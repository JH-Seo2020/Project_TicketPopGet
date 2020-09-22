<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                <span>연극</span>
                <span>이화동 연극회의 '크리스마스의 악몽' 연극에 초대합니다.</span>
            </div>
            <div id="adBoardBodySub">
                작성일 : 2020-02-02 조회수 : 100 
                <div><a href="" style="color: black !important; margin-left: 10px;" data-toggle="modal" data-target="#eventReport">신고</a></div>
            </div>
            <div id="adBoardBodyContent">
                안녕하세요<br>
                이화동 연극회입니다. <br>
                이번에 저희가 크리스마스 이틀 전에 연극 '크리스마스의 악몽'을 올리게 되었습니다. <br>
                규모는 작지만 많이들 와 주셨으면 좋겠습니다. <br>
                자세한 사항은 아래 소개글을 참고해주세요. <br>
                감사합니다. <br>
                <br>
                <br>
                <br>
                에디터 어느 세월에 넣지 
                <br>
                내용 보여주는 부분은 height 지정 안했습니다 크기따라 보이게.. 해놨어요
            </div>
            <div id="adBoardBodyBtns">
                <!--글 작성자일 경우에만 보임 -->
                <a class="btn btn-warning" href="">수정하기</a>
                <a class="btn btn-warning" href="" data-toggle="modal" data-target="#deleteAdBoard">삭제하기</a>

                <a class="btn btn-secondary" href="">목록으로</a>
            </div>
        </div>
        

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