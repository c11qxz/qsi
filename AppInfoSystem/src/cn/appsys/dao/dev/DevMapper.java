package cn.appsys.dao.dev;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.Dev_user;

public interface DevMapper {

	public Dev_user devlogin(@Param("devCode")String devCode,@Param("devPassword")String devPassword);
}
