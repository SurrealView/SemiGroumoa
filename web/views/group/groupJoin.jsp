<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <title>동아리 가입하기</title>
<style>
    body {
        background: rgb(180, 180, 180);
        width: 800px;
        height: 90%;
		display: table-cell;
		vertical-align: middle;
        text-align: center;
    }    
    #joinRule{
    	float:left;
    }
</style>
</head>
<body>
    <br>
    <div class="content">
    <form id="joinGroup" method="post">
    <table align="center">
    	<thead>
    		<th colspan="2">동아리 가입</th>
    	</thead>
    	<tbody>
	    	<tr>
	    	<td>닉네임</td>
	    	<td><input text="text" maxlength="10" style="width:228px;" name="nickName"></td>
	    	</tr>
	    	<tr>
	    	<td>가입약관</td>
	    	<td><input id="joinRule" type="button" onclick="joinRules();" value="동아리 가입약관 보기"></td>
	    	</tr>	    	
    		<tr>
    			<td>자기소개</td>
    			<td><textarea cols="30" rows="10" style="resize:none;" name="introduce-self"></textarea></td>
    		</tr>
    	</tbody>
    </table>        
        <br><br>
        <input type="button" onClick="window.close();" value="닫기">
        <!-- <input type="button" onClick="joinIn();" value="신청하기"> -->
        <button onclick="joinIn()">신청하기</button>
    </form>    
    </div>
    <script>
    function joinIn() {
    	$("#joinGroup").attr("action", "<%=request.getContextPath()%>/join.gr");    	
    	window.close();
    }
    
    function joinRules() {
    	window.open("<%=request.getContextPath()%>/views/pages/joinGroupRule.jsp", "", "width=800,height=700");
    }
    </script>
</body>
</html>