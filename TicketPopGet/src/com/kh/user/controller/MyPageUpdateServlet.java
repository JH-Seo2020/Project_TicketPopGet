package com.kh.user.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.user.model.service.MemberService;
import com.kh.user.model.vo.Member;

/**
 * Servlet implementation class MyPage_UpdateServlet
 */
@WebServlet("/update.my")
public class MyPageUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyPageUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
			String userId = request.getParameter("userId");
			String userName = request.getParameter("userName");
			Date birthdate = java.sql.Date.valueOf(request.getParameter("birthdate"));
			String gender = request.getParameter("gender");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");

			Member m = new Member(userId, userName, (java.sql.Date)birthdate, gender, phone, email);

			Member updateMember = new MemberService().updateMember(m);

			if (updateMember != null) {
				HttpSession session = request.getSession();

				session.setAttribute("loginUser", updateMember);
				session.setAttribute("alertMsg", "회원정보가 변경되었습니다.");

				response.sendRedirect(request.getContextPath() + "/info_de.my");
			} else {
				request.setAttribute("errorMsg", "회원정보 수정에 실패했습니다.");

				RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
				view.forward(request, response);
			}
	
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
