<%-- 
    Document   : header
    Created on : Oct 27, 2024, 5:48:19 PM
    Author     : josep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="utils" uri="/WEB-INF/tld/utils.tld"%>
<%@page import="edu.dmacc.cis175.module15.tomcat10.cis175_final_project.music.business.Product"%>
<%@page import="edu.dmacc.cis175.module15.tomcat10.cis175_final_project.music.data.ProductIO"%>
<%@page import="edu.dmacc.cis175.module15.tomcat10.cis175_final_project.music.data.ProductDB"%>
<%@page import="edu.dmacc.cis175.module15.tomcat10.cis175_final_project.music.data.InfiniteSequencer"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SoundVault Music</title>
        <link rel="stylesheet" href="includes/styleMain.css">
        <script src="includes/ScriptUtilities.js"></script>
    </head>
<body>
<h1>SoundVault Music Store</h1>
