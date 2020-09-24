<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.concert.model.vo.*" %>
<%	
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Concert> list = (ArrayList<Concert>)request.getAttribute("list");
	
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
        #wrap_concert{
            width: 1200px;
            height: 2000px;
            margin: auto;
            box-sizing: border-box;
        }
        
        /*세부 조회 메인 - 콘서트 지역 설정하는 부분*/
        #concertLocal{
            height: 10%; 
            width: 100%;
            text-align: center;
            margin-top: 5px;
            padding-top: 50px;
            font-size: 30px;    
        }
        #concertLocal>select{height: 40%; width: 15%; font-size: 25px;}
        #concertLocal>select>option { font-size: 15px;}

        /* 콘서트 포스터 보여지는 부분(12개, 페이징버튼)*/
        #concertList{
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
        #concertTitle{
            font-size: 20px;
        }

        /*paging 버튼*/
        #concertPaging{
            text-align: center;
            margin-top: 30px;
        }
        #concertPaging button{
            width: 40px;
            height: 40px;
            border: none;
            color: white;
            background-color: #ffb300;
            border-radius: 5px;
        }
        /*a태그 밑줄없애기*/
        a{text-decoration: none !important; color:black !important;}
    </style>
</head>
<body>
	<%@ include file="/views/common/menubar.jsp" %>
	
	<div id="wrap_concert">

        <div id="concertLocal">
            <label>콘서트 &lt; </label>
            <select>
                <option>전체</option>
                <option>서울경기권</option>
                <option>강원충청권</option>
                <option>전라권</option>
                <option>경상제주권</option>
            </select>
        </div>

        <div id="concertList" align="center">
            
            
            <ul id="posterBody">
            <% if(list.isEmpty()){ %>
            	<li>보여질 포스터가 없습니다..(그럴리가없는데..)</li>
            <%}else{ %>
            	<%for(Concert c : list){ %>
	                <li>
	                    <span><img src="<%=contextPath %>/<%=c.getImgPath()%>/<%=c.getContentChangeImg() %>" height="200px" width="150px"></span>
	                    <div id=concertTitle><b><a href="<%=contextPath%>/concert.detail?concertNo=<%=c.getContentNo()%>"><%=c.getContentTitle() %></a></b></div>
	                    <div><%=c.getConcertDate() %></div>
	                    <div><%=c.getContentKeyword() %></div>
	                </li>
                <%} %>
            <%} %>
            </ul>
            
        </div>

        <div id="concertPaging">
            <button onclick="location.href='<%=contextPath%>/concert.co?currentPage=1';">&lt;&lt;</button>
            <%if(currentPage != 1) { %>
            <button onclick="location.href='<%=contextPath%>/concert.co?currentPage=<%=pi.getCurrentPage()-1%>';">&lt;</button>
            <%} %>
            
            <%for(int i = startPage; i <=endPage; i++){ %>
            	<% if(currentPage != i) {%>
            		<button onclick="location.href='<%=contextPath%>/concert.co?currentPage=<%=i%>';"><%=i%></button>
            	<%}else{ %>
            		<button disabled style="color:black;"><%=i %></button>
            	<%} %>
            <%} %>
            
            <%if(currentPage != maxPage){ %>
            <button onclick="location.href='<%=contextPath%>/concert.co?currentPage=<%=pi.getCurrentPage()+1%>';">&gt;</button>
            <% } %>
            <button onclick="location.href='<%=contextPath%>/concert.co?currentPage=<%=pi.getMaxPage()%>';">&gt;&gt;</button>
        </div>

    </div>

</body>
</html>