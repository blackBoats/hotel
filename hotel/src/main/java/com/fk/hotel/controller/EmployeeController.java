package com.fk.hotel.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fk.hotel.bean.Account;
import com.fk.hotel.bean.Employee;
import com.fk.hotel.bean.Result;
import com.fk.hotel.service.AccountService;
import com.fk.hotel.service.EmployeeService;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {

	@Autowired
	private AccountService accountService;
	@Autowired
	private EmployeeService employeeService;
	/*
	 * 添加员工信息
	 * @Param Employee
	 */
	@RequestMapping(value="/create",method=RequestMethod.POST)
	private String saveEmployee(@RequestBody Employee employee){
		employee.setSalaryStatus(0);
		employeeService.saveEmployee(employee);
		return "\"success\"";
	}
	
	/*
	 * 查询所有员工信息
	 * @Param Employee
	 * 
	 */
	@RequestMapping(value="/listAll",method=RequestMethod.GET)
	private List<Employee> findAll(){
		List<Employee> list = employeeService.findAllEmployee();
		return list;
	}
	@RequestMapping(value="/findByUsername/{username}",method=RequestMethod.GET)
	private List<Employee> findByUsername(@PathVariable("username") String username){
		List<Employee> list = employeeService.findAllByUsername(username);
		return list;
	}
	/*
	 *修改员工信息
	 * @Param Employee
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	private String updateEmployee(@RequestBody Employee employee){
		employeeService.updateEmployee(employee);
		return "\"success\"";
	}
	/*
	 *删除员工信息s
	 * @Param Id
	 */
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	private String deleteEmployee(@PathVariable("id") Long id){
		employeeService.deleteEmployee(id);
		return "\"success\"";
	}
	@RequestMapping(value="/init",method=RequestMethod.GET)
	private Authentication init(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth;
	}
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	private String logout(HttpServletRequest request,HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null){
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "\"success\"";
	}
	/*
	 *创建账单信息
	 * @Param Id
	 */
	@RequestMapping(value="/account",method=RequestMethod.POST)
	private String addAccount(@RequestBody Employee employee){
		Account account = new Account();
		account.setAccountMoney(employee.getRealSalary());
		account.setAccountMessage("员工工资");
		account.setAccountStatus(0);
		account.setAccountNo(employee.getEmployeeId());
		account.setAccountUsername(employee.getUsername());
		account.setAccountDate(new Date());
		account.setAccountFrom(2);
		accountService.saveAccount(account);
		return "\"success\"";
	}
	/*@RequestMapping(value="/accounts",method=RequestMethod.POST)
	private Result dd(){
		Account account = new Account();
		account.setAccountUsername("sdsdfsdgsd");
		Result rt = new Result();
		rt.setResl("true");
		List<Account> list = new ArrayList<Account>();
		list.add(account);
		account.setAccountMessage("sdgsdgsdgsd");
		list.add(account);
		rt.setAccoount(list);
		rt.setSize(3);
		return rt;
	}*/
}
