/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sunway.dao.impl;

import com.sunway.dao.ITj00002DAO;
import com.sunway.office.ExcelUtil;
import com.sunway.vo.TJ00002;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

/**
 *
 * @author Amani
 */
public class Tj00002DAO extends BaseDAO implements ITj00002DAO {

    @Override
    public ArrayList<TJ00002> Load(TJ00002 bean) throws Exception {
    	ArrayList<TJ00002> bResult = new ArrayList<TJ00002>();
        ResultSet rs = null;
        Connection conn = null;
        CallableStatement call = null;

        try {
            conn = super.getConnection();
            call = conn.prepareCall("{call PGSP_BF_00007(?,?,?)}");
            //注冊輸出參數
            call.registerOutParameter(1, OracleTypes.CURSOR);
            //傳入輸入參數
            call.setString(2, bean.getCd00002Pssd());
            call.setString(3, bean.getSsgx());
            call.execute();
            //返回數據集
            rs = (ResultSet) call.getObject(1);
            while (null != rs && rs.next()) {
            	TJ00002 e = new TJ00002();
                e.setCjs(rs.getDouble("Cjs"));
                e.setGs(rs.getDouble("Gs"));
                e.setJyffj(rs.getDouble("Jyffj"));
                e.setJyfj(rs.getDouble("Jyfj"));
                e.setQs(rs.getDouble("Qs"));
                e.setTdzzs(rs.getDouble("Tdzzs"));
                e.setYhs(rs.getDouble("Yhs"));
                e.setYys(rs.getDouble("Yys"));
                e.setSe(rs.getDouble("se"));
                e.setHs(rs.getInt("hs")); 
                e.setJzmj(rs.getDouble("jzmj")); 
                e.setJyjg(rs.getDouble("jyjg"));
                e.setPgjg(rs.getDouble("pgjg"));
                e.setScpgjg(rs.getDouble("scpgjg")); 
                e.setCd00002Pssd(rs.getString("M")); 
                bResult.add(e);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            getFree(rs, call, conn, null);
        }
        return bResult;
    }
    
    /* (non-Javadoc)
	 * @see com.sunway.dao.IBB00008DAO#ExportDataW(com.sunway.vo.BF00008)
	 */
	
	@Override
	public OutputStream ExportData(TJ00002 bean) throws Exception {
		ByteArrayOutputStream result;
		Connection conn = null;
		ResultSet rs = null;
		CallableStatement call = null;
		try{
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BF_00007(?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, bean.getCd00002Pssd());
            call.setString(3, bean.getSsgx());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			//创建替换独自单元格列表
			//ArrayList<HashMap<String, String>> hashList = new ArrayList<HashMap<String, String>>();
			/*HashMap<String, String> hm = new HashMap<String, String>();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			hm.put("cxsj", sdf.format(bean.getJysjMin()) + "    至    " + sdf.format(bean.getJysjMax()));
			hashList.add(hm);*/
			result = ExcelUtil.expExcel(rs, bean.getExpFileName(), null);
			
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			getFree(rs, call, conn, null);
		}
		return result;
	}
	
	@Override
    public ArrayList<TJ00002> Load02(TJ00002 bean) throws Exception {
    	ArrayList<TJ00002> bResult = new ArrayList<TJ00002>();
        ResultSet rs = null;
        Connection conn = null;
        CallableStatement call = null;

        try {
            conn = super.getConnection();
            call = conn.prepareCall("{call PGSP_BF_02007(?,?,?)}");
            //注冊輸出參數
            call.registerOutParameter(1, OracleTypes.CURSOR);
            //傳入輸入參數
            call.setString(2, bean.getCd00002Pssd());
            call.setString(3, bean.getSsgx());
            call.execute();
            //返回數據集
            rs = (ResultSet) call.getObject(1);
            while (null != rs && rs.next()) {
            	TJ00002 e = new TJ00002();
                e.setCjs(rs.getDouble("Cjs"));
                e.setGs(rs.getDouble("Gs"));
                e.setJyffj(rs.getDouble("Jyffj"));
                e.setJyfj(rs.getDouble("Jyfj"));
                e.setQs(rs.getDouble("Qs"));
                e.setTdzzs(rs.getDouble("Tdzzs"));
                e.setYhs(rs.getDouble("Yhs"));
                e.setYys(rs.getDouble("Yys"));
                e.setSe(rs.getDouble("se"));
                e.setHs(rs.getInt("hs")); 
                e.setJzmj(rs.getDouble("jzmj")); 
                e.setJyjg(rs.getDouble("jyjg"));
                e.setPgjg(rs.getDouble("pgjg"));
                e.setScpgjg(rs.getDouble("scpgjg")); 
                e.setCd00002Pssd(rs.getString("M")); 
                bResult.add(e);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            getFree(rs, call, conn, null);
        }
        return bResult;
    }
    
    /* (non-Javadoc)
	 * @see com.sunway.dao.IBB00008DAO#ExportDataW(com.sunway.vo.BF00008)
	 */
	
	@Override
	public OutputStream ExportData02(TJ00002 bean) throws Exception {
		ByteArrayOutputStream result;
		Connection conn = null;
		ResultSet rs = null;
		CallableStatement call = null;
		try{
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BF_02007(?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, bean.getCd00002Pssd());
            call.setString(3, bean.getSsgx());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			//创建替换独自单元格列表
			//ArrayList<HashMap<String, String>> hashList = new ArrayList<HashMap<String, String>>();
			/*HashMap<String, String> hm = new HashMap<String, String>();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			hm.put("cxsj", sdf.format(bean.getJysjMin()) + "    至    " + sdf.format(bean.getJysjMax()));
			hashList.add(hm);*/
			result = ExcelUtil.expExcel(rs, bean.getExpFileName(), null);
			
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			getFree(rs, call, conn, null);
		}
		return result;
	}

}
