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
import com.sunny.entity100.Class100;
import com.sunny.entity100.Student100;
//双边的一对多，多对一实例
public class Demo100 {
public static void main(String[] args) {
	initCreateTable();
}
//想利用班级给班级的学生填充数据，但没有成功
public static void fun5(){
	Session session = HibernateSessionFactory.getSession();
	session.beginTransaction();
	Class100 c = new Class100();
	c.setName("三年三班");
	Set<Student100 > students = new HashSet<Student100>();
	Student100 stu = new Student100();
	stu.setName("Jack");
	c.setStudents(students);
	session.save(stu);
	session.save(c);
	session.getTransaction().commit();
}
//fetch的使用
public static void fun4(){
	Session session = HibernateSessionFactory.getSession();
	session.beginTransaction();
	//Query query = session.createQuery("from Class100 c left join fetch c.students");
	Query query = session.createQuery("from Student100 s");
	List<Student100> ss = query.list();
	for(Student100 s : ss){
		System.out.println(s);
	}
}
public static void fun3(){
	Session session = HibernateSessionFactory.getSession();
	session.beginTransaction();
	//Query query = session.createQuery("from Class100 c left join fetch c.students");
	
	Query query = session.createQuery("from Class100 c");
	List<Class100> cs = query.list();
	for(Class100 c : cs){
		System.out.println(c.getStudents());
	}
}
public static void fun2(){
	Session session = HibernateSessionFactory.getSession();
	session.beginTransaction();
	Query query = session.createQuery("from Student100");
	List<Student100> list = query.list();
	for(Student100 stu:list){
		System.out.println(stu.getClass100());
	}
}
//插入数据
public static void fun1(){
	Session session = HibernateSessionFactory.getSession();
	session.beginTransaction();
	Student100 student = new Student100();
	//Class100 c = new Class100();
	Class100 c = (Class100)session.get(Class100.class, 1);
	c.setName("三年二班");
	student.setName("apache");
	student.setClass100(c);
	session.save(student); 
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
