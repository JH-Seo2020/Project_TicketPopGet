package com.kh.admin.adminReservation.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.adminContents.model.vo.Contents;
import com.kh.admin.adminMember.model.vo.Page;
import com.kh.admin.adminReservation.model.service.AdminReservationService;
import com.kh.admin.adminReservation.model.vo.Reservation;

/**
 * Servlet implementation class AdminPaymentListServlet
 */
@WebServlet("/list.adpay")
public class AdminPaymentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPaymentListServlet() {
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
		int round = Integer.parseInt(request.getParameter("round"));
		
		int listCount = new AdminReservationService().paymentListCount(contentNo, contentType, round);
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
		
		ArrayList<Reservation> list = new AdminReservationService().reservationList(p, contentNo, contentType, round);
		
		Reservation r = new Reservation();
		r.setContentNo(contentNo);
		r.setContentType(contentType);
		r.setRound(String.valueOf(round));
		
		request.setAttribute("r", r);
		request.setAttribute("list", list);
		request.setAttribute("p", p);
		
		
		request.getRequestDispatcher("views/admin/adminReservation/adminPaymentList.jsp").forward(request, response);
		
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
