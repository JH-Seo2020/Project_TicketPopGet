package com.kh.user.model.vo;

import java.sql.Clob;
import java.sql.Date;

public class MyPage {
	
	private int userNo;
	private String userId; //로그인한 회원
	private int ticketNo; // 관람후기번호
	private int contentNo; //컨텐츠번호
	private String contentType; //컨텐츠분류
	private Date viewDate; //관람일
	private String contentTitle; //공연,전시명
	private int reviewNo; // 리뷰번호
	private String reviewTitle; //후기제목
	private Clob reviewContent; //후기내용
	private int reviewPoint; //평점
	private Date reviewDate; //후기작성일
	
	public MyPage() {}


	public MyPage(int userNo, String userId, int ticketNo, int contentNo, String contentType, Date viewDate, String contentTitle,
			int reviewNo, String reviewTitle, Clob reviewContent, int reviewPoint, Date reviewDate) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.ticketNo = ticketNo;
		this.contentNo = contentNo;
		this.contentType = contentType;
		this.viewDate = viewDate;
		this.contentTitle = contentTitle;
		this.reviewNo = reviewNo;
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.reviewPoint = reviewPoint;
		this.reviewDate = reviewDate;
	}


	public MyPage(int ticketNo, String contentType, Date viewDate, String contentTitle,
			      int userNo, int contentNo) {
		super();
		this.ticketNo = ticketNo;
		this.contentType = contentType;
		this.viewDate = viewDate;
		this.contentTitle = contentTitle;
		this.userNo = userNo;
		this.contentNo = contentNo;
	}
	
	public MyPage(int userNo, int reviewNo, String contentTitle, String reviewTitle, Date reviewDate) {
		super();
		this.userNo = userNo;
		this.contentTitle = contentTitle;
		this.reviewNo = reviewNo;
		this.reviewTitle = reviewTitle;
		this.reviewDate = reviewDate;
	}

	public MyPage(int userNo, int reviewNo, String contentType, String reviewTitle, Date viewDate, Date reviewDate, int reviewPoint, String contentTitle ) {
		super();
		this.userNo = userNo;
		this.reviewNo = reviewNo;
		this.contentType = contentType;
		this.reviewTitle = reviewTitle;
		this.viewDate = viewDate;
		this.reviewDate = reviewDate;
		this.reviewPoint = reviewPoint;
		this.contentTitle = contentTitle;
	}
	
	

	public MyPage(String contentType, String contentTitle, Date viewDate,int ticketNo, int contentNo, int userNo) {
		super();
		this.contentType = contentType;
		this.contentTitle = contentTitle;
		this.viewDate = viewDate;
		this.ticketNo = ticketNo;
		this.contentNo = contentNo;
		this.userNo = userNo;
	}

	public int getUserNo() {
		return userNo;
	}


	public void setUserNo(int userNo) {
		this.userNo = userNo;
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
	

	public int getContentNo() {
		return contentNo;
	}


	public void setContentNo(int contentNo) {
		this.contentNo = contentNo;
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

	public Clob getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(Clob reviewContent) {
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
		return "MyPage [userNo=" + userNo + ", userId=" + userId + ", ticketNo=" + ticketNo + ", contentType="
				+ contentType + ", viewDate=" + viewDate + ", contentTitle=" + contentTitle + ", reviewNo=" + reviewNo
				+ ", reviewTitle=" + reviewTitle + ", reviewContent=" + reviewContent + ", reviewPoint=" + reviewPoint
				+ ", reviewDate=" + reviewDate + "]";
	}

	
	

}
