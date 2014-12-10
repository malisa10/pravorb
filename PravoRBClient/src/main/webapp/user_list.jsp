<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/mytags.tld" prefix="mytag"%>

<jsp:include page="header.jsp" />
    <mytag:UsersList users="${users}"/>
<jsp:include page="footer.jsp" />
