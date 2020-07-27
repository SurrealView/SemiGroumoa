<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.groumoa.product.model.vo.ProductBoughtVO, com.kh.groumoa.common.PageInfo, java.util.ArrayList
    , com.kh.groumoa.common.CustomUtil"%>
    <% ArrayList<ProductBoughtVO> list = (ArrayList<ProductBoughtVO>) request.getAttribute("list"); 
    CustomUtil cu = new CustomUtil();
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
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
	.content{
		width:1000px;
		height:1500px;
		margin:0 auto;
		border: 1px solid #e2d8d8;
		border-radius: 10px;
	}
	.tab{
		width:950px;
		height:50px;
		margin-top: 0px;
		margin-left: 25px;
		border-bottom:1px solid #e2d8d8;
	}
	.item{
		display: inline-block;
		float:left;
		font-size: 12px;
		font-weight:bold;
		text-align:center;
		width:100px;
		height:20px;
		border: 1px solid #e2d8d8;
		margin-top: 30px;
		background-color:rgba(235, 235, 235, 0.493);
	}
	#sub-title{
		margin-left: 25px;
	}
	.item a {
			text-decoration: none;
			color: black;
			
	}
	.active {
		border-bottom:1px solid white;
	}
	.active a{
		color:rgb(70, 107, 228);
	}
	#searchbox{
		margin: 0 330px;
	}
	#searchbox select {
		float: left;
	}
	#searchbox input {
		float: left;
	}
	.form-control{
		width:100px;
		height:35px;
		
	}
	#temp{
		display:inline-block;
		float:left;
		font-size:10px; 
		padding-left: 25px;
		padding-top: 15px;
		color:rgba(75, 75, 75, 0.493);
	}
	.table{
		width:950px;
		margin-left:25px;
	}
	.pagination-div{
		margin:0 330px	;
	}
	.table tbody tr:hover{
		cursor:pointer;
	}
	.deleteBtn {
		border-radius: 30px;
		float:left;
		margin-left:30px;
		margin-top:-45px;	
	}
	.writeBtn{
		border-radius:30px;
		margin-left: 90px;
		margin-top:-45px;
	}
</style>
</head>
<body>
	<%@include file="../common/header/newHeader.jsp" %>
	<%@include file="subMenubar.jsp" %>
	
	<div class="content">
		<p align="right" style="font-size:10px; padding-right: 25px; padding-top: 15px;">개인정보취급방침에 따라 최근 5년간의 내역이 제공됩니다.</p>
		<div id="sub-title"><span style="font-size: 15px">결제내역 관리</span></div>
		
		<span id="temp">결제내역을 조회하실 수 있습니다.</span>
		
		<br><br><!-- 게시판 관리일경우 -->
		<div class="table-div">
			<h2 align="center">결제내역</h2>         
   			<table class="table table-striped">
                  <thead>
                    <tr>
                      <th>결제금액(원)</th>
                      <th>결제상품</th>
                      <th>결제자</th>
                      <th>결제일시</th> 
                    </tr>
                  </thead>
                  <tbody>
                    <% for(ProductBoughtVO pb : list) { %>
					<tr>
						<input type="hidden" value="<%=pb.getPbCode() %>">
						<td><%= pb.getProductPrice() %></td>
						<td><%= pb.getProductDetail() %></td>
						<td><%= pb.getPayerName() %></td>
						<td><%= cu.sqlDateToString(pb.getPbDate()) %></td>
					</tr>
				<% } %>
                  
                  </tbody>
                </table>
                </div>
            	
                
                <br>
                 <!-- 페이징 처리 버튼 -->
		<div class="pagingArea" align="center">
			<button onclick="location.href='<%=request.getContextPath()%>/selectHistory.pr?currentPage=1'"><<</button>
			
			<% if(currentPage <= 1) {%>
			<button disabled><</button>
			<%} else { %>
			<button onclick="location.href='<%=request.getContextPath() %>/selectHistory.pr?currentPage=<%=currentPage - 1 %>'"><</button>
			<% } %>
			
			<% for(int p = startPage; p <= endPage; p++) {
				if(p == currentPage) {
			%>
				<button disabled><%=p %></button>
			<%   } else { %>
					<button onclick="location.href='<%=request.getContextPath()%>/selectHistory.pr?currentPage=<%=p%>'"><%=p %></button>
			<%
				}
			}
			%>
			
			<% if(currentPage >= maxPage) { %>
			<button disabled>></button>
			<%} else { %>
			<button onclick="location.href='<%=request.getContextPath() %>/selectHistory.pr?currentPage=<%=currentPage + 1 %>'">></button>
			<% } %>
			
			<button onclick="location.href='<%=request.getContextPath()%>/selectHistory.pr?currentPage=<%=maxPage%>'">>></button>
		</div>
		</div>
		<!-- footer 추가할것 -->
		<%@include file="../common/footer/footer.jsp" %>
</body>
</html>