<%-- 
    Document   : index
    Created on : Dec 28, 2021, 4:55:05 PM
    Author     : Tavi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!?</h1>
        <form method="post" action="AddUser">
            <div>
                <input type="text" name="username" />
            </div>
            <div>
                <input type="password" name="password" />
            </div>
            <div>
                <select name="role">
                    <option value="Cashier">Cashier</option>
                    <option value="Director">Director</option>
                    <option value="Admin">Admin</option>
                </select>
            </div>
            <div>
                <input type="email" name="email" />
            </div>
            <div>
                <input type="submit" value="Add" />
            </div>
        </form>
        <form method="post" action="ShowProducts">
            <div>
                <input type="text" name="test" />
            </div>
            <div>
                <input type="submit" value="Test" />
            </div>
        </form>
    </body>
</html>
