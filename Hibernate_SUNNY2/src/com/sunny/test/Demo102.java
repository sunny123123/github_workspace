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
//双边的一对多，多对一实例
public class Demo102 {
public static void main(String[] args) {
	fun1();
}
/**
 * inverse="true"注意控制关系的使用
 */
public static void fun1(){
	Class100 c = new Class100();
	Student100 stu = new Student100();
	stu.setName("tomcat");
	stu.setClass100(c);
	Student100 stu2 =new Student100();
	stu2.setName("apache");
	stu2.setClass100(c);
	Set<Student100> students = new HashSet<Student100>();
	students.add(stu);
	students.add(stu2);
	c.setName("三年二班");
	c.setStudents(students);
	Session session = HibernateSessionFactory.getSession();
	session.beginTransaction();
/*	session.persist(stu);   //当没有设置级联保存的时候，要先将学生对象持久化
	session.persist(stu2);*/
	session.save(c);
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
