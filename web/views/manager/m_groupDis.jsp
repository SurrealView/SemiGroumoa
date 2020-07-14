<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="menubar.jsp" %>
<title>Groumoa</title>
<style>
	#jeje {
		width:1000px;
		height:600px;
		position:absolute;
		top: 90px;
		left: 230px;
		background-color: white;
	}
	
	#title {
		font-weight: bold;
		font-size:20px;
		position:absolute;
		top:20px;
		left:20px;
	}
	
	#list  {
		position:absolute;
		top : 20px;
		left:300px;
		padding-top:20px;
		width: 550px;
	}
	
	.item {
		margin-top:30px;
		padding-left: 30px;
		padding-bottom:10px;
	}
	
	#jejeBtn {
		position: absolute;
		top: 600px;
		left:650px;
		border: none;
  		color: white;
  		padding: 2px 8px;
  		text-align: center;
  		text-decoration: none;
  		display: inline-block;
  		font-size: 16px;
  		margin: 4px 2px;
  		transition-duration: 0.4s;
  		cursor: pointer;
  		background-color: white;
  		color: black;
  		border: 2px solid #555555;
	}
	
	#canBtn {
		position:absolute;
		top:600px;
		left: 750px;
		border: none;
  		color: white;
  		padding: 2px 8px;
  		text-align: center;
  		text-decoration: none;
  		display: inline-block;
  		font-size: 16px;
  		margin: 4px 2px;
  		transition-duration: 0.4s;
  		cursor: pointer;
  		background-color: white;
  		color: black;
  		border: 2px solid #555555;
	}
	
	#canBtn:hover {
  		background-color: #555555;
  		color: white;
	}
	
	#jejeBtn:hover {
  		background-color: #555555;
  		color: white;
	}
	
	input[type=text] {
  		width: 100%;
  		padding: 12px 20px;
  		margin: 8px 0;
  		box-sizing: border-box;
 		border: none;
  		border-bottom: 2px solid black;
	}

</style>
</head>
<body>
  <form>
	<div class="jejelist" id="jeje"><label id="title">모임 해산</label>
		<div class="round" id="round" style="border-radius: 50%; height: 200px; width: 200px; background-color: gray; position: absolute; top: 80px; left: 50px;"></div>
		<div class="listup" id="list">
			<div class="item" id="item1"><label>동호회명</label>&nbsp;&nbsp;<input type="text"></div>
			<div class="item" id="item2"><label>해산 사유</label>&nbsp;&nbsp;<input type="text"></div>
			<div class="item" id="item4"><label style="float:left">해산 사유 상세</label>&nbsp;&nbsp;<textarea style="width:350px; height:150px; resize:none;"></textarea></div>
		</div>
	</div>
		<button id="jejeBtn">해산하기</button><button id="canBtn">취소하기</button>
	</form>
</body>
</html>