package com.sunway.tld;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ComponentTagSupport;

import com.opensymphony.xwork2.util.ValueStack;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.vo.PgvCzPssd;


public class PssdTag extends ComponentTagSupport{   

	private static final long serialVersionUID = -8982884351418093633L;
	private String items;   
	private String name;
	private String id;
	private String checked;
	private String disabled;
	private String classid;

	/* (non-Javadoc)
	 * @see org.apache.struts2.views.jsp.ComponentTagSupport#getBean(com.opensymphony.xwork2.util.ValueStack, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public Component getBean(ValueStack arg0, HttpServletRequest arg1,
			HttpServletResponse arg2) {
		return new Pssd(arg0); 
	}
     
	/* (non-Javadoc)
	 * @see org.apache.struts2.views.jsp.ComponentTagSupport#populateParams()
	 */
	//获得参数      
	@Override
	protected void populateParams() {
		super.populateParams();
		Pssd pssd = (Pssd) component;
		pssd.setPssdList((ArrayList<PgvCzPssd>) component.getStack().findValue(items));
		pssd.setName(name);
		pssd.setId(id);
		if (Common.isNullOrEmpty(checked))
			pssd.setChecked("");
		else{
			//当checked属性不为空时，判断ValueStack是否返回数值
			String checkedStr = (String) component.getStack().findValue(checked);
			if (!Common.isNullOrEmpty(checkedStr))
				pssd.setChecked(checkedStr);
		}
		if (Constant.MOD_DELETE.equals((String)component.getStack().findValue(disabled)) || Constant.MOD_UPDATE.equals((String)component.getStack().findValue(disabled)))
			pssd.setDisabled(disabled);
		if (!Common.isNullOrEmpty(classid))
			pssd.setClassid(classid);
	}

    
    /****************getter and setter**************************/
    
	/**
	 * @return the items
	 */
	public String getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(String items) {
		this.items = items;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the checked
	 */
	public String getChecked() {
		return checked;
	}

	/**
	 * @param checked the checked to set
	 */
	public void setChecked(String checked) {
		this.checked = checked;
	}

	/**
	 * @return the disabled
	 */
	public String getDisabled() {
		return disabled;
	}

	/**
	 * @param disabled the disabled to set
	 */
	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	/**
	 * @return the classid
	 */
	public String getClassid() {
		return classid;
	}

	/**
	 * @param classid the classid to set
	 */
	public void setClassid(String classid) {
		this.classid = classid;
	}

}  

