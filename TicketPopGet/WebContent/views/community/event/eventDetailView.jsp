<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.community.event.model.vo.Event" %>
<%
	Event evObject = (Event)request.getAttribute("evObject");
	String eventContent = (String)request.getAttribute("eventContent");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        #wrap_evDe{
            width: 1200px;
            height: auto;
            margin: auto;
        }
        /*댓글이벤트*/
        #eventHead{
            font-size: 45px;
            margin-top: 10px;
            margin-bottom: 30px;
            height: 7%;
        }
        /*글작성영역*/
        #eventBody{
            width: 100%;
            height: 50%;
        }
        #eventBodyTitle {
            width: 100%;
            padding: 20px;
            font-size: 30px;
            background-color: lightgray;
            margin-top: 10px;
        }
        #eventBodySub{
            width: 100%;
            font-size: 20px;
            background-color: lightgray;
            margin-top: 10px;
            text-align: right;
        }
        #eventBodySub>div{float: right; padding-right: 10px; }
        #eventBodyContent{
            width: 100%;
            padding: 20px;
            background-color: lightgray;
            margin-top: 10px;
        }
        #eventBodyBtns{
            float: right;
            margin: 20px;
        }
        /*댓글전체영역*/
        #eventReplyArea{
            margin-top: 5%;
            width: 100%;
        }
        table>tr{
            width: 30px;
            height: auto;
        }
        /*폼태그 : n개의댓글, 댓글입력창설정*/
        #eventReplyArea>div, form{
            width: 100%;
            font-size: 20px;
            margin-top: 10px;
            padding: 1%;
        }
        /*이벤트참여댓글내용, 댓글버튼부분*/
        #eventReplyContent, #eventReplyBtns{
            line-height: 30px;
            vertical-align: middle;
        }
        #eventReplyContent{
            width: 70%;
        }
        #eventReplyBtns{
            width: 20%;
            text-align: center;
        }
        /*이벤트참여댓글 버튼부분*/
        #eventReplyBtns>a{
            text-decoration: none;
            color: black !important;
        }
        /*paging 버튼*/
        #eventReplyPaging{
            text-align: center;
            margin-top: 30px;
        }
        #eventReplyPaging button{
            width: 40px;
            height: 40px;
            border: none;
            color: white;
            background-color: #ffb300;
            border-radius: 5px;
        }
    </style>
