package com.sunway.service;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import com.sunway.vo.Pgt00322;
import com.sunway.vo.Pgv00322;





/**
 * 市场法楼层系数修正表
 * @category 市场法楼层系数
 * @author Lee
 * @version 1.0
 */
public interface IPgt00322Service {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt00322 lcxs) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt00322 lcxs) throws Exception;
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteSelCommand(Pgv00322 lcxs) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt00322 lcxs) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00322> LoadAll(Pgv00322 lcxs) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt00322 LoadByPrimaryKey(Pgt00322 lcxs) throws Exception;
	
	/**
	 * 进行参数复制操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean ExecuteParamCopy(Pgt00322 lcxs) throws Exception;

	/**
	 * 数据导出
	 * @param v00355
	 * @return
	 * @throws Exception
	 */
	public ByteArrayOutputStream ExportLCXZSjcx(Pgv00322 v00321) throws Exception;
	/**
	 * 数据导入
	 * @param ebList
	 * @return
	 * @throws Exception
	 */
	public Pgv00322 ImportExcelData(ArrayList<Pgv00322> ebList)throws Exception;
}
