package com.criticalweb.ksp.mod.explorer.user;

import com.criticalweb.ksp.mod.explorer.entities.User;

import javax.persistence.EntityNotFoundException;

/**
 * @author Francois Levesque <francois@critical-web.com>
 * @since 1.0
 */
public interface UserDao {

	public User getUser(String username, String email, String displayname);

	public User getUser(String username) throws EntityNotFoundException;

	public void createUser(User user);

}
