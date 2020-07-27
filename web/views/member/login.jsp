<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <!-- 
        =================================== 공통 시작 ===================================  -->
    <!-- OFM Common Style -->
    <link rel="stylesheet" href="https://static.onoffmix.com/css/common/pc/common-pc.css">
    <!-- Common Script -->
    <script src="https://static.onoffmix.com/js/pc/dist/common/plugins/jquery-1.10.2.js"></script>
    <script src="https://static.onoffmix.com/js/pc/dist/common/plugins/jquery-ui-1.10.4.custom.js"></script>
    <script src="https://static.onoffmix.com/js/pc/dist/common/plugins/jquery.dotdotdot-1.5.0.js"></script>
    <!--[if lt IE 9]>
        <script src="https://static.onoffmix.com/js/pc/dist/common/plugins/html5shiv.min.js"></script>
        <script src="https://static.onoffmix.com/js/pc/dist/common/reponse.ie8.js"></script>
    <![endif]-->
    <!-- =================================== 공통 끝 ===================================  -->

    <!-- =================================== 화면 고유 시작 ===================================  -->
    <!-- OFM Style -->
    <link rel="stylesheet" href="https://static.onoffmix.com/css/pc/account/login.css">    <!-- =================================== 화면 고유 끝 ===================================  -->
    
   
    </head>
</head>
<body>
    <!-- Main Content : account/login.html -->
<main id="content" class="login">
    <!-- wrapping -->
    <div class="content_wrapping max_width_area">
        <div class="top_area">
            <!--<h1 class="ofm_logo">
                <a href="#"><img src="image/logo_groumoa2.png" alt="GROUMOA" style="width:50%; height:80%;"></a>
            </h1>-->
        </div>
        <div class="main_area">
            <!-- 메인콘텐츠 시작 -->
            <section class="main_content">
                <h1 class="hidden">로그인</h1>
                <!-- 회원 로그인 시작 -->
                <article class="tab member active">
                    <div class="logo-image" align="center">
                        <img src="/groumoa/resources/image/logo_groumoa2.png"  style="width:50%; height:50%;">
                    </div>
                    <div class="tab_content" style="margin-top:-30px">
                        
                        <form action="<%=request.getContextPath() %>/login.me" method="post" accept-charset="utf-8" class="login_access_form">
                            <input type="hidden" name="returnUrl" value="/">
                            <input type="hidden" name="login_type" value="user">
                            <div class="login_form">
                                <div class="input_area">
                                    <!-- <input type="email" class="email" name="OFM_ID" placeholder="이메일 아이디를 입력해 주세요(ID@xxxx.com)" value=""> -->
                                    <input type="text" class="email" name="email" placeholder="이메일 아이디를 입력해 주세요(ID@xxxx.com)" value="">
                                    <input type="password" class="password" name="userPwd" placeholder="비밀번호를 입력해 주세요.">
                                </div>
                                <ul class="check_area">
                                    <li>
                                        <!-- 기본이 체크된 상태 -->
                                        <input type="checkbox" id="remember" name="PERSISTENT" checked>
                                        <label for="remember">로그인 상태 유지</label>
                                    </li>
                                    <li class="join"><a href="<%=request.getContextPath()%>/views/member/signup.jsp">회원가입</a></li>
                                    <li class="find"><a href="searchIdPwd.jsp">아이디 / 비밀번호찾기</a></li>
                                </ul>
                                <p class="error_msg">
                                                                    </p>
                                <input type="submit" class="btn_submit" value="로그인" style="background-color: darkred;">
                            </div>
                        </form>
						
                        
                    </div>
                </article>
               
            </section>
           
        </div>
    </div>
    <!-- wrapping -->
</main>

</body>
</html>