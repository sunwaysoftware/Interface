package com.sunway.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt02052Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.ConvertUtil;
import com.sunway.util.Excel;
import com.sunway.util.FileUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt02052;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv02052;




/**
 * 商业建筑层次修正表(Pgt02052)
 * @category 系统维护
 * @author Lee
 * @version 1.0
 */
public class Pgt02052Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -8399733998635338526L;

	//Service
	private IPgt02052Service t02052Service;
	
	//View
	
	//分页参数
	private Integer pageSize;
	private Integer pageIndex;
	private Integer total;
	

	//Bean数组
	private ArrayList<Pgv02052> lcxzList;
	private ArrayList<Pgv00052> szqyList;
	private ArrayList<Pgv02052> rows;
	//查询条件
	private String ddlSZQYFind;
	private String txtLCFind;
	private String txtZCSFind;
	private String txtFWLXFind;
	private String txtXQFind;
	//Edit
	
	//edit页面所需Bean
	private Pgt02052 t02052Bean;
	//primary key 主键
	private String txtID;

	//编辑操作符
	private String ACT;
	//表单提交数据
	private String ddlSZQY;
	private String txtLC;
	private String txtZCS;
	private String txtFWLX;
	private String txtXQDM;
	private String txtXZXS;
	private String txtNOTE;
	private String txtUPDATE;
	private Boolean isExists;
	
	private String ACTIONNAME;
	private String HREFNAME;
	private String TITLENAME;
	private String URL;
	private SessionCtrl sessionCtrl=new SessionCtrl();
	private Integer txtCZLX;
	private String userRole;
	
	private InputStream excelStream;
	
	//file upload
	private File upload;
	private String uploadFileName;
	private String savePath;
	private String fileServerPath;
	
	//file import
	private String txtFilePath;
	private ArrayList<Pgv02052> Pgv02052List;
	private String fileName;
	
	private String chkDel;
	private String msgDel;
	
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** start **********");
		}

		try {
			szqyList = sessionCtrl.ReadSzqyList();
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		} catch (Exception e) {
			e.printStackTrace();
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

	public String init() throws Exception {
		if(LOG.isDebugEnabled()){
			LOG.debug("execute() ********** start **********");
		}
		
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("execute() ********** end **********");
		}
		return SUCCESS;
	}
	
	public String initA() throws Exception {
		if(LOG.isDebugEnabled()){
			LOG.debug("execute() ********** start **********");
		}
		
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}
		
		if(LOG.isDebugEnabled()){
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
		
		Pgv02052 v02052 = new Pgv02052();
		try {
			//准备查询条件
			v02052.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v02052.setCd00001Szqy(ddlSZQYFind);
			v02052.setLc(txtLCFind);
			v02052.setZcs(txtZCSFind);
			v02052.setPageIndex(pageIndex);
			v02052.setPageSize(getPageSize());
			v02052.setCd00001Fwlx(CheckUtil.chkTrim(txtFWLXFind));
			//执行查询
			rows = t02052Service.LoadAll(v02052);
			
			//分页设置
			if(null!=rows && rows.size()>0){
				total = rows.get(0).getRecordCount();
			}else{
				total = 0;
				pageIndex = 1;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
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
		
		Pgt02052 t02052 = new Pgt02052();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//取得用户选中的数据信息
				t02052.setId(txtID);
				t02052Bean = t02052Service.LoadByPrimaryKey(t02052);
				if (CheckUtil.chkEmpty(t02052Bean.getUpddate())) {
					setACT(Constant.MOD_CREATE);
				}
			}
			szqyList = sessionCtrl.ReadSzqyList();
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		} catch (Exception e) {
			e.printStackTrace();
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
		this.clearErrorsAndMessages();	
		ReadInfo();
		t02052Bean = new Pgt02052(txtID);
		//t02052Bean.setUpddate(ConvertUtil.toTimestamp(CheckUtil.chkTrim(txtUPDATE)));
		//根据PK信息，为数据BEAN赋值
		if (!Constant.MOD_DELETE.equals(getACT())){
			t02052Bean = t02052Service.LoadByPrimaryKey(t02052Bean);			
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(getACT()))&&(!t02052Bean.getUpddate().equals(ConvertUtil.toTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//为数据BEAN赋值
			t02052Bean.setLc(txtLC);
			t02052Bean.setZcs(txtZCS);
			t02052Bean.setCd00001Szqy(ddlSZQY);
			t02052Bean.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
			t02052Bean.setCd00001Fwlx(txtFWLX);
			t02052Bean.setCd00001Fwlxlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_FWLX_SC));
			t02052Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t02052Bean.setXzxs(ConvertUtil.toDouble(txtXZXS));
			t02052Bean.setNote(txtNOTE);
			t02052Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			t02052Bean.setCzlx(txtCZLX);
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("validateUpdate() ********** end **********");
		}
	}
	
	/**
	 * 读取【所在区域】
	 */
	private void ReadInfo() {
		szqyList = sessionCtrl.ReadSzqyList();
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
		String rtn = "success";
		try {
			if(Constant.MOD_CREATE.equals(getACT())){			// Create
				if(t02052Service.GetInsertCommand(getT02052Bean()))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{getText("app.xtwh.t00361.cs")}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{getText("app.xtwh.t00361.cs")}));
			} else if (Constant.MOD_UPDATE.equals(getACT())) {	// Update
				if(t02052Service.GetUpdateCommand(getT02052Bean())){
					t02052Bean = t02052Service.LoadByPrimaryKey(t02052Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getText("app.xtwh.t00361.cs")}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{getText("app.xtwh.t00361.cs")}));
			} else if (Constant.MOD_DELETE.equals(getACT())) {	// Delete
				if(t02052Service.GetDeleteCommand(getT02052Bean()))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{getText("app.xtwh.t00361.cs")}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{getText("app.xtwh.t00361.cs")}));
				rtn = "successDEL";
			}			
			szqyList = sessionCtrl.ReadSzqyList();
		} catch (Exception e) {
			e.printStackTrace();
			String[] msgs = e.getMessage().split("\n");
			this.addActionError(msgs[0]);
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** end **********");
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		return rtn;
	}
	
	public String delSel() throws Exception {
		if(LOG.isDebugEnabled()){
			LOG.debug("delSel() ********** start **********");
		}
		this.clearErrorsAndMessages();
		try{
			Pgt02052 t02052 = new Pgt02052();
			t02052.setChkDel(chkDel);
			t02052.setCd00002Czr(sessionCtrl.getUserId());
			t02052.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(t02052Service.GetSelDeleteCommand(t02052)){
				msgDel = "删除成功";
			}
		}catch(Exception e){
			e.printStackTrace();
			msgDel = "删除失败：" + e.getMessage();
			if(LOG.isDebugEnabled()){
				LOG.debug("delSel() ********** start **********");
			}
			return SUCCESS;
		}
		if(LOG.isDebugEnabled()){
			LOG.debug("delSel() ********** end **********");
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
		
		Pgt02052 t02052 = new Pgt02052();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//取得用户选中的数据信息
				t02052.setLc(txtLC);
				t02052.setZcs(txtZCS);
				t02052.setCd00001Szqy(ddlSZQY);
				t02052.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
				t02052.setCd00001Fwlx(txtFWLX);
				t02052.setCd00001Fwlxlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_FWLX_SC));
				t02052Bean = t02052Service.LoadByPrimaryAddKey(t02052);
				isExists = t02052Bean.getUpddate() == null?true:false;
			}
		} catch (Exception e) {
			e.printStackTrace();
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

	
	
	
	/**
	 * 信息导出
	 */
	public String exportT02052() throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("exportT02052() ********** start **********");
		}
		
		Pgv02052 v02052 = new Pgv02052();
		try {
			//准备查询条件
			v02052.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v02052.setCd00001Szqy(ddlSZQYFind);
			
			v02052.setLc(txtLCFind);
			v02052.setZcs(txtZCSFind);
			v02052.setPageIndex(1);
			v02052.setPageSize(-1);
			v02052.setCd00001Fwlx(CheckUtil.chkTrim(txtFWLXFind));
			v02052.setCd00002Czr(sessionCtrl.getUserId());
			ByteArrayOutputStream out = (ByteArrayOutputStream)t02052Service.ExportT052(v02052);
			setExcelStream(new ByteArrayInputStream(out.toByteArray()));
		}catch(Exception e){
			e.printStackTrace();
			if(LOG.isDebugEnabled()){
				LOG.debug("exportT02052() ********** end **********");
			}
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
			return INPUT;
		}
		
		
		if(LOG.isDebugEnabled()){
			LOG.debug("exportT02052() ********** end **********");
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		return SUCCESS;
	}
	
	
	
	
	
	
	
	/**
	 * 文件上传
	 * @return
	 * @throws Exception
	 */
	public String upload() throws Exception {
		try{		
			String fileName = sessionCtrl.getUserId() + "_LCXZ" + getUploadFileName().substring(getUploadFileName().lastIndexOf("."));
//			fileServerPath = getSavePath() + "\\" + getUploadFileName();
			fileServerPath = getSavePath() + "\\" + fileName;
			//将上传文件装入SESSION
			Common.addUploadFiles(fileServerPath);
			FileUtil.copyFile(fileServerPath, getUpload());
			
		}catch(Exception e){
			e.printStackTrace();
			
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
			return INPUT;
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
			Pgv02052List = Excel.importDataJZCCXZ(txtFilePath, sessionCtrl.getUserId(),sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(!checkLCXZ(Pgv02052List)){
				this.addActionError("数据不符合导入要求");
			}
			if(Pgv02052List.size() == 0){
				this.addActionError("检查发现没有数据可以导入！");
			}
		}catch(Exception e){
			e.printStackTrace();
			this.addActionError(e.getMessage().replace("\n", "<br />"));
		}	
		if(LOG.isDebugEnabled()){
			LOG.debug("validateImportFile() ********** end **********");
		}
	}
	
	private Boolean checkLCXZ(ArrayList<Pgv02052> v02052){
		return true;
	}
	
	
	/**
	 * 文件导入
	 * @return 
	 * @throws Exception
	 */
	public String importFile() throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("importFile() ********** start **********");
		}
		
		Pgv02052 tmpV02052 = null;
		try{
			tmpV02052 = t02052Service.ImportExcelData(Pgv02052List);
		}catch(Exception e){
			e.printStackTrace();
			this.addActionError(e.getMessage());
			return INPUT;
		}finally{
			if(null!=tmpV02052 && tmpV02052.getOutFlag() == 2){
				this.addActionMessage("数据导入成功");
			}else{
				ByteArrayOutputStream out = (ByteArrayOutputStream)Excel.exportDataJZCCXZ(tmpV02052.getOutList());
				excelStream = new ByteArrayInputStream(out.toByteArray());
				fileName = new String("格式错误的楼层修正数据.xls".getBytes("GBK"),"ISO-8859-1");
				return "failexport";
			}
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("importFile() ********** end **********");
		}
		return SUCCESS;
	}
	
	
	
	//新楼层修正页面
	
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String executeA() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** start **********");
		}

		try {
			szqyList = sessionCtrl.ReadSzqyList();
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		} catch (Exception e) {
			e.printStackTrace();
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
	public String queryA() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}
		
		Pgv02052 v02052 = new Pgv02052();
		try {
			//准备查询条件
			v02052.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v02052.setCd00001Szqy(ddlSZQYFind);
			v02052.setCd02050Xqdm(txtXQFind);
			v02052.setLc(txtLCFind);
			v02052.setZcs(txtZCSFind);
			v02052.setPageIndex(pageIndex);
			v02052.setPageSize(getPageSize());
			v02052.setCd00001Fwlx(CheckUtil.chkTrim(txtFWLXFind));
			//执行查询
			rows = t02052Service.LoadAllA(v02052);
			
			//分页设置
			if(null!=rows && rows.size()>0){
				total = rows.get(0).getRecordCount();
			}else{
				total = 0;
				pageIndex = 1;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
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
	public String createA() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** start **********");
		}
		
		Pgt02052 t02052 = new Pgt02052();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//取得用户选中的数据信息
				t02052.setId(txtID);
				t02052Bean = t02052Service.LoadByPrimaryKeyA(t02052);
				if (CheckUtil.chkEmpty(t02052Bean.getUpddate())) {
					setACT(Constant.MOD_CREATE);
				}
			}
			szqyList = sessionCtrl.ReadSzqyList();
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		} catch (Exception e) {
			e.printStackTrace();
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
	public void validateUpdateA() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("validateUpdate() ********** start **********");
		}
		this.clearErrorsAndMessages();	
		ReadInfo();
		t02052Bean = new Pgt02052(txtID);	
		//t02052Bean.setUpddate(ConvertUtil.toTimestamp(CheckUtil.chkTrim(txtUPDATE)));
		//根据PK信息，为数据BEAN赋值
		if (!Constant.MOD_DELETE.equals(getACT())){
			t02052Bean = t02052Service.LoadByPrimaryKeyA(t02052Bean);			
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(getACT()))&&(!t02052Bean.getUpddate().equals(ConvertUtil.toTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//为数据BEAN赋值
			t02052Bean.setLc(txtLC);
			t02052Bean.setZcs(txtZCS);
			t02052Bean.setCd00001Szqy(ddlSZQY);
			t02052Bean.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
			t02052Bean.setCd00001Fwlx(txtFWLX);
			t02052Bean.setCd00001Fwlxlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_FWLX_SC));
			t02052Bean.setCd02050Xqdm(txtXQDM);
			t02052Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t02052Bean.setXzxs(ConvertUtil.toDouble(txtXZXS));
			t02052Bean.setNote(txtNOTE);
			t02052Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			t02052Bean.setCzlx(txtCZLX);
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
	public String updateA() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** start **********");
		}
		String rtn = "success";
		try {
			if(Constant.MOD_CREATE.equals(getACT())){			// Create
				if(t02052Service.GetInsertCommandA(getT02052Bean()))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{getText("app.xtwh.t00361.cs")}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{getText("app.xtwh.t00361.cs")}));
			} else if (Constant.MOD_UPDATE.equals(getACT())) {	// Update
				if(t02052Service.GetUpdateCommandA(getT02052Bean())){
					t02052Bean = t02052Service.LoadByPrimaryKeyA(t02052Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getText("app.xtwh.t00361.cs")}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{getText("app.xtwh.t00361.cs")}));
			} else if (Constant.MOD_DELETE.equals(getACT())) {	// Delete
				if(t02052Service.GetDeleteCommandA(getT02052Bean()))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{getText("app.xtwh.t00361.cs")}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{getText("app.xtwh.t00361.cs")}));
				rtn = "successDEL";
			}			
			szqyList = sessionCtrl.ReadSzqyList();
		} catch (Exception e) {
			e.printStackTrace();
			String[] msgs = e.getMessage().split("\n");
			this.addActionError(msgs[0]);
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** end **********");
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		return rtn;
	}
	
	public String delSelA() throws Exception {
		if(LOG.isDebugEnabled()){
			LOG.debug("delSel() ********** start **********");
		}
		this.clearErrorsAndMessages();
		try{
			Pgt02052 t02052 = new Pgt02052();
			t02052.setChkDel(chkDel);
			t02052.setCd00002Czr(sessionCtrl.getUserId());
			t02052.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(t02052Service.GetSelDeleteCommandA(t02052)){
				msgDel = "删除成功";
			}
		}catch(Exception e){
			e.printStackTrace();
			msgDel = "删除失败：" + e.getMessage();
			if(LOG.isDebugEnabled()){
				LOG.debug("delSel() ********** start **********");
			}
			return SUCCESS;
		}
		if(LOG.isDebugEnabled()){
			LOG.debug("delSel() ********** end **********");
		}
		return SUCCESS;
	}
	
	
	/**
	 * 点击单选按钮的ajax事件，
	 * @return 如果有值填充，没有则返回NULL
	 * @throws Exception
	 */
	public String createByAjaxA() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("createByAjax() ********** start **********");
		}
		
		Pgt02052 t02052 = new Pgt02052();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//取得用户选中的数据信息
				t02052.setLc(txtLC);
				t02052.setZcs(txtZCS);
				t02052.setCd00001Szqy(ddlSZQY);
				t02052.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
				t02052.setCd00001Fwlx(txtFWLX);
				t02052.setCd02050Xqdm(txtXQDM);
				t02052.setCd00001Fwlxlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_FWLX_SC));
				t02052Bean = t02052Service.LoadByPrimaryAddKeyA(t02052);
				isExists = t02052Bean.getUpddate() == null?true:false;
			}
		} catch (Exception e) {
			e.printStackTrace();
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

	
	/**
	 * 信息导出
	 */
	public String exportT02052A() throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("exportT02052() ********** start **********");
		}
		
		Pgv02052 v02052 = new Pgv02052();
		try {
			//准备查询条件
			v02052.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v02052.setCd00001Szqy(ddlSZQYFind);
			v02052.setCd02050Xqdm(txtXQFind);
			v02052.setLc(txtLCFind);
			v02052.setZcs(txtZCSFind);
			v02052.setPageIndex(1);
			v02052.setPageSize(-1);
			v02052.setCd00001Fwlx(CheckUtil.chkTrim(txtFWLXFind));
			v02052.setCd00002Czr(sessionCtrl.getUserId());
			ByteArrayOutputStream out = (ByteArrayOutputStream)t02052Service.ExportT052A(v02052);
			setExcelStream(new ByteArrayInputStream(out.toByteArray()));
		}catch(Exception e){
			e.printStackTrace();
			if(LOG.isDebugEnabled()){
				LOG.debug("exportT02052() ********** end **********");
			}
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
			return INPUT;
		}
		
		
		if(LOG.isDebugEnabled()){
			LOG.debug("exportT02052() ********** end **********");
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		return SUCCESS;
	}
	
	
	
	
	
	
	
	/**
	 * 文件上传
	 * @return
	 * @throws Exception
	 */
	public String uploadA() throws Exception {
		try{		
			String fileName = sessionCtrl.getUserId() + "_LCXZ" + getUploadFileName().substring(getUploadFileName().lastIndexOf("."));
//			fileServerPath = getSavePath() + "\\" + getUploadFileName();
			fileServerPath = getSavePath() + "\\" + fileName;
			//将上传文件装入SESSION
			Common.addUploadFiles(fileServerPath);
			FileUtil.copyFile(fileServerPath, getUpload());
		}catch(Exception e){
			e.printStackTrace();
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
			
			return INPUT;
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		return SUCCESS;
	}
	
	
	/**
	 * 文件导入前的验证
	 */
	public void validateImportFileA() throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("validateImportFile() ********** start **********");
		}
		
		if(!FileUtil.checkFileExist(txtFilePath)){
			this.addActionError("文件错误，请检查");
		}
		try{
			Pgv02052List = Excel.importDataJZCCXZA(txtFilePath, sessionCtrl.getUserId(),sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(!checkLCXZA(Pgv02052List)){
				this.addActionError("数据不符合导入要求");
			}
			if(Pgv02052List.size() == 0){
				this.addActionError("数据不符合导入要求");
			}
		}catch(Exception e){
			e.printStackTrace();
			this.addActionError(e.getMessage().replace("\n", "<br />"));
		}	
		if(LOG.isDebugEnabled()){
			LOG.debug("validateImportFile() ********** end **********");
		}
	}
	
	private Boolean checkLCXZA(ArrayList<Pgv02052> v02052){
		return true;
	}
	
	
	/**
	 * 文件导入
	 * @return 
	 * @throws Exception
	 */
	public String importFileA() throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("importFile() ********** start **********");
		}
		
		Pgv02052 tmpV02052 = null;
		try{
			tmpV02052 = t02052Service.ImportExcelDataA(Pgv02052List);
		}catch(Exception e){
			e.printStackTrace();
			this.addActionError(e.getMessage());
			return INPUT;
		}finally{
			if(null!=tmpV02052 && tmpV02052.getOutFlag() == 2){
				this.addActionMessage("数据导入成功");
			}else{
				ByteArrayOutputStream out = (ByteArrayOutputStream)Excel.exportDataJZCCXZA(tmpV02052.getOutList());
				excelStream = new ByteArrayInputStream(out.toByteArray());
				fileName = new String("格式错误的楼层修正数据.xls".getBytes("GBK"),"ISO-8859-1");
				return "failexport";
			}
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("importFile() ********** end **********");
		}
		return SUCCESS;
	}
	
	
