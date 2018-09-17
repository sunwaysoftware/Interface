/**
 * 
 */
package com.sunway.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import com.sunway.vo.Pgv00052;

/**
 * @author Andy.Gao
 *
 */
public class SessionCtrl implements Serializable {
	private static final long serialVersionUID = 584963643605336925L;
	
	public final static String SESSION_KEY_RANDPIC = "Session_Key_RandPic";
	/**
	 * 总记录数(暫存)
	 */
	public static Integer SESSION_KEY_RECORDCOUNT;
	/**
	 * 税收管辖ID
	 */
	public final static String SESSION_KEY_SSGX = "Session_Key_Ssgx";
	/**
	 * 税收管辖名称
	 */
	public final static String SESSION_KEY_SSGXNM = "Session_Key_SsgxNm";	
	/**
	 * 登陆帐号
	 */
	public final static String SESSION_KEY_USERID = "Session_Key_UserId";
	/**
	 * 登陆帐号的用户名
	 */
	public final static String SESSION_KEY_USERNAME = "Session_Key_UserName";
	/**
	 * 用户权限
	 */
	public final static String SESSION_KEY_USERROLE = "Session_Key_UserRole";
	/**
	 * 系统当前评税时点(yyyy)
	 */
	public final static String SESSION_KEY_PSSD = "Session_Key_Pssd";
	/**
	 * 系统当前评税时点(yyyymmdd)
	 */
	public final static String SESSION_KEY_PSSD_YMD = "Session_Key_PssdYMD";	
	/**
	 * 页面显示记录个数
	 */
	public final static String SESSION_KEY_DATASIZE = "Session_Key_DataSize";
	/**
	 * 是否是管理员
	 */
	public final static String SESSION_KEY_ISADMIN = "Session_Key_isAdmin";
	/**
	 * 行业
	 */
	public final static String SESSION_INFO_HY = "Session_Info_hy";
	/**
	 * 经济类型
	 */
	public final static String SESSION_INFO_JJLX = "Session_Info_jjlx";

	/**
	 * 税收管辖类型
	 */
	public final static String SESSION_INFO_SSGX = "Session_Info_Ssgx";
	/**
	 * 取得方式
	 */
	public final static String SESSION_INFO_QDFS = "Session_Info_qdfs";
	/**
	 * 免税设置
	 */
	public final static String SESSION_INFO_MSSZ = "Session_Info_mssz";
	/**
	 * 星级标准
	 */
	public final static String SESSION_INFO_XJBZ = "Session_Info_xjbz";
	/**
	 * 土地使用权类型
	 */
	public final static String SESSION_INFO_SYQLX = "Session_Info_syqlx";
	/**
	 * 土地所有权类型
	 */
	public final static String SESSION_INFO_TDSYQLX = "Session_Info_tdsyqlx";
	/**
	 * 建筑结构
	 */
	public final static String SESSION_INFO_JZJG = "Session_Info_jzjg";
	/**
	 * 土地用途
	 */
	public final static String SESSION_INFO_TDYT = "Session_Info_tdyt";
	/**
	 * 规划用途
	 */
	public final static String SESSION_INFO_GHYT = "Session_Info_ghyt";
	/**
	 * 税额总类
	 */
	public final static String SESSION_INFO_SEZL = "Session_Info_sezl";
	
	/**
	 * 土地等级
	 */
	public final static String SESSION_INFO_TDDJ = "Session_Info_tddj";
	/**
	 * 房屋朝向
	 */
	public final static String SESSION_INFO_FWCX = "Session_Info_fwcx";
	/**
	 * 房屋设施
	 */
	public final static String SESSION_INFO_FWSS = "Session_Info_fwss";
	/**
	 * 所在区域
	 */
	public final static String SESSION_INFO_SZQY = "Session_Info_szqy";
	/**
	 * 性质
	 */
	public final static String SESSION_INFO_XZ = "Session_Info_xz";
	/**
	 * 房屋用途
	 */
	public final static String SESSION_INFO_FWYT = "Session_Info_fwyt";
	/**
	 * 房屋类型(市场)
	 */
	public final static String SESSION_INFO_FWLX_SC = "Session_Info_fwlx_sc";
	/**
	 * 采光状况(市场)
	 */
	public final static String SESSION_INFO_CGZK_SC = "Session_Info_cgzk_sc";
	/**
	 * 交易类型(市场)
	 */
	public final static String SESSION_INFO_JYLX_SC = "Session_Info_jylx_sc";
	/**
	 * 证件类型
	 */
	public final static String SESSION_INFO_ZJLX = "Session_Info_zjlx";
	
