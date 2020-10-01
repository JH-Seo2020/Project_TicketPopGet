<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.community.review.model.vo.Review, com.kh.concert.model.vo.*" %>
<%
	ArrayList<Review> list =(ArrayList<Review>) request.getAttribute("list");
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
        #wrap_review{
            width: 1200px;
            height: 1000px;
            margin: auto;
            box-sizing: border-box;
        }
        /*후기*/
        #reviewHead{
            font-size: 45px;
            margin-top: 10px;
            margin-bottom: 30px;
        }
        /*분류 버튼*/
        #reviewBtn{
            margin-top: 10px;
            margin-bottom: 20px;
        }
        /*paging 버튼*/
        #reviewPaging{
            text-align: center;
            margin-top: 30px;
        }
        #reviewPaging button{
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
	
	<div id="wrap_review">
        <div id="reviewHead">
            <b>후기</b>
        </div>
        <div id="reviewBtn">
            <a  class="btn btn-outline-warning btn-lg">콘서트</a>
            <a  class="btn btn-outline-warning btn-lg">연극</a>
            <a  class="btn btn-outline-warning btn-lg">전시</a>
        </div>
        <table id="reviewList" class="table table-hover">
            <thead class="thead-dark" align="center">
              <tr>
                <th scope="col">번호</th>
                <th scope="col">분류</th>
                <th scope="col" width="50%">제목</th>
                <th scope="col">별점</th>
                <th scope="col" width=10%>날짜</th>
                <th scope="col">조회수</th>
              </tr>
            </thead>
            <tbody align="center">
            <%if(list.isEmpty()){ %>
            	<tr><td colspan=6>보여드릴 게시물이 없습니다.</td></tr>
            <%}else{ %>
            	<%for(Review r : list){ %>
	              <tr>
	                <th scope="row"><%=r.getReviewNo() %></th>
	                <td><%=r.getContentType() %></td>
	                <td><a href=""><%=r.getReviewTitle() %></a></td>
	                <td><%=r.getReviewPoint() %></td>
	                <td><%=r.getReviewDate() %></td>
	                <td><%=r.getReviewCount() %></td>
	              </tr>
	             <%} %>
              <%} %>
            </tbody>
        </table>

        <div id="reviewPaging">
            <button onclick="location.href='<%=contextPath%>/review.co?currentPage=1';">&lt;&lt;</button>
            <%if(currentPage != 1) { %>
            <button onclick="location.href='<%=contextPath%>/review.co?currentPage=<%=pi.getCurrentPage()-1%>';">&lt;</button>
            <%} %>
            
            <%for(int i = startPage; i <=endPage; i++){ %>
            	<% if(currentPage != i) {%>
            		<button onclick="location.href='<%=contextPath%>/review.co?currentPage=<%=i%>';"><%=i%></button>
            	<%}else{ %>
            		<button disabled style="color:black;"><%=i %></button>
            	<%} %>
            <%} %>
            
            <%if(currentPage != maxPage){ %>
            <button onclick="location.href='<%=contextPath%>/review.co?currentPage=<%=pi.getCurrentPage()+1%>';">&gt;</button>
            <% } %>
            <button onclick="location.href='<%=contextPath%>/review.co?currentPage=<%=pi.getMaxPage()%>';">&gt;&gt;</button>
        </div>

    </div>

</body>
</html>