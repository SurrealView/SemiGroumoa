<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Groumoa</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
	.container {
		position: absolute;
		top: 100px;
		left: 250px;
		height:630px;
		background:white;
	}
</style>
</head>
<body>
	<%@ include file="menubar.jsp" %>
	<div class="container">
 	 <h4>전체 사용자</h4>          
  		<table class="table table-striped">
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
</body>
</html>