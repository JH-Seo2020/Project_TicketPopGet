package com.kh.user.model.vo;

import java.sql.Date;

public class MyPage {
	
	private String userId; //로그인한 회원
	private int ticketNo; // 관람후기번호
	private String contentType; //컨텐츠분류
	private Date viewDate; //관람일
	private String contentTitle; //공연,전시명
	private int reviewNo; // 리뷰번호
	private String reviewTitle; //후기제목
	private String reviewContent; //후기내용
	private int reviewPoint; //평점
	private Date reviewDate; //후기작성일
	
	public MyPage() {}
	
	public MyPage(String userId, int ticketNo, String contentType, Date viewDate, String contentTitle, int reviewNo,
			String reviewTitle, String reviewContent, int reviewPoint, Date reviewDate) {
		super();
		this.userId = userId;
		this.ticketNo = ticketNo;
		this.contentType = contentType;
		this.viewDate = viewDate;
		this.contentTitle = contentTitle;
		this.reviewNo = reviewNo;
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.reviewPoint = reviewPoint;
		this.reviewDate = reviewDate;
	}

	public MyPage(String userId, int ticketNo, String contentType, Date viewDate, String contentTitle) {
		super();
		this.userId = userId;
		this.ticketNo = ticketNo;
		this.contentType = contentType;
		this.viewDate = viewDate;
		this.contentTitle = contentTitle;
	}
	
	

	public MyPage(String userId, int reviewNo, String contentTitle, String reviewTitle, Date reviewDate) {
		super();
		this.userId = userId;
		this.reviewNo = reviewNo;
		this.contentTitle = contentTitle;
		this.reviewTitle = reviewTitle;
		this.reviewDate = reviewDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Date getViewDate() {
		return viewDate;
	}

	public void setViewDate(Date viewDate) {
		this.viewDate = viewDate;
	}

	public String getContentTitle() {
		return contentTitle;
	}

	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public int getReviewPoint() {
		return reviewPoint;
	}

	public void setReviewPoint(int reviewPoint) {
		this.reviewPoint = reviewPoint;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	@Override
	public String toString() {
		return "MyPageShow [userId=" + userId + ", ticketNo=" + ticketNo + ", contentType=" + contentType
				+ ", viewDate=" + viewDate + ", contentTitle=" + contentTitle + "]";
	}

	

}
