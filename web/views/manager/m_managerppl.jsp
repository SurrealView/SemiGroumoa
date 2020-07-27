<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.groumoa.member.model.vo.MemberVO, java.util.*, com.kh.groumoa.common.*"%>
<% ArrayList<MemberVO> list = (ArrayList<MemberVO>) request.getAttribute("list"); 
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
<%@ include file="menubar.jsp" %>
<title>Groumoa</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
   
   tr {
      border-bottom:1px solid black;
   }
/*   .everylist {
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
    width: 100%;
    max-width: 100%;
    margin-bottom: 20px;
    border-collapse: collapse;
    text-align:center;
   }*/
   
/*   table {
    border-spacing: 0;
    border-collapse: collapse;
    border-color: black;
    vertical-align: middle;
   }*/
   
/*   thead{
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
<!--   <div class="everylist" id="jeje"><label id="title">전체 사용자</label>
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
                <h4 id="name">전체 사용자&nbsp;<%=pi.getTotalCount() %>명</h4>
                <br>
                <br>
                <br>
                <hr>
              <table id="listArea">
           <thead>
            <tr>
                <th>선택</th>
            <th>이름</th>
            <th>계정</th>
            <th>가입일</th>
            <th>글/댓글/문의</th>
            <th>메모</th>
          </tr>
          </thead>
           <tbody>
          <% for(MemberVO m : list) { %>
           <tr>
              <td><input type="checkbox" name="code" onclick="but(this)" value="<%= m.getMemberCode() %>"></td>
            <td><%= m.getUserName() %></td>
             <td><%= m.getEmail() %></td>
             <td><%= m.getEnrollDate() %></td>
           <td><%= m.getPostCode() %></td>
             <td><input type="checkbox"></td>
          </tr>
          <% } %>
          </tbody>
      </table>
        
       
       <div class="pagingArea" align="center">
         <button onclick="location.href='<%=request.getContextPath()%>/managerPpl.mn?currentPage=1'"><<</button>
         
         <% if(currentPage <= 1) { %>
         <button disabled><</button>
         <% } else { %>
         <button onclick="location.href='<%=request.getContextPath()%>/managerPpl.mn?currentPage=<%=currentPage - 1%>'"><</button>
         <% } %>
         
         <% for(int p = startPage; p <= endPage; p++) { 
               if(p == currentPage) {
         %>
                  <button disabled><%= p %></button>
         <%      } else { %>
                  <button onclick="location.href='<%=request.getContextPath()%>/managerPpl.mn?currentPage=<%=p%>'"><%= p %></button>
         <%  
                 }
            }
         %>
         
         <% if(currentPage >= maxPage) { %>
         <button disabled>></button>
         <% } else { %>
         <button onclick="location.href='<%=request.getContextPath()%>/managerPpl.mn?currentPage=<%=currentPage + 1%>'">></button>
         <% } %>
      
         <button onclick="location.href='<%=request.getContextPath()%>/managerPpl.mn?currentPage=<%=maxPage%>'">>></button>
         <br>
         <div id="Btn">
            <button id="detailBtn">정보확인</button>&nbsp;
            <button id="backBtn">이전페이지</button>
         </div>
         
      </div>     
 </div>         

   <script>            
      function but(t) {
         td = t.parentNode;
         td.style.backgroundColor = (t.checked) ? "darkgray" : "white";
         tr = t.parentNode.parentNode;
         tr.style.backgroundColor = (t.checked) ? "darkgray" : "white";
      }
      
      $(function(){
         $("#detailBtn").click(function(){
//            var num = $("#listArea").parent().children().eq(0).val();
            var num = $("input:checkbox[name='code']:checked").val();
            console.log(num);
            location.href="<%=request.getContextPath()%>/detail.mn?num=" + num;
         });
      });
      

   </script>
</body>
</html>