package com.kh.serviceCenter.model.vo;

import java.sql.Date;

public class Question {
	
	private int questionNo;
	private String questionUser;
	private String answerStatus;
	private String questionType;
	private String questionTitle;
	private String questionContent;
	private Date questionDate;
	private String questionStatus;
	private String questionAnswer;
	private String questionAdmin;
	
	public Question() {}

	public Question(int questionNo, String questionUser, String answerStatus, String questionType, String questionTitle,
			String questionContent, Date questionDate, String questionStatus, String questionAnswer,
			String questionAdmin) {
		super();
		this.questionNo = questionNo;
		this.questionUser = questionUser;
		this.answerStatus = answerStatus;
		this.questionType = questionType;
		this.questionTitle = questionTitle;
		this.questionContent = questionContent;
		this.questionDate = questionDate;
		this.questionStatus = questionStatus;
		this.questionAnswer = questionAnswer;
		this.questionAdmin = questionAdmin;
	}
	

	public Question(int questionNo, String answerStatus, String questionType, String questionTitle, Date questionDate) {
		super();
		this.questionNo = questionNo;
		this.answerStatus = answerStatus;
		this.questionType = questionType;
		this.questionTitle = questionTitle;
		this.questionDate = questionDate;
	}
	
	

	public Question(int questionNo, String questionType, String questionTitle, String questionContent,
			Date questionDate, String questionAnswer) {
		super();
		this.questionNo = questionNo;
		this.questionType = questionType;
		this.questionTitle = questionTitle;
		this.questionContent = questionContent;
		this.questionDate = questionDate;
		this.questionAnswer = questionAnswer;
	}

	public int getQuestionNo() {
		return questionNo;
	}

	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}

	public String getQuestionUser() {
		return questionUser;
	}

	public void setQuestionUser(String questionUser) {
		this.questionUser = questionUser;
	}

	public String getAnswerStatus() {
		return answerStatus;
	}

	public void setAnswerStatus(String answerStatus) {
		this.answerStatus = answerStatus;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	public Date getQuestionDate() {
		return questionDate;
	}

	public void setQuestionDate(Date questionDate) {
		this.questionDate = questionDate;
	}

	public String getQuestionStatus() {
		return questionStatus;
	}

	public void setQuestionStatus(String questionStatus) {
		this.questionStatus = questionStatus;
	}

	public String getQuestionAnswer() {
		return questionAnswer;
	}

	public void setQuestionAnswer(String questionAnswer) {
		this.questionAnswer = questionAnswer;
	}

	public String getQuestionAdmin() {
		return questionAdmin;
	}

	public void setQuestionAdmin(String questionAdmin) {
		this.questionAdmin = questionAdmin;
	}

	@Override
	public String toString() {
		return "Question [questionNo=" + questionNo + ", questionUser=" + questionUser + ", answerStatus="
				+ answerStatus + ", questionType=" + questionType + ", questionTitle=" + questionTitle
				+ ", questionContent=" + questionContent + ", questionDate=" + questionDate + ", questionStatus="
				+ questionStatus + ", questionAnswer=" + questionAnswer + ", questionAdmin=" + questionAdmin + "]";
	}

	
	
}
