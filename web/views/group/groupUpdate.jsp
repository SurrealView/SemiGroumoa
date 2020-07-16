<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.groumoa.group.model.vo.GroupVO" %>
<% GroupVO group = (GroupVO) request.getAttribute("group"); %>
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
  		margin-top:1200px;
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
    
    .interest {
    	margin-right:35px;
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
     <form id="updateForm">
	  <table border="1">
        <tr>
            <td colspan="12" height="50px" style="border-right:hidden; border-top:hidden;">동호회이름
            &nbsp;<input type="text" style="width:350px" class="form-control" name="name">
            <input type="hidden" name="groupCode"></td>
        </tr>
        <tr>
            <td colspan="12" height="50px" style="border-right:hidden;">동호회 활동 지역
            &nbsp;<input type="text" style="width:350px" class="form-control" name="rnCode">
            </td>
        </tr>
        <tr>
        	<td colspan="12" height="50px" style="border-right:hidden;">관심사
	 			<br>
	 			<br>
	 			
	 			<input type="checkbox" id="i1" name="interest" value="i1" onclick="doOpenCheck(this);">
	 			<label for="i1" class="interest">문화/공연</label>
	 			<input type="checkbox" id="i2" name="interest" value="i2" onclick="doOpenCheck(this);">
	 			<label for="i2" class="interest">게임/오락</label>
	 			<input type="checkbox" id="i3" name="interest" value="i3" onclick="doOpenCheck(this);">
	 			<label for="i3" class="interest">아웃도어/여행</label>
	 			<input type="checkbox" id="i4" name="interest" value="i4" onclick="doOpenCheck(this);">
	 			<label for="i4" class="interest">운동/스포츠</label>
	 			<input type="checkbox" id="i5" name="interest" value="i5" onclick="doOpenCheck(this);">
	 			<label for="i5" class="interest">인문학/책/글</label>
	 			<input type="checkbox" id="i6" name="interest" value="i6" onclick="doOpenCheck(this);">
	 			<label for="i6" class="interest">업종/직무</label>
	 			<input type="checkbox" id="i7" name="interest" value="i7" onclick="doOpenCheck(this);">
	 			<label for="i7" class="interest">외국/언어</label>
	 			<input type="checkbox" id="i8" name="interest" value="i8" onclick="doOpenCheck(this);">
	 			<label for="i8" class="interest">음악/악기</label>
	 			<input type="checkbox" id="i9" name="interest" value="i9" onclick="doOpenCheck(this);">
	 			<label for="i9" class="interest">패션/뷰티</label>
	 			<input type="checkbox" id="i10" name="interest" value="i10" onclick="doOpenCheck(this);">
	 			<label for="i10" class="interest">공예/만들기</label>&nbsp;&nbsp;&nbsp;
	 			<input type="checkbox" id="i11" name="interest" value="i11" onclick="doOpenCheck(this);">
	 			<label for="i11" class="interest">댄스/무용</label>&nbsp;&nbsp;&nbsp;&nbsp;
	 			<input type="checkbox" id="i12" name="interest" value="i12" onclick="doOpenCheck(this);">
	 			<label for="i12" class="interest">사교/인맥</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	 			<input type="checkbox" id="i13" name="interest" value="i13" onclick="doOpenCheck(this);">
	 			<label for="i13" class="interest">사진</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	 			<input type="checkbox" id="i14" name="interest" value="i14" onclick="doOpenCheck(this);">
	 			<label for="i14" class="interest">차/오토바이</label><br>
	 			<input type="checkbox" id="i15" name="interest" value="i15" onclick="doOpenCheck(this);">
	 			<label for="i15" class="interest">요리/제조</label>
	 			<input type="checkbox" id="i16" name="interest" value="i16" onclick="doOpenCheck(this);">
	 			<label for="i16" class="interest">가족/결혼</label>
	 			<input type="checkbox" id="i17" name="interest" value="i17" onclick="doOpenCheck(this);">
	 			<label for="i17" class="interest">반려동물</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	 			<input type="checkbox" id="i18" name="interest" value="i18" onclick="doOpenCheck(this);">
	 			<label for="i18" class="interest">봉사활동</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	 			<input type="checkbox" id="i19" name="interest" value="i19" onclick="doOpenCheck(this);">
	 			<label for="i19" class="interest">자유주제</label>
	 			
            </td>
        </tr>
        <tr>
            <td rowspan="2" height="450px" style="padding-left:60px;">동호회 프로필</td>
            <td colspan="8" height="200px" style="border-right:hidden;"><label style="float:left">썸네일 설정</label>
            &nbsp;&nbsp;<input type="text" id="thumb" readonly style="float:left; margin-left:10px;" name="thumbNail" value="<%=group.getThumbNail() %>">
            <input type="submit" value="파일" id="subBtn" style="float:left; margin-left:10px;"></td>
        </tr>
        <tr>
            <td colspan="8" height="250px" style="border-right:hidden;"><label style="float:left">동호회 소개</label>
            &nbsp;&nbsp;<textarea id="groupIn" name="description" value="<%=group.getDescription() %>"></textarea></td>
        </tr>
        <tr>
            <td colspan="2" height="100px" style="border-right:hidden;"></td>
            <td colspan="2" style="border-right:hidden;">동호회 공개 여부<br>
                <input type="radio" value="open" id="open" name="openYn" checked>
                <label for="open">공개</label>
                <input type="radio" value="secret" id="secret" name="openYn">
                <label for="secret">비공개</label>
            </td>
            <td colspan="2" style="border-right:hidden;">닉네임 사용 설정<br>
                <input type="radio" value="open" id="open" name="nickNameyn" checked>
                <label for="open">공개</label>
                <input type="radio" value="secret" id="secret" name="nickNameyn">
                <label for="secret">비공개</label>
            </td>
            <td colspan="2" style="border-right:hidden;"></td>
            <td colspan="2" style="border-right:hidden;"></td>
           	<td colspan="2" height="100px" style="border-right:hidden;">
            </td>
            
        </tr>
        <tr>
            <td rowspan="12" colspan="20" style="border-right:hidden; border-bottom:hidden;"><label style="float:left;">우리 동호회 회칙 </label>
            &nbsp;&nbsp;<textarea id="rule" name="groupRule"></textarea></td>
        </tr>
        </table>
          <br>
          <br>
            <input type="submit" id="deleteBtn" value="수정" onclick="update();">
            <input type="button" id="cancelBtn" value="취소">
        </form>
     </div>
     
     <script>
     	function doOpenCheck(chk){
    	    var obj = document.getElementsByName("interest");
    	    for(var i=0; i<obj.length; i++){
    	        if(obj[i] != chk){
    	            obj[i].checked = false;
    	        }
    	    }
    	} 
     
     	function update() {
     		("#updateForm").attr("action", "<%= request.getContextPath() %>/update.gr");
     	}
     </script>
</div>
</body>
</html>