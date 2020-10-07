package com.kh.admin.adminReservation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.adminReservation.model.service.AdminReservationService;

/**
 * Servlet implementation class AdminReservationPaymentCancalServlet
 */
@WebServlet("/cancel.adrepa")
public class AdminReservationPaymentCancalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminReservationPaymentCancalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		int ticketNo = Integer.parseInt(request.getParameter("ticketNo"));
		int contentNo = Integer.parseInt(request.getParameter("contentNo"));
		String contentType = request.getParameter("contentType");
		String round = request.getParameter("round");
		
		request.setAttribute("contentNo", contentNo);
		request.setAttribute("contentType", contentType);
		request.setAttribute("round", round);
		
		int result = new AdminReservationService().reservationCancel(ticketNo);
		
		if(result>0) {
			request.getSession().setAttribute("alertMsg", "취소 완료되었습니다");
			request.getRequestDispatcher("/list.adpay?currentPage=1").forward(request, response);
		}else {
			request.getSession().setAttribute("alertMsg", "취소 실패되었습니다");
			request.getRequestDispatcher("/list.adpay?currentPage=1").forward(request, response);
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
