<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<% String host = request.getContextPath(); %>
<div class="block-shadow form-middle">
    <form class="form-user-info" action="" method="post">
        <h3>Пользователь ${user_info.getLogin()}</h3>
        <label for="firstname">Имя</label>
        <input id="firstname" required type="text" name="firstname" value="${user_info.getFirstname()}">
        <label for="lastname">Фамилия</label>
        <input id="lastname" required type="text" name="lastname" value="${user_info.getLastname()}">
        <label for="email">E-mail</label>
        <input id="email" required type="text" name="email" value="${user_info.getEmail()}">
        <label for="address">Адрес</label>
        <input id="address" required type="text" name="address" value="${user_info.getAddress()}">
        <label for="zipcode">Почтовый код</label>
        <input id="zipcode" required type="text" name="zipcode" value="${user_info.getZipcode()}">
        <label for="telephone">Телефон</label>
        <input id="telephone" required type="text" name="telephone" value="${user_info.getTelephone()}">
        <a class="btn btn-large btn-inverse" href="<%=host%>/user?action=changepassword${link_changepassword}">Сменить пароль</a>
        <input style="float:right;" class="btn btn-large btn-primary"  type="submit" value="Сохранить">
        <span class="error">${error}</span>
    </form>
</div>
<jsp:include page="footer.jsp" />