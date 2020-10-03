package com.kh.common.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.model.service.MainService;
import com.kh.common.model.vo.MainContent;

/**
 * Servlet implementation class MainContentsServlet
 */
@WebServlet("/main.co")
public class MainContentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainContentsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1-1. 투데이베스트 : 콘서트
		MainContent tbConcert = new MainService().selectTbConcert();
		//1-2. 투데이베스트 : 연극
		MainContent tbPlay = new MainService().selectTbPlay();
		//1-3. 투데이베스트 : 전시
		MainContent tbEx = new MainService().selectTbEx();
		
		//2. 신규오픈 다가져오기
		ArrayList<MainContent> news = new MainService().selectNews();
		
		//3. 마감임박 다가져오기
		ArrayList<MainContent> ends = new MainService().selectEnds();
		
		
		//변수전달
		request.setAttribute("tbConcert", tbConcert);
		request.setAttribute("tbPlay", tbPlay);
		request.setAttribute("tbEx", tbEx);
		request.setAttribute("news", news);
		request.setAttribute("ends", ends);
		
		request.getRequestDispatcher("views/common/mainPage.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
