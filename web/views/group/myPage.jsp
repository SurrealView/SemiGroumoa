<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.nav {
	width: 600px;
	margin: 0 auto;
}

.menu {
	background: white;
	color: black;
	text-align: center;
	display: table-cell;
	vertical-align: middle;
	width: 150px;
	height: 50px;
}

.wrap {
	background: white;
	width: 100%;
	height: 50px;
}

.menu:hover {
	background: #461212;
	color: white;
	font-weight: bold;
	cursor: pointer;
}
</style>
</head>
<body>
	<div class="wrap">
		<div class="nav">
			<div class="menu">ID/PWD 찾기</div>
			<div class="menu">회원정보 관리</div>
			<div class="menu">비밀번호 변경</div>
			<div class="menu">회원 탈퇴</div>
		</div>
		<hr noshade="noshade" size="1px" color="black">
		<br>
		<br>
		<br>
		<br>
		<div class="mypagee"
			style="border: 1px solid black; width: 700px; height: 300px; margin-left: auto; margin-right: auto; text-align: left; margin-top: 20px;">
			<br>
			<br> 김승열
			<div style="border-top: 1px solid black; width: 300px; margin-top: 10px;">
				이메일 yeori_kim@gmail.com 
				<br><br> phone 010-1234-5678 
				<br><br> 가입일 2020.06.12 
				<br><br> 생년월일 1900.01.01
			</div>
			<br><br>
			<button>작성하기</button>
		</div>
	</div>
</body>
</html>