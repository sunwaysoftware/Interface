/**
 * 
 */
package com.sunway.vo;

/**
 * ZJLX
 * @author amani
 *
 */
public class CD002 implements java.io.Serializable {
	private static final long serialVersionUID = -3032441082750199446L;
	
	
	private String fcID;
	private String pgNM;
	

	public CD002() {
		super();
	}

	/**
	 * @param fcID
	 */
	public CD002(String fcID) {
		this.fcID = fcID;
	}
	
	/**
	 * @param fcID
	 * @param pgNM
	 */
	public CD002(String fcID, String pgNM) {
		this.fcID = fcID;
		this.pgNM = pgNM;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CD002 [fcID=" + fcID + ", pgNM=" + pgNM + "]";
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
