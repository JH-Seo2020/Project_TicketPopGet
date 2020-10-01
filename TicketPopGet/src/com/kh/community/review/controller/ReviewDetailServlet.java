package com.kh.community.review.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.community.adBoard.model.service.AdBoardService;
import com.kh.community.adBoard.model.vo.AdBoard;
import com.kh.community.review.model.service.ReviewService;
import com.kh.community.review.model.vo.Review;

/**
 * Servlet implementation class ReviewDetailServlet
 */
@WebServlet("/review.detail")
public class ReviewDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		
		// 1. 조회수 올리기
		int reviewCount = new ReviewService().plusCount(reviewNo);
		
		if(reviewCount >0) {
			//2-1. 객체조회
			Review r = new ReviewService().reviewDetail(reviewNo);
			//2-2. 내용조회(clob to string)
			String reviewContent = new ReviewService().reviewContent(reviewNo);
			
			request.setAttribute("r", r);
			request.setAttribute("reviewContent", reviewContent);
			request.getRequestDispatcher("views/community/review/reviewDetailView.jsp").forward(request, response);
			
		}else {
			//오류페이지 띄워주기
			request.setAttribute("errorMsg", "리뷰게시글 조회 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
