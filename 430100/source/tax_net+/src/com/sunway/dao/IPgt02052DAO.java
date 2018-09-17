package com.sunway.dao;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.vo.Pgt02052;
import com.sunway.vo.Pgv02052;


/**
 * 商业建筑层次修正表
 * @category 商业建筑层次修正
 * @author Lee
 * @version 1.0
 */
public interface IPgt02052DAO {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt02052 lcxs) throws Exception;
	
	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommandA(Pgt02052 lcxs) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt02052 lcxs) throws Exception;
	
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommandA(Pgt02052 lcxs) throws Exception;
	
	/**
	 * 进行选择数据删除操作
	 * @param lcxs
	 * @return
	 * @throws Exception
	 */
	public boolean GetSelDeleteCommand(Pgt02052 lcxs) throws Exception;
	
	
	/**
	 * 进行选择数据删除操作
	 * @param lcxs
	 * @return
	 * @throws Exception
	 */
	public boolean GetSelDeleteCommandA(Pgt02052 lcxs) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt02052 lcxs) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommandA(Pgt02052 lcxs) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv02052> LoadAll(Pgv02052 lcxs) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv02052> LoadAllA(Pgv02052 lcxs) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt02052 LoadByPrimaryKey(Pgt02052 lcxs) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt02052 LoadByPrimaryAddKey(Pgt02052 lcxs) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt02052 LoadByPrimaryKeyA(Pgt02052 lcxs) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt02052 LoadByPrimaryAddKeyA(Pgt02052 lcxs) throws Exception;
	
	/**
	 * 进行参数复制操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean ExecuteParamCopy(Pgt02052 lcxs) throws Exception;
	
	/**
	 * 信息导出
	 */
	public OutputStream ExportT052(Pgv02052 v02052) throws Exception;
	
	/**
	 * 信息导出
	 */
	public OutputStream ExportT052A(Pgv02052 v02052) throws Exception;
	
	/**
	 * 信息导入
	 */
	public Pgv02052 ImportExcelData(ArrayList<Pgv02052> v02052List)throws Exception;
	
	/**
	 *新 信息导入
	 */
	public Pgv02052 ImportExcelDataA(ArrayList<Pgv02052> v02052List)throws Exception;
}
