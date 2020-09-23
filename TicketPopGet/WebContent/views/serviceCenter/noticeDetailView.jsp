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
    .noticeTable{
        margin-left:40px ;
        width: 1000px;
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

        <div class="table table-responsive" style="width: 1200px;">
            <table class="noticeTable" style="width: 1000px;">
                <tr>
                    <th class="success" name="noticeType"><!-- 분류 -->변경/취소</th>
                    <th class="success" name="noticeTitle"><!-- 제목 -->2020 양지원 미니콘서트 오픈취소 안내</th>
                </tr>
                                
                <tr>
                    <td colspan="2" name="noticeDate" style="font-size: 15px;">등록일 : <!-- sysdate -->2020.02.21(금) 09:30</td>
                </tr>

                <tr>
                    <td colspan="2" name="noticeContent">
                        <!-- 내용 -->
                        1st. 양지원 미니콘서트 & 팬미팅 연기 “코로나19 심각단계, 숙고 끝에 결정”
                        <br><br>
                        위드포유 미디어그룹에서는<br>
                        금일 25일 부로 코로나19가 심각 단계로<br>
                        격상됨에 따라 내달(28일) 오후 6시 예정이었던<br>
                        1st.양지원 미니콘서트 & 팬미팅을 연기하기로<br>
                        최종 결정했습니다.
                        <br><br>
                        한층 업그레이드 된 공연으로 인사드리겠습니다.
                        <br><br>

                        감사합니다.
                        <br><br>
                        위드포유 미디어그룹 임직원 일동.
                    </td>
                </tr>
                
                <tr>
                    <td colspan="2" align="right">
                        <input type="button" class="btn btn-warning" value="목록보기">          
                    </td>
                </tr>
            </table>
        </div>
    </div>

</body>
</html>