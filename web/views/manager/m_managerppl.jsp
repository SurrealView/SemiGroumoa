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
    width: 240px;
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
    width: 950px;
    height: 41px;
    margin-left: 500px;
    margin-top: 51px;
}

.main {
    position: fixed;
    background-color: white;
    margin-left: 500px;
    margin-top: 105px;
    width: 950px;
    height: 625px;
}

#list button{
    width: 240px;
    height: 55px;
    background-color: rgba(0,0,0,0);
    border: 1px solid gray;
    font-weight: bold;
    text-align: left;
    padding-left: 30px;
}

#list button:hover {
    background-color: rgb(171, 27, 105);
}

#total {
    font-weight: bold;
    position: fixed;
    top: 130px;
    left: 550px;
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
<div class="section">
    <div id="list">
        <button>전체 사용자</button>
        <button>관리자</button>
        <button>모임장</button>
        <button>일반회원</button>
    </div>  
</div>
<div class="aside">
    <nav>
        <form class="search-form">
            <input type="image" src="image/search.png">
            <input type="text" placeholder="전체 사용자 검색">
        </form>
    </nav>
</div>
<div class="main">
    <label id="total">
    </label>
</div>
<div class="custom-control custom-checkbox">
    <input type="checkbox" id="jb-checkbox" class="custom-control-input">
    <label class="custom-control-label" for="jb-checkbox">Checkbox</label>
</div>
</body>
</html> 