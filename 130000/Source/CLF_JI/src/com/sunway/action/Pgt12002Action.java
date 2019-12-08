/**
 * 
 */
package com.sunway.action;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt12001Service;
import com.sunway.service.IPgt12002Service;
import com.sunway.service.IPgt12002bService;
import com.sunway.service.IPgt12002eService;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt12001;
import com.sunway.vo.Pgt12002;
import com.sunway.vo.Pgt12002b;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv12002;
import com.sunway.vo.Pgv12002e;

/**
 * 
 * 成本、收益法地產信息
 * @category 数据采集
 * @author Andy.Gao
 * @version 1.0
 *
 */
public class Pgt12002Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 7501968951939010330L;
	private IPgt12001Service t12001Service;
	private IPgt12002Service t12002Service;
	private IPgt12002eService t12002eService;
	private IPgt12002bService t12002bService;
	private String ACT;
	
	// VIEW
	private Pgv12002 v12002Bean;
	private Integer pageIndex;
	private Integer pageCount;
	private Integer rowCount;
	private ArrayList<Pgv12002> tabList;
	private String txtSWIDFind;
	private String txtNSRMCFind;
	private String txtDCIDFind;
	
	// EDIT
	private Pgt12002 t12002Bean;
	private String txtDCID;
	private String txtUPDATE;
	private String txtSWID;
	private String txtNSRMC;
	private String txtTDSYQBM;
	private String txtTDYTId;
	private String txtSYQLXId;
	private String txtSYQMJ;
	private String txtTDSYQLXId;
	private String txtTDDJId;
	private String txtSZQY;
	private String txtTDZL;
	private String txtGBRJL;
	private String txtYSMJ;
	private String txtMSMJ;
	private String txtTDPFMSE;
	private String txtSYKSSJ;
	private String txtSYJSSJ;
	private String txtNOTE;
	private String txtCZRZJH;
	private String txtCZRMC;
	private String chkSFNSR;
	private String txtCZKSSJ;
	private String txtCZJSSJ;
	private String txtCZNOTE;
	private String PIC;
	private ArrayList<Pgv12002e> qtxzList;
	private ArrayList<Pgv00052> szqyList;
	private String XZLX;
	private String hidQTXZ;
	//AJAX
	private InputStream szqyId;
	// Detail
	private String DCID;
	private String SWID;
	private Pgt12002b t12002bBean;
	// 跳轉地產標識
	private Boolean forward;
	private ArrayList<String> dataList;
	private Integer txtCOUNT;
	// 變更日期
	private String txtBGSJ;
	private String ddlBGLX;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	/**
	 * 查询状态处理
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}

		Pgv12002 v12002 = new Pgv12002();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准備查詢條件
			v12002.setCd12001Swid(Common.getSearchLike(Common.convertEncoding(txtSWIDFind)));
			v12002.setNsrmc(Common.getSearchLike(Common.convertEncoding(txtNSRMCFind)));
			v12002.setDcid(Common.convertEncoding(txtDCIDFind));
			v12002.setPageIndex(pageIndex);
			v12002.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			v12002.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v12002.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			v12002Bean = t12002Service.LoadAll(v12002);
			tabList = v12002Bean.getV12002List();
			//分页设置
			if(null!=tabList && tabList.size()>0){
				rowCount = Common.checkNull(tabList.get(0).getRecordCount());
				pageCount = Common.getPageCount(rowCount, sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE));
			} else {
				pageCount = 1;
				pageIndex = 1;
			}
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 新增状态处理
	 * @return
	 * @throws Exception
	 */
	public String create() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** start **********");
		}
		
		Pgt12002 t12002 = new Pgt12002();
		try {
			if(!Constant.MOD_CREATE.equals(ACT)){
				//读取选中的数据信息
				t12002.setDcid(txtDCIDFind);
				t12002Bean = t12002Service.LoadByPrimaryKey(t12002);
				Pgv12002e v12002e = new Pgv12002e();
				v12002e.setCd12002Dcid(t12002Bean.getDcid());
				qtxzList = t12002eService.LoadAll(v12002e);
			}else{
				if(!Common.isNullOrEmpty(txtSWID)){
					txtSWID = Common.convertEncoding(txtSWID);
					Pgt12001 t12001 = t12001Service.LoadByPrimaryKey(new Pgt12001(txtSWID)); 
					if(null!=t12001){
						txtSWID = t12001.getSwid();
						txtNSRMC = t12001.getNsrmc();
						txtCOUNT = t12001.getCountDC();
					}
				}
			}
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return INPUT;
		} finally {
			readInfo();
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** end **********");
		}
		if (Common.isNullOrEmpty(t12002.getDcid()))
			return "successAdd";
		else
			return SUCCESS;
	}
	
	/**
	 * 更新操作前的驗證處理
	 * @throws Exception
	 */
	public void validateUpdate() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("validateUpdate() ********** start **********");
		}
		
		this.clearErrorsAndMessages();
		t12002Bean = new Pgt12002();
		t12002Bean.setDcid(txtDCID);
		//根據PK取得信息，並為數據BEAN賦值
		if(!Constant.MOD_DELETE.equals(ACT)){
			t12002Bean = t12002Service.LoadByPrimaryKey(t12002Bean);
			if(null==t12002Bean) t12002Bean = new Pgt12002();
		}
		//判断PK是否重复
		if((Constant.MOD_CREATE.equals(ACT))&&(!Common.isNullOrEmpty(t12002Bean.getDcid()))){
			this.addActionError(getText("app.msg.error.pk", new String[]{getText("app.sjcj.t12002.dcid")}));
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(getACT()))&&(!t12002Bean.getUpddate().equals(Common.convertStringToTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			t12002Bean.setCd00001Syqlx(txtSYQLXId);
			t12002Bean.setCd00001Szqy(txtSZQY);
			t12002Bean.setCd00001Tddj(txtTDDJId);
			t12002Bean.setCd00001Tdsyqlx(txtTDSYQLXId);
			t12002Bean.setCd00001Tdyt(txtTDYTId);
			t12002Bean.setCd00002Czr(sessionCtrl.getUserId());
			t12002Bean.setCd12001Swid(txtSWID);
			t12002Bean.setCd12006Czrzjh(txtCZRZJH);
			t12002Bean.setCzjssj(Common.convertToDate(txtCZJSSJ));
			t12002Bean.setCzkssj(Common.convertToDate(txtCZKSSJ));
			t12002Bean.setCzNote(txtCZNOTE);
			t12002Bean.setDcid(txtDCID);
			t12002Bean.setGbrjl(Common.convertToDouble(txtGBRJL));
			t12002Bean.setMsmj(Common.convertToDouble(txtMSMJ));
			t12002Bean.setNote(txtNOTE);
			t12002Bean.setSfnsr(Common.convertToBoolean(chkSFNSR));
			t12002Bean.setSyjssj(Common.convertToDate(txtSYJSSJ));
			t12002Bean.setSykssj(Common.convertToDate(txtSYKSSJ));
			t12002Bean.setSyqmj(Common.convertToDouble(txtSYQMJ));
			t12002Bean.setTdpfmse(Common.convertToDouble(txtTDPFMSE));
			t12002Bean.setTdsyqbm(txtTDSYQBM);
			t12002Bean.setTdzl(txtTDZL);
			t12002Bean.setYsmj(Common.convertToDouble(txtYSMJ));
			t12002Bean.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			t12002Bean.setCd00053QtxzId(hidQTXZ);
			t12002Bean.setX(0.0);
			t12002Bean.setY(0.0);
			t12002Bean.setCzrmc(txtCZRMC);
			t12002Bean.setBgsj(Common.convertToDate(txtBGSJ));
			t12002Bean.setBglx(Common.convertToInteger(ddlBGLX));
		}
		if(this.hasErrors())
			forward = false;
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("validateUpdate() ********** end **********");
		}
	}
	
	/**
	 * 更新信息處理
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** start **********");
		}

		try {
			if(Constant.MOD_CREATE.equals(getACT())){			// Create
				txtDCID = t12002Service.LoadMaxDcId();
				t12002Bean.setDcid(txtDCID);			
				if(t12002Service.GetInsertCommand(t12002Bean)){
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{t12002Bean.getDcid()}));
					if(Common.checkNull(forward)) DCID = t12002Bean.getDcid();
					t12002Bean.clear();
				}else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{t12002Bean.getDcid()}));
			} else if (Constant.MOD_UPDATE.equals(getACT())) {	// Update
				if(t12002Service.GetUpdateCommand(t12002Bean)){
					t12002Bean = t12002Service.LoadByPrimaryKey(t12002Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{t12002Bean.getDcid()}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{t12002Bean.getDcid()}));
			} else if (Constant.MOD_DELETE.equals(getACT())) {	// Delete
				if(t12002Service.GetDeleteCommand(t12002Bean)){
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{t12002Bean.getDcid()}));
				}else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{t12002Bean.getDcid()}));
			}			
		} catch (Exception e) {
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("update() ********** end **********");
			}
			forward = false;
			return INPUT;
		} finally {
			readInfo();
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** end **********");
		}
		
		if(Common.isNullOrEmpty(PIC))
			if (Constant.MOD_DELETE.equals(ACT)){
				ACT = Constant.MOD_MODIFY;
				return "successDEL";
			}else if(Constant.MOD_CREATE.equals(ACT))
				return "successADD";
			else
				return SUCCESS;
		else
			return "successPic";
	}
	
	/**
	 * 根據DCID讀取SZQY(AJAX用)
	 * @return
	 * @throws Exception
	 */
	public String readSzqyByDcid() throws Exception {
		Pgt12002 t12002 = new Pgt12002();
		t12002.setDcid(txtDCIDFind);
		t12002 = t12002Service.LoadByPrimaryKey(t12002);
		if(null!=t12002) {
			StringBuffer strBuf = new StringBuffer();
			strBuf.append(t12002.getCd00001Szqy());
			szqyId = Common.exportTEXT(strBuf);
		}
		return SUCCESS;
	}

	/**
	 * 成本、收益法地产详细信息
	 * @return
	 * @throws Exception
	 */
	public String detail() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** start **********");
		}

		Pgv12002 v12002 = new Pgv12002();
		v12002Bean = new Pgv12002();
		Pgt12002b t12002b = new Pgt12002b();
		t12002bBean = new Pgt12002b();
		Pgv12002e v12002e = new Pgv12002e();
		qtxzList = new ArrayList<Pgv12002e>();
		try {
			// 准备查询条件
			v12002.setDcid(Common.convertEncoding(Common.trim(DCID)));
			t12002b.setCd12002Dcid(Common.convertEncoding(Common.trim(DCID)));
			v12002e.setCd12002Dcid(Common.convertEncoding(Common.trim(DCID)));
			// 执行查询
			v12002Bean = t12002Service.LoadDetail(v12002);
			t12002bBean = t12002bService.LoadByPrimaryKey(t12002b);
			qtxzList = t12002eService.LoadAll(v12002e);
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 读取所在区域
	 */
	protected void readInfo() {
		//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
		szqyList = sessionCtrl.ReadSzqyList();
	}

	/**
	 * 成本、收益法地产详细信息（框架）
	 * @return
	 * @throws Exception
	 */
	public String detailFrame() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("detailFrame() ********** start **********");
		}
		v12002Bean = new Pgv12002();
		try {
			v12002Bean.setDcid(Common.trim(DCID));
			v12002Bean.setCd12001Swid(Common.trim(SWID));
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("detailFrame() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 土地座落自動提示
	 * @return
	 * @throws Exception
	 */
	public String queryTDZL() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("queryTDZL() ********** start **********");
		}
		
		Pgv12002 v12002 = new Pgv12002();
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			txtTDZL = Common.convertEncoding(request.getParameter("q"));
			if(!Common.isNullOrEmpty(txtSZQY)){
				//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
				v12002.setPageIndex(1);
				v12002.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
				v12002.setCd00001Szqy(txtSZQY);
				v12002.setCd00001Tdyt(txtTDYTId);
				v12002.setTdzl(Common.getSearchLike(txtTDZL));
				dataList = t12002Service.LoadTDZL(v12002);
			}
		} catch (Exception e) {
			LOG.error("queryTDZL()", e);
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("queryTDZL() ********** end **********");
		}
		return SUCCESS;	
	}
		
	/**
	 * 根据土地座落地址得到土地等级
	 * @return
	 * @throws Exception
	 */
	public String queryTDDJ() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("queryTDDJ() ********** start **********");
		}

		Pgv12002 v12002 = new Pgv12002();
		try {
			v12002.setTdzl(Common.convertEncoding(txtTDZL));
			v12002.setCd00001Tdyt(Common.convertEncoding(txtTDYTId));
			v12002.setCd00001Szqy(Common.convertEncoding(txtSZQY));
			v12002Bean = t12002Service.LoadTDDJ(v12002);
		} catch (Exception e) {
			LOG.error("queryTDDJ()", e);
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("queryTDDJ() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 判断土地使用权证书号是否已经存在
	 * @return
	 * @throws Exception
	 */
	public String queryTDSYQBM() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("queryTDSYQBM() ********** start **********");
		}

		try {
			forward = t12002Service.GetTdsyqbmByDcid(new Pgt12002(Common.convertEncoding(txtDCID),Common.convertEncoding(txtTDSYQBM)));
		} catch (Exception e) {
			LOG.error("queryTDSYQBM()", e);
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("queryTDSYQBM() ********** end **********");
		}
		return SUCCESS;
	}
	
	/*********************** set and get ******************************/
	
	/**
	 * @param t12002Service the t12002Service to set
	 */
	public void setT12002Service(IPgt12002Service t12002Service) {
		this.t12002Service = t12002Service;
	}

	/**
	 * @return the t12002Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt12002Service getT12002Service() {
		return t12002Service;
	}
	
	/**
	 * @param t12002eService the t12002eService to set
	 */
	public void setT12002eService(IPgt12002eService t12002eService) {
		this.t12002eService = t12002eService;
	}

	/**
	 * @return the t12002eService
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt12002eService getT12002eService() {
		return t12002eService;
	}
	
	/**
	 * @param t12001Service the t12001Service to set
	 */
	public void setT12001Service(IPgt12001Service t12001Service) {
		this.t12001Service = t12001Service;
	}

	/**
	 * @return the t12001Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt12001Service getT12001Service() {
		return t12001Service;
	}
	
	/**
	 * @return the t12002bService
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt12002bService getT12002bService() {
		return t12002bService;
	}

	/**
	 * @param t12002bService the t12002bService to set
	 */
	public void setT12002bService(IPgt12002bService t12002bService) {
		this.t12002bService = t12002bService;
	}

	/**
	 * @param aCT the aCT to set
	 */
	public void setACT(String aCT) {
		ACT = aCT;
	}

	/**
	 * @return the aCT
	 */
	public String getACT() {
		return ACT;
	}

	/**
	 * @return the v12002Bean
	 */
	public Pgv12002 getV12002Bean() {
		return v12002Bean;
	}

	/**
	 * @param v12002Bean the v12002Bean to set
	 */
	public void setV12002Bean(Pgv12002 v12002Bean) {
		this.v12002Bean = v12002Bean;
	}

	/**
	 * @return the pageIndex
	 */
	public Integer getPageIndex() {
		return pageIndex;
	}

	/**
	 * @param pageIndex the pageIndex to set
	 */
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	/**
	 * @return the pageCount
	 */
	public Integer getPageCount() {
		return pageCount;
	}

	/**
	 * @param pageCount the pageCount to set
	 */
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	/**
	 * @return the rowCount
	 */
	public Integer getRowCount() {
		return rowCount;
	}

	/**
	 * @param rowCount the rowCount to set
	 */
	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}

	/**
	 * @return the tabList
	 */
	public ArrayList<Pgv12002> getTabList() {
		return tabList;
	}

	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv12002> tabList) {
		this.tabList = tabList;
	}

	/**
	 * @return the txtSWIDFind
	 */
	public String getTxtSWIDFind() {
		return txtSWIDFind;
	}

	/**
	 * @param txtSWIDFind the txtSWIDFind to set
	 */
	public void setTxtSWIDFind(String txtSWIDFind) {
		this.txtSWIDFind = txtSWIDFind;
	}

	/**
	 * @return the txtNSRMCFind
	 */
	public String getTxtNSRMCFind() {
		return txtNSRMCFind;
	}

	/**
	 * @param txtNSRMCFind the txtNSRMCFind to set
	 */
	public void setTxtNSRMCFind(String txtNSRMCFind) {
		this.txtNSRMCFind = txtNSRMCFind;
	}

	/**
	 * @return the txtDCIDFind
	 */
	public String getTxtDCIDFind() {
		return txtDCIDFind;
	}

	/**
	 * @param txtDCIDFind the txtDCIDFind to set
	 */
	public void setTxtDCIDFind(String txtDCIDFind) {
		this.txtDCIDFind = txtDCIDFind;
	}

	/**
	 * @return the t12002Bean
	 */
	public Pgt12002 getT12002Bean() {
		return t12002Bean;
	}

	/**
	 * @param t12002Bean the t12002Bean to set
	 */
	public void setT12002Bean(Pgt12002 t12002Bean) {
		this.t12002Bean = t12002Bean;
	}

	/**
	 * @return the txtDCID
	 */
	public String getTxtDCID() {
		return txtDCID;
	}

	/**
	 * @param txtDCID the txtDCID to set
	 */
	public void setTxtDCID(String txtDCID) {
		this.txtDCID = txtDCID;
	}

	/**
	 * @return the txtUPDATE
	 */
	public String getTxtUPDATE() {
		return txtUPDATE;
	}

	/**
	 * @param txtUPDATE the txtUPDATE to set
	 */
	public void setTxtUPDATE(String txtUPDATE) {
		this.txtUPDATE = txtUPDATE;
	}

	/**
	 * @return the txtSWID
	 */
	public String getTxtSWID() {
		return txtSWID;
	}

	/**
	 * @param txtSWID the txtSWID to set
	 */
	public void setTxtSWID(String txtSWID) {
		this.txtSWID = txtSWID;
	}

	/**
	 * @return the txtNSRMC
	 */
	public String getTxtNSRMC() {
		return txtNSRMC;
	}

	/**
	 * @param txtNSRMC the txtNSRMC to set
	 */
	public void setTxtNSRMC(String txtNSRMC) {
		this.txtNSRMC = txtNSRMC;
	}

	/**
	 * @return the txtTDSYQBM
	 */
	public String getTxtTDSYQBM() {
		return txtTDSYQBM;
	}

	/**
	 * @param txtTDSYQBM the txtTDSYQBM to set
	 */
	public void setTxtTDSYQBM(String txtTDSYQBM) {
		this.txtTDSYQBM = txtTDSYQBM;
	}

	/**
	 * @return the txtTDYTId
	 */
	public String getTxtTDYTId() {
		return txtTDYTId;
	}

	/**
	 * @param txtTDYTId the txtTDYTId to set
	 */
	public void setTxtTDYTId(String txtTDYTId) {
		this.txtTDYTId = txtTDYTId;
	}

	/**
	 * @return the txtSYQLXId
	 */
	public String getTxtSYQLXId() {
		return txtSYQLXId;
	}

	/**
	 * @param txtSYQLXId the txtSYQLXId to set
	 */
	public void setTxtSYQLXId(String txtSYQLXId) {
		this.txtSYQLXId = txtSYQLXId;
	}

	/**
	 * @return the txtSYQMJ
	 */
	public String getTxtSYQMJ() {
		return txtSYQMJ;
	}

	/**
	 * @param txtSYQMJ the txtSYQMJ to set
	 */
	public void setTxtSYQMJ(String txtSYQMJ) {
		this.txtSYQMJ = txtSYQMJ;
	}

	/**
	 * @return the txtTDSYQLXId
	 */
	public String getTxtTDSYQLXId() {
		return txtTDSYQLXId;
	}

	/**
	 * @param txtTDSYQLXId the txtTDSYQLXId to set
	 */
	public void setTxtTDSYQLXId(String txtTDSYQLXId) {
		this.txtTDSYQLXId = txtTDSYQLXId;
	}

	/**
	 * @return the txtTDDJId
	 */
	public String getTxtTDDJId() {
		return txtTDDJId;
	}

	/**
	 * @param txtTDDJId the txtTDDJId to set
	 */
	public void setTxtTDDJId(String txtTDDJId) {
		this.txtTDDJId = txtTDDJId;
	}

	/**
	 * @return the txtSZQY
	 */
	public String getTxtSZQY() {
		return txtSZQY;
	}

	/**
	 * @param txtSZQY the txtSZQY to set
	 */
	public void setTxtSZQY(String txtSZQY) {
		this.txtSZQY = txtSZQY;
	}

	/**
	 * @return the txtTDZL
	 */
	public String getTxtTDZL() {
		return txtTDZL;
	}

	/**
	 * @param txtTDZL the txtTDZL to set
	 */
	public void setTxtTDZL(String txtTDZL) {
		this.txtTDZL = txtTDZL;
	}

	/**
	 * @return the txtGBRJL
	 */
	public String getTxtGBRJL() {
		return txtGBRJL;
	}

	/**
	 * @param txtGBRJL the txtGBRJL to set
	 */
	public void setTxtGBRJL(String txtGBRJL) {
		this.txtGBRJL = txtGBRJL;
	}

	/**
	 * @return the txtYSMJ
	 */
	public String getTxtYSMJ() {
		return txtYSMJ;
	}

	/**
	 * @param txtYSMJ the txtYSMJ to set
	 */
	public void setTxtYSMJ(String txtYSMJ) {
		this.txtYSMJ = txtYSMJ;
	}

	/**
	 * @return the txtMSMJ
	 */
	public String getTxtMSMJ() {
		return txtMSMJ;
	}

	/**
	 * @param txtMSMJ the txtMSMJ to set
	 */
	public void setTxtMSMJ(String txtMSMJ) {
		this.txtMSMJ = txtMSMJ;
	}

	/**
	 * @return the txtTDPFMSE
	 */
	public String getTxtTDPFMSE() {
		return txtTDPFMSE;
	}

	/**
	 * @param txtTDPFMSE the txtTDPFMSE to set
	 */
	public void setTxtTDPFMSE(String txtTDPFMSE) {
		this.txtTDPFMSE = txtTDPFMSE;
	}

	/**
	 * @return the txtSYKSSJ
	 */
	public String getTxtSYKSSJ() {
		return txtSYKSSJ;
	}

	/**
	 * @param txtSYKSSJ the txtSYKSSJ to set
	 */
	public void setTxtSYKSSJ(String txtSYKSSJ) {
		this.txtSYKSSJ = txtSYKSSJ;
	}

	/**
	 * @return the txtSYJSSJ
	 */
	public String getTxtSYJSSJ() {
		return txtSYJSSJ;
	}

	/**
	 * @param txtSYJSSJ the txtSYJSSJ to set
	 */
	public void setTxtSYJSSJ(String txtSYJSSJ) {
		this.txtSYJSSJ = txtSYJSSJ;
	}

	/**
	 * @return the txtNOTE
	 */
	public String getTxtNOTE() {
		return txtNOTE;
	}

	/**
	 * @param txtNOTE the txtNOTE to set
	 */
	public void setTxtNOTE(String txtNOTE) {
		this.txtNOTE = txtNOTE;
	}

	/**
	 * @return the txtCZRZJH
	 */
	public String getTxtCZRZJH() {
		return txtCZRZJH;
	}

	/**
	 * @param txtCZRZJH the txtCZRZJH to set
	 */
	public void setTxtCZRZJH(String txtCZRZJH) {
		this.txtCZRZJH = txtCZRZJH;
	}

	/**
	 * @return the chkSFNSR
	 */
	public String getChkSFNSR() {
		return chkSFNSR;
	}

	/**
	 * @param chkSFNSR the chkSFNSR to set
	 */
	public void setChkSFNSR(String chkSFNSR) {
		this.chkSFNSR = chkSFNSR;
	}

	/**
	 * @return the txtCZKSSJ
	 */
	public String getTxtCZKSSJ() {
		return txtCZKSSJ;
	}

	/**
	 * @param txtCZKSSJ the txtCZKSSJ to set
	 */
	public void setTxtCZKSSJ(String txtCZKSSJ) {
		this.txtCZKSSJ = txtCZKSSJ;
	}

	/**
	 * @return the txtCZJSSJ
	 */
	public String getTxtCZJSSJ() {
		return txtCZJSSJ;
	}

	/**
	 * @param txtCZJSSJ the txtCZJSSJ to set
	 */
	public void setTxtCZJSSJ(String txtCZJSSJ) {
		this.txtCZJSSJ = txtCZJSSJ;
	}

	/**
	 * @return the txtCZNOTE
	 */
	public String getTxtCZNOTE() {
		return txtCZNOTE;
	}

	/**
	 * @param txtCZNOTE the txtCZNOTE to set
	 */
	public void setTxtCZNOTE(String txtCZNOTE) {
		this.txtCZNOTE = txtCZNOTE;
	}

	/**
	 * @param pIC the pIC to set
	 */
	public void setPIC(String pIC) {
		PIC = pIC;
	}

	/**
	 * @return the pIC
	 */
	public String getPIC() {
		return PIC;
	}

	/**
	 * @param xZLX the xZLX to set
	 */
	public void setXZLX(String xZLX) {
		XZLX = xZLX;
	}

	/**
	 * @return the xZLX
	 */
	public String getXZLX() {
		return XZLX;
	}

	/**
	 * @param hidQTXZ the hidQTXZ to set
	 */
	public void setHidQTXZ(String hidQTXZ) {
		this.hidQTXZ = hidQTXZ;
	}

	/**
	 * @return the hidQTXZ
	 */
	public String getHidQTXZ() {
		return hidQTXZ;
	}

	/**
	 * @param txtCZRMC the txtCZRMC to set
	 */
	public void setTxtCZRMC(String txtCZRMC) {
		this.txtCZRMC = txtCZRMC;
	}

	/**
	 * @return the txtCZRMC
	 */
	public String getTxtCZRMC() {
		return txtCZRMC;
	}

	/**
	 * @param qtxzList the qtxzList to set
	 */
	public void setQtxzList(ArrayList<Pgv12002e> qtxzList) {
		this.qtxzList = qtxzList;
	}

	/**
	 * @return the qtxzList
	 */
	public ArrayList<Pgv12002e> getQtxzList() {
		return qtxzList;
	}

	/**
	 * @param szqyId the szqyId to set
	 */
	public void setSzqyId(InputStream szqyId) {
		this.szqyId = szqyId;
	}

	/**
	 * @return the szqyId
	 */
	public InputStream getSzqyId() {
		return szqyId;
	}

	/**
	 * @return the dCID
	 */
	public String getDCID() {
		return DCID;
	}
	/**
	 * @param dCID the dCID to set
	 */
	public void setDCID(String dCID) {
		DCID = dCID;
	}
	/**
	 * @return the sWID
	 */
	public String getSWID() {
		return SWID;
	}
	/**
	 * @param sWID the sWID to set
	 */
	public void setSWID(String sWID) {
		SWID = sWID;
	}

	/**
	 * @return the t12002bBean
	 */
	public Pgt12002b getT12002bBean() {
		return t12002bBean;
	}

	/**
	 * @param t12002bBean the t12002bBean to set
	 */
	public void setT12002bBean(Pgt12002b t12002bBean) {
		this.t12002bBean = t12002bBean;
	}

	/**
	 * @param forward the forward to set
	 */
	public void setForward(Boolean forward) {
		this.forward = forward;
	}

	/**
	 * @return the forward
	 */
	public Boolean getForward() {
		return forward;
	}

	/**
	 * @param szqyList the szqyList to set
	 */
	public void setSzqyList(ArrayList<Pgv00052> szqyList) {
		this.szqyList = szqyList;
	}

	/**
	 * @return the szqyList
	 */
	public ArrayList<Pgv00052> getSzqyList() {
		return szqyList;
	}

	/**
	 * @param dataList the dataList to set
	 */
	public void setDataList(ArrayList<String> dataList) {
		this.dataList = dataList;
	}

	/**
	 * @return the dataList
	 */
	public ArrayList<String> getDataList() {
		return dataList;
	}

	/**
	 * @param txtCOUNT the txtCOUNT to set
	 */
	public void setTxtCOUNT(Integer txtCOUNT) {
		this.txtCOUNT = txtCOUNT;
	}

	/**
	 * @return the txtCOUNT
	 */
	public Integer getTxtCOUNT() {
		return txtCOUNT;
	}

	/**
	 * @param txtBGSJ the txtBGSJ to set
	 */
	public void setTxtBGSJ(String txtBGSJ) {
		this.txtBGSJ = txtBGSJ;
	}

	/**
	 * @return the txtBGSJ
	 */
	public String getTxtBGSJ() {
		return txtBGSJ;
	}

	/**
	 * @param ddlBGLX the ddlBGLX to set
	 */
	public void setDdlBGLX(String ddlBGLX) {
		this.ddlBGLX = ddlBGLX;
	}

	/**
	 * @return the ddlBGLX
	 */
	public String getDdlBGLX() {
		return ddlBGLX;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}
