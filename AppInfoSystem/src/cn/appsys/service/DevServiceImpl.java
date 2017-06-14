package cn.appsys.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.appsys.dao.dev.DevMapper;
import cn.appsys.pojo.App_category;
import cn.appsys.pojo.App_info;
import cn.appsys.pojo.Data_dictionary;
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


	@Override
	public List<App_category> selectDevlist(App_category cate) {
		// TODO Auto-generated method stub
		return devmapper.selectDevlist(cate);
	}


	@Override
	public List<Data_dictionary> statusList(@Param("typeName") String typeName) {
		
		return devmapper.statusList(typeName);
	}


	@Override
	public List<App_info> appList() {
		
		return devmapper.appList();
	}






}
