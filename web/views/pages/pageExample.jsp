<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>연습문제</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$("header").load("../common/header.jsp");
		$("nav").load("../common/nav.jsp");
		$("footer").load("../common/footer.jsp");
	});
</script>

<style>
.section {
	background: yellowgreen;
	height: 400px;
	color: white;
	width: 70%;
	display: inline-block;
	float: left;
}

.article1 {
	background: violet;
	color: white;
	display: inline-block;
	height: 290px;
	width: 50%;
}

.article2 {
	background: orange;
	color: white;
	display: inline-block;
	height: 290px;
	width: 50%;
	margin-left: -6px;
	margin-top: 40px;
}

.aside-left {
	/* background: blue; */
	color: white;
	width: 15%;
	height: 100%;
	display: block;
	float: left;
}

.aside-right {
	/* background: blue; */
	/* color: white; */
	width: 15%;
	height: 100%;
	display: inline-block;
}
</style>
</head>

<body>
	<%@ include file="../common/header/header.jsp"%>
	<%@ include file="../common/nav.jsp"%>
	<div class="blank">
		<strong>
			<div class="section">
				<br>section<br>
				<div class="article1">article</div>
				<div class="article2">article</div>
			</div>
		</strong>
	</div>
	<%@ include file="../common/footer/footer.jsp"%>
</body>

</html>