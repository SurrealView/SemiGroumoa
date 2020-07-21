<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
#QNA {
	text-align: center;
	align: center;
	border-bottom: 1px solid black;
	width: 250px;
}

#qwer {
	text-align: center;
	align: center;
	
}

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
	<div id="qwer">
		<table border="1">
			<tr>
				<td>자주하는 질문(99)</td>
				<td>회원(20)</td>
				<td>모임신청(15)</td>
				<td>모임개설(17)</td>
				<td>결제(9)</td>
			</tr>
			<tr>
				<td>환불(6)</td>
				<td>정산(7)</td>
				<td>플레이스(7)</td>
				<td>광고제휴(5)</td>
				<td>기타(5)</td>
			</tr>
		</table>
	</div>

	<div id="QNA">
		자주하는 질문</div>
	<div class="content">
		<br> <br>
		<div class="table-div">
			<table class="table table-striped">
				<tbody>
					<tr>
						<td></td>
						<td>회원</td>
						<td>회원가입의 조건이 있나요?</td>
					</tr>
					<tr>
						<td><a href="#">2</a></td>
						<td>회원</td>
						<td>비밀번호를 잃어버렸습니다.</td>
					</tr>
					<tr>
						<td><a href="#">3</a></td>
						<td>회원</td>
						<td>가입 아이디(이메일)을 잊어버렸습니다.</td>
					</tr>
					<tr>
						<td><a href="#">4</a></td>
						<td>회원</td>
						<td>가입 이름,아이디(이메일)을 변경하고 싶어요.</td>
					</tr>
					<tr>
						<td><a href="#">5</a></td>
						<td>회원</td>
						<td>회원정보 수정은 어디에서 하나요?</td>
					</tr>
					<tr>
						<td><a href="#">6</a></td>
						<td>회원</td>
						<td>이메일 인증을 반드시 해야 하나요?</td>
					</tr>
					<tr>
						<td><a href="#">7</a></td>
						<td>회원</td>
						<td>그루모아에서 발송되는 메일이 오지 않아요.</td>
					</tr>
					<tr>
						<td><a href="#">8</a></td>
						<td>회원</td>
						<td>알림메일이나 문자를 수신거부하고 싶어요.</td>
					</tr>
					<tr>
						<td><a href="#">9</a></td>
						<td>회원</td>
						<td>SNS(카카오,네이버,애플,페이스북,구글,트위터)계정으로 로그인은 어떻게 하나요?</td>
					</tr>
					<tr>
						<td><a href="#">10</a></td>
						<td>회원</td>
						<td>SNS(카카오,네이버,애플,페이스북,구글,트위터)연동해제는 어떻게 하나요?</td>
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