package com.fk.hotel.service;

import java.util.List;

import com.fk.hotel.bean.Account;

public interface AccountService {

	/*
	 * 创建账单
	 */
	void saveAccount(Account account);

	/*
	 * 查询所有订单
	 */
	List<Account> findAllAccount();

	/*
	 * 修改订单
	 */
	void updateAccount(Account account);

	void deleteAccount(Long id);

	List<Account> findAllStatus();

	List<Account> findAllUnStatus();

	List<Account> findByLikeAccountUsername(String accountUsername);

}
