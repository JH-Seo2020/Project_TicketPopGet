package com.kh.user.model.vo;

public class Search {

	private int contentNo; //컨텐츠 등록번호
	private String contentType; //컨텐츠작품분류
	private String contentTitle; // 컨텐츠제목
	private String contnetSubject; //주최
	private String place; //장소
	private String limit; //관람등급
	private String price; // 가격
	private String keyword; //키워드
	private String contentStatus; //게재여부
	private String region; //지역
	private String contentChimg; // 이미지수정
	private String contentImgpath; // 파일경로
	
	public Search() {};
	
	public Search(int contentNo, String contentType, String contentTitle, String contnetSubject, String place,
			String limit, String price, String keyword, String contentStatus, String region, String contentChimg,
			String contentImgpath) {
		super();
		this.contentNo = contentNo;
		this.contentType = contentType;
		this.contentTitle = contentTitle;
		this.contnetSubject = contnetSubject;
		this.place = place;
		this.limit = limit;
		this.price = price;
		this.keyword = keyword;
		this.contentStatus = contentStatus;
		this.region = region;
		this.contentChimg = contentChimg;
		this.contentImgpath = contentImgpath;
	}

	
	
	public Search(int contentNo, String contentType, String contentTitle, String place, String price, String region,
			String contentChimg, String contentImgpath) {
		super();
		this.contentNo = contentNo;
		this.contentType = contentType;
		this.contentTitle = contentTitle;
		this.place = place;
		this.price = price;
		this.region = region;
		this.contentChimg = contentChimg;
		this.contentImgpath = contentImgpath;
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

	public String getContnetSubject() {
		return contnetSubject;
	}

	public void setContnetSubject(String contnetSubject) {
		this.contnetSubject = contnetSubject;
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

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getContentStatus() {
		return contentStatus;
	}

	public void setContentStatus(String contentStatus) {
		this.contentStatus = contentStatus;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getContentChimg() {
		return contentChimg;
	}

	public void setContentChimg(String contentChimg) {
		this.contentChimg = contentChimg;
	}

	public String getContentImgpath() {
		return contentImgpath;
	}

	public void setContentImgpath(String contentImgpath) {
		this.contentImgpath = contentImgpath;
	}

	@Override
	public String toString() {
		return "Search [contentNo=" + contentNo + ", contentType=" + contentType + ", contentTitle=" + contentTitle
				+ ", contnetSubject=" + contnetSubject + ", place=" + place + ", limit=" + limit + ", price=" + price
				+ ", keyword=" + keyword + ", contentStatus=" + contentStatus + ", region=" + region + ", contentChimg="
				+ contentChimg + ", contentImgpath=" + contentImgpath + "]";
	}
	
}
