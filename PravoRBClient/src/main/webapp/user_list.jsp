<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/mytags.tld" prefix="mytag"%>
<% String host = request.getContextPath(); %>
<jsp:include page="header.jsp" />
    <mytag:ListTable headers="${headers}" rows="${rows}"/>
    <a class="btn btn-large btn-inverse" href="<%=host%>/user?action=create">Создать пользователя</a>
<jsp:include page="footer.jsp" />
