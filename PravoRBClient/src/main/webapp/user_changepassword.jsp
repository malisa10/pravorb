<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<form class="form-user-changepasswordsecure" action="" method="post">
    <input required type="text" name="newpassword" placeholder=" Новый пароль">
    <input class="btn btn-large btn-primary"  type="submit" value="Сохранить">
    <span class="error">${error}</span>
</form>
<jsp:include page="footer.jsp" />