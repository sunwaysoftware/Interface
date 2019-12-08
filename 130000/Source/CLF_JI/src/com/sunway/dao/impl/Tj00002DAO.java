/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sunway.dao.impl;

import com.sunway.dao.ITj00002DAO;
import com.sunway.util.Common;
import com.sunway.vo.TJ00002;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Amani
 */
public class Tj00002DAO extends BaseDAO implements ITj00002DAO {

    @Override
    public TJ00002 Load(TJ00002 bean) throws Exception {
        TJ00002 bResult = new TJ00002();
        ResultSet rs = null;
        Connection conn = null;
        CallableStatement call = null;

        try {
            conn = super.getConnection();
            call = conn.prepareCall("{call PGSP_BF_00007(?,?,?,?)}");
            //注冊輸出參數
            call.registerOutParameter(1, OracleTypes.CURSOR);
            //傳入輸入參數
            call.setDate(2, Common.converDate(bean.getRdsj1()));
            call.setDate(3, Common.converDate(bean.getRdsj2()));
            call.setString(4, bean.getSsgx());
            call.execute();
            //返回數據集
            rs = (ResultSet) call.getObject(1);
            while (null != rs && rs.next()) {
                bResult.setCjs(rs.getDouble("Cjs"));
                bResult.setGs(rs.getDouble("Gs"));
                bResult.setJyffj(rs.getDouble("Jyffj"));
                bResult.setJyfj(rs.getDouble("Jyfj"));
                bResult.setQs(rs.getDouble("Qs"));
                bResult.setTdzzs(rs.getDouble("Tdzzs"));
                bResult.setYhs(rs.getDouble("Yhs"));
                bResult.setYys(rs.getDouble("Yys"));  
            }
        } catch (Exception e) {
            throw e;
        } finally {
            getFree(rs, call, conn, null);
        }
        return bResult;
    }

}
