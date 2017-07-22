package com.fk.hotel.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hotel_account")
public class Account {

	//账单编号
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long accountId;//账单编号
	//账单信息
	@Column(nullable=false)
	private String accountMessage;//账单信息
	@Column(nullable=false)
	private String accountUsername;//账单 来自的姓名
	@Column(nullable=false)
	private Double accountMoney;//金额
	//账单状态1 为收入 ，0为支出
	@Column(nullable=false)
	private Integer accountStatus;//账单状态
	//账单生成时间
	@Column(nullable=false)
	private Date accountDate;//账单创建时间
	private Long accountNo;//账单来源
	//账单来自 0： 未知 1：来自Order 2 ：来自Employee
	private Integer accountFrom;
	
	public Long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public String getAccountMessage() {
		return accountMessage;
	}
	public void setAccountMessage(String accountMessage) {
		this.accountMessage = accountMessage;
	}
	public String getAccountUsername() {
		return accountUsername;
	}
	public void setAccountUsername(String accountUsername) {
		this.accountUsername = accountUsername;
	}
	public Double getAccountMoney() {
		return accountMoney;
	}
	public void setAccountMoney(Double accountMoney) {
		this.accountMoney = accountMoney;
	}
	public Integer getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(Integer accountStatus) {
		this.accountStatus = accountStatus;
	}
	public Date getAccountDate() {
		return accountDate;
	}
	public void setAccountDate(Date accountDate) {
		this.accountDate = accountDate;
	}
	public Integer getAccountFrom() {
		return accountFrom;
	}
	public void setAccountFrom(Integer accountFrom) {
		this.accountFrom = accountFrom;
	}
	
	
	
}
