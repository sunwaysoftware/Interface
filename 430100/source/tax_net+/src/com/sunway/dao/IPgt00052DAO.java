package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgt00052;
import com.sunway.vo.Pgv00052;

/**
 * 税收管辖与所在区域对应关系
 * @author Lee
 * @version 1.0
 *
 */
public interface IPgt00052DAO {

	/**
	 * 根据税收管辖取得所在区域对应关系列表
	 * @param v00052 税收管辖
	 * @return 对应所在区域列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00052> LoadAll(Pgv00052 v00052) throws Exception;

	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt00052 t00052) throws Exception;
	
	/**
	 * 登陆时根据ssgx读取全部所在区域
	 * @param ssgx
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv00052> LoadSzqyBySsgx(String ssgx) throws Exception;
}
