<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .wrap{
        width: 1200px;
        height: 850px;
        margin: auto;
        text-align: center;
    }
    
    .selectTable{width: 100%;}
    
    .returnMainPage{
        width: 100px;
        height: 40px;
        background: #98c3ff;
        border: none;
        border-radius: 10px;
        float: right;
    }

    .selectTable>tbody:hover{cursor: pointer;}

</style>
</head>
<body>
    <div class="wrap" align="center">
        <button class="returnMainPage">초기화면</button>
    <div align="center">
        <h1 style="width: 500px;">회원 전체 조회</h1>
    </div>
        
    <table class="selectTable" border="1">

        <thead style="background: #6495ed;">
            <tr style="height: 50px;">
                <th width="100px">회원번호</th>
                <th width="180px">회원아이디</th>
                <th width="150px">회원명</th>
                <th >이메일</th>
                <th width="150px">연락처</th>
                <th width="100px">탈퇴여부</th>
            </tr>
        </thead>

        <tbody>
            <tr style="height: 50px;">
                <td>10</td>
                <td>10사용자</td>
                <td>user10</td>
                <td>user10@naver.com</td>
                <td>010-0000-0000</td>
                <td>N</td>
            </tr>
            
        </tbody>

    </table>
    <form action="" style="float: right;">
        <input type="text" list="selectUser">
        <select name="selectUser" id="selectUser">
            <option value="selectAll">전체</option>
            <option value="userId">아이디</option>
            <option value="userName">회원명</option>
            <option value="phone">연락처</option>
        </select>
        <button>검색</button>
    </form>
    <br><br>
    <div align="center">

        <button>&lt;&lt;</button>
        <button>&lt;</button>
        <button>1</button>
        <button>2</button>
        <button>3</button>
        <button>4</button>
        <button>5</button>
        <button>6</button>
        <button>7</button>
        <button>8</button>
        <button>9</button>
        <button>10</button>
        <button>&gt;</button>
        <button>&gt;&gt;</button>   
        
    </div>

    </div>
</body>
</html>