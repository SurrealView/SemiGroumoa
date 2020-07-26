<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.groumoa.common.model.vo.*, com.kh.groumoa.report.model.vo.*, java.util.*"%>
<%
	ReportVo report = (ReportVo) request.getAttribute("report");
	ArrayList<AttachmentVo> list = (ArrayList<AttachmentVo>) request.getAttribute("fileList");
	int idx = 0;
	AttachmentVo attach = null;
	if(list.size() > 0){
		attach = list.get(idx);	
	}
	
	String fileList = "";
		
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>    
	#detailArea td{
    	padding:10px;
	}

	#detailArea tr{
    	border-bottom: 1px solid black;
	}

	.reportArea td {
    	padding: 10px;
	}
	.reportArea tr {
    	border-bottom: 1px solid black;
	}

	.detailArea{
    	border-collapse:collapse;
    	vertical-align: auto;
	}

	#detailArea{
    	border-collapse:collapse;
    	vertical-align: auto
	}

	.reportDetailArea{
   	  position:relative;
   	  left:110px;
   	  top:60px;
      width:1000px;
      height:600px;
      margin:0 auto;
      border: 1px solid #e2d8d8;
      background:white;
      overflow:hidden;
	  height:auto; 
	}

	.upload{
    	border:1px solid black;
    	color:black;
    	text-decoration: none;
    	font-size: 13px;
    	padding:5px;
	}

	.upload:hover{
    	text-decoration: underline;
	}
	.emptysp{
		height:100px;
	}
	</style>

</head>
<body>
	<%@ include file="/views/manager/menubar.jsp" %>
	<div class="reportDetailArea">
        <div class="detailInfo" align="center">
            <table id="detailArea">
                <tr>
                    <td colspan="7"><strong>신고하기</strong></td>
                </tr>
                <tr>
                    <td><label>신고자ID</label></td>
                    <!-- <td colspan="2"><input type="text" name="reporter" value="신고자" readonly></td> -->
                    <td colspan="2"><%=report.getReporterID() %><input type="hidden" name="reporter" value="<%=report.getReporter() %>"></td>                    
                </tr>
                <tr>
                    <td><label>피신고자ID</label></td>
                    <td colspan="6"><%=report.getReportedID() %><input type="hidden" name="reporter" value="<%=report.getReported() %>"></td>
                </tr>
                <tr>
                    <td><label>제목</label></td>                    
                    <td colspan="5"><pre style="width:400px"><%=report.getReportTitle() %></pre></td>
                    <td colspan="1"><%=report.getReportCategory() %></td>
                </tr>
                <tr>
                    <td><label>내용</label></td>
                    <td colspan="6"><pre><%=report.getReportDetail() %></pre>
                    <br>
                    <% if(attach != null) { %>
                    <img src="<%=request.getContextPath() %>/upload_reportFiles/<%=attach.getChangeName() %>">
                    <% } %>
                    </td>                    
                </tr>                                    
            </table>
            <div class="emptysp"></div>
        </div>      
                        <!-- <span>내용</span> -->                
    </div>
    
    <script>    
    </script>
</body>
</html>