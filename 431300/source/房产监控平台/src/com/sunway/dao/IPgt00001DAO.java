package com.sunway.dao;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.vo.Pgt00001;
import com.sunway.vo.Pgt02056;
import com.sunway.vo.Pgv00001;

/**
 * 
 * 参数基本信息
 * @author Andy.Gao
 * @version1.0
 * 
 * @author Lee
 * @version2.0
 */
public interface IPgt00001DAO {

	/**
	 * 讀取【星級標準】. 
	 */
	public ArrayList<Pgt00001> LoadAllXjbz(Pgt02056 xjbz) throws Exception;	
	
	/**
	 * 進行數據刪除操作. 
	 */
	public boolean GetDeleteCommand(Pgt00001 info) throws Exception;

	/**
	 * 進行數據插入操作. 
	 */
	public boolean GetInsertCommand(Pgt00001 info) throws Exception;

	/**
	 * 進行數據更新操作. 
	 */
	public boolean GetUpdateCommand(Pgt00001 info) throws Exception;

	/**
	 * 進行數據提取操作. 
	 */
	public ArrayList<Pgv00001> LoadAll(Pgv00001 info) throws Exception;

	/**
	 * 按PK進行數據提取. 
	 */
	public Pgt00001 LoadByPrimaryKey(Pgt00001 info) throws Exception;
	
	/**
	 * 進行數據导出操作. 
	 */
	public OutputStream ExportAll(Pgv00001 info) throws Exception;
	
	/**
	 * 取得INFO的根节点信息
	 * @param info
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgt00001> LoadAllByRoot() throws Exception;
	
	
	/**
	 * 取得导航数据
	 * @param info
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgt00001> LoadNavigator(Pgt00001 info) throws Exception;
	
	/**
	 * 取得导航提示文字
	 * @param info
	 * @return
	 * @throws Exception
	 */
	public String LoadNavString(Pgt00001 info) throws Exception;
	
	
	/**
	 * 根据导航取得数列表
	 * @param info
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgt00001> LoadTreeList(Pgt00001 info) throws Exception;
	
	/**
	 * 读取综合修正树列表
	 * @param info
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgt00001> LoadZhxzTreeList(Pgt00001 info) throws Exception;
	
	/**
	 * 根据当前编码ID得到索引号
	 * @param info 类型编号
	 * @return 得到当前最大的编码
	 */
	public String GetInfoIdByRootId(Pgt00001 info)  throws Exception;
	
	/**
	 * 行业
	 */
	public String GetInfoHY () throws Exception;
	
	/**
	 * 经济类型
	 */
	public String GetInfoJJLX() throws Exception;
	
	/**
	 * 行政区域
	 */
	public String GetInfoXZQY() throws Exception;
	
	/**
	 * 取得方式
	 */
	public String GetInfoQDFS() throws Exception;
	
	/**
	 * 免税设置
	 */
	public String GetInfoMSSZ() throws Exception;
	
	/**
	 * 星级标准
	 */
	public String GetInfoXJBZ() throws Exception;
	
	/**
	 * 土地使用权类型
	 */
	public String GetInfoSYQLX() throws Exception;
	
	/**
	 * 土地所有权类型
	 */
	public String GetInfoTDSYQLX() throws Exception;
	
	/**
	 * 建筑结构
	 */
	public String GetInfoJZJG() throws Exception;
	
	/**
	 * 土地用途
	 */
	public String GetInfoTDYT() throws Exception;
	
//	/**
//	 * 土地等级
//	 */
//	public String GetInfoTDDJ() throws Exception;
	
	/**
	 * 房屋朝向
	 */
	public String GetInfoFWCX() throws Exception;
	
	/**
	 * 房屋设施
	 */
	public String GetInfoFWSS() throws Exception;
	
	/**
	 * 所在区域
	 */
	public String GetInfoSzqy() throws Exception;
	
	/**
	 * 性质
	 */
	public String GetInfoXZ() throws Exception;
	
	/**
	 * 房屋用途
	 */
	public String GetInfoFWYT() throws Exception;
	
	/**
	 * 房屋类型(市场)
	 */
	public String GetInfoFWLX_SC() throws Exception;
	
	/**
	 * 采光状况(市场)
	 */
	public String GetInfoCGZK_SC() throws Exception;
	
	/**
	 * 交易类型(市场)
	 */
	public String GetInfoJYLX_SC() throws Exception;
	
	/**
	 * 税收管辖
	 */
	public String GetInfoSSGX() throws Exception;
	
	/**
	 * 证件类型
	 */
	public String GetInfoZJLX() throws Exception;
	
	/**
	 * 交通状况(市场)
	 */
	public String GetInfoJTZK() throws Exception;	
	
	/**
	 * 物业状况(市场)
	 */
	public String GetInfoWYZK() throws Exception;		
	
	/**
	 * 装修状况(市场)
	 */
	public String GetInfoZXZK() throws Exception;	

	/**
	 * 综合修正
	 * @return
	 * @throws Exception
	 */
	public String GetInfoZHXZ() throws Exception;
	
	/**
	 * 读取综合修正列表
	 */
	public ArrayList<Pgv00001> LoadAllZHXZ() throws Exception;
	
	/**
	 * 根据小区名称，税收管辖查找小区代码
	 * @param xqnm
	 * @param cd00002Ssgx
	 * @return
	 * @throws Exception
	 */
	public String GetXQDMByXQNM(String xqnm,String cd00001Ssgx)throws Exception;
	
	/**
	 * 根据ROOTID 获取INFO数据
	 * @param rootId
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgt00001> GetINFOListByROOTID(String rootId, String cd00001Fwlx, String cd00352Szqy, String xqdm)throws Exception;

	public String GetInfoLC() throws Exception;
//
//	public String GetInfoLX() throws Exception;
//
//	public String GetInfoGWHJ() throws Exception;

	public String GetInfoTDDJ() throws Exception;
	/**
	 * 收益法办公楼类型
	 * @return
	 * @throws Exception
	 */
	public String GetInfoBGLLX_SY() throws Exception ;
//	/**
//	 * 根据证件类型
//	 * @param rootId
//	 * @return
//	 * @throws Exception
//	 */
//	public ArrayList<Pgt000011> GetZJLXINFOList(String rootId)throws Exception;
	
	/**
	 * 通过市场、商业、工业得到房屋类型
	 * GetINFOListByFWLX
	 * @author LeiJia
	*/
	public ArrayList<Pgt00001> GetINFOListByFWLX(String type) throws Exception ;
	/**
	 * 得到商业小区房屋类型
	 * GetINFOListBySYXQFWLX
	 * @author LeiJia
	 */
	public ArrayList<Pgt00001> GetINFOListBySYXQFWLX() throws Exception;

}
