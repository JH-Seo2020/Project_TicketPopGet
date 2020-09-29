package com.kh.admin.adminReport.model.vo;

import java.sql.Date;

/**
 * @author user
 *
 */
/**
 * @author user
 *
 */
public class Report {
	private int reportNo;
	private String reporter;
	private String troublemaker;
	private String reportType;
	private String reportCate;
	private String reportContent;
	private Date reportDate;
	private String reportStatus;
	private int contentNo;
	private String reportInfo;
	private String reportInfoContent;
	
	public Report() {}
	
	public Report(int reportNo, String reporter, String troublemaker, String reportType, String reportCate,
			String reportContent, Date reportDate, String reportStatus, int contentNo, String reportInfo,
			String reportInfoContent) {
		super();
		this.reportNo = reportNo;
		this.reporter = reporter;
		this.troublemaker = troublemaker;
		this.reportType = reportType;
		this.reportCate = reportCate;
		this.reportContent = reportContent;
		this.reportDate = reportDate;
		this.reportStatus = reportStatus;
		this.contentNo = contentNo;
		this.reportInfo = reportInfo;
		this.reportInfoContent = reportInfoContent;
	}

	public Report(int reportNo, String reporter, String troublemaker, String reportType, String reportCate,
			String reportContent, Date reportDate, String reportStatus, int contentNo, String reportInfo) {
		super();
		this.reportNo = reportNo;
		this.reporter = reporter;
		this.troublemaker = troublemaker;
		this.reportType = reportType;
		this.reportCate = reportCate;
		this.reportContent = reportContent;
		this.reportDate = reportDate;
		this.reportStatus = reportStatus;
		this.contentNo = contentNo;
		this.reportInfo = reportInfo;
	}

	public Report(int reportNo, String troublemaker, String reportType, String reportCate, String reportContent,
			Date reportDate, String reportStatus, int contentNo) {
		super();
		this.reportNo = reportNo;
		this.troublemaker = troublemaker;
		this.reportType = reportType;
		this.reportCate = reportCate;
		this.reportContent = reportContent;
		this.reportDate = reportDate;
		this.reportStatus = reportStatus;
		this.contentNo = contentNo;
	}

	public Report(int reportNo, String reporter) {
		super();
		this.reportNo = reportNo;
		this.reporter = reporter;
	}

	public int getReportNo() {
		return reportNo;
	}

	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}

	public String getReporter() {
		return reporter;
	}

	public void setReporter(String reporter) {
		this.reporter = reporter;
	}

	public String getTroublemaker() {
		return troublemaker;
	}

	public void setTroublemaker(String troublemaker) {
		this.troublemaker = troublemaker;
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

	public int getContentNo() {
		return contentNo;
	}

	public void setContentNo(int contentNo) {
		this.contentNo = contentNo;
	}

	public String getReportInfo() {
		return reportInfo;
	}

	public void setReportInfo(String reportInfo) {
		this.reportInfo = reportInfo;
	}

	public String getReportInfoContent() {
		return reportInfoContent;
	}

	public void setReportInfoContent(String reportInfoContent) {
		this.reportInfoContent = reportInfoContent;
	}

	@Override
	public String toString() {
		return "Report [reportNo=" + reportNo + ", reporter=" + reporter + ", troublemaker=" + troublemaker
				+ ", reportType=" + reportType + ", reportCate=" + reportCate + ", reportContent=" + reportContent
				+ ", reportDate=" + reportDate + ", reportStatus=" + reportStatus + ", contentNo=" + contentNo
				+ ", reportInfo=" + reportInfo + ", reportInfoContent=" + reportInfoContent + "]";
	}


	
}
