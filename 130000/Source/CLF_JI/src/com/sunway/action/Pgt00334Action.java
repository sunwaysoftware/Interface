/**
 *
 */
package com.sunway.action;

import java.util.ArrayList;

import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00331Service;
import com.sunway.service.IPgt00331aService;
import com.sunway.service.IPgt00331cService;
import com.sunway.service.IPgt00334Service;
import com.sunway.service.IPgt00334aService;
import com.sunway.service.IPgt00334cService;
import com.sunway.util.Common;
import com.sunway.vo.Cz00300;
import com.sunway.vo.Pgt00331;
import com.sunway.vo.Pgt00331a;
import com.sunway.vo.Pgt00331c;
import com.sunway.vo.Pgt00334;
import com.sunway.vo.Pgt00334a;
import com.sunway.vo.Pgt00334c;

/**
 *
 * 市场法参与评税的实例库
 * 
 * @author Andy.Gao
 *
 */
public class Pgt00334Action extends ActionSupport {
	private static final long serialVersionUID = 4650950576013918171L;
	private IPgt00334Service t00334Service;
	private IPgt00331Service t00331Service;
	private IPgt00331aService t00331aService;
	private IPgt00331cService t00331cService;
	private IPgt00334aService t00334aService;
	private IPgt00334cService t00334cService;
	private ArrayList<Pgt00334> tabList;
	private ArrayList<Cz00300> gsList;
	private ArrayList<Pgt00331a> dpgXzList;
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
			tabList = t00334Service.LoadAll(new Pgt00334(txtFCID, txtPSSD));
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
			tabList = t00334Service.LoadAll_B(new Pgt00334(txtFCID, txtPSSD));
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
		gsList = new ArrayList<Cz00300>();
		Pgt00331 t00331 = new Pgt00331(txtFCID, txtPSSD);
		t00331 = t00331Service.LoadByPrimaryKey_B(t00331);
		// 取得待评估对象修正参数
		ArrayList<Pgt00331c> t00331cList = t00331cService.LoadAll_B(new Pgt00331c(txtFCID));
		for (Pgt00334 sl : tabList) {
			Cz00300 e = new Cz00300();
			// 1.获得【原单价】
			e.setYpfmjg(sl.getYpfmjg());
			e.setWjxz(sl.getWjxz());
			// 2.获得【修正列表】
			ArrayList<Pgt00334a> xzList = new ArrayList<Pgt00334a>();
			// 组织列表
			ArrayList<Pgt00334c> t00334cList = t00334cService.LoadAll_B(new Pgt00334c(txtFCID, sl.getCdSlid()));
			for (Pgt00331c tmp331c : t00331cList) {
				Pgt00334a qtxz = new Pgt00334a();
				qtxz.setCd00053Qtxzid(tmp331c.getRootnm());
				for (Pgt00334c tmp334c : t00334cList) {
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
				if (Common.isNullOrEmpty(qtxz.getQtxzNm())) {
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
			// ArrayList<Pgt00334a> t00334aList = t00334aService.LoadAll(new
			// Pgt00334a(sl.getCd00302Fcid(), sl.getCdSlid(),
			// sl.getCd00002Pssd()));
			// 组织列表
			// ArrayList<Pgt00334a> qtxzList = new ArrayList<Pgt00334a>();
			// for(Pgt00334a bean : t00334aList){
			// Pgt00334a qtxz = new Pgt00334a();
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
			// if(!Common.isNullOrEmpty(qtxz.getQtxzNm()))
			// qtxzList.add(qtxz);
			// qtxz = null;
			// }
			// e.setQtxzList(qtxzList);
			// 4.获得【修正单价】
			e.setPfmjg(sl.getPfmjg());
			// 填入公式列表
			gsList.add(e);
		}
		txtPGJG = t00331.getPgjg();
		txtJZMJ = t00331.getJzmj();
		txtPGXZ = t00331.getPgxz();
		txtXZXS = t00331.getGaxzxs();
		// 读取待評估對象修正列表
		/*
		 * ArrayList<Pgt00331a> t00331aList = t00331aService.LoadAll(new
		 * Pgt00331a(txtFCID)); if(null!=t00331aList && t00331aList.size()>0)
		 * dpgXzList = new ArrayList<Pgt00331a>(); for(Pgt00331a bean :
		 * t00331aList){ Pgt00331a qtxz = new Pgt00331a();
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
		gsList = new ArrayList<Cz00300>();
		Pgt00331 t00331 = new Pgt00331(txtFCID, txtPSSD);
		t00331 = t00331Service.LoadByPrimaryKey(t00331);
		// 取得待评估对象修正参数
		ArrayList<Pgt00331c> t00331cList = t00331cService.LoadAll(new Pgt00331c(txtFCID));
		for (Pgt00334 sl : tabList) {
			Cz00300 e = new Cz00300();
			// 1.获得【原单价】
			e.setYpfmjg(sl.getYpfmjg());
			e.setWjxz(sl.getWjxz());
			// 2.获得【修正列表】
			ArrayList<Pgt00334a> xzList = new ArrayList<Pgt00334a>();
			// 组织列表
			ArrayList<Pgt00334c> t00334cList = t00334cService.LoadAll(new Pgt00334c(txtFCID, sl.getCdSlid()));
			for (Pgt00331c tmp331c : t00331cList) {
				Pgt00334a qtxz = new Pgt00334a();
				qtxz.setCd00053Qtxzid(tmp331c.getRootnm());
				for (Pgt00334c tmp334c : t00334cList) {
					if (tmp331c.getCd00001Rootid().equals(tmp334c.getCd00001Rootid())) {
						qtxz.setCzlx(tmp331c.getCzlx());
						switch (tmp331c.getCzlx()) {
						case 0:// 乘
							qtxz.setQtxzNm("(1 + " + tmp331c.getXzxs() + "/100 - " + tmp334c.getXzxs() + "/100)");
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
				if (Common.isNullOrEmpty(qtxz.getQtxzNm())) {
					qtxz.setCzlx(tmp331c.getCzlx());
					switch (tmp331c.getCzlx()) {
					case 0:// 乘
						qtxz.setQtxzNm("(1 + " + tmp331c.getXzxs() + "/100 - " + "0" + "/100)");
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
			// 3.获得【其他修正列表】
			ArrayList<Pgt00334a> t00334aList = t00334aService
					.LoadAll(new Pgt00334a(sl.getCd00302Fcid(), sl.getCdSlid(), sl.getCd00002Pssd()));
			// 组织列表
			ArrayList<Pgt00334a> qtxzList = new ArrayList<Pgt00334a>();
			for (Pgt00334a bean : t00334aList) {
				Pgt00334a qtxz = new Pgt00334a();
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
				if (!Common.isNullOrEmpty(qtxz.getQtxzNm()))
					qtxzList.add(qtxz);
				qtxz = null;
			}
			e.setQtxzList(qtxzList);
			// 4.获得【修正单价】
			e.setPfmjg(sl.getPfmjg());
			// 填入公式列表
			gsList.add(e);
		}
		txtPGJG = t00331.getPgjg();
		txtJZMJ = t00331.getJzmj();
		txtPGXZ = t00331.getPgxz();
		txtXZXS = t00331.getGaxzxs();
		// 读取待評估對象修正列表
		ArrayList<Pgt00331a> t00331aList = t00331aService.LoadAll(new Pgt00331a(txtFCID));
		if (null != t00331aList && t00331aList.size() > 0) {
			dpgXzList = new ArrayList<Pgt00331a>();
			for (Pgt00331a bean : t00331aList) {
				Pgt00331a qtxz = new Pgt00331a();
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
		}
	}

	/*************************
	 * set and get
	 **************************************/

	/**
	 * @param t00334Service
	 *            the t00334Service to set
	 */
	public void setT00334Service(IPgt00334Service t00334Service) {
		this.t00334Service = t00334Service;
	}

	/**
	 * @return the t00334Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt00334Service getT00334Service() {
		return t00334Service;
	}

	/**
	 * @param t00334aService
	 *            the t00334aService to set
	 */
	public void setT00334aService(IPgt00334aService t00334aService) {
		this.t00334aService = t00334aService;
	}

	/**
	 * @return the t00334aService
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt00334aService getT00334aService() {
		return t00334aService;
	}

	/**
	 * @param t00331cService
	 *            the t00331cService to set
	 */
	public void setT00331cService(IPgt00331cService t00331cService) {
		this.t00331cService = t00331cService;
	}

	/**
	 * @return the t00331cService
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt00331cService getT00331cService() {
		return t00331cService;
	}

	/**
	 * @param t00331Service
	 *            the t00331Service to set
	 */
	public void setT00331Service(IPgt00331Service t00331Service) {
		this.t00331Service = t00331Service;
	}

	/**
	 * @return the t00331Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt00331Service getT00331Service() {
		return t00331Service;
	}

	/**
	 * @param t00334cService
	 *            the t00334cService to set
	 */
	public void setT00334cService(IPgt00334cService t00334cService) {
		this.t00334cService = t00334cService;
	}

	/**
	 * @return the t00334cService
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt00334cService getT00334cService() {
		return t00334cService;
	}

	/**
	 * @param t00331aService
	 *            the t00331aService to set
	 */
	public void setT00331aService(IPgt00331aService t00331aService) {
		this.t00331aService = t00331aService;
	}

	/**
	 * @return the t00331aService
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt00331aService getT00331aService() {
		return t00331aService;
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
	public void setGsList(ArrayList<Cz00300> gsList) {
		this.gsList = gsList;
	}

	/**
	 * @return the gsList
	 */
	public ArrayList<Cz00300> getGsList() {
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
	 * @param dpgXzList
	 *            the dpgXzList to set
	 */
	public void setDpgXzList(ArrayList<Pgt00331a> dpgXzList) {
		this.dpgXzList = dpgXzList;
	}

	/**
	 * @return the dpgXzList
	 */
	public ArrayList<Pgt00331a> getDpgXzList() {
		return dpgXzList;
	}

	/**
	 * @return the tabList
	 */
	public ArrayList<Pgt00334> getTabList() {
		return tabList;
	}

	/**
	 * @param tabList
	 *            the tabList to set
	 */
	public void setTabList(ArrayList<Pgt00334> tabList) {
		this.tabList = tabList;
	}

	public Double getTxtPGXZ() {
		return txtPGXZ;
	}

	public void setTxtPGXZ(Double txtPGXZ) {
		this.txtPGXZ = txtPGXZ;
	}
}
