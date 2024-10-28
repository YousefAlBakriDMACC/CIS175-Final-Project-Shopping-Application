<%-- 
    Document   : index
    Created on : Oct 9, 2024, 5:04:35 PM
    Author     : josep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="init" uri="/WEB-INF/tld/init.tld"%>
<init:products path="/WEB-INF/data/products.txt"/>

<%@ include file="includes/header.jsp" %>

<h3>Product Maintenance</h3>
<a href="products.jsp">View Products</a>
<br/>

<%@ include file="includes/footer.jsp" %> 


