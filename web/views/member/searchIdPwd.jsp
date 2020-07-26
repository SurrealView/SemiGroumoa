<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--  <link rel="stylesheet" href="https://static.onoffmix.com/css/common/pc/common-pc.css">
 <link rel="stylesheet" href="https://static.onoffmix.com/css/pc/account/join.css">-->
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
 <style>
 	.content {
 		margin: 0 auto;
 		width:950px;
 		height: 1000px;
 		border:1px solid black;
 		padding: 25px;
 	}
 	.form-control {
 		display:inline-block;
 		width: 330px;
 	}
 </style>
</head>
<body>
	 <div class="content">
	 	<div class="subContent">
	 	<h3 align="center">아이디 찾기</h3>
	 		<br>
	 		<label for="name">이름 입력 : </label>
	 		<input type="text" name="name" class="form-control" id="name">
	 		<br><br>
	 		<label for="">전화번호 입력 : </label>
	 		<select name="phoneHead" class="form-control" style="width:100px;" id="phoneHead">
	 				 <option value="010" >010</option>
                     <option value="011" >011</option>
                     <option value="016" >016</option>
                     <option value="017" >017</option>
                     <option value="018" >018</option>
                     <option value="019" >019</option>
	 			</select>
	 			-
	 			<input type="tel" name="tel1" id="tel1" class="form-control" style="width:100px;">
	 			-
	 			<input type="tel" name="tel2" id="tel2" class="form-control" style="width:100px;">
	 			<br><br>
	 			<button id="searchId">아이디 찾기</button>
	 			<br><br><br><br><br><br>
	 		<h3 align="center">비밀번호 찾기</h3>
	 		<br>
	 		<label for="email">이메일(아이디)</label>
	 		<input type="email" class="form-control" name="email" id="email" placeholder="이메일 주소 입력">
	 		<br><br>
	 		<button id="searchPwd">비밀번호 찾기</button>
	 	</div>
		
	</div>
	
	<script>
		$(function(){
			$("#searchId").click(function(){
				
				var name = $("#name").val();
				var phoneHead = $("#phoneHead").val();
				var tel1 = $("#tel1").val();
				var tel2 = $("#tel2").val();
				
				$.ajax({
					url: "<%=request.getContextPath()%>/searchId.me",
					type: "post",
					data: {name : name,
						   phoneHead : phoneHead,
						   tel1 : tel1,
						   tel2 : tel2
					},
					success: function(data) {
						if(data == null) {
	   						  alert("입력하신 정보와 일치하는 아이디가 없습니다.");
	   					  } else {
	   						  alert("당신의 아이디는 : " + data + "입니다.");
	   					  }
					},
					 error: function(data) {
	   					  console.log("실패!");
	   				  }
					
				});
			});
			
			$("#searchPwd").click(function(){
				var email = $("#email").val();
				
				$.ajax({
					url: "<%=request.getContextPath()%>/searchPwd.me",
					type:"post",
					data: {email: email},
					success: function(data) {
						alert(data);
					},
					error: function(data) {
						console.log("실패");
					}
				});
			});
			
			
			
		});
	</script>
	 
</body>
</html>