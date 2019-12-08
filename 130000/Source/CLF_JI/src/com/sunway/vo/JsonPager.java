/**
 * 
 */
package com.sunway.vo;

import java.io.Serializable;

/** 
 * @function 将传递过来的参数封装成Bean，分页查询符合条件的记录 
 */ 
public class JsonPager implements Serializable {
	private static final long serialVersionUID = 2121275256066269322L;

	private Integer pageSize;
	private Integer pageIndex;
	private Integer rowCount; 
	private Object tabList;
	
	/**
	 * @param pageSize 每页显示的记录数 
	 * @param pageIndex 当前的页码
	 * @param rowCount 总记录数
	 * @param pageList 结果集
	 */
	public JsonPager(Integer pageSize, Integer pageIndex, Integer rowCount, Object tabList) {
		super();
		this.pageSize = pageSize;
		this.pageIndex = pageIndex;
		this.rowCount = rowCount;
		this.tabList = tabList;
	}
	
	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}
	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * @return the pageIndex
	 */
	public Integer getPageIndex() {
		return pageIndex;
	}
	/**
	 * @param pageIndex the pageIndex to set
	 */
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	/**
	 * @return the rowCount
	 */
	public Integer getRowCount() {
		return rowCount;
	}
	/**
	 * @param rowCount the rowCount to set
	 */
	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}

	/**
	 * @return the tabList
	 */
	public Object getTabList() {
		return tabList;
	}

	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(Object tabList) {
		this.tabList = tabList;
	}

	
}
