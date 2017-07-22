package com.fk.hotel.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fk.hotel.bean.ImageVo;
import com.fk.hotel.service.ImageService;

@RestController
@RequestMapping(value="/image")
public class ImageController {
	
	@Autowired
	@Qualifier("imageService")
	private ImageService imageService;
	
	/*
	 * 获得所有的Image信息
	 */
	@RequestMapping(value="/image",method=RequestMethod.GET)
	public List<ImageVo> allImage(){
		List<ImageVo> listImage = imageService.findAllImage();
		return listImage;
	}
	/*
	 * 根据某个Id删除图片
	 */
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id){
		imageService.deleteImage(id);
		return "\"deleted\"";
	}
    /*
     *存储照片
     */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(@RequestParam("load") MultipartFile load,@RequestParam("typeBed") String typeBed
			,@RequestParam("typeRoom") String typeRoom,@RequestParam("imageDescription") String imageDescription,
			@RequestParam("level") String level) 
					throws IllegalStateException, IOException {
		System.out.println(load.getOriginalFilename());
		String fileName = load.getOriginalFilename();
		int index = fileName.lastIndexOf(".");
		StringBuffer buf = new StringBuffer(fileName);
		UUID uuid = UUID.randomUUID();
		buf.replace(0, index, uuid.toString());
		/*System.out.println(typeBed);
		System.out.println(typeRoom);
		System.out.println(imageDescription);
		System.out.println(buf);
		System.out.println(load.getOriginalFilename());*/
		File file = new File("G:/images/",buf.toString());
		ImageVo image = new ImageVo();
		image.setImageDescription(imageDescription);
		image.setTypeBed(typeBed);
		image.setTypeRoom(typeRoom);
		image.setImageName(buf.toString());
		image.setRealName(fileName);
		image.setLevel(level);
		if(!file.exists()){
			file.mkdirs();
		}
		load.transferTo(file);
		imageService.saveImage(image);
		
		return "\"sdfsdf\"";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@RequestBody ImageVo image){
		imageService.updateImage(image);
		return "\"success\"";
	}
	@RequestMapping(value="/listAll",method=RequestMethod.GET)
	public List<ImageVo> listAll(){
		List<ImageVo> list = imageService.findAllImage();
		return list;
	}
}
