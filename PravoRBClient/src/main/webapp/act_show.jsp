<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/mytags.tld" prefix="mytag"%>
<% String host = request.getContextPath(); %>
<jsp:include page="header.jsp" />
<h3 style="display:inline">${history.getTexts().getName()}</h3>&nbsp;&nbsp;[<a href="<%=host%>/history?action=list&act=${history.getActs().getId()}">История изменений</a>]</span><br/>
    <small>Редакция от ${timeedit}, пользователь ${history.getUsers().getLogin()}</small><br/><br/>
    <div class="act-content">
        ${history.getTexts().getText()}
    </div><br/><br/>
        <% if (request.getAttribute("access").toString().equals("true")) {%>
            <a class="btn btn-large btn-inverse" href="<%=host%>/act?action=addedition&act=${history.getActs().getId()}&oldhistory=${history.getId()}">Редактировать</a>
            <a class="btn btn-large btn-inverse" href="<%=host%>/history?action=delete&history=${history.getId()}">Удалить редакцию</a>
        <%}%>
<jsp:include page="footer.jsp" />