<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/mytags.tld" prefix="mytag"%>
<% String host = request.getContextPath(); %>
<jsp:include page="header.jsp" />
<div class="block-shadow form-middle">
    <form class="form-act-create" action="" method="post">
        <h3>Создание статьи</h3>
        <input required type="text" name="name" placeholder=" Название статьи">
        <textarea required name="text" placeholder=" Текст статьи">Текст статьи</textarea>
        <input class="btn btn-large btn-primary"  type="submit" value="Сохранить">
        <span class="error">${error}</span>
    </form>
</div>
<jsp:include page="footer.jsp" />
