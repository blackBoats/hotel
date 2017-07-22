package com.fk.hotel.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fk.hotel.bean.HotelRoom;

public interface RoomDao extends JpaRepository<HotelRoom, Long>{

	/*
	 * @Param typeRoom
	 */
	@Query("from HotelRoom where roomType=:typeRoom and reserveStatus = 0")
	List<HotelRoom> findByTypeRoom(@Param("typeRoom") String typeRoom);
	/*
	 * @Param bedType
	 */
	@Query("from HotelRoom where bedType=:bedType and reserveStatus = 0")
	List<HotelRoom> findByBedType(@Param("bedType") String bedType);
    //查询所有已预订的房间
	@Query("from HotelRoom where reserveStatus = 1")
	List<HotelRoom> findByStatus();
	//查询所有未预订的房间
	@Query("from HotelRoom where reserveStatus = 0")
	List<HotelRoom> findByUnStatus();
    /*//@Param roonName房间号 将房间状态设置为已预订
	@Query("update HotelRoom set reserveStatus = 1 where roomName=:roomName")
	void updateStatus(@Param("roomName") String roomName);
	//@Param roonName房间号 将房间状态设置为未预订
	@Query("update HotelRoom set reserveStatus = 0 where roomName=:roomName")
	void updateUnStatus(@Param("roomName") String roomName);*/
	@Query(value="select * from hotel_room a where a.reserve_status=:reserveStatus and a.room_name like %:roomName% ",nativeQuery=true )
	List<HotelRoom> findByLikeRoomName(@Param("roomName") String roomName,@Param("reserveStatus") Integer reserveStatus);
	@Query("from HotelRoom where roomName=:roomName")
	HotelRoom findByRoomName(@Param("roomName") String roomName);
}
