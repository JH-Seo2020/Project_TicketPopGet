<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" import="com.kh.admin.adminMember.model.vo.Page" import="com.kh.admin.adminFaq.model.vo.Faq" %>
<%
	Page p = (Page)request.getAttribute("p");
	ArrayList<Faq> list = (ArrayList<Faq>)request.getAttribute("list");
	String key = (String)request.getAttribute("key");
	String type = (String)request.getAttribute("type");
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
            text-align: center;
        }
        
        .selectTable{
            width: 100%;
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
        #faqContent,#faqContent2{width: 100%; height: 555px; border: 2px solid #6495ed;}
        #noticeTable input, #noticeTable select{width: 100%;}
    </style>
</head>
<%@ include file="../adminCommon/adminMenubar.jsp" %>
<body>
    <div class="wrap" align="center">
        <button class="createBtn" data-toggle="modal" data-target="#myModal">FAQ 작성</button>
        <button class="returnMainPage" onclick="location.href='<%=request.getContextPath()%>/main.ad'">초기화면</button>
    <div align="center">
        <h1 style="width: 500px;">FAQ</h1>
    </div>
        
	<form action="<%=request.getContextPath()%>/search.adfa" method="post">
	<input type="hidden" name="currentPage" value="1">
    <table class="selectTable" border="1">
        <thead style="background: #6495ed;">
            <tr style="height: 50px;">
                <th width="100px">등록번호</th>
                <th width="">FAQ제목</th>
                <th width="100px">작성자</th>
                <th width="150px">
                    <select name="type">
                        <option value="전체">전체</option>
                        <option value="회원">회원</option>
                        <option value="결제">결제</option>
                        <option value="예매및취소">예매/취소</option>
                        <option value="기타">기타</option>
                    </select>
                </th>
                <th width="200px">관리</th>
            </tr>
        </thead>

        <tbody>
        <%for(Faq f : list){ %>
            <tr style="height: 50px;">
                <td><%=f.getFaqNo() %></td>
                <td><%=f.getFaqTitle() %></td>
                <td><%=f.getAdminId() %></td>
                <td><%=f.getFaqType() %></td>
                <td>
                    <button type="button" class="btn btn-primary selectUpdate" data-toggle="modal" data-target="#myModal2">조회/수정</button>
                    <button type="button" class="btn btn-danger deleteFaqBtn1">삭제</button>
                </td>
            </tr>
        <%} %>
        </tbody>
	<script>
		$(function(){
			$(".selectUpdate").click(function(){
				$.ajax({
					url:"<%=request.getContextPath()%>/selectUpdate.adfa",
					data:{faqNo:$(this).parents("tr").children().eq(0).text()},
					type:"post",
					success:function(f){
						if(f != null){
							$("#updateFaqNo").val(f.faqNo);
							$("#faqTitle2").val(f.faqTitle);
							$("#faqType2>option[value="+f.faqType+"]").attr("selected", "true");
							$("#faqContent2").text(f.faqContent);
						}
					},error:function(){
						console.log("faq조회수정 수신 실패");
					}
				});
			});
			
			$(".deleteFaqBtn1").click(function(){
				if(confirm("정말 삭제하시겠습니까?") == true){
		  			$.ajax({
		  					url:"<%=request.getContextPath()%>/delete.adfa",
		  					data:{faqNo:$(this).parents("tr").children().eq(0).text()},
		  					type:"post",
		  					success:function(result){
		  						if(result>0){
		  							alert("FAQ가 삭제되었습니다.");
		  							location.href="<%=request.getContextPath()%>/list.adfa?currentPage=1";
		  						}else{
		  							aler("FAQ삭제 실패하였습니다.");
		  						}
		  					},error:function(){
		  						console.log("FAQ 삭제 실패");
		  					}
		  				});
				}
	  		});
		});	
	</script>
	

    </table>
    
        <button type="submit" style="float:right;">검색</button>
        <input type="text" name="key" style="float:right;">
    </form>
    <br><br>
    <div align="center">

		<%if(p.getCurrentPage() != p.getStartPage()) {%>
        	<button onclick="location.href='<%=request.getContextPath()%>/search.adfa?currentPage=1&type=<%=type%>&key=<%=key%>'">&lt;&lt;</button>
       	 	<button onclick="location.href='<%=request.getContextPath()%>/search.adfa?currentPage=<%=p.getCurrentPage() - 1%>&type=<%=type%>&key=<%=key%>'">&lt;</button>
        <%} %>
        <%for(int i=p.getStartPage(); i<=p.getEndPage(); i++) {%>
        	<%if(i != p.getCurrentPage()){ %>
        		<button onclick="location.href='<%=request.getContextPath()%>/search.adfa?currentPage=<%=i%>&type=<%=type%>&key=<%=key%>'"><%=i%></button>
        	<%}else{ %>
        		<button disabled><%=i%></button>
        	<%} %>
       <%} %>
        <%if(p.getCurrentPage() != p.getEndPage()) { %>
        	<button onclick="location.href='<%=request.getContextPath()%>/search.adfa?currentPage=<%=p.getCurrentPage() + 1%>&type=<%=type%>&key=<%=key%>'">&gt;</button>
        	<button onclick="location.href='<%=request.getContextPath()%>/search.adfa?currentPage=<%=p.getMaxPage()%>&type=<%=type%>&key=<%=key%>'">&gt;&gt;</button>   
        <%} %>    
        
    </div>

    </div>

          <!-- 작성하기모달 -->
  <!-- The Modal -->
  <div class="modal" id="myModal">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <form action="<%=request.getContextPath()%>/insert.adfa" method="POST">
        <!-- Modal Header -->
            <div class="modal-header">
                <div class="" align="center">   
                    <table border="1" style="width: 100%;" id="noticeTable">
                    <tr>
                        <th width="100px">제목</th>
                        <td width="350">
                            <input type="text" name="faqTitle" id="faqTitle">
                        </td>
                        <th width="150px">분류</th>
                        <td width="250">
                            <select name="faqType" id="">
                                <option value="회원">회원</option>
                                <option value="결제">결제</option>
                                <option value="예매및취소">예매/취소</option>
                                <option value="기타">기타</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th width="150px">작성자</th>
                        <td width="250">관리자</td>
                        <th width="150px">관리</th>
                        <td width="250" align="right">
                            <button class="btn btn-primary" style="height: 35px;">등록</button>
                        </td>
                    </tr>
                    </table>
                        <textarea name="faqContent" id="faqContent" style="resize: none;"></textarea>
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

        <!-- 조회/수정 모달 -->
  <!-- The Modal -->
  <div class="modal" id="myModal2">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <form action="update.adfa" method="POST">
        <!-- Modal Header -->
        	<input id="updateFaqNo" type="hidden" name="faqNo" vlaue="">
            <div class="modal-header">
                <div class="" align="center">   
                    <table border="1" style="width: 100%;" id="noticeTable">
                    <tr>
                        <th width="100px">제목</th>
                        <td width="350">
                            <input type="text" name="faqTitle" id="faqTitle2" disabled>
                        </td>
                        <th width="150px">분류</th>
                        <td width="250">
                            <select name="faqType" id="faqType2" disabled>
                                <option value="회원">회원</option>
                                <option value="결제">결제</option>
                                <option value="예매및취소">예매/취소</option>
                                <option value="기타">기타</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th width="150px">작성자</th>
                        <td width="250">관리자</td>
                        <th width="150px">관리</th>
                        <td width="250" align="right">
                            <button id="insertFaqBtn" class="btn btn-primary" style="height: 35px; display:none">등록</button>
                            <button type="button" id="updateFaqBtn" onclick="unlock();" class="btn btn-primary" style="height: 35px;">수정</button>
                            <button type="button" id="deleteFaqBtn" class="btn btn-danger deleteFaqBtn2" style="height: 35px;">삭제</button>
                        </td>
                    </tr>
                    </table>
                        <textarea name="faqContent" id="faqContent2" style="resize: none;" disabled></textarea>
                </div>
            </div>
        </form>
            <!-- Modal footer -->
                <div class="modal-footer">
                    <button type="button" onclick="lock();" class="btn btn-danger" data-dismiss="modal">취소</button>
                </div>
      </div>
    </div>
  </div>
<script>

	function unlock(){
			$("#faqTitle2").removeAttr("disabled");
			$("#faqType2").removeAttr("disabled");
			$("#faqContent2").removeAttr("disabled");
			$("#insertFaqBtn").css("display","");
			$("#updateFaqBtn").css("display","none");
	};
	
	function lock(){
		$("#faqTitle2").attr("disabled","true");
		$("#faqType2").attr("disabled","true");
		$("#faqContent2").attr("disabled","true");
		$("#insertFaqBtn").css("display", "none");
		$("#updateFaqBtn").css("display","");
};


</script>
</body>
</html>