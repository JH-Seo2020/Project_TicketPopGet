package com.kh.reservationPayment.model.vo;

import java.sql.Date;

public class ReservationPayment {
	
	private int ticketNo;
	private Date reservationDate;
	private Date viewDate;
	private int ticketNum;
	private int roundNo;
	private String contentType;
	private int userNo;
	private int contentNo;
	private Date paymentDate;
	private String paymentType;
	private String paymentStatus;
	private String paymentTotal;
	private String paymentCancel;

	public ReservationPayment() {}

	public ReservationPayment(int ticketNo, Date reservationDate, Date viewDate, int ticketNum, int roundNo,
			String contentType, int userNo, int contentNo, Date paymentDate, String paymentType, String paymentStatus,
			String paymentTotal, String paymentCancel) {
		super();
		this.ticketNo = ticketNo;
		this.reservationDate = reservationDate;
		this.viewDate = viewDate;
		this.ticketNum = ticketNum;
		this.roundNo = roundNo;
		this.contentType = contentType;
		this.userNo = userNo;
		this.contentNo = contentNo;
		this.paymentDate = paymentDate;
		this.paymentType = paymentType;
		this.paymentStatus = paymentStatus;
		this.paymentTotal = paymentTotal;
		this.paymentCancel = paymentCancel;
	}

	public int getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
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
		return "ReservationPayment [ticketNo=" + ticketNo + ", reservationDate=" + reservationDate + ", viewDate="
				+ viewDate + ", ticketNum=" + ticketNum + ", roundNo=" + roundNo + ", contentType=" + contentType
				+ ", userNo=" + userNo + ", contentNo=" + contentNo + ", paymentDate=" + paymentDate + ", paymentType="
				+ paymentType + ", paymentStatus=" + paymentStatus + ", paymentTotal=" + paymentTotal
				+ ", paymentCancel=" + paymentCancel + "]";
	}
	
	
	
}
