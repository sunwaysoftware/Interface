

/**
 * @author sunxdd
 *
 */

package com.sunway.action;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt02010Service;
import com.sunway.service.IPgt02031Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.Constant;
import com.sunway.util.ConvertUtil;
import com.sunway.util.FormatUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv02010;
import com.sunway.vo.Pgv02031;

public class Pgt02010Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 68204430262561375L;
	private IPgt02010Service t02010Service;
	private IPgt02031Service t02031Service;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	//grid list
	private ArrayList<Pgv02010> rows;
	// 自动完成
	private ArrayList<String> dataList;
	// 页面Bean
	private Pgv02010 t02010Bean;
	private Pgv02031 t02031Bean;
	//编辑操作符
	private String ACT;
	//主键
	private String pk;
	//分页参数
	private Integer pageIndex;
	private Integer pageSize;
	private Integer total;
	//文件下载上传
	private File txtFILE;
	private String txtFILEFileName;
	private String savePath;
	private String fileServerPath;	
	private InputStream excelStream;
	private String excelName;
	//查询
	
	//编辑项
	private String txtCD02002FCID;
	private String txtSBR;
	private String txtZJLXId;
	private String txtZJHM;
	private String txtLXDH;
	private String txtYYLY;
	private String txtSBDATE;
	private String txtCD00002SBCZR;
	private String txtSBZT;
	private String txtSLYJ;
	private String txtSLDATE;
	private String txtCD00002SLCZR;
	private String txtSLZT;
	private String txtDCYJ;
	private String txtDCDATE;
	private String txtCD00002DCCZR;
	private String txtDCZT;
	private String txtCLJD;
	private String txtCLDATE;
	private String txtCD00002CLCZR;
	private String txtCLZT;
	private String txtSLSY;
	private String txtDCJG;
	private String txtDCDSFJG;
	private String txtDCSFCX;
	private String txtDCBCXYY;
	private String txtSLBSLLY;
	
	private String txtZJHMFind;
	private String txtSBRFind;
	private String txtFCIDFind;
	private String txtZCDZLFind;
	private Integer ZT;
	private String infoMsg;
	private String sqlData;
	private String order;
	private String sort;
	
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	/**
	 * 查询
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		Pgv02010 b = new Pgv02010();
		try {			
			b.setPageIndex(pageIndex);
			b.setPageSize(pageSize);
			b.setSbr(CheckUtil.chkTrim(txtSBRFind));
			b.setZjhm(CheckUtil.chkTrim(txtZJHMFind));
			b.setCd02002Fcid(CheckUtil.chkTrim(txtFCIDFind));
			b.setFwtdzl(FormatUtil.toSearchLike(txtZCDZLFind));
			b.setZt(ZT);
			b.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			rows = t02010Service.LoadAll(b);
			//分页设置
			if(null!=rows && rows.size()>0){
				total = rows.get(0).getTotal();
			}else{
				total = 0;
				pageIndex = 1;
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/**
	 * 查询
	 * @return
	 * @throws Exception
	 */
	public String queryV() throws Exception {
		Pgv02010 b = new Pgv02010();
		try {			
			b.setPageIndex(pageIndex);
			b.setPageSize(pageSize);
			b.setSqlData(sqlData);			
			b.setSort(sort);;
			b.setOrder(order); 
			b.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			rows = t02010Service.LoadAllV(b);
			//分页设置
			if(null!=rows && rows.size()>0){
				total = rows.get(0).getTotal();
			}else{
				total = 0;
				pageIndex = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/**
	 * 查询
	 * @return
	 * @throws Exception
	 */
	public String queryB() throws Exception {
		Pgv02010 b = new Pgv02010();
		try {			
			b.setPageIndex(pageIndex);
			b.setPageSize(pageSize);
			b.setSqlData(sqlData);			
			b.setSort(sort);;
			b.setOrder(order); 
			b.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			rows = t02010Service.LoadAllB(b);
			//分页设置
			if(null!=rows && rows.size()>0){
				total = rows.get(0).getTotal();
			}else{
				total = 0;
				pageIndex = 1;
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/**
	 * 查询
	 * @return
	 * @throws Exception
	 */
	public String queryDCYJ() throws Exception {		
		try {			
			rows = t02010Service.LoadDCYJ();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/**
	 * 查询
	 * @return
	 * @throws Exception
	 */
	public String querySLSY() throws Exception {		
		try {			
			Pgv02010 b = new Pgv02010();
			b.setCd00002Slczr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			dataList = t02010Service.LoadSLSY(b);
				 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/**
	 * 查询
	 * @return
	 * @throws Exception
	 */
	public String queryInfoMsg() throws Exception {
		Pgv02010 b = new Pgv02010();
		try {			
			b.setZt(ZT);
			b.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			infoMsg = t02010Service.InfoMsg(b);
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/**
	 * 新增修改
	 * @return
	 * @throws Exception
	 */
	public String create() throws Exception{
		Pgv02010 b = new Pgv02010();
		Pgv02031 a = new Pgv02031();
		String rtn = "successADD";
		try {			
			
			if(!Constant.MOD_CREATE.equals(ACT)){
				b.setCd02002Fcid(pk);

				t02010Bean = t02010Service.LoadByPrimaryKey(b);
				rtn = SUCCESS;
			}else{
				// 准备查询条件
				a.setCd02002Fcid(CheckUtil.chkTrim(pk));
				// 执行查询
				t02031Bean = t02031Service.LoadByPrimaryKey(a);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());
		}
		return rtn;
	}
	
	/**
	 * 新增修改
	 * @return
	 * @throws Exception
	 */
	public String detail() throws Exception{
		Pgv02010 b = new Pgv02010();
		try {			
			// 准备查询条件			
			
			b.setCd02002Fcid(pk);

			t02010Bean = t02010Service.LoadByPrimaryKey(b);
			
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());
		}
		return SUCCESS;
	}
	
	/**
	 * 新增修改
	 * @return
	 * @throws Exception
	 */
	public String detailB() throws Exception{
		Pgv02010 b = new Pgv02010();
		try {			
			// 准备查询条件			
			
			b.setCd02002Fcid(pk);

			t02010Bean = t02010Service.LoadByPrimaryKeyB(b);
			
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());
		}
		return SUCCESS;
	}
	
	public void validateUpdate() throws Exception{
		this.clearActionErrors();
		t02010Bean = new Pgv02010();
		t02010Bean.setCd02002Fcid(pk);

		//根据PK信息，为数据BEAN赋值
		if (!Constant.MOD_DELETE.equals(ACT)){
			if (Constant.MOD_UPDATE.equals(ACT)){
				t02010Bean = t02010Service.LoadByPrimaryKey(t02010Bean);
											
			}
			t02010Bean.setSbr(txtSBR);
			t02010Bean.setCd00001Zjlx(txtZJLXId);
			t02010Bean.setZjhm(txtZJHM);
			t02010Bean.setLxdh(txtLXDH);
			t02010Bean.setYyly(txtYYLY);
			t02010Bean.setCd00002Sbczr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t02010Bean.setSbzt(ConvertUtil.toShort(txtSBZT));
			t02010Bean.setSlyj(txtSLYJ);
			t02010Bean.setCd00002Slczr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t02010Bean.setSlzt(ConvertUtil.toShort(txtSLZT));
			t02010Bean.setDcyj(ConvertUtil.toShort(txtDCYJ));
			t02010Bean.setCd00002Dcczr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t02010Bean.setDczt(ConvertUtil.toShort(txtDCZT));
			t02010Bean.setCljd(txtCLJD);
			t02010Bean.setCd00002Clczr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t02010Bean.setClzt(ConvertUtil.toShort(txtCLZT));
			t02010Bean.setSlsy(txtSLSY);
			t02010Bean.setDcjg(ConvertUtil.toDouble(txtDCJG));
			t02010Bean.setDcdsfjg(ConvertUtil.toDouble(txtDCDSFJG));
			t02010Bean.setDcsfcx(ConvertUtil.toShort(txtDCSFCX));
			t02010Bean.setDcbcxyy(txtDCBCXYY);
			t02010Bean.setSlbslly(txtSLBSLLY);
			t02010Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			
			
		}
	}
	
	public String update() throws Exception {
		try {
			if(Constant.MOD_CREATE.equals(ACT)){			// Create
				if(t02010Service.GetInsertCommand(t02010Bean))
				{
					this.addActionMessage(getText(Constant.MSG_CREATE_OK));
					t02010Bean = new Pgv02010();
				}
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG));
			} else if (Constant.MOD_UPDATE.equals(ACT)) {	// Update
				if (ZT==10)
				{
					if(t02010Service.GetUpdateCommand(t02010Bean)){
						this.addActionMessage(getText(Constant.MSG_UPDATE_OK));
					} else
						this.addActionError(getText(Constant.MSG_UPDATE_NG));
				}
				else if (ZT==20)
				{
					if(t02010Service.GetUpdateCommand1(t02010Bean)){
						this.addActionMessage(getText(Constant.MSG_UPDATE_OK));
					} else
						this.addActionError(getText(Constant.MSG_UPDATE_NG));
				}
				else if (ZT==30)
				{
					if(t02010Service.GetUpdateCommand2(t02010Bean)){
						this.addActionMessage(getText(Constant.MSG_UPDATE_OK));
					} else
						this.addActionError(getText(Constant.MSG_UPDATE_NG));
				}
				else if (ZT==40)
				{
					if(t02010Service.GetUpdateCommand3(t02010Bean)){
						this.addActionMessage(getText(Constant.MSG_UPDATE_OK));
					} else
						this.addActionError(getText(Constant.MSG_UPDATE_NG));
				}
				else if (ZT==50)
				{
					if(t02010Service.GetUpdateCommand4(t02010Bean)){
						this.addActionMessage(getText(Constant.MSG_UPDATE_OK));
					} else
						this.addActionError(getText(Constant.MSG_UPDATE_NG));
				}
			} else if (Constant.MOD_DELETE.equals(ACT)) {	// Delete
				if(t02010Service.GetDeleteCommand(t02010Bean))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG));
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());
			return INPUT;
		}
		return SUCCESS;
	}
	
	/**
	 * 显示详细信息
	 * @return
	 * @throws Exception
	 */
	public String print() throws Exception {
		Pgv02010 b = new Pgv02010();
		String info = SUCCESS;
		try {
			b.setCd02002Fcid(pk);
			t02010Bean = t02010Service.LoadByPrimaryKey(b);
			switch (t02010Bean.getSlzt()){
				case 0:
					info = "successSb";//申请表
					break;
				case 1:
					info = "successYes";//受理
					break;
				case 2:
					info = "successBack";//补正内容
					break;
				case 3:
					info = "successNo";//不予受理
					break;				
			}
		} catch (Exception e) {
			this.addActionError(e.getMessage());
		}
		return info;
	}
	
	/**
	 * 显示详细信息
	 * @return
	 * @throws Exception
	 */
	public String printSH() throws Exception {
		Pgv02010 b = new Pgv02010();
		String info = SUCCESS;
		try {
			b.setCd02002Fcid(pk);
			t02010Bean = t02010Service.LoadByPrimaryKey(b);			
		} catch (Exception e) {
			this.addActionError(e.getMessage());
		}
		return info;
	}
	
	/**
	 * 显示详细信息
	 * @return
	 * @throws Exception
	 */
	public String jdsPrint() throws Exception {
		Pgv02010 b = new Pgv02010();
		String info = SUCCESS;
		try {
			b.setCd02002Fcid(pk);
			b.setCd00002Clczr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t02010Bean = t02010Service.JdsPrint(b);			
		} catch (Exception e) {
			this.addActionError(e.getMessage());
		}
		return info;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		sessionCtrl.appSession = session;
	}
	
	
	
	//------------------------- setter and getter ------------------------------
	
	/**
	 * @return the t02010Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt02010Service getT02010Service() {
		return t02010Service;
	}

	/**
	 * @param t02010Service the t02010Service to set
	 */
	public void setT02010Service(IPgt02010Service t02010Service) {
		this.t02010Service = t02010Service;
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
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	/**
	 * @return the aCT
	 */
	public String getACT() {
		return ACT;
	}

	/**
	 * @param aCT the aCT to set
	 */
	public void setACT(String aCT) {
		ACT = aCT;
	}

	/**
	 * @return the pk
	 */
	public String getPk() {
		return pk;
	}

	/**
	 * @param pk the pk to set
	 */
	public void setPk(String pk) {
		this.pk = pk;
	}
	
	/**
	 * @return the t02010Bean
	 */
	public Pgv02010 getT02010Bean() {
		return t02010Bean;
	}

	/**
	 * @param t02010Bean the t02010Bean to set
	 */
	public void setT02010Bean(Pgv02010 t02010Bean) {
		this.t02010Bean = t02010Bean;
	}
	
	/**
	 * @return the txtFILE
	 */
	public File getTxtFILE() {
		return txtFILE;
	}

	/**
	 * @param txtFILE the txtFILE to set
	 */
	public void setTxtFILE(File txtFILE) {
		this.txtFILE = txtFILE;
	}
	
	/**
	 * @return the txtFILEFileName
	 */
	public String getTxtFILEFileName() {
		return txtFILEFileName;
	}

	/**
	 * @param txtFILEFileName the txtFILEFileName to set
	 */
	public void setTxtFILEFileName(String txtFILEFileName) {
		this.txtFILEFileName = txtFILEFileName;
	}

	/**
	 * @return the excelName
	 */
	public String getExcelName() {
		return sessionCtrl.getUserId() + excelName;
	}

	/**
	 * @param excelName the excelName to set
	 */
	public void setExcelName(String excelName) {
		this.excelName = excelName;
	}
	
	/**
	 * @return the savePath
	 */
	public String getSavePath() {
		return ServletActionContext.getServletContext().getRealPath("/") +savePath;
	}

	/**
	 * @param savePath the savePath to set
	 */
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	
	/**
	 * @return the fileServerPath
	 */
	public String getFileServerPath() {
		return fileServerPath;
	}

	/**
	 * @param fileServerPath the fileServerPath to set
	 */
	public void setFileServerPath(String fileServerPath) {
		this.fileServerPath = fileServerPath;
	}
	
	/**
	 * @return the excelStream
	 */
	public InputStream getExcelStream() {
		return excelStream;
	}

	/**
	 * @param excelStream the excelStream to set
	 */
	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}
	
	/**
	* @return txtCD02002FCID
	 */
	public String getTxtCD02002FCID() {
			return txtCD02002FCID;
	}
	
	/**
	* @param txtCD02002FCID the txtCD02002FCID to set
	 */
	public void setTxtCD02002FCID(String txtCD02002FCID) {
			this.txtCD02002FCID=txtCD02002FCID;
	}
	/**
	* @return txtSBR
	 */
	public String getTxtSBR() {
			return txtSBR;
	}
	
	/**
	* @param txtSBR the txtSBR to set
	 */
	public void setTxtSBR(String txtSBR) {
			this.txtSBR=txtSBR;
	}
	
	/**
	* @return txtZJHM
	 */
	public String getTxtZJHM() {
			return txtZJHM;
	}
	
	/**
	* @param txtZJHM the txtZJHM to set
	 */
	public void setTxtZJHM(String txtZJHM) {
			this.txtZJHM=txtZJHM;
	}
	/**
	* @return txtLXDH
	 */
	public String getTxtLXDH() {
			return txtLXDH;
	}
	
	/**
	* @param txtLXDH the txtLXDH to set
	 */
	public void setTxtLXDH(String txtLXDH) {
			this.txtLXDH=txtLXDH;
	}
	/**
	* @return txtYYLY
	 */
	public String getTxtYYLY() {
			return txtYYLY;
	}
	
	/**
	* @param txtYYLY the txtYYLY to set
	 */
	public void setTxtYYLY(String txtYYLY) {
			this.txtYYLY=txtYYLY;
	}
	/**
	* @return txtSBDATE
	 */
	public String getTxtSBDATE() {
			return txtSBDATE;
	}
	
	/**
	* @param txtSBDATE the txtSBDATE to set
	 */
	public void setTxtSBDATE(String txtSBDATE) {
			this.txtSBDATE=txtSBDATE;
	}
	/**
	* @return txtCD00002SBCZR
	 */
	public String getTxtCD00002SBCZR() {
			return txtCD00002SBCZR;
	}
	
	/**
	* @param txtCD00002SBCZR the txtCD00002SBCZR to set
	 */
	public void setTxtCD00002SBCZR(String txtCD00002SBCZR) {
			this.txtCD00002SBCZR=txtCD00002SBCZR;
	}
	/**
	* @return txtSBZT
	 */
	public String getTxtSBZT() {
			return txtSBZT;
	}
	
	/**
	* @param txtSBZT the txtSBZT to set
	 */
	public void setTxtSBZT(String txtSBZT) {
			this.txtSBZT=txtSBZT;
	}
	/**
	* @return txtSLYJ
	 */
	public String getTxtSLYJ() {
			return txtSLYJ;
	}
	
	/**
	* @param txtSLYJ the txtSLYJ to set
	 */
	public void setTxtSLYJ(String txtSLYJ) {
			this.txtSLYJ=txtSLYJ;
	}
	/**
	* @return txtSLDATE
	 */
	public String getTxtSLDATE() {
			return txtSLDATE;
	}
	
	/**
	* @param txtSLDATE the txtSLDATE to set
	 */
	public void setTxtSLDATE(String txtSLDATE) {
			this.txtSLDATE=txtSLDATE;
	}
	/**
	* @return txtCD00002SLCZR
	 */
	public String getTxtCD00002SLCZR() {
			return txtCD00002SLCZR;
	}
	
	/**
	* @param txtCD00002SLCZR the txtCD00002SLCZR to set
	 */
	public void setTxtCD00002SLCZR(String txtCD00002SLCZR) {
			this.txtCD00002SLCZR=txtCD00002SLCZR;
	}
	/**
	* @return txtSLZT
	 */
	public String getTxtSLZT() {
			return txtSLZT;
	}
	
	/**
	* @param txtSLZT the txtSLZT to set
	 */
	public void setTxtSLZT(String txtSLZT) {
			this.txtSLZT=txtSLZT;
	}
	/**
	* @return txtDCYJ
	 */
	public String getTxtDCYJ() {
			return txtDCYJ;
	}
	
	/**
	* @param txtDCYJ the txtDCYJ to set
	 */
	public void setTxtDCYJ(String txtDCYJ) {
			this.txtDCYJ=txtDCYJ;
	}
	/**
	* @return txtDCDATE
	 */
	public String getTxtDCDATE() {
			return txtDCDATE;
	}
	
	/**
	* @param txtDCDATE the txtDCDATE to set
	 */
	public void setTxtDCDATE(String txtDCDATE) {
			this.txtDCDATE=txtDCDATE;
	}
	/**
	* @return txtCD00002DCCZR
	 */
	public String getTxtCD00002DCCZR() {
			return txtCD00002DCCZR;
	}
	
	/**
	* @param txtCD00002DCCZR the txtCD00002DCCZR to set
	 */
	public void setTxtCD00002DCCZR(String txtCD00002DCCZR) {
			this.txtCD00002DCCZR=txtCD00002DCCZR;
	}
	/**
	* @return txtDCZT
	 */
	public String getTxtDCZT() {
			return txtDCZT;
	}
	
	/**
	* @param txtDCZT the txtDCZT to set
	 */
	public void setTxtDCZT(String txtDCZT) {
			this.txtDCZT=txtDCZT;
	}
	/**
	* @return txtCLJD
	 */
	public String getTxtCLJD() {
			return txtCLJD;
	}
	
	/**
	* @param txtCLJD the txtCLJD to set
	 */
	public void setTxtCLJD(String txtCLJD) {
			this.txtCLJD=txtCLJD;
	}
	/**
	* @return txtCLDATE
	 */
	public String getTxtCLDATE() {
			return txtCLDATE;
	}
	
	/**
	* @param txtCLDATE the txtCLDATE to set
	 */
	public void setTxtCLDATE(String txtCLDATE) {
			this.txtCLDATE=txtCLDATE;
	}
	/**
	* @return txtCD00002CLCZR
	 */
	public String getTxtCD00002CLCZR() {
			return txtCD00002CLCZR;
	}
	
	/**
	* @param txtCD00002CLCZR the txtCD00002CLCZR to set
	 */
	public void setTxtCD00002CLCZR(String txtCD00002CLCZR) {
			this.txtCD00002CLCZR=txtCD00002CLCZR;
	}
	/**
	* @return txtCLZT
	 */
	public String getTxtCLZT() {
			return txtCLZT;
	}
	
	/**
	* @param txtCLZT the txtCLZT to set
	 */
	public void setTxtCLZT(String txtCLZT) {
			this.txtCLZT=txtCLZT;
	}
	/**
	* @return txtSLSY
	 */
	public String getTxtSLSY() {
			return txtSLSY;
	}
	
	/**
	* @param txtSLSY the txtSLSY to set
	 */
	public void setTxtSLSY(String txtSLSY) {
			this.txtSLSY=txtSLSY;
	}
	/**
	* @return txtDCJG
	 */
	public String getTxtDCJG() {
			return txtDCJG;
	}
	
	/**
	* @param txtDCJG the txtDCJG to set
	 */
	public void setTxtDCJG(String txtDCJG) {
			this.txtDCJG=txtDCJG;
	}
	/**
	* @return txtDCDSFJG
	 */
	public String getTxtDCDSFJG() {
			return txtDCDSFJG;
	}
	
	/**
	* @param txtDCDSFJG the txtDCDSFJG to set
	 */
	public void setTxtDCDSFJG(String txtDCDSFJG) {
			this.txtDCDSFJG=txtDCDSFJG;
	}
	/**
	* @return txtDCSFCX
	 */
	public String getTxtDCSFCX() {
			return txtDCSFCX;
	}
	
	/**
	* @param txtDCSFCX the txtDCSFCX to set
	 */
	public void setTxtDCSFCX(String txtDCSFCX) {
			this.txtDCSFCX=txtDCSFCX;
	}
	/**
	* @return txtDCBCXYY
	 */
	public String getTxtDCBCXYY() {
			return txtDCBCXYY;
	}
	
	/**
	* @param txtDCBCXYY the txtDCBCXYY to set
	 */
	public void setTxtDCBCXYY(String txtDCBCXYY) {
			this.txtDCBCXYY=txtDCBCXYY;
	}

	public String getTxtZJHMFind() {
		return txtZJHMFind;
	}

	public void setTxtZJHMFind(String txtZJHMFind) {
		this.txtZJHMFind = txtZJHMFind;
	}

	public String getTxtSBRFind() {
		return txtSBRFind;
	}

	public void setTxtSBRFind(String txtSBRFind) {
		this.txtSBRFind = txtSBRFind;
	}

	public String getTxtFCIDFind() {
		return txtFCIDFind;
	}

	public void setTxtFCIDFind(String txtFCIDFind) {
		this.txtFCIDFind = txtFCIDFind;
	}

	public String getTxtZCDZLFind() {
		return txtZCDZLFind;
	}

	public void setTxtZCDZLFind(String txtZCDZLFind) {
		this.txtZCDZLFind = txtZCDZLFind;
	}

	public Integer getZT() {
		return ZT;
	}

	public void setZT(Integer zT) {
		ZT = zT;
	}

	public Pgv02031 getT02031Bean() {
		return t02031Bean;
	}

	public void setT02031Bean(Pgv02031 t02031Bean) {
		this.t02031Bean = t02031Bean;
	}
	@JSON(deserialize=false, serialize=false)
	public IPgt02031Service getT02031Service() {
		return t02031Service;
	}

	public void setT02031Service(IPgt02031Service t02031Service) {
		this.t02031Service = t02031Service;
	}

	public String getTxtZJLXId() {
		return txtZJLXId;
	}

	public void setTxtZJLXId(String txtZJLXId) {
		this.txtZJLXId = txtZJLXId;
	}

	public ArrayList<Pgv02010> getRows() {
		return rows;
	}

	public void setRows(ArrayList<Pgv02010> rows) {
		this.rows = rows;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getTxtSLBSLLY() {
		return txtSLBSLLY;
	}

	public void setTxtSLBSLLY(String txtSLBSLLY) {
		this.txtSLBSLLY = txtSLBSLLY;
	}	

	public String getInfoMsg() {
		return infoMsg;
	}

	public void setInfoMsg(String infoMsg) {
		this.infoMsg = infoMsg;
	}

	public ArrayList<String> getDataList() {
		return dataList;
	}

	public void setDataList(ArrayList<String> dataList) {
		this.dataList = dataList;
	}

	public String getSqlData() {
		return sqlData;
	}

	public void setSqlData(String sqlData) {
		this.sqlData = sqlData;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
  
}	
