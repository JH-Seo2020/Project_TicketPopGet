package com.kh.community.event.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.community.event.model.service.EventService;
import com.kh.community.event.model.vo.Event;

/**
 * Servlet implementation class EventDetailServlet
 */
@WebServlet("/event.detail")
public class EventDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int eventNo = Integer.parseInt(request.getParameter("eventNo"));
		
		int result = new EventService().plusCount(eventNo);	//조회수증가
		
		if(result>0) {
			
			Event evObject = new EventService().selectDetail(eventNo);	//게시글정보조회
			String eventContent = new EventService().selectEventContent(eventNo);	//게시글내용조회
			
			request.setAttribute("evObject", evObject);
			request.setAttribute("eventContent", eventContent);
			request.getRequestDispatcher("views/community/event/eventDetailView.jsp").forward(request, response);
			
		}else{
			request.setAttribute("errorMsg", "이벤트 게시글 조회 실패");
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
