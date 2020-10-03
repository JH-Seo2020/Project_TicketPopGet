package com.kh.admin.adminContents.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.adminContents.model.service.AdminContentsService;
import com.kh.admin.adminContents.model.vo.Contents;
import com.kh.common.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class AdminConcertInsertFormServlet
 */
@WebServlet("/insertConcertForm.adco")
public class AdminConcertInsertFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminConcertInsertFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int maxSize = 10*1024*1024;
		String savePath = request.getSession().getServletContext().getRealPath("/resources/img/ContentsImg/");
		MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
		
		String contentTitle = multiRequest.getParameter("contentTitle");
		String contentSubject = multiRequest.getParameter("contentSubject");
		String startDate = multiRequest.getParameter("startDate");
		String runtime = multiRequest.getParameter("runtime");
		int max = Integer.parseInt(multiRequest.getParameter("max"));
		String place = multiRequest.getParameter("place");
		String local = multiRequest.getParameter("local");
		String limit = multiRequest.getParameter("limit");
		String price = multiRequest.getParameter("price");
		String keyword = multiRequest.getParameter("keyword");
		String info = multiRequest.getParameter("info");
		
		Contents c = new Contents(contentTitle, contentSubject, place, limit, price, keyword, info , local, runtime, startDate, max);
		
		c.setContentOgImg(multiRequest.getOriginalFileName("file"));
		c.setContentChImg(multiRequest.getFilesystemName("file"));
		c.setContentImgPath("resources/img/contentsImg/");
		
		int result = new AdminContentsService().insertConcert(c);
		
		if(result>0) {
			request.getSession().setAttribute("alertMsg", "등록 완료되었습니다");
		}else {
			request.getSession().setAttribute("alertMsg", "등록 실패되었습니다");
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
