package com.sunway.entity.tax;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "TAX_DICT_SHJG")
public class TaxShjgDict implements Serializable {
    @Id
    private String id;
    private String taxNm;

    public TaxShjgDict() {}

    //----------------------- setter and getter --------------------------------
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTaxNm() {
        return taxNm;
    }

    public void setTaxNm(String taxNm) {
        this.taxNm = taxNm;
    }
}
