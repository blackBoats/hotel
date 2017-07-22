package com.fk.hotel.bean;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="hotel_customer")
public class Customer implements Serializable{

	private static final long serialVersionUID = 1L;
	
	 
	 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long customerId; //用户ID
    private String nickName; //用户昵称
    private String userName; //用户姓名
    @Column(nullable=false)  
    private String phoneNumber;  //用户电话
    @Column(nullable=false)
    private String email;  //用户邮箱
    @Column(nullable=false)
    private String password;  //用户密码
    private String sex;  //用户性别
    private String identityId; //证件号码
    private Integer credits;  //积分
    private String levelVip;  //会员等级
    private String coupon;   //优惠券
    @Column(nullable=false)
    private Date customerTime; //用户注册时间
    
  /*  @ManyToMany(mappedBy="customers")
    private Set<HotelRoom> hotelRoom;*/
   /* @OneToMany(mappedBy="customer")
    private Set<Review> review;*/
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getIdentityId() {
		return identityId;
	}
	public void setIdentityId(String identityId) {
		this.identityId = identityId;
	}
	public Integer getCredits() {
		return credits;
	}
	public void setCredits(Integer credits) {
		this.credits = credits;
	}
	public String getLevelVip() {
		return levelVip;
	}
	public void setLevelVip(String levelVip) {
		this.levelVip = levelVip;
	}
	public String getCoupon() {
		return coupon;
	}
	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}
	public Date getCustomerTime() {
		return customerTime;
	}
	public void setCustomerTime(Date customerTime) {
		this.customerTime = customerTime;
	}
//	@Override
//	public String toString() {
//		return "Customer [customerId=" + customerId + ", nickName=" + nickName + ", userName=" + userName
//				+ ", phoneNumber=" + phoneNumber + ", email=" + email + ", password=" + password + ", sex=" + sex
//				+ ", identityId=" + identityId + ", credits=" + credits + ", levelVip=" + levelVip + ", coupon="
//				+ coupon + ", customerTime=" + customerTime + "]";
//	}
	
	
	/*public Set<Review> getReview() {
		return review;
	}
	public void setReview(Set<Review> review) {
		this.review = review;
	}*/
	
	
    
}
