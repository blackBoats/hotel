package com.fk.hotel.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
  
@Entity
@Table(name="hotel_room")
public class HotelRoom implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long roomId;  // 房间Id
	@Column(nullable=false)
    private String roomName;  //房间号
	@Column(nullable=false)
    private String roomType;  //房间类型
	@Column(nullable=false)
    private String bedType;     //床型
    private String roomDescrible;  //房间描述
    @Column(nullable=false)
    private Date roomCreate;  //登记时间
    @Column(nullable=false)
    private Double roomPrice;  //价格
    @Column(nullable=false)
	private Integer reserveStatus;  // 预订状态
	/*
	 * 关联Customer(hotel_customer),
	 
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="hotel_customer_room",
	joinColumns={ @JoinColumn(name="rid",referencedColumnName="roomId")},
 	inverseJoinColumns = { @JoinColumn(name="cid",referencedColumnName = "customerId")})
	private Set<Customer> customers;  */
	
	public Long getRoomId() {
		return roomId;
	}
	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}
	public String getRoomName() {  
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getRoomDescrible() {
		return roomDescrible;
	}
	public void setRoomDescrible(String roomDescrible) {
		this.roomDescrible = roomDescrible;
	}
	public Date getRoomCreate() {
		return roomCreate;
	}
	
	public String getBedType() {
		return bedType;
	}
	public void setBedType(String bedType) {
		this.bedType = bedType;
	}
	public void setRoomCreate(Date roomCreate) {
		this.roomCreate = roomCreate;
	}
	
	public Integer getReserveStatus() {
		return reserveStatus;
	}
	public void setReserveStatus(Integer reserveStatus) {
		this.reserveStatus = reserveStatus;
	}
	public Double getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(Double roomPrice) {
		this.roomPrice = roomPrice;
	}
	@Override
	public String toString() {
		return "HotelRoom [roomId=" + roomId + ", roomName=" + roomName + ", roomType=" + roomType + ", bedType="
				+ bedType + ", roomDescrible=" + roomDescrible + ", roomCreate=" + roomCreate + ", roomPrice="
				+ roomPrice + ", reserveStatus=" + reserveStatus + "]";
	}
	
	
 
	
	
	
	
	
}
