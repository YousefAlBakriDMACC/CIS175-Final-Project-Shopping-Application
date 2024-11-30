<%-- 
    Document   : login
    Created on : Nov 24, 2024, 6:08:30 PM
    Author     : brody
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp" %>

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

<%@ include file="includes/footer.jsp" %> 
