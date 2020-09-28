<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.serviceCenter.model.vo.*" %>
<%
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
%>
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

    .servicemenu{
            list-style: none;
            background-color: white;
            float: left;
            line-height: 50px;
            vertical-align: middle;
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
    
    .area{float: left;}
    #noticeDiv{margin-left:5%}

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
	<!-- 왼쪽 메뉴바 -->
	<%@ include file="/views/serviceCenter/serviceMenubar.jsp"%>
    </div>
    <div class="area" id="noticeDiv">
        <div>
        	<br>
            <h2><b>공지사항</b></h2>
            <nav id="topMenu">
                <ul  class="servicemenu">
                    <li class="servicemenu"><a class="menuLink" href="">전체</a></li>
                    <li class="servicemenu"><a class="menuLink" href="">변경/취소</a></li>
                    <li class="servicemenu"><a class="menuLink" href="">시스템</a></li>
                    <li class="servicemenu"><a class="menuLink" href="">기타</a></li>
                </ul>
            </nav>
        </div>

        <div id="noticeTable">
            <table class="table table-striped" id="listArea">
                <thead>
                    <tr>
                    	<th>글번호</th>
                        <th>분류</th>
                        <th>제목</th>
                        <th>등록일</th>
                    </tr>
                </thead>
                <tbody>
                	<% if(list.isEmpty()){ %>
                    <tr>
                        <td colspan="4">조회된 리스트가 없습니다.</td>
                    </tr>
                    <% }else { %>
                    	<% for(Notice n : list) { %>
                    <tr>
                    	<td><%= n.getNoticeNo() %></td>
                        <td><%= n.getNoticeType() %></td>
                        <td><%= n.getNoticeTitle() %></td>
                        <td><%= n.getNoticeDate() %></td>
                    </tr>
                    <% } %>
                  <% } %>
                </tbody>
            </table>
        </div>
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