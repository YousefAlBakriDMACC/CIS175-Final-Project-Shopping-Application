<%-- 
    Document   : login_error
    Created on : Nov 23, 2024, 4:53:17 PM
    Author     : brody
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp" %>

<h2>Login Failed</h2>
<p>Invalid username or password. Please try again.</p>
<form method="post" action="index.jsp">
    <input type="hidden" name="flagRedirect" value="true">
    <input type="submit" value="Back to Login">
</form>

<%@ include file="includes/footer.jsp" %> 
