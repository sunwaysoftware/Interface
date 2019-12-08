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

import com.sunway.service.IPgt00323Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.Excel;
import com.sunway.util.SessionCtrl;

import com.sunway.vo.Pgt00323;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv00323;



/**
 * 市场法楼层系数修正表(Pgt00321)
 * @category 系统维护
 * @author Lee
 * @version 1.0
 */

public class Pgt00323Action extends ActionSupport implements SessionAware{
	
	private static final long serialVersionUID = 7980781226347820153L;

	//Service
	private IPgt00323Service t00323Service;
	
	//View
	
	//分页参数
	private Integer pageIndex;
	private Integer pageSize;
	private Integer rowCount;
	//Bean数组
	private ArrayList<Pgv00323> tabList;
	private ArrayList<Pgv00052> szqyList;
	//查询条件
	private String ddlSZQYFind;
	private String txtLCFind;
	private String txtZCSFind;
	private String txtPSSDFind;
	//Edit
	
	//edit页面所需Bean
	private Pgt00323 t00323Bean;
	//primary key 主键
	private String LC;
	private String ZCS;
	private String SZQY;
	private String PSSD;
	//编辑操作符
	private String ACT;
	//表单提交数据
	private String ddlSZQY;
	private String txtLC;
	private String txtZCS;
	private String txtXZXS;
	private String txtNOTE;
	private String txtUPDATE;
	private Boolean isExists;
	private String txtPSSD;
	private String rdoCZLX;
	
