<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.DriverManager"
	import="java.sql.SQLException"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->
<title>Insert title here</title>

<link
	href="https://fonts.googleapis.com/css2?family=Poor+Story&display=swap"
	rel="stylesheet">
<style>
body {
	font-family: 'Poor Story', cursive;
	
	background-image: url('/groumoa/resources/image/backgroundImg.png');
	background-position: 0% 10%;
	background-size: 100% auto;
	background-repeat: no-repeat;
}

#wrapper {
	display: block;
	margin: 0px auto;
}

#main-content {
	height: 800px;
}

#main-word{
	color: white;
	position: absolute;
	left: 16%;
	top: 125%;
	font-size: 90pt;
	font-family: '나눔명조','명조';
}
</style>
</head>
<body>
	<%@include file="views/common/header/newHeader.jsp"%>
	<div id="wrapper">
		<div id="main-content">
			<div id="main-word">"글자가 들어가는 곳"</div>
		</div>
	</div>
	<%@include file="views/common/footer/newFooter.jsp"%>
</body>
</html>