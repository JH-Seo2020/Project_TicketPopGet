package com.kh.community.event.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
		int commentNo = Integer.parseInt(request.getParameter("commentNo"));
		System.out.println(commentNo);
		int eventNo = Integer.parseInt(request.getParameter("eventNo"));
		int userNo = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
		
		Comment comm = new Comment();
		comm.setCommentNo(commentNo);
		comm.setEventNo(eventNo);
		comm.setUserNo(String.valueOf(userNo));
		
		int result = new EventService().deleteComment(comm);
		
		if(result>0) {
			request.getSession().setAttribute("alertMsg", "댓글이 성공적으로 삭제되었습니다.");
			response.sendRedirect(request.getContextPath() + "/event.detail?eventNo="+eventNo);
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
