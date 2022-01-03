<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${user.getIdRole() != 'Cashier'}">
            <div class="alert alert-warning" role="alert">
               nu esti cashier
            </div>
        </c:if>
        <c:if test="${user.getIdRole() == 'Cashier'}">
            <button onclick="location.href = '/TheFinalPOS/Logout'">Logout</button>
            <button>Sale</button>
            <button>Return</button>
            <button>Rental</button>
        </c:if>
    </body>
</html>
