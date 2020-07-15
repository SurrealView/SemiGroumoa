<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% boolean isAnswered = true; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <%-- <%@ include file="../menubar.jsp" %> --%>
<style>

	/* .everylist {
      width:1200px;
      height:650px;
      position:absolute;
      top: 90px;
      left: 230px;
      background-color: white;
   } */

   .content{
   	  position:relative;
   	  left:180px;
   	  top:60px;
      width:1000px;
      height:800px;
      margin:0 auto;
      border: 1px solid #e2d8d8;
      background:white;
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
/*       margin-left:25px; */
   }
   .pagination-div{
      margin:0 330px   ;
   }
   .table tbody tr:hover{
      cursor:pointer;
   }
   .answerdeleteBtn {
      border-radius: 30px;
      float:left;
      margin-left:30px;
      margin-top:-45px;   
   }
   .writeContentBtn{
      border-radius:30px;
      margin-left: 90px;
      margin-top:-45px;
   }
   
   .table {
    width: 100%;
    max-width: 100%;
    margin-bottom: 10px;
    border-collapse: collapse;
    text-align:center;
   }
   
   .questList {
    border-spacing: 0;
    border-collapse: collapse;
    border-color: black;
    vertical-align: middle;
   }
   
   .answerTitle, .answerTitle td {
		padding:10px;
	}
	
	.answerTitle {
		border-bottom:1px solid black;
	}
   
   .noticeWrite{
   	  position:relative;
   	  left:110px;
   	  top:60px;
      width:1000px;
      height:600px;
      margin:0 auto;
      border: 1px solid #e2d8d8;
      background:white;
   }
   
   .payment{
   	display:inline-block;
   	position:fixed;
   	left:201px;
   	top:70px;
   	width:235px;
   	height:400px;
   	background:white;
   }
   
   /* .payment dt{
   	border-bottom:1px solid lightgray;
   	line-height:30px;
   }
   
   .payment dt:hover{
   	background:red;
   	cursor:pointer;
   	color:white;
   } */
   
   /* .pageSample{
    border:1px solid black;
    color:black;
    text-decoration: none;
    font-size: 13px;
    padding:5px;
}

.pageSample:hover{
    background:blue;
    color:white;
} */

.payBtn{
	background:purple;
	color:white;
	width:100px;
	height:40px;
	border-radius: 10%;
}
   
</style>
</head>
<body>
	<%@ include file="/views/manager/menubar.jsp" %>
	<!-- <div class="payment" align="center">
		<dl>
			<dt>전체 비용 내역</dt>
			<dt>광고 비용</dt>
			<dt>인원증설 비용</dt>
			<dt>동호회별 비용</dt>
		</dl>
	</div> -->
	
	<div class="content">      
      <span id="temp">* 결제하신 광고 비용에 대한 내역을 확인하실 수 있습니다.</span>
      <br>
      <h2 id="name" align="center">광고비용</h4>
      <hr>
      <br><br>
      <table class="table">
      <thead>
          <tr>
           <th><input type="checkbox"></th>
           <th>번호</th>
           <th>비용분류</th>
           <th>동호회명</th>
           <th>금액(원)</th>
           <th>일자</th>
          </tr>                    
      </thead>
      <tbody class="adTbody">
      <tr>
         <td><input type="checkbox"></td>
         <td><a href="boardManagement-detail.jsp">1</a></td>
         <td>광고</td>
         <td>푸른뱃고동</td>
         <td>25000</td>
         <td>2020-07-05</td>
      </tr>
       	<tr>
         <td><input type="checkbox"></td>
         <td><a href="boardManagement-detail.jsp">1</a></td>
         <td>광고</td>
         <td>외계인연구소</td>
         <td>25000</td>
         <td>2020-07-05</td>
      </tr>          
      </tbody>
      <tfooter>
      <td>합계</td>
      <td></td>
      <td></td>
      <td></td>
      <td>50000</td>
      <td></td>
      </tfooter>
      </table>
<!--       <a class="pageSample" href="#" onclick="pageMove();">다음</a> -->
	  <div align="center">
      <button class="payBtn" onclick="addAD();">광고넣기</button>
      <button class="payBtn" onclick="addMember();">인원증설</button>
      </div>
    </div> 
       
    <script>
    function pageMove(){
    	$(this).submit();
    }
    
    function addAD(){
    	confirm("광고추가가 완료 되었습니다.");
    	
    	//db에서 불러오는 구문.

    	var $tbody = $(".adTbody");    	    	
    	var $tr = $("<tr>");
    	var $ck = $("<input type='checkbox'>");
    	var $cktd = $("<td>").append($ck);
    	var $notd = $("<td>").text("1");
    	var $kindTd = $("<td>").text("광고");
    	var $nameTd = $("<td>").text("동아리이름");
    	var $priceTd = $("<td>").text("25000");
    	var $dateTd = $("<td>").text("2020-07-15");
    	
		$tr.append($cktd);
		$tr.append($notd);
		$tr.append($kindTd);
		$tr.append($nameTd);
		$tr.append($priceTd);
		$tr.append($dateTd);
		
		$tbody.append($tr);
    	
    }
    
    function addMember(){
    	confirm("인원 증설이 완료 되었습니다.");
    	
    	//db에서 불러오는 구문.
    	
    	var $tbody = $(".adTbody");    	    	
    	var $tr = $("<tr>");
    	var $ck = $("<input type='checkbox'>");
    	var $cktd = $("<td>").append($ck);
    	var $notd = $("<td>").text("1");
    	var $kindTd = $("<td>").text("인원증설");
    	var $nameTd = $("<td>").text("동아리이름");
    	var $priceTd = $("<td>").text("25000");
    	var $dateTd = $("<td>").text("2020-07-15");
    	
		$tr.append($cktd);
		$tr.append($notd);
		$tr.append($kindTd);
		$tr.append($nameTd);
		$tr.append($priceTd);
		$tr.append($dateTd);
		
		$tbody.append($tr);
    	
    }
    </script>      
      
</body>
</html>
