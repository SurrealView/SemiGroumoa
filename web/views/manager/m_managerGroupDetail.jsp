<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="menubar.jsp" %>
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
	
	.managerList {
		position:absolute;
		top :260px;
		margin-left:20px;
	}
	
	.list {
		margin-top:37px;
	}
	
	.fname {
		position:absolute;
		left:100px;
		width:150px;
	}
	
	#list6 {
		position:absolute;
		top:60px;
		left:20px;
	}
	
	#list7 {
		position:absolute;
		top:60px;
		left:200px;
	}
	
	#list9 {
		position:absolute;
		top:210px;
		left:20px;
	}
	
	#list10{
		position:absolute;
		top:250px;
		left:20px;
	}
	
	#list11 {
		position:absolute;
		top:160px;
		left:200px;
		font-size:20px;
		font-weight:bold;
	}
	
	#list12 {
		 top: 60px; 
		 left: 20px;
		 position:absolute;
	}
	
	#list13 {
		 top: 140px; 
		 left: 20px;
		 position:absolute;
	}
	#list14 {
		top: 60px; 
		left: 200px;
		position:absolute;
	}
	
</style>
</head>
<body>
	<div id="manager">
		<label style="font-weight:bold; position:absolute; top: 20px; left: 20px; font-size:20px;">동호회 정보</label>
   		<div style="border-radius: 50%; height: 200px; width: 200px; background-color: gray; position: absolute; top: 50px; left: 250px;"></div>
   		<div class="managerList" id="managerlistup">
   		<div class="list" id="list1"><label>동호회명  </label>&nbsp;&nbsp;&nbsp;
   		<input type="text"  class ="form-control" id="fname" name="fname"></div>
   		<div class="list" id="list2"><label>모임장명  </label>&nbsp;&nbsp;&nbsp;
   		<input type="text" class ="form-control" id="fname" name="fname"></div>
   		<div class="list" id="list3"><label>인원  </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   		<input type="text" class ="form-control" id="fname" name="fname"></div>
   		<div class="list" id="list4"><label>관심사 </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   		<input type="text" class ="form-control" id="fname" name="fname"></div>
   		<div class="list" id="list5"><label>상세 관심사  </label>
   		<input type="text" class ="form-control" id="fname" name="fname"></div>
   		</div>
	</div>
	<div id="activity">
		<label style="font-weight:bold; position:absolute; top:20px; left: 20px; font-size:20px;">상세정보</label>
		<div id="list1">
		<div class="activityList" id="list6"><label>개설일</label><br>
		<input type="text" id="detail"></div>
    	<div class="activityList" id="list7"><label>결제 금액</label>
    	<input type="text" id="detail"></div>
    	</div>
   		<label id="write" style=" position:absolute; top:160px; left:20px; font-weight:bold; font-size:20px;">작성</label>
    	<div id="list2">
  	    <div class="activityList2" id="list9"><label>게시글</label>
  	    <input type="text" id="detail"></div>
        <div class="activityList2" id="list10"><label>댓글</label>
        <input type="text" id="detail"></div>
        <div class="activityList2" id="list11"><label>해산여부</label>
        <input type="text" id="detail"></div>
        </div>
	</div>
	<div id="group">
		<label style="font-weight:bold; position:absolute; top:20px; left:20px; font-size:20px;">모임장 정보</label>
		<div class="groupList" id="list12"><label>이름</label><br>
		<input type="text" id="detail"></div>
		<div class="groupList" id="list13"><label>계정</label><br>
		<input type="text" id="detail"></div>
   		<div class="groupList" id="list14"><label>연락처</label>
   		<input type="text" id="detail"></div>
	</div>
</body>
</html>