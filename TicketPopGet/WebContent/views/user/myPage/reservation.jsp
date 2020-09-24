<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	margin-top: 110px;
	margin-left: 150px;
}

.reservation_state ul li {
	list-style: none;
	float: left;
}

/* 예매내역확인 테이블 */
.reservation_check3 {
	margin-top: 160px;
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

	<div id=reservation>
		<!-- 예매내역확인 헤더부분 -->
		<div class="reservation_check1">
			<div style="font-size: 25px; width: 1000px; margin-left: 110px; border-bottom: 1px solid rosybrown;">
				<h3 style="margin-bottom: 20px;">
					<b>예매내역확인</b>
				</h3>
			</div>
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
		</div>

		<!-- 예매내역확인 몸통부분  -->
		<div class="reservation_check2">
			<div class="reservation_state">
				<ul>
					<li>
						<h5>예매내역</h5>
					</li>
					<li style="margin-left: 5px;"><select>
							<option>전체</option>
							<option>콘서트</option>
							<option>연극</option>
							<option>전시</option>
					</select></li>
					<li style="padding-left: 480px;">
						<h6>
							예매별 상태 조회 |
							<button style="margin-left: 5px; border: 1px solid rgb(93, 142, 193); color: white; background-color: rgb(93, 142, 193);">예매</button>
							<button style="margin-left: 5px; border: 1px solid rgb(240, 168, 76); color: white; background-color: rgb(240, 168, 76);">취소</button>
						</h6>
					</li>
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
				<%-- if문? 암튼 줘서,,, 예매인지 그거 조건 다 줘서,, 취소면 취소페이지로만 가게해야됨!!!!!! --%>
					<tr onClick="location.href='<%=contextPath%>/re_detail.my'">
						<td>a123456</td>
						<td>2020-09-15</td>
						<td>백예린 소극장 콘서트</td>
						<td>2020-09-30</td>
						<td>2매</td>
						<td>카드결제</td>
						<td>결제완료</td>
						<td>예매</td>
					</tr>
					<tr>
						<td>a123456</td>
						<td>2020-09-15</td>
						<td>백예린 소극장 콘서트</td>
						<td>2020-09-30</td>
						<td>2매</td>
						<td>카드결제</td>
						<td>결제완료</td>
						<td>예매</td>
					</tr>
					<tr>
						<td>a123456</td>
						<td>2020-09-15</td>
						<td>백예린 소극장 콘서트</td>
						<td>2020-09-30</td>
						<td>2매</td>
						<td>무통장입금</td>
						<td>결제진행중</td>
						<td>예매</td>
					</tr>
					<tr>
						<td>a123456</td>
						<td>2020-09-15</td>
						<td>백예린 소극장 콘서트</td>
						<td>2020-09-30</td>
						<td>2매</td>
						<td>카드결제</td>
						<td>환불</td>
						<td>취소</td>
					</tr>
					<tr>
						<td>a123456</td>
						<td>2020-09-15</td>
						<td>백예린 소극장 콘서트</td>
						<td>2020-09-30</td>
						<td>2매</td>
						<td>무통장입금</td>
						<td>환불진행중</td>
						<td>취소</td>
					</tr>
					<tr>
						<td>a123456</td>
						<td>2020-09-15</td>
						<td>백예린 소극장 콘서트</td>
						<td>2020-09-30</td>
						<td>2매</td>
						<td>무통장입금</td>
						<td>환불</td>
						<td>취소</td>
					</tr>
				</tbody>
			</table>
		</div>

		<!-- 페이징바 -->
		<div class="pagination" style="margin-top: 60px; margin-left: 30%;">
			<a href="" class=" btn-prev"><i class="fa fa-chevron-circle-left"></i>
				Prev</a> <a href=""><span>1</span></a> <a href=""><span>2</span></a> <a
				href=""><span>3</span></a> <a href=""><span>4</span></a> <a href=""><span>5</span></a>
			<a href=""><span>6</span></a> <a href=""><span>7</span></a> <a
				href=""><span>8</span></a> <a href=""><span>9</span></a> <a href=""><span>10</span></a>
			<a href="" class=" btn-next">Next <i
				class="fa fa-chevron-circle-right"></i></a>
		</div>

		<!-- 예매내역 풋터부분 -->
		<div
			style="margin-top: 90px; margin-left: 150px; border: 1px solid rosybrown; width: 980px;">
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
</body>
</html>