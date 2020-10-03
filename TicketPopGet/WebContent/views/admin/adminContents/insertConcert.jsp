<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .wrap{
        width: 1000px;
        height: 850px;
        margin: auto;
        text-align: center;
        margin-left:100px;
    }

    .returnMainPage{
        width: 100px;
        height: 40px;
        background: #98c3ff;
        border: none;
        border-radius: 10px;
        float: right;
    }
    
    #contentThumbnail{
        width: 400px;
        height: 475px;
        border: 1px solid blue;
        float: left;
    }

    #contentInsertDiv, #contentThumbnail{display: inline-block;}

    #contentInsertDiv{ margin-left: 20px; margin-bottom: 40px;}

    #contentInsert input, #contentInsert select{width: 100%; height: 100%;}

    #contentInsert tr{height: 40px;}


</style>
</head>
<body>
<%@ include file="../adminCommon/adminMenubar.jsp" %>
    <div class="wrap">  
        <button class="returnMainPage">초기화면</button>
        <form action="insertConcertForm.adco" method="POST" enctype="multipart/form-data">
	        <div id="contentThumbnail">
	            <img id="titleImg" src="" style="width: 100%; height: 100%; border: 1px solid black; box-sizing: border-box;">
	        </div>
	        <div id="contentInsertDiv">
                <table id="contentInsert">
                    <tr>
                        
                        <th>분류</th>
                        <td>콘서트</td>
                        <td style="float: right;">
                            <button class="btn btn-primary">등록</button>
                            <button class="btn btn-danger">삭제</button>
                        </td>
                    </tr>
                    <tr>
                        
                        <th>제목</th>
                        <td colspan="2"><input type="text" name="contentTitle" required></td>
                        
                    </tr>
                    <tr>
                        
                        <th>주최</th>
                        <td colspan="2"><input type="text" name="contentSubject" required "></td>
                        
                    </tr>
                    <tr>
                        
                        <th>기간</th>
                        <td><input type="date" name="start" required></td>
                        <td><input type="date" name="end" required></td>
                        
                    </tr>
                    <tr>
                        <th>공연시간</th>
                        <td colspan="2"><input type="number" min="0" name="runtime" required ></td>
                    </tr>
                    <tr>
                        <th>총티겟수</th>
                        <td colspan="2"><input type="number" min="0" name="ticketCount" required></td>
                    </tr>
                    <tr>
                        <th>장소</th>
                        <td colspan="2"><input type="text" name="place" required></td>
                    </tr>
                    <tr>
                        <th>지역</th>
                        <td colspan="2">
                            <select name="area">
                                <option value="서울">서울</option>
                                <option value="경기도">경기도</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>관람등급</th>
                        <td colspan="2"><input type="number" name="limit" required></td>
                    </tr>
                    <tr>
                        <th>가격</th>
                        <td colspan="2"><input type="text" name="price" required></td>
                    </tr>
                    <tr>
                        <th>키워드</th>
                        <td colspan="2"><input type="text" name="keyword" required></td>
                    </tr>
                </table>
            </form>
        </div>
        <div style="border: 1px solid red; width: 100%; height: 300px; box-sizing: border-box;">
            <textarea name="contentsContent" style="width: 100%; height: 100%; resize: none; text-align: left;">
원래 컨텐츠 설명 내용 자리 
            </textarea>     
        </div>
    </div>


    <input id="file" type="file" name="file" onchange="loadImg(this);" style="display: none;">

    <script>
        $(function(){
            $("#titleImg").click(function(){
                $("#file").click();
            });
        });

    </script>
    <script>
        function loadImg(inputFile){

            if(inputFile.files.length == 1){
                var reader = new FileReader();

                reader.readAsDataURL(inputFile.files[0]);

                reader.onload = function(e){
                    $("#titleImg").attr("src", e.target.result);
                }
            }else{
                $("#titleImg").attr("src",null);
            }
        }
    </script>
</body>
</html>