<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.user.model.vo.*" %>
<%
	ArrayList<MyPage> mps = (ArrayList<MyPage>)request.getAttribute("mps");
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
<title>나의 관람 공연</title>
<style>
        #show{
            width: 1200px;
            height: 1200px;
            /* border: 2px solid gray; */
            margin: auto;
            box-sizing: border-box;
        }

        /* 헤더부분*/
        .reservation_check1{
            margin-top:90px;
        }
      
        .reservation_date ul li{
            list-style: none;
            float: left;          
        }
        
        .reservation_date ul>li>button{
            background-color: white;
            border:1px solid tomato;
        }
        .reservation_date ul>li>button:hover{
            background-color: tomato;
            border:1px solid tomato;
            color: white;
        }

        /* 몸통영역 */
        .contents_btn {
			margin-top: 150px;
			margin-right: 150px;
		}
    

        /* 테이블 */
        .reservation_check3{
            margin-left: 115px;
        }
        .reservation_check3 table{
            width: 950px;
            height: 350px;
            text-align: center;
          
        }
        .reservation_check3 table>tbody>tr:hover{
            background-color: white;
        }

        .reservation_check3 button{
            background-color: white;
            border: 1px solid  orangered;
            border-radius: 0.5em;
        }

        .reservation_check3 button:hover{
            background-color:orangered;
            color: white;
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
<div id="show">

	<!-- 메뉴바쓰추가쓰 -->
	<%@ include file="/views/common/menubar.jsp"%>
		
        <!--  헤더부분 -->
        <div class="reservation_check1">
            <div style="font-size: 25px; width: 1000px; margin-left: 90px; border-bottom: 1px solid rosybrown;">
                <h3 style="margin-bottom: 20px;"><b>나의 관람 공연</b></h3>
            </div>
            <div class="reservation_date">
                <ul style="margin-left: 110px;">
                    <li> 기간 별 조회
                        <button >7일</button>
                        <button>1개월</button>
                        <button>3개월</button>
                    </li>
                    <li style="padding-left: 150px;"> 관람일자별 조회
                        <input type="date"> ~ <input type="date">
                        <button>조회</button>
                    </li>
                </ul>
            </div>
        </div>

        <!-- 몸통부분  -->
        <div class="reservation_check2">
            <div class="reservation_state">
               <!-- 컨텐츠분류 -->
				<div class="contents_btn" align="right">
					<a href="<%=contextPath%>/show.my?currentPage=1&userId=<%=loginUser.getUserId()%>" class="btn btn-outline-warning">전체</a>
					<a href="<%=contextPath%>/show_content.my?currentPage=1&userId=<%=loginUser.getUserId()%>&content=콘서트" class="btn btn-outline-warning">콘서트</a>
					<a href="<%=contextPath%>/show_content.my?currentPage=1&userId=<%=loginUser.getUserId()%>&content=연극" class="btn btn-outline-warning">연극</a>
					<a href="<%=contextPath%>/show_content.my?currentPage=1&userId=<%=loginUser.getUserId()%>&content=전시" class="btn btn-outline-warning">전시</a>
				</div>
            </div>
        </div>

        <!--  테이블부분 -->
        <div class="container reservation_check3" style="margin-left: 100px; margin-top:70px;">          
            <table class="table table-hover" style="width: 950px; height: 70px; margin-left: 30px; text-align: center;">
              <thead>
                <tr>
                  <th>번호</th>
                  <th>분류</th>
                  <th>관람일</th>
                  <th>공연/전시명</th>
                  <th>후기</th>
                </tr>
              </thead>
              
              <tbody>
              		<%
              			if(mps.isEmpty()){
              		%>
              		<tr>
              			<td  colspan="4">조회되는 리스트가 없슴니당</td>
              		</tr>
              		<%
              			}else{ 
              		              		   for(MyPage ps : mps) {
              		%>
	                <tr>
	                  <td><%=ps.getTicketNo() %></td>
	                  <td><%=ps.getContentType() %></td>
	                  <td><%=ps.getViewDate() %></td>
	                  <td><%=ps.getContentTitle() %></td>
	                  <td><button onclick="location.href='<%=contextPath%>/view_write.my'">후기작성</button>
	                </tr>
	                <%} %>
	                <%} %>
              </tbody>
            </table>
          </div>

		<br> <br>
		
     <div class="pagination" align="center" style="margin-top: 60px; margin-left: 50%;">
     		<%if(currentPage != 1){ %>
            	<a href="<%=contextPath%>/show.my?currentPage=1" class=" btn-prev"><i class="fa fa-chevron-circle-left"></i>Prev</a>
            <%} %>
            
            <%for(int p=startPage; p<=endPage; p++){ %>
            	<%if(p!=currentPage){ %>
	           		<a href="<%=contextPath%>/show.my?currentPage=<%=p%>"><span><%=p %></span></a>
	            <%}else { %>
	            	<a href="javascript:void(0);"><span><%=p %></span></a>
	            <%} %>
            <%} %>
            
            <%if(currentPage != maxPage){ %>
            	<a href="<%=contextPath%>/show.my?currentPage=<%=maxPage%>" class=" btn-next">Next <i class="fa fa-chevron-circle-right"></i></a>
            <%} %>
        </div>
    </div>

</body>
</html>