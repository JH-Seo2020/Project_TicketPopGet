package com.kh.play.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.concert.model.service.ConcertService;
import com.kh.exhibition.model.service.ExhibitionService;
import com.kh.play.model.service.PlayService;
import com.kh.play.model.vo.Play;

/**
 * Servlet implementation class PlayDetailViewServlet
 */
@WebServlet("/play.detail")
public class PlayDetailViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlayDetailViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int contentNo = Integer.parseInt(request.getParameter("contentNo"));
		//info빼고 
		Play playObject = new PlayService().playDetailView(contentNo);
		
		//info 따로 가져오기, 기존 메소드 재활용.
		String playInfo = new ConcertService().concertInfo(contentNo);
		
		request.setAttribute("playObject", playObject);
		request.setAttribute("playInfo", playInfo);
		
		request.getRequestDispatcher("views/play/playDetailView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
