<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${not empty sessionScope.message }">
	<script>
		alert("${message}");
	</script>
	<c:remove var="message" scope="session" />
</c:if>
<form action="${pageContext.request.contextPath }/login" method="post">
	학번입력<input type="text" name="id"/>
	<input type="submit" value="로그인" class="btn btn-primary" required/><br/>
	<span>${sessionScope.errors.stdNo }${sessionScope.errors.proCd }</span>
	<c:remove var="errors" scope="session" />
</form>