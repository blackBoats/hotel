package com.fk.hotel.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fk.hotel.bean.Order;

public interface OrderDao extends JpaRepository<Order, Long>{
    /*
     * 获得所有订单
     */
	@Query("from Order  order by orderId desc")   
	List<Order> findAllOrder();
    /*
     * 获取所有正在进行中的订单
     */
    @Query("from Order where orderStatus= 0 order by orderId desc ")
	List<Order> findByStatus();
    /*
     * 获得已经完成的订单
     * 
     */
    @Query("from Order where orderStatus = 1 order by orderId desc ")
    List<Order> findByUnStatus();
    
    @Query(value="select * from hotel_order a where a.room_name like %:roomName% order by order_id desc",nativeQuery=true)
	List<Order> findByRoomName(@Param("roomName") String roomName);
    @Query("from Order where  phoneNumber=:phoneNumber order by order_id desc")
	List<Order> findOrderByPhone(@Param("phoneNumber") String phoneNumber);
    
}
