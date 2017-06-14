package cn.appsys.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.appsys.pojo.App_category;
import cn.appsys.service.DevService;

public class Test {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
		DevService devService  = (DevService) context.getBean("devService");
		
		App_category app_category = new App_category();
		app_category.setParentId(1);
		List<App_category> list = devService.selectDevlist(app_category);
		for (App_category app_category2 : list) {
			System.out.println(app_category2.getCategoryName());
		}
	}

}	
