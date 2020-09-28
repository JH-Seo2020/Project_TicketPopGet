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

import com.kh.concert.model.vo.PageInfo;
import com.kh.user.model.service.MyPageService;
import com.kh.user.model.vo.MyPageShow;

/**
 * Servlet implementation class MyPage_show
 */
@WebServlet("/show.my")
public class MyPage_show extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPage_show() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		
		if(userId != null) {
			MyPageShow mps = new MyPageService().selectShowList(userId);
			
			request.setAttribute("mps", mps);
			
			RequestDispatcher view = request.getRequestDispatcher("views/user/myPage/show.jsp");
			view.forward(request, response);
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
