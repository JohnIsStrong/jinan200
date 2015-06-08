package dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import po.User;
import dao.UserDao;

public class UserDaoImpl implements UserDao{
	private SessionFactory sf;
	
	
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void addUser(User u) {
		Session sen=sf.openSession();
		Transaction tx=sen.beginTransaction();
		sen.save(u);
		tx.commit();
		sen.close();
	}

	@Override
	public User findUser(String uname, String psd) {
		String hql="from User where uname=:uname and psd=:psd";
		Session sen=sf.openSession();
		List<User> us= sen.createQuery(hql).setString("uname", uname).setString("psd", psd).list();
		sen.close();
		if(us.isEmpty()){
			return null;
		}
		else{
			return us.get(0);
		}
		
	}

	@Override
	public List<User> findAllUser() {
		String hql="from User";
		Session sen=sf.openSession();
		List<User> us= sen.createQuery(hql).list();
		sen.close();
		return us;
	}
	
}
