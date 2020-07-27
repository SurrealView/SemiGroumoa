<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="com.kh.groumoa.member.model.vo.MemberVO"%>
<% MemberVO loginUser = (MemberVO) session.getAttribute("loginUser"); %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <style>    
	#writeArea td{
    	padding:10px;
	}

	#writeArea tr{
    	border-bottom: 1px solid black;
	}

	.reportArea td {
    	padding: 10px;
	}
	.reportArea tr {
    	border-bottom: 1px solid black;
	}

	.reportArea{
    	border-collapse:collapse;
    	vertical-align: auto;
	}

	#writeArea{
    	border-collapse:collapse;
    	vertical-align: auto
	}

	.reportWrite{
   	  	position:relative;
   	  	left:110px;
   	  	top:60px;
      	width:1000px;
      height:600px;
      margin:0 auto;
      border: 1px solid #e2d8d8;
      background:white;
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

	.writeBtn{
    	background:purple;
    	color:white;
    	width:100px;
    	height:50px;
    	border-radius: 10%;
	}
	</style>
</head>
<body>
	<%@ include file="/views/manager/menubar.jsp" %>
	<div class="reportWrite">
        <div class="writerInfo" align="center">
        <form action="<%=request.getContextPath()%>/insert.re" method="post" encType="multipart/form-data">
            <table id="writeArea">
                <tr>
                    <td colspan="7"><strong>신고하기</strong></td>
                </tr>
                <tr>
                    <td><label>신고자ID</label></td>
                    <!-- <td colspan="2"><input type="text" name="reporter" value="신고자" readonly></td> -->
                    <% if(loginUser != null) { %>
                    <td colspan="2"><%-- <%=loginUser.getMemberCode() %> --%> <%=loginUser.getEmail() %><input type="hidden" name="reporter" value="<%=loginUser.getMemberCode() %>"></td>
                    <!-- //<input type="text" name="reporter" value="신고자" readonly> -->
                    <% } else { %>
                    <td colspan="2"></td>
                    <% } %>
                </tr>
                <tr>
                    <td><label>피신고자ID</label></td>
                    <td colspan="6"><input type="text" name="reported"></td>
                </tr>
                <tr>
                    <td><label>제목</label></td>                    
                    <td colspan="5"><input type="text" placeholder="제목을입력해주세요" style="width:400px" name="reTitle"></td>
                    <td colspan="1">
                    <select name="kind">
                        <option value="RECA1">광고</option>
                        <option value="RECA2">음란성</option>
                        <option value="RECA3">욕설</option>
                        <option value="RECA4">기타</option>
                    </select>
                </td>
                </tr>
                <tr>
                    <td><label>내용</label></td>
                    <td colspan="6"><textarea cols="67" rows="20" style="resize:none" name="reContent"></textarea></td>
                </tr>
                <tr>
                    <td>파일첨부</td>
                    <td colspan="4"><input type="text" class="file_path" placeholder="파일을 올려주세요" readonly style="width:400px" name="filePath"></td>
                    <td colspan="3"><a class="upload" href="#" onclick="uploadFile();">파일선택</a></td>                
                    <input type="file" id="report_upload" name="report_upload" style="display: none;">
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
            $("#report_upload").click();

            $("#report_upload").change(function(){
                $(".file_path").val($("#report_upload").val());
            });
        }

        $(function() {
            $(".file_path").val($("#report_upload").val());
            
/*             var txtArea = $("textArea");            
            var selectPos = txtArea.prop("selectionStart"); */
        });
    </script>
</body>
</html>