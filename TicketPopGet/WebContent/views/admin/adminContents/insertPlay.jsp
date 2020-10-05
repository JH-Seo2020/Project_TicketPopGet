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
            /* border: solid; */
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
            float: left;
        }

        #contentInsertDiv, #contentThumbnail{display: inline-block;}

        #contentInsertDiv{ margin-left: 20px; margin-bottom: px;}

        #contentInsert input, #contentInsert select{width: 100%; height: 100%;}

        #contentInsert tr{height: 40px;}


    </style>
</head>
<body>
<%@ include file="../adminCommon/adminMenubar.jsp" %>
    <div class="wrap">  
        <button class="returnMainPage" onclick="location.href='<%=request.getContextPath()%>/list.adco?currentPage=1'">이전으로</button>
        <form action="<%=request.getContextPath()%>/insertPlayForm.adco" method="POST" enctype="multipart/form-data">
        <div id="contentThumbnail">
            <img id="titleImg" src="" style="width: 100%; height: 100%; border: 1px solid black; box-sizing: border-box;">
        </div>
        <div id="contentInsertDiv">
                <table id="contentInsert" style="width:460px">
                    <tr>
                        
                        <th style="width:160px">분류</th>
                        <td>연극</td>
                        <td colspan="2">
                            <button type="submit" class="btn btn-primary" style="float:right;">등록</button>
                        </td>
                    </tr>
                    <tr>
                        
                        <th>제목</th>
                        <td colspan="3"><input type="text" name="contentTitle" required></td>
                        
                    </tr>
                    <tr>
                        
                        <th>주최</th>
                        <td colspan="3"><input type="text" name="contentSubject" required></td>
                        
                    </tr>
                    <tr>
                        
                        <th>기간</th>
                        <td><input type="date" name="startDate" required></td>
                        <td><input type="date" name="endDate" required></td>
                        <td></td>
                        
                    </tr>
                    <tr>
                        <th>회차정보</th>
                        <td>
                            <select name="round">
                                <option value="1">1회차</option>
                                <option value="2">2회차</option>
                                <option value="3">3회차</option>
                                <option value="4">4회차</option>
                                <option value="5">5회차</option>
                                <option value="6">6회차</option>
                                <option value="7">7회차</option>
                                <option value="8">8회차</option>
                                <option value="9">9회차</option>
                                <option value="10">10회차</option>
                            </select>
                        </td>
                        <td><input type="date" name="contentDate" required></td>
                        <td></td>
                    </tr>
                    <tr>
                        <th>공연시간</th>
                        <td><input type="text" min="0" name="startTime" required placeholder="14시00분"></td>
                        <td><input type="text" min="0" name="endTime" required placeholder="16시00분"></td>
                        <td style="width:180px"><input type="text" name="runtime" required placeholder="150분"></td>
                    </tr>
                    <tr>
                        <th>총티겟수</th>
                        <td colspan="3"><input type="number" min="0" name="ticketCount" required></td>
                    </tr>
                    <tr>
                        <th>장소</th>
                        <td colspan="3"><input type="text" name="place" required></td>
                    </tr>
                    <tr>
                        <th>지역</th>
                        <td colspan="3">
                            <select name="local">
				                <option value="서울경기권">서울경기권</option>
				                <option value="강원충청권">강원충청권</option>
				                <option value="전라권">전라권</option>
				                <option value="경상제주권">경상제주권</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>관람등급</th>
                        <td colspan="3"><input type="text" name="limit" required></td>
                    </tr>
                    <tr>
                        <th>가격</th>
                        <td colspan="3"><input type="text" name="price" required></td>
                    </tr>
                    <tr>
                        <th>키워드</th>
                        <td colspan="3"><input type="text" name="keyword" required></td>
                    </tr>
                </table>
        </div>
        <div style="border: 1px solid red; width: 100%; height: 300px; box-sizing: border-box;">
            <textarea name="info" style="width: 100%; height: 100%; resize: none; text-align: left;" required></textarea>
        </div>
    <input id="file" type="file" name="file" onchange="loadImg(this);" style="display: none;" required>
            </form>
    </div>


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