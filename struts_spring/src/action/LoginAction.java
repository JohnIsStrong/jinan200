package action;


import service.UserManager;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	
	private String uname;
	private String psd;
	private UserManager um;
	
	
	
	public void setUm(UserManager um) {
		this.um = um;
	}


	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}


	public String getPsd() {
		return psd;
	}


	public void setPsd(String psd) {
		this.psd = psd;
	}


	public String login(){
		um.login(uname, psd);
		
		return SUCCESS;
	}
}
