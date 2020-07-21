<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1:1 문의하기</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
#ask {
	border-bottom: 1px solid black;
	text-align: left;
	width: 570px;
	margin-left: auto;
	margin-right: auto;
	margin-top: 50px;
}

.wrap {
	background: white;
	width: 100%;
	height: 50px;
	text-align: center;
}

.nav {
	width: 600px;
	margin: 0 auto;
}

.menu {
	background: white;
	color: black;
	text-align: center;
	display: table-cell;
	vertical-align: middle;
	width: 150px;
	height: 50px;
}

.menu:hover {
	background: #461212;
	color: white;
	font-weight: bold;
	cursor: pointer;
}
.qWrite {
	margin-top: 50px;
}
</style>
</head>
<body>
	<%@ include file="../common/header/newHeader.jsp"%>
	<div class="wrap">
		<div class="nav">
			<div class="menu">공지사항</div>
			<div class="menu">고객센터</div>
			<div class="menu">자주하는 질문</div>
			<div class="menu">문의하기</div>
		</div>
	</div>
	<div id="ask">1:1 문의하기</div>
	<div class="qWrite">
        <div class="qWriterInfo" align="center">
        <form action="" method="post" encType="multipart/form-data">
            <table id="QWriteArea">
                <tr>
                    <td><label>이름 </label></td>
                    <td colspan="2"><input type="text" name="qManager"></td>
                    <td><label>연락처 </label></td>
                    <td><input type="tel" name="noTel"></td>
                </tr>
                <tr>
                    <td><label>이메일 </label></td>
                    <td colspan="6"><input type="email" name="qEmail"></td>
                </tr>
                <tr>
                    <td><label>제목</label></td>                    
                    <td colspan="5"><input type="text" placeholder="제목을입력해주세요" style="width:400px" name="qTitle"></td>
                    <td colspan="1">
                    <select name="kind">
                        <option value="default">분류</option>
                        <option value="normal">일반</option>
                        <option value="error">오류</option>
                        <option value="account">계정</option>
                        <option value="fuction">기능</option>
                    </select>
                </td>
                </tr>
                <tr>
                    <td><label>내용</label></td>
                    <td colspan="6"><textarea cols="67" rows="20" style="resize:none" name="qContent"></textarea></td>
                </tr>
                <tr>
                    <td>파일첨부</td>
                    <td colspan="4"><input type="text" class="file_path" placeholder="파일을 올려주세요" readonly style="width:400px" name="filePath"></td>
                    <td colspan="3"><a class="upload" href="#" onclick="uploadFile();">파일선택</a></td>                
                    <input type="file" id="notice_upload" name="notice_upload" style="display: none;">
                </tr>
            </table>
            <button type="submit" class="qWriteBtn">등록하기</button>
            </form>
        </div>      
                                     
    </div>
</body>
</html>