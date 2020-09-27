package com.kh.serviceCenter.model.vo;

import java.sql.Date;

public class Notice {
	
	private int noticeNo;			// 공지사항등록번호
	private String noticeType;		// 공지사항분류
	private String noticeTitle;		// 공지사항제목
	private String noticeContent;	// 공지사항내용
	private Date noticeDate;		// 작성일
	private String noticeStatus;	// 게재여부
	private String adminId;			// 작성자[관리자]
	
	public Notice() {}

	public Notice(int noticeNo, String noticeType, String noticeTitle, String noticeContent, Date noticeDate,
			String noticeStatus, String adminId) {
		super();
		this.noticeNo = noticeNo;
		this.noticeType = noticeType;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeDate = noticeDate;
		this.noticeStatus = noticeStatus;
		this.adminId = adminId;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public Date getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}

	public String getNoticeStatus() {
		return noticeStatus;
	}

	public void setNoticeStatus(String noticeStatus) {
		this.noticeStatus = noticeStatus;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", noticeType=" + noticeType + ", noticeTitle=" + noticeTitle
				+ ", noticeContent=" + noticeContent + ", noticeDate=" + noticeDate + ", noticeStatus=" + noticeStatus
				+ ", adminId=" + adminId + "]";
	}
	
	

}
