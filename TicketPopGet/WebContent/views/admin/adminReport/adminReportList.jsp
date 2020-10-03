<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" import="com.kh.admin.adminReport.model.vo.Report" import="com.kh.admin.adminMember.model.vo.*" %>
<%
	Page p = (Page)request.getAttribute("p");
	ArrayList<Report> list = (ArrayList<Report>)request.getAttribute("list");
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

 </style>
</head>
<body>
<%@ include file="../adminCommon/adminMenubar.jsp" %>
    <div class="wrap" align="center">
        <button class="returnMainPage" onclick="location.href='<%=request.getContextPath()%>/main.ad'">초기화면</button>
    <div align="center">
        <h1 style="width: 500px;">신고 회원 조회</h1>
    </div>
        
    <table class="selectTable" border="1">

        <thead style="background: #6495ed;">
            <tr style="height: 50px;">
                <th width="70">신고번호</th>
                <th width="120">신고자</th>
                <th width="120">피신고자</th>
                <th width="100">신고유형</th>
                <th width="100">신고분류</th>
                <th width="300">신고정보</th>
                <th width="200">신고 접수일</th>
                <th width="100">삭제여부</th>
                <th width="100">내용확인</th>
            </tr>
        </thead>

        <tbody>
        <%for(Report r : list){ %>
            <tr style="height: 50px;">
                <td><%=r.getReportNo()%></td>
                <td><%=r.getReporter()%></td>
                <td><%=r.getTroublemaker()%></td>
                <td><%=r.getReportType()%></td>
                <td><%=r.getReportCate()%></td>
                <td><%=r.getReportInfo()%></td>
                <td><%=r.getReportDate()%></td>
                <td><%=r.getReportStatus()%></td>
                <input type="hidden" value="<%=r.getReportContent() %>">
                <input type="hidden" value="<%=r.getReportInfoContent() %>">
                <input type="hidden" value="<%=r.getContentNo()%>">
                <td>
                    <button type="button" class="btn btn-primary reportDetail" data-toggle="modal" data-target="#myModal">
                        	내용확인
                      </button>
                </td>
            </tr>
          <%} %>
        </tbody>
	<script>
		$(function(){
			$(".reportDetail").click(function(){
				$("#reportInfo").text($(this).parents("tr").children().eq(5).text());
				$("#reportContent").text($(this).parents("tr").children().eq(8).val());
				$("#content").text($(this).parents("tr").children().eq(9).val());
				$("#checkReportNo").val($(this).parents("tr").children().eq(0).text());
				$("#deleteReportCate").val($(this).parents("tr").children().eq(4).text());
				$("#deleteContentNo").val($(this).parents("tr").children().eq(10).val());
			});
		});
	</script>
    </table>

    <br><br>
        <div align="center">

		<%if(p.getCurrentPage() != p.getStartPage()) {%>
        	<button onclick="location.href='<%=request.getContextPath()%>/list.adre?currentPage=1'">&lt;&lt;</button>
       	 	<button onclick="location.href='<%=request.getContextPath()%>/list.adre?currentPage=<%=p.getCurrentPage() - 1%>'">&lt;</button>
        <%} %>
        <%for(int i=p.getStartPage(); i<=p.getEndPage(); i++) {%>
        	<%if(i != p.getCurrentPage()){ %>
        		<button onclick="location.href='<%=request.getContextPath()%>/list.adre?currentPage=<%=i%>'"><%=i%></button>
        	<%}else{ %>
        		<button disabled><%=i%></button>
        	<%} %>
       <%} %>
        <%if(p.getCurrentPage() != p.getEndPage()) { %>
        	<button onclick="location.href='<%=request.getContextPath()%>/list.adre?currentPage=<%=p.getCurrentPage() + 1%>'">&gt;</button>
        	<button onclick="location.href='<%=request.getContextPath()%>/list.adre?currentPage=<%=p.getMaxPage()%>'">&gt;&gt;</button>   
        <%} %>   
            
        </div>

    </div>
  
  <!-- The Modal -->
  <div class="modal" id="myModal">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
  
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">신고정보</h4>
        </div>
  
        <!-- Modal body -->
        <div class="modal-body">
          <p id="reportInfo">게시글 제목자리</p>
        </div>

        <!-- Modal Header -->
        <div class="modal-header">
            <h4 class="modal-title">신고사유</h4>
          </div>
    
          <!-- Modal body -->
          <div class="modal-body">
            <textarea id="reportContent" cols="100" rows="10" style="resize: none;" readonly></textarea>
          </div>
          
        <!-- Modal Header -->
        <div class="modal-header">
            <h4 class="modal-title">신고된내용</h4>
          </div>
    
          <!-- Modal body -->
          <div class="modal-body">
            <div>
            	<textarea id="content" cols="100" rows="10" style="resize: none;" readonly></textarea>
            </div>
          </div>          
          <input type="hidden" name="reportNo" value="" id="checkReportNo">
          <input type="hidden" name="reportCate" value="" id="deleteReportCate">
          <input type="hidden" name="contentNo" value="" id="deleteContentNo">

        <!-- Modal footer -->
        <div class="modal-footer">
       	  <button type="button" class="btn btn-primary" id="checkReport">신고확인</button>
       	  <button type="button" class="btn btn-danger" id="deleteReportInfo">게시물삭제</button>
          <button type="button" class="btn btn-dark" data-dismiss="modal">닫기</button>
        </div>
  
      </div>
    </div>
  </div>
  <script>
  	$(function(){
  		$("#checkReport").click(function(){
  			$.ajax({
  				url:"<%=request.getContextPath()%>/check.adre",
  				data:{reportNo:$("#checkReportNo").val()},
  				type:"post",
  				success:function(result){
  					if(result > 0){
  						alert("확인완료되었습니다.");
  						location.href="<%=request.getContextPath()%>/list.adre?currentPage=1"
  					}else{
  						alert("확인실패하였습니다.");
  					}
  				},error:function(){
  					//console.log("신고 체크 실패");
  				}
  			});
  			
  		});
  		$("#deleteReportInfo").click(function(){
  			if(confirm("정말 삭제하시겠습니까?") == true){
	  			$.ajax({
	  				url:"<%=request.getContextPath()%>/delete.adre",
	  				data:{contentNo:$("#deleteContentNo").val(), reportCate:$("#deleteReportCate").val(), reportNo:$("#checkReportNo").val()},
	  				type:"post",
	  				success:function(result){
	  					if(result > 0){
	  						alert("삭제완료되었습니다.");
	  						location.href="<%=request.getContextPath()%>/list.adre?currentPage=1"
	  					}else{
	  						alert("삭제실패되었습니다.");
	  					}
	  				},error:function(){
	  					//console.log("신고 체크 실패");
	  				}
	  			});
  				
  			}else{
  				alert("취소되었습니다");
  			}
  			
  		});
  	});
  </script>
</body>
</html>