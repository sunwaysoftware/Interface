package com.sunway.vo;

import java.util.Date;


/**
 * Pgv10031a1Id entity. @author MyEclipse Persistence Tools
 */


public class Pgv10031a1  implements java.io.Serializable {

	private static final long serialVersionUID = -7367544204860445841L;
	private String qtxzid;
     private String cd12004Mxid;
     private String cd00002Pssd;
     private Double xzxs;
     private Date upddate;
     private String cd00002Czr;
     private String note;
     private String xzmc;
     private Integer xzlx;
     private String czr;


    // Constructors

    /** default constructor */
    public Pgv10031a1() {
    }

    /**
     * @param cd12004Mxid
     * @param cd00002Pssd
     */
    public Pgv10031a1(String cd12004Mxid, String cd00002Pssd) {
    	this.cd12004Mxid = cd12004Mxid;
    	this.cd00002Pssd = cd00002Pssd;
    }
    
	/** minimal constructor */
    public Pgv10031a1(String qtxzid, String cd12004Mxid, String cd00002Pssd, Double xzxs, Date upddate, String cd00002Czr, Integer xzlx) {
        this.qtxzid = qtxzid;
        this.cd12004Mxid = cd12004Mxid;
        this.cd00002Pssd = cd00002Pssd;
        this.xzxs = xzxs;
        this.upddate = upddate;
        this.cd00002Czr = cd00002Czr;
        this.xzlx = xzlx;
    }
    
    /** full constructor */
    public Pgv10031a1(String qtxzid, String cd12004Mxid, String cd00002Pssd, Double xzxs, Date upddate, String cd00002Czr, String note, String xzmc, Integer xzlx, String czr) {
        this.qtxzid = qtxzid;
        this.cd12004Mxid = cd12004Mxid;
        this.cd00002Pssd = cd00002Pssd;
        this.xzxs = xzxs;
        this.upddate = upddate;
        this.cd00002Czr = cd00002Czr;
        this.note = note;
        this.xzmc = xzmc;
        this.xzlx = xzlx;
        this.czr = czr;
    }

   
    // Property accessors

    public String getQtxzid() {
        return this.qtxzid;
    }
    
    public void setQtxzid(String qtxzid) {
        this.qtxzid = qtxzid;
    }

    public String getCd12004Mxid() {
        return this.cd12004Mxid;
    }
    
    public void setCd12004Mxid(String cd12004Mxid) {
        this.cd12004Mxid = cd12004Mxid;
    }

    public String getCd00002Pssd() {
        return this.cd00002Pssd;
    }
    
    public void setCd00002Pssd(String cd00002Pssd) {
        this.cd00002Pssd = cd00002Pssd;
    }

    public Double getXzxs() {
        return this.xzxs;
    }
    
    public void setXzxs(Double xzxs) {
        this.xzxs = xzxs;
    }

    public Date getUpddate() {
        return this.upddate;
    }
    
    public void setUpddate(Date upddate) {
        this.upddate = upddate;
    }

    public String getCd00002Czr() {
        return this.cd00002Czr;
    }
    
    public void setCd00002Czr(String cd00002Czr) {
        this.cd00002Czr = cd00002Czr;
    }

    public String getNote() {
        return this.note;
    }
    
    public void setNote(String note) {
        this.note = note;
    }

    public String getXzmc() {
        return this.xzmc;
    }
    
    public void setXzmc(String xzmc) {
        this.xzmc = xzmc;
    }

    public Integer getXzlx() {
        return this.xzlx;
    }
    
    public void setXzlx(Integer xzlx) {
        this.xzlx = xzlx;
    }

    public String getCzr() {
        return this.czr;
    }
    
    public void setCzr(String czr) {
        this.czr = czr;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof Pgv10031a1) ) return false;
		 Pgv10031a1 castOther = ( Pgv10031a1 ) other; 
         
		 return ( (this.getQtxzid()==castOther.getQtxzid()) || ( this.getQtxzid()!=null && castOther.getQtxzid()!=null && this.getQtxzid().equals(castOther.getQtxzid()) ) )
 && ( (this.getCd12004Mxid()==castOther.getCd12004Mxid()) || ( this.getCd12004Mxid()!=null && castOther.getCd12004Mxid()!=null && this.getCd12004Mxid().equals(castOther.getCd12004Mxid()) ) )
 && ( (this.getCd00002Pssd()==castOther.getCd00002Pssd()) || ( this.getCd00002Pssd()!=null && castOther.getCd00002Pssd()!=null && this.getCd00002Pssd().equals(castOther.getCd00002Pssd()) ) )
 && ( (this.getXzxs()==castOther.getXzxs()) || ( this.getXzxs()!=null && castOther.getXzxs()!=null && this.getXzxs().equals(castOther.getXzxs()) ) )
 && ( (this.getUpddate()==castOther.getUpddate()) || ( this.getUpddate()!=null && castOther.getUpddate()!=null && this.getUpddate().equals(castOther.getUpddate()) ) )
 && ( (this.getCd00002Czr()==castOther.getCd00002Czr()) || ( this.getCd00002Czr()!=null && castOther.getCd00002Czr()!=null && this.getCd00002Czr().equals(castOther.getCd00002Czr()) ) )
 && ( (this.getNote()==castOther.getNote()) || ( this.getNote()!=null && castOther.getNote()!=null && this.getNote().equals(castOther.getNote()) ) )
 && ( (this.getXzmc()==castOther.getXzmc()) || ( this.getXzmc()!=null && castOther.getXzmc()!=null && this.getXzmc().equals(castOther.getXzmc()) ) )
 && ( (this.getXzlx()==castOther.getXzlx()) || ( this.getXzlx()!=null && castOther.getXzlx()!=null && this.getXzlx().equals(castOther.getXzlx()) ) )
 && ( (this.getCzr()==castOther.getCzr()) || ( this.getCzr()!=null && castOther.getCzr()!=null && this.getCzr().equals(castOther.getCzr()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getQtxzid() == null ? 0 : this.getQtxzid().hashCode() );
         result = 37 * result + ( getCd12004Mxid() == null ? 0 : this.getCd12004Mxid().hashCode() );
         result = 37 * result + ( getCd00002Pssd() == null ? 0 : this.getCd00002Pssd().hashCode() );
         result = 37 * result + ( getXzxs() == null ? 0 : this.getXzxs().hashCode() );
         result = 37 * result + ( getUpddate() == null ? 0 : this.getUpddate().hashCode() );
         result = 37 * result + ( getCd00002Czr() == null ? 0 : this.getCd00002Czr().hashCode() );
         result = 37 * result + ( getNote() == null ? 0 : this.getNote().hashCode() );
         result = 37 * result + ( getXzmc() == null ? 0 : this.getXzmc().hashCode() );
         result = 37 * result + ( getXzlx() == null ? 0 : this.getXzlx().hashCode() );
         result = 37 * result + ( getCzr() == null ? 0 : this.getCzr().hashCode() );
         return result;
   }

}