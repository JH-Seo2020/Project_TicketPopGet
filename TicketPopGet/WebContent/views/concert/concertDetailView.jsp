<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.concert.model.vo.*" %>
<%
	Concert cObject = (Concert)request.getAttribute("concertObject");
	String getPrice = cObject.getPrice();
	String price = getPrice.substring(0, getPrice.length()-2);
	String concertInfo = (String)request.getAttribute("concertInfo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<%@ include file="/views/common/menubar.jsp" %>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" type="text/css" />  
<script src="http://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
    <style>
        #wrap_ccDe{
            width: 1200px;
            height: 1800px;
            /* border: 2px solid gray; */
            margin: auto;
            box-sizing: border-box;
        }
        #concertDetailHead{
            font-size: 45px;
            width: 100%;
            height: 10%;
            margin-bottom: 10px;
            padding-top: 50px;
        }
        /*공연정보기술부분*/
        #concertDetailBody{
            width: 100%;
            height: 30%;
        }
        #cdBody1, #cdBody2,#cdBody3 {
            float: left;
            height: 80%;
            box-sizing: border-box;
        }
        #cdBody1{width: 30%; font-size: 20px; padding-top: 50px;}
        #cdBody2{width: 40%; font-size: 18px; padding-top: 100px;}
        #cdBody3{width: 30%; font-size: 20px; padding-top: 50px; padding-left: 50px;}
        /*상세설명부분*/
        #concertDetailInfo{
            width: 100%;
            height: 50%;
            /* background-color: lightyellow; */
            margin-top: 10px;
        }
        #concertDetailInfoHead{
            padding-top: 20px;
            width: 100%;
            height: 10%;   
        }
        #concertDetailInfoBody1, #concertDetailInfoBody2, #concertDetailInfoBody3 {
            width: 100%;
            padding-top: 50px;
            padding-bottom: 50px;
        }
        /*display none 처리할 부분 : 버튼 클릭 시 보여지게 할 예정 */
        #concertDetailInfoBody2, #concertDetailInfoBody3{
            display: none;
        }
        #kakaoAPI{
            width: 100%;
            height: 20%;
        }
        #kakaoAPI>div{
            float: left;
            width: 50%;
            height: 100%;
            padding-top: 50px;
        }
        /*paging 버튼*/
        #reviewPaging{
            text-align: center;
            margin-top: 30px;
        }
        #reviewPaging button{
            margin-top: 20px;
            margin-right: 10px;
            width: 40px;
            height: 40px;
            border: none;
            color: balck;
            background-color: #ffb300;
            border-radius: 5px;
        }
        /*모든 a태그 색 변하지 않게 설정*/
        a{text-decoration: none !important; color: black !important;}
        /*캘린더 크기 너비 설정*/
        .ui-datepicker {
            width: 250px; /*what ever width you want*/
            height: 300px;
        }
        
    </style>
