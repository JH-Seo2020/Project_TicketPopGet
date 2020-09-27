package com.kh.community.adBoard.controller;

import java.io.IOException;
import java.sql.Clob;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.community.adBoard.model.service.AdBoardService;
import com.kh.community.adBoard.model.vo.AdBoard;
import com.kh.user.model.vo.Member;

/**
 * Servlet implementation class AdBoardInsertPostServlet
 */
@WebServlet("/adboard.insert")
public class AdBoardInsertPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdBoardInsertPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String content = request.getParameter("editordata");
			
		//2. 변수다가져오기
		String genre = request.getParameter("genre");
		String location = request.getParameter("location");
		String title = request.getParameter("title");
		//2-1.세션에서 회원번호가져오기
		Member loginUser = (Member) request.getSession().getAttribute("loginUser");
		int userNo = 0;
		if(loginUser != null) {
			userNo = loginUser.getUserNo();
		}

		//3. 객체담아서 전달 
		AdBoard board = new AdBoard();
		board.setBoardType(genre);
		board.setBoardLocation(location);
		board.setBoardTitle(title);
		board.setUserNo(userNo);
		
		int result = new AdBoardService().insertAdBoard(board, content);
		
		if(result>0) {
			
			request.getSession().setAttribute("alertMsg", "성공적으로 등록됐습니다.");
			//추후 url 수정예정
			response.sendRedirect(request.getContextPath() + "/adboard.co?currentPage=1");
			
		}else {
			request.setAttribute("errorMsg", "게시물 등록 실패");
			
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
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
