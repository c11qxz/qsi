package cn.appsys.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.App_category;
import cn.appsys.pojo.App_info;
import cn.appsys.pojo.Data_dictionary;
import cn.appsys.pojo.Dev_user;

public interface DevService {

	public Dev_user devlogin(@Param("devCode")String devCode,@Param("devPassword")String devPassword);

	public List<App_category> selectDevlist(App_category cate);
	
	public List<Data_dictionary> statusList(@Param("typeName")String typeName);
	
	public List<App_info> appList();
}
