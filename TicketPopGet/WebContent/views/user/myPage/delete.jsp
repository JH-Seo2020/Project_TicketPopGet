<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
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
	<!-- 메뉴바쓰추가쓰 -->
	<%@ include file="/views/common/menubar.jsp"%>
	
	<%
	 	String userPwd = loginUser.getUserPwd();
	%>
	
	<div align="center" style="width: 800px; height:500px; margin-left: 450px; margin-top: 100px;">
	<form action="<%=contextPath%>/delete_de.my" method="post">
		<!-- <h1>내 정보확인</h1> -->
		<ul class="nav nav-tabs nav-justified" style="margin-top: 60px;">
		
			<li class="nav-item"><a class="nav-link" style="color: black;" href="<%=contextPath%>/info.my">정보수정</a></li>
			<li class="nav-item"><a class="nav-link" style="color: black;" href="<%=contextPath%>/change_pwd.my">비밀번호변경</a></li>
			<li class="nav-item"><a class="nav-link active" style="color: coral;">회원탈퇴</a></li> 
		</ul>
		<div style="margin-top: 80px;">
			<h3 style="margin-top: 30px;">비밀번호 재입력</h3>
			<p style="color: red;">정보보호를 위해 비밀번호를 한번 더 입력해주세요.</p>
		</div>
		<div style="width: 500px; margin-top: 30px; border-top: 1px solid orange; border-bottom: 1px solid orange;">
			<table style="margin-top: 40px;">
				<tr>
					<td>아이디</td>
					<td><input type="text" readonly name="userId" value="<%=loginUser.getUserId()%>" style="width: 300px; margin-left: 10px;"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" id="pwd" name="pwd"  placeholder="비밀번호를 입력해주세요" required style="width: 300px; margin-left: 10px;"></td>
				</tr>
			</table>

			<br>
			
			<div style="margin-bottom: 30px;">
					
				<button onclick="pwd_check();" id="pwd_check" class="btn" style="border: 1px solid orange; background: orange; color: white;">확인</button>
				&nbsp;&nbsp;
				<a href="<%=contextPath%>/mypage.my" class="btn" style="border: 1px solid orange;">이전으로</a>
				
			<script>
			function pwd_check(){
				
				var pwd = document.getElementById("pwd").value;
				var userPwd = "<%=userPwd%>";
				
				if(pwd!=userPwd){
					alert("비밀번호를 다시 입력해주세요");
				}
			}
			</script>

		
			</div>
		</div>
		</form>
	</div>

</body>
</html>