<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link href="../../../resources/css/notice/noticeDetail.css" rel="stylesheet">
</head>
<body>
	<%@ include file="/views/manager/menubar.jsp" %>
	<div class="noticeSection">
        <div class="noticeInfo" align="center">
            <table class="noticeArea">
                <tr>
                    <td colspan="7"><strong>공지사항</strong></td>
                </tr>
                <tr>
                    <td><label>담당자 </label></td>
                    <td colspan="6"><input type="text"></td>
                </tr>
                <tr>
                    <td><label>연락처 </label></td>
                    <td colspan="2"><input type="tel"></td>
                    <td><label>이메일 </label></td>
                    <td colspan="2"><input type="email"></td>
		                          <!--  줄맞추기 용. -->
                    <td></td>
                </tr>
                <tr>
                    <td><label>제목</label></td>                    
                    <td colspan="5"><input type="text" placeholder="제목을입력해주세요" style="width:400px"></td>
                    <td><input type="text" style="width:80px"></td>
                </tr>
                <tr>
                    <td><label>내용</label></td>
                    <!-- <td colspan="6"><textarea cols="62" rows="10" style="resize:none"></textarea></td> -->
                    <td colspan="6">내용. 내용내용내용내용<br><br><br><br><br><br><br><br><br>내용</td>
                </tr>
            </table>
            <button type="submit" class="gotoMain">목록</button>
            <button type="submit" class="adjust">수정하기</button>
        </div>      
                        <!-- <span>내용</span> -->                
    </div>

    <script>
        function uploadFile(){
            //alert("경고!");
            $("#notice_upload").click();

            $("#notice_upload").change(function(){
                $(".file_path").val($("#notice_upload").val());
            });
        }

        $(function() {
            $(".file_path").val($("#notice_upload").val());
        })
    </script>
</body>
</html>