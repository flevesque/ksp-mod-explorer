package com.criticalweb.ksp.mod.explorer.generics;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;

/**
 * Created by Francois Levesque <francois@critical-web.com>
 */
public abstract class AbstractDao<T> implements GenericDao<T> {

	@Resource
	SessionFactory sessionFactory;

	public void save(T entity) {
		Session session = sessionFactory.getCurrentSession();
		session.save(entity);
	}

}
