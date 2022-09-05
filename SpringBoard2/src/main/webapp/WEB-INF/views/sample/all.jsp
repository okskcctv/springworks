<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인증</title>
</head>
<body>
	<h1>/sample/all page</h1>
	
	<!-- 로그인하지 않은 사용자 -->
	<security:authorize access="isAnonymous()">
		<a href="/customLogin">로그인</a>
	</security:authorize>
	
	<!-- 로그인한 사용자 -->
	<security:authorize access="isAuthenticated()">
		<a href="/customLogout">로그아웃</a>
	</security:authorize>
	
</body>
</html>