package com.fk.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fk.hotel.bean.Order;
import com.fk.hotel.dao.OrderDao;
import com.fk.hotel.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDao orderDao;
	@Override
	public void createOrder(Order order) {
		
		 orderDao.save(order);
		 
	}
	
	@Override
	public List<Order> findAllOrder() {
		return orderDao.findAllOrder();
	}

	@Override
	public List<Order> findByStatus() {
		return orderDao.findByStatus();
	}

	@Override
	public List<Order> findByUnSttaus() {
		return orderDao.findByUnStatus();
	}

	@Override
	public void saveOrder(Order order) {
		 orderDao.saveAndFlush(order);
	}

	@Override
	public List<Order> findAllByRoomName(String roomName) {
		return orderDao.findByRoomName(roomName);
	}

	@Override
	public List<Order> findOrderByPhone(String phoneNumber) {
		return orderDao.findOrderByPhone(phoneNumber);
	}

	@Override
	public void updateOrder(Order order) {
        orderDao.saveAndFlush(order);		
	}

}
