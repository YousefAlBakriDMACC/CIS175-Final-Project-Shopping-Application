<%-- 
    Document   : login.jsp
    Created on : Nov 23, 2024, 4:24:41 PM
    Author     : brody
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
         <h2>Login</h2>
        <form action="j_security_check" method="post">
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" id="username" name="j_username" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="j_password" required>
            </div>
            <div class="form-group">
                <button type="submit">Login</button>
            </div>
        </form>
    </body>
</html>
