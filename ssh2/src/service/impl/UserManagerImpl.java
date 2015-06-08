package service.impl;

import java.util.List;

import dao.UserDao;
import po.User;

public class UserManagerImpl implements UserManager {
	private UserDao ud;
	
	
	public void setUd(UserDao ud) {
		this.ud = ud;
	}

	@Override
	public void regist(User u) {
		ud.addUser(u);
	}

	@Override
	public User login(String uname, String psd) {
		// TODO Auto-generated method stub
		return ud.findUser(uname, psd);
	}

	@Override
	public List<User> listAllUsers() {
		// TODO Auto-generated method stub
		return ud.findAllUser();
	}

}
