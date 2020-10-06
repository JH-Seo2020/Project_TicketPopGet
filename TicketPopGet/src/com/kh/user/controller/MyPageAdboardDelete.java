package com.kh.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.user.model.service.MyPageService;

/**
 * Servlet implementation class MyPageAdboardDelete
 */
@WebServlet("/deleteadboard.my")
public class MyPageAdboardDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageAdboardDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int ano = Integer.parseInt(request.getParameter("ano"));
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		int result = new MyPageService().deleteAdboard(ano, userNo);
		
		if(result>0) {
			request.getSession().setAttribute("alertMsg", "삭제되었습니다.");
			response.sendRedirect(request.getContextPath()+"/adboard.my?currentPage=1&userNo="+userNo);

		}
		else {
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
