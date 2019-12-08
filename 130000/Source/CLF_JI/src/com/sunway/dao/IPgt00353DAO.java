package com.sunway.dao;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Map;

import com.sunway.vo.Pgt00353;
import com.sunway.vo.Pgv00353;

/**
 * 市场法采光修正系数
 * @category 市场法采光修正系数
 * @author Lee
 * @version 1.0
 */
public interface IPgt00353DAO {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt00353 cgxz) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt00353 cgxz) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt00353 cgxz) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00353> LoadAll(Pgv00353 cgxz) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt00353 LoadByPrimaryKey(Pgt00353 cgxz) throws Exception;
	
	/**
	 * 进行参数复制操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean ExecuteParamCopy(Pgt00353 cgxz) throws Exception;
	
	/**
	 * 读取“操作对象”
	 * @return
	 * @throws Exception
	 */
	public Map<String, String> LoadObj(Pgt00353 cgzk) throws Exception;
	
	/**
	 * 数据导出
	 * @param v00353
	 * @return
	 * @throws Exception
	 */
	public OutputStream ExportZHXZSjcx(Pgv00353 v00353) throws Exception;
	
	/**
	 * 数据导入
	 * @param ebList
	 * @return
	 * @throws Exception
	 */
	public Pgv00353 ImportExcelData(ArrayList<Pgv00353> ebList) throws Exception;
	
}
