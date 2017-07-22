package com.fk.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fk.hotel.bean.Account;
import com.fk.hotel.dao.AccountDao;
import com.fk.hotel.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountDao accountDao;
	
	@Override
	public void saveAccount(Account account) {
		accountDao.save(account);
	}
	
	@Override
	public List<Account> findAllAccount() {
		return accountDao.findAllAccount();
	}

	@Override
	public void updateAccount(Account account) {
        accountDao.saveAndFlush(account);		
	}

	@Override
	public void deleteAccount(Long id) {
        accountDao.delete(id);		
	}

	@Override
	public List<Account> findAllStatus() {
		// TODO Auto-generated method stub
		return accountDao.findByStatus();
	}

	@Override
	public List<Account> findAllUnStatus() {
		return accountDao.findByUnStatus();
	}

	@Override
	public List<Account> findByLikeAccountUsername(String accountUsername) {
		return accountDao.findByLikeAccountUsername(accountUsername);
	}

}
