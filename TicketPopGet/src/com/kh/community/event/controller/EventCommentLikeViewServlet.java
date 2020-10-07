package com.kh.community.event.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kh.community.event.model.dao.EventDao;
import com.kh.community.event.model.service.EventService;
import com.kh.user.model.vo.Member;

/**
 * Servlet implementation class EventCommentLikeViewServlet
 */
@WebServlet("/view.like")
public class EventCommentLikeViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventCommentLikeViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int commentNo = Integer.parseInt(request.getParameter("commentNo"));
		
		int resultCount = new EventService().selectCountGood(commentNo);
		
		//비동기로진행
		response.getWriter().print(resultCount);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