	private String ACTIONNAME;
	private String HREFNAME;
	private String TITLENAME;
	private String URL;
	private String ddlPSSD;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	private Integer txtCZLX;
	private String chkSel;
	//private Integer YWDT;
	//private Integer rdoYWDT;
	private String txtFWLX;
	private InputStream excelStream;
	private String txtFilePath;
	private ArrayList<Pgv00323> ebList;
	private String fileName;
	//file upload
	private String title;
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private String savePath;
	private String fileServerPath;
	private String txtXQFind;
	/* (non-Javadoc)
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
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}
		
		Pgv00323 v00323 = new Pgv00323();
		try { 
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准备查询条件
			v00323.setCd00001Szqy(ddlSZQYFind);
			v00323.setCd00352Xqdm(txtXQFind);
			v00323.setPageIndex(pageIndex);
			v00323.setPageSize(getPageSize());
			v00323.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			tabList = t00323Service.LoadAll(v00323);
			
			//分页设置
			if(null!=tabList && tabList.size()>0){
				rowCount = tabList.get(0).getRecordCount();
			}else{
				rowCount = 0;
				pageIndex = 1;
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());
			return ERROR;
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;
	}
	/**
	 *查询信息导出
	 * @return
	 * @throws Exception
	 */
	public String export() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}
		
		Pgv00323 v00323 = new Pgv00323();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准备查询条件
			v00323.setCd00001Szqy(ddlSZQYFind);
			v00323.setCd00352Xqdm(txtXQFind);
			v00323.setPageIndex(1);
			v00323.setPageSize(-1);
			v00323.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			
			ByteArrayOutputStream out = (ByteArrayOutputStream) t00323Service.ExportLCXZSjcx(v00323);
			setExcelStream(new ByteArrayInputStream(out.toByteArray()));
		}catch (Exception e) {
			LOG.error(e.getMessage());
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
	public String create() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** start **********");
		}
		
		Pgt00323 t00323 = new Pgt00323();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			if(!Constant.MOD_CREATE.equals(getACT())){
				//取得用户选中的数据信息
				t00323.setLc(Common.convertToShort(LC));
				//t00355.setYwdt(YWDT);
				t00323.setCd00001Fwlx(txtFWLX);
				t00323.setZcs(Common.convertToShort(ZCS));
				t00323.setCd00001Szqy(SZQY);
				t00323.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
				t00323.setCd00002Pssd(Common.trim(PSSD));
				t00323Bean = t00323Service.LoadByPrimaryKey(t00323);
				if (Common.isNullOrEmpty(t00323Bean.getUpddate())) {
					setACT(Constant.MOD_CREATE);
				}
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
	 * @throws Exception
	 */
	public void validateUpdate() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("validateUpdate() ********** start **********");
		}
		//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
		t00323Bean = new Pgt00323();
		this.clearErrorsAndMessages();	
		t00323Bean.setLc(Common.convertToShort(txtLC));
		//t00355Bean.setYwdt(rdoYWDT);
		t00323Bean.setCd00001Fwlx(txtFWLX);
		t00323Bean.setZcs(Common.convertToShort(txtZCS));
		t00323Bean.setCd00001Szqy(ddlSZQY);
		t00323Bean.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
		t00323Bean.setCd00002Pssd(Common.trim(txtPSSD));
		//根据PK信息，为数据BEAN赋值
		if (!Constant.MOD_DELETE.equals(getACT())){
			t00323Bean = t00323Service.LoadByPrimaryKey(t00323Bean);			
		}
		//判断PK是否重复
		if((Constant.MOD_CREATE.equals(getACT()))&&(!Common.isNullOrEmpty(t00323Bean.getUpddate()))){
			this.addActionError(getText("app.msg.error.pk", new String[]{getText("app.xtwh.info.szqy")}));
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(getACT()))&&(!t00323Bean.getUpddate().equals(Common.convertStringToTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//为数据BEAN赋值
			t00323Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t00323Bean.setXzxs(Common.convertToDouble(txtXZXS));
			t00323Bean.setNote(txtNOTE);
			
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("validateUpdate() ********** end **********");
		}
	}
	
	/**
	 * 更新信息处理
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** start **********");
		}

		try {
			if(Constant.MOD_CREATE.equals(getACT())){			// Create
				if(t00323Service.GetInsertCommand(getT00323Bean()))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{getT00323Bean().getCd00001Szqy()}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{getT00323Bean().getCd00001Szqy()}));
			} else if (Constant.MOD_UPDATE.equals(getACT())) {	// Update
				if(t00323Service.GetUpdateCommand(getT00323Bean())){
					t00323Bean = t00323Service.LoadByPrimaryKey(t00323Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getT00323Bean().getCd00001Szqy()}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{getT00323Bean().getCd00001Szqy()}));
			} else if (Constant.MOD_DELETE.equals(getACT())) {	// Delete
				if(t00323Service.GetDeleteCommand(getT00323Bean()))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{getT00323Bean().getCd00001Szqy()}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{getT00323Bean().getCd00001Szqy()}));
			}			
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
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
		return SUCCESS;
	}
	/**
	 * 点击单选按钮的ajax事件，
	 * @return 如果有值填充，没有则返回NULL
	 * @throws Exception
	 */
	public String createByAjax() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("createByAjax() ********** start **********");
		}
		
		Pgt00323 t00323 = new Pgt00323();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
				//取得用户选中的数据信息
				t00323.setLc(Common.convertToShort(txtLC));
				t00323.setCd00001Fwlx(txtFWLX);
				//t00355.setYwdt(YWDT);
				t00323.setZcs(Common.convertToShort(txtZCS));
				t00323.setCd00001Szqy(ddlSZQY);
				t00323.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
				t00323.setCd00002Pssd(Common.trim(PSSD));
				t00323Bean = t00323Service.LoadByPrimaryKey(t00323);
				isExists = t00323Bean.getUpddate() == null?true:false;
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("createByAjax() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("createByAjax() ********** end **********");
		}
		return SUCCESS;
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String viewCopy() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("viewCopy()********** start **********");
		}

		try {
		
			ReadInfo();
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("viewCopy() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("viewCopy() ********** end **********");
		}
		return SUCCESS;
	}
	
	
	/**
	 * 查询状态处理
	 *
	 * @return
	 * @throws Exception
	 */
	public String delsel() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}

		Pgv00323 v00323 = new Pgv00323();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			v00323.setChkSel(chkSel);	
			v00323.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			v00323.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			// 执行查询
			t00323Service.GetDeleteSelCommand(v00323);
			
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
	 * 为参数复制页面赋值
	 */
	private void ReadInfo(){
		//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
		setACTIONNAME("EXET00355COPY");
		setHREFNAME("VIEWT00355");
		setTITLENAME(getText("app.xtwh.t00355.title"));
		setURL("003559");
		szqyList = sessionCtrl.ReadSzqyList();
	}
	

	/**
	 * 文件导入
	 * @return
	 * @throws Exception
	 */
	public String upload() throws Exception {
		try{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			fileServerPath = getSavePath() + "\\ZJSJ_" + sessionCtrl.getUserId() + getUploadFileName();
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
	/**
	 * 导入校验
	 */
	public void validateImportFile() {
		if(!Common.isFileExist(txtFilePath)){
			this.addActionError("文件错误，请检查！");
		}
		try{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//检验数据合法性
			ebList = Excel.ZJExcel(txtFilePath, sessionCtrl.getUserId(),sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(!checkDateList(ebList))
				this.addActionError("中介数据不符合导入要求！");
			if(ebList.size()==0)
				this.addActionError("中介数据不符合导入要求！");
		}catch(Exception ex){
			ex.printStackTrace();
			this.addActionError("中介数据不符合导入要求！"+ex.getMessage());
		}
	}
	
	/**
	 * 估价分区数据导入
	 * @return
	 * @throws Exception
	 */
	public String importFile() throws Exception {
		Pgv00323 eBean = new Pgv00323();
		try{
			eBean = t00323Service.ImportExcelData(ebList);
		}catch(Exception ex){
			ex.printStackTrace();
			this.addActionError(ex.getMessage());
			return INPUT;
		}finally{
			if(eBean.getOutFlag()==3)
				this.addActionError("数据导入失败，请重新选择模版导入！");
			else if(eBean.getOutFlag()==2)
				this.addActionMessage("数据导入执行完毕！");
			else{
				ByteArrayOutputStream out = (ByteArrayOutputStream) Excel.exportDataZJ(eBean.getOutList(),1);
				excelStream = new ByteArrayInputStream(out.toByteArray());
				fileName=new String("格式错误的中介数据.xls".getBytes("GBK"),"ISO-8859-1");
				return "failexport";
			}
			/*
			else if (tmpV00352.getOutFlag()==1)
				this.addActionMessage("数据导入执行完毕，但导入过程中部分失败！");
			else 
				this.addActionError("数据导入失败！");
			*/
		}
		return SUCCESS;
	}

	/**
	 * 对[估价分区]合法性进行检验
	 * @param list
	 * @return
	 */
	private Boolean checkDateList(ArrayList<Pgv00323> list){
		//TODO 处理保留 对[估价分区]合法性进行检验
		return true;
	}
/*********************** set and get ******************************/
	
	/**
	 * @return the t00355Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00323Service getT00323Service() {
		return t00323Service;
	}

	/**
	 * @param t00355Service the t00355Service to set
	 */
	public void setT00323Service(IPgt00323Service t00323Service) {
		this.t00323Service = t00323Service;
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
	 * @return the txtLCFind
	 */
	public String getTxtLCFind() {
		return txtLCFind;
	}

	/**
	 * @param txtLCFind the txtLCFind to set
	 */
	public void setTxtLCFind(String txtLCFind) {
		this.txtLCFind = txtLCFind;
	}

	/**
	 * @return the txtZCSFind
	 */
	public String getTxtZCSFind() {
		return txtZCSFind;
	}

	/**
	 * @param txtZCSFind the txtZCSFind to set
	 */
	public void setTxtZCSFind(String txtZCSFind) {
		this.txtZCSFind = txtZCSFind;
	}

	/**
	 * @return the txtPSSDFind
	 */
	public String getTxtPSSDFind() {
		return txtPSSDFind;
	}

	/**
	 * @param txtPSSDFind the txtPSSDFind to set
	 */
	public void setTxtPSSDFind(String txtPSSDFind) {
		this.txtPSSDFind = txtPSSDFind;
	}

	/**
	 * @return the t00355Bean
	 */
	public Pgt00323 getT00323Bean() {
		return t00323Bean;
	}

	/**
	 * @param t00355Bean the t00355Bean to set
	 */
	public void setT00323Bean(Pgt00323 t00323Bean) {
		this.t00323Bean = t00323Bean;
	}

	/**
	 * @return the lC
	 */
	public String getLC() {
		return LC;
	}

	/**
	 * @param lC the lC to set
	 */
	public void setLC(String lC) {
		LC = lC;
	}

	/**
	 * @return the zCS
	 */
	public String getZCS() {
		return ZCS;
	}

	/**
	 * @param zCS the zCS to set
	 */
	public void setZCS(String zCS) {
		ZCS = zCS;
	}

	/**
	 * @return the sZQY
	 */
	public String getSZQY() {
		return SZQY;
	}

	/**
	 * @param sZQY the sZQY to set
	 */
	public void setSZQY(String sZQY) {
		SZQY = sZQY;
	}

	/**
	 * @return the pSSD
	 */
	public String getPSSD() {
		return PSSD;
	}

	/**
	 * @param pSSD the pSSD to set
	 */
	public void setPSSD(String pSSD) {
		PSSD = pSSD;
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
	 * @return the txtLC
	 */
	public String getTxtLC() {
		return txtLC;
	}

	/**
	 * @param txtLC the txtLC to set
	 */
	public void setTxtLC(String txtLC) {
		this.txtLC = txtLC;
	}

	/**
	 * @return the txtZCS
	 */
	public String getTxtZCS() {
		return txtZCS;
	}

	/**
	 * @param txtZCS the txtZCS to set
	 */
	public void setTxtZCS(String txtZCS) {
		this.txtZCS = txtZCS;
	}

	/**
	 * @return the txtXZXS
	 */
	public String getTxtXZXS() {
		return txtXZXS;
	}

	/**
	 * @param txtXZXS the txtXZXS to set
	 */
	public void setTxtXZXS(String txtXZXS) {
		this.txtXZXS = txtXZXS;
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
	 * @return the isExists
	 */
	public Boolean getIsExists() {
		return isExists;
	}

	/**
	 * @param isExists the isExists to set
	 */
	public void setIsExists(Boolean isExists) {
		this.isExists = isExists;
	}

	/**
	 * @return the txtPSSD
	 */
	public String getTxtPSSD() {
		return txtPSSD;
	}

	/**
	 * @param txtPSSD the txtPSSD to set
	 */
	public void setTxtPSSD(String txtPSSD) {
		this.txtPSSD = txtPSSD;
	}

	/**
	 * @return the aCTIONNAME
	 */
	public String getACTIONNAME() {
		return ACTIONNAME;
	}

	/**
	 * @param aCTIONNAME the aCTIONNAME to set
	 */
	public void setACTIONNAME(String aCTIONNAME) {
		ACTIONNAME = aCTIONNAME;
	}

	/**
	 * @return the hREFNAME
	 */
	public String getHREFNAME() {
		return HREFNAME;
	}

	/**
	 * @param hREFNAME the hREFNAME to set
	 */
	public void setHREFNAME(String hREFNAME) {
		HREFNAME = hREFNAME;
	}

	/**
	 * @return the tITLENAME
	 */
	public String getTITLENAME() {
		return TITLENAME;
	}

	/**
	 * @param tITLENAME the tITLENAME to set
	 */
	public void setTITLENAME(String tITLENAME) {
		TITLENAME = tITLENAME;
	}

	/**
	 * @return the uRL
	 */
	public String getURL() {
		return URL;
	}

	/**
	 * @param uRL the uRL to set
	 */
	public void setURL(String uRL) {
		URL = uRL;
	}

	/**
	 * @return the ddlPSSD
	 */
	public String getDdlPSSD() {
		return ddlPSSD;
	}

	/**
	 * @param ddlPSSD the ddlPSSD to set
	 */
	public void setDdlPSSD(String ddlPSSD) {
		this.ddlPSSD = ddlPSSD;
	}

	/**
	 * @param txtCZLX the txtCZLX to set
	 */
	public void setTxtCZLX(Integer txtCZLX) {
		this.txtCZLX = txtCZLX;
	}

	/**
	 * @return the txtCZLX
	 */
	public Integer getTxtCZLX() {
		return txtCZLX;
	}
	
	/*public Integer getRdoYWDT() {
		return rdoYWDT;
	}

	public void setRdoYWDT(Integer rdoYWDT) {
		this.rdoYWDT = rdoYWDT;
	}

	public Integer getYWDT() {
		return YWDT;
	}
	public void setYWDT(Integer yWDT) {
		YWDT = yWDT;
	}
	*/

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
	 * @return the sessionCtrl
	 */
	public SessionCtrl getSessionCtrl() {
		return sessionCtrl;
	}

	/**
	 * @param sessionCtrl the sessionCtrl to set
	 */
	public void setSessionCtrl(SessionCtrl sessionCtrl) {
		this.sessionCtrl = sessionCtrl;
	}

	/**
	 * @return the ebList
	 */
	public ArrayList<Pgv00323> getEbList() {
		return ebList;
	}

	/**
	 * @param ebList the ebList to set
	 */
	public void setEbList(ArrayList<Pgv00323> ebList) {
		this.ebList = ebList;
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
	 * 
	 * @return
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
	 * @return the tabList
	 */
	public ArrayList<Pgv00323> getTabList() {
		return tabList;
	}

	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv00323> tabList) {
		this.tabList = tabList;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageSize() {
		return Common.getPageSize(pageSize);
	}

	public String getRdoCZLX() {
		return rdoCZLX;
	}

	public void setRdoCZLX(String rdoCZLX) {
		this.rdoCZLX = rdoCZLX;
	}

	public String getTxtXQFind() {
		return txtXQFind;
	}

	public void setTxtXQFind(String txtXQFind) {
		this.txtXQFind = txtXQFind;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}

}
