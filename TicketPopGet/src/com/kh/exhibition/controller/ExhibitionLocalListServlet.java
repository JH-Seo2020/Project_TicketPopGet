package com.kh.exhibition.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.concert.model.service.ConcertService;
import com.kh.concert.model.vo.Concert;
import com.kh.concert.model.vo.PageInfo;
import com.kh.exhibition.model.service.ExhibitionService;
import com.kh.exhibition.model.vo.Exhibition;

/**
 * Servlet implementation class ExhibitionLocalListServlet
 */
@WebServlet("/exhibition.local")
public class ExhibitionLocalListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExhibitionLocalListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String content = request.getParameter("content");
		String local = request.getParameter("local");
		
		//페이징처리
		int listCount;		// 총 컨텐츠 개수 
		int currentPage;	// 내가 요청한 페이지
		int pageLimit;		// 5개까지 보여질 페이지개수
		int boardLimit;		// 12개까지 보여질 컨텐츠 개수 
		
		int maxPage;		// 전체 페이지들 중에서의 가장 마지막 페이지
		int startPage;		// 1, 6, 11, ...
		int endPage;		// 5, 10, 15, ...
		
		//sql에서 해당지역 해당 컨텐츠 개수 조회해오기
		listCount = new ConcertService().selectLocalListCount(content,local);
		//현재페이지
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		pageLimit = 5;
		boardLimit = 12;
		
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
		ArrayList<Exhibition> list = new ExhibitionService().selectLocalList(pi,local);
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		request.setAttribute("region", local);
		
		request.getRequestDispatcher("views/exhibition/exhibitionLocalList.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
