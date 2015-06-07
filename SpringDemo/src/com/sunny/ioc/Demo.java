package com.sunny.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
	public static void main(String[] args) {
		ApplicationContext appc = new ClassPathXmlApplicationContext("applicationContext.xml");
		ComputerRead cr = (ComputerRead)appc.getBean("iusb");
		cr.test();
		//ComputerRead read = new ComputerRead();
		//read.test();
	}
}
