package com.kh.community.review.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.community.adBoard.model.service.AdBoardService;
import com.kh.community.adBoard.model.vo.Report;
import com.kh.community.review.model.service.ReviewService;

/**
 * Servlet implementation class ReviewReportServlet
 */
@WebServlet("/review.report")
public class ReviewReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		int reporter = Integer.parseInt(request.getParameter("reporter"));
		int troubleMaker = Integer.parseInt(request.getParameter("troubleMaker"));
		String reportType = request.getParameter("reportType");
		String reportCate = request.getParameter("reportCate");
		String reportContent = request.getParameter("reportContent");
		int adContentNo = Integer.parseInt(request.getParameter("reviewNo"));
		
		Report boardReport = new Report();
		boardReport.setReporter(reporter);
		boardReport.setTroubleMaker(troubleMaker);
		boardReport.setReportType(reportType);
		boardReport.setReportCate(reportCate);
		boardReport.setReportContent(reportContent);
		boardReport.setAdContentNo(adContentNo);
		
		int result = new AdBoardService().boardReport(boardReport);
		
		if(result>0) {
			request.getSession().setAttribute("alertMsg", "게시글이 성공적으로 신고되었습니다.");
			response.sendRedirect(request.getContextPath() + "/review.detail?reviewNo="+adContentNo);
		}else {
			request.setAttribute("errorMsg", "게시글 신고 실패");
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
