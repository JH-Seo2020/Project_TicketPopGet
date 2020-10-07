package com.kh.admin.adminReservation.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.adminContents.model.service.AdminContentsService;
import com.kh.admin.adminContents.model.vo.Contents;
import com.kh.admin.adminMember.model.vo.Page;

/**
 * Servlet implementation class AdminReservationListServlet
 */
@WebServlet("/list.adres")
public class AdminReservationListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminReservationListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int listCount = new AdminContentsService().contentsListCount();
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int boardLimit = 10;
		int pageLimit = 10;
		
		int maxPage = (int)Math.ceil((double)listCount/boardLimit);
		int startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		int endPage = startPage + pageLimit-1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		Page p = new Page(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		ArrayList<Contents> list = new AdminContentsService().contentsList(p);
		
		request.setAttribute("list", list);
		request.setAttribute("p", p);
		
		request.getRequestDispatcher("views/admin/adminReservation/adminReservationLists.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
