<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.kh.groumoa.group.model.vo.GroupVO"%>
<%ArrayList<GroupVO> searchedGroupList = (ArrayList<GroupVO>) request.getAttribute("searchedGroupList"); 
	int searchedGroupListSize = searchedGroupList.size();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동호회 검색 결과</title>
<style>
    .nav{
        width: 600px;
        margin: 0 auto;
    }
    .menu{
            background: white;
            color: black;
            text-align: center;
            display: table-cell;
            vertical-align: middle;
            width: 150px;
            height: 50px;
        }
    .menu:hover {
            background: #461212;
            color: white;
            font-weight: bold;
            cursor: pointer;
    }
    #item {
        
        width: 350px;
        height: 200px;
        display: inline-block;
        text-align: center;
        border:1px solid black;
    }
    .mygroup {
        text-align: center;
        margin-left: auto;
        margin-right: auto;
        margin-top: 50px;
    }
    .image{
    	width:300px;
    	height: 200px;
    }
    </style>
</head>
<body>
	<%@include file="/views/common/header/newHeader.jsp" %>
	<h2 align="center">동호회 검색 결과</h2>
	<hr noshade="noshade" size="1px" color="black">

	

		
		<% if(searchedGroupListSize != 0) { %>
		<%for(int i = 0; i < searchedGroupList.size(); i++) { %>
			
			<%if(i % 3 == 3) { %>
				<div class="mygroup">
			<% } %>
		<div id="item">
			
			<div class="image">
				<!-- <img src="image/Ellipse 19.png"> -->
			</div>
			
			<div style="float: left; border-bottom: 1px solid black; width: 200px; text-align: center;">
			<form action="<%=request.getContextPath() %>/selectOne.gr" method="post">
				<input type="hidden" name="groupCode" value="<%=searchedGroupList.get(i).getGroupCode() %>">
				<%
							session.setAttribute("groupCode", searchedGroupList.get(i).getGroupCode());
				%>
				<button style="float:right;" onclick="submit();">페이지 방문</button>
			</form>
				<b><%=searchedGroupList.get(i).getGroupName() %></b> <br>
			</div>
			<div style="float: none; width: 100px; text-align:left;">
				<br>분야: <%=searchedGroupList.get(i).getInterest() %>
				<br>모임장: <%=searchedGroupList.get(i).getGroupLeaderName() %>
				<br>모임지역: <%=searchedGroupList.get(i).getRegionName() %>
			</div>
		</div>
			<% if(i % 3 == 1) { %>
			
	</div>
		<% } %>
		<%} %>
		<% } else { %>
			<h2 align="center">검색하신 동호회는 존재하지 않습니다.</h2>
		<% } %>
		
</body>
</html>