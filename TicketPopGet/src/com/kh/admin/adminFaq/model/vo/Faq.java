package com.kh.admin.adminFaq.model.vo;

public class Faq {
	private int faqNo;
	private String faqType;
	private String faqTitle;
	private String faqContent;
	private String faqStatus;
	private String adminId;
	
	public Faq() {}
	
	public Faq(int faqNo, String faqType, String faqTitle, String faqContent, String faqStatus, String adminId) {
		super();
		this.faqNo = faqNo;
		this.faqType = faqType;
		this.faqTitle = faqTitle;
		this.faqContent = faqContent;
		this.faqStatus = faqStatus;
		this.adminId = adminId;
	}

	public int getFaqNo() {
		return faqNo;
	}

	public void setFaqNo(int faqNo) {
		this.faqNo = faqNo;
	}

	public String getFaqType() {
		return faqType;
	}

	public void setFaqType(String faqType) {
		this.faqType = faqType;
	}

	public String getFaqTitle() {
		return faqTitle;
	}

	public void setFaqTitle(String faqTitle) {
		this.faqTitle = faqTitle;
	}

	public String getFaqContent() {
		return faqContent;
	}

	public void setFaqContent(String faqContent) {
		this.faqContent = faqContent;
	}

	public String getFaqStatus() {
		return faqStatus;
	}

	public void setFaqStatus(String faqStatus) {
		this.faqStatus = faqStatus;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	@Override
	public String toString() {
		return "Faq [faqNo=" + faqNo + ", faqType=" + faqType + ", faqTitle=" + faqTitle + ", faqContent=" + faqContent
				+ ", faqStatus=" + faqStatus + ", adminId=" + adminId + "]";
	}
	
	
}
