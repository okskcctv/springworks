<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<body>
	<nav>
	<security:authorize access="isAnonymous()">
		<ul>
			<li><a href="/">Home</a></li>
			<li><a href="/member/signup">회원가입</a></li>
			<li><a href="/customLogin">로그인</a></li>
			<li><a href="/member/memberList">회원목록</a></li>
			<li><a href="/board/boardList">게시판</a></li>
		</ul>
	</security:authorize>
	
	<security:authentication property="principal" var="pinfo"/>
	<security:authorize access="isAuthenticated()">
		<ul>
			<li><a href="/">Home</a></li>
			<li><a href='/member/memberView?userid=<c:out value="${pinfo.username}" />'>나의 정보</a></li>
			
			<li><a href="/customLogout">(<c:out value="${pinfo.username}" />님)로그아웃</a></li>
			<li><a href="/member/memberList">회원목록</a></li>
			<li><a href="/board/boardList">게시판</a></li>
		</ul>
	</security:authorize>
	</nav>
</body>
</html>