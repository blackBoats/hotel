package com.fk.hotel.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fk.hotel.bean.Account;
import com.fk.hotel.bean.HotelRoom;

public interface AccountDao extends JpaRepository<Account, Long>{

	@Query("from Account where accountStatus= 1 order by accountId desc")
	List<Account> findByStatus();

	@Query("from Account where accountStatus= 0 order by accountId desc")
	List<Account> findByUnStatus();
	
	@Query("from Account order by accountId desc")
	List<Account> findAllAccount();
	@Query(value="select * from hotel_account a where a.account_username like %:accountUsername% ",nativeQuery=true )
	List<Account> findByLikeAccountUsername(@Param("accountUsername") String accountUsername);
}
