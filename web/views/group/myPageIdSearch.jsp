<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID/PWD찾기</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<style>
    .menu{
      background: white;
      color: black;
      text-align: center;
      display: table-cell;
      vertical-align: middle;
      width: 150px;
      height: 50px;
    }
     .wrap{
      background: white;
      width: 100%;
      height: 50px;
   }
     .menu:hover {
      background: #461212;
      color: white;
      font-weight: bold;
      cursor: pointer;
   }
   #loginer {
      display: inline-block;
      width: 100%;
      margin: 0px auto;
   }
    #id_form{
        font-size: 1.3em;
        width: 500px;
        display: inline-block;
        margin: 0px auto;
    }
    #pwd_form{
        font-size: 1.3em;
        width: 500px;
        display: inline-block;
        margin: 0px auto;
    }
    </style>
</head>
<body>
<h2>ID/PWD찾기</h2>
    <div class="wrap">
    <hr noshade="noshade" size="1px" color="black">
    <div id="loginer" align="center"><br><br><br><br>
        <form id = "id_form" method="POST">
            <fieldset>
               <!-- <img src="image/searchID.png" style="float: left; width: 200px; height:200px;"> -->
                <legend>ID 찾기</legend>
                <br><br>
                이름 : <input type="text" id ="name" name ="name">
                <br><br>
                이메일: <input type="text" id ="email" name ="email">
                <br><br>
                <input type="hidden" value="0" name = "check">
                <input type="button" value="아이디 찾기" onclick="submit">
                <br>
            </fieldset>
        </form>
        <br><br><br><br><br><br><br><br><br>
        <form id = "pwd_form"method="POST">
            <fieldset>
                <!--<img src="image/security.png" style="float: left; width: 200px; height: 200px;"> -->
                <legend>PWD 찾기</legend>
                이메일: <input type="text" id ="email" name ="email">
                <br><br>
                전화번호: <input type="text" id ="phone"  name ="phone">
                <br><br>
                비밀번호 힌트: <input type="text" id ="passwordhint"  name ="passwordhint" placeholder="내 보물 1호는?">
                <br><br>
                비밀번호 답: <input type="text" id ="passwordA"  name ="passwordA">
                <br><br>
                <input type="hidden" value="1" name = "check">
                <input type="button" value="비밀번호 찾기" onclick="submit">
                <br>
            </fieldset>
        </form>
    </div>
  </div>
</body>
</html>





