<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/mytags.tld" prefix="mytag"%>
<% String host = request.getContextPath(); %>
<jsp:include page="header.jsp" />
<form class="form-act-edit" action="" method="post">
    <h3>Редактирование статьи</h3>
    <input required type="text" name="name" value="${history.getTexts().getName()}">
    <textarea required name="text">${history.getTexts().getText()}</textarea>
    <input class="btn btn-large btn-primary"  type="submit" value="Сохранить">
    <span class="error">${error}</span>
</form>
<jsp:include page="footer.jsp" />
