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
import com.sunny.entity101.Class100;
import com.sunny.entity101.Student100;
//双边的一对多，多对一实例
public class Demo101 {
public static void main(String[] args) {
	fun1();
}
public static void fun2(){
	Session session = HibernateSessionFactory.getSession();
	session.beginTransaction();
	Class100 c = (Class100)session.get(Class100.class,7);
	session.delete(c);
	session.getTransaction().commit();
	session.close();
}
/**
 * 当 配置文件中cascade="save-update"没有加上时候，改函数会报
 * 因为保存班级的时候，班级是持久化对象，但学生是瞬时对象，关系又是由Class来维护，所以会报错
 * 如果关系是由Student来维护，那就不会报错
 * 所以保存班级时候，要先将学生持久化
 */
/**
 * 当配置文件中没有inverse="true"，那么Hibernate默认是由set方既一方来负责关联工作（这里为Class100负责）
 * 当加上inverse="true"时候，student表中不会主动加上class_id（同样的代码）
 */
public static void fun1(){
	Class100 c = new Class100();
	Student100 stu = new Student100();
	stu.setName("tomcat");
	Student100 stu2 =new Student100();
	stu2.setName("apache");
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
