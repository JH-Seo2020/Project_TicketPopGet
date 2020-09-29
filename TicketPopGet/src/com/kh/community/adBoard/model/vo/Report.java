package com.kh.community.adBoard.model.vo;

import java.sql.Date;

public class Report {
	
	private int reportNo;
	private int reporter;
	private int troubleMaker;
	private String reportType;
	private String reportCate;
	private String reportContent;
	private Date reportDate;
	private String reportStatus;
	private int adContentNo;
	
	public Report() {
		// TODO Auto-generated constructor stub
	}

	public Report(int reportNo, int reporter, int troubleMaker, String reportType, String reportCate,
			String reportContent, Date reportDate, String reportStatus, int adContentNo) {
		super();
		this.reportNo = reportNo;
		this.reporter = reporter;
		this.troubleMaker = troubleMaker;
		this.reportType = reportType;
		this.reportCate = reportCate;
		this.reportContent = reportContent;
		this.reportDate = reportDate;
		this.reportStatus = reportStatus;
		this.adContentNo = adContentNo;
	}

	public int getReportNo() {
		return reportNo;
	}

	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}

	public int getReporter() {
		return reporter;
	}

	public void setReporter(int reporter) {
		this.reporter = reporter;
	}

	public int getTroubleMaker() {
		return troubleMaker;
	}

	public void setTroubleMaker(int troubleMaker) {
		this.troubleMaker = troubleMaker;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public String getReportCate() {
		return reportCate;
	}

	public void setReportCate(String reportCate) {
		this.reportCate = reportCate;
	}

	public String getReportContent() {
		return reportContent;
	}

	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(String reportStatus) {
		this.reportStatus = reportStatus;
	}

	public int getAdContentNo() {
		return adContentNo;
	}

	public void setAdContentNo(int adContentNo) {
		this.adContentNo = adContentNo;
	}

	@Override
	public String toString() {
		return "Report [reportNo=" + reportNo + ", reporter=" + reporter + ", troubleMaker=" + troubleMaker
				+ ", reportType=" + reportType + ", reportCate=" + reportCate + ", reportContent=" + reportContent
				+ ", reportDate=" + reportDate + ", reportStatus=" + reportStatus + ", adContentNo=" + adContentNo
				+ "]";
	}
	
	

}
