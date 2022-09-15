<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록 보기</title>
<link rel="stylesheet" href="/resources/css/style.css">
<script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
<script type="text/javascript">
	// 페이징 처리 - 목록 페이지
	// jQuery 라이브러리 임포트함
	$(document).ready(function(){
		
		let actionForm = $("#actionForm");	// 폼 선택
		
		$(".page-link a").on('click', function(e){
			
			e.preventDefault();	// 기본 동작 제한(링크 안되게 함)
			let targetPage = $(this).attr("href");
			console.log(targetPage);
			
			actionForm.find("input[name='pageNum']").val(targetPage);
			actionForm.submit();	// 페이지 처리 완료(submit 전에 콘솔에서 테스트 하기)
		});
		
		// 상세 페이지
		$(".move").on("click", function(e){
			e.preventDefault();	// 기본 동작 제한
			let targetBno = $(this).attr("href");
			console.log(targetBno);
			
			actionForm.append("<input type='hidden' name='bno' value='" + targetBno + "'>");
			actionForm.attr("action", "/board/boardView");
			actionForm.submit();
		});
		
		// 검색 폼 처리
		let searchForm = $("#searchForm");
		$("#searchForm button").on("click", function(e){
			e.preventDefault();
			console.log("click");
			
			searchForm.find("input[name='pageNum']").val(1);	// 1페이지부터 검색
			searchForm.submit();
		});
	});
</script>
</head>
<body>
	<jsp:include page="../menu.jsp" />
	<div id="container">
		<section id="list">
			<div class="title">
				<h2>게시글 목록</h2>
			</div>
			<!-- 검색 폼 -->
			<form action="/board/boardList" method="get" id="searchForm">
				<select name="type">
					<option value="T">제목</option>
					<option value="C">내용</option>
					<option value="W">작성자</option>
					<option value="TC">제목 or 내용</option>
					<option value="TW">제목 or 작성자</option>
					<option value="TWC">제목 or 내용 or 작성자</option>
				</select>
				<input type="text" name="keyword" value="${pageMaker.cri.keyword}" class="keyword">
				<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
				<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
				<button>Search</button>
			</form>
			<table class="tbl_list">
				<tr>
					<th>번호</th><th>제목</th><th>작성자</th><th>등록일</th><th>조회수</th>
				</tr>
				<c:forEach items="${boardList}" var="board">
				<tr>
					<td><c:out value="${board.bno}" /></td>
					<td>
						<a class="move" href='<c:out value="${board.bno}" />'>
							<c:out value="${board.title}" /></a>
					</td>
					<td><c:out value="${board.writer}" /></td>
					<td><fmt:formatDate value="${board.regDate}" 
					        pattern="yyyy-MM-dd hh:mm:ss" /></td>
					<td><c:out value="${board.cnt}" /></td>
				</tr>
				</c:forEach>
			</table>
			<!-- 페이지 번호 -->
			<div>
				<ul>
					<c:if test="${pageMaker.prev}">
					<li class="page-link"><a href="${pageMaker.startPage - 1}">이전</a></li>
					</c:if>
					<c:forEach begin="${pageMaker.startPage}"
								end="${pageMaker.endPage}" var="num">
						<!-- 현재 페이지 활성화 -->
						<c:if test="${pageMaker.cri.pageNum eq num}">
							<li class="page-link"><a href="${num}">
								<b><c:out value="${num}" /></b></a>
							</li>
						</c:if>
						<c:if test="${pageMaker.cri.pageNum ne num}">
							<li class="page-link">
								<a href="${num}"><c:out value="${num}" /></a>
							</li>
						</c:if>
					</c:forEach>
					<c:if test="${pageMaker.next}">
					<li class="page-link"><a href="${pageMaker.endPage + 1}">다음</a></li>
					</c:if>
				</ul>
			</div>
			<!-- 페이지 처리 전송 폼(get 방식) -->
			<form action="/board/boardList" method="get" id="actionForm">
				<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
				<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
				<input type="hidden" name="type" value="${pageMaker.cri.type}">
				<input type="hidden" name="keyword" value="${pageMaker.cri.keyword}">
			</form>
			
			<!-- 글쓰기 버튼 -->
			<div class="btn_box">
				<a href="/board/insertBoard"><button type="button">글쓰기</button></a>
			</div>
		</section>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>