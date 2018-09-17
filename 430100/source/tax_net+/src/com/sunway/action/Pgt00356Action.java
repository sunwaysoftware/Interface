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
import com.sunway.service.IPgt00356Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.ConvertUtil;
import com.sunway.util.Excel;
import com.sunway.util.FileUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt00356;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv00356;

/**
 * 市场法物价指数修正系数(Pgt00356)
 * @category 系统维护
 * @author Lee
 * @version 1.0
 */

public class Pgt00356Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 6057511020941252671L;

	//Service
	private IPgt00356Service t00356Service;
	
	//View
	
	//分页参数
	private Integer pageIndex;
	private Integer pageSize;
	private Integer total;
	//Bean数组
	private ArrayList<Pgv00356> rows;
	private ArrayList<Pgv00052> szqyList;
	//查询条件
	private String ddlSZQYFind;
	//Edit
	
	//edit页面所需Bean
	private Pgt00356 t00356Bean;
	//primary key 主键
	private String SZQY;
	private String PSSDYM;
	private String txtPSSD;
	//编辑操作符
	private String ACT;
	//表单提交数据
	private String ddlSZQY;
	private String txtXZXS;
	private String txtNOTE;
	private String txtUPDATE;
	private ArrayList<String> monthList;
	private Boolean isExists;
	
	private String ACTIONNAME;
	private String HREFNAME;
	private String TITLENAME;
	private String URL;
	private String ddlPSSD;
	private SessionCtrl sessionCtrl = new SessionCtrl();

	//file upload
	private File upload;
	private String uploadFileName;
	private String savePath;
	private String fileServerPath;
	
	//file import
	private String txtFilePath;
	private ArrayList<Pgv00356> Pgv00356List;
	private InputStream excelStream;
	private String fileName;
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
		
		Pgv00356 v00356 = new Pgv00356();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准备查询条件
			v00356.setCd00001Szqy(ddlSZQYFind);
			//v00356.setPssd(ConvertUtil.toUtilDate(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD_YMD)));
			v00356.setPageIndex(pageIndex);
			v00356.setPageSize(getPageSize());
			v00356.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			rows = t00356Service.LoadAll(v00356);
			
			//分页设置
			if(null!=rows && rows.size()>0){
				total = rows.get(0).getRecordCount();
			}else{
				total = 0;
				pageIndex = 1;
			}
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
	public String create() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** start **********");
		}
		
		Pgt00356 t00356 = new Pgt00356();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			if(!Constant.MOD_CREATE.equals(getACT())){
				//取得用户选中的数据信息
				t00356.setCd00001Szqy(SZQY);
				t00356.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
				t00356.setCd00002Pssd(PSSDYM);
				t00356Bean = t00356Service.LoadByPrimaryKey(t00356);
				if (CheckUtil.chkEmpty(t00356Bean.getUpddate())) {
					setACT(Constant.MOD_CREATE);
				}
			}
			szqyList = sessionCtrl.ReadSzqyList();
			//getMonthList();
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
	 * 交易价格指数数据导出
	 * @return
	 * @return Exception
	 */
      public String export() throws Exception{
    	  if(LOG.isDebugEnabled()){
    		  LOG.debug("query() ********** start **********");
    	  }
    	  Pgv00356 v00356 =new Pgv00356();
    	 
    	  try{
    		  //sessionCtrl =new SessionCtrl(ActionContext.getContext().getSession());
    	     	v00356.setCd00001Szqy(ddlSZQYFind);
  			    v00356.setPageIndex(1);
  			    v00356.setPageSize(-1);
  			  v00356.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
    		  
  			ByteArrayOutputStream out = (ByteArrayOutputStream) t00356Service.ExportjyjgSjcx(v00356);
			excelStream = new ByteArrayInputStream(out.toByteArray());
    	  }catch(Exception e){
    		  this.addActionError(e.getMessage());
    		  return INPUT;
    	  }
    	  if (LOG.isDebugEnabled()) {
  			LOG.debug("query() ********** end **********");
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
		t00356Bean = new Pgt00356();
		this.clearErrorsAndMessages();	
		t00356Bean.setCd00001Szqy(ddlSZQY);
		t00356Bean.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
		t00356Bean.setCd00002Pssd(PSSDYM);
		//根据PK信息，为数据BEAN赋值
		if (!Constant.MOD_DELETE.equals(getACT())){
			t00356Bean = t00356Service.LoadByPrimaryKey(t00356Bean);			
		}
		//判断PK是否重复
		if((Constant.MOD_CREATE.equals(getACT()))&&(!CheckUtil.chkEmpty(t00356Bean.getUpddate()))){
			this.addActionError(getText("app.msg.error.pk", new String[]{getText("app.xtwh.info.szqy")}));
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(getACT()))&&(!t00356Bean.getUpddate().equals(ConvertUtil.toTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//为数据BEAN赋值
			t00356Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t00356Bean.setXzxs(ConvertUtil.toDouble(txtXZXS));
			t00356Bean.setNote(txtNOTE);
			t00356Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
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
				if(t00356Service.GetInsertCommand(getT00356Bean()))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{getT00356Bean().getCd00001Szqy()}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{getT00356Bean().getCd00001Szqy()}));
			} else if (Constant.MOD_UPDATE.equals(getACT())) {	// Update
				if(t00356Service.GetUpdateCommand(getT00356Bean())){
					t00356Bean = t00356Service.LoadByPrimaryKey(t00356Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getT00356Bean().getCd00001Szqy()}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{getT00356Bean().getCd00001Szqy()}));
			} else if (Constant.MOD_DELETE.equals(getACT())) {	// Delete
				if(t00356Service.GetDeleteCommand(getT00356Bean()))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{getT00356Bean().getCd00001Szqy()}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{getT00356Bean().getCd00001Szqy()}));
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
		
		Pgt00356 t00356 = new Pgt00356();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
				//取得用户选中的数据信息
				t00356.setCd00001Szqy(ddlSZQY);
				t00356.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
				t00356.setCd00002Pssd(PSSDYM);
				t00356Bean = t00356Service.LoadByPrimaryKey(t00356);
				isExists = t00356Bean.getUpddate() == null?true:false;
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
	 * 参数复制功能
	 * @return
	 * @throws Exception
	 */
	public String copyParam() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("copyParam() ********** start **********");
		}
		t00356Bean = new Pgt00356();
		try {
			ReadInfo();
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			t00356Bean.setSpssd(ddlPSSD);
			t00356Bean.setTpssd(txtPSSD);
			t00356Bean.setCd00001Szqy(ddlSZQY);
			t00356Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t00356Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			
			if(t00356Service.ExecuteParamCopy(getT00356Bean()))
				this.addActionMessage(getText(Constant.MSG_COPY_OK, new String[]{getT00356Bean().getSpssd()}));
			else
				this.addActionError(getText(Constant.MSG_COPY_NG, new String[]{getT00356Bean().getSpssd()}));
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("copyParam() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("copyParam() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 为参数复制页面赋值
	 */
	private void ReadInfo(){
		//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
		setACTIONNAME("EXET00356COPY");
		setHREFNAME("VIEWT00356");
		setTITLENAME(getText("app.xtwh.t00356.title"));
		setURL("003569");
		szqyList = sessionCtrl.ReadSzqyList();
	}
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String upload() throws Exception {
		try{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			fileServerPath = getSavePath() + "\\JGZS_" + sessionCtrl.getUserId() + getUploadFileName();
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
	public void validateImportFile() {
		if(!FileUtil.checkFileExist(txtFilePath)){
			this.addActionError("文件错误，请检查！");
		}
		try{

			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//检验数据合法性
			Pgv00356List = Excel.importDataJyjgzs(txtFilePath, sessionCtrl.getUserId(),sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(!checkJyjgzs(Pgv00356List))
				this.addActionError("交易价格指数修正数据不符合导入要求！");
			if(Pgv00356List.size()==0)
				this.addActionError("交易价格指数修正数据不符合导入要求！");
		}catch(Exception ex){
			ex.printStackTrace();
			this.addActionError(ex.getMessage());
		}
	}
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String importFile() throws Exception {
		Pgv00356 tmpV00356 = new Pgv00356();
		try{
			tmpV00356 = t00356Service.ImportExcelData(Pgv00356List);
		}catch(Exception ex){
			ex.printStackTrace();
			this.addActionError(ex.getMessage());
			return INPUT;
		}finally{
			if(tmpV00356.getOutFlag()==3)
				this.addActionError("数据导入失败，请重新选择模版导入！");
			else if(tmpV00356.getOutFlag()==2)
				this.addActionMessage("数据导入执行完毕！");
			else{
				ByteArrayOutputStream out = (ByteArrayOutputStream) Excel.exportDataJyjgzs(tmpV00356.getOutList());
				excelStream = new ByteArrayInputStream(out.toByteArray());
				fileName=new String("格式错误的交易价格指数修正数据.xls".getBytes("GBK"),"ISO-8859-1");
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
	 * 对[挂牌数据]合法性进行检验
	 * @param list
	 * @return
	 */
	private Boolean checkJyjgzs(ArrayList<Pgv00356> list){
		//TODO 处理保留 对[挂牌数据]合法性进行检验
		return true;
	}
/*********************** set and get ******************************/
	
	/**
	 * @return the t00356Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00356Service getT00356Service() {
		return t00356Service;
	}

	/**
	 * @param t00356Service the t00356Service to set
	 */
	public void setT00356Service(IPgt00356Service t00356Service) {
		this.t00356Service = t00356Service;
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
	 * @return the t00356Bean
	 */
	public Pgt00356 getT00356Bean() {
		return t00356Bean;
	}

	/**
	 * @param t00356Bean the t00356Bean to set
	 */
	public void setT00356Bean(Pgt00356 t00356Bean) {
		this.t00356Bean = t00356Bean;
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
	 * @return the pSSDYM
	 */
	public String getPSSDYM() {
		return PSSDYM;
	}

	/**
	 * @param pSSDYM the pSSDYM to set
	 */
	public void setPSSDYM(String pSSDYM) {
		PSSDYM = pSSDYM;
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
	 * @return the aCTIONNAME
	 */
	public String getACTIONNAME() {
		return ACTIONNAME;
	}
	/**
	 * @return the monthList
	 */
	public ArrayList<String> getMonthList() {
		//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
		String pssdYMD=Constant.STRING_EMPTY;
		int year, month , maxMonth= 0;
		monthList =  new ArrayList<String>();
		pssdYMD = sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD_YMD);
		// 从评税时点中截取年，月
		year = ConvertUtil.toInteger(pssdYMD.substring(0, 4));
		month = ConvertUtil.toInteger( pssdYMD.substring(5,7));
		maxMonth = month +12;
		// 循环封装List
		for (; month <= maxMonth; month++) {
			if (month <= 12) {
				if (month <10) {
					monthList.add((year-1)+"0"+month);
				}else{
					monthList.add((year-1)+""+month);
				}
			}else{
				if ((month-12) <10) {
					monthList.add(year+"0"+(month-12));
				}else{
					monthList.add(year+""+(month-12));
				}
			}
		}
		return monthList;
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

	public String getTxtPSSD() {
		return txtPSSD;
	}

	public void setTxtPSSD(String txtPSSD) {
		this.txtPSSD = txtPSSD;
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
	 * @return the pgv00356List
	 */
	public ArrayList<Pgv00356> getPgv00356List() {
		return Pgv00356List;
	}

	/**
	 * @param pgv00356List the pgv00356List to set
	 */
	public void setPgv00356List(ArrayList<Pgv00356> pgv00356List) {
		Pgv00356List = pgv00356List;
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

	/**
	 * @param monthList the monthList to set
	 */
	public void setMonthList(ArrayList<String> monthList) {
		this.monthList = monthList;
	}

	/**
	 * @return the rows
	 */
	public ArrayList<Pgv00356> getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(ArrayList<Pgv00356> rows) {
		this.rows = rows;
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
