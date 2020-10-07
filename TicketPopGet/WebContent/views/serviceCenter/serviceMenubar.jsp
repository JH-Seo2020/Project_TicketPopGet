<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.kh.user.model.vo.Member"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
    #help{
        background-color: #ffb300;
        color: white;
        width: 150px;
        height:100px;
        font-size: 27px;
        font-weight: bold;
        text-align: center;
        display:table-cell;
        vertical-align:middle     
    }
    .serviceTopMenu {
        list-style-type: none;
        margin: 0;
        padding: 0;
        width: 150px;
        background-color: white;
    }
    .serviceMenu a {
        display: block;
        color: #000;
        padding: 5px 16px;
        text-decoration: none;
    }
    .serviceMenu a.help_meu {
        color: #ffb300;
        font-weight: bold;
        font-size: 20px;
    }
    .serviceMenu a:hover:not(.active) {
        background-color: rgba(51, 50, 50, 0.548);
        color: white;
    }
</style>
<body>
    <div id="help">고객센터</div>
    <br>
    <ul class="serviceTopMenu">
        <li class="serviceMenu"><a class="help_meu" href="<%= request.getContextPath() %>/list.no?currentPage=1">공지사항</a></li>
        <li class="serviceMenu"><a href="<%= request.getContextPath() %>/search.no?currentPage=1&type=변경/취소">변경/취소</a></li>
        <li class="serviceMenu"><a href="<%= request.getContextPath() %>/search.no?currentPage=1&type=시스템">시스템</a></li>
        <li class="serviceMenu"><a href="<%= request.getContextPath() %>/search.no?currentPage=1&type=기타">기타</a></li>
      </ul>
      <ul class="serviceTopMenu">
        <li class="serviceMenu"><a class="help_meu" href="<%=request.getContextPath()%>/list.fo?currentPage=1">FAQ</a></li>
        <li class="serviceMenu"><a href="<%= request.getContextPath() %>/search.fo?currentPage=1&type=회원">회원</a></li>
        <li class="serviceMenu"><a href="<%= request.getContextPath() %>/search.fo?currentPage=1&type=결제">결제</a></li>
        <li class="serviceMenu"><a href="<%= request.getContextPath() %>/search.fo?currentPage=1&type=예매/취소">예매/취소</a></li>
        <li class="serviceMenu"><a href="<%= request.getContextPath() %>/search.fo?currentPage=1&type=기타">기타</a></li>
      </ul>
         <%if(loginUser != null){ %>
      <ul class="serviceTopMenu">
        <li class="serviceMenu"><a class="help_meu" href="<%= request.getContextPath() %>/list.qo?currentPage=1">1 : 1문의</a></li>
        <li class="serviceMenu"><a href="<%= request.getContextPath() %>/list.qo?currentPage=1">문의내역</a></li>
        <li class="serviceMenu"><a href="<%= request.getContextPath() %>/enrollForm.qo">문의하기</a></li>
      </ul>
      <%} %>
</body>
</html>