<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.groumoa.group.model.vo.*, com.kh.groumoa.member.model.vo.*, java.util.*" %>
<%  GroupVO group = (GroupVO) request.getAttribute("group");
 	RegionVO region = (RegionVO) request.getAttribute("regionSearch");
	GroupVO selectGroup = (GroupVO) request.getAttribute("selectGroup");
	/*	GroupVO insertGroup = (GroupVO) request.getAttribute("insertGroup");*/
	System.out.println("테스트3" + selectGroup);
	System.out.println("테스트4" + region);
	ArrayList<Attachment> fileList = (ArrayList<Attachment>) request.getAttribute("fileList");
	Attachment thumbNail = fileList.get(0);
	String openYn = (String)request.getAttribute("openYn");
%>
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
	.content-1{
		width:1000px;
		height:1500px;
		margin:0 auto;
		border-radius: 10px;
		border: 1px solid lightgray;
   		display: block;
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
	#groupTable {
		position:absolute;
		left:270px;
		width:980px;
		border-left:hidden;
	}
	
	#groupTable tr td {
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
	<%@include file="../common/header/newHeader.jsp"%>
	<%@include file="subMenubar.jsp" %>
	<div class="content-1">
		<p align="right" style="font-size:10px; padding-right: 25px; padding-top: 15px;">개인정보취급방침에 따라 최근 5년간의 내역이 제공됩니다.</p>
		<div id="sub-title"><span style="font-size: 15px">기본정보</span></div>
		<div class="tab" id="tab">
			<div class="item active" id="board"><a href="#">기본정보</a></div>
		</div>
		
		<br><br>
     <div class="wrapper">
     <form id="updateForm" action="<%=request.getContextPath() %>/update.gr" method="post" encType="multipart/form-data">
	  <table border="1" id="groupTable">
        <tr>
            <td colspan="6" height="50px" style="border-right:hidden; border-top:hidden;">동호회이름
            &nbsp;<input type="text" style="width:350px" class="form-control" name="groupName" value="<%=selectGroup.getGroupName()%>" readonly>
            <input type="hidden" name="groupCode" value="<%=selectGroup.getGroupCode() %>"></td>
            <td colspan="6" height="50px" style="border-right:hidden; border-top:hidden;">개설일
            &nbsp;<input type="text" style="width:350px" class="form-control" name="openDate" value="<%=selectGroup.getOpenDate() %>" readonly>
        </tr>
        <tr>
            <td colspan="12" height="50px" style="border-right:hidden;">동호회 활동 지역
            &nbsp;<input type="text" style="width:350px" class="form-control" name="rnCode" value="<%=region.getRegionName() %> <%=region.getRegionSpecific() %>" readonly>
<!--             <select class="form-control" name="rnCode" readonly>
	 				<option value="R0001">서울시 동작구</option>
	 				<option value="R0002">서울시 강동구</option>
	 				<option value="R0003">서울시 강서구</option>
	 				<option value="R0004">서울시 강북구</option>
	 				<option value="R0005">서울시 관악구</option>
	 				<option value="R0006">서울시 광진구</option>
	 				<option value="R0007">서울시 구로구</option>
	 				<option value="R0008">서울시 금천구</option>
	 				<option value="R0009">서울시 노원구</option>
	 				<option value="R0010">서울시 동대문구</option>
	 				<option value="R0011">서울시 도봉구</option>
	 				<option value="R0012">서울시 동작구</option>
	 				<option value="R0013">서울시 마포구</option>
	 				<option value="R0014">서울시 서대문구</option>
	 				<option value="R0015">서울시 성동구</option>
	 				<option value="R0016">서울시 성북구</option>
	 				<option value="R0017">서울시 서초구</option>
	 				<option value="R0018">서울시 송파구</option>
	 				<option value="R0019">서울시 영등포구</option>
	 				<option value="R0020">서울시 용산구</option>
	 				<option value="R0021">서울시 양천구</option>
	 				<option value="R0022">서울시 은평구</option>
	 				<option value="R0023">서울시 송로구</option>
	 				<option value="R0024">서울시 중구</option>
	 				<option value="R0025">서울시 중랑구</option>
	 			</select> -->
          <!-- &nbsp;<input type="text" style="width:350px" class="form-control" name="rnCode">  -->
            </td>
        </tr>
        <tr>
        	<td colspan="12" height="50px" style="border-right:hidden;">관심사
	 			<br>
	 			<br>
	 			
	 			<input type="radio" id="I01" name="interest" value="I01">
	 			<label for="I1" class="interest">문화/공연</label>
	 			<input type="radio" id="I02" name="interest" value="I02">
	 			<label for="I2" class="interest">게임/오락</label>
	 			<input type="radio" id="I03" name="interest" value="I03">
	 			<label for="I3" class="interest">아웃도어/여행</label>
	 			<input type="radio" id="I04" name="interest" value="I04">
	 			<label for="I4" class="interest">운동/스포츠</label>
	 			<input type="radio" id="I05" name="interest" value="I05">
	 			<label for="I5" class="interest">인문학/책/글</label>
	 			<input type="radio" id="I06" name="interestinterest" value="I06">
	 			<label for="I6" class="interest">업종/직무</label>
	 			<input type="radio" id="I07" name="interest" value="I07">
	 			<label for="I7" class="interest">외국/언어</label><br>
	 			<input type="radio" id="I08" name="interest" value="I08">
	 			<label for="I8" class="interest">음악/악기</label>
	 			<input type="radio" id="I09" name="interest" value="I09">
	 			<label for="I9" class="interest">패션/뷰티</label>
	 			<input type="radio" id="I10" name="interest" value="I10">
	 			<label for="I10" class="interest">공예/만들기</label>&nbsp;&nbsp;
	 			<input type="radio" id="I11" name="interest" value="I11">
	 			<label for="I11" class="interest">댄스/무용</label>&nbsp;&nbsp;
	 			<input type="radio" id="I12" name="interest" value="I12">
	 			<label for="I12" class="interest">사교/인맥</label>&nbsp;&nbsp;&nbsp;&nbsp;
	 			<input type="radio" id="I13" name="interest" value="I13">
	 			<label for="I13" class="interest">사진</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	 			<input type="radio" id="I14" name="interest" value="I14">
	 			<label for="I14" class="interest">차/오토바이</label><br>
	 			<input type="radio" id="I15" name="interest" value="I15">
	 			<label for="I15" class="interest">요리/제조</label>
	 			<input type="radio" id="I16" name="interest" value="I16">
	 			<label for="I16" class="interest">가족/결혼</label>
	 			<input type="radio" id="I17" name="interest" value="I17">
	 			<label for="I17" class="interest">반려동물</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	 			<input type="radio" id="I18" name="interest" value="I18">
	 			<label for="I18" class="interest">봉사활동</label>&nbsp;&nbsp;&nbsp;&nbsp;
	 			<input type="radio" id="I19" name="interest" value="I19">
	 			<label for="I19" class="interest">자유주제</label>
	 			
            </td>
        </tr>
        <tr>
        
        <!-- <td>파일첨부</td> -->
                    <!-- <td colspan="4"><input type="text" class="file_path" placeholder="파일을 올려주세요" readonly style="width:400px" name="filePath"></td>
                    <td colspan="3"><a class="upload" href="#" onclick="uploadFile();">파일선택</a></td>                
                    <input type="file" id="notice_upload" name="notice_upload" style="display: none;"> -->
            <td rowspan="2" height="450px" style="padding-left:60px;">동호회 프로필</td>
            <td colspan="8" height="200px" style="border-right:hidden;"><label style="float:left">썸네일 설정</label>
            &nbsp;&nbsp;<img id="thumbNail" style="float:left; margin-left:10px;" name="thumbNail"
            				src="<%=request.getContextPath() %>/thumbnail_uploadFiles/<%=thumbNail.getChangeName() %>">
             <input type="file" id="subBtn" name="thumbNail" onchange="loadImg(this, 1);"></td>
