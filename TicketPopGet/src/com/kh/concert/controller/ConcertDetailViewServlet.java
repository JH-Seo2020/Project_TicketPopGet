package com.kh.concert.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.concert.model.service.ConcertService;
import com.kh.concert.model.vo.Concert;

/**
 * Servlet implementation class ConcertDetailViewServlet
 */
@WebServlet("/concert.detail")
public class ConcertDetailViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConcertDetailViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int concertNo = Integer.parseInt(request.getParameter("concertNo"));
		//일단 info빼고 다 가져옴
		Concert concertObject = new ConcertService().concertDetailView(concertNo);
		
		//여기서부 clob 테스트할 예정!

		//보낼거 정리하기
		request.setAttribute("concertObject", concertObject);
		
		request.getRequestDispatcher("views/concert/concertDetailView.jsp").forward(request, response);
		
	}

	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
