package com.sunway.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00320Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.Excel;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv00302;
import com.sunway.vo.Pgv00303;
import com.sunway.vo.Pgv00320;
import com.sunway.vo.Pgv00320e;

/**
 * 全面评估市场法房产信息
 * @author Light
 *
 */
public class Pgt00320Action extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = -8890413745089540943L;

	private IPgt00320Service t00320Service;
	
	//页面所需列表
	private ArrayList<Pgv00320> tabList;
	private ArrayList<Pgv00052> szqyList;
	private Pgv00320 tBean;
	private Pgv00303 v00303Bean;
	//session
	private SessionCtrl sessionCtrl = new SessionCtrl();
	//操作符
	private String ACT;
	//查询条件
	private String ddlSZQYFind;
	private String txtXQFind;
	private String txtJYSJFind;
	private String rdoPGJG;
	private String txtZCDZLFind;
	private String txtSSGX;
	// 分页参数
	private Integer pageIndex;
	private Integer pageSize;
	private Integer rowCount;
	
	//file upload
	private String fileServerPath;
	private File upload;
	private String uploadFileName;
	private String savePath;
	private InputStream excelStream;
	
	//file import
	private String txtFilePath;
	private ArrayList<Pgv00320> pgv00320List;
	private String fileName;
	
	//pg
	private String hidFlag;
	private String[] chkSel;
	private Integer processCent;	
	private String processMsg;
	private String txtPSSD;
	
	//获取估价值参数
	private String txtXQDMFind;
	private String txtZHFind;
	private String txtDYFind;
	private String txtBWJFHFind;
	private Pgv00320 pgt00320Bean;
	
	//detail
	private Pgv00320 v00320Bean;
	private String FCID;
	
	//printTZD
	private String txtFCZH;
	private String txtSWID;
	private String txtNSRMC;
	private String txtCSFSWID;
	private String txtCSFNSRMC;
	private String txtZJLX;
	private String txtCSFZJLX;
	private String txtLXDH;
	private String txtJYSJ;
	private String txtDJRQ;
	private String txtFCID;
	private String txtJYLX;
	private String txtNOTE;
	private String txtJYJG;
	private String resMsg;
	private String resSign;
	private String zcdzl;
	private String txtLH;
	private String txtDYH;
	private String txtFH;
	
	//pgCWXX
	private String txtSWIDFind;
	
	//edit
	private String SysDate;
	private String txtCLH;
	private String txtZCDZL;
	private String txtJZMJ;
	private String txtHDJG;
	private String txtXQDM;
	private String txtZLC;
	private String txtSZLC;
	private String txtJZJG;
	private String txtGHYT;
	private String txtZH;
	private String txtJCNF;
	private String txtZJHM;
	private String hidZHXZid;
	private String txtUPDATE;
	private String txtXQTIP;
	//queryZhxz
	private String txtFWLX;
	private String ddlSZQY;
	private ArrayList<Pgv00320e> qtxzList;
	
	//delSel
	private String chkDel;
	private String msgDel;
    private boolean isExistZT; 
	//标识全面评估查询与地址重复
	private String TSIGN;
	@Override
	public String execute() throws Exception {
		if(LOG.isDebugEnabled()){
			LOG.debug("execute() ********** start **********");
		}
		//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
		txtSSGX = sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX);
		ReadInfo();
		if(LOG.isDebugEnabled()){
			LOG.debug("execute() ********** end **********");
		}		
		return SUCCESS;
	}
	
	
	/**
	 * 查询，读取数据
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		if(LOG.isDebugEnabled()){
			LOG.debug("query() ********** start **********");
		}
		
		Pgv00320 v00320 = new Pgv00320();
		try{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			v00320.setPageIndex(pageIndex);
			v00320.setPageSize(getPageSize());
			v00320.setCd00001Szqy(ddlSZQYFind);
			v00320.setXqnm(Common.getSearchLike(txtXQTIP));
			v00320.setJysj(Common.convertStringToDate(txtJYSJFind));
			v00320.setIsPgjg(Common.convertToInteger(rdoPGJG));
			v00320.setZcdzl(txtZCDZLFind);
			v00320.setZh(txtZHFind);
			v00320.setDyh(txtDYFind);
			v00320.setFh(txtBWJFHFind);
			if(null != txtSSGX && !"".equals(txtSSGX)){
				v00320.setCd00001Ssgx(txtSSGX);
			}else{
				v00320.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			}
			tabList = t00320Service.LoadAll(v00320);
			// 分页设置
			if (null != tabList && tabList.size() > 0) {
				rowCount = tabList.get(0).getRecordCount();
			} else {
				pageIndex = 1;
				rowCount = 0;
			}
		}catch(Exception e){
			LOG.error(e.getMessage());
			if(LOG.isDebugEnabled()){
				LOG.debug("query() ********** end **********");
			}
			return ERROR;
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 新增状态处理
	 * @return
	 * @throws Exception
	 */
	public String create()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("create() ********** start **********");
		}
		
		try{
			ReadInfo();
			if(!Constant.MOD_CREATE.equals(getACT())){
				Pgv00320 v00320 = new Pgv00320();
				v00320.setFcid(FCID);
				tBean = t00320Service.LoadByPrimaryKey(v00320);
				//为303赋值
				v00303Bean = new Pgv00303();
				v00303Bean.setCd00001Szqy(tBean.getCd00001Szqy());
				v00303Bean.setXqnm(tBean.getXqnm());
				v00303Bean.setCd00352Xqdm(tBean.getCd00352Xqdm());
				v00303Bean.setZlc(tBean.getZlc().shortValue());
			}else{
				SysDate = Common.readCurrentDate();
			}
		}catch(Exception e){
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());
			if(LOG.isDebugEnabled()){
				LOG.debug("create() ********** end **********");
			}
			return ERROR;
		}finally{
			//
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("create() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 更新前验证
	 * @throws Exception
	 */
	public void validateUpdate()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("validateUpdate() ********** start **********");
		}
		this.clearErrorsAndMessages();
		try{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			ReadInfo();
			tBean = new Pgv00320();
			tBean.setFcid(FCID);
			//根据PK为BEAN赋值
			if(Constant.MOD_UPDATE.equals(getACT())){
				tBean = t00320Service.LoadByPrimaryKey(tBean);
			}
			//判断数据是否已被其他用户修改
			if ((Constant.MOD_UPDATE.equals(getACT()))&& (!tBean.getUpddate().equals(Common.convertStringToTimestamp(txtUPDATE)))) {
				this.addActionError(getText("app.msg.error.pktime"));
			} else {
				tBean.setFcid(FCID);
				tBean.setFczh(txtFCZH);
				tBean.setClh(txtCLH);
				tBean.setZcdzl(txtZCDZL);
				tBean.setJzmj(Common.convertToDouble(txtJZMJ));
				tBean.setHdjg(Common.convertToDouble(txtHDJG));
				tBean.setCd00352Xqdm(txtXQDM);
				tBean.setZlc(Common.convertToInteger(txtZLC));
				tBean.setSzlc(Common.convertToInteger(txtSZLC));
				tBean.setCd00001Fwlx(txtFWLX);
				tBean.setCd00001Jzjg(txtJZJG);
				tBean.setCd00001Ghyt(txtGHYT);
				tBean.setCd00001jylx(txtJYLX);
				tBean.setZh(txtZH);
				tBean.setDyh(txtDYH);
				tBean.setFh(txtFH);
				tBean.setJcnf(txtJCNF);
				tBean.setNsrmc(txtNSRMC);
				tBean.setCd00001Zjlx(txtZJLX);
				tBean.setZjhm(txtZJHM);
				tBean.setLxdh(txtLXDH);
				tBean.setZhxzId(hidZHXZid);
				tBean.setNote(txtNOTE);
				
				tBean.setCd00002Czr(sessionCtrl.getUserId());
				tBean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			}
		}catch(Exception e){
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());
		}finally{
			//
		}
		if(LOG.isDebugEnabled()){
			LOG.debug("validateUpdate() ********** end **********");
		}
		
	}
	
	/**
	 * 更新操作
	 * @return
	 * @throws Exception
	 */
	public String update()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("update() ********** start **********");
		}
		String result = "success";
		try{
			
			if(Constant.MOD_UPDATE.equals(getACT())){
				if(t00320Service.GetUpdateCommand(tBean)){
					//为303赋值
					v00303Bean = new Pgv00303();
					v00303Bean.setCd00001Szqy(tBean.getCd00001Szqy());
					v00303Bean.setXqnm(tBean.getXqnm());
					v00303Bean.setCd00352Xqdm(tBean.getCd00352Xqdm());
					v00303Bean.setZlc(tBean.getZlc().shortValue());
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[] { tBean.getFczh() }));
				} else {
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[] { tBean.getFczh() }));
				}
			}else if(Constant.MOD_DELETE.equals(getACT())){
				if(t00320Service.GetDeleteCommand(tBean)){
					this.addActionMessage(getText(Constant.MSG_DELETE_OK));
				} else {
					this.addActionError(getText(Constant.MSG_DELETE_NG));
				}
				if("320".equals(TSIGN)){
					result = "successDEL320";
				}else if("3201".equals(TSIGN)){
					result = "successDEL3201";
				}
				
			}
		}catch(Exception e){
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());
		}finally{
			//
		}
		if(LOG.isDebugEnabled()){
			LOG.debug("update() ********** end **********");
		}
		return result;
	}
	
	
	
	/**
	 * 文件上传
	 */
	public String upload()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("upload() ********** start **********");
		}
		FileInputStream fis = null;
		FileOutputStream fos = null;
		Random random = new Random();
		try{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			String fileName = "QMPGLR" + String.valueOf(random.nextInt()) + sessionCtrl.getUserId() + getUploadFileName().substring(getUploadFileName().lastIndexOf("."));
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
		}catch(Exception e){
			LOG.error(e.getMessage());
			if(LOG.isDebugEnabled()){
				LOG.debug("upload() ********** end **********");
			}
			return INPUT;
		} finally {
			if(null!=fis)
				fis.close();
			if(null!=fos)
				fos.close();
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("upload() ********** end **********");
		}
		return SUCCESS;
	}
	
	
	/**
	 * 文件导入前的验证
	 */
	public void validateImportFile()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("validateImportFile() ********** start **********");
		}
		
		if(!Common.isFileExist(txtFilePath)){
			this.addActionError("文件错误，请检查");
		}
		try{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			ReadInfo();
			pgv00320List = Excel.importDataQMPGLR(txtFilePath, sessionCtrl.getUserId(), sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(!checkQMPGLR(pgv00320List)){
				this.addActionError("数据不符合导入要求");
			}
			if(pgv00320List.size() == 0){
				this.addActionError("数据不符合导入要求");
			}
			
		}catch(Exception e){
			LOG.error(e.getMessage());
			this.addActionError("数据格式不符合导入要求：" + e.getMessage());
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("validateImportFile() ********** end **********");
		}
	}
	
	private boolean checkQMPGLR(ArrayList<Pgv00320> v00320List)throws Exception{
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
			Pgv00320 result = t00320Service.ImportExcelData(pgv00320List);
			if(result.getOutFlag() == 2){
				this.addActionMessage("数据导入成功");
			}else{
				ByteArrayOutputStream out = (ByteArrayOutputStream)Excel.exportDataQMPGLR(result.getOutList());
				excelStream = new ByteArrayInputStream(out.toByteArray());
				fileName = new String("格式错误的全面评估录入数据.xls".getBytes("GBK"),"ISO-8859-1");
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
	 * 選擇评估
	 * @return
	 * @throws Exception
	 */
	public String executePG() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("executePG() ********** start **********");
		}
		Pgv00320 v00320 = new Pgv00320();
		Integer pgwCount = 0;
		Integer pgCount = 0;
		Integer pgTotal = 0;
		try {
			processMsg = "数据估价";
			v00320.setCd00002Czr(sessionCtrl.getUserId());
			v00320.setPssd(txtPSSD);
			v00320.setPssdYMD(Common.convertToDate(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD_YMD)));
			v00320.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			switch (Common.convertToInteger(hidFlag)) {
			case 1:// 選擇评税
				chkSel = chkSel[0].split(",");
				pgTotal = chkSel.length;
				for (Integer i = 0; i < chkSel.length; i++) {
					try {
						v00320.setFcid(chkSel[i]);
						// 執行評估
						if (t00320Service.GetExecPG(v00320))
							pgCount++;
						else
							pgwCount++;
					} catch (Exception e2) {
						LOG.error("executePG()", e2);
					}
					processCent = i * 100 / chkSel.length;
				}
				break;
			case 2:// 全部评税
				v00320.setCd00001Szqy(ddlSZQYFind);
				v00320.setCd00352Xqdm(txtXQFind);
				v00320.setJysj(Common.convertStringToDate(txtJYSJFind));
				v00320.setIsPgjg(Common.convertToInteger(rdoPGJG));
				v00320.setZcdzl(txtZCDZLFind);
				v00320.setZh(txtZHFind);
				v00320.setDyh(txtDYFind);
				v00320.setFh(txtBWJFHFind);
				if(null != txtSSGX && !"".equals(txtSSGX)){
					v00320.setCd00001Ssgx(txtSSGX);
				}else{
					v00320.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
				}
				tabList = t00320Service.LoadPGList(v00320);
				pgTotal = tabList.size();
				for (Integer i = 0; i < tabList.size(); i++) {
					try {
						v00320.setFcid(tabList.get(i).getFcid());
						// 執行評估
						if (t00320Service.GetExecPG(v00320))
							pgCount++;
						else
							pgwCount++;
					} catch (Exception e2) {
						LOG.error("executePG()", e2);
					}
					processCent = i * 100 / tabList.size();
				}
				break;
			default:
				break;
			}
			
		} catch (Exception e) {
			LOG.error("executePG()", e);
			this.addActionError(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("executePG() ********** end **********");
			}
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("executePG() ********** end **********");
		}
		this.addActionMessage("评估执行完毕[共" + pgTotal + "条数据，" + pgCount + "条通过评税，"+pgwCount+"条未通过评税]");
		return SUCCESS;
	}
	
	
	/**
	 * 市场法房产详细信息
	 * @return
	 * @throws Exception
	 */
	public String detail() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** start **********");
		}
		Pgv00320 v00320 = new Pgv00320();
		v00320Bean = new Pgv00320();
		try {
			// 准备查询条件
			v00320.setFcid(Common.trim(FCID));
			// 执行查询
			v00320Bean = t00320Service.LoadByPrimaryKey(v00320);
			v00320Bean.setOutList(t00320Service.LoadPriceList(v00320));
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			LOG.error(e.getMessage());
			return ERROR;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** end **********");
		}
		return SUCCESS;
	}
	
	
	/**
	 * 市场法房产详细信息
	 * @return
	 * @throws Exception
	 */
	public String detailFC() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** start **********");
		}
		Pgv00320 v00320 = new Pgv00320();
		v00320Bean = new Pgv00320();
		try {
			// 准备查询条件
			v00320.setFcid(Common.trim(FCID));
			// 执行查询
			v00320Bean = t00320Service.LoadByPrimaryKey(v00320);
			v00320Bean.setOutList(t00320Service.LoadPriceList(v00320));
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			LOG.error(e.getMessage());
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
		//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
		// 取得所在区域列表信息
		szqyList = sessionCtrl.ReadSzqyList();
	}
	
	
	public String executeTZD()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("executeTZD() ********** start **********");
		}
		try{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			Pgv00302 v00302 = new Pgv00302();
			v00302.setFcid(txtFCID);
			v00302.setCd00001Jylx(txtJYLX);
			v00302.setNote(txtNOTE);
			v00302.setFczh(txtFCZH);
			v00302.setZjhm(txtSWID);
			v00302.setNsrmc(txtNSRMC);
			v00302.setCsfzjhm(txtCSFSWID);
			v00302.setCsfnsrmc(txtCSFNSRMC);
			v00302.setCd00001Zjlx(txtZJLX);
			v00302.setCd00001csfzjlx(txtCSFZJLX);
			v00302.setLxdh(txtLXDH);
			v00302.setJysj(Common.convertStringToDate(txtJYSJ));
			v00302.setDjrq(Common.convertStringToDate(txtDJRQ));
			v00302.setJyjg(Common.convertToDouble(txtJYJG));
			v00302.setCd00002Czr(sessionCtrl.getUserId());
			v00302.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//获取FCID
			resMsg = t00320Service.executeTZD(v00302);
			if(null != resMsg && !"".equals(resMsg)){
				resSign = "1";
			}else{
				resSign = "0";
			}
		}catch(Exception e){
			LOG.error(e.getMessage());
			String[] errorMsg = e.getMessage().split("\n");
			resMsg = errorMsg[0];
			resSign = "0";
			return SUCCESS;
		}
		if(LOG.isDebugEnabled()){
			LOG.debug("executeTZD() ********** end **********");
		}
		return SUCCESS;
	}
	/**
	 * 查询全面评估数据
	 * @return
	 * @throws Exception
	 */
	public String isExistQmpg() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** start **********");
		}
		Pgv00320 v00320 = new Pgv00320();
		v00320Bean = new Pgv00320();
		try {
			// 准备查询条件
			v00320.setCd00001Szqy(ddlSZQYFind);
			v00320.setZcdzl(zcdzl);
			v00320.setZh(txtLH);
			v00320.setDyh(txtDYH);
			v00320.setFh(txtFH);
			// 执行查询
			tabList = t00320Service.LoadQMPGByFCXX(v00320);
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			LOG.error(e.getMessage());
			return ERROR;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** end **********");
		}
		return SUCCESS;
	}
	
	
	public String loadPgCWXX()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("loadPgCWXX() ********** start **********");
		}
		try{
			txtSWIDFind = Common.convertEncoding(txtSWIDFind);
		}catch(Exception e){
			
		}finally{
			
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("loadPgCWXX() ********** end **********");
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
			Pgv00320e v00320e = new Pgv00320e();
			v00320e.setCd00320Fcid(FCID);
			v00320e.setCd00001Szqy(ddlSZQY);
			v00320e.setCd00001Fwlx(txtFWLX);
			setQtxzList(t00320Service.LoadQMPGZhxz(v00320e));
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
	 * 选择删除
	 * @return
	 * @throws Exception
	 */
	public String delSel()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("delSel() ********** start **********");
		}
		
		try{
			this.clearErrorsAndMessages();
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			Pgv00320 v00320 = new Pgv00320();
			v00320.setChkDel(chkDel);
			v00320.setCd00002Czr(sessionCtrl.getUserId());
			v00320.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(t00320Service.GetSelDeleteCommand(v00320)){
				msgDel = "删除成功";
			}
		}catch(Exception e){
			LOG.error(e.getMessage());
			msgDel = "删除失败：" + e.getMessage();
			if(LOG.isDebugEnabled()){
				LOG.debug("delSel() ********** end **********");
			}
			return SUCCESS;
		}finally{
			//
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("delSel() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 全面评估重复数据页面跳转
	 * @return
	 * @throws Exception
	 */
	public String executeDZ()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("executeDZ() ********** start **********");
		}
		try{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			txtSSGX = sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX);
			ReadInfo();
		}catch(Exception e){
			LOG.error(e.getMessage());
		}finally{
			//
		}
		if(LOG.isDebugEnabled()){
			LOG.debug("executeDZ() ********** end **********");
		}
		return SUCCESS;
	}
	
	
	/**
	 * 全面评估重复地址的查询
	 * @return
	 * @throws Exception
	 */
	public String queryDZ()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("queryDZ() ********** start **********");
		}
		Pgv00320 v00320 = new Pgv00320();
		try{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			v00320.setPageIndex(pageIndex);
			v00320.setPageSize(getPageSize());
			v00320.setCd00001Szqy(ddlSZQYFind);
			v00320.setZcdzl(Common.getSearchLike(txtZCDZLFind));
			v00320.setZh(Common.getSearchLike(txtZHFind));
			v00320.setDyh(Common.getSearchLike(txtDYFind));
			v00320.setFh(Common.getSearchLike(txtBWJFHFind));
			v00320.setXqnm(Common.getSearchLike(txtXQTIP));
			
			if(null != txtSSGX && !"".equals(txtSSGX)){
				v00320.setCd00001Ssgx(txtSSGX);
			}else{
				v00320.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			}
			tabList = t00320Service.LoadAllDZ(v00320);
			// 分页设置
			if (null != tabList && tabList.size() > 0) {
				rowCount = tabList.get(0).getRecordCount();
			} else {
				pageIndex = 1;
				rowCount = 0;
			}
		}catch(Exception e){
			LOG.error(e.getMessage());
			if(LOG.isDebugEnabled()){
				LOG.debug("queryDZ() ********** end **********");
			}
			return ERROR;
		}finally{
			//
		}
		if(LOG.isDebugEnabled()){
			LOG.debug("queryDZ() ********** end **********");
		}
		return SUCCESS;
	}

	/***********************   set  &&  get   ***************************/
	@JSON(deserialize = false, serialize = false)
	public IPgt00320Service getT00320Service() {
		return t00320Service;
	}


	public void setT00320Service(IPgt00320Service t00320Service) {
		this.t00320Service = t00320Service;
	}


	public ArrayList<Pgv00320> getTabList() {
		return tabList;
	}


	public void setTabList(ArrayList<Pgv00320> tabList) {
		this.tabList = tabList;
	}


	public Integer getPageIndex() {
		return pageIndex;
	}


	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}


	public Integer getRowCount() {
		return rowCount;
	}


	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}


	public Integer getPageSize() {
		return pageSize;
	}


	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
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


	public String getTxtFilePath() {
		return txtFilePath;
	}


	public void setTxtFilePath(String txtFilePath) {
		this.txtFilePath = txtFilePath;
	}





	public ArrayList<Pgv00320> getPgv00320List() {
		return pgv00320List;
	}


	public void setPgv00320List(ArrayList<Pgv00320> pgv00320List) {
		this.pgv00320List = pgv00320List;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public InputStream getExcelStream() {
		return excelStream;
	}


	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}


	public String getHidFlag() {
		return hidFlag;
	}


	public void setHidFlag(String hidFlag) {
		this.hidFlag = hidFlag;
	}


	public String[] getChkSel() {
		return chkSel;
	}


	public void setChkSel(String[] chkSel) {
		this.chkSel = chkSel;
	}


	public Integer getProcessCent() {
		return processCent;
	}


	public void setProcessCent(Integer processCent) {
		this.processCent = processCent;
	}


	public String getProcessMsg() {
		return processMsg;
	}


	public void setProcessMsg(String processMsg) {
		this.processMsg = processMsg;
	}


	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionCtrl.appSession = arg0;
	}


	public String getTxtXQDMFind() {
		return txtXQDMFind;
	}


	public void setTxtXQDMFind(String txtXQDMFind) {
		this.txtXQDMFind = txtXQDMFind;
	}


	public String getTxtZHFind() {
		return txtZHFind;
	}


	public void setTxtZHFind(String txtZHFind) {
		this.txtZHFind = txtZHFind;
	}


	public String getTxtDYFind() {
		return txtDYFind;
	}


	public void setTxtDYFind(String txtDYFind) {
		this.txtDYFind = txtDYFind;
	}


	public String getTxtBWJFHFind() {
		return txtBWJFHFind;
	}


	public void setTxtBWJFHFind(String txtBWJFHFind) {
		this.txtBWJFHFind = txtBWJFHFind;
	}


	public Pgv00320 getPgt00320Bean() {
		return pgt00320Bean;
	}


	public void setPgt00320Bean(Pgv00320 pgt00320Bean) {
		this.pgt00320Bean = pgt00320Bean;
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


	public ArrayList<Pgv00052> getSzqyList() {
		return szqyList;
	}


	public void setSzqyList(ArrayList<Pgv00052> szqyList) {
		this.szqyList = szqyList;
	}


	public String getTxtPSSD() {
		return txtPSSD;
	}


	public void setTxtPSSD(String txtPSSD) {
		this.txtPSSD = txtPSSD;
	}


	public Pgv00320 getV00320Bean() {
		return v00320Bean;
	}


	public void setV00320Bean(Pgv00320 v00320Bean) {
		this.v00320Bean = v00320Bean;
	}


	public String getFCID() {
		return FCID;
	}


	public void setFCID(String fCID) {
		FCID = fCID;
	}


	public String getTxtFCZH() {
		return txtFCZH;
	}


	public void setTxtFCZH(String txtFCZH) {
		this.txtFCZH = txtFCZH;
	}


	public String getTxtSWID() {
		return txtSWID;
	}


	public void setTxtSWID(String txtSWID) {
		this.txtSWID = txtSWID;
	}


	public String getTxtNSRMC() {
		return txtNSRMC;
	}


	public void setTxtNSRMC(String txtNSRMC) {
		this.txtNSRMC = txtNSRMC;
	}


	public String getTxtCSFSWID() {
		return txtCSFSWID;
	}


	public void setTxtCSFSWID(String txtCSFSWID) {
		this.txtCSFSWID = txtCSFSWID;
	}


	public String getTxtCSFNSRMC() {
		return txtCSFNSRMC;
	}


	public void setTxtCSFNSRMC(String txtCSFNSRMC) {
		this.txtCSFNSRMC = txtCSFNSRMC;
	}


	public String getTxtZJLX() {
		return txtZJLX;
	}


	public void setTxtZJLX(String txtZJLX) {
		this.txtZJLX = txtZJLX;
	}


	public String getTxtCSFZJLX() {
		return txtCSFZJLX;
	}


	public void setTxtCSFZJLX(String txtCSFZJLX) {
		this.txtCSFZJLX = txtCSFZJLX;
	}


	public String getTxtLXDH() {
		return txtLXDH;
	}


	public void setTxtLXDH(String txtLXDH) {
		this.txtLXDH = txtLXDH;
	}


	public String getTxtJYSJ() {
		return txtJYSJ;
	}


	public void setTxtJYSJ(String txtJYSJ) {
		this.txtJYSJ = txtJYSJ;
	}


	public String getTxtDJRQ() {
		return txtDJRQ;
	}


	public void setTxtDJRQ(String txtDJRQ) {
		this.txtDJRQ = txtDJRQ;
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


	public String getTxtFCID() {
		return txtFCID;
	}


	public void setTxtFCID(String txtFCID) {
		this.txtFCID = txtFCID;
	}


	public String getTxtJYLX() {
		return txtJYLX;
	}


	public void setTxtJYLX(String txtJYLX) {
		this.txtJYLX = txtJYLX;
	}


	public String getTxtNOTE() {
		return txtNOTE;
	}


	public void setTxtNOTE(String txtNOTE) {
		this.txtNOTE = txtNOTE;
	}


	public String getTxtJYJG() {
		return txtJYJG;
	}


	public void setTxtJYJG(String txtJYJG) {
		this.txtJYJG = txtJYJG;
	}


	/**
	 * @return the zcdzl
	 */
	public String getZcdzl() {
		return zcdzl;
	}


	/**
	 * @param zcdzl the zcdzl to set
	 */
	public void setZcdzl(String zcdzl) {
		this.zcdzl = zcdzl;
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


	/**
	 * @return the txtDYH
	 */
	public String getTxtDYH() {
		return txtDYH;
	}


	/**
	 * @param txtDYH the txtDYH to set
	 */
	public void setTxtDYH(String txtDYH) {
		this.txtDYH = txtDYH;
	}


	/**
	 * @return the txtFH
	 */
	public String getTxtFH() {
		return txtFH;
	}


	/**
	 * @param txtFH the txtFH to set
	 */
	public void setTxtFH(String txtFH) {
		this.txtFH = txtFH;
	}




	public String getTxtJYSJFind() {
		return txtJYSJFind;
	}


	public void setTxtJYSJFind(String txtJYSJFind) {
		this.txtJYSJFind = txtJYSJFind;
	}


	public String getRdoPGJG() {
		return rdoPGJG;
	}


	public void setRdoPGJG(String rdoPGJG) {
		this.rdoPGJG = rdoPGJG;
	}


	public String getTxtSWIDFind() {
		return txtSWIDFind;
	}


	public void setTxtSWIDFind(String txtSWIDFind) {
		this.txtSWIDFind = txtSWIDFind;
	}


	public String getACT() {
		return ACT;
	}


	public void setACT(String aCT) {
		ACT = aCT;
	}


	public Pgv00320 gettBean() {
		return tBean;
	}


	public void settBean(Pgv00320 tBean) {
		this.tBean = tBean;
	}


	public String getSysDate() {
		return SysDate;
	}


	public void setSysDate(String sysDate) {
		SysDate = sysDate;
	}


	public Pgv00303 getV00303Bean() {
		return v00303Bean;
	}


	public void setV00303Bean(Pgv00303 v00303Bean) {
		this.v00303Bean = v00303Bean;
	}


	public String getTxtZCDZLFind() {
		return txtZCDZLFind;
	}


	public void setTxtZCDZLFind(String txtZCDZLFind) {
		this.txtZCDZLFind = txtZCDZLFind;
	}


	public String getTxtFWLX() {
		return txtFWLX;
	}


	public void setTxtFWLX(String txtFWLX) {
		this.txtFWLX = txtFWLX;
	}


	public String getDdlSZQY() {
		return ddlSZQY;
	}


	public void setDdlSZQY(String ddlSZQY) {
		this.ddlSZQY = ddlSZQY;
	}


	public ArrayList<Pgv00320e> getQtxzList() {
		return qtxzList;
	}


	public void setQtxzList(ArrayList<Pgv00320e> qtxzList) {
		this.qtxzList = qtxzList;
	}


	public String getTxtCLH() {
		return txtCLH;
	}


	public void setTxtCLH(String txtCLH) {
		this.txtCLH = txtCLH;
	}


	public String getTxtZCDZL() {
		return txtZCDZL;
	}


	public void setTxtZCDZL(String txtZCDZL) {
		this.txtZCDZL = txtZCDZL;
	}


	public String getTxtJZMJ() {
		return txtJZMJ;
	}


	public void setTxtJZMJ(String txtJZMJ) {
		this.txtJZMJ = txtJZMJ;
	}


	public String getTxtHDJG() {
		return txtHDJG;
	}


	public void setTxtHDJG(String txtHDJG) {
		this.txtHDJG = txtHDJG;
	}


	public String getTxtXQDM() {
		return txtXQDM;
	}


	public void setTxtXQDM(String txtXQDM) {
		this.txtXQDM = txtXQDM;
	}


	public String getTxtZLC() {
		return txtZLC;
	}


	public void setTxtZLC(String txtZLC) {
		this.txtZLC = txtZLC;
	}


	public String getTxtSZLC() {
		return txtSZLC;
	}


	public void setTxtSZLC(String txtSZLC) {
		this.txtSZLC = txtSZLC;
	}


	public String getTxtJZJG() {
		return txtJZJG;
	}


	public void setTxtJZJG(String txtJZJG) {
		this.txtJZJG = txtJZJG;
	}


	public String getTxtGHYT() {
		return txtGHYT;
	}


	public void setTxtGHYT(String txtGHYT) {
		this.txtGHYT = txtGHYT;
	}


	public String getTxtZH() {
		return txtZH;
	}


	public void setTxtZH(String txtZH) {
		this.txtZH = txtZH;
	}


	public String getTxtJCNF() {
		return txtJCNF;
	}


	public void setTxtJCNF(String txtJCNF) {
		this.txtJCNF = txtJCNF;
	}


	public String getTxtZJHM() {
		return txtZJHM;
	}


	public void setTxtZJHM(String txtZJHM) {
		this.txtZJHM = txtZJHM;
	}


	public String getHidZHXZid() {
		return hidZHXZid;
	}


	public void setHidZHXZid(String hidZHXZid) {
		this.hidZHXZid = hidZHXZid;
	}


	public String getTxtUPDATE() {
		return txtUPDATE;
	}


	public void setTxtUPDATE(String txtUPDATE) {
		this.txtUPDATE = txtUPDATE;
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


	public String getTSIGN() {
		return TSIGN;
	}


	public void setTSIGN(String tSIGN) {
		TSIGN = tSIGN;
	}


	/**
	 * @return the isExistZT
	 */
	public boolean isExistZT() {
		return isExistZT;
	}


	/**
	 * @param isExistZT the isExistZT to set
	 */
	public void setExistZT(boolean isExistZT) {
		this.isExistZT = isExistZT;
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


	
}
