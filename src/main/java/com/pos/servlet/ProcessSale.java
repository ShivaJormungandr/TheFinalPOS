package com.pos.servlet;

import com.pos.bean.TransactionBean;
import com.pos.bean.TransactionTypeBean;
import com.pos.bean.UserBean;
import com.pos.builder.Receipt;
import com.pos.builder.ReceiptBuilder;
import com.pos.builder.ReceiptType;
import com.pos.entity.Product;
import com.pos.entity.TransactionTable;
import com.pos.utility.Cart;
import com.pos.utility.CurrentCarts;
import com.pos.utility.LoggedUsers;
import java.io.IOException;
import java.io.PrintWriter;
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
        
        //TODO: Fix process sale, this is for example purposes only
        
        int cashierId = Integer.parseInt(request.getParameter("cashierId"));
        
        List<Product> productsInCart = CurrentCarts.getInstance().getCartByCashierId(cashierId).getProductsInCart();
        System.out.println(productsInCart);
        double sum = productsInCart.stream().mapToDouble(p -> p.getPrice()).sum();
        System.out.println(sum);
        
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
        TransactionTable currentTransaction = transactionBean.createTransaction(date, transactionTypeBean.findByName("Sale"),LoggedUsers.getInstance().getLoggedUserById(cashierId), null);
        
        transactionBean.addProductsToTransaction(currentTransaction, productsInCart);
        
        ReceiptBuilder builder = new ReceiptBuilder();
        
        if(request.getParameter("receiptType").equals("simple")){
            builder.setReceiptType(ReceiptType.SIMPLE);
            builder.setId(currentTransaction.getId());
            builder.setTitle("SIMPLE: Multumim ca ati ales saptamana comunista Lidl!");
            builder.setProducts(productsInCart);
            builder.setTotalAmount(sum);
        }
        else{
            builder.setReceiptType(ReceiptType.COMPLEX);
            builder.setId(currentTransaction.getId());
            builder.setTitle("COMPLEX: Multumim ca ati ales saptamana comunista Lidl!");
            builder.setProducts(productsInCart);
            builder.setTotalAmount(sum);
            builder.setTaxesAmount(sum * 0.19);
            builder.setDate(date);
            builder.setCashier(transactionBean.findById(currentTransaction.getId()).getIdCashier());
        }
        
        Receipt receipt = builder.getResult();
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddUser</title>");
            out.println("</head>");
            out.println("<body>");           
            
            out.println("<table>");
            if (receipt == null) {
                out.println("<h1> No receipt generated! </h1>");
            } else {
                out.println("<tr>Receipt Type: " + receipt.getReceiptType() + "<br></tr>");
                out.println("<tr>ID: " + receipt.getId() + "<br></tr>");
                out.println("<tr>Title: " + receipt.getTitle() + "<br></tr>");
                
                out.println("<tr><br>");
                
                out.println("<table>");
                out.println("<tr> <th>NAME</th> <th>PRICE</th> </tr>");
                if (productsInCart.isEmpty()) {
                    out.println("<h1> No products found!</h1>");
                } else {
                    for (Product p : productsInCart) {
                        out.println("<tr>" + "<td>" + p.getProductName() + "</td>" + "<td>" + p.getPrice() + "</td>" + "</tr>");
                    }
                }
                out.println("</table>");
                
                out.println("</tr>");
                out.println("<br><tr>TOTAL: " + receipt.getTotalAmount() + " RON</tr>");
                out.println("<br><tr>Taxes: " + receipt.getTaxesAmount() + " RON</tr>");
                out.println("<br><tr>Date: " + receipt.getDate() + "</tr>");
                out.println("<br><tr>Cashier username: " + receipt.getCashier().getUsername() + "</tr>");
            }
            out.println("</table>");
           
            out.println("</body>");
            out.println("</html>");
        }
        
        CurrentCarts.getInstance().getCartByCashierId(cashierId).clearCart();
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
