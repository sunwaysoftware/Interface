package com.sunway.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.dao.impl.Pgt00401DAO;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.JsonPager;
import com.sunway.vo.Pgt00401;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import net.sf.json.JSONObject;

public class Pgt00401Action extends ActionSupport implements SessionAware {
	private static Logger logger = LogManager.getLogger(Pgt00401Action.class);
	private static final long serialVersionUID = 4824297669898589358L;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	private Pgt00401DAO t00401Dao;
	private JsonPager pagerJSON;
	// 分页参数
	private Integer pageIndex;
	private Integer pageSize;
	private Integer rowCount;
	// 查询参数
	private String qQlr;	//权利人
	private String qGyqk;	//共有情况
	// 页面用参数
	private String act;
	private String pk;
	private Pgt00401 pageBean= new Pgt00401();
	private String txtBDCZH;
	private String txtQLR;
	private String txtGYQK;
	private String txtZLDZ;
	private String txtBDCDYH;
	private String txtQLLX;
	private String txtQLXZ;
	private String txtGHYT;
	private String txtJZMJ;
	private String txtSYQX;
	private String txtQTZK;
	private String txtSZQY;
	private String txtSZLC;
	private String txtJCNF;
	private String txtHTJG;
	private String txtZHXZ;
	private String txtPGJG;
	private String txtNOTE;
	private String txtJZJG;
	private String txtJYSJ;
	//数据导出
	private InputStream excelStream;
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		logger.info("页面跳转至[体外评估管理]...");
		return SUCCESS;
	}
	
	/**
	 * 负责页面查询
	 * @return
	 * @throws Exception
	 */
	public String executeQuery() throws Exception {
		Pgt00401 b = new Pgt00401();
		try {
			b.setGyqk(qGyqk);
			b.setQlr(qQlr);
			b.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			pagerJSON = t00401Dao.query(b, pageIndex, getPageSize());			
		} catch (Exception e) {
			logger.error(e);
		}
		return SUCCESS;
	}
	
	/**
	 * 编辑数据
	 * @return
	 * @throws Exception
	 */
	public String executeLoadByID() throws Exception {
		try {
			if (!Constant.MOD_CREATE.equals(act)) {
				pageBean = t00401Dao.loadById(pk);
			}			
		} catch (Exception e) {
			logger.error(e);
		}
		return SUCCESS;
	}

	public void validateExecuteUpdate() throws Exception{
		this.clearErrorsAndMessages();
		pageBean.setId(pk);
		pageBean.setBdcdyh(txtBDCDYH);
		pageBean.setBdczh(txtBDCZH);
		pageBean.setGhyt(txtGHYT);
		pageBean.setGyqk(txtGYQK);
		pageBean.setHtjg(Common.convertToBigDecimal(txtHTJG));
		pageBean.setJcnf(txtJCNF);
		pageBean.setJzjg(txtJZJG);
		pageBean.setJzmj(Common.convertToBigDecimal(txtJZMJ));
		pageBean.setLc(txtSZLC);
		pageBean.setNote(txtNOTE);
		pageBean.setPgjg(Common.convertToBigDecimal(txtPGJG));
		pageBean.setQllx(txtQLLX);
		pageBean.setQlqtzk(txtQTZK);
		pageBean.setQlr(txtQLR);
		pageBean.setQlxz(txtQLXZ);
		pageBean.setSyqx(txtSYQX);
		pageBean.setSzqy(txtSZQY);
		pageBean.setZhxz(txtZHXZ);
		pageBean.setZldz(txtZLDZ);
		pageBean.setJysj(Common.convertStringToDate(txtJYSJ));
		pageBean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
		pageBean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
		pageBean.setUpdDate(new Date());
		logger.info("体外评估数据操作{}：{}", act,  JSONObject.fromObject(pageBean));
	}
	
	/**
	 * 执行“CURD”数据操作
	 * @return
	 * @throws Exception
	 */
	public String executeUpdate() throws Exception {
		logger.debug("执行“CURD”数据操作");
		try {
			if (Constant.MOD_CREATE.equals(act)) {			// Create
				pageBean.setId(null);
				t00401Dao.persist(pageBean);
				this.addActionMessage("创建成功");
			}else if (Constant.MOD_UPDATE.equals(act)) {	// Update
				t00401Dao.attachDirty(pageBean);
				this.addActionMessage("更新成功 ");
			}else if (Constant.MOD_DELETE.equals(act)) {	// Delete
				t00401Dao.delete(pageBean);
				this.addActionMessage("删除成功 ");
			}	
			logger.info("体外评估数据操作（{}）！", act);
		} catch (Exception e) {
			logger.error(e);
			this.addActionError("操作失败："+e.getMessage());
		}
		
		return SUCCESS;
	}
	
	/**
	 * 导出数据
	 * @return
	 * @throws Exception
	 */
	public String executeExport() throws Exception {
		logger.debug("进入【导出数据】");
		Pgt00401 b = new Pgt00401();
		try {
			b.setGyqk(txtGYQK);
			b.setQlr(txtQLR);
			b.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			pagerJSON = t00401Dao.query(b, 1, 1000);			
		} catch (Exception e) {
			logger.error(e);
		}		
		this.excelExport((List<?>)pagerJSON.getTabList());
		logger.debug("退出【导出数据】");
		return SUCCESS;
	}
	
	/**
	 * 组织数据转换为Excel
	 * @param list 体外评估数据
	 */
	private void excelExport(List<?> list) {
		ByteArrayOutputStream strBufResult = null;
		WritableWorkbook workbook = null;

		try {
			strBufResult = new ByteArrayOutputStream();
			workbook = Workbook.createWorkbook(strBufResult);
			WritableSheet sheet = workbook.createSheet("体外评估数据", 0);
			// 填写列头
			sheet.addCell(new Label(0,0,"所在区域"));
			sheet.addCell(new Label(1,0,"坐落地址"));
			sheet.addCell(new Label(2,0,"建筑结构"));
			sheet.addCell(new Label(3,0,"规划用途"));
			sheet.addCell(new Label(4,0,"所在楼层"));
			sheet.addCell(new Label(5,0,"不动产单元号"));
			sheet.addCell(new Label(6,0,"建筑面积"));
			sheet.addCell(new Label(7,0,"权利类型"));
			sheet.addCell(new Label(8,0,"权利性质"));
			sheet.addCell(new Label(9,0,"权利其他状况"));
			sheet.addCell(new Label(10,0,"使用期限"));
			sheet.addCell(new Label(11,0,"建成年份"));
			sheet.addCell(new Label(12,0,"合同价格"));
			sheet.addCell(new Label(13,0,"相关特性"));
			sheet.addCell(new Label(14,0,"评估结果"));
			sheet.addCell(new Label(15,0,"权利人"));
			sheet.addCell(new Label(16,0,"共有情况"));
			sheet.addCell(new Label(17,0,"不动产证号"));
			sheet.addCell(new Label(18,0,"交易时间"));
			sheet.addCell(new Label(19,0,"备注"));
			// 填写数据
			for (int i = 0; i < list.size(); i++) {
				Pgt00401 b = (Pgt00401) list.get(i);
				sheet.addCell(new Label(0, i+1, b.getSzqy()));
				sheet.addCell(new Label(1, i+1, b.getZldz()));
				sheet.addCell(new Label(2, i+1, b.getJzjg()));
				sheet.addCell(new Label(3, i+1, b.getGhyt()));
				sheet.addCell(new Label(4, i+1, b.getLc()));
				sheet.addCell(new Label(5, i+1, b.getBdcdyh()));
				sheet.addCell(new Label(6, i+1, String.valueOf(b.getJzmj())));
				sheet.addCell(new Label(7, i+1, b.getQllx()));
				sheet.addCell(new Label(8, i+1, b.getQlxz()));
				sheet.addCell(new Label(9, i+1, b.getQlqtzk()));
				sheet.addCell(new Label(10, i+1, b.getSyqx()));
				sheet.addCell(new Label(11, i+1, b.getJcnf()));
				sheet.addCell(new Label(12, i+1, String.valueOf(b.getHtjg())));
				sheet.addCell(new Label(13, i+1, b.getZhxz()));
				sheet.addCell(new Label(14, i+1, String.valueOf(b.getPgjg())));
				sheet.addCell(new Label(15, i+1, b.getQlr()));
				sheet.addCell(new Label(16, i+1, b.getGyqk()));
				sheet.addCell(new Label(17, i+1, b.getBdczh()));
				sheet.addCell(new Label(18, i+1, Common.formatToYYYYMMDD(b.getJysj())));
				sheet.addCell(new Label(19, i+1, b.getNote()));
			}
			workbook.write();
		} catch (Exception e) {
			logger.error(e);
		} finally {
			if (null != workbook) {
				try {
					workbook.close();
				} catch (Exception e) {
					logger.error(e);
					workbook = null;
				}
			}
			excelStream = new ByteArrayInputStream(strBufResult.toByteArray());
			try {
				strBufResult.close();
			} catch (IOException e) {
				logger.error(e);
				strBufResult = null;
			}
		}		
	}
	
	//========================= SET AND GET ================================
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
	
	/**
	 * @return the t00401Dao
	 */
	public Pgt00401DAO getT00401Dao() {
		return t00401Dao;
	}

	/**
	 * @param t00401Dao the t00401Dao to set
	 */
	public void setT00401Dao(Pgt00401DAO t00401Dao) {
		this.t00401Dao = t00401Dao;
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
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return Common.getPageSize(pageSize);
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
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
	 * @return the pagerJSON
	 */
	public JsonPager getPagerJSON() {
		return pagerJSON;
	}

	/**
	 * @param pagerJSON the pagerJSON to set
	 */
	public void setPagerJSON(JsonPager pagerJSON) {
		this.pagerJSON = pagerJSON;
	}

	/**
	 * @return the qGyqk
	 */
	public String getqGyqk() {
		return qGyqk;
	}

	/**
	 * @param qGyqk the qGyqk to set
	 */
	public void setqGyqk(String qGyqk) {
		this.qGyqk = qGyqk;
	}

	public String getqQlr() {
		return qQlr;
	}

	public void setqQlr(String qQlr) {
		this.qQlr = qQlr;
	}
	
	/**
	 * @return the act
	 */
	public String getAct() {
		return act;
	}

	/**
	 * @param act the act to set
	 */
	public void setAct(String act) {
		this.act = act;
	}

	/**
	 * @return the pk
	 */
	public String getPk() {
		return pk;
	}

	/**
	 * @param pk the pk to set
	 */
	public void setPk(String pk) {
		this.pk = pk;
	}

	/**
	 * @return the pageBean
	 */
	public Pgt00401 getPageBean() {
		return pageBean;
	}

	/**
	 * @param pageBean the pageBean to set
	 */
	public void setPageBean(Pgt00401 pageBean) {
		this.pageBean = pageBean;
	}

	/**
	 * @return the txtBDCZH
	 */
	public String getTxtBDCZH() {
		return txtBDCZH;
	}

	/**
	 * @param txtBDCZH the txtBDCZH to set
	 */
	public void setTxtBDCZH(String txtBDCZH) {
		this.txtBDCZH = txtBDCZH;
	}

	/**
	 * @return the txtQLR
	 */
	public String getTxtQLR() {
		return txtQLR;
	}

	/**
	 * @param txtQLR the txtQLR to set
	 */
	public void setTxtQLR(String txtQLR) {
		this.txtQLR = txtQLR;
	}

	/**
	 * @return the txtGYQK
	 */
	public String getTxtGYQK() {
		return txtGYQK;
	}

	/**
	 * @param txtGYQK the txtGYQK to set
	 */
	public void setTxtGYQK(String txtGYQK) {
		this.txtGYQK = txtGYQK;
	}

	/**
	 * @return the txtZLDZ
	 */
	public String getTxtZLDZ() {
		return txtZLDZ;
	}

	/**
	 * @param txtZLDZ the txtZLDZ to set
	 */
	public void setTxtZLDZ(String txtZLDZ) {
		this.txtZLDZ = txtZLDZ;
	}

	/**
	 * @return the txtBDCDYH
	 */
	public String getTxtBDCDYH() {
		return txtBDCDYH;
	}

	/**
	 * @param txtBDCDYH the txtBDCDYH to set
	 */
	public void setTxtBDCDYH(String txtBDCDYH) {
		this.txtBDCDYH = txtBDCDYH;
	}

	/**
	 * @return the txtQLLX
	 */
	public String getTxtQLLX() {
		return txtQLLX;
	}

	/**
	 * @param txtQLLX the txtQLLX to set
	 */
	public void setTxtQLLX(String txtQLLX) {
		this.txtQLLX = txtQLLX;
	}

	/**
	 * @return the txtQLXZ
	 */
	public String getTxtQLXZ() {
		return txtQLXZ;
	}

	/**
	 * @param txtQLXZ the txtQLXZ to set
	 */
	public void setTxtQLXZ(String txtQLXZ) {
		this.txtQLXZ = txtQLXZ;
	}

	/**
	 * @return the txtGHYT
	 */
	public String getTxtGHYT() {
		return txtGHYT;
	}

	/**
	 * @param txtGHYT the txtGHYT to set
	 */
	public void setTxtGHYT(String txtGHYT) {
		this.txtGHYT = txtGHYT;
	}

	/**
	 * @return the txtJZMJ
	 */
	public String getTxtJZMJ() {
		return txtJZMJ;
	}

	/**
	 * @param txtJZMJ the txtJZMJ to set
	 */
	public void setTxtJZMJ(String txtJZMJ) {
		this.txtJZMJ = txtJZMJ;
	}

	/**
	 * @return the txtSYQX
	 */
	public String getTxtSYQX() {
		return txtSYQX;
	}

	/**
	 * @param txtSYQX the txtSYQX to set
	 */
	public void setTxtSYQX(String txtSYQX) {
		this.txtSYQX = txtSYQX;
	}

	/**
	 * @return the txtQTZK
	 */
	public String getTxtQTZK() {
		return txtQTZK;
	}

	/**
	 * @param txtQTZK the txtQTZK to set
	 */
	public void setTxtQTZK(String txtQTZK) {
		this.txtQTZK = txtQTZK;
	}

	/**
	 * @return the txtSZQY
	 */
	public String getTxtSZQY() {
		return txtSZQY;
	}

	/**
	 * @param txtSZQY the txtSZQY to set
	 */
	public void setTxtSZQY(String txtSZQY) {
		this.txtSZQY = txtSZQY;
	}

	/**
	 * @return the txtSZLC
	 */
	public String getTxtSZLC() {
		return txtSZLC;
	}

	/**
	 * @param txtSZLC the txtSZLC to set
	 */
	public void setTxtSZLC(String txtSZLC) {
		this.txtSZLC = txtSZLC;
	}

	/**
	 * @return the txtJCNF
	 */
	public String getTxtJCNF() {
		return txtJCNF;
	}

	/**
	 * @param txtJCNF the txtJCNF to set
	 */
	public void setTxtJCNF(String txtJCNF) {
		this.txtJCNF = txtJCNF;
	}

	/**
	 * @return the txtHTJG
	 */
	public String getTxtHTJG() {
		return txtHTJG;
	}

	/**
	 * @param txtHTJG the txtHTJG to set
	 */
	public void setTxtHTJG(String txtHTJG) {
		this.txtHTJG = txtHTJG;
	}

	/**
	 * @return the txtZHXZ
	 */
	public String getTxtZHXZ() {
		return txtZHXZ;
	}

	/**
	 * @param txtZHXZ the txtZHXZ to set
	 */
	public void setTxtZHXZ(String txtZHXZ) {
		this.txtZHXZ = txtZHXZ;
	}

	/**
	 * @return the txtPGJG
	 */
	public String getTxtPGJG() {
		return txtPGJG;
	}

	/**
	 * @param txtPGJG the txtPGJG to set
	 */
	public void setTxtPGJG(String txtPGJG) {
		this.txtPGJG = txtPGJG;
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
}
