package test.dao.impl;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import po.User;
import dao.UserDao;

public class UserDaoImplTest {
	private static ApplicationContext context;
	private static  UserDao ud;
	@BeforeClass
	public static void beforeClass(){
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
		ud=(UserDao)context.getBean("ud");
	}
	
	@Test
	public void testAddUser(){
		User u = new User();
		u.setAge(10);
		u.setUname("john");
		u.setPsd("123");
		ud.addUser(u);
	}
	@Test
	public void testFindUser(){
		
		User u=ud.findUser("john", "123");
		Assert.assertTrue(u!=null);
	}
}
