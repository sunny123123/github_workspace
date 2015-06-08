package com.sunny.service.impl;

import java.io.Serializable;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
/**
 *不序列化也是可以的
 */
public class DaoImpl extends HibernateDaoSupport{
	public Serializable add(Object o){
		Serializable ret = this.getHibernateTemplate().save(o);
		return ret;
	}
	public Object get(Class clazz, Serializable id) {
		Object ret = this.getHibernateTemplate().get(clazz, id);
		return ret;
	}
	public void del(Class clazz, Serializable id) {
		this.getHibernateTemplate().delete(get(clazz,id));
	}
}
