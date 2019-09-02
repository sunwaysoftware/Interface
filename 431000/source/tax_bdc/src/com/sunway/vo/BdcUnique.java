/**
 * 
 */
package com.sunway.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 不动产唯一查询
 * @author amani
 *
 */
public class BdcUnique {
	
	private String pCode;
	private String pName;
	private List<BdcInfo> bdcList;
	private String czr;
	

	public BdcUnique() {
		super();
		this.bdcList = new ArrayList<BdcInfo>();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BdcUnique [pCode=" + pCode + ", pName=" + pName + ", bdcList=" + bdcList + "]";
	}

	/**
	 * @return the pCode
	 */
	public String getpCode() {
		return pCode;
	}

	/**
	 * @param pCode the pCode to set
	 */
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	/**
	 * @return the pName
	 */
	public String getpName() {
		return pName;
	}

	/**
	 * @param pName the pName to set
	 */
	public void setpName(String pName) {
		this.pName = pName;
	}

	/**
	 * @return the bdcList
	 */
	public List<BdcInfo> getBdcList() {
		return bdcList;
	}

	/**
	 * @param bdcList the bdcList to set
	 */
	public void setBdcList(List<BdcInfo> bdcList) {
		this.bdcList = bdcList;
	}

	/**
	 * @return the czr
	 */
	public String getCzr() {
		return czr;
	}

	/**
	 * @param czr the czr to set
	 */
	public void setCzr(String czr) {
		this.czr = czr;
	}

	public static class BdcInfo {		
		private String QLR;
		private String GYQK;
		private String CQZH;
		private String ZLDZ;
		private String DYH;
		private String QLLX;
		private String QLXZ;
		private String YT;
		private String MJ;
		private String SYQX;
		private String QLQTZK;
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "BdcInfo [QLR=" + QLR + ", GYQK=" + GYQK + ", CQZH=" + CQZH + ", ZLDZ=" + ZLDZ + ", DYH=" + DYH
					+ ", QLLX=" + QLLX + ", QLXZ=" + QLXZ + ", YT=" + YT + ", MJ=" + MJ + ", SYQX=" + SYQX + ", QLQTZK="
					+ QLQTZK + "]";
		}
		/**
		 * @return the qLR
		 */
		public String getQLR() {
			return QLR;
		}
		/**
		 * @param qLR the qLR to set
		 */
		public void setQLR(String qLR) {
			QLR = qLR;
		}
		/**
		 * @return the gYQK
		 */
		public String getGYQK() {
			return GYQK;
		}
		/**
		 * @param gYQK the gYQK to set
		 */
		public void setGYQK(String gYQK) {
			GYQK = gYQK;
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
		/**
		 * @return the zLDZ
		 */
		public String getZLDZ() {
			return ZLDZ;
		}
		/**
		 * @param zLDZ the zLDZ to set
		 */
		public void setZLDZ(String zLDZ) {
			ZLDZ = zLDZ;
		}
		/**
		 * @return the dYH
		 */
		public String getDYH() {
			return DYH;
		}
		/**
		 * @param dYH the dYH to set
		 */
		public void setDYH(String dYH) {
			DYH = dYH;
		}
		/**
		 * @return the qLLX
		 */
		public String getQLLX() {
			return QLLX;
		}
		/**
		 * @param qLLX the qLLX to set
		 */
		public void setQLLX(String qLLX) {
			QLLX = qLLX;
		}
		/**
		 * @return the qLXZ
		 */
		public String getQLXZ() {
			return QLXZ;
		}
		/**
		 * @param qLXZ the qLXZ to set
		 */
		public void setQLXZ(String qLXZ) {
			QLXZ = qLXZ;
		}
		/**
		 * @return the yT
		 */
		public String getYT() {
			return YT;
		}
		/**
		 * @param yT the yT to set
		 */
		public void setYT(String yT) {
			YT = yT;
		}
		/**
		 * @return the mJ
		 */
		public String getMJ() {
			return MJ;
		}
		/**
		 * @param mJ the mJ to set
		 */
		public void setMJ(String mJ) {
			MJ = mJ;
		}
		/**
		 * @return the sYQX
		 */
		public String getSYQX() {
			return SYQX;
		}
		/**
		 * @param sYQX the sYQX to set
		 */
		public void setSYQX(String sYQX) {
			SYQX = sYQX;
		}
		/**
		 * @return the qLQTZK
		 */
		public String getQLQTZK() {
			return QLQTZK;
		}
		/**
		 * @param qLQTZK the qLQTZK to set
		 */
		public void setQLQTZK(String qLQTZK) {
			QLQTZK = qLQTZK;
		}
	}
	
	
}
