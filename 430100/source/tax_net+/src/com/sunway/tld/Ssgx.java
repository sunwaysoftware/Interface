package com.sunway.tld;

import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.util.ArrayList;

import org.apache.struts2.components.Component;

import com.opensymphony.xwork2.util.ValueStack;
import com.sunway.util.CheckUtil;
import com.sunway.vo.Pgv00009;

public class Ssgx extends Component implements Serializable {
	private static final long serialVersionUID = 1165329249480184951L;
	private static final String STATUS = " selected='selected'";
	private static final String DISABLE = " disabled='disabled'";
	
	private ArrayList<Pgv00009> ssgxList;
	private String name;
	private String id;
	private String checked;
	private String disabled;
	private String classid;
	
	public Ssgx(ValueStack vs) {
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
			if(null!=ssgxList){
				for (int i = 0; i < ssgxList.size(); i++) {
					str.append("<option value='"+ssgxList.get(i).getCd00001Ssgx()+"'");
					if (!CheckUtil.chkEmpty(checked)) {
						if (checked.equals(ssgxList.get(i).getCd00001Ssgx())) {
							str.append(STATUS);
						}
					}
					str.append(">"+ssgxList.get(i).getSsgx()+"</option>");
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
	 * @return the ssgxList
	 */
	public ArrayList<Pgv00009> getSsgxList() {
		return ssgxList;
	}

	/**
	 * @param ssgxList the ssgxList to set
	 */
	public void setSsgxList(ArrayList<Pgv00009> ssgxList) {
		this.ssgxList = ssgxList;
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
	 * @param checked the checked to set
	 */
	public void setChecked(String checked) {
		this.checked = checked;
	}

	/**
	 * @return the checked
	 */
	public String getChecked() {
		return checked;
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
