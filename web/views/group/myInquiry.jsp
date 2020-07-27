<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.groumoa.inquire.model.vo.InquireVO, java.util.ArrayList, com.kh.groumoa.common.*"%>
<% ArrayList<InquireVO> list = (ArrayList<InquireVO>) request.getAttribute("list"); 
PageInfo pi = (PageInfo) request.getAttribute("pi");
int listCount = pi.getTotalCount();
int currentPage = pi.getCurrentPage();
int maxPage = pi.getMaxPage();
int startPage = pi.getStartPage();
int endPage = pi.getEndPage();
%>
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
				<tr>
					<td>2020.07.07</td>
					<td>계정이 해킹당한거 같아요</td>
					<td>답변대기</td>
				</tr>
				<tr>
					<td>2020.07.08</td>
					<td>동호회 비용관련 문의</td>
					<td>답변대기</td>
				</tr>
				<tr>
					<td>2020.07.14</td>
					<td>사이트 내 오류가 있어요!</td>
					<td>답변대기</td>
				</tr>
			</tbody>
		</table>
	</div>
	</div>
	<div class="pagingArea" align="center">
			<button onclick="location.href='<%=request.getContextPath()%>/select.in?currentPage=1'"><<</button>
			
			<% if(currentPage <= 1) {%>
			<button disabled><</button>
			<%} else { %>
			<button onclick="location.href='<%=request.getContextPath() %>/select.in?currentPage=<%=currentPage - 1 %>'"><</button>
			<% } %>
			
			<% for(int p = startPage; p <= endPage; p++) {
				if(p == currentPage) {
			%>
				<button disabled><%=p %></button>
			<%   } else { %>
					<button onclick="location.href='<%=request.getContextPath()%>/select.in?currentPage=<%=p%>'"><%=p %></button>
			<%
				}
			}
			%>
			
			<% if(currentPage >= maxPage) { %>
			<button disabled>></button>
			<%} else { %>
			<button onclick="location.href='<%=request.getContextPath() %>/select.in?currentPage=<%=currentPage + 1 %>'">></button>
			<% } %>
			
			<button onclick="location.href='<%=request.getContextPath()%>/select.in?currentPage=<%=maxPage%>'">>></button>
		</div>
		

</body>
</html>