package com.sunway.dao;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.vo.ExcelBean;
import com.sunway.vo.Pgt00351;
import com.sunway.vo.Pgt00352;
import com.sunway.vo.Pgv00351;

/**
 * 
 * 市场法标准实例库
 * @category 系统维护
 * @author Lee
 * @version 1.0
 *
 */
public interface IPgt00351DAO {

	/**
	 * 进行数据提取操作
	 */
	public ArrayList<Pgv00351> LoadAll(Pgv00351 v00351) throws Exception;

	/**
	 * 根据PK进行数据提取操作
	 */
	public Pgt00351 LoadByPrimaryKey(Pgt00351 t00351) throws Exception;

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt00351 t00351) throws Exception;

	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt00351 t00351) throws Exception;

	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt00351 t00351) throws Exception;
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteSelCommand(Pgv00351 v00351) throws Exception;
	
	/**
	 * 按PK取得详细信息 
	 */
	public Pgv00351 LoadDetail(Pgv00351 v00351) throws Exception;
	
	/**
	 * 同区测算数据查询
	 * @param v00351
	 * @return 标准房列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00351> LoadAllCsSame(Pgv00351 v00351) throws Exception;

	/**
	 * 同区测算
	 * @param v00351
	 * @return T.成功, F.失败
	 * @throws Exception
	 */
	public Boolean ExecCsSame(Pgv00351 v00351) throws Exception;
	
	/**
	 * 同区测算数据查询
	 * @param v00351
	 * @return 标准房ID列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00351> LoadAllCsSameByBzfID(Pgv00351 v00351) throws Exception;
	
	/**
	 * 异区测算数据查询(无价格)
	 * @param v00351
	 * @return 标准房列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00351> LoadAllCsDiffW(Pgv00351 v00351) throws Exception;
	
	/**
	 * 异区测算数据查询(有价格)
	 * @param v00351
	 * @return 标准房列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00351> LoadAllCsDiffY(Pgv00351 v00351) throws Exception;
	
	/**
	 * 生成标准房
	 * @return Ingeter 生成个数
	 * @throws Exception
	 */
	public Integer CreateBZF(Pgt00351 t00351) throws Exception;

	/**
	 * 生成标准房
	 * @return Ingeter 生成个数
	 * @throws Exception
	 */
	public Integer ImportBZF(Pgt00351 t00351) throws Exception;
	
	/**
	 * 读取【无价格】小区列表
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgt00352> LoadXqW(Pgt00351 bean) throws Exception;
	
	/**
	 * 读取【有价格】小区列表
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgt00352> LoadXqY(Pgt00351 bean) throws Exception;
	
	/**
	 * 从excel中导入评估分区
	 * @param pgfqList
	 * @return
	 */
	public ExcelBean ImportExcelData(ArrayList<ExcelBean> ebList) throws Exception;
	/**
	 * 标准房维护数据导出
	 * @param v00357
	 * @return
	 * @throws Exception
	 */
	public OutputStream ExportbzfwhSjcx(Pgv00351 v00351) throws Exception;
	
	/**
	 * 查询可测算标准房
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00351> findY(Pgv00351 v00351)throws Exception;
	/**
	 * 查询不可测算标准房
	 * @return  数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00351> findN(Pgv00351 v00351)throws Exception;
	/**
	 * 信息导出可测算标准房
	 */
	public OutputStream ExportCSY(Pgv00351 v00351) throws Exception; 
	
	/**
	 * 信息导出不可测算标准房
	 */
	public OutputStream ExportCSN(Pgv00351 v00351) throws Exception;
	/**
	 * 執行評估操作
	 * @param bean 納稅人編碼[SWID], 評估操作人[PGCZR], 評稅時點[PSSD]
	 * @return T.成功; F.失敗
	 * @throws Exception
	 */
	public Boolean GetExecCS(Pgv00351 v00351) throws Exception;
}
