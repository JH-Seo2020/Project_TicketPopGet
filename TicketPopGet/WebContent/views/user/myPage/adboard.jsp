<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.community.adBoard.model.vo.*, com.kh.user.model.vo.PageInfo" %>
<%
	ArrayList<AdBoard> ad = (ArrayList<AdBoard>)request.getAttribute("ad");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
	
	String content = (String)request.getAttribute("content");
	
%>

   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 홍보 글</title>
<style>
#promote {
	width: 1200px;
	height: 900px;
	margin: auto;
	box-sizing: border-box;
}
/* 헤더부분 */
.reservation_check1 {
	margin-top: 100px;
	font-size: 25px;
	width: 1000px;
	margin-left: 90px;
	border-bottom: 1px solid rosybrown;
}
/* 컨텐츠분류 */
.contents_btn {
	margin-top: 70px;
	margin-right: 150px;
}

/* 테이블 */
.reservation_check3 table {
	width: 950px;
	height: 350px;
	text-align: center;
	border-bottom: 1px solid silver;
}

.reservation_check3 table>tbody>tr:hover {
	background-color: white;
	color: sandybrown;
	cursor: pointer;
}

/* checkbox */
input[type=checkbox] {
	width: 20px;
	height: 20px;
}

/* 삭제여부버튼 */   
    #delete{
        background-color: sandybrown;
        border-radius: 0.5em;
        border:1px solid sandybrown;
        width: 80px;
        height: 30px;
        color: white;
    }
/* 페이징바 */
.pagination {
	margin: 10px 0 0;
	text-align: center
}

.pagination .btn-prev, .pagination .btn-next, .pagination a span {
	display: inline-block;
	margin-right: 2px;
	padding: 4px 12px;
	border: 1px solid #ddd;
	border-radius: 4px;
	color: #111;
	background: #fff;
	text-decoration: none;
	text-align: center;
}

.pagination .btn-prev:hover, .pagination .btn-next:hover, .pagination a span:hover,
	.pagination .btn-prev:active, .pagination .btn-next:active, .pagination a span:active,
	.pagination .btn-prev:focus, .pagination .btn-next:focus, .pagination a span:focus
	{
	color: #fff;
	background: #ff8149;
	border: 1px solid #ff8149
}

.pagination a .selected {
	color: #ff8149;
	border: 1px solid #ff8149
}

.pagination .no-more-prev, .pagination .no-more-next {
	display: none
}
</style>
</head>
<body>
	<!-- 메뉴바쓰추가쓰 -->
	<%@ include file="/views/common/menubar.jsp"%>
	<%
	 	int userNo = loginUser.getUserNo();
	%>

	<div id="promote">
		<!-- 헤더부분 -->
		<div class="reservation_check1">
			<h3 style="margin-bottom: 20px;">
				<b>나의 홍보글</b>
			</h3>
		</div>

		<!-- 컨텐츠분류 -->
		<div class="contents_btn" align="right">
			<a href="<%=contextPath%>/adboard.my?currentPage=1&userNo=<%=loginUser.getUserNo()%>" class="btn btn-outline-warning">전체</a>
			<a href="<%=contextPath%>/ad_content.my?currentPage=1&userNo=<%=loginUser.getUserNo()%>&content=콘서트" class="btn btn-outline-warning">콘서트</a>
			<a href="<%=contextPath%>/ad_content.my?currentPage=1&userNo=<%=loginUser.getUserNo()%>&content=연극" class="btn btn-outline-warning">연극</a>
			<a href="<%=contextPath%>/ad_content.my?currentPage=1&userNo=<%=loginUser.getUserNo()%>&content=전시" class="btn btn-outline-warning">전시</a>
		</div>

		<!-- 관람후기테이블 -->

		<div class="container reservation_check3"
			style="margin-left: 70px; margin-top: 50px;">
			<table class="table table-hover"
				style="width: 950px; height: 70px; margin-left: 30px; text-align: center;">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>분류</th>
						<th>작성일</th>
						<th></th>
					</tr>
				</thead>
				 <tbody>
              		<%
              			if(ad.isEmpty()){
              		%>
              		<tr>
              			<td colspan="5">조회되는 리스트가 없습니다.</td>
              		</tr>
              		<%
              			}else{ 
              		          for(AdBoard a : ad) {
              		%>
	                <tr>
	                  <td><%=a.getBoardNo() %></td>
	                  <td onclick="fnClickDetail();"><%=a.getBoardTitle() %></td>
	                  <td><%=a.getBoardType() %>
	                  <td><%=a.getBoardDate()%></td>
	                  <td><input type="button" id="delete" value="삭제하기" onclick="location.href='<%=contextPath%>/deleteadboard.my?ano=<%=a.getBoardNo()%>&userNo=<%=loginUser.getUserNo()%>'" name="delete_adboard"></td>
	                </tr>
	                <%} %>
	                <%} %>
              </tbody>
			</table>
		</div>
		
		<script>
		 //상세페이지 전환
	       function fnClickDetail() {
	        	
	    	   $(".table>tbody>tr").click(function(){
					var ano = $(this).children().eq(0).text(); 
					var userNo = "<%=userNo%>";
					
					location.href="<%=contextPath%>/adboard_detail.my?ano="+ano+"&"+"userNo="+userNo; 
				});
	       }
		</script>

		<!-- 페이징바 -->
		<%if(content == null){ %>
          <div class="pagination" align="center" style="margin-top: 60px; margin-left: 50%;">
     		<%if(currentPage != 1){ %>
            	<a href="<%=contextPath%>/review.my?currentPage=1" class=" btn-prev"><i class="fa fa-chevron-circle-left"></i></a>
            <%} %>
            
            <%for(int p=startPage; p<=endPage; p++){ %>
            	<%if(p!=currentPage){ %>
	           		<a href="<%=contextPath%>/review.my?currentPage=<%=p%>"><span><%=p %></span></a>
	            <%}else { %>
	            	<a href="javascript:void(0);"><span><%=p %></span></a>
	            <%} %>
            <%} %>
            
            <%if(currentPage != maxPage){ %>
            	<a href="<%=contextPath%>/review.my?currentPage=<%=maxPage%>" class=" btn-next"><i class="fa fa-chevron-circle-right"></i></a>
            <%} %>
        </div>
        <%} else{ %>
            <div class="pagination" align="center" style="margin-top: 60px; margin-left: 50%;">
     		<%if(currentPage != 1){ %>
            	<a href="<%=contextPath%>/review_content.my?currentPage=1" class=" btn-prev"><i class="fa fa-chevron-circle-left"></i></a>
            <%} %>
            
            <%for(int p=startPage; p<=endPage; p++){ %>
            	<%if(p!=currentPage){ %>
	           		<a href="<%=contextPath%>/review_content.my?currentPage=<%=p%>"><span><%=p %></span></a>
	            <%}else { %>
	            	<a href="javascript:void(0);"><span><%=p %></span></a>
	            <%} %>
            <%} %>
            
            <%if(currentPage != maxPage){ %>
            	<a href="<%=contextPath%>/review_content.my?currentPage=<%=maxPage%>" class=" btn-next"> <i class="fa fa-chevron-circle-right"></i></a>
            <%} %>
	        </div>
        <%} %>
    </div>
</body>
</html>