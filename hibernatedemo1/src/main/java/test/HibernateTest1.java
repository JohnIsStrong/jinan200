package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import po.User;

public class HibernateTest1 {

	public static void main(String[] args) {
		User u = new User("john",100,true);
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session sen=sf.openSession();
		Transaction tx=sen.beginTransaction();
		sen.save(u);
		tx.commit();
		sen.close();

	}

}
