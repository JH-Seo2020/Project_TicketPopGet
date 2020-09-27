<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>찜리스트</title>
   <style>
#wishlist{
          width: 1200px;
            height: 1500px;
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
        margin-top: 80px;
        margin-right: 150px;
    }
    /* 찜리스트목록 */
    .wishlist_area{
        margin-top: 70px;
        margin-left: 120px;
        width: 2000px;
        cursor: pointer;
    }
    /* 찜리스트목록 세부 항목 */
    .wishlist{
        display: inline-block;
        padding-left: 90px;
        position: relative;
    }
    /* 찜여부버튼 */
    .wishlist_btn button{
        position:absolute;
        top:3%;
        right:0%;
        background-color: transparent !important;
        border: 0;
        outline: 0;
        cursor: pointer;
        background: rgba(0,0,0,0);
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

<div id="wishlist">
        <!-- 헤더부분 -->
        <div class="reservation_check1">
            <h3 style="margin-bottom: 20px;"><b>찜리스트</b></h3>
        </div>

        <!-- 컨텐츠분류 -->
        <div class="contents_btn" align="right">
            <button class="btn btn-outline-warning">전체</button> 
            <button class="btn btn-outline-warning">콘서트</button>
            <button class="btn btn-outline-warning">연극</button>
            <button class="btn btn-outline-warning">전시</button>
        </div>

        <!-- 찜리스트 목록 -->
        <div class="wishlist_area">
            <div class="wishlist" align="center"> 
                <img src="image/연극1.PNG" width="200" height="250"><br>
                <div class="wishlist_btn"><button type="button" class="like_btn"><img src="image/like_heart.png" width="30" height="30"></button></div>
                <p>공연제목 <br>
                                           예매상황
                </p>
            </div>
        </div>
        
     <!-- 페이징바 -->
          <div class="pagination" style="margin-top: 60px; margin-left: 30%;">
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