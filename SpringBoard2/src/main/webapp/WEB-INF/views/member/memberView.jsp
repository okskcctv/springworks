<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	<jsp:include page="../menu.jsp" />
	<div id="container">
		<section id="memberView">
			<div class="title">
				<h2>회원 정보</h2>
			</div>
			<form action="/member/update" method="post" 
				  onsubmit="return checkForm()" name="newWrite">
				<table class="tbl_signup">
					<tr>
						<td>아이디</td>
						<td><input type="text" name="userid" value="${member.userid}"></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="userpw"
						       value="${member.userpw}"></td>
					</tr>
					<tr>
						<td>비밀번호 확인</td>
						<td><input type="password" name="userpw_confirm"
						       value="${member.userpw}"></td>
					</tr>
					<tr>
						<td>이름</td>
						<td><input type="text" name="username" value="${member.username}"></td>
					</tr>
					
					<tr>
						<td colspan="2">
							<input type="submit" value="수정">
							<a href="/member/delete?userid=<c:out value="${member.userid}"/>" 
							   onclick="return confirm('정말로 탈퇴하시겠습니까?')">
								<input type="button" value="탈퇴">
							</a>
							<a href="/member/memberList"><input type="button" value="목록"></a>
						</td>
					</tr>
				</table>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>
		</section>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>