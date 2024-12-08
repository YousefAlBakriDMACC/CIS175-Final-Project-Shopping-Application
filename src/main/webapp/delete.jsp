<%-- 
    Document   : delete
    Created on : Oct 9, 2024, 5:08:02 PM
    Author     : josep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp" %>

<table>
    <tr>
        <th>Product Code</th>
        <th>Product Description</th>
        <th>Price</th>
    </tr>
    <tr>
        <td><c:out value='${param.code}'/></td>
        <td><c:out value='${param.description}'/></td>
        <td><c:out value='${param.price}'/></td>
    </tr>
</table><br>

<form action="Delete" method="post">
    <input type="hidden" name="id" value="<c:out value='${param.id}' />"/>
    <input type="hidden" name="code" value="<c:out value='${param.code}'/>"/>
    <input type="hidden" name="description" value="<c:out value='${param.description}'/>"/>
    <input type="hidden" name="price" value="<c:out value='${param.price}'/>"/>
    
    <label>
        <span>Are you sure you want to delete this product?</span>
        <button type="submit" id ="confirm">Yes</button>
        <button type="button" onclick="window.location.href='products.jsp'">No</button> 
    </label>
</form>

<%@ include file="includes/footer.jsp" %> 

