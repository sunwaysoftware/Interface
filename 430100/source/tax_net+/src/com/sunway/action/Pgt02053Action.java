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
import com.sunway.service.IPgt02053Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.ConvertUtil;
import com.sunway.util.Excel;
import com.sunway.util.FileUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt02053;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv02053;

/**
 * 商业综合修正赋值(Pgt02053)
 * @category 系统维护
 * @author Lee
 * @version 1.0
 */
public class Pgt02053Action extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = -1149492734103440962L;

	//Service
	private IPgt02053Service t02053Service;

	//View

	//分页参数
	private Integer pageSize;
	private Integer pageIndex;
	private Integer total;
	//Bean数组
	private ArrayList<Pgv02053> cgzkList;
	private ArrayList<Pgv00052> szqyList;
	private Map<String, String> objList;
	private ArrayList<Pgv02053> rows;
	//查询条件
	private String ddlSZQYFind;
	private String txtFWLX;
	private String txtCGZKFind;
	//Edit

	//edit页面所需Bean
	private Pgt02053 t02053Bean;
	//primary key 主键
	private String ROOT;
	private String INFOID;
	private String SZQY;
	private String FWLX;
	private String PARENTID;
	//编辑操作符
	private String ACT;
	//表单提交数据
	private String ddlSZQY;
	private String txtCGZK;
	private String txtXZXS;
	private String txtNOTE;
	private String txtUPDATE;
	private Boolean isExists;
	private String ACTIONNAME;
	private String HREFNAME;
	private String TITLENAME;
	private String URL;
	private String rdoSFMR;
	private SessionCtrl sessionCtrl=new SessionCtrl();
	
	private String userRole;
	private String CGZK;
	private String txtXQDM;
    private String txtXQFind;
    private String XQDM;

    private InputStream excelStream;
	
    
	private String fileServerPath;
	private String uploadFileName;
    private String savePath;
    private File upload;
    private String txtFilePath;
    private ArrayList<Pgv02053> Pgv02053List;
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
			//objList = t02053Service.LoadObj(new Pgt02053());
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("execute() ********** end **********");
			}
			return ERROR;
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
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
	public String query1() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}

		Pgv02053 v02053 = new Pgv02053();
		try {
			//准备查询条件
			v02053.setCd00001Fwlx(txtFWLX);
			v02053.setCd00001Szqy(ddlSZQYFind);
			v02053.setPageIndex(pageIndex);
			v02053.setPageSize(getPageSize());
			v02053.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			rows = t02053Service.LoadAll(v02053);
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
	 * 查询状态处理
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}

		Pgv02053 v02053 = new Pgv02053();
		try {
			//准备查询条件
			v02053.setCd00001Fwlx(txtFWLX);
			v02053.setCd00001Szqy(ddlSZQYFind);
			v02053.setPageIndex(pageIndex);
			v02053.setPageSize(getPageSize());
			v02053.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			rows = t02053Service.LoadAll(v02053);
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

		Pgt02053 t02053 = new Pgt02053();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//取得用户选中的数据信息
				t02053.setCd00001Infoid(INFOID);
				t02053.setCd00001Root(ROOT);
				t02053.setCd00001Szqy(SZQY);
				t02053.setCd00001Fwlx(txtFWLX);
				t02053Bean = t02053Service.LoadByPrimaryKey(t02053);
				if (CheckUtil.chkEmpty(t02053Bean.getUpddate())) {
					setACT(Constant.MOD_CREATE);
				}
			}
			//objList = t02053Service.LoadObj(t02053);
			szqyList = sessionCtrl.ReadSzqyList();
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("create() ********** end **********");
			}
			return ERROR;
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
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
		
		t02053Bean = new Pgt02053();
		this.clearErrorsAndMessages();
		if("D".equals(ACT)){
			t02053Bean.setCd00001Infoid(CGZK);
		}else{
			t02053Bean.setCd00001Infoid(INFOID);
		}
		
		//t02053Bean.setCd00001Root(ROOT);		
		//t02053Bean.setCd00001Root(sessionCtrl.Get(SessionCtrl.SESSION_INFO_CGZK_SC));
		t02053Bean.setCd00001Szqy(ddlSZQY);
		t02053Bean.setCd00001Fwlx(txtFWLX);
		//t02053Bean.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_FWLX_SC));
		t02053Bean.setCd02050Xqdm(txtXQDM);
		
		//根据PK信息，为数据BEAN赋值
		if (!Constant.MOD_DELETE.equals(getACT())){
			t02053Bean = t02053Service.LoadByPrimaryKey(t02053Bean);
		}
		//判断PK是否重复
		if((Constant.MOD_CREATE.equals(getACT()))&&(!CheckUtil.chkEmpty(t02053Bean.getUpddate()))){
			this.addActionError(getText("app.msg.error.pk", new String[]{getText("app.xtwh.info.cgzk")}));
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(getACT()))&&(!t02053Bean.getUpddate().equals(ConvertUtil.toTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//为数据BEAN赋值
			t02053Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t02053Bean.setXzxs(ConvertUtil.toDouble(txtXZXS));
			t02053Bean.setNote(txtNOTE);
			t02053Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			t02053Bean.setCd02050Xqdm(txtXQDM);
			t02053Bean.setSfmr(ConvertUtil.toInteger(rdoSFMR));
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
		String rtn = "success";
		try {
			if(Constant.MOD_CREATE.equals(getACT())){			// Create
				if(t02053Service.GetInsertCommand(getT02053Bean()))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{getT02053Bean().getCd00001Infoid()}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{getT02053Bean().getCd00001Infoid()}));
			} else if (Constant.MOD_UPDATE.equals(getACT())) {	// Update
				if(t02053Service.GetUpdateCommand(getT02053Bean())){
					t02053Bean = t02053Service.LoadByPrimaryKey(t02053Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getT02053Bean().getCd00001Infoid()}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{getT02053Bean().getCd00001Infoid()}));
			} else if (Constant.MOD_DELETE.equals(getACT())) {	// Delete
				if(t02053Service.GetDeleteCommand(getT02053Bean()))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{getT02053Bean().getCd00001Infoid()}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{getT02053Bean().getCd00001Infoid()}));
				rtn = "successDEL";
			}
			szqyList = sessionCtrl.ReadSzqyList();
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("update() ********** end **********");
			}
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** end **********");
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		return rtn;
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

		Pgt02053 t02053 = new Pgt02053();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//取得用户选中的数据信息
				t02053.setCd00001Infoid(INFOID);
				t02053.setCd00001Root(ROOT);
				t02053.setCd00001Szqy(ddlSZQY);
				t02053.setCd00001Fwlx(txtFWLX);
				t02053.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_FWLX_SC));
				t02053Bean = t02053Service.LoadByPrimaryKey(t02053);
				isExists = t02053Bean.getUpddate() == null?true:false;
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
	public String exportT02053() throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("exportT02053() ********** start **********");
		}
		
		Pgv02053 v02053 = new Pgv02053();
		try {
			//准备查询条件
			v02053.setCd00001Fwlx(txtFWLX);
			v02053.setCd00001Szqy(ddlSZQYFind);
			v02053.setPageIndex(1);
			v02053.setPageSize(-1);
			v02053.setCd00002Czr(sessionCtrl.getUserId());
			v02053.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			ByteArrayOutputStream out = (ByteArrayOutputStream)t02053Service.ExportT053(v02053);
			setExcelStream(new ByteArrayInputStream(out.toByteArray()));
		}catch(Exception e){
			e.printStackTrace();
			if(LOG.isDebugEnabled()){
				LOG.debug("exportT02053() ********** end **********");
			}
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
			return INPUT;
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("exportT02053() ********** end **********");
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		return SUCCESS;
	}
	
	
	
	/**
	 * 文件上传
	 */
	public String upload()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("upload() ********** start **********");
		}
		try{
			String fileName = sessionCtrl.getUserId() + "_ZHXZ" + getUploadFileName().substring(getUploadFileName().lastIndexOf("."));
//			fileServerPath = getSavePath() + "\\" + getUploadFileName();
			fileServerPath = getSavePath() + "\\" + fileName;
			//将上传文件路径装入SESSION
			Common.addUploadFiles(fileServerPath);
			FileUtil.copyFile(fileServerPath, getUpload());
		}catch(Exception e){
			e.printStackTrace();
			
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
			return INPUT;
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
	public void validateImportFile()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("validateImportFile() ********** start **********");
		}
		
		if(!FileUtil.checkFileExist(txtFilePath)){
			this.addActionError("文件错误，请检查");
		}
		try{
			Pgv02053List = Excel.importDataSYZHXZ(txtFilePath, sessionCtrl.getUserId(), sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(!checkJCSJ(Pgv02053List)){
				this.addActionError("数据不符合导入要求");
			}
			if(Pgv02053List.size() == 0){
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
	
	private boolean checkJCSJ(ArrayList<Pgv02053> v02053List)throws Exception{
		return true;
	}
	
	/**
	 * 文件导入
	 */
	public String importFile() throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("importFile() ********** start **********");
		}
		
			Pgv02053 tmpV02053 = null;
			try{
				tmpV02053 = t02053Service.ImportExcelData(Pgv02053List);
			}catch(Exception ex){
				ex.printStackTrace();
				this.addActionError(ex.getMessage());
				return INPUT;
			}finally{
				if(null!=tmpV02053 && tmpV02053.getOutFlag()==2)
					this.addActionMessage("数据导入成功！");
				else{
					ByteArrayOutputStream out = (ByteArrayOutputStream) Excel.exportDataSYZhxz(tmpV02053.getOutList());
					excelStream = new ByteArrayInputStream(out.toByteArray());
					fileName=new String("格式错误的综合修正数据.xls".getBytes("GBK"),"ISO-8859-1");
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
	
	public String delSel() throws Exception {
		if(LOG.isDebugEnabled()){
			LOG.debug("delSel() ********** start **********");
		}
		this.clearErrorsAndMessages();
		try{
			Pgt02053 t02053 = new Pgt02053();
			t02053.setChkDel(chkDel);
			t02053.setCd00002Czr(sessionCtrl.getUserId());
			t02053.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(t02053Service.GetSelDeleteCommand(t02053)){
				msgDel = "删除成功";
			}
		}catch(Exception e){
			e.printStackTrace();
			msgDel = "删除失败：" + e.getMessage();
			if(LOG.isDebugEnabled()){
				LOG.debug("delSel() ********** end **********");
			}
			return SUCCESS;
		}
		if(LOG.isDebugEnabled()){
			LOG.debug("delSel() ********** end **********");
		}
		return SUCCESS;
	}

	
	public String delSelA() throws Exception {
		if(LOG.isDebugEnabled()){
			LOG.debug("delSel() ********** start **********");
		}
		this.clearErrorsAndMessages();
		try{
			Pgt02053 t02053 = new Pgt02053();
			t02053.setChkDel(chkDel);
			t02053.setCd00002Czr(sessionCtrl.getUserId());
			t02053.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(t02053Service.GetSelDeleteCommandA(t02053)){
				msgDel = "删除成功";
			}
		}catch(Exception e){
			e.printStackTrace();
			msgDel = "删除失败：" + e.getMessage();
			if(LOG.isDebugEnabled()){
				LOG.debug("delSel() ********** end **********");
			}
			return SUCCESS;
		}
		if(LOG.isDebugEnabled()){
			LOG.debug("delSel() ********** end **********");
		}
		return SUCCESS;
	}
	
	//新页面
	/**
	 * 信息导出
	 */
	public String exportT02053A() throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("exportT02053() ********** start **********");
		}
		
		Pgv02053 v02053 = new Pgv02053();
		try {
			//准备查询条件
			v02053.setCd00001Fwlx(txtFWLX);
			v02053.setCd00001Szqy(ddlSZQYFind);
			v02053.setCd02050Xqdm(txtXQFind);
			v02053.setPageIndex(1);
			v02053.setPageSize(-1);
			v02053.setCd00002Czr(sessionCtrl.getUserId());
			v02053.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			ByteArrayOutputStream out = (ByteArrayOutputStream)t02053Service.ExportT053A(v02053);
			setExcelStream(new ByteArrayInputStream(out.toByteArray()));
		}catch(Exception e){
			e.printStackTrace();
			if(LOG.isDebugEnabled()){
				LOG.debug("exportT02053() ********** end **********");
			}
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
			return INPUT;
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("exportT02053() ********** end **********");
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		return SUCCESS;
	}
	

	public String executeA() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** start **********");
		}

		try {
			szqyList = sessionCtrl.ReadSzqyList();
			//objList = t02053Service.LoadObj(new Pgt02053());
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("execute() ********** end **********");
			}
			return ERROR;
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
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

		Pgv02053 v02053 = new Pgv02053();
		try {
			//准备查询条件
			v02053.setCd00001Fwlx(txtFWLX);
			v02053.setCd00001Szqy(ddlSZQYFind);
			v02053.setPageIndex(pageIndex);
			v02053.setPageSize(getPageSize());
			v02053.setCd02050Xqdm(txtXQFind);
			v02053.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			rows = t02053Service.LoadAllA(v02053);
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

		Pgt02053 t02053 = new Pgt02053();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//取得用户选中的数据信息
				t02053.setCd00001Infoid(INFOID);
				t02053.setCd00001Root(ROOT);
				t02053.setCd00001Szqy(SZQY);
				t02053.setCd00001Fwlx(txtFWLX);
				//t02053.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_FWLX_SC));
				t02053.setCd02050Xqdm(XQDM);
				t02053Bean = t02053Service.LoadByPrimaryKeyA(t02053);
				if (CheckUtil.chkEmpty(t02053Bean.getUpddate())) {
					setACT(Constant.MOD_CREATE);
				}
			}
			//objList = t02053Service.LoadObj(t02053);
			szqyList = sessionCtrl.ReadSzqyList();
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("create() ********** end **********");
			}
			return ERROR;
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
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
		
		t02053Bean = new Pgt02053();
		this.clearErrorsAndMessages();
		if("D".equals(ACT)){
			t02053Bean.setCd00001Infoid(CGZK);
		}else{
			t02053Bean.setCd00001Infoid(INFOID);
		}
		
		//t02053Bean.setCd00001Root(ROOT);		
		//t02053Bean.setCd00001Root(sessionCtrl.Get(SessionCtrl.SESSION_INFO_CGZK_SC));
		t02053Bean.setCd00001Szqy(ddlSZQY);
		t02053Bean.setCd00001Fwlx(txtFWLX);
		//t02053Bean.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_FWLX_SC));
		t02053Bean.setCd02050Xqdm(txtXQDM);
			//根据PK信息，为数据BEAN赋值
		if (!Constant.MOD_DELETE.equals(getACT())){
			t02053Bean = t02053Service.LoadByPrimaryKeyA(t02053Bean);
		}
		//判断PK是否重复
		if((Constant.MOD_CREATE.equals(getACT()))&&(!CheckUtil.chkEmpty(t02053Bean.getUpddate()))){
			this.addActionError(getText("app.msg.error.pk", new String[]{getText("app.xtwh.info.cgzk")}));
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(getACT()))&&(!t02053Bean.getUpddate().equals(ConvertUtil.toTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//为数据BEAN赋值
			t02053Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t02053Bean.setXzxs(ConvertUtil.toDouble(txtXZXS));
			t02053Bean.setNote(txtNOTE);
			t02053Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			t02053Bean.setCd02050Xqdm(txtXQDM);
			t02053Bean.setSfmr(ConvertUtil.toInteger(rdoSFMR));
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
				if(t02053Service.GetInsertCommandA(getT02053Bean()))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{getT02053Bean().getCd00001Infoid()}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{getT02053Bean().getCd00001Infoid()}));
			} else if (Constant.MOD_UPDATE.equals(getACT())) {	// Update
				if(t02053Service.GetUpdateCommandA(getT02053Bean())){
					t02053Bean = t02053Service.LoadByPrimaryKey(t02053Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getT02053Bean().getCd00001Infoid()}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{getT02053Bean().getCd00001Infoid()}));
			} else if (Constant.MOD_DELETE.equals(getACT())) {	// Delete
				if(t02053Service.GetDeleteCommandA(getT02053Bean()))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{getT02053Bean().getCd00001Infoid()}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{getT02053Bean().getCd00001Infoid()}));
				rtn = "successDEL";
			}
			szqyList = sessionCtrl.ReadSzqyList();
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("update() ********** end **********");
			}
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** end **********");
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		return rtn;
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

		Pgt02053 t02053 = new Pgt02053();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//取得用户选中的数据信息
				t02053.setCd00001Infoid(INFOID);
				t02053.setCd00001Root(ROOT);
				t02053.setCd00001Szqy(ddlSZQY);
				t02053.setCd00001Fwlx(txtFWLX);
				t02053.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_FWLX_SC));
				t02053.setCd02050Xqdm(XQDM);
				t02053Bean = t02053Service.LoadByPrimaryKeyA(t02053);
				isExists = t02053Bean.getUpddate() == null?true:false;
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
	 * 文件上传
	 */
	public String uploadA()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("upload() ********** start **********");
		}
		try{
			String fileName = sessionCtrl.getUserId() + "_JZJGXZ" + getUploadFileName().substring(getUploadFileName().lastIndexOf("."));
//			fileServerPath = getSavePath() + "\\" + getUploadFileName();
			fileServerPath = getSavePath() + "\\" + fileName;
			//将上传文件路径装入SESSION
			Common.addUploadFiles(fileServerPath);
			FileUtil.copyFile(fileServerPath, getUpload());		
		}catch(Exception e){
			e.printStackTrace();
			
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
			return INPUT;
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
	public void validateImportFileA()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("validateImportFile() ********** start **********");
		}
		
		if(!FileUtil.checkFileExist(txtFilePath)){
			this.addActionError("文件错误，请检查");
		}
		try{
			Pgv02053List = Excel.importDataSYZHXZA(txtFilePath, sessionCtrl.getUserId(), sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(!checkJCSJA(Pgv02053List)){
				this.addActionError("数据不符合导入要求");
			}
			if(Pgv02053List.size() == 0){
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
	
	private boolean checkJCSJA(ArrayList<Pgv02053> v02053List)throws Exception{
		return true;
	}
	
	
	
	/**
	 * 文件导入
	 */
	public String importFileA() throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("importFile() ********** start **********");
		}
		
			Pgv02053 tmpV02053 = null;
			try{
				tmpV02053 = t02053Service.ImportExcelDataA(Pgv02053List);
			}catch(Exception ex){
				ex.printStackTrace();
				this.addActionError(ex.getMessage());
				return INPUT;
			}finally{
				if(null!=tmpV02053 && tmpV02053.getOutFlag()==2)
					this.addActionMessage("数据导入成功！");
				else{
					ByteArrayOutputStream out = (ByteArrayOutputStream) Excel.exportDataSYZhxzA(tmpV02053.getOutList());
					excelStream = new ByteArrayInputStream(out.toByteArray());
					fileName=new String("格式错误的综合修正数据.xls".getBytes("GBK"),"ISO-8859-1");
					return "failexport";
				}
		}
		return SUCCESS;
	}
	
	/**
	 * 所在区域读取父类型
	 * @return
	 * @throws Exception
	 */
	public String LoadParentIds() throws Exception {
		try {
			PARENTID = t02053Service.LoadParentIdsBySzqy(SZQY,FWLX,XQDM);
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	/*********************** set and get ******************************/

	/**
	 * @return the t02053Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt02053Service getT02053Service() {
		return t02053Service;
	}

	/**
	 * @param t02053Service the t02053Service to set
	 */
	public void setT02053Service(IPgt02053Service t02053Service) {
		this.t02053Service = t02053Service;
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
	 * @return the cgzkList
	 */
	public ArrayList<Pgv02053> getCgzkList() {
		return cgzkList;
	}

	/**
	 * @param cgzkList the cgzkList to set
	 */
	public void setCgzkList(ArrayList<Pgv02053> cgzkList) {
		this.cgzkList = cgzkList;
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
	 * @return the txtCGZKFind
	 */
	public String getTxtCGZKFind() {
		return txtCGZKFind;
	}

	/**
	 * @param txtCGZKFind the txtCGZKFind to set
	 */
	public void setTxtCGZKFind(String txtCGZKFind) {
		this.txtCGZKFind = txtCGZKFind;
	}

	

	/**
	 * @return the t02053Bean
	 */
	public Pgt02053 getT02053Bean() {
		return t02053Bean;
	}

	/**
	 * @param t02053Bean the t02053Bean to set
	 */
	public void setT02053Bean(Pgt02053 t02053Bean) {
		this.t02053Bean = t02053Bean;
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
	 * @param objList the objList to set
	 */
	public void setObjList(Map<String, String> objList) {
		this.objList = objList;
	}

	/**
	 * @return the objList
	 */
	public Map<String, String> getObjList() {
		return objList;
	}

	
	/**
	 * @return the rOOT
	 */
	public String getROOT() {
		return ROOT;
	}

	/**
	 * @param rOOT the rOOT to set
	 */
	public void setROOT(String rOOT) {
		ROOT = rOOT;
	}

	/**
	 * @return the iNFOID
	 */
	public String getINFOID() {
		return INFOID;
	}

	/**
	 * @param iNFOID the iNFOID to set
	 */
	public void setINFOID(String iNFOID) {
		INFOID = iNFOID;
	}

	
	/**
	 * 
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
	}
	/**
	 * 
	 * @param userRole the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
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

	public ArrayList<Pgv02053> getRows() {
		return rows;
	}

	public void setRows(ArrayList<Pgv02053> rows) {
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

	public String getCGZK() {
		return CGZK;
	}

	public void setCGZK(String cGZK) {
		CGZK = cGZK;
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
	public String getXQDM() {
		return XQDM;
	}

	public void setXQDM(String xQDM) {
		XQDM = xQDM;
	}
	public InputStream getExcelStream() {
		return excelStream;
	}
	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}
	
	public String getUploadFileName() {
		return uploadFileName;
	}
	
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	
	@SuppressWarnings("deprecation")
	public String getSavePath() {
		return ServletActionContext.getRequest().getRealPath(savePath);
	}
	
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	
    public String getFileServerPath() {
			return fileServerPath;
	}
    
	public void setFileServerPath(String fileServerPath) {
			this.fileServerPath = fileServerPath;
	}
	
	public File getUpload() {
		return upload;
	}
	
	public void setUpload(File upload) {
		this.upload = upload;
	}
	
	public String getTxtFilePath() {
		return txtFilePath;
	}
	
	public void setTxtFilePath(String txtFilePath) {
		this.txtFilePath = txtFilePath;
	}
	
	public ArrayList<Pgv02053> getPgv02053List() {
		return Pgv02053List;
	}
	
	public void setPgv02053List(ArrayList<Pgv02053> pgv02053List) {
		Pgv02053List = pgv02053List;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
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
	/**
	 * @return the fWLX
	 */
	public String getFWLX() {
		return FWLX;
	}
	/**
	 * @param fWLX the fWLX to set
	 */
	public void setFWLX(String fWLX) {
		FWLX = fWLX;
	}
	/**
	 * @return the pARENTID
	 */
	public String getPARENTID() {
		return PARENTID;
	}
	/**
	 * @param pARENTID the pARENTID to set
	 */
	public void setPARENTID(String pARENTID) {
		PARENTID = pARENTID;
	}
	public String getRdoSFMR() {
		return rdoSFMR;
	}
	public void setRdoSFMR(String rdoSFMR) {
		this.rdoSFMR = rdoSFMR;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionCtrl.appSession=arg0;
	}
	
}
