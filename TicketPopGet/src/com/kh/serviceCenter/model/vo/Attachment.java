package com.kh.serviceCenter.model.vo;

public class Attachment {
	
	private String questionFileO;
	private String questionFileC;
	private String questionImgPath;
	
	public Attachment() {}

	public Attachment(String questionFileO, String questionFileC, String questionImgPath) {
		super();
		this.questionFileO = questionFileO;
		this.questionFileC = questionFileC;
		this.questionImgPath = questionImgPath;
	}

	public String getQuestionFileO() {
		return questionFileO;
	}

	public void setQuestionFileO(String questionFileO) {
		this.questionFileO = questionFileO;
	}

	public String getQuestionFileC() {
		return questionFileC;
	}

	public void setQuestionFileC(String questionFileC) {
		this.questionFileC = questionFileC;
	}

	public String getQuestionImgPath() {
		return questionImgPath;
	}

	public void setQuestionImgPath(String questionImgPath) {
		this.questionImgPath = questionImgPath;
	}

	@Override
	public String toString() {
		return "Attachment [questionFileO=" + questionFileO + ", questionFileC=" + questionFileC + ", questionImgPath="
				+ questionImgPath + "]";
	}
	
	

}
