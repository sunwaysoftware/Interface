/**
 * 
 */
package com.sunway.vo;

import java.util.Date;

/**
 * 
 * 標准實例庫更新圖表用
 * @author Andy.Gao
 *
 */
public class ChartBzslk implements java.io.Serializable {
	private static final long serialVersionUID = -1228228134980756328L;
	/**
	 * 數據類型(B:標准實例;G挂牌;S成交)
	 */
	private String lx;
	/**
	 * 月份
	 */
	private String jyMonth;
	/**
	 * 月均值
	 */
	private Double je;
	
	private String rowTitle;
	private Double month1Je;
	private Double month2Je;
	private Double month3Je;
	private Double month4Je;
	private Double month5Je;
	private Double month6Je;
	private Double month7Je;
	private Double month8Je;
	private Double month9Je;
	private Double month10Je;
	private Double month11Je;
	private Double month12Je;
	
	private String cd00352Xqdm;
	private String cd00002Pssd;
	private String cd00001Szqy;
	private String cd00001Fwlx;
	
	private Date month;
	private Integer gpqz;
	private Double czl;
	private String cd00002Czr;
	private String nf;
	private String cd00001Ssgx;
    // Constructors

    /** default constructor */
    public ChartBzslk() {
    }

    
    /** full constructor */
    public ChartBzslk(String lx, String jyMonth, Double je, String rowTitle, Double month1Je, Double month2Je,
    				  Double month3Je, Double month4Je, Double month5Je, Double month6Je, Double month7Je, 
    				  Double month8Je, Double month9Je, Double month10Je, Double month11Je, Double month12Je) {
        this.lx = lx;
        this.jyMonth = jyMonth;
        this.je = je;
        this.rowTitle = rowTitle;
        this.month1Je = month1Je;
        this.month2Je = month2Je;
        this.month3Je = month3Je;
        this.month4Je = month4Je;
        this.month5Je = month5Je;
        this.month6Je = month6Je;
        this.month7Je = month7Je;
        this.month8Je = month8Je;
        this.month9Je = month9Je;
        this.month10Je = month10Je;
        this.month11Je = month11Je;
        this.month12Je = month12Je;
    }
	
	/**
	 * @return the lx
	 */
	public String getLx() {
		return lx;
	}
	
	/**
	 * @param lx the lx to set
	 */
	public void setLx(String lx) {
		this.lx = lx;
	}
	
	/**
	 * @return the jyMonth
	 */
	public String getJyMonth() {
		return jyMonth;
	}
	
	/**
	 * @param jyMonth the jyMonth to set
	 */
	public void setJyMonth(String jyMonth) {
		this.jyMonth = jyMonth;
	}
	
	/**
	 * @return the je
	 */
	public Double getJe() {
		return je;
	}
	
	/**
	 * @param je the je to set
	 */
	public void setJe(Double je) {
		this.je = je;
	}

	/**
	 * @return the rowTitle
	 */
	public String getRowTitle() {
		return rowTitle;
	}

	/**
	 * @param rowTitle the rowTitle to set
	 */
	public void setRowTitle(String rowTitle) {
		this.rowTitle = rowTitle;
	}

	/**
	 * @return the month1Je
	 */
	public Double getMonth1Je() {
		return month1Je;
	}

	/**
	 * @param month1Je the month1Je to set
	 */
	public void setMonth1Je(Double month1Je) {
		this.month1Je = month1Je;
	}

	/**
	 * @return the month2Je
	 */
	public Double getMonth2Je() {
		return month2Je;
	}

	/**
	 * @param month2Je the month2Je to set
	 */
	public void setMonth2Je(Double month2Je) {
		this.month2Je = month2Je;
	}

	/**
	 * @return the month3Je
	 */
	public Double getMonth3Je() {
		return month3Je;
	}

	/**
	 * @param month3Je the month3Je to set
	 */
	public void setMonth3Je(Double month3Je) {
		this.month3Je = month3Je;
	}

	/**
	 * @return the month4Je
	 */
	public Double getMonth4Je() {
		return month4Je;
	}

	/**
	 * @param month4Je the month4Je to set
	 */
	public void setMonth4Je(Double month4Je) {
		this.month4Je = month4Je;
	}

