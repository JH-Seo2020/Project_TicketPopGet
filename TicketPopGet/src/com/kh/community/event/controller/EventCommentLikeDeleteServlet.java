package com.kh.community.event.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.community.event.model.service.EventService;
import com.kh.user.model.vo.Member;

/**
 * Servlet implementation class EventCommentLikeDeleteServlet
 */
@WebServlet("/comment.deletelike")
public class EventCommentLikeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventCommentLikeDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int commentNo = Integer.parseInt(request.getParameter("commentNo"));
		int eventNo = Integer.parseInt(request.getParameter("eventNo"));
		int userNo = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
		
		int result = new EventService().deleteLike(commentNo, eventNo, userNo);
		
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
