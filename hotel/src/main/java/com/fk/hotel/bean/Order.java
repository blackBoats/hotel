package com.fk.hotel.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="hotel_order")
public class Order implements Serializable{
   
	/**
	 * 订单bean
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long orderId;//订单号
	@Column(nullable=false)
	private String userName;//用户姓名
	@Column(nullable=false)
	private String roomName;//房间号
	private String identityId;//用户身份证号
	@Column(nullable=false)
	private String inTime;//入住时间
	@Column(nullable=false)
	private String outTime;	//离开时间		
	@Column(nullable=false)
	private String phoneNumber;//用户电话
	private Long userId;
	@Column(nullable=false)
	private Date createTime;//登记时间
	@Column(nullable=false)	
	private Double price;//总付钱
	@Column(nullable=false)
	private Integer orderStatus;//账单是否已提交
	@Column(nullable=false)	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getIdentityId() {
		return identityId;
	}
	public void setIdentityId(String identityId) {
		this.identityId = identityId;
	}
    
	public String getInTime() {
		return inTime;
	}
	public void setInTime(String inTime) {
		this.inTime = inTime;
	}
	public String getOutTime() {
		return outTime;
	}
	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userName=" + userName + ", identityId=" + identityId + ", inTime="
				+ inTime + ", outTime=" + outTime + ", phoneNumber=" + phoneNumber + ", userId=" + userId
				+ ", createTime=" + createTime + "]";
	}
	
	
	
}
