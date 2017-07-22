package com.fk.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fk.hotel.bean.HotelRoom;
import com.fk.hotel.dao.RoomDao;
import com.fk.hotel.service.RoomService;

@Service(value="roomService")
public class RoomServiceImpl implements RoomService{

	@Autowired
	private RoomDao roomDao;
	@Override
	public void saveRoom(HotelRoom hotelRoom) {
		roomDao.save(hotelRoom);
	}

	@Override
	public HotelRoom findById(Long id) {
		return roomDao.findOne(id);
	}

	@Override
	public void updateRoom(HotelRoom hotelRoom) {

	   roomDao.saveAndFlush(hotelRoom);
	}

	@Override
	public List<HotelRoom> findByTypeRoom(String typeRoom) {
		return roomDao.findByTypeRoom(typeRoom);
	}

	@Override
	public List<HotelRoom> findByBedType(String bedType) {
		return roomDao.findByBedType(bedType);
	}

	//查询已经预订的房间
	@Override
	public List<HotelRoom> findByStatus() {
		return roomDao.findByStatus();
	}

	//查询非预定房间
	@Override
	public List<HotelRoom> findByUnStatus() {
		return roomDao.findByUnStatus();
	}

	@Override
	public void updateStatus(String roomName) {
		HotelRoom room = roomDao.findByRoomName(roomName);
		room.setReserveStatus(1);
		roomDao.saveAndFlush(room);
	}
	
	@Override
	public void updateUnStatus(String roomName) {
		HotelRoom room = roomDao.findByRoomName(roomName);
		room.setReserveStatus(0);
		roomDao.saveAndFlush(room);
	}

	@Override
	public void deleteRoomByRoomName(Long roomId) {
	  roomDao.delete(roomId);
	}

	@Override
	public List<HotelRoom> findByLikeRoomName(String roomName,Integer reserveStatus) {
		return roomDao.findByLikeRoomName(roomName,reserveStatus);
	}
	

}
