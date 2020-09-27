<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.community.adBoard.model.vo.AdBoard, com.kh.concert.model.vo.*" %>
<%
	ArrayList<AdBoard> list =(ArrayList<AdBoard>) request.getAttribute("list");
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
	#wrap_adlist{
	    width: 1200px;
	    height: 1000px;
	    margin: auto;
	    box-sizing: border-box;
	}
	/*이벤트결과발표*/
	#adBoardHead{
	    font-size: 45px;
	    margin-top: 10px;
	    margin-bottom: 30px;
	}
	/*분류 버튼*/
	#adBoardBtn{
	    margin-top: 10px;
	    margin-bottom: 20px;
	}
	/*paging 버튼*/
	#adBoardPaging{
	    text-align: center;
	    margin-top: 30px;
	}
	#adBoardPaging button{
	    margin-top: 20px;
	    width: 40px;
	    height: 40px;
	    border: none;
	    color: white;
	    background-color: #ffb300;
	    border-radius: 5px;
	}
	a{color:black !important; text-decoration:none !important;}
</style>
</head>
<body>
	<%@ include file="/views/common/menubar.jsp" %>

	<div id="wrap_adlist">
        <div id="adBoardHead">
            <b>홍보 게시판</b>
        </div>
        <div id="adBoardBtn">
            <a  class="btn btn-outline-warning btn-lg">콘서트</a>
            <a  class="btn btn-outline-warning btn-lg">연극</a>
            <a  class="btn btn-outline-warning btn-lg">전시</a>
        </div>
        <table id="adBoardList" class="table table-hover">
            <thead class="thead-dark" align="center">
              <tr>
                <th scope="col">번호</th>
                <th scope="col">분류</th>
                <th scope="col">지역</th>
                <th scope="col" width="50%">제목</th>
                <th scope="col" width=10%>날짜</th>
                <th scope="col">조회수</th>
              </tr>
            </thead>
            <tbody align="center">
            <%if(list.isEmpty()){ %>
            	<tr><td colspan=5>보여드릴 게시물이 없습니다.</td></tr>
            <%}else{ %>
            	<%for(AdBoard a : list){ %>
	              <tr>
	                <th scope="row"><%=a.getBoardNo() %></th>
	                <td><%=a.getBoardType() %></td>
	                <td><%=a.getBoardLocation() %></td>
	                <td><a href=""><%=a.getBoardTitle() %></a></td>
	                <td><%=a.getBoardDate() %></td>
	                <td><%=a.getBoardCount() %></td>
	              </tr>
	             <%} %>
              <%} %>
        </table>
        <div align="right">
        <%if (loginUser != null){ %>
          <a href="<%=contextPath %>/adboard.write" class="btn btn-warning btn-lg">글쓰기</a>
         <%}else{ %>
         	<a class="btn btn-warning btn-lg" onclick="message();">글쓰기</a>
         <%} %>
        </div>
        
        <script>
        	function message(){
        		alert('로그인 후 이용가능');
        	}
        </script>

        <div id="adBoardPaging">
            <button onclick="location.href='<%=contextPath%>/adboard.co?currentPage=1';">&lt;&lt;</button>
            <%if(currentPage != 1) { %>
            <button onclick="location.href='<%=contextPath%>/adboard.co?currentPage=<%=pi.getCurrentPage()-1%>';">&lt;</button>
            <%} %>
            
            <%for(int i = startPage; i <=endPage; i++){ %>
            	<% if(currentPage != i) {%>
            		<button onclick="location.href='<%=contextPath%>/adboard.co?currentPage=<%=i%>';"><%=i%></button>
            	<%}else{ %>
            		<button disabled style="color:black;"><%=i %></button>
            	<%} %>
            <%} %>
            
            <%if(currentPage != maxPage){ %>
            <button onclick="location.href='<%=contextPath%>/adboard.co?currentPage=<%=pi.getCurrentPage()+1%>';">&gt;</button>
            <% } %>
            <button onclick="location.href='<%=contextPath%>/eadboard.co?currentPage=<%=pi.getMaxPage()%>';">&gt;&gt;</button>
        </div>

    </div>
</body>
</html>