<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, com.kh.groumoa.group.model.vo.GroupVO"%>
<%
	ArrayList<GroupVO> searchedGroupList = (ArrayList<GroupVO>) request.getAttribute("searchedGroupList");
	int searchedGroupListSize = searchedGroupList.size();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동호회 검색 결과</title>
<style>
.nav {
	width: 600px;
	margin: 0 auto;
}

.menu {
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
	border: 1px solid black;
	text-align: center;
}

.mygroup {
	text-align: center;
	margin-left: auto;
	margin-right: auto;
	margin-top: 50px;
}

.image {
	width: 300px;
	height: 200px;
}

#table-group-desc {
	width: 350px;
	border: 1px solid lightgray;
	border-radius: 5px;
	background: lightgray;
}

#table-group-desc td:last-child {
	background: white;
	text-align: right;
}
</style>
</head>
<body>
	<%@include file="/views/common/header/newHeader.jsp"%>
	<h2 align="center">동호회 검색 결과</h2>
	<hr noshade="noshade" size="2px" color="lightgray">
	<div id="total-wrap">
		<script>
			(function() {
				var wrap = document.getElementById("total-wrap");
				var height = 300 + (
		<%=searchedGroupListSize%>
			* 128) + 200;
				wrap.style.height = height + "px";
			})();
		</script>



		<%
			if (searchedGroupListSize != 0) {
		%>
		<%
			for (int i = 0; i < searchedGroupList.size(); i++) {
		%>

		<%
			if (i % 3 == 0) {
		%>
		<div class="mygroup">
			<%
				}
			%>
			<div id="item">

				<div class="image">
					<!-- <img src="image/Ellipse 19.png"> -->
				</div>

				<div
					style="float: left; border-bottom: 1px solid black; width: 350px; text-align: center;">
					<form action="<%=request.getContextPath()%>/selectOne.gr"
						method="post">
						<input type="hidden" name="groupCode"
							value="<%=searchedGroupList.get(i).getGroupCode()%>">
						<%
							session.setAttribute("groupCode", searchedGroupList.get(i).getGroupCode());
						%>
						<button style="float: right;" onclick="submit();">페이지 방문</button>
					</form>
					<b><%=searchedGroupList.get(i).getGroupName()%></b> <br>
				</div>

					<div style="float: none; text-align: left;">
					<table id="table-group-desc">
						<tr>
							<td style="width: 100px;">분야</td>
							<td><div><%=searchedGroupList.get(i).getInterest()%></div></td>
						</tr>
						<tr>
							<td>모임장</td>
							<td><div><%=searchedGroupList.get(i).getGroupLeaderName()%></div></td>
						</tr>
						<tr>
							<td>소개</td>
							<td><div><%=searchedGroupList.get(i).getDescription()%></div></td>
						</tr>
					</table>
				</div>
			</div>
			<%
				if (i % 3 == 2) {
			%>
			<div style="height: 175px"></div>
			<hr
				style="width: 1050px; background: lightgray; border: 1px solid lightgray"
				noshade="noshade">
			<div style="height: 25px"></div>
		</div>
		<%
			}
		%>
		<%
			}
		%>
		<%
			} else {
		%>
		<h2 align="center">검색하신 동호회는 존재하지 않습니다.</h2>
		<%
			}
		%>
	</div>
	<div style="height: 300px"></div>
	<%@include file="/views/common/footer/newFooter.jsp"%>
</body>
</html>