	/**
	 * @return the month5Je
	 */
	public Double getMonth5Je() {
		return month5Je;
	}

	/**
	 * @param month5Je the month5Je to set
	 */
	public void setMonth5Je(Double month5Je) {
		this.month5Je = month5Je;
	}

	/**
	 * @return the month6Je
	 */
	public Double getMonth6Je() {
		return month6Je;
	}

	/**
	 * @param month6Je the month6Je to set
	 */
	public void setMonth6Je(Double month6Je) {
		this.month6Je = month6Je;
	}

	/**
	 * @return the month7Je
	 */
	public Double getMonth7Je() {
		return month7Je;
	}

	/**
	 * @param month7Je the month7Je to set
	 */
	public void setMonth7Je(Double month7Je) {
		this.month7Je = month7Je;
	}

	/**
	 * @return the month8Je
	 */
	public Double getMonth8Je() {
		return month8Je;
	}

	/**
	 * @param month8Je the month8Je to set
	 */
	public void setMonth8Je(Double month8Je) {
		this.month8Je = month8Je;
	}

	/**
	 * @return the month9Je
	 */
	public Double getMonth9Je() {
		return month9Je;
	}

	/**
	 * @param month9Je the month9Je to set
	 */
	public void setMonth9Je(Double month9Je) {
		this.month9Je = month9Je;
	}

	/**
	 * @return the month10Je
	 */
	public Double getMonth10Je() {
		return month10Je;
	}

	/**
	 * @param month10Je the month10Je to set
	 */
	public void setMonth10Je(Double month10Je) {
		this.month10Je = month10Je;
	}

	/**
	 * @return the month11Je
	 */
	public Double getMonth11Je() {
		return month11Je;
	}

	/**
	 * @param month11Je the month11Je to set
	 */
	public void setMonth11Je(Double month11Je) {
		this.month11Je = month11Je;
	}

	/**
	 * @return the month12Je
	 */
	public Double getMonth12Je() {
		return month12Je;
	}

	/**
	 * @param month12Je the month12Je to set
	 */
	public void setMonth12Je(Double month12Je) {
		this.month12Je = month12Je;
	}


	/**
	 * @return the cd00352Xqdm
	 */
	public String getCd00352Xqdm() {
		return cd00352Xqdm;
	}


	/**
	 * @param cd00352Xqdm the cd00352Xqdm to set
	 */
	public void setCd00352Xqdm(String cd00352Xqdm) {
		this.cd00352Xqdm = cd00352Xqdm;
	}


	/**
	 * @return the cd00002Pssd
	 */
	public String getCd00002Pssd() {
		return cd00002Pssd;
	}


	/**
	 * @param cd00002Pssd the cd00002Pssd to set
	 */
	public void setCd00002Pssd(String cd00002Pssd) {
		this.cd00002Pssd = cd00002Pssd;
	}


	/**
	 * @return the cd00001Szqy
	 */
	public String getCd00001Szqy() {
		return cd00001Szqy;
	}


	/**
	 * @param cd00001Szqy the cd00001Szqy to set
	 */
	public void setCd00001Szqy(String cd00001Szqy) {
		this.cd00001Szqy = cd00001Szqy;
	}


	/**
	 * @return the month
	 */
	public Date getMonth() {
		return month;
	}


	/**
	 * @param month the month to set
	 */
	public void setMonth(Date month) {
		this.month = month;
	}


	/**
	 * @return the czl
	 */
	public Double getCzl() {
		return czl;
	}


	/**
	 * @param czl the czl to set
	 */
	public void setCzl(Double czl) {
		this.czl = czl;
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
	 * @return the gpqz
	 */
	public Integer getGpqz() {
		return gpqz;
	}


	/**
	 * @param gpqz the gpqz to set
	 */
	public void setGpqz(Integer gpqz) {
		this.gpqz = gpqz;
	}


	public void setCd00001Fwlx(String cd00001Fwlx) {
		this.cd00001Fwlx = cd00001Fwlx;
	}


	public String getCd00001Fwlx() {
		return cd00001Fwlx;
	}


	/**
	 * @return the nf
	 */
	public String getNf() {
		return nf;
	}


	/**
	 * @param nf the nf to set
	 */
	public void setNf(String nf) {
		this.nf = nf;
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
