package com.sunway.dao;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.vo.BF00000;
import com.sunway.vo.Pgt02002;
import com.sunway.vo.Pgt02052xml;
import com.sunway.vo.Pgv02002;

/**
 * 
 * 市场法房地产信息
 * @category 数据采集
 * @author Lee
 * @version 1.0
 *
 */
public interface IPgt02002DAO {

	/**
	 * 进行数据提取操作
	 */
	public Pgv02002 LoadAll(Pgv02002 v02002) throws Exception;
	
	public ArrayList<Pgv02002> LoadAllE(Pgv02002 v02002) throws Exception;
	
	public ArrayList<Pgv02002> LoadAllE_B(Pgv02002 v02002) throws Exception;

	/**
	 * 根据PK进行数据提取操作
	 */
	public Pgt02002 LoadByPrimaryKey(Pgt02002 t02002) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 */
	public Pgt02002 LoadByPrimaryKey_B(Pgt02002 t02002) throws Exception;

	/**
	 * 自动採集国土ID
	 */
	public String LoadMaxFcId(String t02002) throws Exception;

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt02002 t02002) throws Exception;
	
	public boolean GetInsertCommandBySFZ(Pgt02002 t02002) throws Exception;

	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt02002 t02002) throws Exception;

	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt02002 t02002) throws Exception;

	/**
	 * 按PK取得详细信息 
	 */
	public Pgv02002 LoadDetail(Pgv02002 v02002) throws Exception;
	
	/**
	 * 按PK取得详细信息 
	 */
	public Pgv02002 LoadDetail_B(Pgv02002 v02002) throws Exception;

	/**
	 * 判断房地产档案图是否已经存在
	 * @param 房地产档案图[FDCDAT], 国土编码[FCID]
	 * @return T.存在; F.不存在
	 * @throws Exception
	 */
	public Boolean GetFdcdatByFcid(Pgt02002 t02002) throws Exception;

	/**
	 * 住宅国土信息查询
	 * @category 数据查询
	 */
	public Pgv02002 LoadPgv020025(Pgv02002 v02002) throws Exception;
	
	/**
	 * 住宅国土信息查询
	 * @category 数据查询
	 */
	public Pgv02002 LoadPgv020025_B(Pgv02002 v02002) throws Exception;
	
	public ArrayList<Pgv02002> LoadPgv020025_B1(Pgv02002 v02002) throws Exception;
	
	/**
	 * 进行数据增加操作(WS)
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommandWs(Pgt02002 t02002) throws Exception;
	
	/**
	 * 根据FCZH进行数据提取操作
	 * @param t02002
	 * @return
	 * @throws Exception
	 */
	public Pgv02002 LoadByFczh(Pgt02002 t02002) throws Exception;
	
	/**
	 * 信息导出操作.
	 */
	public OutputStream ExportCXSjcx(Pgv02002 v02002) throws Exception;
	
	/**
	 * 信息导出操作.
	 */
	public OutputStream ExportCXSjcx_B(Pgv02002 v02002) throws Exception;
	
	/**
	 * 插入webservice数据
	 * @param xmlList
	 * @throws Exception
	 */
	public boolean GetInsertCommandXML(ArrayList<Pgt02052xml> xmlList) throws Exception;
	/**
	 * 更新wevservice数据
	 * @param pgt02052xml
	 * @throws Exception
	 */
	public boolean GetUpdateCommandXML(Pgt02052xml pgt02052xml)throws Exception;
	/**
	 * 查询webservice数据
	 * @param pgt02052xml
	 * @throws Exception
	 */
	public Pgt02052xml LoadByPrimaryKeyXML(Pgt02052xml pgt02052xml) throws Exception;

	/**
	 * 查询webservice数据
	 * @param t02052xml
	 * @return
	 * @throws Exception
	 */
	public Pgt02052xml LoadAllXML(Pgt02052xml t02052xml) throws Exception;
	/**
	 * 删除webservice数据
	 * @param pgt02052xml
	 * @return
	 * @throws Exception
	 */
	public boolean GetDeleteCommandXML(Pgt02052xml pgt02052xml) throws Exception;
	/**
	 * 判断webservice是否存在
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public Integer JCXML(Pgt02052xml bean) throws Exception;
	/**
	 * 更新371信息
	 * @param pgt02052xml
	 * @return
	 * @throws Exception
	 */
	public boolean GetUpdateCommand371(Pgt02052xml pgt02052xml)throws Exception;
	
	/**
	 * 取得发送XMLI数据
	 * @param pgt02052xml
	 * @return
	 * @throws Exception
	 */
	public Pgv02002 GetXMLI(Pgv02002 v02002)throws Exception;
	/**
	 * 传入大集中评估结果xml
	 * @param bf00000
	 * @ return
	 * @ thr0ws Exception
	 */
    public BF00000 GetDJZPsjgXML(BF00000 bf00000)throws Exception;    

    public Boolean execFS(Pgt02002 bean) throws Exception;
    
    /**
     * 将371数据备份至3711
     * @param pgt02052xml
     * @return
     * @throws Exception
     */
    public Boolean GetInsertCommand3711(Pgt02052xml pgt02052xml)throws Exception;
    
    /**
     * 查询确认表
     */
    public Pgt02052xml LoadAll3711(Pgt02052xml t02052xml) throws Exception;
    
    /**
     * 根据PK确认表获取数据
     */
    public Pgt02052xml LoadByPrimaryKey3711(Pgt02052xml t02052xml)throws Exception;
    
    /**
     * 根据PK删除确认表数据
     */
    public boolean GetDeleteCommand3711(Pgt02052xml t02052xml)throws Exception;
    
    /**
     * 根据受理号在过滤表中获取数据 
     * @param v00372
     * @return
     * @throws Exception
     */
    public ArrayList<Pgt02052xml> LoadByFCSLH02072(Pgt02052xml t02052xml)throws Exception;
}