<!--             <input type="file" id="subBtn" name="thumbNail" style="float:left; margin-left:10px;" onchange="loadImg(this, 1);"> -->
         </tr>
        <tr>
            <td colspan="8" height="250px" style="border-right:hidden;"><label style="float:left">동호회 소개</label>
            &nbsp;&nbsp;<textarea id="groupIn" name="description"><%=selectGroup.getDescription() %></textarea></td>
        </tr>
        <tr>
            <td colspan="2" style="border-right:hidden;"></td>
           	<td colspan="2" height="100px" style="border-right:hidden;">
            </td>
            <td colspan="2" style="border-right:hidden;">동호회 공개 여부<br>
                <input type="radio" value="Y" id="open" name="openYn" checked>
                <label for="open">공개</label>
                <input type="radio" value="N" id="secret" name="openYn">
                <label for="secret">비공개</label>
            </td>
            <td colspan="2" style="border-right:hidden;">닉네임 사용 설정<br>
                <input type="radio" value="Y" id="open" name="nickNameyn" checked>
                <label for="open">공개</label>
                <input type="radio" value="N" id="secret" name="nickNameyn">
                <label for="secret">비공개</label>
            </td>
            
        </tr>
        <tr>
            <td rowspan="12" colspan="20" style="border-right:hidden; border-bottom:hidden;"><label style="float:left;">우리 동호회 회칙 </label>
            &nbsp;&nbsp;<textarea id="rule" name="groupRule"><%=selectGroup.getGroupRule() %></textarea></td>
        </tr>
        </table>
          <br>
          <br>
            <input type="submit" id="deleteBtn" value="수정">
            <input type="reset" id="cancelBtn" value="취소">
        </form>
     </div>
     
     <script>
<%--      	function doOpenCheck(chk){
    	    var obj = document.getElementsByName("interest");
    	    for(var i=0; i<obj.length; i++){
    	        if(obj[i] != chk){
    	            obj[i].checked = false;
    	        }
    	    }
    	}    --%>
     	
     	$(function(){
     		$("#subBtn").hide();
     		$("#thumbNail").click(function(){
     			$("#subBtn").click();
     		});
     	});
     	
     	function loadImg(value, num) {
     		if(value.files && value.files[0]) {
     			var reader = new FileReader();
     			
     			reader.onload = function(e) {
     				$("#thumbNail").attr("src", e.target.result);
     			}
     			reader.readAsDataURL(value.files[0]);
     		}
     	}
     	
     	$(function(){
			var exp = '<%=selectGroup.getInterest() %>'.val();	
 /*     		var exp = $(':radio[name="interest"]:checked').val();*/
    		$("input[name=interest]").val(exp);
 
 <%--      		$("input[name=interest]").each(function(){
 				for(var i = 0; i < arr.length; i++) {
   					if($(this).val() == arr[i]) {
   						$(this).attr("checked", true);
   					}
   				}   --%>
<%--    			var temp = '<%=selectGroup.getOpenYn() %>'.val(); --%>  		
   			var temp = $(':radio[name="openYn"]:checked').val(); 
<%--   			var tempt = openYn.val(); --%>
    		$("input[name=openYn]").val(temp);

<%--    			var arr = '<%=selectGroup.getNickNameyn() %>'.val(); --%>
   			var temp = $(':radio[name="nickNameyn"]:checked').val();
   			$("input[name=nickNameyn]").val(arr);
   			
   		});
     	
     </script>
   
</div>
</body>
</html>