<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="menubar.jsp" %>
<title>Groumoa</title>
<style>
	.everylist {
		width:1200px;
		height:650px;
		position:absolute;
		top: 90px;
		left: 230px;
		background-color: white;
	}
	
	#name {
		font-weight: bold;
		font-size:20px;
		position:absolute;
		left:20px;
	}
	
	.table {
    width: 100%;
    max-width: 100%;
    margin-bottom: 20px;
    border-collapse: collapse;
    text-align:center;
	}
	
	table {
    border-spacing: 0;
    border-collapse: collapse;
    border-color: black;
    vertical-align: middle;
	}
	
/*	thead{
		display: table-header-group;
    	vertical-align: middle;
    	border-color: inherit;
	}
	
	tbody {
    	vertical-align: middle;
    	border-color: inherit;
	} */

</style>
</head>
<body>
  <form>
<!--	<div class="everylist" id="jeje"><label id="title">전체 사용자</label>
		<div class="round" id="round" style="border-radius: 50%; height: 200px; width: 200px; background-color: gray; position: absolute; top: 80px; left: 50px;"></div>
		<div class="listup" id="list">
			<div class="item" id="item1"><label>동호회명</label>&nbsp;&nbsp;<input type="text"></div>
			<div class="item" id="item2"><label>해산 사유</label>&nbsp;&nbsp;<input type="text"></div>
			<div class="item" id="item4"><label style="float:left">해산 사유 상세</label>&nbsp;&nbsp;<textarea style="width:350px; height:150px; resize:none;"></textarea></div>
		</div>
	</div>
		<button id="jejeBtn">해산하기</button><button id="canBtn">취소하기</button>
 -->	
 		<div class="everylist">
              <table class="table table-hover">
                <h4 id="name">전체 사용자</h4>
                <br>
                <br>
                <br>
                <hr>
        <thead>
   		   <tr>
   		   	 <th><input type="checkbox"></th>
     		 <th>닉네임</th>
     		 <th>계정</th>
     		 <th>가입일</th>
     		 <th>직책</th>
     		 <th>글/댓글/문의</th>
     		 <th>메모</th>
    	   </tr>
  		  </thead>
    	<tbody>
     	   <tr>
       		 <td><input type="checkbox"></td>
        	 <td>김형진</td>
             <td>john@example.com</td>
             <td>2020/07/01</td>
             <td>모임장</td>
             <td>1/1/0</td>
             <td><input type="checkbox"></td>
          </tr>
        </tbody>
      </table>
           </div>
 </form>
</body>
</html>