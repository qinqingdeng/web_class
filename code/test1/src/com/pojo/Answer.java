package com.pojo;

public class Answer extends Question {
	private String aId;
	private String aContent;
	private String aScore;
	private String analysis;
	public String getaId() {
		return aId;
	}
	public void setaId(String string) {
		this.aId = string;
	}
	public String getaContent() {
		return aContent;
	}
	public void setaContent(String aContent) {
		this.aContent = aContent;
	}
	public String getaScore() {
		return aScore;
	}
	public void setaScore(String string) {
		this.aScore = string;
	}
	public String getAnalysis() {
		return analysis;
	}
	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}
}
