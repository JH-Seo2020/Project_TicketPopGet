package com.kh.admin.adminFaq.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.admin.adminFaq.model.service.AdminFaqService;
import com.kh.admin.adminFaq.model.vo.Faq;

/**
 * Servlet implementation class AdminFaqSelectUpdateServlet
 */
@WebServlet("/selectUpdate.adfa")
public class AdminFaqSelectUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminFaqSelectUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int faqNo = Integer.parseInt(request.getParameter("faqNo"));
		
		Faq f = new AdminFaqService().selectUpdate(faqNo);
		
		response.setContentType("application/json; charset=utf-8");
		Gson gson = new Gson();
		
		gson.toJson(f, response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
