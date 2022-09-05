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
	<h1>/sample/admin page</h1>
	
	<p>principal: <security:authentication property="principal"/></p>
	<p>MemberVO: <security:authentication property="principal.member"/>
	<p>사용자 이름: <security:authentication property="principal.member.userName"/>
	<p>사용자 아이디: <security:authentication property="principal.username"/>
	<p>사용자 비밀번호: <security:authentication property="principal.password"/>
	<p>사용자 권한 리스트: <security:authentication property="principal.member.authList"/>
	
	<a href="/customLogout">
		<button type="button">로그아웃</button>
	</a>
</body>
</html>