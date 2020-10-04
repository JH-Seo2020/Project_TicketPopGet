<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
nav > .nav.nav-tabs{
border: none;
  color:#fff;
  background:#ffb3005d;
  border-radius:0;
  width: 700px;
}

.step1{
  border: none;
  width: 100%;
  background: #ffb300;
  color:#fff;
  border-radius:0;
  transition:background 0.20s linear;
  padding: 18px 25px;
  text-align: center;
}


.listArea{
  float: left;
  margin-left:5%;
}
#nextBtn{
  margin-top: 20px;
  margin-left: 60px;
}
.select{
  background-color: #ffb3005d;
  width: 150px;
  height: 190px;
  float: left;
}

#playTime{
  margin-left:7% ;
  color:#fff; 
  background:#ff8149; 
  border:1px solid #ff8149;
}

/*datepicer 버튼 롤오버 시 손가락 모양 표시*/
.ui-datepicker-trigger{cursor: pointer;}
/*datepicer input 롤오버 시 손가락 모양 표시*/
.hasDatepicker{cursor: pointer;}
</style>
<body>
  <div class="row">
    <div class="col-xs-12 ">

      <nav>
        <div class="nav nav-tabs nav-fill" id="nav-tab">
          <div class="step1"><b style="font-size: 20px;">결제페이지</b></div>
        </div>
      </nav>

        <div>
          <div class="listArea">
            <br>
            <div id="selectDate">
              <b>날짜</b><br><span>2020-10-05</span> <br>
            </div>
            <br>
            &nbsp;<b>회차정보</b>
            <br>
              
              <div class="select">
                <b>&nbsp;잔여석</b><br>
                <table>
                  <tr>
                    <td style="width: 80px;">&nbsp;전석</td>
                    <td>&nbsp;30석</td>
                  </tr>
                  <tr>
                    <td>&nbsp;잔여석</td>
                    <td>&nbsp;14석</td>
                  </tr>
                </table>
                <hr>
                <table>
                  <tr>
                    <td style="width: 60px;">&nbsp;금액</td>
                    <td>&nbsp;16000원</td>
                  </tr>
                  <tr>
                    <td>&nbsp;매수</td>
                    <td><select id="gender" class="form-control" style="width: 80px;">
                      <option>선택</option>
                      <option value="1">1</option>
                      <option value="2">2</option>
                      <option value="4">3</option>
                      <option value="5">5</option>
                  </select></td>
                  </tr>
                </table>
              </div>
          </div>

          <div class="listArea" style="margin-left:70px;">
            <br>
            <div id="selectDate">
              <b>결제방법</b><br><br>
              <input type="radio"> 카드 <br>
              <input type="radio"> 실시간 계좌이체 <br>
            </div>
          </div>
          
          <div class="listArea" style="margin-left:80px;">
              <div>
                <table>
                  <tr>
                    <td><img id="poster" src="css/캡처.JPG" width=70px height="90px"> </td>
                    <td>
                      <b style="font-size: 15px;">연극 [메밀꽃 필무렵]</b><br>
                      <span style="font-size: 13px;">2020-09-01 ~ 2020-10-21<br>
                      서울예술대학교</span>
                    </td>
                  </tr>
                </table>
                <hr>
                <b style="font-size: 20px;">예매정보</b>
                <hr>
                <table width=220px>
                    <tr>
                      <td>날짜</td>
                      <td id="selected_date" style="text-align: right;">2020-09-05(토)</td>
                    </tr>
                    <tr>
                      <td>시간</td>
                      <td style="text-align: right;">[1회차]15시00분</td>
                    </tr>
                    <tr>
                      <td>매수</td>
                      <td style="text-align: right;">2</td>
                    </tr>
                    <tr>
                      <td>티켓금액</td>
                      <td style="text-align: right;">16000원</td>
                    </tr>
                  </table>
                  <hr>
                  <table width=220px>
                    <tr>
                      <th>총결제금액</th>
                      <th style="color: red; text-align: right;">32000원</th>
                    </tr>
                  </table>
              </div>
          </div>
        </div>
        <button id="nextBtn"  class="btn btn-warning" style="margin-left: 40%; margin-top: 7%;">다음단계</button>
      </div>

  </div>
</body>
</html>