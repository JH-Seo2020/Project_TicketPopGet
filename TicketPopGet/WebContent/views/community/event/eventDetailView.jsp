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
            <form class="input-group mb-3" action="" method="POST">
                <input name="" class="form-control" type="text" placeholder="댓글을 입력해주세요" required>
                <div class="input-group-append">
                    <button type="submit" class="btn btn-secondary" >등록하기</button>
                </div>
            </form>
            <table class="table table-striped">
                <tbody id='tbodyArea'>
                
                </tbody>
              </table>
              
              <div id="eventReplyPaging">
                <button>&lt;&lt;</button>
                <button>&lt;</button>
                <button>1</button>
                <button>2</button>
                <button>3</button>
                <button>4</button>
                <button>5</button>
                <button>&gt;</button>
                <button>&gt;&gt;</button>
            </div>
        </div>

		<script>
			$(function(){
				selectCommentList(1);
			});
			
			//댓글 리스트 조회용 ajax 
			function selectCommentList(cPage){
				$.ajax({
					url : "<%=contextPath%>/comment.co",
					type : "get",
					data : {"eventNo" : <%=evObject.getEventNo()%>,
						"currentPage" : cPage},
					success : function(result){
						
						if(result.list.length >= '1'){	//댓글이 1개 이상 있을 때
							
							var comments = "";
							for(var i in result.list){
								comments += "<tr>"
										 + "<td id='eventReplyHead'><p><b>" + result.list[i].userNo + "</b></p>"
										 + "<p style='font-size: 13px;'>" + result.list[i].commentDate + "</p></td>"
										 + "<td id='eventReplyContent'>" + result.list[i].commentCont + "</td>"
										 + "<td id='eventReplyBtns'></td></tr>"
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
	                          //$btns += "<a href="+'<%=contextPath%>/comment.co?currentPage='+">"+$p+"</a>"+"&nbsp;";
	                          $btns += "<button type='button' onclick='selectCommentList(" + $p + ");'>" + $p + "</button>";
	                       }
							
	                       //버튼조건처리덜됨!
							var $firstBtn = "<button type='button' onclick='selectCommentList(" + 1 + ");'>" + "&lt;&lt;" + "</button>";
		                    var $prevBtn = "<button type='button' onclick='selectCommentList(" + ($currentPage - 1) + ");'>" + "&lt;" + "</button>";
		                    var $nextBtn = "<button type='button' onclick='selectCommentList(" + ($currentPage + 1) + ");'>" + "&gt;" + "</button>";
		                    var $endBtn = "<button type='button' onclick='selectCommentList(" + $maxPage + ");'>" + "&gt;&gt;" + "</button>";
		                       
		                    var $bottons = $firstBtn +"&nbsp;"+ $prevBtn +"&nbsp;"+ $btns +"&nbsp;"+ $nextBtn +"&nbsp;"+ $endBtn ;
		                      
		                    $("#tbodyArea").html(comments);
		                    $("#eventReplyPaging").html($bottons);
							
		                    
		                    
		                    
						}else{	//리뷰가 1개도 없을 때
							$("#tbodyArea").html('보여드릴 댓글이 없습니다.');
						}
						
					},
					error : function(){
						console.log("ajax 통신실패");
					}
				});
			}
		</script>





        <!--댓글 삭제 모달-->
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
                        <a type="button" class="btn btn-primary" href="">확인</a>
                    </div>
                </div>
            </div>
        </div>

        <!--신고 등록 모달-->
        <div class="modal" tabindex="-1" id="eventReport">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">신고</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                        <form method="POST" action="">
                            <div class="modal-body">
                                <p>
                                    <b>신고 사유</b>
                                </p>
                                <select required name="" class="form-control">
                                    <option value="">선택</option>
                                    <option value="블라블라">블라블라</option>
                                    <option value="블라블라">블라블라</option>
                                    <option value="블라블라">블라블라</option>
                                    <option value="블라블라">블라블라</option>
                                </select>
                            </div>
                            <div class="modal-body">
                                <p>
                                    <b>신고 대상 아이디 </b>
                                </p>
                                <p>grekk***</p>
                            </div>
                            <div class="modal-body">
                                <p>
                                    <b>구체적인 신고 사유 </b>
                                </p>
                                <input type="text" name="" class="form-control" placeholder="이유를입력하세요" required>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
                                <button type="submit" class="btn btn-primary" onclick="">확인</button>
                            </div>

                        </form>
	                </div>
	            </div>
	        </div>
	    </div>



    </div>

</body>
</html>