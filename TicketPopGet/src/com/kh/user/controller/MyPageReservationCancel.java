package com.kh.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.user.model.service.MyPageService;
import com.kh.user.model.vo.Reservation;

/**
 * Servlet implementation class MyPage_reservation_cancel
 */
@WebServlet("/re_cancel.my")
public class MyPageReservationCancel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageReservationCancel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userNo = Integer.parseInt(request.getParameter("userNo")); 
		int tno = Integer.parseInt(request.getParameter("tno"));
		
		int result = new MyPageService().deleteReservation(userNo,tno);
		
		if(result>0) {
		
		Reservation re = new MyPageService().deleteReservationList(userNo, tno);
		
		request.setAttribute("re", re);
			
		request.getRequestDispatcher("views/user/myPage/reservation_cancel.jsp").forward(request, response);
		
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
