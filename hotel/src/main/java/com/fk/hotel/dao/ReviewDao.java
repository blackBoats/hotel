package com.fk.hotel.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fk.hotel.bean.ReviewVo;

public interface ReviewDao extends JpaRepository<ReviewVo,Long>{

}
