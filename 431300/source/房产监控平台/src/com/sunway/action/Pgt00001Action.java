package com.sunway.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00001Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt00001;
import com.sunway.vo.Pgt000011;
import com.sunway.vo.Pgv00001;

/**
 * 
 * 参数基本信息
 * @author Andy.Gao
 * @version1.0
 * @category INFO_Action
 * @author Lee
 * @version2.0
 *
 */
public class Pgt00001Action extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1068622422815953280L;

	private IPgt00001Service t00001Service;
	
	//VIEW
	private InputStream excelStream;
	private Integer pageSize;
	private Integer pageIndex;
	
	private Integer rowCount;
	private ArrayList<Pgv00001> tabList;
	private ArrayList<Pgt00001> objList;
	private ArrayList<Pgt000011> zjlxList;
	private String ddlROOTIDFind;
	private String txtINFONMFind;
	
	//output stream
	private InputStream maxInfoId;
	private InputStream infoNav;
	
	//EDIT
	private ArrayList<Pgt00001> navList;
	private ArrayList<Pgt00001> treeList;
	private String SZQY;
	private String FWLX;
	private String XQDM;
	private String ROOTID;
	private String INFOID;
	private String NOINFOID;
	private String PARENTID;
	private String ACT;
	private Pgt00001 t00001Dao;
	private String ddlROOTID;
	private String rdoPARENT;
	private String txtINFOID;
	private String txtINFONM;
	private String txtVIEWORDER;
	private String txtNOTE;
	private Boolean rdoISDIR;
	private String RDOTYPE;
	private SessionCtrl sessionCtrl=new SessionCtrl();
	private String currentSSGXId;
	private String userRole;
	private String TYPE;
		

	/**
	 * 用于标识转向页面，所在区域、税收管辖、综合修正
	 */
	private String viewKey;
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		try {
			ReadInfo();
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());
			return ERROR;
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		return SUCCESS;
	}

	/**
	 * 查询
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		Pgv00001 v00001 = new Pgv00001();
		try {
			ReadInfo();
			v00001.setInfoid(txtINFOID);
			if(!Common.isNullOrEmpty(ddlROOTIDFind))
				v00001.setRootid(ddlROOTIDFind);
			if(!Common.isNullOrEmpty(Common.convertEncoding(txtINFONMFind)));
				v00001.setInfonm(Common.getSearchLike(txtINFONMFind));
			if(null==pageIndex)
				pageIndex = 1;
			
			v00001.setPageIndex(pageIndex);
			v00001.setPageSize(getPageSize());
			tabList = t00001Service.LoadAll(v00001);
			if(null!=tabList && tabList.size()>0){
				rowCount = tabList.get(0).getRecordCount();
				//pageCount = Common.getPageCount(rowCount, sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE));
			}else{
				//
				pageIndex = 1;
				rowCount = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * Create action
	 * @return
	 * @throws Exception
	 */
	public String create() throws Exception{
		Pgt00001 t1 = new Pgt00001();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())) {
				//取得用户选中的数据信息
				t1.setRootid(ROOTID);
				t1.setInfoid(INFOID);
				t00001Dao = t00001Service.LoadByPrimaryKey(t1);
			}
			ReadInfo();
			
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());
			return ERROR;
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		return SUCCESS;
	}
	
	/**
	 * validateUpdate
	 * @throws Exception
	 */
	public void validateUpdate() throws Exception{
		ReadInfo();
		t00001Dao = new Pgt00001();
		this.clearErrorsAndMessages();		
		//根据PK信息，为数据BEAN赋值
		if (Constant.MOD_UPDATE.equals(getACT())){
			t00001Dao.setRootid(ddlROOTID);
			t00001Dao.setInfoid(txtINFOID);
			t00001Dao = t00001Service.LoadByPrimaryKey(t00001Dao);			
		}
		//为数据BEAN赋值
		t00001Dao.setRootid(ddlROOTID);		
		t00001Dao.setInfoid(txtINFOID);
		t00001Dao.setParentid(rdoPARENT);
		t00001Dao.setInfonm(txtINFONM);
		t00001Dao.setVieworder(Common.convertToLong(txtVIEWORDER));
		t00001Dao.setSysfield(false);
		t00001Dao.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
		t00001Dao.setNote(txtNOTE);
		t00001Dao.setIsdir(rdoISDIR);
		t00001Dao.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
	}
	
	/**
	 * 编辑
	 * @return
	 * @throws Exception
	 */
	public String update()throws Exception{
		try {
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
			if (Constant.MOD_CREATE.equals(getACT())) {		//create
				if (t00001Service.GetInsertCommand(t00001Dao)){
					//插入成功后，设置编辑页面控件值
					t00001Dao.setInfoid(t00001Service.GetInfoIdByRootId(t00001Dao));
					t00001Dao.setInfonm("");
					this.addActionMessage("创建成功");
				}else
					this.addActionMessage("创建失败");
			}else if (Constant.MOD_UPDATE.equals(getACT())) {	// Update
				if(t00001Service.GetUpdateCommand(t00001Dao))
					this.addActionMessage("更新成功 ");
				else
					this.addActionError("更新失败 ");
				t00001Dao = t00001Service.LoadByPrimaryKey(t00001Dao);
			}else if (Constant.MOD_DELETE.equals(getACT())) {	// Delete
				if(t00001Service.GetDeleteCommand(t00001Dao))
					this.addActionMessage("删除成功 ");
				else
					this.addActionError("删除失败 ");
			}
			ReadInfo();
		}catch(SQLException sqlE){
 	     	sqlE.printStackTrace();
			if (sqlE.getErrorCode() == 20102) {
				this.addActionError("该数据项已经在输入信息中存在，请修改输入信息后再删除!");
			}
			return INPUT;
		}catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());
			return INPUT;
		}
		if (Constant.MOD_DELETE.equals(getACT()))// Delete
			return "successDEL";
		else
			return SUCCESS;
	}
	

	/**
	 * 数据导出
	 * @return
	 * @throws Exception
	 */
	public String export() throws Exception {
		Pgv00001 v00001 = new Pgv00001();
//		StringBuffer strBuf = new StringBuffer();
		try{
			ReadInfo();
			
			if(!Common.isNullOrEmpty(ddlROOTIDFind))
				v00001.setRootid(ddlROOTIDFind);
			if(!Common.isNullOrEmpty(Common.getSearchLike(Common.convertEncoding(txtINFONMFind))));
				v00001.setInfonm(txtINFONMFind);
			
			
			ByteArrayOutputStream out = (ByteArrayOutputStream)t00001Service.ExportAll(v00001);
			setExcelStream(new ByteArrayInputStream(out.toByteArray()));
		}catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());
			return INPUT;
		}
		return SUCCESS;
	}
	
	/**
	 * AJAX方法使用，取得INFOID
	 * @return
	 * @throws Exception
	 */
	public String getInfoID() throws Exception{
		t00001Dao = new Pgt00001();
		StringBuffer strBuf = new StringBuffer();
		try {
			if(!Common.isNullOrEmpty(ROOTID)){
				t00001Dao.setRootid(ROOTID);
				strBuf.append(t00001Service.GetInfoIdByRootId(t00001Dao));
				if (!"null".equals(strBuf.toString()))
					maxInfoId = Common.exportTEXT(strBuf);
			}else{
				maxInfoId = Common.exportTEXT(strBuf);
			}
		} catch (Exception e) {
	        e.printStackTrace();
			this.addActionError(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 读取导航条数据，AJAX方法用
	 * @return
	 * @throws Exception
	 */
	public String loadNavigator() throws Exception{		
		return getNavigator(ROOTID,INFOID,NOINFOID);
	}
//	/**
//	 * 读取LX导航条数据，AJAX方法用
//	 * @return
//	 * @throws Exception
//	 */
//	public String loadLXNavigator() throws Exception{
//		return getNavigator(t00001Service.GetInfoLX(),INFOID,NOINFOID);
//	}
	/**
	 * 读取HY导航条数据，AJAX方法用
	 * @return
	 * @throws Exception
	 */
	public String loadHYNavigator() throws Exception{		
		return getNavigator(t00001Service.GetInfoHY(),INFOID,NOINFOID);
	}
//	/**
//	 * 读取LLZK导航条数据，AJAX方法用
//	 * @return
//	 * @throws Exception
//	 */
//	public String loadGWHJNavigator() throws Exception{
//		return getNavigator(t00001Service.GetInfoGWHJ(),INFOID,NOINFOID);
//	}
	
	/**
	 * 读取JJLX导航条数据，AJAX方法用
	 * @return
	 * @throws Exception
	 */
	public String loadJJLXNavigator() throws Exception{		
		return getNavigator(t00001Service.GetInfoJJLX(),INFOID,NOINFOID);
	}
	
	/**
	 * 读取SSGX导航条数据，AJAX方法用
	 * @return
	 * @throws Exception
	 */
	public String loadSSGXNavigator() throws Exception{		
		return getNavigator(t00001Service.GetInfoSSGX(),INFOID,NOINFOID);
	}
	
	/**
	 * 读取QDFS导航条数据，AJAX方法用
	 * @return
	 * @throws Exception
	 */
	public String loadQDFSNavigator() throws Exception{
		return getNavigator(t00001Service.GetInfoQDFS(),INFOID,NOINFOID);
	}
	
	/**
	 * 读取MSSZ导航条数据，AJAX方法用
	 * @return
	 * @throws Exception
	 */
	public String loadMSSZNavigator() throws Exception{
		return getNavigator(t00001Service.GetInfoMSSZ(),INFOID,NOINFOID);
	}
	
	/**
	 * 读取XJBZ导航条数据，AJAX方法用
	 * @return
	 * @throws Exception
	 */
	public String loadXJBZNavigator() throws Exception{
		return getNavigator(t00001Service.GetInfoXJBZ(),INFOID,NOINFOID);
	}
	/**
	 * 读取CG导航条数据，AJAX方法用
	 * @return
	 * @throws Exception
	 */
	public String loadLCNavigator() throws Exception{
		return getNavigator(t00001Service.GetInfoLC(),INFOID,NOINFOID);
	}
	/**
	 * 读取SYQLX导航条数据，AJAX方法用
	 * @return
	 * @throws Exception
	 */
	public String loadSYQLXNavigator() throws Exception{
		return getNavigator(t00001Service.GetInfoSYQLX(),INFOID,NOINFOID);
	}
	
	/**
	 * 读取TDSYQLX导航条数据，AJAX方法用
	 * @return
	 * @throws Exception
	 */
	public String loadTDSYQLXNavigator() throws Exception{
		return getNavigator(t00001Service.GetInfoTDSYQLX(),INFOID,NOINFOID);
	}
	
	/**
	 * 读取JZJG导航条数据，AJAX方法用
	 * @return
	 * @throws Exception
	 */
	public String loadJZJGNavigator() throws Exception{
		return getNavigator(t00001Service.GetInfoJZJG(),INFOID,NOINFOID);
	}
	
	/**
	 * 读取TDYT导航条数据，AJAX方法用
	 * @return
	 * @throws Exception
	 */
	public String loadTDYTNavigator() throws Exception{
		return getNavigator(t00001Service.GetInfoTDYT(),INFOID,NOINFOID);
	}
	
	/**
	 * 读取TDDJ导航条数据，AJAX方法用
	 * @return
	 * @throws Exception
	 */
	public String loadTDDJNavigator() throws Exception{	
		return getNavigator(t00001Service.GetInfoTDDJ(),INFOID,NOINFOID);
	}
	
	/**
	 * 读取FWCX导航条数据，AJAX方法用
	 * @return
	 * @throws Exception
	 */
	public String loadFWCXNavigator() throws Exception{
		return getNavigator(t00001Service.GetInfoFWCX(),INFOID,NOINFOID);
	}
	
	/**
	 * 读取FWSS导航条数据，AJAX方法用
	 * @return
	 * @throws Exception
	 */
	public String loadFWSSNavigator() throws Exception{
		return getNavigator(t00001Service.GetInfoFWSS(),INFOID,NOINFOID);
	}
	
	/**
	 * 读取SZQY导航条数据，AJAX方法用
	 * @return
	 * @throws Exception
	 */
	public String loadSZQYNavigator() throws Exception{
		return getNavigator(t00001Service.GetInfoSzqy(),INFOID,NOINFOID);
	}
	
	/**
	 * 读取XZ导航条数据，AJAX方法用
	 * @return
	 * @throws Exception
	 */
	public String loadXZNavigator() throws Exception{
		return getNavigator(t00001Service.GetInfoXZ(),INFOID,NOINFOID);
	}
	
	/**
	 * 读取FWYT导航条数据，AJAX方法用
	 * @return
	 * @throws Exception
	 */
	public String loadFWYTNavigator() throws Exception{
		return getNavigator(t00001Service.GetInfoFWYT(),INFOID,NOINFOID);
	}
	
	/**
	 * 读取FWLX导航条数据，AJAX方法用
	 * @return
	 * @throws Exception
	 */
	public String loadFWLXNavigator() throws Exception{
		return getNavigator(t00001Service.GetInfoFWLX_SC(),INFOID,NOINFOID);
	}
	/**
	 * 读取FWLX导航条数据，AJAX方法用
	 * @return
	 * @throws Exception
	 */
	public String loadBGLLXNavigator() throws Exception{
		return getNavigator(t00001Service.GetInfoBGLLX_SY(),INFOID,NOINFOID);
	}
	
	/**
	 * 读取CGZK导航条数据，AJAX方法用
	 * @return
	 * @throws Exception
	 */
	public String loadCGZKNavigator() throws Exception{
		return getZHXZNavigator(t00001Service.GetInfoZHXZ(),INFOID,NOINFOID,SZQY,FWLX);
	}
	
	/**
	 * 读取JYLX导航条数据，AJAX方法用
	 * @return
	 * @throws Exception
	 */
	public String loadJYLXNavigator() throws Exception{
		return getNavigator(t00001Service.GetInfoJYLX_SC(),INFOID,NOINFOID);
	}
	
	/**
	 * 读取ZJLX导航条数据，AJAX方法用
	 * @return
	 * @throws Exception
	 */
	public String loadZJLXNavigator() throws Exception{
		return getNavigator(t00001Service.GetInfoZJLX(),INFOID,NOINFOID);
	}

	/**
	 * 读取[交通状况(市场)]导航条数据，AJAX方法用
	 */
	public String loadJTZKNavigator() throws Exception { 
		return getNavigator(t00001Service.GetInfoJTZK(),INFOID,NOINFOID);
	}
	
	/**
	 * 读取[物业状况(市场)]导航条数据，AJAX方法用
	 */
	public String loadWYZKNavigator() throws Exception { 
		return getNavigator(t00001Service.GetInfoWYZK(),INFOID,NOINFOID);
	}	
	
	/**
	 * 读取[装修状况(市场)]导航条数据，AJAX方法用
	 */
	public String loadZXZKNavigator() throws Exception { 
		return getNavigator(t00001Service.GetInfoZXZK(),INFOID,NOINFOID);
	}	
	
	/**
	 * AJAX方法使用，取得城镇土地等级导航
	 * @return
	 * @throws Exception
	 */
	public String LoadLCNav() throws Exception{
		return getNavStream(t00001Service.GetInfoLC(),INFOID);
	}
	/**
	 * 读取导航条数据，AJAX方法用
	 * @return
	 * @throws Exception
	 */
	private String getNavigator(String rootID,String infoID,String noinfoID) throws Exception{
		Pgt00001 v00001 = new Pgt00001();
		try {
			ReadInfo();
			if(!Common.isNullOrEmpty(rootID))
				v00001.setRootid(rootID);
			if(!Common.isNullOrEmpty(infoID))
				v00001.setInfoid(infoID);
			else
				v00001.setInfoid(rootID);
			if (!Common.isNullOrEmpty(noinfoID)) {
				v00001.setNoinfoid(noinfoID);
			}
			navList = t00001Service.LoadNavigator(v00001);
			currentSSGXId = sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX);
			if(null==navList || navList.size()==0){
				v00001.setInfoid(rootID);
				navList = t00001Service.LoadNavigator(v00001);
			}
			treeList = t00001Service.LoadTreeList(v00001);
			t00001Dao = t00001Service.LoadByPrimaryKey(v00001);
			
		} catch (Exception e) {
			 e.printStackTrace();
			this.addActionError(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 读取综合修正导航条数据，AJAX方法用
	 * @return
	 * @throws Exception
	 */
	private String getZHXZNavigator(String rootID,String infoID,String noinfoID,String szqy,String fwlx) throws Exception{
		Pgt00001 v00001 = new Pgt00001();
		try {
			ReadInfo();
			if(!Common.isNullOrEmpty(rootID))
				v00001.setRootid(rootID);
			if(!Common.isNullOrEmpty(infoID))
				v00001.setInfoid(infoID);
			else
				v00001.setInfoid(rootID);
			if (!Common.isNullOrEmpty(noinfoID)) {
				v00001.setNoinfoid(noinfoID);
			}
			v00001.setCd00001Szqy(szqy);
			v00001.setCd00001Fwlx(fwlx);
			navList = t00001Service.LoadNavigator(v00001);
			if(null==navList || navList.size()==0){
				v00001.setInfoid(rootID);
				navList = t00001Service.LoadNavigator(v00001);
			}
			treeList = t00001Service.LoadZhxzTreeList(v00001);
			t00001Dao = t00001Service.LoadByPrimaryKey(v00001);
			
		} catch (Exception e) {
			 e.printStackTrace();
			this.addActionError(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * AJAX方法使用，取得行业导航
	 * @return
	 * @throws Exception
	 */
	public String LoadHYNav() throws Exception{
		return getNavStream(t00001Service.GetInfoHY(),INFOID);
	}
		
	/**
	 * AJAX方法使用，取得经济类型导航
	 * @return
	 * @throws Exception
	 */
	public String LoadJJLXNav() throws Exception{		
		return getNavStream(t00001Service.GetInfoJJLX(),INFOID);
	}
	
	/**
	 * AJAX方法使用，取得税收管辖导航
	 * @return
	 * @throws Exception
	 */
	public String LoadSSGXNav() throws Exception{		
		return getNavStream(t00001Service.GetInfoSSGX(),INFOID);
	}
	
	/**
	 * AJAX方法使用，取得取得方式导航
	 * @return
	 * @throws Exception
	 */
	public String LoadQDFSNav() throws Exception{
		return getNavStream(t00001Service.GetInfoQDFS(),INFOID);
	}
//	/**
//	 * AJAX方法使用，取得城镇土地等级导航
//	 * @return
//	 * @throws Exception
//	 */
//	public String LoadGWHJNav() throws Exception{
//		return getNavStream(t00001Service.GetInfoGWHJ(),INFOID);
//	}
	/**
	 * AJAX方法使用，取得免税设置导航
	 * @return
	 * @throws Exception
	 */
	public String LoadMSSZNav() throws Exception{
		return getNavStream(t00001Service.GetInfoMSSZ(),INFOID);
	}
	
	/**
	 * AJAX方法使用，取得星级标准导航
	 * @return
	 * @throws Exception
	 */
	public String LoadXJBZNav() throws Exception{
		return getNavStream(t00001Service.GetInfoXJBZ(),INFOID);
	}
	
	/**
	 * AJAX方法使用，取得土地使用权类型导航
	 * @return
	 * @throws Exception
	 */
	public String LoadSYQLXNav() throws Exception{
		return getNavStream(t00001Service.GetInfoSYQLX(),INFOID);
	}
	
	/**
	 * AJAX方法使用，取得土地所有权类型导航
	 * @return
	 * @throws Exception
	 */
	public String LoadTDSYQLXNav() throws Exception{
		return getNavStream(t00001Service.GetInfoTDSYQLX(),INFOID);
	}
	/**
	 * AJAX方法使用，取得建筑结构导航
	 * @return
	 * @throws Exception
	 */
	public String LoadJZJGNav() throws Exception{
		return getNavStream(t00001Service.GetInfoJZJG(),INFOID);
	}
	/**
	 * AJAX方法使用，取得土地用途导航
	 * @return
	 * @throws Exception
	 */
	public String LoadTDYTNav() throws Exception{
		return getNavStream(t00001Service.GetInfoTDYT(),INFOID);
	}
	
	/**
	 * AJAX方法使用，取得土地等级导航
	 * @return
	 * @throws Exception
	 */
	public String LoadTDDJNav() throws Exception{
		return getNavStream(t00001Service.GetInfoTDDJ(),INFOID);
	}
	
	/**
	 * AJAX方法使用，取得房屋朝向导航
	 * @return
	 * @throws Exception
	 */
	public String LoadFWCXNav() throws Exception{
		return getNavStream(t00001Service.GetInfoFWCX(),INFOID);
	}
	/**
	 * AJAX方法使用，取得房屋设施导航
	 * @return
	 * @throws Exception
	 */
	public String LoadFWSSNav() throws Exception{
		return getNavStream(t00001Service.GetInfoFWSS(),INFOID);
	}
	/**
	 * AJAX方法使用，取得所在区域导航
	 * @return
	 * @throws Exception
	 */
	public String LoadSZQYNav() throws Exception{
		return getNavStream(t00001Service.GetInfoSzqy(),INFOID);
	}
	/**
	 * AJAX方法使用，取得税收级次(成本,收益)导航
	 * @return
	 * @throws Exception
	 */
	public String LoadXZNav() throws Exception{
		return getNavStream(t00001Service.GetInfoXZ(),INFOID);
	}

	/**
	 * AJAX方法使用，取得房屋用途导航
	 * @return
	 * @throws Exception
	 */
	public String LoadFWYTNav() throws Exception{
		return getNavStream(t00001Service.GetInfoFWYT(),INFOID);
	}
	/**
	 * AJAX方法使用，取得证件类型导航
	 * @return
	 * @throws Exception
	 */
	public String LoadZJLXNav() throws Exception{
		return getNavStream(t00001Service.GetInfoZJLX(),INFOID);
	}
	/**
	 * AJAX方法使用，取得房屋类型(市场)导航
	 * @return
	 * @throws Exception
	 */
	public String LoadFWLXNav() throws Exception{
		return getNavStream(t00001Service.GetInfoFWLX_SC(),INFOID);
	}
	/**
	 * AJAX方法使用，取得房屋类型(市场)导航
	 * @return
	 * @throws Exception
	 */
	public String LoadBGLLXNav() throws Exception{
		return getNavStream(t00001Service.GetInfoBGLLX_SY(),INFOID);
	}
	/**
	 * AJAX方法使用，取得采光状况(市场)导航
	 * @return
	 * @throws Exception
	 */
	public String LoadCGZKNav() throws Exception{
		if(Common.isNullOrEmpty(ROOTID))
			ROOTID = t00001Service.GetInfoCGZK_SC();
		return getNavStream(ROOTID,INFOID);
	}
	
	/**
	 * 读取[交通状况(市场)]导航条数据，AJAX方法用
	 */
	public String LoadJTZKNav() throws Exception { 
		return getNavStream(t00001Service.GetInfoJTZK(),INFOID);
	}
	
	/**
	 * 读取[物业状况(市场)]导航条数据，AJAX方法用
	 */
	public String LoadWYZKNav() throws Exception { 
		return getNavStream(t00001Service.GetInfoWYZK(),INFOID);
	}	
	
	/**
	 * 读取[装修状况(市场)]导航条数据，AJAX方法用
	 */
	public String LoadZXZKNav() throws Exception { 
		return getNavStream(t00001Service.GetInfoZXZK(),INFOID);
	}		
	
//	/**
//	 * AJAX方法使用，取得城镇土地等级导航
//	 * @return
//	 * @throws Exception
//	 */
//	public String LoadLXNav() throws Exception{
//		return getNavStream(t00001Service.GetInfoLX(),INFOID);
//	}
	/**
	 * AJAX方法使用，取得交易类型(市场)导航
	 * @return
	 * @throws Exception
	 */
	public String LoadJYLXNav() throws Exception{
		return getNavStream(t00001Service.GetInfoJYLX_SC(),INFOID);
	}

	private String getNavStream(String rootID, String infoID) throws Exception{
		Pgt00001 v00001 = new Pgt00001();
		StringBuffer navStr = new StringBuffer();
		try {
			if(!Common.isNullOrEmpty(infoID))
				v00001.setInfoid(infoID);
			v00001.setRootid(rootID);
			navStr.append(t00001Service.LoadNavString(v00001));
			if ("null".equals(navStr.toString())) {
				navStr=null;
			}
			infoNav = Common.exportTEXT(navStr);
		} catch (Exception e) {
			 e.printStackTrace();
			this.addActionError(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 读取基础信息
	 * @throws Exception
	 */
	private void ReadInfo() throws Exception {
		//读取根节点
		objList = t00001Service.LoadAllByRoot();
	}
	
	/**
	 * 通过市场、商业、工业得到房屋类型
	 * GetINFOListByFWLX
	 * @author LeiJia
	*/
	public String GetINFOListByFWLX(){
		if(LOG.isDebugEnabled()){
			LOG.debug("getINFOListByRootId() ********** start **********");
		}
		try{
			objList = t00001Service.GetINFOListByFWLX(TYPE);
		}catch(Exception e){
			e.printStackTrace();
			if(LOG.isDebugEnabled()){
				LOG.debug("getINFOListByRootId() ********** end **********");
			}
			return ERROR;
		}
		if(LOG.isDebugEnabled()){
			LOG.debug("getINFOListByRootId() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 得到商业小区房屋类型
	 * GetINFOListBySYXQFWLX
	 * @author LeiJia
	 */
	public String GetINFOListBySYXQFWLX(){
		if(LOG.isDebugEnabled()){
			LOG.debug("getINFOListByRootId() ********** start **********");
		}
		try{
			objList = t00001Service.GetINFOListBySYXQFWLX();
		}catch(Exception e){
			e.printStackTrace();
			if(LOG.isDebugEnabled()){
				LOG.debug("getINFOListByRootId() ********** end **********");
			}
			return ERROR;
		}
		if(LOG.isDebugEnabled()){
			LOG.debug("getINFOListByRootId() ********** end **********");
		}
		return SUCCESS;
	}
	
	
	/**
	 * 根据ROOTID 获取数据
	 * @return
	 * @throws Exception
	 */
	public String getINFOListByRootId()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("getINFOListByRootId() ********** start **********");
		}
		try{
			objList = t00001Service.GetINFOListByROOTID(ROOTID,FWLX,SZQY,XQDM);
		}catch(Exception e){
			e.printStackTrace();
			if(LOG.isDebugEnabled()){
				LOG.debug("getINFOListByRootId() ********** end **********");
			}
			return ERROR;
		}
		if(LOG.isDebugEnabled()){
			LOG.debug("getINFOListByRootId() ********** end **********");
		}
		return SUCCESS;
	}
	
//	/**
//	 * 根据ZJLX 获取数据
//	 * @return
//	 * @throws Exception
//	 */
//	public String getZJLXINFOList()throws Exception{
//		if(LOG.isDebugEnabled()){
//			LOG.debug("getZJLXINFOList() ********** start **********");
//		}
//		try{
//			zjlxList = t00001Service.GetZJLXINFOList(ROOTID);
//		}catch(Exception e){
//			e.printStackTrace();
//			if(LOG.isDebugEnabled()){
//				LOG.debug("getZJLXINFOList() ********** end **********");
//			}
//			return ERROR;
//		}
//		if(LOG.isDebugEnabled()){
//			LOG.debug("getZJLXINFOList() ********** end **********");
//		}
//		return SUCCESS;
//	}
	
	
	/**
	 * 转向所在区域、税收管辖、综合修正维护页面
	 */
	public String executeView()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("executeView() ********** start **********");
		}
		
		//KEY值： SZQY所在区域、SSGX税收管辖、ZHXZ综合修正
		ReadInfo();
		setDdlROOTIDFind(viewKey);
		if(LOG.isDebugEnabled()){
			LOG.debug("executeView() ********** end **********");
		}
		return SUCCESS;
	}

	
	
	
	/*******************getter and setter method!**************/
	
	/**
	 * @param t00001Service the t00001Service to set
	 */
	public void setT00001Service(IPgt00001Service t00001Service) {
		this.t00001Service = t00001Service;
	}

	/**
	 * @return the t00001Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00001Service getT00001Service() {
		return t00001Service;
	}

	/**
	 * @param objList the objList to set
	 */
	public void setObjList(ArrayList<Pgt00001> objList) {
		this.objList = objList;
	}

	/**
	 * @return the objList
	 */
	public ArrayList<Pgt00001> getObjList() {
		return objList;
	}

	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv00001> tabList) {
		this.tabList = tabList;
	}

	/**
	 * @return the tabList
	 */
	public ArrayList<Pgv00001> getTabList() {
		return tabList;
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
	 * @return the ddlROOTIDFind
	 */
	public String getDdlROOTIDFind() {
		return ddlROOTIDFind;
	}

	/**
	 * @param ddlROOTIDFind the ddlROOTIDFind to set
	 */
	public void setDdlROOTIDFind(String ddlROOTIDFind) {
		this.ddlROOTIDFind = ddlROOTIDFind;
	}

	/**
	 * @return the txtINFONMFind
	 */
	public String getTxtINFONMFind() {
		return txtINFONMFind;
	}

	/**
	 * @param txtINFONMFind the txtINFONMFind to set
	 */
	public void setTxtINFONMFind(String txtINFONMFind) {
		this.txtINFONMFind = txtINFONMFind;
	}

	/**
	 * @param excelStream the excelStream to set
	 */
	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}

	/**
	 * @return the excelStream
	 */
	public InputStream getExcelStream() {
		return excelStream;
	}

	/**
	 * @return the navList
	 */
	public ArrayList<Pgt00001> getNavList() {
		return navList;
	}

	/**
	 * @param navList the navList to set
	 */
	public void setNavList(ArrayList<Pgt00001> navList) {
		this.navList = navList;
	}

	/**
	 * @return the treeList
	 */
	public ArrayList<Pgt00001> getTreeList() {
		return treeList;
	}

	/**
	 * @param treeList the treeList to set
	 */
	public void setTreeList(ArrayList<Pgt00001> treeList) {
		this.treeList = treeList;
	}

	/**
	 * @return the rOOTID
	 */
	public String getROOTID() {
		return ROOTID;
	}

	/**
	 * @param rOOTID the rOOTID to set
	 */
	public void setROOTID(String rOOTID) {
		ROOTID = rOOTID;
	}

	/**
	 * @return the iNFOID
	 */
	public String getINFOID() {
		return INFOID;
	}

	/**
	 * @param iNFOID the iNFOID to set
	 */
	public void setINFOID(String iNFOID) {
		INFOID = iNFOID;
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
	 * @return the t00001Dao
	 */
	public Pgt00001 getT00001Dao() {
		return t00001Dao;
	}

	/**
	 * @param t00001Dao the t00001Dao to set
	 */
	public void setT00001Dao(Pgt00001 t00001Dao) {
		this.t00001Dao = t00001Dao;
	}

	/**
	 * @return the ddlROOTID
	 */
	public String getDdlROOTID() {
		return ddlROOTID;
	}

	/**
	 * @param ddlROOTID the ddlROOTID to set
	 */
	public void setDdlROOTID(String ddlROOTID) {
		this.ddlROOTID = ddlROOTID;
	}

	/**
	 * @return the txtINFOID
	 */
	public String getTxtINFOID() {
		return txtINFOID;
	}

	/**
	 * @param txtINFOID the txtINFOID to set
	 */
	public void setTxtINFOID(String txtINFOID) {
		this.txtINFOID = txtINFOID;
	}

	/**
	 * @return the txtINFONM
	 */
	public String getTxtINFONM() {
		return txtINFONM;
	}

	/**
	 * @param txtINFONM the txtINFONM to set
	 */
	public void setTxtINFONM(String txtINFONM) {
		this.txtINFONM = txtINFONM;
	}

	/**
	 * @return the txtVIEWORDER
	 */
	public String getTxtVIEWORDER() {
		return txtVIEWORDER;
	}

	/**
	 * @param txtVIEWORDER the txtVIEWORDER to set
	 */
	public void setTxtVIEWORDER(String txtVIEWORDER) {
		this.txtVIEWORDER = txtVIEWORDER;
	}

	/**
	 * @return the rdoPARENT
	 */
	public String getRdoPARENT() {
		return rdoPARENT;
	}

	/**
	 * @param rdoPARENT the rdoPARENT to set
	 */
	public void setRdoPARENT(String rdoPARENT) {
		this.rdoPARENT = rdoPARENT;
	}

	/**
	 * @return the maxInfoId
	 */
	public InputStream getMaxInfoId() {
		return maxInfoId;
	}

	/**
	 * @param maxInfoId the maxInfoId to set
	 */
	public void setMaxInfoId(InputStream maxInfoId) {
		this.maxInfoId = maxInfoId;
	}

	/**
	 * @return the nOINFOID
	 */
	public String getNOINFOID() {
		return NOINFOID;
	}

	/**
	 * @param nOINFOID the nOINFOID to set
	 */
	public void setNOINFOID(String nOINFOID) {
		NOINFOID = nOINFOID;
	}

	/**
	 * @return the infoNav
	 */
	public InputStream getInfoNav() {
		return infoNav;
	}

	/**
	 * @param infoNav the infoNav to set
	 */
	public void setInfoNav(InputStream infoNav) {
		this.infoNav = infoNav;
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
	 * @return the rDOTYPE
	 */
	public String getRDOTYPE() {
		return RDOTYPE;
	}

	/**
	 * @param rDOTYPE the rDOTYPE to set
	 */
	public void setRDOTYPE(String rDOTYPE) {
		RDOTYPE = rDOTYPE;
	}

	/**
	 * @return the pARENTID
	 */
	public String getPARENTID() {
		return PARENTID;
	}

	/**
	 * @param pARENTID the pARENTID to set
	 */
	public void setPARENTID(String pARENTID) {
		PARENTID = pARENTID;
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
	 * @return the currentSSGXId
	 */
	public String getCurrentSSGXId() {
		return currentSSGXId;
	}

	/**
	 * @param currentSSGXId the currentSSGXId to set
	 */
	public void setCurrentSSGXId(String currentSSGXId) {
		this.currentSSGXId = currentSSGXId;
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

	public String getFWLX() {
		return FWLX;
	}

	public void setFWLX(String fWLX) {
		FWLX = fWLX;
	}

	public ArrayList<Pgt000011> getZjlxList() {
		return zjlxList;
	}

	public void setZjlxList(ArrayList<Pgt000011> zjlxList) {
		this.zjlxList = zjlxList;
	}

	public String getXQDM() {
		return XQDM;
	}

	public void setXQDM(String xQDM) {
		XQDM = xQDM;
	}

	public String getViewKey() {
		return viewKey;
	}

	public void setViewKey(String viewKey) {
		this.viewKey = viewKey;
	}

	public String getTYPE() {
		return TYPE;
	}

	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionCtrl.appSession = arg0;
	}

}
