package com.fk.hotel.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fk.hotel.bean.Quest;

public interface QuestDao extends JpaRepository<Quest, Long>{
	
	/*
	 * sql查询
	 */
//    @Query(value="select max(quiz_number) from hotel_question",nativeQuery=true)
//	int findMaxNumber();
	@Query("from Quest where quizStatus = 1")
	List<Quest> findAllQuestion();

	
	@Query("from Quest where quizNumber=:number")
	List<Quest> findAllAnswer(@Param("number") Integer number);
	
   
	  
}
