package com.fk.hotel.service;

import java.util.List;

import com.fk.hotel.bean.ReviewVo;

public interface ReviewService {

     //保存Review信息
	 public void saveReview(ReviewVo review);
	 
	 /*
	  * 耕具Id查询Review信息s
	  */
	 public ReviewVo findById(Long reviId);

	public List<ReviewVo> findAll();

	public void delete(Long reviewId);
}
