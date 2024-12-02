<%-- 
    Document   : products
    Created on : Oct 9, 2024, 5:07:26 PM
    Author     : josep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp" %>

<h2>Products</h2>
<table id="products">
    <tr>
        <th>Code</th>
        <th style="border-right: none;">Description</th>
        <th style="border-left: none;">Price</th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach var="product" items="${ProductDB.selectProducts()}">
        <tr>
            <td><c:out value='${product.code}'/></td>
            <td style="border-right: none;"><c:out value='${product.description}'/></td>
            <td style="border-left: none;"><c:out value='${product.getPriceCurrencyFormat()}'/></td>
            <td>
                <form method="post" action="edit.jsp">
                    <input type="hidden" name="code" value="<c:out value='${product.code}'/>"/>
                    <input type="hidden" name="description" value="<c:out value='${product.description}'/>"/>
                    <input type="hidden" name="price" value="<c:out value='${product.price}'/>"/>
                    <input type="submit" value="Edit"/>
                </form>
            </td>
            <td>
                <form method="post" action="Delete">
                    <input type="hidden" id="deleteProduct" name="product" value="<c:out value='${product.toString()}'/>"/>
                    <input type="hidden" id="confirmDelete" name="confirmDelete" value="false"/> 
                    <input type="submit" value="Delete"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table><br/>

<button type="button" onclick="window.location.href='add.jsp'">Add Product</button>

<%@ include file="includes/footer.jsp" %> 
