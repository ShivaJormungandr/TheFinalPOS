package com.pos.servlet;

import com.pos.bean.TransactionBean;
import com.pos.bean.TransactionTypeBean;
import com.pos.bean.UserBean;
import com.pos.builder.Receipt;
import com.pos.builder.ReceiptBuilder;
import com.pos.builder.ReceiptType;
import com.pos.entity.Product;
import com.pos.entity.TransactionTable;
import com.pos.payment.ProcessCardPayment;
import com.pos.payment.ProcessCashPayment;
import com.pos.payment.ProcessPayment;
import com.pos.utility.Cart;
import com.pos.utility.CurrentCarts;
import com.pos.utility.LoggedUsers;
import static com.pos.utility.ParseDateTimeValue.computeTaxes;
import static com.pos.utility.ParseDateTimeValue.computeTotalSumOfCart;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProcessSale", urlPatterns = {"/ProcessSale"})
public class ProcessSale extends HttpServlet {

    @Inject
    UserBean userBean;

    @Inject
    TransactionBean transactionBean;

    @Inject
    TransactionTypeBean transactionTypeBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int cashierId = Integer.parseInt(request.getParameter("cashierId"));
        String paymentType = request.getParameter("paymentType");
        
        java.sql.Date rentalReturnDate = null;
        if (request.getParameter("rentalReturnDate") != null ){
            rentalReturnDate = java.sql.Date.valueOf(request.getParameter("rentalReturnDate"));
            System.out.println(rentalReturnDate);
        }
        
        String cartType = request.getParameter("cartType");
        
        Cart currentCart = CurrentCarts.getInstance().getCartByCashierId(cashierId);
        List<Product> productsInCart = currentCart.getProductsInCart();
        double sum = computeTotalSumOfCart(productsInCart);
        double TVA = 0.19;

        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
        TransactionTable currentTransaction = transactionBean.createTransaction(date, transactionTypeBean.findByName(cartType), LoggedUsers.getInstance().getLoggedUserById(cashierId), rentalReturnDate);

        transactionBean.addProductsToTransaction(currentTransaction, productsInCart);

        ProcessPayment payment = null;

        if (paymentType.equals("cash")) {
            payment = new ProcessCashPayment();
        } else if (paymentType.equals("card")) {
            payment = new ProcessCardPayment();
        }

        if (payment != null) {
            payment.pay();
        }

        ReceiptBuilder builder = new ReceiptBuilder();

        if (request.getParameter("receiptType").equals("simple")) {
            builder.setReceiptType(ReceiptType.SIMPLE);
            builder.setId(currentTransaction.getId());
            builder.setTitle("SIMPLE: Multumim ca ati ales saptamana comunista Lidl!");
            builder.setProducts(productsInCart);
            builder.setTotalAmount(sum);
            builder.setCashier(transactionBean.findById(currentTransaction.getId()).getIdCashier());
        } else {
            builder.setReceiptType(ReceiptType.COMPLEX);
            builder.setId(currentTransaction.getId());
            builder.setTitle("COMPLEX: Multumim ca ati ales saptamana comunista Lidl!");
            builder.setProducts(productsInCart);
            builder.setTotalAmount(sum);
            builder.setTaxesAmount(computeTaxes(sum, TVA));
            builder.setDate(date);
            builder.setCashier(transactionBean.findById(currentTransaction.getId()).getIdCashier());
        }

        Receipt receipt = builder.getResult();
        
        currentCart.proceedPayment();

        request.setAttribute("receipt", receipt);
        request.setAttribute("paymentType", paymentType);
        request.setAttribute("simple", ReceiptType.SIMPLE);
        request.setAttribute("complex", ReceiptType.COMPLEX);
        
        request.getRequestDispatcher("/WEB-INF/pages/receipt.jsp").forward(request, response);        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
