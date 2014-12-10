<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<form class="form-user-login" action="" method="post">
    <input required type="text" name="login" placeholder=" Логин">
    <input required type="password" name="password" placeholder=" Пароль">
    <input class="btn btn-large btn-primary"  type="submit" value="Вход">
    <span class="error">${error}</span>
</form>
<jsp:include page="footer.jsp" />
