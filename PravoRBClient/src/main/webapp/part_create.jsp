<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/mytags.tld" prefix="mytag"%>
<% String host = request.getContextPath(); %>
<jsp:include page="header.jsp" />
<form class="form-part-create" action="" method="post">
    <h3>Создание раздела</h3>
    <input required type="text" name="name" placeholder=" Название раздела">
    ${parentPartSelect}
    <input class="btn btn-large btn-primary"  type="submit" value="Сохранить">
    <span class="error">${error}</span>
</form>
<jsp:include page="footer.jsp" />
