package com.fk.hotel.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

    /*
      * 酒店问答的实体bean:Question
      * quizid:id  
      * quizmessage:message 
      * quizusername:username
      * quiznumber:number
      * quiztime:time
    */

@Entity
@Table(name="hotel_question")
public class Quest {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long quizId;
    private String quizMessage;
    private String quizUsername;
    private String quizAnswer;
    private Date quizTime;
    private Integer quizStatus;
    private Integer quizNumber;
	public Long getQuizId() {
		return quizId;
	}
	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}
	public String getQuizMessage() {
		return quizMessage;
	}
	public void setQuizMessage(String quizMessage) {
		this.quizMessage = quizMessage;
	}
	public String getQuizUsername() {
		return quizUsername;
	}
	public void setQuizUsername(String quizUsername) {
		this.quizUsername = quizUsername;
	}
	
	public Date getQuizTime() {
		return quizTime;
	}
	public void setQuizTime(Date quizTime) {
		this.quizTime = quizTime;
	}
	
	public String getQuizAnswer() {
		return quizAnswer;
	}
	public void setQuizAnswer(String quizAnswer) {
		this.quizAnswer = quizAnswer;
	}
	
	
	public Integer getQuizNumber() {
		return quizNumber;
	}
	public void setQuizNumber(Integer quizNumber) {
		this.quizNumber = quizNumber;
	}
	
	public Integer getQuizStatus() {
		return quizStatus;
	}
	public void setQuizStatus(Integer quizStatus) {
		this.quizStatus = quizStatus;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((quizId == null) ? 0 : quizId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quest other = (Quest) obj;
		if (quizId == null) {
			if (other.quizId != null)
				return false;
		} else if (!quizId.equals(other.quizId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Quest [quizId=" + quizId + ", quizMessage=" + quizMessage + ", quizUsername=" + quizUsername
				+ ", quizAnswer=" + quizAnswer + ", quizTime=" + quizTime + ", quizStatus=" + quizStatus
				+ ", quizNumber=" + quizNumber + "]";
	}
	
       
	
}
