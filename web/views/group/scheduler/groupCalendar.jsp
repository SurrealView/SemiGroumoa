<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
<script src='../../../resources/fullcalendar/packages/daygrid/main.js'></script>
<script
	src='../../../resources/fullcalendar/packages/core/locales/ko.js'></script>
<script
	src="../../../resources/fullcalendar/packages/timegrid/main.min.js"></script>
<script src="../../../resources/fullcalendar/packages/list/main.min.js"></script>
<!-- interaction 끌어오기. 플러그인에 표시해야 이벤트 작동 -->
<script
	src="../../../resources/fullcalendar/packages/interaction/main.js"></script>
<script src='../../../resources/fullcalendar/packages/bootstrap/main.js'></script>

<script>
	document.addEventListener('DOMContentLoaded', function() {
		var calendarEl = document.getElementById('calendar');

		var calendar = new FullCalendar.Calendar(calendarEl, {
			/* dateClick : function() {
				alert('a day has been clicked!');
			}, */
			plugins : [ 'dayGrid', 'timeGrid', 'list', 'interaction',
					'bootstrap' ],
			themeSystem : 'bootstrap',
			editable: true,
			locale : 'ko',
			customButtons : {
				addEventBtn : {
					theme : 'true',
					text : '일정추가',
					click : function() {
						//스케줄러에 이벤트를 추가할 페이지로 이동
						location.href='scheduleInsertForm.jsp';
					}
				}
			},
			header : {
				left : 'addEventBtn today',
				center : 'title',
				right : 'prevYear,prev,next,nextYear'
			},
			events : [ {
				id : '0000001',
				title : '모임회',
				start : '2020-07-22',
				end : '2019-07-22'
			} ],
			dateClick : function(info) {
				alert('Clicked on: ' + info.dateStr);
				alert('Coordinates: ' + info.jsEvent.pageX + ','
						+ info.jsEvent.pageY);
				alert('Current view: ' + info.view.type);
			},
			eventClick : function(info) {
				alert('이벤트클릭');
				alert('이벤트 아이디 : ' + calendar.getEventById(id));
				// 클릭시 해당 일자 배경색 바꿈
				// info.dayEl.style.backgroundColor = 'magenta';
			}
		});
		calendar.render();

	});
</script>
<style>
#outer {
	border: 1px solid black;
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
	<!-- 헤더 추가 필요 -->
	<%@include file="../subMenubar.jsp"%>
	<div id="outer">
		<!-- 이 밖을 1000px로 감싼다. -->
		<div id="cal-wrap">
			<h1 id='cal-title'>일정</h1>
			<hr noshade="noshade">
			<div id='calendar'></div>
		</div>
	</div>
	<script>
/* 		$(function() {
			calendar.changeView('timeGrid', {
				start : '2020-07-01',
				end : '2020-07-05'
			});
		}); */
	</script>
</body>
</html>