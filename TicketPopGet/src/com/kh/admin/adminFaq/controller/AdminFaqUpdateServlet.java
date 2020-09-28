package com.kh.admin.adminFaq.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.adminFaq.model.service.AdminFaqService;
import com.kh.admin.adminFaq.model.vo.Faq;

/**
 * Servlet implementation class AdminFaqUpdateServlet
 */
@WebServlet("/update.adfa")
public class AdminFaqUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminFaqUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int faqNo = Integer.parseInt(request.getParameter("faqNo"));
		String faqTitle = request.getParameter("faqTitle");
		String faqType = request.getParameter("faqType");
		String faqContent = request.getParameter("faqContent");
		
		System.out.println(faqNo+faqTitle+faqType+faqContent);
		
		Faq f = new Faq();
		f.setFaqNo(faqNo);
		f.setFaqTitle(faqTitle);
		f.setFaqType(faqType);
		f.setFaqContent(faqContent);
		
		int result = new AdminFaqService().updateFaq(f);
		
		if(result > 0 ) {
			request.getSession().setAttribute("alertMsg", "FAQ 수정 완료되었습니다.");
		}else{
			request.getSession().setAttribute("alertMsg", "FAQ 수정 실패했습니다.");
		}
		response.sendRedirect(request.getContextPath() + "/list.adfa?currentPage=1");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
