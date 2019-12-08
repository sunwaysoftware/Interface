package com.sunway.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00303Service;
import com.sunway.service.IPgt00357Service;
import com.sunway.service.IPgt00357eService;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.Excel;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt00303;
import com.sunway.vo.Pgt00357;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv00303;
import com.sunway.vo.Pgv00357;
import com.sunway.vo.Pgv00357e;

/**
 *
 * 市场法实例库
 * @category 系统维护
 * @author Lee create
 * @author Andy.Gao fix
 * @version 1.0
 *
 */

public class Pgt00357Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 4959430882020525418L;
	// Service
	private IPgt00357Service t00357Service;
	private IPgt00303Service t00303Service;
	
	private IPgt00357eService t00357eService;
	// View
	private ArrayList<Pgv00052> szqyList;
	// 分页参数
	private Integer pageIndex;
	private Integer pageSize;
	private Integer rowCount;
	// Bean数组
	private ArrayList<Pgv00357> tabList;
	private Pgv00357 v00357Bean;
	// 检索条件
	private String txtSWIDFind;
	private String txtNSRMCFind;
	private String txtFDCDATFind;
	private String txtXQFind;
	private String txtFWTDZLFind;
	private String ddlSZQYFind;
	private String txtSLIDFind;
	//编辑操作符
	private String ACT;
	//primary key 主键
	private String SLID;
	// edit页面所需Bean
	private Pgt00357 tBean;
	private Pgt00303 t00303Bean;
	// edit页面提交数据
	private String txtUPDATE;
	private String txtSWID;
	private String txtLFID;
	private String txtFWLX;
	private String txtJYLX;
	private String txtJZJGT;
	private String txtJZMJ;
	private String txtFWCX;
	private String txtCGZK;
	private Short txtSZLC;
	private String txtBWJFH;
	private String txtPGJG;
	private String txtJYSJ;
	private String txtFDCDAT;
	private String txtNOTET00357;
	private String txtJZJG;
	private Boolean rdoYWDT;
	private Boolean rdoYWJKC;
	private Short txtZLC;
	private String txtNOTE;
	private String ddlSZQY;
	private ArrayList<Pgv00357e> qtxzList;
	private String XZLX;
	private String hidQTXZ;
	private String txtXQDM;
	private String FWTDZL;
	private String txtNSRMC;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	private Pgv00303 v00303Bean;
	private String txtFCZH;
	private String txtQDH;
	private String txtCB;
	private String txtGHYT;
	private String txtHXJG;
	private String txtJCSJ;
	private String txtJTZKId;
	private String txtWYZKId;
	private String txtZXZKId;
	private String txtZCDZL;
	private String txtZCDZBM;
	private String SysDate;
	
	//file upload
	private File upload;
	private String uploadFileName;
	private String savePath;
	private String fileServerPath;
	
	//file import
	private String txtFilePath;
	private ArrayList<Pgv00357> Pgv00357List;
	private InputStream excelStream;
	private String fileName;
	private String chkSel;
	private String txtCLH;
	private String hidZHXZid;
	private String txtCSYF;
	
	private String ddlSZQYFindBZF;
	private String txtXQFindBZF;
	private String txtFWLXFindBZF;
	private String resMsgBZF;
	
	private String txtLH;
	private String txtDYH;
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
			ReadInfo();
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
	public String queryZhxz() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}
		
		try {
			Pgv00357e v00357e = new Pgv00357e();
			v00357e.setCd00357Slid(SLID);
			v00357e.setCd00001Szqy(ddlSZQY);
			v00357e.setCd00001Fwlx(txtFWLX);
			qtxzList = t00357eService.LoadAll(v00357e);
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
	 * 查询状态处理
	 *
	 * @return
	 * @throws Exception
	 */
	public String delsel() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}

		Pgv00357 v00357 = new Pgv00357();
		try {
			// 准备查询条件
			v00357.setChkSel(chkSel);	
			v00357.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			v00357.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			// 执行查询
			t00357Service.GetDeleteSelCommand(v00357);
			
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
	 * 查询状态处理
	 *
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}

		Pgv00357 v00357 = new Pgv00357();
		try {
			// 准备查询条件
			v00357.setSlid(Common.getSearchLike(Common.convertEncoding(txtSLIDFind)));
			v00357.setCd00301Swid(Common.getSearchLike(Common.trim(txtSWIDFind)));
			v00357.setNsrmc(Common.getSearchLike(txtNSRMCFind));
			v00357.setFdcdat(Common.trim(txtFDCDATFind));
			v00357.setCd00001Szqy(ddlSZQYFind);
			v00357.setCd00352Xqdm(Common.trim(txtXQFind));
			v00357.setZcdzl(Common.getSearchLike(txtZCDZL));
			v00357.setPageIndex(pageIndex);
			v00357.setPageSize(getPageSize());
			v00357.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			// 执行查询
			tabList = t00357Service.LoadAll(v00357);
			// 分页设置
			if (null != tabList && tabList.size() > 0) {
				rowCount = Common.checkNull(tabList.get(0).getRecordCount());
			} else {
				rowCount = 0;
				pageIndex = 1;
			}
			ReadInfo();
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
	 * 可比实例库数据导出
	 * @return
	 * @return Exception
	 */
      public String export() throws Exception{
    	  if(LOG.isDebugEnabled()){
    		  LOG.debug("query() ********** start **********");
    	  }
    	  Pgv00357 v00357 =new Pgv00357();
    	 
    	  try{
    		  sessionCtrl =new SessionCtrl(ActionContext.getContext().getSession());
    		 v00357.setSlid(Common.getSearchLike(Common.convertEncoding(txtSLIDFind)));
  			v00357.setCd00301Swid(Common.getSearchLike(Common.trim(txtSWIDFind)));
  			v00357.setNsrmc(Common.getSearchLike(txtNSRMCFind));
  			v00357.setFdcdat(Common.trim(txtFDCDATFind));
  			v00357.setCd00001Szqy(ddlSZQYFind);
  			v00357.setCd00352Xqdm(Common.trim(txtXQFind));
  			v00357.setZcdzl(txtZCDZL);
  			v00357.setPageIndex(1);
  			v00357.setPageSize(-1);
  			v00357.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
    		  
  			ByteArrayOutputStream out = (ByteArrayOutputStream) t00357Service.ExportkbslSjcx(v00357);
			excelStream = new ByteArrayInputStream(out.toByteArray());
    	  }catch(Exception e){
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
	public String create() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** start **********");
		}

		Pgt00357 t00357 = new Pgt00357();
		tBean = new Pgt00357();
		v00303Bean = new Pgv00303();
		try {
			if (!Constant.MOD_CREATE.equals(getACT())) {
				// 取得用户选中的数据信息
				t00357.setSlid(SLID);
				tBean = t00357Service.LoadByPrimaryKey(t00357);
				//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
				v00303Bean.setLfid(tBean.getCd00303Lfid());
				v00303Bean.setPageIndex(1);
				v00303Bean.setPageSize(getPageSize());
				v00303Bean.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
				ArrayList<Pgv00303> v00303List = t00303Service.LoadAll(v00303Bean);
				if (null != v00303List && v00303List.size() > 0) {
					v00303Bean = v00303List.get(0);
				}	
				
			} else {				
				SysDate = Common.readCurrentDateHMS();
			}
			ReadInfo();
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

		tBean = new Pgt00357();
		this.clearErrorsAndMessages();
		tBean.setSlid(SLID);
		//根据PK取得信息，并为BEAN赋值
		if (Constant.MOD_UPDATE.equals(getACT())) {
			tBean = t00357Service.LoadByPrimaryKey(tBean);
		}
		// 判读数据是否已经被其他用户修改
		if ((Constant.MOD_UPDATE.equals(getACT()))
				&& (!tBean.getUpddate().equals(
						Common.convertStringToTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		} else {
			tBean.setSlid(SLID);
			tBean.setCd00301Swid(txtSWID);
			tBean.setNsrmc(txtNSRMC);
			tBean.setCd00303Lfid(txtLFID);
			tBean.setCd00001Fwlx(txtFWLX);
			tBean.setCd00001Jylx(txtJYLX);
			tBean.setCd00001Jzjg(txtJZJGT);
			tBean.setJzmj(Common.convertToBigDecimal(txtJZMJ));
			tBean.setCd00001Fwcx(txtFWCX);
			tBean.setCd00001Cgzk(txtCGZK);
			tBean.setSzlc(txtSZLC);
			tBean.setBwjfh(txtBWJFH);
			tBean.setPgjg(Common.convertToBigDecimal(txtPGJG));
			tBean.setJysj(Common.convertStringToTimestamp(txtJYSJ));
			tBean.setFdcdat(txtFDCDAT);
			tBean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			tBean.setNote(txtNOTET00357);
			tBean.setFczh(txtFCZH);
			tBean.setQdh(txtQDH);
			tBean.setCb(txtCB);
			tBean.setGhyt(txtGHYT);
			tBean.setHxjg(txtHXJG);
			tBean.setJcsj(txtJCSJ);
			tBean.setCd00001Jtzk(txtJTZKId);
			tBean.setCd00001Wyzk(txtWYZKId);
			tBean.setCd00001Zxzk(txtZXZKId);
			tBean.setZcdzl(txtZCDZL);
			tBean.setZcdzbm(txtZCDZBM);
			tBean.setCd00352Xqdm(txtXQDM);
			tBean.setCd00001Jzjg1(txtJZJG);
			tBean.setYwdt(rdoYWDT);
			tBean.setZlc(txtZLC);
			tBean.setNote1(txtNOTE);
			tBean.setCd00053Qtxzid(hidQTXZ);
			tBean.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			tBean.setZhxz(hidZHXZid);
			tBean.setClh(txtCLH);
			tBean.setYwjkc(rdoYWJKC);
			tBean.setLh(txtLH);
			tBean.setDyh(txtDYH);
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
		String rtn = SUCCESS;
		try {
			if (Constant.MOD_CREATE.equals(getACT())) { // Create
				if (t00357Service.GetInsertCommand(tBean)) {
					this.addActionMessage(getText(Constant.MSG_CREATE_OK));
				} else {
					this.addActionError(getText(Constant.MSG_CREATE_NG));
				}
			} else if (Constant.MOD_UPDATE.equals(getACT())) { // Update
				if (t00357Service.GetUpdateCommand(tBean)) {
					tBean = t00357Service.LoadByPrimaryKey(tBean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[] { tBean.getFczh() }));
				} else {
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[] { tBean.getFczh() }));
				}
			} else if (Constant.MOD_DELETE.equals(getACT())) { // Delete
				if (t00357Service.GetDeleteCommand(tBean)) {
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[] { tBean.getFczh() }));
					rtn = "successDEL";
				} else {
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[] { tBean.getFczh() }));
				}
			}
		} catch (SQLException sqlErr) {
			sqlErr.printStackTrace();
			this.addActionError(sqlErr.getMessage());
			return INPUT;
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());
			return ERROR;
		} finally {
			ReadInfo();
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** end **********");
		}
		return rtn;
	}

	/**
	 * 详细信息
	 * @return
	 * @throws Exception
	 */
	public String detail() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** start **********");
		}
		Pgv00357 v00357 = new Pgv00357();
		v00357Bean = new Pgv00357();
		try {
			// 准备查询条件
			v00357.setSlid(Common.convertEncoding(SLID));
			// 执行查询
			v00357Bean = t00357Service.LoadDetail(v00357);
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
	 * 取得下拉菜单信息
	 * @throws Exception
	 */
	private void ReadInfo() throws Exception {
		// 取得所在区域列表信息
		szqyList = sessionCtrl.ReadSzqyList();
	}
	


	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String upload() throws Exception {
		try{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			fileServerPath = getSavePath() + "\\KBSL_" + sessionCtrl.getUserId() + getUploadFileName();
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
		if(!Common.isFileExist(txtFilePath)){
			this.addActionError("文件错误，请检查！");
		}
		try{
			ReadInfo();
			//检验数据合法性
			Pgv00357List = Excel.importDataKbslk(txtFilePath, sessionCtrl.getUserId(),sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(!checkKbslk(Pgv00357List))
				this.addActionError("可比实例数据不符合导入要求！");
			if(Pgv00357List.size()==0)
				this.addActionError("可比实例数据不符合导入要求！");
		}catch(Exception ex){
			ex.printStackTrace();
			this.addActionError(ex.getMessage());
		}
	}
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String importFile() throws Exception {
		Pgv00357 tmpV00357 = new Pgv00357();
		try{
			tmpV00357 = t00357Service.ImportExcelData(Pgv00357List);
		}catch(Exception ex){
			ex.printStackTrace();
			this.addActionError(ex.getMessage());
			return INPUT;
		}finally{
			if(tmpV00357.getOutFlag()==3)
				this.addActionError("数据导入失败，请重新选择模版导入！");
			else if(tmpV00357.getOutFlag()==2)
				this.addActionMessage("数据导入执行完毕！");
			else{
				ByteArrayOutputStream out = (ByteArrayOutputStream) Excel.exportDataKbslk(tmpV00357.getOutList());
				excelStream = new ByteArrayInputStream(out.toByteArray());
				fileName=new String("格式错误的可比实例数据.xls".getBytes("GBK"),"ISO-8859-1");
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
	private Boolean checkKbslk(ArrayList<Pgv00357> list){
		//TODO 处理保留 对[挂牌数据]合法性进行检验
		return true;
	}
	
	
	
	/**
	 * 可比实例可测算具体
	 */
	public String queryKBSL()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("queryKBSL() ********** start **********");
		}
		Pgv00357 v00357 = new Pgv00357();
		try {
			// 准备查询条件			
			v00357.setPageIndex(1);
			v00357.setPageSize(-1);
			v00357.setSlid(SLID);
			v00357.setCsyf(Common.convertToInteger(txtCSYF));
			
			// 执行查询
			tabList = t00357Service.LoadCSKbslk(v00357);
			// 分页设置
			if (null != tabList && tabList.size() > 0) {
				rowCount = tabList.get(0).getRecordCount();
				//pageCount = Common.getPageCount(rowCount, sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE));
			} else {
				
				pageIndex = 1;
			}
			ReadInfo();
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());
			return ERROR;
		}
		
		
		if(LOG.isDebugEnabled()){
			LOG.debug("queryKBSL() ********** end **********");
			
		}
		return SUCCESS;
	}
	
	public String makeBZF()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("makeBZF() ********** start **********");
		}
		try{
			Pgv00357 v00357 = new Pgv00357();
			v00357.setCd00001Szqy(ddlSZQYFindBZF);
			v00357.setCd00352Xqdm(txtXQFindBZF);
			v00357.setCd00001Fwlx(txtFWLXFindBZF);
			v00357.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v00357.setCd00002Czr(sessionCtrl.getUserId());
			resMsgBZF = t00357Service.MakeBZF(v00357).toString();
		}catch(Exception e){
			LOG.error(e.getMessage());
			if(LOG.isDebugEnabled()){
				LOG.debug("makeBZF() ********** end **********");
			}
			return SUCCESS;
		}
		if(LOG.isDebugEnabled()){
			LOG.debug("makeBZF() ********** end **********");
		}
		return SUCCESS;
	}	
	/*********************** setter and getter ******************************/

	/**
	 * @return the t00357Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt00357Service getT00357Service() {
		return t00357Service;
	}
	/**
	 * @param t00357Service the t00357Service to set
	 */
	public void setT00357Service(IPgt00357Service t00357Service) {
		this.t00357Service = t00357Service;
	}
	/**
	 * @return the t00303Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt00303Service getT00303Service() {
		return t00303Service;
	}
	/**
	 * @param t00303Service the t00303Service to set
	 */
	public void setT00303Service(IPgt00303Service t00303Service) {
		this.t00303Service = t00303Service;
	}
	/**
	 * @return the t00357eService
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt00357eService getT00357eService() {
		return t00357eService;
	}
	/**
	 * @param t00357eService the t00357eService to set
	 */
	public void setT00357eService(IPgt00357eService t00357eService) {
		this.t00357eService = t00357eService;
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
	public ArrayList<Pgv00357> getTabList() {
		return tabList;
	}
	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv00357> tabList) {
		this.tabList = tabList;
	}
	/**
	 * @return the v00357Bean
	 */
	public Pgv00357 getV00357Bean() {
		return v00357Bean;
	}
	/**
	 * @param v00357Bean the v00357Bean to set
	 */
	public void setV00357Bean(Pgv00357 v00357Bean) {
		this.v00357Bean = v00357Bean;
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
	 * @return the txtSLIDFind
	 */
	public String getTxtSLIDFind() {
		return txtSLIDFind;
	}
	/**
	 * @param txtSLIDFind the txtSLIDFind to set
	 */
	public void setTxtSLIDFind(String txtSLIDFind) {
		this.txtSLIDFind = txtSLIDFind;
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
	 * @return the sLID
	 */
	public String getSLID() {
		return SLID;
	}
	/**
	 * @param sLID the sLID to set
	 */
	public void setSLID(String sLID) {
		SLID = sLID;
	}
	/**
	 * @return the tBean
	 */
	public Pgt00357 gettBean() {
		return tBean;
	}
	/**
	 * @param tBean the tBean to set
	 */
	public void settBean(Pgt00357 tBean) {
		this.tBean = tBean;
	}
	/**
	 * @return the t00303Bean
	 */
	public Pgt00303 getT00303Bean() {
		return t00303Bean;
	}
	/**
	 * @param t00303Bean the t00303Bean to set
	 */
	public void setT00303Bean(Pgt00303 t00303Bean) {
		this.t00303Bean = t00303Bean;
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
	 * @return the txtLFID
	 */
	public String getTxtLFID() {
		return txtLFID;
	}
	/**
	 * @param txtLFID the txtLFID to set
	 */
	public void setTxtLFID(String txtLFID) {
		this.txtLFID = txtLFID;
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
	 * @return the txtJZJGT
	 */
	public String getTxtJZJGT() {
		return txtJZJGT;
	}
	/**
	 * @param txtJZJGT the txtJZJGT to set
	 */
	public void setTxtJZJGT(String txtJZJGT) {
		this.txtJZJGT = txtJZJGT;
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
	 * @return the txtSZLC
	 */
	public Short getTxtSZLC() {
		return txtSZLC;
	}
	/**
	 * @param txtSZLC the txtSZLC to set
	 */
	public void setTxtSZLC(Short txtSZLC) {
		this.txtSZLC = txtSZLC;
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
	 * @return the txtPGJG
	 */
	public String getTxtPGJG() {
		return txtPGJG;
	}
	/**
	 * @param txtPGJG the txtPGJG to set
	 */
	public void setTxtPGJG(String txtPGJG) {
		this.txtPGJG = txtPGJG;
	}
	/**
	 * @return the txtFDCDAT
	 */
	public String getTxtFDCDAT() {
		return txtFDCDAT;
	}
	/**
	 * @param txtFDCDAT the txtFDCDAT to set
	 */
	public void setTxtFDCDAT(String txtFDCDAT) {
		this.txtFDCDAT = txtFDCDAT;
	}
	/**
	 * @return the txtNOTET00357
	 */
	public String getTxtNOTET00357() {
		return txtNOTET00357;
	}
	/**
	 * @param txtNOTET00357 the txtNOTET00357 to set
	 */
	public void setTxtNOTET00357(String txtNOTET00357) {
		this.txtNOTET00357 = txtNOTET00357;
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
	 * @return the rdoYWDT
	 */
	public Boolean getRdoYWDT() {
		return rdoYWDT;
	}
	/**
	 * @param rdoYWDT the rdoYWDT to set
	 */
	public void setRdoYWDT(Boolean rdoYWDT) {
		this.rdoYWDT = rdoYWDT;
	}
	/**
	 * @return the txtZLC
	 */
	public Short getTxtZLC() {
		return txtZLC;
	}
	/**
	 * @param txtZLC the txtZLC to set
	 */
	public void setTxtZLC(Short txtZLC) {
		this.txtZLC = txtZLC;
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
	 * @return the qtxzList
	 */
	public ArrayList<Pgv00357e> getQtxzList() {
		return qtxzList;
	}
	/**
	 * @param qtxzList the qtxzList to set
	 */
	public void setQtxzList(ArrayList<Pgv00357e> qtxzList) {
		this.qtxzList = qtxzList;
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
	 * @return the fWTDZL
	 */
	public String getFWTDZL() {
		return FWTDZL;
	}
	/**
	 * @param fWTDZL the fWTDZL to set
	 */
	public void setFWTDZL(String fWTDZL) {
		FWTDZL = fWTDZL;
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
	 * @return the v00303Bean
	 */
	public Pgv00303 getV00303Bean() {
		return v00303Bean;
	}
	/**
	 * @param v00303Bean the v00303Bean to set
	 */
	public void setV00303Bean(Pgv00303 v00303Bean) {
		this.v00303Bean = v00303Bean;
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
	 * @return the txtJYSJ
	 */
	public String getTxtJYSJ() {
		return txtJYSJ;
	}

	/**
	 * @param txtJYSJ the txtJYSJ to set
	 */
	public void setTxtJYSJ(String txtJYSJ) {
		this.txtJYSJ = txtJYSJ;
	}

	/**
	 * @return the txtFCZH
	 */
	public String getTxtFCZH() {
		return txtFCZH;
	}

	/**
	 * @param txtFCZH the txtFCZH to set
	 */
	public void setTxtFCZH(String txtFCZH) {
		this.txtFCZH = txtFCZH;
	}

	/**
	 * @return the txtQDH
	 */
	public String getTxtQDH() {
		return txtQDH;
	}

	/**
	 * @param txtQDH the txtQDH to set
	 */
	public void setTxtQDH(String txtQDH) {
		this.txtQDH = txtQDH;
	}

	/**
	 * @return the txtCB
	 */
	public String getTxtCB() {
		return txtCB;
	}

	/**
	 * @param txtCB the txtCB to set
	 */
	public void setTxtCB(String txtCB) {
		this.txtCB = txtCB;
	}

	/**
	 * @return the txtGHYT
	 */
	public String getTxtGHYT() {
		return txtGHYT;
	}

	/**
	 * @param txtGHYT the txtGHYT to set
	 */
	public void setTxtGHYT(String txtGHYT) {
		this.txtGHYT = txtGHYT;
	}

	/**
	 * @return the txtHXJG
	 */
	public String getTxtHXJG() {
		return txtHXJG;
	}

	/**
	 * @param txtHXJG the txtHXJG to set
	 */
	public void setTxtHXJG(String txtHXJG) {
		this.txtHXJG = txtHXJG;
	}

	/**
	 * @return the txtJCSJ
	 */
	public String getTxtJCSJ() {
		return txtJCSJ;
	}

	/**
	 * @param txtJCSJ the txtJCSJ to set
	 */
	public void setTxtJCSJ(String txtJCSJ) {
		this.txtJCSJ = txtJCSJ;
	}

	/**
	 * @return the txtJTZKId
	 */
	public String getTxtJTZKId() {
		return txtJTZKId;
	}

	/**
	 * @param txtJTZKId the txtJTZKId to set
	 */
	public void setTxtJTZKId(String txtJTZKId) {
		this.txtJTZKId = txtJTZKId;
	}

	/**
	 * @return the txtWYZKId
	 */
	public String getTxtWYZKId() {
		return txtWYZKId;
	}

	/**
	 * @param txtWYZKId the txtWYZKId to set
	 */
	public void setTxtWYZKId(String txtWYZKId) {
		this.txtWYZKId = txtWYZKId;
	}

	/**
	 * @return the txtZXZKId
	 */
	public String getTxtZXZKId() {
		return txtZXZKId;
	}

	/**
	 * @param txtZXZKId the txtZXZKId to set
	 */
	public void setTxtZXZKId(String txtZXZKId) {
		this.txtZXZKId = txtZXZKId;
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
	 * @return the txtZCDZBM
	 */
	public String getTxtZCDZBM() {
		return txtZCDZBM;
	}

	/**
	 * @param txtZCDZBM the txtZCDZBM to set
	 */
	public void setTxtZCDZBM(String txtZCDZBM) {
		this.txtZCDZBM = txtZCDZBM;
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
	 * @return the pgv00357List
	 */
	public ArrayList<Pgv00357> getPgv00357List() {
		return Pgv00357List;
	}

	/**
	 * @param pgv00357List the pgv00357List to set
	 */
	public void setPgv00357List(ArrayList<Pgv00357> pgv00357List) {
		Pgv00357List = pgv00357List;
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
	 * @return the sysDate
	 */
	public String getSysDate() {
		return SysDate;
	}

	/**
	 * @param sysDate the sysDate to set
	 */
	public void setSysDate(String sysDate) {
		SysDate = sysDate;
	}
	public String getDdlSZQY() {
		return ddlSZQY;
	}

	public void setDdlSZQY(String ddlSZQY) {
		this.ddlSZQY = ddlSZQY;
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

	public Boolean getRdoYWJKC() {
		return rdoYWJKC;
	}

	public void setRdoYWJKC(Boolean rdoYWJKC) {
		this.rdoYWJKC = rdoYWJKC;
	}

	public String getHidZHXZid() {
		return hidZHXZid;
	}

	public void setHidZHXZid(String hidZHXZid) {
		this.hidZHXZid = hidZHXZid;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageSize() {
		return Common.getPageSize(pageSize);
	}

	public String getTxtCSYF() {
		return txtCSYF;
	}

	public void setTxtCSYF(String txtCSYF) {
		this.txtCSYF = txtCSYF;
	}

	public String getDdlSZQYFindBZF() {
		return ddlSZQYFindBZF;
	}

	public void setDdlSZQYFindBZF(String ddlSZQYFindBZF) {
		this.ddlSZQYFindBZF = ddlSZQYFindBZF;
	}

	public String getTxtXQFindBZF() {
		return txtXQFindBZF;
	}

	public void setTxtXQFindBZF(String txtXQFindBZF) {
		this.txtXQFindBZF = txtXQFindBZF;
	}

	public String getTxtFWLXFindBZF() {
		return txtFWLXFindBZF;
	}

	public void setTxtFWLXFindBZF(String txtFWLXFindBZF) {
		this.txtFWLXFindBZF = txtFWLXFindBZF;
	}

	public String getResMsgBZF() {
		return resMsgBZF;
	}

	public void setResMsgBZF(String resMsgBZF) {
		this.resMsgBZF = resMsgBZF;
	}

	public String getTxtLH() {
		return txtLH;
	}


	public void setTxtLH(String txtLH) {
		this.txtLH = txtLH;
	}


	public String getTxtDYH() {
		return txtDYH;
	}


	public void setTxtDYH(String txtDYH) {
		this.txtDYH = txtDYH;
	}


	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl = new SessionCtrl(arg0);
	}

	
}
