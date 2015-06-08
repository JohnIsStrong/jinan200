package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import po.User;
import dao.UserDao;

public class SpringTest {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao ud=(UserDao)context.getBean("ud");
		User u = new User();
		u.setUname("john");
		ud.addUser(u);
	}

}
