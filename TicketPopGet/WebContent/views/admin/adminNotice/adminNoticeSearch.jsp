<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList" import="com.kh.admin.adminMember.model.vo.Page" import="com.kh.admin.adminNotice.model.vo.Notice" import="java.util.Date" import="java.text.SimpleDateFormat"%>
<%
	Page p = (Page)request.getAttribute("p");
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
	String key = (String)request.getAttribute("key");
	String type = (String)request.getAttribute("type");
	Date today = new Date();
	SimpleDateFormat format = new SimpleDateFormat("yyyy년MM월dd일");
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
<form action="<%=request.getContextPath()%>/searchList.adno" method="post">      
        <button type="button" class="createBtn" data-toggle="modal" data-target="#myModal">공지사항 작성</button>
        <button type="button" class="returnMainPage" onclick="location.href='<%=request.getContextPath()%>/main.ad'">초기화면</button>
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
                        <option value="변경취소">변경/취소</option>
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
                    <button type="button" class="btn btn-primary selectUpdate" data-toggle="modal" data-target="#myModal2">조회/수정</button>
                    <button type="button"  class="btn btn-danger deleteNoticeBtnBtn">삭제</button>
                    
                </td>

            </tr>
        <%} %>    
        </tbody>
		
    </table>
		<script type="text/javascript">
			$(function(){
				$(".deleteNoticeBtnBtn").click(function(){
					if(confirm("정말 삭제하시겠습니가?") == true){
						$.ajax({
							url:"<%=request.getContextPath()%>/delete.adno",
							data:{noticeNo:$(this).parents("tr").children().eq(0).text()},
							type:"post",
							success:function(result){
								if(result > 0){
									alert("삭제 완료되었습니다.");
									location.href="<%=request.getContextPath()%>/list.adno?currentPage=1";
								}else{
									alert("삭제 실패하였습니다.");
								}
							},error:function(){
								console.log("ajax통신실패다리");
							}
						});
					}
				});
			});
		</script>
    	<input type="hidden" name="currentPage" value="1" style="float:right;">
        <button style="float:right;">검색</button>
        <input type="text" name="selectKeyword" style="float:right;">
    </form>
    <br><br>
    <div align="center">
 
		<%if(p.getCurrentPage() != p.getStartPage()) {%>
        	<button onclick="location.href='<%=request.getContextPath()%>/searchList.adno?currentPage=1&selectKeyword=<%=key%>&type=<%=type%>'">&lt;&lt;</button>
       	 	<button onclick="location.href='<%=request.getContextPath()%>/searchList.adno?currentPage=<%=p.getCurrentPage() - 1%>&selectKeyword=<%=key%>&type=<%=type%>'">&lt;</button>
        <%} %>
        <%for(int i=p.getStartPage(); i<=p.getEndPage(); i++) {%>
        	<%if(i != p.getCurrentPage()){ %>
        		<button onclick="location.href='<%=request.getContextPath()%>/searchList.adno?currentPage=<%=i%>&selectKeyword=<%=key%>&type=<%=type%>'"><%=i%></button>
        	<%}else{ %>
        		<button disabled><%=i%></button>
        	<%} %>
       <%} %>
        <%if(p.getCurrentPage() != p.getEndPage()) { %>
        	<button onclick="location.href='<%=request.getContextPath()%>/searchList.adno?currentPage=<%=p.getCurrentPage() + 1%>&selectKeyword=<%=key%>&type=<%=type%>'">&gt;</button>
        	<button onclick="location.href='<%=request.getContextPath()%>/searchList.adno?currentPage=<%=p.getMaxPage()%>&selectKeyword=<%=key%>&type=<%=type%>'">&gt;&gt;</button>   
        <%} %>  
    </div>

    </div>

          <!-- 작성하기모달 -->
  <!-- The Modal -->
  <div class="modal" id="myModal">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <form action="insert.adno" method="POST">
        <!-- Modal Header -->
            <div class="modal-header">
                <div class="" align="center">   
                    <table border="1" style="width: 100%;" id="noticeTable">
                        <tr>
                            <th width="150">제목</th>
                            <td colspan="3">
                                <input type="text" name="noticeTitle">
                            </td>
                        </tr>
                        <tr>
                            <th width="150px">작성자</th>
                            <td width="250">관리자</td>
                            <th width="150px">작성일</th>
                            <td width="250">
                                <%=format.format(today)%>
                            </td>
                        </tr>
                        <tr>
                            <th width="150px">분류</th>
                            <td width="250">
                                <select name="type">
                                    <option value="시스템">시스템</option>
                                    <option value="변경/취소">변경/취소</option>
                                    <option value="기타">기타</option>
                                </select>
                            </td>
                            <th width="150px">관리</th>
                            <td width="250" align="right">
                                <button type="submit" class="btn btn-primary" style="height: 35px;" >등록</button>
                            </td>
                        </tr>
                    </table>
                        <textarea name="noticeContent" id="noticeContent" style="resize: none;"></textarea>
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
    <script>
  $(function(){
  	$(".selectUpdate").click(
  			function (){
  		  		$.ajax({
  		  			url:"<%=request.getContextPath()%>/selectUpdate.adno",
  		  			data:{noticeNo:$(this).parents("tr").children().eq(0).text()},
  		  			type:"post",
  		  			success:function(n){
  		  				$("#updateTitle").val(n.noticeTitle);
  		  				$("#updateType>option[value="+n.noticeType+"]").attr("selected", "true");
  		  				$("#updateContent").text(n.noticeContent);
  		  				$("#updateDate").text(n.noticeDate);
  		  				$("#updateNo").val(n.noticeNo);
  		  			},error:function(){
  		  				//console.log("조회/수정 통신 실패");
  		  			}
  		  		})
  		  	}
  	)
	  
  });
  	
  </script>
        <!-- 수정하기 모달 -->
  <!-- The Modal -->
  <div class="modal" id="myModal2">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <!-- Modal Header -->
            <div class="modal-header">
            <form action="<%=request.getContextPath()%>/update.adno" method="post">
            	<input id="updateNo" type="hidden" name="noticeNo" value="">
                <div class="" align="center">
                    <table border="1" style="width: 100%;" class="noticeTable">
                        <tr>
                            <th width="150">제목</th>
                            <td colspan="3">
                                <input type="text" name="noticeTitle" id="updateTitle" disabled>
                            </td>
                        </tr>
                        <tr>
                            <th width="150px">작성자</th>
                            <td width="250">관리자</td>
                            <th width="150px">작성일</th>
                            <td id="updateDate" width="250">
                                <%=format.format(today)%>
                            </td>
                        </tr>
                        <tr>
                            <th width="150px">분류</th>
                            <td width="250">
                                <select id="updateType" name="type" disabled>
                                    <option value="시스템">시스템</option>
                                    <option value="변경취소">변경/취소</option>
                                    <option value="기타">기타</option>
                                </select>
                            </td>
                            <th width="150px">관리</th>
                            <td width="250" align="right">
                                <button id="insertNoticeBtn" class="btn btn-primary" style="height: 35px; display:none" >등록</button>
                                <button id="updateNoticeBtn" onclick="updateNotice1();" type="button" class="btn btn-primary" style="height: 35px;" >수정</button>
                                <button type="button" id="deleteNoticeBtn" class="btn btn-danger" style="height: 35px;" >삭제</button>
                            </td>
                        </tr>
                    </table>
                        <textarea name="noticeContent" id="updateContent" style="resize: none;" disabled></textarea>
                </div>
               </form>
            </div>
            <!-- Modal footer -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
                </div>
      </div>
    </div>
  </div>
  <script>
  $(function(){
	  $("#deleteNoticeBtn").click(function(){
		  if(confirm("정말 삭제하시겠습니까?") == true){
			  $.ajax({
		  			url:"<%=request.getContextPath()%>/delete.adno",
		  			data:{noticeNo:$("#updateNo").val()},
		  			type:"post",
		  			success:function(result){
		  				if(result > 0){
		  					alert("삭제 완료되었습니다.");
			  				location.href="<%=request.getContextPath()%>/list.adno?currentPage=1";
		  				}else{
		  					alert("삭제 실패하였습니다.");
		  				}
		  			},error:function(){
		  				console.log("통신실패");
		  			}
		  		})
		  }
	  })
  });
 
  	function updateNotice1(){
  		$("#updateTitle, #updateType, #updateContent").removeAttr("disabled");
  		$("#updateNoticeBtn").css("display","none");
  		$("#insertNoticeBtn").css("display","");
  	};
  </script>
</body>
</html>