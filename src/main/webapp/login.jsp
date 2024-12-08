<%-- 
    Document   : login
    Created on : Nov 24, 2024, 6:08:30 PM
    Author     : brody
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp" %>

<h2>Login</h2>
<form action="j_security_check" method="post">
    <table style="width: 15%">
        <tr>
            <td>
                <label for="username">Username:</label>
                <input type="text" id="username" name="j_username" required>
            </td>
        </tr>
        <tr>
            <td>
                <label for="password">Password:</label>
                <input type="password" id="password" name="j_password" required>
            </td>
        </tr>
    </table><br>
    <button type="submit">Login</button>
    <button type="button" onclick="window.location.href='user.jsp'">Create Account</button>
</form>

<%@ include file="includes/footer.jsp" %> 
