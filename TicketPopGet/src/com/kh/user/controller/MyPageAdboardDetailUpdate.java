package com.kh.user.controller;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.community.adBoard.model.vo.AdBoard;
import com.kh.user.model.service.MyPageService;

/**
 * Servlet implementation class MyPageAdboardDetailUpdate
 */
@WebServlet("/adupdate.my")
public class MyPageAdboardDetailUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageAdboardDetailUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int ano = Integer.parseInt(request.getParameter("ano"));
		String category1 = request.getParameter("category1");
		String category2 = request.getParameter("category2");
		String title = request.getParameter("adtitle");
		Date addate = java.sql.Date.valueOf(request.getParameter("addate"));
		String content = request.getParameter("editordata");

		AdBoard ad = new AdBoard();
		ad.setBoardNo(ano);
		ad.setBoardType(category1);
		ad.setBoardLocation(category2);
		ad.setBoardTitle(title);
		ad.setBoardDate(addate);

		int result = new MyPageService().adBoardUpdate(ad, content);
		
		if(result>0) { 
			request.getSession().setAttribute("alertMsg", "성공적으로 수정되었습니다.");
			response.sendRedirect(request.getContextPath() + "/adboard_detail.my?ano="+ano);
		}else { 
			request.setAttribute("errorMsg", " 수정 실패");
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
