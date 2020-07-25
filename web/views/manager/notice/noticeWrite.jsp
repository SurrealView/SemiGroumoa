<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link href="../../../resources/css/notice/notice_write.css" rel="stylesheet">
    <style>
    #writeBoard{
    	border:1px solid black;
    }
    /* .cite{
    	width:200px;
    	height:100px;
    	border:1px solid black;
    } */
    [contenteditable] {
  	outline: 0px solid transparent;
  	font-size:14px;
  	font-style:normal;
  	text-overflow: scroll;
	}
    </style>
</head>
<body>
	<%@ include file="/views/manager/menubar.jsp" %>
	<div class="noticeWrite">
        <div class="writerInfo" align="center">
        <form action="<%=request.getContextPath()%>/insert.no" method="post" encType="multipart/form-data">
            <table id="writeArea">
                <tr>
                    <td colspan="7"><strong>공지사항</strong></td>
                </tr>
                <tr>
                    <td><label>담당자 </label></td>
                    <td colspan="2"><input type="text" name="noManager"></td>
                    <td><label>연락처 </label></td>
                    <td><input type="tel" name="noTel"></td>
                </tr>
                <tr>
                    <td><label>이메일 </label></td>
                    <td colspan="6"><input type="email" name="noEmail"></td>
                </tr>
                <tr>
                    <td><label>제목</label></td>                    
                    <td colspan="5"><input type="text" placeholder="제목을입력해주세요" style="width:400px" name="noTitle"></td>
                    <td colspan="1">
                    <select name="kind">
                        <option value="default">분류</option>
                        <option value="notice">공지</option>
                    </select>
                </td>
                </tr>
                <tr>
                    <td><label>내용</label></td>
                    <td colspan="6"><textarea cols="67" rows="20" style="resize:none" name="noContent"></textarea></td>
                </tr>
                <tr>
                    <td>파일첨부</td>
                    <td colspan="4"><input type="text" class="file_path" placeholder="파일을 올려주세요" readonly style="width:400px" name="filePath"></td>
                    <td colspan="3"><a class="upload" href="#" onclick="uploadFile();">파일선택</a></td>                
                    <input type="file" id="notice_upload" name="notice_upload" style="display: none;">
                </tr>
            </table>
            <button type="submit" class="writeBtn">등록하기</button>
            </form>
        </div>      
                        <!-- <span>내용</span> -->                
    </div>

    <script>
        function uploadFile(){
            //alert("경고!");
            var node = document.getElementById('boardArea');
            
            $("#notice_upload").click();

            $("#notice_upload").change(function(){
                $(".file_path").val($("#notice_upload").val().replace("/C:\\fakepath\\/", ""));
            });
        }       

        $(function() {
            $(".file_path").val($("#notice_upload").val());
            
/*             var txtArea = $("textArea");            
            var selectPos = txtArea.prop("selectionStart"); */
        })
        
        function focusOnBoard(){
        	var board = $("#writeBoard").children("cite").focus();        	
        	/* console.log($("#writeBoard").children("cite").html()); */
        }
    </script>
</body>
</html>