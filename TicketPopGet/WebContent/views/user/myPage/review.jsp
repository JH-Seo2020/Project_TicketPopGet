<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.user.model.vo.*" %>
<%
	ArrayList<MyPage> mps = (ArrayList<MyPage>)request.getAttribute("mps");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();

	String content = (String)request.getAttribute("content");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 관람후기</title>
    <style>
        #review{
            width: 1200px;
            height: 900px;
            margin: auto;
            box-sizing: border-box;
        }
    /* 헤더부분 */
    .reservation_check1{
        margin-top:100px;
        font-size: 25px; 
        width: 1000px;
        margin-left: 90px; 
        border-bottom: 1px solid rosybrown;
    }
    /* 컨텐츠분류 */
    .contents_btn{
        margin-top: 70px;
        margin-right: 150px;
    }

    /* 테이블 */
    .reservation_check3 table{
        width: 950px;
        height: 350px;
        text-align: center;
        border-bottom: 1px solid silver;
    }
    .reservation_check3 table>tbody>tr:hover{
        background-color: white;
        color: sandybrown;
        cursor: pointer;
    }

    /* checkbox */
    input[type=checkbox]{
        width: 20px;
        height: 20px;
    }


    /* 삭제여부버튼 */
    #delete_review_btn{
        margin-top: 20px;
        margin-right: 150px;
    }
    #delete_review_btn button{
        background-color: sandybrown;
        border-radius: 0.5em;
        border:1px solid sandybrown;
        width: 50px;
        height: 30px;
        color: white;
    }

    /* 페이징바 */
    .pagination {margin:10px 0 0; text-align:center}
    .pagination .btn-prev, .pagination .btn-next, .pagination a span {display: inline-block; margin-right:2px; padding: 4px 12px; border:1px solid #ddd; border-radius: 4px; color: #111; background:#fff; text-decoration: none; text-align: center;}
    .pagination .btn-prev:hover, .pagination .btn-next:hover, .pagination a span:hover,
    .pagination .btn-prev:active, .pagination .btn-next:active, .pagination a span:active,
    .pagination .btn-prev:focus, .pagination .btn-next:focus, .pagination a span:focus {color:#fff; background:#ff8149; border:1px solid #ff8149}
    .pagination a .selected {color:#ff8149; border:1px solid #ff8149}
    .pagination .no-more-prev, .pagination .no-more-next {display:none}


</style>
</head>
<body>

	<!-- 메뉴바쓰추가쓰 -->
	<%@ include file="/views/common/menubar.jsp"%>
	<%
	 	int userNo = loginUser.getUserNo();
	%>
	
    <div id="review">
        <!-- 헤더부분 -->
        <div class="reservation_check1">
            <h3 style="margin-bottom: 20px;"><b>나의관람후기</b></h3>
        </div>

        <!-- 컨텐츠분류 -->
        <div class="contents_btn" align="right">
            <a href="<%=contextPath%>/review.my?currentPage=1&userNo=<%=loginUser.getUserNo()%>" class="btn btn-outline-warning">전체</a> 
            <a href="<%=contextPath%>/review_content.my?currentPage=1&userNo=<%=loginUser.getUserNo()%>&content=콘서트" class="btn btn-outline-warning">콘서트</a>
            <a href="<%=contextPath%>/review_content.my?currentPage=1&userNo=<%=loginUser.getUserNo()%>&content=연극" class="btn btn-outline-warning">연극</a>
            <a href="<%=contextPath%>/review_content.my?currentPage=1&userNo=<%=loginUser.getUserNo()%>&content=전시" class="btn btn-outline-warning">전시</a>
        </div>

        <!-- 관람후기테이블 -->
        <div class="container reservation_check3" style="margin-left: 70px; margin-top:50px;">          
            <table class="table table-hover listArea"   style="width: 950px; height: 70px; margin-left: 30px; text-align: center;">
              <thead>
                <tr>
                  <th></th>
                  <th>번호</th>
                  <th>공연명</th>
                  <th>제목</th>
                  <th>작성일</th>
                </tr>
              </thead>
              
              <tbody>
              		<%
              			if(mps.isEmpty()){
              		%>
              		<tr>
              			<td colspan="5">조회되는 리스트가 없습니다.</td>
              		</tr>
              		<%
              			}else{ 
              		           for(MyPage ps : mps) {
              		%>
	                <tr>
	                  <td><input type="checkbox"  name="delete_review"></td>
	                  <td><%=ps.getReviewNo()%></td>
	                  <td onclick="fnClickDetail();"><%=ps.getContentTitle()%></td>
	                  <td><%=ps.getReviewTitle()%></td>
	                  <td><%=ps.getReviewDate()%></td>
	                </tr>
	                <%} %>
	                <%} %>
              </tbody>
            </table>
          </div>
          
          <div id="delete_review_btn" align="right">
              <button id="delete" onclick="deletebtn();">삭제</button>
          </div>
          <%-- 
          		체크박스 체크시 삭제기능 넣어야함.. 근데 이걸 서블릿에게 넘겨야하는뎅.. 서블릿에서 설정을해야하는걸까.. ㅠ.ㅠ..고민좀더해보장
	          <script>
	          	function deletebtn(){
	          		
	          		var con = confirm('정말 삭제하시겠습니까?');
	          		var del = document.ElementName("delete_review");
	          		
	          		if(con==true){
	          			
		          		alert("삭제되었습니다.");
	          		}else{
	          			alert("취소되었습니다.");
	          		}
	          	}
	          </script>
	       --%>
	     
	      
			<script>
	       //상세페이지 전환
	       function fnClickDetail() {
	        	
	    	   
	    	   $(".table>tbody>tr").click(function(){
					var rno = $(this).children().eq(1).text(); 
					var userNo = "<%=userNo%>";
					location.href="<%=contextPath%>/review_detail.my?rno="+rno+"&"+"userNo="+userNo; 
				});
	       }
	       
	       $("#delete").click(function(){
	    	   
	    	   if( $("input[type=checkbox][name=delete_review]:checked").length == 0 ){
				    alert("삭제할 항목을 하나이상 체크해요.");
				    return;
				}
					
				$("#delete").attr({
					"method" : "post",
					"action" : "<%=contextPath%>/reviewDelete.my"
				})
				$("#delete").submit();
	       });
	       
	       </script>
	   
	      <%--
	       function deletebtn(delete_review) {
	    	   
	    	  
	    	   if($("input:checkbox[name=delete_review]").is(":checked") == true) {
		    	   
	    		   var con = confirm('정말 삭제하시겠습니까?');
		    	   var num = "";
	    	 
		    	   $("input[name=delete_review]:checked").each(function() { 
		    		   var test = $(this).parents('td').parents('tr').children().eq(1).text(); 
		    		   num += test+',';
		    	   });		    	   
		    	    
		    	   alert(num);
		    	   
	    		 }else {
	    			alert('삭제할 항목을 선택해주세요.');
	    		 }  			    	   
	       }
	       </script>   --%>
	      
	       
	       
		<!-- 페이징바 -->
		<%if(content == null){ %>
	        <div class="pagination" align="center" style="margin-top: 60px; margin-left: 50%;">
	     		<%if(currentPage != 1){ %>
	     			<!-- 맨 처음으로(<<) -->
	     			<a href="<%=contextPath%>/review.my?currentPage=1&userNo=<%=loginUser.getUserNo()%>" class=" btn-prev"><i class="fa fa-chevron-circle-left"></i>Prev</a>
	            <%} %>
	            
	            <%for(int p=startPage; p<=endPage; p++){ %>
	            	<%if(p!=currentPage){ %>
		           		<a href="<%=contextPath%>/review.my?currentPage=<%=p%>&userNo=<%=loginUser.getUserNo()%>"><span><%=p %></span></a>
		            <%}else { %>
		            	<a href="javascript:void(0);"><span><%=p %></span></a>
		            <%} %>
	            <%} %>
	            
	            <%if(currentPage != maxPage){ %>
	            	<!-- 맨 끝으로(>>) -->
	            	<a href="<%=contextPath%>/review.my?currentPage=<%=maxPage%>&userNo=<%=loginUser.getUserNo()%>" class=" btn-next"><i class="fa fa-chevron-circle-right"></i>NEXT</a>
	            <%} %>
	        </div>
	     <%} else{ %>
	        <div class="pagination" align="center" style="margin-top: 60px; margin-left: 50%;">
		     		<%if(currentPage != 1){ %>
		     			<!-- 맨 처음으로(<<) -->
		     			<a href="<%=contextPath%>/review_content.my?currentPage=1&userNo=<%=loginUser.getUserNo()%>&content=<%=content%>" class=" btn-prev"><i class="fa fa-chevron-circle-left"></i>Prev</a>
		            <%} %>
		            
		            <%for(int p=startPage; p<=endPage; p++){ %>
		            	<%if(p!=currentPage){ %>
			           		<a href="<%=contextPath%>/review_content.my?currentPage=<%=p%>&userNo=<%=loginUser.getUserNo()%>&content=<%=content%>"><span><%=p %></span></a>
			            <%}else { %>
			            	<a href="javascript:void(0);"><span><%=p %></span></a>
			            <%} %>
		            <%} %>
		            
		            <%if(currentPage != maxPage){ %>
		            	<!-- 맨 끝으로(>>) -->
		            	<a href="<%=contextPath%>/review_content.my?currentPage=<%=maxPage%>&userNo=<%=loginUser.getUserNo()%>&content=<%=content%>" class=" btn-next"><i class="fa fa-chevron-circle-right">&gt;&gt;</i>Next</a>
		            <%} %>
		     </div>
        <%} %>
        
        
        
        
    </div>
</body>
</html>