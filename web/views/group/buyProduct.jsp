<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
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
	
	#temp{
		display:inline-block;
		float:left;
		font-size:10px; 
		padding-left: 25px;
		padding-top: 15px;
		color:rgba(75, 75, 75, 0.493);
	}
	.content-area{
		width:950px;
		height:800px;
		margin:0 auto;
	}
	.form-area{
		margin:15px 25px;
	}
	.category, .title, .writer, .payedDate {
		display:inline-block;
		width:100px;
	}
	
  </style>
</head>
<body>
	<%@include file="../common/header/newHeader.jsp" %>
	<%@include file="subMenubar.jsp" %>
	<br>
	<div class="content">
	<p align="right" style="font-size:10px; padding-right: 25px; padding-top: 15px;">개인정보취급방침에 따라 최근 5년간의 내역이 제공됩니다.</p>
		<div id="sub-title"><span style="font-size: 20px; margin-left:25px">결제하기</span></div>
		<!-- 뒤로가기 glyphicon 추가하기 -->
		
		
		<br><br>
		
		<div class="content-area">
			<div class="form-area">
				<form>
					<label for="title">결제금액(원)</label>&nbsp;&nbsp;
					<input type="text" class="form-control title" value="25,000" id="title" style="width:350px" readonly>&nbsp;
					<br><br>
					<label for="category">분류</label>&nbsp;&nbsp;
					<select class="form-control category" style="width:150px">
						<option value="P1">인원증설(30명)</option>
					</select>
					&nbsp;&nbsp;	
					<label for="writer">결제자</label>&nbsp;&nbsp;
					<input type="text" class="form-control writer" value="<%=loginUser.getUserName() %>" readonly>&nbsp;&nbsp;
					<label for="payedDate">결제일</label>&nbsp;&nbsp;
					<input type="date" class="form-control payedDate" value="" style="width:200px;" readonly><br><br>
					<br><br>
					<!-- 자기 자신의 게시글일 경우에만 보임 -->
					<!--<button class="btn btn-primary" onclick="">수정하기</button>  -->
				</form>
				<button class="btn btn-danger" onclick="pay();">결제하기</button>	
			</div>
		</div>
	</div>
	
	<script>
		function pay() {
			
			var IMP = window.IMP; 
			IMP.init('imp93554119'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
			
			IMP.request_pay({
			    pg : 'inicis',
			    pay_method : 'card',
			    merchant_uid : 'merchant_' + new Date().getTime(),
			    name : '주문명:결제테스트',
			    amount : 100,
			    buyer_email : 'iamport@siot.do',
			    buyer_name : '구매자이름',
			    buyer_tel : '010-1234-5678',
			    buyer_addr : '서울특별시 강남구 삼성동',
			    buyer_postcode : '123-456'
			}, function(rsp) {
			    if ( rsp.success ) {
			    	//[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
			    	$.ajax({
			    		url: "<%=request.getContextPath()%>/insertHistory.pr", //cross-domain error가 발생하지 않도록 동일한 도메인으로 전송
			    		type: 'POST',
			    		dataType: 'json',
			    		data: {
				    		pbCode : rsp.imp_uid,
				    		payerCode : '<%=loginUser.getMemberCode()%>',
				    		productCode : 'P1', //나중에 수정필요
				    		groupCode : '<%=selectedGroup.getGroupCode()%>'
				    		//기타 필요한 데이터가 있으면 추가 전달
			    		}
			    	}).done(function(data) {
			    		//[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
			    		if ( everythings_fine ) {
			    			var msg = '결제가 완료되었습니다.';
			    			msg += '\n고유ID : ' + rsp.imp_uid;
			    			msg += '\n상점 거래ID : ' + rsp.merchant_uid;
			    			msg += '\결제 금액 : ' + rsp.paid_amount;
			    			msg += '카드 승인번호 : ' + rsp.apply_num;

			    			alert(msg);
			    		} else {
			    			//[3] 아직 제대로 결제가 되지 않았습니다.
			    			//[4] 결제된 금액이 요청한 금액과 달라 결제를 자동취소처리하였습니다.
			    		}
			    	});
			    } else {
			        var msg = '결제에 실패하였습니다.';
			        msg += '에러내용 : ' + rsp.error_msg;

			        alert(msg);
			    }
			});
			
			
			
			
		}
	</script>
	
 		<%@include file="../common/footer/footer.jsp" %> 
</body>
</html>