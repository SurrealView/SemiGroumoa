<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.groumoa.notice.model.vo.*, java.util.*, com.kh.groumoa.common.model.vo.*" %>
<%
	NoticeVo notice = (NoticeVo) request.getAttribute("notice");
	ArrayList<AttachmentVo> list = (ArrayList<AttachmentVo>) request.getAttribute("fileList");
	int idx = 0;
	AttachmentVo attach = list.get(idx);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link href="/groumoa/resources/css/notice/notice_write.css" rel="stylesheet">
</head>
<body>
	<%@ include file="/views/manager/menubar.jsp" %>
	<div class="noticeWrite">
        <div class="writerInfo" align="center">
        <form action="<%=request.getContextPath()%>/update.no" method="post" encType="multipart/form-data">
            <table id="writeArea">
                <tr>                	
                	<input type="hidden" name="noticeId" value="<%=notice.getNoticeCode() %>">
                    <td colspan="7"><strong>공지사항</strong></td>
                </tr>
                <tr>
                    <td><label>담당자 </label></td>
                    <td colspan="2"><input type="text" name="noManager" value="<%=notice.getMnWriterID() %>"></td>
                    <td><label>연락처 </label></td>
                    <td><input type="tel" name="noTel"></td>
                </tr>
                <tr>
                    <td><label>이메일 </label></td>
                    <td colspan="6"><input type="email" name="noEmail" value="<%=notice.getMnWriterID() %>"></td>
                </tr>
                <tr>
                    <td><label>제목</label></td>                    
                    <td colspan="5"><input type="text" value="<%=notice.getNoticeTitle() %>" style="width:400px" name="noTitle"></td>
                    <td colspan="1">
                    <select name="kind">
                        <option value="default">분류</option>
                        <option value="notice">공지</option>
                    </select>
                </td>
                </tr>
                <tr>
                    <td><label>내용</label></td>
                    <td colspan="6"><textarea cols="67" rows="20" style="resize:none" name="noContent"><%=notice.getNoticeDetail() %></textarea></td>
                </tr>
                <tr>
                    <td>파일첨부</td>
                    <td colspan="4"><input type="text" class="file_path" readonly style="width:400px" name="filePath"></td>
                    <td colspan="3"><a class="upload" href="#" onclick="uploadFile();">파일선택</a></td>                
                    <%-- <input type="file" id="notice_upload" name="notice_upload" value="<%=attach.getFilePath() %>/<%=attach.getChangeName() %>.PNG" style="display: none;"> --%>                    
                    <input type="file" id="notice_upload" name="notice_upload" value="<%=attach.getFilePath() %>/<%=attach.getChangeName() %>.PNG">
                </tr>
            </table>
            <button type="submit" class="writeBtn">등록하기</button>
            </form>
        </div>      
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