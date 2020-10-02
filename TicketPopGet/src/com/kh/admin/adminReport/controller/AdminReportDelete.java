package com.kh.admin.adminReport.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
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

		request.setCharacterEncoding("UTF-8");
		
		int reportNo = Integer.parseInt(request.getParameter("reportNo"));
		int contentNo = Integer.parseInt(request.getParameter("contentNo"));
		String reportCate = request.getParameter("reportCate");
		
		Report r = new Report();
		r.setReportNo(reportNo);
		r.setContentNo(contentNo);
		r.setReportCate(reportCate);
		
		int result = new AdminReportService().deleteReport(r);
		
		response.setContentType("application/json; charset=UTF-8");
		Gson gson = new Gson();
		
		gson.toJson(result, response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
