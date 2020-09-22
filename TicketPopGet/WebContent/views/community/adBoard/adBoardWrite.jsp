<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        #wrap_adWr{
            width: 1200px;
            height: 1000px;
            margin: auto;
            box-sizing: border-box;
        }
        #adBoardHead{
            font-size: 45px;
            margin-top: 10px;
            margin-bottom: 30px;
            height: 7%;
        }
        form{width: 100%; height: 70%;}
        table{width: 100%; height: 100%;}
        select{width: 100%; height: 50%;}
        input{width: 100%; height: 50%;}
        textarea{width: 100%; height: 100%; resize: none;}
        #adWriteBtns{height: 20%; }
        #adWriteBtns>.btn{
            margin-right: 20px;
        }
</style>
</head>
<body>
	<%@ include file="/views/common/menubar.jsp" %>

	<div id="wrap_adWr">
        <div id="adBoardHead">
            <b>홍보 게시판 작성</b>
        </div>
        <form action="" method="POST">
            <table class="table table-borderless">
                <tr style="height: 10%;">
                    <td style="width: 15%;">
                        <select name="" required class="form-control">
                            <option value="">분류</option>
                            <option value="콘서트">콘서트</option>
                            <option value="연극">연극</option>
                            <option value="전시">전시</option>
                        </select>
                    </td>
                    <td style="width: 15%;">
                        <select name="" required class="form-control">
                            <option value="">지역</option>
                            <option value="서울경기권">서울경기권</option>
                            <option value="강원충청권">강원충청권</option>
                            <option value="전라권">전라권</option>
                            <option value="경상제주권">경상제주권</option>
                        </select>
                    </td>
                    <td style="width: 70%;">
                        <input class="form-control" type="text" name="" placeholder="제목을입력하세요" required>
                    </td>
                </tr>
                <tr>
                    <td colspan="3">
                        <!--textarea 일단 넣고 추후 에디터 추가 -->
                        <textarea style="border: 1px solid lightgray;" name="" required>
                        </textarea>
                    </td>
                </tr>
            </table>
            <div id="adWriteBtns" align="right">
                <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#adBoardEnroll">이전으로</button>
                <button type="submit" class="btn btn-warning" onclick="">등록하기</button>
            </div>
        </form>
        
        <!--모달-->
        <div class="modal" tabindex="-1" id="adBoardEnroll">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">이전으로</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <p>
                            정말 이전으로 돌아가시겠습니까? <br>
                            기존에 쓰시던 글은 모두 삭제됩니다.
                        </p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
                        <a type="button" class="btn btn-primary" href="">확인</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>