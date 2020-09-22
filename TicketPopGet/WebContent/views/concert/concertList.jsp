<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        #wrap_concert{
            width: 1200px;
            height: 2000px;
            margin: auto;
            box-sizing: border-box;
        }
        
        /*세부 조회 메인 - 콘서트 지역 설정하는 부분*/
        #concertLocal{
            height: 10%; 
            width: 100%;
            text-align: center;
            margin-top: 5px;
            padding-top: 50px;
            font-size: 30px;    
        }
        #concertLocal>select{height: 40%; width: 15%; font-size: 25px;}
        #concertLocal>select>option { font-size: 15px;}

        /* 콘서트 포스터 보여지는 부분(12개, 페이징버튼)*/
        #concertList{
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
        #concertTitle{
            font-size: 25px;
        }

        /*paging 버튼*/
        #concertPaging{
            text-align: center;
            margin-top: 30px;
        }
        #concertPaging button{
            width: 40px;
            height: 40px;
            border: none;
            color: white;
            background-color: #ffb300;
            border-radius: 5px;
        }
        /*a태그 밑줄없애기*/
        a{text-decoration: none !important; color:black !important;}
    </style>
</head>
<body>
	<%@ include file="/views/common/menubar.jsp" %>
	
	<div id="wrap_concert">

        <div id="concertLocal">
            <label>콘서트 &lt; </label>
            <select>
                <option>전체</option>
                <option>서울/경기권</option>
                <option>강원/충청권</option>
                <option>전라권</option>
                <option>경상/제주권</option>
            </select>
        </div>

        <div id="concertList" align="center">
            
            
            <ul id="posterBody">
                <li>
                    <span><img src="../포스터모음/공연포스터_1.jpg" height="200px" width="150px"></span>
                    <div id=concertTitle><b><a href="">신용재 콘서트</a></b></div>
                    <div>2020.01.01</div>
                    <div>#누군지#모르는#콘서트#신용재#서울</div>
                </li>
                <li>
                    <span><img src="../포스터모음/공연포스터_2.jpg" height="200px" width="150px"></span>
                    <div id=concertTitle><b><a href="">오즈프로젝트 콘서트</a></b></div>
                    <div>2020.02.02</div>
                    <div>#오즈#마법사#동화#존잼#서울</div>
                </li>
                <li>
                    <span><img src="../포스터모음/공연포스터_4.jpg" height="200px" width="150px"></span>
                    <div id=concertTitle><b><a href="">고릴라즈 내한콘서트</a></b></div>
                    <div>2020.03.03</div>
                    <div>#영국#락#고릴라즈#내한기념#서울</div>
                </li>
                <li>
                    <span><img src="../포스터모음/공연포스터_4.jpg" height="200px" width="150px"></span>
                    <div id=concertTitle><b><a href="">고릴라즈 내한콘서트</a></b></div>
                    <div>2020.03.03</div>
                    <div>#영국#락#고릴라즈#내한기념#서울</div>
                </li>
                <li>
                    <span><img src="../포스터모음/공연포스터_4.jpg" height="200px" width="150px"></span>
                    <div id=concertTitle><b><a href="">고릴라즈 내한콘서트</a></b></div>
                    <div>2020.03.03</div>
                    <div>#영국#락#고릴라즈#내한기념#서울</div>
                </li>
                <li>
                    <span><img src="../포스터모음/공연포스터_4.jpg" height="200px" width="150px"></span>
                    <div id=concertTitle><b><a href="">고릴라즈 내한콘서트</a></b></div>
                    <div>2020.03.03</div>
                    <div>#영국#락#고릴라즈#내한기념#서울</div>
                </li>
                <li>
                    <span><img src="../포스터모음/공연포스터_4.jpg" height="200px" width="150px"></span>
                    <div id=concertTitle><b><a href="">고릴라즈 내한콘서트</a></b></div>
                    <div>2020.03.03</div>
                    <div>#영국#락#고릴라즈#내한기념#서울</div>
                </li>
                <li>
                    <span><img src="../포스터모음/공연포스터_4.jpg" height="200px" width="150px"></span>
                    <div id=concertTitle><b><a href="">고릴라즈 내한콘서트</a></b></div>
                    <div>2020.03.03</div>
                    <div>#영국#락#고릴라즈#내한기념#서울</div>
                </li>
                <li>
                    <span><img src="../포스터모음/공연포스터_4.jpg" height="200px" width="150px"></span>
                    <div id=concertTitle><b><a href="">고릴라즈 내한콘서트</a></b></div>
                    <div>2020.03.03</div>
                    <div>#영국#락#고릴라즈#내한기념#서울</div>
                </li>
                <li>
                    <span><img src="../포스터모음/공연포스터_4.jpg" height="200px" width="150px"></span>
                    <div id=concertTitle><b><a href="">고릴라즈 내한콘서트</a></b></div>
                    <div>2020.03.03</div>
                    <div>#영국#락#고릴라즈#내한기념#서울</div>
                </li>
                <li>
                    <span><img src="../포스터모음/공연포스터_4.jpg" height="200px" width="150px"></span>
                    <div id=concertTitle><b><a href="">고릴라즈 내한콘서트</a></b></div>
                    <div>2020.03.03</div>
                    <div>#영국#락#고릴라즈#내한기념#서울</div>
                </li>
                <li>
                    <span><img src="../포스터모음/공연포스터_4.jpg" height="200px" width="150px"></span>
                    <div id=concertTitle><b><a href="">고릴라즈 내한콘서트</a></b></div>
                    <div>2020.03.03</div>
                    <div>#영국#락#고릴라즈#내한기념#서울</div>
                </li>
            </ul>
            
        </div>

        <div id="concertPaging">
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