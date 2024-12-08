<%-- 
    Document   : product
    Created on : Oct 9, 2024, 5:07:35 PM
    Author     : josep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp" %>

<h2>Product Details</h2>
<form action="Product" method="post">
    <input type="hidden" name="id" value="<c:out value='${param.id}'/>" />

    <table>
        <tr>
            <th>Product Code</th>
            <th>Product Description</th>
            <th>Price</th>
        </tr>
        <tr>
            <td>
                <label for="code">Code:</label>
                <input type="text" id="code" name="code" value="<c:out value='${param.code}'/>" required />
                <utils:validate value="${param.code}" />
            </td>
            <td>
                <label for="description">Description:</label>
                <input type="text" id="description" name="description" value="<c:out value='${param.description}'/>" required />
                <utils:validate value="${param.description}" />
            </td>
            <td>
                <label for="price">Price:</label>
                <input type="text" id="price" name="price" value="<c:out value='${param.price}'/>" required />
                <utils:validate value="${param.price}" />
            </td>
        </tr>
    </table><br>
    
    <input type="button" onclick="validateForm(this)" value="Update Product" />
    <button type="button" onclick="window.location.href='products.jsp'">View Products</button>
</form>

<%@ include file="includes/footer.jsp" %> 

