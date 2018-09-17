package com.sunway.service;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.vo.ExcelBean;
import com.sunway.vo.Pgt02050;
import com.sunway.vo.Pgv02050;

/**
 * 商业分区名称维护
 * @author LeiJia
 * @version 1.0
 */
public interface IPgt02050Service {

	/**
	 * 进行数据提取操作
	 * @param v02050 检索条件
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv02050> LoadAll(Pgv02050 v02050) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @param t02050
	 * @return
	 * @throws Exception
	 */
	public Pgt02050 LoadByPrimaryKey(Pgt02050 t02050) throws Exception;

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt02050 t02050) throws Exception;

	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt02050 t02050) throws Exception;
	
	/**
	 * 进行选择数据删除操作
	 * @param t02050
	 * @return
	 * @throws Exception
	 */
	public boolean GetSelDeleteCommand(Pgt02050 t02050) throws Exception;

	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt02050 t02050) throws Exception;

	/**
	 * 取得数据列表
	 * @param t02050
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgt02050> LoadNavigator(Pgt02050 t02050) throws Exception;

	/**
	 * 根据导航取得数据列表
	 * @param t02050
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgt02050> LoadTreeList(Pgt02050 t02050) throws Exception;

	/**
	 * 取得小区名称
	 * @param xqdm 小区代码
	 * @return
	 * @throws Exception
	 */
	public String LoadNavStream(String xqdm) throws Exception;
	
	/**
	 * 从excel中导入评估分区
	 * @param pgfqList
	 * @return
	 */
	public ExcelBean ImportExcelData(ArrayList<ExcelBean> ebList) throws Exception;
	
	/**
	 * 根据状态读取小区列表
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv02050> LoadAllByXqzt(Pgv02050 v02050) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommandForXqzt(Pgt02050 t02050) throws Exception;
	
	/**
	 * 根据小区名称进行数据提取操作
	 * @param t02050
	 * @return
	 * @throws Exception
	 */
	public Pgt02050 LoadByXqnm(Pgt02050 t02050) throws Exception;
	
	/**
	 * 取得小区名称（自动完成用）
	 * @param v00303
	 * @return
	 * @throws Exception
	 */
	public ArrayList<String> GetXQNM(Pgt02050 t02050) throws Exception;
	
	/**
	 * 小区信息导出
	 */
	public OutputStream ExportGJFQ(Pgv02050 v02050) throws Exception;
	
	/**
	 * 片区信息导出
	 */
	public OutputStream ExportGJFQDQ(Pgv02050 v02050)throws Exception;
	
	/**
	 * 估价分区（小区）查询
	 */
	public ArrayList<Pgv02050> loadAllGJFQXQ(Pgv02050 v02050)throws Exception;
	
	/**
	 * 估价分区（大区）查询
	 */
	public ArrayList<Pgv02050> loadAllGJFQDQ(Pgv02050 v02050)throws Exception;
	
	
	/**
	 * 验证该类标准房是否可以评估
	 */
	public boolean ValidatePG(Pgv02050 v02050)throws Exception;
	
	/**
	 * 验证小区代码号是否存在
	 * @param v02050
	 * @return
	 * @throws Exception
	 */
	public boolean validateXqdmhmIsExist(Pgv02050 v02050)throws Exception;
	
	/**
	 * 数据导入：四至描述信息
	 * @param v02050List
	 * @return
	 * @throws Exception
	 */
	public Pgv02050 ImportDataSZMS(ArrayList<Pgv02050> v02050List)throws Exception;
	
}
