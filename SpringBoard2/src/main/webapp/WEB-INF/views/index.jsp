<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome~</title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	<jsp:include page="./menu.jsp" />
	<div id="container">
		<section id="main">
			<div class="title">
				<h2>메인 페이지입니다.</h2>
			</div>
			
			<div>
				<img src="/resources/images/activity.jpg" alt="행글라이더">
			</div>
		</section>
	</div>
	<jsp:include page="./footer.jsp" />
</body>
</html>