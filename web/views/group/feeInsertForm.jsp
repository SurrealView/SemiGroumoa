<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#outer {
	border: 1px solid lightgray;
	border-radius: 10px;
	width: 1000px;
	height: 700px;
	display: block;
	margin: 0px auto;
}

#insert-wrap {
	display: block;
	margin: 0px auto;
	margin-top: 50px;
	width: 900px;
	height: 500px;
}

#event-area {
	border: 1px solid lightgray;
	border-radius: 10px;
}

#event-area td {
	padding: 10px;
}

#event-area { /* 
	border-collapse: collapse; */
	width: 600px;
	vertical-align: auto
}

#title-tr {
	height: 50px;
	width: 650px;
	background: orange;
	border-radius: 10px;
	
}

#title-tr h2 {
	padding-top: 10px;
}

.writeBtn, .cancelBtn {
	border: 0px;
	color: white;
	width: 75px;
	height: 30px;
	border-radius: 10px;
}

.cancelBtn {
	background: #d9534f;
}

.writeBtn {
	background: #0275d8;
}

.writeBtn:hover, .cancelBtn:hover {
	cursor: pointer;
}
</style>
</head>
<body>
	<%@include file="../common/header/newHeader.jsp" %>
	<%@include file="subMenubar.jsp" %>
	<%-- <% if(loginUser != null) { %> 여기서는 유저가 모임장인지 아닌지 판단할 코드 작성할것 --%>
	<div id="outer">
		<div id="insert-wrap" align="center">
			<div id="title-tr">
				<h2>회비 내역 추가</h2>
			</div>
			<br>
			<form action="<%=request.getContextPath()%>/insert.fee" method="post">
				<table id="event-area" style="width:650px; height: 250px">
					<tr>
						<td><input type="hidden" name="feeMember" value="<%= loginUser.getMemberCode()%>">
					</tr>
					<tr>
						<td><label>선택</label></td>
						<td>
							<select name="feeChoose">
								<option value="plus">입금</option>
								<option value="minus">출금</option>
							</select>
						</td>
						<td><label>금액</label></td>
						<td><input type="text" name="feeNum"></td>
						<td><label>날짜</label></td>
						<td><input type="date" name="feeDate"></td>
					</tr>
					<tr>
						<td><label>내용</label></td>
						<td colspan="6"><textarea name="feeDetail" cols="73%"
								rows="10" style="resize: none"></textarea></td>
					</tr>

				</table>
				<br>
				<button type="submit" class="writeBtn">등록하기</button>
				<button type="reset" class="cancelBtn" onclick="location.href='<%=request.getContextPath()%>/selectList.fee'">취소하기</button>
			</form>
		</div>
	</div>
	<%-- 	<% } else {
		request.setAttribute("msg", "잘못된 경로로 접근하셨습니다.");
		request.getRequestDispatcher("../common/errorPage.jsp").forward(request, response);
	} %> --%>
	<%@include file="/views/common/footer/newFooter.jsp" %>
</body>
</html>