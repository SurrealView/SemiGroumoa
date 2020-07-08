<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<title>그룹 페이지</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
.wrapper {
	border: 1px solid black;
	margin: auto;
	padding-top: 50px;
	padding-bottom: 50px;
	height: auto;
	width: 1000px;
	/* display: table-cell;
		    vertical-align: middle; */
	display: block;
	margin: 0px auto;
}

.content {
	border: 1px solid black;
	display: block;
	margin: 0px auto;
	/* position: absolute;
            top: 50%;
            left: 50%;  */
	height: 900px;
	width: 800px;
}

.content hr {
	width: 720px;
	margin: 0 auto;
}

.content button {
	width: 70px;
	height: 25px;
	border-radius: 50px;
	background: transparent;
	border: 1px solid black;
	margin: 7px;
	position: relative;
	left: 30px;
}
</style>
</head>

<body>
	<%@ include file="../common/header/header.jsp"%>
	<%@ include file="../common/nav.jsp"%>
	<div class="blank">
		<strong>
			<div class="wrapper">
				<div class="content">
					<div>
						<br>
						<button>최근일정</button>
						<button>회비내역</button>
						<button>게시판</button>
						<button>모임회원</button>
					</div>
					<br>
					<hr noshade="noshade" size="1px" color="black">
				</div>
			</div>
		</strong>
	</div>
	<%@ include file="../common/footer/footer.jsp"%>

</body>

</html>