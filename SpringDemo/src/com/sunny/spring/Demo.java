package com.sunny.spring;

import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
/*
 * IOC 
 */
public class Demo {
	private static Resource rs = null;
	private static XmlBeanFactory factory = null;
	private List listServlce;
	
	public static void main(String[] args) {
		rs = new ClassPathResource("applicationContext.xml");
	    factory = new XmlBeanFactory(rs);//加载xml
	    test2();
	}
	//获取applicationContent.xml中配置的list
	public static void test2(){
		Demo list = (Demo)factory.getBean("list");
		List list1 = list.getListServlce();
		for(int i=0;i<list1.size();i++)
			System.out.println(list1.get(i));
	}
	
	public static void test1(){	
		Sleep sleep = (Sleep)factory.getBean("sleep");//获得Bean
		sleep.sleep("sleep");
		
	}
	public List getListServlce() {
		return listServlce;
	}
	public void setListServlce(List listServlce) {
		this.listServlce = listServlce;
	}
}
