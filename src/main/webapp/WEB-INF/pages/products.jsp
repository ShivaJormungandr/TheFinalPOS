<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products</title>
    </head>
    <body>
        <c:if test="${products == null}">
            <div class="alert alert-warning" role="alert">
                There are no products in this category!
            </div>
        </c:if>
        <c:if test="${products != null}">
            <table>
                <tr>
                    <th></th>
                    <th>Name</th>
                    <th>Price</th>
                    <th></th>
                    <th>Quantity</th>
                    <th></th>
                    <th>Add to cart</th>
                </tr>
                <c:set var="i" value="0" scope="page" />
                <c:forEach var="product" items="${products}">
                    <form method="post" action="/TheFinalPOS/ShowCart">
                        <tr>
                            <td>${product.imgPath}</td>
                            <td>${product.productName}</td>
                            <td>${product.price}</td>
                            <td><button type="button" id='subtractQty' onclick='subtractQuantity(${i})'> ➖ </button></td>
                            <td><input type='textbox' maxlength='3' name="quantity" value='0' id='tbQuantity${i}'/> </td>
                            <td><button type="button" id='addQty' onclick='increaseQuantity(${i})' > ➕ </button></td>
                            <td><input type="submit" value="🛒" id='addToCart' /></td>
                            <input style="visibility: collapse" name="productId" value="${product.id}" />
                            <c:set var="i" value="${i + 1}" scope="page"/>
                        </tr>
                    </form>
                </c:forEach>
            </table>
        </c:if>
        <script type='text/javascript'>
            function increaseQuantity(id) { 
                let tb = document.getElementById('tbQuantity' + id);
                let qty = parseInt(tb.value);
                qty++;
                tb.value = qty; 
            }

            function subtractQuantity(id) { 
                let tb = document.getElementById('tbQuantity' + id);
                let qty = parseInt(tb.value);
                if (qty > 0) qty--;
                tb.value = qty; 
            }
        </script>
    </body>
</html>
