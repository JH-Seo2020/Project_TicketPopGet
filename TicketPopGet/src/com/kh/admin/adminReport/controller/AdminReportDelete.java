package com.kh.admin.adminReport.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.adminReport.model.service.AdminReportService;
import com.kh.admin.adminReport.model.vo.Report;

/**
 * Servlet implementation class AdminReportDelete
 */
@WebServlet("/delete.adre")
public class AdminReportDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminReportDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int contentNo = Integer.parseInt(request.getParameter("contentNo"));
		String reportCate = request.getParameter("reportCate");
		
		Report r = new Report();
		r.setContentNo(contentNo);
		r.setReportCate(reportCate);
		
		int result = new AdminReportService().deleteReport(r);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
