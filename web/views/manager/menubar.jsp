<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../../resources/css/menubar_style.css">
<style>
  .section {
    width: 930px;
    height: 680px;
    background-color : #eaeaea;
    top: 40px;
    left: 160px;
    position: fixed;
    margin-left: 100px;
    margin-top: 20px;
}

.aside {
    position: fixed;
    background-color: black;
    width: 260px;
    height: 350px;
    margin-left: 1190px;
    margin-top: 50px;
}

.smenu {
	background: #2f323a;
	overflow:hidden;
	transition: max-height 0.3s;
	max-height:0;
}

.smenu a:hover:before{
	opacity:1;
}
.item:target .smenu {
	max-height: 10em;
}
.middle {
	list-style:none;
}

</style>
<body>

<div class="header">
    <b>Grou<span>moa</span></b>
    <button>로그아웃</button>
</div>
<div id="side-nav" class="side-nav">
  <img src="../../resources/image/logo_groumoa.png" width="50%" id="logo">
 	<div class="middle">
 		<div class="menu">
 			<li class="item" id="messages">
 				<a href="#messages" class="btn"><i class="fas fa-ballot"></i>메인페이지</a>
 				<div class="smenu">
 					<a href="#">공지</a>
 					<a href="#">공지2</a>
 				</div>
 			</li>
 			<li class="item" id="settings">
 				<a href="#settings" class="btn"><i class="fal fa-betamax"></i>회원관리</a>
 				<div class="smenu">
 					<a href="#">회원2</a>
 					<a href="#">결제내역</a>
 				</div>
 			</li>
 			<li class="item" id="items">
 				<a href="#items" class="btn"><i class="fal fa-betamax"></i>동호회관리</a>
 				<div class="smenu">
 					<a href="#">푸른뱃고동</a>
 					<a href="#">축구팀</a>
 				</div>
 			</li>
 			<li class="item" id="adver">
 				<a href="#adver" class="btn"><i class="fal fa-betamax"></i>결제내역</a>
 				<div class="smenu">
 					<a href="#">얼마나</a>
 					<a href="#">광고</a>
 				</div>
 			</li>
 			<li class="item" id="ques">
 				<a href="#ques" class="btn"><i class="fal fa-betamax"></i>문의내역</a>
 				<div class="smenu">
 					<a href="#">자주하는질문</a>
 					<a href="#">1:1질문</a>
 				</div>
 			</li>
 		</div>
 	</div>
</div>
</html> 