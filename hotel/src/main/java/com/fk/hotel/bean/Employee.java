package com.fk.hotel.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="hotel_employee")
public class Employee {
 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long employeeId;//编号
	@Column(nullable=false)
	private String username;//名字
	@Column(nullable=false)
	private String position;//工作职位
	@Column(nullable=false)
	private String employeeIdentity;//身份证
	@Column(nullable=false)
	private Double employeeSalary;//工资
	private Double realSalary;//实发工资
	private Integer limitStatus;//暂无
	@Column(nullable=false)
	private String phoneNumber;//电话	
	private String bankNumber;//银行卡号
	private String workMonth;//工作的月份
	@Column(nullable=false)
	private Integer salaryStatus;//本月是否已发工资
	@Column(nullable=false)
	private String createDate;//入职时间
	private String reson;//工作描述
	public Long getEmployeeId(){
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Double getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(Double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	public Double getRealSalary() {
		return realSalary;
	}
	public void setRealSalary(Double realSalary) {
		this.realSalary = realSalary;
	}
	public Integer getLimitStatus() {
		return limitStatus;
	}
	public void setLimitStatus(Integer limitStatus) {
		this.limitStatus = limitStatus;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getBankNumber() {
		return bankNumber;
	}
	public void setBankNumber(String bankNumber) {
		this.bankNumber = bankNumber;
	}
	public String getWorkMonth() {
		return workMonth;
	}
	public void setWorkMonth(String workMonth) {
		this.workMonth = workMonth;
	}
	public Integer getSalaryStatus() {
		return salaryStatus;
	}
	public void setSalaryStatus(Integer salaryStatus) {
		this.salaryStatus = salaryStatus;
	}
	public String getReson() {
		return reson;
	}
	public void setReson(String reson) {
		this.reson = reson;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getEmployeeIdentity() {
		return employeeIdentity;
	}
	public void setEmployeeIdentity(String employeeIdentity) {
		this.employeeIdentity = employeeIdentity;
	}
	
	
	
	
}
