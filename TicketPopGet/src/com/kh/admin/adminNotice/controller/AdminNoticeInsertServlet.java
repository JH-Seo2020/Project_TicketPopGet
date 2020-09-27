package com.kh.admin.adminNotice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.adminNotice.model.service.AdminNoticeService;
import com.kh.admin.adminNotice.model.vo.Notice;

/**
 * Servlet implementation class AdminNoticeInsertServlet
 */
@WebServlet("/insert.adno")
public class AdminNoticeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminNoticeInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String noticeTitle = request.getParameter("noticeTitle");
		String noticeContent = request.getParameter("noticeContent");
		String type = request.getParameter("type");
		
		Notice n = new Notice();
		n.setNoticeTitle(noticeTitle);
		n.setNoticeContent(noticeContent);
		n.setNoticeType(type);
		
		int result = new AdminNoticeService().insertNotice(n);
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "공지사항 등록 완료되었습니다.");
		}else {
			request.getSession().setAttribute("alertMsg", "공지사항 등록 실패하였습니다.");
		}
		response.sendRedirect(request.getContextPath() + "/list.adno?currentPage=1");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
