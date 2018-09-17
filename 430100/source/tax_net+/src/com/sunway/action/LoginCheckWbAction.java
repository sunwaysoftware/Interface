/**
 * 
 */
package com.sunway.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.apache.commons.lang3.StringEscapeUtils;

import com.chinacreator.openid.client.util.DesTool;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00002Service;
import com.sunway.util.EncryptUtil;
import com.sunway.vo.Pgt00002;

/**
 * 外部单点登录接口
 * 接口一：用户名、密码验证
 * 
 * @author amani
 *
 */
public class LoginCheckWbAction extends ActionSupport {

	private static final long serialVersionUID = -9026205486952015376L;

	private IPgt00002Service t00002Service;
	private String userName;//认证中心传的明文用户名
	private String password;//认证中心传的密文密码
	private String passwordKey;
	private InputStream inputStream;
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		String strResult = "false";
		LOG.info("********外部系统用户验证********");
		try {
			//1. 根据用户名获取用户信息及密码
			userName = StringEscapeUtils.unescapeHtml4(userName);//用户名为中文时
			LOG.info("账户：" + userName);
			LOG.info("原密码："+password);			
			//2. key“pass_key”的赋值需要和认证集成配置员协商
			String passwordEnd = DesTool.decrypt(password, passwordKey);
			LOG.info("解密码："+password);
			//3.根据用户名密码验证身份
			Pgt00002 user = new Pgt00002();
			user.setUserid(userName);
			user.setUserpwd(EncryptUtil.md5(passwordEnd));
			//用户登陆判读
			user = getT00002Service().CheckLogin(user);
			if(null!=user && user.getLoginState()==0)
				strResult = "false";
			else
				strResult = "true";
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		LOG.info("********外部系统用户验证********");
		inputStream = new ByteArrayInputStream(strResult.getBytes("UTF-8"));;
		return SUCCESS;
	}

	//--------------------------- getter and setter ------------------------------------
	
	/**
	 * @return the t00002Service
	 */
	public IPgt00002Service getT00002Service() {
		return t00002Service;
	}

	/**
	 * @param t00002Service the t00002Service to set
	 */
	public void setT00002Service(IPgt00002Service t00002Service) {
		this.t00002Service = t00002Service;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the passwordKey
	 */
	public String getPasswordKey() {
		return passwordKey;
	}

	/**
	 * @param passwordKey the passwordKey to set
	 */
	public void setPasswordKey(String passwordKey) {
		this.passwordKey = passwordKey;
	}

	/**
	 * @return the inputStream
	 */
	public InputStream getInputStream() {
		return inputStream;
	}

	/**
	 * @param inputStream the inputStream to set
	 */
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

}
