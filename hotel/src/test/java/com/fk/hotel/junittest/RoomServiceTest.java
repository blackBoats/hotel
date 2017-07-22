package com.fk.hotel.junittest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.fk.hotel.bean.HotelRoom;
import com.fk.hotel.service.RoomService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RoomServiceTest {
	
	@Autowired
	private RoomService roomService;

	@Test
	public void testSaveRoom(){
		HotelRoom hotelRoom = new HotelRoom();
		hotelRoom.setReserveStatus(0);
		hotelRoom.setRoomName("双人床");
		hotelRoom.setRoomType("经济房");
		roomService.saveRoom(hotelRoom);
	}
	@Test 
	public void testFindRoom(){
		HotelRoom hotelRoom = roomService.findById(11l);
		System.out.println(hotelRoom.getRoomName());
	}
}
