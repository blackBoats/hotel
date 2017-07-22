package com.fk.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fk.hotel.bean.Quest;
import com.fk.hotel.dao.QuestDao;
import com.fk.hotel.service.QuestService;

@Service(value="questService")
public class QuestServiceImpl implements QuestService{
    @Autowired
	private QuestDao questDao;
	@Override
	public void saveQuest(Quest quest) {
       
		 questDao.save(quest);
		
	}
	
	@Override
	public List<Quest> findAllQuestion() {
		return questDao.findAllQuestion();
	}
//    /*
//     * 查询number的最大值
//     * 
//     */
//	@Override
//	public int findMaxNumber() {
//		return questDao.findMaxNumber();
//	}

	/*
	 * 查询所有的每个question下的answer
	 * */
	@Override
	public List<Quest> findAllAnswer(Integer number) {
		
		return questDao.findAllAnswer(number);
	}

	
}
