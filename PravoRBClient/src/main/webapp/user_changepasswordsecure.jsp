<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<div class="block-shadow form-middle">
<form class="form-user-changepasswordsecure" action="" method="post">
    <input required type="text" name="oldpassword" placeholder=" Старый пароль">
    <input required type="text" name="newpassword" placeholder=" Новый пароль">
    <input required type="text" name="newpassword" placeholder=" Новый пароль ещё раз">
    <input class="btn btn-large btn-primary"  type="submit" value="Сохранить">
    <span class="error">${error}</span>
</form>
</div>
<jsp:include page="footer.jsp" />