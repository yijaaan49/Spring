<%@page import="com.spring.biz.board.impl.BoardDAO"%>
<%@page import="com.spring.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달받은 파라미터 값(seq) 사용 DB 조회하고 화면에 표시 --%>
<%
	//1. 전달받은 데이터 추출
	int seq = Integer.parseInt(request.getParameter("seq"));

	//2. DB 연동 처리 (하나의 글 조회)
	BoardVO vo = new BoardVO();
	vo.setSeq(seq);
	
	BoardDAO boardDAO = new BoardDAO();
	BoardVO board = boardDAO.getBoard(vo);
	
	//3. 조회 데이터 화면표시(HTML 작성)
%>
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
		<p><a href="logout_proc.jsp">로그아웃</a></p>
		<hr>
		<form action="updateBoard_proc.jsp" method="get">
			<input type="hidden" name="seq" value="<%=board.getSeq() %>">
			<table>
				<tr>
					<th>제목</th>
					<td>
						<input type="text" name="title" value="<%=board.getTitle()%>">
					</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>
						<input type="text" name="writer" value="<%=board.getWriter()%>">
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea name="content" rows="10" cols="40"><%=board.getContent()%></textarea>
					</td>
				</tr>
				<tr>
					<th>등록일</th>
					<td><%=board.getRegdate() %></td>
				</tr>
				<tr>
					<th>조회수</th>
					<td><%=board.getCnt() %></td>
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
			<a href="deleteBoard_proc.jsp?seq=<%=board.getSeq()%>">글 삭제</a>
			<a href="getBoardList.jsp">글 목록</a>
		</P>
	</div>

</body>
</html>