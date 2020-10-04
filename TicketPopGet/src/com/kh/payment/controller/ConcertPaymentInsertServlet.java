package com.kh.payment.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.payment.model.service.PaymentService;
import com.kh.payment.model.vo.ConcertPayment;

/**
 * Servlet implementation class ConcertPaymentInsertServlet
 */
@WebServlet("/concertpayinsert.me")
public class ConcertPaymentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConcertPaymentInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		int ticketNo = Integer.parseInt(request.getParameter("ticketNo"));
		Date concertDate = Date.valueOf(request.getParameter("concertDate"));
		int ticketNum = Integer.parseInt(request.getParameter("ticketNum"));
		String contentType = request.getParameter("contentType");
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		int contentNo = Integer.parseInt(request.getParameter("contentNo"));
		Date paymentDate = Date.valueOf(request.getParameter("paymentDate"));
		String paymentType = request.getParameter("paymentType");
		String paymentTotal = request.getParameter("paymentTotal");
		
		ConcertPayment cp = new ConcertPayment();
		
		cp.setTicketNum(ticketNo);
		cp.setConcertDate(concertDate);
		cp.setTicketNum(ticketNum);
		cp.setContentType(contentType);
		cp.setUserNo(userNo);
		cp.setContentNo(contentNo);
		cp.setPaymentDate(paymentDate);
		cp.setPaymentType(paymentType);
		cp.setPaymentTotal(paymentTotal);
		
		int result = new PaymentService().insertConcertPayment(cp);
		
		if(result > 0) {
			
			request.getSession().setAttribute("alertMsg", "성공적으로 결제되었습니다.");
		}else {
			request.setAttribute("errorMsg", "결제 실패되었습니다.");
			
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
