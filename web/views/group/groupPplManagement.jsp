<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.groumoa.member.model.vo.*, com.kh.groumoa.group.model.vo.*, com.kh.groumoa.common.*, java.util.*" %>
<%
	ArrayList<MemberVO> list = (ArrayList<MemberVO>) request.getAttribute("list");
  	PageInfo pi = (PageInfo) request.getAttribute("pi");
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();	 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Groumoa</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
	.content{
		width:1000px;
		height:1500px;
		margin:0 auto;
		border: 1px solid #e2d8d8;
		border-radius: 10px;
	}
	.tab{
		width:950px;
		height:50px;
		margin-top: 0px;
		margin-left: 25px;
		border-bottom:1px solid #e2d8d8;
	}
	.item{
		display: inline-block;
		float:left;
		font-size: 12px;
		font-weight:bold;
		text-align:center;
		width:100px;
		height:20px;
		border: 1px solid #e2d8d8;
		margin-top: 30px;
		background-color:rgba(235, 235, 235, 0.493);
	}
	#sub-title{
		margin-left: 25px;
	}
	.item a {
			text-decoration: none;
			color: black;
			
	}
	.active {
		border-bottom:1px solid white;
	}
	.active a{
		color:rgb(70, 107, 228);
	}
	#searchbox{
		margin: 0 330px;
	}
	#searchbox select {
		float: left;
	}
	#searchbox input {
		float: left;
	}
	.form-control{
		width:100px;
		height:35px;
		
	}
	#temp{
		display:inline-block;
		float:left;
		font-size:10px; 
		padding-left: 25px;
		padding-top: 15px;
		color:rgba(75, 75, 75, 0.493);
	}
	.table{
		width:950px;
		margin-left:25px;
	}
	.pagination-div{
		margin:0 330px	;
	}
	.table tbody tr:hover{
		cursor:pointer;
	}
	.kickBtn {
		float:left;
		margin-left:30px;
		border: none;
  		color: white;
  		padding: 5px 10px;
  		text-align: center;
  		text-decoration: none;
  		display: inline-block;
  		font-size: 16px;
  		margin: 4px 10px;
  		transition-duration: 0.4s;
  		cursor: pointer;
  		background-color: white;
  		color: black;
 		border: 2px solid #555555;
 		margin-left:50px;
 		position:absolute;
 		top: 900px;
	}
	.inviteBtn{
		border: none;
  		color: white;
  		padding: 5px 10px;
  		text-align: center;
  		text-decoration: none;
  		display: inline-block;
  		font-size: 16px;
  		margin: 4px 10px;
 		transition-duration: 0.4s;
  		cursor: pointer;
  		background-color: white;
  		color: black;
  		border: 2px solid #555555;
  		position:absolute;
 		top: 900px;
 		left:400px;
	}
	.kickBtn:hover {
 		background-color: #555555;
  		color: white;
	}
	.inviteBtn:hover {
		background-color: #555555;
  		color: white;
	}
