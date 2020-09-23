<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#wrap_play{
           width: 1200px;
           height: 2000px;
           margin: auto;
           box-sizing: border-box;
       }
	
	/*세부 조회 메인 - 전시 지역 설정하는 부분*/
	#playLocal{
	    height: 10%; 
	    width: 100%;
	    text-align: center;
	    margin-top: 5px;
	    padding-top: 50px;
	    font-size: 30px;    
	}
	#playLocal>select{height: 40%; width: 15%; font-size: 25px;}
	#playLocal>select>option { font-size: 15px;}
	
	/* 전시 포스터 보여지는 부분(12개, 페이징버튼)*/
	#playList{
	    margin-top: 5px;
	    height: 70%;
	    width: 100%;
	}
	#posterBody{width: 100%;height: 80%;}
	#posterBody>li{
	    list-style-type: none;
	    display:inline-block;
	    width: 30%;
	    height: 30%;
	}
	#playTitle{
	    font-size: 25px;
	}
	
	/*paging 버튼*/
	#playPaging{
	    text-align: center;
	    margin-top: 30px;
	}
	#playPaging button{
	    width: 40px;
	    height: 40px;
	    border: none;
	    color: white;
	    background-color: #ffb300;
	    border-radius: 5px;
	}
	/*a태그 밑줄없애기*/
	a{text-decoration: none !important; color: balck !important;}
</style>
</head>
<body>

	<%@ include file="/views/common/menubar.jsp" %>

	<div id="wrap_play">

        <div id="playLocal">
            <label>연극 &lt; </label>
            <select>
                <option>전체</option>
                <option>서울/경기권</option>
                <option>강원/충청권</option>
                <option>전라권</option>
                <option>경상/제주권</option>
            </select>
        </div>

        <div id="playList" align="center">
            
            
            <ul id="posterBody">
                <li>
                    <span><img src="../resources/연극포스터_3.jpg" height="200px" width="150px"></span>
                    <div id=playTitle><b><a href="">'메밀꽃 필 무렵'</a></b></div>
                    <div>2020.01.01</div>
                    <div>#한국#문학#봉평#메밀꽃#강원</div>
                </li>
                <li>
                    <span><img src="../resources/연극포스터_3.jpg" height="200px" width="150px"></span>
                    <div id=playTitle><b><a href="">'메밀꽃 필 무렵'</a></b></div>
                    <div>2020.01.01</div>
                    <div>#한국#문학#봉평#메밀꽃#강원</div>
                </li>
                <li>
                    <span><img src="../resources/연극포스터_3.jpg" height="200px" width="150px"></span>
                    <div id=playTitle><b><a href="">'메밀꽃 필 무렵'</a></b></div>
                    <div>2020.01.01</div>
                    <div>#한국#문학#봉평#메밀꽃#강원</div>
                </li>
                <li>
                    <span><img src="../resources/연극포스터_3.jpg" height="200px" width="150px"></span>
                    <div id=playTitle><b><a href="">'메밀꽃 필 무렵'</a></b></div>
                    <div>2020.01.01</div>
                    <div>#한국#문학#봉평#메밀꽃#강원</div>
                </li>
                <li>
                    <span><img src="../resources/연극포스터_3.jpg" height="200px" width="150px"></span>
                    <div id=playTitle><b><a href="">'메밀꽃 필 무렵'</a></b></div>
                    <div>2020.01.01</div>
                    <div>#한국#문학#봉평#메밀꽃#강원</div>
                </li>
                <li>
                    <span><img src="../resources/연극포스터_3.jpg" height="200px" width="150px"></span>
                    <div id=playTitle><b><a href="">'메밀꽃 필 무렵'</a></b></div>
                    <div>2020.01.01</div>
                    <div>#한국#문학#봉평#메밀꽃#강원</div>
                </li>
                <li>
                    <span><img src="../resources/연극포스터_3.jpg" height="200px" width="150px"></span>
                    <div id=playTitle><b><a href="">'메밀꽃 필 무렵'</a></b></div>
                    <div>2020.01.01</div>
                    <div>#한국#문학#봉평#메밀꽃#강원</div>
                </li>
                <li>
                    <span><img src="../resources/연극포스터_3.jpg" height="200px" width="150px"></span>
                    <div id=playTitle><b><a href="">'메밀꽃 필 무렵'</a></b></div>
                    <div>2020.01.01</div>
                    <div>#한국#문학#봉평#메밀꽃#강원</div>
                </li>
                <li>
                    <span><img src="../resources/연극포스터_3.jpg" height="200px" width="150px"></span>
                    <div id=playTitle><b><a href="">'메밀꽃 필 무렵'</a></b></div>
                    <div>2020.01.01</div>
                    <div>#한국#문학#봉평#메밀꽃#강원</div>
                </li>
                <li>
                    <span><img src="../resources/연극포스터_3.jpg" height="200px" width="150px"></span>
                    <div id=playTitle><b><a href="">'메밀꽃 필 무렵'</a></b></div>
                    <div>2020.01.01</div>
                    <div>#한국#문학#봉평#메밀꽃#강원</div>
                </li>
                <li>
                    <span><img src="../resources/연극포스터_3.jpg" height="200px" width="150px"></span>
                    <div id=playTitle><b><a href="">'메밀꽃 필 무렵'</a></b></div>
                    <div>2020.01.01</div>
                    <div>#한국#문학#봉평#메밀꽃#강원</div>
                </li>
                <li>
                    <span><img src="../resources/연극포스터_3.jpg" height="200px" width="150px"></span>
                    <div id=playTitle><b><a href="">'메밀꽃 필 무렵'</a></b></div>
                    <div>2020.01.01</div>
                    <div>#한국#문학#봉평#메밀꽃#강원</div>
                </li>
            </ul>
            
        </div>

        <div id="playPaging">
            <button>&lt;&lt;</button>
            <button>&lt;</button>
            <button>1</button>
            <button>2</button>
            <button>3</button>
            <button>4</button>
            <button>5</button>
            <button>&gt;</button>
            <button>&gt;&gt;</button>
        </div>

    </div>

</body>
</html>