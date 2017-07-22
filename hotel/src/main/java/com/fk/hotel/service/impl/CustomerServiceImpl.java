package com.fk.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fk.hotel.bean.Customer;
import com.fk.hotel.dao.CustomerDao;
import com.fk.hotel.service.CustomerService;
     
    /*
     * @author fankk
     */
@Service(value="customerService")
public class CustomerServiceImpl implements CustomerService{

	@Autowired 
	private CustomerDao customerDao;
	@Override
	public void saveCustomer(Customer customer) {
		customerDao.save(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerDao.saveAndFlush(customer);
	}

	@Override
	public Customer login(String loginName, String password) {
		
		return customerDao.login(loginName, password);
	}

	@Override
	public List<Customer> findByPhoneNumber(String phoneNumber) {
		return customerDao.findByPhoneNumber(phoneNumber);
	}

	@Override
	public Customer findByUserName(String userName) {
		return customerDao.findByUserName(userName);
	}

	@Override
	public Customer findByIdentityId(String identityId) {
		return customerDao.findByIdentityId(identityId);
	}

	@Override
	public List<Customer> findAllCustomer() {
		
		return customerDao.findAll();
	}

	@Override
	public Customer FindById(Long id) {
		
		return customerDao.findOne(id);
	}

	@Override
	public void deleteCustomer(Long id) {
          customerDao.delete(id);		
	}
    
}
