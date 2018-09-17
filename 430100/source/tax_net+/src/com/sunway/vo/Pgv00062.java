package com.sunway.vo;

import java.math.BigDecimal;
import java.sql.Timestamp;
/**
 * 导入日志视图
 * @author Light
 *
 */
public class Pgv00062 {

	private String id;						//索引
	private String tableName;				//表名
	private String drfjmc;					//导入文件名称
	private String drfjlj;					//导入文件路径
	private BigDecimal drfjdx;				//导入文件大小
	private Integer drcghs;					//导入成功行数
	private Integer drsbhs;					//导入失败行数
	private Timestamp upddate;				//更新时间
	private String cd00002Czr;				//操作人代码
	private String note;					//备注
	private String drsblj;					//导入失败路径
	private String czr;						//操作人
	private String cd00001Ssgx;
	
	public Pgv00062(){
	}
	
	public Pgv00062(String tableName){
		this.tableName = tableName;
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
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}
	/**
	 * @param tableName the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	/**
	 * @return the drfjmc
	 */
	public String getDrfjmc() {
		return drfjmc;
	}
	/**
	 * @param drfjmc the drfjmc to set
	 */
	public void setDrfjmc(String drfjmc) {
		this.drfjmc = drfjmc;
	}
	/**
	 * @return the drfjlj
	 */
	public String getDrfjlj() {
		return drfjlj;
	}
	/**
	 * @param drfjlj the drfjlj to set
	 */
	public void setDrfjlj(String drfjlj) {
		this.drfjlj = drfjlj;
	}
	/**
	 * @return the drfjdx
	 */
	public BigDecimal getDrfjdx() {
		return drfjdx;
	}
	/**
	 * @param drfjdx the drfjdx to set
	 */
	public void setDrfjdx(BigDecimal drfjdx) {
		this.drfjdx = drfjdx;
	}
	/**
	 * @return the drcghs
	 */
	public Integer getDrcghs() {
		return drcghs;
	}
	/**
	 * @param drcghs the drcghs to set
	 */
	public void setDrcghs(Integer drcghs) {
		this.drcghs = drcghs;
	}
	/**
	 * @return the drsbhs
	 */
	public Integer getDrsbhs() {
		return drsbhs;
	}
	/**
	 * @param drsbhs the drsbhs to set
	 */
	public void setDrsbhs(Integer drsbhs) {
		this.drsbhs = drsbhs;
	}
	/**
	 * @return the upddate
	 */
	public Timestamp getUpddate() {
		return upddate;
	}
	/**
	 * @param upddate the upddate to set
	 */
	public void setUpddate(Timestamp upddate) {
		this.upddate = upddate;
	}
	/**
	 * @return the cd00002Czr
	 */
	public String getCd00002Czr() {
		return cd00002Czr;
	}
	/**
	 * @param cd00002Czr the cd00002Czr to set
	 */
	public void setCd00002Czr(String cd00002Czr) {
		this.cd00002Czr = cd00002Czr;
	}
	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}
	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}
	/**
	 * @return the drsblj
	 */
	public String getDrsblj() {
		return drsblj;
	}
	/**
	 * @param drsblj the drsblj to set
	 */
	public void setDrsblj(String drsblj) {
		this.drsblj = drsblj;
	}
	/**
	 * @return the czr
	 */
	public String getCzr() {
		return czr;
	}
	/**
	 * @param czr the czr to set
	 */
	public void setCzr(String czr) {
		this.czr = czr;
	}

	/**
	 * @return the cd00001Ssgx
	 */
	public String getCd00001Ssgx() {
		return cd00001Ssgx;
	}

	/**
	 * @param cd00001Ssgx the cd00001Ssgx to set
	 */
	public void setCd00001Ssgx(String cd00001Ssgx) {
		this.cd00001Ssgx = cd00001Ssgx;
	}
	
}
