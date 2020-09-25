<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList" import="com.kh.admin.adminMember.model.vo.Page" import="com.kh.admin.adminNotice.model.vo.Notice"%>
<%
	Page p = (Page)request.getAttribute("p");
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .wrap{
        width: 1200px;
        height: 850px;
        margin: auto;
        /* border: solid; */
        text-align: center;
    }
    
    .selectTable{
        width: 100%;
        /* height: 600px; */
        }
    
    .returnMainPage{
        width: 100px;
        height: 40px;
        background: #98c3ff;
        border: none;
        border-radius: 10px;
        float: right;
    }
    .createBtn{
        width: 140px;
        height: 50px;
        background: #98c3ff;
        border: none;
        border-radius: 10px;
        float: left;
    }

    #noticeTable th{background: #6495ed;}
    #noticeContent{width: 100%; height: 555px; border: 2px solid #6495ed;;}
    #noticeTable input, #noticeTable select{width: 100%;}
</style>
</head>
<body>
	<%@ include file = "../adminCommon/adminMenubar.jsp" %>
    <div class="wrap" align="center">
        <button class="createBtn" data-toggle="modal" data-target="#myModal">공지사항 작성</button>
        <button class="returnMainPage">초기화면</button>
    <div align="center">
        <h1 style="width: 500px;">공지사항</h1>
    </div>
        
    <table class="selectTable" border="1">

        <thead style="background: #6495ed;">
            <tr style="height: 50px;">
                <th width="70px">등록번호</th>
                <th width="">공지사항제목</th>
                <th width="100px">작성자</th>
                <th width="150px">작성일</th>
                <th width="150px">
                    <select name="type">
                        <option value="전체">전체</option>
                        <option value="시스템">시스템</option>
                        <option value="변경/취소">변경/취소</option>
                        <option value="기타">기타</option>
                    </select>
                </th>
                <th width="200px">관리</th>
            </tr>
        </thead>

        <tbody>
        <%for(Notice n : list) { %>
            <tr style="height: 50px;">
                <td><%=n.getNoticeNo() %></td>
                <td><%=n.getNoticeTitle() %></td>
                <td><%=n.getAdminId() %></td>
                <td><%=n.getNoticeDate() %></td>
                <td><%=n.getNoticeType() %></td>
                <td>
                    <button class="btn btn-primary Noticelist" data-toggle="modal" data-target="#myModal2">조회/수정</button>
                    <button class="btn btn-danger">삭제</button>
                </td>

            </tr>
        <%} %>    
        </tbody>

    </table>
    <form action="<%=request.getContextPath()%>/searchList.adno" style="float: right;">
    	<input type="hidden" name="currentPage" value="1">
        <input type="text" name="selectKeyword">
        <button>검색</button>
    </form>
    <br><br>
    <div align="center">
		<%if(p.getCurrentPage() != p.getStartPage()) {%>
        	<button onclick="location.href='<%=request.getContextPath()%>/list.adno?currentPage=1'">&lt;&lt;</button>
       	 	<button onclick="location.href='<%=request.getContextPath()%>/list.adno?currentPage=<%=p.getCurrentPage() - 1%>'">&lt;</button>
        <%} %>
        <%for(int i=p.getStartPage(); i<=p.getEndPage(); i++) {%>
        	<%if(i != p.getCurrentPage()){ %>
        		<button onclick="location.href='<%=request.getContextPath()%>/list.adno?currentPage=<%=i%>'"><%=i%></button>
        	<%}else{ %>
        		<button disabled><%=i%></button>
        	<%} %>
       <%} %>
        <%if(p.getCurrentPage() != p.getEndPage()) { %>
        	<button onclick="location.href='<%=request.getContextPath()%>/list.adno?currentPage=<%=p.getCurrentPage() + 1%>'">&gt;</button>
        	<button onclick="location.href='<%=request.getContextPath()%>/list.adno?currentPage=<%=p.getMaxPage()%>'">&gt;&gt;</button>   
        <%} %>  
        
    </div>

    </div>

          <!-- 작성하기모달 -->
  <!-- The Modal -->
  <div class="modal" id="myModal">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <form action="" method="POST">
        <!-- Modal Header -->
            <div class="modal-header">
                <div class="" align="center">   
                    <table border="1" style="width: 100%;" id="noticeTable">
                        <tr>
                            <th width="150">제목</th>
                            <td colspan="3">
                                <input type="text" name="">
                            </td>
                        </tr>
                        <tr>
                            <th width="150px">작성자</th>
                            <td width="250">admin</td>
                            <th width="150px">작성일</th>
                            <td width="250">
                                SYSDATE
                            </td>
                        </tr>
                        <tr>
                            <th width="150px">분류</th>
                            <td width="250">
                                <select name="type">
                                    <option value="전체">전체</option>
                                    <option value="시스템">시스템</option>
                                    <option value="변경/취소">변경/취소</option>
                                    <option value="기타">기타</option>
                                </select>
                            </td>
                            <th width="150px">관리</th>
                            <td width="250" align="right">
                                <button class="btn btn-primary" style="height: 35px;" >등록</button>
                            </td>
                        </tr>
                    </table>
                        <textarea name="noticeContent" id="noticeContent" style="resize: none;">작성하셔</textarea>
                </div>
            </div> 
        </form>
            <!-- Modal footer -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
                </div>
      </div>
    </div>
  </div>
        <!-- 수정하기 모달 -->
  <!-- The Modal -->
  <form action="" method="POST">
  <div class="modal" id="myModal2">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
  
        <!-- Modal Header -->
        <div class="modal-header">
            <div class="" align="center">
                <div align="center">
                <table border="1" style="width: 100%;" id="noticeTable">
                    <tr>
                        <th width="150">제목</th>
                        <td colspan="3">
                            <input type="text" name="" value="기존제목" disabled>
                        </td>
                    </tr>
                    <tr>
                        <th width="150px">작성자</th>
                        <td width="250">admin</td>
                        <th width="150px">작성일</th>
                        <td width="250">
                            	작성일
                        </td>
                    </tr>
                    <tr>
                        <th width="150px">분류</th>
                        <td width="250">
                            <select name="type" disabled>
                                <option value="전체">전체</option>
                                <option value="시스템" selected>시스템</option>
                                <option value="변경/취소">변경/취소</option>
                                <option value="기타">기타</option>
                            </select>
                        </td>
                        <th width="150px">관리</th>
                        <td width="250" align="right">
                            <button class="btn btn-primary" style="height: 35px;">등록</button>
                            <button class="btn btn-danger" style="height: 35px; ">삭제</button>
                        </td>
                    </tr>
                </table>
            <div>
                <textarea name="noticeContent" id="noticeContent" style="resize: none;" disabled>기존내용</textarea>
            </div> 
         </div>
           <!-- Modal footer -->
        	<div class="modal-footer">
            	<button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
          	</div>
        </div>
  
       
  
      </div>
    </div>
  </div>
  </form>
</body>
</html>