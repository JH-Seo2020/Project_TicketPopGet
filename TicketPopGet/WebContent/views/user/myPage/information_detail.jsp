<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보변경</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
*:focus {
	outline: none;
}

::placeholder {
	font-size: 12px;
}

body {
	margin: 0;
	font-size: .9rem;
	font-weight: 400;
	line-height: 1.6;
	color: #ffb300;
	text-align: left;
}

.navbar-brand, .nav-link, .my-form, .login-form {
	font-family: Raleway, sans-serif;
}

.my-form {
	padding-top: 1.5rem;
	padding-bottom: 1.5rem;
}

.my-form .row {
	margin-left: 0;
	margin-right: 0;
}

.login-form {
	padding-top: 1.5rem;
	padding-bottom: 1.5rem;
}

.login-form .row {
	margin-left: 0;
	margin-right: 0;
}

.btnRegister {
	border: none;
	border-radius: 1.5rem;
	padding: 2%;
	background: #ffb300;
	color: #fff;
	font-weight: 600;
	width: 30%;
	cursor: pointer;
}
</style>
</head>
<body>
	<!-- 메뉴바쓰추가쓰 -->
	<%@ include file="/views/common/menubar.jsp"%>
	
	<h2 align="center" style="margin-top:40px;">회원정보수정</h2>
	<div class="row justify-content-center" style="margin-top:20px;">
		<div class="col-md-8">
			<div class="card">
				<div class="card-body">
					<form id="enrollForm" action="" method="POST">
						<div class="form-group row">
							<label for="userId" class="col-md-4 col-form-label text-md-right">아이디</label>
							<input type="text" id="userId" readonly class="form-control" name="userId" value="<%=loginUser.getUserId()%>" style="width: 400px;">
						</div>

						<div class="form-group row">
							<label for="userName" class="col-md-4 col-form-label text-md-right">이름</label> 
							<input type="text" id="userName" name="userName" class="form-control" style="width: 400px;" value="<%=loginUser.getUserName()%>">
						</div>

						<!-- 생년월일 띄워야됨 -->
						<div class="form-group row">
							<label for="birth" class="col-md-4 col-form-label text-md-right">생년월일</label>
							<input type="text" name="year" class="form-control" style="width: 127px;" placeholder="년(4자)"> &nbsp;&nbsp;
							<select id="mm" style="width: 127px" class="form-control">
								<option>월</option>
								<option value="01">1</option>
								<option value="02">2</option>
								<option value="03">3</option>
								<option value="04">4</option>
								<option value="05">5</option>
								<option value="06">6</option>
								<option value="07">7</option>
								<option value="08">8</option>
								<option value="09">9</option>
								<option value="10">10</option>
								<option value="11">11</option>
								<option value="12">12</option>
							</select> &nbsp;&nbsp;
							<select id="dd" style="width: 127px" style="font-size:10px;" class="form-control">
								<option style="font-size: 8pt;">일</option>
								<option value="01">1</option>
								<option value="02">2</option>
								<option value="03">3</option>
								<option value="04">4</option>
								<option value="05">5</option>
								<option value="06">6</option>
								<option value="07">7</option>
								<option value="08">8</option>
								<option value="09">9</option>
								<option value="10">10</option>
								<option value="11">11</option>
								<option value="12">12</option>
							</select>
						</div>

						<!-- 성별도 띄워야됨 -->
						<div class="form-group row">
							<label for="permanent_address" class="col-md-4 col-form-label text-md-right">성별</label> 
							<select id="gender" class="form-control" style="width: 400px;">
								<option>성별</option>
								<option value="남">남</option>
								<option value="여">여</option>
							</select>
						</div>

						<div class="form-group row">
							<label for="phone" class="col-md-4 col-form-label text-md-right">전화번호</label>
							<select id="phone" style="width: 127px" class="form-control">
								<option>010</option>
								<option value="011">011</option>
								<option value="016">016</option>
								<option value="018">018</option>
								<option value="019">019</option>
							</select> &nbsp;&nbsp;
							<input type="text" name="phone" class="form-control" style="width: 127px;"> &nbsp;&nbsp;
							<input type="text" name="phone" class="form-control" style="width: 127px;">
						</div>

						<div class="form-group row">
							<label for="email" class="col-md-4 col-form-label text-md-right">이메일</label>
							<input type="text" id="email" class="form-control" style="width: 400px;" placeholder="이메일 입력">
						</div>

						<br>
						
						<div class="col-md-6 offset-md-4">
						
							<button type="submit" onclick="info_change()" class="btnRegister">회원정보수정</button>
							<button onclick="location.href='information.jsp'" class="btnRegister">이전으로</button>
						</div>
						
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>