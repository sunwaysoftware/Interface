package com.sunway.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00001Service;
import com.sunway.service.IPgt02061Service;
import com.sunway.service.IPgt02061aService;
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
import com.sunway.vo.Pgt02061;
import com.sunway.vo.Pgt02061a;
import com.sunway.vo.Pgv00001;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv02061;
import com.sunway.vo.Pgv02061a;
import com.sunway.vo.Pgv02061e;

/**
 * 
 * 市场法标准实例库
 * 
 * @category 系统维护
 * @author Lei create
 * @author Andy.Gao fix
 * @version 1.0
 * 
 */
public class Pgt02061Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -3484149190551472203L;
	// Service
	private IPgt02061Service t02061Service;
	private IPgt02061aService t02061aService;
	private IPgt00001Service t00001Service;
	// View
	private ArrayList<Pgv00052> szqyList;
	// 分页参数
	private Integer pageSize;
	private Integer pageIndex;
	private Integer total;
	// Bean数组
	private ArrayList<Pgv02061> rows;
	private ArrayList<Pgv02061> fwlxList;
	private ArrayList<Pgv00001> fwlxListBox;
	private Pgv02061 v02061Bean;
	private ArrayList<Pgv02061a> v0035a1Bean;
	// 检索条件
	private String txtXQFind;
	private String ddlSZQYFind;
	private String txtSLIDFind;
	private String txtMONTHFind;
	private String ddlSZQY;
	// private String txtCSSJFind;
	private String txtKBSLKJYSJS;
	private String txtKBSLKJYSJE;

	// 编辑操作符
	private String ACT;
	private String ACTT;
	private String SRC;
	private String csAllTimeLock; // 设置全部测算时间规定
	// primary key 主键
	private String SLID;
	// edit页面所需Bean
	private Pgt02061 bean;
	// edit页面提交数据
	private String txtUPDATE;
	private String txtLFID;
	private String txtFWLX;
	private String txtJYLX;
	private String txtJZJGT;
	private String txtFWCX;
	private String txtCGZK;
	private Short txtSZLC;
	private String txtPFMJG;
	private String txtJYSJ;
	private String txtNOTET02061;
	private String txtJZJG;
	private String rdoYWDT;
	private Short txtZLC;
	private String txtNOTE;
	private ArrayList<Pgv02061e> qtxzList;
	private String XZLX;
	private String hidQTXZ;
	private String txtXQDM;
	private String SZQY;
	private String JYSJ;
	private String ZCDZS;
	private String ZCDZD;
	private String ZCDZL;
	private String ZCDZM;
	private SessionCtrl sessionCtrl=new SessionCtrl();
	private String txtZCDZL;
	private String txtHXJG;
	private String txtJTZKId;
	private String txtWYZKId;
	private String txtZXZKId;
	// 生产标准房个数
	private Integer createSum;
	// 该字段为封装审核状态
	private String FROM;
	// 标准房查询标志
	private String CX;

	// file upload
	private String title;
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private String savePath;
	private String fileServerPath;
	// file import
	private String txtFilePath;
	private ArrayList<Pgv02061> Pgv02061List;
	private ArrayList<ExcelBean> ebList;
	private InputStream excelStream;
	private String fileName;

	private String txtQH;
	private String txtDH;
	private String txtQDH;
	private String txtZH;
	private String txtBWJFH;

	private String userRole;

	private String hidFlag;
	private String[] chkSel;

	
	private String processMsg;
	private Integer processCent;
	private String txtCSJYSJ;

	private String ASZQY;
	private String AXQNM;
	private String AXQDM;
	// 估价待办
	private String XQNM;
	private String FWLX;
	private String FWLXNM;

	private String BZFSIGN;

	private String sign;
	private String QYXZ;
	private String XQGLSIGN;

	// private String txtCSYF;
	private String txtKBSLKIMPS;
	private String txtKBSLKIMPE;
	private String BZFJG;

	// 导出条件
	private String txtBZFJG;

	// 查询条件
	private String txtYWJG;
	private String chkSelTemp;

	private String ddlFWLX;
	private String txtXQCX;

	private String chkDel;
	private String msgDel;
	private String txtJCSJ;

	// 筛选删除
	private String resMsg;
	private String resSign;
	private String txtXQDMD;
	private String txtZCDZLD;
	private String txtSZQYD;
	private String txtSLIDD;
	private String txtFWLXD;
	private String txtISPQD;
	private String txtQDHD;
	private String txtISJYJG;

	// 时间判断“生成标准房”按钮标识
	private boolean btnFlag;
	private String cd02050Xqdm;
	private String cd00001Szqy;
	private String cd00001Ssgx;
	private String slid;
	private String cd00001Fwlx;
	private Date month;
	private String SFSC;


	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** start **********");
		}

		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		ReadInfo();
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

		Pgv02061 v02061 = new Pgv02061();
		try {
			// 准备查询条件
			v02061.setCd00001Szqy(ddlSZQYFind);
			v02061.setCd02050Xqdm(CheckUtil.chkTrim(txtXQFind));
			v02061.setXqnm(FormatUtil.toSearchLike(txtXQCX));
			v02061.setCd00001Fwlx(ConvertUtil.encoding(txtFWLX));
			v02061.setJysjMonth(txtMONTHFind);
			v02061.setPageIndex(pageIndex);
			v02061.setPageSize(getPageSize());
			v02061.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v02061.setQyxz(QYXZ);

			v02061.setBzfjg(ConvertUtil.toInteger(BZFJG));
			v02061.setSfsc(ConvertUtil.toInteger(SFSC));
			
			// 执行查询
			rows = t02061Service.LoadAll(v02061);
			// 分页设置
			// 分页设置
			if (null != rows && rows.size() > 0) {
				total = rows.get(0).getRecordCount();
			} else {
				total = 0;
				pageIndex = 1;
			}
			ReadInfo();
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
	 * 
	 * @return
	 * @throws Exception
	 */
	public String create() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** start **********");
		}

		Pgt02061 t02061 = new Pgt02061();
		bean = new Pgt02061();
		String rtn = SUCCESS;
		try {
			if (!Constant.MOD_CREATE.equals(getACT())) {
				// 取得用户选中的数据信息
				t02061.setSlid(SLID);
				bean = t02061Service.LoadByPrimaryKey(t02061);	
			} else {				
				bean.setZcdzl(ConvertUtil.encoding(ZCDZL));
				bean.setJysj(ConvertUtil.toUtilDate(JYSJ));
				bean.setCd00001Fwlx(FWLX);
				bean.setFwlxsc(ConvertUtil.encoding(FWLXNM));
			}
			ReadInfo();
			if (Constant.MOD_CREATE.equals(getACT())) {
				rtn = "successADD";
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

		bean = new Pgt02061();
		this.clearErrorsAndMessages();
		bean.setSlid(SLID);
		// 根据PK取得信息，并为BEAN赋值
		if (Constant.MOD_UPDATE.equals(getACT())) {
			bean = t02061Service.LoadByPrimaryKey(bean);
		}
		// 判读数据是否已经被其他用户修改
		if ((Constant.MOD_UPDATE.equals(getACT()))
				&& (!bean.getUpddate().equals(
						ConvertUtil.toTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		} else {
			bean.setSlid(SLID);
			bean.setCd00001Fwlx(txtFWLX);
			bean.setSfsc(ConvertUtil.toInteger(SFSC));
			// bean.setCd00001Jylx(txtJYLX);
			// bean.setCd00001Jzjg(txtJZJGT);
			// bean.setCd00001Cgzk(txtCGZK);
			// bean.setSzlc(txtSZLC);
			bean.setJysj(ConvertUtil.toUtilDate(txtJYSJ));
			bean.setPfmjg(ConvertUtil.toDouble(txtPFMJG));
			bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			bean.setNote(txtNOTET02061);
			bean.setCd02050Xqdm(txtXQDM);
			// bean.setCd00001Jzjg1(txtJZJG);
			// bean.setYwdt(rdoYWDT);
			// bean.setZlc(txtZLC);
			// bean.setZcdzl(txtZCDZL);
			// bean.setCd00001Jtzk(txtJTZKId);
			// bean.setCd00001Wyzk(txtWYZKId);
			// bean.setCd00001Zxzk(txtZXZKId);
			// bean.setNote1(txtNOTE);
			// bean.setHxjg(txtHXJG);
			// bean.setCd00053Qtxzid(hidQTXZ);
			bean.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			bean.setZhxz(hidQTXZ);
			bean.setJcsj(txtJCSJ);

			// bean.setBwjfh(txtBWJFH);
			// bean.setQdh(txtQDH);
			// bean.setZh(txtZH);
			// bean.setCd00001Fqwz(txtFQWZ);
			// bean.setCd00001Dywz(txtDYWZ);
			// bean.setCd00001Fwcx(txtFWCX);
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
		if (getACTT() == "OK") {
		}
		if (!"U".equals(getACT())) {
			if (!BZFSIGN.equals("") && BZFSIGN != null) {
				if (BZFSIGN.equals("GL")) {
					rtn = "successGL";
				}
			}
		}

		try {
			if (Constant.MOD_CREATE.equals(getACT())) { // Create
				if (t02061Service.GetInsertCommand(bean)) {
					this.addActionMessage(getText(Constant.MSG_CREATE_OK,
							new String[] { getText("app.xtwh.t00361.cs") }));
				} else {
					this.addActionError(getText(Constant.MSG_CREATE_NG,
							new String[] { getText("app.xtwh.t00361.cs") }));
				}
			} else if (Constant.MOD_UPDATE.equals(getACT())) { // Update
				if (t02061Service.GetUpdateCommand(bean)) {
					bean = t02061Service.LoadByPrimaryKey(bean);
//					Pgt00303 t00303 = new Pgt00303();
//					t00303.setLfid(bean.getCd00303Lfid());
//					t00303Bean = t00303Service.LoadByPrimaryKey(t00303);
					ReadInfo();
					rtn = "successEDIT";
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK,
							new String[] { bean.getSlid() }));
				} else {
					this.addActionError(getText(Constant.MSG_UPDATE_NG,
							new String[] { bean.getSlid() }));
				}
			} else if (Constant.MOD_DELETE.equals(getACT())) { // Delete
				if (t02061Service.GetDeleteCommand(bean)) {
					this.addActionMessage(getText(Constant.MSG_DELETE_OK,
							new String[] { bean.getSlid() }));
					rtn = "successDEL";
					if (!BZFSIGN.equals("") && BZFSIGN != null) {
						if (BZFSIGN.equals("GL")) {
							rtn = "successGLDEL";
						}
					}

				} else {
					this.addActionError(getText(Constant.MSG_DELETE_NG,
							new String[] { bean.getSlid() }));
				}
			}
			ReadInfo();
		} catch (Exception e) {
			e.printStackTrace();
			String[] msg = e.getMessage().split("\n");
			this.addActionError(msg[0]);
			if (LOG.isDebugEnabled()) {
				LOG.debug("update() ********** end **********");
			}
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
			if (!BZFSIGN.equals("") && BZFSIGN != null) {
				if (BZFSIGN.equals("GL")) {
					return "inputGL";
				}
			}

			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** end **********");
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		return rtn;
	}

	/**
	 * 选择删除
	 * 
	 * @return
	 * @throws Exception
	 */
	public String delSel() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("delSel() ********** start **********");
		}
		this.clearErrorsAndMessages();
		try {
			Pgt02061 t02061 = new Pgt02061();
			t02061.setChkSel(chkDel);
			t02061.setCd00002Czr(sessionCtrl.getUserId());
			t02061.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if (t02061Service.GetSelDeleteCommand(t02061)) {
				msgDel = "删除成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
			msgDel = "删除失败：" + e.getMessage();
			if (LOG.isDebugEnabled()) {
				LOG.debug("delSel() ********** end **********");
			}
			return SUCCESS;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("delSel() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 详细信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String detail() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** start **********");
		}
		Pgv02061 v02061 = new Pgv02061();
		v02061Bean = new Pgv02061();
		Pgv02061a v02061a = new Pgv02061a();
		try {
			// 准备查询条件
			v02061.setSlid(ConvertUtil.encoding(SLID));
			// 执行查询
			v02061a.setPageIndex(1);
			v02061a.setPageSize(-1);
			v02061a.setCd02061Slid(CheckUtil.chkTrim(SLID));
			v02061Bean = t02061Service.LoadDetail(v02061);
			v0035a1Bean = t02061aService.LoadAll(v02061a);
		} catch (Exception e) {
			e.printStackTrace();
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
	 * 
	 * @return
	 * @throws Exception
	 */
	public String detailGS() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("detailGS() ********** start **********");
		}
		// Pgv02061 v02061 = new Pgv02061();
		Pgt02061a t02061a = new Pgt02061a();
		Pgv02061a v02061a = new Pgv02061a();
		v02061Bean = new Pgv02061();
		try {
			// 准备查询条件
			t02061a.setSlid(ConvertUtil.encoding(SLID));
			v02061Bean = t02061aService.LoadBySlid(t02061a);
			v02061a.setCd02061Slid(CheckUtil.chkTrim(SLID));
			v02061a.setPageIndex(1);
			v02061a.setPageSize(-1);
			v0035a1Bean = t02061aService.LoadAll(v02061a);
			// v02061.setSlid(t02061a.getCd02061Slid());
			// 执行查询
			// v02061Bean = t02061Service.LoadDetail(v02061);
		} catch (Exception e) {
			e.printStackTrace();
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
	 * 
	 * @throws Exception
	 */
	private void ReadInfo() throws Exception {
		// 取得所在区域列表信息
		szqyList = sessionCtrl.ReadSzqyList();
	}

	/**
	 * 生成标准房（虚拟）
	 * 
	 * @return
	 * @throws Exception
	 */
	public String createBzf() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("createBzf() ********** start **********");
		}
		Pgt02061 t02061 = new Pgt02061();
		try {
			// 准备查询条件
			t02061.setCd00001Szqy(ConvertUtil.encoding(ddlSZQYFind));
			t02061.setCd02050Xqdm(ConvertUtil.encoding(txtXQDM));
			// t02061.setCd00001Fwlx(ConvertUtil.encoding(txtFWLX));
			t02061.setCd00002Czr(sessionCtrl
					.Get(SessionCtrl.SESSION_KEY_USERID));
			t02061.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			// 执行查询
			createSum = t02061Service.CreateBZF(t02061);
		} catch (Exception e) {
			 e.printStackTrace();
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
	 * 
	 * @return
	 * @throws Exception
	 */
	public String importBzf() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("importBzf() ********** start **********");
		}
		Pgt02061 t02061 = new Pgt02061();
		try {
			// 准备查询条件
			t02061.setCd00001Szqy(ConvertUtil.encoding(ddlSZQYFind));
			t02061.setCd02050Xqdm(ConvertUtil.encoding(txtXQDM));
			// t02061.setCd00001Fwlx(ConvertUtil.encoding(txtFWLX));
			t02061.setCd00002Czr(sessionCtrl
					.Get(SessionCtrl.SESSION_KEY_USERID));
			t02061.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			// 执行查询
			createSum = t02061Service.ImportBZF(t02061);
		} catch (Exception e) {
			 e.printStackTrace();
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
	 * 
	 * @return
	 * @throws Exception
	 */
	public String upload() throws Exception {
		try {
			String fileName = sessionCtrl.getUserId()
					+ "_BZF"
					+ getUploadFileName().substring(
							getUploadFileName().lastIndexOf("."));

			// fileServerPath = getSavePath() + "\\" + getUploadFileName();
			fileServerPath = getSavePath() + "\\" + fileName;
			// 记录上传数据的位置
			Common.addUploadFiles(fileServerPath);
			FileUtil.copyFile(fileServerPath, getUpload());
			
		} catch (Exception ex) {
			ex.printStackTrace();
			
			return INPUT;
		} 
		return SUCCESS;
	}

	/**
	 * 导入校验
	 */
	public void validateImportFile() {
		if (!FileUtil.checkFileExist(txtFilePath)) {
			this.addActionError("文件错误，请检查！");
		}
		try {
			ReadInfo();
			// 检验数据合法性
			ebList = Excel.resolveExcelSYSCF(txtFilePath, sessionCtrl.getUserId(),
					sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX),ConvertUtil.toInteger(SFSC));
			if (!checkDateList(ebList))
				this.addActionError("估价分区数据不符合导入要求！");
			if (ebList.size() == 0)
				this.addActionError("估价分区数据不符合导入要求！");
		} catch (Exception ex) {
			ex.printStackTrace();
			this.addActionError(ex.getMessage().replace("\n", "<br />"));
		}
	}

	/**
	 * 标准房价格数据导入
	 * 
	 * @return
	 * @throws Exception
	 */
	public String importFile() throws Exception {
		ExcelBean eBean = null;
		try {
			eBean = t02061Service.ImportExcelData(ebList);
		} catch (Exception ex) {
			ex.printStackTrace();
			this.addActionError(ex.getMessage());
			return INPUT;
		} finally {
			if (null!=eBean && eBean.getExportOutCome() == 2)
				this.addActionMessage("数据导入成功！");
			else {
				ByteArrayOutputStream out = (ByteArrayOutputStream) Excel
						.exportCommonDataSYSCF(eBean.getOutExcelList(), 3,ConvertUtil.toInteger(SFSC));
				excelStream = new ByteArrayInputStream(out.toByteArray());
				fileName = new String("格式错误的标准房价格数据.xls".getBytes("GBK"),
						"ISO-8859-1");
				return "failexport";
			}
			/*
			 * else if (tmpV02061.getOutFlag()==1)
			 * this.addActionMessage("数据导入执行完毕，但导入过程中部分失败！"); else
			 * this.addActionError("数据导入失败！");
			 */
		}
		return SUCCESS;
	}

	/**
	 * 对[标准房价格数据]合法性进行检验
	 * 
	 * @param list
	 * @return
	 */
	private Boolean checkDateList(ArrayList<ExcelBean> list) {
		return true;
	}

	/**
	 * 数据导出
	 * 
	 * @return
	 * @throws Exception
	 */
	public String export() throws Exception {
		Pgv02061 v02061 = new Pgv02061();
		try {
			// 准备查询条件
			v02061.setPageIndex(1);
			v02061.setPageSize(-1);
			v02061.setCd02050Xqdm(CheckUtil.chkTrim(txtXQFind));
			v02061.setCd00001Szqy(ddlSZQYFind);
			v02061.setQyxz(QYXZ);
			v02061.setXqnm(txtXQCX);
			v02061.setQdh(txtQDH);
			v02061.setCd00001Fwlx(ConvertUtil.encoding(txtFWLX));
			v02061.setQyxz(QYXZ);//区域选择 1，片区； 0，小区
			v02061.setBzfjg(ConvertUtil.toInteger(BZFJG));//是否有标准房价格
			v02061.setSfsc(ConvertUtil.toInteger(SFSC));
			v02061.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v02061.setSlid(FormatUtil.toSearchLike(ConvertUtil.encoding(txtSLIDFind)));
			v02061.setJysjMonth(txtMONTHFind);
			v02061.setCd00002Czr(sessionCtrl.getUserId());
			

			if (!CheckUtil.chkEmpty(txtQH) && !CheckUtil.chkEmpty(txtDH)) {
				v02061.setQdh(txtQH + "-" + txtDH);
			}
			ByteArrayOutputStream out = (ByteArrayOutputStream) t02061Service
					.ExportDjxx(v02061);
			excelStream = new ByteArrayInputStream(out.toByteArray());
		} catch (Exception e) {
			 e.printStackTrace();
			this.addActionError(e.getMessage());
			return INPUT;
		}
		return SUCCESS;
	}

	/**
	 * 更新大区标准房价格
	 * 
	 * @return
	 * @throws Exception
	 */
	public String viewExecUpdateDQBZF() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("viewExecUpdateDQBZF() ********** start **********");
		}
		try {

		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("viewExecUpdateDQBZF() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("viewExecUpdateDQBZF() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 更新大区标准房价格
	 * 
	 * @return
	 * @throws Exception
	 */
	public String execUpdateDQBZF() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execUpdateDQBZF() ********** start **********");
		}
		try {
			Pgt02061 t02061 = new Pgt02061();
			t02061.setJysj(ConvertUtil.toUtilDate(txtJYSJ));
			t02061.setCd00002Czr(sessionCtrl
					.Get(SessionCtrl.SESSION_KEY_USERID));

			if (t02061Service.GetUpdateDQBZFCommand(t02061)) {
				this.addActionMessage("大区标准房价格更新成功！");
			} else {
				this.addActionError("大区标准房价格更新失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("execUpdateDQBZF() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("execUpdateDQBZF() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 标准房测算
	 * 
	 * @return
	 * @throws Exception
	 */
	public String executeBZFCS() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("executeBZFCS() ********** start **********");
		}

		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);

		if (LOG.isDebugEnabled()) {
			LOG.debug("executeBZFCS() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 可测算标准房
	 */
	@SuppressWarnings("deprecation")
	public String queryY() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("queryY() ********** start **********");
		}

		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		ReadInfo();

		setTxtKBSLKJYSJS(MakeUtil.preDate(new Date(), 2));
		setTxtKBSLKJYSJE(MakeUtil.currentDate());
		// 设置全部测算时间规定 早9点之前以及晚6点之后
		Date date = new Date();
		if (date.getHours() > 9 && date.getHours() < 17) {
			csAllTimeLock = "no";
		} else {
			csAllTimeLock = "yes";
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("queryY() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 查找可测算标准房
	 */
	public String findY() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("findY() ********** start **********");
		}

		Pgv02061 v02061 = new Pgv02061();
		try {
			v02061.setPageIndex(pageIndex);
			v02061.setPageSize(getPageSize());
			v02061.setCd02050Xqdm(CheckUtil.chkTrim(txtXQFind));
			v02061.setCd00001Szqy(ddlSZQYFind);
			v02061.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v02061.setCd00001Fwlx(ConvertUtil.encoding(txtFWLX));
			// v02061.setMonthSet(ConvertUtil.toInteger(txtCSYF));
			v02061.setKbslkJysjs(ConvertUtil.toTimestamp(txtKBSLKJYSJS));
			v02061.setKbslkJysje(ConvertUtil.toTimestamp(txtKBSLKJYSJE));
			v02061.setBzfjg(ConvertUtil.toInteger(txtYWJG));
			v02061.setXqnm(FormatUtil.toSearchLike(txtXQCX));
			// v02061.setCssj(ConvertUtil.toTimestamp(txtCSSJFind));
			v02061.setKbslkImps(ConvertUtil.toTimestamp(txtKBSLKIMPS));
			v02061.setKbslkImpe(ConvertUtil.toTimestamp(txtKBSLKIMPE));
			v02061.setSfsc(ConvertUtil.toInteger(SFSC));
			rows = t02061Service.findY(v02061);

			if (null != rows && rows.size() > 0) {
				total = rows.get(0).getRecordCount();
			} else {
				total = 0;
				pageIndex = 1;
			}
			ReadInfo();
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("findY() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 不可测算标准房
	 */
	public String queryN() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("queryN() ********** start **********");
		}

		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		ReadInfo();
		setTxtKBSLKJYSJS(MakeUtil.preDate(new Date(), 2));
		setTxtKBSLKJYSJE(MakeUtil.currentDate());
		if (LOG.isDebugEnabled()) {
			LOG.debug("queryN() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 查询不可测算标准房
	 */
	public String findN() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("findN() ********** start **********");
		}

		Pgv02061 v02061 = new Pgv02061();
		try {
			v02061.setPageIndex(pageIndex);
			v02061.setPageSize(getPageSize());
			v02061.setCd02050Xqdm(CheckUtil.chkTrim(txtXQFind));
			v02061.setCd00001Szqy(ddlSZQYFind);
			v02061.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v02061.setCd00001Fwlx(txtFWLX);
			v02061.setKbslkJysjs(ConvertUtil.toTimestamp(txtKBSLKJYSJS));
			v02061.setKbslkJysje(ConvertUtil.toTimestamp(txtKBSLKJYSJE));
			v02061.setBzfjg(ConvertUtil.toInteger(txtYWJG));
			v02061.setXqnm(FormatUtil.toSearchLike(txtZCDZL));
			v02061.setSfsc(ConvertUtil.toInteger(SFSC));
			rows = t02061Service.findN(v02061);

			if (null != rows && rows.size() > 0) {
				total = rows.get(0).getRecordCount();
			} else {
				total = 0;
				pageIndex = 1;
			}
			ReadInfo();
		} catch (Exception e) {
			 e.printStackTrace();
			this.addActionError(e.getMessage());
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("findN() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 测算前的验证
	 */
/*	public void validateExecuteCS() {
		if (LOG.isDebugEnabled()) {
			LOG.debug("validateExecuteCS() ********** start **********");
		}		

		this.clearErrorsAndMessages();
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("validateExecuteCS() ********** end **********");
		}
	}*/

	/**
	 * 选择测算
	 * 
	 * @return
	 * @throws Exception
	 */
	public String executeCS() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("executeCS() ********** start **********");
		}
		chkSel = chkSelTemp.split(",");
		if ("1".equals(hidFlag) && (null == chkSel || chkSel.length < 1))
		{
			this.addActionError("请选择要参与测算的数据");
			return INPUT;
		}
		
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		szqyList = sessionCtrl.ReadSzqyList();
		Pgv02061 v02061 = new Pgv02061();
		Integer cswCount = 0;
		Integer csCount = 0;
		Integer csTotal = 0;
		try {
			processMsg = "数据测算";
			switch (ConvertUtil.toInteger(hidFlag)) {
			case 1:
				csTotal = chkSel.length;
				for (Integer i = 0; i < csTotal; i++) {
					try {

						v02061.setSlid(chkSel[i]);
						v02061.setJysj(ConvertUtil.toUtilDate(CheckUtil.chkTrim(txtCSJYSJ)));
						v02061.setCd00002Czr(sessionCtrl
								.Get(SessionCtrl.SESSION_KEY_USERID));
						// v02061.setMonthSet(ConvertUtil.toInteger(txtMONTHFind));
						v02061.setJysjMin(ConvertUtil.toUtilDate(txtKBSLKJYSJS));
						v02061.setJysjMax(ConvertUtil.toUtilDate(txtKBSLKJYSJE));
						v02061.setKbslkImps(ConvertUtil.toTimestamp(txtKBSLKIMPS));
						v02061.setKbslkImpe(ConvertUtil.toTimestamp(txtKBSLKIMPE));
					//	v02061.setSfsc(SFSC);
						if (t02061Service.GetExecCS(v02061)) {
							csCount++;
						} else {
							cswCount++;
						}
					} catch (Exception e2) {
						 e2.printStackTrace();
						LOG.error("executeCS()", e2);
					}
					processCent = i * 100 / chkSel.length;

				}
				break;

			case 2:
				v02061.setPageIndex(1);
				v02061.setPageSize(-1);
				v02061.setCd02050Xqdm(CheckUtil.chkTrim(txtXQFind));
				v02061.setXqnm(FormatUtil.toSearchLike(txtXQCX));
				v02061.setCd00001Szqy(ddlSZQYFind);
				v02061.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
				v02061.setCd00001Fwlx(txtFWLX);
				// v02061.setMonthSet(ConvertUtil.toInteger(txtMONTHFind));
				v02061.setKbslkJysjs(ConvertUtil.toTimestamp(txtKBSLKJYSJS));
				v02061.setKbslkJysje(ConvertUtil.toTimestamp(txtKBSLKJYSJE));
				v02061.setJysjMin(ConvertUtil.toUtilDate(txtKBSLKJYSJS));
				v02061.setJysjMax(ConvertUtil.toUtilDate(txtKBSLKJYSJE));
				v02061.setKbslkImps(ConvertUtil.toTimestamp(txtKBSLKIMPS));
				v02061.setKbslkImpe(ConvertUtil.toTimestamp(txtKBSLKIMPE));
				v02061.setBzfjg(ConvertUtil.toInteger(txtYWJG));
				v02061.setSfsc(ConvertUtil.toInteger(SFSC));
				// 执行查询
				rows = t02061Service.findYbyID(v02061);
				csTotal = rows.size();
				for (Integer i = 0; i < csTotal; i++) {
					try {
						v02061.setSlid(rows.get(i).getSlid());
						v02061.setJysj(ConvertUtil.toUtilDate(CheckUtil.chkTrim(txtCSJYSJ)));
						v02061.setCd00002Czr(sessionCtrl
								.Get(SessionCtrl.SESSION_KEY_USERID));
						if (t02061Service.GetExecCS(v02061)) {
							csCount++;
						} else {
							cswCount++;
						}
					} catch (Exception e2) {
						 e2.printStackTrace();
						LOG.error("executeCS()", e2);
					}
					processCent = i * 100 / rows.size();
				}
				break;
			default:
				break;
			}
		} catch (Exception e) {
			 e.printStackTrace();
			LOG.error("executeCS()", e);
			this.addActionError(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("executeCS() ********** end **********");
			}

			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("executeCS() ********** end **********");
		}
		setTxtKBSLKJYSJS(MakeUtil.preDate(new Date(), 2));
		setTxtKBSLKJYSJE(MakeUtil.currentDate());
		processMsg = "测算执行完毕[共" + csTotal + "条数据，" + csCount + "条参与测算，其中"
				+ cswCount + "条未通过]";
		this.addActionMessage(processMsg);
		return SUCCESS;
	}

	/**
	 * 查询状态处理
	 * 
	 * @return
	 * @throws Exception
	 */
	public String queryFwlx() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("queryFwlx() ********** start **********");
		}

		Pgv02061 v02061 = new Pgv02061();
		try {
			v02061.setCd02050Xqdm(CheckUtil.chkTrim(txtXQFind));
			// 执行查询
			fwlxList = t02061Service.LoadAllFwlx(v02061);
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

	/************************************** 标准房管理 ***********************************/

	/**
	 * 标准房管理页面
	 */
	public String executeBZFGL() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("executeBZFGL() ********** start **********");
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("executeBZFGL() ********** end **********");
		}

		return "success";
	}

	/**
	 * 小区标准房管理
	 * 
	 * @return
	 * @throws Exception
	 */
	public String executeBZFGLXQ() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("executeBZFGLXQ() ********** start **********");
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("executeBZFGLXQ() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 查询小区标准房
	 * 
	 * @return
	 * @throws Exception
	 */
	public String queryBZFGLXQ() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("queryBZFGLXQ() ********** start **********");
		}
		Pgv02061 v02061 = new Pgv02061();
		try {
			// 准备查询条件
			v02061.setSlid(FormatUtil.toSearchLike(ConvertUtil.encoding(txtSLIDFind)));
			v02061.setCd00001Szqy(ddlSZQYFind);
			v02061.setCd02050Xqdm(CheckUtil.chkTrim(txtXQFind));
			v02061.setXqnm(FormatUtil.toSearchLike(ConvertUtil.encoding(txtZCDZL)));
			v02061.setCd00001Fwlx(txtFWLX);
			v02061.setJysjMonth(txtMONTHFind);
			v02061.setPageIndex(pageIndex);
			v02061.setPageSize(getPageSize());
			v02061.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v02061.setSfsc(ConvertUtil.toInteger(SFSC));
			if (!CheckUtil.chkEmpty(txtQH) && !CheckUtil.chkEmpty(txtDH)) {
				v02061.setQdh(txtQH + "-" + txtDH);
			}
			// 执行查询
			rows = t02061Service.LoadAllByBZFGLXQ(v02061);
			if (null != rows && rows.size() > 0) {
				total = rows.get(0).getRecordCount();
			} else {
				total = 0;
				pageIndex = 1;
			}
			ReadInfo();
		} catch (Exception e) {
			 e.printStackTrace();
			this.addActionError(e.getMessage());
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("queryBZFGLXQ() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 小区标准房添加页面
	 *//*
	public String createBZFGLXQ() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("createBZFGLXQ() ********** start **********");
		}

		Pgt02061 t02061 = new Pgt02061();
		bean = new Pgt02061();
		t00303Bean = new Pgt00303();
		String rtn = SUCCESS;
		try {
			if (!Constant.MOD_CREATE.equals(getACT())) {
				// 取得用户选中的数据信息
				t02061.setSlid(SLID);
				bean = t02061Service.LoadByPrimaryKey(t02061);
				Pgt00303 t00303 = new Pgt00303();
				t00303.setLfid(bean.getCd00303Lfid());
				t00303Bean = t00303Service.LoadByPrimaryKey(t00303);
				Pgv02061e v02061e = new Pgv02061e();
				v02061e.setCd02061Slid(bean.getSlid());
				qtxzList = t02061eService.LoadAll(v02061e);
			} else {
				v00303Bean = new Pgv00303();
				v00303Bean.setCd02050Xqdm(AXQDM);
				v00303Bean.setCd00001Szqy(ASZQY);
				v00303Bean.setXqnm(ConvertUtil.encoding(AXQNM));
				t00303Bean.setCd00001Szqy(ConvertUtil.encoding(SZQY));
				t00303Bean.setZcdzl(ConvertUtil.encoding(ZCDZL));
				bean.setZcdzl(ConvertUtil.encoding(ZCDZL));
				bean.setJysj(ConvertUtil.toUtilDate(JYSJ));
				bean.setCd00001Fwlx(FWLX);
				bean.setFwlxsc(ConvertUtil.encoding(FWLXNM));
			}
			ReadInfo();
			if (Constant.MOD_CREATE.equals(getACT())) {

				t02061.setSlid(SLID);
				bean = t02061Service.LoadByPrimaryKey(t02061);
				bean.setCd00001Fwlx("");
				bean.setFwlxsc("");
				Pgt00303 t00303 = new Pgt00303();
				t00303.setLfid(bean.getCd00303Lfid());
				t00303Bean = t00303Service.LoadByPrimaryKey(t00303);

				rtn = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("createBZFGLXQ() ********** end **********");
			}
			return ERROR;
		}
		sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		if (LOG.isDebugEnabled()) {
			LOG.debug("createBZFGLXQ() ********** end **********");
		}

		return rtn;

	}
*/
	/**
	 * 大区标准房管理
	 * 
	 * @return
	 * @throws Exception
	 */
	public String executeBZFGLDQ() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("executeBZFGLDQ() ********** start **********");
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("executeBZFGLDQ() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 查询大区标准房
	 */
	public String queryBZFGLDQ() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("queryBZFGLDQ() ********** start **********");
		}

		Pgv02061 v02061 = new Pgv02061();
		try {
			// 准备查询条件
			v02061.setSlid(FormatUtil.toSearchLike(ConvertUtil.encoding(txtSLIDFind)));
			v02061.setCd00001Szqy(ddlSZQYFind);
			v02061.setCd02050Xqdm(CheckUtil.chkTrim(txtXQFind));
			v02061.setXqnm(FormatUtil.toSearchLike(ConvertUtil.encoding(txtZCDZL)));
			v02061.setCd00001Fwlx(ConvertUtil.encoding(txtFWLX));
			v02061.setJysjMonth(txtMONTHFind);
			v02061.setPageIndex(pageIndex);
			v02061.setPageSize(getPageSize());
			v02061.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v02061.setSfsc(ConvertUtil.toInteger(SFSC));
			// 执行查询
			rows = t02061Service.LoadAllByBZFGLDQ(v02061);
			// 分页设置
			if (null != rows && rows.size() > 0) {
				total = rows.get(0).getRecordCount();
			} else {
				total = 0;
				pageIndex = 1;
			}
			ReadInfo();
		} catch (Exception e) {
			 e.printStackTrace();
			this.addActionError(e.getMessage());
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("queryBZFGLDQ() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 验证该类标准房是否存在
	 */
	public String valiBZF() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("valiBZF() ********** start **********");
		}

		Pgv02061 v02061 = new Pgv02061();
		try {
			v02061.setCd00001Fwlx(ConvertUtil.encoding(txtFWLX));
			v02061.setCd02050Xqdm(ConvertUtil.encoding(txtXQDM));
			v02061.setSfsc(ConvertUtil.toInteger(SFSC));
			if (t02061Service.ValiBZF(v02061)) {
				sign = "ok";
			} else {
				sign = "no";
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (LOG.isDebugEnabled()) {
				LOG.debug("valiBZF() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("valiBZF() ********** end **********");
		}
		return SUCCESS;
	}

	/************************************** 信息导出 *********************************************/

	/**
	 * 信息导出（可测算标准房）
	 */
	public String exportY() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("exportY() ********** start **********");
		}
		Pgv02061 v02061 = new Pgv02061();
		try {
			v02061.setPageIndex(1);
			v02061.setPageSize(-1);
			v02061.setCd02050Xqdm("");
			v02061.setXqnm(FormatUtil.toSearchLike(txtXQCX));
			v02061.setCd00001Szqy(ConvertUtil.encoding(ddlSZQYFind));
			v02061.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v02061.setCd00001Fwlx(ConvertUtil.encoding(txtFWLX));
			v02061.setBzfjg(ConvertUtil.toInteger(txtBZFJG));
			// v02061.setMonthSet(ConvertUtil.toInteger(txtCSYFE));
			v02061.setKbslkJysjs(ConvertUtil.toTimestamp(txtKBSLKJYSJS));
			v02061.setKbslkJysje(ConvertUtil.toTimestamp(txtKBSLKJYSJE));
			v02061.setKbslkImps(ConvertUtil.toTimestamp(txtKBSLKIMPS));
			v02061.setKbslkImpe(ConvertUtil.toTimestamp(txtKBSLKIMPE));
			v02061.setCd00002Czr(sessionCtrl.getUserId());
			v02061.setSfsc(ConvertUtil.toInteger(SFSC));
			ByteArrayOutputStream out = (ByteArrayOutputStream) t02061Service
					.ExportCSY(v02061);
			setExcelStream(new ByteArrayInputStream(out.toByteArray()));
		} catch (Exception e) {
			e.printStackTrace();
			if (LOG.isDebugEnabled()) {
				LOG.debug("exportY() ********** end **********");
			}
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
			return INPUT;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("exportY() ********** end **********");
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		return SUCCESS;
	}

	/**
	 * 信息导出（可测算标准房）
	 */
	public String exportN() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("exportN() ********** start **********");
		}
		Pgv02061 v02061 = new Pgv02061();
		try {
			v02061.setPageIndex(1);
			v02061.setPageSize(-1);
			v02061.setCd02050Xqdm("");
			v02061.setXqnm(txtZCDZL);
			v02061.setCd00001Szqy(ddlSZQYFind);
			v02061.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v02061.setCd00001Fwlx(txtFWLX);
			v02061.setBzfjg(ConvertUtil.toInteger(txtBZFJG));
			// v02061.setMonthSet(ConvertUtil.toInteger(txtCSYFE));
			v02061.setKbslkJysjs(ConvertUtil.toTimestamp(txtKBSLKJYSJS));
			v02061.setKbslkJysje(ConvertUtil.toTimestamp(txtKBSLKJYSJE));
			v02061.setCd00002Czr(sessionCtrl.getUserId());
			v02061.setSfsc(ConvertUtil.toInteger(SFSC));
			ByteArrayOutputStream out = (ByteArrayOutputStream) t02061Service
					.ExportCSN(v02061);
			setExcelStream(new ByteArrayInputStream(out.toByteArray()));
		} catch (Exception e) {
			e.printStackTrace();
			if (LOG.isDebugEnabled()) {
				LOG.debug("exportN() ********** end **********");
			}
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
			return INPUT;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("exportN() ********** end **********");
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		return SUCCESS;
	}

	/**
	 * 片区标准房
	 */
	public String executeBZFDQCS() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("executeBZFDQCS() ********** start **********");
		}

		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		ReadInfo();
		ReadInfoFWLX();
		if (LOG.isDebugEnabled()) {
			LOG.debug("executeBZFDQCS() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 
	 */
	private void ReadInfoFWLX() throws Exception {

		Pgv00001 v00001 = new Pgv00001();

		v00001.setPageIndex(1);
		v00001.setPageSize(-1);
		v00001.setRootid(sessionCtrl.Get(SessionCtrl.SESSION_INFO_FWLX_SC));

		fwlxListBox = t00001Service.LoadAll(v00001);
	}

	/**
	 * 片区标准房价格测算
	 */
	public String executeDQCS() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("executeDQCS() ********** start **********");
		}

		Pgv02061 v02061 = new Pgv02061();
		try {
			v02061.setCd00001Szqy(ddlSZQY);
			v02061.setCd02050Xqdm(txtXQDM);
			v02061.setJysj(ConvertUtil.toUtilDate(txtCSJYSJ));
			v02061.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v02061.setCd00002Czr(sessionCtrl
					.Get(SessionCtrl.SESSION_KEY_USERID));
			v02061.setFwlx(ddlFWLX);
			ReadInfo();
			ReadInfoFWLX();
			if (t02061Service.ExecuteBZFDQCS(v02061)) {
				this.addActionMessage("片区标准房测算成功");
			} else {
				this.addActionError("数据库连接错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (LOG.isDebugEnabled()) {
				LOG.debug("executeDQCS() ********** end **********");
			}
			this.addActionError("请求已发送，数据库无响应  ");
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("executeDQCS() ********** end **********");
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		return SUCCESS;
	}

	/**
	 * 删除筛选出的所有数据
	 * 
	 * @return
	 * @throws Exception
	 */
	public String delAll() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("delAll() ********** start **********");
		}
		try {
			Pgv02061 v02061 = new Pgv02061();
			v02061.setCd02050Xqdm(txtXQDMD);
			v02061.setXqnm(txtZCDZLD);
			v02061.setCd00001Szqy(txtSZQYD);
			v02061.setSlid(txtSLIDD);
			v02061.setCd00001Fwlx(txtFWLXD);
			v02061.setQyxz(txtISPQD);
			v02061.setQdh(txtQDHD);
			v02061.setBzfjg(ConvertUtil.toInteger(txtISJYJG));
			v02061.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v02061.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			if (t02061Service.GetDeleteAllCommand(v02061)) {
				resSign = "1";
				resMsg = "删除成功";
			} else {
				throw new Exception("未知错误，请与管理员联系");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resSign = "2";
			resMsg = "删除异常:" + e.getMessage();

			if (LOG.isDebugEnabled()) {
				LOG.debug("delAll() ********** end **********");
			}
			return SUCCESS;
		} finally {
			//
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("delAll() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 判断按钮在规定的日期时间是否可用
	 * 
	 * @return 0不可；1可用
	 * @throws Exception
	 */
	public String isBtnEnable() throws Exception {
		String dt = MakeUtil.currentDate();
		try {
			switch (MakeUtil.chkWeek(dt)) {
			case 6:
			case 7:
				// 周末没有限制,按钮可用
				btnFlag = true;
				break;
			default:
				btnFlag = true;
//				//定义时间范围
//				String sBgn = dt + " 08:00:00";
//				String sEnd = dt + " 17:00:00";
//				Date dNow = new Date();
//				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//				// 判断时间是否合法
//				if (dNow.after(sdf.parse(sBgn)) && dNow.before(sdf.parse(sEnd))) {
//					btnFlag = false;
//				} else {
//					btnFlag = true;
//				}
				break;
			}
		} catch (Exception e) {
			 e.printStackTrace();
			btnFlag = false;
		}

		return SUCCESS;
	}

	/*********************** setter and getter ******************************/

	/**
	 * @return the t02061Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt02061Service getT02061Service() {
		return t02061Service;
	}

	/**
	 * @param t02061Service
	 *            the t02061Service to set
	 */
	public void setT02061Service(IPgt02061Service t02061Service) {
		this.t02061Service = t02061Service;
	}

	
	/**
	 * @return the szqyList
	 */
	public ArrayList<Pgv00052> getSzqyList() {
		return szqyList;
	}

	/**
	 * @param szqyList
	 *            the szqyList to set
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
	 * @param pageIndex
	 *            the pageIndex to set
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
	 * @param total
	 *            the total to set
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}

	/**
	 * @return the rows
	 */
	public ArrayList<Pgv02061> getRows() {
		return rows;
	}

	/**
	 * @param rows
	 *            the rows to set
	 */
	public void setRows(ArrayList<Pgv02061> rows) {
		this.rows = rows;
	}

	/**
	 * @return the v02061Bean
	 */
	public Pgv02061 getV02061Bean() {
		return v02061Bean;
	}

	/**
	 * @param v02061Bean
	 *            the v02061Bean to set
	 */
	public void setV02061Bean(Pgv02061 v02061Bean) {
		this.v02061Bean = v02061Bean;
	}

	/**
	 * @return the txtXQFind
	 */
	public String getTxtXQFind() {
		return txtXQFind;
	}

	/**
	 * @param txtXQFind
	 *            the txtXQFind to set
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
	 * @param ddlSZQYFind
	 *            the ddlSZQYFind to set
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
	 * @param txtSLIDFind
	 *            the txtSLIDFind to set
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
	 * @param aCT
	 *            the aCT to set
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
	 * @param sLID
	 *            the sLID to set
	 */
	public void setSLID(String sLID) {
		SLID = sLID;
	}	

	/**
	 * @return the txtUPDATE
	 */
	public String getTxtUPDATE() {
		return txtUPDATE;
	}

	/**
	 * @param txtUPDATE
	 *            the txtUPDATE to set
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
	 * @param txtLFID
	 *            the txtLFID to set
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
	 * @param txtFWLX
	 *            the txtFWLX to set
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
	 * @param txtJYLX
	 *            the txtJYLX to set
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
	 * @param txtJZJGT
	 *            the txtJZJGT to set
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
	 * @param txtFWCX
	 *            the txtFWCX to set
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
	 * @param txtCGZK
	 *            the txtCGZK to set
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
	 * @param txtSZLC
	 *            the txtSZLC to set
	 */
	public void setTxtSZLC(Short txtSZLC) {
		this.txtSZLC = txtSZLC;
	}

	/**
	 * @return the txtJYSJ
	 */
	public String getTxtJYSJ() {
		return txtJYSJ;
	}

	/**
	 * @param txtJYSJ
	 *            the txtJYSJ to set
	 */
	public void setTxtJYSJ(String txtJYSJ) {
		this.txtJYSJ = txtJYSJ;
	}

	/**
	 * @return the txtNOTET02061
	 */
	public String getTxtNOTET02061() {
		return txtNOTET02061;
	}

	/**
	 * @param txtNOTET02061
	 *            the txtNOTET02061 to set
	 */
	public void setTxtNOTET02061(String txtNOTET02061) {
		this.txtNOTET02061 = txtNOTET02061;
	}

	/**
	 * @return the txtJZJG
	 */
	public String getTxtJZJG() {
		return txtJZJG;
	}

	/**
	 * @param txtJZJG
	 *            the txtJZJG to set
	 */
	public void setTxtJZJG(String txtJZJG) {
		this.txtJZJG = txtJZJG;
	}

	/**
	 * @return the rdoYWDT
	 */
	public String getRdoYWDT() {
		return rdoYWDT;
	}

	/**
	 * @param rdoYWDT
	 *            the rdoYWDT to set
	 */
	public void setRdoYWDT(String rdoYWDT) {
		this.rdoYWDT = rdoYWDT;
	}

	/**
	 * @return the txtZLC
	 */
	public Short getTxtZLC() {
		return txtZLC;
	}

	/**
	 * @param txtZLC
	 *            the txtZLC to set
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
	 * @param txtNOTE
	 *            the txtNOTE to set
	 */
	public void setTxtNOTE(String txtNOTE) {
		this.txtNOTE = txtNOTE;
	}

	/**
	 * @return the qtxzList
	 */
	public ArrayList<Pgv02061e> getQtxzList() {
		return qtxzList;
	}

	/**
	 * @param qtxzList
	 *            the qtxzList to set
	 */
	public void setQtxzList(ArrayList<Pgv02061e> qtxzList) {
		this.qtxzList = qtxzList;
	}

	/**
	 * @return the xZLX
	 */
	public String getXZLX() {
		return XZLX;
	}

	/**
	 * @param xZLX
	 *            the xZLX to set
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
	 * @param hidQTXZ
	 *            the hidQTXZ to set
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
	 * @param txtXQDM
	 *            the txtXQDM to set
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
	 * @param sZQY
	 *            the sZQY to set
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
	 * @param jYSJ
	 *            the jYSJ to set
	 */
	public void setJYSJ(String jYSJ) {
		JYSJ = jYSJ;
	}


	/**
	 * @return the zCDZS
	 */
	public String getZCDZS() {
		return ZCDZS;
	}

	/**
	 * @param zCDZS
	 *            the zCDZS to set
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
	 * @param zCDZD
	 *            the zCDZD to set
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
	 * @param zCDZL
	 *            the zCDZL to set
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
	 * @param zCDZM
	 *            the zCDZM to set
	 */
	public void setZCDZM(String zCDZM) {
		ZCDZM = zCDZM;
	}

	/**
	 * @param txtHXJG
	 *            the txtHXJG to set
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
	 * @param txtZCDZL
	 *            the txtZCDZL to set
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
	 * @param txtJTZKId
	 *            the txtJTZKId to set
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
	 * @param txtWYZKId
	 *            the txtWYZKId to set
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
	 * @param txtZXZKId
	 *            the txtZXZKId to set
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
	 * @param fROM
	 *            the fROM to set
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
	 * @param createSum
	 *            the createSum to set
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
	 * @param title
	 *            the title to set
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
	 * @param upload
	 *            the upload to set
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
	 * @param uploadContentType
	 *            the uploadContentType to set
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
	 * @param uploadFileName
	 *            the uploadFileName to set
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
	 * @param savePath
	 *            the savePath to set
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
	 * @param fileServerPath
	 *            the fileServerPath to set
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
	 * @param txtFilePath
	 *            the txtFilePath to set
	 */
	public void setTxtFilePath(String txtFilePath) {
		this.txtFilePath = txtFilePath;
	}

	/**
	 * @return the pgv02061List
	 */
	public ArrayList<Pgv02061> getPgv02061List() {
		return Pgv02061List;
	}

	/**
	 * @param pgv02061List
	 *            the pgv02061List to set
	 */
	public void setPgv02061List(ArrayList<Pgv02061> pgv02061List) {
		Pgv02061List = pgv02061List;
	}

	/**
	 * @return the excelStream
	 */
	public InputStream getExcelStream() {
		return excelStream;
	}

	/**
	 * @param excelStream
	 *            the excelStream to set
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
	 * @param fileName
	 *            the fileName to set
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
	 * @param ebList
	 *            the ebList to set
	 */
	public void setEbList(ArrayList<ExcelBean> ebList) {
		this.ebList = ebList;
	}

	/**
	 * @return the t02061aService
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt02061aService getT02061aService() {
		return t02061aService;
	}

	/**
	 * @param t02061aService
	 *            the t02061aService to set
	 */
	public void setT02061aService(IPgt02061aService t02061aService) {
		this.t02061aService = t02061aService;
	}

	/**
	 * @return the txtMONTHFind
	 */
	public String getTxtMONTHFind() {
		return txtMONTHFind;
	}

	/**
	 * @param txtMONTHFind
	 *            the txtMONTHFind to set
	 */
	public void setTxtMONTHFind(String txtMONTHFind) {
		this.txtMONTHFind = txtMONTHFind;
	}

	/**
	 * @return the sessionCtrl
	 */
	public SessionCtrl getSessionCtrl() {
		return sessionCtrl;
	}

	/**
	 * @param sessionCtrl
	 *            the sessionCtrl to set
	 */
	public void setSessionCtrl(SessionCtrl sessionCtrl) {
		this.sessionCtrl = sessionCtrl;
	}

	/**
	 * @return the txtQDH
	 */
	public String getTxtQDH() {
		return txtQDH;
	}

	/**
	 * @param txtQDH
	 *            the txtQDH to set
	 */
	public void setTxtQDH(String txtQDH) {
		this.txtQDH = txtQDH;
	}

	/**
	 * @return the txtZH
	 */
	public String getTxtZH() {
		return txtZH;
	}

	/**
	 * @param txtZH
	 *            the txtZH to set
	 */
	public void setTxtZH(String txtZH) {
		this.txtZH = txtZH;
	}

	/**
	 * @return the txtBWJFH
	 */
	public String getTxtBWJFH() {
		return txtBWJFH;
	}

	/**
	 * @param txtBWJFH
	 *            the txtBWJFH to set
	 */
	public void setTxtBWJFH(String txtBWJFH) {
		this.txtBWJFH = txtBWJFH;
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
	 * @param userRole
	 *            the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	/**
	 * 
	 * @return the hidFlag
	 */
	public String getHidFlag() {
		return hidFlag;
	}

	/**
	 * 
	 * @param hidFlag
	 *            the hidFlag to set
	 */
	public void setHidFlag(String hidFlag) {
		this.hidFlag = hidFlag;
	}

	/**
	 * 
	 * @return the processMsg
	 */
	public String getProcessMsg() {
		return processMsg;
	}

	/**
	 * 
	 * @param processMsg
	 *            the processMsg to set
	 */
	public void setProcessMsg(String processMsg) {
		this.processMsg = processMsg;
	}

	/**
	 * 
	 * @return the processCent
	 */
	public Integer getProcessCent() {
		return processCent;
	}

	/**
	 * 
	 * @param processCent
	 *            the processCent to set
	 */
	public void setProcessCent(Integer processCent) {
		this.processCent = processCent;
	}

	/**
	 * 
	 * @return the chkSel
	 */
	public String[] getChkSel() {
		return chkSel;
	}

	/**
	 * 
	 * @param chkSel
	 *            the chkSel to set
	 */
	public void setChkSel(String[] chkSel) {
		this.chkSel = chkSel;
	}

	/**
	 * 
	 * @return the txtCSJYSJ
	 */
	public String getTxtCSJYSJ() {
		return txtCSJYSJ;
	}

	/**
	 * 
	 * @param txtCSJYSJ
	 *            the txtCSJYSJ to set
	 */
	public void setTxtCSJYSJ(String txtCSJYSJ) {
		this.txtCSJYSJ = txtCSJYSJ;
	}

	/**
	 * 
	 * @return the sRC
	 */
	public String getSRC() {
		return SRC;
	}

	/**
	 * 
	 * @param sRC
	 *            the sRC to set
	 */
	public void setSRC(String sRC) {
		SRC = sRC;
	}

	/**
	 * @return the aSZQY
	 */
	public String getASZQY() {
		return ASZQY;
	}

	/**
	 * @param aSZQY
	 *            the aSZQY to set
	 */
	public void setASZQY(String aSZQY) {
		ASZQY = aSZQY;
	}

	/**
	 * @return the aXQNM
	 */
	public String getAXQNM() {
		return AXQNM;
	}

	/**
	 * @param aXQNM
	 *            the aXQNM to set
	 */
	public void setAXQNM(String aXQNM) {
		AXQNM = aXQNM;
	}

	/**
	 * @return the aXQDM
	 */
	public String getAXQDM() {
		return AXQDM;
	}

	/**
	 * @param aXQDM
	 *            the aXQDM to set
	 */
	public void setAXQDM(String aXQDM) {
		AXQDM = aXQDM;
	}

	/**
	 * @return the fwlxList
	 */
	public ArrayList<Pgv02061> getFwlxList() {
		return fwlxList;
	}

	/**
	 * @param fwlxList
	 *            the fwlxList to set
	 */
	public void setFwlxList(ArrayList<Pgv02061> fwlxList) {
		this.fwlxList = fwlxList;
	}

	/**
	 * @param xQNM
	 *            the xQNM to set
	 */
	public void setXQNM(String xQNM) {
		XQNM = xQNM;
	}

	/**
	 * @return the xQNM
	 */
	public String getXQNM() {
		return XQNM;
	}

	/**
	 * @param fWLX
	 *            the fWLX to set
	 */
	public void setFWLX(String fWLX) {
		FWLX = fWLX;
	}

	/**
	 * @return the fWLX
	 */
	public String getFWLX() {
		return FWLX;
	}

	/**
	 * @param fWLXNM
	 *            the fWLXNM to set
	 */
	public void setFWLXNM(String fWLXNM) {
		FWLXNM = fWLXNM;
	}

	/**
	 * @return the fWLXNM
	 */
	public String getFWLXNM() {
		return FWLXNM;
	}

	/**
	 * 
	 * @return the bZFSIGN
	 */
	public String getBZFSIGN() {
		return BZFSIGN;
	}

	/**
	 * 
	 * @param bZFSIGN
	 *            the bZFSIGN to set
	 */
	public void setBZFSIGN(String bZFSIGN) {
		BZFSIGN = bZFSIGN;
	}	

	public String getDdlSZQY() {
		return ddlSZQY;
	}

	public void setDdlSZQY(String ddlSZQY) {
		this.ddlSZQY = ddlSZQY;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getQYXZ() {
		return QYXZ;
	}

	public void setQYXZ(String qYXZ) {
		QYXZ = qYXZ;
	}

	public String getXQGLSIGN() {
		return XQGLSIGN;
	}

	public void setXQGLSIGN(String xQGLSIGN) {
		XQGLSIGN = xQGLSIGN;
	}

	public String getTxtQH() {
		return txtQH;
	}

	public void setTxtQH(String txtQH) {
		this.txtQH = txtQH;
	}

	public String getTxtDH() {
		return txtDH;
	}

	public void setTxtDH(String txtDH) {
		this.txtDH = txtDH;
	}

	public String getBZFJG() {
		return BZFJG;
	}

	public void setBZFJG(String bZFJG) {
		BZFJG = bZFJG;
	}

	public String getTxtYWJG() {
		return txtYWJG;
	}

	public void setTxtYWJG(String txtYWJG) {
		this.txtYWJG = txtYWJG;
	}	
	
	public String getTxtBZFJG() {
		return txtBZFJG;
	}

	public void setTxtBZFJG(String txtBZFJG) {
		this.txtBZFJG = txtBZFJG;
	}

	public String getCX() {
		return CX;
	}

	public void setCX(String cX) {
		CX = cX;
	}

	/**
	 * @return the chkSelTemp
	 */
	public String getChkSelTemp() {
		return chkSelTemp;
	}

	/**
	 * @param chkSelTemp
	 *            the chkSelTemp to set
	 */
	public void setChkSelTemp(String chkSelTemp) {
		this.chkSelTemp = chkSelTemp;
	}

	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize
	 *            the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the v0035a1Bean
	 */
	public ArrayList<Pgv02061a> getV0035a1Bean() {
		return v0035a1Bean;
	}

	/**
	 * @param v0035a1Bean
	 *            the v0035a1Bean to set
	 */
	public void setV0035a1Bean(ArrayList<Pgv02061a> v0035a1Bean) {
		this.v0035a1Bean = v0035a1Bean;
	}

	public ArrayList<Pgv00001> getFwlxListBox() {
		return fwlxListBox;
	}

	public void setFwlxListBox(ArrayList<Pgv00001> fwlxListBox) {
		this.fwlxListBox = fwlxListBox;
	}

	@JSON(deserialize = false, serialize = false)
	public IPgt00001Service getT00001Service() {
		return t00001Service;
	}

	public void setT00001Service(IPgt00001Service t00001Service) {
		this.t00001Service = t00001Service;
	}

	public String getDdlFWLX() {
		return ddlFWLX;
	}

	public void setDdlFWLX(String ddlFWLX) {
		this.ddlFWLX = ddlFWLX;
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

	public String getTxtJCSJ() {
		return txtJCSJ;
	}

	public void setTxtJCSJ(String txtJCSJ) {
		this.txtJCSJ = txtJCSJ;
	}

	public String getACTT() {
		return ACTT;
	}

	public void setACTT(String aCTT) {
		ACTT = aCTT;
	}	

	public String getTxtPFMJG() {
		return txtPFMJG;
	}

	public void setTxtPFMJG(String txtPFMJG) {
		this.txtPFMJG = txtPFMJG;
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

	public String getTxtXQDMD() {
		return txtXQDMD;
	}

	public void setTxtXQDMD(String txtXQDMD) {
		this.txtXQDMD = txtXQDMD;
	}

	public String getTxtZCDZLD() {
		return txtZCDZLD;
	}

	public void setTxtZCDZLD(String txtZCDZLD) {
		this.txtZCDZLD = txtZCDZLD;
	}

	public String getTxtSZQYD() {
		return txtSZQYD;
	}

	public void setTxtSZQYD(String txtSZQYD) {
		this.txtSZQYD = txtSZQYD;
	}

	public String getTxtSLIDD() {
		return txtSLIDD;
	}

	public void setTxtSLIDD(String txtSLIDD) {
		this.txtSLIDD = txtSLIDD;
	}

	public String getTxtFWLXD() {
		return txtFWLXD;
	}

	public void setTxtFWLXD(String txtFWLXD) {
		this.txtFWLXD = txtFWLXD;
	}

	public String getTxtISPQD() {
		return txtISPQD;
	}

	public void setTxtISPQD(String txtISPQD) {
		this.txtISPQD = txtISPQD;
	}

	public String getTxtQDHD() {
		return txtQDHD;
	}

	public void setTxtQDHD(String txtQDHD) {
		this.txtQDHD = txtQDHD;
	}

	public String getTxtISJYJG() {
		return txtISJYJG;
	}

	public void setTxtISJYJG(String txtISJYJG) {
		this.txtISJYJG = txtISJYJG;
	}

	public String getCsAllTimeLock() {
		return csAllTimeLock;
	}

	public void setCsAllTimeLock(String csAllTimeLock) {
		this.csAllTimeLock = csAllTimeLock;
	}

	public String getTxtKBSLKJYSJS() {
		return txtKBSLKJYSJS;
	}

	public void setTxtKBSLKJYSJS(String txtKBSLKJYSJS) {
		this.txtKBSLKJYSJS = txtKBSLKJYSJS;
	}

	public String getTxtKBSLKJYSJE() {
		return txtKBSLKJYSJE;
	}

	public void setTxtKBSLKJYSJE(String txtKBSLKJYSJE) {
		this.txtKBSLKJYSJE = txtKBSLKJYSJE;
	}

	public String getTxtKBSLKIMPS() {
		return txtKBSLKIMPS;
	}

	public void setTxtKBSLKIMPS(String txtKBSLKIMPS) {
		this.txtKBSLKIMPS = txtKBSLKIMPS;
	}

	public String getTxtKBSLKIMPE() {
		return txtKBSLKIMPE;
	}

	public void setTxtKBSLKIMPE(String txtKBSLKIMPE) {
		this.txtKBSLKIMPE = txtKBSLKIMPE;
	}

	/**
	 * @return the btnFlag
	 */
	public boolean isBtnFlag() {
		return btnFlag;
	}

	/**
	 * @param btnFlag the btnFlag to set
	 */
	public void setBtnFlag(boolean btnFlag) {
		this.btnFlag = btnFlag;
	}

	public String getCd02050Xqdm() {
		return cd02050Xqdm;
	}

	public void setCd02050Xqdm(String cd02050Xqdm) {
		this.cd02050Xqdm = cd02050Xqdm;
	}

	public String getCd00001Szqy() {
		return cd00001Szqy;
	}

	public void setCd00001Szqy(String cd00001Szqy) {
		this.cd00001Szqy = cd00001Szqy;
	}	

	public String getCd00001Ssgx() {
		return cd00001Ssgx;
	}

	public void setCd00001Ssgx(String cd00001Ssgx) {
		this.cd00001Ssgx = cd00001Ssgx;
	}

	public String getSlid() {
		return slid;
	}

	public void setSlid(String slid) {
		this.slid = slid;
	}

	public String getCd00001Fwlx() {
		return cd00001Fwlx;
	}

	public void setCd00001Fwlx(String cd00001Fwlx) {
		this.cd00001Fwlx = cd00001Fwlx;
	}

	public Date getMonth() {
		return month;
	}

	public void setMonth(Date month) {
		this.month = month;
	}	

	public String getSFSC() {
		return SFSC;
	}

	public void setSFSC(String SFSC) {
		this.SFSC = SFSC;
	}

	public String getTxtXQCX() {
		return txtXQCX;
	}

	public void setTxtXQCX(String txtXQCX) {
		this.txtXQCX = txtXQCX;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionCtrl.appSession=arg0;
	}

	public Pgt02061 getBean() {
		return bean;
	}

	public void setBean(Pgt02061 bean) {
		this.bean = bean;
	}

	


}
