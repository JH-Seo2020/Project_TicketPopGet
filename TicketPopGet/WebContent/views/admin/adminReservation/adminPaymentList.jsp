<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList" import="com.kh.admin.adminReservation.model.vo.Reservation" import="com.kh.admin.adminMember.model.vo.*"%>
<%
	Page p = (Page)request.getAttribute("p");
	ArrayList<Reservation> list = (ArrayList<Reservation>)request.getAttribute("list");
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
        
    <div align="center">
        <h1 style="width: 800px;">&lt;<%=list.get(0).getContentTitle() %>&gt;<%if(list.get(0).getContentDate() != null){%> <%=list.get(0).getContentDate()%> <%} %> <%if(list.get(0).getRound() != null){%>[<%=list.get(0).getRound()%>회차]<%} %> 
        </h1>
        <h1>
        	결제현황
        </h1>
    </div>
    <button class="returnMainPage">이전으로</button>
    
    <%if(list.get(0).getContentDate() != null) {%>
    <p style="float: right;">잔여티켓 :<%=list.get(0).getMax()-list.size()%> 전체티켓 <%=list.get(0).getMax()%> </p>
    <%} %>
    <table class="selectTable" border="1">

        <thead style="background: #6495ed;">
            <tr style="height: 50px;">
                <th width="100px">등록번호</th>
                <th width="150px">회원아이디</th>
                <th width="250px">예약일자</th>
                <th width="250">결제일자</th>
                <th width="150px">결제방법</th>
                <th width="150px">결제여부</th>
                <th>관리</th>
            </tr>
        </thead>

        <tbody>
        <%if(list.isEmpty()) {%>
        	<tr style="height: 50px;">
	            <td colspan="7">조회결과가 없습니다.</td>
	        </tr>
        	
        <%}else {%>
	            <%for(Reservation r : list) { %>
            	<tr style="height: 50px;">
                <td><%=r.getTicketNo()%></td>
                <td><%=r.getUser()%></td>
                <td><%=r.getReservationDate() %></td>
                <td>
                <%if(r.getPaymentDate() == null) {%>
                	-
                <%}else { %>
                	<%=r.getPaymentDate() %>
                <%} %>
                </td>
                <td><%=r.getPaymentType() %></td>
                <td><%=r.getPaymentStatus() %></td>
                <td>
                    <button class="btn btn-primary">예약취소</button>
                </td>
            </tr>
            <%} %>
        <%} %>
        </tbody>

    </table>
    <br><br>
    <div align="center">

		<%if(p.getCurrentPage() != p.getStartPage()) {%>
        	<button onclick="location.href='<%=request.getContextPath()%>/list.adpay?currentPage=1'">&lt;&lt;</button>
       	 	<button onclick="location.href='<%=request.getContextPath()%>/list.adpay?currentPage=<%=p.getCurrentPage() - 1%>'">&lt;</button>
        <%} %>
        <%for(int i=p.getStartPage(); i<=p.getEndPage(); i++) {%>
        	<%if(i != p.getCurrentPage()){ %>
        		<button onclick="location.href='<%=request.getContextPath()%>/list.adpay?currentPage=<%=i%>'"><%=i%></button>
        	<%}else{ %>
        		<button disabled><%=i%></button>
        	<%} %>
       <%} %>
        <%if(p.getCurrentPage() != p.getEndPage()) { %>
        	<button onclick="location.href='<%=request.getContextPath()%>/list.adpay?currentPage=<%=p.getCurrentPage() + 1%>'">&gt;</button>
        	<button onclick="location.href='<%=request.getContextPath()%>/list.adpay?currentPage=<%=p.getMaxPage()%>'">&gt;&gt;</button>   
        <%} %>  
        
    </div>

    </div>
</body>
</html>