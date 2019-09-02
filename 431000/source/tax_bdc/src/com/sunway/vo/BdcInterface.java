/**
 * 
 */
package com.sunway.vo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * 与国土交互用
 * @author amani
 *
 */
@XmlType
@XmlAccessorType()
@XmlRootElement(name="INFO")
public class BdcInterface {
	private String FZJHM;
	private String FSQRMC;
	private List<FdcqInfo> fdcqList;
	private String RESULT_FLAG;
	private String RESULT_MESSAGE;
	

	public BdcInterface() {
		fdcqList = new ArrayList<>();
	}
	
	/**
	 * 房地产属性信息
	 */
	public static class FdcqInfo {	
		private String CQZH;
		private String FBDCDYH;
		private String FFDZL;
		/**
		 * @return the fBDCDYH
		 */
		public String getFBDCDYH() {
			return FBDCDYH;
		}
		/**
		 * @param fBDCDYH the fBDCDYH to set
		 */
		public void setFBDCDYH(String fBDCDYH) {
			FBDCDYH = fBDCDYH;
		}
		/**
		 * @return the fFDZL
		 */
		public String getFFDZL() {
			return FFDZL;
		}
		/**
		 * @param fFDZL the fFDZL to set
		 */
		public void setFFDZL(String fFDZL) {
			FFDZL = fFDZL;
		}
		/**
		 * @return the cQZH
		 */
		public String getCQZH() {
			return CQZH;
		}
		/**
		 * @param cQZH the cQZH to set
		 */
		public void setCQZH(String cQZH) {
			CQZH = cQZH;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "FdcqInfo [CQZH=" + CQZH + ", FBDCDYH=" + FBDCDYH + ", FFDZL=" + FFDZL + "]";
		}
	}

	/**
	 * @return the rESULT_FLAG
	 */
	public String getRESULT_FLAG() {
		return RESULT_FLAG;
	}
	/**
	 * @param rESULT_FLAG the rESULT_FLAG to set
	 */
	public void setRESULT_FLAG(String rESULT_FLAG) {
		RESULT_FLAG = rESULT_FLAG;
	}
	/**
	 * @return the rESULT_MESSAGE
	 */
	public String getRESULT_MESSAGE() {
		return RESULT_MESSAGE;
	}
	/**
	 * @param rESULT_MESSAGE the rESULT_MESSAGE to set
	 */
	public void setRESULT_MESSAGE(String rESULT_MESSAGE) {
		RESULT_MESSAGE = rESULT_MESSAGE;
	}
	
	/**
	 * @return the fZJHM
	 */
	public String getFZJHM() {
		return FZJHM;
	}
	/**
	 * @param fZJHM the fZJHM to set
	 */
	public void setFZJHM(String fZJHM) {
		FZJHM = fZJHM;
	}
	/**
	 * @return the fSQRMC
	 */
	public String getFSQRMC() {
		return FSQRMC;
	}
	/**
	 * @param fSQRMC the fSQRMC to set
	 */
	public void setFSQRMC(String fSQRMC) {
		FSQRMC = fSQRMC;
	}
	/**
	 * @return the fdcqList
	 */
	@XmlElementWrapper(name="FDCQINFO")
	@XmlElement(name="FDCQ")
	public List<FdcqInfo> getFdcqList() {
		return fdcqList;
	}
	/**
	 * @param fdcqList the fdcqList to set
	 */
	public void setFdcqList(List<FdcqInfo> fdcqList) {
		this.fdcqList = fdcqList;
	}
	
}
