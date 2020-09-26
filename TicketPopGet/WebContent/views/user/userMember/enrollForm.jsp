<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
    ::placeholder{
        font-size: 12px;
    }
	body{
	    margin: 0;
	    font-size: .9rem;
	    font-weight: 400;
	    line-height: 1.6;
	    color: #ffb300;
	    text-align: left;
	}
    .navbar-brand , .nav-link, .my-form, .login-form{
        font-family: Raleway, sans-serif;
    }
    .my-form{
        padding-top: 1.5rem;
        padding-bottom: 1.5rem;
    }
    .my-form .row{
        margin-left: 0;
        margin-right: 0;
    }
    .login-form{
        padding-top: 1.5rem;
        padding-bottom: 1.5rem;
    }
    .login-form .row{
        margin-left: 0;
        margin-right: 0;
    }
    .btnRegister{
    border: none;
    border-radius: 1.5rem;
    padding: 2%;
    background: #ffb300;
    color: #fff;
    font-weight: 600;
    width: 30%;
    cursor: pointer;
    }
    .checkId{
        border: none;
    border-radius: 0.5rem;
    background: #ffb300;
    color: #fff;
    font-weight: 400;
    cursor: pointer;
    }

</style>
<body>
<!-- 메뉴바  -->
<%@ include file="/views/common/menubar.jsp"%>
<h2 align="center">회원가입</h2>
    <div class="row justify-content-center">
        <div class="col-md-8">
                <div class="card">
                    <div class="card-body">
                        <form id="enrollForm" action="<%=request.getContextPath() %>" method="POST">
                            <div class="form-group row">
                                <label for="userId" class="col-md-4 col-form-label text-md-right">아이디</label>
                                    <input type="text" id="userId" class="form-control" name="userId" style="width: 300px;" placeholder="띄어쓰기 없이 영문/숫자조합 6~12자리" required>
                                    &nbsp;&nbsp;<button type="button"class="checkId" onclick="idCheck();">중복확인</button>
                            </div>

                            <div class="form-group row">
                                <label for="password" class="col-md-4 col-form-label text-md-right">비밀번호</label>
                                    <input type="password" id="userPwd1" class="form-control" name="userPwd1" style="width: 400px;" placeholder="영문/숫자/특수문자 조합하여 6~12자리" required>
                            </div>

                            <div class="form-group row">
                                <label for="password" class="col-md-4 col-form-label text-md-right">비밀번호 확인</label>
                                    <input type="password" id="userPawd2" class="form-control" name="userPawd2" style="width: 400px;" placeholder="비밀번호 재입력" required>
                            </div>

                            <div class="form-group row">
                                <label for="userName" class="col-md-4 col-form-label text-md-right">이름</label>
                                    <input type="text" id="userName" name="userName" class="form-control" style="width: 400px;" placeholder="이름" required>
                            </div>

                            <div class="form-group row">                                    
                                <label for="birth" class="col-md-4 col-form-label text-md-right">생년월일</label>
                                	<input type="text" id="birth" name="birth" class="form-control" style="width: 400px;" maxlength="8" placeholder="생년월일 8자리 입력" required>
                                        
                            </div>

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
                                	<input type="text" id="phone" name="phone" class="form-control" style="width: 400px;" placeholder="(-)제외한 전화번호 입력" required>
                                    
                            </div>

                            <div class="form-group row">
                                <label for="email" class="col-md-4 col-form-label text-md-right">이메일</label>
                                    <input type="text" id="email" class="form-control" style="width: 400px;" placeholder="이메일 입력">
                            </div>

                            <br>
                            <div class="col-md-6 offset-md-4">
                                <button type="submit" class="btnRegister" id="joinBtn" onclick="return validate();">회원가입</button>
                                <button type="reset" class="btnRegister">가입취소</button>
                            </div>
                        </form>
                    </div>
                </div>
           </div>
    </div>
    <script>
    	// id 중복체크
    	function idCheck(){
    	
	    	var $userId = $("#enrollForm input[name=userId]");
	    	
	    	$.ajax({
				url:"<%=contextPath%>/idCheck.me",
				data:{checkId:$userId.val()},
				type:"get",
				success:function(result){
					
					console.log(result);
					
					if(result == "fail"){ 
						
						alert("사용할 수 없는 아이디입니다.");
						
						$userId.select(); // 재입력가능하도록 입력했던 text 드레그
					
					}else{
						
						if(confirm("사용가능한 아이디입니다. 사용하시겠습니까?")){
							
							$userId.focus(); // 확인 클릭 시 작동
							
						}else {
							$userId.select(); // 취소 시 재입력가능토록 text드레그
						}
					}
				}, 
				error:function(){
					console.log("ajax 통신 실패");
				}
			});

    	}
    	
    	// 아이디/패스워드 유효성 검사
    	function validate(){
    		
    		var userId = document.getElementById("userId");
            var userPwd1 = document.getElementById("userPwd1");
            var userPwd2 = document.getElementById("userPwd2");
            
            // 아이디 영문/숫자조합 6~12자리
            var regExp = /^[a-z][a-z\d]{5,11}$/; 
            
            if(!regExp.test(userId.value)){
                alert("유효한 아이디를 입력하세요!");

                userId.value = "";
                userId.focus();

                return false;
            }
            
            // 패스워드 영문/숫자/특수문자 조합하여 6~12자리
            var reg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{6,12}$/i;

            if(!reg.test(userPwd1.value)){
                alert("비밀번호 규칙이 맞지 않습니다.");
                userPwd1.value="";
                userPwd1.focus();
                return false;
            }
            
            // 비밀번호와 비밀번호 확인이 일치하는지 확인
            if(userPwd1.value != userPwd2.value){
                alert("동일한 비밀번호를 입력해주세요.");
                userPwd2.value = "";
                userPwd2.focus();
                return false;
            }
            
    	}
    </script>
</body>
</html>