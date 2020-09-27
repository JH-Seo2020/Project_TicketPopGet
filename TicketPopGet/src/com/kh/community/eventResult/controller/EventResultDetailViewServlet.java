package com.kh.community.eventResult.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.community.eventResult.model.service.EventResultService;
import com.kh.community.eventResult.model.vo.EventRaffle;

/**
 * Servlet implementation class EventResultDetailViewServlet
 */
@WebServlet("/eventresult.detail")
public class EventResultDetailViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventResultDetailViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int raffleNo = Integer.parseInt(request.getParameter("raffleNo"));
		
		//1. 조회수 증가시키기
		int raffleCount = new EventResultService().plusCount(raffleNo);
		
		if(raffleCount>0) {
			
			//2. 내용물 가져오기
			EventRaffle raffle = new EventResultService().raffleDetail(raffleNo);
			request.setAttribute("raffle", raffle);
			request.getRequestDispatcher("views/community/eventResult/eventResultDetailView.jsp").forward(request, response);
		
		}else {
			
			//오류페이지 띄워주기
			request.setAttribute("errorMsg", "결과 발표 게시글 조회 실패");
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
