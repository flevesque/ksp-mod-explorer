package com.criticalweb.ksp.mod.explorer.user;

import com.criticalweb.ksp.mod.explorer.entities.User;
import com.criticalweb.ksp.mod.explorer.exceptions.InvalidActivationKeyException;
import com.criticalweb.ksp.mod.explorer.generics.GenericDao;

import javax.persistence.EntityNotFoundException;

/**
 * @author Francois Levesque <francois@critical-web.com>
 * @since 1.0
 */
public interface UserDao extends GenericDao<User> {

	public User getUser(String username, String email, String displayname);

	public User getUser(String username) throws EntityNotFoundException;

	public User getUserByActivationKey(String activationKey) throws InvalidActivationKeyException;

}
