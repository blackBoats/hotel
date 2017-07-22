package com.fk.hotel.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fk.hotel.bean.Customer;
import com.fk.hotel.bean.HotelRoom;
import com.fk.hotel.service.CustomerService;
import com.fk.hotel.service.RoomService;

@RestController
public class RoomController {
 
	@Autowired
	private CustomerService customerService;
	@Autowired
	private RoomService roomService;
	private String roomType;
	/*
	 * 生成订单
	 */
	@RequestMapping(value="/reserving/",method=RequestMethod.POST)
	public String reserveRoom(@RequestBody Map<Long,HotelRoom> room){//以map集合的形式接收从前端传递的数据Long为用户的customerId
		//遍历map集合，获得集合的键和值
		for(Map.Entry<Long,HotelRoom> entry:room.entrySet()){
			Long id = entry.getKey();
			Customer customer = customerService.FindById(id);
			System.out.println(id);
			Set<Customer> set = new HashSet<Customer>();
			set.add(customer);
			HotelRoom hotelRoom = entry.getValue();
			System.out.println(hotelRoom);
			roomService.saveRoom(hotelRoom);
		}

		return "reserved";	
	}
	
	/*
	 * 根据roomId查询客房信息
	 * 将hotelroom的customers属性设置为null
	 */
	@RequestMapping(value="/room/{id}",method=RequestMethod.GET)
	public HotelRoom getRoom(@PathVariable("id") Long id){
		HotelRoom hotelRoom = roomService.findById(id);
		return hotelRoom;
	}
	
	/*
	 * 取消订单
	 * 将HotelRoom的属性customers设置为null就删除第三方表记录
	 */
	@RequestMapping(value="/orderDeleting/{id}",method=RequestMethod.POST)
	public String deleteOrder(@PathVariable("id") Long id){
		HotelRoom hotelRoom = roomService.findById(id);
		roomService.updateRoom(hotelRoom);
		return "\"deletedOrder\"";
	}
	
	/*
	 * @Param typeRoom
	 * @Result List<Room>
	 */
	@RequestMapping(value="/findByTypeRoom/room/{typeRoom}",method=RequestMethod.GET)
	public List<HotelRoom> findByTypeRoom(@PathVariable("typeRoom") String typeRoom){
		return roomService.findByTypeRoom(typeRoom);
	}
	
	/*
	 * @Param typeRoom
	 * @Result List<Room>
	 */
	@RequestMapping(value="/findByBedType/room/{bedType}",method=RequestMethod.POST,produces="application/json")
	public List<HotelRoom> findByBedType(@PathVariable("bedType") String bedType,@RequestParam("roomType") String roomTSype){
		System.out.println(bedType+""+roomType);
		return roomService.findByBedType(bedType);
	}
	//查询已预定房间
	@RequestMapping(value="/findByStatus",method=RequestMethod.GET)
	public List<HotelRoom> findByStatus(){
		return roomService.findByStatus();
	}	
	//查询非预定房间
	@RequestMapping(value="/findByUnStatus",method=RequestMethod.GET)
	public List<HotelRoom> findByUnStatus(){
		return roomService.findByUnStatus();
	}
	
	@RequestMapping(value="/createRoom",method=RequestMethod.POST)
	public HotelRoom createRoom(@RequestBody HotelRoom room){
		room.setReserveStatus(0);
		room.setRoomCreate(new Date());
		roomService.saveRoom(room);
		return room;
	}
	
	@RequestMapping(value="/updateRoom",method=RequestMethod.POST)
	public HotelRoom updateRoom(@RequestBody HotelRoom room){
		roomService.updateRoom(room);
		return room;
	}
	@RequestMapping(value="/deleteRoom/{roomId}",method=RequestMethod.DELETE)
	public String updateRoom(@PathVariable("roomId") Long roomId){
		roomService.deleteRoomByRoomName(roomId);
		return "\"success\"";
	}
	
	@RequestMapping(value="/findByLikeRoomName/{roomName}&&{reserveStatus}",method=RequestMethod.GET)
	public List<HotelRoom> findByLikeRoomName(@PathVariable("roomName") String roomName,@PathVariable("reserveStatus") Integer reserveStatus){
		System.out.println(reserveStatus);
		List<HotelRoom> list = roomService.findByLikeRoomName(roomName,reserveStatus);
		return list;
	}
	
	
	
     
}
