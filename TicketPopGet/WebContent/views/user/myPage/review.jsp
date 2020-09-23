<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <div id="review">
        <!-- 헤더부분 -->
        <div class="reservation_check1">
            <h3 style="margin-bottom: 20px;"><b>나의관람후기</b></h3>
        </div>

        <!-- 컨텐츠분류 -->
        <div class="contents_btn" align="right">
            <button class="btn btn-outline-warning">전체</button> 
            <button class="btn btn-outline-warning">콘서트</button>
            <button class="btn btn-outline-warning">연극</button>
            <button class="btn btn-outline-warning">전시</button>
        </div>

        <!-- 관람후기테이블 -->

        <div class="container reservation_check3" style="margin-left: 70px; margin-top:50px;">          
            <table class="table table-hover" style="width: 950px; height: 70px; margin-left: 30px; text-align: center;">
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
                <tr>
                  <td><input type="checkbox" name="delete_review"></td>
                        <td>1</td>
                        <td>어떤공연일까</td>
                        <td>어떤제목</td>
                        <td>2020-09-28</td>
                </tr>
                <tr>
                    <td><input type="checkbox" name="delete_review"></td>
                    <td>1</td>
                    <td>어떤공연일까</td>
                    <td>어떤제목</td>
                    <td>2020-09-28</td>
                  </tr>
                  <tr>
                    <td><input type="checkbox" name="delete_review"></td>
                    <td>1</td>
                    <td>어떤공연일까</td>
                    <td>어떤제목</td>
                    <td>2020-09-28</td>
                  </tr>
                  <tr>
                    <td><input type="checkbox" name="delete_review"></td>
                    <td>1</td>
                    <td>어떤공연일까</td>
                    <td>어떤제목</td>
                    <td>2020-09-28</td>
                  </tr>
                  <tr>
                    <td><input type="checkbox" name="delete_review"></td>
                    <td>1</td>
                    <td>어떤공연일까</td>
                    <td>어떤제목</td>
                    <td>2020-09-28</td>
                  </tr>
              </tbody>
            </table>
          </div>

          <div id="delete_review_btn" align="right">
              <button>삭제</button>
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