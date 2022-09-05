<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="message.user.login.title" /></title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	<jsp:include page="./menu.jsp" />
	<div id="container">
		<section id="login">
			<div class="title">
				<h2><spring:message code="message.user.login.title" /></h2>
			</div>
			<p class="lang">
				<a href="customLogin?lang=en">
					<spring:message code="message.user.login.language.en" />
				</a>
				<a href="customLogin?lang=ko">
					<spring:message code="message.user.login.language.ko" />
				</a>
			</p>
			<h3 class="error"><c:out value="${error}" /></h3>
			<form action="/login" method="post">
				<table class="tbl_login">
					<tr>
						<td><spring:message code="message.user.login.id" /></td>
						<td><input type="text" name="username"></td>
					</tr>
					<tr>
						<td><spring:message code="message.user.login.password" /></td>
						<td><input type="password" name="password"></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="<spring:message code="message.user.login.loginBtn" />">
						</td>
					</tr>
				</table>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>
		</section>
	</div>
	<jsp:include page="./footer.jsp" />
</body>
</html>