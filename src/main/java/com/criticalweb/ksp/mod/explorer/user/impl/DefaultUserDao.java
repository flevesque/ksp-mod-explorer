package com.criticalweb.ksp.mod.explorer.user.impl;

import com.criticalweb.ksp.mod.explorer.entities.User;
import com.criticalweb.ksp.mod.explorer.exceptions.InvalidActivationKeyException;
import com.criticalweb.ksp.mod.explorer.generics.AbstractDao;
import com.criticalweb.ksp.mod.explorer.user.UserDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * @author Francois Levesque <francois@critical-web.com>
 * @since 1.0
 */
@Repository
public class DefaultUserDao extends AbstractDao<User> implements UserDao {

	private static final Logger LOG = LoggerFactory.getLogger(AbstractDao.class);

	@Resource
	SessionFactory sessionFactory;

	@Override
	public User getUser(String username, String email, String displayname) throws EntityNotFoundException {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(User.class);

		criteria.add(Restrictions.or(Restrictions.eq("username", username), Restrictions.eq("email", email), Restrictions.eq("displayname", displayname)));

		List<User> users = criteria.list();

		if (users.size() == 0) {
			throw new EntityNotFoundException("User could not be found.");
		}

		return users.get(0);
	}

	@Override
	public User getUser(String username) throws EntityNotFoundException {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(User.class);

		criteria.add(Restrictions.eq("username", username));

		List<User> users = criteria.list();

		if (users.size() == 0) {
			throw new EntityNotFoundException("User could not be found.");
		}

		return users.get(0);
	}

	@Override
	public User getUserByActivationKey(String activationKey) throws InvalidActivationKeyException {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(User.class);

		criteria.add(Restrictions.eq("activationkey", activationKey));

		List<User> users = criteria.list();

		if (users.size() == 0) {
			throw new InvalidActivationKeyException("Invalid Activation Key!");
		}

		return users.get(0);
	}

}
