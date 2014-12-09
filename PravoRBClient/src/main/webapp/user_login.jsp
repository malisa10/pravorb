<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<% String host = request.getContextPath(); %>
<form class="form-user-login" action="<%=host%>/user" method="post">
    <input required type="text" name="login" placeholder=" Логин">
    <input required type="password" name="password" placeholder=" Пароль">
    <input class="btn btn-large btn-primary"  type="submit" value="Вход">
    <input type="hidden" name="action" value="login">
    <span class="error">${error}</span>
</form>
<jsp:include page="footer.jsp" />
