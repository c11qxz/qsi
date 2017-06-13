package cn.appsys.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.appsys.pojo.Dev_user;
import cn.appsys.service.DevService;

@Controller
public class DevController {

	@Autowired
	DevService devservice;
	
	
	@RequestMapping(value="/devlogin.html")
	public String devlogin(){
		
		return "devlogin";
		
	}
	
	@RequestMapping(value="dologin")
	public String devdologin(@RequestParam String devCode,@RequestParam String devPassword,HttpServletRequest request){
		Dev_user user=devservice.devlogin(devCode, devPassword);
		if(user!=null){
			
			request.setAttribute("devUserSession",user);
			return "developer/main";
			
		}else{
		return "devlogin";
		}
	}
	
	
}
