<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
    .noticetitle{
        margin:auto;
        margin-left: 40px;
    }
    #topMenu {
            height: 50px;
            width: 1100px;
    }

    .servicemenu {
            list-style: none;
            background-color: white;
            float: left;
            line-height: 50px;
            text-align: center;
    }
    #line{
        color: #ffb300;
    }
    #topMenu .menuLink {
            text-decoration:none;
            color: #ffb300;
            display: block;
            width: 500px;
            font-size: 20px;
            font-weight: bold;
            font-family: "Trebuchet MS";
    }
    #topMenu .menuLink:hover {
            color: white;
            background-color: #ffb300;
    }
    #noticeTable{
        width: 1000px;
        margin:auto;
        margin-left: 40px;

    }
    .area{float: left;}
    #noticeDiv{margin-left:5%}

    #listArea>tbody>tr:hover{
            background:rgba(128, 128, 128, 0.596);
            cursor:pointer;
        }

    .pagination {margin:50px 250px 0; text-align:center;}
    .pagination .btn-prev, .pagination .btn-next, .pagination a span {display: inline-block; margin-right:2px; padding: 4px 12px; border:1px solid #ddd; border-radius: 4px; color: #111; background:#fff; text-decoration: none; text-align: center;}
    .pagination .btn-prev:hover, .pagination .btn-next:hover, .pagination a span:hover,
    .pagination .btn-prev:active, .pagination .btn-next:active, .pagination a span:active,
    .pagination .btn-prev:focus, .pagination .btn-next:focus, .pagination a span:focus {color:#fff; background:#ff8149; border:1px solid #ff8149}
    .pagination a .selected {color:#ff8149; border:1px solid #ff8149}
    .pagination .no-more-prev, .pagination .no-more-next {display:none}
</style>
<body>
<!-- 상단 메뉴바  -->
<%@ include file="/views/common/menubar.jsp"%>
	<div class="area">
    <!-- 왼쪽메뉴바 -->
    <%@ include file="/views/serviceCenter/serviceMenubar.jsp"%>
    </div>
    <div class="area">
	    <div>
	        <h2 class="noticetitle"><b>1 : 1문의</b></h2>
	        <nav id="topMenu">
	            <ul class="servicemenu">
	                <li class="servicemenu"><a class="menuLink" href="">문의내역</a></li>
	                <li class="servicemenu"><a class="menuLink" href="">문의하기</a></li>
	            </ul>
	        </nav>
	    </div>
	
	    <div id="noticeTable">
	        <table class="table table-striped" id="listArea">
	            <thead>
	                <tr>
	                    <th style="width: 12%;">처리현황</th>
	                    <th>질문</th>
	                    <th style="width: 12%;">문의유형</th>
	                    <th style="width: 16%;">작성일</th>
	                </tr>
	            </thead>
	            <tbody>
	                <tr>
	                    <td>문의접수</td>
	                    <td>회원정보수정은 어디서 하나요?</td>
	                    <td>회원</td>
	                    <td>2020-07-21</td>
	                </tr>
	                <tr>
	                    <td>문의접수</td>
	                    <td>결제는 어떻게 하나요?</td>
	                    <td>결제</td>
	                    <td>2020-06-15</td>
	                </tr>
	                <tr>
	                    <td>답변완료</td>
	                    <td>환불계좌가 바뀌면 어떻게 하나요?</td>
	                    <td>예매/취소</td>
	                    <td>2020-04-23</td>
	                </tr>
	                <tr>
	                    <td>답변완료</td>
	                    <td>페이지가 넘어가지 않아요.</td>
	                    <td>기타</td>
	                    <td>2020-03-05</td>
	                </tr>
	            </tbody>
	        </table>
	        <div class="pagination">
	            <a href="" class=" btn-prev"><i class="fa fa-chevron-circle-left"></i> Prev</a>
	            <a href=""><span>1</span></a>
	            <a href=""><span>2</span></a>
	            <a href=""><span>3</span></a>
	            <a href=""><span>4</span></a>
	            <a href=""><span>5</span></a>
	            <a href=""><span>6</span></a>
	            <a href=""><span>7</span></a>
	            <a href=""><span>8</span></a>
	            <a href=""><span>9</span></a>
	            <a href=""><span>10</span></a>
	            <a href="" class=" btn-next">Next <i class="fa fa-chevron-circle-right"></i></a>
	        </div>
	    </div>
	</div>
</body>
</html>