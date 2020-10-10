<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.user.model.vo.*" %>
<%
	MyPage mp = (MyPage)request.getAttribute("mp");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    #reviewinsert{
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
        margin-top: 100px;
        margin-left: 150px;
        
    }
    
    /* 테이블 */
    .review_write{
        margin-left: 150px;
        margin-top: 8px;
         height: 800px;
    }
    .review_write table{
        width: 900px;
        height: 90px;
    }
    .review_write textarea{
        width: 900px;
        height: 500px;
    }
    .review_write_btn{
        float: right;
        margin-top: 30px;
        margin-right: 180px;
    }
    .review_write_btn button{
        width: 60px;
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
	
   <div id="reviewinsert">
		<form action="<%=contextPath%>/reviewInsert.my?userNo=<%=mp.getUserNo()%>" method="POST">
			<input type="hidden" name="tno" value="<%=mp.getTicketNo()%>">
			<input type="hidden" name="userNo" value="<%=mp.getUserNo()%>">
			<input type="hidden" name="cno" value="<%=mp.getContentNo()%>">
	        <!-- 헤더부분 -->
	        <div class="reservation_check1">
	            <h3 style="margin-bottom: 20px;"><b>후기작성</b></h3>
	        </div>
	
	         <!-- 몸통부분  -->
	         <div class="reservation_check2">
	            <select name="category" disabled style="width: 300px; height: 50px;">
	                <option value="콘서트">콘서트</option>
	                <option value="연극">연극</option>
	                <option value="전시">전시</option>
	            </select>
	        </div>
	        
	        <script>
	        	$("select[name='category']").val("<%=mp.getContentType()%>");
	        </script>
	
	        <!-- 테이블 -->
	        <div class="review_write" >
	            <table border="1">  
	                <tr>
	                    <th>공연명</th>
	                    <td><input type="text" name="contenttitle" value="<%=mp.getContentTitle()%>" style="border:none;"></td>
	                    <th>관람일</th>
	                    <td><input type="text" name="viewdate" value="<%=mp.getViewDate()%>" style="border:none;"></td>
	                </tr>
	                <tr>
	                    <th>작성일</th>
	                    <td><input type="date" name="reviewdate" value="<%=mp.getReviewDate() %>" readonly style="border:none;"></td>
	                    <th>평점</th>
	                    <td><input type="number" name="reviewpoint" min="1" max="10" placeholder="1~10점까지 점수매겨주세요" 
	                           style="border:none; width: 250px;" required></td>
	                </tr>
	                <tr>
	                    <th>제목</th>
	                    <td colspan="3"><input type="text" name="reviewtitle" style="border:none; width:700px;" required></td>
	                </tr>
	            </table>
	            <textarea id="summernote" name="editordata" required="required"></textarea>
	            
	            <script>
		            $(document).ready(function() {
		            	  $('#summernote').summernote({
		            		  width: 900,
		            		  height : 500,
		            		  focus : true
		            	  });
		            	});

	            </script>
	            
	            
	             <div class=review_write_btn>
		            <button type="submit">확인</button>
		            <button type="button" onclick="history.back(-3);">취소</button>
		            
	        	</div>
	        </div>
	    </form>
    </div>
</body>
</html>