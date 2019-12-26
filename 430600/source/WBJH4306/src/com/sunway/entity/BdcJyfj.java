/**
 * 
 */
package com.sunway.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * 不动产 交易附件
 * @author andy.gao
 *
 */
@Entity
@Table(name = "BDC_JYFJ")
public class BdcJyfj implements Serializable {
	private static final long serialVersionUID = -8749096367206415551L;
	@Id
    @GenericGenerator(name = "appID", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "appID")
    private String id;
	private String caseno;
	private String materialid;
	private String materialname;
	private String fileno;
	private String filename;
	private String filesize;
	private String filepath;
	private String filecontent;
	private String remark;
	private String userid;
	private String uptype;
	private String ftpkeyname;
	private String slbh;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date upfiletime;

    //----------------------- Constructor -------------------------
	public BdcJyfj() {}
	public BdcJyfj(String id) {
		super();
		this.id = id;
	}

	//----------------------- setter and getter -------------------
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
	 * @return the slbh
	 */
	public String getSlbh() {
		return slbh;
	}

	/**
	 * @param slbh the slbh to set
	 */
	public void setSlbh(String slbh) {
		this.slbh = slbh;
	}

	public String getCaseno() {
		return caseno;
	}

	public void setCaseno(String caseno) {
		this.caseno = caseno;
	}

	public String getMaterialid() {
		return materialid;
	}

	public void setMaterialid(String materialid) {
		this.materialid = materialid;
	}

	public String getMaterialname() {
		return materialname;
	}

	public void setMaterialname(String materialname) {
		this.materialname = materialname;
	}

	public String getFileno() {
		return fileno;
	}

	public void setFileno(String fileno) {
		this.fileno = fileno;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFilesize() {
		return filesize;
	}

	public void setFilesize(String filesize) {
		this.filesize = filesize;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public String getFilecontent() {
		return filecontent;
	}

	public void setFilecontent(String filecontent) {
		this.filecontent = filecontent;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUptype() {
		return uptype;
	}

	public void setUptype(String uptype) {
		this.uptype = uptype;
	}

	public String getFtpkeyname() {
		return ftpkeyname;
	}

	public void setFtpkeyname(String ftpkeyname) {
		this.ftpkeyname = ftpkeyname;
	}

	public Date getUpfiletime() {
		return upfiletime;
	}

	public void setUpfiletime(Date upfiletime) {
		this.upfiletime = upfiletime;
	}
}
