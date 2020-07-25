<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.groumoa.group.model.vo.BoardVO, java.util.ArrayList, com.kh.groumoa.common.*"%>
<% ArrayList<BoardVO> list = (ArrayList<BoardVO>) request.getAttribute("list"); 
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
	.boardTable{
		width:950px;
		margin-left:25px;
	}
	.pagination-div{
		margin:0 230px;
	}
	.table tbody tr:hover{
		cursor:pointer;
	}
	.deleteBtn {
		
	}
	.writeBtn{
		border-radius: 30px;
		float:left;
		margin-left:30px;
		margin-top:-45px;	
	}
</style>
</head>
<body>
	<%@include file="/views/common/header/newHeader.jsp" %>
	<%@include file="subMenubar_myGroup.jsp" %>
	<div class="content">
		<p align="right" style="font-size:10px; padding-right: 25px; padding-top: 15px;">개인정보취급방침에 따라 최근 5년간의 내역이 제공됩니다.</p>
		<div id="sub-title"><span style="font-size: 15px">게시판</span></div>
		
		<br><br>
		<div class="table-div">
			<h2 align="center">게시판</h2>         
   			<table class="table table-striped boardTable" id="listArea">
                  <thead>
                    <tr>
                      <th>글번호</th>
                      <th>분류</th>
                      <th>작성자</th>
                      <th>제목</th>
                      <th>작성일</th>
                      <th>조회수</th>
                    </tr>
                  </thead>
                  <tbody>
                    <% for(BoardVO b : list) { %>
					<tr>
						<input type="hidden" value="<%=b.getPostCode() %>">
						<td><%= b.getPostCode() %></td>
						<td><%= b.getCategoryName() %></td>
						<td><%= b.getMemberName() %></td>
						<td><%= b.getTitle() %></td>
						<td><%= b.getPostDate() %></td>
						<td><%= b.getPcount() %></td>
					</tr>
				<% } %>
				
                  </tbody>
                </table>
                </div>
               
                <br>
               <!-- 페이징 처리 버튼 -->
		<div class="pagingArea" align="center">
			<button onclick="location.href='<%=request.getContextPath()%>/selectList.bo?currentPage=1'"><<</button>
			
			<% if(currentPage <= 1) {%>
			<button disabled><</button>
			<%} else { %>
			<button onclick="location.href='<%=request.getContextPath() %>/selectList.bo?currentPage=<%=currentPage - 1 %>'"><</button>
			<% } %>
			
			<% for(int p = startPage; p <= endPage; p++) {
				if(p == currentPage) {
			%>
				<button disabled><%=p %></button>
			<%   } else { %>
					<button onclick="location.href='<%=request.getContextPath()%>/selectList.bo?currentPage=<%=p%>'"><%=p %></button>
			<%
				}
			}
			%>
			
			<% if(currentPage >= maxPage) { %>
			<button disabled>></button>
			<%} else { %>
			<button onclick="location.href='<%=request.getContextPath() %>/selectList.bo?currentPage=<%=currentPage + 1 %>'">></button>
			<% } %>
			
			<button onclick="location.href='<%=request.getContextPath()%>/selectList.bo?currentPage=<%=maxPage%>'">>></button>
		</div>
		
                
               <%-- <!-- 페이징 처리 -->
                   <div class="pagination-div">
                <ul class="pagination">
                	<li class="page-item"><a class="page-link" href="<%=request.getContextPath()/selectList.bo?currentPage=1"><<</a></li>
                	<%if (currentPage <= 1) {%>
  						<li class="page-item"><</li>
  					<% } else {%>
  						<li class="page-item"><a class="page-link" href="<%=request.getContextPath() %>/selectList.bo?currentPage=<%=currentPage - 1 %>"><</a></li>
  					<%} %>
  					<%for (int p = startPage; p <= endPage; p++) { 
  						if(p == currentPage) {
  					%>
  						<li class="page-item"><a class="page-link active"><%=p %></a></li>
  					<% } else { %>
  						<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/selectList.bo?currentPage=<%=p%>"><%=p %></a></li>
					<%
						}
					}
					%>
  					<%if (currentPage >= maxPage) { %>
  						<li class="page-item"><a class="page-link">></a></li>
					<%} else { %>
  						<li class="page-item"><a class="page-link" href="<%=request.getContextPath() %>/selectList.bo?currentPage=<%=currentPage + 1 %>">></a></li>
					<% } %>
  					<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/selectList.bo?currentPage=<%=maxPage%>">>></a></li>
				</ul>
				</div>--%>
				<br>
				<div class="writeBtn" style="float:left">
					<button class="" onclick="location.href='<%=request.getContextPath() %>/views/group/boardWrite.jsp'";>작성하기</button>
				</div>
                <div class="searchbox" id="searchbox">
					<form method="get" class="searchForm">
						<select class="form-control" id="searchBy">
	  						<option>작성자</option>
	  						<option>제목</option>
	  						<option>내용</option>
						</select>
						<input type="text" placeholder="게시글 검색" style="height:35px;" name="search">
						<input type="hidden" value="N" name="leaderYn">
					</form>
						 <button><i class="fa fa-search" style="height:25px" onclick="search();"></i></button>
				</div>
		</div>
		
		<script>
		$(function(){
			$("#listArea td").click(function(){
				var num = $(this).parent().children("input").val();
				console.log(num);
				location.href="<%=request.getContextPath()%>/selectOne.bo?num=" + num;
			});
		});
		
		//검색조건 변수로 받아오기
		
			var selectedSearchOption;
		$(function(){
				$("#searchBy").change(function(){
					selectedSearchOption = 
				$(this).children("option:selected").val();
				
		   		 });
				
		});
		
		function search() {
			console.log(selectedSearchOption);
			if(selectedSearchOption == "작성자" ) {
				$(".searchForm").attr("action", "<%=request.getContextPath() %>/searchByWriter.bo");
				$(".searchForm").submit();
			} else if(selectedSearchOption == "제목") {
				 $(".searchForm").attr("action", "<%=request.getContextPath() %>/searchByTitle.bo");
				 $(".searchForm").submit();
			} else {
				$(".searchForm").attr("action", "<%=request.getContextPath() %>/searchByContent.bo");
				$(".searchForm").submit();
			}
		}
		
		
		</script>
		
		
		<!-- footer 추가할것 -->
		
		
</body>
</html>