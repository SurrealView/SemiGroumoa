<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.footer-wrapper {
	margin: 0;
	padding: 0;
	list-style: none;
	text-decoration: none;
}

.footer {
	width: 98.9vw;
	height: 250px;
	display: block;
	overflow: hidden;
	padding: 30px 0;
	box-sizing: border-box;
	background-color: #e8e8e8;
}

.inner-footer {
	display: block;
	margin: 0 auto;
	width: 100%;
	height: 100%;
}

.inner-footer .logo {
	width: 35%;
	float: left;
	height: 100%;
	display: block;
}

.inner-footer .logo img {
	padding-left:200px;
	width: 100px;
	height: auto;
}

.inner-footer .footer-third {
	width: calc(21.66666667% - 20px);
	margin-right: 10px;
	float: left;
	height: 100%;
}

.inner-footer .footer-third:last-child {
	margin-right: 0;
}

.inner-footer .footer-third h1 {
	font-family: 'arial';
	font-size: 16px;
	color: gray;
	display: block;
	width: 100%;
	margin-bottom: 20px;
	padding-top:10px;
}

.inner-footer .footer-third a {
	font-size: 12px;
	color: gray;
	display: block;
	width: 100%;
	text-decoration: none;
	margin-bottom: 5px;
	padding-bottom: 5px;
}

.inner-footer .footer-third li {
	display: inline-block;
	padding: 0 5px;
	font-size: 16px;
}

.inner-footer .footer-third span {
	font-family: 'arial';
	color: gray;
	font-size: 12px;
	font-weight: 200;
	display: block;
	width: 100%;
	padding-top: 5px;
}

.copyright {
	font-size: 10px;
	padding-left:100px;
}

@media ( max-width : 600px) {
	.footer .inner-footer {
		width: 90%;
	}
	.inner-footer .logo, .inner-footer .footer-third {
		width: 100%;
		margin-bottom: 30px;
	}
}
</style>
</head>
<body>
	<div class="footer-wrapper">
		<div class="footer">
			<div class="inner-footer">
				<div class="logo">
					<!-- <img src="../../../resources/image/logo_groumoa2.png"> -->
					<img src="/groumoa/resources/image/logo_groumoa2.png"> <br>
					<br>
					<div class="copyright">
						그루모아는 통신판매중개자이며 모임에 대한 당사자 및 주최자가 아닙니다.<br> 
						따라서 그루모아는 등록된 모임에 대하여 책임을 지지 않습니다.
					</div>
					<br>
					<div class="copyright">copyright © GROUMOA.COM, All Rights Reserved.</div>
				</div>

				<div class="footer-third">
					<h1>
						회사 소개
					</h1>
					<a href="<%=request.getContextPath()%>/views/pages/personalInfoRule.jsp" onclick="window.open(this.href, '_blank', 
                'width=700px, height=750px, toolbars=no, scrollbars=no, resizable=no'); return false;">서비스 약관 및 정책</a> 
                	<a href="<%=request.getContextPath()%>/views/pages/serviceTermsRule.jsp" onclick="window.open(this.href, '_blank', 
                'width=700px, height=750px, toolbars=no, scrollbars=no, resizable=no'); return false;">개인 정보 취급 방침</a>
				</div>
				<div class="footer-third">
					<h1>Shortcut</h1>
					<a href="#">문의하기</a>
					<a href="#">고객센터</a>
				</div>
				<div class="footer-third">
					<h1>Contact Us</h1>
					<!-- <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                <li><a href="#"><i class="fa fa-instagram"></i></a></li> -->

					<span>
						(주)그루모아<br>
						서울특별시 서초구 강남대로 79길 59	새로나빌딩 3층<br>
						Tel) 02-1234-5678<br>
						Fax) 02-1234-5678<br> 
						Email) webmaster@groumoa.com
					</span>
				</div>
			</div>
		</div>
	</div>
</body>
</html>