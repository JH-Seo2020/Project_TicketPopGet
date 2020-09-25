package com.kh.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.user.model.service.MemberService;
import com.kh.user.model.vo.Member;

/**
 * Servlet implementation class MyPage_UpdatePwdServlet
 */
@WebServlet("/updatePwd.my")
public class MyPage_UpdatePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPage_UpdatePwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String newPwd = request.getParameter("newPwd");
		
		Member updateMember = new MemberService().updatePwd(userId,userPwd,newPwd);
		
		HttpSession session = request.getSession();
		
		if(updateMember!=null) {
			session.setAttribute("alertMsg", "성공적으로 비밀번호 변경됐습니다. 로그인을 다시 해주세요");
			session.setAttribute("loginUser", updateMember);
			session.removeAttribute("loginUser");
		}else {
			session.setAttribute("alertMsg", "비밀번호 변경 실패했습니다.");
		}
		
		response.sendRedirect("/TicketPopGet/loginview.me");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
