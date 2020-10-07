<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.play.model.vo.Play" %>
<%
	Play playObject = (Play)request.getAttribute("playObject");
	String getPrice = playObject.getPrice();
	String price = getPrice.substring(0, getPrice.length()-2);
	String playInfo = (String)request.getAttribute("playInfo");
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
	#wrap_plDe{
	    width: 1200px;
	    height: 1800px;
	    /* border: 2px solid gray; */
	    margin: auto;
	    box-sizing: border-box;
	}
	#playDetailHead{
	    font-size: 45px;
	    width: 100%;
	    height: 10%;
	    margin-bottom: 10px;
	    padding-top: 50px;
	}
	/*공연정보기술부분*/
	#playDetailBody{
	    width: 100%;
	    height: 30%;
	    background: #f6f6f6;
	}
	#plBody1, #plBody2,#plBody3 {
	    float: left;
	    height: 80%;
	    box-sizing: border-box;
	}
	#plBody1{width: 30%; font-size: 20px; padding-top: 50px;}
	#plBody2{width: 40%; font-size: 18px; padding-top: 100px;}
	#plBody3{width: 30%; font-size: 20px; padding-top: 50px; padding-left: 50px;}
	/*상세설명부분*/
	#playDetailInfo{
	    width: 100%;
	    height: 50%;
	    /* background-color: lightyellow; */
	    margin-top: 10px;
	}
	#playDetailInfoHead{
	    padding-top: 20px;
	    width: 100%;
	    height: 10%;   
	}
	#playDetailInfoBody1, #playDetailInfoBody2, #playDetailInfoBody3 {
	    width: 100%;
	    padding-top: 50px;
	    padding-bottom: 50px;
	}
	/*display none 처리 해두는 부분 :  버튼누르면 보이게 처리할 예정 */
	#playDetailInfoBody2, #playDetailInfoBody3{
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
	    width: 40px;
	    height: 40px;
	    border: none;
	    color: white;
	    background-color: #ffb300;
	    border-radius: 5px;
	}
	/*모든 a태그 색 변하지 않게 설정*/
	a{text-decoration: none !important; color: black !important;}
	/*캘린더 크기 너비 설정*/
	.ui-datepicker {
	    width: 250px; /*what ever width you want*/
	    height: 330px;
	}
	
	#roundSelect,#playStartEnd, #seatInfo{
		display:none;
	}
                        			
	</style>
