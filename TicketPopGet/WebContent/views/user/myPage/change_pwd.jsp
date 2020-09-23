<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호변경</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<!-- 메뉴바 -->
	<%@ include file="/views/common/menubar.jsp"%>
	<div align="center" style="width: 800px; height:500px; margin-left: 450px; margin-top: 100px;">
		<!-- <h1>내 정보확인</h1> -->
		<ul class="nav nav-tabs nav-justified" style="margin-top: 60px;">
			<li class="nav-item"><a class="nav-link" style="color: black;"
				href="information.jsp">정보수정</a></li>
			<li class="nav-item"><a class="nav-link active"
				style="color: coral;">비밀번호변경</a></li>
			<li class="nav-item"><a class="nav-link" style="color: black;"
				href="delete.jsp">회원탈퇴</a></li>
		</ul>
		<div style="margin-top: 80px;">
			<h3 style="margin-top: 30px;">비밀번호 변경</h3>
			<p style="color: red;">주기적인 변경으로 내 정보를 보호해주세요</p>
		</div>
		<div
			style="width: 500px; margin-top: 30px; border-top: 1px solid orange; border-bottom: 1px solid orange;">
			<table style="margin-top: 40px;">
				<tr>
					<td>현재 비밀번호</td>
					<td><input type="password"
						style="width: 300px; margin-left: 10px;"></td>
				</tr>
				<tr>
					<td>새 비밀번호</td>
					<td><input type="password"
						style="width: 300px; margin-left: 10px;"
						placeholder="영문/숫자/특수문자 조합하여 6~12자리"></td>
				</tr>
				<tr>
					<td>새 비밀번호확인</td>
					<td><input type="password"
						style="width: 300px; margin-left: 10px;"></td>
				</tr>

			</table>

			<br>
			<div style="margin-bottom: 30px;">
				<button type="button" class="btn" onclick="change_pwd();"
					style="border: 1px solid orange; background: orange; color: white;">변경</button>
				&nbsp;&nbsp;
				<button type="button" class="btn" style="border: 1px solid orange;">이전으로</button>
			</div>
		</div>
	</div>
</body>
</html>