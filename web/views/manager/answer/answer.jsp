<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link href="css/answer/m_answer_style.css" rel="stylesheet">
</head>
<body>
	<table>
        <tr>
            <td class="title">제목1</td>
        </tr>
        <tr class="content">
            <td>
                <div align="center" class="AnswerWrite" id="AnswerWrite">
                    <div class="AnserInfo">
                        <table class="writeArea">
                            <tr>
                                <td colspan="7"> </td>
                            </tr>
                            <tr>
                                <td><label>담당자 </label></td>
                                <td colspan="2"><input type="text"></td>
                                <td><label>연락처 </label></td>
                                <td><input type="tel"></td>
                            </tr>
                            <tr>
                                <td><label>이메일 </label></td>
                                <td colspan="6"><input type="email"></td>
                            </tr>
                            <tr>
                                <td><label>내용</label></td>
                                <td colspan="6"><textarea cols="62" rows="10" style="resize:none"></textarea></td>
                            </tr>
                        </table>
                        <button type="submit" class="writeBtn">등록</button>
                    </div>      
                </div>
            </td>
        </tr>
        <tr>
            <td class="title">제목2</td>
        </tr>
        <tr class="content">
            <td>
                <div align="center" class="AnswerWrite" id="AnswerWrite">
                    <div class="AnserInfo">
                        <table class="writeArea">
                            <tr>
                                <td colspan="7"> </td>
                            </tr>
                            <tr>
                                <td><label>담당자 </label></td>
                                <td colspan="2"><input type="text"></td>
                                <td><label>연락처 </label></td>
                                <td><input type="tel"></td>
                            </tr>
                            <tr>
                                <td><label>이메일 </label></td>
                                <td colspan="6"><input type="email"></td>
                            </tr>
                            <tr>
                                <td><label>내용</label></td>
                                <td colspan="6"><textarea cols="62" rows="10" style="resize:none"></textarea></td>
                            </tr>
                        </table>
                        <button type="submit" class="writeBtn">등록</button>                        
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