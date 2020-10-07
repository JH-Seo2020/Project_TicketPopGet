<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.user.model.vo.*" %>
<%
	ArrayList<Reservation> re = (ArrayList<Reservation>)request.getAttribute("re");
	ArrayList<WishList> wishlist = (ArrayList<WishList>)request.getAttribute("wishlist");
	ArrayList<MyPage> mps = (ArrayList<MyPage>)request.getAttribute("mps");
    String userId = (String)request.getAttribute("userId");  
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<style>
/* 공통사항 */
*:focus {
	outline: none;
}


#mypage {
	width: 1200px;
	height: 1500px;
	margin: auto;
	box-sizing: border-box;
}

.more_btn {
	background: orangered;
	border: 1px solid orangered;
	color: white;
	cursor: pointer;
}

/* 왼쪽 메뉴바 */
.mypage_left {
	float: left;
	width: 230px;
	height: 700px;
	margin-top:50px;
	margin-left: 50px;
}

/* 회원정보관리 */
#mypage_info {
	width: 100%;
	height: 200px;
	text-align: center;
	background-color: #ffb300;
	color: white;
}

#mypage_info h1 {
	padding-top: 35px;
	font-size: 35px;
}

#mypage_info p {
	font-size: 23px;
}

#mypage_info_a {
	font-size: 20px;
	text-decoration: none;
	color: white;
}

#mypage_info_a:hover {
	color: white;
}

/* 마이페이지 메뉴 */
#mypage_menu {
	border: 1px solid black;
	width: 100%;
	height: 430px;
	margin-top: 30px;
}

#mypage_menu ul {
	font-size: 20px;
	list-style-type: none;
	margin: 0px;
	padding: 0px;
}

.mypage_menu_a {
	display: block;
	text-decoration: none;
	color: black;
	font-weight: bold;
	padding: 28px;
	text-align: center;
}

.mypage_menu_a:hover {
	color: tomato;
}

/* 중앙 컨텐츠 */
.mypage_middle {
	width: 850px;
	height: 1500px;
	margin-left: 250px;
}
/* 최근예매내역 */
.mypage_reservation {
	height: 300px;
}

.mypage_reservation  p {
	float: left;
	margin-top: 55px;
	margin-left: 50px;
}

.mypage_reservation table {
	margin-left: 55px;
	text-align: center;
	width: 850px;
	border-collapse: collapse;
}

.mypage_reservation th {
	border-bottom: 1px solid black;
	height: 45px;
	font-size: 18px;
}

.mypage_reservation td {
	font-size: 15px;
}

/* 찜리스트 */
#mypage_wishlist {
	height: 450px;
}

/* 찜리스트목록 */
.wishlist_area {
	width: 850px;
	border:1px solid silver;
	border-radius: 1em;
	float: left;
	margin-left: 50px;
	height:350px;
}
/* 찜리스트목록 세부 항목 */
.wishlist {
	display: inline-block;
	position: relative;
	margin-top: 10px;
	margin-left: 10px;
}


/* 찜여부버튼 */
.wishlist_btn button {
	position: absolute;
	top: 3%;
	right: 0%;
	background-color: transparent !important;
	border: 0;
	outline: 0;
	cursor: pointer;
	background: rgba(0, 0, 0, 0);

}

/* 나의 관람공연/전시 */
#mypage_watchshow {
	height: 500px;
	margin-top: 20px;
}

.watchshow_area {
	border: 1px solid silver;
	border-radius: 1em;
	float: left;
	width: 850px;
	height: 350px;
	margin-left: 50px;
}

.watchshow_list {
	width: 850px;
	display: inline-block;
	position: relative;
	padding-top: 20px;
	margin-left: 20px;
}


