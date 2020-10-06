package com.kh.serviceCenter.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.common.MyFileRenamePolicy;
import com.kh.serviceCenter.model.service.ServiceService;
import com.kh.serviceCenter.model.vo.Question;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class questionInsertServlet
 */
@WebServlet("/insert.qo")
public class questionInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public questionInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			int maxSize = 10 * 1024 * 1024;
			
			String savePath = request.getSession().getServletContext().getRealPath("/resources/question_upfiles/");
			
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			String questionType = multiRequest.getParameter("questionType");
			String questionTitle = multiRequest.getParameter("questionTitle");
			String questionContent = multiRequest.getParameter("questionContent");
			String questionUser = multiRequest.getParameter("questionUser");
			
			Question q = new Question();
			q.setQuestionType(questionType);
			q.setQuestionTitle(questionTitle);
			q.setQuestionContent(questionContent);
			q.setQuestionUser(questionUser);
			

			int result = new ServiceService().insertQuestion(q);
			
			if(result > 0) {
				
				request.getSession().setAttribute("alertMsg", "1:1문의 등록되었습니다.");
				response.sendRedirect(request.getContextPath() + "/list.qo?currentPage=1");
				
			}else {
				
				
				request.setAttribute("errorMsg", "1:1문의 등록 실패하였습니다.");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			}
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
