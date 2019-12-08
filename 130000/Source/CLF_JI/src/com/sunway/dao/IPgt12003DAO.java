/**
 * 
 */
package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgt12003;
import com.sunway.vo.Pgv12003;

/**
 * 
 * 成本法、收益法房地产信息
 * @author Andy.Gao
 *
 */
public interface IPgt12003DAO {

	/**
	 * 進行數據刪除操作. 
	 */
	public boolean GetDeleteCommand(Pgt12003 t12003) throws Exception;

	/**
	 * 進行數據插入操作. 
	 */
	public boolean GetInsertCommand(Pgt12003 t12003) throws Exception;

	/**
	 * 進行數據更新操作. 
	 */
	public boolean GetUpdateCommand(Pgt12003 t12003) throws Exception;

	/**
	 * 進行數據提取操作. 
	 */
	public Pgv12003 LoadAll(Pgv12003 v12003) throws Exception;

	/**
	 * 按PK進行數據提取. 
	 */
	public Pgt12003 LoadByPrimaryKey(Pgt12003 t12003) throws Exception;
	
	/**
	 * 自動採備房產ID
	 * @return 房產ID
	 * @throws Exception
	 */
	public String LoadMaxFcId() throws Exception;

	/**
	 * 按PK取得详细信息 
	 */
	public Pgv12003 LoadDetail(Pgv12003 v12003) throws Exception;
	
	/**
	 * 判断房產证书号是否已经存在
	 * @param 土地使用权证书号[FCZH], 地产编码[FCID]
	 * @return T.存在; F.不存在
	 * @throws Exception
	 */
	public Boolean GetFczhByFcid(Pgt12003 t12003) throws Exception;
	
	/**
	 * 成本法、收益法房屋座落地址自动提示功能
	 */
	public ArrayList<String> LoadFWZLDZ(Pgv12003 v12003) throws Exception;

	/**
	 * 房产信息查询
	 * @category 数据查询
	 */
	public Pgv12003 LoadPgv120035(Pgv12003 v12003) throws Exception;
}