</style>
</head>
<body>
	<!-- 메뉴바쓰추가쓰 -->
	<%@ include file="/views/common/menubar.jsp"%>
	
	
	<div id="mypage" align="center">
		<!-- 왼쪽 메뉴바 -->
		<div class="mypage_left">
			<!-- 회원정보관리 -->
			<div id="mypage_info">
				<h1>MYPAGE</h1>
				<p>
					<b><%=loginUser.getUserName()%></b>님 환영합니다
				</p>
				<a id="mypage_info_a" href="<%=contextPath%>/info.my">회원정보관리</a>
			</div>
			<!-- 마이페이지 메뉴 -->
			<div id="mypage_menu">
				<ul>
					<li><a class="mypage_menu_a" href="<%=contextPath%>/reservation.my?currentPage=1&userNo=<%=loginUser.getUserNo()%>">예매내역조회/취소</a></li>
					<li><a class="mypage_menu_a" href="<%=contextPath%>/wishlist.my?currentPage=1&userNo=<%=loginUser.getUserNo()%>">찜 리스트</a></li>
					<li><a class="mypage_menu_a" href="<%=contextPath%>/show.my?currentPage=1&userNo=<%=loginUser.getUserNo()%>">나의 관람공연</a></li>
					<li><a class="mypage_menu_a" href="<%=contextPath%>/review.my?currentPage=1&userNo=<%=loginUser.getUserNo()%>">나의 관람후기</a></li>
					<li><a class="mypage_menu_a" href="<%=contextPath%>/adboard.my?currentPage=1&userNo=<%=loginUser.getUserNo()%>">나의 홍보 글</a></li>
				</ul>
			</div>
		</div>
		<!-- 중앙 컨텐츠 -->
			<div class="mypage_middle">
				<!-- 최근예매내역 -->
				<div class="mypage_reservation">
					<p>
						<b style="font-size: 30px;">최근예매내역</b>
						<button onclick="location.href='<%=contextPath%>/reservation.my?currentPage=1&userNo=<%=loginUser.getUserNo()%>'" class="more_btn">더보기</button>
					</p>
					<table>
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
							<tr>
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
			
			<!-- 찜리스트 -->
			<div id="mypage_wishlist">
				<p style="float: left; margin-left: 50px;">
					<b style="font-size: 30px;">찜 리스트</b>
					<button onclick="location.href='<%=contextPath%>/wishlist.my?currentPage=1&userNo=<%=loginUser.getUserNo()%>'" class="more_btn">더보기</button>
				</p>
				<div class="wishlist_area" align="left">
				 	<%
               			 if(wishlist.isEmpty()){
           			 %>
        			<%
             		    }else{ 
                      		 for(WishList w : wishlist) {
             		 %>
					<div class="wishlist">
						<img src="<%=contextPath%>/<%=w.getContentImgPath()%>/<%=w.getContentChimg()%>" width="200" height="250"><br>
						<div class="wishlist_btn" >
							<button type="button" class="like_btn" onclick="changeImg();">
								<img src="<%=contextPath%>/resources/img/imgForSearch/like_heart.png" id="img1" width="30" height="30">
							</button>
						</div>
						<span ><%=w.getContentTitle()%> </span> <br>
                        <span style="color:red;"><%=w.getContentStatus()%></span> <br>
                        <span><%=w.getWishlistDate()%></span>
                         <script type="text/javascript">
				   		 function changeImg(){
                       		 var img1 = document.getElementById("img1");
                 
                          img1.src = "<%=contextPath%>/resources/img/imgForSearch/heart.png";
                          location.href="<%=contextPath%>/wishlistUpdate.my?wno="+<%=w.getWishNo()%>+"&"+"userNo="+<%=w.getUserNo()%>; 

                      	 }
		         	</script>
					</div>
					  <%} %>
       			  <%} %>
				</div>
			</div>
			<!-- 나의 관람공연/전시 -->
			<div id="mypage_watchshow">
				<p style="float: left; margin-left: 50px;">
					<b style="font-size: 30px;">나의 관람공연/전시</b>
					<button  onclick="location.href='<%=contextPath%>/show.my?currentPage=1&userNo=<%=loginUser.getUserNo()%>'" class="more_btn">더보기</button>
				</p>
				<div class="watchshow_area" align="left">
					<%
               			 if(mps.isEmpty()){
           			 %>
        			<%
             		    }else{ 
                      		 for(MyPage mp : mps) {
             		 %>
					<div class="watchshow_list">
						<img src="<%=contextPath%>/<%=mp.getContentImgPath()%>/<%=mp.getContentChimg()%>" width="200" height="250"> <br>
						<span><%=mp.getContentTitle() %></span> <br>
						<span><%=mp.getViewDate() %></span>
					</div>	
					  <%} %>
       			  <%} %>
				</div>
			</div>
		</div>
	</div>
</body>
</html>