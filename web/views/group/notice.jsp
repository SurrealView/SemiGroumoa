<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		height:1000px;
		margin:0 auto;
		border: 1px solid #e2d8d8;
		border-radius: 10px;
		text-align: center;
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
	.item a {
			text-decoration: none;
			color: black;	
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
#searchbox{
		margin: 0 200px;
	}
	#searchbox select {
		float: left;
	}
	#searchbox input {
		float: left;
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
	<div class="content">
		<br><br>
		<div class="table-div">      
   			<table class="table table-striped">
                  <thead>
                    <tr>
                      <th>번호</th>
                      <th>분류</th>
                      <th>제목</th>
                      <th>작성일</th> 
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td><a href="feeListDetail.jsp">1</a></td>
                      <td>공지</td>
                      <td><b>그루모아</b>와 함께하는 '모임 생활 속 거리두기'</td>
                      <td>2020-07-01</td>
                    </tr>
                   <tr>
                      <td><a href="#">2</a></td>
                      <td>공지</td>
                      <td>근로자의 날 휴무안내</td>
                      <td>2020-07-02</td>
                    </tr>
                    <tr>
                      <td><a href="#">3</a></td>
                      <td>공지</td>
                      <td>[업데이트]'고객센터'개편 안내</td>
                      <td>2020-07-12</td>
                    </tr>
                    <tr>
                      <td><a href="#">4</a></td>
                      <td>업데이트</td>
                      <td>[업데이트]'뉴스레터 구독'페이지 안내</td>
                      <td>2020-07-14</td>
                    </tr>
                    <tr>
                      <td><a href="#">5</a></td>
                      <td>공지</td>
                      <td>그루모아 창립기념</td>
                      <td>2020-07-15</td>
                    </tr>
                    <tr>
                      <td><a href="#">6</a></td>
                      <td>업데이트</td>
                      <td>[약관]고객 CS외주에 따른 약관 변경</td>
                      <td>2020-07-15</td>
                    </tr>
                    <tr>
                      <td><a href="#">7</a></td>
                      <td>휴무</td>
                      <td>2020년 추석 휴무 안내</td>
                      <td>2020-07-16</td>
                    </tr>
                    <tr>
                      <td><a href="#">8</a></td>
                      <td>공지</td>
                      <td>업데이트</td>
                      <td>2020-07-17</td>
                    </tr>
                    <tr>
                      <td><a href="#">9</a></td>
                      <td>공지</td>
                      <td>[공지]서비스 점검 서비스 이용불가 안내</td>
                      <td>2020-07-17</td>
                    </tr>
                    <tr>
                      <td><a href="#">10</a></td>
                      <td>공지</td>
                      <td>[공지]그루모아 07/28일 서비스 종료</td>
                      <td>2020-07-20</td>
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
		</div>
</body>
</html>