<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
<style>
#carouselExampleCaptions{width: 1200px; height: 360px; margin: 0 auto;}
.carousel-item>img{width : 600px; height : 360px;}
   #wrap_mp{
       width: 1200px !important;
       height: 1800px !important;
       margin: auto;
       box-sizing: border-box;
   }
   
   /* 롤링배너자리 */
   #carouselExampleCaptions{
       margin-top: 2%;
       width: 100%;
       height: 20%;
   }
   /* 투데이베스트와 예매율 */
   #tbAndRate{
       margin-top: 2%;
       width: 100%;
       height: 20%;
       box-sizing: border-box;
   }
   #tbAndRate>div{float: left; height: 100%;}
   #todayBest{
       width: 64%;
       margin-right: 1%;
   }
   #rate{
       width: 34%;
   }
   /* 신규오픈 */
   #newOpen{
       width: 100%;
       height: 20%;
       margin-top: 10px;
   }
   /* 마감임박 */
   #finalTicket{
       width: 100%;
       height: 20%;
       margin-top: 10px;
   }

   /* 포스터 나열칸(투베,신규,마감임박 공통) */
   #posterHeader{width: 100%; height: 10%;
               font-size: 25px; font-weight: bold;
               margin-top: 10px;
               margin-bottom: 10px;}
   #posterBody{width: 100%;height: 80%;}
   #posterBody>ul{width: 100%; height: 100%;}

   /* 포스터 나열칸 세부설정 */
   #posterBody>ul>li{
       list-style-type: none;
       float: left;
       height: 100%;
       width: 30%;
   }

   /* 예매율 테이블 설정 */
   #ranking{
       font-size: 25px; font-weight: bold;
       margin-bottom: 10px;
       margin-top: 10px;
   }
   #rankingTable{
       width: 80%;
       height: 80%;
       text-align: center;
       font-size: 15px;
   }
   /* 예매율 버튼 설정 */
   .rateBtn1{
       border: none;
       background-color: #ffb300;
       border-radius: 5px;
   }

</style>
</head>
<body>
	<%@ include file="/views/common/menubar.jsp" %>
	
	<div id="wrap_mp">

        <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
              <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
              <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
              <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
              <li data-target="#carouselExampleCaptions" data-slide-to="3"></li>
              <li data-target="#carouselExampleCaptions" data-slide-to="4"></li>
              <li data-target="#carouselExampleCaptions" data-slide-to="5"></li>
            </ol>
            <div class="carousel-inner">
              <div class="carousel-item active">
                <img src="<%=contextPath %>/resources/imgCrs/img1.jpg" class="d-block w-100" alt="">
                <div class="carousel-caption d-none d-md-block">
                  <h5>CATS</h5>
                  <p>MUSICAL</p>
                </div>
              </div>
              <div class="carousel-item">
                <img src="resources/imgCrs/im2.jpg" class="d-block w-100" alt="">
                <div class="carousel-caption d-none d-md-block">
                  <h5>JYKILL</h5>
                  <p>MUSICAL</p>
                </div>
              </div>
              <div class="carousel-item">
                <img src="resources/img/carouselTest.png" class="d-block w-100" alt="">
                <div class="carousel-caption d-none d-md-block">
                  <h5>MAP</h5>
                  <p>MAP</p>
                </div>
              </div>
              <div class="carousel-item">
                <img src="resources/img/carouselTest.png" class="d-block w-100" alt="">
                <div class="carousel-caption d-none d-md-block">
                  <h5>PLAY</h5>
                  <p>PLAY</p>
                </div>
              </div>
              <div class="carousel-item">
                <img src="resources/img/carouselTest.png" class="d-block w-100" alt="">
                <div class="carousel-caption d-none d-md-block">
                  <h5>PLAY</h5>
                  <p>PLAY</p>
                </div>
              </div>
              <div class="carousel-item">
                <img src="resources/img/carouselTest.png" class="d-block w-100" alt="">
                <div class="carousel-caption d-none d-md-block">
                  <h5>PLAY</h5>
                  <p>PLAY</p>
                </div>
              </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="sr-only">Next</span>
            </a>
        </div>

        <div id="tbAndRate">
            <div id="todayBest" align="center">
                <div id="posterHeader">Today's Best</div>
                <div id="posterBody">
                    <ul>
                        <li>
                            <span><img src="resources/post_upfiles/111111111140.PNG" height="200px" width="150px"></span>
                            <div>콘서트</div>
                            <div>신용재 콘서트</div>
                        </li>
                        <li>
                            <span><img src="resources/post_upfiles/111111111140.PNG" height="200px" width="150px"></span>
                            <div>연극</div>
                            <div>오즈프로젝트</div>
                        </li>
                        <li>
                            <span><img src="resources/post_upfiles/111111111140.PNG" height="200px" width="150px"></span>
                            <div>전시</div>
                            <div>고릴라즈 앨범자켓전시</div>
                        </li>
                    </ul>
                </div>
                
            </div>
            <div id="rate"  align="center">
                <div id="ranking">예매율 </div>
                <div id="genreBtn"align="right">
                    <button type="button" value="콘서트" class="rateBtn1">콘서트</button>
                    <button type="button" value="연극" class="rateBtn1">연극</button>
                    <button type="button" value="전시" class="rateBtn1">전시</button>
                </div>
                <table id="rankingTable">
                    <tr>
                        <td>순위</td>
                        <td>컨텐츠명</td>
                        <td>예매율</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>사이클롭스</td>
                        <td>80.2%</td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>아이,로봇</td>
                        <td>77.7%</td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>일리아드</td>
                        <td>70.1%</td>
                    </tr>
                </table>
            </div>
        </div>

        <div id="newOpen" align="center">
            <div id="posterHeader">신규 오픈 티켓</div>
                <div id="posterBody">
                    <ul>
                        <li>
                            <span><img src="resources/post_upfiles/111111111140.PNG" height="200px" width="150px"></span>
                            <div>콘서트</div>
                            <div>신용재 콘서트</div>
                        </li>
                        <li>
                            <span><img src="resources/post_upfiles/111111111140.PNG" height="200px" width="150px"></span>
                            <div>연극</div>
                            <div>오즈프로젝트</div>
                        </li>
                        <li>
                            <span><img src="resources/post_upfiles/111111111140.PNG" height="200px" width="150px"></span>
                            <div>전시</div>
                            <div>고릴라즈 앨범자켓전시</div>
                        </li>
                    </ul>
                </div>
            
        </div>

        <div id="finalTicket" align="center">
            <div id="posterHeader">마감 임박 티켓</div>
                <div id="posterBody">
                    <ul>
                        <li>
                            <span><img src="resources/post_upfiles/111111111140.PNG" height="200px" width="150px"></span>
                            <div>콘서트</div>
                            <div>신용재 콘서트</div>
                            <div>D-1</div>
                        </li>
                        <li>
                            <span><img src="resources/post_upfiles/111111111140.PNG" height="200px" width="150px"></span>
                            <div>연극</div>
                            <div>오즈프로젝트</div>
                            <div>D-1</div>
                        </li>
                        <li>
                            <span><img src="resources/post_upfiles/111111111140.PNG" height="200px" width="150px"></span>
                            <div>전시</div>
                            <div>고릴라즈 앨범자켓전시</div>
                            <div>D-1</div>
                        </li>
                    </ul>
                </div>
           
        </div>

    </div>

</body>
</html>