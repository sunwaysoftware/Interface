/**
 *
 */
package com.sunway.action;

import java.util.ArrayList;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt02031Service;
import com.sunway.service.IPgt02031cService;
import com.sunway.service.IPgt02034Service;
import com.sunway.service.IPgt02034cService;
import com.sunway.util.CheckUtil;
import com.sunway.vo.Cz02000;
import com.sunway.vo.Pgt02034a;
import com.sunway.vo.Pgv02031;
import com.sunway.vo.Pgt02031c;
import com.sunway.vo.Pgt02034;
import com.sunway.vo.Pgt02034c;

/**
 *
 * 市场法参与评税的实例库
 * 
 * @author Andy.Gao
 *
 */
public class Pgt02034Action extends ActionSupport {
	private static final long serialVersionUID = 4650950576013918171L;
	private IPgt02034Service t02034Service;
	private IPgt02031Service t02031Service;
	private IPgt02031cService t02031cService;
	private IPgt02034cService t02034cService;
	private ArrayList<Pgt02034> rows;
	private ArrayList<Cz02000> gsList;
	private String txtFCID;
	private String txtPSSD;
	private Double txtPGJG;
	private Double txtJZMJ;
	private Double txtPGXZ;
	private Double txtXZXS;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** start **********");
		}

		try {
			rows = t02034Service.LoadAll(new Pgt02034(txtFCID, txtPSSD));
			readInfo();

		} catch (Exception e) {
			LOG.error("execute()", e);
			this.addActionError(e.getMessage());
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** end **********");
		}
		return SUCCESS;
	}

	public String execute_B() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** start **********");
		}

		try {
			rows = t02034Service.LoadAll_B(new Pgt02034(txtFCID, txtPSSD));
			readInfo_B();

		} catch (Exception e) {
			LOG.error(e.getMessage());
			LOG.error("execute()", e);
			this.addActionError(e.getMessage());
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 进行公式整合
	 */
	protected void readInfo_B() throws Exception {
		gsList = new ArrayList<Cz02000>();
		Pgv02031 t02031 = new Pgv02031();
		t02031.setCd02002Fcid(txtFCID);
		t02031 = t02031Service.LoadByPrimaryKey_B(t02031);
		// 取得待评估对象修正参数
		ArrayList<Pgt02031c> t02031cList = t02031cService.LoadAll_B(new Pgt02031c(txtFCID));
		for (Pgt02034 sl : rows) {
			Cz02000 e = new Cz02000();
			// 1.获得【原单价】
			e.setYpfmjg(sl.getYpfmjg());
			e.setWjxz(sl.getWjxz());
			// 2.获得【修正列表】
			ArrayList<Pgt02034a> xzList = new ArrayList<Pgt02034a>();
			// 组织列表
			ArrayList<Pgt02034c> t02034cList = t02034cService.LoadAll_B(new Pgt02034c(txtFCID, sl.getCdSlid()));
			for (Pgt02031c tmp331c : t02031cList) {
				Pgt02034a qtxz = new Pgt02034a();
				qtxz.setCd00053Qtxzid(tmp331c.getRootnm());
				for (Pgt02034c tmp334c : t02034cList) {
					if (tmp331c.getCd00001Rootid().equals(tmp334c.getCd00001Rootid())) {
						qtxz.setCzlx(tmp331c.getCzlx());
						switch (tmp331c.getCzlx()) {
						case 0:// 乘
							qtxz.setQtxzNm("(1 + " + tmp331c.getXzxs() + "/100 - " + tmp334c.getXzxs() + "/100)");
							break;
						case 1:// 加
							qtxz.setQtxzNm("(" + tmp331c.getXzxs() + " - " + tmp334c.getXzxs() + ")");
							break;
						default:
							break;
						}
						break;
					}
				}
				// 当等评估有相关参数而标准房或者实例库没有时要怎么处理
				if (CheckUtil.chkEmpty(qtxz.getQtxzNm())) {
					qtxz.setCzlx(tmp331c.getCzlx());
					switch (tmp331c.getCzlx()) {
					case 0:// 乘
						qtxz.setQtxzNm("(1 + " + tmp331c.getXzxs() + "/100 - " + "0" + "/100)");
						break;
					case 1:// 加
						qtxz.setQtxzNm("(" + tmp331c.getXzxs() + " - " + "0" + ")");
						break;
					default:
						break;
					}
				}
				xzList.add(qtxz);
				qtxz = null;
			}
			e.setXzList(xzList);
			// 3.获得【其他修正列表】
			// ArrayList<Pgt02034a> t02034aList = t02034aService.LoadAll(new
			// Pgt02034a(sl.getCd02002Fcid(), sl.getCdSlid(),
			// sl.getCd00002Pssd()));
			// 组织列表
			// ArrayList<Pgt02034a> qtxzList = new ArrayList<Pgt02034a>();
			// for(Pgt02034a bean : t02034aList){
			// Pgt02034a qtxz = new Pgt02034a();
			// qtxz.setCd00053Qtxzid(bean.getQtxzNm());
			// switch (bean.getCzlx()) {
			// case 0://乘
			// qtxz.setQtxzNm("(1 + "+bean.getCd00053Qtxz()+"/100 -
			// "+bean.getCd00053Slqtxz()+"/100)");
			// break;
			// case 1://加
			// qtxz.setQtxzNm("("+bean.getCd00053Qtxz()+" -
			// "+bean.getCd00053Slqtxz()+")");
			// break;
			// default:
			// break;
			// }
			// if(!CheckUtil.chkEmpty(qtxz.getQtxzNm()))
			// qtxzList.add(qtxz);
			// qtxz = null;
			// }
			// e.setQtxzList(qtxzList);
			// 4.获得【修正单价】
			e.setPfmjg(sl.getPfmjg());
			// 填入公式列表
			gsList.add(e);
		}
		txtPGJG = t02031.getPgjg();
		txtJZMJ = t02031.getJzmj();
		//txtPGXZ = t02031.getPgxz();
		//txtXZXS = t02031.getGaxzxs();
		// 读取待評估對象修正列表
		/*
		 * ArrayList<Pgt02031a> t02031aList = t02031aService.LoadAll(new
		 * Pgt02031a(txtFCID)); if(null!=t02031aList && t02031aList.size()>0)
		 * dpgXzList = new ArrayList<Pgt02031a>(); for(Pgt02031a bean :
		 * t02031aList){ Pgt02031a qtxz = new Pgt02031a();
		 * qtxz.setCd00053Qtxzid(bean.getQtxzNm()); switch (bean.getCzlx()) {
		 * case 0://乘 qtxz.setQtxzNm("(1 + "+bean.getCd00053Qtxz()+"/100 - "
		 * +bean.getCd00053Qtxz()+"/100)"); break; case 1://加
		 * qtxz.setQtxzNm("("+bean.getCd00053Qtxz()+" - "
		 * +bean.getCd00053Qtxz()+")"); break; default: break; }
		 * dpgXzList.add(qtxz); qtxz = null; }
		 */
	}

	/**
	 * 进行公式整合
	 */
	protected void readInfo() throws Exception {
		gsList = new ArrayList<Cz02000>();
		Pgv02031 t02031 = new Pgv02031();
		t02031.setCd02002Fcid(txtFCID);
		t02031 = t02031Service.LoadByPrimaryKey(t02031);
		// 取得待评估对象修正参数
		ArrayList<Pgt02031c> t02031cList = t02031cService.LoadAll(new Pgt02031c(txtFCID));
		for (Pgt02034 sl : rows) {
			Cz02000 e = new Cz02000();
			// 1.获得【原单价】
			e.setYpfmjg(sl.getYpfmjg());
			e.setWjxz(sl.getWjxz());
			// 2.获得【修正列表】
			ArrayList<Pgt02034a> xzList = new ArrayList<Pgt02034a>();
			// 组织列表
			ArrayList<Pgt02034c> t02034cList = t02034cService.LoadAll(new Pgt02034c(txtFCID, sl.getCdSlid()));
			for (Pgt02031c tmp331c : t02031cList) {
				Pgt02034a qtxz = new Pgt02034a();
				qtxz.setCd00053Qtxzid(tmp331c.getRootnm());
				for (Pgt02034c tmp334c : t02034cList) {
					if (tmp331c.getCd00001Rootid().equals(tmp334c.getCd00001Rootid())) {
						qtxz.setCzlx(tmp331c.getCzlx());
						switch (tmp331c.getCzlx()) {
						case 0:// 乘
							qtxz.setQtxzNm(tmp331c.getXzxs() + "/" + tmp334c.getXzxs());
							// qtxz.setQtxzNm("(1 + " + tmp331c.getXzxs() +
							// "/100 " +
							// Common.isPlusOrSubtractionSign(tmp334c.getXzxs())
							// +" "+ Math.abs(tmp334c.getXzxs()) + "/100)");
							break;
						case 1:// 加
							qtxz.setQtxzNm("(" + tmp331c.getXzxs() + " - " + tmp334c.getXzxs() + ")");
							break;
						default:
							break;
						}
						break;
					}
				}
				// 当等评估有相关参数而标准房或者实例库没有时要怎么处理
				if (CheckUtil.chkEmpty(qtxz.getQtxzNm())) {
					qtxz.setCzlx(tmp331c.getCzlx());
					switch (tmp331c.getCzlx()) {
					case 0:// 乘
						qtxz.setQtxzNm(tmp331c.getXzxs() + "/100");
						// qtxz.setQtxzNm("(1 + " + tmp331c.getXzxs() + "/100 "
						// + Common.isPlusOrSubtractionSign(tmp334c.getXzxs())
						// +" "+ Math.abs(tmp334c.getXzxs()) + "/100)");
						break;
					case 1:// 加
						qtxz.setQtxzNm("(" + tmp331c.getXzxs() + " - " + "0" + ")");
						break;
					default:
						break;
					}
				}
				xzList.add(qtxz);
				qtxz = null;
			}
			e.setXzList(xzList);
			/*// 3.获得【其他修正列表】
			ArrayList<Pgt02034a> t02034aList = t02034aService
					.LoadAll(new Pgt02034a(sl.getCd02002Fcid(), sl.getCdSlid(), sl.getCd00002Pssd()));
			// 组织列表
			ArrayList<Pgt02034a> qtxzList = new ArrayList<Pgt02034a>();
			for (Pgt02034a bean : t02034aList) {
				Pgt02034a qtxz = new Pgt02034a();
				qtxz.setCd00053Qtxzid(bean.getQtxzNm());
				switch (bean.getCzlx()) {
				case 0:// 乘
					qtxz.setQtxzNm("(1 + " + bean.getCd00053Qtxz() + "/100 - " + bean.getCd00053Slqtxz() + "/100)");
					break;
				case 1:// 加
					qtxz.setQtxzNm("(" + bean.getCd00053Qtxz() + " - " + bean.getCd00053Slqtxz() + ")");
					break;
				default:
					break;
				}
				if (!CheckUtil.chkEmpty(qtxz.getQtxzNm()))
					qtxzList.add(qtxz);
				qtxz = null;
			}
			e.setQtxzList(qtxzList);*/
			// 4.获得【修正单价】
			e.setPfmjg(sl.getPfmjg());
			// 填入公式列表
			gsList.add(e);
		}
		txtPGJG = t02031.getPgjg();
		txtJZMJ = t02031.getJzmj();
		//txtPGXZ = t02031.getPgxz();
		//txtXZXS = t02031.getGaxzxs();
		/*// 读取待評估對象修正列表
		ArrayList<Pgt02031a> t02031aList = t02031aService.LoadAll(new Pgt02031a(txtFCID));
		if (null != t02031aList && t02031aList.size() > 0) {
			dpgXzList = new ArrayList<Pgt02031a>();
			for (Pgt02031a bean : t02031aList) {
				Pgt02031a qtxz = new Pgt02031a();
				qtxz.setCd00053Qtxzid(bean.getQtxzNm());
				switch (bean.getCzlx()) {
				case 0:// 乘
					qtxz.setQtxzNm("(1 + " + bean.getCd00053Qtxz() + "/100 - " + bean.getCd00053Qtxz() + "/100)");
					break;
				case 1:// 加
					qtxz.setQtxzNm("(" + bean.getCd00053Qtxz() + " - " + bean.getCd00053Qtxz() + ")");
					break;
				default:
					break;
				}
				dpgXzList.add(qtxz);
				qtxz = null;
			}
		}*/
	}

	/*************************
	 * set and get
	 **************************************/

	/**
	 * @param t02034Service
	 *            the t02034Service to set
	 */
	public void setT02034Service(IPgt02034Service t02034Service) {
		this.t02034Service = t02034Service;
	}

	/**
	 * @return the t02034Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt02034Service getT02034Service() {
		return t02034Service;
	}
	

	/**
	 * @param t02031cService
	 *            the t02031cService to set
	 */
	public void setT02031cService(IPgt02031cService t02031cService) {
		this.t02031cService = t02031cService;
	}

	/**
	 * @return the t02031cService
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt02031cService getT02031cService() {
		return t02031cService;
	}

	/**
	 * @param t02031Service
	 *            the t02031Service to set
	 */
	public void setT02031Service(IPgt02031Service t02031Service) {
		this.t02031Service = t02031Service;
	}

	/**
	 * @return the t02031Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt02031Service getT02031Service() {
		return t02031Service;
	}

	/**
	 * @param t02034cService
	 *            the t02034cService to set
	 */
	public void setT02034cService(IPgt02034cService t02034cService) {
		this.t02034cService = t02034cService;
	}

	/**
	 * @return the t02034cService
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt02034cService getT02034cService() {
		return t02034cService;
	}
	

	/**
	 * @param txtFCID
	 *            the txtFCID to set
	 */
	public void setTxtFCID(String txtFCID) {
		this.txtFCID = txtFCID;
	}

	/**
	 * @return the txtFCID
	 */
	public String getTxtFCID() {
		return txtFCID;
	}

	/**
	 * @param txtPSSD
	 *            the txtPSSD to set
	 */
	public void setTxtPSSD(String txtPSSD) {
		this.txtPSSD = txtPSSD;
	}

	/**
	 * @return the txtPSSD
	 */
	public String getTxtPSSD() {
		return txtPSSD;
	}

	/**
	 * @param gsList
	 *            the gsList to set
	 */
	public void setGsList(ArrayList<Cz02000> gsList) {
		this.gsList = gsList;
	}

	/**
	 * @return the gsList
	 */
	public ArrayList<Cz02000> getGsList() {
		return gsList;
	}

	/**
	 * @return the txtPGJG
	 */
	public Double getTxtPGJG() {
		return txtPGJG;
	}

	/**
	 * @param txtPGJG
	 *            the txtPGJG to set
	 */
	public void setTxtPGJG(Double txtPGJG) {
		this.txtPGJG = txtPGJG;
	}

	/**
	 * @return the txtJZMJ
	 */
	public Double getTxtJZMJ() {
		return txtJZMJ;
	}

	/**
	 * @param txtJZMJ
	 *            the txtJZMJ to set
	 */
	public void setTxtJZMJ(Double txtJZMJ) {
		this.txtJZMJ = txtJZMJ;
	}

	/**
	 * @param txtXZXS
	 *            the txtXZXS to set
	 */
	public void setTxtXZXS(Double txtXZXS) {
		this.txtXZXS = txtXZXS;
	}

	/**
	 * @return the txtXZXS
	 */
	public Double getTxtXZXS() {
		return txtXZXS;
	}	

	/**
	 * @return the rows
	 */
	public ArrayList<Pgt02034> getRows() {
		return rows;
	}

	/**
	 * @param rows
	 *            the rows to set
	 */
	public void setRows(ArrayList<Pgt02034> rows) {
		this.rows = rows;
	}

	public Double getTxtPGXZ() {
		return txtPGXZ;
	}

	public void setTxtPGXZ(Double txtPGXZ) {
		this.txtPGXZ = txtPGXZ;
	}
}
