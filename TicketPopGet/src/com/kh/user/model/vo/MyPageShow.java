package com.kh.user.model.vo;

import java.sql.Date;

public class MyPageShow {
	
	private String userId;
	private int ticketNo;
	private String contentType;
	private Date viewDate;
	private String contentTitle;
	
	public MyPageShow() {}

	public MyPageShow(String userId, int ticketNo, String contentType, Date viewDate, String contentTitle) {
		super();
		this.userId = userId;
		this.ticketNo = ticketNo;
		this.contentType = contentType;
		this.viewDate = viewDate;
		this.contentTitle = contentTitle;
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

	@Override
	public String toString() {
		return "MyPageShow [userId=" + userId + ", ticketNo=" + ticketNo + ", contentType=" + contentType
				+ ", viewDate=" + viewDate + ", contentTitle=" + contentTitle + "]";
	};
	
	

}
