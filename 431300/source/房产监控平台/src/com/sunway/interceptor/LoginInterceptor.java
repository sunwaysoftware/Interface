/**
 * 
 */
package com.sunway.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.sunway.util.Common;
import com.sunway.util.SessionCtrl;

/**
 * @author Andy.Gao
 *
 */

public class LoginInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = -5670291415294243959L;

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.AbstractInterceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
	 */
	public String intercept(ActionInvocation invocation) throws Exception {
		
		try {
			//取得请求相求的ActionContext实例
			ActionContext ctx = invocation.getInvocationContext();
			SessionCtrl sessionCtrl = new SessionCtrl(ctx.getSession()); 
			String userId = sessionCtrl.getUserId();// 登錄者帳號
		/*	String pssd = sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD);//登錄者[評稅時點]
			String ssgx = sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX);//登錄者[稅收管轄]
		*/
			//if(Common.isNullOrEmpty(userId) || Common.isNullOrEmpty(pssd)){
			if(Common.isNullOrEmpty(userId)){
				// 返回到登錄頁面
				return Action.LOGIN;			
			}
//			if(!Common.isNullOrEmpty(userId) && Common.isNullOrEmpty(ssgx)){
		/*	if(!Common.isNullOrEmpty(userId)){
				System.out.println("Time out:" + ctx.getName());
				// 返回到稅收管轄選
				return "timeout";
			}*/
			
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return invocation.invoke();
	}

}
