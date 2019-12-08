package com.sunway.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00304Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.Excel;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt00304;
import com.sunway.vo.Pgt00304a;
import com.sunway.vo.Pgv00001;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv00304;
import com.sunway.vo.Pgv00352;

/**
 * 市场法房地产信息（PGT00304）
 * @author Lee
 * @version 1.0
 */

public class Pgt00304Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 5251728661856323636L;
	// Service
	private IPgt00304Service t00304Service;
	// View
	private InputStream excelStream;
	private ArrayList<Pgv00052> szqyList;
	private ArrayList<Pgt00304a> t00304aList;
	// 分页参数
	private Integer pageIndex;
	private Integer pageSize;
	private Integer rowCount;
	// Bean数组
	private ArrayList<Pgv00304> tabList;
	
	// 检索条件
	private String txtSWIDFind;
	private String txtNSRMCFind;
	private String txtFDCDATFind;
	private String txtXQFind;
	private String txtFWTDZLFind;
	private String ddlSZQYFind;
	//编辑操作符
	private String ACT;
	//primary key 主键
	private String GPID;
	// detail页面所需Bean
	private Pgv00304 v00304Bean;
	private String SWID;
	// edit页面所需Bean
	private Pgt00304 t00304Bean;
	private Pgt00304a t00304aBean;
	// edit页面提交数据
	private String ddlSZQY;
	private String txtUPDATE;
	private String txtSWID;
	private String txtFWLX;
	private String txtJYLX;
	private String txtJZMJ;
	private String txtFWCX;
	private String txtCGZK;
	private String txtSZLC;
	private String txtBWJFH;
	private Double txtJYJG;
	private Double txtTDSYQMJ;
	private String txtJZJG;
	private String txtZLC;
	private String txtNOTE;
	private String hidQTXZ;
	private String txtXQDM;
	private String txtFWTDZL;
	private String hidNsrmc;
	private String txtBGSJ;
	private String ddlBGLX;
	private Boolean rdoYWDT;
	private Boolean rdoSFZJ;
	private String txtZBJG;
	private String txtGPSJ;
	private String txtNSRMC;
	private String XZLX;
	private String txtHX;
	
	//file upload
	private String title;
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private String savePath;
	private String ddlImportLx;
	private String fileServerPath;
	
	//file import
	private String txtFilePath;
	private ArrayList<Pgv00304> Pgv00304List;
	private ArrayList<Pgv00001> Pgv00001List;
	private ArrayList<Pgv00352> Pgv00352List;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	
	private String fileName;
	/*
	 * (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** start **********");
		}
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			szqyList = sessionCtrl.ReadSzqyList();
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("execute() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 查询状态处理
	 * 
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}

		Pgv00304 v00304 = new Pgv00304();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			v00304.setSwid(Common.trim(txtSWIDFind));
			v00304.setNsrmc(Common.getSearchLike(txtNSRMCFind));
			v00304.setCd00352Xqdm(Common.trim(txtXQFind));
			v00304.setFwtdzl(Common.getSearchLike(txtFWTDZLFind));
			v00304.setCd00001Szqy(ddlSZQYFind);
			v00304.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v00304.setPageIndex(pageIndex);
			v00304.setPageSize(getPageSize());
			// 执行查询
			tabList = t00304Service.LoadAll(v00304);
			
			// 分页设置
			if (null != tabList && tabList.size() > 0) {
				rowCount = Common.checkNull(tabList.get(0).getRecordCount());
			} else {
				rowCount = 0;
				pageIndex = 1;
			}
			szqyList = sessionCtrl.ReadSzqyList();
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
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
		Pgt00304 t00304 = new Pgt00304();
		t00304Bean = new Pgt00304();
		t00304aBean = new Pgt00304a();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			if (!Constant.MOD_CREATE.equals(getACT())) {
				// 取得用户选中的数据信息
				t00304.setGpid(GPID);
				t00304Bean = t00304Service.LoadByPrimaryKey(t00304);
				t00304aBean.setCd00304Gpid(GPID);
				t00304aList = t00304Service.LoadAlla(t00304aBean);
			} 
			szqyList = sessionCtrl.ReadSzqyList();
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("create() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 更新操作前的验证处理
	 * 
	 * @throws Exception
	 */
	public void validateUpdate() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("validateUpdate() ********** start **********");
		}

		t00304Bean = new Pgt00304();
		this.clearErrorsAndMessages();
		
		t00304Bean.setGpid(GPID);
		//根据PK取得信息，并为BEAN赋值
		if (Constant.MOD_UPDATE.equals(getACT())) {
			t00304Bean = t00304Service.LoadByPrimaryKey(t00304Bean);
		}
		// 判读数据是否已经被其他用户修改
		if ((Constant.MOD_UPDATE.equals(getACT()))
				&& (!t00304Bean.getUpddate().equals(
						Common.convertStringToTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		} else {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			t00304Bean.setSwid(txtSWID);
			t00304Bean.setGpid(GPID);
			t00304Bean.setCd00352Xqdm(txtXQDM);
			t00304Bean.setYwdt(rdoYWDT);
			t00304Bean.setZlc(Common.convertToShort(txtZLC));
			t00304Bean.setFwtdzl(txtFWTDZL);
			t00304Bean.setCd00001Fwlx(txtFWLX);
			t00304Bean.setCd00001Jylx(txtJYLX);
			t00304Bean.setCd00001Jzjg(txtJZJG);
			t00304Bean.setJzmj(Common.convertToBigDecimal(txtJZMJ));
			t00304Bean.setCd00001Fwcx(txtFWCX);
			t00304Bean.setCd00001Cgzk(txtCGZK);
			t00304Bean.setSzlc(Common.convertToShort(txtSZLC));
			t00304Bean.setBwjfh(txtBWJFH);
			t00304Bean.setZbjg(Common.convertToBigDecimal(txtZBJG));
			t00304Bean.setTdsyqmj(Common.checkNull(txtTDSYQMJ));
			t00304Bean.setSfzj(rdoSFZJ);
			t00304Bean.setGpsj(Common.convertToDate(txtGPSJ));
			t00304Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t00304Bean.setNote(txtNOTE);
			t00304Bean.setHx(txtHX);
			//TODO小区名称
			t00304Bean.setXqmc("");
			t00304Bean.setNsrmc(txtNSRMC);
			t00304Bean.setCd00001Szqy(ddlSZQY);
			t00304Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			t00304Bean.setQtids(hidQTXZ);
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("validateUpdate() ********** end **********");
		}
	}

	/**
	 * 更新、删除状态处理
	 * 
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** start **********");
		}
		//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
		String rtn = SUCCESS;
		try {
			if (Constant.MOD_CREATE.equals(getACT())) { // Create
				if (t00304Service.GetInsertCommand(t00304Bean)) {
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[] {Constant.STRING_EMPTY}));
				} else {
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[] {Constant.STRING_EMPTY}));
				}
			} else if (Constant.MOD_UPDATE.equals(getACT())) { // Update
				if (t00304Service.GetUpdateCommand(t00304Bean)) {
					t00304Bean = t00304Service.LoadByPrimaryKey(t00304Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[] { t00304Bean.getGpid() }));
				} else {
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[] { t00304Bean.getGpid() }));
				}
			} else if (Constant.MOD_DELETE.equals(getACT())) { // Delete
				if (t00304Service.GetDeleteCommand(t00304Bean)) {
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[] { t00304Bean.getGpid() }));
				} else {
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[] { t00304Bean.getGpid() }));
				}
			}
			szqyList = sessionCtrl.ReadSzqyList();
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("update() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** end **********");
		}
		return rtn;
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String upload() throws Exception {
		try{
			fileServerPath = getSavePath() + "\\" + getUploadFileName();
			//建立文件上传的输出流
			FileOutputStream fos = new FileOutputStream(fileServerPath);
			//以上传文件建立一个文件上传流
			FileInputStream fis = new FileInputStream(getUpload());
			//将上传文件的内容写入服务器
			byte[] buffer = new byte[1024];
			int len = 0;
			while((len = fis.read(buffer))>0){
				fos.write(buffer,0,len);			
			}
			fis.close();
			fos.close();
		}catch(Exception ex){
			ex.printStackTrace();
			return INPUT;
		}
		return SUCCESS;
	}

	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#validate()
	 */
	/*public void validateImportFile() {
		if(!Common.isFileExist(txtFilePath)){
			this.addActionError("文件错误，请检查！");
		}
		try{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//检验数据合法性
			Pgv00304List = Excel.importDataGpsj(txtFilePath, sessionCtrl.getUserId(),sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(!checkGpsj(Pgv00304List))
				this.addActionError("挂牌数据不符合导入要求！");
			if(Pgv00304List.size()==0)
				this.addActionError("挂牌数据不符合导入要求！");
		}catch(Exception ex){
			ex.printStackTrace();
			this.addActionError("文件错误，请检查！");
		}
	}
	*/
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String importFile() throws Exception {
		Pgv00304 tmpV00304 = new Pgv00304();
		try{
			tmpV00304 = t00304Service.ImportExcelData(Pgv00304List);
		}catch(Exception ex){
			ex.printStackTrace();
			this.addActionError(ex.getMessage());
			return INPUT;
		}finally{
			if(tmpV00304.getOutFlag()==3)
				this.addActionError("数据导入失败，请重新选择模版导入！");
			else if(tmpV00304.getOutFlag()==2)
				this.addActionMessage("数据导入执行完毕！");
			else{
				ByteArrayOutputStream out = (ByteArrayOutputStream) Excel.exportDataGpsj(tmpV00304.getOutList());
				excelStream = new ByteArrayInputStream(out.toByteArray());
				fileName=new String("格式错误的挂牌数据.xls".getBytes("GBK"),"ISO-8859-1");
				return "failexport";
			}
			/*
			else if (tmpV00304.getOutFlag()==1)
				this.addActionMessage("数据导入执行完毕，但导入过程中部分失败！");
			else 
				this.addActionError("数据导入失败！");
			*/
		}
		return SUCCESS;
	}
	
	/**
	 * 登记详细信息
	 * @return
	 * @throws Exception
	 */
	public String detail() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** start **********");
		}
		Pgv00304 v00304 = new Pgv00304();
		v00304Bean = new Pgv00304();
		try {
			// 准备查询条件
			v00304.setGpid(Common.convertEncoding(SWID));
			// 执行查询
			v00304Bean = t00304Service.LoadDetail(v00304);
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** end **********");
		}
		return SUCCESS;
	}
	
	
	/*********************** setter and getter ******************************/

	/**
	 * @return the t00304Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt00304Service getT00304Service() {
		return t00304Service;
	}
	/**
	 * @param t00304Service the t00304Service to set
	 */
	public void setT00304Service(IPgt00304Service t00304Service) {
		this.t00304Service = t00304Service;
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
	public ArrayList<Pgv00304> getTabList() {
		return tabList;
	}
	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv00304> tabList) {
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
	 * @return the txtFDCDATFind
	 */
	public String getTxtFDCDATFind() {
		return txtFDCDATFind;
	}
	/**
	 * @param txtFDCDATFind the txtFDCDATFind to set
	 */
	public void setTxtFDCDATFind(String txtFDCDATFind) {
		this.txtFDCDATFind = txtFDCDATFind;
	}
	/**
	 * @return the txtXQFind
	 */
	public String getTxtXQFind() {
		return txtXQFind;
	}
	/**
	 * @param txtXQFind the txtXQFind to set
	 */
	public void setTxtXQFind(String txtXQFind) {
		this.txtXQFind = txtXQFind;
	}
	/**
	 * @return the txtFWTDZLFind
	 */
	public String getTxtFWTDZLFind() {
		return txtFWTDZLFind;
	}
	/**
	 * @param txtFWTDZLFind the txtFWTDZLFind to set
	 */
	public void setTxtFWTDZLFind(String txtFWTDZLFind) {
		this.txtFWTDZLFind = txtFWTDZLFind;
	}
	/**
	 * @return the ddlSZQYFind
	 */
	public String getDdlSZQYFind() {
		return ddlSZQYFind;
	}
	/**
	 * @param ddlSZQYFind the ddlSZQYFind to set
	 */
	public void setDdlSZQYFind(String ddlSZQYFind) {
		this.ddlSZQYFind = ddlSZQYFind;
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
	 * @return the fCID
	 */
	public String getGPID() {
		return GPID;
	}
	/**
	 * @param fCID the fCID to set
	 */
	public void setGPID(String fCID) {
		GPID = fCID;
	}
	/**
	 * @return the v00304Bean
	 */
	public Pgv00304 getV00304Bean() {
		return v00304Bean;
	}
	/**
	 * @param v00304Bean the v00304Bean to set
	 */
	public void setV00304Bean(Pgv00304 v00304Bean) {
		this.v00304Bean = v00304Bean;
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
	 * @return the t00304Bean
	 */
	public Pgt00304 gett00304Bean() {
		return t00304Bean;
	}
	/**
	 * @param t00304Bean the t00304Bean to set
	 */
	public void sett00304Bean(Pgt00304 t00304Bean) {
		this.t00304Bean = t00304Bean;
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
	 * @return the txtFWLX
	 */
	public String getTxtFWLX() {
		return txtFWLX;
	}
	/**
	 * @param txtFWLX the txtFWLX to set
	 */
	public void setTxtFWLX(String txtFWLX) {
		this.txtFWLX = txtFWLX;
	}
	/**
	 * @return the txtJYLX
	 */
	public String getTxtJYLX() {
		return txtJYLX;
	}
	/**
	 * @param txtJYLX the txtJYLX to set
	 */
	public void setTxtJYLX(String txtJYLX) {
		this.txtJYLX = txtJYLX;
	}
	/**
	 * @return the txtFWCX
	 */
	public String getTxtFWCX() {
		return txtFWCX;
	}
	/**
	 * @param txtFWCX the txtFWCX to set
	 */
	public void setTxtFWCX(String txtFWCX) {
		this.txtFWCX = txtFWCX;
	}
	/**
	 * @return the txtCGZK
	 */
	public String getTxtCGZK() {
		return txtCGZK;
	}
	/**
	 * @param txtCGZK the txtCGZK to set
	 */
	public void setTxtCGZK(String txtCGZK) {
		this.txtCGZK = txtCGZK;
	}
	/**
	 * @return the txtBWJFH
	 */
	public String getTxtBWJFH() {
		return txtBWJFH;
	}
	/**
	 * @param txtBWJFH the txtBWJFH to set
	 */
	public void setTxtBWJFH(String txtBWJFH) {
		this.txtBWJFH = txtBWJFH;
	}
	/**
	 * @return the txtJYJG
	 */
	public Double getTxtJYJG() {
		return txtJYJG;
	}
	/**
	 * @param txtJYJG the txtJYJG to set
	 */
	public void setTxtJYJG(Double txtJYJG) {
		this.txtJYJG = txtJYJG;
	}
	/**
	 * @return the txtTDSYQMJ
	 */
	public Double getTxtTDSYQMJ() {
		return txtTDSYQMJ;
	}
	/**
	 * @param txtTDSYQMJ the txtTDSYQMJ to set
	 */
	public void setTxtTDSYQMJ(Double txtTDSYQMJ) {
		this.txtTDSYQMJ = txtTDSYQMJ;
	}
	/**
	 * @return the txtJZJG
	 */
	public String getTxtJZJG() {
		return txtJZJG;
	}
	/**
	 * @param txtJZJG the txtJZJG to set
	 */
	public void setTxtJZJG(String txtJZJG) {
		this.txtJZJG = txtJZJG;
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
	 * @return the hidQTXZ
	 */
	public String getHidQTXZ() {
		return hidQTXZ;
	}
	/**
	 * @param hidQTXZ the hidQTXZ to set
	 */
	public void setHidQTXZ(String hidQTXZ) {
		this.hidQTXZ = hidQTXZ;
	}
	/**
	 * @return the hidNsrmc
	 */
	public String getHidNsrmc() {
		return hidNsrmc;
	}
	/**
	 * @param hidNsrmc the hidNsrmc to set
	 */
	public void setHidNsrmc(String hidNsrmc) {
		this.hidNsrmc = hidNsrmc;
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

	/**
	 * @return the t00304aList
	 */
	public ArrayList<Pgt00304a> getT00304aList() {
		return t00304aList;
	}

	/**
	 * @param t00304aList the t00304aList to set
	 */
	public void setT00304aList(ArrayList<Pgt00304a> t00304aList) {
		this.t00304aList = t00304aList;
	}

	/**
	 * @return the t00304Bean
	 */
	public Pgt00304 getT00304Bean() {
		return t00304Bean;
	}

	/**
	 * @param t00304Bean the t00304Bean to set
	 */
	public void setT00304Bean(Pgt00304 t00304Bean) {
		this.t00304Bean = t00304Bean;
	}

	/**
	 * @return the t00304aBean
	 */
	public Pgt00304a getT00304aBean() {
		return t00304aBean;
	}

	/**
	 * @param t00304aBean the t00304aBean to set
	 */
	public void setT00304aBean(Pgt00304a t00304aBean) {
		this.t00304aBean = t00304aBean;
	}

	/**
	 * @return the rdoSFZJ
	 */
	public Boolean getRdoSFZJ() {
		return rdoSFZJ;
	}

	/**
	 * @param rdoSFZJ the rdoSFZJ to set
	 */
	public void setRdoSFZJ(Boolean rdoSFZJ) {
		this.rdoSFZJ = rdoSFZJ;
	}

	/**
	 * @param rdoYWDT the rdoYWDT to set
	 */
	public void setRdoYWDT(Boolean rdoYWDT) {
		this.rdoYWDT = rdoYWDT;
	}

	/**
	 * @return the txtSZLC
	 */
	public String getTxtSZLC() {
		return txtSZLC;
	}

	/**
	 * @param txtSZLC the txtSZLC to set
	 */
	public void setTxtSZLC(String txtSZLC) {
		this.txtSZLC = txtSZLC;
	}

	/**
	 * @return the txtZLC
	 */
	public String getTxtZLC() {
		return txtZLC;
	}

	/**
	 * @param txtZLC the txtZLC to set
	 */
	public void setTxtZLC(String txtZLC) {
		this.txtZLC = txtZLC;
	}

	/**
	 * @return the txtZBJG
	 */
	public String getTxtZBJG() {
		return txtZBJG;
	}

	/**
	 * @param txtZBJG the txtZBJG to set
	 */
	public void setTxtZBJG(String txtZBJG) {
		this.txtZBJG = txtZBJG;
	}

	/**
	 * @return the txtGPSJ
	 */
	public String getTxtGPSJ() {
		return txtGPSJ;
	}

	/**
	 * @param txtGPSJ the txtGPSJ to set
	 */
	public void setTxtGPSJ(String txtGPSJ) {
		this.txtGPSJ = txtGPSJ;
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
	 * @return the rdoYWDT
	 */
	public Boolean getRdoYWDT() {
		return rdoYWDT;
	}

	/**
	 * @return the xZLX
	 */
	public String getXZLX() {
		return XZLX;
	}

	/**
	 * @param xZLX the xZLX to set
	 */
	public void setXZLX(String xZLX) {
		XZLX = xZLX;
	}

	/**
	 * @return the txtJZMJ
	 */
	public String getTxtJZMJ() {
		return txtJZMJ;
	}

	/**
	 * @param txtJZMJ the txtJZMJ to set
	 */
	public void setTxtJZMJ(String txtJZMJ) {
		this.txtJZMJ = txtJZMJ;
	}

	/**
	 * @return the txtXQDM
	 */
	public String getTxtXQDM() {
		return txtXQDM;
	}

	/**
	 * @param txtXQDM the txtXQDM to set
	 */
	public void setTxtXQDM(String txtXQDM) {
		this.txtXQDM = txtXQDM;
	}

	/**
	 * @return the txtFWTDZL
	 */
	public String getTxtFWTDZL() {
		return txtFWTDZL;
	}

	/**
	 * @param txtFWTDZL the txtFWTDZL to set
	 */
	public void setTxtFWTDZL(String txtFWTDZL) {
		this.txtFWTDZL = txtFWTDZL;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the upload
	 */
	public File getUpload() {
		return upload;
	}

	/**
	 * @param upload the upload to set
	 */
	public void setUpload(File upload) {
		this.upload = upload;
	}

	/**
	 * @return the uploadContentType
	 */
	public String getUploadContentType() {
		return uploadContentType;
	}

	/**
	 * @param uploadContentType the uploadContentType to set
	 */
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	/**
	 * @return the uploadFileName
	 */
	public String getUploadFileName() {
		return uploadFileName;
	}

	/**
	 * @param uploadFileName the uploadFileName to set
	 */
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	/**
	 * @return the savePath
	 */
	@SuppressWarnings("deprecation")
	public String getSavePath() {
		return ServletActionContext.getRequest().getRealPath(savePath);
	}

	/**
	 * @param savePath the savePath to set
	 */
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	/**
	 * @return the ddlImportLx
	 */
	public String getDdlImportLx() {
		return ddlImportLx;
	}

	/**
	 * @param ddlImportLx the ddlImportLx to set
	 */
	public void setDdlImportLx(String ddlImportLx) {
		this.ddlImportLx = ddlImportLx;
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
	 * @return the txtFilePath
	 */
	public String getTxtFilePath() {
		return txtFilePath;
	}

	/**
	 * @param txtFilePath the txtFilePath to set
	 */
	public void setTxtFilePath(String txtFilePath) {
		this.txtFilePath = txtFilePath;
	}

	/**
	 * @return the pgv00304List
	 */
	public ArrayList<Pgv00304> getPgv00304List() {
		return Pgv00304List;
	}

	/**
	 * @param pgv00304List the pgv00304List to set
	 */
	public void setPgv00304List(ArrayList<Pgv00304> pgv00304List) {
		Pgv00304List = pgv00304List;
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
	 * @return the txtHX
	 */
	public String getTxtHX() {
		return txtHX;
	}

	/**
	 * @param txtHX the txtHX to set
	 */
	public void setTxtHX(String txtHX) {
		this.txtHX = txtHX;
	}

	/**
	 * @return the pgv00001List
	 */
	public ArrayList<Pgv00001> getPgv00001List() {
		return Pgv00001List;
	}

	/**
	 * @param pgv00001List the pgv00001List to set
	 */
	public void setPgv00001List(ArrayList<Pgv00001> pgv00001List) {
		Pgv00001List = pgv00001List;
	}

	/**
	 * @return the pgv00352List
	 */
	public ArrayList<Pgv00352> getPgv00352List() {
		return Pgv00352List;
	}

	/**
	 * @param pgv00352List the pgv00352List to set
	 */
	public void setPgv00352List(ArrayList<Pgv00352> pgv00352List) {
		Pgv00352List = pgv00352List;
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
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageSize() {
		return Common.getPageSize(pageSize);
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}
