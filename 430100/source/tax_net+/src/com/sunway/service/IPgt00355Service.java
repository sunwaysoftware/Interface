package com.sunway.service;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import com.sunway.vo.Pgt00355;
import com.sunway.vo.Pgv00355;


/**
 * 市场法楼层系数修正表
 * @category 市场法楼层系数
 * @author Lee
 * @version 1.0
 */
public interface IPgt00355Service {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt00355 lcxs) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt00355 lcxs) throws Exception;
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteSelCommand(Pgv00355 lcxs) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt00355 lcxs) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00355> LoadAll(Pgv00355 lcxs) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt00355 LoadByPrimaryKey(Pgt00355 lcxs) throws Exception;
	
	/**
	 * 进行参数复制操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean ExecuteParamCopy(Pgt00355 lcxs) throws Exception;

	/**
	 * 数据导出
	 * @param v00355
	 * @return
	 * @throws Exception
	 */
	public ByteArrayOutputStream ExportLCXZSjcx(Pgv00355 v00355) throws Exception;
	/**
	 * 数据导入
	 * @param ebList
	 * @return
	 * @throws Exception
	 */
	public Pgv00355 ImportExcelData(ArrayList<Pgv00355> ebList)throws Exception;
}
