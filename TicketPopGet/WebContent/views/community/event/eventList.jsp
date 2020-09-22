<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        #wrap_ev{
            width: 1200px;
            height: 1000px;
            margin: auto;
            box-sizing: border-box;
        }
        /*댓글 이벤트*/
        #replyEventHead{
            font-size: 45px;
            margin-top: 10px;
            margin-bottom: 30px;
        }
        /*분류 버튼*/
        #replyEventBtn{
            margin-top: 10px;
            margin-bottom: 20px;
        }
        /*paging 버튼*/
        #replyEventPaging{
            text-align: center;
            margin-top: 30px;
        }
        #replyEventPaging button{
            margin-top: 20px;
            width: 40px;
            height: 40px;
            border: none;
            color: white;
            background-color: #ffb300;
            border-radius: 5px;
        }
        a{text-decoration: none;
          color:black !important;}
</style>
</head>
<body>
	<%@ include file="/views/common/menubar.jsp" %>

	<div id="wrap_ev">
        <div id="replyEventHead">
            <b>댓글 이벤트</b>
        </div>
        <div id="replyEventBtn">
            <a type="button" class="btn btn-outline-warning btn-lg">콘서트</a>
            <a type="button" class="btn btn-outline-warning btn-lg">연극</a>
            <a type="button" class="btn btn-outline-warning btn-lg">전시</a>
        </div>
        <table id="replyEventList" class="table table-hover">
            <thead class="thead-dark" align="center">
              <tr>
                <th scope="col">번호</th>
                <th scope="col">분류</th>
                <th scope="col" width="60%">제목</th>
                <th scope="col" width=15%>날짜</th>
                <th scope="col">조회수</th>
              </tr>
            </thead>
            <tbody align="center">
              <tr>
                <th scope="row">1</th>
                <td>연극</td>
                <td> <a href="">연극 "황금사과이야기" 응모 이벤트 - 공짜표 드립니다</a></td>
                <td>2020/01/02</td>
                <td>30</td>
              </tr>
              <tr>
                <th scope="row">2</th>
                <td>콘서트</td>
                <td><a href="">고릴라즈 내한 기념 무료 티켓 이벤트!!</a></td>
                <td>2020/02/02</td>
                <td>40</td>
              </tr>
              <tr>
                <th scope="row">3</th>
                <td>Larry</td>
                <td>the Bird</td>
                <td>@twitter</td>
                <td>@mdo</td>
              </tr>
              <tr>
                <th scope="row">4</th>
                <td>Larry</td>
                <td>the Bird</td>
                <td>@twitter</td>
                <td>@mdo</td>
              </tr>
              <tr>
                <th scope="row">5</th>
                <td>Larry</td>
                <td>the Bird</td>
                <td>@twitter</td>
                <td>@mdo</td>
              </tr>
              <tr>
                <th scope="row">6</th>
                <td>Larry</td>
                <td>the Bird</td>
                <td>@twitter</td>
                <td>@mdo</td>
              </tr>
              <tr>
                <th scope="row">7</th>
                <td>Larry</td>
                <td>the Bird</td>
                <td>@twitter</td>
                <td>@mdo</td>
              </tr>
              <tr>
                <th scope="row">8</th>
                <td>Larry</td>
                <td>the Bird</td>
                <td>@twitter</td>
                <td>@mdo</td>
              </tr>
              <tr>
                <th scope="row">9</th>
                <td>Larry</td>
                <td>the Bird</td>
                <td>@twitter</td>
                <td>@mdo</td>
              </tr>
              <tr>
                <th scope="row">10</th>
                <td>Larry</td>
                <td>the Bird</td>
                <td>@twitter</td>
                <td>@mdo</td>
              </tr>
            </tbody>
        </table>

        <div id="replyEventPaging">
            <button>&lt;&lt;</button>
            <button>&lt;</button>
            <button>1</button>
            <button>2</button>
            <button>3</button>
            <button>4</button>
            <button>5</button>
            <button>&gt;</button>
            <button>&gt;&gt;</button>
        </div>

    </div>

</body>
</html>