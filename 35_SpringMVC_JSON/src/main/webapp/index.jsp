<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시작페이지</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>

<div id="container">
	<h1>게시판 프로그램</h1>
	<hr>
	<p><a href="login.do">로그인(GET)</a></p>
	<p><a href="getBoardList.do">전체목록보기</a></p>
	
	<hr>
	<p><a href="dataTransform.do">데이터 전환(JSON)</a></p>
	
	<p><a href="javascript:getJsonData()">JSON 데이터 받아서 화면표시</a></p>
</div>

<hr>
<div id="listDisp">
	<ul>
		<li>데이터 가져와서 출력하기</li>
	</ul>
</div>

<script>
	function getJsonData() {
		$.ajax("getJsonList.do", {
			type : "get",
			dataType : "json",
			success : function(data) {
				alert("성공!");
				console.log(data);
				//응답받은 데이터 형식 : [{}, {}, ..., {}] = 배열 형식
				var strData = JSON.stringify(data); //JSON -> string
				console.log("-" + strData + "-");
				
				var jsData = JSON.parse(strData); //string -> JavaScript 객체화
				console.log("-" + jsData + "-");
				
				var dispHtml = "";
							
				dispHtml = "<ul>";
				$.each(data, function(index, obj){
					dispHtml += "<li>";
					dispHtml += this.seq + ", ";
					dispHtml += this.title + ", ";
					dispHtml += this.content + ", ";
					dispHtml += this["writer"] + ", "; //. 을 쓰거나 [속성명 문자열처리] 둘다 표현가능
					dispHtml += this["regdate"] + ", ";
					dispHtml += obj["cnt"]; // this==obj
					dispHtml += "</li>";
				});
				dispHtml += "</ul>";
				$("#listDisp").html(dispHtml);
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert("실패 : \n"
					+ "jqXHR.readyState : " + jqXHR.readyState + "\n"
					+ "textStatus : " + textStatus
					+ "errorThrown : " + errorThrown);
			} 
		});
	}
	
</script>
</body>
</html>