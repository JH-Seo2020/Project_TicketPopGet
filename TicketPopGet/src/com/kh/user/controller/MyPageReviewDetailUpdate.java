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
 * Servlet implementation class MyPageReviewDetailUpdate
 */
@WebServlet("/review_update.my")
public class MyPageReviewDetailUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageReviewDetailUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int rno = Integer.parseInt(request.getParameter("rno"));
		int point = Integer.parseInt(request.getParameter("reviewpoint"));
		String title = request.getParameter("reviewtitle");
		String content = request.getParameter("reviewcontent");
		
		MyPage mp = new MyPage();
		mp.setReviewNo(rno);
		mp.setReviewPoint(point);
		mp.setReviewTitle(title);
		mp.setReviewContent(content);
		
		/*int result = new MyPageService().updateReview(mp);
		
		if(result>0) {
			
		}else {
			
		}*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
