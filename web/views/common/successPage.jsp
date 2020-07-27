<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.groumoa.group.model.vo.*"%>
<% String successCode = (String) request.getAttribute("successCode");
   GroupVO selectedGroup = (GroupVO) request.getAttribute("selectGroup");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		(function(){
			var successCode = "<%= successCode %>";
			
			var successMessage = "";
			var movePath = "";
			
			switch(successCode) {
			case "insertMember" :
				successMessage = "회원 가입에 성공하셨습니다!";
				movePath = "<%=request.getContextPath()%>";
				break;
				
			case "updateMember" :
				successMessage = "회원 수정에 성공하셨습니다!";
				movePath = "<%=request.getContextPath()%>/views/member/memberUpdateForm.jsp";
				break;
				
			case "insertBoard" :
				successMessage = "게시판 작성에 성공하셨습니다!";
				movePath = "<%=request.getContextPath()%>/selectList.bo";
				break;
          
      case "insertInquire" :
				successMessage = "게시판 작성에 성공하셨습니다.";
				movePath = "<%=request.getContextPath()%>/views/group/myInquiry.jsp";
				break;
          
			case "insertGroup" :
				successMessage = "동호회 개설에 성공하셨습니다.";
				request.setAttribute("selectedGroup", selectedGroup);
				movePath = "<%=request.getContextPath()%>/selectOne.gr";
      	break;
          
			case "deleteBoard" :
				successMessage = "게시판 삭제에 성공하셨습니다!";
				movePath = "<%=request.getContextPath()%>/selectListAsLeader.bo";
				break;
          
			case "deleteFee" :
				successMessage = "회비 내역 삭제에 성공하셨습니다!";
				movePath = "<%=request.getContextPath()%>/selectListAsLeader.fee";
				break;
			}
			
			alert(successMessage);
			
			location.href = movePath;
		})();
	</script>
</body>
</html>