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

#deleteBtn {
	width: 40px;
	height: 30px;
	border-radius: 5px;
	background: white;
	border: 1px solid lightgray;
	margin-left: 25px;
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
		<div id="sub-title">
		<br>
			<span style="font-size: 40px">회비 관리</span>
		</div>
		<br>
		<br>
		<br>
		<!-- 게시판 관리일경우 -->
		<div class="table-div">
		<form action="<%=request.getContextPath() %>/delete.fee" method="post" id="deleteFee">
			<table class="table table-striped">
				<thead>
					<tr>
						<th><input type="checkbox" id="selectAllItems"></th>
						<th>종류</th>
						<th>결제금액</th>
						<th>상세설명</th>
						<th>결제일시</th>
					</tr>
				</thead>
				<tbody>
					<% for(FeeVO f : list) { %>
					<tr>
						<input type="hidden" value="<%= f.getFeeCode() %>">
						<td><input type="checkbox" id="feeElement"></td>
						<td><%= f.getFeeCategory() %></td>
						<td><%= f.getFee() %></td>
						<td><%= f.getDetail() %></td>
						<td><%= f.getFeeDate() %></td>
					</tr>
				<% } %>
				</tbody>
			</table>
			</form>
		</div>
		<button id="deleteBtn">삭제</button>
		<button id="insertBtn" style="float:right; margin-right: 25px" onclick="location.href='<%=request.getContextPath()%>/views/group/feeInsertForm.jsp'">쓰기</button>
		<!-- 위 코드는 모임장일때만 작동하도록 함 -->

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
		

	</div>
	<script>
	$(function(){
		
		$("#selectAllItems").click(function(){
	        $("input[type=checkbox]").prop('checked', $(this).prop('checked'));

		});
		
		$("#deleteBtn").click(function(){
			var feeCode = [];
			$.each($("#feeElement:checked").parent().prev(), function(){
				feeCode.push($(this).val());
				$(this).attr("name", "feeCode");
			});
			
			if(window.confirm('정말로 해당 게시물을 삭제하시겠습니까?')) {
				$("#deleteFee").submit();
			}
			
		});
		
		
	});
	</script>
	<%@include file="../common/footer/newFooter.jsp"%>
</body>
</html>