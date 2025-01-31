package com.kh.user.model.vo;

import java.sql.Date;

public class Member {
	
	private int userNo;
	private String userId;
	private String userPwd;
	private String userName;
	private String email;
	private String phone;
	private Date birthdate;
	private String gender;
	private Date deleteDate;
	private String status;
	private String blacklistStatus;
	private int reportCount;
	private String delete_reason;
	private int reportCounter;
	private String bdate;
	private String deleteStatus;
	
	public Member() {}

	public Member(int userNo, String userId, String userPwd, String userName, String email, String phone,
			Date birthdate, String gender, Date deleteDate, String status, String blacklistStatus, int reportCount,
			String delete_reason) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.birthdate = birthdate;
		this.gender = gender;
		this.deleteDate = deleteDate;
		this.status = status;
		this.blacklistStatus = blacklistStatus;
		this.reportCount = reportCount;
		this.delete_reason = delete_reason;
	}
	
	// 회원가입
	public Member(String userId, String userPwd, String userName, String email, String phone, Date birthdate,
			String gender) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.birthdate = birthdate;
		this.gender = gender;
	}
	
	// 정보수정
	public Member(String userId, String userName, Date birthdate, String gender, String phone, String email) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.birthdate = birthdate;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
	}

	//id찾기
	public Member(String userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}
	
	// pass찾기
	public Member(String userPwd, String userName, String phone) {
		super();
		this.userPwd = userPwd;
		this.userName = userName;
		this.phone = phone;
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

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBlacklistStatus() {
		return blacklistStatus;
	}

	public void setBlacklistStatus(String blacklistStatus) {
		this.blacklistStatus = blacklistStatus;
	}

	public int getReportCount() {
		return reportCount;
	}

	public void setReportCount(int reportCount) {
		this.reportCount = reportCount;
	}

	public String getDelete_reason() {
		return delete_reason;
	}

	public void setDelete_reason(String delete_reason) {
		this.delete_reason = delete_reason;
	}
	
	public int getReportCounter() {
		return reportCounter;
	}

	public void setReportCounter(int reportCounter) {
		this.reportCounter = reportCounter;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public String getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(String deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName
				+ ", email=" + email + ", phone=" + phone + ", birthdate=" + birthdate + ", gender=" + gender
				+ ", deleteDate=" + deleteDate + ", status=" + status + ", blacklistStatus=" + blacklistStatus
				+ ", reportCount=" + reportCount + ", delete_reason=" + delete_reason + ", reportCounter="
				+ reportCounter + ", bdate=" + bdate + ", deleteStatus=" + deleteStatus + "]";
	}




}
