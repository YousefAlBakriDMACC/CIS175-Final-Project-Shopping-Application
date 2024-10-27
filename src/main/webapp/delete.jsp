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
    </head>
    <body>
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
            
        <form action="deleteProduct" method="post">
            <input type="hidden" name="productCode" value="${product.code}">
            <button type="submit" class="Delete">Confirm Delete</button>
        </form>
    </body>
</html>
