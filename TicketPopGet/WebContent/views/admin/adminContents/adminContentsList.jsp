<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" import="com.kh.admin.adminContents.model.vo.Contents" import="com.kh.admin.adminMember.model.vo.*" %>
<%
	Page p = (Page)request.getAttribute("p");
	ArrayList<Contents> list = (ArrayList<Contents>)request.getAttribute("list");
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

     .selectTable tbody>tr:hover{cursor: pointer; background: lightgray;}


 </style>
</head>
<body>
<%@ include file="../adminCommon/adminMenubar.jsp" %>
    <div class="wrap" align="center">
        <button class="createBtn" data-toggle="modal" data-target="#myModal">신규등록</button>
        <button class="returnMainPage" onclick="location.href='<%=request.getContextPath()%>/main.ad'">초기화면</button>
    <div align="center">
        <h1 style="width: 500px;">컨텐츠  관리</h1>
    </div>
 
	    <table class="selectTable" border="1">

	        <thead style="background: #6495ed;">
	            <tr style="height: 50px;">
	                <th width="70px">등록번호</th>
	                <th width="">작품제목</th>
	                <th width="250">작품기간</th>
	                <th width="150px">작품시간</th>
	                <th width="200px">주최</th>
	                <th width="150px">분류</th>
	                
	            </tr>
	        </thead>
	
	        <tbody>
	        <%for(Contents c : list){ %>
	            <tr style="height: 50px;">
	           		<td><%=c.getContentNo()%></td>
	            <%if(c.getContentType().equals("연극")){ %>
	                <td><%=c.getContentTitle() + " [" + c.getRound() + "회차]"%></td>
	            <%}else {%>
	                <td><%=c.getContentTitle() %></td>
	            <%} %>
	                <td><%=c.getContentTerm()%></td>
	                <td><%=c.getContentRuntime() %></td>
	                <td><%=c.getContentSubject() %></td>
	                <td><%=c.getContentType() %></td>
	                <input type="hidden" value="<%=c.getRoundNo()%>">
	            </tr>
	        <%} %>
	        </tbody>
	
	    </table>
        <script>
        	$(function(){
        		$(".selectTable>tbody>tr").click(function(){
     
        				location.href="<%=request.getContextPath()%>/detail.adco?contentNo="+$(this).children().eq(0).text()+"&contentType="+$(this).children().eq(5).text()+"&roundNo="+$(this).children().eq(6).val();
        				
        		});
        	});
        </script>

    <br><br>
    <div align="center">

		<%if(p.getCurrentPage() != p.getStartPage()) {%>
        	<button onclick="location.href='<%=request.getContextPath()%>/list.adco?currentPage=1'">&lt;&lt;</button>
       	 	<button onclick="location.href='<%=request.getContextPath()%>/list.adco?currentPage=<%=p.getCurrentPage() - 1%>'">&lt;</button>
        <%} %>
        <%for(int i=p.getStartPage(); i<=p.getEndPage(); i++) {%>
        	<%if(i != p.getCurrentPage()){ %>
        		<button onclick="location.href='<%=request.getContextPath()%>/list.adco?currentPage=<%=i%>'"><%=i%></button>
        	<%}else{ %>
        		<button disabled><%=i%></button>
        	<%} %>
       <%} %>
        <%if(p.getCurrentPage() != p.getEndPage()) { %>
        	<button onclick="location.href='<%=request.getContextPath()%>/list.adco?currentPage=<%=p.getCurrentPage() + 1%>'">&gt;</button>
        	<button onclick="location.href='<%=request.getContextPath()%>/list.adco?currentPage=<%=p.getMaxPage()%>'">&gt;&gt;</button>   
        <%} %>  
        
    </div>

    </div>
    
      <!-- The Modal -->
  <div class="modal" id="myModal">
    <div class="modal-dialog">
      <div class="modal-content">
  
        <!-- Modal Header -->
        <div class="modal-header" align="center">
          <button style="width:150px" type="button" class="btn btn-primary" onclick="location.href='<%=request.getContextPath()%>/insertPlay.adco'">연극</button>
          <button style="width:150px" type="button" class="btn btn-primary" onclick="location.href='<%=request.getContextPath()%>/insertExhibition.adco'">전시</button>
          <button style="width:150px" type="button" class="btn btn-primary" onclick="location.href='<%=request.getContextPath()%>/insertConcert.adco'">콘서트</button>
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