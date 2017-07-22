package com.fk.hotel.service;

import java.util.List;

import com.fk.hotel.bean.Order;

public interface OrderService {

	/*
	 * @Param order
	 * 创建订单
	 */
	void createOrder(Order order);

	List<Order> findAllOrder();

	List<Order> findByStatus();

	List<Order> findByUnSttaus();

	/*
	 * 保存订单
	 * @Param order
	 */
	void saveOrder(Order order);

	List<Order> findAllByRoomName(String roomName);

	List<Order> findOrderByPhone(String phoneNumber);

	void updateOrder(Order order);



	
}
