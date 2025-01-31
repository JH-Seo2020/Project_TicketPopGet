package com.kh.exhibition.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.concert.model.service.ConcertService;
import com.kh.exhibition.model.service.ExhibitionService;
import com.kh.exhibition.model.vo.Exhibition;

/**
 * Servlet implementation class ExhibitionDetailViewServlet
 */
@WebServlet("/exhibition.detail")
public class ExhibitionDetailViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExhibitionDetailViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int contentNo = Integer.parseInt(request.getParameter("contentNo"));
		//info빼고 다가져오기
		Exhibition exObject = new ExhibitionService().exhibitionDetailView(contentNo);
		
		//info 따로 가져오기, 기존 메소드 재활용! 
		String exInfo = new ConcertService().concertInfo(contentNo);
		
		request.setAttribute("exObject", exObject);
		request.setAttribute("exInfo", exInfo);
		
		request.getRequestDispatcher("views/exhibition/exhibitionDetailView.jsp").forward(request, response);
	}

	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