</head>
<body>

	<div id="wrap_plDe">

        <div id="playDetailHead">
            <label><%=playObject.getContentType() %></label>
            <label>&lt;<%=playObject.getContentTitle() %>&gt;</label>        
        </div>

        <div id="playDetailBody">

            <div id="plBody1" align="center">
                <div><img src="<%=contextPath %>/<%=playObject.getImgPath() %>/<%=playObject.getContentChangeImg() %>" width="250px" height="350px"></div>
                <label>관심등록</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label><a href=""><img id="likeImg" src="<%=contextPath %>/resources/img/imgForSearch/heart.png" height="20px" width="20px"></a></label>
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
            				data : {"contentNo" : <%=playObject.getContentNo()%>},
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

            <div id="plBody2">
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
                        <td><%=playObject.getContentSubject() %></td>
                      </tr>
                      <tr>
                        <th scope="row">기간</th>
                        <td><%=playObject.getPlayStartDate() %>~<%=playObject.getPlayEndDate() %></td>
                      </tr>
                      <tr>
                        <th scope="row">관람시간</th>
                        <td><%=playObject.getPlayRuntime() %></td>
                      </tr>
                      <tr>
                        <th scope="row">관람등급</th>
                        <td colspan="2"><%=playObject.getLimit() %></td>
                      </tr>
                      <tr>
                        <th scope="row">장소</th>
                        <td colspan="2"><%=playObject.getPlace() %></td>
                      </tr>
                      <tr>
                        <th scope="row">가격</th>
                        <td colspan="2"><%=price %>원</td>
                      </tr>
                      <tr>
                        <th scope="row">키워드</th>
                        <td colspan="2"><%=playObject.getContentKeyword() %></td>
                      </tr>
                    </tbody>
                  </table>
            </div>

            <div id="plBody3">
                <div id="plCalendar"></div>
            <!--캘린더 설정-->
            <script>
            var playDay;
                $(function() {
                	//조건처리 : 시작일이 아직 안왔으면, 예매가능일이 곧 시작일. 시작일이 지났으면, 예매가능일이 오늘
                	var $currentDay = new Date();
                	var $resultDay = ($currentDay - <%=playObject.getPlayStartDate()%> < 0 ? '<%=playObject.getPlayStartDate()%>': '0');
                    $("#plCalendar").datepicker({
                        dateFormat: "yy-mm-dd",     
                        minDate: $resultDay,   
                        maxDate: '<%=playObject.getPlayEndDate()%>'       
                        
                    });
                   
                    $("#plCalendar").on("change",function(){
                        playDay = $(this).val();         //회원이 고른 날짜 변수에담음
                        $("#plSeatNo>span").text(playDay);   //고른 날짜 표기
                        
                        //회차정보 조회용 ajax 호출
                        $.ajax({
                        	url:"<%=contextPath%>/round.inplay",
                        	type:"get",
                        	data:{
                        		"contentNo" : <%=playObject.getContentNo()%>,
                        		"playDay" : playDay
                        	},
                        	success:function(round){
                        		
                        		if(round.length >= '1'){
                        			
                        			var options = "";
                        			for(var i in round){
	                        			options += "<option value='"+round[i].playRoundCount+"'>" + round[i].playRoundCount +'회 : '+round[i].roundStart+'~'+round[i].roundEnd+ "</option>"
                        				optionss = "<option id='emptyOption' value='선택'>선택</option>"+options;
                        				callForSeat({"k":round[i].playRoundCount,"max":round[i].roundMax, "seat":round[i].roundSeats});
                        			}
                        			
                        			$("#roundSelect").css("display","block");
                        			$("#roundSelect").html(optionss);
                        			$("#seatInfo").css("display","block");
                        			
                        		}else{
                        			$("#roundSelect").css("display","none");
                        			$("#seatInfo").css("display","none");
                        			alert('보여드릴 회차정보가 없습니다!');
                        		}
                        		
                        	},error : function(){
                        		console.log('ajax통신실패');
                        	}
                        });
                    });
                });
                
                //회차 클릭 시 남은 좌석 보여주는 함수
                function callForSeat(result){
                	$('#roundSelect').on('click',function(){
                		if($('#roundSelect').val() == result.k){
                			$('#seats').text((result.max-result.seat)+'석');
                			$('#max').text('전체'+result.max+'석');
                		}
                	});
                }
                
                function updateWish(){
            		$.ajax({
            			url:"<%=contextPath%>/update.wishEx",
            			type:"get",
            			data:{"contentNo":<%=playObject.getContentNo()%>},
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
            			data:{"contentNo":<%=playObject.getContentNo()%>},
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

                <div id="plSeatNo">
                    날짜 : <span></span> <br>
                    <select name="playRound" id="roundSelect" required>
                        
                    </select>
                    
                    <div id="seatInfo">
                    <!--회차 선택 따라서 다르게 보여져야 할 부분-->
	                    남은 좌석 : <lable id='seats'></lable>&nbsp;/
	                    <label id='max'>전체</label>
                    </div>
                </div>
            </div>

            <div width="100%" align="center">
                <%if(loginUser != null){ %>
                	<button id="reservationBtn" class="btn btn-warning btn-lg" onclick="callForReservation();">예매하기</button>
                <%}else{ %>
                	<a class="btn btn-warning btn-lg" onclick="call();">예매하기</a>
                	<script>function call(){alert("로그인 후 이용해주세요!");}</script>
                <%} %>
            </div>

        </div>

        <div id="playDetailInfo">

            <div id="playDetailInfoHead">
                <a id="pDetail" class="btn btn-outline-warning btn-lg">상세정보</a>
                <a id="pCancel" class="btn btn-outline-warning btn-lg">환불/취소</a>
                <a id="pReview" class="btn btn-outline-warning btn-lg">리뷰</a>
            </div>

			<script>
			$(function(){
                selectReviews(1);
                
                
                $("#pDetail").click(function(){
        			$("#playDetailInfoBody1").css("display","block");
        			$("#playDetailInfoBody2").css("display","none");
        			$("#playDetailInfoBody3").css("display","none");
        		});
        		$("#pCancel").click(function(){
        			$("#playDetailInfoBody1").css("display","none");
        			$("#playDetailInfoBody2").css("display","block");
        			$("#playDetailInfoBody3").css("display","none");
        		});
        		$("#pReview").click(function(){
        			
        			$("#playDetailInfoBody1").css("display","none");
        			$("#playDetailInfoBody2").css("display","none");
        			$("#playDetailInfoBody3").css("display","block");
        		});
           });
         
             function selectReviews(cPage){
                $.ajax({
                   url : "<%=contextPath%>/review.inconcert",
                   type : "get",
                   data : {"contentNo" : <%=playObject.getContentNo()%>,
                           "currentPage" : cPage},
                   success : function(result){
                      
	                	if(result.list.length >= '1'){	//리뷰가 1개 이상 있을 때 
	                		   
	                      var reviews = "";
	                       for (var i in result.list){
	                          reviews += "<tr>"
	                                + "<th>" + result.list[i].reviewRnum + "</th>"
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
	                       
	                       var $firstBtn = "<button type='button' onclick='selectReviews(" + 1 + ");'>" + "&lt;&lt;" + "</button>";
	                       var $prevBtn = "<button type='button' onclick='selectReviews(" + ($currentPage - 1) + ");'>" + "&lt;" + "</button>";
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
	                      
	                      
	             	   }else{	//리뷰가 1개도 없을 때 
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
             
             function callForReservation(){
           		 $('#reservationBtn').click(function(){
           			if($('#roundSelect').val() == '선택' || $('#roundSelect').val() == null){
           				alert('회차를선택해주세요');
           		 	}else{
           		 		location.href="<%=contextPath%>/playPay.me?contentNo=<%=playObject.getContentNo()%>&playDay="+playDay+"&round="+$('#roundSelect').val();
           		 	}
           		 });
           	 
             }

			</script>

            <div id="playDetailInfoBody1">
                <p style="font-size: 35px;">&lt;상세정보&gt;</p>
                <div>
                    <%=playInfo %>
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
                            <p>장소 : <%=playObject.getPlace() %></p>
                        	</div>
                           
                        </div>
                        
                    </div>
                </div>

            </div>

            <div id="playDetailInfoBody2">
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

            <div id="playDetailInfoBody3">
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
                    <tbody id="tbodyArea" align="center">
                      
                    </tbody>
                </table>
        
                <div id="reviewPaging">
                </div>

            </div>

            <div align="right">
            </div>
        </div>


    </div>
</body>
</html>