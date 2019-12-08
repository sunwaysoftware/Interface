package com.sunway.tld;

import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.util.ArrayList;

import org.apache.struts2.components.Component;

import com.opensymphony.xwork2.util.ValueStack;
import com.sunway.util.Common;
import com.sunway.vo.PgvCzPssd;

public class Pssd extends Component implements Serializable {
	private static final long serialVersionUID = -9096421810776557485L;
	private static final String STATUS = "selected='selected'";
	private static final String DISABLE = "disabled='disabled'";
	
	private ArrayList<PgvCzPssd> pssdList;
	private String name;
	private String id;
	private String checked;
	private String disabled;
	private String classid;
	
	public Pssd(ValueStack vs) {
		super(vs);
	}

	@Override
	public boolean start(Writer writer) {
		
		boolean result = super.start(writer);
		try {
			StringBuilder str = new StringBuilder();
			str.append("<select name='"+name+"' id='"+id+"' ");
			if (!Common.isNullOrEmpty(disabled)) {
				str.append(DISABLE);
			}
			if (!Common.isNullOrEmpty(classid)) {
				str.append("class='" + classid + "'");
			}
			str.append(">");
			if(null!=pssdList){
				for (int i = 0; i < pssdList.size(); i++) {
					str.append("<option value='" + pssdList.get(i).getCd00002Pssd()
							+ "'");
					if (!Common.isNullOrEmpty(checked)) {
						if (checked.equals(pssdList.get(i).getCd00002Pssd())) {
							str.append(STATUS);
						}
					}
					str.append(">" + pssdList.get(i).getCd00002Pssd() + "</option>");
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
	 * @return the pssdList
	 */
	public ArrayList<PgvCzPssd> getPssdList() {
		return pssdList;
	}

	/**
	 * @param pssdList the pssdList to set
	 */
	public void setPssdList(ArrayList<PgvCzPssd> pssdList) {
		this.pssdList = pssdList;
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
