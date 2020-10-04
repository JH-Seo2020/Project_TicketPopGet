package com.kh.payment.model.vo;

import java.sql.Date;

public class ConcertPayment {
	
	private int contentNo;			// 콘텐츠 번호
	private String contentType;		// 콘텐츠 유형
	private String contentTitle;	// 콘텐츠 제목
	private Date concertDate;		// 콘서트 날짜
	private String concertRuntime;	// 콘서트 시간 
	private int concertMax;			// 콘서트 총좌석수
	private int concertSeats;		// 콘서트 잔여석수
	private String price;			// 콘서트 티켓금액
	private String place;			// 콘서트 장소
	private String contentOriginImg;// 포스터이미지 원본
	private String contentChangeImg;// 포스터이미지 수정
	private String imgPath;			// 파일경로
	private Date paymentDate;		// 결제일자
	private String paymentType;		// 결제방법
	private String paymentStatus;	// 결제여부
	private String paymentTotal;	// 총결제금액
	private int userNo;				// 회원번호
	private int ticketNum;			// 예매매수
	private Date reservationDate;	// 예매일
	
	public ConcertPayment() {}

	public ConcertPayment(int contentNo, String contentType, String contentTitle, Date concertDate,
			String concertRuntime, int concertMax, int concertSeats, String price, String place,
			String contentOriginImg, String contentChangeImg, String imgPath, Date paymentDate, String paymentType,
			String paymentStatus, String paymentTotal, int userNo, int ticketNum, Date reservationDate) {
		super();
		this.contentNo = contentNo;
		this.contentType = contentType;
		this.contentTitle = contentTitle;
		this.concertDate = concertDate;
		this.concertRuntime = concertRuntime;
		this.concertMax = concertMax;
		this.concertSeats = concertSeats;
		this.price = price;
		this.place = place;
		this.contentOriginImg = contentOriginImg;
		this.contentChangeImg = contentChangeImg;
		this.imgPath = imgPath;
		this.paymentDate = paymentDate;
		this.paymentType = paymentType;
		this.paymentStatus = paymentStatus;
		this.paymentTotal = paymentTotal;
		this.userNo = userNo;
		this.ticketNum = ticketNum;
		this.reservationDate = reservationDate;
	}

	public int getContentNo() {
		return contentNo;
	}

	public void setContentNo(int contentNo) {
		this.contentNo = contentNo;
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

	public Date getConcertDate() {
		return concertDate;
	}

	public void setConcertDate(Date concertDate) {
		this.concertDate = concertDate;
	}

	public String getConcertRuntime() {
		return concertRuntime;
	}

	public void setConcertRuntime(String concertRuntime) {
		this.concertRuntime = concertRuntime;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getContentOriginImg() {
		return contentOriginImg;
	}

	public void setContentOriginImg(String contentOriginImg) {
		this.contentOriginImg = contentOriginImg;
	}

	public String getContentChangeImg() {
		return contentChangeImg;
	}

	public void setContentChangeImg(String contentChangeImg) {
		this.contentChangeImg = contentChangeImg;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
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

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getTicketNum() {
		return ticketNum;
	}

	public void setTicketNum(int ticketNum) {
		this.ticketNum = ticketNum;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	@Override
	public String toString() {
		return "ConcertPayment [contentNo=" + contentNo + ", contentType=" + contentType + ", contentTitle="
				+ contentTitle + ", concertDate=" + concertDate + ", concertRuntime=" + concertRuntime + ", concertMax="
				+ concertMax + ", concertSeats=" + concertSeats + ", price=" + price + ", place=" + place
				+ ", contentOriginImg=" + contentOriginImg + ", contentChangeImg=" + contentChangeImg + ", imgPath="
				+ imgPath + ", paymentDate=" + paymentDate + ", paymentType=" + paymentType + ", paymentStatus="
				+ paymentStatus + ", paymentTotal=" + paymentTotal + ", userNo=" + userNo + ", ticketNum=" + ticketNum
				+ ", reservationDate=" + reservationDate + "]";
	}
	
	
	
	

}
