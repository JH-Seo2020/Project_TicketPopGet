<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

    #logo>img{
        width: 100px;
        height: 100px;
    }
    
    #mainPageWrap{
        width: 1200px;
        height: 600px;
        margin: auto;
    }

    .mainPageTableWrap{
        width: 210px;
        height: 500px;
        float: left;
        margin-left: 20px;
        margin-bottom: 5%;
    }

    .mainPageTableWrap>table{
        width: 100%;
        margin:0;
        }

    .mainPageTableWrap span{font-size: 25px;}

    .mainPageTableWrap button{
        width: 200px;
        height: 50px;
        font-size: 18px;
        border: none;
        background: #98c3ff;
        border-radius: 20px;
        }

    .mainPageTableWrap  th{
        width: 100%;
        height: 80px;
    }
    
    a{text-decoration: none;}

</style>
</head>
<body>
    <div id="mainPageWrap">
        <div align="center" style=" margin: auto;">
            <!-- <div id="logo" style="position: absolute;"><img src="" alt="logo"></div> -->
            <h1 style="margin-top: 0;">통합 관리 메뉴</h1>
        </div>
        <div align="right">
            <span>관리자</span>
            <a href="">로그아웃</a>
            <a href="">사용자페이지</a>
        </div>
        <div class="mainPageTableWrap" align="center">  
            <table align="center">
                <tr>
                    <th class="menuTitle">
                        <span>회원관리</span>
                    </th>
                </tr>
                <tr>
                    <th><button type="button" onclick="location.href='<%=request.getContextPath()%>/list.adme?currentPage=1'">회원전체 조회</button></th>
                </tr>
                <tr>
                    <th><button type="button" onclick="location.href='<%=request.getContextPath()%>/blacklist.adme?currentPage=1'">블랙리스트 조회</button></th>
                </tr>
                <tr>
                    <th><button type="button">탈퇴회원 조회</button></th>
                </tr>
            </table>
        </div>
        <div class="mainPageTableWrap" align="center">
            <table align="center" align="center">
                <tr>
                    <th class="menuTitle">
                        <span>고객센터</span>
                    </th>
                </tr>
                <tr>
                    <th><button type="button" onclick="location.href='<%=request.getContextPath()%>/list.adno?currentPage=1'">공지사항 관리</button></th>
                </tr>
                <tr>
                    <th><button type="button" onclick="location.href='<%=request.getContextPath()%>/list.adfa?currentPage=1'">FAQ</button></th>
                </tr>
                <tr>
                    <th><button type="button">1대1문의 관리</button></th>
                </tr>
                <tr>
                    <th><button type="button" onclick="location.href='<%=request.getContextPath()%>/list.adre?currentPage=1'">신고내역 관리</button></th>
                </tr>
            </table>
        </div>
        <div class="mainPageTableWrap" align="center">
            <table align="center">
                <tr>
                    <th class="menuTitle">
                        <span>컨텐츠 관리</span>
                    </th>
                </tr>
                <tr>
                    <th><button type="button">컨텐츠 조회/삭제</button></th>
                </tr>
                <tr>
                    <th><button type="button">컨텐츠 등록/수정</button></th>
                </tr>
            </table>
        </div>
        <div class="mainPageTableWrap" align="center">
            <table align="center">
                <tr>
                    <th class="menuTitle">
                        <span>컨텐츠 예매관리</span>
                    </th>
                </tr>
                <tr>
                    <th><button type="button">예매 및 결제현황</button></th>
                </tr>
                <tr>
                    <th><button type="button">예매통계</button></th>
                </tr>
            </table>
        </div>
        <div class="mainPageTableWrap" align="center">
            <table align="center">
                <tr>
                    <th class="menuTitle">
                        <span>커뮤니티</span>
                    </th>
                </tr>
                <tr>
                    <th><button type="button">후기관리</button></th>
                </tr>
                <tr>
                    <th><button type="button">자율홍보 관리</button></th>
                </tr>
                <tr>
                    <th><button type="button">댓글이벤트 관리</button></th>
                </tr>
                <tr>
                    <th><button type="button">댓글이벤트 참가자</button></th>
                </tr>
                <tr>
                    <th><button type="button">댓글이벤트 당첨자</button></th>
                </tr>
            </table>
        </div>
    </div>
</body>
</html>