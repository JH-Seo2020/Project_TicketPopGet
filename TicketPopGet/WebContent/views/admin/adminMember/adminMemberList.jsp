<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.kh.user.model.vo.Member" %>
<%@ page import="com.kh.admin.adminMember.model.vo.Page" %>
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

    .selectTable>tbody>tr:hover{cursor: pointer; background-color: lightgray;}

</style>
</head>
<body>
	<%@ include file="../adminCommon/adminMenubar.jsp" %>
    <div class="wrap" align="center">
        <button class="returnMainPage" onclick="location.href='<%=request.getContextPath()%>/main.ad'">초기화면</button>
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
           <!-- <tr style="height: 50px;" onclick="location.href='<%=request.getContextPath()%>/detailMember.adme?userNo=<%=m.getUserNo()%>'"> -->
             <tr style="height: 50px;" class="detail" data-toggle="modal" data-target="#reportMyModal"> 
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
    <script>
    	$(function(){
    		$(".detail").click(function(){
    			$.ajax({
    				url:"<%=request.getContextPath()%>/detailMember.adme",
    				data:{userNo:$(this).children().eq(0).text()},
    				type:"POST",
    				success:function(m){
    					$("#userNo1").val(m.userNo);
    					$("#userId1").val(m.userId);
    					$("#userName1").val(m.userName);
    					$("#email1").val(m.email);
    					$("#phone1").val(m.phone);
    					$("#birthdate1").val(m.bdate);
    					$("#gender1").val(m.gender);
    					$("#deleteStatus1").val(m.status);
    					$("#blacklistStatus1").val(m.blacklistStatus);
    				},error:function(){
    					//console.log("?");
    				}
    			});
    		});
    	});
    </script>
    <form action="<%=request.getContextPath()%>/selectMember.adme" style="float: right;" method="post">
    	<input type="hidden" name="currentPage" value="1">
        <input type="text" name="selectUser">
        <select name="selectUserType" id="selectUser">
        	<option value="ALL">전체조회</option>
            <option value="USER_ID">아이디</option>
            <option value="USER_NAME">회원명</option>
            <option value="PHONE">전화번호</option>
        </select>
        <button>검색</button>
    </form>
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
      <!-- The Modal -->
  <div class="modal" id="reportMyModal">
    <div class="modal-dialog modal-xl">
      <div class="modal-content">
  
        <!-- Modal Header -->
        <div class="modal-header">
          <table border="1" width="100%" style=" margin-top:30px; text-align:center;">
            <thead>
                <tr width="100%"  style="height: 40px; background:#6495ed;" > 
                    <th style="width: 70px;">회원번호</th>
                    <th style="width: 100px;">회원아이디</th>
                    <th style="width: 100px;">회원명</th>
                    <th style="width: 290px;">이메일</th>
                    <th style="width: 150px;">연락처</th>
                    <th style="width: 150px;">생년월일</th>
                    <th style="width: 60px;" >성별</th>
                    <th style="width: 60px;">탈퇴여부</th>
                    <th style="width: 60px;">블랙여부</th>
                </tr>
            </thead>
            <tbody>
                <tr id="MemberDetailView" style="height: 40px;">
                    <td><input id="userNo1" type="text" disabled name="userNo"  required style="width: 100%; height: 40px; box-sizing: border-box;"></td>
                    <td><input id="userId1" type="text" disabled name="userId" required style="width: 100%; height: 40px; box-sizing: border-box;"></td>
                    <td><input id="userName1" type="text" disabled name="userName"  required style="width: 100%; height: 40px; box-sizing: border-box;"></td>
                    <td><input id="email1" type="email" disabled name="email"  required style="width: 100%; height: 40px; box-sizing: border-box;"></td>
                    <td><input id="phone1" type="tel" disabled name="phone" required style="width: 100%; height: 40px; box-sizing: border-box;"> </td>
                    <td><input id="birthdate1" type="text" disabled name="birthdate"  required style="width: 100%; height: 40px; box-sizing: border-box;"></td>
                    <td><input id="gender1" type="text" disabled name="gender"  required style="width: 100%; height: 40px; box-sizing: border-box;"></td>
                    <td><input id="deleteStatus1" type="text" disabled name="deleteStatus" required style="width: 100%; height: 40px; box-sizing: border-box;"></td>
                    <td><input id="blacklistStatus1" type="text" disabled name="blacklistStatus"  required style="width: 100%; height: 40px; box-sizing: border-box;"></td>
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