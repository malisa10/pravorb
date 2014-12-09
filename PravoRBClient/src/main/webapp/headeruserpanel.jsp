<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="userpanel">
    <% com.andreenkomv.ws.Users user = ((com.andreenkomv.ws.Users)request.getSession().getAttribute("user")); %>
    <% String host = request.getContextPath(); %>
    <% if(user!=null) { %>
		<div class="logout">
			<a href="<%=host%>/user?action=info"><%=user.getLogin()%></a> (<%=user.getGroups().getName()%>)
			/	
                        <a href="<%=host%>/favorites?action=list&user=<%=user.getId()%>">Избранное</a>
                        /	
                        <a href="<%=host%>/user?action=logout">Выход</a>
		</div>
            <% if(user.getGroups().getId()<2) { %>
				<a href="<%=host%>/user?action=list">Список пользователей</a>
            <% } %>
	<% } else { %>
		<a href="<%=host%>/user?action=login">Вход</a> /
		<a href="${pageContext.request.contextPath}/user?action=register">Регистрация</a>	
		<div class="logout">
			Привет, гость!
		</div>
	<% } %>
</div>
