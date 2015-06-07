package com.sunny.ioc;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
/** 
 * @author sunny
 * 两种加载xml文件的方式，在xml文件中配置了usbDriver和hddDriver
 * 同时配置了iusb,iusb中的usb属性引用usbDriver或hddDriver，所以我们想让电脑接u盘还是硬盘
 * 只要改变配置文件即可，源代码不用改变
 * 问题？ usb不能自动充值，本例中用了getter()才获得属性
 */
public class ComputerRead {
	private  IUsb usb;
	private  Resource rs = null;
	private  XmlBeanFactory factory = null;
	public void test(){
		usb.USBDriver();
	}
	public void read(){
		//rs = new ClassPathResource("applicationContext.xml");
	    //factory = new XmlBeanFactory(rs);//加载xml
	    ApplicationContext factory = new FileSystemXmlApplicationContext("/src/applicationContext.xml");
	    //usb = (IUsb)factory.getBean("usbDriver");
	    ComputerRead cr = (ComputerRead)factory.getBean("iusb");//
	    cr.getUsb().USBDriver();
	}
	public void read1(){
	    ApplicationContext factory = new FileSystemXmlApplicationContext("/src/applicationContext.xml");
	    ComputerRead cr = (ComputerRead)factory.getBean("iusb");//
	    cr.getUsb().USBDriver();
	}

	public IUsb getUsb() {
		return usb;
	}
	public void setUsb(IUsb usb) {
		this.usb = usb;
	}
}
