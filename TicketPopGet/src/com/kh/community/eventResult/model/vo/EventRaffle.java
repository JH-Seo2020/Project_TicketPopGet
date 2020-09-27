package com.kh.community.eventResult.model.vo;

import java.sql.Date;

public class EventRaffle {
	
	private int rNum;
	private int raffleNo;
	private int eventNo;
	private String raffleTitle;
	private String raffleContent;
	private Date raffleDate;
	private int raffleCount;
	private String raffleStatus;
	private String adminId;
	private String eventType;
	
	public EventRaffle() {
		// TODO Auto-generated constructor stub
	}

	public EventRaffle(int raffleNo, int eventNo, String raffleTitle, String raffleContent, Date raffleDate,
			int raffleCount, String raffleStatus, String adminId) {
		super();
		this.raffleNo = raffleNo;
		this.eventNo = eventNo;
		this.raffleTitle = raffleTitle;
		this.raffleContent = raffleContent;
		this.raffleDate = raffleDate;
		this.raffleCount = raffleCount;
		this.raffleStatus = raffleStatus;
		this.adminId = adminId;
	}
	
	

	public EventRaffle(int rNum, int raffleNo, int eventNo, String raffleTitle, String raffleContent, Date raffleDate,
			int raffleCount, String raffleStatus, String adminId, String eventType) {
		super();
		this.rNum = rNum;
		this.raffleNo = raffleNo;
		this.eventNo = eventNo;
		this.raffleTitle = raffleTitle;
		this.raffleContent = raffleContent;
		this.raffleDate = raffleDate;
		this.raffleCount = raffleCount;
		this.raffleStatus = raffleStatus;
		this.adminId = adminId;
		this.eventType = eventType;
	}

	public int getRaffleNo() {
		return raffleNo;
	}

	public void setRaffleNo(int raffleNo) {
		this.raffleNo = raffleNo;
	}

	public int getEventNo() {
		return eventNo;
	}

	public void setEventNo(int eventNo) {
		this.eventNo = eventNo;
	}

	public String getRaffleTitle() {
		return raffleTitle;
	}

	public void setRaffleTitle(String raffleTitle) {
		this.raffleTitle = raffleTitle;
	}

	public String getRaffleContent() {
		return raffleContent;
	}

	public void setRaffleContent(String raffleContent) {
		this.raffleContent = raffleContent;
	}

	public Date getRaffleDate() {
		return raffleDate;
	}

	public void setRaffleDate(Date raffleDate) {
		this.raffleDate = raffleDate;
	}

	public int getRaffleCount() {
		return raffleCount;
	}

	public void setRaffleCount(int raffleCount) {
		this.raffleCount = raffleCount;
	}

	public String getRaffleStatus() {
		return raffleStatus;
	}

	public void setRaffleStatus(String raffleStatus) {
		this.raffleStatus = raffleStatus;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	
	

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	
	

	public int getrNum() {
		return rNum;
	}

	public void setrNum(int rNum) {
		this.rNum = rNum;
	}

	@Override
	public String toString() {
		return "EventRaffle [raffleNo=" + raffleNo + ", eventNo=" + eventNo + ", raffleTitle=" + raffleTitle
				+ ", raffleContent=" + raffleContent + ", raffleDate=" + raffleDate + ", raffleCount=" + raffleCount
				+ ", raffleStatus=" + raffleStatus + ", adminId=" + adminId + "]";
	}
	
	

}
