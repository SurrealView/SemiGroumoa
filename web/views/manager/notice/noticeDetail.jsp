<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.groumoa.common.model.vo.*, com.kh.groumoa.notice.model.vo.*, java.util.*"%>
<%
	NoticeVo notice = (NoticeVo) request.getAttribute("notice");
	ArrayList<AttachmentVo> list = (ArrayList<AttachmentVo>) request.getAttribute("fileList");
	int idx = 0;
	AttachmentVo attach = list.get(idx);
	
	String fileList = "";
		
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link href="/groumoa/resources/css/notice/noticeDetail.css" rel="stylesheet">
</head>
<body>
	<%@ include file="/views/manager/menubar.jsp" %>
	<div class="noticeSection">
        <div class="noticeInfo" align="center">
            <table class="noticeArea">s
                <tr>
                	<input type="hidden" name="noticeId" value="<%=notice.getNoticeCode() %>">                	
                    <td colspan="7"><strong>공지사항</strong></td>
                </tr>
                <tr>
                    <td><label>담당자 </label></td>
				<!--<td colspan="6"><input type="text"></td> -->
					<td colspan="6"><%=notice.getMnWriterID() %></td>
                </tr>
                <tr>
                    <td><label>연락처 </label></td>
                    <td colspan="2"><input type="tel"></td>
<!--                     <td colspan="2"><input type="tel"></td> -->
                    <td><label>이메일 </label></td>
<%--                     <td colspan="2"><%=notice.getMnWriterID() %></td> --%>
                    <td colspan="2"><input type="email"></td>
		                          <!--  줄맞추기 용. -->
                    <td></td>
                </tr>
                <tr>
                    <td><label>제목</label></td>                    
                    <td colspan="5"><input type="text" placeholder="제목을입력해주세요" style="width:400px"></td>
                    <%-- <td colspan="5"><%=notice.getNoticeTitle() %></td> --%>
                    <td><input type="text" style="width:80px"></td>
                </tr>
                <tr>
                    <td><label>내용</label></td>
                    <!-- <dtd colspan="6"><textarea cols="62" rows="10" style="resize:none"></textarea></td> -->
                    <td colspan="6"><pre><%=notice.getNoticeDetail() %></pre><br>
                    <%-- <img src="<%=request.getContextPath() %>/notice_uploadFiles/<%=attach.getChangeName() %>"> --%>
                    <img src="<%=request.getContextPath() %>/notice_uploadFiles/<%=attach.getChangeName() %>">
<%--                     <img id="titleImg" src="<%=request.getContextPath() %>/thumbnail_uploadFiles/<%=titleImg.getChangeName() %>">	 --%>
                    </td>
                </tr>
            </table>
            <button type="submit" class="noDetailBtn" id="gotoNoticeMenu">목록</button>
            <!-- <button type="submit" class="noDetailBtn" id="adjust">수정하기</button> -->
            <button id="adjust" onclick="location.href='<%=request.getContextPath()%>/select.no?num=<%=notice.getnNo()%>'">수정하기</button>
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