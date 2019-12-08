package com.sunway.service;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import com.sunway.vo.ExcelBean;
import com.sunway.vo.Pgt00352;
import com.sunway.vo.Pgv00352;

/**
 * 小区名称维护
 * @author Lee
 * @version 1.0
 */
public interface IPgt00352Service {

	/**
	 * 进行数据提取操作
	 * @param v00352 检索条件
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00352> LoadAll(Pgv00352 v00352) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @param t00352
	 * @return
	 * @throws Exception
	 */
	public Pgt00352 LoadByPrimaryKey(Pgt00352 t00352) throws Exception;

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt00352 t00352) throws Exception;

	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt00352 t00352) throws Exception;

	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt00352 t00352) throws Exception;

	/**
	 * 取得数据列表
	 * @param t00352
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgt00352> LoadNavigator(Pgt00352 t00352) throws Exception;

	/**
	 * 根据导航取得数据列表
	 * @param t00352
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgt00352> LoadTreeList(Pgt00352 t00352) throws Exception;

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
	public ArrayList<Pgv00352> LoadAllByXqzt(Pgv00352 v00352) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommandForXqzt(Pgt00352 t00352) throws Exception;
	
	/**
	 * 根据小区名称进行数据提取操作
	 * @param t00352
	 * @return
	 * @throws Exception
	 */
	public Pgt00352 LoadByXqnm(Pgt00352 t00352) throws Exception;
	
	/**
	 * 取得小区名称（自动完成用）
	 * @param v00303
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv00352> GetXQNM(Pgt00352 t00352) throws Exception;

	/**
	 * 股价分区数据导出
	 * @param v00352
	 * @return
	 * @throws Exception
	 */
	public ByteArrayOutputStream ExportGJFQSjcx(Pgv00352 v00352)throws Exception;
	/**
	 * 判断估价分区小区名称是否重复
	 * @param v00352
	 * @return
	 * @throws Exception
	 */
	public Integer LoadQX(Pgt00352 v00352)throws Exception;
	
}
