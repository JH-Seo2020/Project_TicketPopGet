<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.serviceCenter.model.vo.Notice" %>
<%
	Notice n = (Notice)request.getAttribute("n");
%>
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
    .noticeTable{
        margin-left:40px ;
        width: 900px;
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
    .area{float: left; margin-left:10%;}
    #noticeDiv{margin-left:0%}

</style>
<body>
<!-- 상단 메뉴바  -->
<%@ include file="/views/common/menubar.jsp"%>
	<div class="area">
    <!-- 왼쪽메뉴바 -->
    <%@ include file="/views/serviceCenter/serviceMenubar.jsp"%>
    </div>
    <div class="area" id="noticeDiv">
        <div>
            <br>
            <h2 class="noticetitle"><b>공지사항</b></h2>
            <nav id="topMenu">
                <ul  class="servicemenu">
                    <li class="servicemenu"><a class="menuLink" href="<%= request.getContextPath() %>/list.no?currentPage=1">전체</a></li>
                    <li class="servicemenu"><a class="menuLink" href="<%= request.getContextPath() %>/search.no?currentPage=1&type=변경/취소">변경/취소</a></li>
                    <li class="servicemenu"><a class="menuLink" href="<%= request.getContextPath() %>/search.no?currentPage=1&type=시스템">시스템</a></li>
                    <li class="servicemenu"><a class="menuLink" href="<%= request.getContextPath() %>/search.no?currentPage=1&type=기타">기타</a></li>
                </ul>
            </nav>
        </div>

        <div class="table table-responsive" style="width: 1200px;">
            <table class="noticeTable" style="width: 1000px;">
                <tr>
                    <th class="success" name="noticeType"><%= n.getNoticeType() %></th>
                    <th class="success" name="noticeTitle"><%= n.getNoticeTitle() %></th>
                </tr>
                                
                <tr>
                    <td colspan="2" name="noticeDate" style="font-size: 15px;">등록일 : <%= n.getNoticeDate() %></td>
                </tr>

                <tr>
                    <td colspan="2" name="noticeContent">
                        <%= n.getNoticeContent() %>
                    </td>
                </tr>
                
                <tr>
                    <td colspan="2" align="right">
                        <input type="button" class="btn btn-warning"  onclick="history.back()" value="목록보기">          
                    </td>
                </tr>
            </table>
        </div>
    </div>

</body>
</html>