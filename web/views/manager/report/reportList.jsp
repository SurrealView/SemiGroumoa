<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.groumoa.report.model.vo.ReportVo, com.kh.groumoa.common.PageInfo, java.util.*, com.kh.groumoa.member.model.vo.MemberVO"%>
 <% 
   ArrayList<ReportVo> list = (ArrayList<ReportVo>)request.getAttribute("list");
   PageInfo pi = (PageInfo) request.getAttribute("pi");
   int listCount = pi.getTotalCount();
   int currentPage = pi.getCurrentPage();
   int maxPage = pi.getMaxPage();
   int startPage = pi.getStartPage();
   int endPage = pi.getEndPage();
   MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/views/manager/menubar.jsp" %>
	<div class="content">      
      <span id="temp">* 질문에 대한 조회 및 답변을 작성하실 수 있습니다.</span>
      <br>
      <h2 id="name" align="center">신고 게시판</h4>
      <hr>
      <br><br>
      <form id="reportListForm" method="post">
      <table class="table" id="reportList">
      <thead>
          <tr>
           <th><input type="checkbox"></th>
           <th>글번호</th>
           <th>분류</th>
           <th>작성자</th>
           <th>피신고자</th>
           <th>제목</th>
           <th>작성일</th>
          </tr>                    
      </thead>
      <tbody>
      <% for(ReportVo re : list) { %>
      <tr class="reportTitle">
         <%-- <input type="checkbox" name="ckNotice" value="<%=n.getNoticeCode()%>"></td> --%>
         <input type="hidden" value="<%=re.getReportCode() %>">
         <td class="list" id="rowNum"><%=re.getRno() %></td>
         <td class="list"><%=re.getReportCategory() %></td>
         <td class="list"><%=re.getReporterID() %></td>
         <td class="list"><%=re.getReportedID() %></td>
         <td class="list"><%=re.getReportTitle() %></td>
         <td class="list"><%=re.getReportDate() %></td>
         </tr>
      <% } %>           
      </tbody>
      </table>
      <div class="userBtnArea">
      	<button onclick="location.href='<%=request.getContextPath()%>/views/manager/notice/noticeWrite.jsp'">글쓰기</button>
      </div>
      <div class="pageArea" align="center">   	
      	<button onclick="location.href='<%=request.getContextPath()%>/selectList.re?currentPage=1'">처음으로</button>      	
      	<% if(currentPage >= 1) { %>
      	<button disabled>←</button>
      	<%} else { %>
      	<button onclick="location.href='<%=request.getContextPath()%>/selectList.re?currentPage=<%= currentPage - 1%>'"></button>
      	<%} %>
      	
      	<% for(int p = startPage; p <= endPage; p++) { 
      		if(p == currentPage) {
      	%>
      		<button disabled><%=p %></button>
      	<% } else {%>
      		<button onclick="location.href='<%=request.getContextPath()%>/selectList.re?currentPage=<%=p%>'"><%=p%></button>
      	<% }
      	} %>
      	
      	<% if(currentPage >= maxPage) { %>
      	<button disabled>→</button>
      	<% } else { %>
      	<button onclick="location.href='<%=request.getContextPath()%>/selectList.re?currentPage=<%= currentPage + 1%>'">→</button>
      	<% } %>      	
      	<button onclick="location.href='<%=request.getContextPath()%>/selectList.re?currentPage=<%= maxPage%>'">맨끝으로</button>
      </div>
      
      </form>      
            
    </div>
    
    <script>
    $(function(){    	
    	$("#reportList .list").click(function(){
	    	
    		var tdId = $(this).parent().children("input").val();
    		var num = $(this).parent().children("#rowNum").text();
    		
    		console.log(num);
    		
    		location.href ="<%=request.getContextPath()%>/selectOne.no?num=" + num;
    	});	
    	  	
    });   
    </script>
</body>
</html>