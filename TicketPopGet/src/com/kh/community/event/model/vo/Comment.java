package com.kh.community.event.model.vo;

import java.sql.Date;

public class Comment {
	
	private int commentNo;
	private int eventNo;
	private String userNo;
	private String userId;
	private String commentCont;
	private Date commentDate;
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment(int commentNo, int eventNo, String userNo, String commentCont, Date commentDate) {
		super();
		this.commentNo = commentNo;
		this.eventNo = eventNo;
		this.userNo = userNo;
		this.commentCont = commentCont;
		this.commentDate = commentDate;
	}

	
	
	public Comment(int commentNo, int eventNo, String userNo, String userId, String commentCont, Date commentDate) {
		super();
		this.commentNo = commentNo;
		this.eventNo = eventNo;
		this.userNo = userNo;
		this.userId = userId;
		this.commentCont = commentCont;
		this.commentDate = commentDate;
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public int getEventNo() {
		return eventNo;
	}

	public void setEventNo(int eventNo) {
		this.eventNo = eventNo;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getCommentCont() {
		return commentCont;
	}

	public void setCommentCont(String commentCont) {
		this.commentCont = commentCont;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Comment [commentNo=" + commentNo + ", eventNo=" + eventNo + ", userNo=" + userNo + ", commentCont="
				+ commentCont + ", commentDate=" + commentDate + "]";
	}
	
	

}
