<%-- 
    Document   : index
    Created on : Oct 9, 2024, 5:04:35 PM
    Author     : josep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="utils" uri="/WEB-INF/tld/utils.tld"%>
<utils:init path="/WEB-INF/data/create_music.sql"/>

<%@ include file="includes/header.jsp" %>

<c:if test="${param.flagRedirect != null}">
    <c:redirect url="products.jsp"/>
</c:if>

<h3>Product Maintenance</h3>
<a href="products.jsp">View Products</a>
<br/>

<%@ include file="includes/footer.jsp" %> 
