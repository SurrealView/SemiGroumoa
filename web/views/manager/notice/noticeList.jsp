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
      <span id="temp">* 공지사항의 작성 및 수정과 삭제를 진행하실 수 있습니다.</span>
      <br>
      <h2 id="name" align="center">공지사항</h4>
      <hr>
      <br><br><!-- 게시판 관리일경우 -->
      <form id="noticeListForm" method="post">
      <table class="table" id="noticeList">
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
       <td><input type="checkbox" name="ckNotice" value="<%=n.getNoticeCode()%>"></td>
         <input type="hidden" value="<%=n.getNoticeCode() %>">
         <td class="list" id="rowNum"><%=n.getnNo() %></td>
         <td class="list"><%=n.getNoticeCategory() %></td>
         <td class="list"><%=n.getMnWriterID() %></td>
         <td class="list"><%=n.getNoticeTitle() %></td>
         <td class="list"><%=n.getNoticeDate() %></td>
         </tr>
      <% } %>
      </tbody>
      </table>
      <div class="userBtnArea">
      	<button onclick="writeNotice();">글쓰기</button>
      	<button onclick="deleteNotice();">삭제하기</button>
      </div>                  
      </form>      
      <div class="pageArea" align="center">
      	<button onclick="location.href='<%=request.getContextPath()%>/selectList.no?currentPage=1'">처음으로</button>      	
      	<% if(currentPage <= 1) { %>
      	<button disabled>←</button>
      	<%} else { %>
      	<button onclick="location.href='<%=request.getContextPath()%>/selectList.no?currentPage=<%= currentPage - 1%>'">←</button>
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
      	<button onclick="location.href='<%=request.getContextPath()%>/selectList.no?currentPage=<%= maxPage %>'">맨끝으로</button>
      </div>      
    </div>
    
    <script>
    $(function(){    	
    	$("#noticeList .list").click(function(){
	    	
    		var tdId = $(this).parent().children("input").val();
    		var num = $(this).parent().children("#rowNum").text();
    		
    		console.log(num);
    		
    		location.href ="<%=request.getContextPath()%>/selectOne.no?num=" + num;
    	});	
    	  	
    });
    function deleteNotice(){
    	$("#noticeListForm").attr("action", "<%=request.getContextPath()%>/delete.no");
    }
    
    function writeNotice(){
    	$("#noticeListForm").attr("action", "<%=request.getContextPath()%>/views/manager/notice/noticeWrite.jsp");
    }
    </script>
    
    
</body>
</html>