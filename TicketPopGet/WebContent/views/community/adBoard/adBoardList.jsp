<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#wrap_adlist{
	    width: 1200px;
	    height: 1000px;
	    margin: auto;
	    box-sizing: border-box;
	}
	/*이벤트결과발표*/
	#adBoardHead{
	    font-size: 45px;
	    margin-top: 10px;
	    margin-bottom: 30px;
	}
	/*분류 버튼*/
	#adBoardBtn{
	    margin-top: 10px;
	    margin-bottom: 20px;
	}
	/*paging 버튼*/
	#adBoardPaging{
	    text-align: center;
	    margin-top: 30px;
	}
	#adBoardPaging button{
	    margin-top: 20px;
	    width: 40px;
	    height: 40px;
	    border: none;
	    color: white;
	    background-color: #ffb300;
	    border-radius: 5px;
	}
	a{color:black !important; text-decoration:none !important;}
</style>
</head>
<body>
	<%@ include file="/views/common/menubar.jsp" %>

	<div id="wrap_adlist">
        <div id="adBoardHead">
            <b>홍보 게시판</b>
        </div>
        <div id="adBoardBtn">
            <a  class="btn btn-outline-warning btn-lg">콘서트</a>
            <a  class="btn btn-outline-warning btn-lg">연극</a>
            <a  class="btn btn-outline-warning btn-lg">전시</a>
        </div>
        <table id="adBoardList" class="table table-hover">
            <thead class="thead-dark" align="center">
              <tr>
                <th scope="col">번호</th>
                <th scope="col">분류</th>
                <th scope="col">지역</th>
                <th scope="col" width="50%">제목</th>
                <th scope="col" width=10%>날짜</th>
                <th scope="col">조회수</th>
              </tr>
            </thead>
            <tbody align="center">
              <tr>
                <th scope="row">1</th>
                <td>연극</td>
                <td>서울/경기권</td>
                <td><a href="">이화동 연극회의 "테세우스 이야기"에 여러분을 초대합니다</a></td>
                <td>2020/01/02</td>
                <td>30</td>
              </tr>
              <tr>
                <th scope="row">2</th>
                <td>연극</td>
                <td>서울/경기권</td>
                <td><a href="">한국대학교 연극동아리 '거지들'이 2월에 공연하는데 오실래요?</a></td>
                <td>2020/02/02</td>
                <td>40</td>
              </tr>
              <tr>
                <th scope="row">3</th>
                <td>콘서트</td>
                <td>경상/제주권</td>
                <td><a href="">제주합창회의 크리스마스 합창공연 'Silent Night'</a></td>
                <td>2020/11/30</td>
                <td>50</td>
              </tr>
              <tr>
                <th scope="row">4</th>
                <td>Larry</td>
                <td>Larry</td>
                <td>the Bird</td>
                <td>@twitter</td>
                <td>@mdo</td>
              </tr>
              <tr>
                <th scope="row">5</th>
                <td>Larry</td>
                <td>Larry</td>
                <td>the Bird</td>
                <td>@twitter</td>
                <td>@mdo</td>
              </tr>
              <tr>
                <th scope="row">6</th>
                <td>Larry</td>
                <td>Larry</td>
                <td>the Bird</td>
                <td>@twitter</td>
                <td>@mdo</td>
              </tr>
              <tr>
                <th scope="row">7</th>
                <td>Larry</td>
                <td>Larry</td>
                <td>the Bird</td>
                <td>@twitter</td>
                <td>@mdo</td>
              </tr>
              <tr>
                <th scope="row">8</th>
                <td>Larry</td>
                <td>Larry</td>
                <td>the Bird</td>
                <td>@twitter</td>
                <td>@mdo</td>
              </tr>
              <tr>
                <th scope="row">9</th>
                <td>Larry</td>
                <td>Larry</td>
                <td>the Bird</td>
                <td>@twitter</td>
                <td>@mdo</td>
              </tr>
              <tr>
                <th scope="row">10</th>
                <td>Larry</td>
                <td>Larry</td>
                <td>the Bird</td>
                <td>@twitter</td>
                <td>@mdo</td>
              </tr>
            </tbody>
        </table>
        <div align="right">
          <a class="btn btn-warning btn-lg">글쓰기</a>
        </div>

        <div id="adBoardPaging">
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