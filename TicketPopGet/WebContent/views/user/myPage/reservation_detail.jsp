<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예매내역상세조회</title>
<style>
#reservation_detail {
	width: 1200px;
	height: 1300px;
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

/* 표 공통속성 */
.reservation_table {
	border: 1px solid black;
	border-collapse: collapse;
	width: 900px;
	text-align: center;
	margin: auto;
	margin-top: 20px;
}

.reservation_table tr {
	border-bottom: 1px solid black;
}

.reservation_table th {
	border-right: 1px solid black;
	background: salmon;
}

#reservation_table_list1 {
	height: 250px;
}

#reservation_table_list2 {
	height: 100px;
}

#reservation_table_list3 {
	height: 70px;
}

#reservation_table_list1 th {
	width: 150px;
}

#reservation_table_list3 td {
	border-right: 1px solid black;
}
</style>
</head>
<body>
	<!-- 메뉴바쓰추가쓰 -->
	<%@ include file="/views/common/menubar.jsp"%>
	<div id="reservation_detail">
		<!-- 헤더부분 -->
		<div class="reservation_check1">
			<h3 style="margin-bottom: 20px;">
				<b>예매상세내역</b>
			</h3>
		</div>

		<!-- 예매확인 -->
		<h2 style="margin-left: 150px; margin-top: 80px;">예매확인</h2>
		<table class="reservation_table" id="reservation_table_list1">
			<tr>
				<th>예매번호</th>
				<td>aaaaaa</td>
			</tr>
			<tr>
				<th>티켓명</th>
				<td>외갈매기</td>
			</tr>
			<tr>
				<th>관람일시</th>
				<td>2020-09-01(화) 18시30분 1회</td>
			</tr>
			<tr>
				<th>공연장</th>
				<td>소극장 산울림</td>
			</tr>
			<tr>
				<th>예매자</th>
				<td>땡땡땡</td>
			</tr>
			<tr>
				<th>취소가능일시</th>
				<td>2020-08-29(토) 23시59분까지</td>
			</tr>
		</table>

		<!-- 결제정보 -->
		<h2 style="margin-left: 150px; margin-top: 50px;">결제정보</h2>
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

		<!-- 티켓예매내역 -->
		<h2 style="margin-left: 150px; margin-top: 50px;">티켓예매내역</h2>
		<table class="reservation_table" id="reservation_table_list3">
			<tr>
				<th>예매번호</th>
				<th>티켓매수</th>
				<th>티켓가격</th>
				<th>취소여부</th>
			</tr>
			<tr>
				<td>aaaaaa</td>
				<td>2매</td>
				<td>20,000원</td>
				<td>취소가능</td>
			</tr>
		</table>

		<!-- 유의사항 -->
		<div
			style="margin-top: 100px; margin-left: 90px; border: 1px solid rosybrown; width: 980px;">
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

		<div align="center" style="margin-top: 50px;">
			<button class="btn btn-outline-warning">예매목록내역</button>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button class="btn btn-outline-warning">예매취소</button>
		</div>
	</div>

</body>
</html>