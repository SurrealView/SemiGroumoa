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
		<h2>마이페이지</h2>
		<div class="sub-menubar" id="sub-menubar">
			
			<div class="sub-menubar-each" id="sub5"><a href="myPage.jsp">마이페이지 메인</a></div>
			<div class="sub-menubar-each" id="sub6"><a href="changeInfo.jsp">내 정보 수정</a></div>
			<div class="sub-menubar-each" id="sub9"><a href="#"></a></div>
		</div>
	</div>
</body>
</html>