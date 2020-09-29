<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
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
        <li class="serviceMenu"><a class="help_meu" href="">공지사항</a></li>
        <li class="serviceMenu"><a href="">전체</a></li>
        <li class="serviceMenu"><a href="">변경</a></li>
        <li class="serviceMenu"><a href="">시스템</a></li>
        <li class="serviceMenu"><a href="">기타</a></li>
      </ul>
      <ul class="serviceTopMenu">
        <li class="serviceMenu"><a class="help_meu" href="<%=contextPath%>/list.fo?currentPage=1">FAQ</a></li>
        <li class="serviceMenu"><a href="">회원</a></li>
        <li class="serviceMenu"><a href="">결제</a></li>
        <li class="serviceMenu"><a href="">예매/취소</a></li>
        <li class="serviceMenu"><a href="">기타</a></li>
      </ul>
      <ul class="serviceTopMenu">
        <li class="serviceMenu"><a class="help_meu" href="">1 : 1문의</a></li>
        <li class="serviceMenu"><a href="">문의내역</a></li>
        <li class="serviceMenu"><a href="">문의하기</a></li>
      </ul>
</body>
</html>