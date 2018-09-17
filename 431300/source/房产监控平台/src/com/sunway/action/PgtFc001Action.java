package com.sunway.action;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00004Service;
import com.sunway.service.IPgtFc001Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt00004;
import com.sunway.vo.PgtFc001;
import com.sunway.vo.PgtFc002;
import com.sunway.vo.PgtFc003;
import com.sunway.vo.PgvFc001;
public class PgtFc001Action extends ActionSupport implements SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7735529451064488168L;
	// Service
	private IPgtFc001Service tFc001Service;	
	private IPgt00004Service t00004Service;

	// View

	// 分页参数
	private Integer pageIndex;
	private Integer pageSize;
	private Integer rowCount;
	private String processMsg;
	private Integer processCent;
	// Bean数组
	private ArrayList<PgvFc001> tabList;
	private List<Pgt00004> mszcyjList;
	// 查询条件
	private String txtSLIDFIND;
	private String txtSSQYFIND;
	private String txtZRF_NAMEFIND;
	private String txtCSF_NAMEFIND;
	private String txtJYSJ_MINFIND;
	private String txtJYSJ_MAXFIND;  
	private String txtUPDATETIME_MINFIND;
	private String txtUPDATETIME_MAXFIND;
    private String txtFZRQ_MINFIND;
    private String txtFZRQ_MAXFIND;
	private String txtLFDZFIND;
	private String txtCQRFIND;
	private String txtFCZHFIND;  
	// Edit
	// detail页面所需Bean
	private PgvFc001 vfc001Bean;
	// edit页面所需Bean
	private PgtFc001 tFc001Bean;
	private PgtFc002 tFc002Bean;
	// primary key 主键
	private String ACT;
	// 表单提交数据
	private String txtSSQY;
	private String txtNOTE;
	private String txtUPDATE;
	private String txtSLID;
	private Boolean isExists;

	private String ACTIONNAME;
	private String HREFNAME;
	private String TITLENAME;
	private String URL;
	// 检索条件
	private String pk;
	private String txtID;
	private String msgDel;
	private String chkDel;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	// primary key 主键
	private String SLID;
	private String SSQY;	
	//税款登记
	private String rdoMSSIGN;
	private String txtDJZ_QS;
	private String txtDJZ_YYS;
	private String txtDJZ_CJS;
	private String txtDJZ_DFJYS;
	private String txtDJZ_GRSDS;
	private String txtDJZ_YHS;
	private String txtDJZ_TDZZS;
	private String txtFPHM;
	private String txtQSSPHM;
	private String txtDFGSSPHM;
	private String txtUPDATETIME;
	private boolean rdState;
	private String resSign;
	private String resMsg;
	private String txtMSZCYJ;
	private String txtDEL_CZR;
	private boolean bgFlag;
	private ByteArrayInputStream excelStream;
	private PgtFc003 tfc003Bean;
	private Integer ID;
	private String txtREMARKS;
	@Override
	public String execute() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** start **********");
		}

		try {
			
		} catch (Exception e) {
			e.printStackTrace();
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

		PgvFc001 vFc001 = new PgvFc001();
		try { 
			// 准备查询条件
			vFc001.setSlid(Common.getSearchLike(Common.trim(txtSLIDFIND)));
			vFc001.setZrf_name(Common.getSearchLike(Common.trim(txtZRF_NAMEFIND)));
			vFc001.setCsf_name(Common.getSearchLike(Common.trim(txtCSF_NAMEFIND)));
			vFc001.setJysj_min(Common.convertStringToTimestamp(txtJYSJ_MINFIND));
			vFc001.setJysj_max(Common.convertStringToTimestamp(txtJYSJ_MINFIND));
			vFc001.setPageIndex(pageIndex);
			vFc001.setPageSize(getPageSize());
			// 执行查询
			tabList = tFc001Service.LoadAll(vFc001);

			// 分页设置
			if (null != tabList && tabList.size() > 0) {
				rowCount = Common.checkNull(tabList.get(0).getRecordCount());
			} else {
				pageIndex = 1;
				rowCount = 0;
			}
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
	public String detail() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** start **********");
		}
		PgtFc001 tfc001 = new PgtFc001();
		vfc001Bean = new PgvFc001();
		try {
			// 准备查询条件
			tfc001.setSlid(SLID);
			tfc001.setSsqy(SSQY);
			// 执行查询
			vfc001Bean = tFc001Service.LoadByPrimaryKey(tfc001);
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
	 *  办证
	 * @return
	 * @throws Exception
	 */
	public String create() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** start **********");
		}		
		try {		
			 mszcyjList=t00004Service.LoadAllMsZcYj();					
		} catch (Exception e) {
			e.printStackTrace();
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
   public String registTax()throws Exception {
		try {
			tFc002Bean = new PgtFc002();
			tFc002Bean.setSlid(txtSLID);
			tFc002Bean.setSsqy(txtSSQY);
			tFc002Bean.setMs_sign(Common.convertToInteger(rdoMSSIGN));
			tFc002Bean.setDjz_qs(Common.convertToDouble(txtDJZ_QS));
			tFc002Bean.setDjz_yys(Common.convertToDouble(txtDJZ_YYS));
			tFc002Bean.setDjz_cjs(Common.convertToDouble(txtDJZ_CJS));
			tFc002Bean.setDjz_dfjys(Common.convertToDouble(txtDJZ_DFJYS));
			tFc002Bean.setDjz_grsds(Common.convertToDouble(txtDJZ_GRSDS));
			tFc002Bean.setDjz_yhs(Common.convertToDouble(txtDJZ_YHS));
			tFc002Bean.setDjz_tdzzs(Common.convertToDouble(txtDJZ_TDZZS));
			tFc002Bean.setFphm(txtFPHM);
			tFc002Bean.setQssphm(txtQSSPHM);
			tFc002Bean.setDfgssphm(txtDFGSSPHM);
			tFc002Bean.setUpdatetime(Common
					.convertStringToTimestamp(txtUPDATETIME));
			tFc002Bean.setMs_zcyj(txtMSZCYJ);
			if (tFc001Service.RegistTax(tFc002Bean)) {
				this.addActionMessage(getText(Constant.MSG_SEDJ_EXECR_OK, new String[] { "该数据" }));
			} else{
				this.addActionMessage(getText(Constant.MSG_SEDJ_EXECR_NG, new String[] { "该数据" }));
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("RegistTax() ********** end **********");
			}
			return INPUT;
		} finally {
			//
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("RegistTax() ********** end **********");
		}
		return SUCCESS;
	}
   /**
    * 退税业务
    * @return
    * @throws Exception
    */
   public String reimbursementTax()throws Exception {
		try {
			tFc002Bean = new PgtFc002();
			tFc002Bean.setSlid(txtSLID);
			tFc002Bean.setSsqy(txtSSQY);
			//tFc002Bean.setMs_sign(Common.convertToInteger(rdoMSSIGN));
			tFc002Bean.setDjz_qs(Common.convertToDouble(txtDJZ_QS));
			tFc002Bean.setDjz_yys(Common.convertToDouble(txtDJZ_YYS));
			tFc002Bean.setDjz_cjs(Common.convertToDouble(txtDJZ_CJS));
			tFc002Bean.setDjz_dfjys(Common.convertToDouble(txtDJZ_DFJYS));
			tFc002Bean.setDjz_grsds(Common.convertToDouble(txtDJZ_GRSDS));
			tFc002Bean.setDjz_yhs(Common.convertToDouble(txtDJZ_YHS));
			tFc002Bean.setDjz_tdzzs(Common.convertToDouble(txtDJZ_TDZZS));
			tFc002Bean.setTs_czr(sessionCtrl.getUserId());
//			tFc002Bean.setFphm(txtFPHM);
//			tFc002Bean.setQssphm(txtQSSPHM);
//			tFc002Bean.setDfgssphm(txtDFGSSPHM);
//			tFc002Bean.setUpdatetime(Common
//					.convertStringToTimestamp(txtUPDATETIME));
			tFc002Bean.setMs_zcyj(txtMSZCYJ);
			if (tFc001Service.RebateTax(tFc002Bean)) {
				this.addActionMessage(getText(Constant.MSG_TSDJ_EXECR_OK, new String[] { "该数据" }));
			} else{
				this.addActionMessage(getText(Constant.MSG_TSDJ_EXECR_NG, new String[] { "该数据" }));
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("RegistTax() ********** end **********");
			}
			return INPUT;
		} finally {
			//
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("RegistTax() ********** end **********");
		}
		return SUCCESS;
	}
	/**
	 * 退税业务
	 */
	public String rebateTax()throws Exception{
		
		try {
			tFc002Bean = new PgtFc002();
			tFc002Bean.setSlid(txtSLID);
			tFc002Bean.setSsqy(txtSSQY);
			tFc002Bean.setDel_czr(sessionCtrl.getUserId());
			bgFlag=tFc001Service.RebateTax(tFc002Bean);
			if (bgFlag) {
				resMsg = "退税业务成功";
			} 
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("RebateTax() ********** end **********");
			}
			return SUCCESS;
		} finally {
			//
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("RebateTax() ********** end **********");
		}
		return SUCCESS;
	}
   /**
	 * 读取中止业务处理所有房产信息
	 */	
	public String loadAllZzYw() throws Exception{
		PgvFc001 vFc001 = new PgvFc001();
		try { 
			// 准备查询条件

			vFc001.setSlid(Common.getSearchLike(Common.trim(txtSLIDFIND)));
			vFc001.setZrf_name(Common.getSearchLike(Common.trim(txtZRF_NAMEFIND)));
			vFc001.setCsf_name(Common.getSearchLike(Common.trim(txtCSF_NAMEFIND)));
			vFc001.setJysj_min(Common.convertStringToTimestamp(txtJYSJ_MINFIND));
			vFc001.setJysj_max(Common.convertStringToTimestamp(txtJYSJ_MINFIND));
			vFc001.setPageIndex(pageIndex);
			vFc001.setPageSize(getPageSize());
			// 执行查询
			tabList = tFc001Service.LoadAllZzYw(vFc001);

			// 分页设置
			if (null != tabList && tabList.size() > 0) {
				rowCount = Common.checkNull(tabList.get(0).getRecordCount());
			} else {
				pageIndex = 1;
				rowCount = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("LoadAllZzYw() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 读取退税业务处理所有房产信息
	 */
	public String loadAllTsYw() throws Exception{
		PgvFc001 vFc001 = new PgvFc001();
		try { 
			// 准备查询条件

			vFc001.setSlid(Common.getSearchLike(Common.trim(txtSLIDFIND)));
			vFc001.setZrf_name(Common.getSearchLike(Common.trim(txtZRF_NAMEFIND)));
			vFc001.setCsf_name(Common.getSearchLike(Common.trim(txtCSF_NAMEFIND)));
			vFc001.setJysj_min(Common.convertStringToTimestamp(txtJYSJ_MINFIND));
			vFc001.setJysj_max(Common.convertStringToTimestamp(txtJYSJ_MINFIND));
			vFc001.setPageIndex(pageIndex);
			vFc001.setPageSize(getPageSize());
			// 执行查询
			tabList = tFc001Service.LoadAllTsYw(vFc001);

			// 分页设置
			if (null != tabList && tabList.size() > 0) {
				rowCount = Common.checkNull(tabList.get(0).getRecordCount());
			} else {
				pageIndex = 1;
				rowCount = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("LoadAllTsYw() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 读取错误数据处理所有房产信息
	 */
	public String loadAllCwSjCl() throws Exception{
		PgvFc001 vFc001 = new PgvFc001();
		try { 
			// 准备查询条件
			vFc001.setSlid(Common.getSearchLike(Common.trim(txtSLIDFIND)));
			vFc001.setZrf_name(Common.getSearchLike(Common.trim(txtZRF_NAMEFIND)));
			vFc001.setCsf_name(Common.getSearchLike(Common.trim(txtCSF_NAMEFIND)));
			vFc001.setJysj_min(Common.convertStringToTimestamp(txtJYSJ_MINFIND));
			vFc001.setJysj_max(Common.convertStringToTimestamp(txtJYSJ_MINFIND));
			vFc001.setPageIndex(pageIndex);
			vFc001.setPageSize(getPageSize());
			// 执行查询
			tabList = tFc001Service.LoadAllCwSjCl(vFc001);

			// 分页设置
			if (null != tabList && tabList.size() > 0) {
				rowCount = Common.checkNull(tabList.get(0).getRecordCount());
			} else {
				pageIndex = 1;
				rowCount = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("LoadAllCwSjCl() ********** end **********");
		}
		return SUCCESS;
	}
	/**
	 *中止业务
	 */	
	public String breakService()throws Exception{
		try {
			tFc002Bean = new PgtFc002();
			tFc002Bean.setSlid(txtSLID);
			tFc002Bean.setSsqy(txtSSQY);
			bgFlag=tFc001Service.BreakService(tFc002Bean);
			if (bgFlag) {
				resMsg = "终止业务处理成功！";
			} 
		} catch (Exception e) {
			e.printStackTrace();
			resMsg = e.getMessage();
			this.addActionError(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("BreakService() ********** end **********");
			}
			return SUCCESS;
		} finally {
			//
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("BreakService() ********** end **********");
		}
		return SUCCESS;
	}
	/**
	 *完税认定--审核
	 */	
	public String auditService()throws Exception{
		try {
			tFc002Bean = new PgtFc002();
			tFc002Bean.setSlid(txtSLID);
			tFc002Bean.setSsqy(txtSSQY);
			bgFlag=tFc001Service.AuditService(tFc002Bean);
			if (bgFlag) {
				resMsg = "审核业务处理成功！";
			} 
		} catch (Exception e) {
			e.printStackTrace();
			resMsg = e.getMessage();
			this.addActionError(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("BreakService() ********** end **********");
			}
			return SUCCESS;
		} finally {
			//
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("BreakService() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 错误数据处理
	 */
	public String procesErrorData()throws Exception{
		
		try {
			tFc002Bean = new PgtFc002();
			tFc002Bean.setSlid(txtSLID);
			tFc002Bean.setSsqy(txtSSQY);
			tFc002Bean.setRemarks(txtREMARKS);
			tFc002Bean.setDel_czr(sessionCtrl.getUserId());
			bgFlag=tFc001Service.ProcesErrorData(tFc002Bean);
			if (bgFlag) {
				resMsg = "错误数据处理成功";
			} 
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("ProcesErrorData() ********** end **********");
			}
			return SUCCESS;
		} finally {
			//
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("ProcesErrorData() ********** end **********");
		}
		return SUCCESS;
	}
	/**
	 * 超期未完税数据查询
	 */
	public String loadAllOverodueTax() throws Exception{	
		if (LOG.isDebugEnabled()) {
			LOG.debug("loadAllOverodueTax() ********** start **********");
		}

		PgvFc001 vFc001 = new PgvFc001();
		try { 
			// 准备查询条件
			vFc001.setSlid(Common.getSearchLike(Common.trim(txtSLIDFIND)));
			vFc001.setLfdz(Common.getSearchLike(Common.trim(txtLFDZFIND)));
			vFc001.setZrf_name(Common.getSearchLike(Common.trim(txtZRF_NAMEFIND)));
			vFc001.setCsf_name(Common.getSearchLike(Common.trim(txtCSF_NAMEFIND)));
			vFc001.setJysj_min(Common.convertStringToTimestamp(txtJYSJ_MINFIND));
			vFc001.setJysj_max(Common.convertStringToTimestamp(txtJYSJ_MINFIND));
			vFc001.setPageIndex(pageIndex);
			vFc001.setPageSize(getPageSize());
			// 执行查询
			tabList = tFc001Service.LoadAllOverodueTax(vFc001);

			// 分页设置
			if (null != tabList && tabList.size() > 0) {
				rowCount = Common.checkNull(tabList.get(0).getRecordCount());
			} else {
				pageIndex = 1;
				rowCount = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("loadAllOverodueTax() ********** end **********");
		}
		return SUCCESS;
	}
	public String export1() throws Exception {
		PgvFc001 vFc001 = new PgvFc001();
		try{
			//准备查询条件
			vFc001.setSlid(Common.getSearchLike(Common.trim(txtSLIDFIND)));
			vFc001.setLfdz(Common.getSearchLike(Common.trim(txtLFDZFIND)));
			vFc001.setZrf_name(Common.getSearchLike(Common.trim(txtZRF_NAMEFIND)));
			vFc001.setCsf_name(Common.getSearchLike(Common.trim(txtCSF_NAMEFIND)));
			vFc001.setJysj_min(Common.convertStringToTimestamp(txtJYSJ_MINFIND));
			vFc001.setJysj_max(Common.convertStringToTimestamp(txtJYSJ_MINFIND));
			vFc001.setPageIndex(1);
			vFc001.setPageSize(-1);
			ByteArrayOutputStream out = (ByteArrayOutputStream) tFc001Service.ExportOverodueTax(vFc001);
			excelStream = new ByteArrayInputStream(out.toByteArray());
		}catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());
			return INPUT;
		}
		return SUCCESS;
	}
	/**
	 * 完税信息查询
	 */
	public String loadAllPaymentInfo() throws Exception{	
		if (LOG.isDebugEnabled()) {
			LOG.debug("loadAllOverodueTax() ********** start **********");
		}

		PgvFc001 vFc001 = new PgvFc001();
		try { 
			// 准备查询条件
			vFc001.setSlid(Common.getSearchLike(Common.trim(txtSLIDFIND)));
			vFc001.setLfdz(Common.getSearchLike(Common.trim(txtLFDZFIND)));
			vFc001.setZrf_name(Common.getSearchLike(Common.trim(txtZRF_NAMEFIND)));
			vFc001.setCsf_name(Common.getSearchLike(Common.trim(txtCSF_NAMEFIND)));
			vFc001.setUpdatetime_min(Common.convertStringToTimestamp(txtUPDATETIME_MINFIND));
			vFc001.setUpdatetime_max(Common.convertStringToTimestamp(txtUPDATETIME_MAXFIND));
			vFc001.setPageIndex(pageIndex);
			vFc001.setPageSize(getPageSize());
			// 执行查询
			tabList = tFc001Service.LoadAllPaymentInfo(vFc001);

			// 分页设置
			if (null != tabList && tabList.size() > 0) {
				rowCount = Common.checkNull(tabList.get(0).getRecordCount());
			} else {
				pageIndex = 1;
				rowCount = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("loadAllOverodueTax() ********** end **********");
		}
		return SUCCESS;
	}
	/**
	 * 完税认定审核
	 */
	public String loadAllTaxAuditedInfo() throws Exception{	
		if (LOG.isDebugEnabled()) {
			LOG.debug("loadAllOverodueTax() ********** start **********");
		} 

		PgvFc001 vFc001 = new PgvFc001();
		try { 
			// 准备查询条件
			vFc001.setSlid(Common.getSearchLike(Common.trim(txtSLIDFIND)));
			vFc001.setZrf_name(Common.getSearchLike(Common.trim(txtZRF_NAMEFIND)));
			vFc001.setCsf_name(Common.getSearchLike(Common.trim(txtCSF_NAMEFIND)));
			vFc001.setUpdatetime_min(Common.convertStringToTimestamp(txtJYSJ_MINFIND));
			vFc001.setUpdatetime_max(Common.convertStringToTimestamp(txtJYSJ_MAXFIND));
			vFc001.setPageIndex(pageIndex);
			vFc001.setPageSize(getPageSize());
			// 执行查询
			tabList = tFc001Service.LoadAllTaxAuditedInfo(vFc001);

			// 分页设置
			if (null != tabList && tabList.size() > 0) {
				rowCount = Common.checkNull(tabList.get(0).getRecordCount());
			} else {
				pageIndex = 1;
				rowCount = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("loadAllOverodueTax() ********** end **********");
		}
		return SUCCESS;
	}
	public String detailFc002() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** start **********");
		}
		PgtFc002 tfc002 = new PgtFc002();
		tFc002Bean = new PgtFc002();
		try {
			// 准备查询条件
			tfc002.setSlid(SLID);
			tfc002.setSsqy(SSQY);
			// 执行查询
			tFc002Bean = tFc001Service.LoadByPrimaryKey(tfc002);
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
	public String export2() throws Exception {
		PgvFc001 vFc001 = new PgvFc001();
		try{
			//准备查询条件
			vFc001.setSlid(Common.getSearchLike(Common.trim(txtSLIDFIND)));
			vFc001.setLfdz(Common.getSearchLike(Common.trim(txtLFDZFIND)));
			vFc001.setZrf_name(Common.getSearchLike(Common.trim(txtZRF_NAMEFIND)));
			vFc001.setCsf_name(Common.getSearchLike(Common.trim(txtCSF_NAMEFIND)));
			vFc001.setUpdatetime_min(Common.convertStringToTimestamp(txtUPDATETIME_MINFIND));
			vFc001.setUpdatetime_max(Common.convertStringToTimestamp(txtUPDATETIME_MAXFIND));
			vFc001.setPageIndex(1);
			vFc001.setPageSize(-1);
			ByteArrayOutputStream out = (ByteArrayOutputStream) tFc001Service.ExportPaymentInfo(vFc001);
			excelStream = new ByteArrayInputStream(out.toByteArray());
		}catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());
			return INPUT;
		}
		return SUCCESS;
	}
	/**
	 * 房产方--房产证信息查询
	 */
	public String loadAllHouseInfo() throws Exception{	
		if (LOG.isDebugEnabled()) {
			LOG.debug("loadAllOverodueTax() ********** start **********");
		}

		PgvFc001 vFc001 = new PgvFc001();
		try { 
			// 准备查询条件
			vFc001.setCqr(Common.getSearchLike(Common.trim(txtCQRFIND)));
			vFc001.setFczh(Common.getSearchLike(Common.trim(txtFCZHFIND)));
			vFc001.setFzrq_min(Common.convertStringToTimestamp(txtFZRQ_MINFIND));
			vFc001.setFzrq_max(Common.convertStringToTimestamp(txtFZRQ_MAXFIND));
			vFc001.setPageIndex(pageIndex);
			vFc001.setPageSize(getPageSize());
			// 执行查询
			tabList = tFc001Service.LoadAllHouseInfo(vFc001);

			// 分页设置
			if (null != tabList && tabList.size() > 0) {
				rowCount = Common.checkNull(tabList.get(0).getRecordCount());
			} else {
				pageIndex = 1;
				rowCount = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("loadAllOverodueTax() ********** end **********");
		}
		return SUCCESS;
	}
	public String export3() throws Exception {
		PgvFc001 vFc001 = new PgvFc001();
		try{
			//准备查询条件
			vFc001.setCqr(Common.getSearchLike(Common.trim(txtCQRFIND)));
			vFc001.setFczh(Common.getSearchLike(Common.trim(txtFCZHFIND)));
			vFc001.setFzrq_min(Common.convertStringToTimestamp(txtFZRQ_MINFIND));
			vFc001.setFzrq_max(Common.convertStringToTimestamp(txtFZRQ_MAXFIND));
			vFc001.setPageIndex(1);
			vFc001.setPageSize(-1);
			ByteArrayOutputStream out = (ByteArrayOutputStream) tFc001Service.ExportHouseInfo(vFc001);
			excelStream = new ByteArrayInputStream(out.toByteArray());
		}catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());
			return INPUT;
		}
		return SUCCESS;
	}
	public String detailFc003() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** start **********");
		}
		PgtFc003 tfc003 = new PgtFc003();
		tfc003Bean = new PgtFc003();
		try {
			// 准备查询条件
			tfc003.setId(ID);
			// 执行查询
			tfc003Bean = tFc001Service.LoadByPrimaryKey(tfc003);
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
	 * 房产方--办证但未完税记录查询
	 */
	public String loadAllUnpaidRecord() throws Exception{	
		if (LOG.isDebugEnabled()) {
			LOG.debug("loadAllOverodueTax() ********** start **********");
		}

		PgvFc001 vFc001 = new PgvFc001();
		try { 
			// 准备查询条件
			vFc001.setCqr(Common.getSearchLike(Common.trim(txtCQRFIND)));
			vFc001.setFczh(Common.getSearchLike(Common.trim(txtFCZHFIND)));
			vFc001.setFzrq_min(Common.convertStringToTimestamp(txtFZRQ_MINFIND));
			vFc001.setFzrq_max(Common.convertStringToTimestamp(txtFZRQ_MAXFIND));
			vFc001.setPageIndex(pageIndex);
			vFc001.setPageSize(getPageSize());
			// 执行查询
			tabList = tFc001Service.LoadAllUnpaidRecord(vFc001);

			// 分页设置
			if (null != tabList && tabList.size() > 0) {
				rowCount = Common.checkNull(tabList.get(0).getRecordCount());
			} else {
				pageIndex = 1;
				rowCount = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("loadAllOverodueTax() ********** end **********");
		}
		return SUCCESS;
	}
	public String export4() throws Exception {
		PgvFc001 vFc001 = new PgvFc001();
		try{
			//准备查询条件
			vFc001.setCqr(Common.getSearchLike(Common.trim(txtCQRFIND)));
			vFc001.setFczh(Common.getSearchLike(Common.trim(txtFCZHFIND)));
			vFc001.setFzrq_min(Common.convertStringToTimestamp(txtFZRQ_MINFIND));
			vFc001.setFzrq_max(Common.convertStringToTimestamp(txtFZRQ_MAXFIND));
			vFc001.setPageIndex(1);
			vFc001.setPageSize(-1);
			ByteArrayOutputStream out = (ByteArrayOutputStream) tFc001Service.ExportUnpaidRecord(vFc001);
			excelStream = new ByteArrayInputStream(out.toByteArray());
		}catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());
			return INPUT;
		}
		return SUCCESS;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionCtrl.appSession = arg0;
		
	}
	@JSON(deserialize = false, serialize = false)
	public IPgtFc001Service gettFc001Service() {
		return tFc001Service;
	}
	public void settFc001Service(IPgtFc001Service tFc001Service) {
		this.tFc001Service = tFc001Service;
	}
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getRowCount() {
		return rowCount;
	}
	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
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
	public ArrayList<PgvFc001> getTabList() {
		return tabList;
	}
	public void setTabList(ArrayList<PgvFc001> tabList) {
		this.tabList = tabList;
	}
	public String getTxtSLIDFIND() {
		return txtSLIDFIND;
	}
	public void setTxtSLIDFIND(String txtSLIDFIND) {
		this.txtSLIDFIND = txtSLIDFIND;
	}
	public String getTxtSSQYFIND() {
		return txtSSQYFIND;
	}
	public void setTxtSSQYFIND(String txtSSQYFIND) {
		this.txtSSQYFIND = txtSSQYFIND;
	}
	public PgtFc001 gettFc001Bean() {
		return tFc001Bean;
	}
	public void settFc001Bean(PgtFc001 tFc001Bean) {
		this.tFc001Bean = tFc001Bean;
	}
	public String getACT() {
		return ACT;
	}
	public void setACT(String aCT) {
		ACT = aCT;
	}
	public String getTxtSSQY() {
		return txtSSQY;
	}
	public void setTxtSSQY(String txtSSQY) {
		this.txtSSQY = txtSSQY;
	}
	public String getTxtNOTE() {
		return txtNOTE;
	}
	public void setTxtNOTE(String txtNOTE) {
		this.txtNOTE = txtNOTE;
	}
	public String getTxtUPDATE() {
		return txtUPDATE;
	}
	public void setTxtUPDATE(String txtUPDATE) {
		this.txtUPDATE = txtUPDATE;
	}
	public String getTxtSLID() {
		return txtSLID;
	}
	public void setTxtSLID(String txtSLID) {
		this.txtSLID = txtSLID;
	}
	public Boolean getIsExists() {
		return isExists;
	}
	public void setIsExists(Boolean isExists) {
		this.isExists = isExists;
	}
	public String getACTIONNAME() {
		return ACTIONNAME;
	}
	public void setACTIONNAME(String aCTIONNAME) {
		ACTIONNAME = aCTIONNAME;
	}
	public String getHREFNAME() {
		return HREFNAME;
	}
	public void setHREFNAME(String hREFNAME) {
		HREFNAME = hREFNAME;
	}
	public String getTITLENAME() {
		return TITLENAME;
	}
	public void setTITLENAME(String tITLENAME) {
		TITLENAME = tITLENAME;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getPk() {
		return pk;
	}
	public void setPk(String pk) {
		this.pk = pk;
	}
	public String getTxtID() {
		return txtID;
	}
	public void setTxtID(String txtID) {
		this.txtID = txtID;
	}
	public String getMsgDel() {
		return msgDel;
	}
	public void setMsgDel(String msgDel) {
		this.msgDel = msgDel;
	}
	public String getChkDel() {
		return chkDel;
	}
	public void setChkDel(String chkDel) {
		this.chkDel = chkDel;
	}
	public SessionCtrl getSessionCtrl() {
		return sessionCtrl;
	}
	public void setSessionCtrl(SessionCtrl sessionCtrl) {
		this.sessionCtrl = sessionCtrl;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public PgvFc001 getVfc001Bean() {
		return vfc001Bean;
	}
	public void setVfc001Bean(PgvFc001 vfc001Bean) {
		this.vfc001Bean = vfc001Bean;
	}
	public String getSLID() {
		return SLID;
	}
	public void setSLID(String sLID) {
		SLID = sLID;
	}
	public String getSSQY() {
		return SSQY;
	}
	public void setSSQY(String sSQY) {
		SSQY = sSQY;
	}
	public PgtFc002 gettFc002Bean() {
		return tFc002Bean;
	}
	public void settFc002Bean(PgtFc002 tFc002Bean) {
		this.tFc002Bean = tFc002Bean;
	}
	public String getRdoMSSIGN() {
		return rdoMSSIGN;
	}
	public void setRdoMSSIGN(String rdoMSSIGN) {
		this.rdoMSSIGN = rdoMSSIGN;
	}
	public String getTxtDJZ_QS() {
		return txtDJZ_QS;
	}
	public void setTxtDJZ_QS(String txtDJZ_QS) {
		this.txtDJZ_QS = txtDJZ_QS;
	}
	public String getTxtDJZ_YYS() {
		return txtDJZ_YYS;
	}
	public void setTxtDJZ_YYS(String txtDJZ_YYS) {
		this.txtDJZ_YYS = txtDJZ_YYS;
	}
	public String getTxtDJZ_CJS() {
		return txtDJZ_CJS;
	}
	public void setTxtDJZ_CJS(String txtDJZ_CJS) {
		this.txtDJZ_CJS = txtDJZ_CJS;
	}
	public String getTxtDJZ_DFJYS() {
		return txtDJZ_DFJYS;
	}
	public void setTxtDJZ_DFJYS(String txtDJZ_DFJYS) {
		this.txtDJZ_DFJYS = txtDJZ_DFJYS;
	}
	public String getTxtDJZ_GRSDS() {
		return txtDJZ_GRSDS;
	}
	public void setTxtDJZ_GRSDS(String txtDJZ_GRSDS) {
		this.txtDJZ_GRSDS = txtDJZ_GRSDS;
	}
	public String getTxtDJZ_YHS() {
		return txtDJZ_YHS;
	}
	public void setTxtDJZ_YHS(String txtDJZ_YHS) {
		this.txtDJZ_YHS = txtDJZ_YHS;
	}
	public String getTxtDJZ_TDZZS() {
		return txtDJZ_TDZZS;
	}
	public void setTxtDJZ_TDZZS(String txtDJZ_TDZZS) {
		this.txtDJZ_TDZZS = txtDJZ_TDZZS;
	}
	public String getTxtFPHM() {
		return txtFPHM;
	}
	public void setTxtFPHM(String txtFPHM) {
		this.txtFPHM = txtFPHM;
	}
	public String getTxtQSSPHM() {
		return txtQSSPHM;
	}
	public void setTxtQSSPHM(String txtQSSPHM) {
		this.txtQSSPHM = txtQSSPHM;
	}
	public String getTxtDFGSSPHM() {
		return txtDFGSSPHM;
	}
	public void setTxtDFGSSPHM(String txtDFGSSPHM) {
		this.txtDFGSSPHM = txtDFGSSPHM;
	}
	public String getTxtUPDATETIME() {
		return txtUPDATETIME;
	}
	public void setTxtUPDATETIME(String txtUPDATETIME) {
		this.txtUPDATETIME = txtUPDATETIME;
	}
	@JSON(deserialize = false, serialize = false)
	public IPgt00004Service getT00004Service() {
		return t00004Service;
	}
	public void setT00004Service(IPgt00004Service t00004Service) {
		this.t00004Service = t00004Service;
	}
	public List<Pgt00004> getMszcyjList() {
		return mszcyjList;
	}
	public void setMszcyjList(List<Pgt00004> mszcyjList) {
		this.mszcyjList = mszcyjList;
	}
	public boolean isRdState() {
		return rdState;
	}
	public void setRdState(boolean rdState) {
		this.rdState = rdState;
	}
	public String getResSign() {
		return resSign;
	}
	public void setResSign(String resSign) {
		this.resSign = resSign;
	}
	public String getResMsg() {
		return resMsg;
	}
	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}
	public String getTxtMSZCYJ() {
		return txtMSZCYJ;
	}
	public void setTxtMSZCYJ(String txtMSZCYJ) {
		this.txtMSZCYJ = txtMSZCYJ;
	}
	public String getTxtDEL_CZR() {
		return txtDEL_CZR;
	}
	public void setTxtDEL_CZR(String txtDEL_CZR) {
		this.txtDEL_CZR = txtDEL_CZR;
	}
	public boolean isBgFlag() {
		return bgFlag;
	}
	public void setBgFlag(boolean bgFlag) {
		this.bgFlag = bgFlag;
	}
	public String getTxtZRF_NAMEFIND() {
		return txtZRF_NAMEFIND;
	}
	public void setTxtZRF_NAMEFIND(String txtZRF_NAMEFIND) {
		this.txtZRF_NAMEFIND = txtZRF_NAMEFIND;
	}
	public String getTxtCSF_NAMEFIND() {
		return txtCSF_NAMEFIND;
	}
	public void setTxtCSF_NAMEFIND(String txtCSF_NAMEFIND) {
		this.txtCSF_NAMEFIND = txtCSF_NAMEFIND;
	}
	public String getTxtJYSJ_MINFIND() {
		return txtJYSJ_MINFIND;
	}
	public void setTxtJYSJ_MINFIND(String txtJYSJ_MINFIND) {
		this.txtJYSJ_MINFIND = txtJYSJ_MINFIND;
	}
	public String getTxtJYSJ_MAXFIND() {
		return txtJYSJ_MAXFIND;
	}
	public void setTxtJYSJ_MAXFIND(String txtJYSJ_MAXFIND) {
		this.txtJYSJ_MAXFIND = txtJYSJ_MAXFIND;
	}
	public String getTxtUPDATETIME_MINFIND() {
		return txtUPDATETIME_MINFIND;
	}
	public void setTxtUPDATETIME_MINFIND(String txtUPDATETIME_MINFIND) {
		this.txtUPDATETIME_MINFIND = txtUPDATETIME_MINFIND;
	}
	public String getTxtUPDATETIME_MAXFIND() {
		return txtUPDATETIME_MAXFIND;
	}
	public void setTxtUPDATETIME_MAXFIND(String txtUPDATETIME_MAXFIND) {
		this.txtUPDATETIME_MAXFIND = txtUPDATETIME_MAXFIND;
	}
	public String getTxtFZRQ_MINFIND() {
		return txtFZRQ_MINFIND;
	}
	public void setTxtFZRQ_MINFIND(String txtFZRQ_MINFIND) {
		this.txtFZRQ_MINFIND = txtFZRQ_MINFIND;
	}
	public String getTxtFZRQ_MAXFIND() {
		return txtFZRQ_MAXFIND;
	}
	public void setTxtFZRQ_MAXFIND(String txtFZRQ_MAXFIND) {
		this.txtFZRQ_MAXFIND = txtFZRQ_MAXFIND;
	}
	public ByteArrayInputStream getExcelStream() {
		return excelStream;
	}
	public void setExcelStream(ByteArrayInputStream excelStream) {
		this.excelStream = excelStream;
	}
	public String getTxtLFDZFIND() {
		return txtLFDZFIND;
	}
	public void setTxtLFDZFIND(String txtLFDZFIND) {
		this.txtLFDZFIND = txtLFDZFIND;
	}
	public String getTxtCQRFIND() {
		return txtCQRFIND;
	}
	public void setTxtCQRFIND(String txtCQRFIND) {
		this.txtCQRFIND = txtCQRFIND;
	}
	public String getTxtFCZHFIND() {
		return txtFCZHFIND;
	}
	public void setTxtFCZHFIND(String txtFCZHFIND) {
		this.txtFCZHFIND = txtFCZHFIND;
	}
	public PgtFc003 getTfc003Bean() {
		return tfc003Bean;
	}
	public void setTfc003Bean(PgtFc003 tfc003Bean) {
		this.tfc003Bean = tfc003Bean;
	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getTxtREMARKS() {
		return txtREMARKS;
	}
	public void setTxtREMARKS(String txtREMARKS) {
		this.txtREMARKS = txtREMARKS;
	}
	
}
