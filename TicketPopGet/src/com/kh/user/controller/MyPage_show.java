package com.kh.user.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.concert.model.vo.PageInfo;
import com.kh.user.model.service.MyPageService;
import com.kh.user.model.vo.MyPageShow;

/**
 * Servlet implementation class MyPage_show
 */
@WebServlet("/show.my")
public class MyPage_show extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPage_show() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		// ---------------- 페이징처리 ----------------
		int listCount;		// 현재 총 게시글 개수
		int currentPage; 	// 현재 페이지 (즉, 요청한 페이지)
		int pageLimit;		// 한 페이지 하단에 보여질 페이지 최대개수
		int boardLimit;		// 한 페이지내에 보여질 게시글 최대개수
		
		int maxPage;		// 전체 페이지들 중에서의 가장 마지막 페이지
		int startPage;		// 현재 페이지에 하단에 보여질 페이징 바의 시작 수
		int endPage;		// 현재 페이지에 하단에 보여질 페이징 바의 끝 수
		
		// * listCount : 총 게시글 개수
		listCount = new MyPageService().selectShowListCount(userId);
		
		//System.out.println(listCount);
		// * currentPage : 현재페이지(요청한페이지)
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		System.out.println(userId);
		System.out.println(currentPage);
		
		// * pageLimit : 한 페이지 하단에 보여질 페이지 최대 개수 ( 페이지 목록들 몇개 단위 )
		pageLimit = 10;
		
		// * boardLimit : 한 페이지에 보여질 게시글 최대 개수
		boardLimit = 10;
		

		maxPage = (int)Math.ceil((double)listCount / boardLimit); //->강제형변환 안붙이면 실수로 반환되기때문에 int 붙여야됨
		
		// * startPage : 현재 페이지에 보여질 페이징 바의 시작수
		
		startPage	=	(currentPage - 1) / pageLimit * pageLimit + 1;
		
		// * endPage : 현재 페이지에 보여지는 페이징 바의 끝 수
		
		endPage = startPage + pageLimit - 1;
		
		// 만약 maxPage가 고작 13까지 밖에 안된다면? endPage를 다시 13로 해줘야됨
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		// 페이징정보들을 하나의 공간에 담아서 보내자
		// 1. 페이징바 만들때 필요한 PageInfo 객체
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		ArrayList<MyPageShow> list = new MyPageService().selectShowList(pi);
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
	
		RequestDispatcher view = request.getRequestDispatcher("views/user/myPage/show.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
