<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.groumoa.notice.model.vo.NoticeVo, com.kh.groumoa.common.PageInfo, java.util.*"%>
 <% 
   ArrayList<NoticeVo> list = (ArrayList<NoticeVo>)request.getAttribute("list");
   PageInfo pi = (PageInfo) request.getAttribute("pi");
   int listCount = pi.getTotalCount();
   int currentPage = pi.getCurrentPage();
   int maxPage = pi.getMaxPage();
   int startPage = pi.getStartPage();
   int endPage = pi.getEndPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <style>	
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
    /* width:950px; */
    border-collapse: collapse;
    text-align:center;
   }
   
   .noticeTitle, .noticeTitle td {
		padding:10px;
	}
	
	.noticeTitle {
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
      <% for(NoticeVo n : list) { %>
      <tr class="noticeTitle">
       <td><input type="checkbox"></td>
         <td><%=n.getnNo() %></td>
         <td><%=n.getNoticeCategory() %></td>
         <td><%=n.getMnWriterID() %></td>
         <td><%=n.getNoticeTitle() %></td>
         <td><%=n.getNoticeDate() %></td>
         </tr>
      <% } %>      
      <!-- <tr class="noticeTitle">
         <td><input type="checkbox"></td>
         <td></td>
         <td>공지</td>
         <td>김형진</td>
         <td>방가방가</td>
         <td>2020-07-05</td>
         <td>2</td>
      </tr> -->       
      </tbody>
      </table>
      <div class="pageArea">
      	
      	<button onclick="location.href='<%=request.getContextPath()%>/selectList.no?currentPage=1'">처음으로</button>      	
      	<% if(currentPage >= 1) { %>
      	<button disabled>←</button>
      	<%} else { %>
      	<button onclick="location.href='<%=request.getContextPath()%>/selectList.no?currentPage=<%= currentPage - 1%>'"></button>
      	<%} %>
      	
      	<% for(int p = startPage; p <= endPage; p++) { 
      		if(p == currentPage) {
      	%>
      		<button disabled><%=p %></button>
      	<% } else {%>
      		<button onclick="location.href='<%=request.getContextPath()%>/selectList.no?currentPage=<%=p%>'"><%=p%></button>
      	<% }
      	} %>
      	
      	<% if(currentPage >= maxPage) { %>
      	<button disabled>→</button>
      	<% } else { %>
      	<button onclick="location.href='<%=request.getContextPath()%>/selectList.no?currentPage=<%= currentPage + 1%>'">→</button>
      	<% } %>      	
      	<button onclick="location.href='<%=request.getContextPath()%>/selectList.no?currentPage=<%= maxPage%>'">맨끝으로</button>
      </div>      
    </div>
    
    
</body>
</html>