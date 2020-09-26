<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
    .loginbox{
        width: 700px;
        height: 700px;
        margin-left: 25%;
        margin-top: 2%;
        padding: 25px 15px;
        box-sizing: border-box;
    }
    .loginbox h1{
        width: 100%;
        height: 40px;
        font-size: 35px;
        color: #ffb300;
        padding-left: 40px;
        margin-bottom: 50px;
        text-align: center;
    }
    #loginid, #loginpw{
        width: 200px;
        height: 25px;
        box-sizing: border-box;
        margin-bottom: 15px;
        font-size: 14px;
    }
    .labelid{
        
        /* color: #666; */
        margin-left: 15px;
        margin-right: 8px;
    }
    .chk{width: 100%; text-align: center;}
    .chk label{
        font-size: 13px;
        color: #999;
        position: relative;
        top: -3px;
    }
    .search{
        width: 100%;
        border-bottom: 1px dached #999;
        /* box-sizing: border-box; */
        line-height: 40px;
    }
    .search span{font-size: 11px;color: #999;}
    .search a{
        font-size: 12px;
        text-decoration: none;
        background-color: #333;
        color: #fff;
        padding: 3px 5px;
        border-radius: 3px;
    }
    .btnwrap{width: 100%; text-align: center;}

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
<body>
<!-- 상단 메뉴바  -->
<%@ include file="/views/common/menubar.jsp"%>

    <div class="loginbox">
        <h1>로그인</h1>
        <form id="loginForm" action="<%= request.getContextPath() %>/login.me" method="post" align="center">
            <label for="loginid" class="labelid">아이디</label>
            <input type="text" id="loginid" name="userId" required><br>
            <label for="loginpw" class="labelpw">패스워드</label>&nbsp;
            <input type="password" id="loginpw" name="userPwd" required>
            <div class="chk">
                <input type="checkbox" id="idchk">
                <label for="idchk">비밀번호 저장</label>
                <input type="checkbox" id="pwchk">
                <label for="pwchk">비밀번호 저장</label>
            </div>
            <br>
            <div class="btnwrap">
                <input type="submit" id="loginbtn" value="로그인">
            </div>
            <br>
            <div class="search">
                <span class="text">아이디 또는 비밀번호를 잊으셨나요?</span>
                <a href="">ID찾기</a>
                <a href="">ID찾기</a>
            </div>
        </form>
        
        <script>
        </script>
    </div>
</body>
</html>