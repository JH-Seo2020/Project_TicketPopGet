package com.kh.admin.adminMember.controller;

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
 * Servlet implementation class AdminMemberSelectFormServlet
 */
@WebServlet("/selectMember.adme")
public class AdminMemberSelectFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMemberSelectFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String selectUser = request.getParameter("selectUser");
		String selectUserType = request.getParameter("selectUserType");
		
		if(selectUserType.equals("ALL")) {
			response.sendRedirect(request.getContextPath() + "/list.adme?currentPage=1");
		}else { 
		
		int listCount = new AdminMemberService().selectMemberCount(selectUser, selectUserType);
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int pageLimit = 10;
		int boardLimit = 10;
		
		int maxPage = (int)Math.ceil((double)listCount/pageLimit);
		int startPage = (currentPage-1) / pageLimit * pageLimit + 1 ;
		int endPage = startPage + pageLimit - 1;
		
		if(maxPage<endPage) {
			endPage = maxPage;
		}
		
		Page p = new Page(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		
		ArrayList<Member> list = new AdminMemberService().selectMember(p, selectUser, selectUserType);
		
		request.setAttribute("page", p);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("views/admin/adminMember/adminMemberList.jsp").forward(request, response);
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
