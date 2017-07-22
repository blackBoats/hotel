package com.fk.hotel.service;

import java.util.List;

import com.fk.hotel.bean.Customer;
   /*
    * @author fankk
    */
public interface CustomerService {
	
	/*
	  * 保存客户信息到数据库，如果存在，则不允许添加
	  * @param customer
	  */
	public void saveCustomer(Customer customer);
	
	/*
	 * 修改客户的信息
	 * @param customer
	 */
	public void updateCustomer(Customer customer);
	
	/*
	 * 用户登录，返回Customer
	 * @param loginName(phoneNumber,email),password
	 */
	public Customer login(String loginName,String password);
	
	/*
	 * 查询电话号码用户信息
	 * @param phoneNumber
	 */
    public List<Customer> findByPhoneNumber(String phoneNumber);
    
    /*
     * 根据姓名查询用户信息
     * @param username
     */
    public Customer findByUserName(String userName);
    
    /*
     * 根据身份号码查询用户信息
     * @param identityId
     */
    public Customer findByIdentityId(String identityId);
    
    /*
     * 根据Id查询用户信息
     * @param
     */
    public Customer FindById(Long id);
    
    /*
     * 查询所有用户信息
     */
    public List<Customer> findAllCustomer();

	public void deleteCustomer(Long id);
	
	
}
