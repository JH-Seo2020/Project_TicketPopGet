package com.kh.admin.adminContents.model.vo;

import java.sql.Date;

public class Contents {
	
	private int contentNo;
	private String contentType;
	private String contentTitle;
	private String contentSubject;
	private String place;
	private String limit;
	private String price;
	private String contentKeyword;
	private String info;
	private String contentStatus;
	private int latitude;
	private int longtitude;
	private String region;
	private String contentOgImg;
	private String contentChImg;
	private String contentImgPath;
	private String contentRuntime;
	private String contentTerm;
	private String startDate;
	private String endDate;
	private String contentDate;
	private String startTime;
	private String endTime;
	private String round;
	private int roundNo;
	private int Max;
	private int seats;
	
	private Date startDay;
	private Date endDay;
	private Date contentDay;
	
	public Contents() {}
	
	public Contents(int contentNo, String contentType, String contentTitle, String contentSubject, String place,
			String limit, String price, String contentKeyword, String info, String contentStatus, int latitude,
			int longtitude, String region, String contentOgImg, String contentChImg, String contentImgPath,
			String contentRuntime, String contentTerm, String startDate, String endDate, String contentDate,
			String startTime, String endTime, String round, int roundNo, int max, int seats) {
		super();
		this.contentNo = contentNo;
		this.contentType = contentType;
		this.contentTitle = contentTitle;
		this.contentSubject = contentSubject;
		this.place = place;
		this.limit = limit;
		this.price = price;
		this.contentKeyword = contentKeyword;
		this.info = info;
		this.contentStatus = contentStatus;
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.region = region;
		this.contentOgImg = contentOgImg;
		this.contentChImg = contentChImg;
		this.contentImgPath = contentImgPath;
		this.contentRuntime = contentRuntime;
		this.contentTerm = contentTerm;
		this.startDate = startDate;
		this.endDate = endDate;
		this.contentDate = contentDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.round = round;
		this.roundNo = roundNo;
		Max = max;
		this.seats = seats;
	}

	public Contents(int contentNo, String contentType, String contentTitle, String contentSubject, String place,
			String limit, String price, String contentKeyword, String info, String region, String contentOgImg,
			String contentChImg, String contentImgPath, String contentRuntime, String startDate, String endDate,
			String contentDate, String startTime, String endTime, String round, int max) {
		super();
		this.contentNo = contentNo;
		this.contentType = contentType;
		this.contentTitle = contentTitle;
		this.contentSubject = contentSubject;
		this.place = place;
		this.limit = limit;
		this.price = price;
		this.contentKeyword = contentKeyword;
		this.info = info;
		this.region = region;
		this.contentOgImg = contentOgImg;
		this.contentChImg = contentChImg;
		this.contentImgPath = contentImgPath;
		this.contentRuntime = contentRuntime;
		this.startDate = startDate;
		this.endDate = endDate;
		this.contentDate = contentDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.round = round;
		Max = max;
	}

