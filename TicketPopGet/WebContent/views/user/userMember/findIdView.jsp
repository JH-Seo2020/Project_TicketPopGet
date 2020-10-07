<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.user.model.vo.Member" %>
<%
	Member m = (Member)request.getAttribute("m");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .loginbox{
        width: 700px;
        height: 700px;
        margin: 20px;
        padding: 25px 15px;
        box-sizing: border-box;
    }
    .loginbox h1{
        width: 100%;
        height: 40px;
        font-size: 30px;
        color: #ffb300;
        padding-left: 40px;
        margin-bottom: 50px;
        text-align: center;
    }

    .chk{width: 100%; text-align: center; margin-left: 8%;}

    .btnwrap{text-align: center; margin-left: 11%;}

    #loginbtn{
        width: 129px;
        height: 35px;
        border: none;
        background-color: #ffb300;
        border-radius: 3px;
        color: #fff;
        font-size: 14px;
        font-weight: bold;
        position: relative;
        top: 1px;
    }
</style>
</head>
<body>
<!-- 메뉴바  -->
<%@ include file="/views/common/menubar.jsp"%>
    <div class="loginbox">
        <h1>아이디 찾기</h1>
        <form action="" align="center">
            
            <div class="chk" style="font-size: 15px;">
                <b><%=m.getUserName() %></b>님의 아이디는 <b><%=m.getUserId() %></b>입니다.
            </div>
            <br><br>
            <div class="btnwrap">
                <input type="button" id="loginbtn" style="width: 200px;" onclick = "location.href = '<%=contextPath%>/loginview.me' " value="로그인화면으로 돌아가기">
            </div>
        </form>
    </div>
</body>
</html>