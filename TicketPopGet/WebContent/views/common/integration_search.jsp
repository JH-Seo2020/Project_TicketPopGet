<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>통합검색창</title>
 <style>
/* 공통사항 */
#search_result1 input, #search_button1, #search_button2:focus{outline: none;}

/* 큰 틀 */
.detailed_search{ height: 1000px;}
/* 통합검색 상세조회 */
.search_result1 {
    margin-top: 100px;
    margin-left: 100px;
    font-size: 30px;
    border: 1px solid slategray;
    width: 1000px;
    height: 200px;
    background-color:slategray;
}

#search_result1 input{
    width: 300px;
    height: 25px;
    border: none;
    background-color: slategray;
    border-bottom: 1px solid black;
}

#search_button1{
    background: rgba(0,0,0,0);
    border:none;
    cursor: pointer;
    position:absolute;
    margin-top: 10px;
}

/* 지역,분류,관람기간 상세조회 */
.search_result2 {
    width: 1000px;
    height: 55px;
    margin-left: 100px;
    border: 1px solid black;
}

.search_result2 ul{
    display: block;
}

.search_result2 ul>li{
    list-style: none;
    float: left;
}

#search_button2{
    background-color: white;
    border:1px solid orange;
    cursor: pointer;
}

/* 검색결과 내용 */
.search_result3{
    margin-left: 100px;
    margin-top: 60px;
    border-top: 1px solid black;
    border-width: medium;
    width: 1000px;
    height: 500px;
}

.search_result_list{
    width: 1000px;
    margin-top: 25px;
    padding-bottom: 25px;
    border-bottom:1px solid gray;
    float: left;
}

.search_result_list div{float: left;}

#search_result_content{
    margin-left: 120px;
    font-size: 19px;
    margin-top:10px;
}
#search_result_content a{
    text-decoration: none;
    color: black;
}

#search_result_reservation{
    margin-left: 250px;
    margin-top: 80px;
    font-size: 20px;
    width: 110px;
    text-align: center;
    background: coral;
    color: cornsilk;
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
<body>
    <!-- 메뉴바 넣기 -->

    <!-- 상세조회 검색 창 -->
    <div class="detailed_search" align="center">
        <form action="">
            <!-- 검색결과입니다 -->
            <div class="search_result1">
                <p style="height: 50px;">
                    <span style="color:red; font-weight: bold; line-height: 70px;">'검색'</span>
                    에 대한 검색 결과 입니다.
                </p>
                <div id="search_result1">
                    <input type="text" >
                    <!-- 버튼 누르면 검색결과 나오게->동기식? 비동기식? -->
                    <!-- 이미지 경로 : 기본설정이 views/common으로 돼있기 때문에 .. /TicketPopGet/resources/img/imgForSearch/search.png 요로콤,,해야됨.. 기억하기..  -->
                    <button id="search_button1"><img src="/TicketPopGet/resources/img/imgForSearch/search.png"  width="30px" height="30px"></button>
                </div>
            </div>

            <!-- 지역,분류,관람기간 상세조회 -->
            <div class="search_result2">
                <!-- 지역 -->
                <ul>
                    <li>
                        <select style="margin-left: 40px; width: 150px; height: 30px;">
                            <option>지역</option>
                            <option>서울/경기권</option>
                            <option>강원/충천권</option>
                            <option>전라권</option>
                            <option>경상권/제주</option>
                        </select>
                    </li>
                </ul>
                <!-- 분류 -->
                <ul>
                    <li>
                        <select style="margin-left: 30px; width: 150px; height: 30px;">
                            <option>분류</option>
                            <option>콘서트</option>
                            <option>연극</option>
                            <option>전시</option>
                        </select>
                    </li>
                </ul>
                <!-- 관람기간 -->
                <ul>
                    <li style="margin-left: 30px; font-size: 17px;">
                        관람기간 <input type="date" style="width: 150px; height: 30px; margin-left: 5px;"> - <input type="date" style="width: 150px; height: 30px;">
                    </li>
                    <li>
                        <button type="submit" id="search_button2" style="width: 70px; height: 30px; margin-left: 20px;">조회하기</button>
                    </li>
                </ul>
            </div>
        </form>
        
        
        <!-- 검색결과 한페이지당 목록은 4개만 보여줄것 -->
        <div class="search_result3">
            <!-- 목록하나 -->
            <div class="search_result_list">
                <!-- 이미지 -->
                <div id="search_result_img" style="margin-left: 70px;">
                    <a href=""><img src="/TicketPopGet/resources/post_upfiles/111111111111.PNG" width="150" ></a>
                </div>
                <!-- 검색내용 -->
                <div id="search_result_content">
                    <h3><b><a href="">공연명</a></b></h3>
                    <p>
                        장 소 : 장소입니다 <br>
                        기 간 : 기간입니다 <br>
                        가 격 : 가격입니다 <br>
                    </p>
                </div>
                <!-- 예매상황 // 진행중 -->
                <div id="search_result_reservation">
                    <span>예매진행중</span>
                </div>
            </div>

            <!-- 목록하나 -->
                <div class="search_result_list">
                <!-- 이미지 -->
                <div id="search_result_img" style="margin-left: 70px;">
                    <a href=""><img src="/TicketPopGet/resources/post_upfiles/111111111111.PNG" width="150" ></a>
                </div>
                <!-- 검색내용 -->
                <div id="search_result_content">
                    <h3><b><a href="">공연명</a></b></h3>
                    <p>
                        장 소 : 장소입니다 <br>
                        기 간 : 기간입니다 <br>
                        가 격 : 가격입니다 <br>
                    </p>
                </div>
                <!-- 예매상황 // 종료 색 바뀌게해야됨 -->
                <div id="search_result_reservation">
                    <span>예매종료</span>
                </div>
            </div>
        </div> 

        <!-- 페이징바 -->
        <div class="pagination" style="margin:auto; margin-top:40px">
            <a href="" class=" btn-prev"><i class="fa fa-chevron-circle-left"></i> Prev</a>
            <a href=""><span>1</span></a>
            <a href=""><span>2</span></a>
            <a href=""><span>3</span></a>
            <a href=""><span>4</span></a>
            <a href=""><span>5</span></a>
            <a href=""><span>6</span></a>
            <a href=""><span>7</span></a>
            <a href=""><span>8</span></a>
            <a href=""><span>9</span></a>
            <a href=""><span>10</span></a>
            <a href="" class=" btn-next">Next <i class="fa fa-chevron-circle-right"></i></a>
        </div>
        </div>  

</body>
</html>