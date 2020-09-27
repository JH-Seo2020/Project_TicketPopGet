<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.community.eventResult.model.vo.EventRaffle" %>
<%
	EventRaffle raffle = (EventRaffle)request.getAttribute("raffle");
%>
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
                <span><%=raffle.getEventType() %></span>
                <span><%=raffle.getRaffleTitle() %></span>
            </div>
            <div id="adBoardBodySub">
                작성일 : <%=raffle.getRaffleDate() %> 조회수 : <%=raffle.getRaffleCount() %>
            </div>
            <div id="adBoardBodyContent">
                <%=raffle.getRaffleContent() %>
            </div>
            <div id="adBoardBodyBtns">
                <a class="btn btn-secondary" id="back">목록으로</a>
            </div>
        </div>
    <script>
    	$(function(){
    		$("#back").click(function(){
    			if(document.referrer){
    	    		history.back();
    	    	}else{
    	    		location.href="<%=contextPath%>/event.result?currentPage=1";
    	    	}
    		});
    	});
    </script>
    </div>
</body>
</html>