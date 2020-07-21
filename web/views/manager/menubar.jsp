<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/groumoa/resources/css/menubar_style.css">
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
.pageMain:target .smenu {
	max-height: 15em;
}
.middle {
	list-style:none;
}
.smenu a:hover {
	background:#2f323a;
	color:darkred;
}


</style>
<body>

<div class="header">
    <b>Grou<span>moa</span></b>
    <button>로그아웃</button>
</div>
<div id="side-nav" class="side-nav">
  <img src="/groumoa/resources/image/logo_groumoa.png" width="50%" id="logo">
 	<div class="middle">
 		<div class="menu">
 			<li class="pageMain" id="messages">
 				<a href="#messages" class="list"><img src="/groumoa/resources/image/menubar_home.png" width="10%">&nbsp;&nbsp;메인페이지</a>
<!--  				<div class="smenu">
 					<a href="#">공지</a>
 					<a href="#">공지2</a>
 				</div> -->
 			</li>
 			<li class="pageMain" id="settings">
 				<a href="#settings" class="list"><img src="/groumoa/resources/image/menubar_address.png" width="10%">&nbsp;&nbsp;회원관리</a>
 				<div class="smenu">
 					<a href="#">전체 사용자</a>
 					<a href="#">관리자</a>
 					<a href="#">모임장</a>
 					<a href="#">일반회원</a>
 				</div>
 			</li>
 			<li class="pageMain" id="items">
 				<a href="#items" class="list"><img src="/groumoa/resources/image/menubar_group.png" width="10%">&nbsp;&nbsp;동호회관리</a>
 				<div class="smenu">
 					<a href="#">전체 동호회</a>
 				</div>
 			</li>
 			<li class="pageMain" id="adver">
 				<a href="#adver" class="list"><img src="/groumoa/resources/image/menubar_won.png" width="10%">&nbsp;&nbsp;결제내역</a>
 				<div class="smenu">
 					<a href="#">얼마나</a>
 					<a href="#">광고</a>
 				</div>
 			</li>
 			<li class="pageMain" id="ques">
 				<a href="#ques" class="list"><img src="/groumoa/resources/image/menubar_question.png" width="10%">&nbsp;&nbsp;문의내역</a>
 				<div class="smenu">
 					<a href="#">자주하는질문</a>
 					<a href="#">1:1질문</a>
 				</div>
 			</li>
 		</div>
 	</div>
</div>
</html> 