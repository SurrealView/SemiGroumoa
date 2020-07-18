<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.groumoa.member.model.vo.MemberVO"%>
    
<% MemberVO loginUser = (MemberVO) session.getAttribute("loginUser"); %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
        @font-face {
        font-family: 'NanumBarunGothic';
        src: url('resources/fonts/NanumBarunGothic.ttf') format('truetype');
    }

    * {
	    font-family: NanumBarunGothic;
    }
    </style>
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
    <link rel="stylesheet" href="https://static.onoffmix.com/css/pc/account/event.css">    <!-- =================================== 화면 고유 끝 ===================================  -->
<script>dataLayer=[{uid:"1214583"}]</script>    <!-- Google Tag Manager -->
    <script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
            new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
            j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
            'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
        })(window,document,'script','dataLayer','GTM-K5ZBGC5');</script>
    <!-- End Google Tag Manager -->
    
    <!-- Global site tag (gtag.js) - Google Analytics -->
    <script async src="https://www.googletagmanager.com/gtag/js?id=UA-25312010-14"></script>
    <script>
        window.dataLayer = window.dataLayer || [];
        function gtag(){dataLayer.push(arguments);}
        gtag('js', new Date());
        gtag('config', 'UA-25312010-14');
    </script>
    <!-- Global site tag (gtag.js) - Google Analytics -->
</head>
<body>
    <header id="header" class="header_wrap sub_head_foot">
        <div class="header_top wide_max_width_area">
                    <h1 class="ofm_logo" style="top:45px;left:190px;">
                        <a href="/">
                <span class="text_logo">그루모아 홈</span>
                                    <img src="image/logo_groumoa2.png" alt="GROUMOA" style="width:35%; height:35%;">
                                </a>
        </h1>

        <div class="user_area">
            <ul class="service_menu">
            <%if(loginUser != null){ %>
                                        <li class="list_item">
                        <a href="#" class="user_name" title="클릭시 마이페이지로 이동">
                            <strong><%=loginUser.getUserName()%></strong>님
                        </a>
                    </li>                        
                    <li class="list_item logout"><a href="<%=request.getContextPath() %>/logout.me">로그아웃</a></li>
                    <%} else { %>
                    	<li class="list_item"><a href="<%=request.getContextPath() %>/views/member/login.jsp">로그인</a></li>
                    	<li class="list_item"><a href="<%=request.getContextPath() %>/views/member/signup.jsp">회원가입</a></li>
                    <% }%>
                                    <li class="list_item service"><a href="/service">서비스안내</a></li>
                <li class="list_item customer"><a href="/cs/main">고객센터</a></li>
            </ul>

            <ul class="member_menu">
                <li class="list_item mypage" tabindex="0">
                    <a href="#">마이페이지</a>
                    <div class="sub_menu">
                        <ul class="sub_list mypage_list">
                            <li><a href="#" class="site_link edit">회원정보수정</a></li>
                            <li><a href="#" class="site_link pass">비밀번호변경</a></li>
                            <li><a href="#" class="site_link event">신청내역</a></li>
                            <li><a href="#" class="site_link payment">결제내역</a></li>
                            <li><a href="#" class="site_link pin">최근일정</a></li>
                        </ul>
                    </div>
                </li>
                <li class="list_item eventopen"><a href="/event/add">모임개설</a></li>
                <li class="list_item manage"><a href="/event/manage">모임관리</a></li>
                <li class="list_item notice">
                                            <button type="button">알림</button>
                    <div class="news">
                        <span class="number"></span><span class="a11y_hidden">개의 새로운 소식이 있습니다</span>
                    </div>
                    <div class="sub_menu">
                        <div class="sub_list">
                            <ol class="notice_list">
                                                                    <li class="none_list">새로운 알림이 없습니다.</li>
                                                                                                    </ol>
                        </div>
                    </div>
                                        </li>
            </ul>
        </div>
        <div class="search_area">
            <form class="search_form" action="/event/main" method="GET">
                <label for="searchInput">검색할 모임을 입력해주세요.</label>
                <input type="text" id="searchInput" class="search_input" name="s" placeholder="검색할 모임을 입력하세요">
                                   
                <script>
                    gtag('event', 'view_promotion', {
                        "non_interaction": true,
                        "promotions": [
                            {
                                "id": "event_217732",
                                "name": "event_신규 입주기업 공모를 위한 온라인 사전 설명회",
                                "creative_name": "PC_메인_검색창광고",
                                "creative_slot": "1"
                            }
                        ]
                    });
                </script>
                                    <input type="submit" class="btn_search" value="검색" title="검색">
            </form>
        </div>
    </div>

    <div class="header_bottom">
        <div class="wide_max_width_area">
            <div class="category_section">
               <!-- <div class="title_wrap">
                    <button class="btn_category">카테고리</button>
                </div>-->
            </div>
        </div>
       
        <div class="wide_max_width_area" style="text-align: center;">
            <div class="right_section" >
                <!-- link section -->
                <div class="link_section">
                    <a href="#" class="link_item best" data-c="b09b92011">추천동호회</a>
                    <a href="#" class="link_item exhibition" data-c="b09b92031">내모임</a>
                                            <a href="#" class="link_item event" data-c="b09b92021">공지사항</a>
                                            <a href="#" class="link_item exhibition" data-c="b09b92031">QnA</a>
                </div>

                <!-- partner center -->
                
                
                <!---->

                <!-- lanking event -->
                
            </div>
        </div>
    </div>
<!-- Plugin -->
<script src="/static_html/js/pc/dist/common/plugins/jquery.browser.js"></script>
<script src="/static_html/js/pc/dist/common/plugins/jquery.fancybox-1.3.3.js"></script>
<!-- Script -->
<script src="/static_html/js/pc/dist/account/mypage-common.js"></script>
<script src="/static_html/js/pc/dist/account/event.js"></script>
        </header>
</body>
</html>