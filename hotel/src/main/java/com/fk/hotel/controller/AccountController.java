package com.fk.hotel.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fk.hotel.bean.Account;
import com.fk.hotel.service.AccountService;

@RestController
@RequestMapping(value="account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	/*
	 * 创建账单
	 * @Param Account
	 */
	@RequestMapping(value="/create",method=RequestMethod.POST)
	private String createAccount(@RequestBody Account account){
		account.setAccountDate(new Date());
		accountService.saveAccount(account);
		return "\"success\"";
	}
	
	/*
	 * 查询账单
	 * @Param Account
	 */
	@RequestMapping(value="/listAll",method=RequestMethod.GET)
	private List<Account> listAccount(){
		List<Account> list = accountService.findAllAccount();
		return list;
	}
	@RequestMapping(value="/findByStatus",method=RequestMethod.GET)
	private List<Account> findAllStatus(){
		List<Account> list = accountService.findAllStatus();
		return list;
	}
	@RequestMapping(value="/findByUnStatus",method=RequestMethod.GET)
	private List<Account> findAllUnStatus(){
		List<Account> list = accountService.findAllUnStatus();
		return list;
	}
	@RequestMapping(value="/likeAccountUsername/{accountUsername}",method=RequestMethod.GET)
	private List<Account> findByLikeAccountUsername(@PathVariable("accountUsername") String accountUsername){
		List<Account> list = accountService.findByLikeAccountUsername(accountUsername);
		return list;
	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	private String delete(@PathVariable("id") Long id){
		accountService.deleteAccount(id);
		return "\"success\"";
	}
	/*
	 * 修改账单
	 * @Param Account
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	private String updateAccount(@RequestBody Account account){
		accountService.updateAccount(account);
		return "\"success\"";
	}
	
}
