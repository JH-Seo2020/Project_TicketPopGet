package com.kh.user.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.user.model.service.MyPageService;
import com.kh.user.model.vo.MyPage;
import com.kh.user.model.vo.Reservation;
import com.kh.user.model.vo.WishList;

/**
 * Servlet implementation class MyPage_main
 */
@WebServlet("/mypage.my")
public class MyPageMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageMain() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		ArrayList<Reservation> re = new MyPageService().mainReservation(userNo);
		ArrayList<WishList> wishlist = new MyPageService().mainWishList(userNo);
		ArrayList<MyPage> mps = new MyPageService().mainShowList(userNo);
		
		request.setAttribute("re", re);
		request.setAttribute("wishlist", wishlist);
		request.setAttribute("mps", mps);
		
		
		
		
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginUser")== null) {
			RequestDispatcher view = request.getRequestDispatcher("views/common/loginView.jsp");
			view.forward(request, response);
			
		}else {
			RequestDispatcher view = request.getRequestDispatcher("views/user/myPage/myPage_main.jsp");
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
