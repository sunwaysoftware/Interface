package com.sunway.service;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import com.sunway.vo.Pgt00356;
import com.sunway.vo.Pgv00356;


/**
 * 市场法物价指数修正系数
 * @category 物价指数修正
 * @author Lee
 * @version 1.0
 */
public interface IPgt00356Service {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt00356 wjzs) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt00356 wjzs) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt00356 wjzs) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00356> LoadAll(Pgv00356 wjzs) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt00356 LoadByPrimaryKey(Pgt00356 wjzs) throws Exception;
	
	/**
	 * 进行参数复制操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean ExecuteParamCopy(Pgt00356 wjzs) throws Exception;
	/**
	 * 从excel中导入交易价格指数修正数据
	 * @param jyjgzsList
	 * @return
	 */
	public Pgv00356 ImportExcelData(ArrayList<Pgv00356> jyjgzsList) throws Exception;
	/**
	 * 楼房系数数据导出
	 * @param v00356
	 * @return
	 * @throws Exception
	 */
	public ByteArrayOutputStream ExportjyjgSjcx(Pgv00356 v00356)throws Exception;
}
