package com.fk.hotel.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BackViewController {

	@RequestMapping("back")
	public String back(){
		return "back/back";
	}
	@RequestMapping("order")
	public String order(){
		return "back/order/order";
	}
	@RequestMapping("addOrder")
	public String addOrder(){
		return "back/order/addOrder";
	}
	@RequestMapping("showOrder")
	public String showOrder(){
		return "back/order/showOrder";
	}
	
	@RequestMapping("user")
	public String allUser(){
		return "back/user/user";
	}
	@RequestMapping("updateUser")
	public String updateUser(){
		return "back/user/updateUser";
	}
	@RequestMapping("imageing")
	public String allImage(){
		return "back/image/image";
	}
	@RequestMapping("addImage")
	public String addImage(){
		return "back/image/addImage";
	}
	@RequestMapping("updateImage")
	public String updateImage(){
		return "back/image/updateImage";
	}
	@RequestMapping("room")
	public String allRoom(){
		return "back/room/room";
	}
	
	@RequestMapping("/updateRoom")
	public String detailRoom(){
		return "back/room/updateRoom";
	}
	
	@RequestMapping("/addRoom")
	public String addRoom(){
		return "back/room/addRoom";
	} 
	@RequestMapping("/employee")
	public String employee(){
		return "back/employee/employee";
	} 
	@RequestMapping("/addEmployee")
	public String addEmployee(){
		return "back/employee/addEmployee";
	}
	@RequestMapping("/updateEmployee")
	public String updateEmployee(){
		return "back/employee/updateEmployee";
	}
	
	@RequestMapping("/account")
	public String account(){
		return "back/account/account";
	}
	@RequestMapping("/updateAccount")
	public String updateAccount(){
		return "back/account/updateAccount";
	}
	@RequestMapping("/addAccount")
	public String addAccount(){
		return "back/account/addAccount";
	}
	@RequestMapping("question")
	public String allQuestion(){
		return "back/question/question";
	}
	
/*	@RequestMapping("/remark")
	public String allRemark(){
		return "back/remark/remark";
	}*/
	
	@RequestMapping("/select")
	public String select(){
		return "back/select/select";
	}
	@RequestMapping("/backReview")
	public String review(){
		return "back/review/review";
	}
	@RequestMapping("loginPd")
	public String loginPage(){
		return "back/login";
	}
	@RequestMapping(value = "/loginP", method = RequestMethod.GET)
	public ModelAndView login(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("back/login");

		return model;
	
	}
}
