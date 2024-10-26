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
        <h1>Products</h1>
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
                        <form method="post" action="Product">
                            <input type="hidden" id="product" name="product" value="${product}"/>
                            <input type="submit" value="Edit"/>
                        </form>
                    </td>
                    <td>
                        <form method="post" action="Delete">
                            <input type="hidden" id="product" name="product" value="${product}"/>
                            <input type="submit" value="Delete"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        
        <form method="post" action="Add">
            <input type="submit" value="Add Product"/>
        </form>
        
    </body>
</html>
