package com.sunway.dao;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.vo.ExcelBean;
import com.sunway.vo.Pgt00303;
import com.sunway.vo.Pgv00303;


/**
 * 市场法楼房信息表维护
 * @author Lee
 * @version 1.0
 */
public interface IPgt00303DAO {

	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00303> LoadAll(Pgv00303 v00303) throws Exception;

	/**
	 * 根据PK进行数据提取操作
	 * @param t00303
	 * @return
	 * @throws Exception
	 */
	public Pgt00303 LoadByPrimaryKey(Pgt00303 t00303) throws Exception;

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt00303 t00303) throws Exception;

	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt00303 t00303) throws Exception;

	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt00303 t00303) throws Exception;

	/**
	 * 自动採集楼房Id
	 * @return 楼房Id
	 * @throws Exception
	 */
	public String LoadMaxLfId() throws Exception;

	/**
	 * 取得座落地址（自动完成用）
	 * @param v00303
	 * @return
	 * @throws Exception
	 */
	public ArrayList<String> GetFwtdzl(Pgv00303 v00303) throws Exception;

	/**
	 * 取得楼房信息List
	 * @param hbLfidList
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv00303> GetHbInitList(String hbLfidList) throws Exception;

	/**
	 * 合并操作
	 * @return  True成功；False失败
	 * @throws Exception
	 */
	public boolean GetHBCommand(Pgt00303 t00303) throws Exception;

	/**
	 * 根据地址查询LFID
	 * @param t00303
	 * @return
	 * @throws Exception
	 */
	public Pgv00303 GetLFID(Pgv00303 v00303) throws Exception;
	
	/**
	 * 根据别名查询房屋地址
	 * @param v00303
	 * @return
	 * @throws Exception
	 */
	public Pgv00303 GetFWDZ(Pgv00303 v00303) throws Exception;
	
	/**
	 * 从excel中导入楼房普查数据
	 * @param lfpcList
	 * @return
	 */
	public ExcelBean ImportExcelData(ArrayList<ExcelBean> ebList) throws Exception;
	/**
	 * 估计分区信息导出
	 * @param v00352
	 * @return
	 * @throws Exception
	 */
	public OutputStream ExportlfpcSjcx(Pgv00303 v00303) throws Exception;
	/**
	 * 通过楼号+地址+所在区域查询全面评估数据
	 * @param v00303
	 * @return
	 * @throws Exception
	 */
	public ArrayList<String> GetLhdz(Pgv00303 v00303) throws Exception;
	/**
	 * 通过单元号+楼号+地址+所在区域查询全面评估数据
	 * @param v00303
	 * @return
	 * @throws Exception
	 */
	public ArrayList<String> GetDyhdz(Pgv00303 v00303) throws Exception;
	/**
	 * 通过房号+单元号+楼号+地址+所在区域查询全面评估数据
	 * @param v00303
	 * @return
	 * @throws Exception
	 */
	public ArrayList<String> GetFhdz(Pgv00303 v00303) throws Exception;
	
	
}
