<%-- 
    Document   : products
    Created on : Oct 9, 2024, 5:07:26 PM
    Author     : josep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="edu.dmacc.cis175.module15.tomcat10.cis175_final_project.music.business.Product"%>
<%@page import="edu.dmacc.cis175.module15.tomcat10.cis175_final_project.music.data.ProductIO"%>
<%@taglib prefix="init" uri="/WEB-INF/tld/init.tld"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Our Products</title>
        <link rel="stylesheet" href="includes/styleMain.css">
    </head>
    <body>
        <init:products path="/WEB-INF/data/products.txt"/>
        <%@ include file="includes/header.html" %>
        <h2>Products</h2>
        <table id="products">
            <tr>
                <th>Code</th>
                <th style="border-right: none;">Description</th>
                <th style="border-left: none;">Price</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="product" items="${ProductIO.selectProducts()}">
                <tr>
                    <td>${product.code}</td>
                    <td style="border-right: none;">${product.description}</td>
                    <td style="border-left: none;">${product.getPriceCurrencyFormat()}</td>
                    <td>
                        <form method="post" action="product.jsp">
                           <input type="hidden" id="editProduct" name="product" value="${product.code}"/>
                            <input type="hidden" name="description" value="${product.description}"/>
                            <input type="hidden" name="price" value="${product.price}"/>
                            <input type="submit" value="Edit"/>
                        </form>
                    </td>
                    <td>
                        <form method="post" action="Delete">
                            <input type="hidden" id="deleteProduct" name="product" value="${product.toString()}"/>
                            <input type="hidden" id="confirmDelete" name="confirmDelete" value="false"/> 
                           <input type="submit" value="Delete"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        
        <button type="button" onclick="window.location.href='add.jsp'">Add Product</button>
        
        <%@ include file="includes/footer.html" %> 
    </body>
</html>
