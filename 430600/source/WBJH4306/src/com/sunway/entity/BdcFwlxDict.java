package com.sunway.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "BDC_DICT_FWLX")
public class BdcFwlxDict implements Serializable {
	private static final long serialVersionUID = -4350240423969905312L;
	@Id
    private String id;
    private String bdcNm;
    private String taxNm;

    public BdcFwlxDict(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBdcNm() {
        return bdcNm;
    }

    public void setBdcNm(String bdcNm) {
        this.bdcNm = bdcNm;
    }

    public String getTaxNm() {
        return taxNm;
    }

    public void setTaxNm(String taxNm) {
        this.taxNm = taxNm;
    }
}
