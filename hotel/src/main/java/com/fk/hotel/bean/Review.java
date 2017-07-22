/*package com.fk.hotel.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="hotel_review")
public class Review implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long reviId;
	private String reviMessage;  //点评信息
	private Date reviTime;    //点评时间
	private Integer reviService;  //酒店服务
	private Integer reviEquipment;  //酒店设备设施
	private Integer reviClean;  //酒店卫生
	private Integer reviTraffic; //酒店周边交通
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	public Long getReviId() {
		return reviId;
	}
	public void setReviId(Long reviId) {
		this.reviId = reviId;
	}
	public String getReviMessage() {
		return reviMessage;
	}
	public void setReviMessage(String reviMessage) {
		this.reviMessage = reviMessage;
	}
	public Date getReviTime() {
		return reviTime;
	}
	public void setReviTime(Date reviTime) {
		this.reviTime = reviTime;
	}
	public Integer getReviService() {
		return reviService;
	}
	public void setReviService(Integer reviService) {
		this.reviService = reviService;
	}
	public Integer getReviEquipment() {
		return reviEquipment;
	}
	public void setReviEquipment(Integer reviEquipment) {
		this.reviEquipment = reviEquipment;
	}
	public Integer getReviClean() {
		return reviClean;
	}
	public void setReviClean(Integer reviClean) {
		this.reviClean = reviClean;
	}
	public Integer getReviTraffic() {
		return reviTraffic;
	}
	public void setReviTraffic(Integer reviTraffic) {
		this.reviTraffic = reviTraffic;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Review [reviId=" + reviId + ", reviMessage=" + reviMessage + ", reviTime=" + reviTime + ", reviService="
				+ reviService + ", reviEquipment=" + reviEquipment + ", reviClean=" + reviClean + ", reviTraffic="
				+ reviTraffic + ", customer=" + customer + "]";
	}
	
}
*/