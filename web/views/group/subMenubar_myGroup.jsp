<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#sub-menubar-wrap {
		width:1000px;
		height: 110px;
		margin:0px auto;
	}
	#sub-menubar {
		width:1000px;
		height: 39px;
		background-color: darkred;
		margin-left: auto;
		margin-right: auto;
		border-radius: 10px;
		
	}
	
	.sub-menubar-each a {
		text-decoration: none;
		color:white;
		font-size: 10px;
	}
	.sub-menubar-each{	
		display:inline-block;
		margin:7px 30px;
	}
	.sub-menubar-each a:hover {
		color: yellow;
	}

</style>
</head>
<body>
	<div class="sub-menubar" id="sub-menubar-wrap">
		<h2>모임관리</h2>
		<div class="sub-menubar" id="sub-menubar">
			<div class="sub-menubar-each" id="sub1"><a href="#">동호회페이지</a></div>
			<div class="sub-menubar-each" id="sub2"><a href="#">최근일정</a></div>
			<div class="sub-menubar-each" id="sub3"><a href="#">회비내역</a></div>
			<div class="sub-menubar-each" id="sub4"><a href="#">게시판</a></div>
			<div class="sub-menubar-each" id="sub5"><a href="#">모임인원</a></div>
		</div>
	</div>
</body>
</html>