</style>
</head>
<body>
	<%@include file="../common/header/newHeader.jsp"%>
	<%@include file="subMenubar.jsp" %>
	<div class="content">
		<p align="right" style="font-size:10px; padding-right: 25px; padding-top: 15px;">개인정보취급방침에 따라 최근 5년간의 내역이 제공됩니다.</p>
		<div id="sub-title"><span style="font-size: 15px">회원 관리</span></div>
		<div class="tab" id="tab">
			<div class="item active" id="pplManagement"><a href="#">회원 관리</a></div>
		</div>
		
		<br><br>
		<div class="table-div">
			<h2 align="center">회원</h2>         
   			<form id="kickout" method="post" action="<%=request.getContextPath() %>/kickout.ko">
   			<table class="table table-striped">
                  <thead>
                    <tr>
                      <th>선택</th>
                      <th>번호</th>
                      <th>이름</th>
                      <th>직책</th>
                      <th>전화번호</th>
                      <th>이메일</th>
                      <th>가입일자</th>
                    </tr>
                  </thead>
                  <tbody>
                   	<% for(MemberVO m : list) { %>
                    <tr>
                      <input type="hidden" name="check">
                      <td><input type="checkbox" id="checkList"></td>
                      <td><a href="pplManagement-detail.jsp"><%=m.getMemberCode() %></a></td>
                      <td><%= m.getUserName() %></td>
                      <td><%= m.getGroupCode() %></td>
                      <td><%= m.getPhone() %></td>
                      <td><%= m.getEmail() %></td>
                      <td><%= m.getEnrollDate() %></td>
                    </tr>
                    <% } %> 
                  </tbody>
                </table>
                </div>
                
                <!-- 회원일 경우 --><!--  
               <div class="table-div">
				<h2 align="center">게시판</h2>         
   				<table class="table table-striped">
                 <thead>
                    <tr>
                      <th><input type="checkbox"></th>
                      <th>번호</th>
                      <th>이름</th>
                      <th>직책</th>
                      <th>전화번호</th>
                      <th>이메일</th>
                      <th>가입일자</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td><input type="checkbox"></td>
                      <td><a href="pplManagement-detail.jsp">1</a></td>
                      <td>김승열</td>
                      <td>모임장</td>
                      <td>010-1234-1234</td>
                      <td>yeori-kim@gmail.com</td>
                      <td>2020-07-01</td>
                    </tr>
                    <tr>
                      <td><input type="checkbox"></td>
                        <td>2</td>
                        <td>김형진</td>
                        <td>총무</td>
                        <td>010-1234-5678</td>
                        <td>hyung@gmail.com</td>
                        <td>2020-07-05</td>
                      </tr>
                      <tr>
                        <td><input type="checkbox"></td>
                        <td>3</td>
                        <td>정상현</td>
                        <td>회원</td>
                        <td>010-1234-3333</td>
                        <td>sang@gmail.com</td>
                        <td>2020-07-05</td>
                      </tr>
                      <tr>
                        <td><input type="checkbox"></td>
                        <td>3</td>
                        <td>정상현</td>
                        <td>회원</td>
                        <td>010-1234-3333</td>
                        <td>sang@gmail.com</td>
                        <td>2020-07-05</td>
                      </tr>
                      <tr>
                        <td><input type="checkbox"></td>
                        <td>3</td>
                        <td>정상현</td>
                        <td>회원</td>
                        <td>010-1234-3333</td>
                        <td>sang@gmail.com</td>
                        <td>2020-07-05</td>
                      </tr>
                      <tr>
                        <td><input type="checkbox"></td>
                        <td>3</td>
                        <td>정상현</td>
                        <td>회원</td>
                        <td>010-1234-3333</td>
                        <td>sang@gmail.com</td>
                        <td>2020-07-05</td>
                      </tr>
                     <tr>
                        <td><input type="checkbox"></td>
                        <td>3</td>
                        <td>정상현</td>
                        <td>회원</td>
                        <td>010-1234-3333</td>
                        <td>sang@gmail.com</td>
                        <td>2020-07-05</td>
                      </tr>
                      <tr>
                        <td><input type="checkbox"></td>
                        <td>3</td>
                        <td>정상현</td>
                        <td>회원</td>
                        <td>010-1234-3333</td>
                        <td>sang@gmail.com</td>
                        <td>2020-07-05</td>
                      </tr>
                     <tr>
                        <td><input type="checkbox"></td>
                        <td>3</td>
                        <td>정상현</td>
                        <td>회원</td>
                        <td>010-1234-3333</td>
                        <td>sang@gmail.com</td>
                        <td>2020-07-05</td>
                      </tr>
                      <tr>
                        <td><input type="checkbox"></td>
                        <td>3</td>
                        <td>정상현</td>
                        <td>회원</td>
                        <td>010-1234-3333</td>
                        <td>sang@gmail.com</td>
                        <td>2020-07-05</td>
                      </tr>
                  </tbody>
                </table>
                </div> -->
                <!-- 회원일 경우 끝 -->
                
                <br>
