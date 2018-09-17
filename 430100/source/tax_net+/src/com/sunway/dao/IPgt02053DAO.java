package com.sunway.dao;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Map;

import com.sunway.vo.Pgt02053;
import com.sunway.vo.Pgv02053;


/**
 * @category 商业综合修正赋值
 * @author Lee
 * @version 1.0
 */
public interface IPgt02053DAO {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt02053 cgxz) throws Exception;
	
	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommandA(Pgt02053 cgxz) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt02053 cgxz) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommandA(Pgt02053 cgxz) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt02053 cgxz) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommandA(Pgt02053 cgxz) throws Exception;
	
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv02053> LoadAll(Pgv02053 cgxz) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv02053> LoadAllA(Pgv02053 cgxz) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt02053 LoadByPrimaryKey(Pgt02053 cgxz) throws Exception;
	
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt02053 LoadByPrimaryKeyA(Pgt02053 cgxz) throws Exception;
	
	/**
	 * 进行参数复制操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean ExecuteParamCopy(Pgt02053 cgxz) throws Exception;
	
	/**
	 * 读取“操作对象”
	 * @return
	 * @throws Exception
	 */
	public Map<String, String> LoadObj(Pgt02053 cgzk) throws Exception;
	
	/**
	 * 信息导出
	 */
	public OutputStream ExportT053(Pgv02053 v02053) throws Exception;
	
	/**
	 * 信息导出
	 */
	public OutputStream ExportT053A(Pgv02053 v02053) throws Exception;
	
	/**
	 * 文件导入
	 */
	public Pgv02053 ImportExcelData(ArrayList<Pgv02053> v02053List)throws Exception;
	
	/**
	 * 文件导入
	 */
	public Pgv02053 ImportExcelDataA(ArrayList<Pgv02053> v02053List)throws Exception;
	/**
	 * 进行选择数据删除操作
	 * @param wjzs
	 * @return
	 * @throws Exception
	 */
	public boolean GetSelDeleteCommand(Pgt02053 wjzs) throws Exception;
	
	/**
	 * 进行选择数据删除操作
	 * @param wjzs
	 * @return
	 * @throws Exception
	 */
	public boolean GetSelDeleteCommandA(Pgt02053 wjzs) throws Exception;
	
	/**
	 * 商业：所在区域读取父类型
	 * @param szqy
	 * @param fwlx
	 * @param xqdm
	 * @return
	 * @throws Exception
	 */
	public String LoadParentIdsBySzqy(String szqy,String fwlx,String xqdm) throws Exception;
}
