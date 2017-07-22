package com.fk.hotel.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fk.hotel.bean.Customer;
import com.fk.hotel.bean.Employee;

public interface CustomerDao extends JpaRepository<Customer, Long>{
	
	/*
	 * 用户登录，返回Customer对象
	 * @param loginname,password
	 */
	@Query("from Customer where password=:password and phoneNumber=:loginName or email=:loginName")
	Customer login(@Param("loginName") String loginName,@Param("password") String password);
	
	/*
	 * 根据phoneNumber查询用户信息
	 * @param phoneNumber
	 */
	@Query(value="select * from hotel_customer a where a.phone_number like %:phoneNumber% order by customer_id desc",nativeQuery=true)
	List<Customer> findByPhoneNumber(@Param("phoneNumber") String phoneNumber);
	
	/*
	 * 根据姓名查询用户信息
	 * @param username
	 */
	@Query("from Customer where userName=:userName")
	Customer findByUserName(@Param("userName") String userName);
	
	/*
	 * 根据身份号码查询用户信息
	 * @param identityId
	 */
	@Query("from Customer where identityId=:identityId")
	Customer findByIdentityId(@Param("identityId") String identityId);
	
	
}
