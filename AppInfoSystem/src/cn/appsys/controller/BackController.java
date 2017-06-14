package cn.appsys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.appsys.service.BackService;


@Controller
public class BackController {

	
	
	@RequestMapping(value="/backendlogin.html")
	public String backendlogin(){
		
		
		return "backendlogin";
	}
}
