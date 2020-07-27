<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.groumoa.member.model.vo.MemberVO"%>
<%
	MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link
	href="https://fonts.googleapis.com/css2?family=Poor+Story&display=swap"
	rel="stylesheet"> -->
<link
	href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap"
	rel="stylesheet">

<style>
body {
	/* font-family: 'Poor Story', cursive; */
	font-family: 'Do Hyeon', sans-serif;
}

.header {
	width: 100%;
	height: 175px;
	display: block;
	background-color: white;
}

.logo_container {
	width: 400px;
	height: auto;
	float: left;
}

.logo_container img {
	height: 130px;
	width: auto;
	display: table-cell;
	vertical-align: middle;
	margin-top: 10px;
	float: right;
}

#middle-td {
	width: 50%;
}

.search-form {
	text-align: center;
	padding-left: 100px;
	padding-right: 100px;
	padding-top: 50px;
}

.search-form input[type=text] {
	padding: 7px;
	border: none;
	width: 400px;
	height: 30px;
	border-radius: 50px;
	border: 2px solid #0275d8;
	font-size: 16px;
	font-family: sans-serif;
	margin-top: 7px;
	font-size: 16px;
	border-radius: 50px;
}

.search-form button {
	height: 40px;
	border-radius: 50px;
	border: none;
	font-size: 16px;
	font-family: sans-serif;
	padding: 7px;
	margin-left: -70px;
	cursor: pointer;
}

#first-tr .sub-menu {
	font-size: 12px;
	text-align: right;
}

#second-tr .sub-menu {
	text-align: center;
}

.sub-menu a {
	text-decoration: none;
	color: gray;
}

.div-bar {
	background: lightgray;
	border: 1px solid lightgray;
}

.table-nav-bar {
	width: 100%;
	height: 50px;
}

.table-nav-bar #blank {
	width: 250px;
}

.table-nav-bar .my-menu {
	width: 150px;
	text-align: center;
}

.my-menu a {
	text-decoration: none;
	color: gray;
}

.sub-icons {
	height: 50px;
	width: 50px;
}
</style>
</head>
<body>
	<div class="header-wrapper">
		<table class="header">
			<tr id="first-tr">
				<td rowspan="2">
					<div class="logo_container">
						<!-- <img src="../../../resources/image/logo_groumoa2.png"> -->
						<a href="<%=request.getContextPath()%>"><img
							src="/groumoa/resources/image/logo_groumoa3.png"></a>
					</div>
				</td>
				<td rowspan="2" id="middle-td">
					<form class="search-form"
						action="<%=request.getContextPath()%>/search.gr" method="get">
						<input type="text" placeholder="동호회 이름을 입력해주세요" name="groupName">
						<button style="width: 60px">
							<img src="/groumoa/resources/image/search.png"
								style="width: 20px; height: 20px">
						</button>
					</form>
				</td>
				<%
					if (loginUser != null) {
				%>
				<td class="sub-menu" height="30" width="100"><a href="#"><strong><%=loginUser.getUserName()%><strong></a>
					님</td>
				<td class="sub-menu" height="30" width="100"><a
					href="<%=request.getContextPath()%>/logout.me">로그아웃</a></td>
				<%
					} else {
				%>
				<td class="sub-menu" height="30" width="100"><a
					href="<%=request.getContextPath()%>/views/member/login.jsp">로그인</a></td>
				<td class="sub-menu" height="30" width="100"><a
					href="<%=request.getContextPath()%>/views/member/signup.jsp">회원가입</a></td>
				<%
					}
				%>
				<td class="sub-menu" height="30" width="100"><a href="#">서비스안내</a></td>
				<td class="sub-menu" height="30" width="100"><a href="#">고객센터</a></td>
			</tr>
			<tr id="second-tr">
				<%
					if (loginUser != null) {
				%>
				<td class="sub-menu"><a href="#"><img class="sub-icons"
						src="<%=request.getContextPath()%>/resources/image/personal1.png"><br>마이페이지</a></td>
				<td class="sub-menu"><a
					href="<%=request.getContextPath()%>/views/group/groupInsert.jsp"><img
						class="sub-icons"
						src="<%=request.getContextPath()%>/resources/image/groupadd1.png"><br>모임개설</a></td>
				<td class="sub-menu"><a
					href="<%=request.getContextPath()%>/selectListAsLeader.gr"><img
						class="sub-icons"
						src="<%=request.getContextPath()%>/resources/image/groupmanage.png"><br>모임관리</a></td>
				<%
					} else {
				%>
				<td class="sub-menu"><a
					href="<%=request.getContextPath()%>/views/member/login.jsp"><img
						class="sub-icons"
						src="<%=request.getContextPath()%>/resources/image/personal1.png"><br>마이페이지</a></td>
				<td class="sub-menu"><a
					href="<%=request.getContextPath()%>/views/member/login.jsp"><img
						class="sub-icons"
						src="<%=request.getContextPath()%>/resources/image/groupadd1.png"><br>모임개설</a></td>
				<td class="sub-menu"><a
					href="<%=request.getContextPath()%>/views/member/login.jsp"><img
						class="sub-icons"
						src="<%=request.getContextPath()%>/resources/image/groupmanage.png"><br>모임관리</a></td>
				<%
					}
				%>
				<!-- <td class="sub-menu"><a href="#">알림</a></td> -->
			</tr>
		</table>
	</div>
	<hr noshade="noshade" class="div-bar">
	<table class="table-nav-bar">
		<tr>
			<td id="blank"></td>

			<%
				if (loginUser != null) {
			%>
			<td class="my-menu"><a
				href="<%=request.getContextPath()%>/selectRecommendedList.gr">추천
					동호회</a></td>
			<td class="my-menu"><a
				href="<%=request.getContextPath()%>/selectMyList.gr">가입한 동호회</a></td>
			<%
				}
			%>
			<%-- <td class="my-menu"><a href="<%=request.getContextPath()%>/select.in">공지사항</a></td> --%>
			<%
				if (loginUser != null && loginUser.getEmail().equals("admin@groumoa.com")) {
			%>
			<td class="my-menu"><a
				href="<%=request.getContextPath()%>/selectList.no">공지사항</a></td>
			<%
				} else {
			%>
			<td class="my-menu"><a href="#">공지사항</a></td>
			<%
				}
			%>
			<td class="my-menu"><a href="#">QnA</a></td>
			<td></td>
		</tr>
	</table>
	<hr noshade="noshade" class="div-bar">
</body>
</html>