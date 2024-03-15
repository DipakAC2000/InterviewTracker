package com.example.interviewtrackerdemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Entity
public class InterviewTracker {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "interviewerName", nullable = false)
    private String interviewerName;
    
    @Column(name = "position", nullable = false)
    private String position;
    
    @Column(name = "employee_name", nullable = false)
    private String employeeName;
    
    @Column(name = "feedback")
    @Length(max = 500, message = "Feedback should be maximum of 500 characters.")
    private String feedback;
    
    @Column(name = "hr_name")
    private String hrName;
    
    @Column(name = "judgement")
    private String judgment;
    
    @Column(name = "panCardNo", nullable = false)
    private String panCardNo;
    
    @NotNull(message = "Interview date/time is required.")
    
    private LocalDateTime dateTime = LocalDateTime.now();
    
    private String recordingLink;

    //here we are taking only getter no need of settter as it is unique and auto incremented
    public long getId() {
        return id;
    }

    public String getInterviewerName() {
        return interviewerName;
    }

    public void setInterviewerName(String interviewerName) {
        this.interviewerName = interviewerName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getHrName() {
        return hrName;
    }

    public void setHrName(String hrName) {
        this.hrName = hrName;
    }

    public String getJudgment() {
        return judgment;
    }

    public void setJudgment(String judgment) {
        this.judgment = judgment;
    }

    public String getPanCardNo() {
        return panCardNo;
    }

    public void setPanCardNo(String panCardNo) {
        this.panCardNo = panCardNo;
    }
    
    //PREVIOUSLY USED GETTER SETTER AS GIVING THE DATE AS INPUT BUT NOW I USED IT AS LOCALDATE.NOW NO NEEED
    //TO TAKE DATA AS INPUT IT WILL DIRECTLY FETCH LOCAL DATE
    
/*
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
*/
    public String getRecordingLink() {
        return recordingLink;
    }

    public void setRecordingLink(String recordingLink) {
        this.recordingLink = recordingLink;
    }
    public InterviewTracker(){

    }

    public InterviewTracker(long id, String interviewerName, String position, String employeeName, String feedback, String hrName, String judgment, String panCardNo, LocalDateTime dateTime, String recordingLink) {
        this.id = id;
        this.interviewerName = interviewerName;
        this.position = position;
        this.employeeName = employeeName;
        this.feedback = feedback;
        this.hrName = hrName;
        this.judgment = judgment;
        this.panCardNo = panCardNo;
        this.dateTime = dateTime;
        this.recordingLink = recordingLink;
    }

    //to display the records 
    @Override
    public String toString() {
        return "InterviewTracker{" +
                "id=" + id +
                ", interviewerName='" + interviewerName + '\'' +
                ", position='" + position + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", feedback='" + feedback + '\'' +
                ", hrName='" + hrName + '\'' +
                ", judgment='" + judgment + '\'' +
                ", panCardNo='" + panCardNo + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", recordingLink='" + recordingLink + '\'' +
                '}';
    }
}

