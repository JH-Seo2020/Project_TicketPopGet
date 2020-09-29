<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.kh.user.model.vo.Member" %>
<%
	String contextPath = request.getContextPath();
	
	Member loginUser = (Member)session.getAttribute("loginUser");
	String alertMsg = (String)session.getAttribute("alertMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴바</title>
<!-- 제이쿼리 CDN 포함해서 올립니다 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>

<style>
	#wrap{
	    width: 1200px;
	    height: 220px;
	    margin: auto;
	    box-sizing: border-box;
	}
	
	/* 헤더, 헤더 내 첫번째 div */
	#header{
	    height: 60%; 
	}
	#header>div{
	    float: left;
	    height: 100%;
	    box-sizing: border-box;
	}
	/* 헤더 내 첫번째 div */
	#logoSpace{
	    line-height: 110px;
	    font-size: 30px;
	    width: 30%;
	}
	/* 헤더 내 두번째 div */
	#search{width: 33%;}
	form{width: 100%; height: 100%;}
	#searchBar{
	    height: 40%; 
	    width: 80%; 
	    margin-top: 30px;
	}
	#searchBtn{
	    height: 40%;
	    border: none;
	    background-color: #ffb300;
	}
	/* 헤더 내 세번째 div */
	#loginSpace{
	    width: 33%;
	    text-align: right;
	}
	
	/* loginSpace내 div */
	#loginSpace>label{
	    padding: 5%;
	    margin-top: 25px;
	    display: inline-block;
	}
	
	  /* 메뉴바 */
	#navigator{
	    height: 50%;
	}
	.menubar{
	    text-align: center;
	    word-spacing: 150px;
	    height: 100%;
	}
	#list{
	    height: 50%;
	    margin: 0% ; 
	    padding-top: 10px;
	    box-shadow: 0 1px 1px 0 rgba(0,0,0,.12);
	}
	#list li{
	    list-style: none;
	    display: inline-block;
	    height: 100%;
	    font-size: 25px;
	    color:#ffb300;
	    font-weight: bold;
	    transform: scale(1.1);
	}
	#innerList{
	    height: 30%;
	    background-color: #ffb300;
	    display: none;
	    margin: 0%; 
	    padding-top: 5px;
	}
	#innerList li{
	    list-style: none;
	    display: inline;
	    font-size: 18px;
	}
	/* a 태그 href 밑줄속성 지우려고 만든거*/
	.menubar_a{text-decoration: none !important; color: black !important;}
	
</style>
<script>
	$(function(){
		// var msg =  "메세지" / "null" 
		var msg = "<%= alertMsg%>"; 
	
		if(msg != "null"){ // 메세지가 담겨있을 경우
			alert(msg);
			// 알람창 띄워준 후에 session에 담긴 메세지 지워야됨
			// 안그러면 menubar.jsp가 포함되어있는 페이지 열때마다 alert 계속 뜰거임
			<% session.removeAttribute("alertMsg"); %> // 페이지 끄면 소멸됨
		}
	});
</script>
</head>
<body>

	<div id="wrap">
        <div id="header">
      
	            <div id="logoSpace">
	                <a class="menubar_a" href="<%=request.getContextPath()%>"><img src="" width="90%">TicketPopGet로고</a>
	            </div>
	
	            <div id="search" align="center">
	                <form>
	                    <input type="search" id="searchBar" placeholder="검색창">
	                    <button id="searchBtn">검색</button>
	                </form>
	            </div>
		<%if(loginUser == null){ %>
	            <div id="loginSpace" align="right">
	                <label><a class="menubar_a" href="<%=contextPath%>/loginview.me">로그인</a></label>
	                <label><a class="menubar_a" href="<%=contextPath%>/enrollForm.me">회원가입</a></label>
	                <label><a class="menubar_a" href="<%= contextPath %>/list.no?currentPage=1">고객센터</a></label>
	            </div>
            <%} else{ %>
                <div id="loginSpace" align="right";>
                <label><a class="menubar_a" href="<%=request.getContextPath()%>/logout.me">로그아웃</a></label>
                <label><a class="menubar_a" href="<%=contextPath%>/mypage.my">마이페이지</a></label>
                <label><a class="menubar_a" href="<%= contextPath %>/list.no?currentPage=1">고객센터</a></label>
                </div>
              <%} %>
        </div>
        

        <div id="navigator">
            <div class="menubar"> 
                <ul id="list" >
                    <li><a class="menubar_a" href="<%=contextPath%>/concert.co?currentPage=1">콘서트</a></li>
                    <li><a class="menubar_a" href="<%=contextPath%>/play.co?currentPage=1">연극</a></li>
                    <li><a class="menubar_a" href="<%=contextPath%>/exhibition.co?currentPage=1">전시</a></li>
                    <li id="menuCommu"><a class="menubar_a" href="">커뮤니티</a></li>
                </ul>
                <ul id="innerList">
                    <li><a class="menubar_a" href="">후기</a></li>
                    <li><a class="menubar_a" href="<%=contextPath%>/event.co?currentPage=1">댓글이벤트</a></li>
                    <li><a class="menubar_a" href="<%=contextPath%>/adboard.co?currentPage=1">홍보게시판</a></li>
                    <li><a class="menubar_a" href="<%=contextPath%>/event.result?currentPage=1">이벤트결과발표</a></li> 
                </ul>

                <script>
                    $(function(){
                        $("#menuCommu").mouseover(function(){
                            $("#innerList").slideDown();
                            $("#innerList").css("display","block");
                        });

                        $("#innerList").hover(function(){
                            $(this).css("display","block");
                        },function(){
                            $(this).slideUp();
                        });
                    });
                </script>
            
            </div>

        </div>

    </div>

</body>
</html>