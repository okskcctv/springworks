<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�� ���</title>
<link rel="stylesheet" href="/resources/css/style.css">
<script>
	function submitCheck(){
		let form = document.board;
		let title = form.title.value;
		let writer = form.writer.value;
		let content = form.content.value;
		
		if(title == ""){
			alert("������ �Է����ּ���");
			form.title.focus();
			return false;
		}
		if(writer == ""){
			alert("�ۼ��ڸ� �Է����ּ���");
			form.writer.focus();
			return false;
		}
		if(content == ""){
			alert("������ �Է����ּ���");
			form.content.focus();
			return false;
		}
		
		form.submit();
	}
</script>
</head>
<body>
	<section id="register">
		<h2>�� ���</h2>
		<hr>
		<form action="/insertBoard" method="post" name="board">
			<table class="tbl_reg">
				<tr>
					<td width="100">����</td>
					<td align="left"><input type="text" name="title" size="50"></td>
				</tr>
				<tr>
					<td>�ۼ���</td>
					<td><input type="text" name="writer"></td>
				</tr>
				<tr>
					<td>����</td>
					<td><textarea name="content" cols="50" rows="10"></textarea></td>
				</tr>
				<tr>
					<td colspan="2" align="center">						
						<input type="button" value="���" onclick="submitCheck()">
						<a href="/boardList"><input type="button" value="���"></a>
					</td>
				</tr>
			</table>
		</form>
	</section>
</body>
</html>