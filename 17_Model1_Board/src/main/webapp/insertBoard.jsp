<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 등록</title>
<style>
	#container {
		width: 700px;
		margin: 0 auto;
	}
	h1 { text-align: center; }
	table { border-collapse: collapse; }
	table, th, td {
		border: 1px solid black;
		margin: 0 auto;
	}
	th { background-color: orange; }
	.center { text-align: center; }
</style>
</head>
<body>
	<div id="container">
		<h1>글 등록</h1>
		<p class="center"><a href="logout_proc.jsp">로그아웃</a></p>
		<hr>
		
		<form action="insertBoard_proc.jsp" method="post">
		<table>
			<tr>
				<th>제목</th>
				<td>
					<input type="text" name="title" size="30">
				</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>
					<input type="text" name="writer">
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea name="content" rows="10" cols="40"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" class="center">
					<input type="submit" value="새글 등록">
				</td>
			</tr>
		</table>
		</form>
		<p class="center"><a href="getBoardList.jsp">글 목록 가기</a></p>
	</div>
</body>
</html>