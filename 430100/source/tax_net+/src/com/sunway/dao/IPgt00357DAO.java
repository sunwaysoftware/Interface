package com.sunway.dao;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.vo.Pgt00357;
import com.sunway.vo.Pgv00357;

/**
 * 
 * 市场法实例库
 * @category 系统维护
 * @author Lee
 * @version 1.0
 *
 */
public interface IPgt00357DAO {

	/**
	 * 进行数据提取操作
	 */
	public ArrayList<Pgv00357> LoadAll(Pgv00357 v00357) throws Exception;

	/**
	 * 根据PK进行数据提取操作
	 */
	public Pgt00357 LoadByPrimaryKey(Pgt00357 t00357) throws Exception;

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt00357 t00357) throws Exception;

	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt00357 t00357) throws Exception;

	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt00357 t00357) throws Exception;
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteSelCommand(Pgv00357 v00357) throws Exception;

	/**
	 * 按PK取得详细信息 
	 */
	public Pgv00357 LoadDetail(Pgv00357 v00357) throws Exception;
	
	/**
	 * 从excel中导入可比实例库数据
	 * @param kbslkList
	 * @return
	 */
	public Pgv00357 ImportExcelData(ArrayList<Pgv00357> kbslkList) throws Exception;
	
	/**
	 * 可比实例库数据导出
	 * @param v00357
	 * @return
	 * @throws Exception
	 */
	public OutputStream ExportkbslSjcx(Pgv00357 v00357) throws Exception;
	/**
	 * 读取标准房测算可比实例
	 * @param v00357
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv00357> LoadCSKbsl(Pgv00357 v00357) throws Exception;
	/**
	 * 根据可比实例库生成标准房
	 * @param v00357
	 * @return
	 * @throws Exception
	 */
	public Integer MakeBZF(Pgv00357 v00357)throws Exception;
}
