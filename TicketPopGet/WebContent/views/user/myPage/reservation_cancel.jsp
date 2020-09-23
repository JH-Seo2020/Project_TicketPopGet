<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예매취소내역</title>
<style>
#reservation_cancel {
	width: 1200px;
	height: 800px;
	/* border: 2px solid gray; */
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

/* 이미지, 예매확인 */
.reservation_check2 {
	margin-top: 50px;
	margin-left: 150px;
}

.reservation_check2 div {
	float: left;
}

/* 연극, 연극장소 */
#rc2_2 {
	width: 200px;
	height: 250px;
	margin-left: 20px;;
	text-align: left;
	margin-top:20px;
}
/* 연극[xxxx] */
#rc2_2 p:first-child {
	font-size: 35px;
}
/* 장소 */
#rc2_2 p:last-child {
	font-size: 20px;
	margin-top: 100px;
}

/* 예매확인 */
#rc2_3 {
	width: 400px;
	height: 250px;
	margin-left: 100px;
}

#rc2_3 table {
	width: 400px;
	height: 200px;
	border: 1px solid black;
	border-collapse: collapse;
	text-align: center;
	font-size: 15px;
}

#rc2_3 tr {
	border-bottom: 1px solid black;
}

#rc2_3 th {
	border-right: 1px solid black;
}

/* 결제정보 */
.reservation_check3 {
	margin-top: 350px;
}

.reservation_table {
	border: 1px solid black;
	border-collapse: collapse;
	width: 950px;
	height: 150px;
	text-align: center;
	margin: auto;
	float: left;
	margin-left: 150px;
}

.reservation_table tr {
	border-bottom: 1px solid black;
}

.reservation_table th {
	border-right: 1px solid black;
}

/* 버튼 */
#cancel_btn {
	width: 70px;
	height: 35px;
	background-color: orangered;
	border: 1px solid orangered;
	color: white;
	font-weight: bold;
	border-width: 2px;
	font-size: 16px;
	cursor: pointer;
}
</style>
</head>
<body>

	<!-- 메뉴바쓰추가쓰 -->
	<%@ include file="/views/common/menubar.jsp"%>
	<div id="reservation_cancel">

		<!-- 헤더부분 -->
		<div class="reservation_check1">
			<h3 style="margin-bottom: 20px;">
				<b>예매취소내역</b>
			</h3>
		</div>

		<!-- 이미지, 예매확인 -->
		<div class="reservation_check2" align="center">

			<div id="rc2_1">
				<img src="/TicketPopGet/resources/post_upfiles/111111111133.PNG" width="200px">
			</div>

			<div id="rc2_2">
				<p>연극</p>
				<p>
					연극[xxxxxxxxx] <br> 장소
				</p>
			</div>

			<div id="rc2_3">
				<h2 style="text-align: left; color: tomato;">예매확인</h2>
				<table>
					<tr>
						<th>예매번호</th>
						<td>aaaaaaa</td>
					</tr>
					<tr>
						<th>티켓명</th>
						<td>티켓명입니다</td>
					</tr>
					<tr>
						<th>관람일시</th>
						<td>관람일시입니다</td>
					</tr>
					<tr>
						<th>공연장</th>
						<td>공연장이당</td>
					</tr>
					<tr>
						<th>예매자</th>
						<td>누구누구</td>
					</tr>
				</table>
			</div>
		</div>

		<!-- 결제정보 -->
		<div class="reservation_check3">
			<h2 style="margin-left: 150px; margin-top: 50px; color: tomato;">결제정보</h2>
			<table class="reservation_table" id="reservation_table_list2">
				<tr>
					<th>예매일</th>
					<td>2020-08-27(목)</td>
				</tr>
				<tr>
					<th>결제수단</th>
					<td>무통장입금</td>
				</tr>
				<tr>
					<th>결제수단</th>
					<td>결제완료/결제미완료/결제진행중</td>
				</tr>
			</table>
		</div>

		<div style="margin-top: 220px;" align="center">
			<button id="cancel_btn">확인</button>
		</div>

	</div>

</body>
</html>