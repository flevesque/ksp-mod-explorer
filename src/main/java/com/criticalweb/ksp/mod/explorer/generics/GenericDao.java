package com.criticalweb.ksp.mod.explorer.generics;

/**
 * Created by Francois Levesque <francois@critical-web.com>
 */
public interface GenericDao<T> {

	public void save(T entity);

}
