<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/mytags.tld" prefix="mytag"%>
<%@page import="com.andreenkomv.ws.Users"%>
<% String host = request.getContextPath(); %>
<jsp:include page="header.jsp" />
    <h3>Избранное</h3>
    <mytag:ListTable rows="${rowsActs}"/>
<jsp:include page="footer.jsp" />