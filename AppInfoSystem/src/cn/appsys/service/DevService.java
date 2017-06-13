package cn.appsys.service;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.Dev_user;

public interface DevService {

	public Dev_user devlogin(@Param("devCode")String devCode,@Param("devPassword")String devPassword);
}
