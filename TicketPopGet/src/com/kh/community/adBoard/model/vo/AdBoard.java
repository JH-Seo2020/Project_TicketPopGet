package com.kh.community.adBoard.model.vo;

import java.sql.Clob;
import java.sql.Date;

public class AdBoard {

	private int boardNo;
	private String boardType;
	private String boardLocation;
	private String boardTitle;
	private Clob boardContent;
	private Date boardDate;
	private int boardCount;
	private String boardStatus;
	private int userNo;
	private String userId;
	
	public AdBoard() {
		// TODO Auto-generated constructor stub
	}

	public AdBoard(int boardNo, String boardType, String boardLocation, String boardTitle, Clob boardContent,
			Date boardDate, int boardCount, String boardStatus, int userNo) {
		super();
		this.boardNo = boardNo;
		this.boardType = boardType;
		this.boardLocation = boardLocation;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
		this.boardCount = boardCount;
		this.boardStatus = boardStatus;
		this.userNo = userNo;
	}
	
	

	public AdBoard(int boardNo, String boardType, String boardLocation, String boardTitle, Date boardDate,
			int boardCount) {
		super();
		this.boardNo = boardNo;
		this.boardType = boardType;
		this.boardLocation = boardLocation;
		this.boardTitle = boardTitle;
		this.boardDate = boardDate;
		this.boardCount = boardCount;
	}
	
	

	public AdBoard(int boardNo, String boardType, String boardTitle, Date boardDate, int boardCount, int userNo, String userId) {
		super();
		this.boardNo = boardNo;
		this.boardType = boardType;
		this.boardTitle = boardTitle;
		this.boardDate = boardDate;
		this.boardCount = boardCount;
		this.userNo = userNo;
		this.userId = userId;
	}

	
	
	public AdBoard(int boardNo, String boardType, String boardLocation, String boardTitle, Date boardDate,
			int boardCount, int userNo) {
		super();
		this.boardNo = boardNo;
		this.boardType = boardType;
		this.boardLocation = boardLocation;
		this.boardTitle = boardTitle;
		this.boardDate = boardDate;
		this.boardCount = boardCount;
		this.userNo = userNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardType() {
		return boardType;
	}

	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}

	public String getBoardLocation() {
		return boardLocation;
	}

	public void setBoardLocation(String boardLocation) {
		this.boardLocation = boardLocation;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public Clob getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(Clob boardContent) {
		this.boardContent = boardContent;
	}

	public Date getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}

	public int getBoardCount() {
		return boardCount;
	}

	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}

	public String getBoardStatus() {
		return boardStatus;
	}

	public void setBoardStatus(String boardStatus) {
		this.boardStatus = boardStatus;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	
	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "AdBoard [boardNo=" + boardNo + ", boardType=" + boardType + ", boardLocation=" + boardLocation
				+ ", boardTitle=" + boardTitle + ", boardContent=" + boardContent + ", boardDate=" + boardDate
				+ ", boardCount=" + boardCount + ", boardStatus=" + boardStatus + ", userNo=" + userNo + "]";
	}
	
	
}
