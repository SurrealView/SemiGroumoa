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

</style>
</head>
<body> 
	
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
			<button onclick="location.href='<%=request.getContextPath()%>/managerGroupMember.mn?currentPage=1'"><<</button>
			
			<% if(currentPage <= 1) { %>
			<button disabled><</button>
			<% } else { %>
			<button onclick="location.href='<%=request.getContextPath()%>/managerGroupMember.mn?currentPage=<%=currentPage - 1%>'"><</button>
			<% } %>
			
			<% for(int p = startPage; p <= endPage; p++) { 
					if(p == currentPage) {
			%>
						<button disabled><%= p %></button>
			<%      } else { %>
						<button onclick="location.href='<%=request.getContextPath()%>/managerGroupMember.mn?currentPage=<%=p%>'"><%= p %></button>
			<%  
			        }
				}
			%>
			
			<% if(currentPage >= maxPage) { %>
			<button disabled>></button>
			<% } else { %>
			<button onclick="location.href='<%=request.getContextPath()%>/managerGroupMember.mn?currentPage=<%=currentPage + 1%>'">></button>
			<% } %>
		
			<button onclick="location.href='<%=request.getContextPath()%>/managerGroupMember.mn?currentPage=<%=maxPage%>'">>></button>
			<br>
			<div id="Btn">
				<button id="backBtn">이전페이지</button>&nbsp;
				<button id="detailBtn">정보확인</button>
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
//				var num = $("#listArea").parent().children().eq(0).val();
				var num = $("input:checkbox[name='code']:checked").val();
				console.log(num);
				location.href="<%=request.getContextPath()%>/detail.mn?num=" + num;
			});
		});
		

	</script>
</body>
</html>