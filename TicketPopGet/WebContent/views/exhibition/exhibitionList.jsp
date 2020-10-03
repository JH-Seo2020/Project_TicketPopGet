<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.concert.model.vo.PageInfo, com.kh.exhibition.model.vo.Exhibition" %>
<% 
	ArrayList<Exhibition> list = (ArrayList<Exhibition>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	
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
        #wrap_ex{
            width: 1200px;
            height: 2000px;
            margin: auto;
            box-sizing: border-box;
        }
        
        /*세부 조회 메인 - 전시 지역 설정하는 부분*/
        #exhibitionLocal{
            height: 10%; 
            width: 100%;
            text-align: center;
            margin-top: 5px;
            padding-top: 50px;
            font-size: 30px;   
            background: #f6f6f6;   
        }
        #exhibitionLocal>select{height: 40%; width: 15%; font-size: 25px;}
        #exhibitionLocal>select>option { font-size: 15px;}

        /* 전시 포스터 보여지는 부분(12개, 페이징버튼)*/
        #exhibitionList{
            margin-top: 20px;
            height: 70%;
            width: 100%;
            background : #f6f6f6;
        }
        #posterBody{width: 100%;height: 80%;padding-top: 20px;}
        #posterBody>li{
            list-style-type: none;
            display:inline-block;
            width: 30%;
            height: 30%;
        }
        #exhibitionTitle{
            font-size: 20px;
        }

        /*paging 버튼*/
        #exhibitionPaging{
            text-align: center;
            margin-top: 30px;
        }
        #exhibitionPaging button{
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

	<div id="wrap_ex">

        <div id="exhibitionLocal">
            <label>전시 &lt; </label>
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
        		$("#local").on('change',function(){
        			var local = $("#local").val();
	        		if(local !== '전체'){
	        			location.href="<%=contextPath%>/exhibition.local?currentPage=1&content=전시&local="+local;
	        		}else{
	        			location.href="<%=contextPath%>/exhibition.co?currentPage=1";
	        		}
        		});
        	});
        </script>

        <div id="exhibitionList" align="center">
            
            
            <ul id="posterBody">
                <%if(list.isEmpty()){ %>
                	<li>조회된 컨텐츠가 없습니다.(그럴리가..?)</li>
                <%}else{ %>
	                <%for(Exhibition e : list){ %>
		                <li>
		                    <span><img src="<%=contextPath %>/<%=e.getImgPath() %>/<%=e.getContentChangeImg() %>" height="200px" width="150px"></span>
		                    <div id=exhibitionTitle><b><a href="<%=contextPath%>/exhibition.detail?contentNo=<%=e.getContentNo()%>"><%=e.getContentTitle() %></a></b></div>
		                    <div><%=e.getExhibitionStartDate() %>~<%=e.getExhibitionEndDate() %></div>
		                    <div><%=e.getContentKeyword() %></div>
		                </li>
	                <%} %>
                <%} %>
            </ul>
            
        </div>

        <div id="exhibitionPaging">
            <button onclick="location.href='<%=contextPath%>/exhibition.co?currentPage=1';">&lt;&lt;</button>
            <%if(currentPage != 1) { %>
            <button onclick="location.href='<%=contextPath%>/exhibition.co?currentPage=<%=pi.getCurrentPage()-1%>';">&lt;</button>
            <%} %>
            
            <%for(int i = startPage; i <=endPage; i++){ %>
            	<% if(currentPage != i) {%>
            		<button onclick="location.href='<%=contextPath%>/exhibition.co?currentPage=<%=i%>';"><%=i%></button>
            	<%}else{ %>
            		<button disabled style="color:black;"><%=i %></button>
            	<%} %>
            <%} %>
            
            <%if(currentPage != maxPage){ %>
            	<button onclick="location.href='<%=contextPath%>/exhibition.co?currentPage=<%=pi.getCurrentPage()+1%>';">&gt;</button>
            <% } %>
            <button onclick="location.href='<%=contextPath%>/exhibition.co?currentPage=<%=pi.getMaxPage()%>';">&gt;&gt;</button>
        </div>

    </div>

</body>
</html>