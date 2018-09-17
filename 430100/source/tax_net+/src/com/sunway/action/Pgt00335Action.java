/**
 * 
 */
package com.sunway.action;

import java.util.ArrayList;

import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00331Service;
import com.sunway.service.IPgt00331aService;
import com.sunway.service.IPgt00332cService;
import com.sunway.service.IPgt00333Service;
import com.sunway.service.IPgt00335Service;
import com.sunway.service.IPgt00335aService;
import com.sunway.service.IPgt00335cService;
import com.sunway.vo.Cz00300;
import com.sunway.vo.Pgt00331;
import com.sunway.vo.Pgt00331a;
import com.sunway.vo.Pgt00332c;
import com.sunway.vo.Pgt00333;
import com.sunway.vo.Pgt00334a;
import com.sunway.vo.Pgt00335;
import com.sunway.vo.Pgt00335a;
import com.sunway.vo.Pgt00335c;

/**
 * @author Andy.Gao
 *
 */
public class Pgt00335Action extends ActionSupport {
	private static final long serialVersionUID = -2985034897469575038L;
	private IPgt00335Service t00335Service;
	private IPgt00331Service t00331Service;
	private IPgt00333Service t00333Service;
	private IPgt00331aService t00331aService;
	private IPgt00332cService t00332cService;
	private IPgt00335aService t00335aService;
	private IPgt00335cService t00335cService;
	private ArrayList<Pgt00335> pgslList;
	private ArrayList<Cz00300> gsList;
	private ArrayList<Pgt00331a> dpgXzList;
	private ArrayList<Pgt00333> t00333List;
	private String txtFCID;
	private String txtPSSD;
	private Double txtPGJG;
	private Double txtJZMJ;
	private Double txtXZXS;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {

		try {
			pgslList = t00335Service.LoadAll(new Pgt00335(txtFCID, txtPSSD));
			readInfo();
		} catch (Exception e) {
			LOG.error("execute()", e);
			this.addActionError(e.getMessage());
			return INPUT;
		}
		return SUCCESS;
	}

	/**
	 * 进行公式整合
	 */
	protected void readInfo() throws Exception {
		gsList = new ArrayList<Cz00300>();
		Pgt00331 t00331 = new Pgt00331(txtFCID, txtPSSD);
		t00331 = t00331Service.LoadByPrimaryKey(t00331);
		// 取得待评估对象修正参数
		ArrayList<Pgt00332c> t00332cList = t00332cService.LoadAll(new Pgt00332c(txtFCID));
		for (Pgt00335 sl : pgslList) {
			Cz00300 e = new Cz00300();
			// 1.获得【原单价】
			e.setYpfmjg(sl.getYpfmjg());
			e.setWjxz(sl.getWjxz());
			// 2.获得【修正列表】
			// 组织列表
			ArrayList<Pgt00334a> xzList = new ArrayList<Pgt00334a>();
			// 组织列表
			ArrayList<Pgt00335c> t00335cList = t00335cService.LoadAll(new Pgt00335c(txtFCID, sl.getCdSlid()));
			for (Pgt00332c tmp332c : t00332cList) {
				Pgt00334a qtxz = new Pgt00334a();
				qtxz.setCd00053Qtxzid(tmp332c.getRootnm());
				for (Pgt00335c tmp335c : t00335cList) {
					if (tmp332c.getCd00001Rootid().equals(tmp335c.getCd00001Rootid())) {
						qtxz.setCzlx(tmp332c.getCzlx());
						switch (tmp332c.getCzlx()) {
						case 0:// 乘
							qtxz.setQtxzNm("(1 + " + tmp332c.getXzxs() + "/100 - " + tmp335c.getXzxs() + "/100)");
							break;
						case 1:// 加
							qtxz.setQtxzNm("( " + tmp332c.getXzxs() + " - " + tmp335c.getXzxs() + ")");
							break;
						default:
							break;
						}
						break;
					}
				}
				xzList.add(qtxz);
				qtxz = null;
			}
			e.setXzList(xzList);
			// 3.获得【其他修正列表】
			ArrayList<Pgt00335a> t00335aList = t00335aService
					.LoadAll(new Pgt00335a(sl.getCd00302Fcid(), sl.getCdSlid(), sl.getCd00002Pssd()));
			// 组织列表
			ArrayList<Pgt00334a> qtxzList = new ArrayList<Pgt00334a>();
			for (Pgt00335a bean : t00335aList) {
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
				qtxzList.add(qtxz);
				qtxz = null;
			}
			e.setQtxzList(qtxzList);
			// 4.获得【修正单价】
			e.setPfmjg(sl.getPfmjg());
			// 填入公式列表
			gsList.add(e);
		}
		txtPGJG = t00331.getGapgjg();
		txtJZMJ = t00331.getJzmj();
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
		// 读取个案评估的信息列表 00333
		ArrayList<Pgt00333> tmpList = t00333Service.LoadAll(new Pgt00333(txtFCID, txtPSSD));
		if (null != tmpList && tmpList.size() > 0) {
			t00333List = new ArrayList<Pgt00333>();
			for (Pgt00333 bean : tmpList) {
				Pgt00333 qtxz = new Pgt00333();
				qtxz.setQtxzid(bean.getQtxznm());
				qtxz.setCzlx(bean.getCzlx());
				switch (bean.getCzlx()) {
				case 0:// 乘
					qtxz.setQtxznm("(1 + " + bean.getXzxs() + "/100)");
					break;
				case 1:// 加
					qtxz.setQtxznm("(" + bean.getXzxs() + ")");
					break;
				default:
					break;
				}
				t00333List.add(qtxz);
				qtxz = null;
			}
		}
	}

