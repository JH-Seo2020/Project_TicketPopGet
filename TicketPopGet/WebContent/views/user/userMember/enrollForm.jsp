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
                                    <input type="text" id="userId" class="form-control" name="userId" style="width: 300px;" placeholder="띄어쓰기 없이 영문/숫자조합 6~12자리">
                                    &nbsp;&nbsp;<button type="button"class="checkId" onclick="idCheck();">중복확인</button>
                            </div>

                            <div class="form-group row">
                                <label for="password" class="col-md-4 col-form-label text-md-right">비밀번호</label>
                                    <input type="text" id="password" class="form-control" name="password" style="width: 400px;" placeholder="영문/숫자/특수문자 조합하여 6~12자리">
                            </div>

                            <div class="form-group row">
                                <label for="password" class="col-md-4 col-form-label text-md-right">비밀번호 확인</label>
                                    <input type="text" id="password" class="form-control" name="password" style="width: 400px;" placeholder="비밀번호 재입력">
                            </div>

                            <div class="form-group row">
                                <label for="userName" class="col-md-4 col-form-label text-md-right">이름</label>
                                    <input type="text" id="userName" class="form-control" style="width: 400px;" placeholder="이름">
                            </div>

                            <div class="form-group row">                                    
                                <label for="birth" class="col-md-4 col-form-label text-md-right">생년월일</label>
                                    <input type="text" name="year" class="form-control" style="width: 127px;" placeholder="년(4자)">
                                    &nbsp;&nbsp;<select id="mm" style="width: 127px" class="form-control">
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
                                    </select>
                                    &nbsp;&nbsp;<select id="dd" style="width: 127px" style="font-size:10px;" class="form-control">
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
                                    </select>
                                    &nbsp;&nbsp;<input type="text" name="phone" class="form-control" style="width: 127px;">
                                    &nbsp;&nbsp;<input type="text" name="phone" class="form-control" style="width: 127px;">
                            </div>

                            <div class="form-group row">
                                <label for="email" class="col-md-4 col-form-label text-md-right">이메일</label>
                                    <input type="text" id="email" class="form-control" style="width: 400px;" placeholder="이메일 입력">
                            </div>

                            <br>
                            <div class="col-md-6 offset-md-4">
                                <button type="submit" class="btnRegister" id="joinBtn">회원가입</button>
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
    </script>
</body>
</html>