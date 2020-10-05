package com.kh.payment.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.exhibition.model.vo.Exhibition;
import com.kh.payment.model.service.PaymentService;

/**
 * Servlet implementation class ExhibitionPaymentViewServlet
 */
@WebServlet("/exPay.me")
public class ExhibitionPaymentViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExhibitionPaymentViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int contentNo = Integer.parseInt(request.getParameter("contentNo"));	//전시 컨텐츠넘버
		String exdate = request.getParameter("exDate");
		System.out.println(exdate);
		Date exDate = Date.valueOf(exdate);				//전시 가기로 선택한 날짜
		System.out.println(exDate);
		//선택한 전시 컨텐츠에 해당하는 컨텐츠 내용을 예매 페이지에 뿌려주기 위해 서비스 호출
		Exhibition exObject = new PaymentService().selectExhibitionForPayment(contentNo);
		
		request.setAttribute("exObject", exObject);		//내용뿌려줄객체
		request.setAttribute("exDate", exDate);			//선택한날짜 (이건 sql에서 못받아옴, 화면에서 받은거 그대로넘김)
		
		request.getRequestDispatcher("views/user/payment/exhibitionPayment.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
