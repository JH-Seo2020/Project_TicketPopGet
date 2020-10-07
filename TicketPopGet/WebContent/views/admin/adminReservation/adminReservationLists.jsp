<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList" import="com.kh.admin.adminContents.model.vo.Contents" import="com.kh.admin.adminMember.model.vo.*"%>
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
    
    .selectTable{ width: 100%;}
    
    .returnMainPage{
        width: 100px;
        height: 40px;
        background: #98c3ff;
        border: none;
        border-radius: 10px;
        float: right;
    }

    .selectTable>tbody>tr:hover{cursor: pointer; background:lightgray;}

</style>
</head>
<body>
<%@ include file="../adminCommon/adminMenubar.jsp" %>
    <div class="wrap" align="center">
        <button class="returnMainPage" onclick="location.href='<%=request.getContextPath()%>/main.ad'">초기화면</button>
    <div align="center">
        <h1 style="width: 500px;">컨텐츠 예매/결제현황</h1>
    </div>
        
    <table class="selectTable" border="1">

        <thead style="background: #6495ed;">
            <tr style="height: 50px;">
                <th width="70px">등록번호</th>
                <th width="">작품제목</th>
                <th width="250">작품기간</th>
                <th width="200px">주최</th>
                <th width="150px">분류</th>
                
            </tr>
        </thead>

        <tbody>
        <%if(list.isEmpty()) {%>
        	<tr class="contentTr" style="height: 50px;">
	            <td colspan="5">조회된 결과가 없습니다.</td>
	        </tr>
        <%}else { %>
	        <%for(Contents c : list) {%>
	        <tr class="contentTr" style="height: 50px;">
	                <td><%=c.getContentNo()%></td>
	                <%if(c.getContentType().equals("연극")){ %>
		                <td><%=c.getContentTitle()%>[<%=c.getRound()%>회차]</td>
	                <%}else {%>
	                	<td><%=c.getContentTitle()%></td>
	                <%} %>
	                <td><%=c.getContentTerm() %></td>
	                <td><%=c.getContentSubject() %></td>
	                <td><%=c.getContentType() %></td>
	                <%if(c.getContentType().equals("연극")){ %>
		                <input type="hidden" name="round" value="<%=c.getRound()%>">
	                <%}else {%>
	                	<input type="hidden" name="round" value="0">
	                <%} %>
	            </tr>
	        <%} %>
        <%} %>
        </tbody>
		<script>
			$(function(){
				$(".contentTr").click(function(){
					location.href="<%=request.getContextPath()%>/list.adpay?currentPage=1&contentNo="+$(this).children().eq(0).text()+"&contentType="+$(this).children().eq(4).text()+"&round="+$(this).children().eq(5).val();
				});
			});
		</script>

    </table>
    <br><br>
    <div align="center">

		<%if(p.getCurrentPage() != p.getStartPage()) {%>
        	<button onclick="location.href='<%=request.getContextPath()%>/list.adres?currentPage=1'">&lt;&lt;</button>
       	 	<button onclick="location.href='<%=request.getContextPath()%>/list.adres?currentPage=<%=p.getCurrentPage() - 1%>'">&lt;</button>
        <%} %>
        <%for(int i=p.getStartPage(); i<=p.getEndPage(); i++) {%>
        	<%if(i != p.getCurrentPage()){ %>
        		<button onclick="location.href='<%=request.getContextPath()%>/list.adres?currentPage=<%=i%>'"><%=i%></button>
        	<%}else{ %>
        		<button disabled><%=i%></button>
        	<%} %>
       <%} %>
        <%if(p.getCurrentPage() != p.getEndPage()) { %>
        	<button onclick="location.href='<%=request.getContextPath()%>/list.adres?currentPage=<%=p.getCurrentPage() + 1%>'">&gt;</button>
        	<button onclick="location.href='<%=request.getContextPath()%>/list.adres?currentPage=<%=p.getMaxPage()%>'">&gt;&gt;</button>   
        <%} %>
        
    </div>

    </div>

</body>
</html>