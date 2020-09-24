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
        <button class="returnMainPage" onclick="<%=request.getContextPath()%>/mian.ad">초기화면</button>
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
                <td><%=m.getUserNo() %></td>
                <td><%=m.getUserId() %></td>
                <td><%=m.getReportCount()%></td>
                <td>
                    <button onclick="blacklistDetail();" type="button" class="btn btn-primary" data-toggle="modal" data-target="#reportMyModal">
                        	내용확인
                      </button>
                </td>
                
                <td>
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                        	해제
                      </button>
                </td>
            </tr>
         <%} %>
		<script>
			function blacklistDetail(){
				
				$.ajax({
					url:"<%=request.getContextPath()%>/blacklistDetail.adme",
					type:"get",
					data:{userNo:$(".selectTable>tbody>tr").children().eq(0).text()},
					success:function(list){
						for(var i=0; i<list.length; i++){
							$(".modal-header>table>tbody").html(
								"<tr>" +
									"<td>" + list[i].reportNo + "</td>" +
									"<td>" + list[i].reporter + "</td>" +
									"<td>" + list[i].reportDate + "</td>" +
									"<td>" + list[i].reportCate + "</td>" +
								+ "</tr>"
							);
						}
					},error:function(){
						console.log("블랙리스트 상세조회 모달 ajax통신 실패");
					}
				});
			};
		</script>
        </tbody>

    </table>
    
    <form action="" style="float: right;">
        <input type="text" name="selectUser"> 
        <button type="submit">검색</button>
    </form>
    <br><br>
        <div align="center">
			<%if(p.getCurrentPage() != p.getStartPage()) {%>
            	<button><<</button>
            	<button><</button>
            <%} %>
            <%for(int i=p.getStartPage(); i<=p.getEndPage(); i++) {%>
            	<%if(p.getCurrentPage() != i) {%>
            		<button onclick="location.href='<%=request.getContextPath()%>/blacklist.adme?currentPage=<%=i%>'"><%=i%></button>
            	<%}else { %>
            		<button disabled onclick="location.href='<%=request.getContextPath()%>/blacklist.adme?currentPage=<%=i%>'"><%=i%></button>
            	<%} %>
            <%} %>
            <%if(p.getCurrentPage() != p.getEndPage()){ %>
            <button>></button>
            <button>>></button>   
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
                        <td width="80px">신고 분류</td>
                        <td width="100px">신고된날짜</td>
                        <td width="80">신고자</td>
                        <td width="200px">신고 사유</td>
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

<!-- 해제설정시 나타날 모달 -->
    <!-- The Modal -->
    <div class="modal" id="myModal">
        <div class="modal-dialog">
          <div class="modal-content">
      
            <!-- Modal Header -->
            <div class="modal-header">
              <h4 class="modal-title">블랙리스트를 해제 하시겠습니까?</h4>
            </div>
      
            <!-- Modal body -->
            <div class="modal-body" align="right">
              <button class="btn btn-danger" style="width: 150px;">해제</button>
            </div>
    
            <!-- Modal footer -->
            <div class="modal-footer">
              <button type="button" class="btn btn-dark" data-dismiss="modal">닫기</button>
            </div>
      
          </div>
        </div>
      </div>
</body>
</html>