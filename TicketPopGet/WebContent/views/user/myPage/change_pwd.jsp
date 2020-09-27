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
	
	<%
	 	String userPwd = loginUser.getUserPwd();
	%>

	<div align="center" style="width: 800px; height:500px; margin-left: 450px; margin-top: 100px;">
	
		<!-- <h1>내 정보확인</h1> -->
		<ul class="nav nav-tabs nav-justified" style="margin-top: 60px;">
			<li class="nav-item"><a class="nav-link" style="color: black;" href="<%=contextPath%>/info.my">정보수정</a></li>
			<li class="nav-item"><a class="nav-link active" style="color: coral;">비밀번호변경</a></li>
			<li class="nav-item"><a class="nav-link" style="color: black;" href="<%=contextPath%>/delete.my">회원탈퇴</a></li>
		</ul>
		
		<div style="margin-top: 80px;">
			<h3 style="margin-top: 30px;">비밀번호 변경</h3>
			<p style="color: red;">주기적인 변경으로 내 정보를 보호해주세요</p>
		</div>
		
			<div style="width: 500px; margin-top: 30px; border-top: 1px solid orange; border-bottom: 1px solid orange;">
				<form action="<%=contextPath%>/updatePwd.my" method="post">
					<input TYPE="hidden" name="userId" value="<%=loginUser.getUserId()%>">
						<table style="margin-top: 40px;">
							<tr>
								<td>현재 비밀번호</td>
								<td><input type="password" id="pwd" name="userPwd" placeholder="현재 비밀번호를 입력해주세요" style="width: 300px; margin-left: 10px;"></td>
							</tr>
							<tr>
								<td>새 비밀번호</td>
								<td><input type="password" id="newPwd" name="newPwd" style="width: 300px; margin-left: 10px;" placeholder="영문/숫자/특수문자 조합하여 6~12자리"></td>
							</tr>
							<tr>
								<td>새 비밀번호확인</td>
								<td><input type="password" id="newPwd2" name="newPwd_check" placeholder="비밀번호를 다시 입력해주세요" style="width: 300px; margin-left: 10px;"></td>
							</tr>
						</table>
	
					<br>
					
					<div style="margin-bottom: 30px;">
					<button type="submit" class="btn" onclick="return change_pwd();" style="border: 1px solid orange; background: orange; color: white;">변경</button>	
					&nbsp;&nbsp;
					<a href="<%=contextPath%>/mypage.my" class="btn" style="border: 1px solid orange;">이전으로</a>
					</div>
					</form>
			
			</div>
			
			<script>
				function change_pwd(){
					
					var pwd = document.getElementById("pwd").value;
					var userPwd = "<%=userPwd%>";
					
					if(pwd != userPwd){
						//alert("현재비밀번호가 일치하지않습니다.");
						//return false;
						document.getElementById('')
						
					}
					if ($("input[name=newPwd]").val() != $("input[name=newPwd_check]").val()) {
						alert("비밀번호가 일치하지않습니다.");
						return false;
					}
				}
				
			</script>
		</div>
</body>
</html>