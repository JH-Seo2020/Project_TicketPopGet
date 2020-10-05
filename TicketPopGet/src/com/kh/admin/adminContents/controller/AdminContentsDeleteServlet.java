package com.kh.admin.adminContents.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.adminContents.model.service.AdminContentsService;

/**
 * Servlet implementation class AdminContentsDeleteServlet
 */
@WebServlet("/delete.adco")
public class AdminContentsDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminContentsDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int contentNo = Integer.parseInt(request.getParameter("contentNo"));
		String contentType = request.getParameter("contentType");
		
	    int result = new AdminContentsService().deleteContents(contentNo, contentType);
			
		if(result>0) {
			request.getSession().setAttribute("alertMsg", "삭제 완료되었습니다");
		}else {
			request.getSession().setAttribute("alertMsg", "삭제 실패되었습니다");
		}
		response.sendRedirect(request.getContextPath()+"/list.adco?currentPage=1");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
