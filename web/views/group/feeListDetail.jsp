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
	
	#temp{
		display:inline-block;
		float:left;
		font-size:10px; 
		padding-left: 25px;
		padding-top: 15px;
		color:rgba(75, 75, 75, 0.493);
	}
	.content-area{
		width:950px;
		height:800px;
		margin:0 auto;
	}
	.form-area{
		margin:15px 25px;
	}
	.category, .title, .writer, .payedDate {
		display:inline-block;
		width:100px;
	}
	
  </style>
</head>
<body>
	<!-- 여기 헤더 추가할것 -->
<%-- 	<%@include file="../common/header/header_old.html" %> --%>
	<%@include file="subMenubar.jsp" %>
	<br>
	<div class="content">
	<p align="right" style="font-size:10px; padding-right: 25px; padding-top: 15px;">개인정보취급방침에 따라 최근 5년간의 내역이 제공됩니다.</p>
		<div id="sub-title"><span style="font-size: 20px; margin-left:25px">결제내역 상세</span></div>
		<!-- 뒤로가기 glyphicon 추가하기 -->
		
		
		<br><br>
		
		<div class="content-area">
			<div class="form-area">
				<form>
					<label for="title">결제금액(원)</label>&nbsp;&nbsp;
					<input type="text" class="form-control title" value="25,000" id="title" style="width:350px" readonly>&nbsp;
					<br><br>
					<label for="category">분류</label>&nbsp;&nbsp;
					<input type="text" class="form-control category" value="인원증설" readonly>&nbsp;&nbsp;	
					<label for="writer">결제자</label>&nbsp;&nbsp;
					<input type="text" class="form-control writer" value="김형진" readonly>&nbsp;&nbsp;
					<label for="payedDate">결제일</label>&nbsp;&nbsp;
					<input type="date" class="form-control payedDate" style="width:200px;" readonly><br><br>
					<br><br>
					<!-- 자기 자신의 게시글일 경우에만 보임 -->
					<!--<button class="btn btn-primary" onclick="">수정하기</button>  -->
				</form>
				<button class="btn btn-danger" onclick="refund();">환불신청</button>	
			</div>
		</div>
	</div>
	<script>
		function refund() {
			location.href="refund.jsp";
		}
	</script>
 		<%@include file="../common/footer/footer.jsp" %> 
</body>
</html>