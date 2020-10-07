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
            background: #f6f6f6;
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
            		changeImg();
            		
            		$("#likeImg").click(function(){
            			<%if(loginUser!=null){%>
	            			if( $(this).attr("src") === "<%=contextPath %>/resources/img/imgForSearch/heart.png" ){
	            				$(this).attr("src","<%=contextPath %>/resources/img/imgForSearch/like_heart.png");
	            				updateWish();
	            			}else{
	            				$(this).attr("src","<%=contextPath %>/resources/img/imgForSearch/heart.png");
	            				deletewish();
	            			}
            			<%}else{%>
            				alert("로그인 후 이용해주세요!");
            			<%}%>
            		});
            	});
            	
            	function changeImg(){
            		<%if(loginUser!=null){%>
            			$.ajax({
            				url : "<%=contextPath%>/check.img",
            				type : "get",
            				data : {"contentNo" : <%=cObject.getContentNo()%>},
            				success : function(result){
            					console.log(result);
            					
            					if(result>0){
            						$("#likeImg").attr("src","<%=contextPath %>/resources/img/imgForSearch/like_heart.png");
            					}else{
            						$("#likeImg").attr("src","<%=contextPath %>/resources/img/imgForSearch/heart.png");
            					}
            					
            				},error : function(){
            					console.log('실패');
            				}
            				
            			});	
            		
            		<%}else{%>
            			$('#likeImg').attr("src","<%=contextPath %>/resources/img/imgForSearch/heart.png");
            		<%}%>
            	}

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
                	<a class="btn btn-warning btn-lg" id="reservationBtn" href="<%=contextPath%>/conpay.me?contentNo=<%=cObject.getContentNo()%>">예매하기</a>
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
            		
                     function updateWish(){
                 		$.ajax({
                 			url:"<%=contextPath%>/update.wishEx",
                 			type:"get",
                 			data:{"contentNo":<%=cObject.getContentNo()%>},
                 			success: function(result){
                 				alert('관심등록성공!');
                 			},
                 			error: function(){
                 				console.log('통신실패');
                 			}
                 				
                 		});
                 	}
                     
                     function deletewish(){
                     	$.ajax({
                 			url:"<%=contextPath%>/delete.wishEx",
                 			type:"get",
                 			data:{"contentNo":<%=cObject.getContentNo()%>},
                 			success: function(result){
                 				alert('관심등록삭제!');
                 				changeImg();
                 			},
                 			error: function(){
                 				console.log('통신실패');
                 			}
                 				
                 		});
                     }
            		
            </script>

            <div id="concertDetailInfoBody1">
                <p style="font-size: 35px;">&lt;상세정보&gt;</p>
                <div>
                    <%=concertInfo %>
                    <hr>
                    <div id="kakaoAPI">
                        <div>
                            <span><b>위치정보</b></span>
                            <div id="map" style="width:500px;height:200px;"></div>
                            <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7ef05dee2f78a0d0551b6fd2aa8092bf"></script>
                            <script>
                                var container = document.getElementById('map');
                                var options = {
                                    center: new kakao.maps.LatLng(33.450701, 126.570667),
                                    level: 3
                                };
            
                                var map = new kakao.maps.Map(container, options);
                            </script>
                           
	                        <div>
	                            <p>장소 : <%=cObject.getPlace()%></p>
	                        </div>
                        </div>
                    </div>
                </div>

            </div>

            <div id="concertDetailInfoBody2">
                <p style="font-size: 35px;">&lt;환불/취소&gt;</p>
                <div>
                    합리적인 환불 정책<br>
					IKEA는 제품 구매 후 고객 여러분의 만족감을 매우 중요하게 생각합니다. <br>
					제품이 완전히 만족스럽지 않은 경우 또는 마음이 바뀐 경우에는 365일 이내에 제품을 환불하실 수 있습니다. <br>
					구매 증명과 제품(가능한 경우 원래의 포장 상태)을 반환하시면 제품 구매 시 결제한 것과 동일한 방법으로 환불해 드립니다. <br>
					제품을 사용하지 않았으며 판매가 가능한 상태인 경우, 이미 조립을 마쳤더라도 모든 제품을 환불받으실 수 있습니다. <br>
					판매가 가능한 상태란, 재판매가 가능한 정상 제품으로 손상 또는 변형되지 않고, 얼룩 없는 상태, 세탁 또는 사용 하지 않은 상태입니다. <br>
					일부 환불 조건이 충족되지 않는 경우에는 환불되지 않을 수도 있으며, 제품 교환 또는 IKEA 환불카드를 수령하는 것으로 대체될 수 있습니다.<br>

					이 정책은 고객의 마음이 변한 경우에 적용되며 고객의 법적 권한 및 IKEA 상업 보증 외에 부가적으로 적용됩니다. <br>
					제품에 결함이 있거나 설명서와 동일한 상태가 아닌 경우에는 언제든지 IKEA에 반품할 권한이 있습니다.<br>
                    
                    
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