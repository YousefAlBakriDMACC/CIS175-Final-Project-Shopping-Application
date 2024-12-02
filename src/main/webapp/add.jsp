<%-- 
    Document   : add
    Created on : Oct 16, 2024, 6:56:13 PM
    Author     : josep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp" %>

<h2>Product Details</h2>

<form action="Add" method="post">
    <label for="code">Code:</label>
    <input type="text" id="code" name="code" value="<c:out value='${sessionScope.storedProductAdd.code}'/>" />
    <utils:validate value="${sessionScope.storedProductAdd.code}" /><br><br>

    <label for="description">Description:</label>
    <input type="text" id="description" name="description" value="<c:out value='${sessionScope.storedProductAdd.description}'/>" />
    <utils:validate value="${sessionScope.storedProductAdd.description}" /><br><br>

    <label for="price">Price:</label>
    <input type="text" id="price" name="price" value="<c:out value='${sessionScope.storedProductAdd.getPriceCurrencyFormat()}'/>" />
    <utils:validate value="${sessionScope.storedProductAdd.getPriceCurrencyFormat()}" /><br><br>

    <input type="submit" onclick="validateForm(this)" value="Save Product" name="save" />
    <input type="submit" value="View Products" name="save" />
</form>

<%@ include file="includes/footer.jsp" %> 

