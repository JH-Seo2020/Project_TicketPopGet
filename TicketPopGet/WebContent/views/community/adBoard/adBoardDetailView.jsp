<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.community.adBoard.model.vo.AdBoard" %>
<%
	AdBoard board = (AdBoard)request.getAttribute("board");
	String boardContent = (String)request.getAttribute("boardContent");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        #wrap_adDe{
            width: 1200px;
            height: auto;
            margin: auto;
        }
        /*홍보 게시판*/
        #adBoardHead{
            font-size: 45px;
            margin-top: 10px;
            margin-bottom: 30px;
            height: 7%;
        }
        /*글작성영역*/
        #adBoardBody{
            width: 100%;
            height: 50%;
        }
        #adBoardBodyTitle {
            width: 100%;
            padding: 20px;
            font-size: 30px;
            background-color: lightgray;
            margin-top: 10px;
        }
        #adBoardBodySub{
            width: 100%;
            font-size: 20px;
            background-color: lightgray;
            margin-top: 10px;
            text-align: right;
        }
        #adBoardBodySub>div{float: right; padding-right: 10px; }
        #adBoardBodyContent{
            width: 100%;
            padding: 20px;
            background-color: lightgray;
            margin-top: 10px;
        }
        #adBoardBodyBtns{
            float: right;
            margin: 20px;
        }
        
    </style>
</head>
<body>
	<%@ include file="/views/common/menubar.jsp" %>

	<div id="wrap_adDe">
        <div id="adBoardHead">
            <b>홍보 게시판</b>
        </div>
        <div id="adBoardBody">
            <div id="adBoardBodyTitle">
                <span><%=board.getBoardType() %></span>
                <span><%=board.getBoardTitle() %></span>
            </div>
            <div id="adBoardBodySub">
                작성일 : <%=board.getBoardDate() %> 조회수 : <%=board.getBoardCount() %> 
                <%if(loginUser != null & loginUser.getUserNo() != board.getUserNo()) {%>
                	<div><a href="" style="color: black !important; margin-left: 10px;" data-toggle="modal" data-target="#eventReport">신고</a></div>
            	<%} %>
            </div>
            <div id="adBoardBodyContent">
                <%=boardContent %>
            </div>
            <div id="adBoardBodyBtns">
                <%if (loginUser != null && loginUser.getUserNo() == board.getUserNo()){ %>
	                <a class="btn btn-warning" href="<%=contextPath%>/adboard.recall?boardNo=<%=board.getBoardNo()%>">수정하기</a>
	                <a class="btn btn-warning" data-toggle="modal" data-target="#deleteAdBoard">삭제하기</a>
				<%} %>
                <a class="btn btn-secondary" id="back">목록으로</a>
            </div>
        </div>
        
         <script>
	    	$(function(){
	    		$("#back").click(function(){
	    			if(document.referrer){
	    	    		history.back();
	    	    	}else{
	    	    		location.href="<%=contextPath%>/adboard.detail?currentPage=1";
	    	    	}
	    		});
	    	});
    	</script>
        

        <!--글 삭제 모달-->
        <div class="modal" tabindex="-1" id="deleteAdBoard">
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
                        <a type="button" class="btn btn-primary" href="<%=contextPath %>/adboard.delete?boardNo=<%=board.getBoardNo() %>">확인</a>
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