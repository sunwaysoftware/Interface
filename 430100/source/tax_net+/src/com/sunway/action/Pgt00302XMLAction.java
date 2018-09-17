package com.sunway.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

import org.apache.axis2.AxisFault;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPg30001Service;
import com.sunway.service.IPg30002Service;
import com.sunway.service.IPgt00001Service;
import com.sunway.service.IPgt00301Service;
import com.sunway.service.IPgt00302Service;
import com.sunway.service.IPgt00302eService;
import com.sunway.service.IPgt00303Service;
import com.sunway.service.IWBJH00Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.ConvertUtil;
import com.sunway.util.Excel;
import com.sunway.util.FileUtil;
import com.sunway.util.FormatUtil;
import com.sunway.util.MakeUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.util.XML;
import com.sunway.vo.Pgt00301;
import com.sunway.vo.Pgt00302;
import com.sunway.vo.Pgt00303;
import com.sunway.vo.Pgt00352xml;
import com.sunway.vo.Pgt00370;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv00302;
import com.sunway.vo.Pgv00302e;
import com.sunway.vo.Pgv00303;
import com.sunway.vo.Pgv00331;
import com.sunway.vo.Pgv00357;
import com.sunway.webservice.WebXml;

/**
 * 市场法房地产信息（PGT00302）
 * 
 * @author Lee create
 * @author Andy.Gao fix
 * @version 1.0
 */

