package com.kh.admin.adminMember.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.admin.adminMember.model.service.AdminMemberService;

/**
 * Servlet implementation class AdminMemberBlacklistUnlockServlet
 */
@WebServlet("/blacklistUnlock.adme")
public class AdminMemberBlacklistUnlockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMemberBlacklistUnlockServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		int result = new AdminMemberService().blacklistUnlock(userNo);
		
		Gson gson = new Gson();
		
		if(result > 0) {
			response.setContentType("application/json; charset=UTF-8");
			gson.toJson(result, response.getWriter());
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
