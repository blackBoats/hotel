package com.fk.hotel.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontViewController {
    /*
     * 前台主页面
     */
	@RequestMapping("index")
	public String index(){
		return "front/index";
	}
	
	/*
	 * 登录
	 */
	@RequestMapping("logining")
	public String login(){
		return "front/loginAndRegist/login";
	}
	/*
	 * 注册
	 */
	@RequestMapping("regist")
	public String regist(){
		return "front/loginAndRegist/regist";
	}
	
	@RequestMapping("loginAndRegist")
	public String background(){
		return "front/loginAndRegist/loginAndRegist";
	}
	@RequestMapping("reserve")
	public String reserve(){
		return "front/reserve/reserve";
	}
	@RequestMapping("review")
	public String review(){
		return "front/review/review";
	}
	@RequestMapping("main")
	public String main(){
		return "front/main";
	}
	@RequestMapping("reserveStep1")
	public String step1(){
		return "front/reserve/reserveStep/reserveStep1";
	}
	
	@RequestMapping("reserveStep2")
	public String step2(){
		return "front/reserve/reserveStep/reserveStep2";
	}
	
	@RequestMapping("template")
	public String template(){
		return "angular/template";
	}
	
	@RequestMapping("uploaddd")
	public String uplodImages(){
		return "views/uploadImg";
	}
	@RequestMapping("updateCustomer")
	public String updateCustomer(){
		return "front/updateCustomer";
	}
	@RequestMapping("detailOrder")
	public String detailCustomer(){
		return "front/detailOrder";
	}
}
