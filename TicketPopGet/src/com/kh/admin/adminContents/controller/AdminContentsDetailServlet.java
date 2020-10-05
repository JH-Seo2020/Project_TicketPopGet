package com.kh.admin.adminContents.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.adminContents.model.service.AdminContentsService;
import com.kh.admin.adminContents.model.vo.Contents;

/**
 * Servlet implementation class AdminContentsDetailServlet
 */
@WebServlet("/detail.adco")
public class AdminContentsDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminContentsDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		int contentNo = Integer.parseInt(request.getParameter("contentNo"));
		String contentType = request.getParameter("contentType");
		int roundNo = 0;
		
		if(contentType.equals("연극")) {
			roundNo = Integer.parseInt(request.getParameter("roundNo"));
		}
		Contents c = new AdminContentsService().contentDetail(contentNo, contentType, roundNo);
		
		request.setAttribute("c", c);
		if(contentType.equals("연극")) {
			request.getRequestDispatcher("views/admin/adminContents/detailPlay.jsp").forward(request, response);
		}else if(contentType.equals("전시")){
			request.getRequestDispatcher("views/admin/adminContents/detailExhibition.jsp").forward(request, response);
		}else if(contentType.equals("콘서트")) {
			request.getRequestDispatcher("views/admin/adminContents/detailConcert.jsp").forward(request, response);
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
