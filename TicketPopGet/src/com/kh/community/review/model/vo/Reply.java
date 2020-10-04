package com.kh.community.review.model.vo;

import java.sql.Date;

public class Reply {
	
	private int replyNo;
	private int userNo;
	private String userId;
	private int reviewNo;
	private Date replyDate;
	private String replyContent;
	private String replyStatus;
	
	public Reply() {
		// TODO Auto-generated constructor stub
	}

	public Reply(int replyNo, int userNo, int reviewNo, Date replyDate, String replyContent, String replyStatus) {
		super();
		this.replyNo = replyNo;
		this.userNo = userNo;
		this.reviewNo = reviewNo;
		this.replyDate = replyDate;
		this.replyContent = replyContent;
		this.replyStatus = replyStatus;
	}
	
	

	public Reply(int replyNo, int userNo, String userId, int reviewNo, Date replyDate, String replyContent) {
		super();
		this.replyNo = replyNo;
		this.userNo = userNo;
		this.userId = userId;
		this.reviewNo = reviewNo;
		this.replyDate = replyDate;
		this.replyContent = replyContent;
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public Date getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getReplyStatus() {
		return replyStatus;
	}

	public void setReplyStatus(String replyStatus) {
		this.replyStatus = replyStatus;
	}
	
	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Reply [replyNo=" + replyNo + ", userNo=" + userNo + ", reviewNo=" + reviewNo + ", replyDate="
				+ replyDate + ", replyContent=" + replyContent + ", replyStatus=" + replyStatus + "]";
	}
	
	

}
