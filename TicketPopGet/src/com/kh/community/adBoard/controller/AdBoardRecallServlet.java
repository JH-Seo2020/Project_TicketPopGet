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
 * Servlet implementation class AdBoardRecallServlet
 */
@WebServlet("/adboard.recall")
public class AdBoardRecallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdBoardRecallServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		AdBoard board = new AdBoardService().boardDetail(boardNo);
		String boardContent = new AdBoardService().boardContent(boardNo);
		
		request.setAttribute("board", board);
		request.setAttribute("boardContent", boardContent);
		
		request.getRequestDispatcher("views/community/adBoard/adBoardRecall.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
