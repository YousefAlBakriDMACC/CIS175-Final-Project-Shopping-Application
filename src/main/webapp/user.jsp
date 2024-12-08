<%-- 
    Document   : user
    Created on : Dec 7, 2024, 7:02:38 PM
    Author     : josep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp" %>

<h2>Create Account</h2>
<form action="User" method="post">
    <table style="width: 15%">
        <tr>
            <td>
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required>
            </td>
        </tr>
        <tr>
            <td>
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </td>
        </tr>
        <tr>
            <td>
                <label for="rolename">Role:</label>
                <select id="rolename" name="rolename">
                    <option value="customer_service">Customer Service</option>
                    <option value="programmer">Programmer</option>
                </select>
            </td>
        </tr>
    </table><br>
    <input type="hidden" name="flagRedirect" value="true">
    <input type="submit" value="Create Account" name="action" onclick="validateForm(this)"/>
    <input type="submit" value="Delete Account" name="action" onclick="validateForm(this)"/>
</form>

<%@ include file="includes/footer.jsp" %> 