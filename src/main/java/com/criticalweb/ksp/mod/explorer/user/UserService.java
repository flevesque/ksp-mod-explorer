package com.criticalweb.ksp.mod.explorer.user;

import com.criticalweb.ksp.mod.explorer.entities.User;
import com.criticalweb.ksp.mod.explorer.exceptions.ExpandedEntityExistsException;

import javax.persistence.EntityNotFoundException;

/**
 * @author Francois Levesque <francois@critical-web.com>
 * @since 1.0
 */
public interface UserService {

	public User getUserById(Long id);

	public User getUserByEmail(String email);

	public User getUserByDisplayName(String displayname);

	public User getUserByLogin(String username, String password) throws EntityNotFoundException;

	public User createNewUser(String username, String password, String email, String displayname) throws ExpandedEntityExistsException;

}