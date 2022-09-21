<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL - functions 태그 실습</title>
</head>
<body>
	<h2>JSTL - functions 태그 실습</h2>
	<c:set var="test" value="${fn:split('Hello, Java Spring Framework', ' ')}" />
	<c:out value="${test[2]}" />
</body>
</html>