package com.sunway.service;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import com.sunway.vo.Pgt02056;
import com.sunway.vo.Pgv02056;


/**
 * 市场法物价指数修正系数
 * @category 物价指数修正
 * @author Lee
 * @version 1.0
 */
public interface IPgt02056Service {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt02056 wjzs) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt02056 wjzs) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt02056 wjzs) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv02056> LoadAll(Pgv02056 wjzs) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt02056 LoadByPrimaryKey(Pgt02056 wjzs) throws Exception;
	
	/**
	 * 进行参数复制操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean ExecuteParamCopy(Pgt02056 wjzs) throws Exception;
	/**
	 * 从excel中导入交易价格指数修正数据
	 * @param jyjgzsList
	 * @return
	 */
	public Pgv02056 ImportExcelData(ArrayList<Pgv02056> jyjgzsList) throws Exception;
	/**
	 * 楼房系数数据导出
	 * @param v02056
	 * @return
	 * @throws Exception
	 */
	public ByteArrayOutputStream ExportjyjgSjcx(Pgv02056 v02056)throws Exception;
}
