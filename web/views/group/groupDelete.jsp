<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
	.content{
		width:1000px;
		height:1500px;
		margin:0 auto;
		border: 1px solid #e2d8d8;
		border-radius: 10px;
	}
	.tab{
		width:950px;
		height:50px;
		margin-top: 0px;
		margin-left: 25px;
		border-bottom:1px solid #e2d8d8;
	}
	.item{
		display: inline-block;
		float:left;
		font-size: 12px;
		font-weight:bold;
		text-align:center;
		width:100px;
		height:20px;
		border: 1px solid #e2d8d8;
		margin-top: 30px;
		background-color:rgba(235, 235, 235, 0.493);
	}
	#sub-title{
		margin-left: 25px;
	}
	.item a {
			text-decoration: none;
			color: black;
			
	}
	.active {
		border-bottom:1px solid white;
	}
	.active a{
		color:rgb(70, 107, 228);
	}
	.wrapper {
        margin: auto;
        height: auto;
        width: 1000px;
       /* display: table-cell;
       vertical-align: middle; */
            
        display: block;
        margin: 0px auto;
    }
	#first {
        width: 800px;
        margin: 0 auto;
        position: absolute;
        top: 210px;
    }

    #delete {
        position: absolute;
        top: 173px;
        left: 900px;
    }

    #menu {
        position: absolute;
        top: 230px;
        left: 500px;
    }
    #incontent {
        margin-left: 20px;
    }
        
    .deleteBtn {
        background-color: #f44336;
        border: none;
  		color: white;
 		padding: 10px 20px;
  		text-align: center;
  		text-decoration: none;
  		display: inline-block;
  		font-size: 16px;
 		margin: 8px 10px;
  		cursor: pointer;
  		margin-left:350px;
    }
        
    .cancelBtn {
        background-color: #f44336;
        border: none;
  		color: white;
 		padding: 10px 20px;
  		text-align: center;
  		text-decoration: none;
  		display: inline-block;
  		font-size: 16px;
 		margin: 4px 10px;
  		cursor: pointer;
  		margin-left:20px;
  		
    }
    .reason {
    	padding-top:20px;
    	padding-left:10px;
    }
    .date {
    	padding-left:10px;
    }
    .detail {
    	padding-left:10px;
    }
    input[type=text] {
  		width: 95%;
  		padding: 12px 20px;
  		margin: 8px 0;
  		box-sizing: border-box;
  		border: none;
  		border-bottom: 2px solid red;
    	padding-left:10px;
	}
</style>
</head>
<body>
	<!-- 여기 헤더 추가할것 -->
	<%@include file="subMenubar.jsp" %>
	<div class="content">
		<p align="right" style="font-size:10px; padding-right: 25px; padding-top: 15px;">개인정보취급방침에 따라 최근 5년간의 내역이 제공됩니다.</p>
		<div id="sub-title"><span style="font-size: 15px">모임해산</span></div>
		<div class="tab" id="tab">
			<div class="item active" id="board"><a href="#">모임해산</a></div>
		</div>
		
		<br><br><!-- 게시판 관리일경우 -->
		<!-- <div class="table-div">
			<h2 align="center">모임해산</h2> -->

    <div class="blank"><strong>
    <div class="wrapper">
            <form id="incontent">
            <div class="reason"><label>해산 사유</label></div>
            <input type="text" id="fname" name="fname">
            <br>
            <br>
            <div class="date"><label>해산 일시</label></div>
            <input type="text" id="fname" name="fname">
            <br>
            <br>
            <div class="detail"><label style="float: left;">해산 사유 상세</label></div>&nbsp;
            <textarea style="width: 600px; height: 400px; resize:none;"></textarea>
            <br>
            <br>
            <button class="deleteBtn">해산</button>
            <button class="cancelBtn">취소</button>
            </div>
            </form>
        </div>
    </div>
</div>
		
</body>
</html>