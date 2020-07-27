<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>개인 정보 취급 방침</title>
<style>
body {
	background: rgb(180, 180, 180);
	width: 800px;
	height: 90%;
	display: table-cell;
	vertical-align: middle;
	text-align: center;
}

.content textarea {
	border: 1px solid #cccccc;
	resize: none;
	background: #cccccc;
	color: black;
	width: 500px;
	height: 350px;
	margin-top: 50px;
	border-radius: 30px;
}

#apply-title {
	font-size: 20px;
	height: 30px;
	width: 500px;
	background: #cccccc;
	border-radius: 15px;
	border: 1px solid #cccccc;
	display: block;
	margin: 0px auto;
}
</style>
</head>
<body>
	<br>
	<div class="content">
		<div id="apply-title">자기소개 작성</div>
		<form>
		<textarea>

        </textarea>
        	<br>
			<br> <input type="submit" onClick="" value="신청하기"> <input
				type="reset" onClick="window.close()" value="취소하기">
		</form>
	</div>
</body>
</html>