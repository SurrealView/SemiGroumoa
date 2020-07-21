<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.groumoa.group.model.vo.BoardVO"%>
<% BoardVO selectedBoard = (BoardVO) request.getAttribute("selectedBoard"); %>
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
		margin:0 330px	;
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
   			<table class="table table-striped boardTable">
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
                    <tr>
                    
                      <td><a href="boardManagement-detail.jsp">1</a></td>
                      <td>공지</td>
                      <td>김형진</td>
                      <td>방가방가</td>
                      <td>2020-07-05</td>
                      <td>2</td>
                    </tr>
                    <tr>
                    
                        <td>1</td>
                        <td>공지</td>
                        <td>김형진</td>
                        <td>방가방가</td>
                        <td>2020-07-05</td>
                        <td>2</td>
                      </tr>
                     
                  </tbody>
                </table>
                </div>
               
                <br>
                <div class="pagination-div">
                <ul class="pagination">
                	<li class="page-item"><a class="page-link" href="#"><<</a></li>
  					<li class="page-item"><a class="page-link" href="#"><</a></li>
  					<li class="page-item"><a class="page-link" href="#">1</a></li>
  					<li class="page-item active"><a class="page-link" href="#">2</a></li>
  					<li class="page-item"><a class="page-link" href="#">3</a></li>
  					<li class="page-item"><a class="page-link" href="#">4</a></li>
  					<li class="page-item"><a class="page-link" href="#">5</a></li>
  					<li class="page-item"><a class="page-link" href="#">></a></li>
  					<li class="page-item"><a class="page-link" href="#">>></a></li>
				</ul>
				</div>
				
				<div class="writeBtn" style="float:left">
					<button class="" onclick="location.href='boardWrite.jsp'";>작성하기</button>
				</div>
                <div class="searchbox" id="searchbox">
					<form>
						<select class="form-control">
	  						<option>제목</option>
	  						<option>작성자</option>
	  						<option>내용</option>
						</select>
						<input type="text" placeholder="게시글 검색" style="height:35px;">
						 <button type="submit"><i class="fa fa-search" style="height:25px"></i></button>
					</form>
					
				</div>
		</div>
		<!-- footer 추가할것 -->
		
		
</body>
</html>