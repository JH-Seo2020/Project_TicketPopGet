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
	
   <div id="wrap">

        <!-- 헤더부분 -->
        <div class="reservation_check1">
            <h3 style="margin-bottom: 20px;"><b>후기작성</b></h3>
        </div>

         <!-- 몸통부분  -->
         <div class="reservation_check2">
            <select name="category" style="width: 300px; height: 50px;">
                <option><%=mp.getContentType()%></option>
            </select>
        </div>

        <!-- 테이블 -->
        <div class="review_write" >
            <table border="1">  
                <tr>
                    <th>공연명</th>
                    <td><%=mp.getReviewTitle() %></td>
                    <th>관람일</th>
                    <td><%=mp.getViewDate() %></td>
                </tr>
                <tr>
                    <th>작성일</th>
                    <td><%=mp.getReviewDate() %></td>
                    <th>평점</th>
                    <td><%=mp.getReviewPoint() %></td>
                </tr>
                <tr>
                    <th>제목</th>
                    <td colspan="3"><%=mp.getContentTitle() %></td>
                </tr>
            </table>
            <textarea><%=mp.getReviewContent() %></textarea>
            
             <div class=review_write_btn>
	            <button>수정</button>
	            <button>취소</button>
        	</div>
        </div>
    </div>
</body>
</html>