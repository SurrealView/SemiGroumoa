<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#pwd_form {
	font-size: 1.3em;
	width: 500px;
	display: inline-block;
	margin: 0px auto;
}

#Btn11 {
	text-align: center;
}
</style>
</head>
<body>
	<div id="loginer" align="center" style="">
		<form id="pwd_form" method="POST">
			<fieldset>
				<img src="image/security.png"
					style="float: left; width: 200px; height: 200px;">
				<legend>ID 찾기</legend>
				<br> <br> 가입이메일 <br> <br> yeori_kim@gmail.com <br>

			</fieldset>
		</form>
	</div>
	<br>
	<br>
	<div class="Btn11" style="text-align: center;">
		<button type="submit" class="writeBtn">로그인하기</button>
		<button type="submit" class="cancelBtn">비밀번호찾기</button>
	</div>
</body>
</html>