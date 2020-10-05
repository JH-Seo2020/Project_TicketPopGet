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
        border: 1px solid blue;
        float: left;
    }

    #contentInsertDiv, #contentThumbnail{display: inline-block;}

    #contentInsertDiv{ margin-left: 20px; margin-bottom: 120px;}

    #contentInsert input, #contentInsert select{width: 100%; height: 100%;}

    #contentInsert tr{height: 40px;}


</style>
</head>
<body>
<%@ include file="../adminCommon/adminMenubar.jsp" %>
    <div class="wrap">  
        <button class="returnMainPage" onclick="location.href='<%=request.getContextPath()%>/list.adco?currentPage=1'">이전으로</button>
        <form action="insertExhibitionForm.adco" method="POST" enctype="multipart/form-data">
	        <div id="contentThumbnail">
	            <img id="titleImg" src="" style="width: 100%; height: 100%; border: 1px solid black; box-sizing: border-box;">
	        </div>
	        <div id="contentInsertDiv">
                <table id="contentInsert">
                    <tr>
                        
                        <th>분류</th>
                        <td>전시</td>
                        <td style="float: right;">
                            <button class="btn btn-primary">등록</button>
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
                        <td><input type="date" name="startDate" required></td>
                        <td><input type="date" name="endDate" required></td>
                        
                    </tr>

                    <tr>
                        <th>장소</th>
                        <td colspan="2"><input type="text" name="place" required></td>
                    </tr>
                    <tr>
                        <th>지역</th>
                        <td colspan="2">
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
                        <td colspan="2"><input type="text" name="limit" required></td>
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
        </div>
        <div style="border: 1px solid red; width: 100%; height: 300px; box-sizing: border-box;">
            <textarea name="info" style="width: 100%; height: 100%; resize: none; text-align: left;" ></textarea>
        </div>
    <input id="file" type="file" name="file" onchange="loadImg(this);" style="display: none;">
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