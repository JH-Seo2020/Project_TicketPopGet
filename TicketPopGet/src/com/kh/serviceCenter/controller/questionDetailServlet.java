package com.kh.serviceCenter.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.serviceCenter.model.service.ServiceService;
import com.kh.serviceCenter.model.vo.Question;

/**
 * Servlet implementation class questionDetailServlet
 */
@WebServlet("/detail.qo")
public class questionDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public questionDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("qno"));
		
		int qno = Integer.parseInt(request.getParameter("qno"));
		
		Question q = new ServiceService().selectQuestion(qno);
		
		request.setAttribute("q", q);
		
		RequestDispatcher view = request.getRequestDispatcher("views/serviceCenter/questionDetail.jsp");
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
