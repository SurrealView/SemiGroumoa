<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.groumoa.fee.model.vo.FeeVO, java.util.ArrayList, com.kh.groumoa.common.*"%>
<%
	ArrayList<FeeVO> list = (ArrayList<FeeVO>) request.getAttribute("list");
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
<title>회비 내역</title>
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

#sub-title {
	margin-left: 25px;
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

#searchbox {
	margin: 0 330px;
}

#searchbox select {
	float: left;
}

#searchbox input {
	float: left;
}

.form-control {
	width: 100px;
	height: 35px;
}

#temp {
	display: inline-block;
	float: left;
	font-size: 10px;
	padding-left: 25px;
	padding-top: 15px;
	color: rgba(75, 75, 75, 0.493);
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

#division {
	width: 950px;
}

#insertBtn {
	width: 40px;
	height: 30px;
	border-radius: 5px;
	background: white;
	border: 1px solid lightgray;
	margin-left: 25px;
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

.pageBtn{
	border-radius: 5px;
	border: 1px solid lightgray;
	background: white;
	width: 30px;
	height: 30px;
}
</style>
</head>
<body>
	<%@include file="../common/header/newHeader.jsp"%>
	<%@include file="subMenubar.jsp"%>

	<div class="content">
		<p align="right"
			style="font-size: 10px; padding-right: 25px; padding-top: 15px;">개인정보취급방침에
			따라 최근 5년간의 내역이 제공됩니다.</p>
		<div id="sub-title">
			<span style="font-size: 20px">회비 내역</span>
		</div>
		<br>
		<hr id="division">
		<button id="insertBtn" onclick="location.href='<%=request.getContextPath()%>/views/group/feeInsertForm.jsp'">쓰기</button>
		<!-- 위 코드는 모임장일때만 작동하도록 함 -->
		<br>
		<br>
		<!-- 게시판 관리일경우 -->
		<div class="table-div">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>종류</th>
						<th>결제금액</th>
						<th>상세설명</th>
						<th>결제일시</th>
					</tr>
				</thead>
				<tbody>
					<% for(FeeVO f : list) { %>
					<tr>
						<%-- <input type="hidden" value="<%=f.getFeeCode() %>"> --%>
						<td><%= f.getFeeCategory() %></td>
						<td><%= f.getFee() %></td>
						<td><%= f.getDetail() %></td>
						<td><%= f.getFeeDate() %></td>
					</tr>
				<% } %>
				</tbody>
			</table>
		</div>


		<br>
				<div class="pagingArea" align="center">
			<button class="pageBtn" onclick="location.href='<%=request.getContextPath()%>/selectList.fee?currentPage=1'"><<</button>
			
			<% if(currentPage <= 1) {%>
			<button class="pageBtn" disabled><</button>
			<%} else { %>
			<button class="pageBtn" onclick="location.href='<%=request.getContextPath() %>/selectList.fee?currentPage=<%=currentPage - 1 %>'"><</button>
			<% } %>
			
			<% for(int p = startPage; p <= endPage; p++) {
				if(p == currentPage) {
			%>
				<button style="background: rgb(2,117,216); color:white" class="pageBtn" disabled><%= p %></button>
			<%   } else { %>
					<button class="pageBtn" onclick="location.href='<%=request.getContextPath()%>/selectList.fee?currentPage=<%=p%>'"><%=p %></button>
			<%
				}
			}
			%>
			
			<% if(currentPage >= maxPage) { %>
			<button class="pageBtn" disabled>></button>
			<%} else { %>
			<button class="pageBtn" onclick="location.href='<%=request.getContextPath() %>/selectList.fee?currentPage=<%=currentPage + 1 %>'">></button>
			<% } %>
			
			<button class="pageBtn" onclick="location.href='<%=request.getContextPath()%>/selectList.fee?currentPage=<%=maxPage%>'">>></button>
		</div>
		<%-- <div class="pagination-div">
			<ul class="pagination">
				<li class="page-item"><a class="page-link" href="'<%=request.getContextPath()%>/selectList.fee?currentPage=1'"><<</a></li>
				<li class="page-item"><a class="page-link" href="'<%=request.getContextPath() %>/selectList.bo?currentPage=<%=currentPage - 1 %>'"><</a></li>
				<li class="page-item"><a class="page-link" href="#">1</a></li>
				<li class="page-item active"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#">4</a></li>
				<li class="page-item"><a class="page-link" href="#">5</a></li>
				<li class="page-item"><a class="page-link" href="#">></a></li>
				<li class="page-item"><a class="page-link" href="#">>></a></li>
			</ul>
		</div> --%>
	</div>
	<%@include file="../common/footer/newFooter.jsp"%>
</body>
</html>