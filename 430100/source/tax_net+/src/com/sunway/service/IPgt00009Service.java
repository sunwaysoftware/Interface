package com.sunway.service;

import java.util.ArrayList;
import com.sunway.vo.Pgt00009;
import com.sunway.vo.Pgv00009;


/**
 * 用户所在税收管辖区域
 * @author Lee
 */
public interface IPgt00009Service {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt00009 ssgx) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt00009 ssgx) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt00009 ssgx) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00009> LoadAll(Pgv00009 ssgx) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt00009 LoadByPrimaryKey(Pgt00009 ssgx) throws Exception;
	
	
	/**
	 * 根据ID获得税收全部管辖列表（包括该用户所在组的税收管辖）
	 * @param userID
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv00009> LoadAllSSGX(String userID) throws Exception;

	/**
	 * 设置该用户登陆的默认税收管线
	 * @param t00009
	 * @return
	 * @throws Exception
	 */
	public boolean GetUpdDef(Pgt00009 t00009) throws Exception;
}
