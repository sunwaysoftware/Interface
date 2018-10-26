/**
 * 
 */
package com.sunway.vo;

/**
 * 请求响应表
 * @author amani
 *
 */
public class SysCmdResponse implements java.io.Serializable {
	private static final long serialVersionUID = 2817026144566657999L;

	private Integer id;
	private String qqlsh;
	private String content;
	private String biz_code;
	
	//------------------------- constructor -----------------------------
	public SysCmdResponse() {}
	
	//--------------------- setter and getter ----------------------------
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the qqlsh
	 */
	public String getQqlsh() {
		return qqlsh;
	}
	/**
	 * @param qqlsh the qqlsh to set
	 */
	public void setQqlsh(String qqlsh) {
		this.qqlsh = qqlsh;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the biz_code
	 */
	public String getBiz_code() {
		return biz_code;
	}

	/**
	 * @param biz_code the biz_code to set
	 */
	public void setBiz_code(String biz_code) {
		this.biz_code = biz_code;
	}
	
}
