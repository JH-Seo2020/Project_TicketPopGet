package com.kh.admin.adminFaq.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.adminFaq.model.service.AdminFaqService;
import com.kh.admin.adminFaq.model.vo.Faq;
import com.kh.admin.adminMember.model.vo.Page;

/**
 * Servlet implementation class AdminFaqSearchServlet
 */
@WebServlet("/search.adfa")
public class AdminFaqSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminFaqSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String type = request.getParameter("type");
		String key = "";
		key = request.getParameter("key");
		
		int listCount = 0;
		if(type.equals("전체")) {
			if(key.equals("")) {
				listCount = new AdminFaqService().faqListCount();
			}else {
				listCount = new AdminFaqService().searchKeyListCount(key);
			}
				
		}else {
			if(key.equals("")) {
				listCount = new AdminFaqService().searchTypeListCount(type);
			}else {
				listCount = new AdminFaqService().searchKeyTypeListCount(key,type);
			}
		}
				
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int pageLimit = 10;
		int boardLimit = 10;
		
		int maxPage = (int)Math.ceil((double)listCount / boardLimit);
		int startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		int endPage = startPage + pageLimit-1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		Page p = new Page(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		ArrayList<Faq> list = new ArrayList<>();
		if(type.equals("전체")) {
			if(key.equals("")) {
				list = new AdminFaqService().selectFaqList(p);
			}else {
				list = new AdminFaqService().searchKey(key, p);
				
			}
		}else {
			if(key.equals("")) {
				list = new AdminFaqService().searchType(type, p);
			}else {
				list = new AdminFaqService().searchKeyType(key, type, p);
			}
		}
		
		request.setAttribute("p", p);
		request.setAttribute("list", list);
		request.setAttribute("key", key);
		request.setAttribute("type", type);
		request.getRequestDispatcher("views/admin/adminFaq/adminFaqSearchList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
