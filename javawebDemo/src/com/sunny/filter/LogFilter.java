package com.sunny.filter;

import java.awt.SystemColor;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.sun.org.apache.commons.logging.Log;
import com.sun.org.apache.commons.logging.LogFactory;
//日志管理
public class LogFilter implements Filter{
private Log log = LogFactory.getLog(this.getClass());
private String filterName;
	public void destroy() {
		log.info("关闭 Filter: "+filterName);
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		long startTime = System.currentTimeMillis();
		String requestUrl = req.getRequestURI();
		requestUrl = req.getQueryString() == null?requestUrl:(requestUrl+"?"+req.getQueryString());
		chain.doFilter(request, response);
		long endTime = System.currentTimeMillis();
		log.info(request.getRemoteAddr()+"访问了"+requestUrl+",总用时："+(endTime-startTime)+"毫秒.");
		
		
	}

	public void init(FilterConfig config) throws ServletException {
		filterName = config.getFilterName();
		log.info("启动 Filter"+ filterName);
	}

}
