package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import po.User;

public class HibernateTest3 {
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
	public void testBase(){
		String hql="from User";
		Query query=sen.createQuery(hql);
		List<User> us=query.list();
		
		for(User u:us){
			System.out.println(u.getUname()+","+u.getAge()+"....."+u.getId());
		}
	}
	
	@Test // junit,测试框架
	public void testWithCondition(){
		String hql="from User as u where u.id>:age and uname=:uname";
//		Query query=sen.createQuery(hql);
//		query.setInteger("age", 37);
//		query.setString("uname", "johnson");
//		List<User> us=query.list();
		
		List<User> us=sen.createQuery(hql).setInteger("age", 37).setString("uname", "johnson").list();
		
		
		
		for(User u:us){
			System.out.println(u.getUname()+","+u.getAge()+"....."+u.getId());
		}
	}

	
	@Test // junit,测试框架
	public void testWithOrdde(){
		String hql="from User as u where u.id>:age and uname=:uname";
//		Query query=sen.createQuery(hql);
//		query.setInteger("age", 37);
//		query.setString("uname", "johnson");
//		List<User> us=query.list();
		
		List<User> us=sen.createQuery(hql).setInteger("age", 37).setString("uname", "johnson").list();
		
		
		
		for(User u:us){
			System.out.println(u.getUname()+","+u.getAge()+"....."+u.getId());
		}
	}
	
	@Test // junit,测试框架
	public void testByOrder(){
		String hql="from User Order by uname asc,id desc";
		Query query=sen.createQuery(hql);
		List<User> us=query.list();
		
		for(User u:us){
			System.out.println(u.getUname()+","+u.getAge()+"....."+u.getId());
		}
	}
	
	
	@Test // junit,测试框架
	public void testByPaging(){
		int offset=0;
		int max=4;
		String hql="from User Order by uname asc,id desc";
		
		List<User> us=sen
				.createQuery(hql)
				.setFirstResult(offset)
				.setMaxResults(max)
				.list();
		
		for(User u:us){
			System.out.println(u.getUname()+","+u.getAge()+"....."+u.getId());
		}
	}

}
