package com.kh.common.model.vo;

import java.sql.Date;

public class MainContent {
	
	private int rownum;	//순번
	private int contentNo;
	private int rate;	//예매율
	private String title;
	private String genre;
	private String changeImg;
	private String imgPath;
	private Date concertDate;
	
	public MainContent() {
		// TODO Auto-generated constructor stub
	}
	public MainContent(int rownum, int contentNo, int rate, String title, String genre,  String changeImg,
			String imgPath) {
		super();
		this.rownum = rownum;
		this.contentNo = contentNo;
		this.rate = rate;
		this.title = title;
		this.genre = genre;
		this.changeImg = changeImg;
		this.imgPath = imgPath;
	}
	
	
	
	public MainContent(int contentNo, int rate, String title, String genre,  String changeImg, String imgPath) {
		super();
		this.contentNo = contentNo;
		this.rate = rate;
		this.title = title;
		this.genre = genre;
		this.changeImg = changeImg;
		this.imgPath = imgPath;
	}
	
	
	
	public MainContent(int contentNo, String title, String genre, String changeImg, String imgPath, Date concertDate) {
		super();
		this.contentNo = contentNo;
		this.title = title;
		this.genre = genre;
		this.changeImg = changeImg;
		this.imgPath = imgPath;
		this.concertDate = concertDate;
	}
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public int getContentNo() {
		return contentNo;
	}
	public void setContentNo(int contentNo) {
		this.contentNo = contentNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public String getChangeImg() {
		return changeImg;
	}
	public void setChangeImg(String changeImg) {
		this.changeImg = changeImg;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	
	public Date getConcertDate() {
		return concertDate;
	}
	public void setConcertDate(Date concertDate) {
		this.concertDate = concertDate;
	}
	@Override
	public String toString() {
		return "MainContent [rownum=" + rownum + ", contentNo=" + contentNo + ", title=" + title + ", genre=" + genre
				+ ", rate=" + rate + ", changeImg=" + changeImg + ", imgPath=" + imgPath + "]";
	}
	
	
	

}
