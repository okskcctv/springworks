<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>logout</title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	<jsp:include page="./menu.jsp" />
	<div id="container">
		<div class="title">
			<h2>로그아웃 되었습니다.</h2>
		</div>
		
		<h2><c:out value="${error}" /> </h2>
		<h2><c:out value="${logout}" /> </h2>
		
		<form action="/customLogout" method="post">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<button type="submit">로그아웃</button>
		</form>
	</div>
</body>
</html>