/**
 * 
 */
package com.sunway.vo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Administrator
 *
 */

public class Tree00000 implements Serializable {

	/* 
	id: node id, which is important to load remote data 
	text: node text to show 
	state: node state, 'open' or 'closed', default is 'open'. When set to 'closed', the node have children nodes and will load them from remote site 
	checked: Indicate whether the node is checked selected. 
	attributes: custom attributes can be added to a node 
	children: an array nodes defines some children nodes 
	*/

	private static final long serialVersionUID = -7342138486993358270L;
	private String id;
	private String text;
	private String state;
	private Boolean checked;
	private String attributes;
	private ArrayList<Tree00000> children;
	
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
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		if(null==state || ""==state)
			state = "closed";
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the checked
	 */
	public Boolean getChecked() {
		return checked;
	}
	/**
	 * @param checked the checked to set
	 */
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	/**
	 * @return the attributes
	 */
	public String getAttributes() {
		return attributes;
	}
	/**
	 * @param attributes the attributes to set
	 */
	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}
	/**
	 * @return the children
	 */
	public ArrayList<Tree00000> getChildren() {
		return children;
	}
	/**
	 * @param children the children to set
	 */
	public void setChildren(ArrayList<Tree00000> children) {
		this.children = children;
	}
}
