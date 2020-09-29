<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.concert.model.vo.PageInfo, com.kh.play.model.vo.Play" %>
<% 
	ArrayList<Play> list = (ArrayList<Play>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	String region = (String)request.getAttribute("region");
	
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
<style>
	#wrap_play{
           width: 1200px;
           height: 2000px;
           margin: auto;
           box-sizing: border-box;
       }
	
	/*세부 조회 메인 - 전시 지역 설정하는 부분*/
	#playLocal{
	    height: 10%; 
	    width: 100%;
	    text-align: center;
	    margin-top: 5px;
	    padding-top: 50px;
	    font-size: 30px;    
	}
	#playLocal>select{height: 40%; width: 15%; font-size: 25px;}
	#playLocal>select>option { font-size: 15px;}
	
	/* 전시 포스터 보여지는 부분(12개, 페이징버튼)*/
	#playList{
	    margin-top: 5px;
	    height: 70%;
	    width: 100%;
	}
	#posterBody{width: 100%;height: 80%;}
	#posterBody>li{
	    list-style-type: none;
	    display:inline-block;
	    width: 30%;
	    height: 30%;
	}
	#playTitle{
	    font-size: 20px;
	}
	
	/*paging 버튼*/
	#playPaging{
	    text-align: center;
	    margin-top: 30px;
	}
	#playPaging button{
	    width: 40px;
	    height: 40px;
	    border: none;
	    color: white;
	    background-color: #ffb300;
	    border-radius: 5px;
	}
	/*a태그 밑줄없애기*/
	a{text-decoration: none !important; color: balck !important;}
	
</style>
</head>
<body>

	<%@ include file="/views/common/menubar.jsp" %>

	<div id="wrap_play">

        <div id="playLocal">
            <label>연극 &lt; </label>
            <select id="local">
                <option>전체</option>
                <option value="서울경기권">서울경기권</option>
                <option value="강원충청권">강원충청권</option>
                <option value="전라권">전라권</option>
                <option value="경상제주권">경상제주권</option>
            </select>
        </div>
        
        <script>
        	$(function(){	
        		$("#local").val('<%=region%>').attr("selected",true);
        		$("#local").on('change',function(){
        			var local = $("#local").val();
	        		if(local !== '전체'){
	        			location.href="<%=contextPath%>/play.local?currentPage=1&content=연극&local="+local;
	        		}else{
	        			location.href="<%=contextPath%>/play.co?currentPage=1";
	        		}
        		});
        	});
        </script>

        <div id="playList" align="center">
            
            
            <ul id="posterBody">
            	<%if(list.isEmpty()){ %>
                	<li>해당 지역에서 예매가능한 연극이 없습니다.</li>
                <%}else{ %>
	                <%for(Play p : list){ %>
		                <li>
		                    <span><img src="<%=contextPath %>/<%=p.getImgPath() %>/<%=p.getContentChangeImg() %>" height="200px" width="150px"></span>
		                    <div id=playTitle><b><a href="<%=contextPath%>/play.detail?contentNo=<%=p.getContentNo()%>"><%=p.getContentTitle() %></a></b></div>
		                    <div><%=p.getPlayStartDate() %>~<%=p.getPlayEndDate() %></div>
		                    <div><%=p.getContentKeyword() %></div>
		                </li>
	                <%} %>
                <%} %>
            </ul>
            
        </div>

        <div id="playPaging">
        	<%if(!list.isEmpty()){ %>
	        	<button onclick="location.href='<%=contextPath%>/play.local?currentPage=1&content=연극&local=<%=region%>';">&lt;&lt;</button>
	            <%if(currentPage != 1) { %>
	            <button onclick="location.href='<%=contextPath%>/play.local?currentPage=<%=pi.getCurrentPage()-1%>&content=연극&local=<%=region%>';">&lt;</button>
	            <%} %>
	            
	            <%for(int i = startPage; i <=endPage; i++){ %>
	            	<% if(currentPage != i) {%>
	            		<button onclick="location.href='<%=contextPath%>/play.local?currentPage=<%=i%>&content=연극&local=<%=region%>';"><%=i%></button>
	            	<%}else{ %>
	            		<button disabled style="color:black;"><%=i %></button>
	            	<%} %>
	            <%} %>
	            
	            <%if(currentPage != maxPage){ %>
	            	<button onclick="location.href='<%=contextPath%>/play.local?currentPage=<%=pi.getCurrentPage()+1%>&content=연극&local=<%=region%>';">&gt;</button>
	            <% } %>
	            <button onclick="location.href='<%=contextPath%>/play.local?currentPage=<%=pi.getMaxPage()%>&content=연극&local=<%=region%>';">&gt;&gt;</button>
	         <%} %>
        </div>

    </div>

</body>
</html>