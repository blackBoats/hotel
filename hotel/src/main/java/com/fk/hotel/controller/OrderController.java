package com.fk.hotel.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fk.hotel.bean.Account;
import com.fk.hotel.bean.Order;
import com.fk.hotel.service.AccountService;
import com.fk.hotel.service.OrderService;
import com.fk.hotel.service.RoomService;

@RestController
@RequestMapping(value="/order")
public class OrderController {

	@Autowired
	private AccountService accountService;
	@Autowired
	private RoomService roomService;
	@Autowired
	private OrderService orderService;
	/*
	 * 保存订单
	 * @Param order
	 */
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public Order createOrder(@RequestBody Order order){
		System.out.println(order);
		order.setCreateTime(new Date());
		order.setOrderStatus(0);
		orderService.createOrder(order);
		//将客房设置为已预订	
		roomService.updateStatus(order.getRoomName());
		return order;
	}
	
	/*
	 * 获得正在进行中的订单
	 * 
	 */
	@RequestMapping(value="/status",method=RequestMethod.GET)
	public List<Order> findByOrderStatus(){
		return orderService.findByStatus();
	}
	/*
	 * 获得已结束订单
	 * return List<Order>
	 */
	@RequestMapping(value="/unStatus",method=RequestMethod.GET)
	public List<Order> findByOrderUnStatus(){
		return orderService.findByUnSttaus();
	}
	/*
	 * 获得所有订单
	 * return List<Order>
	 */
	@RequestMapping(value="all",method=RequestMethod.GET)
	public List<Order> findAllOrder(){
		return orderService.findAllOrder();
	}
	/*
	 * 根据roomName查询相关Order
	 * @Param roomName
	 */
	@RequestMapping(value="/findByRoomName/{roomName}",method=RequestMethod.GET)
	public List<Order> findByRoomName(@PathVariable("roomName") String roomName){
		return orderService.findAllByRoomName(roomName);
	}
	@RequestMapping(value="/findOrderByPhone/{phoneNumber}",method=RequestMethod.GET)
	public List<Order> findOrderByPhone(@PathVariable("phoneNumber") String phoneNumber){
		return orderService.findOrderByPhone(phoneNumber);
	}
	/*
	 * 保存订单
	 * 
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveOrder(@RequestBody Order order){
		order.setOrderStatus(1);
		//设置账单信息并保存
		Account account = new Account();
		account.setAccountMoney(order.getPrice());
		account.setAccountMessage("酒店入住");
		account.setAccountStatus(1);
		account.setAccountNo(order.getOrderId());
		account.setAccountUsername(order.getUserName());
		account.setAccountDate(new Date());
	    account.setAccountFrom(1);
		accountService.saveAccount(account);
		//设置客房的预订状态
		roomService.updateUnStatus(order.getRoomName());
		orderService.saveOrder(order);
		return "success";
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@RequestBody Order order){
		orderService.updateOrder(order);
		return "\"success\"";
	}
	
}
