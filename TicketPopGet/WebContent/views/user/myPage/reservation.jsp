<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.user.model.vo.*" %>
<%
	ArrayList<Reservation> re = (ArrayList<Reservation>)request.getAttribute("re");
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
<title>예매내역조회/취소</title>
<style>
#reservation {
	width: 1200px;
	height: 1000px;
	margin: auto;
	box-sizing: border-box;
}

/* 예매내역확인 헤더부분*/
.reservation_check1 {
	margin-top: 60px;
}

.reservation_date ul li {
	list-style: none;
	float: left;
}

.reservation_date ul>li>button {
	background-color: white;
	border: 1px solid tomato;
}

.reservation_date ul>li>button:hover {
	background-color: tomato;
	border: 1px solid tomato;
	color: white;
}

/* 예매내역확인 몸통영역 */
.reservation_check2 {
	margin-top: 80px;
	margin-left: 150px;
}

.reservation_state ul li {
	list-style: none;
	float: left;
}

/* 예매내역확인 테이블 */
.reservation_check3 {
	margin-top: 140px;
	margin-left: 115px;
}

.reservation_check3 table {
	margin-left:140px;
	width: 900px;
	height: 350px;
	text-align: center;
}

.reservation_check3 table>tbody>tr:hover {
	color: rgb(149, 130, 255);
	background-color: white;
	cursor: pointer;
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

	<div id=reservation>
		<!-- 예매내역확인 헤더부분 -->
		<div class="reservation_check1">
			<div style="font-size: 25px; width: 1000px; margin-left: 110px; border-bottom: 1px solid rosybrown;">
				<h3 style="margin-bottom: 20px;">
					<b>예매내역확인</b>
				</h3>
			</div>
			<%-- 
			<div class="reservation_date">
				<ul style="margin-left: 110px;">
					<li>기간 별 조회
						<button>7일</button>
						<button>1개월</button>
						<button>3개월</button>
					</li>
					<li style="padding-left: 150px;">관람일자별 조회 <input type="date">
						~ <input type="date">
						<button>조회</button>
					</li>
				</ul>
			</div>
		</div>--%>

		<!-- 예매내역확인 몸통부분  -->
		<div class="reservation_check2">
			<div class="reservation_state">
				<ul>
					<li>
						<h5>예매내역</h5>
					</li>
					<li style="margin-left: 5px;">
						<select name="content" onchange="location.href=this.value">
								<option value="<%=contextPath%>/reservation.my?currentPage=1&userNo=<%=loginUser.getUserNo()%>">전체</option>
								<option value="<%=contextPath%>/reservationContent.my?currentPage=1&userNo=<%=loginUser.getUserNo()%>&content=콘서트">콘서트</option>
								<option value="<%=contextPath%>/reservationContent.my?currentPage=1&userNo=<%=loginUser.getUserNo()%>&content=연극">연극</option>
								<option value="<%=contextPath%>/reservationContent.my?currentPage=1&userNo=<%=loginUser.getUserNo()%>&content=전시">전시</option>
						</select>
					</li>
					<%-- 
					<li style="padding-left: 480px;">
						<h6>
							예매별 상태 조회 |
							<button style="margin-left: 5px; border: 1px solid rgb(93, 142, 193); color: white; background-color: rgb(93, 142, 193);">예매</button>
							<button style="margin-left: 5px; border: 1px solid rgb(240, 168, 76); color: white; background-color: rgb(240, 168, 76);">취소</button>
						</h6>
					</li>
					--%>
				</ul>
			</div>
		</div>

		<!-- 예매내역 테이블부분 -->
		<div class="container reservation_check3">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>예매번호</th>
						<th>예매일</th>
						<th>공연/전시명</th>
						<th>관람일</th>
						<th>매수</th>
						<th>결제방법</th>
						<th>결제여부</th>
						<th>예매상태</th>
					</tr>
				</thead>
				<tbody>
				    <%
              			if(re.isEmpty()){
              		%>
              		<tr>
              			<td  colspan="8">조회되는 리스트가 없습니다</td>
              		</tr>
              		<%
              			}else{ 
              		              		   for(Reservation r : re) {
              		%>
				<%-- if문? 암튼 줘서,,, 예매인지 그거 조건 다 줘서,, 취소면 취소페이지로만 가게해야됨!!!!!! onclick (if문) --%>
					<tr onClick="location.href='<%=contextPath%>/re_detail.my'">
						<td><%=r.getTicketNo() %></td>
						<td><%=r.getReservationDate() %></td>
						<td><%=r.getContnetTitle() %></td>
						<td><%=r.getViewDate()%></td>
						<td><%=r.getTicketNum()%>매</td>
						<td><%=r.getPaymentType() %></td>
						<td><%=r.getPaymentStatus() %></td>
						<td><%=r.getPaymentCancel() %></td>
					</tr>
					<%} %>
	                <%} %>
				</tbody>
			</table>
		</div>

		<!-- 페이징바 -->
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

		<!-- 예매내역 풋터부분 -->
		<div
			style="margin-top: 70px; margin-left: 150px; border: 1px solid rosybrown; width: 980px;">
			<p
				style="margin-top: 15px; padding-left: 20px; font-size: 25px; color: red;">
				<b>유의사항</b>
			</p>
			<ul style="padding-top: 5px;">
				<li>[상세보기]에서 예매상세보기와 예매취소가 가능합니다</li>
				<li>[상세보기]에서 예매상세보기와 예매취소가 가능합니다</li>
				<li>[상세보기]에서 예매상세보기와 예매취소가 가능합니다</li>
				<li>[상세보기]에서 예매상세보기와 예매취소가 가능합니다</li>
			</ul>
		</div>

	</div>
</div>
</body>
</html>