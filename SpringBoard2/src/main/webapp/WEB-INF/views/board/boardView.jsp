<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome~</title>
<link rel="stylesheet" href="/resources/css/style.css">
<script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
<script type="text/javascript">
	
	$(document).ready(function(){
		
		let actionForm = $("#actionForm");
		// 목록 버튼 클릭
		$(".listBtn").click(function(e){
			
			e.preventDefault();
			actionForm.submit();
		});
		
		// 댓글 등록
		let replyForm = $("#replyForm");
		$(".replyBtn").click(function(e){
			e.preventDefault();
			
			replyForm.attr("action", "/board/reply");
			replyForm.submit();
		});
		
		// 댓글 삭제 페이지 요청
		$(".replyDeleteBtn").click(function(e){
			e.preventDefault();
			console.log("click...");
			let rno = $(this).attr("data-rno");
			
			location.href = "/board/replyDelete?bno=${board.bno}"
					+ "&rno=" + rno;
		});
		
		// 댓글 수정 페이지 요청
		$(".replyUpdateBtn").click(function(e){
			e.preventDefault();
			console.log("click...");
			let rno = $(this).attr("data-rno");
			
			location.href = "/board/replyUpdate?bno=${board.bno}"
					+ "&rno=" + rno;
		});
	});
</script>
</head>
<body>
	<div id="container">
		<section id="list">
			<div class="title">
				<h2>글 상세 보기</h2>
			</div>
			<form action="/board/updateBoard" method="post">
				<!-- 수정 시에 기본키 속성이 반드시 필요함  --> 
				<input type="hidden" name="bno" value="${board.bno}">
				<!-- 수정, 삭제시 페이지 번호 유지(없으면 1페이지 이동) -->
				<input type="hidden" name="pageNum" value="${cri.pageNum}">
				<input type="hidden" name="amount" value="${cri.amount}">
				<input type="hidden" name="type" value="${cri.type}">
				<input type="hidden" name="keyword" value="${cri.keyword}">
				<table class="tbl_view">
					<tr>
						<td>제목</td>
						<td><input type="text" name="title" value="${board.title}"></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td><input type="text" name="writer" value="${board.writer}"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td>
							<textarea name="content" 
							  cols="50" rows="10"><c:out value="${board.content}" /></textarea>
						</td>
					</tr>
					<tr>
						<td>등록일</td>
						<td class="time"><fmt:formatDate value="${board.regDate}" 
					              pattern="yyyy-MM-dd hh:mm:ss" /></td>
					</tr>
					<tr>
						<td>조회수</td>
						<td><input type="text" name="cnt" value="${board.cnt}"></td>
					</tr>
					<tr>
						<td colspan="2">
						<security:authentication property="principal" var="pinfo" />
						<security:authorize access="isAuthenticated()">
						<c:if test="${pinfo.username eq board.writer}">
							<input type="submit" value="수정">
							<a href="/board/deleteBoard?bno=<c:out value="${board.bno}" />"
							   onclick="return confirm('해당 게시글을 삭제하시겠습니까?')">
								 <input type="button" value="삭제">
							</a>
						</c:if>
						</security:authorize>
							<a href="/board/boardList"><input type="button" value="목록" class="listBtn"></a>
						</td>
					</tr>
				</table>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>
			<!-- 댓글 영역 -->
			<div class="comment">
				<h4>댓글</h4>
				<ol class="replyList">
					<c:forEach items="${replyList}" var="list">
						<li>
							<p>작성자: <c:out value="${list.replyer}" />&nbsp;&nbsp;
							   (작성일: <fmt:formatDate value="${list.replyDate}"
							   					pattern="yyyy-MM-dd hh:mm:ss"/>)
							</p>
							<p><c:out value="${list.reply}" /></p>
							<c:if test="${pinfo.username eq list.replyer}">
							<p>
								<button type="button" class="replyUpdateBtn" data-rno="${list.rno}">수정</button>
								<button type="button" class="replyDeleteBtn" data-rno="${list.rno}">삭제</button>
							</p>
							</c:if>
						</li>
					</c:forEach>
				</ol>
				<!-- 댓글 등록 폼 -->
				<form method="post" id="replyForm" class="replyForm">
					<input type="hidden" name="bno" value="${board.bno}">
					<ul>
						<li>
							<label>작성자</label>
							<input type="text" name="replyer" id="replyer"
								value='<security:authentication property="principal.username"/>'>
						</li>
						<li>
							<textarea rows="4" cols="60" name="reply" id="reply"></textarea>
							<button type="button" class="replyBtn">댓글 등록</button>
						</li>
					</ul>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
			</div>
		</section>
		<!-- 페이지 및 검색 전송 폼 -->
		<form action="/board/boardList" method="get" id="actionForm">
			<input type="hidden" name="bno" value="${board.bno}">
			<!-- 목록 페이지로 이동시 페이지 번호 유지(없으면 1페이지로 감) -->
			<input type="hidden" name="pageNum" value="${cri.pageNum}">
			<input type="hidden" name="amount" value="${cri.amount}">
		</form>
	</div>
</body>
</html>