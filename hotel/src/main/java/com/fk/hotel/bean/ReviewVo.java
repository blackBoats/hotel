package com.fk.hotel.bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hotel_review")
public class ReviewVo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long reviewId;
	@Column(nullable=false)
    private String reviewQuestion;
	@Column(nullable=false)
    private String reviewMessage;
	@Column(nullable=false)
    private String reviewUsername;
	@Column(nullable=false)
    private String phoneNumber;
	@Column(nullable=false)
    private Date createDate;
	//0为审核未通过，1为审核通过
	@Column(nullable=false)
    private Integer reviewStatus;
	public Long getReviewId() {
		return reviewId;
	}
	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}
	public String getReviewQuestion() {
		return reviewQuestion;
	}
	public void setReviewQuestion(String reviewQuestion) {
		this.reviewQuestion = reviewQuestion;
	}
	public String getReviewMessage() {
		return reviewMessage;
	}
	public void setReviewMessage(String reviewMessage) {
		this.reviewMessage = reviewMessage;
	}
	public String getReviewUsername() {
		return reviewUsername;
	}
	public void setReviewUsername(String reviewUsername) {
		this.reviewUsername = reviewUsername;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Integer getReviewStatus() {
		return reviewStatus;
	}
	public void setReviewStatus(Integer reviewStatus) {
		this.reviewStatus = reviewStatus;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
    
}
