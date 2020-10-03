<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.common.model.vo.MainContent" %>
<%
	ArrayList<MainContent> rank = (ArrayList<MainContent>)request.getAttribute("rank");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        #wrap_rank{
            width: 1200px;
            height: 1700px;
            margin: auto;
            margin-top : 30px;
        }
        /*랭킹*/
        #rankHead{
            font-size: 45px;
            margin-top: 10px;
            margin-bottom: 30px;
            height: 7%;
            text-align: center;
        }
        #rankBody{
            width: 100%;
            height: 80%
        }
        #rankGenre, #rankGroup{
            margin: 20px;
        }
        #rankGroup{text-align: right;}
        #rankFooter{color:gray;}
        td{vertical-align: middle !important;}
        a{text-decoration: none !important; color: black !important;}
</style>
</head>
<body>
<%@ include file="/views/common/menubar.jsp" %>
    <div id="wrap_rank">
        <div id="rankHead">
            <b>랭킹</b>
        </div>
        <div id="rankBody">
            <div id="rankGenre">
                <!-- <a class="btn btn-warning">콘서트</a> 
                <a class="btn btn-warning">연극</a> 
                <a class="btn btn-warning">전시</a> -->
            </div>
            <div id="rankGroup">
                <!--<a class="btn btn-warning">연령별</a>
                <a class="btn btn-warning">성별</a>
                <a class="btn btn-warning">주간예매율</a>-->
            </div>
            <table class="table table-striped">
                <tr align="center">
                    <th>순위</th>
                    <th>포스터</th>
                    <th>컨텐츠명</th>
                    <th>예매율</th>
                    <th>공연시작날짜</th>
                </tr>
                <%if(rank.isEmpty()){ %>
                	<td colspan=6>보여드릴 순위가 없습니다.</td>
                <%}else{ %>
                	<%for(MainContent r : rank){ %>
		                <tr align="center">
		                    <td><%=r.getRownum() %></td>
		                    <td><img src="<%=contextPath %>/<%=r.getImgPath() %>/<%=r.getChangeImg() %>" width="70px;" height="100px;"></td>
		                    <td><a href="<%=contextPath%>/'<%=r.getTitle()%>'.detail?contentNo=<%=r.getContentNo()%>"><%=r.getGenre() %> : <%=r.getTitle() %></a></td>
		                    <td><%=r.getRate() %> %</td>
		                    <td><%=r.getConcertDate() %></td>
		                </tr>
		           <%} %>
                <%} %>
            </table>
            
        </div>
        <div id="rankFooter">
	    	<hr>
	    	<span><b> 본 통계는 콘서트, 연극 컨텐츠 기반 예매율을 보여드립니다.</b></span><br>
	    </div>
    
    </div>
</body>
</html>