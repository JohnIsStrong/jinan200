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

import po.Addr;
import po.User;

public class HibernateTest2 {
	private static SessionFactory sf;
	private Session sen;
	@BeforeClass
	public static void  beforeClass(){
		sf=new Configuration().configure().buildSessionFactory();
	}
	public static void main(String[] args) {
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
		Addr a1=new Addr();
		a1.setAddrName("bj");
		Addr a2=new Addr();
		a2.setAddrName("sh");
		a1.setU(u);
		a2.setU(u);
		u.getAddrs().add(a1);
		u.getAddrs().add(a2);
		
		Transaction tx=sen.beginTransaction();
		sen.save(a1);
		sen.save(a2);
		sen.save(u);
		tx.commit();
		System.out.println(u.getId());
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
		User u=(User)sen.get(User.class, 22);
		u.setUname("tom1");
		//sen.evict(u);
		tx.commit();
	}
	
	@Test // junit,测试框架
	public void testDelete(){
		Transaction tx=sen.beginTransaction();
		User u=(User)sen.get(User.class, 2);
		sen.delete(u);
		tx.commit();
	}


}
