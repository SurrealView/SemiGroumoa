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
		/*border:1px solid black;*/
		margin:0 auto;
	}
	.form-area{
		margin:15px 25px;
	}
	.category, .title, .writer {
		display:inline-block;
		width:120px;
	}
  </style>
</head>
<body>
	<!-- 여기 헤더 추가할것 -->
	<%@include file="../common/header/header.jsp" %>
	<%@include file="subMenubar.jsp" %>
	<br>
	<div class="content">
	<p align="right" style="font-size:10px; padding-right: 25px; padding-top: 15px;">개인정보취급방침에 따라 최근 5년간의 내역이 제공됩니다.</p>
		<div id="sub-title"><span style="font-size: 15px">게시판 작성</span></div>
		<!-- 뒤로가기 glyphicon 추가하기 -->
		
		<br><br>
		
		<div class="content-area">
			<div class="form-area">
			<!-- 완성 후 action태그 속성값 insert.bo로 변경하기 -->
				<form action="<%=request.getContextPath() %>/insert.bo" method="post">
					<label for="title">제목</label>&nbsp;&nbsp;
					<input type="text" class="form-control title" id="title" style="width:350px" name="title">&nbsp;
					<br><br>
					<label for="category">분류</label>&nbsp;&nbsp;
					<select class="form-control category" id="category" name="category"><!-- 분류 뭐뭐있는지 정하기 -->
						<option value="C1">가입인사</option>
						<option value="C2">공지</option>
						<option value="C3">일반</option>
					</select>&nbsp;&nbsp;
					<label for="writer">작성자</label>&nbsp;&nbsp;
					<input type="text" class="form-control writer" value="<%=loginUser.getUserName() %>" readonly>&nbsp;&nbsp;
					<label for="date-written">작성일</label>&nbsp;&nbsp;
					<input type="date" id="currentDate" readonly><br><br>
					<textarea class="form-control" cols="120" rows="20" style="resize:none;" name="content"></textarea>
					<br><br>
					<label for="attachment">파일 첨부</label>&nbsp;<!-- 파일 첨부하는 로직 추가하기 -->
					<input type="file" class="attachment" id="attachment" name="attachment">
					<br><br>
					<input type="hidden" name="groupCode" value=""><!-- 그룹코드 받아오는 로직 추가하기 -->
					<input type="hidden" name="writerCode" value=" name="<%=loginUser.getMemberCode() %>">
					<button class="btn btn-primary" onclick="submit();">작성하기</button>
					<button class="btn btn-dark" onclick="reset();">취소</button>
				</form>
			</div>
			<script>
  				document.getElementById('currentDate').value = new Date().toISOString().substring(0, 10);
			</script>
			
		
		
		</div>
	</div>
		<%@include file="../common/footer/footer.jsp" %>
</body>
</html>