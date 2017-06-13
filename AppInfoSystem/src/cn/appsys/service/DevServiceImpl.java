package cn.appsys.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.appsys.dao.dev.DevMapper;
import cn.appsys.pojo.Dev_user;

@Service("devService")
public class DevServiceImpl implements DevService{

	@Autowired
	DevMapper devmapper;
	
	@Override
	public Dev_user devlogin(@Param("devCode") String devCode,
			@Param("devPassword") String devPassword) {
		Dev_user user=null;
		user=devmapper.devlogin(devCode, devPassword);
		if(user!=null){
			if(!user.getDevPassword().equals(devPassword)){
				user=null;
			}
		}
		
		return user;
	}



}
