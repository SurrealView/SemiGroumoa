<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>탈퇴 약관</title>
<style>
.menu {
	background: white;
	color: black;
	text-align: center;
	display: table-cell;
	vertical-align: middle;
	width: 150px;
	height: 50px;
}

.wrap {
	background: white;
	width: 100%;
	height: 50px;
}

.menu:hover {
	background: #461212;
	color: white;
	font-weight: bold;
	cursor: pointer;
}
</style>
</head>
<body>
	<h2>회원탈퇴</h2>
	<div class="wrap">
		<hr noshade="noshade" size="1px" color="black">
		<br>
		<br>
		<br>
		<br>
		<p align="center">
			그루모아 탈퇴 신청에 앞서 아래의 사항을 반드시 확인하시기 바랍니다. <br>
			<br> 1. 해당 이메일로 재가입 불가 <br>
			<br> 회원탈퇴를 신청하시면 해당 이메일은 즉시 탈퇴 처리 되며, 삭제 후 해당 이메일로 회원가입이 불가능합니다.
			<br>
			<br> 이는 가입과 탈퇴의 반복을 막고, 선량한 이용자들에게 피해를 끼지는 행위를 방지하기 위한 조치 이오니 양해
			바랍니다. <br>
			<br> 2. 회원정보 및 회원제 서비스의 정보 삭제 <br>
			<br> - 결제 관련 정보 <br>-게시판 : 타인과 함께 사용하는 공적인 영역의 게시물과 댓글, 의견
			등 <br>(게시물 등의 삭제를 원하시는 경우에는 반드시 삭제하신 후, 탈퇴를 신청하시기 바랍니다.) <br>
			<br> 위의 해당되는 내용은 탈퇴 후에도 삭제되지 않습니다. <br>
			<br> 3. 탈퇴 이유 <br>
			<input type="radio" name="reason" id="c1"
				data-parsley-multiple="reason">플랫폼 구성(프로세스/인터페이스 등) 불만 <br>
			<input type="radio" name="reason" id="c2"
				data-parsley-multiple="reason">잦은 홈페이지 기능 장애 <br>
			<input type="radio" name="reason" id="c3"
				data-parsley-multiple="reason">고객 응대 불만 <br>
			<input type="radio" name="reason" id="c4"
				data-parsley-multiple="reason">동호회 안 갈등 <br>
			<input type="radio" name="reason" id="c5"
				data-parsley-multiple="reason">가격 불만 <br>
			<input type="radio" name="reason" id="c6"
				data-parsley-multiple="reason">참여할 동호회가 별로 없다. <br>
			<br> 4. 서비스 개선을 위해 바꾸어야 할 것은? <br>
			<textarea cols="60" rows="10" style="resize: none;"></textarea>
			<br>회원탈퇴 하시겠습니까?
		</p>

	</div>

</body>
</html>
