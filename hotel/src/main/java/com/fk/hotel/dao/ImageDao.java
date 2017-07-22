package com.fk.hotel.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.fk.hotel.bean.ImageVo;

public interface ImageDao extends JpaRepository<ImageVo, Long>{
  
	@Query("from ImageVo where typeRoom=:typeRoom")
	List<ImageVo> typeImage(@Param("typeRoom") String typeRoom);
}
