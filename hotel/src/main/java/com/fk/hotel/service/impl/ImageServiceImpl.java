package com.fk.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fk.hotel.bean.ImageVo;
import com.fk.hotel.dao.ImageDao;
import com.fk.hotel.service.ImageService;

@Service(value="imageService")
public class ImageServiceImpl implements ImageService{
    
	@Autowired
	private ImageDao imageDao;
	
	@Override
	public void saveImage(ImageVo image) {
		imageDao.save(image);
	}

	@Override
	public void deleteImage(Long imageId) {
		
		imageDao.delete(imageId);
	}

	@Override
	public void updateImage(ImageVo image) {
		imageDao.saveAndFlush(image);
	}

	@Override
	public List<ImageVo> findByType(String typeRoom) {
		return imageDao.typeImage(typeRoom);
	}

	@Override
	public List<ImageVo> findAllImage() {
		return imageDao.findAll();
	}

}
