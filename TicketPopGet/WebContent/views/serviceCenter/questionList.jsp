<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.serviceCenter.model.vo.*" %>
<%
	ArrayList<Question> list = (ArrayList<Question>)request.getAttribute("list");
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
            width: 1000px;
    }

    .servicemenu {
            list-style: none;
            background-color: white;
            float: left;
            line-height: 50px;
            text-align: center;
    }
    #line{
        color: #ffb300;
    }
    #topMenu .menuLink {
            text-decoration:none;
            color: #ffb300;
            display: block;
            width: 400px;
            font-size: 20px;
            font-weight: bold;
            font-family: "Trebuchet MS";
    }
    #topMenu .menuLink:hover {
            color: white;
            background-color: #ffb300;
    }
    #noticeTable{
        width: 900px;
        margin:auto;
        margin-left: 10px;

    }
    .area{float: left;}
    #noticeDiv{margin-left:2%}

    #listArea>tbody>tr:hover{
            background:rgba(128, 128, 128, 0.596);
            cursor:pointer;
        }
    #leftmenu{ margin-left:11%;}
    #contentArea{margin-left:4%;}

    .pagination {margin:50px 250px 0; text-align:center;}
    .pagination .btn-prev, .pagination .btn-next, .pagination a span {display: inline-block; margin-right:2px; padding: 4px 12px; border:1px solid #ddd; border-radius: 4px; color: #111; background:#fff; text-decoration: none; text-align: center;}
    .pagination .btn-prev:hover, .pagination .btn-next:hover, .pagination a span:hover,
    .pagination .btn-prev:active, .pagination .btn-next:active, .pagination a span:active,
    .pagination .btn-prev:focus, .pagination .btn-next:focus, .pagination a span:focus {color:#fff; background:#ff8149; border:1px solid #ff8149}
    .pagination a .selected {color:#ff8149; border:1px solid #ff8149}
    .pagination .no-more-prev, .pagination .no-more-next {display:none}
</style>
<body>
<!-- 상단 메뉴바  -->
<%@ include file="/views/common/menubar.jsp"%>
	<div class="area"  id="leftmenu">
    <!-- 왼쪽메뉴바 -->
    <%@ include file="/views/serviceCenter/serviceMenubar.jsp"%>
    </div>
    <form action="<%=request.getContextPath()%>/list.qo" method="GET">
	    <div class="area"  id="contentArea">
		    <div>
		        <h2 class="noticetitle"><b>1 : 1문의</b></h2>
		        <nav id="topMenu">
		            <ul class="servicemenu">
		                <li class="servicemenu"><a class="menuLink" href="<%= request.getContextPath() %>/list.qo?currentPage=1&userNo=<%=loginUser.getUserNo()%>">문의내역</a></li>
		                <li class="servicemenu"><a class="menuLink" href="<%= request.getContextPath() %>/enrollForm.qo">문의하기</a></li>
		            </ul>
		        </nav>
		    </div>
		
		    <div id="noticeTable">
		        <table class="table table-striped" id="listArea">
		            <thead>
		                <tr>
		                    <th style="width: 12%;">처리현황</th>
		                    <th>질문</th>
		                    <th style="width: 12%;">문의유형</th>
		                    <th style="width: 16%;">작성일</th>
		                </tr>
		            </thead>
		            <tbody>
		            	<% if(list.isEmpty()){ %>
		            	<tr>
	                        <td colspan="4">조회된 리스트가 없습니다.</td>
	                    </tr>
		            	<% }else { %>
		            		<% for(Question q : list) { %>
		                <tr>
		                    <td><%=q.getAnswerStatus() %></td>
		                    <td><%=q.getQuestionTitle() %></td>
		                    <td><%=q.getQuestionType() %></td>
		                    <td><%=q.getQuestionDate() %></td>
		                </tr>
		                <% } %>
	                 <%  } %>
		            </tbody>
		        </table>
		        
		        <script>
		        	$(function(){
		        		$("#listArea>tbody>tr").click(function(){

		        			var qno = $(this).children().eq(0).text();
		        			
		        			location.href = "<%=contextPath%>/detail.qo?qno=" + qno;
		        		});
		        	});
		        </script>
		        <div class="pagination" align="center">
		        <% if(currentPage != 1) { %>
		        	<!-- 이전페이지로 -->
		        	<a href="<%=contextPath%>/list.qo?currentPage=<%=currentPage-1%>&userNo=<%=loginUser.getUserNo()%>" class=" btn-prev"><i class="fa fa-chevron-circle-left"></i> Prev</a>
		        <% } %>
		        		<% for(int p=startPage; p<=endPage; p++){ %>
				            <%if(p != currentPage) {%>    
		            		<a href="<%=contextPath%>/list.no?currentPage=<%=p%>&userNo=<%=loginUser.getUserNo()%>"><span><%= p %></span></a>
		            		<% }else{ %>
		            		<a  href="javascript:void(0);"><span><%= p %></span></a>
							<% } %>
						<% } %>
	
				<% if(currentPage != maxPage) {%>	
					<!-- 다음페이지로 -->	
		            <a href="<%=contextPath%>/list.qo?currentPage=<%=currentPage+1%>&userNo=<%=loginUser.getUserNo()%>" class=" btn-next">Next <i class="fa fa-chevron-circle-right"></i></a>
		        <% } %>
		        </div>
		    </div>
		</div>
	</form>
</body>
</html>