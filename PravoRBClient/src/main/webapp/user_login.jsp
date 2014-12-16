<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<div class="block-shadow form-middle">
<h2 style="text-align:center;">Вход</h2><br/>
<form class="form-user-login" action="" method="post">
    <h6 style="text-align:center;">Логин</h6>
    <input required type="text" name="login" placeholder=" Логин">
    <h6 style="text-align:center;">Пароль</h6>
    <input required type="password" name="password" placeholder=" Пароль"><br/><br/><br/>
    <input class="btn btn-large btn-primary"  type="submit" value="Вход">
    <span class="error">${error}</span>
</form>
</div>
<jsp:include page="footer.jsp" />
