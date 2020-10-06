<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.user.model.vo.*" %>
<%
	ArrayList<Search> search = (ArrayList<Search>)request.getAttribute("search");
	String keyword = (String)request.getAttribute("keyword");
		
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
        /* 공통사항 */
        #search_result1 input, #search_button1, #search_button2:focus{outline: none;}

        /* 큰 틀 */
        .detailed_search{ height: 1500px;}
        /* 통합검색 상세조회 */
     
        .search_result1 {
            margin-top: 100px;
            margin-left: 100px;
            font-size: 30px;
            border: 1px solid slategray;
            width: 1000px;
            height: 200px;
            background-color:slategray;
        }

        #search_result1 input{
            width: 300px;
            height: 25px;
            border: none;
            font-size: 18px;
            background-color: slategray;
            border-bottom: 1px solid black;
        }

        #search_button1{
            background: rgba(0,0,0,0);
            border:none;
            cursor: pointer;
            position:absolute;
        }

        /* 지역,분류,관람기간 상세조회 */
        .search_result2 {
            width: 1000px;
            height: 55px;
            margin-left: 100px;
            border: 1px solid black;
        }

        .search_result2 ul{
            display: block;
        }

        .search_result2 ul>li{
            list-style: none;
            float: left;
        }

        #search_button2{
            background-color: white;
            border:1px solid orange;
            cursor: pointer;
        }

        /* 검색결과 내용 */
        .search_result3{
            margin-left: 100px;
            margin-top: 60px;
            border-top: 1px solid black;
            border-width: medium;
            width: 1000px;
            height: 500px;
        }

        .search_result_list{
            width: 1000px;
            margin-top: 25px;
            padding-bottom: 25px;
            border-bottom:1px solid gray;
            float: left;
        }

        .search_result_list div{float: left;}

        #search_result_content{
            margin-left: 120px;
            font-size: 19px;
            margin-top:10px;
        }
        #search_result_content a{
            text-decoration: none;
            color: black;
        }

        #search_result_reservation{
            margin-left: 300px;
            margin-top: 60px;
            font-size: 20px;
            width: 110px;
            text-align: center;
            background: coral;
            color: cornsilk;
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
	
    <!-- 상세조회 검색 창 -->
 	  <div class="detailed_search" align="center">
            <!-- 검색결과입니다 -->
            
            <div class="search_result1">
            <form>
                <p style="height: 90px;">
                    <span style="color:red; font-weight: bold; line-height: 130px;"><%=keyword%></span>
                    	에 대한 검색 결과 입니다.
                </p>
                <div id="search_result1">
                    <input type="text" >
                    <button id="search_button1"><img src="resources/img/imgForSearch/search.png"  width="30px" height="30px"></button>
                </div>
              </form>
            </div>
			<%--
            <!-- 지역,분류,관람기간 상세조회 -->
            <div class="search_result2">
            <form>
            
                <!-- 지역 -->
                <ul>
                    <li>
                        <select style="margin-left: 40px; width: 150px; height: 30px;">
                            <option>지역</option>
                            <option>서울/경기권</option>
                            <option>강원/충천권</option>
                            <option>전라권</option>
                            <option>경상권/제주</option>
                        </select>
                    </li>
                </ul>
                <!-- 분류 -->
                <ul>
                    <li>
                        <select style="margin-left: 30px; width: 150px; height: 30px;">
                            <option>분류</option>
                            <option>콘서트</option>
                            <option>연극</option>
                            <option>전시</option>
                        </select>
                    </li>
                </ul>
                <!-- 관람기간 -->
                <ul>
                    <li style="margin-left: 30px; font-size: 17px;">
                        관람기간 <input type="date" style="width: 150px; height: 30px; margin-left: 5px;"> - <input type="date" style="width: 150px; height: 30px;">
                    </li>
                    <li>
                        <button type="submit" id="search_button2" style="width: 80px; height: 30px; margin-left: 20px;">조회하기</button>
                    </li>
                </ul>
                 </form>
            </div>
             --%>  
        <div class="search_result3">
        			<%
                       if(search.isEmpty()){
                    %>
                   
                       	조회되는 리스트가 없습니다.
                    
                    <%
                       }else{ 
                           for(Search s : search) {
                    %>
        
	            <!-- 목록하나 -->
	            <div class="search_result_list">
	                <!-- 이미지 -->
	                <div id="search_result_img" style="margin-left: 70px;">
	                    <a href=""><img src="<%=contextPath%>/<%=s.getContentImgpath()%>/<%=s.getContentChimg()%>" width="150" ></a>
	                </div>
	                <!-- 검색내용 -->
	                <div id="search_result_content">
	                    <h3><b><a href=""><%=s.getContentTitle()%></a></b></h3>
	                    <p>
				                        장 소 : <%=s.getPlace()%> <br>
				                        기 간 : <%=s.getRegion()%> <br>
				                        가 격 : <%=s.getPrice()%> <br>
	                    </p>
	                </div>
		                <%--
		                <!-- 예매상황 // 진행중 -->
		                <div id="search_result_reservation">
		                    <span><%=s.get %></span>
		                </div>
		                 --%>
	                 <%} %>
	               <%} %>
	                
	            </div>

         
        	</div> 

        <!-- 페이징바 -->
         <div class="pagination" align="center" style="margin-top: 60px; margin-left: 50%;">
	     		<%if(currentPage != 1){ %>
	     			<!-- 맨 처음으로(<<) -->
	     			<a href="<%=contextPath%>/reservation.my?currentPage=1&userNo=<%=loginUser.getUserNo()%>" class=" btn-prev"><i class="fa fa-chevron-circle-left"></i>Prev</a>
	            <%} %>
	            
	            <%for(int p=startPage; p<=endPage; p++){ %>
	            	<%if(p!=currentPage){ %>
		           		<a href="<%=contextPath%>/reservation.my?currentPage=<%=p%>&userNo=<%=loginUser.getUserNo()%>"><span><%=p %></span></a>
		            <%}else { %>
		            	<a href="javascript:void(0);"><span><%=p %></span></a>
		            <%} %>
	            <%} %>
	            
	            <%if(currentPage != maxPage){ %>
	            	<!-- 맨 끝으로(>>) -->
	            	<a href="<%=contextPath%>/reservation.my?currentPage=<%=maxPage%>&userNo=<%=loginUser.getUserNo()%>" class=" btn-next"><i class="fa fa-chevron-circle-right"></i>NEXT</a>
	            <%} %>
	        </div>
    </div>  
</body>
</html>