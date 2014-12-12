<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/mytags.tld" prefix="mytag"%>
<%@page import="com.andreenkomv.ws.Users"%>
<% String host = request.getContextPath(); %>
<% boolean editRights = ((request.getSession().getAttribute("user")!=null)&&
        (((Users)request.getSession().getAttribute("user")).getGroups().getId()<3)); %>
<% String part = request.getParameter("part"); %>
<jsp:include page="header.jsp" />
    <mytag:ListTable headers="${headersParts}" rows="${rowsParts}"/>
    <% if (request.getAttribute("rowsActs")!=null) { %>
        <mytag:ListTable rows="${rowsActs}"/>
    <% } %>
    <% if (editRights) {%>
        <% if (request.getAttribute("rowsActs")!=null) {%>
            <a class="btn btn-large btn-inverse" href="<%=host%>/part?action=create&part=<%=part%>">Создать раздел</a>
        <%} else {%> 
            <a class="btn btn-large btn-inverse" href="<%=host%>/part?action=create">Создать раздел</a>
        <%}%> 
    <%}%>   
    <% if (editRights&&(request.getAttribute("rowsActs")!=null)) {%>
    <a class="btn btn-large btn-inverse" href="<%=host%>/act?action=create&part=<%=part%>">Создать акт</a>
    <%}%>  
<jsp:include page="footer.jsp" />
