package cn.appsys.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;


import cn.appsys.pojo.App_category;
import cn.appsys.pojo.App_info;
import cn.appsys.pojo.Data_dictionary;
import cn.appsys.pojo.Dev_user;
import cn.appsys.service.DevService;

@Controller
public class DevController {

	@Autowired
	DevService devservice;
	
	//跳入dev登录界面
	@RequestMapping(value="/devlogin.html")
	public String devlogin(){
		
		return "devlogin";
		
	}
	//进行dev登录
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
	//注销
	@RequestMapping(value="logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "devlogin";
	}
	
	//app维护跳入devlist列表界面
	@RequestMapping(value="appinfolist.html")
	public String appinfolist(HttpSession session){
		//List<App_category> list=devservice.selectDevlist(Integer.parseInt(pid));
		//request.setAttribute("categoryLevel1List", list);
		App_category cate=new App_category();
		cate.setParentId(0);
		List<App_category> list=devservice.selectDevlist(cate);
		List<Data_dictionary> data=devservice.statusList("APP状态");
		List<Data_dictionary> data2=devservice.statusList("所属平台");
		List<App_info> info=devservice.appList();
		session.setAttribute("categoryLevel1List", list);
		session.setAttribute("statusList", data);
		session.setAttribute("flatFormList", data2);
		session.setAttribute("appInfoList", info);
		return "/developer/appinfolist";
	}
	
	@ResponseBody //ajax提交注解
	@RequestMapping(value="/categorylevellist2",produces="application/json;charset=utf-8")
	public String appinfolist2(HttpServletRequest request,@RequestParam String pid){
		App_category cate=new App_category();
		cate.setParentId(Integer.parseInt(pid));
		List<App_category> list=devservice.selectDevlist(cate);
		return JSONArray.toJSONString(list);
	}
	
	@RequestMapping(value="/appinfoadd.html")
	public String appinfoadd(){
		return "/developer/appinfoadd";
	}
	
	@ResponseBody //ajax提交注解
	@RequestMapping(value="/appstatuslist",produces="application/json;charset=utf-8")
	public String appstatuslist(){
		List<Data_dictionary> data2=devservice.statusList("所属平台");
		for (Iterator iterator = data2.iterator(); iterator.hasNext();) {
			Data_dictionary data_dictionary = (Data_dictionary) iterator.next();
			System.out.println(data_dictionary.getId()+data_dictionary.getTypeName());
		}
		return JSONArray.toJSONString(data2);
	}
	
	@ResponseBody //ajax提交注解
	@RequestMapping(value="categorylevellist1",produces="application/json;charset=utf-8")
	public String categorylevellist1(){
		App_category cate=new App_category();
		cate.setParentId(0);
		List<App_category> list=devservice.selectDevlist(cate);
		return JSONArray.toJSONString(list);
	}
	
	
}
