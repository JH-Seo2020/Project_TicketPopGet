<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%

String alertMsg = (String)session.getAttribute("alertMsg");
// > 서비스요청전 : null
// > 서비스요청성공후 : alert띄워줄 메세지 문구
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    
    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> 
	    <style>
        #menubar{
            width: 150px;
            height: 850px;
            background: #6494ed93;
            text-align: left;
            float:left;
            margin-right:;
        }
	
		.wrap{
	        position: absolute;
        	left: 300px;
		}
	
        .menuTitle{
            width: 100%;
            height: 30px;
            font-size: 20px;
            font-weight: bold;
            border-radius: 5px;
            margin-bottom: 5px;
            color: white;
            line-height: 2;
            
        }

        .menuTitle:hover{cursor: pointer;}

        #menubar button{
            width: 150px;
            height: 30px;
            margin-top: 2px;
            margin-bottom: 2px;
            border: 0px;
            background: none;
            color: black;
            font-size: 15px;
        }
        
        .menuWrap button{text-align: left;}

    </style>
</head>
<body>
<script type="text/javascript">
	$(function(){
		var alertMsg = "<%=alertMsg%>"
		if(alertMsg != null && alertMsg != "null"){
			alert(alertMsg);
			<%session.removeAttribute("alertMsg");%>
		}
	});
</script>
<div id="menubar">
		
        <button align="center" onclick="location.href='<%=request.getContextPath()%>/main.ad'" style="padding-bottom: 60px; padding-top: 30px; width: 100% ; cursor: pointer; font-size: 25px;">메인으로</button>
        
        <div class="menuTitle">회원관리</div>
        <div class="menuWrap">
        <button onclick="location.href='<%=request.getContextPath()%>/list.adme?currentPage=1'">회원전체 조회</button>
        <button>탈퇴회원 조회</button>
        <button type="button" onclick="location.href='<%=request.getContextPath()%>/blacklist.adme?currentPage=1'">블랙리스트 조회</button>
        </div>

        <div class="menuTitle">고객센터</div>
        <div class="menuWrap">
        <button type="button" onclick="location.href='<%=request.getContextPath()%>/list.adno?currentPage=1'">공지사항 관리</button>
        <button type="button" onclick="location.href='<%=request.getContextPath()%>/list.adfa?currentPage=1'">FAQ</button>
        <button>1대1문의 관리</button>
        <button onclick="location.href='<%=request.getContextPath()%>/list.adre?currentPage=1'">신고관리</button>
        </div>
        

        <div class="menuTitle">컨텐츠관리</div>
        <div class="menuWrap">
        <button>컨텐츠 조회/삭제</button>
        <button>컨텐츠 등록/수정</button>
        </div>

        <div class="menuTitle">컨텐츠 예매현황</div>
        <div class="menuWrap">
        <button>예매 및 견제현황</button>
        <button>예매 통계</button>
        </div>

        <div class="menuTitle">커뮤니티 관리</div>
        <div class="menuWrap">
        <button>후기관리</button>
        <button>자율홍보 게시판</button>
        <button>댓글이벤트 관리</button>
        <button>댓글이벤트 참가자</button>
        <button>댓글이벤트 당첨자</button>
        </div>
    </div>
    <script>
        $(function(){

            if($(".menuWrap").css("display") != "none"){
                $(".menuTitle").click(function(){$(this).next().toggle(500)});
            }

            
        });
    </script>
</body>
</html>