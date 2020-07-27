<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.groumoa.group.model.vo.GroupVO"%>
<%
	GroupVO group = (GroupVO) session.getAttribute("selectedGroup");
	//GroupVO selectedGroup = (GroupVO) session.getAttribute("selectedGroup");
	session.setAttribute("selectedGroup", group);
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>동아리 폐쇄 진행</title>
<style>
    body {
        background: rgb(180, 180, 180);
        width: 800px;
        height: 90%;
		display: table-cell;
		vertical-align: middle;
        text-align: center;
    }    
    #closeRule{
    	float:left;
    }
</style>
</head>
<body>
    <br>
    <div class="content">
    <form id="closeGroup">
    <table align="center">
    	<thead>
    		<th colspan="2">동아리 폐쇄</th>
    	</thead>
    	<tbody>
	    	<tr>
	    	<td>동아리이름</td>
	    	<!-- <input text="text" maxlength="10" style="width:228px;" name="nickName"> -->
	    	<td><span style="width:228px;"><%=group.getGroupName() %></span></td>
	    	</tr>
	    	<tr>
	    	<td>폐쇄약관</td>
	    	<td><input id="closeRule" type="button" onclick="closedRule();" value="동아리 폐쇄약관 보기"></td>
	    	</tr>	    	
    		<tr>
    			<td>폐쇄사유</td>
    			<td><textarea cols="30" rows="10" style="resize:none;" name="introduce-self"></textarea></td>
    		</tr>
    	</tbody>
    </table>        
        <br><br>
        <input type="button" onclick="window.close();" value="닫기">
        <input type="button" onclick="closeGroup();" value="폐쇄하기">
    </form>    
    </div>
    <script>
    function closedRule() {
    	window.open("<%=request.getContextPath()%>/views/pages/closeGroupRule.jsp", "", "width=800,height=700");
    }
    
    function closeGroup() {
    	<%-- $("#closeGroup").attr("action", "<%=request.getContextPath()%>"); --%>
    }
        
    </script>
</body>
</html>