package action;

import java.util.List;

import po.User;
import service.impl.UserManager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserManagerAction extends ActionSupport {
	private User u;
	
	
	private UserManager um;
	
	
	
	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	}
	public void setUm(UserManager um) {
		this.um = um;
	}
	public String login(){
		User user=um.login(u.getUname(), u.getPsd());
		if(user!=null){
			ActionContext.getContext().getSession().put("user", user);
			return SUCCESS;
		}
		else{
			return INPUT;
		}
	}
	public String regist(){
		um.regist(u);
		return SUCCESS;
	}
	public String listAllUsers(){
		List<User> users=um.listAllUsers();
		ActionContext.getContext().put("users", users);
		return SUCCESS;
	}
}
