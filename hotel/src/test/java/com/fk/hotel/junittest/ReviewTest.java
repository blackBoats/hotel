/*package com.fk.hotel.junittest;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.fk.hotel.bean.Customer;
import com.fk.hotel.bean.Review;
import com.fk.hotel.service.CustomerService;
import com.fk.hotel.service.ReviewService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ReviewTest {
	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private ReviewService reviewService;

	@Test
	public void addReview(){
		Customer customer = customerService.FindById(1l);
		
		Review review = new Review();
		review.setReviClean(89);
		System.out.println(review);
		Set<Review> set = new HashSet<Review>();
		set.add(review);
		customer.setReview(set);
		System.out.println(customer);
		review.setCustomer(customer);
		
		reviewService.saveReview(review);
		
		
		
	}
	
	@Test
	public void testFindById(){
		Review review = reviewService.findById(8l);
//		System.out.println(review);
	}
}
*/