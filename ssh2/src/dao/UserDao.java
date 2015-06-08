package dao;

import java.util.List;

import po.User;

public interface UserDao {
	public void addUser(User u);
	public User findUser(String uname,String psd);
	public List<User> findAllUser();
	
}
