package com.kh.admin.adminMember.controller.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.adminMember.model.service.AdminMemberService;
import com.kh.admin.adminMember.model.vo.Page;
import com.kh.user.model.vo.Member;

/**
 * Servlet implementation class AdminMemberBlacklistListServlet
 */
@WebServlet("/blacklist.adme")
public class AdminMemberBlacklistListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMemberBlacklistListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int listCount = new AdminMemberService().selectBlacklistListCount();
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int pageLimit = 10;
		int boardLimit = 10;
		
		int maxPage = (int)Math.ceil(((double)listCount/boardLimit));
		int startPage = (currentPage - 1) / pageLimit * pageLimit +1;
		int endPage = startPage + pageLimit - 1;
		
		if(maxPage < endPage) {
			 endPage = maxPage;
		}
		
		Page p = new Page(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		ArrayList<Member> list = new AdminMemberService().selectBlacklistList(p);
		
		request.setAttribute("list", list);
		request.setAttribute("p", p);
		
		request.getRequestDispatcher("views/admin/adminMember/adminMemberBlacklistList.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
