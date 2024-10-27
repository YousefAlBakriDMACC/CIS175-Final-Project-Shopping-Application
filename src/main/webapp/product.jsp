<%-- 
    Document   : product
    Created on : Oct 9, 2024, 5:07:35 PM
    Author     : josep
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Music Store - Product Details</title>
    <link rel="stylesheet" href="includes/styleMain.css">
</head>
<body>
request. get attribute product
    <h1>Product Details</h1>

        <form action="Add.java" method="post">
        <input type="hidden" name="productId" value="${product.productId}" />

        
        <label for="code">Code:</label>
        <input type="text" id="code" name="code" value="${product.code}" required /><br><br>

      
        <label for="description">Description:</label>
        <input type="text" id="description" name="description" value="${product.description}" required /><br><br>

     
        <label for="price">Price:</label>
        <input type="text" id="price" name="price" value="${product.price}" required /><br><br>


        <input type="submit" value="Update Product" />
        
        
    </form>
    <form action="products.jsp" method="get">
        <button type="submit">View Products</button>
    </form>


</body>
</html>