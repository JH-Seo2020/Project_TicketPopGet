<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page 
	import="com.kh.admin.adminMember.model.vo.*"
	import="com.kh.user.model.vo.Member"
	import="java.util.ArrayList"
%>
<%
	Page p = (Page)request.getAttribute("p");
	ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .wrap{
        width: 800px;
        height: 850px;
        margin: auto;
        text-align: center;
        right:300px;
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

</style>
</head>
<body>
	<%@ include file="../adminCommon/adminMenubar.jsp" %>
    <div class="wrap" align="center">
        <button class="returnMainPage" onclick="location.href='<%=request.getContextPath()%>/main.ad'">초기화면</button>
    <div align="center">
        <h1 style="width: 500px;">블랙리스트 조회</h1>
    </div>
        
    <table class="selectTable" border="1">

        <thead style="background: #6495ed;">
            <tr style="height: 50px;">
                <th width="70">회원번호</th>
                <th width="120">회원아이디</th>
                <th width="120">누적신고수</th>
                <th width="100">신고내역</th>
                <th width="100">해제설정</th>
                
            </tr>
        </thead>

        <tbody>
        <%for(Member m : list) {%>
            <tr style="height: 50px;">
                <td class="userNo"><%=m.getUserNo() %></td>
                <td><%=m.getUserId() %></td>
                <td><%=m.getReportCount()%></td>
                <td>
                    <button type="button" class="btn btn-primary blacklistDetail" data-toggle="modal" data-target="#reportMyModal">
                        	내용확인
                      </button>
                </td>
                
                <td>
                    <button type="button" class="btn btn-primary blacklistUnlock" data-toggle="modal" data-target="#myModal">
                        	해제
                      </button>
                </td>
            </tr>
         <%} %>
		<script>
			$(function(){
				$(".blacklistDetail").click(function(){
					$.ajax({
						url:"<%=request.getContextPath()%>/blacklistDetail.adme",
						type:"post",
						data:{userNo:$(this).parents("tr").children().eq(0).text()},
						success:function(list){
							var result = "";
							for(var i in list){
								
									result += 
									"<tr>" +
										"<td>" + list[i].reportType + "</td>" +
										"<td>" + list[i].reportDate + "</td>" +
										"<td>" + list[i].reporter + "</td>" +
										"<td>" + list[i].reportCate + "</td>" +
									+ "</tr>"
								
							}
							$(".modal-header>table>tbody").html(
									result
							);
						},error:function(){
							console.log("블랙리스트 상세조회 모달 ajax통신 실패");
						}
					});
				});
				$(".blacklistUnlock").click(function(){
					if(confirm("블랙리스트를 해제하시겠습니까?") == true){
						$.ajax({
							url:"<%=request.getContextPath()%>/blacklistUnlock.adme",
							data:{userNo:$(this).parents("tr").children().eq(0).text()},
							type:"post",
							success:function(result){
								if(result > 0){
										location.href="<%=request.getContextPath()%>/blacklist.adme?currentPage=1"
										alert("블랙리스트가 해제되었습니다.");
								}
									
							},error:function(){
								//console.log("블랙리스트해제 ajax통신 실패");
							}
 							});
						}
					});
				});
		</script>
        </tbody>

    </table>
    
    <br><br>
        <div align="center">
		<%if(p.getCurrentPage() != p.getStartPage()) {%>
        	<button onclick="location.href='<%=request.getContextPath()%>/list.adme?currentPage=1'">&lt;&lt;</button>
       	 	<button onclick="location.href='<%=request.getContextPath()%>/list.adme?currentPage=<%=p.getCurrentPage() - 1%>'">&lt;</button>
        <%} %>
        <%for(int i=p.getStartPage(); i<=p.getEndPage(); i++) {%>
        	<%if(i != p.getCurrentPage()){ %>
        		<button onclick="location.href='<%=request.getContextPath()%>/list.adme?currentPage=<%=i%>'"><%=i%></button>
        	<%}else{ %>
        		<button disabled><%=i%></button>
        	<%} %>
       <%} %>
        <%if(p.getCurrentPage() != p.getEndPage()) { %>
        	<button onclick="location.href='<%=request.getContextPath()%>/list.adme?currentPage=<%=p.getCurrentPage() + 1%>'">&gt;</button>
        	<button onclick="location.href='<%=request.getContextPath()%>/list.adme?currentPage=<%=p.getMaxPage()%>'">&gt;&gt;</button>   
        <%} %>
        </div>

    </div>


  <!-- 신고내역 내용확인 모달 -->
  <!-- The Modal -->
  <div class="modal" id="reportMyModal">
    <div class="modal-dialog">
      <div class="modal-content">
  
        <!-- Modal Header -->
        <div class="modal-header">
            <table border="1" style="height: 70px;" >
                <thead style="background:#6495ed;">
                    <tr style="height: 50px;" align="center">
                        <th width="80px">신고 분류</th>
                        <th width="100px">신고된날짜</th>
                        <th width="80">신고자</th>
                        <th width="200px">신고 사유</th>
                    </tr>

                </thead>
                <tbody align="center" id="reportCheck">
                	 <tr style="height: 50px;" align="center">
                        <td width="80px"></td>
                        <td width="100px"></td>
                        <td width="80"></td>
                        <td width="200px"></td>
                    </tr>
                </tbody>
            </table>
          
        </div>
  
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
        </div>
  
      </div>
    </div>
  </div>

</body>
</html>