package com.kh.community.review.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.community.event.model.service.EventService;
import com.kh.community.event.model.vo.Comment;
import com.kh.community.review.model.service.ReviewService;
import com.kh.community.review.model.vo.Reply;
import com.kh.user.model.vo.Member;

/**
 * Servlet implementation class ReviewReplyInsertServlet
 */
@WebServlet("/reply.insert")
public class ReviewReplyInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewReplyInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청시 전달값 2개 + 회원번호 넘기기
		String replyContent = request.getParameter("replyContent");
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		int userNo = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
		
		Reply reply = new Reply();
		reply.setReplyContent(replyContent);
		reply.setReviewNo(reviewNo);
		reply.setUserNo(userNo);
		
		int result = new ReviewService().insertReply(reply);
		
		//비동기식, 바로전달
		response.getWriter().print(result);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
