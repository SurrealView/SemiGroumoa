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
#QNA{
	text-align: center;
	align: center;
}
#qwer {
	text-align: center;
	align: center;
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
	<br><br><br><br>
	<div id="QNA" style="float: none; border-bottom: 1px solid black; width: 200px; text-align: left;">
	자주하는 질문
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
	
</body>
</html>