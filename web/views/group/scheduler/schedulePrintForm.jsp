<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.kh.groumoa.scheduler.model.vo.*, java.util.*"%>
<%
	ArrayList<SchedulerVO> list = (ArrayList<SchedulerVO>) request.getAttribute("list");
	/* 	SchedulerVO schedule = (SchedulerVO) request.getAttribute("schedule");
		String schTitle = schedule.getSchTitle();
		String schDetail = schedule.getSchDetail();
		String schDate = schedule.getSchDate();
		System.out.println(schedule); */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	
<%for (int i = 0; i < list.size(); i++) { %>
/* 	calendar.addEvent({
		title : '되냐',
		start : date,
		allDay : true
	}); */
	/* calendar.addEvent({
	
	}); */
<%}%>
	
</script>
</head>
<body>
	<%@include file="groupCalendar.jsp"%>
</body>
</html>