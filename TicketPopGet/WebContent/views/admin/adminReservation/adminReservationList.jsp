<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"import="java.util.ArrayList" import="com.kh.admin.adminContents.model.vo.Contents" import="com.kh.admin.adminMember.model.vo.*"%>
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
        width: 800px;
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

    .selectTable>tbody>tr:hover{cursor: pointer;}

</style>
</head>
<body>
    <div class="wrap" align="center">
        <button class="returnMainPage">초기화면</button>
    <div align="center">
        <h1 style="width: 500px;">컨텐츠 예매/결제현황</h1>
    </div>
        
    <table class="selectTable" border="1">

        <thead style="background: #6495ed;">
            <tr style="height: 50px;">
                <th width="70px">등록번호</th>
                <th width="150">작품제목</th>
                <th width="">작품기간</th>
                <th width="200px">주최</th>
                <th width="150px">분류</th>
                
            </tr>
        </thead>

        <tbody>
        <%for(Contents c : list) {%>
        <tr class="contentTr" style="height: 50px;">
                <td><%=c.getContentNo()%></td>
                <td><%=c.getContentTitle() %></td>
                <td><%=c.getContentTerm() %></td>
                <td><%=c.getContentSubject() %></td>
                <td><%=c.getContentType() %></td>
            </tr>
        <%} %>
        </tbody>

        <script>
            $(document).ready(function(){
                $(".contentTr").click(function(){
                    $("#myModal").modal();
                });
            });
            </script>

    </table>
    <form action="" style="float: right;">
        <input type="text" list="selectUser">
        <button>검색</button>
    </form>
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
  <!-- 작품 클릭시 -->
  <!-- The Modal -->
  <div class="modal" id="myModal">
    <div class="modal-dialog modal-xl">
      <div class="modal-content">
  
        <!-- Modal Header -->
        <div class="modal-header">
            <table border="1" style="height: 70px; width: 100%;" >
                <thead style="background:#6495ed;">
                    <tr style="height: 50px;" align="center">
                        <th width="70px">등록번호</th>
                        <th width="300px">회차정보</th>
                        <th width="200">예매현황</th>
                        <th width="200px">관리</th>
                    </tr>

                </thead>
                <tbody align="center">
                    <tr style="height: 50px;">
                        <td>1</td>
                        <td>2020-02-02 / 16:00 ~ 18:00(1회차)</td>
                        <td>120/150</td>
                        <td>
                            <button class="btn btn-primary">상세보기</button>
                        </td>

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