	/** --------------------- set and get -------------------------- **/

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
	 * @return the t00335Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt00335Service getT00335Service() {
		return t00335Service;
	}

	/**
	 * @param t00335Service
	 *            the t00335Service to set
	 */
	public void setT00335Service(IPgt00335Service t00335Service) {
		this.t00335Service = t00335Service;
	}

	/**
	 * @return the t00331Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt00331Service getT00331Service() {
		return t00331Service;
	}

	/**
	 * @param t00331Service
	 *            the t00331Service to set
	 */
	public void setT00331Service(IPgt00331Service t00331Service) {
		this.t00331Service = t00331Service;
	}

	/**
	 * @return the t00335aService
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt00335aService getT00335aService() {
		return t00335aService;
	}

	/**
	 * @param t00335aService
	 *            the t00335aService to set
	 */
	public void setT00335aService(IPgt00335aService t00335aService) {
		this.t00335aService = t00335aService;
	}

	/**
	 * @return the pgslList
	 */
	public ArrayList<Pgt00335> getPgslList() {
		return pgslList;
	}

	/**
	 * @param pgslList
	 *            the pgslList to set
	 */
	public void setPgslList(ArrayList<Pgt00335> pgslList) {
		this.pgslList = pgslList;
	}

	/**
	 * @return the gsList
	 */
	public ArrayList<Cz00300> getGsList() {
		return gsList;
	}

	/**
	 * @param gsList
	 *            the gsList to set
	 */
	public void setGsList(ArrayList<Cz00300> gsList) {
		this.gsList = gsList;
	}

	/**
	 * @return the txtFCID
	 */
	public String getTxtFCID() {
		return txtFCID;
	}

	/**
	 * @param txtFCID
	 *            the txtFCID to set
	 */
	public void setTxtFCID(String txtFCID) {
		this.txtFCID = txtFCID;
	}

	/**
	 * @return the txtPSSD
	 */
	public String getTxtPSSD() {
		return txtPSSD;
	}

	/**
	 * @param txtPSSD
	 *            the txtPSSD to set
	 */
	public void setTxtPSSD(String txtPSSD) {
		this.txtPSSD = txtPSSD;
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
	 * @return the txtXZXS
	 */
	public Double getTxtXZXS() {
		return txtXZXS;
	}

	/**
	 * @param txtXZXS
	 *            the txtXZXS to set
	 */
	public void setTxtXZXS(Double txtXZXS) {
		this.txtXZXS = txtXZXS;
	}

	/**
	 * @return the t00331cService
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt00332cService getT00332cService() {
		return t00332cService;
	}

	/**
	 * @param t00331cService
	 *            the t00331cService to set
	 */
	public void setT00332cService(IPgt00332cService t00332cService) {
		this.t00332cService = t00332cService;
	}

	/**
	 * @return the t00335cService
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt00335cService getT00335cService() {
		return t00335cService;
	}

	/**
	 * @param t00335cService
	 *            the t00335cService to set
	 */
	public void setT00335cService(IPgt00335cService t00335cService) {
		this.t00335cService = t00335cService;
	}

	/**
	 * @return the dpgXzList
	 */
	public ArrayList<Pgt00331a> getDpgXzList() {
		return dpgXzList;
	}

	/**
	 * @param dpgXzList
	 *            the dpgXzList to set
	 */
	public void setDpgXzList(ArrayList<Pgt00331a> dpgXzList) {
		this.dpgXzList = dpgXzList;
	}

	/**
	 * @param t00333Service
	 *            the t00333Service to set
	 */
	public void setT00333Service(IPgt00333Service t00333Service) {
		this.t00333Service = t00333Service;
	}

	/**
	 * @return the t00333Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt00333Service getT00333Service() {
		return t00333Service;
	}

	/**
	 * @param t00333List
	 *            the t00333List to set
	 */
	public void setT00333List(ArrayList<Pgt00333> t00333List) {
		this.t00333List = t00333List;
	}

	/**
	 * @return the t00333List
	 */
	public ArrayList<Pgt00333> getT00333List() {
		return t00333List;
	}

}
