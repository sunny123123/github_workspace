package com.sunny.ioc;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
/** 
 * @author sunny
 * ���ּ���xml�ļ��ķ�ʽ����xml�ļ���������usbDriver��hddDriver
 * ͬʱ������iusb,iusb�е�usb��������usbDriver��hddDriver�������������õ��Խ�u�̻���Ӳ��
 * ֻҪ�ı������ļ����ɣ�Դ���벻�øı�
 * ���⣿ usb�����Զ���ֵ������������getter()�Ż������
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
	    //factory = new XmlBeanFactory(rs);//����xml
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
