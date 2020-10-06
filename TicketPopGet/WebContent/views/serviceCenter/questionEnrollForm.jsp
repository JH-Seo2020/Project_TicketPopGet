<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .noticetitle{
        margin:auto;
        margin-left: 40px;
    }
    table{
        margin-left:40px ;
    }
    #topMenu {
            height: 50px;
            width: 900px;
    }

    .servicemenu {
            list-style: none;
            background-color: white;
            float: left;
            line-height: 50px;
            text-align: center;
    }
    #line{
        color: #ffb300;
    }
    #topMenu .menuLink {
            text-decoration:none;
            color: #ffb300;
            display: block;
            width: 400px;
            font-size: 20px;
            font-weight: bold;
            font-family: "Trebuchet MS";
    }
    #topMenu .menuLink:hover {
            color: white;
            background-color: #ffb300;
    }
    .btnRegister{
    border: none;
    border-radius: 1.5rem;
    padding: 0.5%;
    background: #ffb300;
    color: #fff;
    font-weight: 600;
    cursor: pointer;
    }

    input, textarea{ width: 600px;}
    .area{float: left;}
    #leftmenu{ margin-left:11%;}
 	#contentArea{margin-left:4%;}

</style>
</head>
<body>
<!-- 상단 메뉴바  -->
<%@ include file="/views/common/menubar.jsp"%>
    <div class="area" id="leftmenu">
	<!-- 왼쪽 메뉴바 -->
	<%@ include file="/views/serviceCenter/serviceMenubar.jsp"%>
    </div>
    <form action="<%=request.getContextPath()%>/insert.qo" id="questioninsert" method="post" enctype="multipart/form-data">
	    <input type="hidden" name="questionUser" value="<%=loginUser.getUserNo()%>">
	    <div class="area" id="contentArea">
	        <div id="noticeDiv">
	            <h2 class="noticetitle"><b>1 : 1문의</b></h2>
	            <nav id="topMenu">
	                <ul class="servicemenu">
	                    <li class="servicemenu"><a class="menuLink" href="">문의내역</a></li>
	                    <li class="servicemenu"><a class="menuLink" href="<%= request.getContextPath() %>/enrollForm.qo">문의하기</a></li>
	                </ul>
	            </nav>
	        </div>
	        <div class="table table-responsive">
	            
                <table class="table" style="width: 800px;">
                    <tr>
                        <th width="80">문의유형</th>
                        <td width="500">
                            <select name="questionType">
                                <option value="회원">회원</option>
                                <option value="결제">결제</option>
                                <option value="예매/취소">예매/취소</option>
                                <option value="시스템">시스템</option>
                                <option value="기타">기타</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>제목</th>
                        <td><input type="text" name="questionTitle" required></td>
                    </tr>
                                
                    <tr>
                        <th>문의내용</th>
                        <td><textarea name="questionContent" rows="10" style="resize: none;"></textarea></td>
                    </tr>

                    <tr>
                        <th>첨부파일</th>
                        <td><input type="file" name="upfile"></td>
                    </tr>
                </table>
	        </div>
            <div align="center">
                <button type="submit" class="btnRegister">작성하기</button>
                <button type="reset" class="btnRegister">취소하기</button>
            </div> <br><br>
    	</div>
    </form>
</body>
</html>