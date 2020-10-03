package com.kh.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.user.model.service.MyPageService;
import com.kh.user.model.vo.MyPage;

/**
 * Servlet implementation class MyPage_review_detail
 */
@WebServlet("/review_detail.my")
public class MyPageReviewDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageReviewDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int rno = Integer.parseInt(request.getParameter("rno"));
		int uno = Integer.parseInt(request.getParameter("userNo"));
		
		if(rno>0) {
			MyPage mp = new MyPageService().selectReviewDetail(rno,uno);
			String content = new MyPageService().selectReviewContent(rno,uno);
			
			request.setAttribute("mp", mp);
			request.setAttribute("content", content);
			
			request.getRequestDispatcher("views/user/myPage/review_detail.jsp?rno="+rno+"userNo"+uno).forward(request, response);
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
