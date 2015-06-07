package com.sunny.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * Servlet 生命周期
 */
public class GetInitParamServlet extends HttpServlet {
@Resource(name="username")//注解技术
private String username;
//private @Resource(name="username") String name;//可以这样写

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.log("执行	doGet	方法 ");//日志输出
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String str = this.getInitParameter("encoding");//重数据库中获取配置的参数
		this.log(str);//日志输出
		this.log(username);
		out.flush();
		out.close();
	}

	@Override
	public void destroy() {
		this.log("执行 destory 方法");
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		this.log("执行 init 方法");
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.log("执行 service 方法");
		super.service(request, response);
	}

}
