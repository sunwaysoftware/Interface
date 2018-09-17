

/**
 * @author sunxdd
 *
 */

package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00050Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.Constant;
import com.sunway.util.FormatUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv00050;

public class Pgt00050Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 68204430262451375L;
	private IPgt00050Service t00050Service;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	//grid list
	private ArrayList<Pgv00050> rows;
	// 页面Bean
	private String pk;
	private Pgv00050 t00050Bean;
	//编辑操作符
	private String ACT;

	//分页参数
	private Integer pageIndex;
	private Integer pageSize;
	private Integer total;
	
	//编辑项
	private String txtPGGSMC;
	private String txtSSGX;

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	/**
	 * 新增状态处理
	 * @return
	 * @throws Exception
	 */
	public String create() throws Exception{
		try {
			if(!Constant.MOD_CREATE.equals(ACT)){
				//取得用户选中的数据信息
				Pgv00050 b = new Pgv00050();
				b.setId(pk);
				t00050Bean = t00050Service.LoadByPrimaryKey(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());			
			return INPUT;
		}
		
		return SUCCESS;
	}
	
	/**
	 * 查询
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		Pgv00050 b = new Pgv00050();
		try {						
			b.setPageIndex(pageIndex);
			b.setPageSize(getPageSize());
			b.setPggsmc(FormatUtil.toSearchLike(txtPGGSMC));
			if (CheckUtil.chkEmpty(txtSSGX)){
				b.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			}else{
				b.setCd00001Ssgx(txtSSGX);
			}
			rows = t00050Service.LoadAll(b);
			//分页设置
			if(null!=rows && rows.size()>0){
				total = rows.get(0).getTotal();
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
		t00050Bean = new Pgv00050();
		t00050Bean.setId(pk);

		//根据PK信息，为数据BEAN赋值
		if (!Constant.MOD_DELETE.equals(ACT)){
			if (Constant.MOD_UPDATE.equals(ACT)){
				t00050Bean = t00050Service.LoadByPrimaryKey(t00050Bean);
			}
			t00050Bean.setPggsmc(txtPGGSMC);
			t00050Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			if (CheckUtil.chkEmpty(txtSSGX)){
				t00050Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			}else{
				t00050Bean.setCd00001Ssgx(txtSSGX);
			}			
		}
	}
	
	public String update() throws Exception {
		try {
			if(Constant.MOD_CREATE.equals(ACT)){// Create				
				//存储文件列表于数据库
				if(t00050Service.GetInsertCommand(t00050Bean)){
					this.addActionMessage(getText(Constant.MSG_CREATE_OK));
				}else {
					this.addActionError(getText(Constant.MSG_CREATE_NG));
				}
			} else if (Constant.MOD_UPDATE.equals(ACT)) {	// Update				
				if(t00050Service.GetUpdateCommand(t00050Bean)){
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK));
				} else
					this.addActionError(getText(Constant.MSG_UPDATE_NG));
				
			} else if (Constant.MOD_DELETE.equals(ACT)) {	// Delete
				if(t00050Service.GetDeleteCommand(t00050Bean))
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
		Pgv00050 b = new Pgv00050();
		String info = SUCCESS;
		try {
			b.setId(pk);
			t00050Bean = t00050Service.LoadByPrimaryKey(b);			
			
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

	public ArrayList<Pgv00050> getRows() {
		return rows;
	}

	public void setRows(ArrayList<Pgv00050> rows) {
		this.rows = rows;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}	

	public Pgv00050 getT00050Bean() {
		return t00050Bean;
	}

	public void setT00050Bean(Pgv00050 t00050Bean) {
		this.t00050Bean = t00050Bean;
	}
	

	@JSON(deserialize=false, serialize=false)
	public IPgt00050Service getT00050Service() {
		return t00050Service;
	}

	public void setT00050Service(IPgt00050Service t00050Service) {
		this.t00050Service = t00050Service;
	}

	public String getPk() {
		return pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}

	public String getTxtPGGSMC() {
		return txtPGGSMC;
	}

	public void setTxtPGGSMC(String txtPGGSMC) {
		this.txtPGGSMC = txtPGGSMC;
	}

	public String getTxtSSGX() {
		return txtSSGX;
	}

	public void setTxtSSGX(String txtSSGX) {
		this.txtSSGX = txtSSGX;
	}
}