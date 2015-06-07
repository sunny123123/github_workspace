package com.sunny.test;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.sunny.common.HibernateUtil;
import com.sunny.entity.Student;

public class Demo {
public static void main(String[] args) {
	fun1();
}

//查询数据
public static void fun4(){
	SessionFactory factory = HibernateUtil.getSessionFactory();
	Session session = factory.openSession();
	Query query = session.createQuery("select s.name from Student s where sno = ?");
	
	query.setInteger(0, 1);
	List<String> stus = query.list();
	for (String name : stus) {
		System.out.println(name);
	}
}
//查询数据
public static void fun3(){
	SessionFactory factory = HibernateUtil.getSessionFactory();
	Session session = factory.openSession();
	Query query = session.createQuery("from Student  where sno = ?");
	query.setInteger(0, 1);
	List<Student> stus = query.list();
	for (Student stu : stus) {
		System.out.println(stu);
	}
}
//向表中插入数据，要开启事务
public static void fun2(){
	SessionFactory factory = HibernateUtil.getSessionFactory();
	Session session = factory.openSession();
	Transaction trans =  session.beginTransaction();
	Student stu = new Student();
	stu.setName("tomcat");
	stu.setAddress("nanjing");
	session.save(stu);
	System.out.println(stu.getSno());
	trans.commit();
	session.close();
	
}
//根据模型，自动生成表，注意，配置文件出错，这里不检查的
public static void fun1(){
	Configuration cfg = new Configuration().configure();
	//SessionFactory sf=new Configuration().configure().buildSessionFactory();
	SchemaExport export = new SchemaExport(cfg);
	export.create(true,true);
}
}
