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
	text-align: center;
}

.menu:hover {
	background: #461212;
	color: white;
	font-weight: bold;
	cursor: pointer;
}

#pwd_form {
	font-size: 1.3em;
	width: 500px;
	display: inline-block;
	text-align: center;
	margin-left: auto;
	margin-right: auto;
	margin-top: 50px;
}
</style>
</head>
<body>
	<h2>회원정보 관리</h2>
	<div class="wrap">
		<div class="nav">
			<div class="menu">ID/PWD 찾기</div>
			<div class="menu">회원정보 관리</div>
			<div class="menu">비밀번호 변경</div>
			<div class="menu">회원 탈퇴</div>
		</div>
		<hr noshade="noshade" size="1px" color="black">
		<form>
			<table border="1"
				style="text-align: center; margin-left: auto; margin-right: auto; width: 500px; height: 300px; margin-top: 50px;">
				<tr>
					<th>이름</th>
					<th>김승열</th>
				</tr>
				<tr>
					<td>이메일</td>
					<td>yeori_kim@gmail.com</td>
				</tr>
				<tr>
					<td>연락처</td>
					<td>010-1234-5678</td>
				</tr>
			</table>
		</form>
		<br>
		<br>
		<br>
		<hr style="width: 1000px">
		<form id="pwd_form" method="POST">
			<fieldset>
				<!--<img src="image/security.png" style="float: left; width: 200px; height: 200px;"> -->
				<legend>PWD 변경</legend>
				이름: <input type="text" id="name" name="name"> <br> <br>
				이메일: <input type="text" id="email" name="email"> <br> <br>
				현재 비밀번호: <input type="text" id="password" name="password"> <br>
				<br> 새로운 비밀번호: <input type="text" id="passwordA"
					name="passwordA"> <br> <br> 비밀번호 확인: <input
					type="text" id="passwodrB" name="passwordB"> <br> <input
					type="hidden" value="1" name="check"> <input type="button"
					value="변경 완료" onclick="submit"> <br>
			</fieldset>
		</form>
	</div>
</body>
</html>







