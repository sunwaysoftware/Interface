package com.sunway.dao;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.vo.BF00000;
import com.sunway.vo.Pgt00302;
import com.sunway.vo.Pgt00352xml;
import com.sunway.vo.Pgv00302;
import com.sunway.vo.Pgv00357;

/**
 * 
 * 市场法房地产信息
 * @category 数据采集
 * @author Lee
 * @version 1.0
 *
 */
public interface IPgt00302DAO {

	/**
	 * 进行数据提取操作
	 */
	public Pgv00302 LoadAll(Pgv00302 v00302) throws Exception;

	/**
	 * 根据PK进行数据提取操作
	 */
	public Pgt00302 LoadByPrimaryKey(Pgt00302 t00302) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 */
	public Pgt00302 LoadByPrimaryKey_B(Pgt00302 t00302) throws Exception;

	/**
	 * 自动採集房产ID
	 */
	public String LoadMaxFcId(String t00302) throws Exception;

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt00302 t00302) throws Exception;

	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt00302 t00302) throws Exception;

	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt00302 t00302) throws Exception;

	/**
	 * 按PK取得详细信息 
	 */
	public Pgv00302 LoadDetail(Pgv00302 v00302) throws Exception;
	
	/**
	 * 按PK取得详细信息 
	 */
	public Pgv00302 LoadDetail_B(Pgv00302 v00302) throws Exception;

	/**
	 * 判断房地产档案图是否已经存在
	 * @param 房地产档案图[FDCDAT], 房产编码[FCID]
	 * @return T.存在; F.不存在
	 * @throws Exception
	 */
	public Boolean GetFdcdatByFcid(Pgt00302 t00302) throws Exception;

	/**
	 * 住宅房产信息查询
	 * @category 数据查询
	 */
	public Pgv00302 LoadPgv003025(Pgv00302 v00302) throws Exception;
	
	/**
	 * 住宅房产信息查询
	 * @category 数据查询
	 */
	public Pgv00302 LoadPgv003025_B(Pgv00302 v00302) throws Exception;
	
	/**
	 * 进行数据增加操作(WS)
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommandWs(Pgt00302 t00302) throws Exception;
	
	/**
	 * 根据FCZH进行数据提取操作
	 * @param t00302
	 * @return
	 * @throws Exception
	 */
	public Pgv00302 LoadByFczh(Pgt00302 t00302) throws Exception;
	
	/**
	 * 信息导出操作.
	 */
	public OutputStream ExportCXSjcx(Pgv00302 v00302) throws Exception;
	
	/**
	 * 信息导出操作.
	 */
	public OutputStream ExportCXSjcx_B(Pgv00302 v00302) throws Exception;
	
	/**
	 * 从excel中导入可比实例库数据
	 * @param kbslkList
	 * @return
	 */
	public Pgv00357 ImportExcelData(ArrayList<Pgv00357> kbslkList) throws Exception;

	/**
	 * 插入webservice数据
	 * @param xmlList
	 * @throws Exception
	 */
	public boolean GetInsertCommandXML(ArrayList<Pgt00352xml> xmlList) throws Exception;
	/**
	 * 更新wevservice数据
	 * @param pgt00352xml
	 * @throws Exception
	 */
	public boolean GetUpdateCommandXML(Pgt00352xml pgt00352xml)throws Exception;
	/**
	 * 查询webservice数据
	 * @param pgt00352xml
	 * @throws Exception
	 */
	public Pgt00352xml LoadByPrimaryKeyXML(Pgt00352xml pgt00352xml) throws Exception;

	/**
	 * 查询webservice数据
	 * @param t00352xml
	 * @return
	 * @throws Exception
	 */
	public Pgt00352xml LoadAllXML(Pgt00352xml t00352xml) throws Exception;
	/**
	 * 删除webservice数据
	 * @param pgt00352xml
	 * @return
	 * @throws Exception
	 */
	public boolean GetDeleteCommandXML(Pgt00352xml pgt00352xml) throws Exception;
	/**
	 * 判断webservice是否存在
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public Integer JCXML(Pgt00352xml bean) throws Exception;
	/**
	 * 更新371信息
	 * @param pgt00352xml
	 * @return
	 * @throws Exception
	 */
	public boolean GetUpdateCommand371(Pgt00352xml pgt00352xml)throws Exception;
	
	/**
	 * 取得发送XMLI数据
	 * @param pgt00352xml
	 * @return
	 * @throws Exception
	 */
	public Pgv00302 GetXMLI(Pgv00302 v00302)throws Exception;
	/**
	 * 传入大集中评估结果xml
	 * @param bf00000
	 * @ return
	 * @ thr0ws Exception
	 */
    public BF00000 GetDJZPsjgXML(BF00000 bf00000)throws Exception;    

    public Boolean execFS(Pgt00302 bean) throws Exception;
    
    /**
     * 将371数据备份至3711
     * @param pgt00352xml
     * @return
     * @throws Exception
     */
    public Boolean GetInsertCommand3711(Pgt00352xml pgt00352xml)throws Exception;
    
    /**
     * 查询确认表
     */
    public Pgt00352xml LoadAll3711(Pgt00352xml t00352xml) throws Exception;
    
    /**
     * 根据PK确认表获取数据
     */
    public Pgt00352xml LoadByPrimaryKey3711(Pgt00352xml t00352xml)throws Exception;
    
    /**
     * 根据PK删除确认表数据
     */
    public boolean GetDeleteCommand3711(Pgt00352xml t00352xml)throws Exception;
    
    /**
     * 根据受理号在过滤表中获取数据 
     * @param v00372
     * @return
     * @throws Exception
     */
    public ArrayList<Pgt00352xml> LoadByFCSLH372(Pgt00352xml t00352xml)throws Exception;
}
