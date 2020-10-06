<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Date, com.kh.play.model.vo.Play, com.kh.user.model.vo.Member" %>    
<%
	Member loginUser = (Member) request.getSession().getAttribute("loginUser");
	String contextPath = request.getContextPath();

	Play playObject = (Play)request.getAttribute("playObject");
	Date playDate = (Date)request.getAttribute("playDate");
	
	//가격데이터 가공 (받을때 String으로 받았기 때문에 int로 변형 거쳐주기)
	String price = playObject.getPrice().substring(0,playObject.getPrice().length()-2);
	int truePrice = Integer.parseInt(price);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<style>
nav > .nav.nav-tabs{
border: none;
  color:#fff;
  background:#ffb3005d;
  border-radius:0;
  width: 800px;
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
</style>
</head>
<body>
  <form action="">
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
                <b>날짜</b><br><span><%=playDate %></span> <br>
              </div>
              <br>
              <br>
              &nbsp;<b>회차정보</b>
              <br>
                <div class="select">
                  <b>회차선택</b><br>
                  <lable id="playTime">[<%=playObject.getPlayRoundCount() %>회] <%=playObject.getRoundStart() %></label>
                </div>
                

                <div class="select">
                  <b>&nbsp;잔여석</b><br>
                  <table>
                    <tr>
                      <td style="width: 80px;">&nbsp;전석</td>
                      <td>&nbsp;<%=playObject.getRoundMax() %></td>
                    </tr>
                    <tr>
                      <td>&nbsp;잔여석</td>
                      <td>&nbsp;<%=playObject.getRoundSeats() %></td>
                    </tr>
                  </table>
                  <hr>
                  <table>
                    <tr>
                      <td style="width: 60px;">&nbsp;금액</td>
                      <td>&nbsp;<%=truePrice %>원</td>
                    </tr>
                    <tr>
                      <td>&nbsp;매수</td>
                      <td><select id="gender" class="form-control" style="width: 80px;">
                        <option>선택</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                    </select></td>
                    </tr>
                  </table>
                </div>
            </div>

            <div class="listArea" style="margin-left:30px;">
              <br>
              <div id="selectDate">
                <b>결제방법</b><br><br>
                <input type="radio"> 카드 <br>
                <input type="radio"> 실시간 계좌이체 <br>
              </div>
            </div>
            
            <div class="listArea" style="margin-left:60px;">
                <div>
                  <table>
                    <tr>
                      <td><img id="poster" src="<%=contextPath %>/<%=playObject.getImgPath() %>/<%=playObject.getContentChangeImg() %>" width=70px height="90px"> </td>
                      <td>
                        <b style="font-size: 15px;"><%=playObject.getContentType() %> [<%=playObject.getContentTitle() %>]</b><br>
                        <span style="font-size: 13px;"><%=playObject.getPlayStartDate() %> ~ <%=playObject.getPlayEndDate() %><br>
                        <%=playObject.getPlace() %></span>
                      </td>
                    </tr>
                  </table>
                  <hr>
                  <b style="font-size: 20px;">예매정보</b>
                  <hr>
                  <table width=220px>
                      <tr>
                        <td>날짜</td>
                        <td id="selected_date" style="text-align: right;"><%=playDate %></td>
                      </tr>
                      <tr>
                        <td>시간</td>
                        <td style="text-align: right;">[<%=playObject.getPlayRoundCount() %>회차]<%=playObject.getRoundStart() %></td>
                      </tr>
                      <tr>
                        <td>매수</td>
                        <td style="text-align: right;"></td>
                      </tr>
                      <tr>
                        <td>티켓금액</td>
                        <td style="text-align: right;"></td>
                      </tr>
                    </table>
                    <hr>
                    <table width=220px>
                      <tr>
                        <th>총결제금액</th>
                        <th style="color: red; text-align: right;"></th>
                      </tr>
                    </table>
                    <br> <br>
                </div>
            </div>
          </div>
          <div align="right" style="margin-top: 5%;">
            <button type="submit" class="btn btn-warning">결제하기</button>
            <button type="reset" class="btn btn-warning">취소하기</button>
          </div>
        </div>
    </div>
  </form>
</body>
</html>