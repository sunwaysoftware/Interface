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
import com.sunway.service.IPgt00001Service;
import com.sunway.service.IPgt00353Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.ConvertUtil;
import com.sunway.util.Excel;
import com.sunway.util.FileUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt00001;
import com.sunway.vo.Pgt00353;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv00353;

/**
 * 市场法采光修正系数(Pgt00353)
 * @category 系统维护
 * @author Lee
 * @version 1.0
 */

public class Pgt00353Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -9051173258383190888L;
	//Service
	private IPgt00353Service t00353Service;
	private IPgt00001Service t00001Service;
	//View

	//分页参数
	private Integer pageIndex;
	private Integer pageSize;
	private Integer total;
	//Bean数组
	private ArrayList<Pgv00353> rows;
	private ArrayList<Pgv00052> szqyList;
	private Map<String, String> objList;
	//查询条件
	private String ddlSZQYFind;
	private String txtCGZKFind;
	private String txtPSSDFind;
	//Edit

	//edit页面所需Bean
	private Pgt00353 t00353Bean;
	//primary key 主键
	private String ROOT;
	private String INFOID;
	private String SZQY;
	private String PSSD;
	

	private String FWLX;
	//编辑操作符
	private String ACT;
	//表单提交数据
	private String ddlSZQY;
	private String txtCGZK;
	private String txtFWLX;
	private String txtXZXS;
	private String txtNOTE;
	private String txtUPDATE;
	private Boolean isExists;
	private String txtPSSD;
	private String ACTIONNAME;
	private String HREFNAME;
	private String TITLENAME;
	private String URL;
	private String ddlPSSD;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	private Integer txtCZLX;
	//导出
	private InputStream excelStream;
	
	//导入
	private String uploadFileName;
	private String fileServerPath;
	private String savePath;
	private File upload;
	private String userRole;
	
	private String txtFilePath;
	private ArrayList<Pgv00353> ebList;
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
			//objList = t00353Service.LoadObj(new Pgt00353());
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

		Pgv00353 v00353 = new Pgv00353();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准备查询条件
			v00353.setCd00001Szqy(CheckUtil.chkTrim(ddlSZQYFind));
			v00353.setCd00001Root(ROOT);
			v00353.setCd00001Infoid(CheckUtil.chkTrim(txtCGZKFind));
			v00353.setCd00002Pssd(CheckUtil.chkTrim(txtPSSDFind));
			v00353.setPageIndex(pageIndex);
			v00353.setPageSize(getPageSize());
			v00353.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			rows = t00353Service.LoadAll(v00353);
			//分页设置
			if(null!=rows && rows.size()>0){
				total = rows.get(0).getRecordCount();
			}else{
				total = 0;
				pageIndex = 1;
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
		//	this.addActionError(e.getMessage());
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

		Pgt00353 t00353 = new Pgt00353();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			if(!Constant.MOD_CREATE.equals(getACT())){
				//取得用户选中的数据信息
				t00353.setCd00001Infoid(INFOID);
				t00353.setCd00001Root(ROOT);
				t00353.setCd00001Szqy(SZQY);
				t00353.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
				t00353.setCd00002Pssd(PSSD);
				t00353.setCd00001Fwlx(txtFWLX);
				Pgt00001 info = new Pgt00001();
				info.setInfoid(txtFWLX);
				info.setRootid(sessionCtrl.Get(SessionCtrl.SESSION_INFO_FWLX_SC));
				t00353.setFwlx(t00001Service.LoadByPrimaryKey(info).getInfonm());
				t00353Bean = t00353Service.LoadByPrimaryKey(t00353);
				if (CheckUtil.chkEmpty(t00353Bean.getUpddate())) {
					setACT(Constant.MOD_CREATE);
				}
			}
			//objList = t00353Service.LoadObj(t00353);
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
		t00353Bean = new Pgt00353();
		this.clearErrorsAndMessages();
		t00353Bean.setCd00001Infoid(INFOID);
		t00353Bean.setCd00001Root(ROOT);		//t00353Bean.setCd00001Root(sessionCtrl.Get(SessionCtrl.SESSION_INFO_CGZK_SC));
		t00353Bean.setCd00001Szqy(ddlSZQY);
		t00353Bean.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
		t00353Bean.setCd00002Pssd(txtPSSD);
		t00353Bean.setCd00001Fwlx(txtFWLX);
		//根据PK信息，为数据BEAN赋值
		if (!Constant.MOD_DELETE.equals(getACT())){
			t00353Bean = t00353Service.LoadByPrimaryKey(t00353Bean);
		}
		//判断PK是否重复
		if((Constant.MOD_CREATE.equals(getACT()))&&(!CheckUtil.chkEmpty(t00353Bean.getUpddate()))){
			this.addActionError(getText("app.msg.error.pk", new String[]{getText("app.xtwh.info.cgzk")}));
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(getACT()))&&(!t00353Bean.getUpddate().equals(ConvertUtil.toTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//为数据BEAN赋值
			t00353Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t00353Bean.setXzxs(ConvertUtil.toDouble(txtXZXS));
			t00353Bean.setNote(txtNOTE);
			t00353Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			t00353Bean.setCzlx(txtCZLX);
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("validateUpdate() ********** end **********");
		}
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

		Pgt00353 t00353 = new Pgt00353();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			t00353.setCd00001Infoid(INFOID);
			t00353.setCd00001Root(ROOT);		
			t00353.setCd00001Szqy(ddlSZQY);
			t00353.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
			t00353.setCd00002Pssd(txtPSSD);
			t00353.setCd00001Fwlx(txtFWLX);
			t00353.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t00353.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			// 执行查询
			t00353Service.GetDeleteCommand(t00353);
			
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
				if(t00353Service.GetInsertCommand(getT00353Bean()))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{getT00353Bean().getCd00001Infoid()}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{getT00353Bean().getCd00001Infoid()}));
			} else if (Constant.MOD_UPDATE.equals(getACT())) {	// Update
				if(t00353Service.GetUpdateCommand(getT00353Bean())){
					t00353Bean = t00353Service.LoadByPrimaryKey(t00353Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getT00353Bean().getCd00001Infoid()}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{getT00353Bean().getCd00001Infoid()}));
			} else if (Constant.MOD_DELETE.equals(getACT())) {	// Delete
				if(t00353Service.GetDeleteCommand(getT00353Bean()))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{getT00353Bean().getCd00001Infoid()}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{getT00353Bean().getCd00001Infoid()}));
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

		Pgt00353 t00353 = new Pgt00353();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
				//取得用户选中的数据信息
				t00353.setCd00001Infoid(INFOID);
				t00353.setCd00001Root(ROOT);
				t00353.setCd00001Szqy(ddlSZQY);
				t00353.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
				t00353.setCd00002Pssd(PSSD);
				t00353.setCd00001Fwlx(FWLX);
				t00353Bean = t00353Service.LoadByPrimaryKey(t00353);
				isExists = t00353Bean.getUpddate() == null?true:false;
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
	 * 文件导入
	 * @return
	 * @throws Exception
	 */
	public String upload() throws Exception {
		try{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			fileServerPath = getSavePath() + "\\ZHXZ_" + sessionCtrl.getUserId() + getUploadFileName();
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
		if(!FileUtil.checkFileExist(txtFilePath)){
			this.addActionError("文件错误，请检查！");
		}
		try{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//检验数据合法性
			ebList = Excel.ZHXZExcel(txtFilePath, sessionCtrl.getUserId(),sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(!checkDateList(ebList))
				this.addActionError("市场法综合修正数据不符合导入要求！");
			if(ebList.size()==0)
				this.addActionError("市场法综合修正数据不符合导入要求！");
		}catch(Exception ex){
			ex.printStackTrace();
			this.addActionError("市场法综合修正数据不符合导入要求！"+ex.getMessage());
		}
	}
	
	/**
	 * 估价分区数据导入
	 * @return
	 * @throws Exception
	 */
	public String importFile() throws Exception {
		Pgv00353 eBean = new Pgv00353();
		try{
			eBean = t00353Service.ImportExcelData(ebList);
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
				ByteArrayOutputStream out = (ByteArrayOutputStream) Excel.exportDataZHXZ(eBean.getOutList(),1);
				excelStream = new ByteArrayInputStream(out.toByteArray());
				fileName=new String("格式错误的市场法综合修正数据.xls".getBytes("GBK"),"ISO-8859-1");
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
	 *查询信息导出
	 * @return
	 * @throws Exception
	 */
	public String export() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}
		
		Pgv00353 v00353 = new Pgv00353();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准备查询条件
			v00353.setCd00001Szqy(CheckUtil.chkTrim(ddlSZQYFind));
			v00353.setCd00001Root(ROOT);
			v00353.setCd00001Infoid(CheckUtil.chkTrim(txtCGZKFind));
			v00353.setCd00002Pssd(CheckUtil.chkTrim(txtPSSDFind));
			v00353.setPageIndex(1);
			v00353.setPageSize(-1);
			v00353.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			
			ByteArrayOutputStream out = (ByteArrayOutputStream) t00353Service.ExportZHXZSjcx(v00353);
			setExcelStream(new ByteArrayInputStream(out.toByteArray()));
		}catch (Exception e) {
			this.addActionError(e.getMessage());
			return INPUT;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
		}
		
		return SUCCESS;
		
		
	}
	
	
	
	/**
	 * 对[估价分区]合法性进行检验
	 * @param list
	 * @return
	 */
	private Boolean checkDateList(ArrayList<Pgv00353> list){
		//TODO 处理保留 对[估价分区]合法性进行检验
		return true;
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
		t00353Bean = new Pgt00353();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			ReadInfo();

			t00353Bean.setSpssd(ddlPSSD);
			t00353Bean.setTpssd(txtPSSD);
			t00353Bean.setCd00001Szqy(ddlSZQY);
			t00353Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t00353Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));

			if(t00353Service.ExecuteParamCopy(getT00353Bean()))
				this.addActionMessage(getText(Constant.MSG_COPY_OK, new String[]{getT00353Bean().getSpssd()}));
			else
				this.addActionError(getText(Constant.MSG_COPY_NG, new String[]{getT00353Bean().getSpssd()}));
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
		setACTIONNAME("EXET00353COPY");
		setHREFNAME("VIEWT00353");
		setTITLENAME(getText("app.xtwh.t00353.title"));
		setURL("003539");
		szqyList = sessionCtrl.ReadSzqyList();
	}
	/*********************** set and get ******************************/

	/**
	 * @return the t00353Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00353Service getT00353Service() {
		return t00353Service;
	}

	/**
	 * @param t00353Service the t00353Service to set
	 */
	public void setT00353Service(IPgt00353Service t00353Service) {
		this.t00353Service = t00353Service;
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
	 * @return the t00353Bean
	 */
	public Pgt00353 getT00353Bean() {
		return t00353Bean;
	}

	/**
	 * @param t00353Bean the t00353Bean to set
	 */
	public void setT00353Bean(Pgt00353 t00353Bean) {
		this.t00353Bean = t00353Bean;
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

	public void setTxtFWLX(String txtFWLX) {
		this.txtFWLX = txtFWLX;
	}

	public String getTxtFWLX() {
		return txtFWLX;
	}
	public String getFWLX() {
		return FWLX;
	}

	public void setFWLX(String fWLX) {
		FWLX = fWLX;
	}

	/**
	 * @return the rows
	 */
	public ArrayList<Pgv00353> getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(ArrayList<Pgv00353> rows) {
		this.rows = rows;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageSize() {
		return Common.getPageSize(pageSize);
	}

	@JSON(deserialize=false, serialize=false)
	public IPgt00001Service getT00001Service() {
		return t00001Service;
	}

	public void setT00001Service(IPgt00001Service t00001Service) {
		this.t00001Service = t00001Service;
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

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getTxtFilePath() {
		return txtFilePath;
	}

	public void setTxtFilePath(String txtFilePath) {
		this.txtFilePath = txtFilePath;
	}

	public ArrayList<Pgv00353> getEbList() {
		return ebList;
	}

	public void setEbList(ArrayList<Pgv00353> ebList) {
		this.ebList = ebList;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}


	
	
}
