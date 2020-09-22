<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

 <style>

     .member_delete{
         border-bottom: 1px solid orangered;
         width: 1000px;
         height: 90px;
         margin-top: 50px;
         margin-left: 90px;
     }

     .delete_write{
         margin-left: 150px;
         margin-top: 60px;
     }

     #delete_reason{
         width: 900px;
         margin-top: 30px;
         margin-left: 100px;
     }
  

   
 </style>
</head>
<body>
   <!-- 라디오버튼 해제 기능 넣어야됨 -->
    <div class="member_delete">
        <p style="float:left;"><img src="image/회원탈퇴.png" align=middle style="width: 60px; height: 60px;"></p>
        <h1 style="float:left; margin-left: 8px; margin-top:25px">회원탈퇴</h1>
    </div>

    <h6 style="margin-left: 90px; margin-top: 25px; color: red;">
        고객님 탈퇴하시기 전 아래의 사항을 먼저 확인해주세요 <br>
        탈퇴한 계정은 취소 혹은 복구가 불가능 하오니 다시 한번 신중하게 생각해 보시기 바랍니다.
    </h6>

    <div class="delete_write">
        <div>
            <h3>회원정보</h3>
            <ul style="margin-top:20px">
                <li>탈퇴 신청한 아이디로 즉시 재가입이 불가능합니다.</li>
                <li>게시판형 서비스에 등록한 게시물은 삭제되지 않고 유지됩니다.</li>
                <li>탈퇴 시 예매하기 사용이 불가합니다.</li>
            </ul>
        </div>
        <div style="margin-top: 50px; border-top: 1px solid silver; width: 900px;">
            <h3 style="margin-top: 40px;">탈퇴 후 정보보관에 대한 안내</h3>
            <p>전자상거래 등에서의 소보자 보호에 관한 법률 제 6조에 의거 서명, 주소등 거래의 주체를 식별할 수 있는 정보에 한하여
                서비스 이용에 관한 동의를 철회한 경우에도 이를 보존할 수 있으며, 동법 시행령 제6조에 의거 다음과 같이 거래 기록을 보관합니다.
            </p>
            <ul>
                <li>표시, 광고에 관한 기록: 6개월</li>
                <li>계약 또는 청약철회 등에 관한 기록 : 5년</li>
                <li>대금결제 및 재화등의 공급에 관한 기록 : 5년</li>
                <li>소비자의 불만 또는 분쟁처리에 관한 기록 : 3년</li>
            </ul>
        </div>
        <div style="margin-top: 45px; border-top: 1px solid silver; width: 900px;">
            <h3 style="margin-top: 40px;">탈퇴사유</h3>
            <p>탈퇴하시는 사유를 알려주시면 보다 나은 서비스제공을 위해 노력하겠습니다.</p>
            <table id="delete_reason">
                <tr>
                    <td>
                        <input type="radio" name="cause" id="cause1"> 
                        <label for="cause1">개인정보유출 우려</label>
                    </td>
                    <td>
                        <input type="radio" name="cause" id="cause2">
                        <label for="cause2">탈퇴 후 재가입</label>
                    </td>
                    <td>
                        <input type="radio" name="cause" id="cause3">
                        <label for="cause3">서비스 기능 불편</label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="radio" name="cause" id="cause7">
                        <label for="cause7">시스템 오류</label>
                    </td>
                    <td>
                        <input type="radio" name="cause" id="cause8">
                        <label for="cause8">사이트 이용안함</label>
                    </td>
                </tr>
                <tr>
                    <!-- 기타 클릭시 text 이용할 수 있게 설정하기 -->
                    <td>
                        <input type="radio" name="cause" id="cause9">
                        <label for="cause9">기타</label>
                    </td>
                </tr>
                <tr>
                    <td colspan="3">
                        <textarea style="width: 700px; height: 90px; resize: none;"></textarea>
                    </td>
                </tr>
            </table> 
        </div>

        <div style="margin-top: 90px; margin-left: 250px;">
                <input type="radio" onclick="" style="width:20px; height: 16px; " id="delete_ok">
                <label for="delete_ok" style="font-size: 20px;">위, 모든 내용을 확인했으며 동의합니다</label>
        </div>
    </div>

    <div align=center style="margin-top: 70px;">
        <button type="button" class="btn" style="border: 1px solid orange; background:orange; color: white;">탈퇴하기</button> 
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <button type="button" class="btn" style="border: 1px solid orange;">이전으로</button>
    </div>
</body>
</html>