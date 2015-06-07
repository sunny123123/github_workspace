package com.sunny.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import com.sun.org.apache.commons.logging.Log;
import com.sun.org.apache.commons.logging.LogFactory;

import sun.util.logging.resources.logging;

public class RequestListener implements ServletRequestListener,ServletRequestAttributeListener{
Log log = LogFactory.getLog(this.getClass());
	
public void attributeAdded(ServletRequestAttributeEvent sr) {
		log.info("����"+sr.getName()+"������");
		
	}

	public void attributeRemoved(ServletRequestAttributeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void attributeReplaced(ServletRequestAttributeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void requestDestroyed(ServletRequestEvent arg0) {
		log.info("request ����");
		
	}

	public void requestInitialized(ServletRequestEvent arg0) {
	log.info("request ����");
		
	}

}
