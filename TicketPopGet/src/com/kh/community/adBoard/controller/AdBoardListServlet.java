package com.kh.community.adBoard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.community.adBoard.model.service.AdBoardService;
import com.kh.community.adBoard.model.vo.AdBoard;
import com.kh.community.eventResult.model.service.EventResultService;
import com.kh.community.eventResult.model.vo.EventRaffle;
import com.kh.concert.model.vo.PageInfo;

/**
 * Servlet implementation class AdBoardListServlet
 */
@WebServlet("/adboard.co")
public class AdBoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdBoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//페이징처리
		int listCount;		// 총 게시글 개수 
		int currentPage;	// 내가 요청한 페이지
		int pageLimit;		// 5개까지 보여질 페이지개수
		int boardLimit;		// 12개까지 보여질 컨텐츠 개수 
		
		int maxPage;		// 전체 페이지들 중에서의 가장 마지막 페이지
		int startPage;		
		int endPage;		
		
		//이벤트 결과물 게시글 개수 조회 
		listCount = new AdBoardService().adBoardListCount();
		//현재페이지
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		pageLimit = 5;
		boardLimit = 10;
		
		//위의 4개로 아래 3개 도출하기.
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;	
		endPage = startPage + pageLimit - 1;
		
		//마지막페이지처리
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		//페이징 관련 정보를 담아줄 pageInfo vo객체 생성하고 담아서 전달
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		//페이징 정보를 통해서 해당되는 게시글 리스트를 받아올 수 있음 
		ArrayList<AdBoard> list = new AdBoardService().selectList(pi);
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		
		RequestDispatcher view = request.getRequestDispatcher("views/community/adBoard/adBoardList.jsp");
		view.forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
