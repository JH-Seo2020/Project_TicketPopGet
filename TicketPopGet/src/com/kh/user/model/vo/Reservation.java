package com.kh.user.model.vo;

import java.sql.Date;

public class Reservation {
	
	private int ticketNo; //예매번호
	private int userNo;   //회원번호
	private int contentNo; //등록번호
	private Date reservationDate; //예매일
	private Date viewDate; //관람일시
	private int ticketNum; //예매매수
	private int roundNo; // 회차번호
	private String contentType; //컨텐츠분류
	private String contnetTitle; //공연제목
	private Date paymentDate; //결제일자
	private String paymentType; //결제방법
	private String paymentStatus; //결제여부
	private String paymentTotal; // 총결제금액
	private String paymentCancel; //취소여부
	
	public Reservation(int ticketNo, int userNo, int contentNo, Date reservationDate, Date viewDate, int ticketNum,
			int roundNo, String contentType, String contnetTitle, Date paymentDate, String paymentType,
			String paymentStatus, String paymentTotal, String paymentCancel) {
		super();
		this.ticketNo = ticketNo;
		this.userNo = userNo;
		this.contentNo = contentNo;
		this.reservationDate = reservationDate;
		this.viewDate = viewDate;
		this.ticketNum = ticketNum;
		this.roundNo = roundNo;
		this.contentType = contentType;
		this.contnetTitle = contnetTitle;
		this.paymentDate = paymentDate;
		this.paymentType = paymentType;
		this.paymentStatus = paymentStatus;
		this.paymentTotal = paymentTotal;
		this.paymentCancel = paymentCancel;
	}


	public Reservation(int ticketNo, int userNo, int contentNo, Date reservationDate
			, String contnetTitle,int ticketNum, Date viewDate, String paymentType, String paymentStatus, String paymentCancel) {
		super();
		this.ticketNo = ticketNo;
		this.userNo = userNo;
		this.contentNo = contentNo;
		this.reservationDate = reservationDate;
		this.contnetTitle = contnetTitle;
		this.ticketNum = ticketNum;
		this.viewDate = viewDate;
		this.paymentType = paymentType;
		this.paymentStatus = paymentStatus;
		this.paymentCancel = paymentCancel;
	}
	



	public int getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
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

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public Date getViewDate() {
		return viewDate;
	}

	public void setViewDate(Date viewDate) {
		this.viewDate = viewDate;
	}
	
	public String getContnetTitle() {
		return contnetTitle;
	}




	public void setContnetTitle(String contnetTitle) {
		this.contnetTitle = contnetTitle;
	}




	public int getTicketNum() {
		return ticketNum;
	}

	public void setTicketNum(int ticketNum) {
		this.ticketNum = ticketNum;
	}

	public int getRoundNo() {
		return roundNo;
	}

	public void setRoundNo(int roundNo) {
		this.roundNo = roundNo;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getPaymentTotal() {
		return paymentTotal;
	}

	public void setPaymentTotal(String paymentTotal) {
		this.paymentTotal = paymentTotal;
	}

	public String getPaymentCancel() {
		return paymentCancel;
	}

	public void setPaymentCancel(String paymentCancel) {
		this.paymentCancel = paymentCancel;
	}

	@Override
	public String toString() {
		return "RESERVATION [ticketNo=" + ticketNo + ", userNo=" + userNo + ", contentNo=" + contentNo
				+ ", reservationDate=" + reservationDate + ", viewDate=" + viewDate + ", ticketNum=" + ticketNum
				+ ", roundNo=" + roundNo + ", contentType=" + contentType + ", paymentDate=" + paymentDate
				+ ", paymentType=" + paymentType + ", paymentStatus=" + paymentStatus + ", paymentTotal=" + paymentTotal
				+ ", paymentCancel=" + paymentCancel + "]";
	}
	
	
	
	

}
