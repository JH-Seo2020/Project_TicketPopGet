package com.kh.user.model.vo;

import java.sql.Date;

public class Payment {
	
	private int ticketNo;			// 예매번호
	private Date reservationDate;	// 예매일
	private Date viewDate;			// 관람일시
	private int ticketNum;			// 예매매수
	private int roundNo;			// 회차번호
	private String contentType;		// 컨텐츠분류
	private int userNo;				// 회원번호
	private int contentNo;			// 등록번호
	private Date paymentDate;		// 결제일자
	private String paymentType;		// 결제방법
	PAYMENT_STATUS
	private String paymentTotal;	// 총결제금액
	PAYMENT_CANCEL
	
	
	
	
	
	
	결제일자
	결제방법
	결제여부
	총결제금액
	취소여부

}
