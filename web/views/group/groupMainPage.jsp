<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <% GroupVO group = (GroupVO) session.getAttribute("group"); %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동호회 메인페이지</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.content {
	width: 1000px;
	height: 1500px;
	margin: 0 auto;
	border: 1px solid #e2d8d8;
	border-radius: 10px;
}

.tab {
	width: 950px;
	height: 50px;
	margin-top: 0px;
	margin-left: 25px;
	border-bottom: 1px solid #e2d8d8;
}

.item {
	display: inline-block;
	float: left;
	font-size: 12px;
	font-weight: bold;
	text-align: center;
	width: 100px;
	height: 20px;
	border: 1px solid #e2d8d8;
	margin-top: 30px;
	background-color: rgba(235, 235, 235, 0.493);
}

.item a {
	text-decoration: none;
	color: black;
}

.active {
	border-bottom: 1px solid white;
}

.active a {
	color: rgb(70, 107, 228);
}

#btn{
	float:right;
	margin-right: 25px;
	background: white;
	border: 1px solid black;
}

.wrapper {
	margin: auto;
	height: auto;
	width: 1000px;
	display: block;
	margin: 0px auto;
}

.table {
	width: 950px;
	display: block;
	margin: 0px auto;
}

#content1 tr {
	border: 1px solid lightgray;
}

.img-wrapper {
	width: 200px;
	height: 200px;
	border: 1px solid lightgray;
}

#group-title {
	
}

.group-desc {
	
}

#content2{
	width:950px;
	display: block;
	margin: 0px auto;
}

#content3{
	width: 950px;
	height: 500px;
	display: block;
	margin: 0px auto;
	border: 1px solid lightgray;
	
}
.group-field {
	background: rgb(235, 235, 235);
	text-align: center;
	padding-top: auto;
	padding-bottom: auto;
}

.group-board {
	border: 1px solid lightgray;
	height: 300px;
}
</style>
</head>
<body>
	<%@include file="../common/header/newHeader.jsp" %>
	<%@include file="subMenubar.jsp"%>
	<div class="content">
		<!-- 메뉴. 지워도 됨 -->
		<div class="tab" id="tab">
			<div class="item active" id="board">
				<a href="/groumoa/views/group/groupMainPage.jsp">메인페이지</a>
			</div>
			<div class="item active" id="board">
				<a href="#">가입신청내역</a>
			</div>
		</div>
		<!-- 메뉴 끝 -->
		
		<br>
			<input id="btn" type="button" value="가입하기">
		<br>
		<br>
		
		<div class="wrapper">
			<table class="table" id="content1">
				<tr>
					<td colspan="2" rowspan="4">
						<div class="img-wrapper">
							<img src="#" title="썸네일">
						</div>
					</td>
					<td width="15%" class="group-field">동호회명</td>
					<td width="85%"><div id="group-title" class="group-desc">그룹
							이름 들어가는 곳</div></td>
				</tr>
				<tr>
					<td class="group-field">활동지</td>
					<td><div id="group-title" class="group-desc">활동 지역 들어가는
							곳</div></td>
				</tr>

				<tr>
					<td class="group-field">분야</td>
					<td><div id="group-title" class="group-desc">활동 분야 들어가는
							곳</div></td>
				</tr>

				<tr>
					<td class="group-field"></td>
					<td><div id="group-title" class="group-desc">개설일이나 가입인원
							같은거 들어가는 곳</div></td>
				</tr>
			</table>
			<table id="content2" style="margin-top: 25px">
				<tr>
					<td width="325px" class="group-board">대충 무언가 들어가는 곳1</td>
					<td width="25px" class="blank"></td>
					<td width="600px" class="group-board">대충 무언가 들어가는 곳2</td>
				</tr>
			</table>
			<div id="content3" style="margin-top: 25px">대충 무언가 들어가는 곳3	</div>
		</div>
	</div>
	<%@include file="../common/footer/newFooter.jsp" %>
</body>
</html>