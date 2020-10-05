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
                    <li class="servicemenu"><a class="menuLink" href="">문의내역</a></li>
                    <li class="servicemenu"><a class="menuLink" href="<%= request.getContextPath() %>/enrollForm.qo">문의하기</a></li>
                </ul>
            </nav>
        </div>
        <div>
                <div class="table table-responsive" style="width: 1200px;">
                    <table class="table" style="width: 1000px;">
                    <tr>
                        <th class="success" name="noticeType">회원정보수정은 어디서 하나요?</th>
                    </tr>
                                
                    <tr>
                        <td name="noticeDate" style="font-size: 15px;">등록일 : <!-- sysdate -->2020.02.21(금) 09:30</td>
                    </tr>

                    <tr>
                        <td name="noticeContent">
                            <!-- 내용 -->
                                                              회원정보수정 메뉴가 어딘지 문의합니다. <br>메뉴 어떤건가요? 
                        </td>
                    </tr>
                    <tr>
                        <td name="attachment">
                            <b>첨부파일 : </b><a href="/jsp/resources/board_upfiles/파일수정명.jsp">파일원본명.jsp</a>
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
                            <input type="button" class="btn btn-warning" value="목록보기">          
                        </td>
                    </tr>
                    </table>
                </div>
        </div>
    </div>
</body>
</html>