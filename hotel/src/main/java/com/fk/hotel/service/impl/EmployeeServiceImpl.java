package com.fk.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fk.hotel.bean.Employee;
import com.fk.hotel.dao.EmployeeDao;
import com.fk.hotel.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public List<Employee> findAllEmployee() {
		return employeeDao.findAllEmployee();
	}

	@Override
	public void saveEmployee(Employee employee) {
		employeeDao.save(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeDao.saveAndFlush(employee);
	}

	@Override
	public void deleteEmployee(Long id) {
		employeeDao.delete(id);
	}

	@Override
	public List<Employee> findAllByUsername(String username) {
		return employeeDao.findByUsername(username);
	}

}
