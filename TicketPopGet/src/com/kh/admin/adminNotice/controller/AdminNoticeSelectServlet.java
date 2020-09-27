package com.kh.admin.adminNotice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.adminMember.model.service.AdminMemberService;
import com.kh.admin.adminMember.model.vo.Page;
import com.kh.admin.adminNotice.model.service.AdminNoticeService;
import com.kh.admin.adminNotice.model.vo.Notice;

/**
 * Servlet implementation class AdminNoticeSelectServlet
 */
@WebServlet("/searchList.adno")
public class AdminNoticeSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminNoticeSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String key = "";
		key = request.getParameter("selectKeyword");
		String type= request.getParameter("type");
		
		int listCount = new AdminNoticeService().searchNoticeListCount(key);
		
		if(!type.equals("전체")) {
			if(!key.equals("")) {
				listCount = new AdminNoticeService().searchNoticeListKeyTypeCount(key, type);
			}else {
				listCount = new AdminNoticeService().searchNoticeListTypeCount(type);
			}
		}else {
			
		}
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int pageLimit = 10;
		int boardLimit = 10;
		
		int maxPage = (int)Math.ceil((double)listCount / pageLimit);
		int startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		int endPage = startPage + pageLimit-1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		
		Page p = new Page(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		

		ArrayList<Notice> list = new AdminNoticeService().searchNoticeList(p, key, type);
		
		request.setAttribute("list", list);
		request.setAttribute("p", p);
		request.setAttribute("key", key);
		request.setAttribute("type", type);
		
		request.getRequestDispatcher("views/admin/adminNotice/adminNoticeSearch.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
