package com.fk.hotel.junittest;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.fk.hotel.bean.Customer;
import com.fk.hotel.bean.HotelRoom;
import com.fk.hotel.service.CustomerService;
import com.fk.hotel.service.RoomService;
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerServiceTest {
	
	@Autowired
	@Qualifier("customerService")
	private CustomerService customerService;
	@Autowired
	private RoomService roomService;
	
	@Test
	public void testSaveCustomer(){
		//存入一个对象
		Customer customer = new Customer();
		customer.setPhoneNumber("23232323");
		customer.setEmail("1111111");
		customer.setPassword("lisi");
		customer.setIdentityId("huawei");
		customerService.saveCustomer(customer);
//		HotelRoom hotelRoom = new HotelRoom();
//		hotelRoom.setRoomName("双人间");
//		Set<Customer> set = new HashSet<Customer>();
//		set.add(customer);
//		hotelRoom.setCustomers(set);	
//		roomService.saveRoom(hotelRoom);
		
	}
	
	@Test 
	public void findById(){
		//查询出来的内容为空
		Customer customer = customerService.FindById(1l);
		System.out.println(customer.getCoupon());
		System.out.println(customer);
	}
	
	@Test
	public void login(){
		Customer customer = customerService.login("11111111", "lisi");
		System.out.println(customer);
	}
}
