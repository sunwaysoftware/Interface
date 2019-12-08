package com.sunway.action;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileOutputStream;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00306fService;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.DwindlePic;
import com.sunway.util.FileUpload;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt00306f;
import com.sunway.vo.Pgv00306f;

public class Pgt00306fAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 68204010262561375L;

	private IPgt00306fService t00306fService;
	
	private SessionCtrl sessionCtrl = new SessionCtrl();
	
	private ArrayList<Pgv00306f> tabList;
	//查询条件
	private String txtXQDM;
	private String txtXQDMHM;
	private String LH;
	
	//文件上传
	private String txtFileFileName;
	private String file_url;
	private Integer isSW;
	private String savePath;
	private File txtFile;
	private String txtZPLX;
	private String txtNote;
	private String txtZPID;
	private String CD00306ID;
	
	//图片删除
	private Pgt00306f t00306fBean;
	private String txtXQDMDEL;
	private String txtXQDMHMDEL;
	private String CD00306IDDEL;
	
	private String ip;

	@Override
	public String execute() throws Exception {
		if(LOG.isDebugEnabled()){
			LOG.debug("execute() ********** start **********");
		}
		
		
		if(LOG.isDebugEnabled()){
			LOG.debug("exeucte() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 数据查询
	 * @return
	 * @throws Exception
	 */
	public String queryByDz()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("query() ********** start **********");
		}
		try{
			Pgv00306f v00306f = new Pgv00306f();
			v00306f.setLh(LH);
			v00306f.setCd00352Xqdm(txtXQDM);
			
			tabList = t00306fService.LoadAllByDz(v00306f);
			String url = "http://" + ip;
			
			for(int i = 0;i < tabList.size();i++){
				Pgv00306f e = tabList.get(i);
				//String fileServerPath = ServletActionContext.getServletContext().getRealPath("upload\\xqPic");
				if (!Common.isNullOrEmpty(e.getZplj()))
					e.setZplj(url +Common.picPathUrl(e.getZplj()));
//				if (!Common.isNullOrEmpty(e.getZpljMin()))
//					e.setZpljMin(url +Common.picPathUrl(e.getZpljMin()));
//				if (!Common.isNullOrEmpty(e.getZpljDownLoad()))
//					e.setZpljDownLoad(url +Common.picPathUrl(e.getZpljDownLoad()));
			}
		}catch(Exception e){
			LOG.error(e.getMessage());
		}
		if(LOG.isDebugEnabled()){
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 数据查询
	 * @return
	 * @throws Exception
	 */
	public String query()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("query() ********** start **********");
		}
		try{
			Pgv00306f v00306f = new Pgv00306f();
			v00306f.setCd00306Id(Common.convertToInteger(CD00306ID));
			
			tabList = t00306fService.LoadAll(v00306f);
			String url = "http://" + ip;
			
			for(int i = 0;i < tabList.size();i++){
				Pgv00306f e = tabList.get(i);
				//String fileServerPath = ServletActionContext.getServletContext().getRealPath("upload\\xqPic");
				if (!Common.isNullOrEmpty(e.getZplj()))
					e.setZplj(url +Common.picPathUrl(e.getZplj()));
				if (!Common.isNullOrEmpty(e.getZpljMin()))
					e.setZpljMin(url +Common.picPathUrl(e.getZpljMin()));
				if (!Common.isNullOrEmpty(e.getZpljDownLoad()))
					e.setZpljDownLoad(url +Common.picPathUrl(e.getZpljDownLoad()));
			}
		}catch(Exception e){
			LOG.error(e.getMessage());
		}
		if(LOG.isDebugEnabled()){
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 验证文件上传
	 */
	public void validateCreate() {
		if(this.hasErrors()){
			this.clearErrorsAndMessages();
			this.addActionError(getText("app.msg.error.fileupload"));
		}		
		//讀取"照片類型"
		try {
			
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
	}
	public int Random()
	{
		Random random = new Random();
		int num = random.nextInt();
		return num;

	}
	
	
	/**
	 * 保存地產圖片信息
	 * @return
	 * @throws Exception
	 */
	public String create() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** start **********"+Common.getCurrentTime());
		}	
		
		DwindlePic mypic = new DwindlePic();
		String fileServerPath = null;
		String Radnumber=Integer.toString(Random());
		txtFileFileName=Radnumber+".jpg";
		String shortFileName = "min" + txtFileFileName;		
		String viewFileName = "view" + txtFileFileName;
		String swUrl=file_url;	
		SmbFile swFile= new SmbFile(swUrl);
		SmbFile uploadFile = new SmbFile(swFile+ "upload/"); 
		SmbFile xqPicFile = new SmbFile(swFile + "upload/xqPic/"); 
		SmbFile xqPicURLMax=null;
		//SmbFile xqPicURLMin=null;
		try{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			fileServerPath = ServletActionContext.getServletContext().getRealPath(savePath+ "/" +txtXQDM) + "/";
			//fileServerPath = ServletActionContext.getServletContext().getRealPath(savePath+ "/" +txtXQDMHM) + "/";		//2011-12-7修改  小区编码为代码号
			if(file_url!=null){
				isSW = 1;
				if(!swFile.isDirectory())
				{
					file_url= ServletActionContext.getServletContext().getRealPath("");
					isSW = 0;
				}
				
			}
			if (isSW==1)
			{					
				//判断服务器是否有对应的共享文件如果没有就创建
				 if(!uploadFile.exists()){  
	                 //创建远程文件夹   
					 uploadFile.mkdir();  
					 if(!xqPicFile.exists()){  
						 
						 xqPicFile.mkdir();  							 
		             }
	             } 
			    SmbFile	 RadFile =new SmbFile(xqPicFile+txtXQDM); 
				//SmbFile	 RadFile =new SmbFile(xqPicFile+txtXQDMHM);     //2011-12-7修改小区编码为代码号 
			    if(!RadFile.exists()){  
					 
			        RadFile.mkdir();  							 
	             }
			
				xqPicURLMax=new SmbFile(RadFile+"/"+txtFileFileName);
				
				//上传共享文件
				FileInputStream inpic=new FileInputStream(txtFile);	
				SmbFileOutputStream in = new SmbFileOutputStream(xqPicURLMax);
				byte []b =new byte[1024*8];
				int len =0;
				while((len=inpic.read(b)) != -1)
				{
					in.write(b, 0, len);
				}
				in.flush();
				in.close();
				inpic.close();
				//生成縮略圖
				if(!mypic.s_pic(txtFile.toString(), RadFile+"/"+shortFileName,true)){
					throw new Exception(getText("app.msg.error.filezoomout"));
				}
				
				//生成显示圖
				if(!mypic.s_pic(txtFile.toString(), RadFile+"/"+viewFileName, 550, 550,true)){
					throw new Exception(getText("app.msg.error.filezoomout")+"请检查格式是否为.jpg");
				}
			}
			else{
				//上传到本地文件夹
				FileUpload fileUpload = new FileUpload();
				File file= new File(getSavePath());
				
				if(!file.exists())
					file.mkdir();
				//文件上傳處理
				fileUpload.setFile(txtFile);
				fileUpload.setFileName(txtFileFileName);
				fileUpload.setFileServerPath(fileServerPath);		
				
				if (!fileUpload.upload()) {
					throw new Exception(getText("app.msg.error.fileupload"));
				}
				//生成縮略圖
				if(!mypic.s_pic(fileServerPath+txtFileFileName, fileServerPath + shortFileName,false)){
					throw new Exception(getText("app.msg.error.filezoomout")+"请检查格式是否为.jpg");
				}
				
				//生成显示圖
				if(!mypic.s_pic(fileServerPath+txtFileFileName, fileServerPath + viewFileName, 550, 550,false)){
					throw new Exception(getText("app.msg.error.filezoomout")+"请检查格式是否为.jpg");
				}
			}
			
			//文件信息入庫
			Pgt00306f t00306f = new Pgt00306f();
			t00306f.setCd00306Id(Common.convertToInteger(CD00306ID));
			t00306f.setCd00352Xqdm(txtXQDM);
			//t00306f.setCd00352Xqdm(txtXQDMHM);						//2011-12-7修改  小区编码为代码号
			t00306f.setZplx(Common.convertToInteger(txtZPLX)); 
			t00306f.setZplj("/upload/xqPic/" + txtXQDM + "/" + viewFileName);
			t00306f.setZpljMin("/upload/xqPic/" + txtXQDM + "/" + shortFileName);
			//t00306f.setZplj("/upload/xqPic/" + txtXQDMHM + "/" + viewFileName);			//2011-12-7修改  小区编码为代码号
			//t00306f.setZpljMin("/upload/xqPic/" + txtXQDMHM + "/" + shortFileName);		//2011-12-7修改  小区编码为代码号
			t00306f.setNote(txtNote);
			t00306f.setCd00002Czr(sessionCtrl.getUserId());
			t00306f.setZpljDownLoad("/upload/xqPic/" + txtXQDM + "/" + txtFileFileName);
			//t00306f.setZpljDownLoad("/upload/xqPic/" + txtXQDMHM + "/" + txtFileFileName);	//2011-12-7修改  小区编码为代码号
			if(t00306fService.GetInsertCommand(t00306f))
				this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{t00306f.getCd00352Xqdm().toString()}));
			else
				this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{t00306f.getCd00352Xqdm().toString()}));
		}catch(Exception ex){
			ex.printStackTrace();
			this.addActionError(ex.getMessage());
			return INPUT;
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** end **********"+Common.getCurrentTime());
		}
		return SUCCESS;
		
	}
	
	/**
	 * 验证文件上传
	 */
	public void validateUpdate() {
		this.clearErrorsAndMessages();
		Pgt00306f t00306f = new Pgt00306f();
		try {
			t00306f.setZpid(txtZPID);
			t00306fBean = t00306f;
			
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());
		}
	}
	
	/**
	 * 刪除地產圖片信息
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** start **********");
		}
		
		try {
			Pgt00306f t00306f = t00306fService.LoadByPrimaryKey(t00306fBean);
			ArrayList<String> delList = new ArrayList<String>();
			String fileServerPath = ServletActionContext.getServletContext().getRealPath("upload/xqPic").replace("\\", "/");
			String path = fileServerPath.substring(0,fileServerPath.indexOf("upload/xqPic"));
			if(t00306fService.GetDeleteCommand(t00306fBean)){	
				String swUrl=file_url;	
				if(null != file_url && !"".equals(file_url)){
					isSW = 1;			
				}			
				if (isSW==1)
				{
					SmbFile temp1 = new SmbFile(swUrl+t00306f.getZpljDownLoad());
					temp1.delete();
					SmbFile temp2 = new SmbFile(swUrl+t00306f.getZplj());
					temp2.delete();
					SmbFile temp3 = new SmbFile(swUrl+t00306f.getZpljMin());
					temp3.delete();
				}else{
					delList.add(path+t00306f.getZpljDownLoad());
					delList.add(path+t00306f.getZplj());
					delList.add(path+t00306f.getZpljMin());
					Common.removeUploadFiles(delList);
				}
				this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{t00306fBean.getZpid().toString()}));
			}else{
				this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{t00306fBean.getZpid().toString()}));
			}
		} catch (Exception e) {
			String[] msgs = e.getMessage().split("\n");
			this.addActionError(msgs[0]);

			if (LOG.isDebugEnabled()) {
				LOG.debug("update() ********** end **********");
			}
			return INPUT;
		}		

		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 根据小区代码，删除该小区内所有图片
	 * @return
	 * @throws Exception
	 */
	public String delPhotoByLF()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("delPhotoByXQ() ********** start **********");
		}
		try{
			setTxtXQDM(txtXQDMDEL);
			setTxtXQDMHM(txtXQDMHMDEL);
			setCD00306ID(CD00306IDDEL);
			//String fileServerPath = ServletActionContext.getServletContext().getRealPath("upload//xqPic");
			Pgt00306f t00306f = new Pgt00306f();
			t00306f.setCd00306Id(Common.convertToInteger(CD00306IDDEL));
			if(t00306fService.DelPhotoByLF(t00306f)){
				/*String swUrl=file_url;	
				if(null != file_url && !"".equals(file_url)){
					isSW = 1;			
				}			
				if (isSW==1)
				{
					SmbFile temp = new SmbFile(swUrl+"upload/xqPic/"+txtXQDMDEL+"/");
					temp.delete();
				}else{
					FileUtils.deleteDirectory(new File(fileServerPath+"/"+txtXQDMDEL));
				}*/
			
				this.addActionMessage("删除成功");
			}
		}catch(Exception e){
			LOG.error(e.getMessage());
			this.addActionError("删除出现异常");
			return INPUT;
		}
		if(LOG.isDebugEnabled()){
			LOG.debug("delPhotoByXQ() ********** end **********");
		}
		return SUCCESS;
	}

	

	
	
	/*******************************   set & get   ********************************/
	@JSON(deserialize=false, serialize=false)
	public IPgt00306fService getT00306fService() {
		return t00306fService;
	}

	public void setT00306fService(IPgt00306fService t00306fService) {
		this.t00306fService = t00306fService;
	}

	public ArrayList<Pgv00306f> getTabList() {
		return tabList;
	}

	public void setTabList(ArrayList<Pgv00306f> tabList) {
		this.tabList = tabList;
	}

	public String getTxtXQDM() {
		return txtXQDM;
	}

	public void setTxtXQDM(String txtXQDM) {
		this.txtXQDM = txtXQDM;
	}

	public String getTxtFileFileName() {
		return txtFileFileName;
	}

	public void setTxtFileFileName(String txtFileFileName) {
		this.txtFileFileName = txtFileFileName;
	}

	public String getFile_url() {
		return file_url;
	}

	public void setFile_url(String fileUrl) {
		file_url = fileUrl;
	}

	public Integer getIsSW() {
		return isSW;
	}

	public void setIsSW(Integer isSW) {
		this.isSW = isSW;
	}

	@SuppressWarnings("deprecation")
	public String getSavePath() {
		return ServletActionContext.getRequest().getRealPath(savePath);
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public File getTxtFile() {
		return txtFile;
	}

	public void setTxtFile(File txtFile) {
		this.txtFile = txtFile;
	}

	public String getTxtZPLX() {
		return txtZPLX;
	}

	public void setTxtZPLX(String txtZPLX) {
		this.txtZPLX = txtZPLX;
	}

	public String getTxtNote() {
		return txtNote;
	}

	public void setTxtNote(String txtNote) {
		this.txtNote = txtNote;
	}

	public String getTxtZPID() {
		return txtZPID;
	}

	public void setTxtZPID(String txtZPID) {
		this.txtZPID = txtZPID;
	}

	public Pgt00306f getT00306fBean() {
		return t00306fBean;
	}

	public void setT00306fBean(Pgt00306f t00306fBean) {
		this.t00306fBean = t00306fBean;
	}

	public String getCD00306ID() {
		return CD00306ID;
	}

	public void setCD00306ID(String cD00306ID) {
		CD00306ID = cD00306ID;
	}

	public String getTxtXQDMDEL() {
		return txtXQDMDEL;
	}

	public void setTxtXQDMDEL(String txtXQDMDEL) {
		this.txtXQDMDEL = txtXQDMDEL;
	}

	public String getCD00306IDDEL() {
		return CD00306IDDEL;
	}

	public void setCD00306IDDEL(String cD00306IDDEL) {
		CD00306IDDEL = cD00306IDDEL;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIp() {
		return ip;
	}

	public String getTxtXQDMHM() {
		return txtXQDMHM;
	}

	public void setTxtXQDMHM(String txtXQDMHM) {
		this.txtXQDMHM = txtXQDMHM;
	}

	public String getTxtXQDMHMDEL() {
		return txtXQDMHMDEL;
	}

	public void setTxtXQDMHMDEL(String txtXQDMHMDEL) {
		this.txtXQDMHMDEL = txtXQDMHMDEL;
	}

	public void setLH(String lH) {
		LH = lH;
	}

	public String getLH() {
		return LH;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}


}
