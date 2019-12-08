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
import com.sunway.service.IPgt00303Service;
import com.sunway.service.IPgt00351Service;
import com.sunway.service.IPgt00351aService;
import com.sunway.service.IPgt00351eService;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.Excel;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.ExcelBean;
import com.sunway.vo.Pgt00303;
import com.sunway.vo.Pgt00351;
import com.sunway.vo.Pgt00351a;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv00303;
import com.sunway.vo.Pgv00351;
import com.sunway.vo.Pgv00351a;
import com.sunway.vo.Pgv00351e;


/**
 *
 * 市场法标准实例库
 * @category 系统维护
 * @author Lee create
 * @author Andy.Gao fix
 * @version 1.0
 *
 */

public class Pgt00351Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 3316530735373418595L;
	// Service
	private IPgt00351Service t00351Service;
	private IPgt00303Service t00303Service;
	private IPgt00351eService t00351eService;
	private IPgt00351aService t00351aService;
	
	// View
	private ArrayList<Pgv00052> szqyList;
	// 分页参数
	private Integer pageIndex;
	private Integer pageSize;
	private Integer rowCount;
	// Bean数组
	private ArrayList<Pgv00351> tabList;
	private ArrayList<Pgv00351a> tabListA;
	private Pgv00351 v00351Bean;
	// 检索条件
	private String txtXQFind;
	private String ddlSZQYFind;
	private String txtSLIDFind;
	private String txtJYSJFind;
	//编辑操作符
	private String ACT;
	//primary key 主键
	private String SLID;
	// edit页面所需Bean
	private Pgt00351 tBean;
	private Pgt00303 t00303Bean;
	// edit页面提交数据
	private String txtUPDATE;
	private String txtLFID;
	private String txtFWLX;
	private String txtJYLX;
	private String txtJZJGT;
	private String txtFWCX;
	private String txtCGZK;
	private Short txtSZLC;
	private Double txtPFMJG;
	private String txtJYSJ;
	private String txtJCNF;
	private String ddlSZQY;
	private String txtNOTET00351;
	private String txtJZJG;
	private Boolean rdoYWDT;
	private Boolean rdoYWJKC;
	private Short txtZLC;
	private String txtNOTE;
	private ArrayList<Pgv00351e> qtxzList;
	private String XZLX;
	private String hidQTXZ;
	private String txtXQDM;
	private String SZQY;
	private String JYSJ;
	private String ZCDZS;
	private String ZCDZD;
	private String ZCDZL;
	private String ZCDZM;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	private Pgv00303 v00303Bean;
	private String txtZCDZL;
	private String txtHXJG;
	private String txtJTZKId;
	private String txtWYZKId;
	private String txtZXZKId;
	private String chkSel;
	//生产标准房个数
	private Integer createSum;
	//该字段为封装审核状态
	private String FROM;
	
	//file upload
	private String title;
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private String savePath;
	private String fileServerPath;
	//file import
	private String txtFilePath;
	private ArrayList<Pgv00351> Pgv00351List;
	private ArrayList<ExcelBean> ebList;
	private InputStream excelStream;
	private String fileName;
	private String txtCLH;
	private String hidZHXZid;
	
