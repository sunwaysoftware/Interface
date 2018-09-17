/**
 * 
 */
package com.sunway.vo;

/**
 * @author amani
 *
 */
public class FC001_PK implements java.io.Serializable {

	private static final long serialVersionUID = 7922094079601244191L;
	
	private String slid;
	private String ssqy;
	
	public FC001_PK() {
		super();
	}
	
	/**
	 * @param slid
	 * @param ssqy
	 */
	public FC001_PK(String slid, String ssqy) {
		super();
		this.slid = slid;
		this.ssqy = ssqy;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((slid == null) ? 0 : slid.hashCode());
		result = prime * result + ((ssqy == null) ? 0 : ssqy.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FC001_PK other = (FC001_PK) obj;
		if (slid == null) {
			if (other.slid != null)
				return false;
		} else if (!slid.equals(other.slid))
			return false;
		if (ssqy == null) {
			if (other.ssqy != null)
				return false;
		} else if (!ssqy.equals(other.ssqy))
			return false;
		return true;
	}
	
	/**
	 * @return the slid
	 */
	public String getSlid() {
		return slid;
	}
	/**
	 * @param slid the slid to set
	 */
	public void setSlid(String slid) {
		this.slid = slid;
	}
	/**
	 * @return the ssqy
	 */
	public String getSsqy() {
		return ssqy;
	}
	/**
	 * @param ssqy the ssqy to set
	 */
	public void setSsqy(String ssqy) {
		this.ssqy = ssqy;
	}
	
}