<!--                 <div class="pagination-div">
                <ul class="pagination">
                	<li class="page-item"><a class="page-link" href="#"><<</a></li>
  					<li class="page-item"><a class="page-link" href="#"><</a></li>
  					<li class="page-item"><a class="page-link" href="#">1</a></li>
  					<li class="page-item active"><a class="page-link" href="#">2</a></li>
  					<li class="page-item"><a class="page-link" href="#">3</a></li>
  					<li class="page-item"><a class="page-link" href="#">4</a></li>
  					<li class="page-item"><a class="page-link" href="#">5</a></li>
  					<li class="page-item"><a class="page-link" href="#">></a></li>
  					<li class="page-item"><a class="page-link" href="#">>></a></li>
				</ul>
				</div>
 -->		
				 <div class="pagingArea" align="center">
			<button onclick="location.href='<%=request.getContextPath()%>/managerGroupMember.mn?currentPage=1'"><<</button>
			
			<% if(currentPage <= 1) { %>
			<button disabled><</button>
			<% } else { %>
			<button onclick="location.href='<%=request.getContextPath()%>/managerGroupMember.mn?currentPage=<%=currentPage - 1%>'"><</button>
			<% } %>
			
			<% for(int p = startPage; p <= endPage; p++) { 
					if(p == currentPage) {
			%>
						<button disabled><%= p %></button>
			<%      } else { %>
						<button onclick="location.href='<%=request.getContextPath()%>/managerGroupMember.mn?currentPage=<%=p%>'"><%= p %></button>
			<%  
			        }
				}
			%>
			
			<% if(currentPage >= maxPage) { %>
			<button disabled>></button>
			<% } else { %>
			<button onclick="location.href='<%=request.getContextPath()%>/managerGroupMember.mn?currentPage=<%=currentPage + 1%>'">></button>
			<% } %>
		
			<button onclick="location.href='<%=request.getContextPath()%>/managerGroupMember.mn?currentPage=<%=maxPage%>'">>></button>
			<br>
			<div id="Btn">
				<button id="backBtn">이전페이지</button>&nbsp;
				<button id="detailBtn">정보확인</button>
			</div>
			
		</div> 

				
				<button class="kickBtn">강퇴하기</button>
				<button class="inviteBtn">초대하기</button>
				</form>
                <div class="searchbox" id="searchbox">
					<form>
						<select class="form-control">
	  						<option>이름</option>
	  						<option>직책</option>
						</select>
						<input type="text" placeholder="회원 검색" style="height:35px;">
						 <button type="submit"><i class="fa fa-search" style="height:25px"></i></button>
					</form>
					
				</div>
		</div>
		<!-- footer 추가할것 -->
		
		<script>
		function kickout(){
			$("#kickoutForm").attr("action", "<%=request.getContextPath()%>/kickout.ko");
		}
		
		$("#kickBtn").click(function(){
			var member = [];
			$.each($("#checkList:checked").parent().prev(), function(){
				feeCode.push($(this).val());
				$(this).attr("name", "memberCode");
			});
			
			if(window.confirm('정말로 해당 게시물을 삭제하시겠습니까?')) {
				$("#kickout").submit();
			}
			
		});
		
<%-- 		function kickout() {
			var kick = document.getElementsByName("check");
			
			console.log(hobby);
			
			var checkItem = "";
			
			for(var i in check) {
				if(checck[i].checked) {
					checkItem += check[i].value;
				}
			}
			
			var result = window.confirm("정말 강퇴하시겠습니까?");
			
			console.log(result);
			
			var gang ="";
			
			if(result) { 
   				gang = $("#kickoutForm").attr("action", "<%=request.getContextPath()%>/kickout.ko");
			} else {
				gang = null;
			}
			
		} --%>
		</script>
		<%@include file="../common/footer/newFooter.jsp" %>
</body>
</html>