public class Pgt00302XMLAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 7340547184590608770L;
	
	// 金三数据源
	private String gt3DriverClass;
	private String gt3DSUrl;
	private String gt3User;
	private String gt3Password;
	
	// Service
	private IPgt00302Service t00302Service;
	private IPgt00303Service t00303Service;
	private IPgt00302eService t00302eService;
	private IPgt00301Service t00301Service;
	private IPg30001Service pg30001Service;
	private IPg30002Service pg30002Service;
	private IPgt00001Service t00001Service;
	private IWBJH00Service WBJH00Service;
	// View
	private ArrayList<Pgv00052> szqyList;
	private ArrayList<Pgv00302e> qtxzList;
	// 分页参数
	private Integer pageIndex;
	private Integer pageSize;
	private Integer total;
	// Bean数组
	private ArrayList<Pgt00352xml> rows;
	// 检索条件
	private String txtFCIDFind;
	private String txtSWIDFind;
	private String txtNSRMCFind;
	private String txtFDCDATFind;
	private String txtXQFind;
	private String txtFWTDZLFind;
	private String ddlSZQYFind;
	// 编辑操作符
	private String ACT;
	// primary key 主键
	private String FCID;
	private String PGJG;
	// detail页面所需Bean
	private Pgv00302 v00302Bean;
	private Pgt00352xml t00352Bean;
	private String SWID;
	// edit页面所需Bean
	private Pgt00352xml bean;
	private Pgt00301 t00301Bean;
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
	private String txtSZLC;
	private String txtBWJFH;
	private String txtJYJG;
	private String txtDTGJ;
	private String txtTDSYQMJ;
	private String txtRJL;
	private String txtJYSJ;
	private String txtFDCDAT;
	private String txtNOTET00302;
	private String txtJZJG;
	private String rdoYWDT;
	private String rdoYWJKC;
	private String txtZLC;
	private String txtNOTE;

	private String XZLX;
	private String hidQTXZ;
	private String txtXQDM;
	private String FWTDZL;
	private String hidNsrmc;
	private Boolean forward;
	private String txtBGSJ;
	private String ddlBGLX;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	private String txtNSRMC;
	private String txtZJLX;
	private String txtZZ;
	private String txtLXDH;
	private String txtYDDH;
	private String txtNOTET00301;
	private Pgv00303 v00303Bean;
	private String txtFCZH;
	private String txtQDH;
	private String txtCB;
	private String txtGHYT;
	private String txtHXJG;
	private String txtJCSJ;
	private String txtDJRQ;
	private String txtJTZKId;
	private String txtWYZKId;
	private String txtZXZKId;
	private String txtZCDZL;
	private String txtZCDZBM;
	private String SysDate;
	private String hidPARENTDM;
	private String hidXQZT;
	private String ddlSZQY;
	private String txtXJXQMC;
	private String txtLH;
	private Boolean FROMCJ;// 采集标识

	private String FCZH;
	private Boolean ISEXISTFCZH;
	private String txtCLH;
	private String hidZHXZid;

	// file upload
	private File upload;
	private String fileServerPath;
	private String uploadFileName;
	private String savePath;

	// file import
	private String txtFilePath;
	private ArrayList<Pgv00357> Pgv00357List;
	private InputStream excelStream;
	private String fileName;
	private String txtFCSLH;

	// 受理标识
	private boolean txtSLSIGN;
	private String isVal;

	// 查询
	private String txtFCSLHFIND;
	private String txtCLHFIND;
	private String txtFHFIND;
	private String txtXQTIP;

	private String txtFCID;
	private String txtPGJG;

	private String txtRes;

	private String psSign;

	private String txtZRFSFIDFIND;
	private String txtZRFMCFIND;

	private String txtFWLXSL;
	private String txtEDIT;

	// 修改页面提交信息
	private String txtZRFMCEDIT;
	private String txtZRFSFLXEDIT;
	private String txtZRFSFIDEDIT;
	private String txtCSFMCEDIT;
	private String txtCSFSFLXEDIT;
	private String txtCSFSFIDEDIT;
	private String txtCLHEDIT;
	private String txtLFDZEDIT;
	private String txtDYFHEDIT;
	private String txtSZLCEDIT;
	private String txtJZJGTTIP;
	private String txtGHYTTTIP;
	private String txtYFCZHEDIT;
	private String txtJZMJEDIT;
	private String txtJYJGEDIT;
	private String txtJYSJEDIT;
	private String txtJYLXTIP;
	private String txtFWLXTIP;
	private String txtFZRQEDIT;
	private String txtYJGEDIT;
	private String txtPGJGEDIT;

	private Pgt00370 t00370Bean;
	private String resSign;

	// 确认数据参数
	private String FCIDSUB; // 确认表中插入数据操作FCID参数
	private String INFOMSGSUB; // 确认表中插入数据操作备注信息参数
	private String resMsg; // 操作返回信息
	private String txtCQRNMFIND; // 确认表中查询数据操作产权人姓名参数
	private String txtCQRZJHMFIND; // 确认表中查询数据操作产权人证件号码参数
	private String actCount; // 操作次数，用来判断是否数据已存在，是否更新操作
	private String OINSID; // 调用WS取消挂起的KEY

	// 372测试
	private String testTxt;
	private String SLSign;
	private String SLMsg;
	
	private String userRole;

	/*********************** webservice数据操作 ******************************/
	public String xml() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("xml() ********** start **********");
		}

		if ("HN".equals(SLSign)) {
			// 此处为测试
			// 判断标识如果为HN代表湖南接口，则调用方法，并返回
			SLMsg = hnXML();
			txtSLSIGN = false;
			txtRes = "4";
			return SUCCESS;
		}
		txtSLSIGN = false;
		XML person = new XML();
		WebXml web = new WebXml();
		Pgt00352xml t00352xml = null;
		// sessionCtrl = new
		// SessionCtrl(ActionContext.getContext().getSession());
		try {
			Pgt00352xml pgt00352xml = new Pgt00352xml();
			pgt00352xml.setFCSLH(txtFCSLH);
			if (!"".equals(txtFCSLH) && null != txtFCSLH) {
				// 组织请求报文XML
				String fcid = person.getxml(txtFCSLH,
						sessionCtrl.Get(SessionCtrl.FCBMBM));
				String retXML = null;
				try {
					retXML = web.web(fcid, sessionCtrl.Get(SessionCtrl.FCJKDZ));
				} catch (AxisFault e) {
					txtRes = "2";
					SLMsg = e.getMessage();
					return SUCCESS;
				} catch (Exception e) {
					txtRes = "5";
					SLMsg = e.getMessage();
					return SUCCESS;
				}
				try {
					pgt00352xml = person.jxxml(retXML, sessionCtrl.getUserId(),
							sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
					if ("1".equals(pgt00352xml.getErrorSign())) {
						txtRes = "-1";
						return SUCCESS;
					}
				} catch (Exception e) {
					txtRes = "2";
					SLMsg = e.getMessage();
					return SUCCESS;
				}
				// 判断WS是否取空
				if (pgt00352xml.getPgt00352xmllist().size() == 0) {
					txtRes = "3";
					return SUCCESS;
				}
				rows = pgt00352xml.getPgt00352xmllist();
				if (null == isVal || "".equals(isVal)) {
					// 验证是否已存在
					for (int i = 0; i < pgt00352xml.getPgt00352xmllist().size(); i++) {
						t00352xml = pgt00352xml.getPgt00352xmllist().get(i);
						if (t00302Service.JCXML(t00352xml) == 1) {
							txtSLSIGN = true;
							return SUCCESS;
						}
					}
				}

				// 插入数据库
				if (txtSLSIGN == false) {
					// 当数据已被采集，需要先删除
					if ("ok".equals(isVal)) {
						for (int i = 0; i < rows.size(); i++) {
							t00352xml = rows.get(i);
							t00302Service.GetDeleteCommandXML(t00352xml);
						}
					}
					t00302Service.GetInsertCommandXML(rows);
					isVal = "";
				}
			} else {
				txtRes = "1";
				return SUCCESS;
			}
			// 分页设置
			if (null != rows && rows.size() > 0) {
				total = CheckUtil.chkNull(rows.get(0).getRecordCount());
			} else {
				total = 0;
				pageIndex = 1;
			}

		} catch (Exception e) {
			LOG.error(e.getMessage());
			LOG.error("Pgt00302XMLAction -- xml()", e);
			SLMsg = e.getMessage();
			return ERROR;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("xml() ********** end **********");
		}
		return SUCCESS;

	}

	/**
	 * 湖南接口测试方法
	 * 
	 * @return
	 */
	protected String hnXML() {
		String result = "";
		try {
			// 根据受理号获得数据列表
			// sessionCtrl = new
			// SessionCtrl(ActionContext.getContext().getSession());
			Pgt00352xml t00352xml = new Pgt00352xml();
			t00352xml.setFCSLH(txtFCSLH);
			t00352xml.setCzr(sessionCtrl.getUserId());
			t00352xml.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			ArrayList<Pgt00352xml> tempList = t00302Service
					.LoadByFCSLH372(t00352xml);

			// 获取数据后插入371中
			t00302Service.GetInsertCommandXML(tempList);
			result = "受理成功";
		} catch (Exception e) {
			LOG.error("Pgt00302XMLAction -- hnXML()", e);
			result = "获取数据和插入库中阶段出错：" + e.getMessage();
		}
		return result;
	}

	/**
	 * 查询状态处理
	 * 
	 * @return
	 * @throws Exception
	 */
	public String queryxml() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}

		Pgt00352xml t00352xml = new Pgt00352xml();

		try {
			// sessionCtrl = new
			// SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件

			// 执行查询
			t00352xml.setPageIndex(pageIndex);
			t00352xml.setPageSize(getPageSize());
			t00352xml.setFCSLH(CheckUtil.chkTrim(txtFCSLHFIND));
			t00352xml.setCLH(CheckUtil.chkTrim(txtCLHFIND));
			t00352xml.setDYFH(CheckUtil.chkTrim(txtFHFIND));
			t00352xml.setCzr(sessionCtrl.getUserId());
			t00352Bean = t00302Service.LoadAllXML(t00352xml);
			rows = t00352Bean.getPgt00352xmllist();
			// 分页设置
			if (null != rows && rows.size() > 0) {
				total = CheckUtil.chkNull(rows.get(0).getRecordCount());
			} else {
				pageIndex = 1;
				total = 0;
			}

		} catch (Exception e) {
			LOG.error("Pgt00302XMLAction -- queryxml()", e);
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
	public String queryByPrimary() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}

		Pgt00352xml t00352xml = new Pgt00352xml();

		try {
			// 执行查询
			t00352xml.setFcid(FCID);
			t00352Bean = t00302Service.LoadByPrimaryKeyXML(t00352xml);

		} catch (Exception e) {
			LOG.error("Pgt00302XMLAction -- queryByPrimary()", e);
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
	public String createxml() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** start **********");
		}
		String rtn = "successADD";
		Pgt00352xml t00352xml = new Pgt00352xml();
		v00303Bean = new Pgv00303();
		t00301Bean = new Pgt00301();
		v00302Bean = new Pgv00302();
		try {
			ReadInfo();
			// sessionCtrl = new
			// SessionCtrl(ActionContext.getContext().getSession());
			if (Constant.MOD_CREATE.equals(getACT())) {
				// 取得用户选中的数据信息
				t00352xml.setFcid(FCID);
				t00352Bean = t00302Service.LoadByPrimaryKeyXML(t00352xml);
				// 如果FCID存在不给添加
				Pgt00302 t00302 = new Pgt00302();
				t00302.setFcid(FCID);
				t00302 = t00302Service.LoadByPrimaryKey(t00302);
				if (CheckUtil.chkEmpty(t00302.getFcid())) {
					// 基本信息
					t00301Bean.setCd00001Zjlx(t00352Bean.getCd00001zrfsflx());
					t00301Bean.setNsrmc(t00352Bean.getZRFMC());
					t00301Bean.setSwid(t00352Bean.getZRFSFID());
					t00301Bean.setLxdh(t00352Bean.getZrfTel());
					v00302Bean.setCd00001csfzjlx(t00352Bean.getCd00001csfsflx());
					v00302Bean.setCsfzjhm(t00352Bean.getCSFSFID());
					v00302Bean.setCsfnsrmc(t00352Bean.getCSFMC());
					v00302Bean.setCsflxdh(t00352Bean.getCsfTel());
					// 国土信息
					v00302Bean.setFcid(FCID);
					v00302Bean.setFczh(t00352Bean.getYFCZH());
					v00302Bean.setClh(t00352Bean.getCLH());
					v00302Bean.setZcdzl(t00352Bean.getLFDZ());
					v00302Bean.setBwjfh(t00352Bean.getDYFH());
					v00302Bean.setSzlcmc(t00352Bean.getSZLC());
					v00302Bean.setCd00001Jzjg(t00352Bean.getCd00001jzjg());
					v00302Bean.setCd00001Ghyt(t00352Bean.getCd00001sjyt());
					v00302Bean.setCd00001Fwlx(t00352Bean.getCd00001fwlx());
					v00302Bean.setJzmj(t00352Bean.getJZMJ());
					v00302Bean.setJyjg(t00352Bean.getHTZJ());
					v00302Bean.setJysj(t00352Bean.getJYSJ());
					v00302Bean.setCd00001Jylx(t00352Bean.getCd00001jylx());
					v00302Bean.setDjrq(t00352Bean.getFZRQ());
					v00302Bean.setSfsyfc(t00352Bean.getSfsyfc());
					v00302Bean.setYjg(t00352Bean.getYJG());
					v00302Bean.setSbpgjg(t00352Bean.getPGJG());
					v00302Bean.setJcsj(t00352Bean.getJcsj());
					v00302Bean.setWsjs(t00352Bean.getWsjs());
					v00302Bean.setWsrq(t00352Bean.getWsrq());
					v00303Bean.setZlc(ConvertUtil.toShort(t00352Bean.getZLC()));
					v00303Bean.setCd00001Szqy(t00352Bean.getSzqy());
					v00303Bean.setCd00352Xqdm(t00352Bean.getXqdm());
					v00303Bean.setXqnm(t00352Bean.getXqnm());
					v00302Bean.setId(t00352Bean.getId());
					
				}
				rtn = "success";

			} else {
				t00352Bean = new Pgt00352xml();
				SysDate = MakeUtil.currentDate();
			}

		} catch (Exception e) {
			LOG.error(e.getMessage());
			LOG.error("Pgt00302XMLAction -- createxml()", e);
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("create() ********** end **********");
			}
			return ERROR;
		} finally {
			FROMCJ = true;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** end **********");
		}
		String ssgx = sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX);
		//湘潭市地方税务局
		if("24303".equals(ssgx.substring(0, 5))){
			t00352Bean.setWsSign("Y");
		}
		return rtn;
	}

	/**
	 * 填补缺失信息
	 * 
	 * @param t00352xml
	 * @return
	 * @throws Exception
	 */
	protected Pgt00352xml valiFCXX(Pgt00352xml t00352xml) throws Exception {
		// if(CheckUtil.chkEmpty(t00352xml.getYFCZH()) ||
		// "null".equals(t00352xml.getYFCZH())){
		// t00352xml.setYFCZH("0000000000");
		// }
		// if(CheckUtil.chkEmpty(t00352xml.getZRFSFLX()) ||
		// "null".equals(t00352xml.getZRFSFLX())){
		// t00352xml.setZRFSFLX("居民身份证");
		// }
		// if(CheckUtil.chkEmpty(t00352xml.getZRFSFID()) ||
		// "null".equals(t00352xml.getZRFSFID())){
		// t00352xml.setZRFSFID("123456789098765432");
		// }
		// if(CheckUtil.chkEmpty(t00352xml.getZRFMC()) ||
		// "null".equals(t00352xml.getZRFMC())){
		// t00352xml.setZRFMC("承受方名称");
		// }
		// if(CheckUtil.chkEmpty(t00352xml.getCSFSFLX()) ||
		// "null".equals(t00352xml.getCSFSFLX())){
		// t00352xml.setCSFSFLX("居民身份证");
		// }
		if (CheckUtil.chkEmpty(t00352xml.getCSFSFID())
				|| "null".equals(t00352xml.getCSFSFID())) {
			t00352xml.setCSFSFID("098765432123456789");
		}
		// if(CheckUtil.chkEmpty(t00352xml.getCSFMC()) ||
		// "null".equals(t00352xml.getCSFMC())){
		// t00352xml.setCSFMC("转让方名称");
		// }
		// if(CheckUtil.chkEmpty(t00352xml.getCLH()) ||
		// "null".equals(t00352xml.getCLH())){
		// t00352xml.setCLH("12345678");
		// }
		// if(CheckUtil.chkEmpty(t00352xml.getSJYT()) ||
		// "null".equals(t00352xml.getSJYT())){
		// t00352xml.setSJYT("住宅");
		// }
		if (CheckUtil.chkEmpty(t00352xml.getLFDZ())
				|| "null".equals(t00352xml.getLFDZ())) {
			t00352xml.setLFDZ("无");
		}
		if (CheckUtil.chkEmpty(t00352xml.getDYFH())
				|| "null".equals(t00352xml.getDYFH())) {
			t00352xml.setDYFH("无");
		}
		if (CheckUtil.chkEmpty(t00352xml.getSZLC())
				|| "null".equals(t00352xml.getSZLC())) {
			t00352xml.setSZLC("1");
		}
		if (CheckUtil.chkEmpty(t00352xml.getZLC())
				|| "null".equals(t00352xml.getZLC())) {
			t00352xml.setZLC("1");
		}
		// if(CheckUtil.chkEmpty(t00352xml.getJZJG()) ||
		// "null".equals(t00352xml.getJZJG())){
		// t00352xml.setJZJG("混合");
		// }
		// if(CheckUtil.chkEmpty(t00352xml.getFWLX()) ||
		// "null".equals(t00352xml.getFWLX())){
		// t00352xml.setFWLX("高层住宅");
		// }
		// if(CheckUtil.chkEmpty(t00352xml.getJYLX()) ||
		// "null".equals(t00352xml.getJYLX())){
		// t00352xml.setJYLX("房屋交换");
		// }
		// if(CheckUtil.chkEmpty(t00352xml.getJZMJ()) ||
		// "null".equals(t00352xml.getJZMJ())){
		// t00352xml.setJZMJ("0.0");
		// }
		// if(CheckUtil.chkEmpty(t00352xml.getHTZJ()) ||
		// "null".equals(t00352xml.getHTZJ())){
		// t00352xml.setHTZJ("0.0");
		// }
		// if(CheckUtil.chkEmpty(t00352xml.getJYSJ()) ||
		// "null".equals(t00352xml.getJYSJ())){
		// t00352xml.setJYSJ("2000-01-01");
		// }
		// if(CheckUtil.chkEmpty(t00352xml.getFZRQ()) ||
		// "null".equals(t00352xml.getFZRQ())){
		// t00352xml.setFZRQ("2000-01-01");
		// }
		// if(CheckUtil.chkEmpty(t00352xml.getDF()) ||
		// "null".equals(t00352xml.getDF())){
		// t00352xml.setDF("非端房");
		// }
		// if(CheckUtil.chkEmpty(t00352xml.getCX()) ||
		// "null".equals(t00352xml.getCX())){
		// t00352xml.setCX("非南");
		// }
		// if(CheckUtil.chkEmpty(t00352xml.getCG()) ||
		// "null".equals(t00352xml.getCG())){
		// t00352xml.setCG("4.2米以内");
		// }
		// if(CheckUtil.chkEmpty(t00352xml.getYJG()) ||
		// "null".equals(t00352xml.getYJG())){
		// t00352xml.setYJG("0.0");
		// }
		// if(CheckUtil.chkEmpty(t00352xml.getPGJG()) ||
		// "null".equals(t00352xml.getPGJG())){
		// t00352xml.setPGJG("0.0");
		// }
		return t00352xml;
	}

	// /**
	// * 建筑结构判断
	// * @param jzjg
	// * @return
	// * @throws Exception
	// */
	// protected String valJZJG(String jzjg) throws Exception{
	// if("钢结构".equals(jzjg)){
	// return "钢结构";
	// }else if("钢、钢混".equals(jzjg)){
	// return "钢、钢混结构";
	// }else if("钢筋混凝土".equals(jzjg)){
	// return "钢筋混凝土结构";
	// }else if("混合".equals(jzjg)){
	// return "混合结构";
	// }else if("砖木".equals(jzjg)){
	// return "砖木结构";
	// }else if("其他".equals(jzjg)){
	// return "其他结构";
	// }
	// return "其他结构";
	// }

	// /**
	// * 交易类型判断
	// * @param jylx
	// * @return
	// * @throws Exception
	// */
	// protected String valJYLX(String jylx) throws Exception{
	// if("房屋二手房买卖".equals(jylx)){
	// return "二手房";
	// }else if("房屋商品房买卖".equals(jylx)){
	// return "商品房";
	// }else if("买卖".equals(jylx)){
	// return "房屋买卖";
	// }
	// return jylx;
	// }

	/**
	 * 更新操作前的验证处理
	 * 
	 * @throws Exception
	 */
	public void validateUpdateXML() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("validateUpdate() ********** start **********");
		}
		// sessionCtrl = new
		// SessionCtrl(ActionContext.getContext().getSession());
		t00352Bean = new Pgt00352xml();
		this.clearErrorsAndMessages();
		t00352Bean.setFcid(FCID);
		// 根据PK取得信息，并为BEAN赋值
		if (Constant.MOD_UPDATE.equals(getACT())) {
			bean = t00302Service.LoadByPrimaryKeyXML(t00352Bean);
		}

		bean.setSzqy(ddlSZQY);
		bean.setXqdm(txtXQDM);
		bean.setLxdh("");
		bean.setNote(bean.getDF());
		// bean.setJyjg(0.0);
		bean.setTdsyqmj(0.0);
		bean.setRjl(0.0);
		bean.setFdcdat("");
		bean.setCzr(sessionCtrl.getUserId());
		bean.setJcsj("");
		bean.setShr("");
		bean.setYwdt("");
		bean.setZcdzl("");
		bean.setZcdzbm("");
		bean.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
		bean.setXqzt(hidXQZT);
		bean.setParentdm(hidPARENTDM);
		bean.setXqnm(CheckUtil.chkTrim(txtXQTIP));
		bean.setYwjkc("");
		bean.setZhxz(hidZHXZid);
		/*
		 * bean.setYJG(txtYJGEDIT); bean.setPGJG(txtPGJGEDIT);
		 */
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
	public String updateXML() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** start **********");
		}
		String rtn = SUCCESS;
		try {
			if (Constant.MOD_UPDATE.equals(getACT())) { // Update
				if (t00302Service.GetUpdateCommandXML(getBean())) {

					/*
					 * t00352Bean =
					 * t00302Service.LoadByPrimaryKeyXML(t00352Bean);
					 * Pgt00352xml t00352XML = new Pgt00352xml();
					 * t00352XML.setFcid(t00352Bean.getFcid()); t00352Bean =
					 * t00302Service.LoadByPrimaryKeyXML(t00352XML);
					 */

					this.addActionMessage(getText(Constant.MSG_UPDATE_OK,
							new String[] { bean.getFCSLH() }));
				} else {
					this.addActionError(getText(Constant.MSG_UPDATE_NG,
							new String[] { bean.getFCSLH() }));
				}
				txtFCSLH = bean.getFCSLH();
				txtFCID = bean.getFcid();
			} else if (Constant.MOD_DELETE.equals(getACT())) { // Delete
				if (t00302Service.GetDeleteCommandXML(t00352Bean)) {
					this.addActionMessage(getText(Constant.MSG_DELETE_OK,
							new String[] { bean.getFCSLH() }));
					ACT = Constant.MOD_MODIFY;
					rtn = "successDEL";
				} else {
					this.addActionError(getText(Constant.MSG_DELETE_NG,
							new String[] { bean.getFCSLH() }));
				}
			}

		} catch (Exception e) {
			LOG.error(e.getMessage());
			LOG.error("Pgt00302XMLAction -- updateXML()", e);
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("update() ********** end **********");
			}
			return ERROR;
		} finally {
			// SysDate = MakeUtil.currentTime();
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** end **********");
		}

		return rtn;
	}
	
	

	public String executePS() throws Exception {
		this.clearErrorsAndMessages();
		Pgv00302 v00302 = new Pgv00302();
		try {
			// sessionCtrl = new
			// SessionCtrl(ActionContext.getContext().getSession());
			v00302.setPgCzr(sessionCtrl.getUserId());
			v00302.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v00302.setSysPssdYMD(ConvertUtil.toUtilDate(sessionCtrl
					.Get(SessionCtrl.SESSION_KEY_PSSD_YMD)));
			v00302.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v00302.setFcid(txtFCID);
			Pgt00352xml t00352xml = new Pgt00352xml();
			t00352xml.setFcid(txtFCID);
			t00352Bean = t00302Service.LoadByPrimaryKeyXML(t00352xml);
			txtFCSLH = t00352Bean.getFCSLH();
			v00302Bean = pg30001Service.GetExecPG(v00302);
			if (v00302Bean.getbResult() == 1) {
				psSign = "Y";
				this.addActionMessage("已通过估价！");
			} else {
				psSign = "N";
				this.addActionMessage("未通过估价！");
			}
		} catch (Exception e) {
			LOG.error("Pgt00302XMLAction -- executePS()", e);
			this.addActionError("估价时出现错误！");
			return INPUT;
		}

		t00352Bean.setFcid(txtFCID);
		t00352Bean.setPsSign(psSign);
		return SUCCESS;
	}

	public String loadResult() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("loadResult() ********** start **********");
		}
		// sessionCtrl = new
		// SessionCtrl(ActionContext.getContext().getSession());
		Pgv00331 v00331 = new Pgv00331();
		v00331.setCd00301Swid(FormatUtil.toSearchLike(txtZRFSFIDFIND));
		v00331.setNsrmc(FormatUtil.toSearchLike(txtZRFMCFIND));
		// v00331.setCd00301Swid(FormatUtil.toSearchLike("")));
		// v00331.setNsrmc(FormatUtil.toSearchLike(""));
		v00331.setPageIndex(1);
		v00331.setPageSize(-1);
		v00331.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
		v00331.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
		// 执行查询
		ArrayList<Pgv00331> list = pg30002Service.LoadPgOK(v00331);
		Pgt00352xml t00352xml = null;
		rows = new ArrayList<Pgt00352xml>();

		if ("Y".equals(psSign)) {

			// t00352xml.setFCSLH(txtFCSLH);
			for (int i = 0; i < list.size(); i++) {
				t00352xml = new Pgt00352xml();
				if (list.get(i).getCd00302Fcid().equals(txtFCID)) {
					t00352xml.setFcid(list.get(i).getCd00302Fcid());
					// t00352xml.setJyjg(list.get(i).getPgjg());
					t00352Bean = t00302Service.LoadByPrimaryKeyXML(t00352xml);
					t00352xml.setZRFSFID(t00352Bean.getZRFSFID());
					t00352xml.setZRFMC(t00352Bean.getZRFMC());
					t00352xml.setZcdzl(t00352Bean.getLFDZ());
					t00352xml.setPsSign(psSign);
					rows.add(t00352xml);
				}

			}
		} else {
			t00352xml = new Pgt00352xml();
			t00352xml.setFcid(txtFCID);
			// t00352xml.setJyjg(0.0);
			t00352Bean = t00302Service.LoadByPrimaryKeyXML(t00352xml);
			t00352xml.setZRFSFID(t00352Bean.getZRFSFID());
			t00352xml.setZRFMC(t00352Bean.getZRFMC());
			t00352xml.setZcdzl(t00352Bean.getLFDZ());
			t00352xml.setPsSign(psSign);
			rows.add(t00352xml);
		}

		// 分页设置
		if (null != rows && rows.size() > 0) {
			total = CheckUtil.chkNull(rows.get(0).getRecordCount());
		} else {
			pageIndex = 1;
			total = 0;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("loadResult() ********** end **********");
		}
		return SUCCESS;
	}

	public String executeEDIT() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("executeEDIT() ********** start **********");
		}
		// sessionCtrl = new
		// SessionCtrl(ActionContext.getContext().getSession());
		t00352Bean = new Pgt00352xml();
		t00352Bean.setFcid(FCID);
		if (Constant.MOD_UPDATE.equals(getACT())) {
			bean = t00302Service.LoadByPrimaryKeyXML(t00352Bean);
		}

		bean.setSzqy(ddlSZQY);
		bean.setXqdm(txtXQDM);
		bean.setZLC(txtZLC);
		bean.setLxdh("");
		bean.setNote(bean.getDF());
		// bean.setJyjg(0.0);
		bean.setTdsyqmj(0.0);
		bean.setRjl(0.0);
		bean.setFdcdat("");
		bean.setCzr(sessionCtrl.getUserId());
		bean.setJcsj("");
		bean.setShr("");
		bean.setYwdt("");
		bean.setZcdzl("");
		bean.setZcdzbm("");
		bean.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
		bean.setXqzt(hidXQZT);
		bean.setParentdm(hidPARENTDM);
		bean.setXqnm(CheckUtil.chkTrim(txtXQTIP));
		bean.setYwjkc("");
		bean.setZhxz(hidZHXZid);
		bean.setZRFMC(txtZRFMCEDIT);
		bean.setZRFSFLX(txtZRFSFLXEDIT);
		bean.setZRFSFID(txtZRFSFIDEDIT);
		bean.setCSFMC(txtCSFMCEDIT);
		bean.setCSFSFLX(txtCSFSFLXEDIT);
		bean.setCSFSFID(txtCSFSFIDEDIT);
		bean.setCLH(txtCLHEDIT);
		bean.setLFDZ(txtLFDZEDIT);
		bean.setDYFH(txtDYFHEDIT);
		bean.setSZLC(txtSZLCEDIT);
		bean.setJZJG(txtJZJGTTIP);
		bean.setSJYT(txtGHYTTTIP);
		bean.setYFCZH(txtYFCZHEDIT);
		bean.setJZMJ(ConvertUtil.toDouble(txtJZMJEDIT));
		// bean.setJyjg(ConvertUtil.toDouble(txtJYJGEDIT));
		bean.setHTZJ(ConvertUtil.toDouble(txtJYJGEDIT));
		bean.setJYSJ(ConvertUtil.toSqlDate(txtJYSJEDIT));
		bean.setJYLX(txtJYLXTIP);
		bean.setFWLX(txtFWLXTIP);
		bean.setFZRQ(ConvertUtil.toSqlDate(txtFZRQEDIT));
		bean.setYJG(ConvertUtil.toDouble(txtYJGEDIT));
		bean.setPGJG(ConvertUtil.toDouble(txtPGJGEDIT));
		try {
			if (Constant.MOD_UPDATE.equals(getACT())) { // Update
				if (t00302Service.GetUpdateCommand371(getBean())) {
					if (t00302Service.GetUpdateCommandXML(getBean()))
						this.addActionMessage(getText(Constant.MSG_UPDATE_OK,
								new String[] { bean.getFCSLH() }));
				} else {
					this.addActionError(getText(Constant.MSG_UPDATE_NG,
							new String[] { bean.getFCSLH() }));
				}
				txtFCSLH = bean.getFCSLH();
				txtFCID = bean.getFcid();
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			LOG.error("Pgt00302XMLAction -- executeEDIT()", e);
			if (LOG.isDebugEnabled()) {
				LOG.debug("executeEDIT() ********** end **********");
			}
			return ERROR;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("executeEDIT() ********** end **********");
		}

		return SUCCESS;
	}

	public String executeZF() throws Exception {
		return SUCCESS;
	}

	/*********************** 采集数据导入 ******************************/
	public String executeImport() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("executeImport() ********** start **********");
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("executeImport() ********** end **********");
		}
		return SUCCESS;
	}

	public String upload() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("upload() ********** start **********");
		}
		try {
			fileServerPath = getSavePath() + "\\" + getUploadFileName();
			FileOutputStream fos = new FileOutputStream(fileServerPath);
			FileInputStream fis = new FileInputStream(getUpload());

			int len = 0;
			byte[] buffer = new byte[1024];
			while ((len = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
			fis.close();
			fos.close();
		} catch (Exception e) {
			LOG.error(e.getMessage());
			LOG.error("Pgt00302XMLAction -- upload()", e);
			if (LOG.isDebugEnabled()) {
				LOG.debug("upload() ********** end **********");
			}
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("upload() ********** end **********");
		}
		return SUCCESS;
	}

	public void validateImportFile() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("validateImportFile() ********** start **********");
		}

		if (!FileUtil.checkFileExist(txtFilePath)) {
			this.addActionError("文件错误，请检查！");
		}
		try {
			// sessionCtrl = new
			// SessionCtrl(ActionContext.getContext().getSession());
			// 检验数据合法性
			Pgv00357List = Excel.importDataSjcj(txtFilePath,
					sessionCtrl.getUserId(),
					sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if (!checkKbslk(Pgv00357List))
				this.addActionError("采集数据不符合导入要求！");
			if (Pgv00357List.size() == 0)
				this.addActionError("采集数据不符合导入要求！");
		} catch (Exception ex) {
			ex.printStackTrace();
			LOG.error("Pgt00302XMLAction -- validateImportFile()", ex);
			this.addActionError("文件错误，请检查！" + ex.getMessage());
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("validateImportFile() ********** end **********");
		}
	}

	/**
	 * 对[挂牌数据]合法性进行检验
	 * 
	 * @param list
	 * @return
	 */
	private Boolean checkKbslk(ArrayList<Pgv00357> list) {
		return true;
	}

	public String importFile() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("importFile() ********** start **********");
		}

		Pgv00357 tmpV00357 = new Pgv00357();
		try {
			tmpV00357 = t00302Service.ImportExcelData(Pgv00357List);
		} catch (Exception ex) {
			ex.printStackTrace();
			LOG.error("Pgt00302XMLAction -- importFile()", ex);
			this.addActionError(ex.getMessage());
			return INPUT;
		} finally {
			if (tmpV00357.getOutFlag() == 3)
				this.addActionError("数据导入失败，请重新选择模版导入！");
			else if (tmpV00357.getOutFlag() == 2)
				this.addActionMessage("数据导入执行完毕！");
			else {
				ByteArrayOutputStream out = (ByteArrayOutputStream) Excel
						.exportDataSjcj(tmpV00357.getOutList());
				excelStream = new ByteArrayInputStream(out.toByteArray());
				fileName = new String("格式错误的采集数据.xls".getBytes("GBK"),
						"ISO-8859-1");
				return "failexport";
			}
			/*
			 * else if (tmpV00304.getOutFlag()==1)
			 * this.addActionMessage("数据导入执行完毕，但导入过程中部分失败！"); else
			 * this.addActionError("数据导入失败！");
			 */
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("importFile() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * WebService
	 * 
	 * @return
	 * @throws Exception
	 */
	public String executeWS() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("executeWS() ********** start **********");
		}
		readRole();
		// queryxml();
		if (LOG.isDebugEnabled()) {
			LOG.debug("executeWS() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 取得下拉菜单信息
	 * 
	 * @throws Exception
	 */
	private void ReadInfo() throws Exception {
		// sessionCtrl = new
		// SessionCtrl(ActionContext.getContext().getSession());
		// 取得所在区域列表信息
		szqyList = sessionCtrl.ReadSzqyList();
	}

	/**
	 * 发送国土数据至大集中
	 * 
	 * @return
	 * @throws Exception
	 */
	public String sendXMLI() throws Exception {
		
		try {
			if(WBJH00Service.InsGT3WBJH(FCID))
				resSign = "0";
			else
				resSign = "1";
		} catch (Exception e) {
			LOG.error(e.getMessage());
			SLMsg = e.getMessage();
			resSign = "1";
		} finally {
				
		}
		return SUCCESS;
		
//以下是原征管接口代码		
//		Pgv00302 v00302 = new Pgv00302();
//		v00302.setFcid(FCID);
//		v00302.setFclsh(t00001Service.GetLsh());
//		v00302.setDjz_channel_pwd(sessionCtrl.Get(SessionCtrl.CHANNEL_PWD));
//		v00302.setDjz_channel_acc(sessionCtrl.Get(SessionCtrl.CHANNEL_ACC));
//		v00302.setDjz_channel_code(sessionCtrl.Get(SessionCtrl.CHANNEL_CODE));
//		v00302.setDjz_wbmbm(sessionCtrl.Get(SessionCtrl.WBMBM));
//		XML xmlClass = new XML();
//		ECBWebXml web = new ECBWebXml();
//		try {
//			String ResultInfo = web.web(xmlClass.getDJZxml(t00302Service.GetXMLI(v00302)), ws_urll);
//			if (CheckUtil.chkEmpty(ResultInfo)) {
//				resSign = "1";
//			} else {
//				t00370Bean = xmlClass.jxResultInfo(ResultInfo);
//			}
//		} catch (AxisFault e) {	
//			SLMsg = e.getMessage();
//			resSign = "2";
//			return SUCCESS;			
//		} catch (RemoteException e) {
//			SLMsg = e.getMessage();
//			resSign = "3";
//			return SUCCESS;
//		} catch (Exception e) {	
//			SLMsg = e.getMessage();
//			resSign = "1";
//			return SUCCESS;			
//		} finally {
//			v00302 = null;
//			xmlClass = null;
//			web = null;
//		}
	}
	

	/**
	 * 传入大集中评估结果XML
	 * 
	 * @return
	 * @throws Exception
	 */

	public String DJZPgjgXML() throws Exception {
		return SUCCESS;
	}

	/**
	 * 将371数据备份至3711中
	 */
	public String update003711() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("update003711() ********** start **********");
		}
		try {
			// 准备插入确认表参数
			Pgt00352xml pgt00352xml = new Pgt00352xml();
			pgt00352xml.setFcid(FCIDSUB);
			pgt00352xml.setInfoMsg(INFOMSGSUB);

			// 准备调用WS进行取消挂起
			XML xml = new XML();
			WebXml webxml = new WebXml();

			// 判断数据是否已经存在于确认表中
			if (null != t00302Service.LoadByPrimaryKey3711(pgt00352xml)
					&& "0".equals(actCount)) {
				resMsg = "该数据在确认表中";
				resSign = "warning";
				return SUCCESS;
			} else if ("1".equals(actCount)) {
				// 表中已存在，则先删除，重新插入
				if (t00302Service.GetDeleteCommand3711(pgt00352xml)) {
					if (t00302Service.GetInsertCommand3711(pgt00352xml)) {
						resMsg = "数据已在确认表中更新";
						resSign = "success";
						setActCount("0");
						return SUCCESS;
					}
				}
			} else {
				// 若数据为第一次操作，在进行插入确认表之前，调用WS进行取消挂起
				String result = xml.jxHXxml(webxml.web(
						xml.getCancelHangXML(OINSID),
						sessionCtrl.Get(SessionCtrl.FCJKDZ)));
				if ("true".equals(result)) {
					// 挂起取消成功，则开始插入
					if (t00302Service.GetInsertCommand3711(pgt00352xml)) {
						resMsg = "数据已传至确认表";
						resSign = "success";
						return SUCCESS;
					}
				} else {
					resSign = "error";
					resMsg = "挂起取消失败：" + result;
					return SUCCESS;
				}
			}

		} catch (Exception e) {
			LOG.error(e.getMessage());
			LOG.error("Pgt00302XMLAction -- update003711()", e);
			if (LOG.isDebugEnabled()) {
				LOG.debug("update003711() ********** end **********");
			}
			resMsg = "操作失败：" + e.getMessage();
			resSign = "error";
			return SUCCESS;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("update003711() ********** end **********");
		}
		return SUCCESS;
	}

	public String del3711() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("del3711() **********   start   **********");
		}
		this.clearErrorsAndMessages();
		try {
			Pgt00352xml t00352xml = new Pgt00352xml();
			t00352xml.setFcid(FCIDSUB);
			if (t00302Service.GetDeleteCommand3711(t00352xml)) {
				this.addActionMessage("数据删除成功");
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			LOG.error("Pgt00302XMLAction -- del3711()", e);
			this.addActionMessage(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("del3711() ********** end **********");
			}
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("del3711() **********   end   **********");
		}
		return SUCCESS;
	}

	/**
	 * 查看确认表
	 */
	public String executeWS1() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("executeWS1() ********** start ***********");
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("executeWS1() ********** end ************");
		}
		return SUCCESS;
	}

	/**
	 * 确认表查询
	 * 
	 * @return
	 * @throws Exception
	 */
	public String query003711() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}

		Pgt00352xml t00352xml = new Pgt00352xml();

		try {
			// sessionCtrl = new
			// SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件

			// 执行查询
			t00352xml.setPageIndex(pageIndex);
			t00352xml.setPageSize(getPageSize());
			t00352xml.setZRFMC(FormatUtil.toSearchLike(txtCQRNMFIND));
			t00352xml.setZRFSFID(FormatUtil.toSearchLike(txtCQRZJHMFIND));
			t00352Bean = t00302Service.LoadAll3711(t00352xml);
			rows = t00352Bean.getPgt00352xmllist();
			// 分页设置
			if (null != rows && rows.size() > 0) {
				total = CheckUtil.chkNull(rows.get(0).getRecordCount());
			} else {
				pageIndex = 1;
				total = 0;
			}

		} catch (Exception e) {
			LOG.error("Pgt00302XMLAction -- query003711()", e);
			this.addActionError(e.getMessage());
			return ERROR;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;
	}

	public String execute00372() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute00372() ********** start **********");
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("execute00372() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 读取ROLE.
	 */
	
	protected void readRole() throws Exception {
		Object role = sessionCtrl.GetList(SessionCtrl.SESSION_KEY_USERROLE);
		userRole = "";
		if(null!=role){
			ArrayList<String> roleList = (ArrayList<String>) role;
			for(Integer i = 0; i < roleList.size(); i++){
				userRole = userRole + roleList.get(i) + Constant.STRING_COMMA;
			}
		}		
	}

	/**
	 * 测试372
	 * 
	 * @return
	 * @throws Exception
	 */
	public String test00372() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("test00372() ********** start **********");
		}
		try {
			// sessionCtrl = new
			// SessionCtrl(ActionContext.getContext().getSession());
			WebXml web = new WebXml();
			testTxt = web.web(testTxt, sessionCtrl.Get(SessionCtrl.FCJKDZ));
		} catch (Exception e) {
			LOG.error(e.getMessage());
			LOG.error("Pgt00302XMLAction -- test00372()", e);
		} finally {
			//
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("test00372() ********** end **********");
		}
		return SUCCESS;
	}

	/*********************** setter and getter ******************************/
	/**
	 * @return the t00302eService
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt00302eService getT00302eService() {
		return t00302eService;
	}

	/**
	 * @param t00302eService
	 *            the t00302eService to set
	 */
	public void setT00302eService(IPgt00302eService t00302eService) {
		this.t00302eService = t00302eService;
	}

	/**
	 * @return the t00302Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt00302Service getT00302Service() {
		return t00302Service;
	}

	/**
	 * @param t00302Service
	 *            the t00302Service to set
	 */
	public void setT00302Service(IPgt00302Service t00302Service) {
		this.t00302Service = t00302Service;
	}

	/**
	 * @return the t00303Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt00303Service getT00303Service() {
		return t00303Service;
	}

	/**
	 * @param t00303Service
	 *            the t00303Service to set
	 */
	public void setT00303Service(IPgt00303Service t00303Service) {
		this.t00303Service = t00303Service;
	}

	/**
	 * @return the t00301Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt00301Service getT00301Service() {
		return t00301Service;
	}

	/**
	 * @param t00301Service
	 *            the t00301Service to set
	 */
	public void setT00301Service(IPgt00301Service t00301Service) {
		this.t00301Service = t00301Service;
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
	 * @return the txtFCIDFind
	 */
	public String getTxtFCIDFind() {
		return txtFCIDFind;
	}

	/**
	 * @param txtFCIDFind
	 *            the txtFCIDFind to set
	 */
	public void setTxtFCIDFind(String txtFCIDFind) {
		this.txtFCIDFind = txtFCIDFind;
	}

	/**
	 * @return the txtSWIDFind
	 */
	public String getTxtSWIDFind() {
		return txtSWIDFind;
	}

	/**
	 * @param txtSWIDFind
	 *            the txtSWIDFind to set
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
	 * @param txtNSRMCFind
	 *            the txtNSRMCFind to set
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
	 * @param txtFDCDATFind
	 *            the txtFDCDATFind to set
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
	 * @param txtXQFind
	 *            the txtXQFind to set
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
	 * @param txtFWTDZLFind
	 *            the txtFWTDZLFind to set
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
	 * @param ddlSZQYFind
	 *            the ddlSZQYFind to set
	 */
	public void setDdlSZQYFind(String ddlSZQYFind) {
		this.ddlSZQYFind = ddlSZQYFind;
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
	 * @return the fCID
	 */
	public String getFCID() {
		return FCID;
	}

	/**
	 * @param fCID
	 *            the fCID to set
	 */
	public void setFCID(String fCID) {
		FCID = fCID;
	}

	/**
	 * @return the v00302Bean
	 */
	public Pgv00302 getV00302Bean() {
		return v00302Bean;
	}

	/**
	 * @param v00302Bean
	 *            the v00302Bean to set
	 */
	public void setV00302Bean(Pgv00302 v00302Bean) {
		this.v00302Bean = v00302Bean;
	}

	/**
	 * @return the sWID
	 */
	public String getSWID() {
		return SWID;
	}

	/**
	 * @param sWID
	 *            the sWID to set
	 */
	public void setSWID(String sWID) {
		SWID = sWID;
	}
	

	/**
	 * @return the t00301Bean
	 */
	public Pgt00301 getT00301Bean() {
		return t00301Bean;
	}

	/**
	 * @param t00301Bean
	 *            the t00301Bean to set
	 */
	public void setT00301Bean(Pgt00301 t00301Bean) {
		this.t00301Bean = t00301Bean;
	}

	/**
	 * @return the t00303Bean
	 */
	public Pgt00303 getT00303Bean() {
		return t00303Bean;
	}

	/**
	 * @param t00303Bean
	 *            the t00303Bean to set
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
	 * @param txtUPDATE
	 *            the txtUPDATE to set
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
	 * @param txtSWID
	 *            the txtSWID to set
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
	 * @return the txtFDCDAT
	 */
	public String getTxtFDCDAT() {
		return txtFDCDAT;
	}

	/**
	 * @param txtFDCDAT
	 *            the txtFDCDAT to set
	 */
	public void setTxtFDCDAT(String txtFDCDAT) {
		this.txtFDCDAT = txtFDCDAT;
	}

	/**
	 * @return the txtNOTET00302
	 */
	public String getTxtNOTET00302() {
		return txtNOTET00302;
	}

	/**
	 * @param txtNOTET00302
	 *            the txtNOTET00302 to set
	 */
	public void setTxtNOTET00302(String txtNOTET00302) {
		this.txtNOTET00302 = txtNOTET00302;
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
	public ArrayList<Pgv00302e> getQtxzList() {
		return qtxzList;
	}

	/**
	 * @param qtxzList
	 *            the qtxzList to set
	 */
	public void setQtxzList(ArrayList<Pgv00302e> qtxzList) {
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
	 * @return the fWTDZL
	 */
	public String getFWTDZL() {
		return FWTDZL;
	}

	/**
	 * @param fWTDZL
	 *            the fWTDZL to set
	 */
	public void setFWTDZL(String fWTDZL) {
		FWTDZL = fWTDZL;
	}

	/**
	 * @return the hidNsrmc
	 */
	public String getHidNsrmc() {
		return hidNsrmc;
	}

	/**
	 * @param hidNsrmc
	 *            the hidNsrmc to set
	 */
	public void setHidNsrmc(String hidNsrmc) {
		this.hidNsrmc = hidNsrmc;
	}

	/**
	 * @return the forward
	 */
	public Boolean getForward() {
		return forward;
	}

	/**
	 * @param forward
	 *            the forward to set
	 */
	public void setForward(Boolean forward) {
		this.forward = forward;
	}

	/**
	 * @return the txtBGSJ
	 */
	public String getTxtBGSJ() {
		return txtBGSJ;
	}

	/**
	 * @param txtBGSJ
	 *            the txtBGSJ to set
	 */
	public void setTxtBGSJ(String txtBGSJ) {
		this.txtBGSJ = txtBGSJ;
	}

	/**
	 * @return the ddlBGLX
	 */
	public String getDdlBGLX() {
		return ddlBGLX;
	}

	/**
	 * @param ddlBGLX
	 *            the ddlBGLX to set
	 */
	public void setDdlBGLX(String ddlBGLX) {
		this.ddlBGLX = ddlBGLX;
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
	 * @return the txtNSRMC
	 */
	public String getTxtNSRMC() {
		return txtNSRMC;
	}

	/**
	 * @param txtNSRMC
	 *            the txtNSRMC to set
	 */
	public void setTxtNSRMC(String txtNSRMC) {
		this.txtNSRMC = txtNSRMC;
	}

	/**
	 * @return the txtZJLX
	 */
	public String getTxtZJLX() {
		return txtZJLX;
	}

	/**
	 * @param txtZJLXId
	 *            the txtZJLXId to set
	 */
	public void setTxtZJLX(String txtZJLX) {
		this.txtZJLX = txtZJLX;
	}

	/**
	 * @return the txtZZ
	 */
	public String getTxtZZ() {
		return txtZZ;
	}

	/**
	 * @param txtZZ
	 *            the txtZZ to set
	 */
	public void setTxtZZ(String txtZZ) {
		this.txtZZ = txtZZ;
	}

	/**
	 * @return the txtLXDH
	 */
	public String getTxtLXDH() {
		return txtLXDH;
	}

	/**
	 * @param txtLXDH
	 *            the txtLXDH to set
	 */
	public void setTxtLXDH(String txtLXDH) {
		this.txtLXDH = txtLXDH;
	}

	/**
	 * @return the txtYDDH
	 */
	public String getTxtYDDH() {
		return txtYDDH;
	}

	/**
	 * @param txtYDDH
	 *            the txtYDDH to set
	 */
	public void setTxtYDDH(String txtYDDH) {
		this.txtYDDH = txtYDDH;
	}

	/**
	 * @return the txtNOTET00301
	 */
	public String getTxtNOTET00301() {
		return txtNOTET00301;
	}

	/**
	 * @param txtNOTET00301
	 *            the txtNOTET00301 to set
	 */
	public void setTxtNOTET00301(String txtNOTET00301) {
		this.txtNOTET00301 = txtNOTET00301;
	}

	/**
	 * @return the v00303Bean
	 */
	public Pgv00303 getV00303Bean() {
		return v00303Bean;
	}

	/**
	 * @param v00303Bean
	 *            the v00303Bean to set
	 */
	public void setV00303Bean(Pgv00303 v00303Bean) {
		this.v00303Bean = v00303Bean;
	}

	/**
	 * @return the txtFCZH
	 */
	public String getTxtFCZH() {
		return txtFCZH;
	}

	/**
	 * @param txtFCZH
	 *            the txtFCZH to set
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
	 * @param txtQDH
	 *            the txtQDH to set
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
	 * @param txtCB
	 *            the txtCB to set
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
	 * @param txtGHYT
	 *            the txtGHYT to set
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
	 * @param txtHXJG
	 *            the txtHXJG to set
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
	 * @param txtJCSJ
	 *            the txtJCSJ to set
	 */
	public void setTxtJCSJ(String txtJCSJ) {
		this.txtJCSJ = txtJCSJ;
	}

	/**
	 * @return the txtDJRQ
	 */
	public String getTxtDJRQ() {
		return txtDJRQ;
	}

	/**
	 * @param txtDJRQ
	 *            the txtDJRQ to set
	 */
	public void setTxtDJRQ(String txtDJRQ) {
		this.txtDJRQ = txtDJRQ;
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
	 * @return the txtZCDZBM
	 */
	public String getTxtZCDZBM() {
		return txtZCDZBM;
	}

	/**
	 * @param txtZCDZBM
	 *            the txtZCDZBM to set
	 */
	public void setTxtZCDZBM(String txtZCDZBM) {
		this.txtZCDZBM = txtZCDZBM;
	}

	/**
	 * @return the txtJZMJ
	 */
	public String getTxtJZMJ() {
		return txtJZMJ;
	}

	/**
	 * @param txtJZMJ
	 *            the txtJZMJ to set
	 */
	public void setTxtJZMJ(String txtJZMJ) {
		this.txtJZMJ = txtJZMJ;
	}

	/**
	 * @return the txtSZLC
	 */
	public String getTxtSZLC() {
		return txtSZLC;
	}

	/**
	 * @param txtSZLC
	 *            the txtSZLC to set
	 */
	public void setTxtSZLC(String txtSZLC) {
		this.txtSZLC = txtSZLC;
	}

	/**
	 * @return the txtJYJG
	 */
	public String getTxtJYJG() {
		return txtJYJG;
	}

	/**
	 * @param txtJYJG
	 *            the txtJYJG to set
	 */
	public void setTxtJYJG(String txtJYJG) {
		this.txtJYJG = txtJYJG;
	}

	/**
	 * @return the txtDTGJ
	 */
	public String getTxtDTGJ() {
		return txtDTGJ;
	}

	/**
	 * @param txtDTGJ
	 *            the txtDTGJ to set
	 */
	public void setTxtDTGJ(String txtDTGJ) {
		this.txtDTGJ = txtDTGJ;
	}

	/**
	 * @return the txtTDSYQMJ
	 */
	public String getTxtTDSYQMJ() {
		return txtTDSYQMJ;
	}

	/**
	 * @param txtTDSYQMJ
	 *            the txtTDSYQMJ to set
	 */
	public void setTxtTDSYQMJ(String txtTDSYQMJ) {
		this.txtTDSYQMJ = txtTDSYQMJ;
	}

	/**
	 * @return the txtRJL
	 */
	public String getTxtRJL() {
		return txtRJL;
	}

	/**
	 * @param txtRJL
	 *            the txtRJL to set
	 */
	public void setTxtRJL(String txtRJL) {
		this.txtRJL = txtRJL;
	}

	/**
	 * @return the txtZLC
	 */
	public String getTxtZLC() {
		return txtZLC;
	}

	/**
	 * @param txtZLC
	 *            the txtZLC to set
	 */
	public void setTxtZLC(String txtZLC) {
		this.txtZLC = txtZLC;
	}

	/**
	 * @return the sysDate
	 */
	public String getSysDate() {
		return SysDate;
	}

	/**
	 * @param sysDate
	 *            the sysDate to set
	 */
	public void setSysDate(String sysDate) {
		SysDate = sysDate;
	}

	/**
	 * @return the hidPARENTDM
	 */
	public String getHidPARENTDM() {
		return hidPARENTDM;
	}

	/**
	 * @param hidPARENTDM
	 *            the hidPARENTDM to set
	 */
	public void setHidPARENTDM(String hidPARENTDM) {
		this.hidPARENTDM = hidPARENTDM;
	}

	/**
	 * @return the hidXQZT
	 */
	public String getHidXQZT() {
		return hidXQZT;
	}

	/**
	 * @param hidXQZT
	 *            the hidXQZT to set
	 */
	public void setHidXQZT(String hidXQZT) {
		this.hidXQZT = hidXQZT;
	}

	/**
	 * @return the ddlSZQY
	 */
	public String getDdlSZQY() {
		return ddlSZQY;
	}

	/**
	 * @param ddlSZQY
	 *            the ddlSZQY to set
	 */
	public void setDdlSZQY(String ddlSZQY) {
		this.ddlSZQY = ddlSZQY;
	}

	/**
	 * @return the txtXJXQMC
	 */
	public String getTxtXJXQMC() {
		return txtXJXQMC;
	}

	/**
	 * @param txtXJXQMC
	 *            the txtXJXQMC to set
	 */
	public void setTxtXJXQMC(String txtXJXQMC) {
		this.txtXJXQMC = txtXJXQMC;
	}

	/**
	 * @return the fROMCJ
	 */
	public Boolean getFROMCJ() {
		return FROMCJ;
	}

	/**
	 * @param fROMCJ
	 *            the fROMCJ to set
	 */
	public void setFROMCJ(Boolean fROMCJ) {
		FROMCJ = fROMCJ;
	}

	/**
	 * @return the txtLH
	 */
	public String getTxtLH() {
		return txtLH;
	}

	/**
	 * @param txtLH
	 *            the txtLH to set
	 */
	public void setTxtLH(String txtLH) {
		this.txtLH = txtLH;
	}

	/**
	 * @return the iSEXISTFCZH
	 */
	public Boolean getISEXISTFCZH() {
		return ISEXISTFCZH;
	}

	/**
	 * @param iSEXISTFCZH
	 *            the iSEXISTFCZH to set
	 */
	public void setISEXISTFCZH(Boolean iSEXISTFCZH) {
		ISEXISTFCZH = iSEXISTFCZH;
	}

	/**
	 * @return the fCZH
	 */
	public String getFCZH() {
		return FCZH;
	}

	/**
	 * @param fCZH
	 *            the fCZH to set
	 */
	public void setFCZH(String fCZH) {
		FCZH = fCZH;
	}

	/**
	 * @return the txtCLH
	 */
	public String getTxtCLH() {
		return txtCLH;
	}

	/**
	 * @param txtCLH
	 *            the txtCLH to set
	 */
	public void setTxtCLH(String txtCLH) {
		this.txtCLH = txtCLH;
	}

	public String getRdoYWJKC() {
		return rdoYWJKC;
	}

	public void setRdoYWJKC(String rdoYWJKC) {
		this.rdoYWJKC = rdoYWJKC;
	}

	public void setHidZHXZid(String hidZHXZid) {
		this.hidZHXZid = hidZHXZid;
	}

	public String getHidZHXZid() {
		return hidZHXZid;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getFileServerPath() {
		return fileServerPath;
	}

	public void setFileServerPath(String fileServerPath) {
		this.fileServerPath = fileServerPath;
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

	public InputStream getExcelStream() {
		return excelStream;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public ArrayList<Pgv00357> getPgv00357List() {
		return Pgv00357List;
	}

	public void setPgv00357List(ArrayList<Pgv00357> pgv00357List) {
		Pgv00357List = pgv00357List;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageSize() {
		return Common.getPageSize(pageSize);
	}

	/**
	 * @return the txtFCSLH
	 */
	public String getTxtFCSLH() {
		return txtFCSLH;
	}

	/**
	 * @param txtFCSLH
	 *            the txtFCSLH to set
	 */
	public void setTxtFCSLH(String txtFCSLH) {
		this.txtFCSLH = txtFCSLH;
	}

	/**
	 * @return the rows
	 */
	public ArrayList<Pgt00352xml> getRows() {
		return rows;
	}

	/**
	 * @param rows
	 *            the rows to set
	 */
	public void setRows(ArrayList<Pgt00352xml> rows) {
		this.rows = rows;
	}

	/**
	 * @return the t00352Bean
	 */
	public Pgt00352xml getT00352Bean() {
		return t00352Bean;
	}

	/**
	 * @param t00352Bean
	 *            the t00352Bean to set
	 */
	public void setT00352Bean(Pgt00352xml t00352Bean) {
		this.t00352Bean = t00352Bean;
	}

	public boolean isTxtSLSIGN() {
		return txtSLSIGN;
	}

	public void setTxtSLSIGN(boolean txtSLSIGN) {
		this.txtSLSIGN = txtSLSIGN;
	}

	/*
	 * public String getWs_url() { return ws_url; }
	 * 
	 * 
	 * public void setWs_url(String wsUrl) { ws_url = wsUrl; }
	 */

	public String getTxtFCSLHFIND() {
		return txtFCSLHFIND;
	}

	public void setTxtFCSLHFIND(String txtFCSLHFIND) {
		this.txtFCSLHFIND = txtFCSLHFIND;
	}

	public String getTxtCLHFIND() {
		return txtCLHFIND;
	}

	public void setTxtCLHFIND(String txtCLHFIND) {
		this.txtCLHFIND = txtCLHFIND;
	}

	public String getTxtFHFIND() {
		return txtFHFIND;
	}

	public void setTxtFHFIND(String txtFHFIND) {
		this.txtFHFIND = txtFHFIND;
	}

	public String getIsVal() {
		return isVal;
	}

	public void setIsVal(String isVal) {
		this.isVal = isVal;
	}

	public String getTxtXQTIP() {
		return txtXQTIP;
	}

	public void setTxtXQTIP(String txtXQTIP) {
		this.txtXQTIP = txtXQTIP;
	}

	@JSON(deserialize = false, serialize = false)
	public IPg30001Service getPg30001Service() {
		return pg30001Service;
	}

	public void setPg30001Service(IPg30001Service pg30001Service) {
		this.pg30001Service = pg30001Service;
	}

	public String getTxtFCID() {
		return txtFCID;
	}

	public void setTxtFCID(String txtFCID) {
		this.txtFCID = txtFCID;
	}

	public String getTxtPGJG() {
		return txtPGJG;
	}

	public void setTxtPGJG(String txtPGJG) {
		this.txtPGJG = txtPGJG;
	}

	@JSON(deserialize = false, serialize = false)
	public IPg30002Service getPg30002Service() {
		return pg30002Service;
	}

	public void setPg30002Service(IPg30002Service pg30002Service) {
		this.pg30002Service = pg30002Service;
	}

	public String getTxtRes() {
		return txtRes;
	}

	public void setTxtRes(String txtRes) {
		this.txtRes = txtRes;
	}

	public String getPsSign() {
		return psSign;
	}

	public void setPsSign(String psSign) {
		this.psSign = psSign;
	}

	public String getTxtZRFSFIDFIND() {
		return txtZRFSFIDFIND;
	}

	public void setTxtZRFSFIDFIND(String txtZRFSFIDFIND) {
		this.txtZRFSFIDFIND = txtZRFSFIDFIND;
	}

	public String getTxtZRFMCFIND() {
		return txtZRFMCFIND;
	}

	public void setTxtZRFMCFIND(String txtZRFMCFIND) {
		this.txtZRFMCFIND = txtZRFMCFIND;
	}

	public String getTxtFWLXSL() {
		return txtFWLXSL;
	}

	public void setTxtFWLXSL(String txtFWLXSL) {
		this.txtFWLXSL = txtFWLXSL;
	}

	@JSON(deserialize = false, serialize = false)
	public IPgt00001Service getT00001Service() {
		return t00001Service;
	}

	public void setT00001Service(IPgt00001Service t00001Service) {
		this.t00001Service = t00001Service;
	}

	public String getTxtEDIT() {
		return txtEDIT;
	}

	public void setTxtEDIT(String txtEDIT) {
		this.txtEDIT = txtEDIT;
	}

	public String getTxtZRFMCEDIT() {
		return txtZRFMCEDIT;
	}

	public void setTxtZRFMCEDIT(String txtZRFMCEDIT) {
		this.txtZRFMCEDIT = txtZRFMCEDIT;
	}

	public String getTxtZRFSFLXEDIT() {
		return txtZRFSFLXEDIT;
	}

	public void setTxtZRFSFLXEDIT(String txtZRFSFLXEDIT) {
		this.txtZRFSFLXEDIT = txtZRFSFLXEDIT;
	}

	public String getTxtZRFSFIDEDIT() {
		return txtZRFSFIDEDIT;
	}

	public void setTxtZRFSFIDEDIT(String txtZRFSFIDEDIT) {
		this.txtZRFSFIDEDIT = txtZRFSFIDEDIT;
	}

	public String getTxtCSFMCEDIT() {
		return txtCSFMCEDIT;
	}

	public void setTxtCSFMCEDIT(String txtCSFMCEDIT) {
		this.txtCSFMCEDIT = txtCSFMCEDIT;
	}

	public String getTxtCSFSFLXEDIT() {
		return txtCSFSFLXEDIT;
	}

	public void setTxtCSFSFLXEDIT(String txtCSFSFLXEDIT) {
		this.txtCSFSFLXEDIT = txtCSFSFLXEDIT;
	}

	public String getTxtCSFSFIDEDIT() {
		return txtCSFSFIDEDIT;
	}

	public void setTxtCSFSFIDEDIT(String txtCSFSFIDEDIT) {
		this.txtCSFSFIDEDIT = txtCSFSFIDEDIT;
	}

	public String getTxtCLHEDIT() {
		return txtCLHEDIT;
	}

	public void setTxtCLHEDIT(String txtCLHEDIT) {
		this.txtCLHEDIT = txtCLHEDIT;
	}

	public String getTxtLFDZEDIT() {
		return txtLFDZEDIT;
	}

	public void setTxtLFDZEDIT(String txtLFDZEDIT) {
		this.txtLFDZEDIT = txtLFDZEDIT;
	}

	public String getTxtDYFHEDIT() {
		return txtDYFHEDIT;
	}

	public void setTxtDYFHEDIT(String txtDYFHEDIT) {
		this.txtDYFHEDIT = txtDYFHEDIT;
	}

	public String getTxtSZLCEDIT() {
		return txtSZLCEDIT;
	}

	public void setTxtSZLCEDIT(String txtSZLCEDIT) {
		this.txtSZLCEDIT = txtSZLCEDIT;
	}

	public String getTxtJZJGTTIP() {
		return txtJZJGTTIP;
	}

	public void setTxtJZJGTTIP(String txtJZJGTTIP) {
		this.txtJZJGTTIP = txtJZJGTTIP;
	}

	public String getTxtGHYTTTIP() {
		return txtGHYTTTIP;
	}

	public void setTxtGHYTTTIP(String txtGHYTTTIP) {
		this.txtGHYTTTIP = txtGHYTTTIP;
	}

	public String getTxtYFCZHEDIT() {
		return txtYFCZHEDIT;
	}

	public void setTxtYFCZHEDIT(String txtYFCZHEDIT) {
		this.txtYFCZHEDIT = txtYFCZHEDIT;
	}

	public String getTxtJZMJEDIT() {
		return txtJZMJEDIT;
	}

	public void setTxtJZMJEDIT(String txtJZMJEDIT) {
		this.txtJZMJEDIT = txtJZMJEDIT;
	}

	public String getTxtJYJGEDIT() {
		return txtJYJGEDIT;
	}

	public void setTxtJYJGEDIT(String txtJYJGEDIT) {
		this.txtJYJGEDIT = txtJYJGEDIT;
	}

	public String getTxtJYSJEDIT() {
		return txtJYSJEDIT;
	}

	public void setTxtJYSJEDIT(String txtJYSJEDIT) {
		this.txtJYSJEDIT = txtJYSJEDIT;
	}

	public String getTxtJYLXTIP() {
		return txtJYLXTIP;
	}

	public void setTxtJYLXTIP(String txtJYLXTIP) {
		this.txtJYLXTIP = txtJYLXTIP;
	}

	public String getTxtFWLXTIP() {
		return txtFWLXTIP;
	}

	public void setTxtFWLXTIP(String txtFWLXTIP) {
		this.txtFWLXTIP = txtFWLXTIP;
	}

	public String getTxtFZRQEDIT() {
		return txtFZRQEDIT;
	}

	public void setTxtFZRQEDIT(String txtFZRQEDIT) {
		this.txtFZRQEDIT = txtFZRQEDIT;
	}

	public String getTxtYJGEDIT() {
		return txtYJGEDIT;
	}

	public void setTxtYJGEDIT(String txtYJGEDIT) {
		this.txtYJGEDIT = txtYJGEDIT;
	}

	public String getTxtPGJGEDIT() {
		return txtPGJGEDIT;
	}

	public void setTxtPGJGEDIT(String txtPGJGEDIT) {
		this.txtPGJGEDIT = txtPGJGEDIT;
	}

	public String getPGJG() {
		return PGJG;
	}

	public void setPGJG(String pGJG) {
		PGJG = pGJG;
	}

	public Pgt00370 getT00370Bean() {
		return t00370Bean;
	}

	public void setT00370Bean(Pgt00370 t00370Bean) {
		this.t00370Bean = t00370Bean;
	}

	public String getResSign() {
		return resSign;
	}

	public void setResSign(String resSign) {
		this.resSign = resSign;
	}

	/*
	 * public String getDjz_channel_pwd() { return djz_channel_pwd; }
	 * 
	 * 
	 * public void setDjz_channel_pwd(String djzChannelPwd) { djz_channel_pwd =
	 * djzChannelPwd; }
	 * 
	 * 
	 * public String getDjz_channel_acc() { return djz_channel_acc; }
	 * 
	 * 
	 * public void setDjz_channel_acc(String djzChannelAcc) { djz_channel_acc =
	 * djzChannelAcc; }
	 * 
	 * 
	 * public String getDjz_channel_code() { return djz_channel_code; }
	 * 
	 * 
	 * public void setDjz_channel_code(String djzChannelCode) { djz_channel_code
	 * = djzChannelCode; }
	 * 
	 * 
	 * public String getDjz_wbmbm() { return djz_wbmbm; }
	 * 
	 * 
	 * public void setDjz_wbmbm(String djzWbmbm) { djz_wbmbm = djzWbmbm; }
	 */
	public String getFCIDSUB() {
		return FCIDSUB;
	}

	public void setFCIDSUB(String fCIDSUB) {
		FCIDSUB = fCIDSUB;
	}

	public String getINFOMSGSUB() {
		return INFOMSGSUB;
	}

	public void setINFOMSGSUB(String iNFOMSGSUB) {
		INFOMSGSUB = iNFOMSGSUB;
	}

	public String getResMsg() {
		return resMsg;
	}

	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}

	public String getTxtCQRNMFIND() {
		return txtCQRNMFIND;
	}

	public void setTxtCQRNMFIND(String txtCQRNMFIND) {
		this.txtCQRNMFIND = txtCQRNMFIND;
	}

	public String getTxtCQRZJHMFIND() {
		return txtCQRZJHMFIND;
	}

	public void setTxtCQRZJHMFIND(String txtCQRZJHMFIND) {
		this.txtCQRZJHMFIND = txtCQRZJHMFIND;
	}

	public String getActCount() {
		return actCount;
	}

	public void setActCount(String actCount) {
		this.actCount = actCount;
	}

	public String getOINSID() {
		return OINSID;
	}

	public void setOINSID(String oINSID) {
		OINSID = oINSID;
	}

	public String getTestTxt() {
		return testTxt;
	}

	public void setTestTxt(String testTxt) {
		this.testTxt = testTxt;
	}

	public String getSLSign() {
		return SLSign;
	}

	public void setSLSign(String sLSign) {
		SLSign = sLSign;
	}

	public String getSLMsg() {
		return SLMsg;
	}

	public void setSLMsg(String sLMsg) {
		SLMsg = sLMsg;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}

	/**
	 * @return the wBJH00Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IWBJH00Service getWBJH00Service() {
		return WBJH00Service;
	}

	/**
	 * @param wBJH00Service the wBJH00Service to set
	 */	
	public void setWBJH00Service(IWBJH00Service wBJH00Service) {
		WBJH00Service = wBJH00Service;
	}

	/**
	 * @return the gt3DriverClass
	 */
	public String getGt3DriverClass() {
		return gt3DriverClass;
	}

	/**
	 * @param gt3DriverClass the gt3DriverClass to set
	 */
	public void setGt3DriverClass(String gt3DriverClass) {
		this.gt3DriverClass = gt3DriverClass;
	}

	/**
	 * @return the gt3DSUrl
	 */
	public String getGt3DSUrl() {
		return gt3DSUrl;
	}

	/**
	 * @param gt3dsUrl the gt3DSUrl to set
	 */
	public void setGt3DSUrl(String gt3dsUrl) {
		gt3DSUrl = gt3dsUrl;
	}

	/**
	 * @return the gt3User
	 */
	public String getGt3User() {
		return gt3User;
	}

	/**
	 * @param gt3User the gt3User to set
	 */
	public void setGt3User(String gt3User) {
		this.gt3User = gt3User;
	}

	/**
	 * @return the gt3Password
	 */
	public String getGt3Password() {
		return gt3Password;
	}

	/**
	 * @param gt3Password the gt3Password to set
	 */
	public void setGt3Password(String gt3Password) {
		this.gt3Password = gt3Password;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public Pgt00352xml getBean() {
		return bean;
	}

	public void setBean(Pgt00352xml bean) {
		this.bean = bean;
	}

	
	

}
