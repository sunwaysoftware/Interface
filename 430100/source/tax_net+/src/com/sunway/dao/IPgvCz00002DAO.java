package com.sunway.dao;

import java.util.ArrayList;
import com.sunway.vo.PgvCz00002;


/**
 * 审核类型名称
 * @category 审核类型名称
 * @author Lee
 * @version 1.0
 */
public interface IPgvCz00002DAO {

	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<PgvCz00002> LoadAll(PgvCz00002 shlxmc) throws Exception;
	
}
