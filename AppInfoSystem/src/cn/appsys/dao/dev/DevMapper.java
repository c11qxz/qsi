package cn.appsys.dao.dev;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.App_category;
import cn.appsys.pojo.App_info;
import cn.appsys.pojo.Data_dictionary;
import cn.appsys.pojo.Dev_user;

public interface DevMapper {
	//��ѯ�û�������Ϣ     //��¼
	public Dev_user devlogin(@Param("devCode")String devCode,@Param("devPassword")String devPassword);
	//��ѯ�б�
	public List<App_category> selectDevlist(App_category cate);
	//��ѯAPP״̬
	public List<Data_dictionary> statusList(@Param("typeName")String typeName);
	//��ѯapp�б�
	public List<App_info> appList();
}
