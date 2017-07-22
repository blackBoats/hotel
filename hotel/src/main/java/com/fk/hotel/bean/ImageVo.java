package com.fk.hotel.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hotel_image")
public class ImageVo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long imageId;
	@Column(nullable=false)
	private String imageName;
	@Column(nullable=false)
	private String realName;
	private String typeRoom;
	private String typeBed;
	@Column(nullable=false)
	private String level;
	@Column(nullable=false)
	private String imageDescription;
	public Long getImageId() {	
		return imageId;
	}
	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getTypeRoom() {
		return typeRoom;
	}
	public void setTypeRoom(String typeRoom) {
		this.typeRoom = typeRoom;
	}
	public String getTypeBed() {
		return typeBed;
	}
	public void setTypeBed(String typeBed) {
		this.typeBed = typeBed;
	}
	public String getImageDescription() {
		return imageDescription;
	}
	public void setImageDescription(String imageDescription) {
		this.imageDescription = imageDescription;
	}
	
	public String getLevel() {
		return level; 	
	}
	public void setLevel(String level) {
		this.level = level;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imageId == null) ? 0 : imageId.hashCode());
		return result;
	}

	

}
