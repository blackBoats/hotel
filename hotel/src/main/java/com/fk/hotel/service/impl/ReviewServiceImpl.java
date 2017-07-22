package com.fk.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fk.hotel.bean.ReviewVo;
import com.fk.hotel.dao.ReviewDao;
import com.fk.hotel.service.ReviewService;

@Service(value="reviewService")
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	private ReviewDao reviewDao;
	
	@Override
	public void saveReview(ReviewVo review) {
		reviewDao.save(review);
		
	}

	@Override
	public ReviewVo findById(Long reviId) {
		return reviewDao.findOne(reviId);
	}

	@Override
	public List<ReviewVo> findAll() {
		return reviewDao.findAll();
	}

	@Override
	public void delete(Long reviewId) {
		// TODO Auto-generated method stub
	    reviewDao.delete(reviewId);
	}

	
}
