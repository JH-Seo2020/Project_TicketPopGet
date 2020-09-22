<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        #wrap_reviewDe{
            width: 1200px;
            margin: auto;
        }
        /*후기*/
        #reviewHead{
            font-size: 45px;
            margin-top: 10px;
            margin-bottom: 30px;
            height: 7%;
        }
        /*글작성영역*/
        #reviewBody{
            width: 100%;
            height: 50%;
        }
        #reviewBodyTitle {
            width: 100%;
            height: 10%;
            padding: 20px;
            font-size: 30px;
            background-color: lightgray;
            margin-top: 10px;
        }
        #reviewBodySub{
            width: 100%;
            height: 10%;
            padding: 20px;
            font-size: 20px;
            background-color: lightgray;
            margin-top: 10px;
        }
        #reviewBodySub>span{display: inline-block; float: right; padding: 10px;}
        #reviewBodyContent{
            width: 100%;
            padding: 20px;
            background-color: lightgray;
            margin-top: 10px;
        }
        #reviewBodyBtns{
            float: right;
            margin: 20px;
        }
        /*댓글전체영역*/
        #reviewReplyArea{
            margin-top: 5%;
            width: 100%;
        }
        /*폼태그 : n개의댓글, 댓글입력창설정*/
        #reviewReplyArea>div, form{
            width: 100%;
            font-size: 20px;
            margin-top: 10px;
            padding: 1%;
        }
        /*리뷰댓글내용, 댓글버튼부분*/
        #reveiwReplyContent, #reviewReplyBtns{
            line-height: 30px;
            vertical-align: middle;
        }
        #reveiwReplyContent{
            width: 80%;
            padding-left: 35px;
        }
        /*리뷰댓글 버튼부분*/
        #reviewReplyBtns>a{
            text-decoration: none;
            color: black !important;
        }
        /*paging 버튼*/
        #ReviewReplyPaging{
            text-align: center;
            margin-top: 30px;
        }
        #ReviewReplyPaging button{
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

	<div id="wrap_reviewDe">
        <div id="reviewHead">
            <b>후기</b>
        </div>
        <div id="reviewBody">
            <div id="reviewBodyTitle">
                <span>연극</span>
                <span>테세우스의 모험</span>
            </div>
            <div id="reviewBodySub">
                별점 : ★★★★★ 
                <span>
                	<a href="" style="color: black !important;" data-toggle="modal" data-target="#ReviewReport">신고</a>
                </span>
                <span>작성일 : 2020-02-02 조회수 : 100</span>
            </div>
            <div id="reviewBodyContent">
                9월 30일날  종로에서 이화동 연극회가 올린 '테세우스의 모험'을 보았습니다.<br>
                아주 재미있었습니다.<br>    
                결국 테세우스가 미노타우로스를 물리칠 수 있었던 건 순전히 장비빨이라는 생각이 드는군요.<br>
                신들이 도와주지 않았다면 어림도 없었을 일입니다.<br>
                그러니까 여러분, 주변사람들에게 잘 구걸해서 도움을 잘 받읍시다.<br> 
                저는 그런 교훈을 얻었습니다.<br>
                시간이 난다면 다음에 또 보고싶네요.<br>
            </div>
            <div id="reviewBodyBtns">
                <!--내가 쓴 글일 경우 보여질 버튼-->
                <a class="btn btn-warning" href="">수정</a>
                <a class="btn btn-warning" href="" data-toggle="modal" data-target="#deleteReview">삭제</a>

                <a class="btn btn-secondary" href="">목록으로</a>
            </div>
        </div>
        <div id="reviewReplyArea">
            <div><b>n개의 댓글</b></div>
            <form class="input-group mb-3" action="" method="POST">
                <input name="" class="form-control" type="text" placeholder="댓글을 입력해주세요" required>
                <div class="input-group-append">
                    <button type="submit" class="btn btn-secondary" >등록하기</button>
                </div>
            </form>
            <table class="table table-striped">
                <tbody>
                  <tr>
                    <td>
                        <p><b>greek***</b></p>
                        <p>2020-09-02</p>
                    </td>
                    <td id="reveiwReplyContent">감상이 비슷하시네요. 잘 읽고 갑니다.</td>
                    <td id="reviewReplyBtns">
                        <!--본인일 경우만 보임-->
                        <a href="">수정</a>
                        <a href="" data-toggle="modal" data-target="#deleteReviewReply">삭제</a>

                        <a href="" data-toggle="modal" data-target="#ReviewReport">신고</a>
                    </td>
                  </tr>
                  <tr>
                    <td>
                        <p><b>greek***</b></p>
                        <p>2020-09-02</p>
                    </td>
                    <td id="reveiwReplyContent">감상이 비슷하시네요. 잘 읽고 갑니다.</td>
                    <td id="reviewReplyBtns">
                        <!--본인일 경우만 보임-->
                        <a href="">수정</a>
                        <a href="" data-toggle="modal" data-target="#deleteReviewReply">삭제</a>

                        <a href="" data-toggle="modal" data-target="#ReviewReport">신고</a>
                    </td>
                  </tr>
                  <tr>
                    <td>
                        <p><b>greek***</b></p>
                        <p>2020-09-02</p>
                    </td>
                    <td id="reveiwReplyContent">몇자까지들어가나 어떻게보이나 테스트중몇자까지들어가나 어떻게보이나 테스트중몇자까지들어가나 어떻게보이나 테스트중몇자까지들어가나 어떻게보이나 테스트중몇자까지들어가나 어떻게보이나 테스트중몇자까지들어가나 어떻게보이나 테스트중몇자까지들어가나 어떻게보이나 테스트중몇자까지들어가나 어떻게보이나 테스트중몇자까지들어가나 어떻게보이나 테스트중몇자까지들어가나 어떻게보이나 테스트중몇자까지들어가나 어떻게보이나 테스트중몇자까지들어가나 어떻게보이나 테스트중몇자까지들어가나 어떻게보이나 테스트중몇자까지들어가나 어떻게보이나 테스트중몇자까지들어가나 어떻게보이나 테스트중몇자까지들어가나 어떻게보이나 테스트중</td>
                    <td id="reviewReplyBtns">
                        <!--본인일 경우만 보임-->
                        <a href="">수정</a>
                        <a href="" data-toggle="modal" data-target="#deleteReviewReply">삭제</a>

                        <a href="" data-toggle="modal" data-target="#ReviewReport">신고</a>
                    </td>
                  </tr>
                  
                </tbody>
              </table>

              <div id="ReviewReplyPaging">
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

        <!--글 삭제 모달-->
        <div class="modal" tabindex="-1" id="deleteReview">
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
        <div class="modal" tabindex="-1" id="ReviewReport">
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