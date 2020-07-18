<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="../../../resources/css/header_style.css">
<title>Insert title here</title>
<style>

.logo_container {
	width: 135px;
	height: auto;
	float: left;
}

.search-form {
	text-align: center;
}

.search-form input[type=text] {
	padding: 7px;
	border: none;
	width: 500px;
	border-radius: 50px;
	border: 2px solid blue; font-size : 16px;
	font-family: sans-serif;
	margin-top: 7px;
	font-size: 16px;
}

.search-form button {
	padding: 7px;
	border-radius: 50px;
	border: none;
	font-size: 16px;
	font-family: sans-serif;
}
</style>
</head>
<body>
	<table class="header">
		<tr>
			<td rowspan="2">
				<div class="logo_container">
					<img src="../../../resources/image/logo_groumoa2.png">
				</div>
			</td>
			<td rowspan="2">
				<form class="search-form">
					<input type="text" placeholder="search">
					<button>search</button>
				</form>
			</td>
			<td>로그인</td>
			<td>회원가입</td>
			<td>서비스안내</td>
			<td>고객센터</td>
		</tr>
		<tr>
			<td>마이페이지</td>
			<td>모임개설</td>
			<td>모임관리</td>
			<td>알림</td>
		</tr>
	</table>
	<div class="header">
		<div class="inner_header">
			<!-- 			<ul class="navigation">
				<li>추천동호회</li>
				<li>내모임</li>
				<li>공지사항</li>
				<li>QnA</li>
			</ul> -->
		</div>
	</div>
</body>
</html>