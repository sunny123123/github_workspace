package com.sunny.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunny.entity.UserInfo;


public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 245634436873708618L;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.println(request.getParameter("userName"));
		request.setAttribute("TEST", "test");
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		List<Object[]> list = new ArrayList<Object[]>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crm?useunicode=true&characterEncoding=utf-8","root","niit");
			PreparedStatement ps = conn.prepareStatement("select userid,username,pwd from userinfo");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Object[] o = new Object[]{rs.getInt("userid"),rs.getString("username"),rs.getString("pwd")};
				list.add(o);
				//out.println(rs.getInt("userid")+" "+rs.getString("username"));
				//out.println("<br>");
			}
		
			rs.first();
			UserInfo user = new UserInfo(rs.getInt("userid"), rs.getString("username"), rs.getString("pwd"));
			request.setAttribute("USER1", user);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("USERS", list);
		request.getRequestDispatcher("showuser.jsp").forward(request, response);
		
		//response.sendRedirect("showuser.jsp");
		out.flush();
		out.close();
	}
}
