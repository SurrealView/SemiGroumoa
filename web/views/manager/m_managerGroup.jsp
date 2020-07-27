<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.groumoa.group.model.vo.*, java.util.*, com.kh.groumoa.common.*" %>
<% ArrayList<GroupVO> list = (ArrayList<GroupVO>) request.getAttribute("list"); 
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
	
	tbody tr:nth-child(odd) {
		background-color:rgb(211,211,211);
	}
	
	tr {
		border-bottom:1px solid black;
	}
	

</style>
</head>
<body>

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
     		 <th>인원</th>
     		 <th>게시글</th>
     		 <th>메모</th>
    	   </tr>
  		  </thead>
    	<tbody>
     	   <% for(GroupVO g : list) { %>
     	   <tr>
       		 <td><input type="checkbox" name="code" onclick="but(this)" value="<%= g.getGroupCode() %>"></td>
        	 <td><%= g.getGroupName() %></td>
             <td><%= g.getMemberName() %></td>
             <td><%= g.getOpenDate() %></td>
             <td><%= g.getInterest() %></td>
		     <td><%= g.getMemberCount() %></td>
		     <td><%= g.getPostCount() %></td>
             <td><input type="checkbox"></td>
          </tr>
          <% } %>
        </tbody>
      </table>
          <div class="pagingArea" align="center">
			<button onclick="location.href='<%=request.getContextPath()%>/groupList.gp?currentPage=1'"><<</button>
			
			<% if(currentPage <= 1) { %>
			<button disabled><</button>
			<% } else { %>
			<button onclick="location.href='<%=request.getContextPath()%>/groupList.gp?currentPage=<%=currentPage - 1%>'"><</button>
			<% } %>
			
			<% for(int p = startPage; p <= endPage; p++) { 
					if(p == currentPage) {
			%>
						<button disabled><%= p %></button>
			<%      } else { %>
						<button onclick="location.href='<%=request.getContextPath()%>/groupList.gp?currentPage=<%=p%>'"><%= p %></button>
			<%  
			        }
				}
			%>
			
			<% if(currentPage >= maxPage) { %>
			<button disabled>></button>
			<% } else { %>
			<button onclick="location.href='<%=request.getContextPath()%>/groupList.gp?currentPage=<%=currentPage + 1%>'">></button>
			<% } %>
		
			<button onclick="location.href='<%=request.getContextPath()%>/groupList.gp?currentPage=<%=maxPage%>'">>></button>
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
//				var num = $("#listArea").parent().children().eq(0).val();
				var num = $("input:checkbox[name='code']:checked").val();
				console.log(num);
				location.href="<%=request.getContextPath()%>/detail.gd?num=" + num;
			});
		});
		

	</script>
</body>
</html>