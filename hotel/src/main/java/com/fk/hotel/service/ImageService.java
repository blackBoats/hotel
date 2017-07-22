package com.fk.hotel.service;

import java.util.List;
import com.fk.hotel.bean.ImageVo;

public interface ImageService {
    
	/*
	 *存入图片相关信息
	 *@Param image 
	 */
	public void saveImage(ImageVo image);
	
	/*
	 * 删除图片
	 * @param imageName
	 * 
	 */
	public void deleteImage(Long imageId);
	
	/*
	 *修改图片信息
	 *@image 
	 */
	public void updateImage(ImageVo image);
	
	/*
	 * 根据类型查询图片
	 * @typeRoom
	 */
	public List<ImageVo> findByType(String typeRoom);
	
	/*
	 * 查询所有的图片
	 * 
	 */
	public List<ImageVo> findAllImage();
}
