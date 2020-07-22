<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.content{
   	  position:relative;
   	  left:110px;
   	  top:60px;
      width:1000px;
      height:1000px;
      margin:0 auto;
      border: 1px solid #e2d8d8;
      background:white;
   }
   
   td{
   	font-size:14px;
   }
   
   #areaTitle{
   	color:red;
   }
   
   .inputLine{
   	border-bottom:1px solid black;
   }
   
    .clause{
    	color:gray;
    	font-size:16px;
    }
    
    .content{
    	line-height:40px;
    }
   
   #doRestriction{
   	background:purple;
    color:white;
    width:100px;
    height:50px;
    border-radius: 10%;
   }
   
   #deleteBtn{
   background:purple;
    color:white;
    width:100px;
    height:50px;
    border-radius: 10%;
   }      	
</style>

</head>
<body>
	<%@ include file="/views/manager/menubar.jsp" %>
	<div class="content">      
      <br>
      <h2 id="areaTitle">회원 제재</h4>
      <hr>
      <br><br>
      <div id="restrictionBody" align="center">
      <form id="restrictionDetailForm" method="post">
      <table class="table" id="restrictionDetail">
      <thead>
      </thead>
      <tbody>
              <tr>
               <!-- class="clause" -->
              	<td class="clause">회원 이름</td>
              	
              	<td>김승열</td>
              	
              	
              	<td class="inputLine" rowspan="2"></td>
              </tr>
              <tr>
              	<td class="clause">소속 동호회</td>

              	<td>푸른뱃고동</td>

              </tr>
              <tr>
              	<td class="clause">회원 계정</td>
              </tr>
              <tr>
              	<td class="inputLine" colspan="2">phoneSy@naver.com</td>
              </tr>
              <tr>
              	<td class="clause">제재 사유</td>
              </tr>
              <tr>
              	<td class="inputLine" colspan="2">욕설사용</td>
              </tr>
              
              <tr>
              	<td class="clause">제재 종류</td>
              </tr>
              <tr>
              	<td class="inputLine" colspan="2">
              	<select>
              		<option>선택</option>
              	</select>
              	</td>
              </tr>
              <tr>
              	<td class="clause">신고 상세 내역</td>
              </tr>
              <tr>
               <td colspan="2"><textarea cols="50" rows="10" readonly="readonly" style="resize:none;"></textarea></td>
              </tr>                            
      </tbody>      
      </table>
      <div class="btnArea">
      	<button id="doRestriction">제재하기</button>
      	<button id="deleteBtn">삭제하기</button>
      </div>            
      </form>      
      </div>
    </div>
    
    <script>    
    </script>
</body>
</html>