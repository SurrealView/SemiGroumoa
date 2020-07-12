<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../common/manager/menubar.jsp" %>
<title>Groumoa</title>
<style>
	#manager {
		height: 610px;
    	width: 750px;
    	position: fixed;
    	z-index: 1;
    	top: 90px;
   	 	left: 230px;
   		background-color: white;
    	overflow-x: hidden;
	}
	
	#activity {
		height: 350px;
		width: 400px;
		position: fixed;
		z-index: 1;
		top : 90px;
		left : 990px;
		background-color : white;
		overflow-x: hidden;
		
	}
	
	#group {
		height: 250px;
		width: 400px;
		position: fixed;
		z-index: 1;
		top : 450px;
		left : 990px;
		background-color : white;
		overflow-x: hidden;
	}
	
	#label2 {
		position: absolute;
	}
	#label {
		position: absolute;
		font-weight:bold;
		font-size: 20px;
	}
</style>
</head>
<body>
	<div id="manager">
		<label style="font-weight:bold; position:absolute; top: 20px; left: 20px; font-size:20px;">동호회 정보</label>
   		<div style="border-radius: 50%; height: 200px; width: 200px; background-color: gray; position: absolute; top: 50px; left: 250px;"></div>
   		<label id="label2" style="top:290px; left: 20px;">동호회명 : </label>
   		<label id="label2" style="top:350px; left: 20px;">모임장명 : </label>
   		<label id="label2" style="top:410px; left: 20px;">인원 : </label>
   		<label id="label2" style="top:470px; left: 20px;">관심사 : </label>
   		<label id="label2" style="top:530px; left: 20px;">상세 관심사 : </label>
	</div>
	<div id="activity">
		<label style="font-weight:bold; position:absolute; top:20px; left: 20px; font-size:20px;">상세정보</label>
		<label id="label2" style="top:60px; left:20px;">개설일</label>
    	<label id="label2" style="top:60px; left:200px;">결제 금액</label>
   		<label id="label" style="top:160px; left:20px;">작성</label>
  	    <label id="label2" style="top:210px; left:20px;">게시글</label>
        <label id="label2" style="top:250px; left:20px;">댓글</label>
        <label id="label" style="top:160px; left:200px;">해산여부</label>
	</div>
	<div id="group">
		<label style="font-weight:bold; position:absolute; top:20px; left:20px; font-size:20px;">모임장 정보</label>
		<label id="label2" style="top: 60px; left: 20px;">이름</label>
		<label id="label2" style="top: 140px; left: 20px;">계정</label>
   		<label id="label2" style="top: 60px; left: 200px;">연락처</label>
	</div>
</body>
</html>