</head>
<body>
	<%@ include file="/views/common/menubar.jsp" %>

	<div id="wrap_evDe">
        <div id="eventHead">
            <b>댓글 이벤트</b>
        </div>
        <div id="eventBody">
            <div id="eventBodyTitle">
                <span><%=evObject.getEventType() %></span>
                <span><%=evObject.getEventTitle() %></span>
            </div>
            <div id="eventBodySub">
                작성일 : <%=evObject.getEventDate() %> 조회수 : <%=evObject.getEventCount() %>
            </div>
            <div id="eventBodyContent">
                <%=eventContent %>
            </div>
            <div id="eventBodyBtns">
                <a class="btn btn-secondary" id="back">목록으로</a>
            </div>
        </div>
        
        <script>
	    	$(function(){
	    		$("#back").click(function(){
	    			if(document.referrer){
	    	    		history.back();
	    	    	}else{
	    	    		location.href="<%=contextPath%>/event.detail?currentPage=1";
	    	    	}
	    		});
	    	});
    	</script>
        
        
        <div id="eventReplyArea">
            <div><b>댓글 작성에 참여해보세요!🖋</b></div>
            <form class="input-group mb-3" >
                <input id="commentContent" class="form-control" type="text" placeholder="댓글을 입력해주세요" required>
                <div class="input-group-append" id='divForUpdate'>
                    <button id='insertBtn' type="button" class="btn btn-secondary" onclick="addComment();">등록하기</button>
                </div>
            </form>
            <table class="table table-striped">
                <tbody id='tbodyArea'>
                
                </tbody>
              </table>
              
              <div id="eventReplyPaging">
                
            </div>
        </div>

		<script>
			$(function(){
				selectCommentList(1);
				var $like;
			});
			
			//1. 댓글 리스트 조회용 ajax 
			function selectCommentList(cPage){
				$.ajax({
					url : "<%=request.getContextPath()%>/comment.co",
					type : "get",
					data : {"eventNo" : <%=evObject.getEventNo()%>,
						"currentPage" : cPage},
					success : function(result){
						if(result.list.length >= '1'){	//댓글이 1개 이상 있을 때
							
							var comments = "";
							var commentBtns = "";
		                    
							for(var i in result.list){
									
								//수정,삭제,신고, 추천버튼 조건처리 (내 댓글이면 수정삭제, 남의 댓글이면 신고 추천)
								$commentNo = result.list[i].commentNo;
								
			                    $update = "<a class='btn' onclick='callForUpdate("+$commentNo+");'>수정💬</a>";
			                    $delete = "<a class='btn' onclick='callForDelete("+$commentNo+");' data-toggle='modal' data-target='#deleteReviewReply'>삭제❌</a>";
			                    $report = "<a class='btn' onclick='callForReport("+$commentNo+");' data-toggle='modal' data-target='#eventReport'>신고🚨</a>";
			                    $like = "<span id='thumbsup'><a class='btn' onclick='call("+$commentNo+");'>추천💛</a><lable id='good'></lable></span>";	
			                    
								<%if(loginUser != null){%>
									
									if(result.list[i].userNo == '<%=loginUser.getUserId()%>'){
			                    		commentBtns = $update + "&nbsp;&nbsp;"+$delete;
									}else{
										commentBtns = $report +"&nbsp;&nbsp;"+ $like;
									}
									
			                    <%}else{%>
			                    	commentBtns = "";
			                    <%}%>
								
								comments += "<tr>"
										 + "<td id='eventReplyHead'><p><b>" + result.list[i].userNo + "</b></p>"
										 + "<p style='font-size: 13px;'>" + result.list[i].commentDate + "</p></td>"
										 + "<td id='eventReplyContent'>" + result.list[i].commentCont + "</td>"
										 + "<td><input type='hidden' value="+result.list[i].commentNo +"></td>" 
										 + "<td id='eventReplyBtns'>"+commentBtns+"</td></tr>";
								
								
								<%if(loginUser != null){%>
									callForUserGood($commentNo);
								<%}%>
								countLike($commentNo);
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
	                          //$btns += "&nbsp;"+<a href="+'<%=contextPath%>/comment.co?currentPage='+">"+$p+"</a>"+"&nbsp;";
	                       	  if($p != $currentPage){
	                          	$btns += "<button class='cc' type='button' onclick='selectCommentList(" + $p + ");'>" + $p + "</button>"+"&nbsp;";	                       		  
	                       	  }else{
	                       		$btns += "<button disabled style='color:black'>" + $p + "</button>"+"&nbsp;";
	                       	  }   
	                       
	                       }
							
	                       
	                       
							var $firstBtn = "<button type='button' onclick='selectCommentList(" + 1 + ");'>" + "&lt;&lt;" + "</button>";
		                    var $prevBtn = "<button type='button' onclick='selectCommentList(" + ($currentPage - 1) + ");'>" + "&lt;" + "</button>";
		                    var $nextBtn = "<button type='button' onclick='selectCommentList(" + ($currentPage + 1) + ");'>" + "&gt;" + "</button>";
		                    var $endBtn = "<button type='button' onclick='selectCommentList(" + $maxPage + ");'>" + "&gt;&gt;" + "</button>";
		                       
		                    var $buttons = $firstBtn +"&nbsp;"+ $prevBtn +"&nbsp;"+ $btns +"&nbsp;"+ $nextBtn +"&nbsp;"+ $endBtn ;
		                    var $buttons0 = $firstBtn +"&nbsp;"+ $btns +"&nbsp;"+ $endBtn ;
		                    var $buttons1 = $firstBtn + "&nbsp;"+ $btns +"&nbsp;"+ $nextBtn +"&nbsp;"+ $endBtn ;
		                    var $buttons2 = $firstBtn +"&nbsp;"+ $prevBtn +"&nbsp;"+ $btns +"&nbsp;" + $endBtn ;
		                    
		                    $("#tbodyArea").html(comments);
		                    
		                    //버튼조건처리.. 댓글 등록 후 기능 다시 확인해볼것 
		                    if(cPage == "1" && cPage == $maxPage){
		                    	$("#eventReplyPaging").html($buttons0);
		                    }else if(cPage == "1" && cPage != $maxPage) {
		                    	$("#eventReplyPaging").html($buttons1);
                            }else if(cPage != "1" && cPage != $maxPage){
                            	$("#eventReplyPaging").html($buttons);
                            }else if (cPage != "1" && cPage == $maxPage){
                            	$("#eventReplyPaging").html($buttons2);
                            }
		                    
		                    
						}else{	//댓글이 1개도 없을 때
							$("#tbodyArea").html('보여드릴 댓글이 없습니다.');
						}
						
					},
					error : function(){
						console.log("ajax 통신실패");
					}
				});
			}
			
			
			//2. 댓글 작성용 ajax
			function addComment(){
				console.log($('#commentContent').val());
				var user;
                <%if(loginUser != null){%>
                	user = "<%=loginUser.getUserId()%>";
				
					$.ajax({
						url : "<%=request.getContextPath()%>/comment.insert",
						type : "post",
						data : {"commentContent" : $('#commentContent').val(),
							"eno" : <%=evObject.getEventNo()%>},	//회원번호는 서블릿에서 넘긴다
						success : function(result){
							
							if(result>0){
								selectCommentList(1);
								$('#commentContent').val("");
							}else{
								console.log('댓글작성실패');
							}
							
						}, 
						error : function(){
							console.log('통신실패');
						}
					});
				
				<%}else{%>
            		alert("로그인 후 이용해주세요!");
            	<%}%>
				
			}
			
			//3. 댓글 수정 시 댓글내용 불러올 ajax
			function callForUpdate(commentNo){	
				var cno = commentNo;
				$.ajax({
					url : "<%=contextPath%>/comment.forUpdate",
					type: "get",
					data : {"commentNo" : cno},
					success : function(result){
						$('#commentContent').val(result.commentCont);
						$('#divForUpdate').html("<a id='upBtn' type='button' class='btn btn-warning'>수정하기</a>");
						$('#upBtn').click(function(){
							updateComment({commentNo : result.commentNo , commentCont : $('#commentContent').val()});
						});
						
						
					},error : function(){
						console.log('통신실패');
					}
				});
				
			}
			
			function updateComment(result){
				console.log(result.commentCont);
				//수정하기 클릭 시 업데이트할 ajax
				$.ajax({
					url : "<%=request.getContextPath()%>/comment.update",
					type : "post",
					data : {"commentContent" : result.commentCont,
						"commentNo" : result.commentNo},	
					success : function(update){
						
						if(update>0){
							$('#divForUpdate').html("<button id='insertBtn' type='button' class='btn btn-secondary' onclick='addComment();'>등록하기</button>");
							selectCommentList(1);
							$('#commentContent').val("");
						}else{
							console.log('댓글수정실패');
						}
						
					}, 
					error : function(){
						console.log('수정시통신실패');
					}
				});
				
			}
			
			//4. 댓글삭제 시 댓글번호 전달용 함수, 동기식
			function callForDelete(commentNo){	
				$("#deleteCheck").click(function(){
					location.href="<%=contextPath%>/comment.delete?commentNo="+commentNo+"&eventNo=<%=evObject.getEventNo()%>";
				});
			}
			
			//5. 댓글신고 시 신고내용 불러올 ajax, 신고등록은 동기식
			function callForReport(commentNo){	
				$.ajax({
						url : "<%=contextPath%>/comment.forUpdate",
						type : "get",
						data : {"commentNo" : commentNo},	
						success : function(result){
							
							console.log(result);
							$('#troubleMaker').val(result.userNo);
							$('#commentNo').val(result.commentNo);
							$('#troubleMakerId').text(result.userId);
							$('#eventNo').val(result.eventNo);
							$('#reportForm').attr('action','<%=contextPath%>/comment.report');
							
						}, 
						error : function(){
							console.log('통신실패');
						}
					});
			}
			
			//6. 댓글추천함수 (로딩직후 실행될)
			function countLike(commentNo){
				$.ajax({
					url : "<%=contextPath%>/view.like",
					type : "get",
					data : {"commentNo" : commentNo},
					success : function(result){
						
						<%if(loginUser != null){%>
							$('#good').text(result);
						<%}%>
						
					}, error : function(){
						console.log('통신실패');
					}
				});
			}
			
			//7. 유저추천버튼판별함수
			<%if(loginUser != null){%>
			function callForUserGood(commentNo){
				$.ajax({
					url : "<%=contextPath%>/view.userlike",
					type : "get",
					data : {"commentNo" : commentNo},
					success : function(result){
						console.log(result);
						if(result>0){
							$('#thumbsup').html("<a class='btn' onclick='cancle("+commentNo+");'>추천해제</a><lable id='good'></lable>");
							countLike(commentNo);
						}else{
							$('#thumbsup').html("<a class='btn' onclick='call("+commentNo+");'>추천💛</a><lable id='good'></lable>");
							countLike(commentNo);
						}
						
					}, error : function(){
						console.log('통신실패');
					}
				});
			}
			
			//8. 추천 insert
			function call(commentNo){
				$.ajax({
					url : "<%=contextPath%>/comment.updatelike",
					type : "get",
					data : {"commentNo" : commentNo,
						"eventNo" : <%=evObject.getEventNo()%>},
					success : function(result){
						callForUserGood(commentNo);
					}, error : function(){
						console.log('통신실패');
					}
				});
			}
			
			//9. 추천 delete
			function cancle(commentNo){
				$.ajax({
					url : "<%=contextPath%>/comment.deletelike",
					type : "get",
					data : {"commentNo" : commentNo,
						"eventNo" : <%=evObject.getEventNo()%>},
					success : function(result){
						callForUserGood(commentNo);
						
					}, error : function(){
						console.log('통신실패');
					}
				});
			}
			
			<%}%>
			
		</script>





        <!--댓글 삭제 모달, 일단 접어놓음-->
        <div class="modal" tabindex="-1" id="deleteReviewReply">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">삭제하기</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <p>
                            정말 삭제하시겠습니까?
                        </p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
                        <button id="deleteCheck" type="button" class="btn btn-primary" >확인</button>
                    </div>
                </div>
            </div>
        </div>





        <!--신고 등록 모달, 이것도 접어놓겟음-->
        <div class="modal" tabindex="-1" id="eventReport">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">신고</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                        <form id='reportForm' method="POST" action="">
                        <%if(loginUser != null){ %>
		                	<input id="" name="reporter" type="hidden" value="<%=loginUser.getUserNo()%>">
		                <%} %>
		                	<input id="troubleMaker" name="troubleMaker" type="hidden" value="">
		                	<input id="" name="reportCate" type="hidden" value="이벤트댓글">
		                	<input id="commentNo" name="commentNo" type="hidden" value="">
		                	<input id="eventNo" name="eventNo" type="hidden" value="">
		                	
                            <div class="modal-body">
                                <p>
                                    <b>신고 사유</b>
                                </p>
                                <select required name="reportType" class="form-control">
                                    <option value="">선택</option>
		                            <option value="욕설">욕설</option>
		                            <option value="음란">음란</option>
		                            <option value="광고">광고</option>
		                            <option value="비하">비하</option>
		                            <option value="기타">기타</option>
                                </select>
                            </div>
                            <div class="modal-body">
                                <p>
                                    <b>신고 대상 아이디 </b>
                                </p>
                                <p id="troubleMakerId"></p>
                            </div>
                            <div class="modal-body">
                                <p>
                                    <b>구체적인 신고 사유 </b>
                                </p>
                                <input type="text" name="reportContent" class="form-control" placeholder="이유를입력하세요" required>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
                                <button type="submit" class="btn btn-primary" id='reportCheck'>확인</button>
                            </div>

                        </form>
	                </div>
	            </div>
	        </div>
	    </div>



</body>
</html>