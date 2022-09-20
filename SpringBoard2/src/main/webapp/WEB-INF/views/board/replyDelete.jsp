<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제 페이지</title>
<link rel="stylesheet" href="/resources/css/style.css">
<script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
<script type="text/javascript">
	$(document).ready(function(){
		let deleteForm = $("#deleteForm");
		
		$(".cancelBtn").click(function(e){
			e.preventDefault();
			console.log("click...");
			
			deleteForm.attr("action", "/board/boardView?bno=${selectReply.bno}");
			deleteForm.submit();
		});
	});
</script>
</head>
<body>
	<div id="container">
		<section id="reply_del">
			<div class="title">
				<h2>댓글 삭제</h2>
			</div>
			<form action="/board/replyDelete" method="post" id="deleteForm">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<input type="hidden" name="bno" value="${selectReply.bno}">
				<input type="hidden" name="rno" value="${selectReply.rno}">
				
				<div>
					<h3>해당 댓글을 삭제하시겠습니까?</h3>
					<button type="submit" class="deleteBtn">예</button>
					<button type="button" class="cancelBtn">아니오</button>
				</div>
			</form>
		</section>
	</div>
</body>
</html>