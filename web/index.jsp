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

.main-word {
	color: white;
	position: absolute;
	font-family: '나눔명조', '명조';
}

#word1 {
	left: 30%;
	top: 115%;
	font-size: 60pt;
}

#word2 {
	left: 50%;
	top: 125%;
	font-size: 50pt;
}

#word3 {
	left: 25%;
	top: 130%;
	font-size: 80pt;
}
</style>
</head>
<body>
	<%@include file="views/common/header/newHeader.jsp"%>
	<div id="wrapper">
		<div id="main-content">
			<div id="word1" class="main-word">세상의 모든</div>
			<div id="word2" class="main-word">즐거움을 모아</div>
			<div id="word3" class="main-word">그루모아</div>
		</div>
	</div>
	<%@include file="views/common/footer/newFooter.jsp"%>
</body>
</html>