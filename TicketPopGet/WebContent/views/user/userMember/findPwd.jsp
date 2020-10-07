<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
    .searchIdbox{
        width: 700px;
        height: 700px;
        margin-left: 25%;
        margin-top: 2%;
        padding: 25px 15px;
        box-sizing: border-box;
    }
    .searchIdbox h1{
        width: 100%;
        height: 40px;
        font-size: 35px;
        color: #ffb300;
        padding-left: 40px;
        margin-bottom: 50px;
        text-align: center;
    }
    #userName, #phone{
        width: 200px;
        height: 25px;
        box-sizing: border-box;
        margin-bottom: 15px;
        font-size: 14px;
    }
    .userName{
        
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

    <div class="searchIdbox">
        <h1>비밀번호 찾기</h1>
        <form id="searchForm" action="<%= request.getContextPath() %>/findPwd.me" method="post" align="center">
            <label for="userName" class="userName">이름</label>
            <input type="text" id="userName" name="userName" required><br>
            <label for="userId" class="userId">아이디</label>
            <input type="text" id="userId" name="userId" required><br>
            <label for="phone" class="phone">전화번호</label>
            <input type="text" id="phone" name="phone" required>

            <br>
            <div class="btnwrap">
                <input type="submit" id="loginbtn" value="비밀번호찾기">
            </div>
            <br>
        </form>
        
        <script>
        </script>
    </div>
</body>
</html>