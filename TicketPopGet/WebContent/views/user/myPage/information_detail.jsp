<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>
<%
		Member  m = (Member)request.getAttribute("m");
%>
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
	
	<%  
		java.util.Date birthdate = new java.util.Date();
	
		String userId = loginUser.getUserId();
		String userName = loginUser.getUserName();
		birthdate = loginUser.getBirthdate();
		String gender = loginUser.getGender();
		String phone = loginUser.getPhone();
		String email = (loginUser.getEmail() == null) ? "" : loginUser.getEmail();
	%>
	
	<h2 align="center" style="margin-top:40px;">회원정보수정</h2>
	<div class="row justify-content-center" style="margin-top:20px;">
		<div class="col-md-8">
			<div class="card">
				<div class="card-body">
					<form id="enrollForm" action="<%=contextPath%>/update.my" method="POST">
						<div class="form-group row">
							<label for="userId" class="col-md-4 col-form-label text-md-right">아이디</label>
							<input type="text" id="userId" readonly class="form-control" name="userId" value="<%=userId%>" style="width: 400px;">
						</div>

						<div class="form-group row">
							<label for="userName" class="col-md-4 col-form-label text-md-right">이름</label> 
							<input type="text" id="userName" name="userName" class="form-control" required style="width: 400px;" value="<%=userName%>">
						</div>

						<!-- 생년월일 띄워야됨 -->
						<div class="form-group row">                                    
                                <label for="birth" class="col-md-4 col-form-label text-md-right">생년월일</label>
                                	<input type="date" id="birthdate" name="birthdate" class="form-control" value="<%=birthdate %>" style="width: 400px;" placeholder="생년월일 8자리 입력" required>               
                         </div>

						<!-- 성별도 띄워야됨 -->
						<div class="form-group row">
							<label for="permanent_address" class="col-md-4 col-form-label text-md-right">성별</label> 
							<select id="gender" name="gender" class="form-control" required  style="width: 400px;">
								<option >선택</option>
								<option value="M">남</option>
								<option value="F">여</option>
							</select>
						</div>

					    <div class="form-group row">                                    
                               <label for="phone" class="col-md-4 col-form-label text-md-right">전화번호</label>
                               	<input type="text" id="phone" name="phone" required class="form-control" value="<%=phone%>" style="width: 400px;" placeholder="(-)제외한 전화번호 입력" required>
                        </div>

						<div class="form-group row">
							<label for="email" class="col-md-4 col-form-label text-md-right">이메일</label>
							<input type="text" id="email" name="email" class="form-control" value="<%=email%>" style="width: 400px;" placeholder="이메일 입력">
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