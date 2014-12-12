<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/mytags.tld" prefix="mytag"%>
<%@page import="com.andreenkomv.ws.Users"%>
<% String host = request.getContextPath(); %>
<jsp:include page="header.jsp" />
    <mytag:ListTable rows="${histories}"/>
<jsp:include page="footer.jsp" />
