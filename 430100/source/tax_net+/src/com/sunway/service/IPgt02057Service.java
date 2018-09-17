package com.sunway.service;

import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import com.sunway.vo.Pgt02057;
import com.sunway.vo.Pgv02057;


/**
 * 收益法资本化率维护
 * @category 收益法资本化率
 * @author Lee
 * @version 1.0
 */
public interface IPgt02057Service {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt02057 zbhl) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt02057 zbhl) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt02057 zbhl) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv02057> LoadAll(Pgv02057 zbhl) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt02057 LoadByPrimaryKey(Pgt02057 zbhl) throws Exception;
	
	/**
	 * 进行参数复制操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean ExecuteParamCopy(Pgt02057 zbhl) throws Exception;
	/**
	 * 从excel中导入收益法资本化率维护数据
	 * @param syzbhsjList
	 * @return
	 */
	public Pgv02057 ImportExcelData(ArrayList<Pgv02057> v02057List) throws Exception;
	/**
	 * 资本化率信息导出操作.
	 */
	public OutputStream ExportZBHLxtwh(Pgv02057 v02057) throws Exception;
	/**
	 * 导入时删除重复数据
	 * @param eBean
	 * @return
	 * @throws Exception
	 */


	public ArrayList<Pgv02057> LoadAllA(Pgv02057 v02057)throws Exception;

	public Pgt02057 LoadByPrimaryKeyA(Pgt02057 t02057)throws Exception;

	public boolean GetInsertCommandA(Pgt02057 t02057Bean)throws Exception;

	public boolean GetUpdateCommandA(Pgt02057 t02057Bean)throws Exception;

	public boolean GetDeleteCommandA(Pgt02057 t02057Bean)throws Exception;

	public Pgv02057 ImportExcelDataA(ArrayList<Pgv02057> v02057List) throws Exception ;

	public boolean GetSelDeleteCommand(Pgt02057 t02057)throws Exception;

	public boolean GetSelDeleteCommandA(Pgt02057 t02057)throws Exception;

	public ByteArrayOutputStream ExportJYSJ(Pgv02057 v02057)throws Exception;

	public ByteArrayOutputStream ExportJYSJA(Pgv02057 v02057)throws Exception;
}
