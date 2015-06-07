package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import po.User;

public class HibernateTest1 {
	private static SessionFactory sf;
	private Session sen;
	@BeforeClass
	public static void  beforeClass(){
		sf=new Configuration().configure().buildSessionFactory();
	}
	
	@AfterClass
	public static void  afterClass(){
		sf.close();
	}
	
	@Before
	public void before(){
		sen=sf.openSession();
	}
	@After
	public void after(){
		sen.close();
	}
	
	@Test // junit,测试框架
	public void testSave(){
		User u = new User("john",99,true);
		Transaction tx=sen.beginTransaction();
		sen.save(u);
		tx.commit();
		
		Assert.assertTrue(u.getId()!=null);
	}
	@Test // junit,测试框架
	public void testLoad(){
		User u=(User)sen.get(User.class, 1);
		System.out.println(u.getUname());
		Assert.assertTrue(u.getUname()!=null);
	}
	
	
	
	@Test // junit,测试框架
	public void testUpdate(){
		Transaction tx=sen.beginTransaction();
		User u=(User)sen.get(User.class, 1);
		u.setUname("tom");
		tx.commit();
	}
	
	@Test // junit,测试框架
	public void testDelete(){
		Transaction tx=sen.beginTransaction();
		User u=(User)sen.get(User.class, 2);
		sen.delete(u);
		tx.commit();
	}
	
	public static void main(String[] args) {
		

	}

}
