package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgt00304;
import com.sunway.vo.Pgt00304a;
import com.sunway.vo.Pgv00304;


/**
 * 挂牌数据(市场)
 * @category 挂牌数据(市场)
 * @author Lee
 * @version 1.0
 */
public interface IPgt00304Service {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt00304 gpsj) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt00304 gpsj) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt00304 gpsj) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00304> LoadAll(Pgv00304 gpsj) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt00304 LoadByPrimaryKey(Pgt00304 gpsj) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgt00304a> LoadAlla(Pgt00304a gpsj) throws Exception;
	
	/**
	 * 从excel中导入挂牌数据
	 * @param gpsjList
	 * @return
	 */
	public Pgv00304 ImportExcelData(ArrayList<Pgv00304> gpsjList) throws Exception;
	
	/**
	 * 通过swid取得详细信息
	 * @param gpsj
	 * @return
	 * @throws Exception
	 */
	public Pgv00304 LoadDetail(Pgv00304 gpsj) throws Exception;
}
