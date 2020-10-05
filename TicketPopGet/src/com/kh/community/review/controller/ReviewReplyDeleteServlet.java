package com.kh.community.review.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.community.review.model.service.ReviewService;

/**
 * Servlet implementation class ReviewReplyDeleteServlet
 */
@WebServlet("/reply.delete")
public class ReviewReplyDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewReplyDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int replyNo = Integer.parseInt(request.getParameter("replyNo"));
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		
		int result = new ReviewService().replyDelete(replyNo);
		
		if(result>0) {
			request.getSession().setAttribute("alertMsg", "댓글이 성공적으로 삭제되었습니다.");
			response.sendRedirect(request.getContextPath() + "/review.detail?reviewNo="+reviewNo);
		}else {
			request.setAttribute("errorMsg", "댓글 삭제 실패");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
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
