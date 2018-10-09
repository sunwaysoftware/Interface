/**
 * 
 */
package com.sunway.vo;

/**
 * SZQY
 * @author amani
 *
 */
public class CD001 implements java.io.Serializable {
	private static final long serialVersionUID = -3032441082750199446L;
	
	
	private String fcID;
	private String pgNM;
	

	public CD001() {
		super();
	}

	/**
	 * @param fcID
	 */
	public CD001(String fcID) {
		this.fcID = fcID;
	}
	
	/**
	 * @param fcID
	 * @param pgNM
	 */
	public CD001(String fcID, String pgNM) {
		this.fcID = fcID;
		this.pgNM = pgNM;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CD001 [fcID=" + fcID + ", pgNM=" + pgNM + "]";
	}

	/**
	 * @return the fcID
	 */
	public String getFcID() {
		return fcID;
	}
	/**
	 * @param fcID the fcID to set
	 */
	public void setFcID(String fcID) {
		this.fcID = fcID;
	}
	/**
	 * @return the pgNM
	 */
	public String getPgNM() {
		return pgNM;
	}
	/**
	 * @param pgNM the pgNM to set
	 */
	public void setPgNM(String pgNM) {
		this.pgNM = pgNM;
	}

}
