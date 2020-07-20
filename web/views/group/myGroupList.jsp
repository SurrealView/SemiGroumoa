<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내가 가입한 동호회</title>
<style>
    .nav{
        width: 600px;
        margin: 0 auto;
    }
    .menu{
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
    #pic {
        
        width: 350px;
        height: 200px;
        display: inline-block;
        text-align: center;
    }
    .mygroup {
        text-align: center;
        margin-left: auto;
        margin-right: auto;
        margin-top: 50px;
    }
    </style>
</head>
<body>
	<h2>마이 동호회 리스트</h2>
	<hr noshade="noshade" size="1px" color="black">

	<div class="mygroup">
		<div id="pic">
			<!-- <img src="image/Ellipse 17.png"> -->
			<div
				style="float: left; border-bottom: 1px solid black; width: 200px; text-align: center;">
				<button style="float:right;">페이지 방문</button>
				<b>푸른 뱃고동</b> <br>
			</div>
			<div style="float: none; width: 100px; text-align:left;">
				<br>낚시동호회 
				<br>모임장:김승열 
				<br>소개:낚시왕
			</div>
		</div>
		<div id="pic">
			<!-- <img src="image/Ellipse 18.png"> -->
			<div
				style="float: left; border-bottom: 1px solid black; width: 200px; text-align: center;">
				<button style="float:right;">페이지 방문</button>
				<b>범호 축구단</b> <br>
			</div>
			<div style="float: none; width: 100px; text-align:left;">
				<br>축구동호회 
				<br>모임장:현상정 
				<br>소개:축구왕
			</div>
		</div>
		<div id="pic">
			<!-- <img src="image/Ellipse 19.png"> -->
			<div
				style="float: left; border-bottom: 1px solid black; width: 200px; text-align: center;">
				<button style="float:right;">페이지 방문</button>
				<b>운칠기삼</b> <br>
			</div>
			<div style="float: none; width: 100px; text-align:left;">
				<br>낚시동호회 
				<br>모임장:김승열 
				<br>소개:낚시꾼
			</div>
		</div>
	</div>
</body>
</html>