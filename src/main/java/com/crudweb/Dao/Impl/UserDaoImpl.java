package com.crudweb.Dao.Impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.crudweb.Dao.UserDao;
import com.crudweb.model.User;

public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;

	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<User> list() {
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) sessionFactory.getCurrentSession()
				.createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listUser;
	}
	@Override
	public void add(User user) {
		sessionFactory.getCurrentSession().save(user);
		
	}

	@Override
	public void delete(int userId) {
		sessionFactory.getCurrentSession().delete(userId);
		
	}

	@Override
	public void edit(User user) {
		sessionFactory.getCurrentSession().update(user);
		
	}

	@Override
	public User findUser(int userId) {
		
		return (User)sessionFactory.getCurrentSession().get(User.class, userId);
	}

	

}
