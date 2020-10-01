package com.kh.user.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.user.model.service.MyPageService;
import com.kh.user.model.vo.MyPage;
import com.kh.user.model.vo.PageInfo;

/**
 * Servlet implementation class MyPage_review
 */
@WebServlet("/review.my")
public class MyPageReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageReview() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		if(userNo>0) {
			// ---------------- 페이징처리 ----------------
			int listCount; // 현재 총 게시글 개수
			int currentPage; // 현재 페이지 (즉, 요청한 페이지)
			int pageLimit; // 한 페이지 하단에 보여질 페이지 최대개수
			int boardLimit; // 한 페이지내에 보여질 게시글 최대개수

			int maxPage; // 전체 페이지들 중에서의 가장 마지막 페이지
			int startPage; // 현재 페이지에 하단에 보여질 페이징 바의 시작 수
			int endPage; // 현재 페이지에 하단에 보여질 페이징 바의 끝 수

			listCount = new MyPageService().selectReviewListCount(userNo);

			currentPage = Integer.parseInt(request.getParameter("currentPage"));
			
			pageLimit = 10;

			boardLimit = 5;

			maxPage = (int) Math.ceil((double) listCount / boardLimit);

			startPage = (currentPage - 1) / pageLimit * pageLimit + 1;

			endPage = startPage + pageLimit - 1;

			if (maxPage < endPage) {
				endPage = maxPage;
			}

			PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);

			ArrayList<MyPage> mps = new MyPageService().selectReviewList(userNo, pi);
			
			request.setAttribute("mps", mps);
			request.setAttribute("pi", pi);
		
			RequestDispatcher view = request.getRequestDispatcher("views/user/myPage/review.jsp");
			view.forward(request, response);
		}else {
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
