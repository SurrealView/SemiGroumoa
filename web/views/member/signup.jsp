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
	 	<h1 align="center">회원가입</h1>
	 		<br>
	 		<!-- 완성후 action 태그 insert.me로 바꾸기 -->
	 		<form action="<%=request.getContextPath() %>/insert.me" method="post">
	 			<label for="email">이메일(아이디)</label>
	 			<input type="email" class="form-control" name="email" id="email" placeholder="이메일 주소 입력">
	 			<br><br>
	 			<label for="password">비밀번호 </label>
	 			<input type="password" class="form-control" name="userPwd" id="password" placeholder="비밀번호 입력(최소 8자 이상)">
	 			<br><br>
	 			<label for="password2">비밀번호 </label>
	 			<input type="password" class="form-control" name="userPwd2" id="password2" placeholder="위의 비밀번호를 다시 입력해 주세요">
	 			<br><br>
	 			<label for="userName">이름</label>
	 			<input type="text" class="form-control" name="userName" id="userName" placeholder="이름 입력(최소 2자 이상)">
	 			<br><br>
	 			<label for="gender">성별</label>
	 			<label for="male">남</label>
	 			<input type="radio" class="" name="gender" id="male" value="M">
	 			<label for="female">여</label>
	 			<input type="radio" class="" name="gender" id="female" value="F">
	 			<br><br>
	 			<label for="">휴대번호</label>
	 			<select name="phoneHead" class="form-control" style="width:100px;">
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
	 			<label for="birthDate">생년월일(예: 19940906)</label>
                <input type="text" id="birthDate" class="form-control birthDate" name="birthDate">
                <br><br>
	 			<label for="">주소</label>
	 			<select class="form-control" name="rnCode">
	 				<option value="R0001">서울시 동작구</option>
	 				<option value="R0002">서울시 강동구</option>
	 				<option value="R0003">서울시 강서구</option>
	 				<option value="R0004">서울시 강북구</option>
	 				<option value="R0005">서울시 관악구</option>
	 				<option value="R0006">서울시 광진구</option>
	 				<option value="R0007">서울시 구로구</option>
	 				<option value="R0008">서울시 금천구</option>
	 				<option value="R0009">서울시 노원구</option>
	 				<option value="R0010">서울시 동대문구</option>
	 				<option value="R0011">서울시 도봉구</option>
	 				<option value="R0012">서울시 동작구</option>
	 				<option value="R0013">서울시 마포구</option>
	 				<option value="R0014">서울시 서대문구</option>
	 				<option value="R0015">서울시 성동구</option>
	 				<option value="R0016">서울시 성북구</option>
	 				<option value="R0017">서울시 서초구</option>
	 				<option value="R0018">서울시 송파구</option>
	 				<option value="R0019">서울시 영등포구</option>
	 				<option value="R0020">서울시 용산구</option>
	 				<option value="R0021">서울시 양천구</option>
	 				<option value="R0022">서울시 은평구</option>
	 				<option value="R0023">서울시 송로구</option>
	 				<option value="R0024">서울시 중구</option>
	 				<option value="R0025">서울시 중랑구</option>
	 			</select>
	 			<input type="text" id="address" class="form-control" name="address" placeholder="상세 주소 입력" style="width:350px;">
	 			<br><br>
	 			<label for="interest">관심 분야</label>
	 			<br>
	 			<input type="checkbox" id="I01" name="interest" value="I01">
	 			<label for="I01">문화/공연</label>
	 			<input type="checkbox" id="I02" name="interest" value="I02">
	 			<label for="I02">게임/오락</label>
	 			<input type="checkbox" id="I03" name="interest" value="I03">
	 			<label for="I03">아웃도어/여행</label>
	 			<input type="checkbox" id="I04" name="interest" value="I04">
	 			<label for="I04">운동/스포츠</label>
	 			<input type="checkbox" id="I05" name="interest" value="I05">
	 			<label for="I05">인문학/책/글</label>
	 			<input type="checkbox" id="I06" name="interest" value="I06">
	 			<label for="I06">업종/직무</label>
	 			<input type="checkbox" id="I07" name="interest" value="I07">
	 			<label for="I07">외국/언어</label>
	 			<input type="checkbox" id="I08" name="interest" value="I08">
	 			<label for="I08">음악/악기</label>
	 			<input type="checkbox" id="I09" name="interest" value="I09">
	 			<label for="I09">패션/뷰티</label>
	 			<input type="checkbox" id="I10" name="interest" value="I10">
	 			<label for="I10">공예/만들기</label>
	 			<input type="checkbox" id="I11" name="interest" value="I11">
	 			<label for="I11">댄스/무용</label>
	 			<input type="checkbox" id="I12" name="interest" value="I12">
	 			<label for="I12">사교/인맥</label>
	 			<input type="checkbox" id="I13" name="interest" value="I13">
	 			<label for="I13">사진</label>
	 			<input type="checkbox" id="I14" name="interest" value="I14">
	 			<label for="I14">차/오토바이</label>
	 			<input type="checkbox" id="I15" name="interest" value="I15">
	 			<label for="I15">요리/제조</label>
	 			<input type="checkbox" id="I16" name="interest" value="I16">
	 			<label for="I16">가족/결혼</label>
	 			<input type="checkbox" id="I17" name="interest" value="I17">
	 			<label for="I17">반려동물</label>
	 			<input type="checkbox" id="I18" name="interest" value="I18">
	 			<label for="I18">봉사활동</label>
	 			<input type="checkbox" id="I19" name="interest" value="I19">
	 			<label for="I19">자유주제</label>
	 			<br>
	 			<input type="submit" value="가입하기">
	 		</form>
	 	</div>
	
	</div>
	 
</body>
</html>