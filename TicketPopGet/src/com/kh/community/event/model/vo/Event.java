package com.kh.community.event.model.vo;

import java.sql.Clob;
import java.sql.Date;

public class Event {
	
	private int eventNo;
	private int contentNo;
	private String eventType;
	private String eventTitle;
	private Clob eventContent;
	private Date eventDate;
	private int eventCount;
	private String eventStatus;
	private String adminId;
	
	public Event() {
		// TODO Auto-generated constructor stub
	}

	public Event(int eventNo, int contentNo, String eventType, String eventTitle, Clob eventContent, Date eventDate,
			int eventCount, String eventStatus, String adminId) {
		super();
		this.eventNo = eventNo;
		this.contentNo = contentNo;
		this.eventType = eventType;
		this.eventTitle = eventTitle;
		this.eventContent = eventContent;
		this.eventDate = eventDate;
		this.eventCount = eventCount;
		this.eventStatus = eventStatus;
		this.adminId = adminId;
	}

	
	
	public Event(int eventNo, int contentNo, String eventType, String eventTitle, Date eventDate, int eventCount) {
		super();
		this.eventNo = eventNo;
		this.contentNo = contentNo;
		this.eventType = eventType;
		this.eventTitle = eventTitle;
		this.eventDate = eventDate;
		this.eventCount = eventCount;
	}

	public int getEventNo() {
		return eventNo;
	}

	public void setEventNo(int eventNo) {
		this.eventNo = eventNo;
	}

	public int getContentNo() {
		return contentNo;
	}

	public void setContentNo(int contentNo) {
		this.contentNo = contentNo;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public Clob getEventContent() {
		return eventContent;
	}

	public void setEventContent(Clob eventContent) {
		this.eventContent = eventContent;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public int getEventCount() {
		return eventCount;
	}

	public void setEventCount(int eventCount) {
		this.eventCount = eventCount;
	}

	public String getEventStatus() {
		return eventStatus;
	}

	public void setEventStatus(String eventStatus) {
		this.eventStatus = eventStatus;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	@Override
	public String toString() {
		return "Event [eventNo=" + eventNo + ", contentNo=" + contentNo + ", eventType=" + eventType + ", eventTitle="
				+ eventTitle + ", eventContent=" + eventContent + ", eventDate=" + eventDate + ", eventCount="
				+ eventCount + ", eventStatus=" + eventStatus + ", adminId=" + adminId + "]";
	}
	
	

}
