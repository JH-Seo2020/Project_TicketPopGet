<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.user.model.vo.Member"%>
<%
	Member m = (Member)request.getAttribute("m");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <style>
        .wrap{
            width: 1200px;
            height: 850px;
            margin: auto;
            border: solid;
            text-align: center;
        }

        .userDetailSelect>table>thead{
            background: #98c3ff;
        }

        .userDetailSelect{
            width: 100%;
        }

    </style>
</head>
<body>
	<%@ include file = "../adminCommon/adminMenubar.jsp" %>
    <div class="wrap">
        <button class="btn btn-primary" style="float: right; width: 100px; height: 40px;" onclick="location.href='<%=request.getContextPath()%>/list.adme?currentPage=1'">이전으로</button>
        <h1 style="width: 800px; margin: auto;">회원상세조회</h1>
        <button class="btn btn-danger" style="float: right; height: 40px;">회원정보삭제</button>
        <button class="btn btn-primary" style="float: right; height: 40px;" >회원정보수정</button>
        <table border="1" width="100%">
            <thead>
                <tr width="100%"  style="height: 40px; background:#6495ed;" > 
                    <th style="width: 60px;">회원번호</th>
                    <th style="width: 100px;">회원아이디</th>
                    <th style="width: 100px;">회원명</th>
                    <th style="width: 350px;">이메일</th>
                    <th style="width: 150px;">연락처</th>
                    <th style="width: 100px;">생년월일</th>
                    <th style="width: 60px;" >성별</th>
                    <th style="width: 60px;">탈퇴여부</th>
                    <th style="width: 60px;">블랙여부</th>
                </tr>
            </thead>
            <tbody>
                <tr id="MemberDetailView" style="height: 40px;">
                    <td><input type="text" disabled name="userNo" value="<%=m.getUserNo()%>" required style="width: 100%; height: 40px; box-sizing: border-box;"></td>
                    <td><input type="text" disabled name="userId" value="<%=m.getUserId() %>" required style="width: 100%; height: 40px; box-sizing: border-box;"></td>
                    <td><input type="text" disabled name="userName" value="<%=m.getUserName() %>" required style="width: 100%; height: 40px; box-sizing: border-box;"></td>
                    <td><input type="email" disabled name="email" value="<%=m.getEmail()%>" required style="width: 100%; height: 40px; box-sizing: border-box;"></td>
                    <td><input type="tel" disabled name="phone" value="<%=m.getPhone() %>" required style="width: 100%; height: 40px; box-sizing: border-box;"> </td>
                    <td><input type="text" disabled name="birthdate" value="<%=m.getBirthdate()%>" required style="width: 100%; height: 40px; box-sizing: border-box;"></td>
                    <td><input type="text" disabled name="gender" value="<%=m.getGender() %>" required style="width: 100%; height: 40px; box-sizing: border-box;"></td>
                    <td><input type="text" disabled name="deleteStatus" value="<%=m.getStatus() %>" required style="width: 100%; height: 40px; box-sizing: border-box;"></td>
                    <td><input type="text" disabled name="blacklistStatus" value="<%=m.getBlacklistStatus() %>" required style="width: 100%; height: 40px; box-sizing: border-box;"></td>
                </tr>
            </tbody>
        </table>

        <div class="userDetailSelect" id="reservation">
            <h3>최근예매내역</h3>
            <table border="1" style="width: 100%;">
                <thead>
                    <tr>
                        <th>예매번호</th>
                        <th>예매일</th>
                        <th>컨텐츠명</th>
                        <th>관람일</th>
                        <th>구매매수</th>
                        <th>결제상태</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>번호</td>
                        <td>일</td>
                        <td>컨텐츠이름</td>
                        <td>관람일</td>
                        <td>매수</td>
                        <td>상태</td>
                    </tr>
                    <tr>
                        <td>번호</td>
                        <td>일</td>
                        <td>컨텐츠이름</td>
                        <td>관람일</td>
                        <td>매수</td>
                        <td>상태</td>
                    </tr>
                    <tr>
                        <td>번호</td>
                        <td>일</td>
                        <td>컨텐츠이름</td>
                        <td>관람일</td>
                        <td>매수</td>
                        <td>상태</td>
                    </tr>
                </tbody>

            </table>
        </div>
        <div class="userDetailSelect" id="review">
            <h3>관람후기</h3>
            <table border="1" style="width: 100%;">
                <thead>
                    <tr>
                        <th>후기번호</th>
                        <th>작품제목</th>
                        <th>후기제목</th>
                        <th>후기작성일</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td>제목자리</td>
                        <td>후기제목자리</td>
                        <td>2020-00-00</td>
                    </tr>
                </tbody>   
            </table>

        </div>
        <div class="userDetailSelect" id="board">
            <h3>홍보게시판</h3>
            <table border="1" style="width: 100%;">
                <thead>
                    <tr>
                        <th>홍보번호</th>
                        <th>홍보제목</th>
                        <th>홍보작성일</th>
                    </tr>
                </thead>
                <tbody>
                    <tr">
                        <td>1</td>
                        <td>제목자리</td>
                        <td>2020-20-20</td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div class="userDetailSelect" id="question">
            <h3>1대1문의내역</h3>
            <table border="1" style="width: 100%;">
                <thead>
                    <tr>
                        <th>질문번호</th>
                        <th>질문제목</th>
                        <th>질문분류</th>
                        <th>질문작성일</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td>제목자리</td>
                        <td>분류자리</td>
                        <td>2020-02-02</td>
                    </tr>
                </tbody>

            </table>
        </div>
    </div>
</body>
</html>