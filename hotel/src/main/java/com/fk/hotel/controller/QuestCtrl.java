package com.fk.hotel.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fk.hotel.bean.Quest;
import com.fk.hotel.service.QuestService;

@RestController
public class QuestCtrl {
   @Autowired
   @Qualifier("questService")
	private QuestService questService;
   /*
    * 存入提出的问题以及回答
    */
	@RequestMapping(value="/questing",method=RequestMethod.POST)
	public String sayQuest(@RequestBody Quest quest){
//		int number;
//		List<Quest> list = questService.findAllQuest();
//		System.out.println(list.size());
//		System.out.println(quest.getQuizNumber());
//		
//		/* 判断number是否为null，为null的时候，说明是提出问题。
//		 * 前段传递的数据当是回答问题的时候，number为空
//		 */
//		if(quest.getQuizNumber()==null){
//	    
//	     /* 判断问答记录的表是否为空，为空的时候设置number为1
//		 */
//		    if(list.size()!=0){
//			     number = questService.findMaxNumber()+1;
//			     quest.setQuizNumber(number);
//			     questService.saveQuest(quest);
//		    }else {
//		        number=1;
//		        quest.setQuizNumber(number);
//			    questService.saveQuest(quest);
//		    }
//		}else{
//			questService.saveQuest(quest);
//		}
		quest.setQuizTime(new Date());
		quest.setQuizStatus(1);
		questService.saveQuest(quest);
		return "say";
	}
	
	@RequestMapping(value="/answering",method=RequestMethod.POST)
	public String sayAnswer(@RequestBody Quest quest){
		quest.setQuizTime(new Date());
		quest.setQuizStatus(0);
		questService.saveQuest(quest);
		return "sayAnswered";
	}
	
	/*
	 * 查询hotel_quest所有记录
	 */
	@RequestMapping(value="/question",method=RequestMethod.GET)
	public List<Quest> getQuest(){
		List<Quest> list = questService.findAllQuestion();
		return list;
	}
	@RequestMapping(value="/answering/{number}",method=RequestMethod.GET)
	public List<Quest> getAnswer(@PathVariable("number") Integer number){
		List<Quest> list = questService.findAllAnswer(number);
		return list;
	}
}
