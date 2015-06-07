package com.sunny.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.sunny.common.HibernateSessionFactory;
import com.sunny.entity102.Class100;
import com.sunny.entity102.Student100;
import com.sunny.entity200.Course200;
import com.sunny.entity200.Student200;
//双边的一对多，多对一实例
public class Demo200 {
public static void main(String[] args) {
	fun1();
}

public static void fun1(){
	Student200 stu = new Student200();
	stu.setName("tomcat");
	Course200 c1 = new Course200();
	c1.setName("C++");
	Course200 c2 = new Course200();
	c2.setName("Java");
	Set<Course200> cous = new HashSet<Course200>();
	cous.add(c1);
	cous.add(c2);
	stu.setCourses(cous);
	Session session = HibernateSessionFactory.getSession();
	session.beginTransaction();
	session.save(c1);
	session.save(c2);
	session.save(stu);
	session.getTransaction().commit();
	session.close();
}
public static void initCreateTable(){
	Configuration cfg = new Configuration().configure();
	//SessionFactory sf=new Configuration().configure().buildSessionFactory();
	SchemaExport export = new SchemaExport(cfg);
	export.create(true,true);
}
}
