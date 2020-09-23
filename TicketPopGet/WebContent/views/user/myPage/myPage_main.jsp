<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<style>

/* css 문제 -> a태그 안먹힘 ㅠㅠ 왜징 */

/* 공통사항 */
*:focus {
	outline: none;
}

.more_btn {
	background: orangered;
	border: 1px solid orangered;
	color: white;
	cursor: pointer;
}

/* 마이페이지 큰 틀 */
.mypage_main {
	margin-left: 180px;
	width: 1200px;
	height: 1800px;
}

/* 왼쪽 메뉴바 */
.mypage_left {
	float: left;
	width: 230px;
	height: 700px;
	margin-left: 50px;
	margin-top:50px;
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
	padding-top: 20px;
	font-size: 35px;
}

#mypage_info p {
	font-size: 23px;
}

#mypage_info a {
	font-size: 20px;
	text-decoration: none;
	color: white;
	margin-top:50px;
}

#mypage_info a:hover {
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

#mypage_menu ul li a {
	display: block;
	text-decoration: none;
	color: black;
	font-weight: bold;
	padding: 28px;
	text-align: center;
}

#mypage_menu ul li a:hover {
	color: tomato;
}

/* 중앙 컨텐츠 */
.mypage_middle {
	width: 850px;
	height: 1500px;
	margin-left: 220px;
}
/* 최근예매내역 */
#mypage_reservation {height: 330px;}

#mypage_reservation  p {
	float: left;
	margin-top: 40px;
	margin-left: 50px;
}

#mypage_reservation table {
	margin-left: 55px;
	text-align: center;
	border: 1px solid black;
	width: 850px;
	height: 200px;
	border-collapse: collapse;
}

#mypage_reservation th {
	border-bottom: 1px solid black;
	height: 45px;
	font-size: 18px;
}

#mypage_reservation td {
	font-size: 15px;
}

#mypage_reservation tbody>tr:hover {
	color: coral;
	cursor: pointer;
}

/* 찜리스트 */
#mypage_wishlist{
	height:410px;
}

/* 찜리스트목록 */
.wishlist_area {
	border: 1px solid silver;
	border-radius: 1em;
	float: left;
	width: 850px;
	margin-left: 50px;
}
/* 찜리스트목록 세부 항목 */
.wishlist {
	margin-left: 30px;
	display: inline-block;
	position: relative;
	padding-top: 20px;
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
	padding-top: 20px;
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
	margin-left: 50px;
}

.watchshow_list {
	margin-left: 30px;
	display: inline-block;
	position: relative;
	padding-top: 20px;
}

.watchshow_btn {
	margin-bottom: 20px;
	background-color: white;
	border: 1px solid tomato;
	cursor: pointer;
}

.watchshow_btn:hover {
	background-color: tomato;
	color: white;
}
</style>
</head>
<body>
	<!-- 메뉴바 -->
	<%@ include file="/views/common/menubar.jsp"%>
	
	<!-- 마이페이지 큰 틀 -->
	<div align="center" class="mypage_main">
		<!-- 왼쪽 메뉴바 -->
		<div class="mypage_left">
			<!-- 회원정보관리 -->
			<div id="mypage_info">
				<h1>MYPAGE</h1>
				<p>
					<b>xxx</b>님 환영합니다
				</p>
				<!-- contextPath/info.my 넣기  -->
				<a href="information.jsp">회원정보관리</a>
			</div>
			<!-- 마이페이지 메뉴 -->
			<div id="mypage_menu">
				<ul>
					<li><a href="">예매내역조회/취소</a></li>
					<li><a href="">찜 리스트</a></li>
					<li><a href="">나의 관람공연</a></li>
					<li><a href="">나의 관람후기</a></li>
					<li><a href="">나의 홍보 글</a></li>
				</ul>
			</div>
		</div>
		<!-- 중앙 컨텐츠 -->
		<div class="mypage_middle">
			<!-- 최근예매내역 -->
			<div id="mypage_reservation">
				<p>
					<b style="font-size: 30px;">최근예매내역</b> <span>xxx님의 최근 3개월간 예매하신내역입니다.</span>
					<button class="more_btn">더보기</button>
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
						<tr>
							<td>aaaaa</td>
							<td>2020-09-22</td>
							<td>행복</td>
							<td>2020-09-30</td>
							<td>1매</td>
							<td>카드결제</td>
							<td>결제완료</td>
							<td>예매</td>
						</tr>
						<tr>
							<td>aaaaa</td>
							<td>2020-09-22</td>
							<td>행복</td>
							<td>2020-09-30</td>
							<td>1매</td>
							<td>카드결제</td>
							<td>환불</td>
							<td>취소</td>
						</tr>
						<tr>
							<td>aaaaa</td>
							<td>2020-09-22</td>
							<td>행복</td>
							<td>2020-09-30</td>
							<td>1매</td>
							<td>무통장입금</td>
							<td>환불진행중</td>
							<td>취소</td>
						</tr>
					</tbody>
				</table>
			</div>
			<!-- 찜리스트 -->
			<div id="mypage_wishlist">
				<p style="float: left; margin-left: 50px;">
					<b style="font-size: 30px;">찜 리스트</b>
					<button class="more_btn">더보기</button>
				</p>
				<div class="wishlist_area">
					<div class="wishlist">
						<img src="/TicketPopGet/resources/post_upfiles/111111111128.PNG" width="200" height="250" align="center"><br>
						<div class="wishlist_btn">
							<button type="button" class="like_btn">
								<img src="/TicketPopGet/resources/img/imgForSearch/like_heart.png" width="30" height="30">
							</button>
						</div>
						<p>
							공연제목 <br> 예매상황
						</p>
					</div>
					<div class="wishlist">
						<img src="/TicketPopGet/resources/post_upfiles/111111111128.PNG" width="200" height="250"><br>
						<div class="wishlist_btn">
							<button type="button" class="like_btn">
								<img
									src="/TicketPopGet/resources/img/imgForSearch/like_heart.png"
									width="30" height="30">
							</button>
						</div>
						<p>
							공연제목 <br> 예매상황
						</p>
					</div>
					<div class="wishlist">
						<img src="/TicketPopGet/resources/post_upfiles/111111111128.PNG" width="200" height="250"><br>
						<div class="wishlist_btn">
							<button type="button" class="like_btn">
								<img src="/TicketPopGet/resources/img/imgForSearch/like_heart.png" width="30" height="30">
							</button>
						</div>
						<p>
							공연제목 <br> 예매상황
						</p>
					</div>
				</div>
			</div>
			<!-- 나의 관람공연/전시 -->
			<div id="mypage_watchshow">
				<p style="float: left; margin-left: 50px;">
					<b style="font-size: 30px;">나의 관람공연/전시</b>
					<button class="more_btn">더보기</button>
				</p>
				<div class="watchshow_area">
					<div class="watchshow_list">
						<img src="/TicketPopGet/resources/post_upfiles/111111111126.PNG" width="200" height="250"> <br>
						<p>공연제목</p>
						<button class="watchshow_btn">후기작성</button>
					</div>
					<div class="watchshow_list">
						<img src="/TicketPopGet/resources/post_upfiles/111111111126.PNG" width="200" height="250"> <br>
						<p>공연제목</p>
						<button class="watchshow_btn">후기작성</button>
					</div>
					<div class="watchshow_list">
						<img src="/TicketPopGet/resources/post_upfiles/111111111126.PNG" width="200" height="250"> <br>
						<p>공연제목</p>
						<button class="watchshow_btn">후기작성</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>