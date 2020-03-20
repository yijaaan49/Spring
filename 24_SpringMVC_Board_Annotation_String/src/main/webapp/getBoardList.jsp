<%@page import="java.util.List"%>
<%@page import="com.spring.biz.board.BoardVO"%>
<%@page import="com.spring.biz.board.impl.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
</head>
<style>
	#container {
		width: 700px;
		margin: 0 auto;
	}
	h1, h3, p { text-align: center; }
	table { border-collapse: collapse; }
	table, th, td {
		border: 1px solid black;
		margin: 0 auto;
	}
	th { background-color: orange; }
	.center { text-align: center; }
	.border-none, .border-none td { border: none; }
</style>
<body>

<div id="container">
	<h1>글 목록</h1>
	<h3>테스트님 환영합니다.
		<a href="logout.do">로그아웃</a>
	</h3>
	
	<!-- 검색을 위한 폼 -->
	<form action="getBoardList.jsp" method="post">
	<table class="border-none">
		<tr>
			<td>
				<select name="searchCondition">
					<option value="TITLE">제목
					<option value="CONTENT">내용
				</select>
				<input type="text" name="searchKeyword">
				<input type="submit" value="검색">
			</td>
		</tr>
	</table>
	</form>
	
	<!-- 데이터 표시 -->
	<form>
	<table>
		<tr>
			<th width="100">번호</th>
			<th width="200">제목</th>
			<th width="150">작성자</th>
			<th width="150">작성일</th>
			<th width="100">조회수</th>
		</tr>
		<c:forEach var="board" items="${boardList }">
			<tr>
				<td class="center">${board.getSeq() }</td>
				<td>
					<a href="getBoard.do?seq=${board.getSeq() }">${board.getTitle() }</a>
				</td>
				<td>${board.getWriter() }</td>
				<td>${board.getRegdate() }</td>
				<td class="center">${board.getCnt() }</td>
			</tr>
		</c:forEach>
	</table>
	</form>
	<p><a href="insertBoard.jsp">새글등록</a></p>
</div>

</body>
</html>