	public Contents(String contentTitle, String contentSubject, String place, String limit, String price,
			String contentKeyword, String info, String region, String startDate, String endDate) {
		super();
		this.contentTitle = contentTitle;
		this.contentSubject = contentSubject;
		this.place = place;
		this.limit = limit;
		this.price = price;
		this.contentKeyword = contentKeyword;
		this.info = info;
		this.region = region;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Contents(String contentTitle, String contentSubject, String place, String limit, String price,
			String contentKeyword, String info, String region, String contentRuntime, String startDate, int max) {
		super();
		this.contentTitle = contentTitle;
		this.contentSubject = contentSubject;
		this.place = place;
		this.limit = limit;
		this.price = price;
		this.contentKeyword = contentKeyword;
		this.info = info;
		this.region = region;
		this.contentRuntime = contentRuntime;
		this.startDate = startDate;
		Max = max;
	}

	public Contents(String contentTitle, String contentSubject, String place, String limit, String price,
			String contentKeyword, String info, String region, String contentRuntime, String startDate, String endDate,
			String contentDate, String startTime, String endTime, String round, int max) {
		super();
		this.contentTitle = contentTitle;
		this.contentSubject = contentSubject;
		this.place = place;
		this.limit = limit;
		this.price = price;
		this.contentKeyword = contentKeyword;
		this.info = info;
		this.region = region;
		this.contentRuntime = contentRuntime;
		this.startDate = startDate;
		this.endDate = endDate;
		this.contentDate = contentDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.round = round;
		Max = max;
	}
	
	public Contents(int contentNo, String contentType, String contentTitle, String contentSubject, String place,
			String limit, String price, String contentKeyword, String info, String contentStatus, int latitude,
			int longtitude, String region, String contentOgImg, String contentChImg, String contentImgPath) {
		super();
		this.contentNo = contentNo;
		this.contentType = contentType;
		this.contentTitle = contentTitle;
		this.contentSubject = contentSubject;
		this.place = place;
		this.limit = limit;
		this.price = price;
		this.contentKeyword = contentKeyword;
		this.info = info;
		this.contentStatus = contentStatus;
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.region = region;
		this.contentOgImg = contentOgImg;
		this.contentChImg = contentChImg;
		this.contentImgPath = contentImgPath;
	}


	public Contents(int contentNo, String contentType, String contentTitle, String contentSubject, String place,
			String limit, String price, String contentKeyword, String info, String contentOgImg, String contentChImg,
			String contentImgPath, String contentRuntime, String startDate, String endDate, String contentDate,
			String startTime, String endTime, String round, int max, int seats) {
		super();
		this.contentNo = contentNo;
		this.contentType = contentType;
		this.contentTitle = contentTitle;
		this.contentSubject = contentSubject;
		this.place = place;
		this.limit = limit;
		this.price = price;
		this.contentKeyword = contentKeyword;
		this.info = info;
		this.contentOgImg = contentOgImg;
		this.contentChImg = contentChImg;
		this.contentImgPath = contentImgPath;
		this.contentRuntime = contentRuntime;
		this.startDate = startDate;
		this.endDate = endDate;
		this.contentDate = contentDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.round = round;
		Max = max;
		this.seats = seats;
	}


	public Contents(String contentTitle, String contentSubject, String place, String limit, String price,
			String contentKeyword, String info, String region, String contentRuntime, String startDate, String endDate,
			String contentDate, String startTime, String endTime, int max) {
		super();
		this.contentTitle = contentTitle;
		this.contentSubject = contentSubject;
		this.place = place;
		this.limit = limit;
		this.price = price;
		this.contentKeyword = contentKeyword;
		this.info = info;
		this.region = region;
		this.contentRuntime = contentRuntime;
		this.startDate = startDate;
		this.endDate = endDate;
		this.contentDate = contentDate;
		this.startTime = startTime;
		this.endTime = endTime;
		Max = max;
	}


	public Contents(int contentNo, String contentTitle, String contentSubject, String place, String limit, String price,
			String contentKeyword, String info, String region, String contentRuntime, String startDate, String endDate,
			String contentDate, String startTime, String endTime, int max) {
		super();
		this.contentNo = contentNo;
		this.contentTitle = contentTitle;
		this.contentSubject = contentSubject;
		this.place = place;
		this.limit = limit;
		this.price = price;
		this.contentKeyword = contentKeyword;
		this.info = info;
		this.region = region;
		this.contentRuntime = contentRuntime;
		this.startDate = startDate;
		this.endDate = endDate;
		this.contentDate = contentDate;
		this.startTime = startTime;
		this.endTime = endTime;
		Max = max;
	}


	public Contents(int contentNo, String contentType, String contentTitle, String contentSubject, String place,
			String limit, String price, String contentKeyword, String info, String contentStatus, int latitude,
			int longtitude, String region, String contentOgImg, String contentChImg, String contentImgPath,
			String contentRuntime, String contentTerm, String startDate, String endDate, String contentDate,
			String startTime, String endTime, int max, int seats) {
		super();
		this.contentNo = contentNo;
		this.contentType = contentType;
		this.contentTitle = contentTitle;
		this.contentSubject = contentSubject;
		this.place = place;
		this.limit = limit;
		this.price = price;
		this.contentKeyword = contentKeyword;
		this.info = info;
		this.contentStatus = contentStatus;
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.region = region;
		this.contentOgImg = contentOgImg;
		this.contentChImg = contentChImg;
		this.contentImgPath = contentImgPath;
		this.contentRuntime = contentRuntime;
		this.contentTerm = contentTerm;
		this.startDate = startDate;
		this.endDate = endDate;
		this.contentDate = contentDate;
		this.startTime = startTime;
		this.endTime = endTime;
		Max = max;
		this.seats = seats;
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

	public String getContentSubject() {
		return contentSubject;
	}

	public void setContentSubject(String contentSubject) {
		this.contentSubject = contentSubject;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getContentKeyword() {
		return contentKeyword;
	}

	public void setContentKeyword(String contentKeyword) {
		this.contentKeyword = contentKeyword;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getContentStatus() {
		return contentStatus;
	}

	public void setContentStatus(String contentStatus) {
		this.contentStatus = contentStatus;
	}

	public int getLatitude() {
		return latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public int getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(int longtitude) {
		this.longtitude = longtitude;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getContentOgImg() {
		return contentOgImg;
	}

	public void setContentOgImg(String contentOgImg) {
		this.contentOgImg = contentOgImg;
	}

	public String getContentChImg() {
		return contentChImg;
	}

	public void setContentChImg(String contentChImg) {
		this.contentChImg = contentChImg;
	}

	public String getContentImgPath() {
		return contentImgPath;
	}

	public void setContentImgPath(String contentImgPath) {
		this.contentImgPath = contentImgPath;
	}

	public String getContentRuntime() {
		return contentRuntime;
	}

	public void setContentRuntime(String contentRuntime) {
		this.contentRuntime = contentRuntime;
	}

	public String getContentTerm() {
		return contentTerm;
	}

	public void setContentTerm(String contentTerm) {
		this.contentTerm = contentTerm;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getContentDate() {
		return contentDate;
	}

	public void setContentDate(String contentDate) {
		this.contentDate = contentDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getMax() {
		return Max;
	}

	public void setMax(int max) {
		Max = max;
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


	public int getRoundNo() {
		return roundNo;
	}

	public void setRoundNo(int roundNo) {
		this.roundNo = roundNo;
	}

	public Date getStartDay() {
		return startDay;
	}

	public void setStartDay(Date startDay) {
		this.startDay = startDay;
	}

	public Date getEndDay() {
		return endDay;
	}

	public void setEndDay(Date endDay) {
		this.endDay = endDay;
	}

	public Date getContentDay() {
		return contentDay;
	}

	public void setContentDay(Date contentDay) {
		this.contentDay = contentDay;
	}

	@Override
	public String toString() {
		return "Contents [contentNo=" + contentNo + ", contentType=" + contentType + ", contentTitle=" + contentTitle
				+ ", contentSubject=" + contentSubject + ", place=" + place + ", limit=" + limit + ", price=" + price
				+ ", contentKeyword=" + contentKeyword + ", info=" + info + ", contentStatus=" + contentStatus
				+ ", latitude=" + latitude + ", longtitude=" + longtitude + ", region=" + region + ", contentOgImg="
				+ contentOgImg + ", contentChImg=" + contentChImg + ", contentImgPath=" + contentImgPath
				+ ", contentRuntime=" + contentRuntime + ", contentTerm=" + contentTerm + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", contentDate=" + contentDate + ", startTime=" + startTime + ", endTime="
				+ endTime + ", round=" + round + ", roundNo=" + roundNo + ", Max=" + Max + ", seats=" + seats
				+ ", startDay=" + startDay + ", endDay=" + endDay + ", contentDay=" + contentDay + "]";
	}



}
