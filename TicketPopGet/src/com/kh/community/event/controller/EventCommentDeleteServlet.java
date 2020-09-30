package com.kh.community.event.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.community.event.model.service.EventService;
import com.kh.community.event.model.vo.Comment;
import com.kh.user.model.vo.Member;

/**
 * Servlet implementation class EventCommentDeleteServlet
 */
@WebServlet("/comment.delete")
public class EventCommentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventCommentDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//요청시 전달값 2개 + 회원번호 넘기기
		String commentContent = request.getParameter("commentContent");
		int eno = Integer.parseInt(request.getParameter("eno"));
		int userNo = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
		
		Comment comm = new Comment();
		comm.setCommentCont(commentContent);
		comm.setEventNo(eno);
		comm.setUserNo(String.valueOf(userNo));
		
		int result = new EventService().deleteComment(comm);
		
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
