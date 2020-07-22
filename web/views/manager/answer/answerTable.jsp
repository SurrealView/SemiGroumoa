<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% boolean isAnswered = true; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <%-- <%@ include file="../menubar.jsp" %> --%>
<style>

	/* .everylist {
      width:1200px;
      height:650px;
      position:absolute;
      top: 90px;
      left: 230px;
      background-color: white;
   } */

   .content{
   	  position:relative;
   	  left:110px;
   	  top:60px;
      width:1000px;
      height:800px;
      margin:0 auto;
      border: 1px solid #e2d8d8;
      background:white;
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
   #searchbox{
      margin: 0 330px;
   }
   #searchbox select {
      float: left;
   }
   #searchbox input {
      float: left;
   }
   .form-control{
      width:100px;
      height:35px;
      
   }
   #temp{
      display:inline-block;
      float:left;
      font-size:10px; 
      padding-left: 25px;
      padding-top: 15px;
      color:rgba(75, 75, 75, 0.493);
   }
   .table{
      width:950px;
/*       margin-left:25px; */
   }
   .pagination-div{
      margin:0 330px   ;
   }
   .table tbody tr:hover{
      cursor:pointer;
   }
   .answerdeleteBtn {
      border-radius: 30px;
      float:left;
      margin-left:30px;
      margin-top:-45px;   
   }
   .writeContentBtn{
      border-radius:30px;
      margin-left: 90px;
      margin-top:-45px;
   }
   
   .table {
    width: 100%;
    max-width: 100%;
    margin-bottom: 10px;
    border-collapse: collapse;
    text-align:center;
   }
   
   .questList {
    border-spacing: 0;
    border-collapse: collapse;
    border-color: black;
    vertical-align: middle;
   }
   
   .answerTitle, .answerTitle td {
		padding:10px;
	}
	
	.answerTitle {
		border-bottom:1px solid black;
	}
   
