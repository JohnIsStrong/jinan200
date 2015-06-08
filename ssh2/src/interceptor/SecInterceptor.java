package interceptor;

import po.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class SecInterceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		User u=(User)ActionContext.getContext().getSession().get("user");
		if(u!=null){
			return invocation.invoke();
		}
		else{
			return ActionSupport.INPUT;
		}
		
		
	}

}
