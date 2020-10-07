package com.kh.admin.adminReservation.model.vo;

import java.sql.Date;

public class Reservation {
	private int ticketNo;
	private Date reservationDate;
	private Date viewDate;
	private int ticketNum;
	private int roundNo;
	private String contentType;
	private String user;
	private int contentNo;
	private Date paymentDate;
	private String paymentType;
	private String paymentStatus;
	private String paymentTotal;
	private String paymentCancel;
	private String contentTitle;
	private Date contentDate;
	private int max;
	private int seats;
	private String round;
	
	public Reservation() {}

	public Reservation(int ticketNo, Date reservationDate, Date viewDate, int ticketNum, int roundNo,
			String contentType, String user, int contentNo, Date paymentDate, String paymentType, String paymentStatus,
			String paymentTotal, String paymentCancel, String contentTitle, Date contentDate, int max, int seats,
			String round) {
		super();
		this.ticketNo = ticketNo;
		this.reservationDate = reservationDate;
		this.viewDate = viewDate;
		this.ticketNum = ticketNum;
		this.roundNo = roundNo;
		this.contentType = contentType;
		this.user = user;
		this.contentNo = contentNo;
		this.paymentDate = paymentDate;
		this.paymentType = paymentType;
		this.paymentStatus = paymentStatus;
		this.paymentTotal = paymentTotal;
		this.paymentCancel = paymentCancel;
		this.contentTitle = contentTitle;
		this.contentDate = contentDate;
		this.max = max;
		this.seats = seats;
		this.round = round;
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

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
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

	public String getContentTitle() {
		return contentTitle;
	}

	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}

	public Date getContentDate() {
		return contentDate;
	}

	public void setContentDate(Date contentDate) {
		this.contentDate = contentDate;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public String getRound() {
		return round;
	}

	public void setRound(String round) {
		this.round = round;
	}

	@Override
	public String toString() {
		return "Reservation [ticketNo=" + ticketNo + ", reservationDate=" + reservationDate + ", viewDate=" + viewDate
				+ ", ticketNum=" + ticketNum + ", roundNo=" + roundNo + ", contentType=" + contentType + ", user="
				+ user + ", contentNo=" + contentNo + ", paymentDate=" + paymentDate + ", paymentType=" + paymentType
				+ ", paymentStatus=" + paymentStatus + ", paymentTotal=" + paymentTotal + ", paymentCancel="
				+ paymentCancel + ", contentTitle=" + contentTitle + ", contentDate=" + contentDate + ", max=" + max
				+ ", seats=" + seats + ", round=" + round + "]";
	}

	
	
}
