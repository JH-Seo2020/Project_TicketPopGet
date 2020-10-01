package com.kh.community.review.model.vo;

import java.sql.Clob;
import java.sql.Date;

public class Review {
	
	private int reviewRnum;
	private int reviewNo;
	private int userNo;
	private int contentNo;
	private String contentType;
	private String reviewTitle;
	private Clob reviewContent;
	private int reviewPoint;
	private Date reviewDate;
	private int reviewCount;
	private String reviewStatus;
	
	public Review() {
		// TODO Auto-generated constructor stub
	}

	public Review(int reviewNo, int userNo, int contentNo, String reviewTitle, Clob reviewContent, int reviewPoint,
			Date reviewDate, int reviewCount, String reviewStatus) {
		super();
		this.reviewNo = reviewNo;
		this.userNo = userNo;
		this.contentNo = contentNo;
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.reviewPoint = reviewPoint;
		this.reviewDate = reviewDate;
		this.reviewCount = reviewCount;
		this.reviewStatus = reviewStatus;
	}

	public Review(int reviewRnum, int reviewNo ,String reviewTitle, int reviewPoint, Date reviewDate, int reviewCount) {
		super();
		this.reviewRnum = reviewRnum;
		this.reviewNo = reviewNo;
		this.reviewTitle = reviewTitle;
		this.reviewPoint = reviewPoint;
		this.reviewDate = reviewDate;
		this.reviewCount = reviewCount;
		
	}

	

	public Review(int reviewNo, int userNo, int contentNo, String contentType, String reviewTitle, int reviewPoint,
			Date reviewDate, int reviewCount) {
		super();
		this.reviewNo = reviewNo;
		this.userNo = userNo;
		this.contentNo = contentNo;
		this.contentType = contentType;
		this.reviewTitle = reviewTitle;
		this.reviewPoint = reviewPoint;
		this.reviewDate = reviewDate;
		this.reviewCount = reviewCount;
	}

	public int getReviewRnum() {
		return reviewRnum;
	}

	public void setReviewRnum(int reviewRnum) {
		this.reviewRnum = reviewRnum;
	}
	
	

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getContentNo() {
		return contentNo;
	}

	public void setContentNo(int contentNo) {
		this.contentNo = contentNo;
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

	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	public String getReviewStatus() {
		return reviewStatus;
	}

	public void setReviewStatus(String reviewStatus) {
		this.reviewStatus = reviewStatus;
	}
	
	

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", userNo=" + userNo + ", contentNo=" + contentNo + ", reviewTitle="
				+ reviewTitle + ", reviewContent=" + reviewContent + ", reviewPoint=" + reviewPoint + ", reviewDate="
				+ reviewDate + ", reviewCount=" + reviewCount + ", reviewStatus=" + reviewStatus + "]";
	}
	
	

}
