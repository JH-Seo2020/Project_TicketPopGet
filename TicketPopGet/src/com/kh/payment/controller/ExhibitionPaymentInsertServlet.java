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
import com.kh.payment.model.vo.Payment;
import com.kh.user.model.vo.Member;

/**
 * Servlet implementation class ExhibitionPaymentInsertServlet
 */
@WebServlet("/expayinsert.me")
public class ExhibitionPaymentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExhibitionPaymentInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		//DB에 칼럼마다 넣어줄 내용을 request.getParameter에서 추출하기
		Date viewDate = Date.valueOf(request.getParameter("viewDate"));						//관람하려고 고른 날짜
		int ticketNum = Integer.parseInt(request.getParameter("choiceNo"));					//예매한 티켓개수
		String contentType = request.getParameter("contentType");							//컨텐츠타입 : 여기선 전시
		int userNo = Integer.parseInt(request.getParameter("userNo"));						//유저번호
		int contentNo = Integer.parseInt(request.getParameter("contentNo"));				//전시컨텐츠 번호
		String pdate = request.getParameter("paymentDate");	
		Date paymentDate = null;
		if (pdate.isEmpty()) {
			paymentDate = null;
		}else {
			paymentDate = Date.valueOf(pdate);												//지불날짜			
		}
		String paymentType = request.getParameter("paymentMethod");							//지불방법
		String paymentTotal = request.getParameter("paymentTotal");							//총지불금액
		
		Payment exPay = new Payment();
		exPay.setViewDate(viewDate);
		exPay.setTicketNum(ticketNum);
		exPay.setContentType(contentType);
		exPay.setUserNo(userNo);
		exPay.setContentNo(contentNo);
		exPay.setPaymentDate(paymentDate);
		exPay.setPaymentType(paymentType);
		exPay.setPaymentTotal(paymentTotal);
		
		int result = new PaymentService().insertPayment(exPay);
		
		if(result>0) {
			
			//select문 실행해서 db에 방금 저장한 정보 다시 가져오기 
			Payment selectPay = new PaymentService().selectRecentPayment(userNo);
			
			//결제포트 띄워줄 페이지(빈걸로 하나만들어서)로 전송 
			request.setAttribute("selectPay",selectPay);
			request.getRequestDispatcher("views/user/payment/payAPIPage.jsp").forward(request, response);
			
//			request.getSession().setAttribute("alertMsg", "성공적으로 결제되었습니다. 마이페이지에서 확인하세요!");
//			response.sendRedirect(request.getContextPath() + "/reservation.my?currentPage=1&userNo="+userNo);
			
		}else {
			request.setAttribute("errorMsg", "결제가 되지 않습니다. 다시 시도해주세요.");
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
