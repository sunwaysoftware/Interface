/**
 * 
 */
package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgt12006;

/**
 * 
 * 登记人或承租人信息表(可以给登记提供自动提示功能)
 * @category 数据采集
 * @author Andy.Gao
 * @version 1.0
 *
 */
public interface IPgt12006Service {

	/**
	 * 根據用戶/承租人ID獲得對應的名稱
	 * @param id 用戶/承租人ID
	 * @return 對應的名稱
	 * @throws Exception
	 */
	public String LoadNmById(String id) throws Exception;
	
	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt12006 auto) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt12006 auto) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt12006 auto) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgt12006> LoadAll(Pgt12006 auto) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt12006 LoadByPrimaryKey(Pgt12006 auto) throws Exception;
	

	/**
	 * 从excel中导入征管数据
	 * @param zgsjList
	 * @return
	 */
	public Boolean ImportExcelData(Pgt12006 bean) throws Exception;
	
	
}
