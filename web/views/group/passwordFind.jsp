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

#pp {
	width: 500px;
	margin: 0px auto;
}
</style>
</head>
<body>
	<div id="loginer" align="center" style="">
		<form id="pwd_form" method="POST">
			<fieldset>
				<img src="image/security.png"
					style="float: left; width: 200px; height: 200px;">
				<legend>PWD 찾기</legend>
				<br> <br> 가입이메일 <br> <br> yeori_kim@gmail.com <br>

			</fieldset>
		</form>
	</div>
	<div id="pp">
		<p style="text-align: center;">
			<br>비밀번호는 무작위로 추출된 영문,숫자의 조합으로 발송됩니다. 가입시 입력하신 휴대전화와
			yeori_kim@gmail.com로 신규 비밀번호가 전송이 되었습니다. 로그인 하신 후 원하시는 비밀번호로 변경해 주세요.
		</p>
	</div>
	<br><br>
	<div style="text-align: center;">
	<input type="button" value="로그인하기" onclick="submit">
	</div>
</body>
</html>