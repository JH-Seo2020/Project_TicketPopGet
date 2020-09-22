<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        #wrap_evReDe{
            width: 1200px;
            height: auto;
            margin: auto;
        }
        /*이벤트결과발표*/
        #adBoardHead{
            font-size: 45px;
            margin-top: 10px;
            margin-bottom: 30px;
            height: 7%;
        }
        /*글작성영역*/
        #adBoardBody{
            width: 100%;
            height: 50%;
        }
        #adBoardBodyTitle {
            width: 100%;
            padding: 20px;
            font-size: 30px;
            background-color: lightgray;
            margin-top: 10px;
        }
        #adBoardBodySub{
            width: 100%;
            font-size: 20px;
            background-color: lightgray;
            margin-top: 10px;
            text-align: right;
        }
        #adBoardBodySub>div{float: right; padding-right: 10px; }
        #adBoardBodyContent{
            width: 100%;
            padding: 20px;
            background-color: lightgray;
            margin-top: 10px;
        }
        #adBoardBodyBtns{
            float: right;
            margin: 20px;
        }
        
    </style>
</head>
<body>
	<%@ include file="/views/common/menubar.jsp" %>

	<div id="wrap_evReDe">
        <div id="adBoardHead">
            <b>이벤트 결과 발표</b>
        </div>
        <div id="adBoardBody">
            <div id="adBoardBodyTitle">
                <span>연극</span>
                <span>'사이클롭스' 이벤트 결과 발표</span>
            </div>
            <div id="adBoardBodySub">
                작성일 : 2020-02-02 조회수 : 100 
            </div>
            <div id="adBoardBodyContent">
                안녕하세요<br>
                관리자입니다. <br>
                지난번 시행했던 연극 '사이클롭스'의 이벤트 결과를 발표합니다. <br>
                ------------------------------------------------ <br>
                윤xx : 010-2000-**** <br>
                윤xx : 010-2000-**** <br>
                윤xx : 010-2000-**** <br>
                ------------------------------------------------ <br>
                당첨되신분은 공연일인 10월 3일날 매표소 데스크에서 성명과 전화번호를 말씀하시고 표를 받아가세요. <br>
                감사합니다. <br>
                <br>
                <br>
                <br>
                에디터 어느 세월에 넣지 
                <br>
                내용 보여주는 부분은 height 지정 안했습니다 크기따라 보이게.. 해놨어요
            </div>
            <div id="adBoardBodyBtns">
                <a class="btn btn-secondary" href="">목록으로</a>
            </div>
        </div>
    
    </div>
</body>
</html>