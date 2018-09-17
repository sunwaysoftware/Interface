

/**
 * @author sunxdd
 *
 */

package com.sunway.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import com.sunway.net.FTPUtil;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt02010fService;
import com.sunway.util.CheckUtil;
import com.sunway.util.Constant;
import com.sunway.util.ConvertUtil;
import com.sunway.util.FileUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv02010f;

public class Pgt02010fAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 68204430262451375L;
	private IPgt02010fService t02010fService;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	//grid list
	private ArrayList<Pgv02010f> rows;
	// 页面Bean
	private String pk;
	private Pgv02010f t02010fBean;
	//编辑操作符
	private String ACT;

	//分页参数
	private Integer pageIndex;
	private Integer pageSize;
	private Integer total;
	//显示图片参数
	private String picServer;
	//FTP参数
	private String ftpIP;
	private String ftpPort;
	private String ftpUsername;
	private String ftpPassword;
	
	//编辑项
	private String FCID;
	private String ZTLX;
	private File txtUpload;
	private String txtUploadFileName;
	private String txtUploadContentType;

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	/**
	 * 查询
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		Pgv02010f b = new Pgv02010f();
		try {						
			b.setCd02002Fcid(CheckUtil.chkTrim(FCID));
			b.setZtlx(ConvertUtil.toShort(ZTLX));;
			b.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			rows = t02010fService.LoadAll(b);
			//分页设置
			if(null!=rows && rows.size()>0){
				total = rows.get(0).getTotal();
				for (Pgv02010f r:rows) {
					r.setBcljm("http://" + picServer + r.getBcljm());
				}
			}else{
				total = 0;
				pageIndex = 1;
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/**
	 * 查询
	 * @return
	 * @throws Exception
	 */
	public String queryB() throws Exception {
		Pgv02010f b = new Pgv02010f();
		try {						
			b.setCd02002Fcid(CheckUtil.chkTrim(FCID));
			b.setZtlx(ConvertUtil.toShort(ZTLX));;
			b.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			rows = t02010fService.LoadAllB(b);
			//分页设置
			if(null!=rows && rows.size()>0){
				total = rows.get(0).getTotal();
				for (Pgv02010f r:rows) {
					r.setBcljm("http://" + picServer + r.getBcljm());
				}
			}else{
				total = 0;
				pageIndex = 1;
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public void validateUpdate() throws Exception{
		this.clearActionErrors();
		t02010fBean = new Pgv02010f();
		t02010fBean.setId(pk);
		t02010fBean.setCd02002Fcid(FCID);

		//根据PK信息，为数据BEAN赋值
		if (!Constant.MOD_DELETE.equals(ACT)){
			if (Constant.MOD_UPDATE.equals(ACT)){
				t02010fBean = t02010fService.LoadByPrimaryKey(t02010fBean);
			}
			t02010fBean.setZtlx(ConvertUtil.toShort(ZTLX));
			t02010fBean.setCd02002Fcid(FCID);
			t02010fBean.setZlfjm(txtUploadFileName);
			txtUploadFileName = FileUtil.randFileName(txtUploadFileName);
			t02010fBean.setBcljm(CheckUtil.chkTrim("/upload/zyPic/"+FCID+"/"+txtUploadFileName));
			t02010fBean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));			
			t02010fBean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
		}
	}
	
	public String update() throws Exception {
		try {
			if(Constant.MOD_CREATE.equals(ACT)){// Create
				//上传资料
				FTPUtil ftpUtil = new FTPUtil(ftpIP,ftpUsername,ftpPassword);
				ftpUtil.connectServer();
				File f = new File(txtUpload.getParent()+"/"+txtUploadFileName);
				txtUpload.renameTo(f);
				ftpUtil.uploadFile(f.getPath(),"/zyPic/"+FCID+"/");
				ftpUtil.closeServer();
				ftpUtil = null;
				//存储文件列表于数据库
				if(t02010fService.GetInsertCommand(t02010fBean)){
					this.addActionMessage(getText(Constant.MSG_CREATE_OK));
				}else {
					this.addActionError(getText(Constant.MSG_CREATE_NG));
				}
			} else if (Constant.MOD_UPDATE.equals(ACT)) {	// Update				
				if(t02010fService.GetUpdateCommand(t02010fBean)){
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK));
				} else
					this.addActionError(getText(Constant.MSG_UPDATE_NG));
				
			} else if (Constant.MOD_DELETE.equals(ACT)) {	// Delete
				if(t02010fService.GetDeleteCommand(t02010fBean))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG));				
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());
			return INPUT;
		}
		return SUCCESS;
	}
	
	/**
	 * 显示详细信息
	 * @return
	 * @throws Exception
	 */
	public String detail() throws Exception {
		Pgv02010f b = new Pgv02010f();
		String info = SUCCESS;
		try {
			b.setId(FCID);

			t02010fBean = t02010fService.LoadByPrimaryKey(b);			
			
		} catch (Exception e) {
			this.addActionError(e.getMessage());
		}
		return info;
	}
	
	
	@Override
	public void setSession(Map<String, Object> session) {
		sessionCtrl.appSession = session;
	}
	
	
	//------------------------- setter and getter ------------------------------
	

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

	public ArrayList<Pgv02010f> getRows() {
		return rows;
	}

	public void setRows(ArrayList<Pgv02010f> rows) {
		this.rows = rows;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}	

	public Pgv02010f getT02010fBean() {
		return t02010fBean;
	}

	public void setT02010fBean(Pgv02010f t02010fBean) {
		this.t02010fBean = t02010fBean;
	}

	public String getFCID() {
		return FCID;
	}

	public void setFCID(String fCID) {
		FCID = fCID;
	}

	public String getZTLX() {
		return ZTLX;
	}

	public void setZTLX(String zTLX) {
		ZTLX = zTLX;
	}

	@JSON(deserialize=false, serialize=false)
	public IPgt02010fService getT02010fService() {
		return t02010fService;
	}

	public void setT02010fService(IPgt02010fService t02010fService) {
		this.t02010fService = t02010fService;
	}

	public String getFtpIP() {
		return ftpIP;
	}

	public void setFtpIP(String ftpIP) {
		this.ftpIP = ftpIP;
	}

	public String getFtpPort() {
		return ftpPort;
	}

	public void setFtpPort(String ftpPort) {
		this.ftpPort = ftpPort;
	}

	public String getFtpUsername() {
		return ftpUsername;
	}

	public void setFtpUsername(String ftpUsername) {
		this.ftpUsername = ftpUsername;
	}

	public String getFtpPassword() {
		return ftpPassword;
	}

	public void setFtpPassword(String ftpPassword) {
		this.ftpPassword = ftpPassword;
	}

	public File getTxtUpload() {
		return txtUpload;
	}

	public void setTxtUpload(File txtUpload) {
		this.txtUpload = txtUpload;
	}

	public String getTxtUploadFileName() {
		return txtUploadFileName;
	}

	public void setTxtUploadFileName(String txtUploadFileName) {
		this.txtUploadFileName = txtUploadFileName;
	}

	public String getTxtUploadContentType() {
		return txtUploadContentType;
	}

	public void setTxtUploadContentType(String txtUploadContentType) {
		this.txtUploadContentType = txtUploadContentType;
	}

	public String getPicServer() {
		return picServer;
	}

	public void setPicServer(String picServer) {
		this.picServer = picServer;
	}

	public String getPk() {
		return pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}
}