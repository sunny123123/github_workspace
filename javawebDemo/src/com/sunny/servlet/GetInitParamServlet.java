package com.sunny.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * Servlet ��������
 */
public class GetInitParamServlet extends HttpServlet {
@Resource(name="username")//ע�⼼��
private String username;
//private @Resource(name="username") String name;//��������д

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.log("ִ��	doGet	���� ");//��־���
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String str = this.getInitParameter("encoding");//�����ݿ��л�ȡ���õĲ���
		this.log(str);//��־���
		this.log(username);
		out.flush();
		out.close();
	}

	@Override
	public void destroy() {
		this.log("ִ�� destory ����");
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		this.log("ִ�� init ����");
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.log("ִ�� service ����");
		super.service(request, response);
	}

}
