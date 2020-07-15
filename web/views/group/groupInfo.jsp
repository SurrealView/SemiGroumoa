<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Groumoa</title>
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
	table{
		position:absolute;
		left:270px;
		width:980px;
		border-left:hidden;
	}
	
	table tr td {
		padding-left:20px;
		padding-top:20px;
		padding-bottom:20px;
	}
	
	#groupIn {
		height:200px;
		width:350px;
		resize:none;
		padding-left:10px;
	}
	
	#thumb{
		height:150px;
		width:200px;
		padding-left:10px;
	}
	
	#rule {
		width:600px;
		height:300px;
	}
	
	.profile {
		text-aling:center;
	}
	
	.gong {
		padding-left:100px;
		display:inline-block;
		float:left;
	}
	
	.nick{
		padding-left:30px;
		display:inline-block;
		float:left;
	}
	.form-control {
		display:inline-block;
		width:200px;
	}
	
	#deleteBtn {
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
  		margin-top:1050px;
    }
        
    #cancelBtn {
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
	
</style>
</head>
<body>
	<%@include file="subMenubar.jsp" %>
	<div class="content">
		<p align="right" style="font-size:10px; padding-right: 25px; padding-top: 15px;">개인정보취급방침에 따라 최근 5년간의 내역이 제공됩니다.</p>
		<div id="sub-title"><span style="font-size: 15px">기본정보</span></div>
		<div class="tab" id="tab">
			<div class="item active" id="board"><a href="#">기본정보</a></div>
		</div>
		
		<br><br>
     <div class="wrapper">
     <form>
	  <table border="1">
        <tr>
            <td colspan="12" height="50px" style="border-right:hidden;">동호회주소
            &nbsp;<input type="text" style="width:350px" class="form-control"></td>
        </tr>
        <tr>
            <td colspan="12" height="50px" style="border-right:hidden;">동호회이름
            &nbsp;<input type="text" style="width:350px" class="form-control"></td>
        </tr>
        <tr>
            <td rowspan="2" height="450px" style="padding-left:60px;">동호회 프로필</td>
            <td colspan="8" height="200px" style="border-right:hidden;"><label style="float:left">썸네일 설정</label>
            &nbsp;&nbsp;<input type="text" id="thumb" readonly style="float:left; margin-left:10px;">
            <input type="submit" value="파일" id="subBtn" style="float:left; margin-left:10px;"></td>
        </tr>
        <tr>
            <td colspan="8" height="250px" style="border-right:hidden;"><label style="float:left">동호회 소개</label>
            &nbsp;&nbsp;<textarea id="groupIn"></textarea></td>
        </tr>
        <tr>
            <td colspan="2" height="100px" style="border-right:hidden;"></td>
            <td colspan="2" style="border-right:hidden;">동호회 공개 여부<br>
                <input type="radio" value="open" id="open" name="group" checked>
                <label for="open">공개</label>
                <input type="radio" value="secret" id="secret" name="group">
                <label for="secret">비공개</label>
            </td>
            <td colspan="2" style="border-right:hidden;">닉네임 사용 설정<br>
                <input type="radio" value="open" id="open" name="nick" checked>
                <label for="open">공개</label>
                <input type="radio" value="secret" id="secret" name="nick">
                <label for="secret">비공개</label>
            </td>
            <td colspan="2" style="border-right:hidden;"></td>
            <td colspan="2" style="border-right:hidden;"></td>
           	<td colspan="2" height="100px" style="border-right:hidden;">
            </td>
            
        </tr>
        <tr>
            <td rowspan="12" colspan="20" style="border-right:hidden;"><label style="float:left;">우리 동호회 회칙 </label>&nbsp;&nbsp;<textarea id="rule"></textarea></td>
        </tr>
        </table>
          <br>
          <br>
            <input type="submit" id="deleteBtn" value="확인">
            <input type="button" id="cancelBtn" value="취소">
        </form>
     </div>
</div>
</body>
</html>