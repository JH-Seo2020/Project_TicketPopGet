package com.kh.payment.model.vo;

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
	private String userId;			//
	private String userName;		//
	private String email;			//
	private String phone;			//
	private int ticketNo;

	
	public Payment() {}




	public Payment(Date reservationDate, Date viewDate, int ticketNum, String price, int roundNo, String contentType,
			String contentTitle, int userNo, int contentNo, Date paymentDate, String paymentType, String paymentStatus,
			String paymentTotal) {
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
	}

	


	public Payment(Date reservationDate, Date viewDate, int ticketNum, int roundNo, String contentType,String contentTitle,
			int userNo,int contentNo, Date paymentDate, String paymentType, String paymentTotal, String userId, String userName,
			String email, String phone, int ticketNo) {
		super();
		this.reservationDate = reservationDate;
		this.viewDate = viewDate;
		this.ticketNum = ticketNum;
		this.roundNo = roundNo;
		this.contentType = contentType;
		this.contentTitle = contentTitle;
		this.userNo = userNo;
		this.contentNo = contentNo;
		this.paymentDate = paymentDate;
		this.paymentType = paymentType;
		this.paymentTotal = paymentTotal;
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
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
	
	

	public String getUserId() {
		return userId;
	}




	public void setUserId(String userId) {
		this.userId = userId;
	}




	public String getUserName() {
		return userName;
	}




	public void setUserName(String userName) {
		this.userName = userName;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPhone() {
		return phone;
	}




	public void setPhone(String phone) {
		this.phone = phone;
	}

	


	public int getTicketNo() {
		return ticketNo;
	}




	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
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
