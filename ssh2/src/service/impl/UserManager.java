package service.impl;

import java.util.List;

import po.User;

public interface UserManager {
	public void regist(User u);
	public User login(String uname,String psd);
	public List<User> listAllUsers();
}
