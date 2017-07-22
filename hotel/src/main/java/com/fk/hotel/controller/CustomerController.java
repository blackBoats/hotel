package com.fk.hotel.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fk.hotel.bean.Customer;
import com.fk.hotel.service.CustomerService;
import com.fk.hotel.utils.Utils;

@RestController
@RequestMapping(value="customer")
public class CustomerController {
	
	@Autowired
	@Qualifier("customerService")
	private CustomerService customerService;
	
	/*
	 * 注册用户
	 * @param customer
	 */
	@RequestMapping(value="/registing",method=RequestMethod.POST)
    public Customer regist(@RequestBody Customer customer){
		customer.setCustomerTime(new Date());
		customerService.saveCustomer(customer);
		return customer;
	}
	/*
	 * 更新用户信息
	 * @param customer
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@RequestBody Customer customer){
		customerService.updateCustomer(customer);
		return "\"updated\"";
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id){
		customerService.deleteCustomer(id);
		return "\"delete\"";
	}
	/*
	 * 登录功能
	 */
	@RequestMapping(value="/logining",method=RequestMethod.POST)
	public Customer login(@RequestBody Customer customer,HttpServletRequest req){
		String loginName = customer.getUserName();
		Customer customer1 = new Customer();
		customer1 = customerService.login(loginName, customer.getPassword());
		System.out.println(customer1);
		
     /*
      * 把包含的集合属性设置为null
      */	
        //customer.setReview(null);
		if(customer1!=null){
		HttpSession session = req.getSession();
		session.setAttribute("customer", customer1);
		}
		return customer1;
	}
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpServletRequest req){
		req.getSession().removeAttribute("customer");
		return "\"success\"";
	}
	/*
	 * 获得所有用户的信息
	 * 
	 */
	@RequestMapping(value="/findAll",method=RequestMethod.GET)
	public List<Customer> allCustomer(){
		List<Customer> list = customerService.findAllCustomer();
		return list;
	}
	@RequestMapping(value="/findByPhoneNumber/{phoneNumber}",method=RequestMethod.GET)
	public List<Customer> findByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber){
		List<Customer> list = customerService.findByPhoneNumber(phoneNumber);
		return list;
	}
	@RequestMapping(value="/init",method=RequestMethod.GET)
	public Customer init(HttpServletRequest req){
		Customer customer = (Customer) req.getSession().getAttribute("customer");
		return customer;
	}
	/*
	 * 根据Id查询用户信息
	 */
	@RequestMapping(value="/customer/{id}",method=RequestMethod.GET)
	public Customer findById(@PathVariable("id") Long id){
		Customer customer = customerService.FindById(id);
		
		/*
		 * 将Customer中的属性hotelRoom设置为null
		 */
		
//		customer.setHotelRoom(null);
		return customer;
	}
	@RequestMapping(value="/valid/{checkCode}",method=RequestMethod.GET)
	public String valid(@PathVariable("checkCode") String checkCode,HttpServletRequest request){
		String smsText = (String) request.getSession().getAttribute("smsText");
		System.out.println(smsText);
		System.out.println(checkCode);
		System.out.println(smsText.equals(checkCode));
		if(smsText.equals(checkCode)){
			return "\"success\"";
		}else{
			return "\"error\"";
		}
	}
	@RequestMapping(value="/checkCode/{phoneNumber}",method=RequestMethod.GET)
	public String getCheckCode(@PathVariable("phoneNumber") String phoneNumber,HttpServletRequest request) throws HttpException, IOException{
		 /*HttpClient client = new HttpClient();
		 PostMethod post = new PostMethod("http://gbk.sms.webchinese.cn"); 
		 post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
		 String smsText = String.valueOf(Utils.getRandNum(1, 999999));
		 NameValuePair[] data ={ new NameValuePair("Uid", "往事如风"),
				 new NameValuePair("Key", "5c5a0cec3e4d132240ae"),
				 new NameValuePair("smsMob",phoneNumber),
				 new NameValuePair("smsText",smsText)};
		 post.setRequestBody(data);
		 client.executeMethod(post);*/
		 HttpClient client = new HttpClient();
		 PostMethod post = new PostMethod("http://gbk.sms.webchinese.cn"); 
		 post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
		 String smsText = String.valueOf(Utils.getRandNum(1, 999999));
		 NameValuePair[] data ={ new NameValuePair("Uid", "fankaikai"),
				 new NameValuePair("Key", "667fe95008e5650390ce"),
				 new NameValuePair("smsMob",phoneNumber),
				 new NameValuePair("smsText",smsText)};
		 post.setRequestBody(data);
		 client.executeMethod(post);
		 Header[] headers = post.getResponseHeaders();
		 int statusCode = post.getStatusCode();
		 for(Header h : headers)
		 {
		 }
		 String result = new String(post.getResponseBodyAsString().getBytes("gbk")); 
		 HttpSession session = request.getSession();
		 session.setAttribute("smsText", smsText);
		 post.releaseConnection();
		return "\"success\"";
	}
	
}
