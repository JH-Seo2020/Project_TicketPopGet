<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.serviceCenter.model.vo.Question" %>
<%
	Question q = (Question)request.getAttribute("q");
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
    table{
        margin-left:40px ;
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
            width: 500px;
            font-size: 20px;
            font-weight: bold;
            font-family: "Trebuchet MS";
    }
    #topMenu .menuLink:hover {
            color: white;
            background-color: #ffb300;
    }
    .area{float: left;}
    #noticeDiv{margin-left:5%}
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
                    <li class="servicemenu"><a class="menuLink" href="<%= request.getContextPath() %>/list.qo?currentPage=1">문의내역</a></li>
                    <li class="servicemenu"><a class="menuLink" href="<%= request.getContextPath() %>/enrollForm.qo">문의하기</a></li>
                </ul>
            </nav>
        </div>
        <div>
                <div class="table table-responsive" style="width: 1200px;">
                    <table class="table" style="width: 1000px;">
                    <tr>
                        <th class="success" name="questionType">문의유형 : <%=q.getQuestionType() %></th>
                    </tr>
                    <tr>
                        <th class="success" name="questionTitle"><%=q.getQuestionTitle() %></th>
                    </tr>
                                
                    <tr>
                        <td name="questionDate" style="font-size: 15px;">등록일 : <%=q.getQuestionDate() %></td>
                    </tr>

                    <tr>
                        <td name="questionConten">
                            <%= q.getQuestionContent() %> 
                        </td>
                    </tr>
                </table>
                <br><br>
                <table style="width: 1000px;">
                    <tr>
                        <th>답변</th>
                    </tr>
                    <tr>
                        <td>마이페이지에서 수정 가능합니다.</td>
                    </tr>
                    
                    <tr>
                        <td align="right">
                            <input type="button" class="btn btn-warning" onclick="history.back()" value="목록보기">          
                        </td>
                    </tr>
                    </table>
                </div>
        </div>
    </div>
</body>
</html>