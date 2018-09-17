package com.sunway.vo;

import java.sql.Timestamp;

/**
 * PgtSysConfig entity. 
 * @author Lee
 */

@SuppressWarnings("serial")
public class Pgt00012 implements java.io.Serializable {

	// Fields

	private Long id;
	private Boolean islogadd;
	private Boolean islogupd;
	private Boolean islogdel;
	private Boolean islogpg;
	private Boolean islogsh;
	private Boolean isloggpg;
	private Boolean islogss;
	private Boolean islogdy;
	private Boolean islogimp;
	private Boolean islogexp;
	private Boolean islogbackup;
	private Boolean islogbzfcs;
	private Boolean islognsrd;
	private Timestamp upddate;
	private String cd00002Czr;
	private String note;
	private String cd00001Ssgxlx;
	private String cd00001Ssgx;
	private String ssgx;
    private String qdhgs;
    private String bzjcnf;
	
	

	private Integer logadd;
	private Integer logupd;
	private Integer logdel;
	private Integer logpg;
	private Integer logsh;
	private Integer loggpg;
	

	private Integer logss;
	private Integer logdy;
	private Integer logimp;
	private Integer logexp;
	private Integer logbackup;
	private Integer logbzfcs;
	private Integer lognsrd;
	
	
	
	// Constructors

	/** default constructor */
	public Pgt00012() {
	}

	/** minimal constructor */
	public Pgt00012(Long id, Boolean islogadd, Boolean islogupd,
			Boolean islogdel, Boolean islogpg, Boolean islogsh,
			Boolean isloggpg, Boolean islogss, Boolean islogdy, Timestamp upddate,
			String cd00002Userid) {
		this.id = id;
		this.islogadd = islogadd;
		this.islogupd = islogupd;
		this.islogdel = islogdel;
		this.islogpg = islogpg;
		this.islogsh = islogsh;
		this.isloggpg = isloggpg;
		this.islogss = islogss;
		this.islogdy = islogdy;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Userid;
	}

