<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList" import="com.kh.user.model.vo.Member"%>
<%@ page import="com.kh.admin.adminMember.model.vo.Page;" %>
<%
	ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
	Page p = (Page)request.getAttribute("page");
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
    
    .selectTable{width: 100%;}
    
    .returnMainPage{
        width: 100px;
        height: 40px;
        background: #98c3ff;
        border: none;
        border-radius: 10px;
        float: right;
    }

    .selectTable>tbody:hover{cursor: pointer;}

</style>
</head>
<body>
    <div class="wrap" align="center">
        <button class="returnMainPage">초기화면</button>
    <div align="center">
        <h1 style="width: 500px;">회원 전체 조회</h1>
    </div>
        
    <table class="selectTable" border="1">

        <thead style="background: #6495ed;">
            <tr style="height: 50px;">
                <th width="100px">회원번호</th>
                <th width="180px">회원아이디</th>
                <th width="150px">회원명</th>
                <th >이메일</th>
                <th width="150px">연락처</th>
                <th width="100px">탈퇴여부</th>
            </tr>
        </thead>

        <tbody>
        <%if(list.isEmpty()) {%>
        	<tr>
        		<td colspan="6">조회된 리스트가 없습니다.</td>
        	</tr>
        <%}else {%>
        	<%for(Member m : list) { %>
            	<tr style="height: 50px;">
                	<td><%=m.getUserNo()%></td>
                	<td><%=m.getUserId() %></td>
	                <td><%=m.getUserName() %></td>
	                <td><%=m.getEmail() %></td>
	                <td><%=m.getPhone() %></td>
	                <td><%=m.getStatus() %></td>
	            </tr>
            <%} %>
        <%} %>    
        </tbody>

    </table>
    <form action="" style="float: right;">
        <input type="text" list="selectUser">
        <select name="selectUser" id="selectUser">
            <option value="selectAll">전체</option>
            <option value="userId">아이디</option>
            <option value="userName">회원명</option>
            <option value="phone">연락처</option>
        </select>
        <button>검색</button>
    </form>
    <br><br>
    <div align="center">
		<%if(p.getCurrentPage() != p.getStartPage()) {%>
        	<button onclick="location.href='<%=request.getContextPath()%>/list.adme?currentPage=1'">&lt;&lt;</button>
       	 	<button onclick="location.href='<%=request.getContextPath()%>/list.adme?currentPage=<%=p.getCurrentPage() - 1%>'">>&lt;</button>
        <%} %>
        <%for(int i=0; i<=p.getEndPage(); i++) {%>
        
        	<button onclick="location.href='<%=request.getContextPath()%>/list.adme?currentPage=<%=i%>'">><%=i%></button>
        
       <%} %>
        <%if(p.getCurrentPage() != p.getEndPage()) { %>
        	<button onclick="location.href='<%=request.getContextPath()%>/list.adme?currentPage=<%=p.getCurrentPage() + 1%>'">>&gt;</button>
        	<button onclick="location.href='<%=request.getContextPath()%>/list.adme?currentPage=<%=p.getMaxPage()%>'">>&gt;&gt;</button>   
        <%} %>
    </div>

    </div>
</body>
</html>