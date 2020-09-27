<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.community.eventResult.model.vo.EventRaffle, com.kh.concert.model.vo.*" %>
<%
	ArrayList<EventRaffle> list =(ArrayList<EventRaffle>) request.getAttribute("list");
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
        #wrap_evRe{
            width: 1200px;
            height: 1000px;
            margin: auto;
            box-sizing: border-box;
        }
        /*이벤트결과발표*/
        #eventResultHead{
            font-size: 45px;
            margin-top: 10px;
            margin-bottom: 30px;
        }
        /*분류 버튼*/
        #eventResultBtn{
            margin-top: 10px;
            margin-bottom: 20px;
        }
        /*paging 버튼*/
        #eventResultPaging{
            text-align: center;
            margin-top: 30px;
        }
        #eventResultPaging button{
            margin-top: 20px;
            width: 40px;
            height: 40px;
            border: none;
            color: white;
            background-color: #ffb300;
            border-radius: 5px;
        }
        a{color:black !important;}
    </style>
</head>
<body>
	<%@ include file="/views/common/menubar.jsp" %>
	
	<div id="wrap_evRe">
        <div id="eventResultHead">
            <b>이벤트 결과 발표</b>
        </div>
        <div id="eventResultBtn">
            <a href="<%=contextPath %>/eventresult.genre?genre=콘서트&currentPage=1" type="button" class="btn btn-outline-warning btn-lg">콘서트</a>
            <a href="<%=contextPath %>/eventresult.genre?genre=연극&currentPage=1" type="button" class="btn btn-outline-warning btn-lg">연극</a>
            <a href="<%=contextPath %>/eventresult.genre?genre=전시&currentPage=1" type="button" class="btn btn-outline-warning btn-lg">전시</a>
        </div>
        <table id="eventResultList" class="table table-hover">
            <thead class="thead-dark" align="center">
              <tr>
                <th scope="col">번호</th>
                <th scope="col">분류</th>
                <th scope="col" width="60%">제목</th>
                <th scope="col" width=15%>날짜</th>
                <th scope="col">조회수</th>
              </tr>
            </thead>
            <tbody align="center">
            <%if(list.isEmpty()){ %>
            	<tr><td colspan=5>보여드릴 게시물이 없습니다.</td></tr>
            <%}else{ %>
            	<%for(EventRaffle r : list){ %>
	              <tr>
	                <th scope="row"><%=r.getRaffleNo() %></th>
	                <td><%=r.getEventType() %></td>
	                <td> <a href="<%=contextPath%>/eventresult.detail?raffleNo=<%=r.getRaffleNo()%>"><%=r.getRaffleTitle() %></a></td>
	                <td><%=r.getRaffleDate() %></td>
	                <td><%=r.getRaffleCount() %></td>
	              </tr>
              	<%} %>
              <%} %>
            </tbody>
        </table>

        <div id="eventResultPaging">
            <button onclick="location.href='<%=contextPath%>/event.result?currentPage=1';">&lt;&lt;</button>
            <%if(currentPage != 1) { %>
            <button onclick="location.href='<%=contextPath%>/event.result?currentPage=<%=pi.getCurrentPage()-1%>';">&lt;</button>
            <%} %>
            
            <%for(int i = startPage; i <=endPage; i++){ %>
            	<% if(currentPage != i) {%>
            		<button onclick="location.href='<%=contextPath%>/event.result?currentPage=<%=i%>';"><%=i%></button>
            	<%}else{ %>
            		<button disabled style="color:black;"><%=i %></button>
            	<%} %>
            <%} %>
            
            <%if(currentPage != maxPage){ %>
            <button onclick="location.href='<%=contextPath%>/event.result?currentPage=<%=pi.getCurrentPage()+1%>';">&gt;</button>
            <% } %>
            <button onclick="location.href='<%=contextPath%>/event.result?currentPage=<%=pi.getMaxPage()%>';">&gt;&gt;</button>
        </div>

    </div>

</body>
</html>