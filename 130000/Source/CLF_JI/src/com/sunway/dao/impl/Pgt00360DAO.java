/**
 * 
 */
package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sunway.dao.IPgt00360DAO;
import com.sunway.vo.Pgt00360;

/**
 * @author Andy
 *
 */
public class Pgt00360DAO extends BaseDAO implements IPgt00360DAO {

	private static final String id = "ID";							//流水号
	//private static final String cd00002Pssd = "CD_00002_PSSD";		//评税时点
	private static final String cd00001Szqy = "CD_00001_SZQY";		//所在区域
	private static final String cd00001Fwlx = "CD_00001_FWLX";		//所在区域	
	private static final String jzmjMin = "JZMJ_MIN";				//面积下限
	private static final String jzmjMax = "JZMJ_MAX";				//面积上限
	private static final String xzxs = "XZXS" ;						//建筑面积修正
	private static final String upddate = "UPDDATE";				//更改时间
	private static final String cd00002Czr = "CD_00002_CZR";		//操作人字段
	private static final String note = "NOTE";						//备注信息
	private static final String szqy = "SZQY";
	private static final String fwlx = "FWLX";
	private static final String czr = "CZR";
	private static final String rid = "RID";						//行号
	private static final String total = "TOTAL";					//总纪录数
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00360DAO#GetDeleteCommand(com.sunway.vo.Pgt00360)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt00360 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;	
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT00360(?)}");
			//傳入輸入參數
			call.setString(1, bean.getId());
			call.execute();
			tran.commit();
			bResult = true;
		} catch (Exception e) {
			tran.rollback();
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return bResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00360DAO#GetInsertCommand(com.sunway.vo.Pgt00360)
	 */
	
	@Override
	public boolean GetInsertCommand(Pgt00360 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT00360(?,?,?,?,?,?,?,?)}");
			//傳入輸入參數
			call.setString(1, bean.getCd00002Pssd());
			call.setString(2, bean.getCd00001Szqy());
			call.setString(3, bean.getCd00001Fwlx());
			call.setBigDecimal(4, bean.getJzmjMin());
			call.setBigDecimal(5, bean.getJzmjMax());
			call.setBigDecimal(6, bean.getXzxs());
			call.setString(7, bean.getCd00002Czr());
			call.setString(8, bean.getNote());
			call.execute();
			tran.commit();
			bResult = true;
		} catch (Exception e) {
			tran.rollback();
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return bResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00360DAO#GetUpdateCommand(com.sunway.vo.Pgt00360)
	 */
	
	@Override
	public boolean GetUpdateCommand(Pgt00360 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT00360(?,?,?,?,?,?,?,?,?)}");
			//傳入輸入參數
			call.setString(1, bean.getId());
			call.setString(2, bean.getCd00002Pssd());
			call.setString(3, bean.getCd00001Szqy());
			call.setString(4, bean.getCd00001Fwlx());
			call.setBigDecimal(5, bean.getJzmjMin());
			call.setBigDecimal(6, bean.getJzmjMax());
			call.setBigDecimal(7, bean.getXzxs());
			call.setString(8, bean.getCd00002Czr());
			call.setString(9, bean.getNote());
			call.execute();
			tran.commit();
			bResult = true;
		} catch (Exception e) {
			tran.rollback();
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return bResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00360DAO#LoadAll(com.sunway.vo.Pgt00360)
	 */
	
	@Override
	public ArrayList<Pgt00360> LoadAll(Pgt00360 bean) throws Exception {
		ArrayList<Pgt00360> listResult = new ArrayList<Pgt00360>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00360(?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, bean.getPageIndex());
			call.setInt(3, bean.getPageSize());
			call.setString(4, bean.getCd00002Pssd());
			call.setString(5, bean.getCd00001Szqy());
			call.setString(6, bean.getCd00001Fwlx());
			call.setString(7, bean.getCd00001Ssgx());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetParameters(rs, true));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00360DAO#LoadByPrimaryKey(com.sunway.vo.Pgt00360)
	 */
	
	@Override
	public Pgt00360 LoadByPrimaryKey(Pgt00360 bean) throws Exception {
		Pgt00360 listResult = new Pgt00360();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00360(?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, bean.getId());
			call.execute();
			//返回数据集
			rs = (ResultSet)call.getObject(1);
			while (null!=rs && rs.next()) {
				listResult = SetParameters(rs, false);
				break;
			}
		} catch (Exception e) {
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		return listResult;
	}

	/**
	 * Table 数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt00360 SetParameters(ResultSet rs, Boolean flag) throws Exception {
		Pgt00360 e = new Pgt00360();
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setCd00002Czr(rs.getString(cd00002Czr));
//		e.setCd00002Pssd(rs.getString(cd00002Pssd));
		e.setId(rs.getString(id));
		e.setJzmjMax(rs.getBigDecimal(jzmjMax));
		e.setJzmjMin(rs.getBigDecimal(jzmjMin));
		e.setNote(rs.getString(note));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setXzxs(rs.getBigDecimal(xzxs));
		e.setFwlx(rs.getString(fwlx));
		if(flag){
			e.setRecordIndex(rs.getInt(rid));
			e.setRecordCount(rs.getInt(total));
			e.setCzr(rs.getString(czr));
			e.setSzqy(rs.getString(szqy));
		}
		return e;
	}
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#ExecuteParamCopy(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean ExecuteParamCopy(Pgt00360 mj) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {	
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_00360(?,?,?,?,?)}");
			call.setString(1, mj.getSpssd());
			call.setString(2, mj.getTpssd());
			call.setString(3, mj.getCd00001Szqy());
			call.setString(4, mj.getCd00002Czr());
			call.setString(5, mj.getCd00001Ssgx());
			call.execute();
			tran.commit();
			bResult = true;
		} catch (Exception e) {
			tran.rollback();
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return bResult;
	}

	
	@Override
	public boolean SelDeleteCommand(Pgt00360 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		CallableStatement call = null;
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT003601(?,?,?)}");
			call.setString(1, bean.getId());
			call.setString(2, bean.getCd00002Czr());
			call.setString(3, bean.getCd00001Ssgx());
			call.execute();
			tran.commit();
			bResult = true;
		}catch(Exception e){
			tran.rollback();
			throw e;
		}finally {
			getFree(call,conn,session);
		}
		return bResult;
	}

	
	@Override
	public Pgt00360 GetImportCommand(ArrayList<Pgt00360> list) throws Exception {
		Pgt00360 resultBean = new Pgt00360();
		ArrayList<Pgt00360> errList = new ArrayList<Pgt00360>();
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		CallableStatement call = null;
		ResultSet rs = null;
		Integer sResultCount = 0;
		Integer fResultCount = 0;
		
		try{
			session = getSession();
			conn = super.getConnection();
			tran = session.beginTransaction();
			
			for(int i = 0; i < list.size();i++){
				call = conn.prepareCall("{call PGSP_ADDT003601(?,?,?,?,?,?,?,?)}");
				Pgt00360 b = list.get(i);
				try{
					call.registerOutParameter(1, OracleTypes.CURSOR);
					call.setBigDecimal(2, b.getJzmjMin());
					call.setBigDecimal(3, b.getJzmjMax());
					call.setBigDecimal(4, b.getXzxs());
					call.setString(5, b.getCd00002Czr());
					call.setString(6, b.getFwlx());
					call.setString(7, b.getSsgx());
					call.setString(8, b.getSzqy());
					call.execute();
					rs = (ResultSet) call.getObject(1); 
				    if(null != rs && rs.next()){
				    	if(rs.getInt("flag") == 0){
				    		sResultCount++;
				    		b.setCd00001Fwlx(rs.getString("TFWLX"));
				    		b.setCd00001Szqy(rs.getString("SZQYID"));
				    		errList.add(b);
				    		resultBean.setSelfList(errList);
				    	}
				    }
				}catch(Exception e){
					sResultCount++;
					b.setImpErrorMsg(e.getMessage());
					errList.add(b);
		    		resultBean.setSelfList(errList);
					continue;
				}finally{
					if(null != rs)
						rs.close();
					if(null != call)
						call.close();
				}
			}
			tran.commit();
		}catch(Exception e){
			tran.rollback();
			throw e;
		}finally{
			getFree(rs, call,conn,session);
			if(sResultCount == 0){
				resultBean.setOutFlag(true);//成功
			}else if(sResultCount > 0 && fResultCount == 0){
				resultBean.setOutFlag(false);//失败
			}
		}
		return resultBean;
	}
	
}
