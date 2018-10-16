/**
 * 
 */
package com.sunway.vo;

import java.util.Date;

/**
 * @author amani
 *
 */
public class SysCmdRequest implements java.io.Serializable {

	private static final long serialVersionUID = 4138788042359058854L;
	
	private Integer id;
	private String cmd_code;
	private Date create_time;
	private Integer resolve_state;
	private Date resolve_time;
	private Date send_resolve_time;
	private String data_id;
	private String fail_msg;
	private Integer type;
	
	//---------------------------------- constructor --------------------------------------
	public SysCmdRequest() {}
	
	/**
	 * Read Cmd
	 */
	public SysCmdRequest(Date resolve_time, String data_id) {
		this.resolve_state = 1;
		this.resolve_time = resolve_time;
		this.data_id = data_id;
	}
	/**
	 * Write Cmd
	 */
	public SysCmdRequest(String data_id) {
		this.cmd_code = "300101";
		this.create_time = new Date();
		this.resolve_state = 10;
		this.data_id = data_id;
	}	
	
	//-------------------------- setter and getter ----------------------------------------
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
	 * @return the cmd_code
	 */
	public String getCmd_code() {
		return cmd_code;
	}
	/**
	 * @param cmd_code the cmd_code to set
	 */
	public void setCmd_code(String cmd_code) {
		this.cmd_code = cmd_code;
	}
	/**
	 * @return the create_time
	 */
	public Date getCreate_time() {
		return create_time;
	}
	/**
	 * @param create_time the create_time to set
	 */
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	/**
	 * @return the resolve_state
	 */
	public Integer getResolve_state() {
		return resolve_state;
	}
	/**
	 * @param resolve_state the resolve_state to set
	 */
	public void setResolve_state(Integer resolve_state) {
		this.resolve_state = resolve_state;
	}
	/**
	 * @return the resolve_time
	 */
	public Date getResolve_time() {
		return resolve_time;
	}
	/**
	 * @param resolve_time the resolve_time to set
	 */
	public void setResolve_time(Date resolve_time) {
		this.resolve_time = resolve_time;
	}
	/**
	 * @return the data_id
	 */
	public String getData_id() {
		return data_id;
	}
	/**
	 * @param data_id the data_id to set
	 */
	public void setData_id(String data_id) {
		this.data_id = data_id;
	}
	/**
	 * @return the fail_msg
	 */
	public String getFail_msg() {
		return fail_msg;
	}
	/**
	 * @param fail_msg the fail_msg to set
	 */
	public void setFail_msg(String fail_msg) {
		this.fail_msg = fail_msg;
	}
	/**
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * @return the send_resolve_time
	 */
	public Date getSend_resolve_time() {
		return send_resolve_time;
	}
	/**
	 * @param send_resolve_time the send_resolve_time to set
	 */
	public void setSend_resolve_time(Date send_resolve_time) {
		this.send_resolve_time = send_resolve_time;
	}
}