</head>
<body>


	<div id="wrap_ccDe">

        <div id="concertDetailHead">
            <label><%=cObject.getContentType() %></label>
            <label>&lt;<%=cObject.getContentTitle() %>&gt;</label>        
        </div>

        <div id="concertDetailBody">

            <div id="cdBody1" align="center">
                <div><img src="<%=contextPath %>/<%=cObject.getImgPath()%>/<%=cObject.getContentChangeImg() %>" width="250px" height="350px"></div>
                <label>관심등록</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label><a><img id="likeImg" src="<%=contextPath %>/resources/img/imgForSearch/heart.png" height="20px" width="20px"></a></label>
            </div>
            
            <script>
            	$(function(){
            		$("#likeImg").click(function(){
            			<%if(loginUser!=null){%>
	            			if( $(this).attr("src") === "<%=contextPath %>/resources/img/imgForSearch/heart.png" ){
	            				$(this).attr("src","<%=contextPath %>/resources/img/imgForSearch/like_heart.png");
	            			}else{
	            				$(this).attr("src","<%=contextPath %>/resources/img/imgForSearch/heart.png");
	            			}
            			<%}else{%>
            				alert("로그인 후 이용해주세요!");
            			<%}%>
            		});
            	});
            </script>

            <div id="cdBody2">
                <table class="table table-sm">
                    <thead>
                      <tr align="center">
                        <th scope="col" width="30%">상세정보</th>
                        <th scope="col">내용</th>
                      </tr>
                    </thead>
                    <tbody align="center">
                      <tr>
                        <th scope="row">주최</th>
                        <td><%=cObject.getContentSubject() %></td>
                      </tr>
                      <tr>
                        <th scope="row">기간</th>
                        <td><%=cObject.getConcertDate() %></td>
                      </tr>
                      <tr>
                        <th scope="row">관람시간</th>
                        <td><%=cObject.getConcertRuntime() %></td>
                      </tr>
                      <tr>
                        <th scope="row">관람등급</th>
                        <td colspan="2"><%=cObject.getLimit() %></td>
                      </tr>
                      <tr>
                        <th scope="row">장소</th>
                        <td colspan="2"><%=cObject.getPlace() %></td>
                      </tr>
                      <tr>
                        <th scope="row">가격</th>
                        <td colspan="2"><%= price %>원</td>
                      </tr>
                      <tr>
                        <th scope="row">키워드</th>
                        <td colspan="2"><%=cObject.getContentKeyword() %></td>
                      </tr>
                    </tbody>
                  </table>
            </div>

            <div id="cdBody3">
                <div id="cdCalendar"></div>
            <!--캘린더 설정-->
            <script>
                $(function() {
                	
                    $("#cdCalendar").datepicker({
                        dateFormat: "yy-mm-dd",     //날짜형식
                        minDate: '<%=cObject.getConcertDate()%>',      //기간시작일
                        maxDate: '<%=cObject.getConcertDate()%>'       //기간끝일
                        //일단 이정도만? 주말 예외처리..이런건 차차 생각해봐요..
                    });
                    $("#cdCalendar").on("change",function(){
                        var concertDay = $(this).val();         //회원이 고른 날짜 변수에담음
                        $("#cdSeatNo>span").text(concertDay);   //고른 날짜 표기 (필요없으시면 지워도됩니다)
                        $("#concertSeats").text(<%=cObject.getConcertSeats()%>);
            			$("#concertMax").text(<%=cObject.getConcertMax()%>);
                    });
                });
            </script>

                <div id="cdSeatNo">
                    날짜 : <span></span>
                    <br>
                    남은 좌석 : <lable id="concertSeats"></lable>&nbsp;/
                    전체 : <label id="concertMax"></label>
                </div>
            </div>

            <div width="100%" align="center">
            	<%if(loginUser != null){ %>
                	<a class="btn btn-warning btn-lg">예매하기</a>
                <%}else{ %>
                	<a class="btn btn-warning btn-lg" onclick="call();">예매하기</a>
                	<script>function call(){alert("로그인 후 이용해주세요!");}</script>
                <%} %>
            </div>

        </div>

        <div id="concertDetailInfo">

            <div id="concertDetailInfoHead">
                <a id="cDetail" class="btn btn-outline-warning btn-lg">상세정보</a>
                <a id="cCancel" class="btn btn-outline-warning btn-lg">환불/취소</a>
                <a id="cReview" class="btn btn-outline-warning btn-lg">리뷰</a>
            </div>
            
            <script>
                    $(function(){
                        selectReviews(1);
                        
                        
                        $("#cDetail").click(function(){
                			$("#concertDetailInfoBody1").css("display","block");
                			$("#concertDetailInfoBody2").css("display","none");
                			$("#concertDetailInfoBody3").css("display","none");
                		});
                		$("#cCancel").click(function(){
                			$("#concertDetailInfoBody1").css("display","none");
                			$("#concertDetailInfoBody2").css("display","block");
                			$("#concertDetailInfoBody3").css("display","none");
                		});
                		$("#cReview").click(function(){
                			
                			$("#concertDetailInfoBody1").css("display","none");
                			$("#concertDetailInfoBody2").css("display","none");
                			$("#concertDetailInfoBody3").css("display","block");
                		});
                   });
                 
                     function selectReviews(cPage){
                        $.ajax({
                           url : "<%=contextPath%>/review.inconcert",
                           type : "get",
                           data : {"contentNo" : <%=cObject.getContentNo()%>,
                                   "currentPage" : cPage},
                           success : function(result){
                              
                              if(result.list.length >= 1){
	                              var reviews = "";
	                               for (var i in result.list){
	                                  reviews += "<tr>"
	                                        + "<th>" + result.list[i].reviewNo + "</th>"
	                                        + "<td><a onclick='callReview("+result.list[i].reviewNo+");' style='cursor:pointer;'>" + result.list[i].reviewTitle+ "</a></td>"
	                                        + "<td>" + result.list[i].reviewPoint+ "</td>"
	                                        + "<td>" + result.list[i].reviewDate+ "</td>"
	                                        + "<td>" + result.list[i].reviewCount+ "</td>"
	                                        + "</tr>"
	                               }
	                               
	                               
	                               var $boardLimit = result.pi.boardLimit;
	                               var $currentPage = result.pi.currentPage;
	                               var $endPage = result.pi.endPage;
	                               var $listCount = result.pi.listCount;
	                               var $maxPage = result.pi.maxPage;
	                               var $pageLimit = result.pi.pageLimit;
	                               var $startPage = result.pi.startPage;
	                               
	                               var $btns = "";
	                               for(var $p = $startPage; $p <= $endPage; $p++ ){
	                                 
	                            	   if($p != $currentPage){
	       	                          	$btns += "<button class='cc' type='button' onclick='selectReviews(" + $p + ");'>" + $p + "</button>"+"&nbsp;";	                       		  
	       	                       	  }else{
	       	                       		$btns += "<button disabled style='color:black'>" + $p + "</button>"+"&nbsp;";
	       	                       	  }  
	                                  
	                               }
	                               
	                               
	                               var $firstBtn = "<button type='button'id='startBtn' onclick='selectReviews(" + 1 + ");'>" + "&lt;&lt;" + "</button>";
	                               var $prevBtn = "<button type='button' id='prevBtn' onclick='selectReviews(" + ($currentPage - 1) + ");'>" + "&lt;" + "</button>";
	                               var $nextBtn = "<button type='button' onclick='selectReviews(" + ($currentPage + 1) + ");'>" + "&gt;" + "</button>";
	                               var $endBtn = "<button type='button' onclick='selectReviews(" + $maxPage + ");'>" + "&gt;&gt;" + "</button>";
	                               
	                               	var $buttons = $firstBtn +"&nbsp;"+ $prevBtn +"&nbsp;"+ $btns +"&nbsp;"+ $nextBtn +"&nbsp;"+ $endBtn ;
	   		                    	var $buttons0 = $firstBtn +"&nbsp;"+ $btns +"&nbsp;"+ $endBtn ;
	   		                    	var $buttons1 = $firstBtn + "&nbsp;"+ $btns +"&nbsp;"+ $nextBtn +"&nbsp;"+ $endBtn ;
	   		                    	var $buttons2 = $firstBtn +"&nbsp;"+ $prevBtn +"&nbsp;"+ $btns +"&nbsp;" + $endBtn ;
	   		                    
	   		                    	$("#tbodyArea").html(reviews);
	   		                    
		   		                    
		   		                    if(cPage == "1" && cPage == $maxPage){
		   		                    	$("#reviewPaging").html($buttons0);
		   		                    }else if(cPage == "1" && cPage != $maxPage) {
		   		                    	$("#reviewPaging").html($buttons1);
		                            }else if(cPage != "1" && cPage != $maxPage){
		                               	$("#reviewPaging").html($buttons);
		                            }else if (cPage != "1" && cPage == $maxPage){
		                               	$("#reviewPaging").html($buttons2);
		                            }  
	                               
                             	
										                               
	                               
                              }else{
                            	  $("#tbodyArea").html('보여드릴 리뷰가 없습니다.');
                              }
                              	
                           },
                           error : function(){
                              console.log("ajax통신실패");
                          }

               			});
               		}
                     

                     function callReview(reviewNo){
                  	   location.href = '<%=contextPath%>/review.detail?reviewNo='+reviewNo;
                     }
            		

            		
            </script>

            <div id="concertDetailInfoBody1">
                <p style="font-size: 35px;">&lt;상세정보&gt;</p>
                <div>
                    <%=concertInfo %>
                    
                    <div id="kakaoAPI">
                        <div>
                            카카오 지도 api 미리 붙여놓음 (도메인필요)
                            
                            <!-- <div id="map" style="width:500px;height:400px;"></div>
                            <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=발급받은 APP KEY를 넣으시면 됩니다."></script>
                            <script>
                                var container = document.getElementById('map');
                                var options = {
                                    center: new kakao.maps.LatLng(33.450701, 126.570667),
                                    level: 3
                                };
            
                                var map = new kakao.maps.Map(container, options);
                            </script>  -->
                           
                        </div>
                        <div>
                            <p>장소 : 홍대 어딘가 극장</p>
                            <p>주소 : 서울시 마포구 홍익대학교 근처</p>
                        </div>
                    </div>
                </div>

            </div>

            <div id="concertDetailInfoBody2">
                <p style="font-size: 35px;">&lt;환불/취소&gt;</p>
                <div>
                    에디터 추가 예정 or 그냥 텍스트 넣기 <br>
                    둘 아무 내린 불러 나는 까닭이요, 별 많은 오는 봅니다. 가난한 옥 내 된 듯합니다. 
                    가슴속에 딴은 새겨지는 벌레는 것은 버리었습니다. 써 경, 나의 남은 하나의 우는 같이 아름다운 있습니다. 그러나 동경과 잠, 하나에 흙으로 봅니다. 
                    별들을 라이너 가슴속에 별 있습니다. 
                    내 하나에 가득 이름과 슬퍼하는 당신은 나의 계십니다. 사람들의 없이 토끼, 같이 봄이 다 까닭이요, 동경과 봅니다. 추억과 남은 것은 하나 별에도 있습니다. 
                    사랑과 아직 다 지나고 별 버리었습니다. 내일 까닭이요, 멀리 아침이 사랑과 어머님, 별들을 없이 무엇인지 있습니다.
                    무덤 나의 밤이 시와 가슴속에 까닭입니다. 
                    별 하나에 언덕 어머님, 된 까닭입니다. 별에도 속의 위에 사랑과 하나에 시인의 별 있습니다. 가득 가난한 밤이 까닭입니다. 하나의 가을로 다하지 위에 잠, 헤는 위에도 듯합니다. 
                    아름다운 피어나듯이 동경과 아침이 토끼, 옥 그러나 계십니다. 둘 까닭이요, 별 같이 사랑과 별 이름자 비둘기, 다하지 까닭입니다. 이름과 계집애들의 하나의 별 버리었습니다. 
                    벌레는 멀리 하나에 무엇인지 이름자 별 잠, 사랑과 이름과, 듯합니다. 
                    자랑처럼 잠, 북간도에 이름과, 헤는 위에 책상을 까닭입니다.
                    멀리 덮어 노루, 이름을 한 버리었습니다. 이런 밤이 무덤 토끼, 다하지 하나 하늘에는 사람들의 가슴속에 까닭입니다. 무엇인지 별 속의 했던 겨울이 묻힌 이국 어머니, 무성할 계십니다. 
                    아름다운 때 마리아 가을로 하나 별 프랑시스 언덕 멀리 계십니다. 딴은 둘 별 새워 헤는 거외다. 별 풀이 청춘이 그러나 새워 헤일 까닭이요, 이런 북간도에 거외다. 가득 추억과 어머님, 시인의 멀리 봅니다. 
                    북간도에 이름과, 패, 둘 보고, 잔디가 봅니다. 헤일 둘 말 하나의 하나에 동경과 봅니다. 
                    이름을 이네들은 하나에 나는 듯합니다. 별 추억과 어머님, 피어나듯이 까닭입니다.
                    
                </div>

            </div>

            <div id="concertDetailInfoBody3">
                <p style="font-size: 35px;">&lt;리뷰&gt;</p>
                <table id="reviewList" class="table table-hover">
                    <thead class="thead-dark" align="center">
                      <tr>
                        <th scope="col">번호</th>
                        <th scope="col" width="50%">제목</th>
                        <th scope="col">별점</th>
                        <th scope="col" width=10%>날짜</th>
                        <th scope="col">조회수</th>
                      </tr>
                    </thead>
                    <tbody align="center" id="tbodyArea">
                      
                    </tbody>
                </table>
        
                <div id="reviewPaging">
                    
                </div>

            </div>

            <div align="right">
                <!-- 목록으로 버튼 있었는데 없앴습니다. 브라우저에는 뒤로가기라는 훌륭한 기능이 있으니까...! -->
            </div>
        </div>


    </div>
</body>
</html>