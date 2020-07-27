<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.kh.groumoa.scheduler.model.vo.SchedulerVO, java.util.ArrayList"%>
<%
	ArrayList<SchedulerVO> list = (ArrayList<SchedulerVO>) request.getAttribute("list");
System.out.println("list" + list);
%>
<!DOCTYPE html>
<html>
<head>
<link href='../../../resources/fullcalendar/packages/core/main.css'
	rel='stylesheet' />
<link href='../../../resources/fullcalendar/packages/daygrid/main.css'
	rel='stylesheet' />
<link
	href='../../../resources/fullcalendar/packages/timegrid/main.min.css'
	rel='stylesheet' />
<link href='../../../resources/fullcalendar/packages/list/main.min.css'
	rel='stylesheet' />
<!-- 테마 적용을 위한 부트스트랩 v4.0 -->
<link
	href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css'
	rel='stylesheet' />
<link href='https://use.fontawesome.com/releases/v5.0.6/css/all.css'
	rel='stylesheet'>
<link href='../../../resources/fullcalendar/packages/bootstrap/main.css'
	rel='stylesheet' />
<!-- bootstrap link end -->


<script src='../../../resources/fullcalendar/packages/core/main.js'></script>
<script
	src="../../../resources/fullcalendar/packages/interaction/main.js"></script>
<script src='../../../resources/fullcalendar/packages/daygrid/main.js'></script>
<script
	src="../../../resources/fullcalendar/packages/timegrid/main.min.js"></script>
<script src="../../../resources/fullcalendar/packages/list/main.min.js"></script>
<script
	src='../../../resources/fullcalendar/packages/core/locales/ko.js'></script>
<!-- interaction 끌어오기. 플러그인에 표시해야 이벤트 작동 -->
<script src='../../../resources/fullcalendar/packages/bootstrap/main.js'></script>

<!-- popper.js 사용을 위한 jquery -->
<!-- <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script> -->

<script>
	document.addEventListener('DOMContentLoaded', function() {
		var calendarEl = document.getElementById('calendar');
		var calendar = new FullCalendar.Calendar(calendarEl, {
			/* dateClick : function() {
				alert('a day has been clicked!');
			}, */
			plugins : [ 'dayGrid', 'timeGrid', 'list', 'interaction'
				/* ,'bootstrap' */ ],
			/* themeSystem : 'bootstrap', */
			header : {
				left : 'addEventBtn today',
				center : 'title',
				right : 'prevYear,prev,next,nextYear'
			},
			locale : 'ko',
			editable : true,
			customButtons : {
				addEventBtn : {
					theme : 'true',
					text : '일정추가',
					click : function() {
						//스케줄러에 이벤트를 추가할 페이지로 이동
						location.href = 'scheduleInsertForm.jsp';
					}
				}
			},
			events : [
				
				<%if (list != null) {
				for (SchedulerVO sch : list) {
					System.out.println(sch);
					System.out.println(sch.getSchTitle());
					System.out.println(sch.getSchDate());
					System.out.println(sch.getSchDetail());
					System.out.println();%>
				{
					title : '<%=sch.getSchTitle()%>',
					start : '<%=sch.getSchDate()%>',
					description : '<%=sch.getSchDetail()%>'
				},
				<%}
			}%>	
			{
				title : 'default',
				start : '2019-01-01',
				description : 'defualt'
			}],
			dateClick : function(info) {
				alert('Clicked on: ' + info.dateStr);
				alert('Coordinates: ' + info.jsEvent.pageX + ','
						+ info.jsEvent.pageY);
				alert('Current view: ' + info.view.type);
			},
			eventClick : function(info) {
				alert('클릭');
				// 클릭시 해당 일자 배경색 바꿈
				// info.dayEl.style.backgroundColor = 'magenta';
			}
		});
		calendar.render();
	});
	
</script>
<style>
#outer {
	border: 1px solid lightgray;
	border-radius: 10px;
	width: 1000px;
	height: 900px;
	display: block;
	margin: 0px auto;
}

#cal-wrap {
	display: block;
	margin: 0px auto;
	margin-top: 50px;
	width: 800px;
	height: 700px;
}

#cal-title {
	display: block;
	margin: 0px auto;
}

#calendar {
	
}
</style>
</head>
<body>

	<%@include file="/views/common/header/newHeader.jsp"%>
	<%@include file="../subMenubar.jsp"%>
	<div id="outer">
		<!-- 이 밖을 1000px로 감싼다. -->
		<div id="cal-wrap">
			<h1 id='cal-title'>일정</h1>
			<hr noshade="noshade">
			<div id='calendar'></div>
		</div>
	</div>
	<%@include file="/views/common/footer/newFooter.jsp"%>
	<!-- 	<script>
		(function() {
			calendar.addEvent(event[{
				title : '모임회',
				start : '2020-07-19',
				description : 'event no.3'
			}]);
			calendar.render();
		}());
	</script> -->
</body>
</html>