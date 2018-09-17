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
import com.sunway.service.IPgt00306Service;
import com.sunway.service.IPgt00320Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.Constant;
import com.sunway.util.ConvertUtil;
import com.sunway.util.Excel;
import com.sunway.util.FileUtil;
import com.sunway.util.FormatUtil;
import com.sunway.util.MakeUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv00306;
import com.sunway.vo.Pgv00320;


/**
 * 楼房相关信息
 * @author LiuYang
 *
 */
public class Pgt00306Action extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = -4938741567631993907L;
	
	private IPgt00306Service t00306Service;
	private IPgt00320Service t00320Service;
	
	//编辑操作符
	private String ACT;
	//list
	private ArrayList infoList;
	private ArrayList lostList;
	private ArrayList<Pgv00320> t00320List;
	private ArrayList<Pgv00306> rows;
	private ArrayList<Pgv00052> szqyList;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	//分页
	private Integer pageSize;
	private Integer pageIndex;
	private Integer total;
	//查询条件
	private String ddlSZQYFind;
	private String txtXQFind;
	private String txtSSGX;
	//FRAME KEY
	private String zpFk;

	//导出页面
	private InputStream excelStream;

	//file upload
	private File upload;
	private String fileServerPath;
	private String savePath;
	private String uploadFileName;
	//file import
	private String txtFilePath;
	private String fileName;
	private ArrayList<Pgv00306> Pgv00306List;

	//表单提交
	private String userRole;
    private String txtUPDATE;
    private String id;
    private String ddlSZQY;
    private String txtXQDM;
    private String txtLH;
    private String txtNOTE;						//房屋坐落地址
    private Integer txtZLC;
	private Integer txtDYGS;
	private String txtCLH;
	private String txtZCDZL;
	private String txtXQNM;
	private String txtXQTIP;
	//edit页面所需Bean
	private Pgv00306 v00306Bean;
	
	private String SysDate;
	
	//通用返回信息及标识
	private String resSign;
	private String resMsg;
	
	
	@Override
	public String execute() throws Exception {
		if(LOG.isDebugEnabled()){
			LOG.debug("execute() ********** start **********");
		}
		//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		try{
			ReadInfo();
		} catch (Exception e) {
			LOG.error(e.getMessage());
			return INPUT;
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("execute() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 读取数据
	 * @return
	 * @throws Exception
	 */
	public String query()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("query() ********** start **********");
		}
		//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
		try{
			Pgv00306 v00306 = new Pgv00306();
			v00306.setPageIndex(pageIndex);
			v00306.setPageSize(getPageSize());
			v00306.setCd00001Szqy(ddlSZQYFind);
			v00306.setXqnm(FormatUtil.toSearchLike(txtXQTIP));
			v00306.setZcdzl(FormatUtil.toSearchLike(txtZCDZL));
			if(null != txtSSGX && !"".equals(txtSSGX)){
				v00306.setCd00001Ssgx(txtSSGX);
			}else{
				v00306.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			}
			rows = t00306Service.LoadAll(v00306);
			// 分页设置
			if (null != rows && rows.size() > 0) {
				total = rows.get(0).getRecordCount();
			} else {
				pageIndex = 1;
				total = 0;
			}
		}catch(Exception e){
			LOG.error(e.getMessage());
			if(LOG.isDebugEnabled()){
				LOG.debug("query() ********** end **********");
			}
			return INPUT;
		}		
		if(LOG.isDebugEnabled()){
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;
	}
	
	

	public String create() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** start **********");
		}

		Pgv00306 v00306 = new Pgv00306();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			if(!Constant.MOD_CREATE.equals(getACT())){
				//取得用户选中的数据信息
				v00306.setId(id);
				v00306Bean = t00306Service.LoadByPrimaryKey(v00306);
				if (CheckUtil.chkEmpty(v00306Bean.getUpddate())) {
					setACT(Constant.MOD_CREATE);
				}
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("create() ********** end **********");
			}
			return ERROR;
		} finally {
			szqyList = sessionCtrl.ReadSzqyList();
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
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
		v00306Bean = new Pgv00306();
		//this.clearErrorsAndMessages();	
		ReadInfo();
		  v00306Bean.setId(id);
		//根据PK信息，为数据BEAN赋值
		if (!Constant.MOD_DELETE.equals(getACT())){
			v00306Bean = t00306Service.LoadByPrimaryKey(v00306Bean);			
		}
		//判断PK是否重复
		if((Constant.MOD_CREATE.equals(getACT()))&&(!CheckUtil.chkEmpty(v00306Bean.getUpddate()))){
			this.addActionError(getText("app.msg.error.pk", new String[]{getText("app.xtwh.info.szqy")}));
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(getACT()))&&(!v00306Bean.getUpddate().equals(ConvertUtil.toTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//为数据BEAN赋值
			v00306Bean.setCd00352Xqdm(txtXQDM);
			v00306Bean.setLh(txtLH);
			v00306Bean.setZlc(txtZLC);
			v00306Bean.setDygs(txtDYGS);
			v00306Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			v00306Bean.setNote(txtNOTE);
			v00306Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v00306Bean.setClh(txtCLH);
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
		System.out.println("this");
		String rtn = "success";
		try {
			if(Constant.MOD_CREATE.equals(getACT())){			// Create
				if(t00306Service.GetInsertCommand(getV00306Bean()))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{getText("app.xtwh.t00361.cs")}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{getText("app.xtwh.t00361.cs")}));
			} else if (Constant.MOD_UPDATE.equals(getACT())) {	// Update
				if(t00306Service.GetUpdateCommand(getV00306Bean())){
					v00306Bean = t00306Service.LoadByPrimaryKey(v00306Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getText("app.xtwh.t00361.cs")}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{getText("app.xtwh.t00361.cs")}));
			} else if (Constant.MOD_DELETE.equals(getACT())) {	// Delete
				if(t00306Service.GetDeleteCommand(getV00306Bean()))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{getText("app.xtwh.t00361.cs")}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{getText("app.xtwh.t00361.cs")}));
				rtn = "successDEL";
			}			
		} catch (Exception e) {
			LOG.error(e.getMessage());
			String errMsg[] = e.getMessage().split("\n");
			this.addActionError(errMsg[0]);
			return INPUT;
		} finally {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			szqyList = sessionCtrl.ReadSzqyList();
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** end **********");
		}
		return rtn;
	}
	
	/**
	 * 信息导出
	 */
	public String exportT00306()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("exportT00360() ********** start **********");
		}
		//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
		Pgv00306 v00306 = new Pgv00306();
		try {
			//准备查询条件
			
			v00306.setPageIndex(1);
			v00306.setPageSize(-1);
			v00306.setCd00001Szqy(ddlSZQYFind);
			v00306.setXqnm(FormatUtil.toSearchLike(txtXQTIP));
			v00306.setZcdzl(FormatUtil.toSearchLike(txtZCDZL));
			v00306.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v00306.setCd00002Czr(sessionCtrl.getUserId());
			ByteArrayOutputStream out = (ByteArrayOutputStream)t00306Service.ExportT00306(v00306);
			setExcelStream(new ByteArrayInputStream(out.toByteArray()));
		}catch(Exception e){
			LOG.error(e.getMessage());
			if(LOG.isDebugEnabled()){
				LOG.debug("exportT00306() ********** end **********");
			}
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
			return INPUT;
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("exportT00360() ********** end **********");
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		return SUCCESS;
	}
	
	
	
	/**
	 * 文件上传
	 */
	public String upload() throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("upload() ********** start **********");
		}
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			String fileName = "LFPC_" + sessionCtrl.getUserId() + getUploadFileName().substring(getUploadFileName().lastIndexOf("."));
//			fileServerPath = getSavePath() + "\\" + getUploadFileName();
			fileServerPath = getSavePath() + "\\" + fileName;
			//将上传文件路径装入SESSION
			//Common.addUploadFiles(fileServerPath);
			fis = new FileInputStream(getUpload());
			fos = new FileOutputStream(fileServerPath);
			
			byte[] buffer = new byte[1024];
			int len = 0;
			while((len = fis.read(buffer)) > 0){
				fos.write(buffer,0,len);
			}
			fos.close();
			fis.close();
		}catch(Exception e){
			LOG.error(e.getMessage());
			fos.close();
			fis.close();
			if(LOG.isDebugEnabled()){
				LOG.debug("upload() ********** end **********");
			}
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
			return INPUT;
		}finally{
			fos = null;
			fis = null;
		}
		
		
		if(LOG.isDebugEnabled()){
			LOG.debug("upload() ********** end **********");
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		return SUCCESS;
	}
	
	
	/**
	 * 文件导入前的验证
	 */
	public void validateImportFile() throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("validateImportFile() ********** start **********");
		}
		
		if(!FileUtil.checkFileExist(txtFilePath)){
			this.addActionError("文件错误，请检查");
		}
		try{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			Pgv00306List = Excel.importDataLFXX(txtFilePath, sessionCtrl.getUserId(), sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(!checkLFXX(Pgv00306List)){
				this.addActionError("数据不符合导入要求");
			}
			if(Pgv00306List.size() == 0){
				this.addActionError("数据不符合导入要求");
			}
		}catch(Exception e){
			LOG.error(e.getMessage());
			this.addActionError("数据不符合导入要求:"+e.getMessage());
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("validateImportFile() ********** end **********");
		}
		
	}	
	
	private boolean checkLFXX(ArrayList<Pgv00306> v00360List){
		return true;
	}
	
	/**
	 * 文件导入
	 */
	public String importFile()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("importFile() ********** start **********");
		}
		
		try{
			Pgv00306 result = t00306Service.ImportExcelData(Pgv00306List);
			if(result.getOutFlag() == 2){
				this.addActionMessage("数据导入成功");
			}else{
				ByteArrayOutputStream out = (ByteArrayOutputStream)Excel.exportDataMLFXX(result.getOutList());
				excelStream = new ByteArrayInputStream(out.toByteArray());
				fileName = new String("格式错误的楼房信息数据.xls".getBytes("GBK"),"ISO-8859-1");
				return "failexport";
			}
		}catch(Exception e){
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());
			if(LOG.isDebugEnabled()){
				LOG.debug("importFile() ********** end **********");
			}
			return INPUT;
		}
		if(LOG.isDebugEnabled()){
			LOG.debug("importFile() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 查询楼房相关
	 * @return
	 * @throws Exception
	 */
	public String frame()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("frame() ********** start **********");
		}
		this.clearErrorsAndMessages();
		try{
			
			t00320List = new ArrayList<Pgv00320>();
			Pgv00320 v00320 = new Pgv00320();
			v00320.setCd00306Id(zpFk);			
			t00320List = t00320Service.LoadByLhXqdm(v00320);
			
			Pgv00306 v00306 = new Pgv00306();
			v00306.setId(zpFk);			
			v00306Bean = t00306Service.LoadByPrimaryKey(v00306);
			
			createList(v00306Bean.getZlc(),v00306Bean.getDygs());
			lostList = new ArrayList();
			for(int i = 0; i < t00320List.size(); i++){
				setList(t00320List.get(i));
			}
			SysDate = MakeUtil.currentDate();
		}catch(Exception e){
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());
			if(LOG.isDebugEnabled()){
				LOG.debug("frame() ********** end **********");
			}
			return INPUT;
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("frame() ********** end **********");
		}
		return SUCCESS;
	}

	
	
	private void setList(Pgv00320 v00320Bean){
		if ((v00320Bean.getSzlc()>infoList.size()) || (v00320Bean.getSzlc() <= 0))
		{			
			lostList.add(v00320Bean);
			return;
		}
		ArrayList zcsList = (ArrayList)infoList.get(v00320Bean.getSzlc()-1);
		if ((ConvertUtil.toInteger(v00320Bean.getDyh()) > zcsList.size()) || ((ConvertUtil.toInteger(v00320Bean.getDyh()) <= 0)))
		{		
			lostList.add(v00320Bean);
			return;
		}
		ArrayList dyhList = (ArrayList)zcsList.get(ConvertUtil.toInteger(v00320Bean.getDyh())-1);
		dyhList.add(v00320Bean);
	}
	
	/**
	 * 读取【所在区域】
	 */
	private void ReadInfo() {
		szqyList = sessionCtrl.ReadSzqyList();
	}	

		
	
	/*
	 * 创建列表
	 */
	
	private void createList(int zcs,int dyh){
		infoList = new ArrayList<Pgv00320>();
		for(int j = 1;j <= zcs;j++){
			ArrayList zcsList = new ArrayList();
			for(int k = 1;k <= dyh;k++){
				ArrayList dyhList = new ArrayList();				
				zcsList.add(dyhList);
			}
			
			infoList.add(zcsList);
		}		
		
	}
	
	
	
	/**
	 * 根据所在区域、坐落地址获取信息
	 * @return
	 * @throws Exception
	 */
	public String loadByZCDZL()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("loadByZCDZL() ********** start **********");
		}
		//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			
		try{
			Pgv00306 v00306 = new Pgv00306();
			v00306.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v00306.setNote(CheckUtil.chkTrim(txtNOTE));
			v00306.setClh(CheckUtil.chkTrim(txtCLH));
			v00306Bean = t00306Service.LoadByZCDZL(v00306);
			resSign = "1";    //返回标识，1标识成功，0标识错误
		}catch(Exception e){
			LOG.error(e.getMessage());
			resSign = "0";
			resMsg = "后台查询出错：" + e.getMessage();
			return SUCCESS;
		}finally{
			//
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("loadByZCDZL() ********** end **********");
		}
		return SUCCESS;
	}
		
	
