package com.sunny.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
/*
 * 在请求Servlet之前 做某些事情
 */
public class FirstFilter implements Filter{

	public void doFilter(ServletRequest request, ServletResponse reponse,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("request 别处理之前");
		HttpServletRequest req = (HttpServletRequest)request;
		System.out.println(req.getProtocol());
		System.out.println(req.getHeader("referer"));
		System.out.println(req.getServerName());
		chain.doFilter(request, reponse);
		System.out.println("request 被处理之后");
		
	}

	public void destroy() {
		System.out.println("执行 destoty 方法");		
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("执行 init 方法");		
	}

}
