package com.kh.user.model.vo;

import java.sql.Date;

public class Payment {
	
	private Date reservationDate;	// 예매일
	private Date viewDate;			// 관람일시
	private int ticketNum;			// 예매매수
	private String price;			// 티켓금액
	private int roundNo;			// 회차번호
	private String contentType;		// 컨텐츠분류
	private String contentTitle;	// 컨텐츠제목
	private int userNo;				// 회원번호
	private int contentNo;			// 등록번호
	private Date paymentDate;		// 결제일자
	private String paymentType;		// 결제방법
	private String paymentStatus;	// 결제여부
	private String paymentTotal;	// 총결제금액
	private int concertMax;			// 콘서트 총좌석수
	private int concertSeats;		// 콘서트 잔여석수
	
	public Payment() {}


	public Payment(Date reservationDate, Date viewDate, int ticketNum, String price, int roundNo, String contentType,
			String contentTitle, int userNo, int contentNo, Date paymentDate, String paymentType, String paymentStatus,
			String paymentTotal, int concertMax, int concertSeats) {
		super();
		this.reservationDate = reservationDate;
		this.viewDate = viewDate;
		this.ticketNum = ticketNum;
		this.price = price;
		this.roundNo = roundNo;
		this.contentType = contentType;
		this.contentTitle = contentTitle;
		this.userNo = userNo;
		this.contentNo = contentNo;
		this.paymentDate = paymentDate;
		this.paymentType = paymentType;
		this.paymentStatus = paymentStatus;
		this.paymentTotal = paymentTotal;
		this.concertMax = concertMax;
		this.concertSeats = concertSeats;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
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

	public String getContentTitle() {
		return contentTitle;
	}

	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
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
	

	public int getConcertMax() {
		return concertMax;
	}

	public void setConcertMax(int concertMax) {
		this.concertMax = concertMax;
	}

	public int getConcertSeats() {
		return concertSeats;
	}

	public void setConcertSeats(int concertSeats) {
		this.concertSeats = concertSeats;
	}

	@Override
	public String toString() {
		return "Payment [reservationDate=" + reservationDate + ", viewDate=" + viewDate + ", ticketNum=" + ticketNum
				+ ", price=" + price + ", roundNo=" + roundNo + ", contentType=" + contentType + ", contentTitle="
				+ contentTitle + ", userNo=" + userNo + ", contentNo=" + contentNo + ", paymentDate=" + paymentDate
				+ ", paymentType=" + paymentType + ", paymentStatus=" + paymentStatus + ", paymentTotal=" + paymentTotal
				+ "]";
	}
	
	
	
	
	
}
