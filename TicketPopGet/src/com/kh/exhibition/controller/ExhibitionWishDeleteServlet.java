package com.kh.exhibition.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.exhibition.model.service.ExhibitionService;
import com.kh.user.model.vo.Member;

/**
 * Servlet implementation class ExhibitionWishDeleteServlet
 */
@WebServlet("/delete.wishEx")
public class ExhibitionWishDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExhibitionWishDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int contentNo = Integer.parseInt(request.getParameter("contentNo"));
		
		int userNo = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
		
		int result = new ExhibitionService().deleteWish(contentNo, userNo);
		
		//비동기식, 바로전달
		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
