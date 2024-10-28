<%-- 
    Document   : product
    Created on : Oct 9, 2024, 5:07:35 PM
    Author     : josep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp" %>

<h2>Product Details</h2>
<form action = "Product" method = "post">
    <input type="hidden" name="productId" value="${param.productId}" />

    <label for="code">Code:</label>
    <input type="text" id="code" name="code" value="${param.product}" required /><br><br>

    <label for="description">Description:</label>
    <input type="text" id="description" name="description" value="${param.description}" required /><br><br>

    <label for="price">Price:</label>
    <input type="text" id="price" name="price" value="${param.price}" required /><br><br>

    <input type="button" onclick="validateForm(this)" value="Update Product" />
</form>

<button type="button" onclick="window.location.href='products.jsp'">View Product</button>

<%@ include file="includes/footer.jsp" %> 

