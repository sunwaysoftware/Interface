package com.sunway.vo;

import com.sunway.log.LogInfo;

public class BaseVO {
	
	private Integer pageIndex;
    private Integer pageSize; 
    private Integer recordCount;
    private LogInfo loginfo = new LogInfo();
    
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(Integer recordCount) {
		this.recordCount = recordCount;
	}
	public LogInfo getLoginfo() {
		return loginfo;
	}
	public void setLoginfo(LogInfo loginfo) {
		this.loginfo = loginfo;
	}
}
