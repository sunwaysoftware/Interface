/**
 * 
 */
package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPg20002Service;
import com.sunway.util.Constant;
import com.sunway.util.ConvertUtil;
import com.sunway.util.FormatUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv02002;
import com.sunway.vo.Pgv02031;

/**
 * 
 * 已評估[收益法]
 * @author Andy.Gao
 * @category 評估
 * @version 1.0
 *
 */
public class Pg20002Action extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = -1873438623566578448L;
	private IPg20002Service pg20002Service;
	private ArrayList<Pgv02031> rows;
	private Pgv02031 v02031Bean;
	// VIEW
	private Integer pageIndex;
	private Integer pageSize;
	private Integer total;
	private String txtSWIDFind;
	private String txtNSRMCFind;
	private String hidFlag;
	private String chkSel;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	private String ddlSZQY;
	private String txtCZR;
	private String txtFCID;
	private String txtUser;
	
	//选择变更
	private Boolean bgFlag;
	private String FCID;
	private String chkBg;
	private String resSign;
	private String resMsg;
	private String txtSSGX;
    private ArrayList<Pgv00052> szqyList;
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		txtUser = sessionCtrl.getUserId();
		txtSSGX = sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX);
		szqyList = sessionCtrl.ReadSzqyList();
		return SUCCESS;
	}

	public void validateQuery() {
		this.clearErrorsAndMessages();
	}
	
	/**
	 * 查询处理
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}

		Pgv02031 v02031 = new Pgv02031();
		try {
			//准備查詢條件
			v02031.setZjhm(FormatUtil.toSearchLike(txtSWIDFind));
			v02031.setNsrmc(FormatUtil.toSearchLike(txtNSRMCFind));
			v02031.setCzr(FormatUtil.toSearchLike(txtCZR));
			v02031.setCd02002Fcid(FormatUtil.toSearchLike(txtFCID));
			v02031.setCd00001Szqy(ddlSZQY);
			v02031.setPageIndex(pageIndex);
			v02031.setPageSize(ConvertUtil.toInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			v02031.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v02031.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			
			//执行查询
			rows = pg20002Service.LoadPgOK(v02031);
			//分页设置
			if(null!=rows && rows.size()>0){
				total = rows.get(0).getRecordCount();
				//pageCount = Common.getPageSize(total,sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE));
			} else {
				
				pageIndex = 1;
				total= 0;
			}
		} catch (Exception e) {
			LOG.error("query()", e);
			e.printStackTrace();
			this.addActionError(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("query() ********** end **********");
			}
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;	
	}	
	
	/**
	 * 重新審核
	 * @return
	 * @throws Exception
	 */
	public String executePgAgain() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("executeShAgain() ********** start **********");
		}
		
		Pgv02002 v02002 = new Pgv02002();
		try {
			v02002.setPgCzr(sessionCtrl.getUserId());
			v02002.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));		
			switch (ConvertUtil.toInteger(hidFlag)) {
			case 1://選擇重新審核
				v02002.setFcid(chkSel);
				//執行重新審核
				if(pg20002Service.GetExecPgAgain(v02002))
					this.addActionMessage(getText(Constant.MSG_PG_EXECR_OK, new String[]{chkSel}));
				else
					this.addActionError(getText(Constant.MSG_PG_EXECR_NG));
				break;
			case 2://全部重新審核
				//執行重新審核
				v02002.setZjhm(FormatUtil.toSearchLike(txtSWIDFind));
				v02002.setNsrmc(FormatUtil.toSearchLike(txtNSRMCFind));
				if(pg20002Service.GetExecPgAgainAll(v02002))
					this.addActionMessage(getText(Constant.MSG_PG_EXECR_OK, new String[]{Constant.STRING_EMPTY}));
				else
					this.addActionError(getText(Constant.MSG_PG_EXECR_NG));
				break;
			default:
				break;
			}		
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("executeShAgain()", e);
			this.addActionError(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("executeShAgain() ********** end **********");
			}			
			return INPUT;
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("executeShAgain() ********** end **********");
		}
		return SUCCESS;
	}
	
	
	/**
	 * 估价后的数据，进行变更
	 * @return
	 * @throws Exception
	 */
	public String executeInfoBg() throws Exception {
		Pgv02031 v02031 = new Pgv02031();
		v02031.setCd02002Fcid(ConvertUtil.encoding(FCID));
		v02031.setPgCzr(sessionCtrl.getUserId());
		v02031.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
		bgFlag = pg20002Service.ExecInfoBg(v02031);
		return SUCCESS;
	}
	
	
	/**
	 * 选择变更操作
	 * @return
	 * @throws Exception
	 */
	public String executeInfoSelBg()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("executeInfoSelBg() ********** start **********");
		}
		try{
			if(chkBg.contains(",")){
				String[] temp = chkBg.split(",");					//讲字符串分隔为FCID数组
				int i = 0;
				do{
					Pgv02031 v02031 = new Pgv02031();
					v02031.setCd02002Fcid(ConvertUtil.encoding(temp[i]));
					v02031.setPgCzr(sessionCtrl.getUserId());
					v02031.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
					bgFlag = pg20002Service.ExecInfoBg(v02031);
					v02031 = null;
					i++;
				}while((i < temp.length) && bgFlag);
				if(i == temp.length){
					resMsg = "数据变更操作成功执行完毕，请通知录入人员进行数据修改";
					resSign = "1";
					
					if(LOG.isDebugEnabled()){
						LOG.debug("executeInfoSelBg() ********** end **********");
					}
					return SUCCESS;
				}else{
					throw new Exception("数据变更操作失败，请重试");
				}
			}else{
				throw new Exception("请选择需要变更的数据");
			}
		}catch(Exception e){
			e.printStackTrace();
			resMsg = "变更时出现异常："+e.getMessage();
			resSign = "2";
			
			if(LOG.isDebugEnabled()){
				LOG.debug("executeInfoSelBg() ********** end **********");
			}
			return SUCCESS;
		}

	}
	
	/**
	 * 获取国土评估信息
	 * @return
	 * @throws Exception
	 */
	public String LoadPgxx()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("LoadPgxx() ********** start **********");
		}
		try{
			Pgv02031 v02031 = new Pgv02031();
			v02031.setCd02002Fcid(txtFCID);
			//获取国土评估信息
			v02031Bean = pg20002Service.LoadPgxx(v02031);
		}catch(Exception e){
			e.printStackTrace();
			if(LOG.isDebugEnabled()){
				LOG.debug("LoadPgxx() ********** end **********");
			}
			return INPUT;
		}finally{
			//
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("LoadPgxx() ********** end **********");
		}
		return SUCCESS;
	}

	/*********************** set and get ******************************/	
	
	/**
	 * @param pg20002Service the pg20002Service to set
	 */
	public void setPg20002Service(IPg20002Service pg20002Service) {
		this.pg20002Service = pg20002Service;
	}
	/**
	 * @return the pg20002Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPg20002Service getPg20002Service() {
		return pg20002Service;
	}

	/**
	 * @return the rows
	 */
	public ArrayList<Pgv02031> getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(ArrayList<Pgv02031> rows) {
		this.rows = rows;
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
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageCount the pageCount to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the total
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(Integer total) {
		this.total = total;
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
	 * @return the hidFlag
	 */
	public String getHidFlag() {
		return hidFlag;
	}

	/**
	 * @param hidFlag the hidFlag to set
	 */
	public void setHidFlag(String hidFlag) {
		this.hidFlag = hidFlag;
	}

	/**
	 * @return the chkSel
	 */
	public String getChkSel() {
		return chkSel;
	}

	/**
	 * @param chkSel the chkSel to set
	 */
	public void setChkSel(String chkSel) {
		this.chkSel = chkSel;
	}

	/**
	 * @return the ddlSZQY
	 */
	public String getDdlSZQY() {
		return ddlSZQY;
	}

	/**
	 * @param ddlSZQY the ddlSZQY to set
	 */
	public void setDdlSZQY(String ddlSZQY) {
		this.ddlSZQY = ddlSZQY;
	}

	/**
	 * @return the txtCZR
	 */
	public String getTxtCZR() {
		return txtCZR;
	}

	/**
	 * @param txtCZR the txtCZR to set
	 */
	public void setTxtCZR(String txtCZR) {
		this.txtCZR = txtCZR;
	}

	/**
	 * @return the txtFCID
	 */
	public String getTxtFCID() {
		return txtFCID;
	}

	/**
	 * @param txtFCID the txtFCID to set
	 */
	public void setTxtFCID(String txtFCID) {
		this.txtFCID = txtFCID;
	}

	public String getChkBg() {
		return chkBg;
	}

	public void setChkBg(String chkBg) {
		this.chkBg = chkBg;
	}

	public String getResSign() {
		return resSign;
	}

	public void setResSign(String resSign) {
		this.resSign = resSign;
	}

	public String getResMsg() {
		return resMsg;
	}

	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}

	public Boolean getBgFlag() {
		return bgFlag;
	}

	public void setBgFlag(Boolean bgFlag) {
		this.bgFlag = bgFlag;
	}

	public String getFCID() {
		return FCID;
	}

	public void setFCID(String fCID) {
		FCID = fCID;
	}

	public String getTxtUser() {
		return txtUser;
	}

	public void setTxtUser(String txtUser) {
		this.txtUser = txtUser;
	}

	public Pgv02031 getV02031Bean() {
		return v02031Bean;
	}

	public void setV02031Bean(Pgv02031 v02031Bean) {
		this.v02031Bean = v02031Bean;
	}

	/**
	 * @return the txtSSGX
	 */
	public String getTxtSSGX() {
		return txtSSGX;
	}

	/**
	 * @param txtSSGX the txtSSGX to set
	 */
	public void setTxtSSGX(String txtSSGX) {
		this.txtSSGX = txtSSGX;
	}

	/**
	 * @return the szqyList
	 */
	public ArrayList<Pgv00052> getSzqyList() {
		return szqyList;
	}

	/**
	 * @param szqyList the szqyList to set
	 */
	public void setSzqyList(ArrayList<Pgv00052> szqyList) {
		this.szqyList = szqyList;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionCtrl.appSession = arg0;
	}
}
