package com.fk.hotel.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fk.hotel.bean.ReviewVo;
import com.fk.hotel.service.ReviewService;

@RestController
@RequestMapping(value="/review")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(@RequestBody ReviewVo review){
		review.setReviewStatus(0);
		review.setCreateDate(new Date());
		reviewService.saveReview(review);
		return "\"save\"";
	}
	
	@RequestMapping(value="/findAll",method=RequestMethod.GET)
	public List<ReviewVo> findAll(){
		List<ReviewVo> list = reviewService.findAll();
		return list;
	}
	@RequestMapping(value="/delete/{reviewId}",method=RequestMethod.DELETE)
	public String delete(@PathVariable("reviewId") Long reviewId){
		reviewService.delete(reviewId);
		return "\"success\"";
	}
	
	
}