/*********************************   set &&  get   *****************************************/

	@JSON(deserialize=false, serialize=false)
	public IPgt00306Service getT00306Service() {
		return t00306Service;
	}

	public void setT00306Service(IPgt00306Service t00306Service) {
		this.t00306Service = t00306Service;
	}


	@JSON(deserialize=false, serialize=false)
	public IPgt00320Service getT00320Service() {
		return t00320Service;
	}



	public void setT00320Service(IPgt00320Service t00320Service) {
		this.t00320Service = t00320Service;
	}

	public ArrayList getInfoList() {
		return infoList;
	}

	public void setInfoList(ArrayList infoList) {
		this.infoList = infoList;
	}

	public ArrayList<Pgv00320> getT00320List() {
		return t00320List;
	}



	public void setT00320List(ArrayList<Pgv00320> t00320List) {
		this.t00320List = t00320List;
	}



	public SessionCtrl getSessionCtrl() {
		return sessionCtrl;
	}



	public void setSessionCtrl(SessionCtrl sessionCtrl) {
		this.sessionCtrl = sessionCtrl;
	}



	public Integer getPageSize() {
		return pageSize;
	}



	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}



	public Integer getPageIndex() {
		return pageIndex;
	}



	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}



	public String getDdlSZQYFind() {
		return ddlSZQYFind;
	}



	public void setDdlSZQYFind(String ddlSZQYFind) {
		this.ddlSZQYFind = ddlSZQYFind;
	}



	public String getTxtXQFind() {
		return txtXQFind;
	}



	public void setTxtXQFind(String txtXQFind) {
		this.txtXQFind = txtXQFind;
	}



	public String getTxtSSGX() {
		return txtSSGX;
	}



	public void setTxtSSGX(String txtSSGX) {
		this.txtSSGX = txtSSGX;
	}

	public ArrayList<Pgv00306> getRows() {
		return rows;
	}

	public void setRows(ArrayList<Pgv00306> rows) {
		this.rows = rows;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
	
	public ArrayList<Pgv00052> getSzqyList() {
		return szqyList;
	}


	public String getZpFk() {
		return zpFk;
	}

	public void setZpFk(String zpFk) {
		this.zpFk = zpFk;
	}


	public void setSzqyList(ArrayList<Pgv00052> szqyList) {
		this.szqyList = szqyList;
	}
	
	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getACT() {
		return ACT;
	}

	public void setACT(String aCT) {
		ACT = aCT;
	}

	
	public Pgv00306 getV00306Bean() {
		return v00306Bean;
	}

	public void setV00306Bean(Pgv00306 v00306Bean) {
		this.v00306Bean = v00306Bean;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDdlSZQY() {
		return ddlSZQY;
	}

	public void setDdlSZQY(String ddlSZQY) {
		this.ddlSZQY = ddlSZQY;
	}
	
	public String getTxtNOTE() {
		return txtNOTE;
	}

	public void setTxtNOTE(String txtNOTE) {
		this.txtNOTE = txtNOTE;
	}

	public String getTxtUPDATE() {
		return txtUPDATE;
	}

	public void setTxtUPDATE(String txtUPDATE) {
		this.txtUPDATE = txtUPDATE;
	}
	
	public String getTxtXQDM() {
		return txtXQDM;
	}

	public void setTxtXQDM(String txtXQDM) {
		this.txtXQDM = txtXQDM;
	}
	
	public String getTxtLH() {
		return txtLH;
	}

	public void setTxtLH(String txtLH) {
		this.txtLH = txtLH;
	}
	public Integer getTxtZLC() {
		return txtZLC;
	}

	public void setTxtZLC(Integer txtZLC) {
		this.txtZLC = txtZLC;
	}
	public Integer getTxtDYGS() {
		return txtDYGS;
	}

	public void setTxtDYGS(Integer txtDYGS) {
		this.txtDYGS = txtDYGS;
	}
	
	public InputStream getExcelStream() {
		return excelStream;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}
	
	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getFileServerPath() {
		return fileServerPath;
	}

	public void setFileServerPath(String fileServerPath) {
		this.fileServerPath = fileServerPath;
	}

	@SuppressWarnings("deprecation")
	public String getSavePath() {
		return ServletActionContext.getRequest().getRealPath(savePath);
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	
	public String getTxtFilePath() {
		return txtFilePath;
	}

	public void setTxtFilePath(String txtFilePath) {
		this.txtFilePath = txtFilePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public ArrayList<Pgv00306> getPgv00306List() {
		return Pgv00306List;
	}

	public void setPgv00306List(ArrayList<Pgv00306> pgv00306List) {
		Pgv00306List = pgv00306List;
	}

	public String getSysDate() {
		return SysDate;
	}

	public void setSysDate(String sysDate) {
		SysDate = sysDate;
	}

	public ArrayList getLostList() {
		return lostList;
	}

	public void setLostList(ArrayList lostList) {
		this.lostList = lostList;
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

	/**
	 * @return the txtCLH
	 */
	public String getTxtCLH() {
		return txtCLH;
	}

	/**
	 * @param txtCLH the txtCLH to set
	 */
	public void setTxtCLH(String txtCLH) {
		this.txtCLH = txtCLH;
	}

	/**
	 * @return the txtZCDZL
	 */
	public String getTxtZCDZL() {
		return txtZCDZL;
	}

	/**
	 * @param txtZCDZL the txtZCDZL to set
	 */
	public void setTxtZCDZL(String txtZCDZL) {
		this.txtZCDZL = txtZCDZL;
	}

	/**
	 * @return the txtXQNM
	 */
	public String getTxtXQNM() {
		return txtXQNM;
	}

	/**
	 * @param txtXQNM the txtXQNM to set
	 */
	public void setTxtXQNM(String txtXQNM) {
		this.txtXQNM = txtXQNM;
	}

	/**
	 * @return the txtXQTIP
	 */
	public String getTxtXQTIP() {
		return txtXQTIP;
	}

	/**
	 * @param txtXQTIP the txtXQTIP to set
	 */
	public void setTxtXQTIP(String txtXQTIP) {
		this.txtXQTIP = txtXQTIP;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}


}
