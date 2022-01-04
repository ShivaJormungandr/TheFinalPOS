<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cart</h1>
        <c:if test="${productsInCart == null}">
            <div class="alert alert-warning" role="alert">
                The cart is empty!
            </div>
        </c:if>
        <c:if test="${productsInCart != null}">
            <table>
                <tr>
                    <th></th>
                    <th>Name</th>
                    <th>Price</th>
                </tr>
                <c:set var="i" value="0" scope="page" />
                <form action="/TheFinalPOS/ProcessSale" method="post" >
                    <c:forEach var="product" items="${productsInCart}">
                        <!--<form method="post" action="/TheFinalPOS/ShowCart">-->
                        <tr>
                            <td>${product.imgPath}</td>
                            <td>${product.productName}</td>
                            <td>${product.price}</td>
                            <%--<c:set var="i" value="${i + 1}" scope="page"/>--%>
                        </tr>
                        <!--<input style="visibility: collapse" name="productId" value="${product.id}" />-->

                        <!--</form>-->
                    </c:forEach>

                    <p>Please select your receipt type: </p>
                    <input type="radio" name="receiptType" value="simple">
                    <label for="html">Simple</label><br>
                    <input type="radio" name="receiptType" value="complex">
                    <label for="css">Complex</label><br>

                    <br>

                    <input type="submit" value="Proceed to buy" />
                </form>
            </table>
        </c:if>
    </body>
</html>
