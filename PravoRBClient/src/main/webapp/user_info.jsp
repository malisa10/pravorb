<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<% com.andreenkomv.ws.Users user = ((com.andreenkomv.ws.Users)request.getSession().getAttribute("user")); %>
<% String host = request.getContextPath(); %>
<form class="form-user-info" action="?action=info" method="post">
    <h3>Пользователь <%=user.getLogin()%></h3>
    <input required type="text" name="firstname" value="<%=user.getFirstname()%>">
    <input required type="text" name="lastname" value="<%=user.getLastname()%>">
    <input required type="text" name="email" value="<%=user.getEmail()%>">
    <input required type="text" name="address" value="<%=user.getAddress()%>">
    <input required type="text" name="zipcode" value="<%=user.getZipcode()%>">
    <input required type="text" name="telephone" value="<%=user.getTelephone()%>">
    <a href="<%=host%>/user?action=changepassword">Сменить пароль</a>
    <input class="btn btn-large btn-primary"  type="submit" value="Сохранить">
    <span class="error">${error}</span>
</form>
<jsp:include page="footer.jsp" />