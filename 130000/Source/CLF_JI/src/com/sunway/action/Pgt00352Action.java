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
import com.sunway.service.IPgt00352Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.Excel;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.ExcelBean;
import com.sunway.vo.Pgt00352;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv00352;

/**
 * 小区名称维护（PGT00352）
 * 
 * @author Lee
 * @version 1.0
 */

public class Pgt00352Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -2986061039708878433L;
	// Service
	private IPgt00352Service t00352Service;
	// View
	private ArrayList<Pgv00052> szqyList;
	// 分页参数
	private Integer pageIndex;
	private Integer pageSize;
	private Integer rowCount;
	// Bean数组
	private ArrayList<Pgv00352> tabList;
	private ArrayList<String> dataList = new ArrayList<>();
	
	// 检索条件
	private String ddlSZQYFind;
	private String txtXqnmFind;
	private String txtXqIdFind;
	private String txtXqDzFind;
	//编辑操作符
	private String ACT;
	//primary key 主键
	private String XQDM;
	// edit页面所需Bean
	private Pgt00352 t00352Bean;
	// edit页面提交数据
	private String ddlSZQY;
	private String txtXQNM;
	private String txtXQBM;
	private Short txtVIEWORDER;
	private String txtNOTE;//-->小区座落地址
	private Boolean rdoISDIR;
	private String txtUPDATE;
	private ArrayList<Pgt00352> navList;
	private ArrayList<Pgt00352> treeList;
	private ArrayList<Pgv00352> unableList;
	private ArrayList<Pgv00352> ableList;
	private String SZQY;
	private String NOXQDM;
	private String rdoXQ;
	private String PARENTDM;
	private String DDLABLEXQ;
	private String DDLUNABLEXQ;
	private String XQNM;
	private String txtXQDMH;
	//output stream
	private InputStream xqNav;
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
	private ArrayList<Pgv00352> Pgv00352List;
	private ArrayList<ExcelBean> ebList;
	private InputStream excelStream;
	private String fileName;
	private String SQZY;
	private Integer xqzt;
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

		Pgv00352 v00352 = new Pgv00352();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			v00352.setCd00001Szqy(ddlSZQYFind);
			v00352.setXqnm(Common.getSearchLike(txtXqnmFind));
			v00352.setXqdm(txtXqIdFind);
			v00352.setNote(Common.getSearchLike(txtXqDzFind));
			v00352.setPageIndex(pageIndex);
			v00352.setPageSize(getPageSize());
			v00352.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			// 执行查询
			tabList = t00352Service.LoadAll(v00352);
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

		Pgt00352 t00352 = new Pgt00352();
		t00352Bean = new Pgt00352();
		try {
			if (!Constant.MOD_CREATE.equals(getACT())) {
				// 取得用户选中的数据信息
				t00352.setXqdm(XQDM);
				t00352Bean = t00352Service.LoadByPrimaryKey(t00352);
			} else {
				t00352Bean.setCd00001Szqy(ddlSZQY);
				t00352Bean.setParentdm(rdoXQ);
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

		t00352Bean = new Pgt00352();
		this.clearErrorsAndMessages();
		t00352Bean.setXqdm(XQDM);
		//根据PK取得信息，并为BEAN赋值
		if (Constant.MOD_UPDATE.equals(getACT())) {
			t00352Bean = t00352Service.LoadByPrimaryKey(t00352Bean);
		}
		// 判读数据是否已经被其他用户修改
		if ((Constant.MOD_UPDATE.equals(getACT()))
				&& (!t00352Bean.getUpddate().equals(
						Common.convertStringToTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		} else {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			t00352Bean.setXqdm(XQDM);
			t00352Bean.setCd00001Szqy(ddlSZQY);
			t00352Bean.setParentdm(rdoXQ);
			t00352Bean.setXqnm(txtXQNM);
			t00352Bean.setXqdmh(txtXQDMH);
			t00352Bean.setXqbm(txtXQBM);
			t00352Bean.setVieworder(txtVIEWORDER);
			t00352Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t00352Bean.setNote(txtNOTE);
			t00352Bean.setIsdir(rdoISDIR);
			t00352Bean.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			
			
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
			LOG.debug("create() ********** start **********");
		}
		String rtn = "success";
		try {
			if (Constant.MOD_CREATE.equals(getACT())) { // Create
				//此处状态为估价分区采集页面默认
				t00352Bean.setXqzt(Common.convertToByte("0"));
				if (t00352Service.GetInsertCommand(t00352Bean)) {
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[] { t00352Bean.getXqnm() }));
					ddlSZQY = t00352Bean.getCd00001Szqy();
					rdoXQ = t00352Bean.getParentdm();
				} else {
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[] { t00352Bean.getXqnm() }));
				}
			} else if (Constant.MOD_UPDATE.equals(getACT())) { // Update
				if (t00352Service.GetUpdateCommand(t00352Bean)) {
					t00352Bean = t00352Service.LoadByPrimaryKey(t00352Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[] { t00352Bean.getXqnm() }));
				} else {
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[] { t00352Bean.getXqnm() }));
				}
			} else if (Constant.MOD_DELETE.equals(getACT())) { // Delete
				if (t00352Service.GetDeleteCommand(t00352Bean)) {
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[] { t00352Bean.getXqnm() }));
					rtn = "successDEL";
				} else {
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[] { t00352Bean.getXqnm() }));
				}
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("update() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** end **********");
		}
		return rtn;
	}

	/**
	 * 取得下拉菜单信息
	 * @throws Exception
	 */
	private void ReadInfo() throws Exception {
		//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
		// 取得所在区域列表信息
		szqyList = sessionCtrl.ReadSzqyList();
	}

	/**
	 * 读取导航条数据，AJAX方法用
	 * @return
	 * @throws Exception
	 */
	public String loadNavigator() throws Exception{		
		return getNavigator(SZQY,XQDM,NOXQDM,PARENTDM);
	}
	private String getNavigator(String szqy, String xqdm, String noxqdm,
			String parentdm) throws Exception {

		Pgt00352 v00352 = new Pgt00352();
		try {
			ReadInfo();
			if (!Common.isNullOrEmpty(szqy)){
				v00352.setCd00001Szqy(szqy);
			}
			if (!Common.isNullOrEmpty(xqdm)) {
				v00352.setXqdm(xqdm);
			}
			if (!Common.isNullOrEmpty(noxqdm)){
				v00352.setNoxqdm(noxqdm);
			}
			navList = t00352Service.LoadNavigator(v00352);
			treeList = t00352Service.LoadTreeList(v00352);
			t00352Bean = t00352Service.LoadByPrimaryKey(v00352);
			t00352Bean.setNoxqdm(noxqdm);
			t00352Bean.setParentdm(parentdm);
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * AJAX方法使用，取得小区导航
	 * @return
	 * @throws Exception
	 */
	public String LoadXQNav() throws Exception{
		return getNavStream(XQDM);
	}
	private String getNavStream(String xqdm) throws Exception {
		StringBuffer strBuf = new StringBuffer();
		try {
			
			if (!Common.isNullOrEmpty(xqdm)) {
				String xqnm = t00352Service.LoadNavStream(xqdm);
				if (!Common.isNullOrEmpty(xqnm))
					strBuf.append(xqnm);
				else
					strBuf.append(Constant.STRING_EMPTY);	
			}
			xqNav = Common.exportTEXT(strBuf);
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}
	/**
	 * 判断所在区域下小区名称是否重复，AJAX方法用
	 * @return
	 * @throws Exception
	 */
	public String loadXQ() throws Exception{		
		return getXQ(Common.trim(XQNM),SQZY,rdoXQ);
	}
	private String getXQ(String XQNM,String SQZY,String rdoXQ) throws Exception {

		Pgt00352 v00352 = new Pgt00352();
		try {
			ReadInfo();
			if (!Common.isNullOrEmpty(SQZY)){
				v00352.setCd00001Szqy(SQZY);
			}
			if (!Common.isNullOrEmpty(XQNM)) {
				v00352.setXqnm(XQNM);
			}
			if (!Common.isNullOrEmpty(rdoXQ)) {
				v00352.setParentdm(rdoXQ);
			}
			
			xqzt = t00352Service.LoadQX(v00352);
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}
	/**
	 * 地段嵌套处理
	 * @return
	 * @throws Exception
	 */
	public String frame() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("frame() ********** start **********");
		}
		t00352Bean = new Pgt00352();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				t00352Bean.setCd00001Szqy(ddlSZQY);
				t00352Bean.setXqdm(XQDM);
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("frame() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("frame() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 小区点击事件
	 * @return
	 * @throws Exception
	 */
	public String t00352Byxq() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("t00352Byxq() ********** start **********");
		}
		Pgt00352 t00352 = new Pgt00352();
		t00352Bean = new Pgt00352();
		try {
			// 取得用户选中的数据信息
			t00352.setXqdm(XQDM);
			t00352Bean = t00352Service.LoadByPrimaryKey(t00352);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("t00352Byxq() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("t00352Byxq() ********** end **********");
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
			fileServerPath = getSavePath() + "\\GJFQ_" + sessionCtrl.getUserId() + getUploadFileName();
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
			ReadInfo();
			//检验数据合法性
			ebList = Excel.resolveExcelGJFQ(txtFilePath, sessionCtrl.getUserId(),sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(!checkDateList(ebList))
				this.addActionError("估价分区数据不符合导入要求！");
			if(ebList.size()==0)
				this.addActionError("估价分区数据不符合导入要求！");
		}catch(Exception ex){
			ex.printStackTrace();
			this.addActionError(ex.getMessage());
		}
	}
	
	/**
	 * 估价分区数据导入
	 * @return
	 * @throws Exception
	 */
	public String importFile() throws Exception {
		ExcelBean eBean = new ExcelBean();
		try{
			eBean = t00352Service.ImportExcelData(ebList);
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
				ByteArrayOutputStream out = (ByteArrayOutputStream) Excel.exportCommonDataGJFQ(eBean.getOutExcelList(),1);
				excelStream = new ByteArrayInputStream(out.toByteArray());
				fileName=new String("格式错误的估价分区数据.xls".getBytes("GBK"),"ISO-8859-1");
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
	private Boolean checkDateList(ArrayList<ExcelBean> list){
		//TODO 处理保留 对[估价分区]合法性进行检验
		return true;
	}
	
	/*
	 * AJAX方法使用，读取小区状态
	 */
	public String LoadZTByXqdm() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("LoadZTByXqdm() ********** start **********");
		}
		Pgt00352 t00352 = new Pgt00352();
		
		try {
			t00352.setXqdm(XQDM);
			t00352Bean = t00352Service.LoadByPrimaryKey(t00352);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("LoadZTByXqdm() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("LoadZTByXqdm() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 确定小区状态
	 * @return
	 * @throws Exception
	 */
	public String viewConfirmXQZT() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("confirmXQZT() ********** start **********");
		}
		Pgv00352 unableBean = new Pgv00352();
		Pgv00352 ableBean = new Pgv00352();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			
			// 取得下拉菜单信息
			ReadInfo();
			
			// 准备查询条件
			unableBean.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			unableBean.setXqzt(Common.convertToByte("2"));
			unableBean.setCd00001Szqy(ddlSZQY);
			unableList = t00352Service.LoadAllByXqzt(unableBean);
			
			ableBean.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			ableBean.setXqzt(Common.convertToByte("1"));
			ableBean.setCd00001Szqy(ddlSZQY);
			ableList = t00352Service.LoadAllByXqzt(ableBean);
			
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("confirmXQZT() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("confirmXQZT() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 更新小区状态
	 * @return
	 * @throws Exception
	 */
	public String updateXQZT() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("updateXQZT() ********** start **********");
		}
		Pgv00352 unableBean = new Pgv00352();
		Pgv00352 ableBean = new Pgv00352();
		Pgt00352 bean = new Pgt00352();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			
			// 取得下拉菜单信息
			ReadInfo();
			bean.setXqdms_able(DDLABLEXQ);
			bean.setXqdms_unable(DDLUNABLEXQ);
			bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			bean.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			
			if (t00352Service.GetUpdateCommandForXqzt(bean)) {
				this.addActionMessage(getText("app.xtwh.t003521.confirm"));
			}
			
			
			// 准备查询条件
			unableBean.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			unableBean.setXqzt(Common.convertToByte("2"));
			unableBean.setCd00001Szqy(ddlSZQY);
			unableList = t00352Service.LoadAllByXqzt(unableBean);
			
			ableBean.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			ableBean.setXqzt(Common.convertToByte("1"));
			ableBean.setCd00001Szqy(ddlSZQY);
			ableList = t00352Service.LoadAllByXqzt(ableBean);
			
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("updateXQZT() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("updateXQZT() ********** end **********");
		}
		return SUCCESS;
	}
	
	
	/**
	 * 自动完成小区名称byAJAX
	 * @return
	 * @throws Exception
	 */
	public String queryXQNM() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("queryXQNM() ********** start **********");
		}
		Pgt00352 t00352 = new Pgt00352();
		try {
			t00352.setXqnm(XQNM);
			t00352.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			ArrayList<Pgv00352> xqList = t00352Service.GetXQNM(t00352);
			for (Pgv00352 b : xqList) {
				dataList.add(b.getXqnm());
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("queryXQNM() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("queryXQNM() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 根据小区名称取得小区信息
	 * @return
	 * @throws Exception
	 */
	public String LoadXQByXqnm() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("LoadXQByXqnm() ********** start **********");
		}

		Pgt00352 t00352 = new Pgt00352();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			
			t00352.setXqnm(XQNM);
			t00352.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			
			t00352Bean = t00352Service.LoadByXqnm(t00352);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("LoadXQByXqnm() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("LoadXQByXqnm() ********** end **********");
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

		Pgv00352 v00352 = new Pgv00352();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			v00352.setCd00001Szqy(ddlSZQYFind);
			v00352.setXqnm(Common.getSearchLike(Common.convertEncoding(txtXqnmFind)));
			v00352.setXqdm(Common.convertEncoding(txtXqIdFind));
			v00352.setNote(Common.getSearchLike(Common.convertEncoding(txtXqDzFind)));
			v00352.setPageIndex(1);
			v00352.setPageSize(-1);
			v00352.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			
			ByteArrayOutputStream out = (ByteArrayOutputStream) t00352Service.ExportGJFQSjcx(v00352);
//			setExcelStream(new ByteArrayInputStream(out.toByteArray()));
			excelStream = new ByteArrayInputStream(out.toByteArray());
		}catch (Exception e) {
			this.addActionError(e.getMessage());
			return INPUT;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
		}
		
		return SUCCESS;
		
		
	}
	/*********************** setter and getter ******************************/

	/**
	 * @return the t00352Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt00352Service getT00352Service() {
		return t00352Service;
	}
	/**
	 * @param t00352Service the t00352Service to set
	 */
	public void setT00352Service(IPgt00352Service t00352Service) {
		this.t00352Service = t00352Service;
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
	 * @return the txtXqnmFind
	 */
	public String getTxtXqnmFind() {
		return txtXqnmFind;
	}
	/**
	 * @param txtXqnmFind the txtXqnmFind to set
	 */
	public void setTxtXqnmFind(String txtXqnmFind) {
		this.txtXqnmFind = txtXqnmFind;
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
	 * @return the xQDM
	 */
	public String getXQDM() {
		return XQDM;
	}
	/**
	 * @param xQDM the xQDM to set
	 */
	public void setXQDM(String xQDM) {
		XQDM = xQDM;
	}
	/**
	 * @return the t00352Bean
	 */
	public Pgt00352 getT00352Bean() {
		return t00352Bean;
	}
	/**
	 * @param t00352Bean the t00352Bean to set
	 */
	public void setT00352Bean(Pgt00352 t00352Bean) {
		this.t00352Bean = t00352Bean;
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
	 * @return the txtXQBM
	 */
	public String getTxtXQBM() {
		return txtXQBM;
	}
	/**
	 * @param txtXQBM the txtXQBM to set
	 */
	public void setTxtXQBM(String txtXQBM) {
		this.txtXQBM = txtXQBM;
	}
	/**
	 * @return the txtVIEWORDER
	 */
	public Short getTxtVIEWORDER() {
		return txtVIEWORDER;
	}
	/**
	 * @param txtVIEWORDER the txtVIEWORDER to set
	 */
	public void setTxtVIEWORDER(Short txtVIEWORDER) {
		this.txtVIEWORDER = txtVIEWORDER;
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
	 * @return the rdoISDIR
	 */
	public Boolean getRdoISDIR() {
		return rdoISDIR;
	}
	/**
	 * @param rdoISDIR the rdoISDIR to set
	 */
	public void setRdoISDIR(Boolean rdoISDIR) {
		this.rdoISDIR = rdoISDIR;
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
	 * @return the navList
	 */
	public ArrayList<Pgt00352> getNavList() {
		return navList;
	}
	/**
	 * @param navList the navList to set
	 */
	public void setNavList(ArrayList<Pgt00352> navList) {
		this.navList = navList;
	}
	/**
	 * @return the treeList
	 */
	public ArrayList<Pgt00352> getTreeList() {
		return treeList;
	}
	/**
	 * @param treeList the treeList to set
	 */
	public void setTreeList(ArrayList<Pgt00352> treeList) {
		this.treeList = treeList;
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
	 * @return the nOXQDM
	 */
	public String getNOXQDM() {
		return NOXQDM;
	}
	/**
	 * @param nOXQDM the nOXQDM to set
	 */
	public void setNOXQDM(String nOXQDM) {
		NOXQDM = nOXQDM;
	}
	/**
	 * @return the rdoXQ
	 */
	public String getRdoXQ() {
		return rdoXQ;
	}
	/**
	 * @param rdoXQ the rdoXQ to set
	 */
	public void setRdoXQ(String rdoXQ) {
		this.rdoXQ = rdoXQ;
	}
	/**
	 * @return the pARENTDM
	 */
	public String getPARENTDM() {
		return PARENTDM;
	}
	/**
	 * @param pARENTDM the pARENTDM to set
	 */
	public void setPARENTDM(String pARENTDM) {
		PARENTDM = pARENTDM;
	}
	/**
	 * @return the xqNav
	 */
	public InputStream getXqNav() {
		return xqNav;
	}
	/**
	 * @param xqNav the xqNav to set
	 */
	public void setXqNav(InputStream xqNav) {
		this.xqNav = xqNav;
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
	 * @return the txtXqIdFind
	 */
	public String getTxtXqIdFind() {
		return txtXqIdFind;
	}

	/**
	 * @param txtXqIdFind the txtXqIdFind to set
	 */
	public void setTxtXqIdFind(String txtXqIdFind) {
		this.txtXqIdFind = txtXqIdFind;
	}

	/**
	 * @return the txtXqDzFind
	 */
	public String getTxtXqDzFind() {
		return txtXqDzFind;
	}

	/**
	 * @param txtXqDzFind the txtXqDzFind to set
	 */
	public void setTxtXqDzFind(String txtXqDzFind) {
		this.txtXqDzFind = txtXqDzFind;
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
	 * @return the unableList
	 */
	public ArrayList<Pgv00352> getUnableList() {
		return unableList;
	}

	/**
	 * @param unableList the unableList to set
	 */
	public void setUnableList(ArrayList<Pgv00352> unableList) {
		this.unableList = unableList;
	}

	/**
	 * @return the ableList
	 */
	public ArrayList<Pgv00352> getAbleList() {
		return ableList;
	}

	/**
	 * @param ableList the ableList to set
	 */
	public void setAbleList(ArrayList<Pgv00352> ableList) {
		this.ableList = ableList;
	}

	/**
	 * @return the dDLABLEXQ
	 */
	public String getDDLABLEXQ() {
		return DDLABLEXQ;
	}

	/**
	 * @param dDLABLEXQ the dDLABLEXQ to set
	 */
	public void setDDLABLEXQ(String dDLABLEXQ) {
		DDLABLEXQ = dDLABLEXQ;
	}

	/**
	 * @return the dDLUNABLEXQ
	 */
	public String getDDLUNABLEXQ() {
		return DDLUNABLEXQ;
	}

	/**
	 * @param dDLUNABLEXQ the dDLUNABLEXQ to set
	 */
	public void setDDLUNABLEXQ(String dDLUNABLEXQ) {
		DDLUNABLEXQ = dDLUNABLEXQ;
	}

	/**
	 * @return the xQNM
	 */
	public String getXQNM() {
		return XQNM;
	}

	/**
	 * @param xQNM the xQNM to set
	 */
	public void setXQNM(String xQNM) {
		XQNM = xQNM;
	}

	/**
	 * @return the dataList
	 */
	public ArrayList<String> getDataList() {
		return dataList;
	}

	/**
	 * @param dataList the dataList to set
	 */
	public void setDataList(ArrayList<String> dataList) {
		this.dataList = dataList;
	}

	/**
	 * @return the tabList
	 */
	public ArrayList<Pgv00352> getTabList() {
		return tabList;
	}

	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv00352> tabList) {
		this.tabList = tabList;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageSize() {
		return Common.getPageSize(pageSize);
	}

	/**
	 * @return the xqzt
	 */
	public Integer getXqzt() {
		return xqzt;
	}

	/**
	 * @param xqzt the xqzt to set
	 */
	public void setXqzt(Integer xqzt) {
		this.xqzt = xqzt;
	}

	/**
	 * @return the sQZY
	 */
	public String getSQZY() {
		return SQZY;
	}

	/**
	 * @param sQZY the sQZY to set
	 */
	public void setSQZY(String sQZY) {
		SQZY = sQZY;
	}

	public String getTxtXQDMH() {
		return txtXQDMH;
	}

	public void setTxtXQDMH(String txtXQDMH) {
		this.txtXQDMH = txtXQDMH;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
	
}
