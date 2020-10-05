<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.user.model.vo.*" %>
<% 
	ArrayList<WishList> wishlist = (ArrayList<WishList>)request.getAttribute("wishlist");
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
<title>찜리스트</title>
   <style>
#wishlist{
          width: 1200px;
            height: 1500px;
            margin: auto;
            box-sizing: border-box;
}

    /* 헤더부분 */
    .reservation_check1{
        margin-top:100px;
        font-size: 25px; 
        width: 1000px;
        margin-left: 90px; 
        border-bottom: 1px solid rosybrown;
    }
    /* 컨텐츠분류 */
    .contents_btn{
        margin-top: 80px;
        margin-right: 150px;
    }
    /* 찜리스트목록 */
    .wishlist_area{
        margin-top: 70px;
        margin-left: 120px;
        width: 2000px;
    }
    /* 찜리스트목록 세부 항목 */
    .wishlist{
        display: inline-block;
        padding-left: 90px;
        position: relative;
    }
    /* 찜여부버튼 */
    .wishlist_btn button{
        position:absolute;
        top:3%;
        right:0%;
        background-color: transparent !important;
        border: 0;
        outline: 0;
        cursor: pointer;
        background: rgba(0,0,0,0);
    }
    
      /* 페이징바 */
        .pagination {margin:10px 0 0; text-align:center}
        .pagination .btn-prev, .pagination .btn-next, .pagination a span {display: inline-block; margin-right:2px; padding: 4px 12px; border:1px solid #ddd; border-radius: 4px; color: #111; background:#fff; text-decoration: none; text-align: center;}
        .pagination .btn-prev:hover, .pagination .btn-next:hover, .pagination a span:hover,
        .pagination .btn-prev:active, .pagination .btn-next:active, .pagination a span:active,
        .pagination .btn-prev:focus, .pagination .btn-next:focus, .pagination a span:focus {color:#fff; background:#ff8149; border:1px solid #ff8149}
        .pagination a .selected {color:#ff8149; border:1px solid #ff8149}
        .pagination .no-more-prev, .pagination .no-more-next {display:none}

</style>
</head>
<body>
<!-- 메뉴바쓰추가쓰 -->
<%@ include file="/views/common/menubar.jsp"%>

<div id="wishlist">
        <!-- 헤더부분 -->
        <div class="reservation_check1">
            <h3 style="margin-bottom: 20px;"><b>찜리스트</b></h3>
        </div>

        <!-- 컨텐츠분류 -->
        <div class="contents_btn" align="right">
            <a href="<%=contextPath%>/wishlist.my?currentPage=1&userNo=<%=loginUser.getUserNo()%>" class="btn btn-outline-warning">전체</a> 
            <a href="<%=contextPath%>/wishContent.my?currentPage=1&userNo=<%=loginUser.getUserNo()%>&content=콘서트" class="btn btn-outline-warning">콘서트</a>
            <a href="<%=contextPath%>/wishContent.my?currentPage=1&userNo=<%=loginUser.getUserNo()%>&content=연극" class="btn btn-outline-warning">연극</a>
            <a href="<%=contextPath%>/wishContent.my?currentPage=1&userNo=<%=loginUser.getUserNo()%>&content=전시" class="btn btn-outline-warning">전시</a>
        </div>

        <!-- 찜리스트 목록 -->
        <div class="wishlist_area">
            <%
                if(wishlist.isEmpty()){
            %>
        		
             <%
                 }else{ 
                         for(WishList w : wishlist) {
              %>
		            <div class="wishlist" align="center"> 
		                <img src="<%=contextPath%>/<%=w.getContentImgPath()%>/<%=w.getContentChimg()%>" width="200" height="250"><br>
		                <div class="wishlist_btn"><button type="button" class="like_btn"><img src="<%=contextPath%>/resources/img/imgForSearch/like_heart.png" width="30" height="30"></button></div>
		                <span><%=w.getContentTitle()%> </span> <br>
                        <span style="color:red;"><%=w.getContentStatus()%></span> <br>
                        <span><%=w.getWishlistDate()%></span>
		            </div>
              <%} %>
         <%} %>
		            
        </div>
        
     <!-- 페이징바 -->
          <div class="pagination" align="center" style="margin-top: 60px; margin-left: 50%;">
     		<%if(currentPage != 1){ %>
            	<a href="<%=contextPath%>/wishlist.my?currentPage=1" class=" btn-prev"><i class="fa fa-chevron-circle-left"></i>Prev</a>
            <%} %>
            
            <%for(int p=startPage; p<=endPage; p++){ %>
            	<%if(p!=currentPage){ %>
	           		<a href="<%=contextPath%>/wishlist.my?currentPage=<%=p%>"><span><%=p %></span></a>
	            <%}else { %>
	            	<a href="javascript:void(0);"><span><%=p %></span></a>
	            <%} %>
            <%} %>
            
            <%if(currentPage != maxPage){ %>
            	<a href="<%=contextPath%>/wishlist.my?currentPage=<%=maxPage%>" class=" btn-next">Next <i class="fa fa-chevron-circle-right"></i></a>
            <%} %>
        </div>
          
</div>
</body>
</html>