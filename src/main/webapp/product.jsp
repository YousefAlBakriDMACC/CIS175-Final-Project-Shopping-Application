<%-- 
    Document   : product
    Created on : Oct 9, 2024, 5:07:35 PM
    Author     : josep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="edu.dmacc.cis175.module15.tomcat10.cis175_final_project.music.business.Product"%>
<%@page import="java.io.BufferedWriter"%>
<%@page import="java.io.FileWriter"%>
<%@page import="java.io.IOException"%>
<%@page import="edu.dmacc.cis175.module15.tomcat10.cis175_final_project.music.data.ProductIO"%>

<!DOCTYPE html>
<html>
<head>
    <title>Music Store - Product Details</title>
    <link rel="stylesheet" href="includes/styleMain.css">
</head>
<body>
    <%@ include file="includes/header.jsp" %>

    <h1>Product Details</h1>
        <init:products path="/WEB-INF/data/products.txt"/>
        
        <form action="add.java" method="post">
        <input type="hidden" name="productId" value="${product.productId}" />


        <label for="code">Code:</label>
        <input type="text" id="code" name="code" value="${product.code}" required /><br><br>


        <label for="description">Description:</label>
        <input type="text" id="description" name="description" value="${product.description}" required /><br><br>


        <label for="price">Price:</label>
        <input type="text" id="price" name="price" value="${product.price}" required /><br><br>


        <input type="submit" value="Save Product" />


    </form>
    <form action="products.jsp" method="get">
        <button type="submit">View Products</button>
    </form>

    <%@ include file="includes/footer.jsp" %> 
</body>
</html>
