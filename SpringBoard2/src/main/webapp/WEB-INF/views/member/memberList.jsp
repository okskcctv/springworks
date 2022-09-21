<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	<jsp:include page="../menu.jsp" />
	<div id="container">
		<section id="list">
			<div class="title">
				<h2>회원 목록</h2>
			</div>
			<table class="tbl_list">
				<thead>
					<tr>
						<th>번호</th>
						<th>아이디</th>
						<!-- <th>비밀번호</th> -->
						<th>이 름</th>
						<th>가입일</th>
						<th>권한</th>
						<!-- <th>권한2</th> -->
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${memberList}" var="member" varStatus="status">
					<tr>
						<td><c:out value="${status.count}" /></td>
						<td><a href="/member/memberView?userid=<c:out value="${member.userid}" />"> <c:out value="${member.userid}" /></a></td>
						<%-- <td><c:out value="${member.userpw}" /></td> --%>
						<td><c:out value="${member.username}" /></td>
						<td><fmt:formatDate value="${member.regDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<%-- <td><c:out value="${member.authList.get(0)}" /></td> --%>
						<td><c:out value="${fn:replace(fn:split(member.authList.get(0), '=')[2], ')', '')}" /></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</section>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>