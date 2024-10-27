<%-- 
    Document   : add
    Created on : Oct 16, 2024, 6:56:13 PM
    Author     : josep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="edu.dmacc.cis175.module15.tomcat10.cis175_final_project.music.business.Product"%>
<%@page import="java.io.BufferedWriter"%>
<%@page import="java.io.FileWriter"%>
<%@page import="java.io.IOException"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="edu.dmacc.cis175.module15.tomcat10.cis175_final_project.music.data.ProductIO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Music Store - Product Details</title>
        <link rel="stylesheet" href="includes/styleMain.css">
    </head>
    <body>
        <%@ include file="includes/header.jsp" %>
        <h1>Product Details</h1>
        <%-- request. get attribute product --%>
        <init:products path="/WEB-INF/data/products.txt"/>

        <form action="Add" method="post">
            <input type="hidden" name="productId" value="${product.productID}" />


            <label for="code">Code:</label>
            <input type="text" id="code" name="code" value="${product}" required /><br><br>


            <label for="description">Description:</label>
            <input type="text" id="description" name="description" value="${product.description}" required /><br><br>


            <label for="price">Price:</label>
            <input type="text" id="price" name="price" value="${product.price}" required /><br><br>


            <input type="submit" value="Save Product" />


        </form>
        <button type="button" onclick="window.location.href='products.jsp'">View Products</button>


        <%@ include file="includes/footer.jsp" %> 
    </body>
</html>
