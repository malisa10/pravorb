<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String host = request.getContextPath(); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta name="description" content=""/>
        <meta name="author" content=""/>
        <title><%=host%></title>               
        <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/bootstrap-responsive.css" rel="stylesheet">
    </head>
    <body>
        <div id="all">
            <div id="header">
                <center><h3 class="muted"><a href="<%=host%>">Реестр правовых актов РБ</a></h3></center>
                <hr/>
                <div class="userblock">
                    <jsp:include page="headeruserpanel.jsp" />
                </div>
            </div>
            <hr/>
            <div id="content">