package com.fk.hotel.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fk.hotel.bean.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Long>{

	@Query("from Employee order by employeeId desc")
   	List<Employee> findAllEmployee();
	@Query(value="select * from hotel_employee a where a.username like %:username% order by employee_id desc",nativeQuery=true)
	List<Employee> findByUsername(@Param("username") String username);

}
