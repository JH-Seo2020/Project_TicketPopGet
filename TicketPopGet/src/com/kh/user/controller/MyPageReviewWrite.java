package com.kh.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.websocket.Transformation;

import com.kh.user.model.service.MyPageService;
import com.kh.user.model.vo.MyPage;

import java.util.*;
import java.text.*;

/**
 * Servlet implementation class MyPage_review_write
 */
@WebServlet("/review_write.my")
public class MyPageReviewWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageReviewWrite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int tno = Integer.parseInt(request.getParameter("tno"));
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		int cno = Integer.parseInt(request.getParameter("cno"));
		
		if(tno>0) {
			MyPage mp = new MyPageService().selectReviewWrite(tno,userNo,cno);
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			
			mp.setReviewDate(java.sql.Date.valueOf(dateFormat.format(date)));
			
			request.setAttribute("tno", tno);
			request.setAttribute("userNo", userNo);
			request.setAttribute("cno", cno);
			request.setAttribute("mp", mp);
			
			
			request.getRequestDispatcher("views/user/myPage/review_write.jsp").forward(request, response);
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
