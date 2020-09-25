package com.kh.exhibition.model.vo;

import java.sql.Date;

public class Exhibition {

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
	private int longitude;
	private String region;
	private String contentOriginImg;
	private String contentChangeImg;
	private String imgPath;
	private Date exhibitionStartDate;
	private Date exhibitionEndDate;
	

	public Exhibition(int contentNo, String contentType, String contentTitle, String contentSubject, String place,
			String limit, String price, String contentKeyword, String info, String contentStatus, int latitude,
			int longitude, String region, String contentOriginImg, String contentChangeImg, String imgPath) {
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
		this.longitude = longitude;
		this.region = region;
		this.contentOriginImg = contentOriginImg;
		this.contentChangeImg = contentChangeImg;
		this.imgPath = imgPath;
	}

	public Exhibition(int contentNo, String contentTitle, String contentKeyword, String region, String contentChangeImg, String imgPath, Date exhibitionStartDate, Date exhibitionEndDate) {
		super();
		this.contentNo = contentNo;
		this.contentTitle = contentTitle;
		this.contentKeyword = contentKeyword;
		this.region = region;
		this.contentChangeImg = contentChangeImg;
		this.imgPath = imgPath;
		this.exhibitionStartDate = exhibitionStartDate;
		this.exhibitionEndDate = exhibitionEndDate;
		
	}

	public Exhibition(int contentNo, String contentType, String contentTitle, String contentSubject, String place,
			String limit, String price, String contentKeyword, int latitude, int longitude, String region,
			String contentChangeImg, String imgPath, Date exhibitionStartDate, Date exhibitionEndDate) {
		super();
		this.contentNo = contentNo;
		this.contentType = contentType;
		this.contentTitle = contentTitle;
		this.contentSubject = contentSubject;
		this.place = place;
		this.limit = limit;
		this.price = price;
		this.contentKeyword = contentKeyword;
		this.latitude = latitude;
		this.longitude = longitude;
		this.region = region;
		this.contentChangeImg = contentChangeImg;
		this.imgPath = imgPath;
		this.exhibitionStartDate = exhibitionStartDate;
		this.exhibitionEndDate = exhibitionEndDate;
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

	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
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

	public Date getExhibitionStartDate() {
		return exhibitionStartDate;
	}

	public void setExhibitionStartDate(Date exhibitionStartDate) {
		this.exhibitionStartDate = exhibitionStartDate;
	}

	public Date getExhibitionEndDate() {
		return exhibitionEndDate;
	}

	public void setExhibitionEndDate(Date exhibitionEndDate) {
		this.exhibitionEndDate = exhibitionEndDate;
	}

	@Override
	public String toString() {
		return "Exhibition [contentNo=" + contentNo + ", contentType=" + contentType + ", contentTitle=" + contentTitle
				+ ", contentSubject=" + contentSubject + ", place=" + place + ", limit=" + limit + ", price=" + price
				+ ", contentKeyword=" + contentKeyword + ", info=" + info + ", contentStatus=" + contentStatus
				+ ", latitude=" + latitude + ", longitude=" + longitude + ", region=" + region + ", contentOriginImg="
				+ contentOriginImg + ", contentChangeImg=" + contentChangeImg + ", imgPath=" + imgPath
				+ ", exhibitionStartDate=" + exhibitionStartDate + ", exhibitionEndDate=" + exhibitionEndDate + "]";
	}
	
	
	
	
	
}