	/** full constructor */
	public Pgt00012(Long id, Boolean islogadd, Boolean islogupd,
			Boolean islogdel, Boolean islogpg, Boolean islogsh,
			Boolean isloggpg, Boolean islogss, Boolean islogdy, Timestamp upddate,
			String cd00002Userid, String note) {
		this.id = id;
		this.islogadd = islogadd;
		this.islogupd = islogupd;
		this.islogdel = islogdel;
		this.islogpg = islogpg;
		this.islogsh = islogsh;
		this.isloggpg = isloggpg;
		this.islogss = islogss;
		this.islogdy = islogdy;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Userid;
		this.note = note;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the islogadd
	 */
	public Boolean getIslogadd() {
		return islogadd;
	}

	/**
	 * @param islogadd the islogadd to set
	 */
	public void setIslogadd(Boolean islogadd) {
		this.islogadd = islogadd;
	}

	/**
	 * @return the islogupd
	 */
	public Boolean getIslogupd() {
		return islogupd;
	}

	/**
	 * @param islogupd the islogupd to set
	 */
	public void setIslogupd(Boolean islogupd) {
		this.islogupd = islogupd;
	}

	/**
	 * @return the islogdel
	 */
	public Boolean getIslogdel() {
		return islogdel;
	}

	/**
	 * @param islogdel the islogdel to set
	 */
	public void setIslogdel(Boolean islogdel) {
		this.islogdel = islogdel;
	}

	/**
	 * @return the islogpg
	 */
	public Boolean getIslogpg() {
		return islogpg;
	}

	/**
	 * @param islogpg the islogpg to set
	 */
	public void setIslogpg(Boolean islogpg) {
		this.islogpg = islogpg;
	}

	/**
	 * @return the islogsh
	 */
	public Boolean getIslogsh() {
		return islogsh;
	}

	/**
	 * @param islogsh the islogsh to set
	 */
	public void setIslogsh(Boolean islogsh) {
		this.islogsh = islogsh;
	}

	/**
	 * @return the isloggpg
	 */
	public Boolean getIsloggpg() {
		return isloggpg;
	}

	/**
	 * @param isloggpg the isloggpg to set
	 */
	public void setIsloggpg(Boolean isloggpg) {
		this.isloggpg = isloggpg;
	}

	/**
	 * @return the islogss
	 */
	public Boolean getIslogss() {
		return islogss;
	}

	/**
	 * @param islogss the islogss to set
	 */
	public void setIslogss(Boolean islogss) {
		this.islogss = islogss;
	}

	/**
	 * @return the islogdy
	 */
	public Boolean getIslogdy() {
		return islogdy;
	}

	/**
	 * @param islogdy the islogdy to set
	 */
	public void setIslogdy(Boolean islogdy) {
		this.islogdy = islogdy;
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
	 * @return the cd00001Ssgxlx
	 */
	public String getCd00001Ssgxlx() {
		return cd00001Ssgxlx;
	}

	/**
	 * @param cd00001Ssgxlx the cd00001Ssgxlx to set
	 */
	public void setCd00001Ssgxlx(String cd00001Ssgxlx) {
		this.cd00001Ssgxlx = cd00001Ssgxlx;
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

	/**
	 * @return the logadd
	 */
	public Integer getLogadd() {
		return logadd;
	}

	/**
	 * @param logadd the logadd to set
	 */
	public void setLogadd(Integer logadd) {
		this.logadd = logadd;
	}

	/**
	 * @return the logupd
	 */
	public Integer getLogupd() {
		return logupd;
	}

	/**
	 * @param logupd the logupd to set
	 */
	public void setLogupd(Integer logupd) {
		this.logupd = logupd;
	}

	/**
	 * @return the logdel
	 */
	public Integer getLogdel() {
		return logdel;
	}

	/**
	 * @param logdel the logdel to set
	 */
	public void setLogdel(Integer logdel) {
		this.logdel = logdel;
	}

	/**
	 * @return the logpg
	 */
	public Integer getLogpg() {
		return logpg;
	}

	/**
	 * @param logpg the logpg to set
	 */
	public void setLogpg(Integer logpg) {
		this.logpg = logpg;
	}

	/**
	 * @return the logsh
	 */
	public Integer getLogsh() {
		return logsh;
	}

	/**
	 * @param logsh the logsh to set
	 */
	public void setLogsh(Integer logsh) {
		this.logsh = logsh;
	}

	/**
	 * @return the loggpg
	 */
	public Integer getLoggpg() {
		return loggpg;
	}

	/**
	 * @param loggpg the loggpg to set
	 */
	public void setLoggpg(Integer loggpg) {
		this.loggpg = loggpg;
	}

	/**
	 * @return the logss
	 */
	public Integer getLogss() {
		return logss;
	}

	/**
	 * @param logss the logss to set
	 */
	public void setLogss(Integer logss) {
		this.logss = logss;
	}

	/**
	 * @return the logdy
	 */
	public Integer getLogdy() {
		return logdy;
	}

	/**
	 * @param logdy the logdy to set
	 */
	public void setLogdy(Integer logdy) {
		this.logdy = logdy;
	}

	/**
	 * @return the ssgx
	 */
	public String getSsgx() {
		return ssgx;
	}

	/**
	 * @param ssgx the ssgx to set
	 */
	public void setSsgx(String ssgx) {
		this.ssgx = ssgx;
	}

	public Boolean getIslogimp() {
		return islogimp;
	}

	public void setIslogimp(Boolean islogimp) {
		this.islogimp = islogimp;
	}

	public Boolean getIslogexp() {
		return islogexp;
	}

	public void setIslogexp(Boolean islogexp) {
		this.islogexp = islogexp;
	}

	public Boolean getIslogbackup() {
		return islogbackup;
	}

	public void setIslogbackup(Boolean islogbackup) {
		this.islogbackup = islogbackup;
	}

	public Boolean getIslogbzfcs() {
		return islogbzfcs;
	}

	public void setIslogbzfcs(Boolean islogbzfcs) {
		this.islogbzfcs = islogbzfcs;
	}

	public Boolean getIslognsrd() {
		return islognsrd;
	}

	public void setIslognsrd(Boolean islognsrd) {
		this.islognsrd = islognsrd;
	}

	public Integer getLogimp() {
		return logimp;
	}

	public void setLogimp(Integer logimp) {
		this.logimp = logimp;
	}

	public Integer getLogexp() {
		return logexp;
	}

	public void setLogexp(Integer logexp) {
		this.logexp = logexp;
	}

	public Integer getLogbackup() {
		return logbackup;
	}

	public void setLogbackup(Integer logbackup) {
		this.logbackup = logbackup;
	}

	public Integer getLogbzfcs() {
		return logbzfcs;
	}

	public void setLogbzfcs(Integer logbzfcs) {
		this.logbzfcs = logbzfcs;
	}

	public Integer getLognsrd() {
		return lognsrd;
	}

	public void setLognsrd(Integer lognsrd) {
		this.lognsrd = lognsrd;
	}

	public String getQdhgs() {
		return qdhgs;
	}

	public void setQdhgs(String qdhgs) {
		this.qdhgs = qdhgs;
	}

	public String getBzjcnf() {
		return bzjcnf;
	}

	public void setBzjcnf(String bzjcnf) {
		this.bzjcnf = bzjcnf;
	}
}