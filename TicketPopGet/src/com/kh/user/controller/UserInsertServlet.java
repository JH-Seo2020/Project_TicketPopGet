package com.kh.user.controller;

import java.io.IOException;
import java.sql.Date;

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
 * Servlet implementation class UserInsertServlet
 */
@WebServlet("/insert.me")
public class UserInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");		// 아이디
		String userPwd = request.getParameter("userPwd");	// 비밀번호
		String userName = request.getParameter("userName");	// 이름
		String email = request.getParameter("email");		// 이메일
		String phone = request.getParameter("phone");		// 전화번호
		Date birthdate = java.sql.Date.valueOf(request.getParameter("birthdate"));	//생년월일
		String gender = request.getParameter("gender");		//성별
		
		Member m = new Member(userId, userPwd, userName, email, phone, birthdate, gender);
		
		int result = new MemberService().insertMember(m);
		
		if(result > 0) { // 회원가입 성공
			
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "성공적으로 회원가입이 되었습니다.");
			
			response.sendRedirect(request.getContextPath());
			
		}else { // 회원가입 실패
			
request.setAttribute("errorMsg", "회원가입에 실패했습니다.");
			
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
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
