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
	
	table {
		border-collapse:collapse;
		width:100%;
		text-align:center;
	}

	th,td {
		padding:10px;
	}
	
	tbody tr:nth-child(odd) {
		background-color:rgb(211,211,211);
	}
	
	tr {
		border-bottom:1px solid black;
	}
/*	.everylist {
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
	}*/
	
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
                <h4 id="name">전체 동호회</h4>
                <br>
                <br>
                <br>
                <hr>
        <thead>
   		   <tr>
   		   	 <th><input type="checkbox"></th>
     		 <th>모임명</th>
     		 <th>모임장</th>
     		 <th>개설일</th>
     		 <th>관심사</th>
     		 <th>상세관심사</th>
     		 <th>인원</th>
     		 <th>게시글</th>
     		 <th>메모</th>
    	   </tr>
  		  </thead>
    	<tbody>
     	   <tr>
       		 <td><input type="checkbox"></td>
        	 <td>푸른뱃고등</td>
             <td>김승열</td>
             <td>2020/07/01</td>
             <td>아웃도어/여행</td>
             <td>낚시</td>
             <td>10/30</td>
             <td>10</td>
             <td><input type="checkbox"></td>
          </tr>
        </tbody>
      </table>
           </div>
 </form>
</body>
</html>