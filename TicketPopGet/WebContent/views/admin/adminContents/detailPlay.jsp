<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.admin.adminContents.model.vo.*" import="java.text.SimpleDateFormat"%>
<%
Contents c = (Contents)request.getAttribute("c");
%>
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
        <form action="update.adco" method="POST" enctype="multipart/form-data">
        <input type="hidden" name="contentNo" value="<%=c.getContentNo() %>">
        <input type="hidden" name="contentType" value="<%=c.getContentType() %>">
        <div id="contentThumbnail">
            <img id="titleImg" src="<%=request.getContextPath()%>/<%=c.getContentImgPath()%><%=c.getContentChImg()%>" style="width: 100%; height: 100%; border: 1px solid black; box-sizing: border-box;">
        </div>
        <div id="contentInsertDiv">
                <table id="contentInsert" style="width:460px">
                    <tr>
                        
                        <th style="width:160px">분류</th>
                        <td>연극</td>
                        <td colspan="2">
                        	<button type="button" class="btn btn-danger" onclick="location.href='delete.adco?contentNo=<%=c.getContentNo()%>&contentType=<%=c.getContentType()%>'" style="float:right;">삭제</button>
                            <button type="button" id="updateBtn" class="btn btn-primary" style="float:right;">수정</button>
                            <button type="submit" id="insertBtn" class="btn btn-primary" style="float:right; display:none;">등록</button>
                        </td>
                    </tr>
                	<script>
                		$(function(){
                			$("#updateBtn").click(function(){
                				$("#contentTitle").removeAttr("disabled");
                				$("#contentSubject").removeAttr("disabled");
                				$("#startDate").removeAttr("disabled");
                				$("#endDate").removeAttr("disabled");
                				$("#round").removeAttr("disabled");
                				$("#startTime").removeAttr("disabled");
                				$("#endTime").removeAttr("disabled");
                				$("#contentDate").removeAttr("disabled");
                				$("#runtime").removeAttr("disabled");
                				$("#ticketCount").removeAttr("disabled");
                				$("#place").removeAttr("disabled");
                				$("#local").removeAttr("disabled");
                				$("#limit").removeAttr("disabled");
                				$("#price").removeAttr("disabled");
                				$("#keyword").removeAttr("disabled");
                				$("#info").removeAttr("disabled");
                				$("#file").removeAttr("disabled");
                				$("#insertBtn").css("display", "");
                				$("#updateBtn").css("display", "none");
                				$("#titleImg").removeAttr("src");
                			});
                		});
                	</script>
                    <tr>
                        
                        <th>제목</th>
                        <td colspan="3"><input id="contentTitle" type="text" value="<%=c.getContentTitle()%>" name="contentTitle" required disabled>
                        </td>
                        
                    </tr>
                    <tr>
                        
                        <th>주최</th>
                        <td colspan="3">
                        <input type="text" id="contentSubject" name="contentSubject" value="<%=c.getContentSubject()%>" required disabled>
                        </td>
                        
                    </tr>
                    <tr>
                        
                        <th>기간</th>
                        <td><input id="startDate" type="date" name="startDate" id="startDate" value="<%=c.getStartDate() %>" required disabled></td>
                        <td><input id="endDate" type="date" name="endDate" id="endDate" value="<%=c.getEndDate() %>" required disabled></td>
                        <td></td>
                        
                    </tr>
                    <tr>
                        <th>회차정보</th>
                        <td>
                            <select id="round" name="round"  disabled>
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
 
                        <td><input id="contentDate" type="date" name="contentDate" id="contentDate" value="<%=c.getContentDate()%>" required  disabled></td>
                        <td></td>
                    </tr>
                    <tr>
                        <th>공연시간</th>
                        <td><input id="startTime" type="text" value="<%=c.getStartTime() %>" name="startTime" required placeholder="14시00분" disabled></td>
                        <td><input id="endTime" type="text" value="<%=c.getEndTime() %>" name="endTime" required placeholder="16시00분" disabled></td>
                        <td style="width:180px"><input id="runtime" type="text" value="<%=c.getContentRuntime() %>" name="runtime" required placeholder="150분" disabled></td>
                    </tr>
                    <tr>
                        <th>총티겟수</th>
                        <td colspan="3"><input id="ticketCount" type="number" min="0" value="<%=c.getMax()%>" name="ticketCount" required disabled></td>
                    </tr>
                    <tr>
                        <th>장소</th>
                        <td colspan="3"><input id="place" type="text" value="<%=c.getPlace() %>" name="place" required disabled></td>
                    </tr>
                    <tr>
                        <th>지역</th>
                        <td colspan="3">
                            <select id="local" name="local" disabled>
				                <option value="서울경기권">서울경기권</option>
				                <option value="강원충청권">강원충청권</option>
				                <option value="전라권">전라권</option>
				                <option value="경상제주권">경상제주권</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>관람등급</th>
                        <td colspan="3"><input type="text" id="limit" value="<%=c.getLimit() %>" name="limit" required disabled></td>
                    </tr>
                    <tr>
                        <th>가격</th>
                        <td colspan="3"><input type="text" id="price" value="<%=c.getPrice() %>" name="price" required disabled></td>
                    </tr>
                    <tr>
                        <th>키워드</th>
                        <td colspan="3"><input type="text" id="keyword" value="<%=c.getContentKeyword() %>" name="keyword" required disabled></td>
                    </tr>
                </table>
        </div>
        <div style="border: 1px solid red; width: 100%; height: 300px; box-sizing: border-box;">
            <textarea name="info" id="info" style="width: 100%; height: 100%; resize: none; text-align: left;" required disabled><%=c.getInfo() %></textarea>
        </div>
    <input id="file" type="file" name="file" onchange="loadImg(this);" style="display: none;" required disabled>
            </form>
    </div>


    <script>
        $(function(){
            $("#titleImg").click(function(){
                $("#file").click();
            });
            $("#round option[value='<%=c.getRound()%>']").attr("selected", "selected");
            $("#local option[value='<%=c.getRegion()%>']").attr("selected", "selected");
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