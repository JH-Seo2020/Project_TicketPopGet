<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.serviceCenter.model.vo.*" %>
<%
	ArrayList<Faq> list = (ArrayList<Faq>)request.getAttribute("list");
	String searchType = (String)request.getAttribute("type");
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
</head>
<style>
    .noticetitle{
        margin:auto;
        margin-left: 40px;
    }
    #topMenu {
            height: 50px;
            width: 1100px;
    }

    .servicemenu {
            list-style: none;
            background-color: white;
            float: left;
            line-height: 50px;
            /* vertical-align: middle; */
            text-align: center;
    }
    #line{
        color: #ffb300;
    }
    #topMenu .menuLink {
            text-decoration:none;
            color: #ffb300;
            display: block;
            width: 250px;
            font-size: 20px;
            font-weight: bold;
            font-family: "Trebuchet MS";
    }
    #topMenu .menuLink:hover {
            color: white;
            background-color: #ffb300;
    }
    #noticeTable{
        width: 1000px;
        margin:auto;
        margin-left: 40px;
    }
    .faqTitle{cursor:pointer; color: black;}
    .area{float: left;}
    #noticeDiv{margin-left:5%}

    .pagination {margin:50px 30% 0; text-align:center;}
    .pagination .btn-prev, .pagination .btn-next, .pagination a span {display: inline-block; margin-right:2px; padding: 4px 12px; border:1px solid #ddd; border-radius: 4px; color: #111; background:#fff; text-decoration: none; text-align: center;}
    .pagination .btn-prev:hover, .pagination .btn-next:hover, .pagination a span:hover,
    .pagination .btn-prev:active, .pagination .btn-next:active, .pagination a span:active,
    .pagination .btn-prev:focus, .pagination .btn-next:focus, .pagination a span:focus {color:#fff; background:#ff8149; border:1px solid #ff8149}
    .pagination a .selected {color:#ff8149; border:1px solid #ff8149}
    .pagination .no-more-prev, .pagination .no-more-next {display:none}

    .content td {display: none;}
</style>
<body>
<!-- 상단 메뉴바  -->
<%@ include file="/views/common/menubar.jsp"%>
	<div class="area">
    <!-- 왼쪽메뉴바 -->
    <%@ include file="/views/serviceCenter/serviceMenubar.jsp"%>
    </div>
    <div class="area">
        <div>
            <h2 class="noticetitle"><b>FAQ</b></h2>
            <nav id="topMenu">
                <ul class="servicemenu">
                    <li class="servicemenu"><a class="menuLink" href="<%= request.getContextPath() %>/search.fo?currentPage=1&type=회원">회원</a></li>
                    <li class="servicemenu"><a class="menuLink" href="<%= request.getContextPath() %>/search.fo?currentPage=1&type=결제">결제</a></li>
                    <li class="servicemenu"><a class="menuLink" href="<%= request.getContextPath() %>/search.fo?currentPage=1&type=예매/취소">예매/취소</a></li>
                    <li class="servicemenu"><a class="menuLink" href="<%= request.getContextPath() %>/search.fo?currentPage=1&type=기타">기타</a></li>
                </ul>
            </nav>
        </div>

        <div id="noticeTable">
            <table class="table table-striped" id="listArea">
                <thead>
                    <tr>
                        <th style="width: 15%;">분류</th>
                        <th>제목</th>
                    </tr>
                </thead>
                <tbody>
                	<% if(list.isEmpty()){ %>
                	<tr>
                        <td colspan="2">조회된 리스트가 없습니다.</td>
                    </tr>
                    <% }else { %>
                    	<% for(Faq f : list) { %>
                    <tr>
                        <td><%=f.getFaqType() %></td>
                        <td><a class="faqTitle" id="title<%=f.getFaqNo() %>" onclick="showContent(<%=f.getFaqNo() %>)"><%=f.getFaqTitle() %></a></td>
                    </tr>
                    <tr class="content<%=f.getFaqNo() %>" id="content<%=f.getFaqNo() %>" style="display: none;">
                        <td></td>
                        <td><%=f.getFaqContent() %></td>
                    </tr>
                    <% } %>
                 <%  } %>
                    
                </tbody>
            </table>
            <script>
                function showContent(no){
					var contentClass = ".content"+no;
					var shown = $(contentClass).is(':visible');
					if (!shown) {
						$(contentClass).slideDown();
					}else{
						$(contentClass).hide();
					}
                }
            </script>
            <div class="pagination">
		           <% if(searchType==null) { %> <!-- 전체리스트 조회 -->
		              <% if(currentPage != 1) { %>
		              
		              <!-- 이전페이지로 -->
		                <a href="<%=contextPath%>/list.fo?currentPage=<%=currentPage-1%>&type=<%=searchType%>" class=" btn-prev"><i class="fa fa-chevron-circle-left"></i> Prev</a>
		              <% } %>
		                     
		                     <% for(int p=startPage; p<=endPage; p++){ %>
		                        <%if(p != currentPage) {%>
		                        <a href="<%=contextPath%>/list.fo?currentPage=<%=p%>&type=<%=searchType%>"><span><%= p %></span></a>
		                     <% }else{ %>
		                     <a disalbed><span><%= p %></span></a>
		                     <% } %>
		                  <% } %>
		                  
		            <% if(currentPage != maxPage) {%>   
		               <!-- 다음페이지로 -->   
		                <a href="<%=contextPath%>/list.fo?currentPage=<%=currentPage+1%>&type=<%=searchType%>" class=" btn-next">Next <i class="fa fa-chevron-circle-right"></i></a>
		             <% } %>
		         <% } else { %> <!-- 타입별 조회 -->
		            <% if(currentPage != 1) { %>
		              
		              <!-- 이전페이지로 -->
		                <a href="<%=contextPath%>/search.fo?currentPage=<%=currentPage-1%>&type=<%=searchType%>" class=" btn-prev"><i class="fa fa-chevron-circle-left"></i> Prev</a>
		              <% } %>
		                     
		                     <% for(int p=startPage; p<=endPage; p++){ %>
		                        <%if(p != currentPage) {%>
		                        <a href="<%=contextPath%>/search.fo?currentPage=<%=p%>&type=<%=searchType%>"><span><%= p %></span></a>
		                     <% }else{ %>
		                     <a disalbed><span><%= p %></span></a>
		                     <% } %>
		                  <% } %>
		                  
		            <% if(currentPage != maxPage) {%>   
		               <!-- 다음페이지로 -->   
		                <a href="<%=contextPath%>/search.fo?currentPage=<%=currentPage+1%>&type=<%=searchType%>" class=" btn-next">Next <i class="fa fa-chevron-circle-right"></i></a>
		             <% } %>
		         <% } %>

            </div>
        </div>
    </div>
</body>
</html>