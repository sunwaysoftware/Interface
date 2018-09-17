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
import com.sunway.service.IPgt02050Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.ConvertUtil;
import com.sunway.util.Excel;
import com.sunway.util.FileUtil;
import com.sunway.util.FormatUtil;
import com.sunway.util.MakeUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.ExcelBean;
import com.sunway.vo.Pgt02050;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv02050;

/**
 * 非住宅评估分区名称维护
 * @author LeiJia
 * @version 1.0
 */
public class Pgt02050Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 6488193487025572692L;
	// Service
	private IPgt02050Service t02050Service;
	// View
	private ArrayList<Pgv00052> szqyList;
	// 分页参数
	private Integer pageSize;
	private Integer pageIndex;
	private Integer total;
	// Bean数组
	private ArrayList<Pgv02050> rows;
	private ArrayList<Pgv02050> operList;
	private ArrayList<String> dataList;
	
	// 检索条件
	private String ddlSZQYFind;
	private String txtXqnmFind;
	private String txtXqIdFind;
	private String txtXqDzFind;
	private String txtXQTYPEFind;
	private String txtXQCX;
	private String txtXqdmhFind;
	private String txtXQFWLXFind;  //2013-04-03 新加字段房屋类型
	//编辑操作符
	private String ACT;
	//primary key 主键
	private String XQDM;
	// edit页面所需Bean
	private Pgt02050 t02050Bean;
	

	// edit页面提交数据
	private String txtDMH;
	private String txtXQDMHM;
	private String ddlSZQY;
	private String txtXQNM;
	private String txtXQBM;
	private Short txtVIEWORDER;
	private String txtNOTE;//-->小区座落地址
	private Boolean rdoISDIR;
	private String txtUPDATE;
	private ArrayList<Pgt02050> navList;
	private ArrayList<Pgt02050> treeList;
	private ArrayList<Pgv02050> unableList;
	private ArrayList<Pgv02050> ableList;
	private String SZQY;
	private String NOXQDM;
	private String rdoXQ;
	private String PARENTDM;
	private String DDLABLEXQ;
	private String DDLUNABLEXQ;
	private String XQNM;
	private String FWLX;
	private String txtQDH;
	private String txtQDHFind;
	private String txtJCNF;
	private String txtQH;
	private String txtDH;
	private String txtFWLX;
	
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
	private ArrayList<Pgv02050> Pgv02050List;
	private ArrayList<ExcelBean> ebList;
	private InputStream excelStream;
	private String fileName;
	private String userRole;
	private String USERID;
	//判断编辑页面是否由小区管理跳入
	private String FROMA;
	private String NEW;
	private Integer parId = 0;
	
	
	//验证该标准房是否可评估
	private String valXQDM;
	private String valFWLX;
	private String valJYSJ;
	private Integer valSIGN;
	
	private String chkDel;
	private String msgDel;
	
	
	//丘地号格式
	private String txtQDHGS;
	
	//验证代码号是否存在
	private boolean isExist;
	private String resMsg;
	private String resSign;
	
	//定位税收管辖前五位
	private String mapSign;
	
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
			//获取丘地号格式
			txtQDHGS = sessionCtrl.Get(SessionCtrl.SESSION_KEY_QDHGS);
			mapSign = sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX).substring(0, 5);
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
	 * 
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}

		Pgv02050 v02050 = new Pgv02050();
		try {
			USERID = sessionCtrl.getUserId();
			// 准备查询条件
			v02050.setCd00001Szqy(ddlSZQYFind);
			v02050.setXqnm(FormatUtil.toSearchLike(txtXqnmFind));
			v02050.setXqdm(txtXqIdFind);
			v02050.setXqdmhm(FormatUtil.toSearchLike(txtXqDzFind));
			v02050.setPageIndex(pageIndex);
			v02050.setPageSize(getPageSize());
			v02050.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v02050.setXqzt(ConvertUtil.toByte(txtXqDzFind));
			v02050.setCd00001Fwlx(txtXQFWLXFind);
			// 执行查询
			rows = t02050Service.loadAllGJFQDQ(v02050);
			//分页设置
			if(null!=rows && rows.size()>0){
				total = rows.get(0).getRecordCount();
			}else{
				total = 0;
				pageIndex = 1;
			}
			// 取得修正类型列表
			ReadInfo();
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());
			return ERROR;
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
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
		Pgt02050 t02050 = new Pgt02050();
		t02050Bean = new Pgt02050();
		try {
			if (!Constant.MOD_CREATE.equals(getACT())) {
				// 取得用户选中的数据信息
				t02050.setXqdm(XQDM);
				t02050Bean = t02050Service.LoadByPrimaryKey(t02050);
			} else {
				t02050Bean.setCd00001Szqy(ddlSZQY);
				t02050Bean.setParentdm(rdoXQ);
			}
			// 取得下拉菜单信息
			ReadInfo();
			txtQDHGS = sessionCtrl.Get(SessionCtrl.SESSION_KEY_QDHGS);
			if (Constant.MOD_CREATE.equals(getACT())) {
				userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
				return  "successADD";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("create() ********** end **********");
			}
			return ERROR;
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		setNEW(CheckUtil.chkTrim(getNEW()));
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

		t02050Bean = new Pgt02050();
		this.clearErrorsAndMessages();
		t02050Bean.setXqdm(XQDM);
		
		//根据PK取得信息，并为BEAN赋值
		if (Constant.MOD_UPDATE.equals(getACT())) {
			t02050Bean = t02050Service.LoadByPrimaryKey(t02050Bean);
		}
		// 判读数据是否已经被其他用户修改
		if ((Constant.MOD_UPDATE.equals(getACT()))
				&& (!t02050Bean.getUpddate().equals(
						ConvertUtil.toTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		} else {
			t02050Bean.setXqdm(XQDM);
			t02050Bean.setDmh(txtDMH);
			t02050Bean.setXqdmhm(txtXQDMHM);
			t02050Bean.setCd00001Szqy(ddlSZQY);
			t02050Bean.setParentdm(rdoXQ);
			t02050Bean.setXqnm(txtXQNM);
			t02050Bean.setXqbm(txtXQBM);
			t02050Bean.setVieworder(txtVIEWORDER);
			t02050Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t02050Bean.setNote(txtNOTE);
			t02050Bean.setIsdir(rdoISDIR);			
			t02050Bean.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			/*if (!CheckUtil.chkEmpty(txtQH) && !CheckUtil.chkEmpty(txtDH)) {
				t02050Bean.setQdh(txtQH+"-"+txtDH);
			}*/
			t02050Bean.setQdh(txtQDH);
			t02050Bean.setJcnf(txtJCNF);
			t02050Bean.setCd00001Fwlx(txtFWLX);
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
		this.clearErrorsAndMessages();
		setNEW(CheckUtil.chkTrim(getNEW()));
		String rtn = "success";
		if("C".equals(getACT())){
			rtn = "successADD";
		}
		try {
			if (Constant.MOD_CREATE.equals(getACT())) { // Create
				//此处状态为估价分区采集页面默认
				t02050Bean.setXqzt(ConvertUtil.toByte("0"));
				if (t02050Service.GetInsertCommand(t02050Bean)) {
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[] { t02050Bean.getXqnm() }));
					//ddlSZQY = t02050Bean.getCd00001Szqy();
					//rdoXQ = t02050Bean.getParentdm();
				} else {
					this.addActionError(t02050Bean.getXqnm()+"已存在");
				}
			} else if (Constant.MOD_UPDATE.equals(getACT())) { // Update
				if (t02050Service.GetUpdateCommand(t02050Bean)) {
					t02050Bean = t02050Service.LoadByPrimaryKey(t02050Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[] { t02050Bean.getXqnm() }));
				} else {
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[] { t02050Bean.getXqnm() }));
				}
			} else if (Constant.MOD_DELETE.equals(getACT())) { // Delete
				if (t02050Service.GetDeleteCommand(t02050Bean)) {
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[] { t02050Bean.getXqnm() }));
					if("A".equals(FROMA)){
						rtn = "successDELA";
					}else{
						if("DQ".equals(getNEW())){
							rtn = "successDELDQ";
						}else{
							rtn = "successDELXQ";
						}
						
					}
					
				} else {
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[] { t02050Bean.getXqnm() }));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			String msg = e.getMessage();
			
			this.addActionError(msg.replace("\n", " "));
			
			if (LOG.isDebugEnabled()) {
				LOG.debug("update() ********** end **********");
			}
			ReadInfo();
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
			return INPUT;
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** end **********");
		}
		ReadInfo();
		/*if(FROMA.equals("A")){
			return "errora";
		}*/
		return rtn;
	}
	
	public String delSel() throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("delSel() ********** start **********");
		}
		this.clearErrorsAndMessages();
		try{
			Pgt02050 t02050 = new Pgt02050();
			t02050.setChkDel(chkDel);
			t02050.setCd00002Czr(sessionCtrl.getUserId());
			t02050.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(t02050Service.GetSelDeleteCommand(t02050)){
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

	/**
	 * 取得下拉菜单信息
	 * @throws Exception
	 */
	private void ReadInfo() throws Exception {
		// 取得所在区域列表信息
		szqyList = sessionCtrl.ReadSzqyList();
	}

	/**
	 * 读取导航条数据，AJAX方法用
	 * @return
	 * @throws Exception
	 */
	public String loadNavigator() throws Exception{		
		return getNavigator(SZQY,XQDM,NOXQDM,PARENTDM, FWLX);
	}
	private String getNavigator(String szqy, String xqdm, String noxqdm,
			String parentdm, String fwlx) throws Exception {

		Pgt02050 v02050 = new Pgt02050();
		try {
			ReadInfo();
			if (!CheckUtil.chkEmpty(szqy)){
				v02050.setCd00001Szqy(szqy);
			}
			if (!CheckUtil.chkEmpty(xqdm)) {
				v02050.setXqdm(xqdm);
			}
			if (!CheckUtil.chkEmpty(noxqdm)){
				v02050.setNoxqdm(noxqdm);
			}
			if (!CheckUtil.chkEmpty(fwlx)){
				v02050.setCd00001Fwlx(fwlx);
			}
			navList = t02050Service.LoadNavigator(v02050);
			treeList = t02050Service.LoadTreeList(v02050);
			t02050Bean = t02050Service.LoadByPrimaryKey(v02050);
			t02050Bean.setNoxqdm(noxqdm);
			t02050Bean.setParentdm(parentdm);
			t02050Bean.setCd00001Fwlx(fwlx);
		} catch (Exception e) {
			 e.printStackTrace();
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
			
			if (!CheckUtil.chkEmpty(xqdm)) {
				String xqnm = t02050Service.LoadNavStream(xqdm);
				if (!CheckUtil.chkEmpty(xqnm))
					strBuf.append(xqnm);
				else
					strBuf.append(Constant.STRING_EMPTY);	
			}
			xqNav = Common.exportTEXT(strBuf);
		} catch (Exception e) {
			 e.printStackTrace();
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
		t02050Bean = new Pgt02050();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				t02050Bean.setCd00001Szqy(ddlSZQY);
				t02050Bean.setXqdm(XQDM);
			}
		} catch (Exception e) {
			e.printStackTrace();
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
	public String t02050Byxq() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("t02050Byxq() ********** start **********");
		}
		Pgt02050 t02050 = new Pgt02050();
		t02050Bean = new Pgt02050();
		try {
			// 取得用户选中的数据信息
			t02050.setXqdm(XQDM);
			t02050Bean = t02050Service.LoadByPrimaryKey(t02050);
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("t02050Byxq() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("t02050Byxq() ********** end **********");
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
			String fileName = sessionCtrl.getUserId() + "_PGQWSY" + getUploadFileName().substring(getUploadFileName().lastIndexOf("."));
			//fileServerPath = getSavePath() + "\\" + getUploadFileName();
			fileServerPath = getSavePath() + "\\" + fileName;
			//将上传文件保存路径存入SESSION
			Common.addUploadFiles(fileServerPath);
			FileUtil.copyFile(fileServerPath, getUpload());
			
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
			ReadInfo();
			//检验数据合法性
			ebList = Excel.resolveExcelFQ(txtFilePath, sessionCtrl.getUserId(),sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(!checkDateList(ebList))
				this.addActionError("估价分区数据不符合导入要求！");
			if(ebList.size()==0)
				this.addActionError("估价分区数据不符合导入要求！");
		}catch(Exception ex){
			ex.printStackTrace();
			this.addActionError(ex.getMessage().replace("\n", "<br />"));
		}
	}
	
	/**
	 * 估价分区数据导入
	 * @return
	 * @throws Exception
	 */
	public String importFile() throws Exception {
		ExcelBean eBean = null;
		try{
			eBean = t02050Service.ImportExcelData(ebList);
			if(null!=eBean){
				if(eBean.getExportOutCome()==2)
					this.addActionMessage("数据导入成功！");
				else{
					ByteArrayOutputStream out = (ByteArrayOutputStream) Excel.exportCommonDataSy(eBean.getOutExcelList(),1);
					excelStream = new ByteArrayInputStream(out.toByteArray());
					fileName=new String("格式错误的估价分区数据.xls".getBytes("GBK"),"ISO-8859-1");
					return "failexport";
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
			this.addActionError(ex.getMessage());
			return INPUT;
		}finally{
			/*
			else if (tmpV02050.getOutFlag()==1)
				this.addActionMessage("数据导入执行完毕，但导入过程中部分失败！");
			else 
				this.addActionError("数据导入失败！");
			*/
		}
		return SUCCESS;
	}
	
	/**
	 * 文件导入
	 * @return
	 * @throws Exception
	 */
	public String uploadSZMS() throws Exception {
		
		try{
			String fileName = sessionCtrl.getUserId() + "_SZMS" + getUploadFileName().substring(getUploadFileName().lastIndexOf("."));
			//fileServerPath = getSavePath() + "\\" + getUploadFileName();
			fileServerPath = getSavePath() + "\\" + fileName;
			//将上传文件保存路径存入SESSION
			Common.addUploadFiles(fileServerPath);
			FileUtil.copyFile(fileServerPath, getUpload());
			
		}catch(Exception ex){
			ex.printStackTrace();
			
			return INPUT;
		}
		return SUCCESS;
	}
	
	/**
	 * 导入校验
	 */
	public void validateImportFileSZMS() {
		if(!FileUtil.checkFileExist(txtFilePath)){
			this.addActionError("文件错误，请检查！");
		}
		try{
			ReadInfo();
			//检验数据合法性
			Pgv02050List = Excel.resolveExcelSZMSS(txtFilePath, sessionCtrl.getUserId(),sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(Pgv02050List.size()==0)
				this.addActionError("导入数据不符合导入要求！");
		}catch(Exception ex){
			ex.printStackTrace();
			this.addActionError(ex.getMessage().replace("\n", "<br />"));
		}
	}
	
	/**
	 * 估价分区数据导入
	 * @return
	 * @throws Exception
	 */
	public String importFileSZMS() throws Exception {
		Pgv02050 eBean = null;
		try{
			eBean = t02050Service.ImportDataSZMS(Pgv02050List);
		}catch(Exception ex){
			ex.printStackTrace();
			this.addActionError(ex.getMessage());
			return INPUT;
		}finally{
			if(null!=eBean && eBean.getOutFlag()==2)
				this.addActionMessage("数据导入成功！");
			else{
				ByteArrayOutputStream out = (ByteArrayOutputStream) Excel.exportCommonDataSZMSSY(eBean.getOutList(),1);
				excelStream = new ByteArrayInputStream(out.toByteArray());
				fileName=new String("格式错误的四至描述数据.xls".getBytes("GBK"),"ISO-8859-1");
				return "failexport";
			}
		}
		return SUCCESS;
	}

	/**
	 * 对[估价分区]合法性进行检验
	 * @param list
	 * @return
	 */
	private Boolean checkDateList(ArrayList<ExcelBean> list){
		return true;
	}
	
	/*
	 * AJAX方法使用，读取小区状态
	 */
	public String LoadZTByXqdm() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("LoadZTByXqdm() ********** start **********");
		}
		Pgt02050 t02050 = new Pgt02050();
		
		try {
			t02050.setXqdm(XQDM);
			t02050Bean = t02050Service.LoadByPrimaryKey(t02050);
		} catch (Exception e) {
			e.printStackTrace();
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
		Pgv02050 unableBean = new Pgv02050();
		Pgv02050 ableBean = new Pgv02050();
		try {
			// 取得下拉菜单信息
			ReadInfo();
			
			// 准备查询条件
			unableBean.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			unableBean.setXqzt(ConvertUtil.toByte("2"));
			unableBean.setCd00001Szqy(ddlSZQY);
			unableList = t02050Service.LoadAllByXqzt(unableBean);
			
			ableBean.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			ableBean.setXqzt(ConvertUtil.toByte("1"));
			ableBean.setCd00001Szqy(ddlSZQY);
			ableList = t02050Service.LoadAllByXqzt(ableBean);
			
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("confirmXQZT() ********** end **********");
			}
			return ERROR;
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
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
		Pgv02050 unableBean = new Pgv02050();
		Pgv02050 ableBean = new Pgv02050();
		Pgt02050 bean = new Pgt02050();
		try {
			// 取得下拉菜单信息
			ReadInfo();
			bean.setXqdms_able(DDLABLEXQ);
			bean.setXqdms_unable(DDLUNABLEXQ);
			bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			bean.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			
			if (t02050Service.GetUpdateCommandForXqzt(bean)) {
				this.addActionMessage(getText("app.xtwh.t020501.confirm"));
			}
			
			
			// 准备查询条件
			unableBean.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			unableBean.setXqzt(ConvertUtil.toByte("2"));
			unableBean.setCd00001Szqy(ddlSZQY);
			unableList = t02050Service.LoadAllByXqzt(unableBean);
			
			ableBean.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			ableBean.setXqzt(ConvertUtil.toByte("1"));
			ableBean.setCd00001Szqy(ddlSZQY);
			ableList = t02050Service.LoadAllByXqzt(ableBean);
			
		} catch (Exception e) {
			e.printStackTrace();
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
		Pgt02050 t02050 = new Pgt02050();
		try {
			t02050.setXqnm(XQNM);
			t02050.setCd00001Fwlx(FWLX);
			t02050.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			dataList = t02050Service.GetXQNM(t02050);
		} catch (Exception e) {
			e.printStackTrace();
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

		Pgt02050 t02050 = new Pgt02050();
		try {
			t02050.setCd00001Fwlx(FWLX);
			t02050.setXqnm(XQNM);
			t02050.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			t02050Bean = t02050Service.LoadByXqnm(t02050);
		} catch (Exception e) {
			e.printStackTrace();
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
	 * 小区信息导出
	 */
	public String export() throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("export() ********** start **********");
		}
		
		Pgv02050 v02050 = new Pgv02050();
		try {
			USERID = sessionCtrl.getUserId();
			// 准备查询条件
			v02050.setCd00001Szqy(ddlSZQYFind);
			v02050.setXqnm(FormatUtil.toSearchLike(txtXqnmFind));
			v02050.setXqdm(txtXqIdFind);
			v02050.setNote(FormatUtil.toSearchLike(txtXqDzFind));
			v02050.setPageIndex(1);	
			v02050.setPageSize(-1);
			v02050.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v02050.setXqzt(ConvertUtil.toByte(txtXqDzFind));
			v02050.setXqtype(ConvertUtil.toInteger(txtXQTYPEFind));
			v02050.setQdh(txtQDH);
		    v02050.setCd00002Czr(sessionCtrl.getUserId());
		    v02050.setCd00001Fwlx(txtXQFWLXFind);     //2013-04-07添加
			
			ByteArrayOutputStream out = (ByteArrayOutputStream) t02050Service.ExportGJFQ(v02050);
			setExcelStream(new ByteArrayInputStream(out.toByteArray()));
		
		} catch (Exception e) {
			e.printStackTrace();
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);	
			return INPUT;
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);	
		if(LOG.isDebugEnabled()){
			LOG.debug("export() ********** end **********");
		}
		return SUCCESS;
	}
	
	
	
	
	/**
	 * 片区信息导出
	 */
	public String exportA() throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("exportA() ********** start **********");
		}
		
		Pgv02050 v02050 = new Pgv02050();
		try {
			USERID = sessionCtrl.getUserId();
			// 准备查询条件
			v02050.setCd00001Szqy(ddlSZQYFind);
			v02050.setXqnm(FormatUtil.toSearchLike(txtXqnmFind));
			v02050.setXqdm(txtXqIdFind);
			v02050.setNote(FormatUtil.toSearchLike(txtXqDzFind));
			v02050.setPageIndex(1);	
			v02050.setPageSize(-1);
			v02050.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v02050.setParId(parId);
			v02050.setCd00002Czr(sessionCtrl.getUserId());
			/*if(!CheckUtil.chkEmpty(txtQH) && !CheckUtil.chkEmpty(txtDH)){
				v02050.setQdh(txtQH + "-" + txtDH);
			}*/
						
			ByteArrayOutputStream out = (ByteArrayOutputStream) t02050Service.ExportGJFQDQ(v02050);
			setExcelStream(new ByteArrayInputStream(out.toByteArray()));
		
		} catch (Exception e) {
			e.printStackTrace();
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);	
			return INPUT;
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);	
		if(LOG.isDebugEnabled()){
			LOG.debug("exportA() ********** end **********");
		}
		return SUCCESS;
	}
	
	
	
	
	
	
/************************************     估价分区           **********************************************/	
	
	/**
	 * 估价分区
	 */
	public String executeGJFQ()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("executeGJFQ() ********** start **********");
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		
		if(LOG.isDebugEnabled()){
			LOG.debug("executeGJFQ() ********** end **********");
		}
		return SUCCESS;
	}
	
	
	/**
	 * 估价分区（小区）
	 *//*
	public String executeGJFQXQ()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("executeGJFQXQ() ********** start **********");
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		ReadInfo();
		txtQDHGS = sessionCtrl.Get(SessionCtrl.SESSION_KEY_QDHGS);
		if(LOG.isDebugEnabled()){
			LOG.debug("executeGJFQXQ() ********** end **********");
		}
		return SUCCESS;
	}*/
	
	
	/**
	 * 估价分区（小区）查询
	 */
	public String queryGJFQXQ()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("queryGJFQXQ() ********** start **********");
		}
		Pgv02050 v02050 = new Pgv02050();
		try {
			USERID = sessionCtrl.getUserId();
			// 准备查询条件
			v02050.setCd00001Szqy(ddlSZQYFind);
			v02050.setXqnm(FormatUtil.toSearchLike(txtXqnmFind));
			v02050.setXqdm(txtXqIdFind);
			v02050.setNote(FormatUtil.toSearchLike(txtXqDzFind));
			v02050.setPageIndex(pageIndex);
			v02050.setPageSize(getPageSize());
			v02050.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v02050.setXqzt(ConvertUtil.toByte(txtXqDzFind));
			v02050.setXqtype(ConvertUtil.toInteger(txtXQTYPEFind));
			v02050.setCd00001Fwlx(txtXQFWLXFind);
			/*if(!CheckUtil.chkEmpty(txtQH) && !CheckUtil.chkEmpty(txtDH)){
				v02050.setQdh(txtQH + "-" + txtDH);
			}*/
			v02050.setQdh(txtQDH);
			// 执行查询
			rows = t02050Service.loadAllGJFQXQ(v02050);
			//分页设置
			if(null!=rows && rows.size()>0){
				total = rows.get(0).getRecordCount();
			}else{
				total = 0;
				pageIndex = 1;
			}
			// 取得修正类型列表
			ReadInfo();
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());
			return INPUT;
		}
		if(LOG.isDebugEnabled()){
			LOG.debug("queryGJFQXQ() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 估价分区（大区）
	 */
	public String executeGJFQDQ() throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("executeGJFQDQ() ********** start **********");
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		ReadInfo();
		
		if(LOG.isDebugEnabled()){
			LOG.debug("executeGJFQDQ() ********** end **********");
		}
		return SUCCESS;
	}	
	
	/**
	 * 验证该标准房是否可评估
	 */
	public String validatePG()throws Exception{
		Pgv02050 v02050 = new Pgv02050();
		try{
			v02050.setFwlx(ConvertUtil.encoding(valFWLX));
			v02050.setXqdm(ConvertUtil.encoding(valXQDM));
			v02050.setValdate(ConvertUtil.toTimestamp(MakeUtil.currentTime()));
			v02050.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			v02050.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(t02050Service.ValidatePG(v02050)){
				valSIGN = 1;
			}else{
				valSIGN = 0;
			}
		}catch(Exception e){
			e.printStackTrace();
			return INPUT;
		}
		return SUCCESS;
	}
		
	/**
	 * 验证小区代码号编码是否存在
	 * @return
	 * @throws Exception
	 */
	public String validateXqdmhmIsExist()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("validateUserIdIsExist() ********** start **********");
		}
		try{
			Pgv02050 v02050 = new Pgv02050();
			v02050.setXqdmhm(CheckUtil.chkTrim(txtXQDMHM));
			v02050.setCd00001Szqy(ddlSZQY);
			isExist = t02050Service.validateXqdmhmIsExist(v02050);
			if(!isExist){
				resSign = "0";
				resMsg = "分区代码号不存在，请继续填写.";
			}else{
				resSign = "1";
				resMsg = "分区代码号已存在，请重新输入.";
			}
		}catch(Exception e){
			e.printStackTrace();
			resSign = "2";
			resMsg = e.getMessage();
			
			if(LOG.isDebugEnabled()){
				LOG.debug("validateUserIdIsExist() ********** end **********");
			}
			return SUCCESS;
		}finally{
			//
		}
		if(LOG.isDebugEnabled()){
			LOG.debug("validateUserIdIsExist() ********** end **********");
		}
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.sessionCtrl.appSession = session;
	}
		
	/*********************** setter and getter ******************************/

	/**
	 * @return the t02050Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt02050Service getT02050Service() {
		return t02050Service;
	}
	/**
	 * @param t02050Service the t02050Service to set
	 */
	public void setT02050Service(IPgt02050Service t02050Service) {
		this.t02050Service = t02050Service;
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
	 * @return the operList
	 */
	public ArrayList<Pgv02050> getOperList() {
		return operList;
	}
	/**
	 * @param operList the operList to set
	 */
	public void setOperList(ArrayList<Pgv02050> operList) {
		this.operList = operList;
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
	 * @return the t02050Bean
	 */
	public Pgt02050 getT02050Bean() {
		return t02050Bean;
	}
	/**
	 * @param t02050Bean the t02050Bean to set
	 */
	public void setT02050Bean(Pgt02050 t02050Bean) {
		this.t02050Bean = t02050Bean;
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
	public ArrayList<Pgt02050> getNavList() {
		return navList;
	}
	/**
	 * @param navList the navList to set
	 */
	public void setNavList(ArrayList<Pgt02050> navList) {
		this.navList = navList;
	}
	/**
	 * @return the treeList
	 */
	public ArrayList<Pgt02050> getTreeList() {
		return treeList;
	}
	/**
	 * @param treeList the treeList to set
	 */
	public void setTreeList(ArrayList<Pgt02050> treeList) {
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
	 * @return the pgv02050List
	 */
	public ArrayList<Pgv02050> getPgv02050List() {
		return Pgv02050List;
	}

	/**
	 * @param pgv02050List the pgv02050List to set
	 */
	public void setPgv02050List(ArrayList<Pgv02050> pgv02050List) {
		Pgv02050List = pgv02050List;
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
	public ArrayList<Pgv02050> getUnableList() {
		return unableList;
	}

	/**
	 * @param unableList the unableList to set
	 */
	public void setUnableList(ArrayList<Pgv02050> unableList) {
		this.unableList = unableList;
	}

	/**
	 * @return the ableList
	 */
	public ArrayList<Pgv02050> getAbleList() {
		return ableList;
	}

	/**
	 * @param ableList the ableList to set
	 */
	public void setAbleList(ArrayList<Pgv02050> ableList) {
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
	 * @return the txtQDHFind
	 */
	public String getTxtQDHFind() {
		return txtQDHFind;
	}

	/**
	 * @param txtQDHFind the txtQDHFind to set
	 */
	public void setTxtQDHFind(String txtQDHFind) {
		this.txtQDHFind = txtQDHFind;
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
	 * 
	 * @return the txtJCNF
	 */
	public String getTxtJCNF() {
		return txtJCNF;
	}
	/**
	 * 
	 * @param txtJCNF the txtJCNF to set
	 */
	public void setTxtJCNF(String txtJCNF) {
		this.txtJCNF = txtJCNF;
	}
	/**
	 * 
	 * @return the txtQH
	 */
	public String getTxtQH() {
		return txtQH;
	}
	/**
	 * 
	 * @param txtQH the txtQH to set
	 */
	public void setTxtQH(String txtQH) {
		this.txtQH = txtQH;
	}
	/**
	 * 
	 * @return the txtDH
	 */
	public String getTxtDH() {
		return txtDH;
	}
	/**
	 * 
	 * @param txtDH the txtDH to set
	 */
	public void setTxtDH(String txtDH) {
		this.txtDH = txtDH;
	}

	/**
	 * @return the uSERID
	 */
	public String getUSERID() {
		return USERID;
	}

	/**
	 * @param uSERID the uSERID to set
	 */
	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}

	/**
	 * @return the fROMA
	 */
	public String getFROMA() {
		return FROMA;
	}

	/**
	 * @param fROMA the fROMA to set
	 */
	public void setFROMA(String fROMA) {
		FROMA = fROMA;
	}

	public String getNEW() {
		return NEW;
	}

	public void setNEW(String nEW) {
		NEW = nEW;
	}

	public Integer getParId() {
		return parId;
	}

	public void setParId(Integer parId) {
		this.parId = parId;
	}

	public String getValXQDM() {
		return valXQDM;
	}

	public void setValXQDM(String valXQDM) {
		this.valXQDM = valXQDM;
	}

	public String getValFWLX() {
		return valFWLX;
	}

	public void setValFWLX(String valFWLX) {
		this.valFWLX = valFWLX;
	}

	public String getValJYSJ() {
		return valJYSJ;
	}

	public void setValJYSJ(String valJYSJ) {
		this.valJYSJ = valJYSJ;
	}

	public Integer getValSIGN() {
		return valSIGN;
	}

	public void setValSIGN(Integer valSIGN) {
		this.valSIGN = valSIGN;
	}

	public ArrayList<Pgv02050> getRows() {
		return rows;
	}

	public void setRows(ArrayList<Pgv02050> rows) {
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

	public String getTxtDMH() {
		return txtDMH;
	}

	public void setTxtDMH(String txtDMH) {
		this.txtDMH = txtDMH;
	}	

	public String getTxtXQDMHM() {
		return txtXQDMHM;
	}

	public void setTxtXQDMHM(String txtXQDMHM) {
		this.txtXQDMHM = txtXQDMHM;
	}

	public String getTxtXQTYPEFind() {
		return txtXQTYPEFind;
	}

	public void setTxtXQTYPEFind(String txtXQTYPEFind) {
		this.txtXQTYPEFind = txtXQTYPEFind;
	}	

	public String getTxtXQCX() {
		return txtXQCX;
	}

	public void setTxtXQCX(String txtXQCX) {
		this.txtXQCX = txtXQCX;
	}

	public String getTxtQDHGS() {
		return txtQDHGS;
	}

	public void setTxtQDHGS(String txtQDHGS) {
		this.txtQDHGS = txtQDHGS;
	}

	public boolean isExist() {
		return isExist;
	}

	public void setExist(boolean isExist) {
		this.isExist = isExist;
	}

	public String getResMsg() {
		return resMsg;
	}

	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}

	public String getResSign() {
		return resSign;
	}

	public void setResSign(String resSign) {
		this.resSign = resSign;
	}

	public String getMapSign() {
		return mapSign;
	}

	public void setMapSign(String mapSign) {
		this.mapSign = mapSign;
	}

	public String getTxtXqdmhFind() {
		return txtXqdmhFind;
	}

	public void setTxtXqdmhFind(String txtXqdmhFind) {
		this.txtXqdmhFind = txtXqdmhFind;
	}
	

	public String getFWLX() {
		return FWLX;
	}

	public void setFWLX(String fWLX) {
		FWLX = fWLX;
	}

	public String getTxtXQFWLXFind() {
		return txtXQFWLXFind;
	}

	public void setTxtXQFWLXFind(String txtXQFWLXFind) {
		this.txtXQFWLXFind = txtXQFWLXFind;
	}

	public String getTxtFWLX() {
		return txtFWLX;
	}

	public void setTxtFWLX(String txtFWLX) {
		this.txtFWLX = txtFWLX;
	}

}
