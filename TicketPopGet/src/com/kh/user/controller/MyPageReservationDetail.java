package com.kh.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.user.model.service.MyPageService;
import com.kh.user.model.vo.Reservation;

/**
 * Servlet implementation class MyPage_reservation_detail
 */
@WebServlet("/re_detail.my")
public class MyPageReservationDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageReservationDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		int tno = Integer.parseInt(request.getParameter("tno"));
		
		
		Reservation re = new MyPageService().selectReservationDetail(userNo, tno);
		System.out.println(re);
		
		request.setAttribute("re", re);
		
		
		RequestDispatcher view = request.getRequestDispatcher("views/user/myPage/reservation_detail.jsp");
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
