<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<% String host = request.getContextPath(); %>
<form class="form-user-info" action="" method="post">
    <h3>Пользователь ${user_info.getLogin()}</h3>
    <input required type="text" name="firstname" value="${user_info.getFirstname()}">
    <input required type="text" name="lastname" value="${user_info.getLastname()}">
    <input required type="text" name="email" value="${user_info.getEmail()}">
    <input required type="text" name="address" value="${user_info.getAddress()}">
    <input required type="text" name="zipcode" value="${user_info.getZipcode()}">
    <input required type="text" name="telephone" value="${user_info.getTelephone()}">
    <a href="<%=host%>/user?action=changepassword">Сменить пароль</a>
    <input class="btn btn-large btn-primary"  type="submit" value="Сохранить">
    <span class="error">${error}</span>
</form>
<jsp:include page="footer.jsp" />