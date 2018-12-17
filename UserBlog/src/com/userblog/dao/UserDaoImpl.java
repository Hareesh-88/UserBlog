package com.userblog.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.userblog.dto.UserDto;
import com.userblog.entity.UserBlog;
import com.userblog.entity.UserDetails;

@Repository("userDao")
public class UserDaoImpl implements UserDao{
	
	@Autowired
	SessionFactory sessionFactory;
	private Session session;
	
	
	@Override
	public UserDetails getUserDetails(UserDto userDto) {
		boolean flag = false;
		UserDetails user = null;
		try {
			session = sessionFactory.getCurrentSession();
			List<UserDetails> usersQueryList = (List<UserDetails>) session
					.createSQLQuery(
							"SELECT  * FROM UBUSR WHERE  EMAIL = '"
									+ userDto.getEmail() + "' AND PASSWORD = '"
									+ userDto.getPassword() + "'").addEntity(UserDetails.class)
					.list();
			System.out.println("usersQueryList.size().."+ usersQueryList.size());
			if (usersQueryList.size() != 0) {
				user = usersQueryList.get(0);
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	
	@Override
	public boolean saveUserDetails(UserDetails user) {
		boolean flag = false;
		try {
			session = sessionFactory.getCurrentSession();
			session.save(user);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public boolean saveUserBlog(UserBlog userBlog) {
		boolean flag = false;
		try {
			session = sessionFactory.getCurrentSession();
			session.save(userBlog);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}


	public List<UserBlog> getUserBlogById(String userId){
		boolean flag = false;
		List<UserBlog> usersQueryList = new ArrayList<UserBlog>();
			try {
				session = sessionFactory.getCurrentSession();
				 usersQueryList = (List<UserBlog>) session
						.createSQLQuery(
								"SELECT  * FROM UBUSRBLOG WHERE  CREATED_BY = '"
										+ userId + "'").addEntity(UserBlog.class)
						.list();
				System.out.println("usersQueryList.size().."+ usersQueryList.size());

			} catch (HibernateException e) {
				e.printStackTrace();
			}
     	
		return usersQueryList;
	}	
	
	
	
	
	
	
}
