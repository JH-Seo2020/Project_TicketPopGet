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
 * Servlet implementation class AdBoardUpdateServlet
 */
@WebServlet("/adboard.update")
public class AdBoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdBoardUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String genre = request.getParameter("genre");
		String location = request.getParameter("location");
		String title = request.getParameter("title");
		String editordata = request.getParameter("editordata");
		
		AdBoard board = new AdBoard();
		board.setBoardNo(boardNo);
		board.setBoardType(genre);
		board.setBoardLocation(location);
		board.setBoardTitle(title);
		
		int result = new AdBoardService().updateBoard(board, editordata);
		
		if(result>0) {
			request.getSession().setAttribute("alertMsg", "성공적으로 수정되었습니다.");
			response.sendRedirect(request.getContextPath() + "/adboard.detail?boardNo=" + boardNo);
		}else {
			request.setAttribute("errorMsg", "공지사항 수정 실패");
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
