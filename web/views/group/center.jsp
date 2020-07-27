<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객센터 메인</title>
<style>
.content {
	width: 500px;
	height: 150px;
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
#center1 { 
	border-bottom: 1px solid black;
	text-align: left;
	width: 500px;
	margin-left: auto;
	margin-right: auto;
	margin-top: 50px;
}
#table-div {
}

.ask{
	text-align: left;
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
	<div id="center1">고객센터 메인</div>
	<div class="content">
		<div class="table-div">
			<table class="table table-striped">
				<thead>
				</thead>
				<tbody>
				<tr>
					<td>모임신청</td>
					<td class="ask">모임과 관련된 문의는 어디서 할 수 있나요?</td>
				</tr>
				<tr>
					<td>회원</td>
					<td class="ask">비밀번호를 까먹었는데 어떻게 해야 하나요?</td>
				</tr>
				<tr>
					<td>결제</td>
					<td class="ask">결제가 되지 않는데 어떻게 해결해야 하나요?</td>
				</tr>
				<tr>
					<td>모임개설</td>
					<td class="ask">모임개설은 어디서 할 수 있나요?</td>
				</tr>
				<tr>
					<td>회원</td>
					<td class="ask">이메일을 변경하고 싶은데 어떻게 하면 되나요?</td>
				</tr>
				</tbody>
			
			</table>
		</div>
	</div>
	<br>
	<div id="center1">공지사항</div>
	<div class="content">
		<div class="table-div">
			<table class="table table-striped">
				<thead>
				</thead>
				<tbody>
				<tr>
					<td class="ask"><b>그루모아</b>와 함께하는 '모임 생활 속 거리두기'</td>
				</tr>
				<tr>
					<td class="ask">근로자의 날 휴무 안내</td>
				</tr>
				<tr>
					<td class="ask">[업데이트]'고객센터'개편안내</td>
				</tr>
				<tr>
					<td class="ask">[업데이트]'뉴스레터 구독'페이지 안내</td>
				</tr>
				<tr>
					<td class="ask">이벤트 페이지(초대/서평이벤트)일시 중지 안내</td>
				</tr>
				</tbody>
			
			</table>
		</div>
	</div>

</body>
</html>