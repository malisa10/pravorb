<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String host = request.getContextPath(); %>
<jsp:include page="header.jsp" />
Привет! Вы находитесь на ресурсе "ПравоРБ"! <br/>

<h4><a href="<%=host%>/part?action=list">Каталог статей</a></h4>
<jsp:include page="footer.jsp" />
