package com.kh.user.model.vo;

import java.sql.Date;

public class WishList {
	
	private int wishNo; // 찜번호
	private int contentNo; //등록번호
	private int userNo; //회원번호
	private int ticketNo; // 예매번호
	private String contentType; //작품분류
	private String contentTitle; //공연제목
	private String contentChimg; //수정이미지
	private String contentImgPath; //파일경로
	private String contentStatus; // 예매여부
	private Date wishlistDate; //등록일
	
	public WishList(int wishNo, int contentNo, int userNo, int ticketNo, String contentType, String contentTitle,
			String contentChimg, String contentImgPath, String contentStatus, Date wishlistDate) {
		super();
		this.wishNo = wishNo;
		this.contentNo = contentNo;
		this.userNo = userNo;
		this.ticketNo = ticketNo;
		this.contentType = contentType;
		this.contentTitle = contentTitle;
		this.contentChimg = contentChimg;
		this.contentImgPath = contentImgPath;
		this.contentStatus = contentStatus;
		this.wishlistDate = wishlistDate;
	}

	public int getWishNo() {
		return wishNo;
	}

	public void setWishNo(int wishNo) {
		this.wishNo = wishNo;
	}

	public int getContentNo() {
		return contentNo;
	}

	public void setContentNo(int contentNo) {
		this.contentNo = contentNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
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

	public String getContentTitle() {
		return contentTitle;
	}

	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}

	public String getContentChimg() {
		return contentChimg;
	}

	public void setContentChimg(String contentChimg) {
		this.contentChimg = contentChimg;
	}

	public String getContentImgPath() {
		return contentImgPath;
	}

	public void setContentImgPath(String contentImgPath) {
		this.contentImgPath = contentImgPath;
	}

	

	public String getContentStatus() {
		return contentStatus;
	}

	public void setContentStatus(String contentStatus) {
		this.contentStatus = contentStatus;
	}

	public Date getWishlistDate() {
		return wishlistDate;
	}

	public void setWishlistDate(Date wishlistDate) {
		this.wishlistDate = wishlistDate;
	}

	@Override
	public String toString() {
		return "WishList [wishNo=" + wishNo + ", contentNo=" + contentNo + ", userNo=" + userNo + ", ticketNo="
				+ ticketNo + ", contentType=" + contentType + ", contentTitle=" + contentTitle + ", contentChimg="
				+ contentChimg + ", contentImgPath=" + contentImgPath + ", contentStatus=" + contentStatus
				+ ", wishlistDate=" + wishlistDate + "]";
	}
	
	
	
	
	
	
	
	

}
