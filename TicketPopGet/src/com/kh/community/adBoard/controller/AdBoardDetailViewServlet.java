package com.kh.community.adBoard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.community.adBoard.model.service.AdBoardService;
import com.kh.community.adBoard.model.vo.AdBoard;

/**
 * Servlet implementation class AdBoardDetailViewServlet
 */
@WebServlet("/adboard.detail")
public class AdBoardDetailViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdBoardDetailViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		// 1. 조회수 올리기
		int boardCount = new AdBoardService().plusCount(boardNo);
		
		if(boardCount >0) {
			//2-1. 객체조회
			AdBoard board = new AdBoardService().boardDetail(boardNo);
			//2-2. 내용조회(clob to string)
			String boardContent = new AdBoardService().boardContent(boardNo);
			
			request.setAttribute("board", board);
			request.setAttribute("boardContent", boardContent);
			request.getRequestDispatcher("views/community/adBoard/adBoardDetailView.jsp").forward(request, response);
			
		}else {
			//오류페이지 띄워주기
			request.setAttribute("errorMsg", "홍보게시글 조회 실패");
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
