package com.kh.admin.adminMember.controller.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.admin.adminMember.model.service.AdminMemberService;
import com.kh.admin.adminMember.model.vo.Report;

/**
 * Servlet implementation class AdminMemberBlacklistDetailServelt
 */
@WebServlet("/blacklistDetail.adme")
public class AdminMemberBlacklistDetailServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMemberBlacklistDetailServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		System.out.print(userNo);
		
		ArrayList<Report> rlist = new AdminMemberService().selectReportList(userNo);
		
		response.setContentType("application/json; charset=UTF-8");
		
		Gson gson = new Gson();
		
		gson.toJson(rlist, response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