</style>
</head>
<body>
	<%@ include file="/views/manager/menubar.jsp" %>
	<div class="content">      
      <span id="temp">* 질문에 대한 조회 및 답변을 작성하실 수 있습니다.</span>
      <br>
      <h2 id="name" align="center">Q&A 게시판</h4>
      <hr>
      <br><br><!-- 게시판 관리일경우 -->
      <table class="table">
      <thead>
          <tr>
           <th><input type="checkbox"></th>
           <th>글번호</th>
           <th>분류</th>
           <th>작성자</th>
           <th>제목</th>
           <th>작성일</th>
           <th>조회수</th>
          </tr>                    
      </thead>
      <tbody>
      <tr class="answerTitle">
         <td><input type="checkbox"></td>
         <td><a href="boardManagement-detail.jsp">1</a></td>
         <td>공지</td>
         <td>김형진</td>
         <td>방가방가</td>
         <td>2020-07-05</td>
         <td>2</td>
      </tr>
      <tr class="answerContent">
    	<td colspan="7">                    	
          	<% if(!isAnswered) { %>
       		<%@ include file="answer.jsp" %>
       		<% } else { %>
       		<%@ include file="answerDetail.jsp" %>
    		<% } %>
       	</td>
       	<tr class="answerTitle">
         <td><input type="checkbox"></td>
         <td><a href="boardManagement-detail.jsp">1</a></td>
         <td>공지</td>
         <td>김형진</td>
         <td>방가방가</td>
         <td>2020-07-05</td>
         <td>2</td>
      </tr>
      <tr class="answerContent">
    	<td colspan="7">                    	
          	<% if(!isAnswered) { %>
       		<%@ include file="answer.jsp" %>
       		<% } else { %>
       		<%@ include file="answerDetail.jsp" %>
    		<% } %>
       	</td>
      </tr>
      </tr>           
      </tbody>
      </table>
    </div>
    
    <script>
        $(function() {
        	$(".writeArea").removeAttr("style");
            $(".answerContent").hide();
            var tr = $(".answerContent");
            console.log(tr);            
            $(".answerTitle").each(function(i, e){                
            	$(this).click(function(){            		
           		//$(this).parent().click(function(){
            		console.log(i);
                    var idx = i;   
                    for(var j = 0; j < tr.length; j++){
                        if(j == i){
                            continue;
                        }
                        $(tr[j]).hide();
                    }
                    if($(tr[idx]).is(":visible")){
                        $(tr[idx]).hide();
                    } else{
                        $(tr[idx]).show();
                    }                                        
                })
            })

        });
    </script>
      
      <%-- <div class="table-div">
         <h2 align="center">게시판</h2>         
         <!-- table table-striped -->
            <table class="table">
                  <thead>
                    <tr>
                      <th><input type="checkbox"></th>
                      <th>글번호</th>
                      <th>분류</th>
                      <th>작성자</th>
                      <th>제목</th>
                      <th>작성일</th>
                      <th>조회수</th>
                    </tr>                    
                  </thead>
                  <tbody>
                    <tr class="answerTitle">
                      <td><input type="checkbox"></td>
                      <td><a href="boardManagement-detail.jsp">1</a></td>
                      <td>공지</td>
                      <td>김형진</td>
                      <td>방가방가</td>
                      <td>2020-07-05</td>
                      <td>2</td>
                      </tr>
                      <tr class="answerContent">
                    	<td colspan="7">                    	
                    	<% if(!isAnswered) { %>
                    		<%@ include file="answer.jsp" %>
                    		<% } else { %>
                    		<%@ include file="answerDetail.jsp" %>
                    		<% } %>
                    	</td>
                    </tr>                    
                    <tr>
                      <td><input type="checkbox"></td>
                        <td>1</td>
                        <td>공지</td>
                        <td>김형진</td>
                        <td>방가방가</td>
                        <td>2020-07-05</td>
                        <td>2</td>
                      </tr>
                      <tr>
                        <td><input type="checkbox"></td>
                        <td>1</td>
                        <td>공지</td>
                        <td>김형진</td>
                        <td>방가방가</td>
                        <td>2020-07-05</td>
                        <td>2</td>
                      </tr>
                      <tr>
                        <td><input type="checkbox"></td>
                        <td>1</td>
                        <td>공지</td>
                        <td>김형진</td>
                        <td>방가방가</td>
                        <td>2020-07-05</td>
                        <td>2</td>
                      </tr>
                      <tr>
                        <td><input type="checkbox"></td>
                        <td>1</td>
                        <td>공지</td>
                        <td>김형진</td>
                        <td>방가방가</td>
                        <td>2020-07-05</td>
                        <td>2</td>
                      </tr>
                      <tr>
                        <td><input type="checkbox"></td>
                        <td>1</td>
                        <td>공지</td>
                        <td>김형진</td>
                        <td>방가방가</td>
                        <td>2020-07-05</td>
                        <td>2</td>
                      </tr>
                      <tr>
                        <td><input type="checkbox"></td>
                        <td>1</td>
                        <td>공지</td>
                        <td>김형진</td>
                        <td>방가방가</td>
                        <td>2020-07-05</td>
                        <td>2</td>
                      </tr>
                      <tr>
                        <td><input type="checkbox"></td>
                        <td>1</td>
                        <td>공지</td>
                        <td>김형진</td>
                        <td>방가방가</td>
                        <td>2020-07-05</td>
                        <td>2</td>
                      </tr>
                      <tr>
                        <td><input type="checkbox"></td>
                        <td>1</td>
                        <td>공지</td>
                        <td>김형진</td>
                        <td>방가방가</td>
                        <td>2020-07-05</td>
                        <td>2</td>
                      </tr>
                      <tr>
                        <td><input type="checkbox"></td>
                        <td>1</td>
                        <td>공지</td>
                        <td>김형진</td>
                        <td>방가방가</td>
                        <td>2020-07-05</td>
                        <td>2</td>
                      </tr>
                  </tbody>
                </table>
                </div>
                
                <br>
                <div class="pagination-div">
                <ul class="pagination">
                   <li class="page-item"><a class="page-link" href="#"><<</a></li>
                 <li class="page-item"><a class="page-link" href="#"><</a></li>
                 <li class="page-item"><a class="page-link" href="#">1</a></li>
                 <li class="page-item active"><a class="page-link" href="#">2</a></li>
                 <li class="page-item"><a class="page-link" href="#">3</a></li>
                 <li class="page-item"><a class="page-link" href="#">4</a></li>
                 <li class="page-item"><a class="page-link" href="#">5</a></li>
                 <li class="page-item"><a class="page-link" href="#">></a></li>
                 <li class="page-item"><a class="page-link" href="#">>></a></li>
            </ul>
            </div>
            <div class="answerdeleteBtn" style="float:left;">
               <button class="">삭제</button>
            </div>
            <div class="writeContentBtn" style="float:left">
               <button class="">작성하기</button>
            </div>
                <div class="searchbox" id="searchbox">
               <form>
                  <select class="form-control">
                       <option>제목</option>
                       <option>작성자</option>
                       <option>내용</option>
                  </select>
                  <input type="text" placeholder="게시글 검색" style="height:35px;">
                   <button type="submit"><i class="fa fa-search" style="height:25px"></i></button>
               </form>
               
            </div>
      </div> --%>
</body>
</html>
