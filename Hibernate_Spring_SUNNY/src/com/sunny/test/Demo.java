package com.sunny.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sunny.common.HibernateSessionFactory;
import com.sunny.entity.Clazz;
import com.sunny.entity.Student;
import com.sunny.service.impl.DaoImpl;

public class Demo{
public static void main(String[] args) {
	fun1(); 
}
public static void fun2(){
	ApplicationContext apptc = new ClassPathXmlApplicationContext("applicationContext.xml");
	DaoImpl dao = (DaoImpl)apptc.getBean("dao");
	Student stu = (Student)dao.get(Student.class,34);
	System.out.println(stu.getName());
}
/*
 * Hibernate+Spring的方式对数据库进行操作，session的打开关闭全部交给Spring来维护
 */
public static void fun1(){
	ApplicationContext apptc = new ClassPathXmlApplicationContext("applicationContext.xml");
	DaoImpl dao = (DaoImpl)apptc.getBean("dao");
	Clazz c = new Clazz();
	c.setName("三年二班");
	Student s1 = new Student();
	s1.setClazz(c);
	s1.setName("JBoss");
	Student s2 = new Student();
	s2.setName("Tomcat");
	s2.setClazz(c);
	Set< Student> stus = new HashSet<Student>();
	stus.add(s1);
	stus.add(s2);
	c.setStudents(stus);
	int i = (Integer)dao.add(c);
	
	System.out.println(i);
}
}
