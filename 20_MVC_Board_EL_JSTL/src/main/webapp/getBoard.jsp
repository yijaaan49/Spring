<%@page import="com.spring.biz.board.impl.BoardDAO"%>
<%@page import="com.spring.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세보기</title>
<style>
	#container {
		width: 700px;
		margin: 0 auto;
	}
	p{ text-align: center; }
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
		<h1>글 상세</h1>
		<p><a href="logout.do">로그아웃</a></p>
		<hr>
		<form action="updateBoard.do" method="get">
			<input type="hidden" name="seq" value="${board.getSeq() }">
			<table>
				<tr>
					<th>제목</th>
					<td>
						<input type="text" name="title" value="${board.getTitle()}">
					</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>
						<input type="text" name="writer" value="${board.getWriter()}">
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea name="content" rows="10" cols="40">${board.getContent()}</textarea>
					</td>
				</tr>
				<tr>
					<th>등록일</th>
					<td>${board.getRegdate() }</td>
				</tr>
				<tr>
					<th>조회수</th>
					<td>${board.getCnt() }</td>
				</tr>
				<tr>
					<td colspan="2" class="center">
						<input type="submit" value="글 수정">
					</td>
				</tr>
			</table>
		</form>
		<P>
			<a href="insertBoard.jsp">글 등록</a>
			<a href="deleteBoard.do?seq=${board.getSeq()}">글 삭제</a>
			<a href="getBoardList.do">글 목록</a>
		</P>
	</div>

</body>
</html>