//测算与不可测算用	
	private String userRole;
	private String txtCSYF; 
	private String txtYWJG;
	private String txtXQNME;
	private String txtBZFJG;
	private String txtCSYFE;
	private String chkSelTemp;
	private String[] chkSell;
	private String hidFlag;
	private String processMsg;
	private Integer processCent;
	private String txtCSJYSJ;
	private String txtMONTHFind;
	private String txtFWLXCS;
	private String ddlSZQYCS;
	private String txtXQCX;
	private Integer rdoYWJG;
	private String txtCJAL;
	private String txtGPAL;
	private String txtYSF;
	private String txtZJ;
	private String txtFale;
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
			txtJYSJFind =Common.readCurrentDate();
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
			Pgv00351e v00351e = new Pgv00351e();
			v00351e.setCd00351Slid(SLID);
			v00351e.setCd00001Szqy(ddlSZQY);
			v00351e.setCd00001Fwlx(txtFWLX);
			qtxzList = t00351eService.LoadAll(v00351e);
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

		Pgv00351 v00351 = new Pgv00351();
		try {
			// 准备查询条件
			v00351.setSlid(Common.getSearchLike(txtSLIDFind));
			v00351.setCd00001Szqy(ddlSZQYFind);
			v00351.setCd00352Xqdm(Common.trim(txtXQFind));
			v00351.setZcdzl(Common.getSearchLike(txtZCDZL));
			v00351.setCd00001Fwlx(txtFWLX);
			if(null != txtJYSJFind && !"".equals(txtJYSJFind)){
				v00351.setJysj(Common.convertStringToDate(txtJYSJFind));
			}else{
				v00351.setJysj(Common.convertStringToDate(Common.getCurrentDate()));
			}
			
			v00351.setPageIndex(pageIndex);
			v00351.setPageSize(getPageSize());
			v00351.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			// 执行查询
			tabList = t00351Service.LoadAll(v00351);
			// 分页设置
			if (null != tabList && tabList.size() > 0) {
				rowCount = Common.checkNull(tabList.get(0).getRecordCount());
			} else {
				rowCount = 0;
				pageIndex = 1;
			}
			ReadInfo();
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());
			return ERROR;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;
	}
	/**
	 * 标准房维护数据导出
	 * @return
	 * @return Exception
	 */
      public String export() throws Exception{
    	  if(LOG.isDebugEnabled()){
    		  LOG.debug("query() ********** start **********");
    	  }
    	  Pgv00351 v00351 =new Pgv00351();
    	 
    	  try{
  			// 准备查询条件
  			v00351.setSlid(Common.getSearchLike(txtSLIDFind));
  			v00351.setCd00001Szqy(ddlSZQYFind);
  			v00351.setCd00352Xqdm(Common.trim(txtXQFind));
  			v00351.setZcdzl(Common.getSearchLike(txtZCDZL));
  			v00351.setCd00001Fwlx(txtFWLX);
  			v00351.setJysj(Common.convertStringToDate(txtJYSJFind));
  			v00351.setPageIndex(1);
  			v00351.setPageSize(-1);
  			v00351.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
    		  
  			ByteArrayOutputStream out = (ByteArrayOutputStream) t00351Service.ExportbzfwhSjcx(v00351);
			excelStream = new ByteArrayInputStream(out.toByteArray());
			out.close();
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
	 * 查询状态处理
	 *
	 * @return
	 * @throws Exception
	 */
	public String delsel() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}

		Pgv00351 v00351 = new Pgv00351();
		try {
			// 准备查询条件
			// 准备查询条件
			v00351.setChkSel(chkSel);	
			v00351.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			v00351.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			// 执行查询
			t00351Service.GetDeleteSelCommand(v00351);
			
		} catch (Exception e) {
			LOG.error(e.getMessage());
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

		Pgt00351 t00351 = new Pgt00351();
		tBean = new Pgt00351();
		v00303Bean = new Pgv00303();
		String rtn = SUCCESS;
		try {
			if (!Constant.MOD_CREATE.equals(getACT())) {
				// 取得用户选中的数据信息
				t00351.setSlid(SLID);
				tBean = t00351Service.LoadByPrimaryKey(t00351);
				v00303Bean.setLfid(tBean.getCd00303Lfid());
				v00303Bean.setPageIndex(1);
				v00303Bean.setPageSize(getPageSize());
				v00303Bean.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
				ArrayList<Pgv00303> v00303List = t00303Service.LoadAll(v00303Bean);
				if (null != v00303List && v00303List.size() > 0) {
					v00303Bean = v00303List.get(0);
				}		
				
			}else{
				v00303Bean.setCd00001Szqy(SZQY);
				v00303Bean.setCd00352Xqdm(txtXQDM);
				tBean.setZcdzl(v00303Bean.getZcdzl());
				tBean.setJysj(Common.convertToDate(JYSJ));
				tBean.setCd00001Fwlx(txtFWLX);
				tBean.setCd00001Jzjg(txtJZJG);
			}
			ReadInfo();
			if (Constant.MOD_CREATE.equals(getACT())) {
				rtn = "successADD";
			}
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
		return rtn;
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

		tBean = new Pgt00351();
		this.clearErrorsAndMessages();
		tBean.setSlid(SLID);
		//根据PK取得信息，并为BEAN赋值
		if (Constant.MOD_UPDATE.equals(getACT())) {
			tBean = t00351Service.LoadByPrimaryKey(tBean);
		}
		// 判读数据是否已经被其他用户修改
		if ((Constant.MOD_UPDATE.equals(getACT()))
				&& (!tBean.getUpddate().equals(
						Common.convertStringToTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		} else {
			tBean.setSlid(SLID);
			tBean.setCd00303Lfid(txtLFID);
			tBean.setCd00001Fwlx(txtFWLX);
			tBean.setCd00001Jylx(txtJYLX);
			tBean.setJcnf(txtJCNF);
			tBean.setCd00001Jzjg(txtJZJGT);
			tBean.setCd00001Fwcx(txtFWCX);
			tBean.setCd00001Cgzk(txtCGZK);
			tBean.setSzlc(txtSZLC);
			tBean.setJysj(Common.convertToDate(txtJYSJ));
			tBean.setPfmjg(Common.checkNull(txtPFMJG));
			tBean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			tBean.setNote(txtNOTET00351);
			tBean.setCd00352Xqdm(txtXQDM);
			tBean.setCd00001Jzjg1(txtJZJG);
			/*if(rdoYWDT){
				tBean.setYwdt(1);
			}else{*/
				tBean.setYwdt(0);
			//}			
			tBean.setZlc((short)0);
			tBean.setZcdzl("");
			tBean.setCd00001Jtzk(txtJTZKId);
			tBean.setCd00001Wyzk(txtWYZKId);
			tBean.setCd00001Zxzk(txtZXZKId);
			tBean.setNote1(txtNOTE);
			tBean.setHxjg(txtHXJG);
			tBean.setCd00053Qtxzid(hidQTXZ);
			tBean.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			tBean.setZhxz(hidZHXZid);
			tBean.setClh(txtCLH);
			tBean.setYwjkc(rdoYWJKC);
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
				if (t00351Service.GetInsertCommand(tBean)) {
					txtFale = "1";
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{Constant.STRING_EMPTY}));
				} else {
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{Constant.STRING_EMPTY}));
				}
			} else if (Constant.MOD_UPDATE.equals(getACT())) { // Update
				if (t00351Service.GetUpdateCommand(tBean)) {
					tBean = t00351Service.LoadByPrimaryKey(tBean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[] { tBean.getSlid() }));
				} else {
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[] { tBean.getSlid() }));
				}
			} else if (Constant.MOD_DELETE.equals(getACT())) { // Delete
				if (t00351Service.GetDeleteCommand(tBean)) {
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[] { tBean.getSlid() }));
					rtn = "successDEL";
				} else {
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[] { tBean.getSlid() }));
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
		Pgv00351 v00351 = new Pgv00351();
		v00351Bean = new Pgv00351();
		Pgv00351a v00351a = new Pgv00351a();
		try {
			// 准备查询条件
			v00351.setSlid(Common.convertEncoding(SLID));
			// 执行查询
			v00351a.setPageIndex(1);
			v00351a.setPageSize(-1);
			v00351a.setCd00351Slid(Common.trim(SLID));
			// 执行查询
			v00351Bean = t00351Service.LoadDetail(v00351);
			// 执行查询
			tabListA = t00351aService.LoadAll(v00351a);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());
			return ERROR;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 详细信息(公式查看页面)
	 * @return
	 * @throws Exception
	 */
	public String detailGS() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("detailGS() ********** start **********");
		}
		Pgv00351 v00351 = new Pgv00351();
		Pgt00351a t00351a = new Pgt00351a();
		v00351Bean = new Pgv00351();
		try {
			// 准备查询条件
			t00351a.setSlid(Common.convertEncoding(SLID));
			tabListA = t00351aService.LoadByPrimaryKey(t00351a);
			if(tabListA.size()>0){
				v00351.setSlid(tabListA.get(0).getCd00351Slid());
			}
			
			// 执行查询
			v00351Bean = t00351Service.LoadDetail(v00351);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());
			return ERROR;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("detailGS() ********** end **********");
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
	 * 生成标准房（虚拟）
	 * @return
	 * @throws Exception
	 */
	public String createBzf() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("createBzf() ********** start **********");
		}
		Pgt00351 t00351 = new Pgt00351();
		try {
			// 准备查询条件
			t00351.setCd00001Szqy(Common.convertEncoding(ddlSZQYFind));
			t00351.setCd00352Xqdm(txtXQDM);
//			t00351.setCd00001Fwlx(Common.convertEncoding(txtFWLX));
			t00351.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t00351.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			// 执行查询
			createSum = t00351Service.CreateBZF(t00351);
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("createBzf() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 生成标准房(真实)
	 * @return
	 * @throws Exception
	 */
	public String importBzf() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("importBzf() ********** start **********");
		}
		Pgt00351 t00351 = new Pgt00351();
		try {
			// 准备查询条件
			t00351.setCd00001Szqy(Common.convertEncoding(ddlSZQYFind));
			t00351.setCd00352Xqdm(Common.convertEncoding(txtXQDM));
			//t00351.setCd00001Fwlx(Common.convertEncoding(txtFWLX));
			t00351.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t00351.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			// 执行查询
			createSum = t00351Service.ImportBZF(t00351);
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("importBzf() ********** end **********");
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
			fileServerPath = getSavePath() + "\\BZF_" + sessionCtrl.getUserId() + getUploadFileName();
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
			ebList = Excel.resolveExcel(txtFilePath, sessionCtrl.getUserId(),sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(!checkDateList(ebList))
				this.addActionError("估价分区数据不符合导入要求！");
			if(ebList.size()==0)
				this.addActionError("估价分区数据不符合导入要求！");
		}catch(Exception ex){
			ex.printStackTrace();
			this.addActionError("数据不符合导入要求："+ex.getMessage());
		}
	}
	
	/**
	 * 标准房价格数据导入
	 * @return
	 * @throws Exception
	 */
	public String importFile() throws Exception {
		ExcelBean eBean = new ExcelBean();
		try{
			eBean = t00351Service.ImportExcelData(ebList);
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
				ByteArrayOutputStream out = (ByteArrayOutputStream) Excel.exportCommonData(eBean.getOutExcelList(),3);
				excelStream = new ByteArrayInputStream(out.toByteArray());
				fileName=new String("格式错误的标准房价格数据.xls".getBytes("GBK"),"ISO-8859-1"); 
				return "failexport";
			}
			/*
			else if (tmpV00351.getOutFlag()==1)
				this.addActionMessage("数据导入执行完毕，但导入过程中部分失败！");
			else 
				this.addActionError("数据导入失败！");
			*/
		}
		return SUCCESS;
	}

	/**
	 * 对[标准房价格数据]合法性进行检验
	 * @param list
	 * @return
	 */
	private Boolean checkDateList(ArrayList<ExcelBean> list){
		//TODO 处理保留 对[标准房价格数据]合法性进行检验
		return true;
	}
	
	
	
	
	
	
	/**
	 * 可测算标准房
	 */
	public String queryY()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("queryY() ********** start **********");
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		 txtCJAL ="100";
		 txtGPAL ="100";
		 txtYSF  ="100";
		 txtZJ   ="100";
		ReadInfo();
		
		if(LOG.isDebugEnabled()){
			LOG.debug("queryY() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 查找可测算标准房
	 */
	public String findY()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("findY() ********** start **********");
		}
		
		Pgv00351 v00351 = new Pgv00351();
		try{
			v00351.setPageIndex(pageIndex);
			v00351.setPageSize(getPageSize());
			v00351.setCd00352Xqdm(Common.trim(txtXQFind));
			v00351.setCd00001Szqy(ddlSZQYFind);
			v00351.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v00351.setCd00001Fwlx(Common.convertEncoding(txtFWLX));
			v00351.setMonthSet(Common.convertToInteger(txtCSYF));
			v00351.setIsYwjg(rdoYWJG);
			v00351.setXqnm(Common.getSearchLike(txtXQCX));
			
			tabList = t00351Service.findY(v00351);
			
			if(null!=tabList && tabList.size()>0){
				rowCount = tabList.get(0).getRecordCount();
			}else{
				rowCount = 0;
				pageIndex = 1;
			}
			ReadInfo();
			}catch (Exception e) {
				LOG.error(e.getMessage());
				this.addActionError(e.getMessage());
				return ERROR;
			}
		
		
		if(LOG.isDebugEnabled()){
			LOG.debug("findY() ********** end **********");
		}
		return SUCCESS;
	}
	
	
	
	/**
	 * 不可测算标准房
	 */
	public String queryN()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("queryN() ********** start **********");
		}
		
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		ReadInfo();
		
		if(LOG.isDebugEnabled()){
			LOG.debug("queryN() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 *查询不可测算标准房 	
	 */
	public String findN()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("findN() ********** start **********");
		}
		
		Pgv00351 v00351 = new Pgv00351();
		try{
			v00351.setPageIndex(pageIndex);
			v00351.setPageSize(getPageSize());
			v00351.setCd00352Xqdm(Common.trim(txtXQFind));
			v00351.setCd00001Szqy(ddlSZQYFind);
			v00351.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v00351.setCd00001Fwlx(Common.convertEncoding(txtFWLX));
			v00351.setMonthSet(Common.convertToInteger(txtCSYF));
			v00351.setBzfjg(Common.convertToInteger(txtYWJG));
			v00351.setZcdzl(Common.getSearchLike(txtZCDZL));
			tabList = t00351Service.findN(v00351);
			
			if(null!=tabList && tabList.size()>0){
				rowCount = tabList.get(0).getRecordCount();
			}else{
				rowCount = 0;
				pageIndex = 1;
			}
			ReadInfo();
			}catch (Exception e) {
		        LOG.error(e.getMessage());
				this.addActionError(e.getMessage());
				return ERROR;
			}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("findN() ********** end **********");
		}
		return SUCCESS;
	}
	
