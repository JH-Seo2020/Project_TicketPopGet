<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
    h2{
        margin:auto;
        margin-left: 40px;
    }
    #topMenu {
            height: 50px;
            width: 1100px;
    }

    #topMenu ul li {
            list-style: none;
            background-color: white;
            float: left;
            line-height: 50px;
            /* vertical-align: middle; */
            text-align: center;
    }
    #line{
        color: #ffb300;
    }
    #topMenu .menuLink {
            text-decoration:none;
            color: #ffb300;
            display: block;
            width: 250px;
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
<!-- 왼쪽 메뉴바 -->
<%@ include file="/views/serviceCenter/serviceMenubar.jsp"%>
	<div>
        <h2><b>공지사항</b></h2>
        <nav id="topMenu">
            <ul>
                <li><a class="menuLink" href="">전체</a></li>
                <li><a class="menuLink" href="">변경/취소</a></li>
                <li><a class="menuLink" href="">시스템</a></li>
                <li><a class="menuLink" href="">기타</a></li>
            </ul>
        </nav>
    </div>

    <div id="noticeTable">
        <table class="table table-striped" id="listArea">
            <thead>
                <tr>
                    <th>분류</th>
                    <th>제목</th>
                    <th>등록일</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>변경/취소</td>
                    <td>2020 양지원 미니콘서트 오픈취소 안내</td>
                    <td>2020-02-21</td>
                </tr>
                <tr>
                    <td>시스템</td>
                    <td>시스템 임시점검 1/22(00-00~03:00)</td>
                    <td>2020-01-20</td>
                </tr>
                <tr>
                    <td>기타</td>
                    <td>뮤직어워드 온라인 티켓 공지사항</td>
                    <td>2019-12-11</td>
                </tr>
                <tr>
                    <td>변경/취소</td>
                    <td>2020 양지원 미니콘서트 오픈취소 안내</td>
                    <td>2020-02-21</td>
                </tr>
                <tr>
                    <td>시스템</td>
                    <td>시스템 임시점검 1/22(00-00~03:00)</td>
                    <td>2020-01-20</td>
                </tr>
                <tr>
                    <td>기타</td>
                    <td>뮤직어워드 온라인 티켓 공지사항</td>
                    <td>2019-12-11</td>
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
</body>
</html>