	/**
	 * 所在区域列表
	 */
	public final static String  SESSION_LIST_SZQY= "Session_List_szqy";
	
	/**
	 * 税收管辖列表
	 */
	public final static String  SESSION_LIST_SSGX= "Session_List_ssgx";
	/**
	 * 跟国土的接口地址
	 */
	public final static String  FCJKDZ = "FCJKDZ";
	/**
	 * 国土部门编码
	 */
	public final static String  FCBMBM = "FCBMBM";	
	/**
	 * 跟征管的接口密码
	 */
	public final static String  CHANNEL_PWD="CHANNEL_PWD";
	/**
	 * 跟征管的接口帐户
	 */
	public final static String  CHANNEL_ACC="CHANNEL_ACC";
	/**
	 * 跟征管的接口代码
	 */
	public final static String  CHANNEL_CODE="CHANNEL_CODE";
	/**
	 * 跟征管的接口代码
	 */
	public final static String  WBMBM="WBMBM";
	/**
	 * 丘地号格式
	 */
	public final static String SESSION_KEY_QDHGS = "Session_Key_qdhgs";
		
	public Map<String,Object> appSession;
	
	public SessionCtrl(){};
	
	public SessionCtrl(Map<String,Object> appSession){
		this.appSession = appSession;
	}
	
	/**
	 * 登陆成功后[用户帐号]
	 * @return 用户帐号
	 */
	public String getUserId(){
		Object obj = appSession.get(SESSION_KEY_USERID);
		if(null == obj){
			return Constant.STRING_EMPTY;
		}else{
			return (String)obj;
		}
	}
	
	/**
	 * 登陆成功后[用户名]
	 * @return 用户名
	 */
	public String getUserName(){
		Object obj = appSession.get(SESSION_KEY_USERNAME);
		if(null == obj){
			return Constant.STRING_EMPTY;
		}else{
			return (String)obj;
		}
	}	
	
	/**
	 * 删除所有session
	 */
	public void RemoveAll(){
		appSession.clear();
	}
	
	/**
	 * 删除指定的session
	 * @param key 指定的session值
	 */
	public void Remove(Object key){
		appSession.remove(key);
	}
	
	/**
	 * 保存指定session
	 * @param key Session键
	 * @param value Session值
	 */
	public void Add(String key, Object value){
		appSession.put(key, value);
	}
	
	/**
	 * 读取指定session
	 * @param key Session键
	 * @return
	 */
	public String Get(String key){
		String resultValue = null;
		try {
			if(null!=appSession.get(key))
				resultValue = appSession.get(key).toString();			
		} catch (Exception e) {
			resultValue = "";
		}
		return resultValue;
	}
	
	/**
	 * 读取指定session
	 * @param key Session键
	 * @return
	 */
	public Object GetList(String key){
		Object resultValue = null;
		try {
			if(null!=appSession.get(key))
				resultValue = appSession.get(key);			
		} catch (Exception e) {
			resultValue = new Object();
		}
		return resultValue;
	}
	
	/**
	 * 读取所在区域
	 * @return
	 */
	public ArrayList<Pgv00052> ReadSzqyList() {
		ArrayList<Pgv00052> szqyList = new ArrayList<Pgv00052>();
		try {
			szqyList = (ArrayList<Pgv00052>)GetList(SessionCtrl.SESSION_LIST_SZQY);
		} catch (Exception e) {
		}
		return szqyList;
	}	
	
}
