package com.example.interviewtrackerdemo.entity;

// created dto, this we are using as we need update the feedback and judgement
public class Review {

	private String feedback;
	private String judgement;
	
	
	public Review(String feedback, String judgement) {
		this.feedback = feedback;
		this.judgement = judgement;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getJudgement() {
		return judgement;
	}
	public void setJudgement(String judgement) {
		this.judgement = judgement;
	}
	
	
	
}
