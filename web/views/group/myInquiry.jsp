<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.kh.groumoa.inquire.model.vo.InquireVO, java.util.ArrayList, com.kh.groumoa.common.*"%>
	<%ArrayList<InquireVO> selectQna = (ArrayList<InquireVO>) request.getAttribute("selectQna"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 문의내역</title>
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
	height: 1000px;
	margin: 0 auto;
	border: 1px solid #e2d8d8;
	border-radius: 10px;
	text-align: center;
	margin-top: 50px;
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

.table {
	width: 950px;
	margin-left: 25px;
}

.pagination-div {
	margin: 0 330px;
}

.table tbody tr:hover {
	cursor: pointer;
}

.deleteBtn {
	border-radius: 30px;
	float: left;
	margin-left: 30px;
	margin-top: -45px;
}

.writeBtn {
	border-radius: 30px;
	margin-left: 90px;
	margin-top: -45px;
}

.wrap {
	background: white;
	width: 100%;
	height: 50px;
	text-align: center;
}

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

.menu:hover {
	background: #461212;
	color: white;
	font-weight: bold;
	cursor: pointer;
}

#searchbox {
	margin: 0 200px;
}

#searchbox select {
	float: left;
}

#searchbox input {
	float: left;
}

#myAsk {
	border-bottom: 1px solid black;
	text-align: left;
	width: 1000px;
	margin-left: auto;
	margin-right: auto;
	margin-top: 50px;
}

#table-div {
	
}
</style>
</head>
<body>
	<%@ include file="../common/header/newHeader.jsp"%>
	<div class="wrap">
		<div class="nav">
			<div class="menu">공지사항</div>
			<div class="menu">고객센터</div>
			<div class="menu">자주하는 질문</div>
			<div class="menu">문의하기</div>
		</div>
	</div>
	<div id="myAsk">나의 문의내역</div>
	<div class="content">
		<div class="table-div">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>등록일</th>
						<th>문의제목</th>
						<th>문의상태</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (InquireVO i : selectQna) {
					%>
					<tr>
						<input type="hidden" value="<%=i.getQna_Code()%>">
						<td><%=i.getQna_Date()%></td>
						<td><%=i.getQna_Title()%></td>
						<td><%=i.getIsanswered()%></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
		<button onclick="location.href='<%=request.getContextPath()%>/insert.qa'">작성하기</button>
	</div>

</body>
</html>





