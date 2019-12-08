package com.sunway.dao;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.vo.Pgt00323;
import com.sunway.vo.Pgv00323;







/**
 * 市场法楼层系数修正表
 * @category 市场法楼层系数
 * @author Lee
 * @version 1.0
 */
public interface IPgt00323DAO {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt00323 lcxs) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt00323 lcxs) throws Exception;
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteSelCommand(Pgv00323 lcxs) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt00323 lcxs) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00323> LoadAll(Pgv00323 lcxs) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt00323 LoadByPrimaryKey(Pgt00323 lcxs) throws Exception;
	
	/**
	 * 进行参数复制操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean ExecuteParamCopy(Pgt00323 lcxs) throws Exception;

	/**
	 * 数据导出
	 * @param v00355
	 * @return
	 * @throws Exception
	 */
	public OutputStream ExportLXCZSjcx(Pgv00323 v00322) throws Exception;
	/**
	 * 数据导入
	 * @param ebList
	 * @return
	 * @throws Exception
	 */
	public Pgv00323 ImportExcelData(ArrayList<Pgv00323> ebList) throws Exception;
}
