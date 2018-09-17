package com.sunway.vo;
import java.util.ArrayList;
import java.util.Date;


/**
 * 单层工业厂房跨数修正系数
 * @author LeiJia
 */



public class Pgv00004 implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4026410865235009268L;
	// Fields
	private String id;
	private String ids;
	private String js ;
	private String xs;
	private Date upddate;
	private String cd00002Czr;
	private String cd00001Ssgx;
	private String note;
	private String czr;	
	private Integer recordCount;
    private Integer recordIndex;    
    private Integer pageIndex;
    private Integer pageSize;
    private String impErrorMsg;
    private Integer exportOutCome;
    private ArrayList<Pgv00004> outList;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getUpddate() {
		return upddate;
	}
	public void setUpddate(Date upddate) {
		this.upddate = upddate;
	}
	public String getCd00002Czr() {
		return cd00002Czr;
	}
	public void setCd00002Czr(String cd00002Czr) {
		this.cd00002Czr = cd00002Czr;
	}
	public String getCd00001Ssgx() {
		return cd00001Ssgx;
	}
	public void setCd00001Ssgx(String cd00001Ssgx) {
		this.cd00001Ssgx = cd00001Ssgx;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getCzr() {
		return czr;
	}
	public void setCzr(String czr) {
		this.czr = czr;
	}
	public Integer getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(Integer recordCount) {
		this.recordCount = recordCount;
	}
	public Integer getRecordIndex() {
		return recordIndex;
	}
	public void setRecordIndex(Integer recordIndex) {
		this.recordIndex = recordIndex;
	}
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getImpErrorMsg() {
		return impErrorMsg;
	}
	public void setImpErrorMsg(String impErrorMsg) {
		this.impErrorMsg = impErrorMsg;
	}
	public ArrayList<Pgv00004> getOutList() {
		return outList;
	}
	public void setOutList(ArrayList<Pgv00004> outList) {
		this.outList = outList;
	}
	public Integer getExportOutCome() {
		return exportOutCome;
	}
	public void setExportOutCome(Integer exportOutCome) {
		this.exportOutCome = exportOutCome;
	}
	public String getJs() {
		return js;
	}
	public void setJs(String js) {
		this.js = js;
	}
	public String getXs() {
		return xs;
	}
	public void setXs(String xs) {
		this.xs = xs;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	
	
}