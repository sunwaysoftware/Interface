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
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.Excel;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.ExcelBean;
import com.sunway.vo.Pgt00303;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv00303;

/**
 * 市场法楼房信息表维护（PGT00303）
 *
 * @author Lee
 * @version 1.0
 */

public class Pgt00303Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -6219248325201064316L;
	// Service
	private IPgt00303Service t00303Service;
	// View
	private ArrayList<Pgv00052> szqyList;
	// 分页参数
	private Integer pageIndex;
	private Integer pageSize;
	private Integer rowCount;
	// Bean数组
	private ArrayList<Pgv00303> tabList;
	// 检索条件
	private String ddlSZQYFind;
	private String txtXQFind;
	private String txtFWTDZLFind;
	private String rdoUnite;
	//编辑操作符
	private String ACT;
	//primary key 主键
	private String LFID;
	// edit页面所需Bean
	private Pgt00303 t00303Bean;
	// edit页面提交数据
	private String txtLFID;
	private String txtXQDM;
	private String txtJZJG;
	private Boolean rdoYWDT;
	private Boolean rdoYWJKC;
	private Short txtZLC;
	private String txtFWTDZL;
	private String txtNOTE;
	private String txtUPDATE;
	private String txtZCDZL;
	private String txtZCDZBM;
	private Integer txtZCDZType;
	private String txtCLH;
	
	// 自动完成
	private ArrayList<String> dataList;
	// 合并
	private String[] chkDataHB;
	private ArrayList<Pgv00303> hbInitList;
	private Pgv00303 v00303Bean;
	private String hbLfidList;
	private Boolean FINDRTNFLAG = false;
	private String ddlSZQY;
	private String message;
	private String FWTDZL;
	private SessionCtrl sessionCtrl = new SessionCtrl();

	//file upload
	private String title;
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private String savePath;
	private String fileServerPath;
	//file import
	private String txtFilePath;
	private ArrayList<Pgv00303> Pgv00303List;
	private InputStream excelStream;
	private ArrayList<ExcelBean> ebList;
	private String fileName;
	private String FROMCJ;//判断是否来自采集
	private Boolean isEXISTLF;
	private String txtLH;
	private String txtDyh;
	private String txtFh;
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
			// 取得下拉菜单信息
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
	public String query() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}

		Pgv00303 v00303 = new Pgv00303();
		try {
			// 准备查询条件
			v00303.setCd00001Szqy(ddlSZQYFind);
			v00303.setCd00352Xqdm(Common.trim(txtXQFind));
			v00303.setZcdzl(Common.getSearchLike(txtZCDZL));
			v00303.setPageIndex(pageIndex);
			v00303.setPageSize(getPageSize());
			v00303.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			// 执行查询
			tabList = t00303Service.LoadAll(v00303);
			// 分页设置
			if (null != tabList && tabList.size() > 0) {
				rowCount = tabList.get(0).getRecordCount();
			} else {
				rowCount = 0;
				pageIndex = 1;
			}
			// 取得修正类型列表
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
	 * 新增状态处理
	 * @return
	 * @throws Exception
	 */
	public String create() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** start **********");
		}

		Pgt00303 t00303 = new Pgt00303();
		t00303Bean = new Pgt00303();
		try {
			if (!Constant.MOD_CREATE.equals(getACT())) {
				// 取得用户选中的数据信息
				t00303.setLfid(LFID);
				t00303Bean = t00303Service.LoadByPrimaryKey(t00303);
			}
			if (Constant.MOD_CREATE.equals(getACT())
					&& !Common.isNullOrEmpty(ddlSZQY)
					&& !Common.isNullOrEmpty(txtXQDM)) {
				t00303Bean.setCd00001Szqy(ddlSZQY);
				t00303Bean.setCd00352Xqdm(txtXQDM);
			}
			// 取得下拉菜单信息
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

		t00303Bean = new Pgt00303();
		this.clearErrorsAndMessages();
		t00303Bean.setLfid(LFID);
		//根据PK取得信息，并为BEAN赋值
		if (Constant.MOD_UPDATE.equals(getACT())) {
			t00303Bean = t00303Service.LoadByPrimaryKey(t00303Bean);
		}
		// 判读数据是否已经被其他用户修改
		if ((Constant.MOD_UPDATE.equals(getACT()))
				&& (!t00303Bean.getUpddate().equals(
						Common.convertStringToTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		} else {
			t00303Bean.setLfid(LFID);
			t00303Bean.setClh(txtCLH);
			t00303Bean.setCd00001Szqy(ddlSZQY);
			t00303Bean.setCd00352Xqdm(txtXQDM);
			t00303Bean.setCd00001Jzjg(txtJZJG);
			t00303Bean.setYwdt(rdoYWDT);
			t00303Bean.setYwjkc(rdoYWJKC);
			t00303Bean.setZlc(txtZLC);
			t00303Bean.setZcdzl(txtFWTDZL);
			t00303Bean.setZcdzbm(txtZCDZBM);
			t00303Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t00303Bean.setNote(txtNOTE);
			t00303Bean.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
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
				if (t00303Service.GetInsertCommand(t00303Bean)) {
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[] { t00303Bean.getZcdzbm() }));
					ddlSZQY = t00303Bean.getCd00001Szqy();
					txtXQDM = t00303Bean.getCd00352Xqdm();
				} else {
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[] { t00303Bean.getZcdzbm() }));
				}
			} else if (Constant.MOD_UPDATE.equals(getACT())) { // Update
				if (t00303Service.GetUpdateCommand(t00303Bean)) {
					t00303Bean = t00303Service.LoadByPrimaryKey(t00303Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[] { t00303Bean.getZcdzbm() }));
				} else {
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[] { t00303Bean.getZcdzbm() }));
				}
			} else if (Constant.MOD_DELETE.equals(getACT())) { // Delete
				if (t00303Service.GetDeleteCommand(t00303Bean)) {
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[] { t00303Bean.getLfid() }));
					rtn = "successDEL";
				} else {
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[] { t00303Bean.getLfid() }));
				}
			}
		} catch (SQLException e) {
			String[] msgList = e.getMessage().split("\n");
			for (String msg : msgList) {
				this.addActionError(msg);
			}
			return INPUT;
		} catch (Exception e) {
			LOG.error(e.getMessage());
			return ERROR;
		}finally{
			// 取得下拉菜单信息
			ReadInfo();
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** end **********");
		}
		return rtn;
	}

	/**
	 * 取得下拉菜单信息
	 * @throws Exception
	 */
	private void ReadInfo() throws Exception {
		// 取得所在区域列表信息
		szqyList = sessionCtrl.ReadSzqyList();
	}

	/**
	 * 自动完成座落地址
	 * @return
	 * @throws Exception
	 */
	public String queryFwtdzldat() throws Exception {
		Pgv00303 v00303 = new Pgv00303();
		try {
			// 准备查询条件
			v00303.setSzqy(ddlSZQY);
			v00303.setZcdzl(Common.getSearchLike(txtZCDZL));
			// 执行查询
			dataList = t00303Service.GetFwtdzl(v00303);
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * [自动完成]楼栋地址
	 * @return
	 * @throws Exception
	 */
	public String queryLhdzdat() throws Exception {
		Pgv00303 v00303 = new Pgv00303();
		try {
			// 准备查询条件

			v00303.setSzqy(ddlSZQY);
			v00303.setZcdzl(txtZCDZL);
			v00303.setLh(Common.getSearchLike(txtLH));
			// 执行查询
			dataList = t00303Service.GetLhdz(v00303);
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * [自动完成]单元号地址
	 * @return
	 * @throws Exception
	 */
	public String queryDyhdzdat() throws Exception {
		Pgv00303 v00303 = new Pgv00303();
		try {
			// 准备查询条件

			v00303.setSzqy(ddlSZQY);
			v00303.setZcdzl(txtZCDZL);
			v00303.setLh(txtLH);
			v00303.setDyh(Common.getSearchLike(txtDyh));
			// 执行查询
			dataList = t00303Service.GetDyhdz(v00303);
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * [自动完成]房号地址
	 * @return
	 * @throws Exception
	 */
	public String queryFhdzdat() throws Exception {
		Pgv00303 v00303 = new Pgv00303();
		try {
			// 准备查询条件

			v00303.setSzqy(ddlSZQY);
			v00303.setZcdzl(txtZCDZL);
			v00303.setLh(txtLH);
			v00303.setDyh(txtDyh);
			v00303.setFh(Common.getSearchLike(txtFh));
			// 执行查询
			dataList = t00303Service.GetFhdz(v00303);
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * 合并初始化
	 * @return
	 * @throws Exception
	 */
	public String hbInit() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("hbInit() ********** start **********");
		}
		try {
			hbLfidList = "";
			if (chkDataHB.length > 0) {
				for (int i = 0; i <= chkDataHB.length - 1; i++) {
					hbLfidList += chkDataHB[i]
							+ Constant.STRING_COMMA;
				}
				hbLfidList = Common.removeComma(hbLfidList);
				hbInitList = t00303Service.GetHbInitList(hbLfidList);
			}
			ReadInfo();
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("hbInit() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("hbInit() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 自动完成前
	 * @return 如果有值填充，没有则返回NULL
	 * @throws Exception
	 */
	public String beforeCreateByAjax() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("beforeCreateByAjax() ********** start **********");
		}
		v00303Bean = new Pgv00303();
		Pgv00303 v00303 = v00303Bean;
		try {
			// 准备查询条件
			v00303.setZcdzl(Common.convertEncoding(txtZCDZL));
			v00303.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			// 执行查询
			v00303Bean = t00303Service.GetLFID(v00303);
			isEXISTLF = (null != v00303Bean)?true:false;
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("beforeCreateByAjax() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("createByAjax() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 点击搜索按钮的ajax事件，
	 * @return 如果有值填充，没有则返回NULL
	 * @throws Exception
	 */
	public String CreateByAjax() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("createByAjax() ********** start **********");
		}
		v00303Bean = new Pgv00303();
		Pgv00303 v00303 = v00303Bean;
		try {
			// 准备查询条件
			v00303.setZcdzl(txtZCDZL);
			v00303.setClh(txtCLH);
			v00303.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			// 执行查询
			v00303Bean = t00303Service.GetLFID(v00303);
			if (null != v00303Bean) {
				//FINDRTNFLAG = true;
			} else {
				v00303Bean = v00303;
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("createByAjax() ********** end **********");
			}
			return ERROR;
		} finally {
			szqyList = sessionCtrl.ReadSzqyList();
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("createByAjax() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 取得选中项目的楼房信息
	 * @return
	 * @throws Exception
	 */
	public String findLfxx() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("findLfxx() ********** start **********");
		}
		Pgt00303 t00303 = new Pgt00303();
		t00303Bean = new Pgt00303();
		try {
			// 准备查询条件
			t00303.setLfid(LFID);
			t00303Bean = t00303Service.LoadByPrimaryKey(t00303);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("findLfxx() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("findLfxx() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 合并处理
	 *
	 * @return
	 * @throws Exception
	 */
	public String hbUpdate() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("hbUpdate() ********** start **********");
		}
		t00303Bean = new Pgt00303();
		this.clearErrorsAndMessages();
		try {
			t00303Bean.setLfid(rdoUnite);
			t00303Bean.setYwdt(true);
			t00303Bean.setZlc(Common.convertToShort("7"));
			t00303Bean.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			t00303Bean.setHbLfidList(hbLfidList);
			if (t00303Service.GetHBCommand(t00303Bean)) {
				this.addActionMessage(getText("合并成功", new String[] { t00303Bean.getHbLfidList() }));
			} else {
				this.addActionError(getText("合并失败", new String[] { t00303Bean.getHbLfidList() }));
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("hbUpdate() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("hbUpdate() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 根据别名查地址
	 * @return
	 * @throws Exception
	 */
	public String findFwdz() throws Exception {
		v00303Bean = new Pgv00303();
		try {
			// 准备查询条件
			v00303Bean.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v00303Bean.setZcdzbm(Common.convertEncoding(txtZCDZBM));
			v00303Bean = t00303Service.GetFWDZ(v00303Bean);
		} catch (Exception e) {
			LOG.error(e.getMessage());
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

	
	/**
	 * 导入校验
	 */
	public void validateImportFile() {
		if(!Common.isFileExist(txtFilePath)){
			this.addActionError("文件错误，请检查！");
		}
		try{
			//检验数据合法性
			ebList = Excel.resolveExcelLFPC(txtFilePath, sessionCtrl.getUserId(),sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(!checkDateList(ebList))
				this.addActionError("楼房普查数据不符合导入要求！");
			if(ebList.size()==0)
				this.addActionError("楼房普查数据不符合导入要求！");
		}catch(Exception ex){
			ex.printStackTrace();
			this.addActionError(ex.getMessage());
		}
	}
	/**
	 * 楼房普查数据导出
	 * @return
	 * @return Exception
	 */
      public String export() throws Exception{
    	  if(LOG.isDebugEnabled()){
    		  LOG.debug("query() ********** start **********");
    	  }
    	  Pgv00303 v00303 =new Pgv00303();
    	 
    	  try{
    		  sessionCtrl =new SessionCtrl(ActionContext.getContext().getSession());
    		  v00303.setCd00001Szqy(ddlSZQYFind);
  			  v00303.setCd00352Xqdm(Common.trim(txtXQFind));
  			  v00303.setZcdzl(Common.getSearchLike(txtZCDZL));
  			  v00303.setPageIndex(1);
  			  v00303.setPageSize(-1);
  			  v00303.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
    		  
  			ByteArrayOutputStream out = (ByteArrayOutputStream) t00303Service.ExportlfpcSjcx(v00303);
//			setExcelStream(new ByteArrayInputStream(out.toByteArray()));
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
	 * 楼房普查数据导入
	 * @return
	 * @throws Exception
	 */
	public String importFile() throws Exception {
		ExcelBean eBean = new ExcelBean();
		try{
			eBean = t00303Service.ImportExcelData(ebList);
		}catch(Exception ex){
			ex.printStackTrace();
			this.addActionError(ex.getMessage());
			return INPUT;
		}finally{
			if(eBean.getExportOutCome()==3)
				this.addActionError("数据导入失败，请重新选择模版导入！");
			else if(eBean.getExportOutCome()==2)
				this.addActionMessage("数据导入执行完毕！");
			else{
				ByteArrayOutputStream out = (ByteArrayOutputStream) Excel.exportCommonDataLFPC(eBean.getOutExcelList(),2);
				excelStream = new ByteArrayInputStream(out.toByteArray());
				fileName=new String("格式错误的楼房普查数据.xls".getBytes("GBK"),"ISO-8859-1");
				return "failexport";
			}
			/*
			else if (tmpV00303.getOutFlag()==1)
				this.addActionMessage("数据导入执行完毕，但导入过程中部分失败！");
			else 
				this.addActionError("数据导入失败！");
			*/
		}
		return SUCCESS;
	}

	/**
	 * 对[楼房普查]合法性进行检验
	 * @param list
	 * @return
	 */
	private Boolean checkDateList(ArrayList<ExcelBean> list){
		//TODO 处理保留 对[楼房普查]合法性进行检验
		return true;
	}

	/*********************** setter and getter ******************************/

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
	 * @return the lFID
	 */
	public String getLFID() {
		return LFID;
	}
	/**
	 * @param lFID the lFID to set
	 */
	public void setLFID(String lFID) {
		LFID = lFID;
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
	 * @return the chkDataHB
	 */
	public String[] getChkDataHB() {
		return chkDataHB;
	}
	/**
	 * @param chkDataHB the chkDataHB to set
	 */
	public void setChkDataHB(String[] chkDataHB) {
		this.chkDataHB = chkDataHB;
	}
	/**
	 * @return the hbInitList
	 */
	public ArrayList<Pgv00303> getHbInitList() {
		return hbInitList;
	}
	/**
	 * @param hbInitList the hbInitList to set
	 */
	public void setHbInitList(ArrayList<Pgv00303> hbInitList) {
		this.hbInitList = hbInitList;
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
	 * @return the hbLfidList
	 */
	public String getHbLfidList() {
		return hbLfidList;
	}
	/**
	 * @param hbLfidList the hbLfidList to set
	 */
	public void setHbLfidList(String hbLfidList) {
		this.hbLfidList = hbLfidList;
	}
	/**
	 * @return the fINDRTNFLAG
	 */
	public Boolean getFINDRTNFLAG() {
		return FINDRTNFLAG;
	}
	/**
	 * @param fINDRTNFLAG the fINDRTNFLAG to set
	 */
	public void setFINDRTNFLAG(Boolean fINDRTNFLAG) {
		FINDRTNFLAG = fINDRTNFLAG;
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
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
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
	 * @param dataList the dataList to set
	 */
	public void setDataList(ArrayList<String> dataList) {
		this.dataList = dataList;
	}

	/**
	 * @return the dataList
	 */
	public ArrayList<String> getDataList() {
		return dataList;
	}

	/**
	 * @param txtZCDZType the txtZCDZType to set
	 */
	public void setTxtZCDZType(Integer txtZCDZType) {
		this.txtZCDZType = txtZCDZType;
	}

	/**
	 * @return the txtZCDZType
	 */
	public Integer getTxtZCDZType() {
		return txtZCDZType;
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
	 * @return the pgv00303List
	 */
	public ArrayList<Pgv00303> getPgv00303List() {
		return Pgv00303List;
	}

	/**
	 * @param pgv00303List the pgv00303List to set
	 */
	public void setPgv00303List(ArrayList<Pgv00303> pgv00303List) {
		Pgv00303List = pgv00303List;
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
	 * @return the ebList
	 */
	public ArrayList<ExcelBean> getEbList() {
		return ebList;
	}

	/**
	 * @param ebList the ebList to set
	 */
	public void setEbList(ArrayList<ExcelBean> ebList) {
		this.ebList = ebList;
	}

	/**
	 * @return the fROMCJ
	 */
	public String getFROMCJ() {
		return FROMCJ;
	}

	/**
	 * @param fROMCJ the fROMCJ to set
	 */
	public void setFROMCJ(String fROMCJ) {
		FROMCJ = fROMCJ;
	}

	/**
	 * @return the isEXISTLF
	 */
	public Boolean getIsEXISTLF() {
		return isEXISTLF;
	}

	/**
	 * @param isEXISTLF the isEXISTLF to set
	 */
	public void setIsEXISTLF(Boolean isEXISTLF) {
		this.isEXISTLF = isEXISTLF;
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

	public String getRdoUnite() {
		return rdoUnite;
	}

	public void setRdoUnite(String rdoUnite) {
		this.rdoUnite = rdoUnite;
	}

	public void setRdoYWJKC(Boolean rdoYWJKC) {
		this.rdoYWJKC = rdoYWJKC;
	}

	public Boolean getRdoYWJKC() {
		return rdoYWJKC;
	}

	/**
	 * @return the tabList
	 */
	public ArrayList<Pgv00303> getTabList() {
		return tabList;
	}

	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv00303> tabList) {
		this.tabList = tabList;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageSize() {
		return Common.getPageSize(pageSize);
	}

	

	/**
	 * @return the txtDyh
	 */
	public String getTxtDyh() {
		return txtDyh;
	}

	/**
	 * @param txtDyh the txtDyh to set
	 */
	public void setTxtDyh(String txtDyh) {
		this.txtDyh = txtDyh;
	}

	/**
	 * @return the txtFh
	 */
	public String getTxtFh() {
		return txtFh;
	}

	/**
	 * @param txtFh the txtFh to set
	 */
	public void setTxtFh(String txtFh) {
		this.txtFh = txtFh;
	}

	/**
	 * @return the txtLH
	 */
	public String getTxtLH() {
		return txtLH;
	}

	/**
	 * @param txtLH the txtLH to set
	 */
	public void setTxtLH(String txtLH) {
		this.txtLH = txtLH;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl = new SessionCtrl(arg0);
	}

}
