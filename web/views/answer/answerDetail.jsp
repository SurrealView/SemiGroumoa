<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link href="../../../resources/css/answer/m_answerDetail.css" rel="stylesheet">
</head>
<body>
	<table>
        <tr>
            <td class="title">제목1</td>
        </tr>
        <tr class="content">
            <td>
                <div align="center" class="answerDetail" id="answerDetail">
                    <div class="answerDetailInfo">
                        <table class="detailArea">
                            <tr>
                                <td colspan="7"> </td>
                            </tr>
                            <tr>
                                <td><label>담당자 </label></td>
                                <td colspan="6"><input type="text"></td>                                
                            </tr>
                            <tr>
                            	<td><label>연락처 </label></td>
                                <td colspan="2"><input type="tel"></td>
                                <td><label>이메일 </label></td>
                                <td><input type="email"></td>
                            </tr>
                            <tr>
                                <td><label>내용</label></td>
                                <td colspan="6"><p>내용 내용내용 <br>내용내용<br><br><br><br><br>내용	</p></textarea></td>
                            </tr>
                        </table>
                        <button type="submit" class="correctBtn">수정하기</button>
                        <button type="submit" class="deleteBtn">삭제하기</button>
                    </div>      
                </div>
            </td>
        </tr>
        <tr>
            <td class="title">제목2</td>
        </tr>
        <tr class="content">
            <td>
                <div align="center" class="answerDetail" id="answerDetail">
                    <div class="answerDetailInfo">
                        <table class="detailArea">
                            <tr>
                                <td colspan="7"> </td>
                            </tr>
                            <tr>
                                <td><label>담당자 </label></td>
                                <td colspan="6"><input type="text"></td>                                
                            </tr>
                            <tr>
                            	<td><label>연락처 </label></td>
                                <td colspan="2"><input type="tel"></td>
                                <td><label>이메일 </label></td>
                                <td><input type="email"></td>
                            </tr>
                            <tr>
                                <td><label>내용</label></td>
                                <td colspan="6"><p>내용 내용내용 <br>내용내용<br><br><br><br><br>내용	</p></textarea></td>
                            </tr>
                        </table>
                        <button type="submit" class="correctBtn">수정하기</button>
                        <button type="submit" class="deleteBtn">삭제하기</button>
                    </div>      
                </div>
            </td>
        </tr>
    </table>

    <script>
        $(function() {
            $(".content").hide();
            var tr = $(".content");
            console.log(tr);
            $(".title").each(function(i, e){                
                $(this).parent().click(function(){
                    var idx = i;   
                    for(var j = 0; j < tr.length; j++){

                        if(j == i){
                            continue;
                        }
                        $(tr[j]).hide();
                    }

                    if($(tr[idx]).is(":visible")){
                        $(tr[idx]).hide();
                    } else{
                        $(tr[idx]).show();
                    }                    
                    
                })
            })

        });
    </script>
</body>
</html>