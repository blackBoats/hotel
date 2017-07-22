package com.fk.hotel.service;

import java.util.List;

import com.fk.hotel.bean.HotelRoom;

public interface RoomService {
    
	public void saveRoom(HotelRoom hotelRoom);
	
	public HotelRoom findById(Long id);
	
	public void updateRoom(HotelRoom hotelRoom);

	public List<HotelRoom> findByTypeRoom(String typeRoom);
	
	public List<HotelRoom> findByBedType(String bedType);
    //查询已预订
	public List<HotelRoom> findByStatus();
	//查询未预订
	public List<HotelRoom> findByUnStatus();
	//将状态修改为已预订
	public void updateStatus(String roomName);
	//将状态修改未预订
	public void updateUnStatus(String roomName);

	public void deleteRoomByRoomName(Long roomId);

	/*
	 * 根据roomName查询
	 */
	public List<HotelRoom> findByLikeRoomName(String roomName,Integer reserveStatus);
	
}
