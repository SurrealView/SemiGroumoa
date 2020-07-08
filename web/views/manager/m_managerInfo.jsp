<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/menubar_style.css">
<%@ include file="menubar.jsp" %>
<style>
  .section {
    width: 930px;
    height: 680px;
    background-color : white;
    top: 40px;
    left: 160px;
    position: fixed;
    margin-left: 100px;
    margin-top: 20px;
}

.aside {
    position: fixed;
    background-color: white;
    width: 260px;
    height: 340px;
    margin-left: 1190px;
    margin-top: 50px;
}
.aside2 {
    position: fixed;
    background-color: white;
    width: 260px;
    height: 338px;
    margin-left: 1190px;
    margin-top: 395px;
}
#label {
    font-weight: bold;
    position: absolute;
}
#label2 {
    position: absolute;
    color: gray;
}
</style>
<body>

<div class="header">
    <button>미리보기</button>
    <button>로그아웃</button>
</div>
<div id="side-nav" class="side-nav">
  <img src="image/logo_groumoa2.png" width="60%" height="20%" id="logo">
  <a href="#">메인페이지</a>
  <a href="#">공지사항</a>
  <a href="#">회원관리</a>
  <a href="#">동호회관리</a>
  <a href="#">결제내역</a>
  <a href="#">문의하기</a>
</div>
<div class="section"><label id="label" style="top: 20px; left: 20px;">편집 및 추가</label> 
   <img src="image/back.png" style="position: absolute; top: 20px; left: 880px;" width="3%" height="3%">
   <div style="border-radius: 50%; height: 200px; width: 200px; background-color: gray; position: absolute; top: 80px; left: 350px;"></div>
   <label id="label" style="top:300px; left: 20px; font-size: 20px;" >회원정보</label>
   <label id="label2" style="top:350px; left: 20px;">닉네임 : </label>
   <label id="label2" style="top:430px; left: 20px;">계정 : </label>
   <label id="label2" style="top:510px; left: 20px;">비밀번호(변경시에만 입력) : </label>
   <label id="label2" style="top:590px; left: 20px;">구분 : </label>
</div>
<div class="aside"><label id="label" style="top: 15px; left: 15px;">활동정보</label>
    <label id="label2" style="top: 50px; left: 15px;">가입일</label>
    <label id="label2" style="top: 50px; left:130px;">로그인</label>
    <label id="label" style="top: 150px; left:15px;">작성</label>
    <label id="label2" style="top: 190px; left:15px;">글</label>
    <label id="label2" style="top: 230px; left:15px;">댓글</label>
    <label id="label2" style="top: 270px; left:15px;">문의</label>
    <label id="label" style="top:150px; left:130px;">제재횟수</label>
</div>
<div class="aside2"><label id="label" style="top: 15px; left: 15px;">가입한 모임</label>
    <label id="label2" style="top: 50px; left: 15px;">동호회명</label>
    <label id="label2" style="top: 50px; left: 130px;">직책</label>
</div>
</body>
</html> 