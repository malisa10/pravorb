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
        <title>Реестр правовых актов РБ | <%=host%></title>               
        <link href="<%=host%>/css/bootstrap.css" rel="stylesheet">
        <link href="<%=host%>/css/bootstrap-responsive.css" rel="stylesheet">
        <link href="<%=host%>/css/jquery-te-1.4.0.css" rel="stylesheet">
        <link href="<%=host%>/css/myStyle.css" rel="stylesheet">
    </head>
    <body>
        <div id="all" class="block-shadow">
            <div id="header">
                <div id="search">
                    <form action="<%=host%>/history?action=search" method="post">
                        <input type="search" name="searchstring" placeholder="Поиск..." />
                    </form>
                </div>
                <center><h3 class="muted"><a href="<%=host%>">Реестр правовых актов РБ</a></h3></center>
                <hr/>
                <div class="userblock">
                    <jsp:include page="headeruserpanel.jsp" />
                </div>
                <hr/>
            </div>
            <div id="content">