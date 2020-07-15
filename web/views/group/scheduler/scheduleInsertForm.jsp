<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#outer {
	border: 1px solid black;
	width: 1000px;
	height: 900px;
	display: block;
	margin: 0px auto;
}

#insert-wrap {
	display: block;
	margin: 0px auto;
	margin-top: 50px;
	width: 800px;
	height: 700px;
}
</style>
</head>
<body>
	<!-- 헤더 추가 필요 -->
	<%@include file="../subMenubar.jsp"%>
	<%-- <% if(loginUser != null) { %> 여기서는 유저가 모임장인지 아닌지 판단할 코드 작성할것 --%>
	<div class="outer">
		<div class="insert-wrap">
			<div align="center">
				<button type="reset">취소하기</button>
				<button type="submit">등록하기</button>
			</div>
		</div>
	</div>
	<%-- 	<% } else {
		request.setAttribute("msg", "잘못된 경로로 접근하셨습니다.");
		request.getRequestDispatcher("../common/errorPage.jsp").forward(request, response);
	} %> --%>
</body>
</html>