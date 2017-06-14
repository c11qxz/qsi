package cn.appsys.dao.dev;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.App_category;
import cn.appsys.pojo.App_info;
import cn.appsys.pojo.Data_dictionary;
import cn.appsys.pojo.Dev_user;

public interface DevMapper {
	//查询用户所有信息     //登录
	public Dev_user devlogin(@Param("devCode")String devCode,@Param("devPassword")String devPassword);
	//查询列表
	public List<App_category> selectDevlist(App_category cate);
	//查询APP状态
	public List<Data_dictionary> statusList(@Param("typeName")String typeName);
	//查询app列表
	public List<App_info> appList();
}
