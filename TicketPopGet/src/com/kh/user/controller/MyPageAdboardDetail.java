package com.kh.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.community.adBoard.model.vo.AdBoard;
import com.kh.user.model.service.MyPageService;

/**
 * Servlet implementation class MyPageAdboardDetail
 */
@WebServlet("/adboard_detail.my")
public class MyPageAdboardDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageAdboardDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int ano = Integer.parseInt(request.getParameter("ano"));
	
		
		if(ano>0) {
			AdBoard ad = new MyPageService().selectAdboardDetail(ano);
			String content = new MyPageService().selectAdboardContent(ano);
			
			request.setAttribute("ad", ad);
			request.setAttribute("content", content);
			
			request.getRequestDispatcher("views/user/myPage/adboard_detail.jsp").forward(request, response);
			
		}else {
			
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
