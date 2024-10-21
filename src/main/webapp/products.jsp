<%-- 
    Document   : products
    Created on : Oct 9, 2024, 5:07:26 PM
    Author     : josep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="edu.dmacc.cis175.module15.tomcat10.cis175_final_project.music.business.Product"%>
<%@taglib prefix="init" uri="/WEB-INF/tld/init.tld"%>
<%--TODO: Refactor as tag--%>
<%edu.dmacc.cis175.module15.tomcat10.cis175_final_project.music.data.ProductIO.init(getServletContext().getRealPath("/WEB-INF/data/products.txt"));%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Our Products</title>
    </head>
    <body>
        <h1>Products</h1>
        <table>
            <tr>
                <th>Code</th>
                <th>Description</th>
                <th>Price</th>
                <th></th>
                <th></th>
            </tr>
            <init:products/>
            <c:forEach var="product" items="${edu.dmacc.cis175.module15.tomcat10.cis175_final_project.music.data.ProductIO.selectProducts()}">
                <tr>
                    <td>${product.code}</td>
                    <td>${product.description}</td>
                    <td>${product.price}</td>
                    <td><a href="#">Edit</a></td>
                    <td><a href="#">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
        <form method="post" action="Add">
            <input type="submit" value="Add Product">
        </form>
        
    </body>
</html>
