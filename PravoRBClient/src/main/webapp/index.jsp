<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String host = request.getContextPath(); %>
<jsp:include page="header.jsp" />
<h4><center><a href="<%=host%>/part?action=list">Каталог статей (Количество статей: ${countActs})</a></center></h4>
<jsp:include page="footer.jsp" />
