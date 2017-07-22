package com.fk.hotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fk.hotel.bean.Employee;

public interface EmployeeService {

	/*
	 * 查询所有的Employee信息
	 */
	List<Employee> findAllEmployee();

	/*
	 * 添加employee信息
	 * @Param employee
	 */
	void saveEmployee(Employee employee);
	/*
	 * 修改员工信息
	 */
	void updateEmployee(Employee employee);

	/*
	 * 删除员工信息
	 */
	void deleteEmployee(Long id);

	List<Employee> findAllByUsername(String username);

}
