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
}

#wrapper {
	display: block;
	margin: 0px auto;
}

#main-content {
	width: 1000px;
	height: 800px;
}

#myCarousel{
	padding-top: 300px;
}
</style>
</head>
<body>
	<%@include file="views/common/header/newHeader.jsp"%>
	<div id="wrapper">
		<div id="main-content">
<!-- 
			carousel
			<div class="container">
				<div id="myCarousel" class="carousel slide" data-ride="carousel">
					Indicators
					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
						<li data-target="#myCarousel" data-slide-to="2"></li>
					</ol>

					Wrapper for slides
					<div class="carousel-inner">
						<div class="item active">
							<img src="../../resources/image/main1.png" alt="main1"
								style="width: 100%;">
						</div>

						<div class="item">
							<img src="../../resources/image/main2.png" alt="main2" style="width: 100%;">
						</div>

						<div class="item">
							<img src="../../resources/image/main3.png" alt="main3" style="width: 100%;">
						</div>
					</div>

					Left and right controls
					<a class="left carousel-control" href="#myCarousel"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#myCarousel"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>
			</div>

 -->
		</div>
	</div>
	<%@include file="views/common/footer/newFooter.jsp"%>
</body>
</html>