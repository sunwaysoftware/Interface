package com.sunway.tld;

import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.util.ArrayList;

import org.apache.struts2.components.Component;

import com.opensymphony.xwork2.util.ValueStack;
import com.sunway.util.CheckUtil;
import com.sunway.vo.Pgv00052;

public class Szqy extends Component implements Serializable {

	private static final long serialVersionUID = -7077034635480086811L;
	private static final String STATUS = "selected='selected'";
	private static final String DISABLE = "disabled='disabled'";
	
	private ArrayList<Pgv00052> szqyList;
	private String name;
	private String id;
	private String display;
	private String checked;
	private String disabled;
	private String classid;
	
	public Szqy(ValueStack vs) {
		super(vs);
	}

	@Override
	public boolean start(Writer writer) {
		
		boolean result = super.start(writer);
		try {
			StringBuilder str = new StringBuilder();
			str.append("<select name='"+name+"' id='"+id+"' ");
			if (!CheckUtil.chkEmpty(disabled)) {
				str.append(DISABLE);
			}
			if (!CheckUtil.chkEmpty(classid)) {
				str.append("class='" + classid + "'");
			}
			
			str.append(">");
			str.append("<option value='' ");
			if (CheckUtil.chkEmpty(checked)) {
				str.append(STATUS);
			}
			str.append(" >"+display+"</option>");
			if(null!=szqyList){
				for (int i = 0; i < szqyList.size(); i++) {
					str.append("<option value='"+szqyList.get(i).getCd00001Szqy()+"'");
					if (!CheckUtil.chkEmpty(checked)) {
						if (checked.equals(szqyList.get(i).getCd00001Szqy())) {
							str.append(STATUS);
						}
					}
					str.append(">"+szqyList.get(i).getSzqy()+"</option>");
				}
			}
			str.append("</select>");
			writer.write(str.toString());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return result;
	}

	/********************getter and setter**********************/
	
	/**
	 * @return the szqyList
	 */
	public ArrayList<Pgv00052> getSzqyList() {
		return szqyList;
	}

	/**
	 * @param szqyList the szqyList to set
	 */
	public void setSzqyList(ArrayList<Pgv00052> szqyList) {
		this.szqyList = szqyList;
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
