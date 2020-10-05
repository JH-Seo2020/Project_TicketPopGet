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
	private Date viewDatecancel; // 취소가능날
	private String paymentType; //결제방법
	private String paymentStatus; //결제여부
	private String paymentTotal; // 총결제금액
	private String paymentCancel; //취소여부
	private String place; //장소
	private String userName; //이름
	private String contentChimg; //수정이미지
	private String contentImgPath; //파일경로
	
	

	public Reservation(int ticketNo, int userNo, int contentNo, Date reservationDate, Date viewDate, int ticketNum,
			int roundNo, String contentType, String contnetTitle, Date paymentDate, Date viewDatecancel,
			String paymentType, String paymentStatus, String paymentTotal, String paymentCancel, String place,
			String userName, String contentChimg, String contentImgPath) {
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
		this.viewDatecancel = viewDatecancel;
		this.paymentType = paymentType;
		this.paymentStatus = paymentStatus;
		this.paymentTotal = paymentTotal;
		this.paymentCancel = paymentCancel;
		this.place = place;
		this.userName = userName;
		this.contentChimg = contentChimg;
		this.contentImgPath = contentImgPath;
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
	
	public Reservation(int ticketNo, String contnetTitle, Date viewDate, Date viewDatecancel, String place, String userName, Date paymentDate,
			 Date reservationDate, String paymentType, String paymentTotal, int ticketNum, String paymentCancel) {
		super();
		this.ticketNo = ticketNo;
		this.reservationDate = reservationDate;
		this.viewDate = viewDate;
		this.viewDatecancel = viewDatecancel;
		this.ticketNum = ticketNum;
		this.contnetTitle = contnetTitle;
		this.paymentDate = paymentDate;
		this.paymentType = paymentType;
		this.paymentTotal = paymentTotal;
		this.paymentCancel = paymentCancel;
		this.place = place;
		this.userName = userName;
	}


	public Reservation(int ticketNo, String contentType, String contnetTitle, String place, String contentChimg, String contentImgPath, String userName,Date reservationDate, Date viewDate, String paymentType,
			String paymentTotal) {
		super();
		this.ticketNo = ticketNo;
		this.viewDate = viewDate;
		this.reservationDate = reservationDate;
		this.contentType = contentType;
		this.contnetTitle = contnetTitle;
		this.paymentType = paymentType;
		this.paymentTotal = paymentTotal;
		this.place = place;
		this.userName = userName;
		this.contentChimg = contentChimg;
		this.contentImgPath = contentImgPath;
	}

	public Date getViewDatecancel() {
		return viewDatecancel;
	}

	public void setViewDatecancel(Date viewDatecancel) {
		this.viewDatecancel = viewDatecancel;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	@Override
	public String toString() {
		return "Reservation [ticketNo=" + ticketNo + ", userNo=" + userNo + ", contentNo=" + contentNo
				+ ", reservationDate=" + reservationDate + ", viewDate=" + viewDate + ", ticketNum=" + ticketNum
				+ ", roundNo=" + roundNo + ", contentType=" + contentType + ", contnetTitle=" + contnetTitle
				+ ", paymentDate=" + paymentDate + ", viewDatecancel=" + viewDatecancel + ", paymentType=" + paymentType
				+ ", paymentStatus=" + paymentStatus + ", paymentTotal=" + paymentTotal + ", paymentCancel="
				+ paymentCancel + ", place=" + place + ", userName=" + userName + ", contentChimg=" + contentChimg
				+ ", contentImgPath=" + contentImgPath + "]";
	}

	

	
	
	
	
	

}
