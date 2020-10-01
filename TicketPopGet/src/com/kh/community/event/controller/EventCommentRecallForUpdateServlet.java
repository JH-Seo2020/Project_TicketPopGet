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
import com.kh.community.event.model.service.EventService;
import com.kh.community.event.model.vo.Comment;

/**
 * Servlet implementation class EventCommentRecallForUpdateServlet
 */
@WebServlet("/comment.forUpdate")
public class EventCommentRecallForUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventCommentRecallForUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int commentNo = Integer.parseInt(request.getParameter("commentNo"));
		System.out.println(commentNo);
		Comment eComment = new EventService().recallForUpdate(commentNo);
		
		//비동기식
		JSONObject comment1 = new JSONObject();					
		comment1.put("userNo",eComment.getCommentNo());			
		comment1.put("userName",eComment.getEventNo());		
		comment1.put("age",eComment.getUserNo());					
		comment1.put("gender",eComment.getUserId());
		comment1.put("gender",eComment.getCommentCont());
		comment1.put("gender",eComment.getCommentDate());
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(comment1);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
