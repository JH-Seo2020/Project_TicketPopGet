package com.kh.user.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.user.model.service.MyPageService;
import com.kh.user.model.vo.MyPage;

/**
 * Servlet implementation class MyPageReviewWriteInsert
 */
@WebServlet("/reviewInsert.my")
public class MyPageReviewWriteInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageReviewWriteInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String content = request.getParameter("editordata");

		int userNo = Integer.parseInt(request.getParameter("userNo"));
		int cno = Integer.parseInt(request.getParameter("cno"));
		int tno = Integer.parseInt(request.getParameter("tno"));
		Date reviewdate = java.sql.Date.valueOf(request.getParameter("reviewdate"));
		int reviewpoint = Integer.parseInt(request.getParameter("reviewpoint"));
		String reviewtitle = request.getParameter("reviewtitle");
		
		MyPage mp = new MyPage();
		mp.setUserNo(userNo);
		mp.setContentNo(cno);
		mp.setTicketNo(tno);
		mp.setReviewDate(reviewdate);
		mp.setReviewPoint(reviewpoint);
		mp.setReviewTitle(reviewtitle);
		
		int result = new MyPageService().reviewInsert(mp, content);
		
		if(result>0) {
			request.getSession().setAttribute("alertMsg", "등록되었습니다.");
			response.sendRedirect(request.getContextPath() + "/review.my?currentPage=1&userNo="+userNo);
		}else {
			System.out.println("에러");
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
