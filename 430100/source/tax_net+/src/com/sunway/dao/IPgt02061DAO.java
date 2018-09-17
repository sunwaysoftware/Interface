package com.sunway.dao;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.vo.ExcelBean;
import com.sunway.vo.Pgt02061;
import com.sunway.vo.Pgt02050;
import com.sunway.vo.Pgv02061;

/**
 * 
 * 市场法标准实例库
 * @category 系统维护
 * @author Lee
 * @version 1.0
 *
 */
public interface IPgt02061DAO {

	/**
	 * 进行数据提取操作
	 */
	public ArrayList<Pgv02061> LoadAll(Pgv02061 v02061) throws Exception;

	/**
	 * 根据PK进行数据提取操作
	 */
	public Pgt02061 LoadByPrimaryKey(Pgt02061 t02061) throws Exception;

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt02061 t02061) throws Exception;

	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt02061 t02061) throws Exception;

	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt02061 t02061) throws Exception;
	
	/**
	 * 进行选择删除操作
	 * @param t02061
	 * @return
	 * @throws Exception
	 */
	public boolean GetSelDeleteCommand(Pgt02061 t02061) throws Exception;

	/**
	 * 按PK取得详细信息 
	 */
	public Pgv02061 LoadDetail(Pgv02061 v02061) throws Exception;
	
	/**
	 * 同区测算数据查询
	 * @param v02061
	 * @return 标准房列表
	 * @throws Exception
	 */
	public ArrayList<Pgv02061> LoadAllCsSame(Pgv02061 v02061) throws Exception;

	/**
	 * 同区测算
	 * @param v02061
	 * @return T.成功, F.失败
	 * @throws Exception
	 */
	public Boolean ExecCsSame(Pgv02061 v02061) throws Exception;
	
	/**
	 * 同区测算数据查询
	 * @param v02061
	 * @return 标准房ID列表
	 * @throws Exception
	 */
	public ArrayList<Pgv02061> LoadAllCsSameByBzfID(Pgv02061 v02061) throws Exception;
	
	/**
	 * 异区测算数据查询(无价格)
	 * @param v02061
	 * @return 标准房列表
	 * @throws Exception
	 */
	public ArrayList<Pgv02061> LoadAllCsDiffW(Pgv02061 v02061) throws Exception;
	
	/**
	 * 异区测算数据查询(有价格)
	 * @param v02061
	 * @return 标准房列表
	 * @throws Exception
	 */
	public ArrayList<Pgv02061> LoadAllCsDiffY(Pgv02061 v02061) throws Exception;
	
	/**
	 * 生成标准房
	 * @return Ingeter 生成个数
	 * @throws Exception
	 */
	public Integer CreateBZF(Pgt02061 t02061) throws Exception;

	/**
	 * 生成标准房
	 * @return Ingeter 生成个数
	 * @throws Exception
	 */
	public Integer ImportBZF(Pgt02061 t02061) throws Exception;
	
	/**
	 * 读取【无价格】小区列表
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgt02050> LoadXqW(Pgt02061 bean) throws Exception;
	
	/**
	 * 读取【有价格】小区列表
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgt02050> LoadXqY(Pgt02061 bean) throws Exception;
	
	/**
	 * 从excel中导入评估分区
	 * @param pgfqList
	 * @return
	 */
	public ExcelBean ImportExcelData(ArrayList<ExcelBean> ebList) throws Exception;
	
	/**
	 * 進行标准房信息导出操作. 
	 */
	public OutputStream ExportDjxx(Pgv02061 v02061) throws Exception;
	
	/**
	 * 进行大区标准房价格更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateDQBZFCommand(Pgt02061 t02061) throws Exception;
	/**
	 * 執行評估操作
	 * @param bean 納稅人編碼[SWID], 評估操作人[PGCZR], 評稅時點[PSSD]
	 * @return T.成功; F.失敗
	 * @throws Exception
	 */
	public Boolean GetExecCS(Pgv02061 v02061) throws Exception;
	/**
	 * 查询可测算标准房
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv02061> findY(Pgv02061 v02061)throws Exception;
	/**
	 * 查询不可测算标准房
	 * @return  数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv02061> findN(Pgv02061 v02061)throws Exception;
	
	/**
	 * 进行数据提取操作
	 */
	public ArrayList<Pgv02061> LoadAllFwlx(Pgv02061 v02061) throws Exception;
	
	/**
	 * 查询小区标准房
	 */
	public ArrayList<Pgv02061> LoadAllByBZFGLXQ(Pgv02061 v02061)throws Exception;
	
	/**
	 * 查询大区标准房
	 */
	public ArrayList<Pgv02061> LoadAllByBZFGLDQ(Pgv02061 v02061)throws Exception;
	
	/**
	 * 信息导出可测算标准房
	 */
	public OutputStream ExportCSY(Pgv02061 v02061) throws Exception; 
	
	/**
	 * 信息导出不可测算标准房
	 */
	public OutputStream ExportCSN(Pgv02061 v02061) throws Exception;
	
	/**
	 * 大区标准房测算
	 *
	 */
	public boolean ExecuteDQCS(Pgv02061 v02061)throws Exception;
	
	/**
	 * 验证该类标准房是否存在
	 */
	public boolean ValiBZF(Pgv02061 v02061)throws Exception;
	
	/**
	 * 删除筛选出的所有数据
	 * @param v02061
	 * @return
	 * @throws Exception
	 */
	public boolean GetDeleteAllCommand(Pgv02061 v02061)throws Exception;

	public ArrayList<Pgv02061> findYbyID(Pgv02061 v02061) throws Exception;
}
