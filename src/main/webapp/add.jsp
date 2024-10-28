<%-- 
    Document   : add
    Created on : Oct 16, 2024, 6:56:13 PM
    Author     : josep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp" %>

<h2>Product Details</h2>

<form action="Add" method="post">
    <input type="hidden" name="productId" value="${product.productID}" />

    <label for="code">Code:</label>
    <input type="text" id="code" name="code" value="${product}" required /><br><br>

    <label for="description">Description:</label>
    <input type="text" id="description" name="description" value="${product.description}" required /><br><br>

    <label for="price">Price:</label>
    <input type="text" id="price" name="price" value="${product.price}" required /><br><br>

    <input type="button" onclick="validateForm(this)" value="Save Product" />
</form>

<button type="button" onclick="window.location.href='products.jsp'">View Products</button>

<%@ include file="includes/footer.jsp" %> 

