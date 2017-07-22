package com.fk.hotel.junittest;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fk.hotel.bean.Quest;
import com.fk.hotel.service.QuestService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class QuestServiceTest {

	@Autowired
	private QuestService questService;
	public void testAddQuest(){
		Quest quest = new Quest();
		Quest quest1 = new Quest();
		quest1.setQuizMessage("傻逼");
		List<Quest> list = new ArrayList<Quest>();
//		quest.setList(list);
		questService.saveQuest(quest);
		
	}
}
