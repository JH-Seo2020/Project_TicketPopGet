<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.community.adBoard.model.vo.AdBoard" %>
<%
	AdBoard ad = (AdBoard)request.getAttribute("ad");
	String content = (String)request.getAttribute("content");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
   <style>
        #wrap{
            width: 1200px;
            height: 1800px;
            margin: auto;
            box-sizing: border-box;
        }

        /* 헤더부분 */
        .reservation_check1{
            margin-top:80px;
            font-size: 25px; 
            width: 1000px;
            margin-left: 90px; 
            border-bottom: 1px solid rosybrown;
        }

        /* 몸통영역 */
        .reservation_check2{
            float: left;
            margin-top: 100px;
            margin-left: 90px;
        }

        .reservation_check2_1{
            margin-top: 100px;
            padding-left: 400px;
        }
        
        /* 테이블 */
        .review_write{
            margin-left: 90px;
            margin-top: 8px;
            height: 800px;
        }
        .review_write table{
            width: 1110px;
            height: 50px;
        }

        .review_write_btn{
            float: right;
            margin-top: 30px;
            margin-right: 180px;
        }
        .review_write_btn button{
            width: 80px;
            height: 40px;
        }
        .review_write_btn :first-child{
            margin-right: 20px;
            background-color: coral;
            border: 1px solid coral;
            border-radius: 0.5em;
            color: white;
        }
        .review_write_btn :last-child{
            background-color:dimgray;
            border: 1px solid dimgray;
            border-radius: 0.5em;
            color: white;
        }
    </style>
</head>

<body>

	<!-- 메뉴바쓰추가쓰 -->
	<%@ include file="/views/common/menubar.jsp"%>
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

   <div id="wrap">
		<form action="<%=contextPath%>/adupdate.my?boardNo=<%=ad.getBoardNo()%>&userNo=<%=loginUser.getUserNo() %>" method="post">
		<input type="hidden" id="ano" name="ano" value="<%=ad.getBoardNo()%>">
		<input type="hidden" name="userNo" value="<%=loginUser.getUserNo() %>">
		
	        <!-- 헤더부분 -->
	        <div class="reservation_check1">
	            <h3 style="margin-bottom: 20px;"><b>홍보글수정</b></h3>
	        </div>
	
	         <!-- 몸통부분  -->
	         <div class="reservation_check2">
	            <select id="category1" name="category1" style="width: 300px; height: 50px;">
	                <option value="콘서트">콘서트</option>
	                <option value="연극">연극</option>
	                <option value="전시">전시</option>
	            </select>
	        </div>
	
	        <div class="reservation_check2_1">
	            <select id="category2" name="category2" style="width: 300px; height: 50px;">
	                <option value="서울경기권">서울경기권</option>
	                <option value="강원충천권">강원충천권</option>
	                <option value="전라권">전라권</option>
	                <option value="경상권제주">경상권제주</option>
	            </select>
	        </div>
	        
	        <script>
	        	$("select[name='category1']").val("<%=ad.getBoardType()%>");
	        	$("select[name='category2']").val("<%=ad.getBoardLocation()%>");
	        </script>
	
	        <!-- 테이블 -->
	        <div class="review_write" >
	            <table border="1">  
	                <tr>
	                    <th style="text-align:center;">제목</th>
	                    <td colspan="2"><input type="text" id="adtitle" name="adtitle"  value="<%=ad.getBoardTitle()%>" style="border:none; width:500px;"></td>
	                    <th style="text-align:center;">작성일</th>
	                    <td style="text-align:center;"><input type="date" id="dadate" readonly name="addate" value="<%=ad.getBoardDate()%>"  style="border:none;"></td>
	                </tr>
	            </table>
	     
	            <textarea id="summernote" name="editordata"><%=content%></textarea>
	            
		        <script>
		            $(document).ready(function() {
		            	  $('#summernote').summernote({
		            		  height : 500,
		            		  focus : true
		            	  });
		            	});
	            </script>
	            
	             <div class=review_write_btn>
		            <button type="submit">수정하기</button>
		            <button type="button" onclick="history.back()">뒤로가기</button>
	        	</div>
	        </div>
        </form>
     </div>
</body>
</html>