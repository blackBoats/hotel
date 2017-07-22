package com.fk.hotel.service;

import java.util.List;

import com.fk.hotel.bean.Quest;

public interface QuestService {

	public void saveQuest(Quest quest);

	public List<Quest> findAllQuestion();

	public List<Quest> findAllAnswer(Integer number);

//	public int findMaxNumber();
}
