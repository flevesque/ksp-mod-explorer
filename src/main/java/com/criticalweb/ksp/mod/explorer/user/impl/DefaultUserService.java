package com.criticalweb.ksp.mod.explorer.user.impl;

import com.criticalweb.ksp.mod.explorer.entities.User;
import com.criticalweb.ksp.mod.explorer.exceptions.ExpandedEntityExistsException;
import com.criticalweb.ksp.mod.explorer.security.HashResponse;
import com.criticalweb.ksp.mod.explorer.security.SecurityService;
import com.criticalweb.ksp.mod.explorer.user.UserDao;
import com.criticalweb.ksp.mod.explorer.user.UserService;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Francois Levesque <francois@critical-web.com>
 * @since 1.0
 */
@Component
public class DefaultUserService implements UserService {

	@Resource
	SessionFactory sessionFactory;

	@Resource
	UserDao userDao;

	@Resource
	SecurityService securityService;

	private static final Logger LOG = LoggerFactory.getLogger(DefaultUserService.class);

	@Override
	@Transactional
	public User getUserById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return (User) session.get(User.class, id);
	}

	@Override
	@Transactional
	public User getUserByEmail(String email) throws EntityNotFoundException {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(User.class);
		List<User> results = criteria.add(Restrictions.eq("email", email)).list();
		if (results.size() == 0) {
			throw new EntityNotFoundException(String.format("User with e-mail %s not found.", email));
		}
		return results.get(0);
	}

	@Override
	public User getUserByDisplayName(String displayname) {
		return null;
	}

	@Override
	@Transactional
	public User getUserByLogin(String username, String password) throws EntityNotFoundException {

		User user = userDao.getUser(username);

		if (!user.getPassword().equals(securityService.hash(password, user.getSalt()))) {
			throw new EntityNotFoundException("Invalid password!");
		}

		return user;
	}

	@Override
	@Transactional
	public User createNewUser(String username, String password, String email, String displayname) throws ExpandedEntityExistsException {

		try {
			User user = userDao.getUser(username, email, password);

			ExpandedEntityExistsException e = new ExpandedEntityExistsException();

			if (username.equals(user.getUsername()))
				e.addField("username");

			if (email.equals(user.getEmail()))
				e.addField("email");

			if (displayname.equals(user.getDisplayname()))
				e.addField("displayname");

			throw e;

		} catch (EntityNotFoundException e) {
			// expected
		}

		HashResponse hashResponse = securityService.hash(password);

		User user = new User();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(hashResponse.getHashed());
		user.setSalt(hashResponse.getSalt());
		user.setDisplayname(displayname);

		userDao.createUser(user);

		return user;
	}
}
