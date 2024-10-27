<%-- 
    Document   : delete
    Created on : Oct 9, 2024, 5:08:02 PM
    Author     : josep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="includes/styleMain.css">
    </head>
    <body>
        <%@ include file="includes/header.html" %>
        <table>
            <tr>
                <th>Product Code</th>
                <th>Product Description</th>
                <th>Price</th>
            </tr>
            <tr>
                <td>${product.code}</td>
                <td>${product.description}</td>
                <td>${product.price}</td>
            </tr>
        </table>

        <form action="Delete" method="post">
            <input type="hidden" name="confirmDelete" value="true">
            <label for ="confirm">Are you sure you want to delete this product?</label>
                <button type="submit" id ="confirm">yes</button>
            <button type="button" onclick="window.location.href='products.jsp'">No</button> 
        </form>
            
        <%@ include file="includes/footer.html" %> 
    </body>
</html>
