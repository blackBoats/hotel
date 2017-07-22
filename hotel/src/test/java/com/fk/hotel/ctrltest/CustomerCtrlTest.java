package com.fk.hotel.ctrltest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import com.fk.hotel.App;
import com.fk.hotel.bean.Customer;
import com.fk.hotel.bean.HotelRoom;

@SpringBootTest(classes=App.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerCtrlTest {

    RestTemplate restTemplate = new RestTemplate();
	@Test
	public void testAdd(){
		
		Customer customer = new Customer();
		customer.setPassword("123");
		customer.setPhoneNumber("1234");
		customer.setEmail("dsfsdfsdfsdfsd");
		System.out.println(customer);
		HotelRoom hotelRoom = new HotelRoom();
		hotelRoom.setRoomName("dsfs");
		String res = restTemplate.postForObject("http://localhost:8080/reserving/", hotelRoom,String.class);
		System.out.println(res);
//	   
		
	}
	
	
}
