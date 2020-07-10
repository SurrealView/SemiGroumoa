<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../common/manager/menubar.jsp" %>
<title>Groumoa</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
	.container {
		position: absolute;
		top: 100px;
		left: 250px;
	}
</style>
</head>
<body>
	<div class="container">
 	 <h4>전체 사용자</h4>          
  		<table class="table table-striped">
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
        	 <td>푸른뱃고동</td>
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
</body>
</html>