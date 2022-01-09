package com.pos.servlet;

import com.pos.bean.ProductBean;
import com.pos.entity.Product;
import com.pos.utility.Cart;
import com.pos.utility.CartType;
import com.pos.utility.CurrentCarts;
import static com.pos.utility.ParseDateTimeValue.computeTotalSumOfCart;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ShowCart", urlPatterns = {"/ShowCart"})
public class ShowCart extends HttpServlet {

    @Inject
    ProductBean productBean;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Product> productsInCart = null;
        int cashierId = Integer.parseInt(request.getParameter("cashierId"));
        Cart currentCart = CurrentCarts.getInstance().getCartByCashierId(cashierId);

        if (currentCart.getCartType() == CartType.Rental && request.getParameter("productId") != null){
            int productId = Integer.parseInt(request.getParameter("productId"));

            Product product = productBean.findById(productId);
            
            if (!product.getIdCategory().getCategory().equals( "Tool")) {
                request.setAttribute("action", currentCart.getCartType().toString());
                request.setAttribute("cashierId", cashierId);
                request.setAttribute("err_product", "The product you scanned is not a valid product to rent!");
                
                String paramsToSend = "action="+ currentCart.getCartType().toString() + "&cashierId=" + cashierId;
                paramsToSend += "&err_product=" + "The product you scanned is not a valid product to rent!";
                
                response.sendRedirect("http://localhost:8080/TheFinalPOS/ShowCategories?" + paramsToSend);
                return;
            }
        }
        
        if (request.getParameter("quantity") != null && request.getParameter("productId") != null) {
             
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            int productId = Integer.parseInt(request.getParameter("productId"));

            Product productToAdd = productBean.findById(productId);
            currentCart.enterItems(productToAdd, quantity);
            
            productsInCart = currentCart.getProductsInCart();
        }
        
        if (currentCart.getProductsInCart() != null){
            productsInCart = currentCart.getProductsInCart();
        }
        
        String todayDateAsString = java.time.LocalDate.now().plusDays(1).toString();
        System.out.println(todayDateAsString);
        
        request.setAttribute("today", todayDateAsString);
        request.setAttribute("cartType", currentCart.getCartType());
        request.setAttribute("productsInCart", productsInCart);
        request.setAttribute("cashierId", cashierId);
        request.setAttribute("moneyTotal", computeTotalSumOfCart(productsInCart));
        
        request.getRequestDispatcher("/WEB-INF/pages/cart.jsp").forward(request, response);
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
