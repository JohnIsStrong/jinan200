package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import po.User;

public class UserDao {
	private SessionFactory sf;
	
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	public void addUser(User u){
		Session sen=sf.openSession();
		Transaction tx=sen.beginTransaction();
		sen.save(u);
		tx.commit();
		sen.close();
	}
}