/*********************** set and get ******************************/
	
	/**
	 * @return the t02052Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt02052Service getT02052Service() {
		return t02052Service;
	}

	/**
	 * @param t02052Service the t02052Service to set
	 */
	public void setT02052Service(IPgt02052Service t02052Service) {
		this.t02052Service = t02052Service;
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
	 * @return the lcxzList
	 */
	public ArrayList<Pgv02052> getLcxzList() {
		return lcxzList;
	}

	/**
	 * @param lcxzList the lcxzList to set
	 */
	public void setLcxzList(ArrayList<Pgv02052> lcxzList) {
		this.lcxzList = lcxzList;
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
	 * @return the t02052Bean
	 */
	public Pgt02052 getT02052Bean() {
		return t02052Bean;
	}

	/**
	 * @param t02052Bean the t02052Bean to set
	 */
	public void setT02052Bean(Pgt02052 t02052Bean) {
		this.t02052Bean = t02052Bean;
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

	

	/**
	 * @return the txtFWLXFind
	 */
	public String getTxtFWLXFind() {
		return txtFWLXFind;
	}

	/**
	 * @param txtFWLXFind the txtFWLXFind to set
	 */
	public void setTxtFWLXFind(String txtFWLXFind) {
		this.txtFWLXFind = txtFWLXFind;
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
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
	}

	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	/**
	 * 
	 * @return the excelStream
	 */
	public InputStream getExcelStream() {
		return excelStream;
	}
	/**
	 * 
	 * @param excelStream the excelStream to set
	 */
	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}
	/**
	 * 
	 * @return the upload
	 */
	public File getUpload() {
		return upload;
	}
	/**
	 * 
	 * @param upload the upload to set
	 */
	public void setUpload(File upload) {
		this.upload = upload;
	}
	/**
	 * 
	 * @return the uploadFileName
	 */
	public String getUploadFileName() {
		return uploadFileName;
	}
	/**
	 * 
	 * @param uploadFileName the uploadFileName to set
	 */
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	/**
	 * 
	 * @return the savePath
	 */
	@SuppressWarnings("deprecation")
	public String getSavePath() {
		return ServletActionContext.getRequest().getRealPath(savePath);
	}
	/**
	 * 
	 * @param savePath the savePath to set
	 */
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	/**
	 * 
	 * @return the fileServerPath
	 */
	public String getFileServerPath() {
		return fileServerPath;
	}
	/**
	 * 
	 * @param fileServerPath the fileServerPath to set
	 */
	public void setFileServerPath(String fileServerPath) {
		this.fileServerPath = fileServerPath;
	}
	/**
	 * 
	 * @return the txtFilePath
	 */
	public String getTxtFilePath() {
		return txtFilePath;
	}
	/**
	 * 
	 * @param txtFilePath the txtFilePath to set
	 */
	public void setTxtFilePath(String txtFilePath) {
		this.txtFilePath = txtFilePath;
	}
	/**
	 * 
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * 
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * 
	 * @return the pgv02052List
	 */
	public ArrayList<Pgv02052> getPgv02052List() {
		return Pgv02052List;
	}
	/**
	 * 
	 * @param pgv02052List the pgv02052List to set
	 */
	public void setPgv02052List(ArrayList<Pgv02052> pgv02052List) {
		Pgv02052List = pgv02052List;
	}

	public ArrayList<Pgv02052> getRows() {
		return rows;
	}

	public void setRows(ArrayList<Pgv02052> rows) {
		this.rows = rows;
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

	public String getChkDel() {
		return chkDel;
	}

	public void setChkDel(String chkDel) {
		this.chkDel = chkDel;
	}

	public String getMsgDel() {
		return msgDel;
	}

	public void setMsgDel(String msgDel) {
		this.msgDel = msgDel;
	}
	public String getTxtXQDM() {
		return txtXQDM;
	}

	public void setTxtXQDM(String txtXQDM) {
		this.txtXQDM = txtXQDM;
	}
	
	public String getTxtXQFind() {
		return txtXQFind;
	}

	public void setTxtXQFind(String txtXQFind) {
		this.txtXQFind = txtXQFind;
	}

	public String getTxtID() {
		return txtID;
	}

	public void setTxtID(String txtID) {
		this.txtID = txtID;
	}

	public SessionCtrl getSessionCtrl() {
		return sessionCtrl;
	}

	public void setSessionCtrl(SessionCtrl sessionCtrl) {
		this.sessionCtrl = sessionCtrl;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionCtrl.appSession=arg0;
	}
}
