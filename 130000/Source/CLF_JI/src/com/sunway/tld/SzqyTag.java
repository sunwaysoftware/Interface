package com.sunway.tld;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ComponentTagSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.vo.Pgv00052;


public class SzqyTag extends ComponentTagSupport{

	private static final long serialVersionUID = -2665744948834745873L;
	private String items;
	private String name;
	private String id;
	private String display;
	private String checked;
	private String disabled;
	private String classid;

	/* (non-Javadoc)
	 * @see org.apache.struts2.views.jsp.ComponentTagSupport#getBean(com.opensymphony.xwork2.util.ValueStack, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public Component getBean(ValueStack arg0, HttpServletRequest arg1,
			HttpServletResponse arg2) {
		return new Szqy(arg0);
	}

	/* (non-Javadoc)
	 * @see org.apache.struts2.views.jsp.ComponentTagSupport#populateParams()
	 */
	//获得参数
	@Override
	protected void populateParams() {
		super.populateParams();
		Szqy szqy = (Szqy) component;
		szqy.setSzqyList((ArrayList<Pgv00052>) component.getStack().findValue(items));
		szqy.setName(name);
		szqy.setId(id);
		if (Common.isNullOrEmpty(display))
			szqy.setDisplay("请选择...");
		else
			szqy.setDisplay(display);
		if (Common.isNullOrEmpty(checked))
			szqy.setChecked("");
		else{
			//当checked属性不为空时，判断ValueStack是否返回数值
			String checkedStr = (String) component.getStack().findValue(checked);
			if (!Common.isNullOrEmpty(checkedStr))
				szqy.setChecked(checkedStr);
		}
		//if (Constant.MOD_DELETE.equals((String)component.getStack().findValue(disabled)) || Constant.MOD_UPDATE.equals((String)component.getStack().findValue(disabled)))
		if (!Constant.MOD_CREATE.equals((String)component.getStack().findValue(disabled)))
			szqy.setDisabled(disabled);
		if (!Common.isNullOrEmpty(classid))
			szqy.setClassid(classid);
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
	 * @return the display
	 */
	public String getDisplay() {
		return display;
	}

	/**
	 * @param display the display to set
	 */
	public void setDisplay(String display) {
		this.display = display;
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

