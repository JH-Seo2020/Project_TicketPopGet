<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴바</title>
<!-- 제이쿼리 CDN 포함해서 올립니다 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
	a{text-decoration: none; color: black;}
	
</style>
</head>
<body>

	<div id="wrap">
        <div id="header">
            
            <div id="logoSpace">
                <a href=""><img src="" width="90%">TicketPopGet로고</a>
            </div>

            <div id="search" align="center">
                <form>
                    <input type="search" id="searchBar" placeholder="검색창">
                    <button id="searchBtn">검색</button>
                </form>
            </div>

            <div id="loginSpace" align="right">
                <label><a href="">로그인</a></label>
                <label><a href="">회원가입</a></label>
                <label><a href="">고객센터</a></label>
            </div>

            <!-- 로그인 시 보여질 부분
                <div id="loginSpace" align="right";>
                <label>로그아웃</label>
                <label>마이페이지</label>
                <label>고객센터</label>
                </div>

            -->
        </div>

        <div id="navigator">
            <div class="menubar"> 
                <ul id="list" >
                    <li><a href="">콘서트</a></li>
                    <li><a href="">연극</a></li>
                    <li><a href="">전시</a></li>
                    <li id="menuCommu"><a href="">커뮤니티</a></li>
                </ul>
                <ul id="innerList">
                    <li><a href="">후기</a></li>
                    <li><a href="">댓글이벤트</a></li>
                    <li><a href="">홍보게시판</a></li>
                    <li><a href="">이벤트결과발표</a></li> 
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