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

import com.sunway.dao.IPg20001gDAO;
import com.sunway.vo.Pgv02031;

/**
 * 
 * 收益法讀取个案评税數據列表
 * @author Andy.Gao
 *
 */
public class Pg20001gDAO extends BaseDAO implements IPg20001gDAO {

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPg20001gDAO#LoadPgMx(com.sunway.vo.Pgv02031)
	 */
	
	@Override
	public ArrayList<Pgv02031> LoadPgMx(Pgv02031 bean) throws Exception {
		ArrayList<Pgv02031> listResult = new ArrayList<Pgv02031>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;	
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT020313(?,?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, bean.getPageIndex());
			call.setInt(3, bean.getPageSize());
			call.setString(4, bean.getSysPssd());
			call.setString(5, bean.getCd12001Swid());
			call.setString(6, bean.getNsrmc());
			call.setString(7, bean.getCd12004Mxid());
			call.setString(8, bean.getSysSsgx());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetV02031Parameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}

	/**
	 * View數據轉存
	 * @param rs 數據集
	 * @return 數據實體
	 * @throws Exception
	 */
	protected Pgv02031 SetV02031Parameters(ResultSet rs) throws Exception {
		String total = "TOTAL";
		String rid = "RID";
		String cd12004Mxid = "CD_12004_MXID";		//房产明细编码
		String cd00002Pssdy = "CD_00002_PSSDY";		//评税时点
		String pgjg = "PGJG";						//收益法评税结果(元)
		String cd00002Pssd = "CD_00002_PSSD";		//显示用的评税时点（详细时间）
		String mjxz = "MJXZ";						//面积修正
		String cxxz = "CXXZ";						//朝向修正
		String xjbzxz = "XJBZXZ";					//星级修正
		String lcxz = "LCXZ";						//楼层修正
		String ssxz = "SSXZ";						//设施修正
		String zjbz = "ZJBZ";						//租金标准
		String zbhl = "ZBHL";						//资本化率
		String synx = "SYNX";						//收益年限
		String ytjzmj = "YTJZMJ";					//建筑面积
		String szqy = "SZQY";						//所在区域
		String fwyt = "FWYT";						//房屋用途
		String fwcx = "FWCX";						//房屋朝向
		String xjbz = "XJBZ";						//星级标准
		String jzjg = "JZJG";						//建筑结构
		String szcc = "SZCC";						//所在楼层
		String ddid = "DDID";						//地段编码
		String jcnf = "JCNF";						//建成年份
		String upddate = "UPDDATE";					//更改时间
		String czr = "CZR";							//操作人字段
		String note = "NOTE";						//备注信息
		String qtxz = "QTXZ";						//其它修正系统
		String cd12001Swid = "CD_12001_SWID";		//税务登记代码
		String nsrmc = "NSRMC";						//纳税人名称
		String cd00001Ssgx = "CD_00001_SSGX";		//税收管辖
		String sypgczr = "SYPGCZR";
		String gbpgjg = "GBPGJG";
		String gbxzxs = "GBXZXS";
		String gzCount = "GZCOUNT";
		
		Pgv02031 e = new Pgv02031();
		e.setCd00002Pssd(rs.getDate(cd00002Pssd));
		e.setCd00002Pssdy(rs.getString(cd00002Pssdy));
		e.setCd12001Swid(rs.getString(cd12001Swid));
		e.setCd12004Mxid(rs.getString(cd12004Mxid));
		e.setCzr(rs.getString(czr));
		e.setFwyt(rs.getString(fwyt));
		e.setJzjg(rs.getString(jzjg));
		e.setNote(rs.getString(note));
		e.setNsrmc(rs.getString(nsrmc));
		e.setPgjg(rs.getDouble(pgjg));
		e.setSzqy(rs.getString(szqy));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setXjbz(rs.getString(xjbz));
		e.setMjxz(rs.getDouble(mjxz));
		e.setCxxz(rs.getDouble(cxxz));
		e.setXjbzxz(rs.getDouble(xjbzxz));
		e.setLcxz(rs.getDouble(lcxz));
		e.setSsxz(rs.getDouble(ssxz));
		e.setZjbz(rs.getDouble(zjbz));
		e.setZbhl(rs.getDouble(zbhl));
		e.setSynx(rs.getDouble(synx));
		e.setYtjzmj(rs.getDouble(ytjzmj));
		e.setFwcx(rs.getString(fwcx));
		e.setQtxz(rs.getDouble(qtxz));
		e.setSzcc(rs.getString(szcc));
		e.setJcnf(rs.getString(jcnf));
		e.setDdid(rs.getString(ddid));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setRecordCount(rs.getInt(total));
		e.setRecordIndex(rs.getInt(rid));
		e.setPgCzr(rs.getString(sypgczr));
		e.setGbpgjg(rs.getDouble(gbpgjg));
		e.setGbxzxs(rs.getDouble(gbxzxs));
		e.setGzCount(rs.getInt(gzCount));
		return e;
	}
}
