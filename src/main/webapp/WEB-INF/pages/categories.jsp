<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All categories</title>
    </head>
    <body>

        <h1>Select a category:</h1>
        <br>
        <table class="table table-layout-fixed">
            <thead>
                <tr>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="category" items="${allCategories}">
                    <div>
                        <td><button onclick="location.href = '/TheFinalPOS/ShowProducts?category=${category}'">${category}</button></td>
                    </div>
                </c:forEach>
            </tbody>
        </table>
</body>
</html>