/**************************************   信息导出     *********************************************/
	
	/**
	 * 信息导出（可测算标准房）
	 */
	public String exportY()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("exportY() ********** start **********");
		}
		Pgv00351 v00351 = new Pgv00351();
		try{
			v00351.setPageIndex(1);
			v00351.setPageSize(-1);
			v00351.setCd00352Xqdm(Common.trim(txtXQFind));
			v00351.setCd00001Szqy(ddlSZQYFind);
			v00351.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v00351.setCd00001Fwlx(Common.convertEncoding(txtFWLX));
			v00351.setMonthSet(Common.convertToInteger(txtCSYF));
			v00351.setIsYwjg(rdoYWJG);
			v00351.setXqnm(Common.getSearchLike(txtXQCX));
			ByteArrayOutputStream out = (ByteArrayOutputStream)t00351Service.ExportCSY(v00351);
			setExcelStream(new ByteArrayInputStream(out.toByteArray()));
			}catch(Exception e){
				LOG.error(e.getMessage());
				if(LOG.isDebugEnabled()){
					LOG.debug("exportY() ********** end **********");
				}
				userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
				return INPUT;
			}
		if(LOG.isDebugEnabled()){
			LOG.debug("exportY() ********** end **********");
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		return SUCCESS;
	}
	
	/**
	 * 信息导出（不可测算标准房）
	 */
	public String exportN()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("exportN() ********** start **********");
		}
		Pgv00351 v00351 = new Pgv00351();
		try{
			v00351.setPageIndex(1);
			v00351.setPageSize(-1);
			v00351.setCd00352Xqdm("");
			v00351.setZcdzl(txtXQNME);
			v00351.setCd00001Szqy(Common.convertEncoding(ddlSZQYFind));
			v00351.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v00351.setCd00001Fwlx(Common.convertEncoding(txtFWLX));
			v00351.setBzfjg(Common.convertToInteger(txtBZFJG));
			v00351.setMonthSet(Common.convertToInteger(txtCSYFE));
			v00351.setCd00002Czr(sessionCtrl.getUserId());
			ByteArrayOutputStream out = (ByteArrayOutputStream)t00351Service.ExportCSN(v00351);
			setExcelStream(new ByteArrayInputStream(out.toByteArray()));
			}catch(Exception e){
				LOG.error(e.getMessage());
				if(LOG.isDebugEnabled()){
					LOG.debug("exportN() ********** end **********");
				}
				userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
				return INPUT;
			}
		if(LOG.isDebugEnabled()){
			LOG.debug("exportN() ********** end **********");
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		return SUCCESS;
	}	
	
	
	/**
	 * 测算前的验证
	 */
	public void validateExecuteCS(){
		if(LOG.isDebugEnabled()){
			LOG.debug("validateExecuteCS() ********** start **********");
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		szqyList = sessionCtrl.ReadSzqyList();
		this.clearErrorsAndMessages();
		chkSell = chkSelTemp.split(",");
		if("1".equals(hidFlag) && (null==chkSell || chkSell.length<1))
			this.addActionError("请选择要参与测算的数据");
		if(LOG.isDebugEnabled()){
			LOG.debug("validateExecuteCS() ********** end **********");
		}
	}
	
	
	/**
	 * 选择测算
	 * @return 
	 * @throws Exception
	 */
	public String executeCS()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("executeCS() ********** start **********");
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		Pgv00351 v00351 = new Pgv00351();
		Integer cswCount = 0;
		Integer csCount = 0;
		Integer csTotal = 0;
		try{
			processMsg = "数据测算";
			switch(Common.convertToInteger(hidFlag)){
			case 1:
				csTotal = chkSell.length;
				for(Integer i = 0;i < csTotal;i++){
					try{
						
						v00351.setSlid(chkSell[i]);
						v00351.setCjal(txtCJAL);
						v00351.setGpal(txtGPAL);
						v00351.setYsf(txtYSF);
						v00351.setZj(txtZJ);
						v00351.setJysj(Common.convertStringToDate(Common.trim(txtCSJYSJ)));
						v00351.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
						v00351.setMonthSet(Common.convertToInteger(txtMONTHFind));
						if(t00351Service.GetExecCS(v00351)){
							csCount++;
						}else{
							cswCount++;
						}
					}catch (Exception e2) {
						LOG.error("executeCS()", e2);
					}
					processCent = i * 100 / chkSell.length;
					
				}
				break;
				
			case 2:
				v00351.setPageIndex(1);
				v00351.setPageSize(-1);
				v00351.setCd00352Xqdm(Common.trim(txtXQFind));
				v00351.setCd00001Szqy(ddlSZQYCS);
				v00351.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
				v00351.setCd00001Fwlx(txtFWLXCS);
				v00351.setMonthSet(Common.convertToInteger(txtMONTHFind));
				v00351.setIsYwjg((Common.convertToInteger(txtYWJG)));
				v00351.setZcdzl(Common.getSearchLike(txtZCDZL));
				
				// 执行查询
				tabList = t00351Service.findY(v00351);
				csTotal = tabList.size();
				for(Integer i = 0;i < csTotal;i++){
					try{
						v00351.setSlid(tabList.get(i).getSlid());
						v00351.setJysj(Common.convertStringToDate(Common.trim(txtCSJYSJ)));
						//v00351.setCd00002Czr(tabList.get(i).getCd00002Czr());
						v00351.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
						v00351.setCjal(txtCJAL);
						v00351.setGpal(txtGPAL);
						v00351.setYsf(txtYSF);
						v00351.setZj(txtZJ);
						if(t00351Service.GetExecCS(v00351)){
							csCount++;
						}else{
							cswCount++;
						}
					}catch (Exception e2) {
						LOG.error("executeCS()", e2);
					}
					processCent = i * 100 / tabList.size();
				}
				break;
			default:
				break;
			}
		}catch (Exception e) {
			LOG.error("executeCS()", e);
			this.addActionError(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("executeCS() ********** end **********");
			}
			
			return INPUT;
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("executeCS() ********** end **********");
		}
		
		processMsg = "测算执行完毕[共" + csTotal + "条数据，" + csCount + "条参与测算，其中"+cswCount+"条未通过]";
		return SUCCESS;
	}
	
	
	/*********************** setter and getter ******************************/

	/**
	 * @return the t00351Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt00351Service getT00351Service() {
		return t00351Service;
	}
	/**
	 * @param t00351Service the t00351Service to set
	 */
	public void setT00351Service(IPgt00351Service t00351Service) {
		this.t00351Service = t00351Service;
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
	 * @return the t00351eService
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt00351eService getT00351eService() {
		return t00351eService;
	}
	/**
	 * @param t00351eService the t00351eService to set
	 */
	public void setT00351eService(IPgt00351eService t00351eService) {
		this.t00351eService = t00351eService;
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
	public ArrayList<Pgv00351> getTabList() {
		return tabList;
	}
	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv00351> tabList) {
		this.tabList = tabList;
	}
	/**
	 * @return the v00351Bean
	 */
	public Pgv00351 getV00351Bean() {
		return v00351Bean;
	}
	/**
	 * @param v00351Bean the v00351Bean to set
	 */
	public void setV00351Bean(Pgv00351 v00351Bean) {
		this.v00351Bean = v00351Bean;
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
	public Pgt00351 gettBean() {
		return tBean;
	}
	/**
	 * @param tBean the tBean to set
	 */
	public void settBean(Pgt00351 tBean) {
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
	 * @return the txtPFMJG
	 */
	public Double getTxtPFMJG() {
		return txtPFMJG;
	}
	/**
	 * @param txtPFMJG the txtPFMJG to set
	 */
	public void setTxtPFMJG(Double txtPFMJG) {
		this.txtPFMJG = txtPFMJG;
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
	 * @return the txtNOTET00351
	 */
	public String getTxtNOTET00351() {
		return txtNOTET00351;
	}
	/**
	 * @param txtNOTET00351 the txtNOTET00351 to set
	 */
	public void setTxtNOTET00351(String txtNOTET00351) {
		this.txtNOTET00351 = txtNOTET00351;
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
	public ArrayList<Pgv00351e> getQtxzList() {
		return qtxzList;
	}
	/**
	 * @param qtxzList the qtxzList to set
	 */
	public void setQtxzList(ArrayList<Pgv00351e> qtxzList) {
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
	 * @return the jYSJ
	 */
	public String getJYSJ() {
		return JYSJ;
	}
	/**
	 * @param jYSJ the jYSJ to set
	 */
	public void setJYSJ(String jYSJ) {
		JYSJ = jYSJ;
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
	 * @return the zCDZS
	 */
	public String getZCDZS() {
		return ZCDZS;
	}

	/**
	 * @param zCDZS the zCDZS to set
	 */
	public void setZCDZS(String zCDZS) {
		ZCDZS = zCDZS;
	}

	/**
	 * @return the zCDZD
	 */
	public String getZCDZD() {
		return ZCDZD;
	}

	/**
	 * @param zCDZD the zCDZD to set
	 */
	public void setZCDZD(String zCDZD) {
		ZCDZD = zCDZD;
	}

	/**
	 * @return the zCDZL
	 */
	public String getZCDZL() {
		return ZCDZL;
	}

	/**
	 * @param zCDZL the zCDZL to set
	 */
	public void setZCDZL(String zCDZL) {
		ZCDZL = zCDZL;
	}

	/**
	 * @return the zCDZM
	 */
	public String getZCDZM() {
		return ZCDZM;
	}

	/**
	 * @param zCDZM the zCDZM to set
	 */
	public void setZCDZM(String zCDZM) {
		ZCDZM = zCDZM;
	}

	/**
	 * @param txtHXJG the txtHXJG to set
	 */
	public void setTxtHXJG(String txtHXJG) {
		this.txtHXJG = txtHXJG;
	}

	/**
	 * @return the txtHXJG
	 */
	public String getTxtHXJG() {
		return txtHXJG;
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
	 * @return the fROM
	 */
	public String getFROM() {
		return FROM;
	}

	/**
	 * @param fROM the fROM to set
	 */
	public void setFROM(String fROM) {
		FROM = fROM;
	}

	/**
	 * @return the createSum
	 */
	public Integer getCreateSum() {
		return createSum;
	}

	/**
	 * @param createSum the createSum to set
	 */
	public void setCreateSum(Integer createSum) {
		this.createSum = createSum;
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
	 * @return the pgv00351List
	 */
	public ArrayList<Pgv00351> getPgv00351List() {
		return Pgv00351List;
	}

	/**
	 * @param pgv00351List the pgv00351List to set
	 */
	public void setPgv00351List(ArrayList<Pgv00351> pgv00351List) {
		Pgv00351List = pgv00351List;
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
	 * @return the t00351aService
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt00351aService getT00351aService() {
		return t00351aService;
	}

	/**
	 * @param t00351aService the t00351aService to set
	 */
	public void setT00351aService(IPgt00351aService t00351aService) {
		this.t00351aService = t00351aService;
	}
	public String getDdlSZQY() {
		return ddlSZQY;
	}

	public void setDdlSZQY(String ddlSZQY) {
		this.ddlSZQY = ddlSZQY;
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
		public String getChkSel() {
		return chkSel;
	}

	public void setChkSel(String chkSel) {
		this.chkSel = chkSel;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageSize() {
		return Common.getPageSize(pageSize);
	}

	/**
	 * @return the tabListA
	 */
	public ArrayList<Pgv00351a> getTabListA() {
		return tabListA;
	}

	/**
	 * @param tabListA the tabListA to set
	 */
	public void setTabListA(ArrayList<Pgv00351a> tabListA) {
		this.tabListA = tabListA;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getTxtCSYF() {
		return txtCSYF;
	}

	public void setTxtCSYF(String txtCSYF) {
		this.txtCSYF = txtCSYF;
	}

	public String getTxtYWJG() {
		return txtYWJG;
	}

	public void setTxtYWJG(String txtYWJG) {
		this.txtYWJG = txtYWJG;
	}

	public String getTxtXQNME() {
		return txtXQNME;
	}

	public void setTxtXQNME(String txtXQNME) {
		this.txtXQNME = txtXQNME;
	}

	public String getTxtBZFJG() {
		return txtBZFJG;
	}

	public void setTxtBZFJG(String txtBZFJG) {
		this.txtBZFJG = txtBZFJG;
	}

	public String getTxtCSYFE() {
		return txtCSYFE;
	}

	public void setTxtCSYFE(String txtCSYFE) {
		this.txtCSYFE = txtCSYFE;
	}

	public String getChkSelTemp() {
		return chkSelTemp;
	}

	public void setChkSelTemp(String chkSelTemp) {
		this.chkSelTemp = chkSelTemp;
	}

	public String[] getChkSell() {
		return chkSell;
	}

	public void setChkSell(String[] chkSell) {
		this.chkSell = chkSell;
	}

	public String getHidFlag() {
		return hidFlag;
	}

	public void setHidFlag(String hidFlag) {
		this.hidFlag = hidFlag;
	}

	public String getProcessMsg() {
		return processMsg;
	}

	public void setProcessMsg(String processMsg) {
		this.processMsg = processMsg;
	}

	public Integer getProcessCent() {
		return processCent;
	}

	public void setProcessCent(Integer processCent) {
		this.processCent = processCent;
	}

	public String getTxtCSJYSJ() {
		return txtCSJYSJ;
	}

	public void setTxtCSJYSJ(String txtCSJYSJ) {
		this.txtCSJYSJ = txtCSJYSJ;
	}

	public String getTxtMONTHFind() {
		return txtMONTHFind;
	}

	public void setTxtMONTHFind(String txtMONTHFind) {
		this.txtMONTHFind = txtMONTHFind;
	}

	public String getTxtFWLXCS() {
		return txtFWLXCS;
	}

	public void setTxtFWLXCS(String txtFWLXCS) {
		this.txtFWLXCS = txtFWLXCS;
	}

	public String getDdlSZQYCS() {
		return ddlSZQYCS;
	}

	public void setDdlSZQYCS(String ddlSZQYCS) {
		this.ddlSZQYCS = ddlSZQYCS;
	}

	public String getTxtJCNF() {
		return txtJCNF;
	}

	public void setTxtJCNF(String txtJCNF) {
		this.txtJCNF = txtJCNF;
	}

	public String getTxtJYSJFind() {
		return txtJYSJFind;
	}

	public void setTxtJYSJFind(String txtJYSJFind) {
		this.txtJYSJFind = txtJYSJFind;
	}

	/**
	 * @return the txtXQCX
	 */
	public String getTxtXQCX() {
		return txtXQCX;
	}

	/**
	 * @param txtXQCX the txtXQCX to set
	 */
	public void setTxtXQCX(String txtXQCX) {
		this.txtXQCX = txtXQCX;
	}

	/**
	 * @return the rdoYWJG
	 */
	public Integer getRdoYWJG() {
		return rdoYWJG;
	}

	/**
	 * @param rdoYWJG the rdoYWJG to set
	 */
	public void setRdoYWJG(Integer rdoYWJG) {
		this.rdoYWJG = rdoYWJG;
	}

	public String getTxtCJAL() {
		return txtCJAL;
	}

	public void setTxtCJAL(String txtCJAL) {
		this.txtCJAL = txtCJAL;
	}

	public String getTxtGPAL() {
		return txtGPAL;
	}

	public void setTxtGPAL(String txtGPAL) {
		this.txtGPAL = txtGPAL;
	}

	public String getTxtYSF() {
		return txtYSF;
	}

	public void setTxtYSF(String txtYSF) {
		this.txtYSF = txtYSF;
	}

	public String getTxtZJ() {
		return txtZJ;
	}

	public void setTxtZJ(String txtZJ) {
		this.txtZJ = txtZJ;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl = new SessionCtrl(arg0);
	}

	public String getTxtFale() {
		return txtFale;
	}

	public void setTxtFale(String txtFale) {
		this.txtFale = txtFale;
	}

}
