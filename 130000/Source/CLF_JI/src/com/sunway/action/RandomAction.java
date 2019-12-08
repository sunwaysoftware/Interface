/**
 * 
 */
package com.sunway.action;

import java.io.ByteArrayInputStream;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.util.RandomNumUtil;
import com.sunway.util.SessionCtrl;

/**
 * @author Andy.Kou
 * 
 */
public class RandomAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 2108201281088783246L;

	private ByteArrayInputStream inputStream;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	
	public String execute() throws Exception {
		RandomNumUtil rdnu = RandomNumUtil.Instance();
		// 取得带有随机字符串的图片
		inputStream = rdnu.getImage();
		// 取得随机字符串放入HttpSession
		sessionCtrl.Add(SessionCtrl.SESSION_KEY_RANDPIC , rdnu.getString());
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}	
	
	/************************** set and get ******************************/
	
	public void setInputStream(ByteArrayInputStream inputStream) {
		this.inputStream = inputStream;
	}

	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}

}
